package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScannerFlashSwitcher extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f120169a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f120170b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f120171c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f120172d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f120173e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScannerFlashSwitcher.this.f120169a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ScannerFlashSwitcher.this.f120169a.setAlpha(1.0f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ScannerFlashSwitcher.this.setVisibility(8);
        }
    }

    public ScannerFlashSwitcher(Context context) {
        super(context);
        this.f120171c = false;
        c();
    }

    public void b() {
        w.d("Luggage.ScannerFlashSwitcher", "hide");
        setEnabled(false);
        this.f120173e = false;
        this.f120169a.animate().alpha(0.0f).setDuration(500L);
        this.f120170b.animate().alpha(0.0f).setDuration(500L).setListener(new c());
        this.f120172d = false;
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ffg, (ViewGroup) this, true);
        this.f120169a = (ImageView) findViewById(R.id.vaj);
        this.f120170b = (TextView) findViewById(R.id.v96);
        this.f120171c = true;
    }

    public boolean d() {
        return this.f120172d;
    }

    public boolean e() {
        return this.f120173e;
    }

    public void f() {
        w.d("Luggage.ScannerFlashSwitcher", "openFlashStatus");
        this.f120172d = true;
        this.f120169a.setImageResource(R.drawable.ou8);
        this.f120170b.setText(R.string.f223976ho);
    }

    public void g() {
        w.d("Luggage.ScannerFlashSwitcher", "show, isFirstShow: %s", Boolean.valueOf(this.f120171c));
        this.f120173e = true;
        if (this.f120171c) {
            this.f120169a.setAlpha(0.0f);
            this.f120170b.setAlpha(0.0f);
            setVisibility(0);
            this.f120170b.animate().alpha(1.0f).setListener(null).setDuration(500L);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new a());
            ofFloat.setRepeatCount(3);
            ofFloat.setRepeatMode(2);
            ofFloat.setDuration(500L);
            ofFloat.addListener(new b());
            ofFloat.start();
            this.f120171c = false;
        } else {
            setVisibility(0);
            this.f120170b.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
            this.f120169a.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
        }
        setEnabled(true);
    }

    public void a() {
        w.d("Luggage.ScannerFlashSwitcher", "closeFlashStatus");
        this.f120172d = false;
        this.f120169a.setImageResource(R.drawable.ou7);
        this.f120170b.setText(R.string.f223986hp);
    }

    public ScannerFlashSwitcher(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f120171c = false;
        c();
    }

    public ScannerFlashSwitcher(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f120171c = false;
        c();
    }
}
