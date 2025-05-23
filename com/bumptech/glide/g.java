package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.g;
import h0.j;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class g<CHILD extends g<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private f0.e<? super TranscodeType> f31502d = f0.c.c();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f0.e<? super TranscodeType> b() {
        return this.f31502d;
    }

    @NonNull
    public final CHILD d(@NonNull f0.e<? super TranscodeType> eVar) {
        this.f31502d = (f0.e) j.d(eVar);
        return c();
    }

    private CHILD c() {
        return this;
    }
}
