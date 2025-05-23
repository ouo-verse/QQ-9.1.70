package com.tencent.luggage.wxa.ol;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p extends PasswordTransformationMethod {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements CharSequence {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f136898a;

        public a(CharSequence charSequence) {
            this.f136898a = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i3) {
            return '\u25cf';
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.f136898a.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i3, int i16) {
            return this.f136898a.subSequence(i3, i16);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new a(charSequence);
    }
}
