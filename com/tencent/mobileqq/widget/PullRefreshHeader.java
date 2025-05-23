package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;

/* loaded from: classes20.dex */
public class PullRefreshHeader extends RelativeLayout implements q {
    private RotateAnimation C;
    private RotateAnimation D;
    private TextView E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    public long L;

    /* renamed from: d, reason: collision with root package name */
    private int f316014d;

    /* renamed from: e, reason: collision with root package name */
    private Context f316015e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f316016f;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f316017h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f316018i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f316019m;

    public PullRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316014d = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0L;
        this.f316015e = context;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.C = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.C.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.D = rotateAnimation2;
        rotateAnimation2.setDuration(100L);
        this.D.setFillAfter(true);
    }

    private void a() {
        RelativeLayout relativeLayout = this.f316016f;
        if (relativeLayout == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        if (this.f316014d == 0) {
            m(layoutParams, 10);
            layoutParams.addRule(12);
        } else {
            m(layoutParams, 12);
            layoutParams.addRule(10);
        }
        this.f316016f.setLayoutParams(layoutParams);
    }

    @TargetApi(17)
    public static void m(RelativeLayout.LayoutParams layoutParams, int i3) {
        layoutParams.removeRule(i3);
    }

    private void n(int i3) {
        if (i3 != 0) {
            this.f316019m.setTextColor(i3);
        }
    }

    private void o(long j3) {
        TextView textView = this.E;
        if (textView == null) {
            return;
        }
        if (j3 != 0) {
            textView.setVisibility(0);
            this.E.setText(String.format("%s%s", this.f316015e.getString(R.string.hqf), en.p(j3, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT)));
            int i3 = this.J;
            if (i3 >= 0) {
                this.E.setTextColor(i3);
                return;
            }
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.widget.p
    public void c(int i3, String str) {
        Drawable drawable;
        this.f316018i.clearAnimation();
        this.f316018i.setVisibility(4);
        this.f316017h.setVisibility(4);
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
            int textSize = ((int) this.f316019m.getTextSize()) + 2;
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableString spannableString = new SpannableString("[O] " + ((Object) str));
            spannableString.setSpan(new ImageSpan(drawable, 0), 0, 3, 17);
            str = spannableString;
        }
        this.f316019m.setText(str);
        n(this.I);
        TextView textView = this.E;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void d(long j3) {
        this.f316018i.clearAnimation();
        this.f316018i.startAnimation(this.C);
        this.f316019m.setText(R.string.hqj);
        n(this.G);
        o(j3);
    }

    public void e() {
        this.f316016f = (RelativeLayout) findViewById(R.id.content);
        this.f316017h = (ProgressBar) findViewById(R.id.i5n);
        this.f316018i = (ImageView) findViewById(R.id.i5l);
        this.f316019m = (TextView) findViewById(R.id.i5m);
        this.E = (TextView) findViewById(R.id.i5q);
        if (this.f316014d != 0) {
            a();
        }
        if (this.K != 0) {
            this.f316018i.setImageResource(R.drawable.cia);
        }
        i(0L);
    }

    @Override // com.tencent.mobileqq.widget.q
    public Object f(int i3, Object obj) {
        boolean z16;
        if (i3 == 6) {
            ProgressBar progressBar = this.f316017h;
            if (progressBar != null && progressBar.getVisibility() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        if (i3 == 8) {
            return Integer.valueOf(indexOfChild((View) obj));
        }
        if (i3 == 11) {
            return this.f316019m.getText().toString();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void g() {
        ProgressBar progressBar = this.f316017h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
            this.f316017h.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void h(long j3) {
        try {
            this.f316019m.setText(R.string.hqg);
            n(this.H);
        } catch (Exception unused) {
        }
        o(j3);
        this.f316018i.setVisibility(8);
        this.f316018i.clearAnimation();
        this.f316017h.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void i(long j3) {
        this.f316017h.setVisibility(4);
        this.f316018i.setVisibility(0);
        this.f316018i.clearAnimation();
        if (this.f316014d == 0) {
            if (this.K == 0) {
                this.f316018i.setImageResource(R.drawable.refresh_arrow_2);
            } else {
                this.f316018i.setImageResource(R.drawable.ci9);
            }
            this.f316019m.setText(R.string.hqh);
        } else {
            if (this.K == 0) {
                this.f316018i.setImageResource(R.drawable.gls);
            } else {
                this.f316018i.setImageResource(R.drawable.ci_);
            }
            this.f316019m.setText(R.string.hqi);
        }
        n(this.F);
        o(j3);
    }

    @Override // com.tencent.mobileqq.widget.q
    public void j(int i3, Object obj) {
        if (i3 == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.i5j);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.addRule(12);
            relativeLayout.setLayoutParams(layoutParams);
            try {
                relativeLayout.setBackgroundResource(R.drawable.bg_texture_theme_version2);
                return;
            } catch (Exception e16) {
                QLog.d("PullRefreshHeader", 1, "setBackgroundColor failed: " + e16);
                return;
            }
        }
        if (i3 == 5) {
            this.f316019m.setText(((Integer) obj).intValue());
            return;
        }
        if (i3 == 2) {
            View view = (View) obj;
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.lts);
            if (indexOfChild(view) < 0) {
                viewGroup.addView(view);
            }
            viewGroup.setVisibility(0);
            return;
        }
        if (i3 == 9) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, R.id.i5j);
            addView((View) obj, layoutParams2);
            return;
        }
        if (i3 == 10) {
            removeView((View) obj);
            return;
        }
        if (i3 == 4) {
            ((RelativeLayout) findViewById(R.id.i5j)).setVisibility(((Integer) obj).intValue());
            return;
        }
        if (i3 == 12) {
            this.f316019m.setTextColor(((Integer) obj).intValue());
            return;
        }
        if (i3 == 13) {
            TextHook.updateFont(this.f316019m);
            return;
        }
        if (i3 == 14) {
            ((RelativeLayout) findViewById(R.id.i5j)).setBackgroundColor(((Integer) obj).intValue());
            return;
        }
        if (i3 == 16) {
            ((RelativeLayout) findViewById(R.id.i5j)).setBackgroundResource(((Integer) obj).intValue());
        } else if (i3 == 15) {
            ((ProgressBar) findViewById(R.id.i5n)).setIndeterminateDrawable((Drawable) obj);
        } else if (i3 == 17) {
            setArrowColor(((Integer) obj).intValue());
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public long k() {
        return this.L;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void l(int i3) {
        String string;
        this.f316018i.clearAnimation();
        this.f316018i.setVisibility(4);
        this.f316017h.setVisibility(4);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    string = "";
                } else {
                    getResources().getDrawable(R.drawable.glu);
                    string = getResources().getString(R.string.hqe);
                }
            } else {
                getResources().getDrawable(R.drawable.refresh_fail);
                string = getResources().getString(R.string.hqe);
            }
        } else {
            getResources().getDrawable(R.drawable.refresh_success);
            string = getResources().getString(R.string.hqk);
        }
        this.f316019m.setText(string);
        n(this.I);
        TextView textView = this.E;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        e();
    }

    public void setArrowColor(int i3) {
        this.K = i3;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgColor(int i3) {
        setBackgroundColor(i3);
    }

    @Override // com.tencent.mobileqq.widget.p
    @TargetApi(16)
    public void setHeaderBgDrawable(Drawable drawable) {
        setBackground(drawable);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgRes(int i3) {
        setBackgroundResource(i3);
    }

    public void setPullType(int i3) {
        if (this.f316014d != i3) {
            this.f316014d = i3;
            a();
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setTextColor(int i3, int i16, int i17, int i18, int i19) {
        this.F = i3;
        this.G = i16;
        this.H = i17;
        this.I = i18;
        this.J = i19;
    }

    @Override // com.tencent.mobileqq.widget.p
    public View b() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
    }
}
