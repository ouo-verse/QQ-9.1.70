package jx2;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d implements com.tencent.paysdk.log.b {
    @Override // com.tencent.paysdk.log.b
    public void e(String str, String str2) {
        QLog.e("TVideoAuthPayLog", 4, "tag : " + str + " msg: " + str2);
    }

    @Override // com.tencent.paysdk.log.b
    public void i(String str, String str2) {
        QLog.i("TVideoAuthPayLog", 4, "tag : " + str + " msg: " + str2);
    }
}
