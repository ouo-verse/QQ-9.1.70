package com.tencent.mobileqq.main.api;

import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/main/api/b;", "", "", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onAccountChanged", "onDrawComplete", "onPostThemeChanged", "onLogout", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@UiThread
/* loaded from: classes15.dex */
public interface b {
    void onAccountChanged();

    void onCreate();

    void onDestroy();

    void onDrawComplete();

    void onLogout();

    void onPause();

    void onPostThemeChanged();

    void onResume();
}
