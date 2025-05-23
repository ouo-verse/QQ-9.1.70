package f61;

import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$EmptyStatusInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f397894a;

    public static b a(oidb_0xcf4$EmptyStatusInfo oidb_0xcf4_emptystatusinfo) {
        if (oidb_0xcf4_emptystatusinfo == null) {
            return null;
        }
        b bVar = new b();
        if (oidb_0xcf4_emptystatusinfo.bytes_jump_url.has()) {
            bVar.f397894a = oidb_0xcf4_emptystatusinfo.bytes_jump_url.get().toStringUtf8();
        }
        return bVar;
    }

    public String toString() {
        return "EmptyStatusInfo{jumpUrl=" + this.f397894a + '}';
    }
}
