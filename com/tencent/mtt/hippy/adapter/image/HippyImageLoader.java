package com.tencent.mtt.hippy.adapter.image;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter;
import com.tencent.mtt.supportui.adapters.image.IImageRequestListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class HippyImageLoader implements IImageLoaderAdapter<Callback> {
    private final ConcurrentHashMap<Integer, WeakReference<HippyDrawable>> mWeakImageCache = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface Callback extends IImageRequestListener<HippyDrawable> {
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter
    public HippyDrawable getImage(String str, Object obj) {
        WeakReference<HippyDrawable> weakReference;
        boolean z16 = str.startsWith("data:") || str.startsWith("assets://");
        Integer valueOf = Integer.valueOf(str.hashCode());
        if (z16 && (weakReference = this.mWeakImageCache.get(valueOf)) != null) {
            HippyDrawable hippyDrawable = weakReference.get();
            if (hippyDrawable != null) {
                return hippyDrawable;
            }
            this.mWeakImageCache.remove(valueOf);
        }
        HippyDrawable hippyDrawable2 = new HippyDrawable();
        if (!hippyDrawable2.setData(str)) {
            return null;
        }
        if (z16) {
            this.mWeakImageCache.put(valueOf, new WeakReference<>(hippyDrawable2));
        }
        return hippyDrawable2;
    }

    public void getSize(final String str, final Promise promise) {
        fetchImage(str, new Callback() { // from class: com.tencent.mtt.hippy.adapter.image.HippyImageLoader.1
            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            public void onRequestFail(Throwable th5, String str2) {
                promise.reject("fetch image fail " + str2);
            }

            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            public void onRequestStart(HippyDrawable hippyDrawable) {
            }

            @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
            public void onRequestSuccess(HippyDrawable hippyDrawable) {
                if (hippyDrawable != null) {
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushInt("width", hippyDrawable.getWidth());
                    hippyMap.pushInt("height", hippyDrawable.getHeight());
                    promise.resolve(hippyMap);
                    hippyDrawable.onDrawableDetached();
                    return;
                }
                promise.reject("fetch image fail " + str);
            }
        }, null);
    }

    public void destroyIfNeed() {
    }
}
