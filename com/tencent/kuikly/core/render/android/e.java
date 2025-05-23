package com.tencent.kuikly.core.render.android;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u0002H&J\b\u0010\u0010\u001a\u00020\u0002H&J\b\u0010\u0011\u001a\u00020\u0002H&J\b\u0010\u0012\u001a\u00020\u0002H&J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/render/android/e;", "", "", "onInit", "l", "j", "f", "k", "i", tl.h.F, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "c", "a", "e", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface e {
    void a();

    void b(@NotNull Throwable throwable, @NotNull ErrorReason errorReason);

    void c();

    void d();

    void e();

    void f();

    void g();

    void h();

    void i();

    void j();

    void k();

    void l();

    void m();

    void onDestroy();

    void onInit();

    void onPause();

    void onResume();
}
