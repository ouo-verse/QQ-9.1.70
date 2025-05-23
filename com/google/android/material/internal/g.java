package com.google.android.material.internal;

import android.widget.Checkable;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.g;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public interface g<T extends g<T>> extends Checkable {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a<C> {
        void a(C c16, boolean z16);
    }

    @IdRes
    int getId();

    void setInternalOnCheckedChangeListener(@Nullable a<T> aVar);
}
