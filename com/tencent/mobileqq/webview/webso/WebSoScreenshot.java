package com.tencent.mobileqq.webview.webso;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IGifAntishakeApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebSoScreenshot {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f314928a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f314929b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314928a = "";
            f314929b = Boolean.valueOf(ar.b("kenaiyu", "2025-02-13", "vas_bug_webso_screenshot").isEnable(false));
        }
    }

    public static void a(View view, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            String dhash = ((IGifAntishakeApi) QRoute.api(IGifAntishakeApi.class)).getDhash(createBitmap);
            e.h("catch = " + dhash + " cache = " + f314928a + " diff = " + ((IGifAntishakeApi) QRoute.api(IGifAntishakeApi.class)).getDistance(dhash, f314928a));
            if (!dhash.equals("0000000000000000")) {
                f314928a = dhash;
                FileOutputStream fileOutputStream2 = new FileOutputStream(e.r(str));
                try {
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream2);
                    fileOutputStream2.close();
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    try {
                        QLog.e("WebSoScreenshot", 1, th.getMessage());
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th6;
                    }
                }
            }
            createBitmap.recycle();
            e.h("catch Screenshot sucess");
            if (fileOutputStream == null) {
                return;
            }
        } catch (Throwable th7) {
            th = th7;
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused2) {
        }
    }

    static Drawable b(String str) {
        Bitmap bitmap;
        Drawable bitmapDrawable;
        String r16 = e.r(str);
        if (!TextUtils.isEmpty(r16) && new File(r16).exists()) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mUseMemoryCache = false;
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 4;
                    bitmap = BitmapFactory.decodeFile(r16, options);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    bitmap = null;
                }
                if (bitmap == null) {
                    bitmapDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                } else {
                    bitmapDrawable = new BitmapDrawable(bitmap);
                }
                obtain.mLoadingDrawable = bitmapDrawable;
                obtain.mFailedDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mUseAutoScaleParams = false;
                return URLDrawable.getDrawable(new File(r16), obtain);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        return null;
    }

    public static void c(CustomWebView customWebView) {
        if (!f314929b.booleanValue()) {
            return;
        }
        customWebView.post(new Runnable() { // from class: com.tencent.mobileqq.webview.webso.WebSoScreenshot.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomWebView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    View findViewById = ((Activity) CustomWebView.this.getContext()).findViewById(R.id.enc);
                    findViewById.animate().alpha(0.0f).setDuration(300L);
                    findViewById.postDelayed(new Runnable(findViewById) { // from class: com.tencent.mobileqq.webview.webso.WebSoScreenshot.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ View f314935d;

                        {
                            this.f314935d = findViewById;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) findViewById);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.f314935d.setVisibility(8);
                            }
                        }
                    }, 300L);
                } catch (Exception e16) {
                    QLog.e("WebSoScreenshot", 1, e16, new Object[0]);
                }
            }
        });
    }

    public static void d(Activity activity, String str) {
        Drawable b16;
        View findViewById;
        if (f314929b.booleanValue() && (b16 = b(str)) != null && (findViewById = activity.findViewById(R.id.enc)) != null) {
            Drawable background = findViewById.getBackground();
            findViewById.setBackgroundDrawable(b16);
            findViewById.setAlpha(1.0f);
            findViewById.setVisibility(0);
            findViewById.postDelayed(new Runnable(findViewById, background) { // from class: com.tencent.mobileqq.webview.webso.WebSoScreenshot.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f314930d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Drawable f314931e;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.webview.webso.WebSoScreenshot$1$a */
                /* loaded from: classes20.dex */
                class a extends f {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ViewPropertyAnimator f314932d;

                    a(ViewPropertyAnimator viewPropertyAnimator) {
                        this.f314932d = viewPropertyAnimator;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) viewPropertyAnimator);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                        }
                    }

                    @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f314930d.setBackgroundDrawable(anonymousClass1.f314931e);
                        AnonymousClass1.this.f314930d.setVisibility(8);
                        this.f314932d.setListener(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                        }
                    }

                    @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                        }
                    }
                }

                {
                    this.f314930d = findViewById;
                    this.f314931e = background;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) findViewById, (Object) background);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ViewPropertyAnimator duration = this.f314930d.animate().alpha(0.0f).setDuration(300L);
                    duration.setListener(new a(duration));
                    duration.start();
                }
            }, 2000L);
        }
    }
}
