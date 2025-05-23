package fw1;

import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        boolean z16;
        if (objArr != null && objArr.length >= 1 && objArr[0] != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) objArr[0]);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f(z16);
                bVar.e(mergeFrom.uint32_result.get());
                bVar.d(mergeFrom.str_error_msg.get());
                return;
            } catch (Exception e16) {
                QLog.e("ReportGuestRoamMsgProtocolParser", 1, "parse error! " + e16);
                bVar.f(false);
                bVar.e(-1);
                bVar.d("client parse guestRoamMsg error!");
                return;
            }
        }
        QLog.d("ReportGuestRoamMsgProtocolParser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportGuestRoamMsgProtocolParser";
    }
}
