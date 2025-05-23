package com.tencent.mtt.hippy.runtime.builtins;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends i {

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f337566a;

    public a(ByteBuffer byteBuffer) {
        this.f337566a = byteBuffer;
    }

    public static a a(int i3) {
        return new a(ByteBuffer.allocate(i3));
    }

    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a clone() throws CloneNotSupportedException {
        a aVar = (a) super.clone();
        aVar.f337566a = this.f337566a.duplicate();
        return aVar;
    }

    public ByteBuffer a() {
        return this.f337566a;
    }
}
