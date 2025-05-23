package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoPoster;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import yu2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdBaseCountDownView extends LinearLayout {
    protected TextView C;
    protected View D;
    private View.OnClickListener E;
    protected AdInsideVideoPoster F;
    protected InsideVideoSkipAdInfo G;
    private boolean H;
    private int I;
    protected View.OnClickListener J;
    protected boolean K;
    private int L;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f303714d;

    /* renamed from: e, reason: collision with root package name */
    protected View f303715e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f303716f;

    /* renamed from: h, reason: collision with root package name */
    protected View f303717h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f303718i;

    /* renamed from: m, reason: collision with root package name */
    protected View f303719m;

    public QAdBaseCountDownView(Context context) {
        super(context);
        this.K = false;
        this.L = Integer.MAX_VALUE;
        e(context);
    }

    private String a(boolean z16, int i3) {
        String str;
        View view;
        if (TextUtils.isEmpty(this.F.skipAdtitle)) {
            return "";
        }
        if (z16 && i3 > 0 && f()) {
            if (i3 < this.L) {
                this.L = i3;
            }
            str = this.F.skipAdtitle.replace("__second__", String.valueOf(this.L));
            this.f303716f.setOnClickListener(null);
            View view2 = this.f303717h;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            if (z16) {
                str = this.F.skipAdSubtitle;
            } else {
                str = this.F.skipAdtitle;
            }
            this.f303716f.setOnClickListener(this.J);
            if (!this.K && (view = this.f303717h) != null) {
                view.setVisibility(0);
            }
        }
        return str;
    }

    private void b(AdInsideVideoPoster adInsideVideoPoster) {
        int i3;
        h(8);
        TextView textView = this.f303716f;
        if (textView == null) {
            return;
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (!TextUtils.isEmpty(adInsideVideoPoster.skipAdtitle)) {
            int i16 = this.I;
            if (i16 == 4) {
                i3 = -1;
            } else {
                i3 = adInsideVideoPoster.skipAdDuration;
            }
            n(b.W(i16), i3);
            this.f303716f.setVisibility(0);
            return;
        }
        this.f303716f.setVisibility(8);
    }

    private void c() {
        CharSequence fromHtml;
        TextView textView = this.f303716f;
        if (textView != null) {
            if (TextUtils.isEmpty(this.F.skipAdtitle)) {
                fromHtml = "";
            } else {
                fromHtml = Html.fromHtml(this.F.skipAdtitle);
            }
            textView.setText(fromHtml);
            this.f303716f.setSelected(true);
            this.f303716f.setSingleLine();
            this.f303716f.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }
        int i3 = this.I;
        if (i3 != 1) {
            if (i3 != 3) {
                h(8);
                return;
            }
            TextView textView2 = this.f303716f;
            if (textView2 != null) {
                textView2.setOnClickListener(this.J);
            }
            h(8);
            return;
        }
        h(0);
    }

    private void h(int i3) {
        View view = this.f303719m;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    private void i() {
        TextView textView = this.C;
        if (textView != null && this.E != null) {
            textView.setVisibility(0);
            this.C.setOnClickListener(this.E);
        }
    }

    private void q(@Nullable String str) {
        CharSequence fromHtml;
        if (this.K) {
            this.f303716f.setTextColor(getResources().getColor(R.color.f156715b43));
            this.f303716f.setText(getResources().getString(R.string.yjy));
            return;
        }
        TextView textView = this.f303716f;
        if (TextUtils.isEmpty(str)) {
            fromHtml = "";
        } else {
            fromHtml = Html.fromHtml(str);
        }
        textView.setText(fromHtml);
    }

    public void d(boolean z16) {
        View view = this.f303715e;
        if ((view != null && view.isShown()) || z16) {
            this.f303715e.setVisibility(8);
        }
        TextView textView = this.f303714d;
        if ((textView != null && textView.isShown()) || z16) {
            this.f303714d.setVisibility(8);
        }
    }

    protected boolean f() {
        return true;
    }

    public void g() {
        this.L = Integer.MAX_VALUE;
    }

    public void j(int i3) {
        TextView textView = this.f303714d;
        if (textView != null) {
            textView.setText(String.valueOf(i3));
            if (this.f303714d.getVisibility() == 4) {
                this.f303714d.setVisibility(0);
            }
        }
    }

    public void k(AdInsideVideoPoster adInsideVideoPoster, int i3, boolean z16, boolean z17) {
        if (adInsideVideoPoster != null && adInsideVideoPoster != this.F) {
            this.F = adInsideVideoPoster;
            this.H = z16;
            this.I = i3;
            g();
            int i16 = this.I;
            if (i16 != 0 && i16 != 4 && i16 != 6 && i16 != 12 && i16 != 7) {
                c();
            } else {
                b(adInsideVideoPoster);
            }
            if (this.I == 5) {
                setVisibility(8);
            }
        }
    }

    public void m(InsideVideoSkipAdInfo insideVideoSkipAdInfo) {
        this.G = insideVideoSkipAdInfo;
    }

    protected void n(boolean z16, int i3) {
        AdInsideVideoPoster adInsideVideoPoster;
        String str;
        if (this.f303716f != null && (adInsideVideoPoster = this.F) != null && !TextUtils.isEmpty(adInsideVideoPoster.skipAdtitle)) {
            if (this.H) {
                i();
                str = a(z16, i3);
            } else {
                str = this.F.skipAdtitle;
                View view = this.f303717h;
                if (view != null) {
                    view.setVisibility(8);
                }
                this.f303716f.setOnClickListener(this.J);
            }
            q(str);
        }
    }

    public void p(boolean z16, int i3) {
        if (this.F != null && !this.K && this.H) {
            if (i3 < 0) {
                i3 = 0;
            }
            n(z16, i3);
        }
    }

    public void setCanShowSkipCountDown(boolean z16) {
        this.H = z16;
    }

    public void setEnterVipOnClickListener(View.OnClickListener onClickListener) {
        this.E = onClickListener;
        View view = this.D;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSkipTipOnClickListener(View.OnClickListener onClickListener) {
        this.J = onClickListener;
        TextView textView = this.f303716f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        View view = this.f303717h;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setWarnerOnClickListener(View.OnClickListener onClickListener) {
        View view = this.f303719m;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public QAdBaseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = false;
        this.L = Integer.MAX_VALUE;
        e(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Context context) {
    }

    public void o(int i3) {
    }

    public void setMultiTrueViewLeftTipListener(View.OnClickListener onClickListener) {
    }

    public void setonVipTipClickListener(View.OnClickListener onClickListener) {
    }

    public void l(int i3, int i16) {
    }
}
