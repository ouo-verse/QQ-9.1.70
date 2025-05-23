package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class ClearTextEndIconDelegate extends com.google.android.material.textfield.d {

    /* renamed from: e, reason: collision with root package name */
    private final TextWatcher f34310e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f34311f;

    /* renamed from: g, reason: collision with root package name */
    private final TextInputLayout.d f34312g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout.e f34313h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f34314i;

    /* renamed from: j, reason: collision with root package name */
    private ValueAnimator f34315j;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
            clearTextEndIconDelegate.i(clearTextEndIconDelegate.m());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements TextInputLayout.d {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.d
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText L = textInputLayout.L();
            textInputLayout.setEndIconVisible(ClearTextEndIconDelegate.this.m());
            L.setOnFocusChangeListener(ClearTextEndIconDelegate.this.f34311f);
            ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
            clearTextEndIconDelegate.f34419c.setOnFocusChangeListener(clearTextEndIconDelegate.f34311f);
            L.removeTextChangedListener(ClearTextEndIconDelegate.this.f34310e);
            L.addTextChangedListener(ClearTextEndIconDelegate.this.f34310e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Editable text = ClearTextEndIconDelegate.this.f34417a.L().getText();
            if (text != null) {
                text.clear();
            }
            ClearTextEndIconDelegate.this.f34417a.o0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ClearTextEndIconDelegate.this.f34417a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ClearTextEndIconDelegate.this.f34417a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            ClearTextEndIconDelegate.this.f34419c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClearTextEndIconDelegate.this.f34419c.setScaleX(floatValue);
            ClearTextEndIconDelegate.this.f34419c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClearTextEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i3) {
        super(textInputLayout, i3);
        this.f34310e = new a();
        this.f34311f = new b();
        this.f34312g = new c();
        this.f34313h = new TextInputLayout.e() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            @Override // com.google.android.material.textfield.TextInputLayout.e
            public void a(@NonNull TextInputLayout textInputLayout2, int i16) {
                final EditText L = textInputLayout2.L();
                if (L != null && i16 == 2) {
                    L.post(new Runnable() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            L.removeTextChangedListener(ClearTextEndIconDelegate.this.f34310e);
                            ClearTextEndIconDelegate.this.i(true);
                        }
                    });
                    if (L.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.f34311f) {
                        L.setOnFocusChangeListener(null);
                    }
                    if (ClearTextEndIconDelegate.this.f34419c.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.f34311f) {
                        ClearTextEndIconDelegate.this.f34419c.setOnFocusChangeListener(null);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z16) {
        boolean z17;
        if (this.f34417a.e0() == z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && !this.f34314i.isRunning()) {
            this.f34315j.cancel();
            this.f34314i.start();
            if (z17) {
                this.f34314i.end();
                return;
            }
            return;
        }
        if (!z16) {
            this.f34314i.cancel();
            this.f34315j.start();
            if (z17) {
                this.f34315j.end();
            }
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(x0.a.f446810a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new g());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(x0.a.f446813d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private void l() {
        ValueAnimator k3 = k();
        ValueAnimator j3 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f34314i = animatorSet;
        animatorSet.playTogether(k3, j3);
        this.f34314i.addListener(new e());
        ValueAnimator j16 = j(1.0f, 0.0f);
        this.f34315j = j16;
        j16.addListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        EditText L = this.f34417a.L();
        if (L != null && ((L.hasFocus() || this.f34419c.hasFocus()) && L.getText().length() > 0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.d
    public void a() {
        TextInputLayout textInputLayout = this.f34417a;
        int i3 = this.f34420d;
        if (i3 == 0) {
            i3 = R.drawable.k0r;
        }
        textInputLayout.setEndIconDrawable(i3);
        TextInputLayout textInputLayout2 = this.f34417a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R.string.zm9));
        this.f34417a.setEndIconCheckable(false);
        this.f34417a.setEndIconOnClickListener(new d());
        this.f34417a.g(this.f34312g);
        this.f34417a.h(this.f34313h);
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.d
    public void c(boolean z16) {
        if (this.f34417a.b0() == null) {
            return;
        }
        i(z16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (ClearTextEndIconDelegate.this.f34417a.b0() != null) {
                return;
            }
            ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
            clearTextEndIconDelegate.i(clearTextEndIconDelegate.m());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
