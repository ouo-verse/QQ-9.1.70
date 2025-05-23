package com.tencent.mobileqq.activity.bless;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.AudioUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CountDownView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f180582h;

    /* renamed from: d, reason: collision with root package name */
    private int f180583d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f180584e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f180585f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f180582h = new int[]{R.drawable.c_q, R.drawable.c_p, R.drawable.c_o};
        }
    }

    public CountDownView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f180583d = 0;
        this.f180584e = false;
        this.f180585f = new Runnable() { // from class: com.tencent.mobileqq.activity.bless.CountDownView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CountDownView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (CountDownView.this.f180584e && CountDownView.this.f180583d >= CountDownView.f180582h.length) {
                    CountDownView.this.h();
                    CountDownView.c(CountDownView.this);
                } else if (CountDownView.this.f180583d < CountDownView.f180582h.length) {
                    CountDownView.this.i();
                    CountDownView.this.setImageResource(CountDownView.f180582h[CountDownView.this.f180583d]);
                    CountDownView countDownView = CountDownView.this;
                    countDownView.postDelayed(countDownView.f180585f, 1000L);
                    CountDownView.this.f180583d++;
                }
            }
        };
    }

    static /* bridge */ /* synthetic */ a c(CountDownView countDownView) {
        countDownView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        AudioUtil.s();
        AudioUtil.m(R.raw.f169429a0, 1, null, null);
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        setImageResource(f180582h[0]);
        this.f180584e = false;
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f180585f);
        }
        this.f180583d = 0;
        setVisibility(4);
    }

    public void setListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f180583d = 0;
        this.f180584e = false;
        this.f180585f = new Runnable() { // from class: com.tencent.mobileqq.activity.bless.CountDownView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CountDownView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (CountDownView.this.f180584e && CountDownView.this.f180583d >= CountDownView.f180582h.length) {
                    CountDownView.this.h();
                    CountDownView.c(CountDownView.this);
                } else if (CountDownView.this.f180583d < CountDownView.f180582h.length) {
                    CountDownView.this.i();
                    CountDownView.this.setImageResource(CountDownView.f180582h[CountDownView.this.f180583d]);
                    CountDownView countDownView = CountDownView.this;
                    countDownView.postDelayed(countDownView.f180585f, 1000L);
                    CountDownView.this.f180583d++;
                }
            }
        };
    }

    public CountDownView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f180583d = 0;
        this.f180584e = false;
        this.f180585f = new Runnable() { // from class: com.tencent.mobileqq.activity.bless.CountDownView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CountDownView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (CountDownView.this.f180584e && CountDownView.this.f180583d >= CountDownView.f180582h.length) {
                    CountDownView.this.h();
                    CountDownView.c(CountDownView.this);
                } else if (CountDownView.this.f180583d < CountDownView.f180582h.length) {
                    CountDownView.this.i();
                    CountDownView.this.setImageResource(CountDownView.f180582h[CountDownView.this.f180583d]);
                    CountDownView countDownView = CountDownView.this;
                    countDownView.postDelayed(countDownView.f180585f, 1000L);
                    CountDownView.this.f180583d++;
                }
            }
        };
    }
}
