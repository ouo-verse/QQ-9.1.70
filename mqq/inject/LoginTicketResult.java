package mqq.inject;

import com.tencent.commonsdk.util.HexUtil;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LoginTicketResult {

    /* renamed from: a2, reason: collision with root package name */
    public byte[] f417209a2 = new byte[0];

    /* renamed from: d2, reason: collision with root package name */
    public byte[] f417210d2 = new byte[0];
    public byte[] d2Key = new byte[0];

    public String toString() {
        return "LoginTicketResult{a2=" + HexUtil.bytes2HexStr(this.f417209a2) + ", d2=" + HexUtil.bytes2HexStr(this.f417210d2) + ", d2Key=" + HexUtil.bytes2HexStr(this.d2Key) + '}';
    }
}
