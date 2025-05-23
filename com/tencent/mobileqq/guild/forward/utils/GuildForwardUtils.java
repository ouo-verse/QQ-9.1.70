package com.tencent.mobileqq.guild.forward.utils;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/utils/GuildForwardUtils;", "", "Landroid/content/Intent;", "intent", "", "a", "c", "", "", "b", "Lkotlin/Lazy;", "()Ljava/util/Set;", "whiteForwardTypeSet", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildForwardUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final GuildForwardUtils f224542a = new GuildForwardUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy whiteForwardTypeSet;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Set<? extends Integer>>() { // from class: com.tencent.mobileqq.guild.forward.utils.GuildForwardUtils$whiteForwardTypeSet$2
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Integer> invoke() {
                Set<? extends Integer> of5;
                of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{27, -1, 1, 21, 48, 9});
                return of5;
            }
        });
        whiteForwardTypeSet = lazy;
    }

    GuildForwardUtils() {
    }

    @JvmStatic
    public static final boolean a(Intent intent) {
        AppRuntime peekAppRuntime;
        IGPSService iGPSService;
        Intrinsics.checkNotNullParameter(intent, "intent");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null || (iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")) == null) {
            return false;
        }
        if (!((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab()) {
            ArrayList<IGProQQMsgListGuild> qQMsgListGuilds = iGPSService.getQQMsgListGuilds();
            if (qQMsgListGuilds == null || qQMsgListGuilds.isEmpty()) {
                return false;
            }
        }
        ArrayList<Long> sortedGuildIdsFromCache = iGPSService.getSortedGuildIdsFromCache();
        if (sortedGuildIdsFromCache != null && sortedGuildIdsFromCache.isEmpty()) {
            iGPSService.refreshGuildList(true);
            Logger.f235387a.d().i("Guild.share.GuildForwardUtils", 1, "checkShowShareGuildEntrance tabIsOpen but sortedGuildList isEmpty");
        }
        if (!intent.getBooleanExtra(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, true)) {
            return false;
        }
        int intExtra = intent.getIntExtra("forward_type", 1001);
        if ((intExtra == 27 && f224542a.c(intent)) || intExtra == 1059) {
            return false;
        }
        int intExtra2 = intent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, 5);
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        if (extras.get("android.intent.extra.STREAM") != null && intExtra2 == 5) {
            return false;
        }
        if (intExtra2 == 6) {
            return true;
        }
        if ((intExtra == 11 && intExtra2 != 5) || f224542a.b().contains(Integer.valueOf(intExtra)) || intExtra == 39 || 154 == intent.getIntExtra(AppConstants.Key.STRUCT_MSG_SERVICE_ID, 1)) {
            return true;
        }
        return intExtra == 1001 && Intrinsics.areEqual("web_share", intent.getStringExtra("pluginName"));
    }

    private final Set<Integer> b() {
        return (Set) whiteForwardTypeSet.getValue();
    }

    private final boolean c(Intent intent) {
        String stringExtra = intent.getStringExtra("forward_ark_app_name");
        if (Intrinsics.areEqual("com.tencent.map", stringExtra)) {
            return true;
        }
        String stringExtra2 = intent.getStringExtra("forward_ark_app_view");
        return ArkMsgUtils.isMultiMsg(stringExtra, stringExtra2) || ArkMsgUtils.isShareRobotArkMsg(stringExtra, stringExtra2);
    }
}
