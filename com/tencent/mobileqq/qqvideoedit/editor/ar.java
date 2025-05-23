package com.tencent.mobileqq.qqvideoedit.editor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ar implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    private final int f275185a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f275186b;

    public ar(int i3, boolean z16) {
        this.f275185a = i3;
        this.f275186b = z16;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        try {
            return cls.getConstructor(Integer.TYPE, Boolean.TYPE).newInstance(Integer.valueOf(this.f275185a), Boolean.valueOf(this.f275186b));
        } catch (Exception e16) {
            throw new RuntimeException("Cannot create an instance of " + cls, e16);
        }
    }
}
