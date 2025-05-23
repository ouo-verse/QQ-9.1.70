package com.tencent.mobileqq.wink.editor.hdr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes21.dex */
public class HDRStatusView extends LinearLayout implements View.OnClickListener {
    private final Runnable C;

    /* renamed from: d, reason: collision with root package name */
    private HDRProgressView f320436d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f320437e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f320438f;

    /* renamed from: h, reason: collision with root package name */
    private l f320439h;

    /* renamed from: i, reason: collision with root package name */
    private d f320440i;

    /* renamed from: m, reason: collision with root package name */
    private String f320441m;

    public HDRStatusView(Context context) {
        super(context);
        this.f320441m = "";
        this.C = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.hdr.b
            @Override // java.lang.Runnable
            public final void run() {
                HDRStatusView.this.e();
            }
        };
        c(context);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(R.layout.i5h, this);
        this.f320436d = (HDRProgressView) findViewById(R.id.f122857f3);
        this.f320437e = (TextView) findViewById(R.id.f122867f4);
        ImageView imageView = (ImageView) findViewById(R.id.f122827f0);
        this.f320438f = imageView;
        imageView.setOnClickListener(this);
        this.f320440i = new d(context);
        l(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        setVisibility(8);
    }

    private void k() {
        requestLayout();
        invalidate();
    }

    public void b(boolean z16) {
        if (z16) {
            this.f320436d.b(100, true);
            postDelayed(this.C, 100L);
        } else {
            removeCallbacks(this.C);
            setVisibility(8);
        }
        f();
    }

    public void d(boolean z16, boolean z17, boolean z18, long j3) {
        this.f320440i.c(z16, z17, z18, j3);
        l(0.0f);
        m(this.f320440i.getStartText());
    }

    public void g() {
        removeCallbacks(this.C);
        setVisibility(0);
    }

    public void h() {
        this.f320438f.setVisibility(8);
        this.f320437e.setVisibility(8);
        k();
    }

    public void i() {
        this.f320438f.setVisibility(0);
        this.f320437e.setVisibility(0);
        k();
    }

    public void j() {
        if (this.f320438f.getVisibility() == 0) {
            h();
        } else {
            i();
        }
    }

    public void l(float f16) {
        if (this.f320436d != null) {
            Pair<Integer, String> e16 = this.f320440i.e(f16);
            this.f320436d.b(e16.getFirst().intValue(), true);
            m(e16.getSecond());
        }
    }

    public void m(String str) {
        if (this.f320437e != null && !this.f320441m.equals(str)) {
            this.f320437e.setText(str);
            this.f320441m = str;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f122827f0 && (lVar = this.f320439h) != null) {
            lVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setWinkHDRStopListerner(l lVar) {
        this.f320439h = lVar;
    }

    public HDRStatusView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f320441m = "";
        this.C = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.hdr.b
            @Override // java.lang.Runnable
            public final void run() {
                HDRStatusView.this.e();
            }
        };
        c(context);
    }

    public HDRStatusView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f320441m = "";
        this.C = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.hdr.b
            @Override // java.lang.Runnable
            public final void run() {
                HDRStatusView.this.e();
            }
        };
        c(context);
    }

    public void f() {
    }
}
