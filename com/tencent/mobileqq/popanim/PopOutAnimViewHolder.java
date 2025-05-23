package com.tencent.mobileqq.popanim;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;

/* loaded from: classes16.dex */
public class PopOutAnimViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<RelativeLayout> f259096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f259097a;

        a(LottieAnimationView lottieAnimationView) {
            this.f259097a = lottieAnimationView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PopOutAnimViewHolder.this, (Object) lottieAnimationView);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
            } else {
                this.f259097a.setImageDrawable(lottieDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f259099a;

        b(LottieAnimationView lottieAnimationView) {
            this.f259099a = lottieAnimationView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PopOutAnimViewHolder.this, (Object) lottieAnimationView);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
            } else {
                this.f259099a.setImageDrawable(lottieDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static PopOutAnimViewHolder f259101a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52246);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f259101a = new PopOutAnimViewHolder();
            }
        }
    }

    PopOutAnimViewHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            e();
        }
    }

    private void b(RelativeLayout relativeLayout) {
        View findViewById = relativeLayout.findViewById(R.id.f26360db);
        View findViewById2 = relativeLayout.findViewById(R.id.f26350da);
        int h16 = com.tencent.mobileqq.qui.b.f276860a.h(Foreground.getTopActivity());
        if (h16 != 0) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height += h16;
            findViewById.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = h16;
            findViewById2.setLayoutParams(layoutParams2);
        }
    }

    public static PopOutAnimViewHolder d() {
        return c.f259101a;
    }

    private RelativeLayout e() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.duw, (ViewGroup) null);
        this.f259096a = new WeakReference<>(relativeLayout);
        relativeLayout.setClickable(false);
        relativeLayout.setFocusable(false);
        relativeLayout.setFocusableInTouchMode(false);
        b(relativeLayout);
        com.tencent.mobileqq.popanim.view.a.e(new a((LottieAnimationView) relativeLayout.findViewById(R.id.f88164wb)));
        com.tencent.mobileqq.popanim.view.a.d(new b((LottieAnimationView) relativeLayout.findViewById(R.id.v6d)));
        return relativeLayout;
    }

    @MainThread
    public RelativeLayout c() {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        WeakReference<RelativeLayout> weakReference = this.f259096a;
        if (weakReference != null && (relativeLayout = weakReference.get()) != null) {
            return relativeLayout;
        }
        return e();
    }

    @MainThread
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            g();
            this.f259096a = null;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.popanim.PopOutAnimViewHolder.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PopOutAnimViewHolder.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (PopOutAnimViewHolder.this.f259096a == null) {
                        QLog.i("PopOutAnimViewHolder", 1, "removeContentView but mContentViewRef is null");
                        return;
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) PopOutAnimViewHolder.this.f259096a.get();
                    if (relativeLayout == null) {
                        QLog.i("PopOutAnimViewHolder", 1, "removeContentView but contentView is null");
                    } else if (relativeLayout.getParent() != null) {
                        try {
                            ((ViewGroup) relativeLayout.getParent()).removeView(relativeLayout);
                        } catch (Throwable unused) {
                            QLog.e("PopOutAnimViewHolder", 1, "mContentView.getParent() can not to be ViewGroup");
                        }
                    }
                }
            });
        }
    }
}
