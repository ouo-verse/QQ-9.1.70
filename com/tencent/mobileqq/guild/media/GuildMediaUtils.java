package com.tencent.mobileqq.guild.media;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J8\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0006\u0010\u0014\u001a\u00020\u0002J\u001e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ+\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bR0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001aj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/GuildMediaUtils;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "guildId", "channelId", "k", "", "permissionMask", "l", "permissionType", "Lkotlin/Function1;", "", "callback", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "appId", "o", DomainData.DOMAIN_NAME, tl.h.F, "p", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "PERMISSION_FILTER_MAP", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildMediaUtils f227771a = new GuildMediaUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> PERMISSION_FILTER_MAP;

    static {
        HashMap<Integer, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(102, 32), TuplesKt.to(103, 8), TuplesKt.to(104, 4), TuplesKt.to(101, 16), TuplesKt.to(100, 1));
        PERMISSION_FILTER_MAP = hashMapOf;
    }

    GuildMediaUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(final String guildId, final String channelId, int permissionType, final Function1<? super Boolean, Unit> callback) {
        final Integer num = PERMISSION_FILTER_MAP.get(Integer.valueOf(permissionType));
        if (num == null) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
            }
        } else {
            AppRuntime m3 = ch.m();
            Intrinsics.checkNotNullExpressionValue(m3, "appRuntime()");
            IRuntimeService runtimeService = m3.getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            ((IGPSService) runtimeService).fetchChannelUserPermission(guildId, channelId, permissionType, new xh2.n() { // from class: com.tencent.mobileqq.guild.media.aa
                @Override // xh2.n
                public final void onResult(int i3, String str, int i16) {
                    GuildMediaUtils.g(Function1.this, guildId, channelId, num, i3, str, i16);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void f(GuildMediaUtils guildMediaUtils, String str, String str2, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            function1 = null;
        }
        guildMediaUtils.e(str, str2, i3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 function1, String guildId, String channelId, Integer num, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        QLog.i("GuildMediaUtils", 1, "fetchLatestChannelPermission: result[" + i3 + "]");
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(f227771a.h(guildId, channelId, num.intValue())));
        }
    }

    @Deprecated(message = "please use suspendFetchChannelUserPermission or getCachedChannelPermission")
    @JvmStatic
    public static final boolean k(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Integer num = PERMISSION_FILTER_MAP.get(102);
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        GuildMediaUtils guildMediaUtils = f227771a;
        boolean l3 = guildMediaUtils.l(guildId, channelId, intValue);
        Logger logger = Logger.f235387a;
        logger.d().d("GuildMediaUtils", 1, "getMediaChannelActivityPermission:  hasChanged[" + l3 + "]");
        if (!l3) {
            boolean h16 = guildMediaUtils.h(guildId, channelId, intValue);
            logger.d().d("GuildMediaUtils", 1, "[getMediaChannelActivityPermission] cachePermission " + h16);
            return h16;
        }
        f(guildMediaUtils, guildId, channelId, 102, null, 8, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(String guildId, String channelId, int permissionMask) {
        AppRuntime m3 = ch.m();
        Intrinsics.checkNotNullExpressionValue(m3, "appRuntime()");
        IRuntimeService runtimeService = m3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        int permissionChangeFilter = ((IGPSService) runtimeService).getPermissionChangeFilter(guildId, channelId);
        if ((permissionChangeFilter & 1) <= 0 && (permissionChangeFilter & permissionMask) <= 0) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean m() {
        if (com.tencent.mobileqq.guild.media.core.j.c().W() > 30 && f227771a.n()) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void o(@NotNull Activity activity, @NotNull String appId, @NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        String str = null;
        if (TextUtils.isEmpty(appId)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("openThirdAppProfileDialog: app id is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, (String) it.next(), null);
            }
            return;
        }
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        Bundle bundle = new Bundle();
        bundle.putFloat("guildMiniAppHeightByDP", 500.0f);
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (channelInfo != null) {
            str = channelInfo.getChannelName();
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "MediaChannel.getCore().g\u2026Info()?.channelName ?: \"\"");
        }
        bundle.putString("channel_name", str);
        bundle.putInt("user_type", z.h(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()));
        bundle.putInt("start_permission", k(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()) ? 1 : 0);
        Fragment b16 = GuildOpenContainerLauncher.f229226a.b(new GuildOpenContainerLauncher.StartParams(appId, "10000-pages-together/game-detail/index.html", guildID, E, null, 0L, null, bundle, 112, null), GuildOpenContainerLauncher.ContainerType.MINI_APP);
        ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().add(b16, b16.getClass().getCanonicalName()).commitAllowingStateLoss();
    }

    public final boolean h(@NotNull String guildId, @NotNull String channelId, int permissionMask) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        AppRuntime m3 = ch.m();
        Intrinsics.checkNotNullExpressionValue(m3, "appRuntime()");
        IRuntimeService runtimeService = m3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ssConstant.MAIN\n        )");
        int channelUserPermission = ((IGPSService) runtimeService).getChannelUserPermission(guildId, channelId);
        Logger.f235387a.d().d("GuildMediaUtils", 1, "getCurrentCachedActivityPermission: permission[" + channelUserPermission + "]");
        if ((channelUserPermission & permissionMask) > 0 || (channelUserPermission & 1) > 0) {
            return true;
        }
        return false;
    }

    public final int i() {
        return com.tencent.mobileqq.util.x.f(BaseApplication.getContext()).a();
    }

    public final int j() {
        int b16 = com.tencent.mobileqq.util.x.f(BaseApplication.getContext()).b();
        if (AppSetting.t(BaseApplication.getContext()) && com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
            return (int) (b16 * com.tencent.mobileqq.pad.e.g());
        }
        return b16;
    }

    public final boolean n() {
        return QCircleDeviceInfoUtils.isLowDevice();
    }

    @Nullable
    public final Object p(@NotNull String str, @NotNull String str2, int i3, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Integer num = (Integer) PERMISSION_FILTER_MAP.get(Boxing.boxInt(i3));
        if (num == null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
        } else {
            GuildMediaUtils guildMediaUtils = f227771a;
            boolean l3 = guildMediaUtils.l(str, str2, num.intValue());
            Logger logger = Logger.f235387a;
            logger.d().d("GuildMediaUtils", 1, "[suspendFetchChannelPermission]: permissionType[" + i3 + "], permissionMask[" + num + "], hasChanged[" + l3 + "]");
            if (l3) {
                guildMediaUtils.e(str, str2, i3, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaUtils$suspendFetchChannelPermission$2$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        Logger.f235387a.d().d("GuildMediaUtils", 1, "[suspendFetchChannelPermission] fetchLatestChannelPermission " + z16);
                        if (cancellableContinuationImpl.isActive()) {
                            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
                        }
                    }
                });
            } else {
                boolean h16 = guildMediaUtils.h(str, str2, num.intValue());
                logger.d().d("GuildMediaUtils", 1, "[suspendFetchChannelPermission] cachePermission " + h16);
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(h16)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
