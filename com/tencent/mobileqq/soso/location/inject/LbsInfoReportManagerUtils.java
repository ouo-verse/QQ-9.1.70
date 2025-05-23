package com.tencent.mobileqq.soso.location.inject;

import com.tencent.mobileqq.app.soso.LbsInfoReportManagerProcessorProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LbsInfoReportManagerUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SOSO.LbsInfoReportManagerUtils";

    @ConfigInject(configPath = "Foundation/QQLocation/src/main/resources/Inject_QQLocationLbsInfoReportManagerProcessor.yml", version = 1)
    public static ArrayList<Class<? extends ILbsInfoReportManagerProcessor>> sLbsInfoReportManagerClassList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34883);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends ILbsInfoReportManagerProcessor>> arrayList = new ArrayList<>();
        sLbsInfoReportManagerClassList = arrayList;
        arrayList.add(LbsInfoReportManagerProcessorProxy.class);
    }

    public LbsInfoReportManagerUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportLbsInfo2DC(SosoLocation sosoLocation, String str) {
        try {
            sLbsInfoReportManagerClassList.get(0).newInstance().reportLbsInfo2DC(sosoLocation, str);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "ILbsInfoReportManagerProcessor.reportLbsInfo2DC(), location = " + sosoLocation + ", businessTag = " + str);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }
}
