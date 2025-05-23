package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.q;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContactRefreshHeader extends RelativeLayout implements q, com.tencent.mobileqq.activity.contacts.pullrefresh.b, c {
    static IPatchRedirector $redirector_;
    private RotateAnimation C;
    private RotateAnimation D;
    private TextView E;
    private boolean F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    public long N;
    private int P;
    private b Q;

    /* renamed from: d, reason: collision with root package name */
    private int f181700d;

    /* renamed from: e, reason: collision with root package name */
    private Context f181701e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f181702f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f181703h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f181704i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f181705m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactRefreshHeader.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader.b
        public long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ContactRefreshHeader.this.p();
            }
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        long a();
    }

    public ContactRefreshHeader(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void o() {
        RelativeLayout relativeLayout = this.f181702f;
        if (relativeLayout == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        if (this.f181700d == 0) {
            r(layoutParams, 10);
            layoutParams.addRule(12);
        } else {
            r(layoutParams, 12);
            layoutParams.addRule(10);
        }
        this.f181702f.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long p() {
        return getContext().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
    }

    private long q() {
        b bVar = this.Q;
        if (bVar != null) {
            return bVar.a();
        }
        return 0L;
    }

    @TargetApi(17)
    public static void r(RelativeLayout.LayoutParams layoutParams, int i3) {
        layoutParams.removeRule(i3);
    }

    private void t() {
        getContext().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", System.currentTimeMillis()).commit();
    }

    private void u(int i3) {
        if (i3 >= 0) {
            this.f181705m.setTextColor(i3);
        }
    }

    private void v(long j3) {
        if (j3 != 0) {
            this.E.setVisibility(0);
            this.E.setText(String.format("%s%s", this.f181701e.getString(R.string.hqf), en.p(j3, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT)));
            int i3 = this.L;
            if (i3 >= 0) {
                this.E.setTextColor(i3);
                return;
            }
            return;
        }
        this.E.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else if (!this.G) {
            s();
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.widget.p
    public void c(int i3, String str) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
            return;
        }
        this.f181704i.clearAnimation();
        this.f181704i.setVisibility(4);
        this.f181703h.setVisibility(4);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    drawable = null;
                } else {
                    drawable = getResources().getDrawable(R.drawable.glu);
                }
            } else {
                drawable = getResources().getDrawable(R.drawable.refresh_fail);
            }
        } else {
            drawable = getResources().getDrawable(R.drawable.refresh_success);
        }
        if (drawable != null) {
            int textSize = ((int) this.f181705m.getTextSize()) + 2;
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableString spannableString = new SpannableString("[O] " + ((Object) str));
            spannableString.setSpan(new ImageSpan(drawable, 0), 0, 3, 17);
            str = spannableString;
        }
        this.f181705m.setText(str);
        u(this.K);
        this.E.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        this.f181704i.clearAnimation();
        this.f181704i.startAnimation(this.C);
        this.f181705m.setText(R.string.hqj);
        u(this.I);
        v(j3);
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void e(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z16 && !this.G) {
            int i16 = this.P;
            if (i3 > i16) {
                if (this.F) {
                    this.F = false;
                    d(q());
                    return;
                }
                return;
            }
            if (i3 < i16 && !this.F) {
                this.F = true;
                i(q());
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.q
    public Object f(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return iPatchRedirector.redirect((short) 29, (Object) this, i3, obj);
        }
        if (i3 == 8) {
            return Integer.valueOf(indexOfChild((View) obj));
        }
        if (i3 == 11) {
            return this.f181705m.getText().toString();
        }
        if (i3 == 25) {
            return Integer.valueOf(ViewUtils.dpToPx(50.0f));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ImageView imageView = this.f181703h;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.f181703h.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        try {
            this.f181705m.setText(R.string.hqg);
            u(this.J);
        } catch (Exception unused) {
        }
        v(j3);
        this.f181704i.setVisibility(8);
        this.f181704i.clearAnimation();
        this.f181703h.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
            return;
        }
        this.f181703h.setVisibility(4);
        this.f181704i.setVisibility(0);
        this.f181704i.clearAnimation();
        if (this.f181700d == 0) {
            if (this.M == 0) {
                this.f181704i.setImageResource(R.drawable.refresh_arrow_2);
            } else {
                this.f181704i.setImageResource(R.drawable.ci9);
            }
            this.f181705m.setText(R.string.hqh);
        } else {
            if (this.M == 0) {
                this.f181704i.setImageResource(R.drawable.gls);
            } else {
                this.f181704i.setImageResource(R.drawable.ci_);
            }
            this.f181705m.setText(R.string.hqi);
        }
        u(this.H);
        v(j3);
    }

    @Override // com.tencent.mobileqq.widget.q
    public void j(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3, obj);
            return;
        }
        if (i3 == 19) {
            setRefreshHeaderUpdateListener(new a());
            return;
        }
        if (i3 == 20) {
            t();
            return;
        }
        if (i3 == 9) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id.i5j);
            addView((View) obj, layoutParams);
        } else if (i3 == 10) {
            removeView((View) obj);
        } else if (i3 == 4) {
            ((RelativeLayout) findViewById(R.id.i5j)).setVisibility(((Integer) obj).intValue());
        } else if (i3 == 18) {
            setRefresh(((Boolean) obj).booleanValue());
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.N;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.widget.p
    public void l(int i3) {
        Drawable drawable;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        this.f181704i.clearAnimation();
        this.f181704i.setVisibility(4);
        this.f181703h.setVisibility(4);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    drawable = null;
                    string = "";
                } else {
                    drawable = getResources().getDrawable(R.drawable.glu);
                    string = getResources().getString(R.string.hqe);
                }
            } else {
                drawable = getResources().getDrawable(R.drawable.refresh_fail);
                string = getResources().getString(R.string.hqe);
            }
        } else {
            drawable = getResources().getDrawable(R.drawable.refresh_success);
            string = getResources().getString(R.string.hqk);
        }
        if (drawable != null) {
            int textSize = ((int) this.f181705m.getTextSize()) + 2;
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableString spannableString = new SpannableString("[O] " + ((Object) string));
            spannableString.setSpan(new ImageSpan(drawable, 0), 0, 3, 17);
            string = spannableString;
        }
        this.f181705m.setText(string);
        u(this.K);
        this.E.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onFinishInflate();
        this.f181702f = (RelativeLayout) findViewById(R.id.content);
        this.f181703h = (ImageView) findViewById(R.id.i5n);
        this.f181704i = (ImageView) findViewById(R.id.i5l);
        this.f181705m = (TextView) findViewById(R.id.i5m);
        this.E = (TextView) findViewById(R.id.i5q);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactRefreshHeader.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(LoadingUtil.getLoadingDrawable(ContactRefreshHeader.this.getContext(), 2)) { // from class: com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Drawable f181706d;

                        {
                            this.f181706d = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                ContactRefreshHeader.this.f181703h.setImageDrawable(this.f181706d);
                            }
                        }
                    });
                }
            }
        }, 16, null, true);
        if (this.f181700d != 0) {
            o();
        }
        if (this.M != 0) {
            this.f181704i.setImageResource(R.drawable.cia);
        }
        i(0L);
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void onPrepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.b
    public void onRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void onRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else if (!this.G) {
            this.G = true;
            h(0L);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.F = false;
        this.f181705m.setText(R.string.hqh);
        this.f181704i.clearAnimation();
        this.f181704i.setVisibility(0);
        this.f181703h.setVisibility(8);
        this.E.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            setBackgroundColor(i3);
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    @TargetApi(16)
    public void setHeaderBgDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) drawable);
        } else {
            setBackground(drawable);
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            setBackgroundResource(i3);
        }
    }

    public void setPullType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else if (this.f181700d != i3) {
            this.f181700d = i3;
            o();
        }
    }

    public void setRefresh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    public void setRefreshHeaderUpdateListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bVar);
        } else {
            this.Q = bVar;
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setTextColor(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        this.H = i3;
        this.I = i16;
        this.J = i17;
        this.K = i18;
        this.L = i19;
    }

    public ContactRefreshHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ContactRefreshHeader(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181700d = 0;
        this.F = false;
        this.G = false;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = 0;
        this.N = 0L;
        this.f181701e = context;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.C = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.C.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.D = rotateAnimation2;
        rotateAnimation2.setDuration(100L);
        this.D.setFillAfter(true);
        this.P = getResources().getDimensionPixelOffset(R.dimen.auf);
    }
}
