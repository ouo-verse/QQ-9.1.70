package com.tencent.biz.pubaccount.weishi.verticalvideo.gdt;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GdtAdWSCountDownLayout extends RelativeLayout {
    private TextView C;
    private TextView D;
    private TextView E;
    private Handler F;
    private int G;
    private int H;
    private int I;
    private final Runnable J;

    /* renamed from: d, reason: collision with root package name */
    private boolean f82042d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f82043e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f82044f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f82045h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f82046i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f82047m;

    public GdtAdWSCountDownLayout(Context context) {
        this(context, null);
    }

    private boolean g(int i3) {
        if (i3 > 0 && i3 < 8640000) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LifecycleOwner j(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    private void k() {
        o(this.H);
        m(this.I);
    }

    private void m(int i3) {
        this.f82043e.setTextColor(i3);
    }

    private void o(int i3) {
        this.f82044f.setTextColor(i3);
        this.C.setTextColor(i3);
        this.f82045h.setTextColor(i3);
        this.D.setTextColor(i3);
        this.f82046i.setTextColor(i3);
        this.E.setTextColor(i3);
        this.f82047m.setTextColor(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.F.removeCallbacks(this.J);
        if (this.G < 0) {
            this.f82042d = false;
        } else {
            this.f82042d = true;
            this.F.postDelayed(this.J, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.G < 0) {
            setVisibility(8);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((LinearLayout) findViewById(R.id.vma)).getLayoutParams();
        if (this.G < 86400) {
            layoutParams.width = h(99.0f);
            this.f82044f.setVisibility(8);
            this.C.setVisibility(8);
        } else {
            layoutParams.width = h(128.5f);
            this.f82044f.setVisibility(0);
            this.C.setVisibility(0);
        }
    }

    public int h(float f16) {
        return (int) ((f16 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void l() {
        this.F.removeCallbacks(this.J);
        QLog.i("GdtAdWSCountDownLayout", 4, "countdown layout is recycled");
    }

    public boolean n(int i3) {
        if (!g(i3)) {
            return false;
        }
        this.G = i3;
        p();
        q();
        r();
        return true;
    }

    public void q() {
        int i3 = this.G;
        this.f82044f.setText(i(i3 / 86400));
        this.f82045h.setText(i((i3 / 3600) % 24));
        this.f82046i.setText(i((i3 / 60) % 60));
        this.f82047m.setText(i(i3 % 60));
    }

    public void setTextViewTextSize(int i3, int i16) {
        float f16 = i16;
        this.f82044f.setTextSize(i3, f16);
        this.C.setTextSize(i3, f16);
        this.f82045h.setTextSize(i3, f16);
        this.D.setTextSize(i3, f16);
        this.f82046i.setTextSize(i3, f16);
        this.E.setTextSize(i3, f16);
        this.f82047m.setTextSize(i3, f16);
        this.f82043e.setTextSize(i3, f16);
    }

    public GdtAdWSCountDownLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82042d = false;
        this.F = new Handler(Looper.getMainLooper());
        this.J = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.GdtAdWSCountDownLayout.2
            @Override // java.lang.Runnable
            public void run() {
                GdtAdWSCountDownLayout gdtAdWSCountDownLayout = GdtAdWSCountDownLayout.this;
                gdtAdWSCountDownLayout.G--;
                GdtAdWSCountDownLayout.this.q();
                GdtAdWSCountDownLayout.this.r();
                GdtAdWSCountDownLayout.this.p();
                QLog.i("GdtAdWSCountDownLayout", 4, "countdown is running");
            }
        };
        LayoutInflater.from(context).inflate(R.layout.ecf, this);
        this.I = Color.parseColor("#CCFFFFFF");
        this.H = Color.parseColor("#FFFFFF");
        this.f82043e = (TextView) findViewById(R.id.vmd);
        this.f82044f = (TextView) findViewById(R.id.vm7);
        this.C = (TextView) findViewById(R.id.vm8);
        this.f82045h = (TextView) findViewById(R.id.vm9);
        this.D = (TextView) findViewById(R.id.vm_);
        this.f82046i = (TextView) findViewById(R.id.vmb);
        this.E = (TextView) findViewById(R.id.vmc);
        this.f82047m = (TextView) findViewById(R.id.vme);
        k();
        LifecycleOwner j3 = j(context);
        if (j3 != null) {
            j3.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.GdtAdWSCountDownLayout.1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy() {
                    GdtAdWSCountDownLayout.this.F.removeCallbacks(GdtAdWSCountDownLayout.this.J);
                }
            });
        }
    }

    private String i(long j3) {
        if (j3 <= 9) {
            return "0" + Long.toString(j3);
        }
        return Long.toString(j3);
    }
}
