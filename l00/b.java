package l00;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f413568b;

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f413569a;

    /* compiled from: P */
    /* renamed from: l00.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10696b {
        void onFailure();
    }

    b() {
    }

    public static b c() {
        if (f413568b == null) {
            synchronized (b.class) {
                if (f413568b == null) {
                    f413568b = new b();
                }
            }
        }
        return f413568b;
    }

    private void d(LottieAnimationView lottieAnimationView, String str, InterfaceC10696b interfaceC10696b) {
        URL c16 = bb.c(str);
        com.tencent.mobileqq.kandian.base.image.b bVar = new com.tencent.mobileqq.kandian.base.image.b();
        bVar.f239004a = c16;
        ((IImageManager) QRoute.api(IImageManager.class)).loadImage(bVar, new a(lottieAnimationView, interfaceC10696b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(LottieAnimationView lottieAnimationView, Bitmap bitmap, InterfaceC10696b interfaceC10696b) {
        x.i("WSLiveAnimation", "[WSLiveAnimationManager.java]:[startAnimation()]:" + lottieAnimationView);
        if (this.f413569a == null) {
            this.f413569a = l00.a.c(lottieAnimationView);
        }
        x.i("WSLiveAnimation", "[WSLiveAnimationManager.java]:[startAnimation()]sBitmapLiveLogo:" + this.f413569a);
        l00.a.f(lottieAnimationView, this.f413569a, bitmap, interfaceC10696b);
    }

    public void b(LottieAnimationView lottieAnimationView) {
        x.i("WSLiveAnimation", "[WSLiveAnimationManager.java]:[stopAnimation()]" + lottieAnimationView);
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }

    public void f(LottieAnimationView lottieAnimationView, String str, InterfaceC10696b interfaceC10696b) {
        d(lottieAnimationView, str, interfaceC10696b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements k52.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f413570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC10696b f413571b;

        a(LottieAnimationView lottieAnimationView, InterfaceC10696b interfaceC10696b) {
            this.f413570a = lottieAnimationView;
            this.f413571b = interfaceC10696b;
        }

        @Override // k52.a
        public void a(com.tencent.mobileqq.kandian.base.image.b bVar, k52.b bVar2) {
            b.this.e(this.f413570a, bVar2.get(), this.f413571b);
        }

        @Override // k52.a
        public void b(com.tencent.mobileqq.kandian.base.image.b bVar, Throwable th5) {
            InterfaceC10696b interfaceC10696b = this.f413571b;
            if (interfaceC10696b != null) {
                interfaceC10696b.onFailure();
            }
        }

        @Override // k52.a
        public void c(com.tencent.mobileqq.kandian.base.image.b bVar, int i3) {
        }
    }
}
