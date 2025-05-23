package com.tencent.hippy.qq.view.alphavideo;

import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.VideoOptions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAlphaHelper {
    private static HippyAlphaHelper mInstance;

    HippyAlphaHelper() {
    }

    public static HippyAlphaHelper getInstance() {
        if (mInstance == null) {
            synchronized (HippyAlphaHelper.class) {
                if (mInstance == null) {
                    mInstance = new HippyAlphaHelper();
                }
            }
        }
        return mInstance;
    }

    public Drawable getAlphaDrawable(String str, final boolean z16) {
        final VideoOptions videoOptions = new VideoOptions();
        videoOptions.setFilePath(str);
        videoOptions.setNeedThumbnail(true);
        videoOptions.setVideoType(1);
        videoOptions.setLoop(z16);
        return GLDrawableApi.asyncFactory(new Function0<Drawable>() { // from class: com.tencent.hippy.qq.view.alphavideo.HippyAlphaHelper.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public Drawable invoke() {
                return null;
            }
        }, new Function1<IFactoryStub, Drawable>() { // from class: com.tencent.hippy.qq.view.alphavideo.HippyAlphaHelper.2
            @Override // kotlin.jvm.functions.Function1
            public Drawable invoke(IFactoryStub iFactoryStub) {
                iFactoryStub.useCache(z16);
                return iFactoryStub.fromBundle(videoOptions.toBundle());
            }
        });
    }
}
