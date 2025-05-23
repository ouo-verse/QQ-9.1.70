package com.tencent.filament.zplan.listener;

import androidx.annotation.Keep;
import com.tencent.filament.zplan.animation.GYZPlanAnimation;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/listener/IAnimationSetListener;", "", "onSetAnimationResult", "", "animations", "Lcom/tencent/filament/zplan/animation/GYZPlanAnimation;", "result", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface IAnimationSetListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a {
        public static void a(@NotNull IAnimationSetListener iAnimationSetListener, @NotNull GYZPlanAnimation animations, int i3, int i16) {
            Intrinsics.checkNotNullParameter(animations, "animations");
        }
    }

    void onSetAnimationResult(@NotNull GYZPlanAnimation animations, int result);

    void onSetAnimationResult(@NotNull GYZPlanAnimation animations, int requestId, int result);
}
