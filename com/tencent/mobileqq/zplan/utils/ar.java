package com.tencent.mobileqq.zplan.utils;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ar;", "", "Landroid/content/Context;", "context", "", "assetPath", "Lcom/airbnb/lottie/LottieDrawable;", "lottieDrawable", "Lcom/tencent/mobileqq/zplan/utils/as;", "listener", "", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ar {

    /* renamed from: a, reason: collision with root package name */
    public static final ar f335790a = new ar();

    ar() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context, final String assetPath, final LottieDrawable lottieDrawable, final as listener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(assetPath, "$assetPath");
        Intrinsics.checkNotNullParameter(lottieDrawable, "$lottieDrawable");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        LottieComposition.Factory.fromAssetFileName(context, assetPath, new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.zplan.utils.ao
            @Override // com.airbnb.lottie.OnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                ar.g(LottieDrawable.this, listener, assetPath, lottieComposition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LottieDrawable lottieDrawable, final as listener, String assetPath, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(lottieDrawable, "$lottieDrawable");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(assetPath, "$assetPath");
        if (lottieComposition == null) {
            QLog.e("[zplan][ZplanLottieAnimUtil]", 1, "load lottie fail!");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.ap
                @Override // java.lang.Runnable
                public final void run() {
                    ar.h(as.this);
                }
            });
        } else {
            lottieDrawable.setComposition(lottieComposition);
            lottieDrawable.setImagesAssetsFolder(assetPath);
            QLog.i("[zplan][ZplanLottieAnimUtil]", 1, "load lottie success!");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.aq
                @Override // java.lang.Runnable
                public final void run() {
                    ar.i(as.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(as listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onFail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(as listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onSuccess();
    }

    public final void e(final Context context, final String assetPath, final LottieDrawable lottieDrawable, final as listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        Intrinsics.checkNotNullParameter(lottieDrawable, "lottieDrawable");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.an
            @Override // java.lang.Runnable
            public final void run() {
                ar.f(context, assetPath, lottieDrawable, listener);
            }
        }, 16, null, true);
    }
}
