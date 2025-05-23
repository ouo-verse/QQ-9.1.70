package fw1;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        if (objArr != null && objArr.length >= 3) {
            int i3 = 0;
            Object obj = objArr[0];
            if ((obj instanceof Integer) && (objArr[1] instanceof String) && (objArr[2] instanceof Boolean)) {
                int intValue = ((Integer) obj).intValue();
                String str = (String) objArr[1];
                Boolean bool = (Boolean) objArr[2];
                bVar.f(bool.booleanValue());
                if (!bool.booleanValue()) {
                    i3 = intValue;
                }
                bVar.e(i3);
                bVar.d(str);
                return;
            }
        }
        QLog.d("ReportNormalProtocolParser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportNormalProtocolParser";
    }
}
