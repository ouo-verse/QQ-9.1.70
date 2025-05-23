package fw1;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        boolean z16 = true;
        if (objArr != null && objArr.length >= 2) {
            Object obj = objArr[0];
            if ((obj instanceof Integer) && (objArr[1] instanceof String)) {
                int intValue = ((Integer) obj).intValue();
                String str = (String) objArr[1];
                if (intValue != 0) {
                    z16 = false;
                }
                bVar.f(z16);
                bVar.e(intValue);
                bVar.d(str);
                return;
            }
        }
        QLog.d("ReportSendGuildArkToServerParser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportSendGuildArkToServerParser";
    }
}
