package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class FileUpdateRsp extends MapJceStruct {
    public int iFileSize;
    public int iFileUpdated;
    public int iRet;
    public int iVersion;
    public String sMd5;
    public String sName;
    public String sUpdateUrl;

    public FileUpdateRsp() {
        this.sName = "";
        this.iRet = 0;
        this.iVersion = 0;
        this.iFileUpdated = 0;
        this.sUpdateUrl = "";
        this.sMd5 = "";
        this.iFileSize = 0;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "MapConfProtocol.FileUpdateRsp";
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.sName = mVar.b(0, true);
        this.iRet = mVar.a(this.iRet, 1, true);
        this.iVersion = mVar.a(this.iVersion, 2, true);
        this.iFileUpdated = mVar.a(this.iFileUpdated, 3, false);
        this.sUpdateUrl = mVar.b(4, false);
        this.sMd5 = mVar.b(5, false);
        this.iFileSize = mVar.a(this.iFileSize, 6, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("FileUpdateRsp{");
        stringBuffer.append("sName='");
        stringBuffer.append(this.sName);
        stringBuffer.append('\'');
        stringBuffer.append(", iRet=");
        stringBuffer.append(this.iRet);
        stringBuffer.append(", iVersion=");
        stringBuffer.append(this.iVersion);
        stringBuffer.append(", iFileUpdated=");
        stringBuffer.append(this.iFileUpdated);
        stringBuffer.append(", sUpdateUrl='");
        stringBuffer.append(this.sUpdateUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", sMd5='");
        stringBuffer.append(this.sMd5);
        stringBuffer.append('\'');
        stringBuffer.append(", iFileSize=");
        stringBuffer.append(this.iFileSize);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.sName, 0);
        nVar.a(this.iRet, 1);
        nVar.a(this.iVersion, 2);
        nVar.a(this.iFileUpdated, 3);
        String str = this.sUpdateUrl;
        if (str != null) {
            nVar.a(str, 4);
        }
        String str2 = this.sMd5;
        if (str2 != null) {
            nVar.a(str2, 5);
        }
        nVar.a(this.iFileSize, 6);
    }

    public FileUpdateRsp(String str, int i3, int i16, int i17, String str2, String str3, int i18) {
        this.sName = str;
        this.iRet = i3;
        this.iVersion = i16;
        this.iFileUpdated = i17;
        this.sUpdateUrl = str2;
        this.sMd5 = str3;
        this.iFileSize = i18;
    }
}
