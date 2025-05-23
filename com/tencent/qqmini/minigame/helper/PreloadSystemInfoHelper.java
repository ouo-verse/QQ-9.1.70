package com.tencent.qqmini.minigame.helper;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqmini/minigame/helper/PreloadSystemInfoHelper;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "", "b", "a", "I", "mNotchHeight", "mBenchmarkLevel", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class PreloadSystemInfoHelper {

    /* renamed from: c, reason: collision with root package name */
    public static final PreloadSystemInfoHelper f346473c = new PreloadSystemInfoHelper();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile int mNotchHeight = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile int mBenchmarkLevel = -1;

    PreloadSystemInfoHelper() {
    }

    @JvmStatic
    public static final int a() {
        if (mBenchmarkLevel == -1) {
            mBenchmarkLevel = DeviceUtil.getDeviceBenchmarkLevel();
        }
        return mBenchmarkLevel;
    }

    @JvmStatic
    public static final int b(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (mNotchHeight == -1) {
            mNotchHeight = ImmersiveUtils.getNotchHeight(activity, activity);
        }
        return mNotchHeight;
    }

    @JvmStatic
    public static final void c(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        final WeakReference weakReference = new WeakReference(activity);
        ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.helper.PreloadSystemInfoHelper$preload$1
            @Override // java.lang.Runnable
            public final void run() {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(activity2, "actRef.get() ?: return@e\u2026teOnComputationThreadPool");
                    PreloadSystemInfoHelper.b(activity2);
                    PreloadSystemInfoHelper.a();
                }
            }
        });
    }
}
