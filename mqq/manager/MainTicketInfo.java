package mqq.manager;

import com.tencent.commonsdk.util.HexUtil;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MainTicketInfo {

    /* renamed from: a2, reason: collision with root package name */
    private String f417212a2 = "";

    /* renamed from: d2, reason: collision with root package name */
    private byte[] f417213d2 = new byte[0];
    private byte[] d2Key = new byte[0];

    public String getA2() {
        return this.f417212a2;
    }

    public byte[] getD2() {
        return this.f417213d2;
    }

    public byte[] getD2Key() {
        return this.d2Key;
    }

    public void setA2(String str) {
        this.f417212a2 = str;
    }

    public void setD2(byte[] bArr) {
        this.f417213d2 = bArr;
    }

    public void setD2Key(byte[] bArr) {
        this.d2Key = bArr;
    }

    public String toString() {
        return "MainTicketInfo{a2='" + this.f417212a2 + "', d2=" + HexUtil.bytes2HexStr(this.f417213d2) + ", d2Key=" + HexUtil.bytes2HexStr(this.d2Key) + '}';
    }
}
