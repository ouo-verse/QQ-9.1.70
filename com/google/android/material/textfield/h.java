package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.tencent.mobileqq.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class h extends LinearLayout {
    private View.OnLongClickListener C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final TextInputLayout f34448d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f34449e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private CharSequence f34450f;

    /* renamed from: h, reason: collision with root package name */
    private final CheckableImageButton f34451h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f34452i;

    /* renamed from: m, reason: collision with root package name */
    private PorterDuff.Mode f34453m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f34448d = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.e5w, (ViewGroup) this, false);
        this.f34451h = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f34449e = appCompatTextView;
        f(tintTypedArray);
        e(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void e(TintTypedArray tintTypedArray) {
        this.f34449e.setVisibility(8);
        this.f34449e.setId(R.id.f95985gg);
        this.f34449e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f34449e, 1);
        k(tintTypedArray.getResourceId(w0.a.f444029sa, 0));
        int i3 = w0.a.f444041ta;
        if (tintTypedArray.hasValue(i3)) {
            l(tintTypedArray.getColorStateList(i3));
        }
        j(tintTypedArray.getText(w0.a.f444017ra));
    }

    private void f(TintTypedArray tintTypedArray) {
        if (g1.c.i(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f34451h.getLayoutParams(), 0);
        }
        p(null);
        q(null);
        int i3 = w0.a.f444087xa;
        if (tintTypedArray.hasValue(i3)) {
            this.f34452i = g1.c.b(getContext(), tintTypedArray, i3);
        }
        int i16 = w0.a.f444099ya;
        if (tintTypedArray.hasValue(i16)) {
            this.f34453m = ViewUtils.j(tintTypedArray.getInt(i16, -1), null);
        }
        int i17 = w0.a.f444075wa;
        if (tintTypedArray.hasValue(i17)) {
            o(tintTypedArray.getDrawable(i17));
            int i18 = w0.a.f444064va;
            if (tintTypedArray.hasValue(i18)) {
                n(tintTypedArray.getText(i18));
            }
            m(tintTypedArray.getBoolean(w0.a.f444053ua, true));
        }
    }

    private void w() {
        int i3;
        boolean z16;
        int i16 = 8;
        if (this.f34450f != null && !this.D) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (this.f34451h.getVisibility() != 0 && i3 != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i16 = 0;
        }
        setVisibility(i16);
        this.f34449e.setVisibility(i3);
        this.f34448d.M0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CharSequence a() {
        return this.f34450f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public TextView b() {
        return this.f34449e;
    }

    @Nullable
    CharSequence c() {
        return this.f34451h.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Drawable d() {
        return this.f34451h.getDrawable();
    }

    boolean g() {
        if (this.f34451h.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z16) {
        this.D = z16;
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        e.c(this.f34448d, this.f34451h, this.f34452i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f34450f = charSequence2;
        this.f34449e.setText(charSequence);
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@StyleRes int i3) {
        TextViewCompat.setTextAppearance(this.f34449e, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull ColorStateList colorStateList) {
        this.f34449e.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z16) {
        this.f34451h.setCheckable(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(@Nullable CharSequence charSequence) {
        if (c() != charSequence) {
            this.f34451h.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(@Nullable Drawable drawable) {
        this.f34451h.setImageDrawable(drawable);
        if (drawable != null) {
            e.a(this.f34448d, this.f34451h, this.f34452i, this.f34453m);
            t(true);
            i();
        } else {
            t(false);
            p(null);
            q(null);
            n(null);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        v();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(@Nullable View.OnClickListener onClickListener) {
        e.e(this.f34451h, onClickListener, this.C);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(@Nullable View.OnLongClickListener onLongClickListener) {
        this.C = onLongClickListener;
        e.f(this.f34451h, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@Nullable ColorStateList colorStateList) {
        if (this.f34452i != colorStateList) {
            this.f34452i = colorStateList;
            e.a(this.f34448d, this.f34451h, colorStateList, this.f34453m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(@Nullable PorterDuff.Mode mode) {
        if (this.f34453m != mode) {
            this.f34453m = mode;
            e.a(this.f34448d, this.f34451h, this.f34452i, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z16) {
        int i3;
        if (g() != z16) {
            CheckableImageButton checkableImageButton = this.f34451h;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            checkableImageButton.setVisibility(i3);
            v();
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f34449e.getVisibility() == 0) {
            accessibilityNodeInfoCompat.setLabelFor(this.f34449e);
            accessibilityNodeInfoCompat.setTraversalAfter(this.f34449e);
        } else {
            accessibilityNodeInfoCompat.setTraversalAfter(this.f34451h);
        }
    }

    void v() {
        int paddingStart;
        EditText editText = this.f34448d.f34389i;
        if (editText == null) {
            return;
        }
        if (g()) {
            paddingStart = 0;
        } else {
            paddingStart = ViewCompat.getPaddingStart(editText);
        }
        ViewCompat.setPaddingRelative(this.f34449e, paddingStart, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.cph), editText.getCompoundPaddingBottom());
    }
}
