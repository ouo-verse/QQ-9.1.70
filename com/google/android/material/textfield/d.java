package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    TextInputLayout f34417a;

    /* renamed from: b, reason: collision with root package name */
    Context f34418b;

    /* renamed from: c, reason: collision with root package name */
    CheckableImageButton f34419c;

    /* renamed from: d, reason: collision with root package name */
    @DrawableRes
    final int f34420d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@NonNull TextInputLayout textInputLayout, @DrawableRes int i3) {
        this.f34417a = textInputLayout;
        this.f34418b = textInputLayout.getContext();
        this.f34419c = textInputLayout.Q();
        this.f34420d = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i3) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z16) {
    }
}
