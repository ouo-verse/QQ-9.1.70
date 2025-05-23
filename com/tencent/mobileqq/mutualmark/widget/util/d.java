package com.tencent.mobileqq.mutualmark.widget.util;

import android.os.Build;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f252460e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f252461f;

    /* renamed from: a, reason: collision with root package name */
    private ImageView f252462a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f252463b;

    /* renamed from: c, reason: collision with root package name */
    private LottieDrawable f252464c;

    /* renamed from: d, reason: collision with root package name */
    private LottieDrawable f252465d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
                return;
            }
            if (lottieDrawable != null && d.this.f252462a != null) {
                if (d.this.f252464c != null && d.this.f252464c.isRunning()) {
                    d.this.f252464c.stop();
                    d.this.f252464c.removeAllAnimatorListeners();
                }
                d.this.f252464c = lottieDrawable;
                d.this.f252464c.setRepeatCount(-1);
                if (d.this.f252464c != null && d.this.f252462a != null) {
                    d.this.f252462a.setImageDrawable(d.this.f252464c);
                }
                d.this.f252464c.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
                return;
            }
            if (lottieDrawable != null && d.this.f252463b != null) {
                if (d.this.f252465d != null && d.this.f252465d.isRunning()) {
                    d.this.f252465d.stop();
                    d.this.f252465d.removeAllAnimatorListeners();
                }
                d.this.f252465d = lottieDrawable;
                d.this.f252465d.setRepeatCount(0);
                if (d.this.f252465d != null && d.this.f252463b != null) {
                    d.this.f252463b.setImageDrawable(d.this.f252465d);
                }
                d.this.f252465d.start();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33692);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f252460e = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252186a;
            f252461f = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252187b;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public d g(ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageView);
        }
        this.f252462a = imageView;
        return this;
    }

    public d h(ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageView);
        }
        this.f252463b = imageView;
        return this;
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            com.tencent.mobileqq.mutualmark.widget.util.b.e().i(str);
        }
    }

    public void j(String str) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26 && (imageView = this.f252462a) != null && imageView.getContext() != null) {
            IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class);
            String str2 = f252460e;
            String str3 = f252461f;
            if (iMutualMarkHelperApi.isCartoonResourceReady(str2, str3)) {
                String cartoonResourcesPath = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getCartoonResourcesPath(str2, str3);
                LottieHelper.c(this.f252462a.getContext(), cartoonResourcesPath + str, "", ScreenUtil.dip2px(this.f252462a.getWidth()), ScreenUtil.dip2px(this.f252462a.getHeight()), new a());
            }
        }
    }

    public void k(String str) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26 && (imageView = this.f252463b) != null && imageView.getContext() != null) {
            IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class);
            String str2 = f252460e;
            String str3 = f252461f;
            if (iMutualMarkHelperApi.isCartoonResourceReady(str2, str3)) {
                String cartoonResourcesPath = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getCartoonResourcesPath(str2, str3);
                LottieHelper.c(this.f252463b.getContext(), cartoonResourcesPath + str, "", ScreenUtil.dip2px(this.f252463b.getWidth()), ScreenUtil.dip2px(this.f252463b.getHeight()), new b());
            }
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        LottieDrawable lottieDrawable = this.f252464c;
        if (lottieDrawable != null) {
            lottieDrawable.clearComposition();
        }
    }
}
