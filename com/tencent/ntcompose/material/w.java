package com.tencent.ntcompose.material;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/material/w;", "Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "", "a", "I", "()I", "b", "(I)V", "firstLoadMaxIndex", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class w implements com.tencent.ntcompose.foundation.lazy.layout.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int firstLoadMaxIndex = 6;

    @Override // com.tencent.ntcompose.foundation.lazy.layout.a
    /* renamed from: a, reason: from getter */
    public int getFirstLoadMaxIndex() {
        return this.firstLoadMaxIndex;
    }

    public void b(int i3) {
        this.firstLoadMaxIndex = i3;
    }
}
