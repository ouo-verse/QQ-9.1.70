package hc0;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class s implements com.tencent.tedger.outapi.delegate.e {
    @Override // com.tencent.tedger.outapi.delegate.e
    public int a() {
        return 1;
    }

    @Override // com.tencent.tedger.outapi.delegate.e
    public void d(String str, int i3, String str2) {
        QLog.d(str, i3, str2);
    }

    @Override // com.tencent.tedger.outapi.delegate.e
    public void e(String str, int i3, String str2) {
        QLog.e(str, i3, str2);
    }

    @Override // com.tencent.tedger.outapi.delegate.e
    public void i(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
    }

    @Override // com.tencent.tedger.outapi.delegate.e
    public void w(String str, int i3, String str2) {
        QLog.w(str, i3, str2);
    }
}
