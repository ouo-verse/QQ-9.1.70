package cooperation.qqcircle.report.outbox;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleClientReportRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import qqcircle.QQCircleReport$StDataReportRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleNetDetectHelper {
    private static final String TAG = "QCircleNetCheckHelper";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface DetectListener {
        void onDetectResult(boolean z16, long j3, String str);
    }

    public static void detectQCircleNetConnection(final DetectListener detectListener) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleClientReportRequest(new ArrayList()), new VSDispatchObserver.OnVSRspCallBack<QQCircleReport$StDataReportRsp>() { // from class: cooperation.qqcircle.report.outbox.QCircleNetDetectHelper.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp) {
                if ((!z16 || j3 != 0 || qQCircleReport$StDataReportRsp == null) && !TextUtils.isEmpty(str)) {
                    QLog.e(QCircleNetDetectHelper.TAG, 1, "detect net connection blocked retcode:" + j3 + ",error:" + str + ",traceId:" + baseRequest.getTraceId());
                }
                QLog.d(QCircleNetDetectHelper.TAG, 2, "detect net connection success!");
                DetectListener detectListener2 = DetectListener.this;
                if (detectListener2 != null) {
                    detectListener2.onDetectResult(z16, j3, str);
                }
            }
        });
    }
}
