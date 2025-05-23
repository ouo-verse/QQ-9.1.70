package com.tencent.aelight.camera.ae.flashshow.tips;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends c {

    /* renamed from: d, reason: collision with root package name */
    private View f64406d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f64407e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f64408f;

    /* renamed from: g, reason: collision with root package name */
    private AlphaAnimation f64409g;

    /* renamed from: h, reason: collision with root package name */
    private Animation.AnimationListener f64410h;

    public d(ViewStub viewStub) {
        super(viewStub);
        this.f64409g = new AlphaAnimation(1.0f, 0.0f);
        this.f64410h = new a();
    }

    public void h() {
        if (d()) {
            this.f64409g.setAnimationListener(null);
            this.f64409g.cancel();
            this.f64406d.clearAnimation();
            this.f64406d.setVisibility(8);
        }
    }

    public void i(String str, Bitmap bitmap, int i3) {
        c();
        this.f64406d.setVisibility(0);
        this.f64407e.setVisibility(0);
        this.f64407e.setText(str);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f64408f.setImageBitmap(bitmap);
            this.f64408f.setVisibility(0);
        } else {
            this.f64408f.setVisibility(8);
        }
        this.f64409g.reset();
        this.f64409g.setAnimationListener(this.f64410h);
        this.f64409g.setStartOffset(i3 > 0 ? i3 : 3000L);
        this.f64409g.setDuration(200L);
        this.f64406d.setAnimation(this.f64409g);
        this.f64409g.startNow();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.tips.c
    protected void e(View view) {
        this.f64406d = view.findViewById(R.id.rxo);
        this.f64408f = (ImageView) view.findViewById(R.id.rxp);
        this.f64407e = (TextView) view.findViewById(R.id.rxn);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (d.this.f64406d != null) {
                d.this.f64406d.clearAnimation();
                d.this.f64406d.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
