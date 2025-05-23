package com.tencent.robot.adelie.homepage.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseBizType;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/AIOUtil;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotInfo", "", "source", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "robotGuideInfo", "", "d", "Landroid/graphics/Bitmap;", "b", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "g", "(Landroid/graphics/Bitmap;)V", "coverBitmap", "", "c", "Lkotlin/Lazy;", "()Z", "mPlayVideoSwitch", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AIOUtil {

    /* renamed from: a */
    @NotNull
    public static final AIOUtil f366629a = new AIOUtil();

    /* renamed from: b, reason: from kotlin metadata */
    @Nullable
    private static Bitmap coverBitmap;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final Lazy mPlayVideoSwitch;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.robot.adelie.homepage.utils.AIOUtil$mPlayVideoSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("babyq_play_video_9095", true));
            }
        });
        mPlayVideoSwitch = lazy;
    }

    AIOUtil() {
    }

    public static /* synthetic */ void e(AIOUtil aIOUtil, Context context, RobotCoreInfo robotCoreInfo, String str, RobotGuideInfo robotGuideInfo, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "27";
        }
        if ((i3 & 8) != 0) {
            robotGuideInfo = null;
        }
        aIOUtil.d(context, robotCoreInfo, str, robotGuideInfo);
    }

    public static final void f(RobotCoreInfo robotInfo, String source, RobotGuideInfo robotGuideInfo, Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(robotInfo, "$robotInfo");
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullParameter(context, "$context");
        boolean z17 = false;
        if (RobotBaseBizType.KADELIE == robotInfo.getBizType()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !TextUtils.isEmpty(robotInfo.uid) && robotInfo.robotUin != 0) {
            IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class);
            String valueOf = String.valueOf(robotInfo.robotUin);
            String str = robotInfo.uid;
            Intrinsics.checkNotNullExpressionValue(str, "robotInfo.uid");
            iUixConvertAdapterApi.saveUidByUin(valueOf, str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_from", source);
        bundle.putBoolean("key_ignore_pre_scale_chat", true);
        bundle.putString("key_day_color", robotInfo.dayColor);
        bundle.putString("key_night_color", robotInfo.nightColor);
        bundle.putString("key_avatar_dominantColor", robotInfo.avatarDominantColor);
        bundle.putString("key_day_bg", robotInfo.bgDay);
        bundle.putString("key_night_bg", robotInfo.bgNight);
        bundle.putString("key_day_dynamic_bg", robotInfo.dayDynamicPic);
        bundle.putString("key_night_dynamic_bg", robotInfo.nightDynamicPic);
        if (robotInfo.aioConfig.supportHalfScreenSwitch != 0) {
            z17 = true;
        }
        bundle.putBoolean("key_support_half_screen", z17);
        bundle.putBoolean("key_support_tts", u64.b.b(robotInfo));
        bundle.putBoolean("key_support_auto_tts", u64.b.a(robotInfo));
        bundle.putBoolean("key_support_wide_sceen", u64.b.c(robotInfo));
        if (f366629a.c() && robotGuideInfo != null) {
            bundle.putBoolean("key_babyQ_need_show_video", true);
            bundle.putString("key_babyQ_video_url", robotGuideInfo.videoUrl);
            bundle.putString("key_babyQ_image_url", robotGuideInfo.fullscreenBg);
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
        String str2 = robotInfo.uid;
        Intrinsics.checkNotNullExpressionValue(str2, "robotInfo.uid");
        String str3 = robotInfo.name;
        Intrinsics.checkNotNullExpressionValue(str3, "robotInfo.name");
        iAIOStarterApi.navigateToAIOActivity(context, 1, str2, str3, robotInfo.robotUin, bundle);
    }

    @Nullable
    public final Bitmap b() {
        return coverBitmap;
    }

    public final boolean c() {
        return ((Boolean) mPlayVideoSwitch.getValue()).booleanValue();
    }

    public final void d(@NotNull final Context context, @NotNull final RobotCoreInfo robotInfo, @NotNull final String source, @Nullable final RobotGuideInfo robotGuideInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(source, "source");
        String str = robotInfo.jumpUrl;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            n nVar = n.f366680a;
            String str2 = robotInfo.jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str2, "robotInfo.jumpUrl");
            nVar.f(context, str2);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOUtil.f(RobotCoreInfo.this, source, robotGuideInfo, context);
            }
        }, 32, null, true);
    }

    public final void g(@Nullable Bitmap bitmap) {
        coverBitmap = bitmap;
    }
}
