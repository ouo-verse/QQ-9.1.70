package com.tencent.image_picker.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SnackBarView extends RelativeLayout {

    /* renamed from: c, reason: collision with root package name */
    public static final Interpolator f116274c = new FastOutLinearInInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public TextView f116275a;

    /* renamed from: b, reason: collision with root package name */
    public Button f116276b;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f116277a;

        /* compiled from: P */
        /* renamed from: com.tencent.image_picker.imagepicker.view.SnackBarView$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC5851a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f116279a;

            public RunnableC5851a(View view) {
                this.f116279a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f116277a.onClick(this.f116279a);
            }
        }

        public a(View.OnClickListener onClickListener) {
            this.f116277a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SnackBarView.this.a(new RunnableC5851a(view));
        }
    }

    public SnackBarView(Context context) {
        this(context, null);
    }

    public void b(int i3, View.OnClickListener onClickListener) {
        setText(i3);
        a(0, onClickListener);
        ViewCompat.animate(this).translationY(0.0f).setDuration(200L).setInterpolator(f116274c).alpha(1.0f);
    }

    public void setText(@StringRes int i3) {
        this.f116275a.setText(i3);
    }

    public SnackBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        View.inflate(getContext(), R.layout.ffy, this);
        if (isInEditMode()) {
            return;
        }
        ViewCompat.setTranslationY(this, getContext().getResources().getDimensionPixelSize(R.dimen.dk6));
        ViewCompat.setAlpha(this, 0.0f);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.dkd);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.f116275a = (TextView) findViewById(R.id.urc);
        this.f116276b = (Button) findViewById(R.id.urb);
    }

    public SnackBarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }

    public void a(int i3, View.OnClickListener onClickListener) {
        if (i3 == 0) {
            i3 = R.string.f241537s5;
        }
        this.f116276b.setText(i3);
        this.f116276b.setOnClickListener(new a(onClickListener));
    }

    public final void a(Runnable runnable) {
        ViewCompat.animate(this).translationY(getHeight()).setDuration(200L).alpha(0.5f).withEndAction(runnable);
    }
}
