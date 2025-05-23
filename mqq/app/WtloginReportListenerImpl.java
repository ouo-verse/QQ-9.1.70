package mqq.app;

import android.util.Log;
import java.util.HashMap;
import mqq.inject.MqqInjectorManager;
import oicq.wlogin_sdk.listener.ReportListener;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WtloginReportListenerImpl implements ReportListener {
    private static final String TAG = "WtloginReportListenerImpl";
    private static volatile WtloginReportListenerImpl singleton;

    WtloginReportListenerImpl() {
    }

    public static WtloginReportListenerImpl getSingleton() {
        if (singleton == null) {
            synchronized (WtloginReportListenerImpl.class) {
                if (singleton == null) {
                    singleton = new WtloginReportListenerImpl();
                }
            }
        }
        return singleton;
    }

    @Override // oicq.wlogin_sdk.listener.ReportListener
    public void onReport(String str, HashMap<String, String> hashMap, boolean z16, boolean z17) {
        Log.d(TAG, "onReport() called with: name = [" + str + "], params = [" + hashMap + "], isRealTime = [" + z16 + "], isImmediatelyUpload = [" + z17 + "]");
        MqqInjectorManager.instance().report(str, hashMap);
    }
}
