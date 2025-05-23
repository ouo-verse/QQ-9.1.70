package com.tencent.guild.aio.input.at.utils;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.ah;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J6\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0015\u001a\u00020\u0005H\u0007R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/input/at/utils/AtUserHelper;", "", "", "guildId", "channelId", "", tl.h.F, "Lmqq/app/AppRuntime;", "app", "", "robotList", "", "robotFilter", "c", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "e", "list", "i", "Luo0/f;", "g", "b", "Lkotlin/Lazy;", "f", "()Ljava/util/List;", "atUserDataList", "Ljava/lang/String;", "lastGuildId", "d", "Luo0/f;", "mFeedUserPresenter", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class AtUserHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AtUserHelper f111098a = new AtUserHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy atUserDataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastGuildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static uo0.f mFeedUserPresenter;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<List<IGProUserInfo>>() { // from class: com.tencent.guild.aio.input.at.utils.AtUserHelper$atUserDataList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<IGProUserInfo> invoke() {
                return new ArrayList();
            }
        });
        atUserDataList = lazy;
        lastGuildId = "";
    }

    AtUserHelper() {
    }

    @JvmStatic
    public static final void b() {
        f111098a.f().clear();
        mFeedUserPresenter = null;
        lastGuildId = "";
    }

    private final void c(AppRuntime app, String guildId, String channelId, List<String> robotList, boolean robotFilter) {
        if (mFeedUserPresenter == null) {
            mFeedUserPresenter = new uo0.f();
        }
        uo0.f fVar = mFeedUserPresenter;
        Intrinsics.checkNotNull(fVar);
        fVar.c(app, guildId, channelId, robotList, false, robotFilter, 60L, new ah() { // from class: com.tencent.guild.aio.input.at.utils.a
            @Override // vh2.ah
            public final void a(boolean z16, List list) {
                AtUserHelper.d(z16, list);
            }
        });
    }

    @JvmStatic
    @Nullable
    public static final List<IGProUserInfo> e(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (Intrinsics.areEqual(guildId, lastGuildId)) {
            return f111098a.f();
        }
        return null;
    }

    private final List<IGProUserInfo> f() {
        return (List) atUserDataList.getValue();
    }

    @JvmStatic
    @Nullable
    public static final uo0.f g(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (Intrinsics.areEqual(lastGuildId, guildId)) {
            return mFeedUserPresenter;
        }
        return null;
    }

    @JvmStatic
    public static final void h(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        boolean z16 = true;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106217", true);
        if (QLog.isColorLevel()) {
            QLog.i("AtUserHelper", 2, "preLoadAtUserData switch: " + isSwitchOn);
        }
        if (!isSwitchOn) {
            return;
        }
        if (Intrinsics.areEqual(lastGuildId, guildId) && (!f111098a.f().isEmpty())) {
            return;
        }
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService runtimeService = app.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IG\u2026va, ProcessConstant.MAIN)");
        IGProChannelInfo channelInfo = ((IGPSService) runtimeService).getChannelInfo(channelId);
        if (channelInfo == null || channelInfo.getType() != 7) {
            z16 = false;
        }
        if (z16) {
            AtUserHelper atUserHelper = f111098a;
            Intrinsics.checkNotNullExpressionValue(app, "app");
            atUserHelper.c(app, guildId, channelId, RecentAtRobotCache.a(guildId), false);
        }
        lastGuildId = guildId;
    }

    @JvmStatic
    public static final void i(@NotNull String guildId, @NotNull List<? extends IGProUserInfo> list) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(list, "list");
        AtUserHelper atUserHelper = f111098a;
        atUserHelper.f().clear();
        atUserHelper.f().addAll(list);
        lastGuildId = guildId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(boolean z16, List list) {
    }
}
