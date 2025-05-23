package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes9.dex */
public final class Package extends MapJceStruct implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static int f147613a = 0;

    /* renamed from: b, reason: collision with root package name */
    static byte[] f147614b = null;

    /* renamed from: c, reason: collision with root package name */
    static byte[] f147615c = null;

    /* renamed from: d, reason: collision with root package name */
    static ArrayList<Tag> f147616d = null;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f147617e = true;
    public byte[] busiBuff;
    public byte cEncodeType;
    public int eCmd;
    public byte[] head;
    public int iSeqNo;
    public String sAppId;
    public short shVer;
    public String strSubCmd;
    public String uin;
    public ArrayList<Tag> vTag;

    public Package() {
        this.shVer = (short) 0;
        this.eCmd = 0;
        this.strSubCmd = "";
        this.iSeqNo = 0;
        this.cEncodeType = (byte) 0;
        this.sAppId = "";
        this.uin = "";
        this.head = null;
        this.busiBuff = null;
        this.vTag = null;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "sosomap.Package";
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f147617e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void display(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a(this.shVer, "shVer");
        kVar.a(this.eCmd, "eCmd");
        kVar.a(this.strSubCmd, "strSubCmd");
        kVar.a(this.iSeqNo, "iSeqNo");
        kVar.a(this.cEncodeType, "cEncodeType");
        kVar.a(this.sAppId, "sAppId");
        kVar.a(this.uin, "uin");
        kVar.a(this.head, "head");
        kVar.a(this.busiBuff, "busiBuff");
        kVar.a((Collection) this.vTag, "vTag");
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void displaySimple(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a(this.shVer, true);
        kVar.a(this.eCmd, true);
        kVar.a(this.strSubCmd, true);
        kVar.a(this.iSeqNo, true);
        kVar.a(this.cEncodeType, true);
        kVar.a(this.sAppId, true);
        kVar.a(this.uin, true);
        kVar.a(this.head, true);
        kVar.a(this.busiBuff, true);
        kVar.a((Collection) this.vTag, false);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Package r46 = (Package) obj;
        if (!q.a(this.shVer, r46.shVer) || !q.a(this.eCmd, r46.eCmd) || !q.a((Object) this.strSubCmd, (Object) r46.strSubCmd) || !q.a(this.iSeqNo, r46.iSeqNo) || !q.a(this.cEncodeType, r46.cEncodeType) || !q.a((Object) this.sAppId, (Object) r46.sAppId) || !q.a((Object) this.uin, (Object) r46.uin) || !q.a((Object) this.head, (Object) r46.head) || !q.a((Object) this.busiBuff, (Object) r46.busiBuff) || !q.a((Object) this.vTag, (Object) r46.vTag)) {
            return false;
        }
        return true;
    }

    public final byte[] getBusiBuff() {
        return this.busiBuff;
    }

    public final byte[] getHead() {
        return this.head;
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
        this.shVer = mVar.a(this.shVer, 0, true);
        this.eCmd = mVar.a(this.eCmd, 1, true);
        this.strSubCmd = mVar.b(2, true);
        this.iSeqNo = mVar.a(this.iSeqNo, 3, false);
        this.cEncodeType = mVar.a(this.cEncodeType, 4, false);
        this.sAppId = mVar.b(5, false);
        this.uin = mVar.b(6, false);
        if (f147614b == null) {
            f147614b = r0;
            byte[] bArr = {0};
        }
        this.head = mVar.c(7, false);
        if (f147615c == null) {
            f147615c = r0;
            byte[] bArr2 = {0};
        }
        this.busiBuff = mVar.c(8, false);
        if (f147616d == null) {
            f147616d = new ArrayList<>();
            f147616d.add(new Tag());
        }
        this.vTag = (ArrayList) mVar.a((m) f147616d, 9, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.shVer, 0);
        nVar.a(this.eCmd, 1);
        nVar.a(this.strSubCmd, 2);
        nVar.a(this.iSeqNo, 3);
        nVar.a(this.cEncodeType, 4);
        String str = this.sAppId;
        if (str != null) {
            nVar.a(str, 5);
        }
        String str2 = this.uin;
        if (str2 != null) {
            nVar.a(str2, 6);
        }
        byte[] bArr = this.head;
        if (bArr != null) {
            nVar.a(bArr, 7);
        }
        byte[] bArr2 = this.busiBuff;
        if (bArr2 != null) {
            nVar.a(bArr2, 8);
        }
        ArrayList<Tag> arrayList = this.vTag;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 9);
        }
    }

    public Package(short s16, int i3, String str, int i16, byte b16, String str2, String str3, byte[] bArr, byte[] bArr2, ArrayList<Tag> arrayList) {
        this.shVer = s16;
        this.eCmd = i3;
        this.strSubCmd = str;
        this.iSeqNo = i16;
        this.cEncodeType = b16;
        this.sAppId = str2;
        this.uin = str3;
        this.head = bArr;
        this.busiBuff = bArr2;
        this.vTag = arrayList;
    }
}
