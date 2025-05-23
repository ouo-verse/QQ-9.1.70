package com.tencent.biz.richframework.network.resend;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.MobileQQVSNetworkImpl;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.Packet;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleResendIntercept {
    private static final String DEF_CMD_RESEND_WHITE_LIST = "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList|";
    private static final int DEF_RESEND_COUNT = 3;
    private static final String QCIRCLE_RESEND_NUM = "qcircle_resend_num";
    private static final String SPLIT_DIVISION = "\\|";
    private static final String TAG = "QCircleResendIntercept";

    public static int getResendMaxCount() {
        return o.B0(3);
    }

    public static String getResendWhiteList(String str) {
        return o.C0(str);
    }

    private boolean hitFastResend(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 2901) {
            return true;
        }
        return false;
    }

    private boolean isEnabledResend() {
        return o.L1();
    }

    private boolean isResendMaxCount(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getIntExtra(QCIRCLE_RESEND_NUM, 0) < getResendMaxCount()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isResendWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Arrays.asList(getResendWhiteList(DEF_CMD_RESEND_WHITE_LIST).split(SPLIT_DIVISION)).contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void handlerFastResend(Intent intent, FromServiceMsg fromServiceMsg) {
        if (intent == null || fromServiceMsg == null || !isEnabledResend()) {
            return;
        }
        try {
            BaseRequest baseRequest = (BaseRequest) intent.getSerializableExtra(VSBaseServlet.KEY_REQUEST);
            byte[] bArr = (byte[]) intent.getSerializableExtra("key_request_data");
            intent.putExtra(QCIRCLE_RESEND_NUM, intent.getIntExtra(QCIRCLE_RESEND_NUM, 0) + 1);
            new MobileQQVSNetworkImpl().sendRequest(baseRequest, bArr, null);
            QLog.d(TAG, 1, "[handlerFastResend] hashCode: " + baseRequest.getContextHashCode() + " | code: " + fromServiceMsg.getResultCode() + " | traceId: " + baseRequest.getTraceId() + " | cmd: " + fromServiceMsg.getServiceCmd());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[handlerFastResend] ex: ", th5);
        }
    }

    public boolean isNeedFastResend(Intent intent, FromServiceMsg fromServiceMsg) {
        if (hitFastResend(fromServiceMsg) && !isResendMaxCount(intent)) {
            return true;
        }
        return false;
    }

    public void updateFastResendFlag(BaseRequest baseRequest, Packet packet) {
        ToServiceMsg msg2;
        if (!isEnabledResend() || baseRequest == null) {
            return;
        }
        String str = baseRequest.get$cmd();
        if (!isResendWhiteList(str)) {
            return;
        }
        if (packet == null) {
            msg2 = null;
        } else {
            msg2 = packet.toMsg();
        }
        if (msg2 == null) {
            return;
        }
        packet.autoResend = true;
        msg2.setEnableFastResend(true);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 1, "[updateFastResendFlag] hashCode:" + baseRequest.getContextHashCode() + " | traceId: " + baseRequest.getTraceId() + " | cmd: " + str);
        }
    }
}
