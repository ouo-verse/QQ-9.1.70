package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class SCFileUpdateRsp extends MapJceStruct {

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<FileUpdateRsp> f147603a = new ArrayList<>();
    public int iRet;
    public ArrayList<FileUpdateRsp> vItems;

    static {
        f147603a.add(new FileUpdateRsp());
    }

    public SCFileUpdateRsp() {
        this.iRet = 0;
        this.vItems = null;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "MapConfProtocol.SCFileUpdateRsp";
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.iRet = mVar.a(this.iRet, 0, true);
        this.vItems = (ArrayList) mVar.a((m) f147603a, 1, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("SCFileUpdateRsp{");
        stringBuffer.append("iRet=");
        stringBuffer.append(this.iRet);
        stringBuffer.append(", vItems=");
        stringBuffer.append(this.vItems);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.iRet, 0);
        ArrayList<FileUpdateRsp> arrayList = this.vItems;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 1);
        }
    }

    public SCFileUpdateRsp(int i3, ArrayList<FileUpdateRsp> arrayList) {
        this.iRet = i3;
        this.vItems = arrayList;
    }
}
