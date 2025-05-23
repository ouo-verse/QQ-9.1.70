package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class CmdResult extends MapJceStruct implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f147610a = true;
    public int iErrCode;
    public int iSubErrCode;
    public String strErrDesc;

    public CmdResult() {
        this.iErrCode = 0;
        this.strErrDesc = "";
        this.iSubErrCode = 0;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "sosomap.CmdResult";
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f147610a) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void display(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a(this.iErrCode, "iErrCode");
        kVar.a(this.strErrDesc, "strErrDesc");
        kVar.a(this.iSubErrCode, "iSubErrCode");
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void displaySimple(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a(this.iErrCode, true);
        kVar.a(this.strErrDesc, true);
        kVar.a(this.iSubErrCode, false);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        CmdResult cmdResult = (CmdResult) obj;
        if (!q.a(this.iErrCode, cmdResult.iErrCode) || !q.a((Object) this.strErrDesc, (Object) cmdResult.strErrDesc) || !q.a(this.iSubErrCode, cmdResult.iSubErrCode)) {
            return false;
        }
        return true;
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
        this.iErrCode = mVar.a(this.iErrCode, 0, true);
        this.strErrDesc = mVar.b(1, true);
        this.iSubErrCode = mVar.a(this.iSubErrCode, 2, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.iErrCode, 0);
        nVar.a(this.strErrDesc, 1);
        nVar.a(this.iSubErrCode, 2);
    }

    public CmdResult(int i3, String str, int i16) {
        this.iErrCode = i3;
        this.strErrDesc = str;
        this.iSubErrCode = i16;
    }
}
