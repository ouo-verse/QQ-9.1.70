package com.tencent.mobileqq.setting.processor;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/setting/processor/d;", "", "", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface d {
    void onCreate();

    void onDestroy();

    void onPause();

    void onResume();
}
