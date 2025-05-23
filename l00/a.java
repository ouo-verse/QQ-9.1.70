package l00;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.io.IOException;
import java.io.InputStream;
import l00.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f413561a = "WSLiveAnimation";

    /* compiled from: P */
    /* renamed from: l00.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10695a implements LottieListener<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.InterfaceC10696b f413562a;

        C10695a(b.InterfaceC10696b interfaceC10696b) {
            this.f413562a = interfaceC10696b;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th5) {
            b.InterfaceC10696b interfaceC10696b = this.f413562a;
            if (interfaceC10696b != null) {
                interfaceC10696b.onFailure();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements LottieListener<LottieComposition> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f413563a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f413564b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bitmap f413565c;

        b(LottieAnimationView lottieAnimationView, Bitmap bitmap, Bitmap bitmap2) {
            this.f413563a = lottieAnimationView;
            this.f413564b = bitmap;
            this.f413565c = bitmap2;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(LottieComposition lottieComposition) {
            a.d(lottieComposition, this.f413563a, this.f413564b, this.f413565c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements ImageAssetDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f413566a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f413567b;

        c(Bitmap bitmap, Bitmap bitmap2) {
            this.f413566a = bitmap;
            this.f413567b = bitmap2;
        }

        @Override // com.airbnb.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
            if (TextUtils.equals(lottieImageAsset.getFileName(), "img_1.jpg")) {
                return a.e(this.f413566a, 108, 108);
            }
            return this.f413567b;
        }
    }

    public static Bitmap c(LottieAnimationView lottieAnimationView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 320;
        options.outWidth = 126;
        options.outHeight = 126;
        try {
            InputStream open = lottieAnimationView.getResources().getAssets().open("wsfollow/live/images/img_0.png");
            Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
            try {
                open.close();
            } catch (IOException e16) {
                x.f(f413561a, "[getBitmapFromAsserts] decodeStream IOException");
                e16.printStackTrace();
            }
            lottieAnimationView.updateBitmap("image_0", decodeStream);
            return decodeStream;
        } catch (IOException unused) {
            x.f(f413561a, "[getBitmapFromAsserts] getAssets IOException");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(LottieComposition lottieComposition, LottieAnimationView lottieAnimationView, Bitmap bitmap, Bitmap bitmap2) {
        lottieAnimationView.setComposition(lottieComposition);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setImageAssetsFolder("wsfollow/live/images");
        lottieAnimationView.setImageAssetDelegate(new c(bitmap, bitmap2));
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap e(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static void f(LottieAnimationView lottieAnimationView, Bitmap bitmap, Bitmap bitmap2, b.InterfaceC10696b interfaceC10696b) {
        LottieCompositionFactory.fromAsset(lottieAnimationView.getContext(), "wsfollow/live/data.json").addListener(new b(lottieAnimationView, bitmap2, bitmap)).addFailureListener(new C10695a(interfaceC10696b));
    }
}
