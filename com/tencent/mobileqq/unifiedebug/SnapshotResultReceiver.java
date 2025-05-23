package com.tencent.mobileqq.unifiedebug;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SnapshotResultReceiver extends ResultReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f305708d;

    public SnapshotResultReceiver(QQAppInterface qQAppInterface, Handler handler) {
        super(handler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) handler);
        } else {
            this.f305708d = qQAppInterface;
        }
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        SecSpyFileManager secSpyFileManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
            return;
        }
        super.onReceiveResult(i3, bundle);
        QQAppInterface qQAppInterface = this.f305708d;
        if (qQAppInterface != null) {
            secSpyFileManager = (SecSpyFileManager) qQAppInterface.getManager(QQManagerFactory.SEC_SPY_FILEMANAGER);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("SnapshotResultReceiver", 2, "mApp.getManager(QQAppInterface.SEC_SPY_FILEMANAGER) == null");
            }
            secSpyFileManager = null;
        }
        SecSpyFileManager secSpyFileManager2 = secSpyFileManager;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && secSpyFileManager2 != null) {
                        long j3 = bundle.getLong("seq");
                        secSpyFileManager2.d(j3);
                        secSpyFileManager2.k(j3, -1, "can't find x5's method: snapshotVisibleWithBitmap");
                        return;
                    }
                    return;
                }
                if (secSpyFileManager2 != null) {
                    String string = bundle.getString("debugUrl");
                    int i16 = bundle.getInt("maxCount");
                    long j16 = bundle.getLong("seq");
                    secSpyFileManager2.o(string, i16, bundle.getLong("delay"), j16, bundle.getString("seqKey"));
                    if (QLog.isColorLevel()) {
                        QLog.d("SnapshotResultReceiver", 2, "RESULT_WEBVIEW_INVALID, restart alive snapshot. seq=" + j16);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SnapshotResultReceiver", 2, "RESULT_WEBVIEW_INVALID, manager == null");
                    return;
                }
                return;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList("snapshotPaths");
            long j17 = bundle.getLong("seq");
            String string2 = bundle.getString("seqKey");
            if (secSpyFileManager2 != null) {
                secSpyFileManager2.r(stringArrayList, j17, string2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SnapshotResultReceiver", 2, "RESULT_FINISH_ALIVE_SNAPSHOT, seq=" + j17);
                return;
            }
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("snapshotPaths");
        long j18 = bundle.getLong("seq");
        String string3 = bundle.getString("seqKey");
        if (secSpyFileManager2 != null) {
            secSpyFileManager2.e(stringArrayList2, j18, string3);
        }
    }
}
