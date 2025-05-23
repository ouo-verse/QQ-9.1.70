package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: d, reason: collision with root package name */
    private int f33796d;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final int a() {
        return this.f33796d;
    }

    public final void b(int i3, boolean z16) {
        super.setVisibility(i3);
        if (z16) {
            this.f33796d = i3;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        b(i3, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f33796d = getVisibility();
    }
}
