package com.tencent.comic.hippy.module;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

/* compiled from: P */
@HippyNativeModule(name = HippyQQComicModule.CLASSNAME)
/* loaded from: classes32.dex */
public class HippyQQComicModule extends HippyNativeModuleBase {
    static final String CLASSNAME = "comic";
    private QQComicModule mComicModule;

    public HippyQQComicModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mComicModule = new QQComicModule();
    }

    @HippyMethod(name = "getChapterList")
    public void getChapterList(String str, Promise promise) {
        this.mComicModule.getChapterList(str, promise);
    }

    @HippyMethod(name = "getPictureList")
    public void getPictureList(String str, String str2, Promise promise) {
        this.mComicModule.getPictureList(str, str2, promise);
    }
}
