package fw1;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        boolean z16 = true;
        if (objArr != null && objArr.length >= 2) {
            int i3 = 0;
            Object obj = objArr[0];
            if ((obj instanceof Integer) && (objArr[1] instanceof String)) {
                int intValue = ((Integer) obj).intValue();
                String str = (String) objArr[1];
                if (intValue != 0 && intValue != 400100) {
                    z16 = false;
                }
                bVar.f(z16);
                if (!z16) {
                    i3 = intValue;
                }
                bVar.e(i3);
                bVar.d(str);
                return;
            }
        }
        QLog.d("ReportGetMsgBoxProtocolParser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportGetMsgBoxProtocolParser";
    }
}
