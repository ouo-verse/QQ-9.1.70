package com.google.android.material.textfield;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull TextInputLayout textInputLayout, @DrawableRes int i3) {
        super(textInputLayout, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.d
    public void a() {
        this.f34417a.setEndIconDrawable(this.f34420d);
        this.f34417a.setEndIconOnClickListener(null);
        this.f34417a.setEndIconOnLongClickListener(null);
    }
}
