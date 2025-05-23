package d6;

import com.qzone.common.account.LoginData;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.IQZoneProtocolListener;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.common.servlet.QZoneIntent;
import com.qzone.common.servlet.QZoneServlet;
import com.qzone.publish.business.protocol.QzoneUploadRequest;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static Object f393114b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static a f393115c;

    /* renamed from: a, reason: collision with root package name */
    private String f393116a = "QzoneNewService";

    a() {
    }

    public static a a() {
        if (f393115c == null) {
            synchronized (f393114b) {
                if (f393115c == null) {
                    f393115c = new a();
                }
            }
        }
        return f393115c;
    }

    public int b(QZoneRequest qZoneRequest, IQZoneProtocolListener iQZoneProtocolListener) {
        if (qZoneRequest == null) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "request is null");
            return 1000004;
        }
        qZoneRequest.setListner(iQZoneProtocolListener);
        if (qZoneRequest instanceof QzoneUploadRequest) {
            ((QzoneUploadRequest) qZoneRequest).upload(LoginData.getInstance().getA2Bytes());
            return 0;
        }
        qZoneRequest.startTime = System.currentTimeMillis();
        try {
            QZoneIntent qZoneIntent = new QZoneIntent(BaseApplication.getContext(), QZoneServlet.class);
            qZoneIntent.setWithouLogin(true);
            QZoneTask qZoneTask = (QZoneTask) iQZoneProtocolListener;
            qZoneIntent.f46120d = qZoneTask;
            if (qZoneTask != null && qZoneTask.mRequest != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QZLog.e(QZLog.TO_DEVICE_TAG, "app is null,try get app by getQZoneRuntime");
                    peekAppRuntime = LoginData.getInstance().getQZoneRuntime();
                }
                if (peekAppRuntime != null) {
                    peekAppRuntime.startServlet(qZoneIntent);
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "cmd=" + qZoneRequest.getRequestCmd() + ", pkgId=" + qZoneRequest.getRequestPkgId() + " | submit to MSF, isLogin: " + peekAppRuntime.isLogin() + " | app = " + peekAppRuntime);
                    return 0;
                }
                QZLog.e(QZLog.TO_DEVICE_TAG, "app is null");
                return 0;
            }
            return 1000004;
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "QZoneProtocolService occur exception. stack=" + QZLog.getStackTraceString(e16));
            return 0;
        }
    }
}
