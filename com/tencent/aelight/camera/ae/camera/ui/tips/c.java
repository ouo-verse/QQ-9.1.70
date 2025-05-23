package com.tencent.aelight.camera.ae.camera.ui.tips;

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
public class c extends com.tencent.aelight.camera.ae.camera.ui.a {
    private AlphaAnimation C;
    private Animation.AnimationListener D;

    /* renamed from: h, reason: collision with root package name */
    private View f63312h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f63313i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f63314m;

    public c(ViewStub viewStub) {
        super(viewStub);
        this.C = new AlphaAnimation(1.0f, 0.0f);
        this.D = new a();
    }

    public void o() {
        if (k()) {
            this.C.setAnimationListener(null);
            this.C.cancel();
            this.f63312h.clearAnimation();
            this.f63312h.setVisibility(8);
        }
    }

    public void p(String str, Bitmap bitmap, int i3) {
        i();
        this.f63312h.setVisibility(0);
        this.f63313i.setVisibility(0);
        this.f63313i.setText(str);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f63314m.setImageBitmap(bitmap);
            this.f63314m.setVisibility(0);
        } else {
            this.f63314m.setVisibility(8);
        }
        this.C.reset();
        this.C.setAnimationListener(this.D);
        this.C.setStartOffset(i3 > 0 ? i3 : 3000L);
        this.C.setDuration(200L);
        this.f63312h.setAnimation(this.C);
        this.C.startNow();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        this.f63312h = view.findViewById(R.id.rxo);
        this.f63314m = (ImageView) view.findViewById(R.id.rxp);
        this.f63313i = (TextView) view.findViewById(R.id.rxn);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.f63312h != null) {
                c.this.f63312h.clearAnimation();
                c.this.f63312h.setVisibility(8);
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
