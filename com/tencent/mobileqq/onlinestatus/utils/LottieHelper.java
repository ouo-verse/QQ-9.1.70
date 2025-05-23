package com.tencent.mobileqq.onlinestatus.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;
import android.view.View;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LottieHelper {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements OnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f256294a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f256295b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f256296c;

        a(String str, String str2, d dVar) {
            this.f256294a = str;
            this.f256295b = str2;
            this.f256296c = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Bitmap d(String str, LottieImageAsset lottieImageAsset) {
            try {
                String str2 = str + lottieImageAsset.getFileName();
                boolean exists = new File(str2).exists();
                if (!exists) {
                    if (QLog.isColorLevel()) {
                        QLog.d("onlinestate.LottieHelper", 2, "fetchBitmap exists:" + exists + " imagePath:" + str2);
                    }
                    return null;
                }
                return LottieHelper.a(str2);
            } catch (Throwable th5) {
                QLog.i("onlinestate.LottieHelper", 2, "fetchBitmap error ", th5);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(d dVar, LottieDrawable lottieDrawable) {
            if (dVar != null) {
                dVar.onLoad(lottieDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(LottieComposition lottieComposition, String str, final String str2, final d dVar) {
            final LottieDrawable lottieDrawable = new LottieDrawable();
            long currentTimeMillis = System.currentTimeMillis();
            lottieDrawable.setComposition(lottieComposition);
            QLog.d("onlinestate.LottieHelper", 1, "setComposition cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms path: " + str);
            lottieDrawable.setRepeatCount(0);
            lottieDrawable.setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.onlinestatus.utils.l
                @Override // com.airbnb.lottie.ImageAssetDelegate
                public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                    Bitmap d16;
                    d16 = LottieHelper.a.d(str2, lottieImageAsset);
                    return d16;
                }
            });
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.utils.m
                @Override // java.lang.Runnable
                public final void run() {
                    LottieHelper.a.e(LottieHelper.d.this, lottieDrawable);
                }
            });
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(final LottieComposition lottieComposition) {
            if (lottieComposition == null) {
                QLog.w("onlinestate.LottieHelper", 1, "onCompositionLoaded, fail");
                return;
            }
            QLog.d("onlinestate.LottieHelper", 1, "loadLottieAnimFromFile onCompositionLoaded " + this.f256294a);
            final String str = this.f256294a;
            final String str2 = this.f256295b;
            final d dVar = this.f256296c;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    LottieHelper.a.f(LottieComposition.this, str, str2, dVar);
                }
            }, 16, null, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements OnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f256297a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f256298b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f256299c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f256300d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f256301e;

        b(String str, int i3, String str2, Context context, d dVar) {
            this.f256297a = str;
            this.f256298b = i3;
            this.f256299c = str2;
            this.f256300d = context;
            this.f256301e = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Bitmap d(Context context, String str, LottieImageAsset lottieImageAsset) {
            InputStream inputStream;
            try {
                inputStream = context.getAssets().open(str + lottieImageAsset.getFileName());
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = false;
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    inputStream.close();
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return decodeStream;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        QLog.i("onlinestate.LottieHelper", 2, "fetchBitmap error ", th);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return null;
                    } catch (Throwable th6) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(d dVar, LottieDrawable lottieDrawable) {
            if (dVar != null) {
                dVar.onLoad(lottieDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(LottieComposition lottieComposition, String str, int i3, final String str2, final Context context, final d dVar) {
            final LottieDrawable lottieDrawable = new LottieDrawable();
            long currentTimeMillis = System.currentTimeMillis();
            lottieDrawable.setComposition(lottieComposition);
            QLog.d("onlinestate.LottieHelper", 1, "setComposition cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms path: " + str);
            lottieDrawable.setRepeatCount(i3);
            if (str2 != null) {
                lottieDrawable.setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.onlinestatus.utils.o
                    @Override // com.airbnb.lottie.ImageAssetDelegate
                    public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                        Bitmap d16;
                        d16 = LottieHelper.b.d(context, str2, lottieImageAsset);
                        return d16;
                    }
                });
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.utils.p
                @Override // java.lang.Runnable
                public final void run() {
                    LottieHelper.b.e(LottieHelper.d.this, lottieDrawable);
                }
            });
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(final LottieComposition lottieComposition) {
            if (lottieComposition == null) {
                QLog.w("onlinestate.LottieHelper", 1, "onCompositionLoaded, fail");
                return;
            }
            final String str = this.f256297a;
            final int i3 = this.f256298b;
            final String str2 = this.f256299c;
            final Context context = this.f256300d;
            final d dVar = this.f256301e;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.utils.n
                @Override // java.lang.Runnable
                public final void run() {
                    LottieHelper.b.f(LottieComposition.this, str, i3, str2, context, dVar);
                }
            }, 16, null, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class c implements LottieListener<LottieComposition>, Cancellable {

        /* renamed from: a, reason: collision with root package name */
        private final OnCompositionLoadedListener f256302a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f256303b = false;

        public c(OnCompositionLoadedListener onCompositionLoadedListener) {
            this.f256302a = onCompositionLoadedListener;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(LottieComposition lottieComposition) {
            if (this.f256303b) {
                return;
            }
            this.f256302a.onCompositionLoaded(lottieComposition);
        }

        @Override // com.airbnb.lottie.Cancellable
        public void cancel() {
            this.f256303b = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void onLoad(LottieDrawable lottieDrawable);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class e implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    LottieHelper.d(view, 1.0f);
                    return false;
                }
                return false;
            }
            LottieHelper.d(view, 0.5f);
            return false;
        }
    }

    public static Bitmap a(String str) {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 != null) {
            return f16;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            imageCacheHelper.i(str, decodeFile, Business.Conversation);
            return decodeFile;
        } catch (Throwable th5) {
            QLog.i("onlinestate.LottieHelper", 1, "getBitmap error " + th5.getMessage());
            return null;
        }
    }

    public static void b(Context context, String str, String str2, int i3, int i16, int i17, final d dVar) {
        try {
            LottieComposition.Factory.fromAssetFileName(context, str, new b(str, i17, str2, context, dVar));
        } catch (Exception e16) {
            QLog.e("onlinestate.LottieHelper", 1, "fromAssetFileName fail", e16);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.utils.LottieHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    d dVar2 = d.this;
                    if (dVar2 != null) {
                        dVar2.onLoad(null);
                    }
                }
            });
        }
    }

    public static void c(Context context, String str, String str2, int i3, int i16, final d dVar) {
        try {
            LottieComposition.Factory.fromInputStream(new FileInputStream(str), new a(str, str2, dVar));
        } catch (Exception e16) {
            QLog.e("onlinestate.LottieHelper", 1, "fromAssetFileName fail", e16);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.utils.LottieHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    d dVar2 = d.this;
                    if (dVar2 != null) {
                        dVar2.onLoad(null);
                    }
                }
            });
        }
    }

    @TargetApi(11)
    public static void d(View view, float f16) {
        view.setAlpha(f16);
    }
}
