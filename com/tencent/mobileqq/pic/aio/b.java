package com.tencent.mobileqq.pic.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(String str, long j3) {
        if (str != null && j3 != 0) {
            Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = b().entrySet().iterator();
            while (it.hasNext()) {
                IHttpCommunicatorListener value = it.next().getValue();
                if (c(value)) {
                    BaseTransProcessor baseTransProcessor = (BaseTransProcessor) value;
                    if (str.equals(baseTransProcessor.mUiRequest.mPeerUin) && j3 == baseTransProcessor.mUiRequest.mUniseq) {
                        baseTransProcessor.cancel();
                        if (QLog.isColorLevel()) {
                            QLog.d("cancelpic", 2, "cancel pic:" + baseTransProcessor.mUiRequest.mUniseq);
                        }
                    }
                }
            }
        }
    }

    static ConcurrentHashMap<String, IHttpCommunicatorListener> b() {
        return ((ITransFileController) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(ITransFileController.class)).getProcessMap();
    }

    private static boolean c(IHttpCommunicatorListener iHttpCommunicatorListener) {
        if (iHttpCommunicatorListener == null || !(iHttpCommunicatorListener instanceof IPicTransFile.b)) {
            return false;
        }
        BaseTransProcessor baseTransProcessor = (BaseTransProcessor) iHttpCommunicatorListener;
        if (baseTransProcessor.getFileStatus() == Constant.FROM_ID_START_ACTIVITY || baseTransProcessor.getLastFileStatus() == Constant.FROM_ID_START_ACTIVITY) {
            return false;
        }
        return true;
    }
}
