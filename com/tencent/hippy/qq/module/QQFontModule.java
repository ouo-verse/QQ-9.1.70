package com.tencent.hippy.qq.module;

import com.tencent.hippy.qq.utils.HippyFontUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;

/* compiled from: P */
@HippyNativeModule(name = QQFontModule.TAG)
/* loaded from: classes7.dex */
public class QQFontModule extends QQBaseModule {
    public static final String TAG = "QQFontModule";

    public QQFontModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "registerFont")
    public void registerFont(String str, Promise promise) {
        HippyArray hippyArray = new HippyArray();
        hippyArray.pushString(str);
        HippyFontUtils.startAsyncDownloadFont(hippyArray, promise);
    }
}
