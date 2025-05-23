package com.tencent.mobileqq.mutualmark.widget.util;

import android.animation.Animator;
import android.content.Context;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final String f252445f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f252446g;

    /* renamed from: h, reason: collision with root package name */
    private static b f252447h;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<ImageView> f252448a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<LottieDrawable> f252449b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<InterfaceC8135b> f252450c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f252451d;

    /* renamed from: e, reason: collision with root package name */
    public long f252452e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f252453a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.mutualmark.widget.util.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class C8134a implements Animator.AnimatorListener {
            static IPatchRedirector $redirector_;

            C8134a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                if (b.this.f252450c == null) {
                    b.this.f252450c = new WeakReference(null);
                    return;
                }
                InterfaceC8135b interfaceC8135b = (InterfaceC8135b) b.this.f252450c.get();
                if (interfaceC8135b != null) {
                    interfaceC8135b.onAnimationEnd();
                    b.this.f252450c = new WeakReference(null);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                }
            }
        }

        a(ImageView imageView) {
            this.f252453a = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) imageView);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
                return;
            }
            if (lottieDrawable != null) {
                b.this.j();
                b.this.f252449b = new WeakReference(lottieDrawable);
                this.f252453a.setImageDrawable(lottieDrawable);
                lottieDrawable.addAnimatorListener(new C8134a());
                lottieDrawable.start();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mutualmark.widget.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8135b {
        void onAnimationEnd();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33656);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f252445f = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252186a;
            f252446g = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252187b;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252448a = new WeakReference<>(null);
        this.f252449b = new WeakReference<>(new LottieDrawable());
        this.f252450c = new WeakReference<>(null);
        this.f252451d = false;
        this.f252452e = -1L;
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            if (f252447h == null) {
                f252447h = new b();
            }
            bVar = f252447h;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        LottieDrawable lottieDrawable;
        WeakReference<LottieDrawable> weakReference = this.f252449b;
        if (weakReference != null && (lottieDrawable = weakReference.get()) != null && lottieDrawable.isRunning()) {
            lottieDrawable.stop();
            lottieDrawable.removeAllAnimatorListeners();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f252448a = new WeakReference<>(null);
        this.f252449b = new WeakReference<>(null);
        this.f252450c = new WeakReference<>(null);
    }

    public void g(ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageView);
        } else {
            this.f252448a = new WeakReference<>(imageView);
        }
    }

    public void h(InterfaceC8135b interfaceC8135b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) interfaceC8135b);
        } else {
            this.f252450c = new WeakReference<>(interfaceC8135b);
        }
    }

    public void i(String str) {
        ImageView imageView;
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        WeakReference<ImageView> weakReference = this.f252448a;
        if (weakReference == null || (imageView = weakReference.get()) == null || (context = imageView.getContext()) == null) {
            return;
        }
        IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class);
        String str2 = f252445f;
        String str3 = f252446g;
        if (iMutualMarkHelperApi.isCartoonResourceReady(str2, str3)) {
            LottieHelper.c(context, ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getCartoonResourcesPath(str2, str3) + str, "", ScreenUtil.dip2px(imageView.getWidth()), ScreenUtil.dip2px(imageView.getHeight()), new a(imageView));
        }
    }
}
