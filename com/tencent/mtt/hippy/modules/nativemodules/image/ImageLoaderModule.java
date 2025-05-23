package com.tencent.mtt.hippy.modules.nativemodules.image;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

/* compiled from: P */
@HippyNativeModule(name = "ImageLoaderModule")
/* loaded from: classes20.dex */
public class ImageLoaderModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    final HippyImageLoader f337512a;

    public ImageLoaderModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337512a = hippyEngineContext.getGlobalConfigs().getImageLoaderAdapter();
    }

    @HippyMethod(name = "getSize")
    public void getSize(String str, Promise promise) {
        HippyImageLoader hippyImageLoader = this.f337512a;
        if (hippyImageLoader != null) {
            hippyImageLoader.getSize(str, promise);
        }
    }

    @HippyMethod(name = "prefetch")
    public void prefetch(String str) {
        this.f337512a.fetchImage(str, new HippyImageLoader.Callback() { // from class: com.tencent.mtt.hippy.modules.nativemodules.image.ImageLoaderModule.1
            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onRequestSuccess(HippyDrawable hippyDrawable) {
                hippyDrawable.onDrawableDetached();
            }

            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onRequestStart(HippyDrawable hippyDrawable) {
            }

            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            public void onRequestFail(Throwable th5, String str2) {
            }
        }, null);
    }
}
