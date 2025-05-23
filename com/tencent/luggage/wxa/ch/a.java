package com.tencent.luggage.wxa.ch;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends RelativeLayout {
    public float C;
    public int D;
    public int E;
    public int F;
    public int G;

    /* renamed from: a, reason: collision with root package name */
    public g.d f123499a;

    /* renamed from: b, reason: collision with root package name */
    public View f123500b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f123501c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f123502d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f123503e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f123504f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f123505g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f123506h;

    /* renamed from: i, reason: collision with root package name */
    public int f123507i;

    /* renamed from: j, reason: collision with root package name */
    public int f123508j;

    /* renamed from: k, reason: collision with root package name */
    public int f123509k;

    /* renamed from: l, reason: collision with root package name */
    public int f123510l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f123511m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ch.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6111a implements Runnable {
        public RunnableC6111a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.r();
        }
    }

    public a(Context context) {
        super(context);
        this.f123499a = null;
        this.f123500b = null;
        this.f123502d = null;
        this.f123503e = null;
        this.f123504f = null;
        this.f123507i = 0;
        this.f123508j = 0;
        this.f123509k = 0;
        this.f123510l = 0;
        this.f123511m = false;
        this.C = 0.0f;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        o();
    }

    public String c(int i3) {
        if (i3 < 10) {
            return "0" + i3;
        }
        return i3 + "";
    }

    public int getBarLen() {
        if (this.f123509k <= 0) {
            this.f123509k = this.f123502d.getWidth();
        }
        return this.f123509k;
    }

    public int getBarPointWidth() {
        if (this.f123510l <= 0) {
            this.f123510l = this.f123503e.getWidth();
        }
        return this.f123510l;
    }

    public int getCurrentTimeByBarPoint() {
        return Math.max(0, (int) (((((((FrameLayout.LayoutParams) this.f123503e.getLayoutParams()).leftMargin - (((FrameLayout.LayoutParams) this.f123502d.getLayoutParams()).leftMargin - this.f123503e.getPaddingLeft())) + (((getBarPointWidth() - this.f123503e.getPaddingLeft()) - this.f123503e.getPaddingRight()) / 2)) * 1.0d) / getBarLen()) * this.f123507i));
    }

    public int getLayoutId() {
        return R.layout.dyu;
    }

    public int getVideoTotalTime() {
        return this.f123507i;
    }

    public int getmPosition() {
        return this.f123508j;
    }

    public abstract void o();

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        p();
        if (i3 != this.D || i16 != this.E || i17 != this.F || i18 != this.G) {
            q();
        }
        this.D = i3;
        this.E = i16;
        this.F = i17;
        this.G = i18;
    }

    public void p() {
        this.f123509k = 0;
    }

    public abstract void q();

    public void r() {
        this.f123506h.setText(c(this.f123507i / 60) + ":" + c(this.f123507i % 60));
        q();
    }

    public void setIplaySeekCallback(g.d dVar) {
        this.f123499a = dVar;
    }

    public void setIsPlay(boolean z16) {
        if (z16) {
            this.f123504f.setImageResource(R.raw.f169389e4);
        } else {
            this.f123504f.setImageResource(R.raw.f169390e5);
        }
    }

    public void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
        this.f123504f.setOnClickListener(onClickListener);
    }

    public void setVideoTotalTime(int i3) {
        this.f123507i = i3;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new RunnableC6111a());
        } else {
            r();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f123499a = null;
        this.f123500b = null;
        this.f123502d = null;
        this.f123503e = null;
        this.f123504f = null;
        this.f123507i = 0;
        this.f123508j = 0;
        this.f123509k = 0;
        this.f123510l = 0;
        this.f123511m = false;
        this.C = 0.0f;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        o();
    }

    public a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f123499a = null;
        this.f123500b = null;
        this.f123502d = null;
        this.f123503e = null;
        this.f123504f = null;
        this.f123507i = 0;
        this.f123508j = 0;
        this.f123509k = 0;
        this.f123510l = 0;
        this.f123511m = false;
        this.C = 0.0f;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        o();
    }
}
