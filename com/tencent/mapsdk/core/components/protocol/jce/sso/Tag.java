package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class Tag extends MapJceStruct implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static byte[] f147618a = null;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f147619b = true;
    public String strId;
    public byte[] value;

    public Tag() {
        this.strId = "";
        this.value = null;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "sosomap.Tag";
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f147619b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void display(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a(this.strId, "strId");
        kVar.a(this.value, "value");
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void displaySimple(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a(this.strId, true);
        kVar.a(this.value, false);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (!q.a((Object) this.strId, (Object) tag.strId) || !q.a((Object) this.value, (Object) tag.value)) {
            return false;
        }
        return true;
    }

    public final byte[] getValue() {
        return this.value;
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
        this.strId = mVar.b(0, true);
        if (f147618a == null) {
            f147618a = r2;
            byte[] bArr = {0};
        }
        this.value = mVar.c(1, true);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.strId, 0);
        nVar.a(this.value, 1);
    }

    public Tag(String str, byte[] bArr) {
        this.strId = str;
        this.value = bArr;
    }
}
