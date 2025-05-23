package com.tencent.mobileqq.springhb.module;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0004H&J\b\u0010\u0013\u001a\u00020\u0004H&R\u0014\u0010\u0016\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/springhb/module/g;", "", "", "onBackPressed", "", "onCreate", "c", "d", "onResume", "onBeforeAccountChanged", "onAccountChanged", "onPostThemeChanged", "b", "a", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "r0", "e", "()Z", "isShowingTabBanner", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface g {
    void a();

    void b();

    void c();

    void d();

    boolean e();

    void onAccountChanged();

    boolean onBackPressed();

    void onBeforeAccountChanged();

    void onCreate();

    void onDestroy();

    void onLogout(@NotNull Constants.LogoutReason reason);

    void onPause();

    void onPostThemeChanged();

    void onResume();

    void r0();
}
