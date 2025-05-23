package com.tencent.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.QAdPerformanceDefine$MonitorAdKey;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WeakReferenceHandler extends Handler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WeakReferenceHandler";
    private WeakReference<Handler.Callback> mWeakReferCallBack;

    public WeakReferenceHandler(Handler.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mWeakReferCallBack = new WeakReference<>(callback);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        Handler.Callback callback = this.mWeakReferCallBack.get();
        if (callback != null) {
            callback.handleMessage(message);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleMessage cb is null! handler = " + this);
        }
    }

    @Override // android.os.Handler
    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Handler.Callback callback = this.mWeakReferCallBack.get();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(QAdPerformanceDefine$MonitorAdKey.Q_AD_MONITOR_INFO_REPORT_KEY_BACK);
            if (callback != null) {
                str = callback.toString();
            } else {
                str = "None callback";
            }
            sb5.append(str);
            return sb5.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "WHcallback exception";
        }
    }

    public WeakReferenceHandler(Looper looper, Handler.Callback callback) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mWeakReferCallBack = new WeakReference<>(callback);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper, (Object) callback);
        }
    }
}
