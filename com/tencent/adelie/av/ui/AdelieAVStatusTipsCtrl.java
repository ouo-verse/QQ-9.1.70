package com.tencent.adelie.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVStatusTipsCtrl {

    /* renamed from: a, reason: collision with root package name */
    private View f61464a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f61465b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f61466c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f61467d;

    /* renamed from: e, reason: collision with root package name */
    private AdelieLoadingTextView f61468e;

    /* renamed from: f, reason: collision with root package name */
    private LottieDrawable f61469f;

    /* renamed from: g, reason: collision with root package name */
    private LottieDrawable f61470g;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Context> f61472i;

    /* renamed from: h, reason: collision with root package name */
    private boolean f61471h = false;

    /* renamed from: j, reason: collision with root package name */
    private int f61473j = -1;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements LottieHelper.d {
        a() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            AdelieAVStatusTipsCtrl.this.f61469f = lottieDrawable;
            AdelieAVStatusTipsCtrl adelieAVStatusTipsCtrl = AdelieAVStatusTipsCtrl.this;
            adelieAVStatusTipsCtrl.m(true, adelieAVStatusTipsCtrl.f61473j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements LottieHelper.d {
        b() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            AdelieAVStatusTipsCtrl.this.f61470g = lottieDrawable;
            AdelieAVStatusTipsCtrl adelieAVStatusTipsCtrl = AdelieAVStatusTipsCtrl.this;
            adelieAVStatusTipsCtrl.m(true, adelieAVStatusTipsCtrl.f61473j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f61478d;

        c(View.OnClickListener onClickListener) {
            this.f61478d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (2 == AdelieAVStatusTipsCtrl.this.f61473j || 3 == AdelieAVStatusTipsCtrl.this.f61473j) {
                this.f61478d.onClick(view);
                tp.b.f437029a.b("em_bas_interrupt");
            }
        }
    }

    private void e(float f16) {
        ((Activity) this.f61472i.get()).getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        int i3 = (int) (r0.heightPixels * f16);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61464a.getLayoutParams();
        layoutParams.bottomMargin = i3;
        this.f61464a.setLayoutParams(layoutParams);
    }

    private void g(Drawable drawable) {
        if (drawable instanceof ApngDrawable) {
            ((ApngDrawable) drawable).pause();
        } else if (drawable instanceof LottieDrawable) {
            ((LottieDrawable) drawable).stop();
        }
    }

    private void j(int i3, int i16) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61465b.getLayoutParams();
        layoutParams.width = this.f61472i.get().getResources().getDimensionPixelSize(i3);
        layoutParams.height = this.f61472i.get().getResources().getDimensionPixelSize(i16);
        this.f61465b.setLayoutParams(layoutParams);
    }

    private void l(boolean z16, int i3) {
        Resources resources = this.f61472i.get().getResources();
        if (z16) {
            this.f61467d.setTextSize(0, resources.getDimension(R.dimen.f12868m));
            this.f61467d.setVisibility(-1 == i3 ? 8 : 0);
            this.f61467d.setTextColor(resources.getColor(R.color.qui_common_text_allwhite_primary));
            if (2 == i3) {
                this.f61468e.stop();
                this.f61468e.setVisibility(8);
                if (!this.f61471h) {
                    this.f61467d.setText("\u601d\u8003\u4e2d");
                    return;
                } else {
                    this.f61467d.setText("\u601d\u8003\u4e2d(\u70b9\u51fb\u6253\u65ad)");
                    return;
                }
            }
            if (3 == i3) {
                this.f61468e.stop();
                this.f61468e.setVisibility(8);
                if (!this.f61471h) {
                    this.f61467d.setText("");
                    return;
                } else {
                    this.f61467d.setText("(\u70b9\u51fb\u6253\u65ad)");
                    return;
                }
            }
            if (i3 == 0) {
                this.f61467d.setText("\u4f60\u53ef\u4ee5\u5f00\u59cb\u8bb2\u8bdd\u4e86");
                this.f61468e.setVisibility(0);
                this.f61468e.f();
            } else if (i3 == 1) {
                this.f61467d.setText("\u6b63\u5728\u542c\u4f60\u8bb2\u8bdd");
                this.f61468e.setVisibility(0);
                this.f61468e.f();
            } else if (i3 == 4) {
                this.f61467d.setText("\u5f53\u524d\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38");
                this.f61468e.stop();
                this.f61468e.setVisibility(8);
            }
        }
    }

    private void n(boolean z16, int i3) {
        this.f61464a.setVisibility(i3 == -1 ? 8 : 0);
        this.f61464a.setClickable(this.f61471h);
        if (z16) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61464a.getLayoutParams();
            if (4 == i3) {
                layoutParams.width = -2;
                this.f61464a.setBackgroundResource(R.drawable.k9l);
                e(0.4f);
            } else {
                layoutParams.width = -1;
                this.f61464a.setBackgroundColor(0);
                e(0.18f);
            }
            this.f61464a.setLayoutParams(layoutParams);
        }
    }

    public void f(boolean z16, int i3) {
        this.f61473j = i3;
        n(z16, i3);
        l(z16, i3);
        m(z16, i3);
    }

    public void h() {
        LottieDrawable lottieDrawable = this.f61469f;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
            this.f61469f.removeAllAnimatorListeners();
            this.f61469f.clearComposition();
            this.f61469f = null;
        }
        LottieDrawable lottieDrawable2 = this.f61470g;
        if (lottieDrawable2 != null) {
            lottieDrawable2.stop();
            this.f61470g.removeAllAnimatorListeners();
            this.f61470g.clearComposition();
            this.f61470g = null;
        }
        this.f61467d.setText("");
        this.f61465b.setImageDrawable(null);
        this.f61466c.setImageDrawable(null);
        this.f61464a = null;
        this.f61465b = null;
        this.f61466c = null;
        this.f61467d = null;
        this.f61468e.e();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f61464a.setOnClickListener(new c(onClickListener));
    }

    public void k(boolean z16) {
        this.f61471h = z16;
        this.f61464a.setClickable(z16);
        if (z16) {
            this.f61467d.setVisibility(0);
            int i3 = this.f61473j;
            if (i3 == 2) {
                this.f61467d.setText("\u601d\u8003\u4e2d(\u70b9\u51fb\u6253\u65ad)");
            } else if (i3 == 3) {
                this.f61467d.setText("(\u70b9\u51fb\u6253\u65ad)");
            }
            tp.b.f437029a.d("em_bas_interrupt");
            return;
        }
        this.f61467d.setVisibility(8);
        this.f61465b.setVisibility(8);
        g(this.f61465b.getDrawable());
    }

    public void o(final boolean z16, final int i3) {
        boolean z17 = com.tencent.adelie.av.ui.c.N;
        com.tencent.xaction.log.b.b("AdelieAVStatusTipsCtrl", 1, "updateUI isHeadMode=" + z16 + " chatStatus=" + i3 + " showingAnim=" + z17, new Throwable());
        if (z17) {
            return;
        }
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVStatusTipsCtrl.4
            @Override // java.lang.Runnable
            public void run() {
                AdelieAVStatusTipsCtrl.this.f(z16, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16, int i3) {
        if (z16) {
            g(this.f61465b.getDrawable());
            if (i3 == 2) {
                j(R.dimen.f12988y, R.dimen.f12978x);
                LottieDrawable lottieDrawable = this.f61469f;
                if (lottieDrawable != null) {
                    this.f61465b.setImageDrawable(lottieDrawable);
                    this.f61465b.setVisibility(0);
                    this.f61466c.setVisibility(8);
                    this.f61469f.start();
                    return;
                }
                return;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    this.f61466c.setVisibility(0);
                    this.f61465b.setVisibility(8);
                    return;
                } else {
                    this.f61465b.setVisibility(8);
                    this.f61466c.setVisibility(8);
                    return;
                }
            }
            j(R.dimen.f12968w, R.dimen.f12958v);
            LottieDrawable lottieDrawable2 = this.f61470g;
            if (lottieDrawable2 != null) {
                this.f61465b.setImageDrawable(lottieDrawable2);
                this.f61465b.setVisibility(0);
                this.f61466c.setVisibility(8);
                this.f61470g.start();
            }
        }
    }

    public AdelieAVStatusTipsCtrl(Activity activity) {
        this.f61472i = new WeakReference<>(activity);
        this.f61464a = activity.findViewById(R.id.rbi);
        this.f61465b = (ImageView) activity.findViewById(R.id.rbq);
        this.f61466c = (ImageView) activity.findViewById(R.id.rbt);
        this.f61467d = (TextView) activity.findViewById(R.id.rbp);
        AdelieLoadingTextView adelieLoadingTextView = (AdelieLoadingTextView) activity.findViewById(R.id.rbd);
        this.f61468e = adelieLoadingTextView;
        adelieLoadingTextView.b(300L);
        LottieHelper.b(BaseApplication.getContext(), "thinking-animation.json", null, 40, 40, -1, new a());
        LottieHelper.b(BaseApplication.getContext(), "voice-animation.json", null, 40, 40, -1, new b());
    }
}
