package im;

import com.tencent.midas.api.IMidasLogCallback;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IMidasLogCallback {
    @Override // com.tencent.midas.api.IMidasLogCallback
    public void onLogging(int i3, String str, String str2) {
        if (i3 == 3) {
            QLog.i(str, 2, str2);
            return;
        }
        if (i3 == 4) {
            QLog.w(str, 1, str2);
        } else if (i3 != 5) {
            QLog.d(str, 2, str2);
        } else {
            QLog.e(str, 1, str2);
        }
    }
}
