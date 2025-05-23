package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.io.File;
import s.a;

/* compiled from: P */
/* loaded from: classes.dex */
class c<DataType> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.a<DataType> f31649a;

    /* renamed from: b, reason: collision with root package name */
    private final DataType f31650b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.e f31651c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, com.bumptech.glide.load.e eVar) {
        this.f31649a = aVar;
        this.f31650b = datatype;
        this.f31651c = eVar;
    }

    @Override // s.a.b
    public boolean write(@NonNull File file) {
        return this.f31649a.a(this.f31650b, file, this.f31651c);
    }
}
