package com.tencent.mobileqq.utils;

import android.content.Context;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQLoadingUtil {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onFail();

        void onLoad(LottieDrawable lottieDrawable);
    }

    public static void a(Context context, final String str, final a aVar) {
        try {
            LottieComposition.Factory.fromAssetFileName(context, str, new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.utils.QQLoadingUtil.1
                @Override // com.airbnb.lottie.OnCompositionLoadedListener
                public void onCompositionLoaded(@Nullable LottieComposition lottieComposition) {
                    if (lottieComposition == null) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQLoadingUtil.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.onFail();
                            }
                        });
                        return;
                    }
                    final LottieDrawable lottieDrawable = new LottieDrawable();
                    lottieDrawable.setComposition(lottieComposition);
                    lottieDrawable.setImagesAssetsFolder(str);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQLoadingUtil.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.onLoad(lottieDrawable);
                        }
                    });
                }
            });
        } catch (Exception unused) {
            aVar.onFail();
        }
    }
}
