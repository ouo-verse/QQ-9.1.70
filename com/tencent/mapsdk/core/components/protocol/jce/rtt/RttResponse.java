package com.tencent.mapsdk.core.components.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class RttResponse extends MapJceStruct implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static byte[] f147608a = null;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f147609b = true;
    public byte[] result;

    static {
        f147608a = r0;
        byte[] bArr = {0};
    }

    public RttResponse() {
        this.result = null;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "navsns.RttResponse";
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f147609b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void display(StringBuilder sb5, int i3) {
        new k(sb5, i3).a(this.result, "result");
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void displaySimple(StringBuilder sb5, int i3) {
        new k(sb5, i3).a(this.result, false);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return q.a((Object) this.result, (Object) ((RttResponse) obj).result);
    }

    public final byte[] getResult() {
        return this.result;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.result = mVar.c(0, true);
    }

    public final void setResult(byte[] bArr) {
        this.result = bArr;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.result, 0);
    }

    public RttResponse(byte[] bArr) {
        this.result = bArr;
    }
}
