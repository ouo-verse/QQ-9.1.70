package com.tencent.qmethod.pandoraex.core;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class w extends ThreadLocal<StringBuilder> {

    /* renamed from: a, reason: collision with root package name */
    private final int f344167a;

    public w(int i3) {
        this.f344167a = i3;
    }

    @Override // java.lang.ThreadLocal
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StringBuilder get() {
        StringBuilder sb5 = (StringBuilder) super.get();
        if (sb5 == null) {
            return new StringBuilder();
        }
        return sb5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public StringBuilder initialValue() {
        return new StringBuilder(this.f344167a);
    }

    @Override // java.lang.ThreadLocal
    public void remove() {
        StringBuilder sb5 = (StringBuilder) super.get();
        if (sb5 != null) {
            sb5.setLength(0);
        }
    }
}
