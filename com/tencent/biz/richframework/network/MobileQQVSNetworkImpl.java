package com.tencent.biz.richframework.network;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.delegate.VSBaseNetwork;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICForwardRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.network.request.VSNetQUICExp;
import com.tencent.biz.richframework.network.request.VSNetQUICFailStat;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import cooperation.qzone.QUA;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MobileQQVSNetworkImpl extends VSBaseNetwork {
    private static final String TAG = "MobileQQVSNetworkImpl";
    private static volatile String mCurrentAccount;

    private boolean requestWithQUIC(BaseRequest baseRequest) {
        boolean z16 = false;
        if (!VSNetQUICExp.isEnabledQUICNetReq() || VSNetQUICExp.isBlackSDKVersion()) {
            return false;
        }
        if (VSNetQUICFailStat.instance().isFailUpperLimit()) {
            QLog.d(TAG, 1, "[requestWithQUIC] current is quic fail max, end flow.");
            return false;
        }
        if (baseRequest instanceof VSBaseRequest) {
            VSBaseRequest vSBaseRequest = (VSBaseRequest) baseRequest;
            String serviceName = vSBaseRequest.getServiceName();
            String methodName = vSBaseRequest.getMethodName();
            if (!TextUtils.isEmpty(serviceName) && !TextUtils.isEmpty(methodName)) {
                z16 = true;
            }
            String str = vSBaseRequest.get$cmd();
            if (!TextUtils.isEmpty(serviceName) && !TextUtils.isEmpty(methodName)) {
                QLog.d(TAG, 1, "[requestWithQUIC] :" + str + " |serviceName:" + serviceName + " |method:" + methodName + " |result:" + z16);
            } else {
                QLog.d(TAG, 2, "[requestWithQUIC] current server name or method is empty, not quic req.");
            }
        }
        return z16;
    }

    private void sendByQUIC(VSBaseRequest vSBaseRequest, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[4];
        }
        new VSNetLightQUICForwardRequest(vSBaseRequest).setEncodeData(bArr).startRequest();
    }

    @Override // com.tencent.biz.richframework.network.delegate.VSBaseNetwork
    public String getAccountId() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "[getAccountId] app runtime should not be null.");
            return "";
        }
        return peekAppRuntime.getAccount();
    }

    @Override // com.tencent.biz.richframework.network.delegate.VSBaseNetwork
    public String getQUA() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.biz.richframework.network.delegate.VSBaseNetwork
    public boolean isValidLog(String str) {
        if (str != null && !str.endsWith(".DataReport")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.network.delegate.VSBaseNetwork
    public boolean needReinitialize() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "[needReinitialize] app runtime should not be null.");
            return false;
        }
        if (TextUtils.isEmpty(mCurrentAccount)) {
            mCurrentAccount = peekAppRuntime.getAccount();
        }
        String account = peekAppRuntime.getAccount();
        if (mCurrentAccount == null || mCurrentAccount.equals(account)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.network.delegate.VSBaseNetwork
    public void onInit() {
        QCircleInvokeProxy.invoke(1, 1, new Object[0]);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            mCurrentAccount = peekAppRuntime.getAccount();
        } else {
            QLog.e(TAG, 1, "[onInit] app runtime should not be null.");
        }
    }

    @Override // com.tencent.biz.richframework.network.delegate.VSBaseNetwork
    public void onRelease() {
        QCircleInvokeProxy.invoke(2, 1, new Object[0]);
        QCircleReportOutboxTaskQueue.getInstance().resetTaskList();
        mCurrentAccount = null;
    }

    @Override // com.tencent.biz.richframework.network.delegate.VSBaseNetwork
    public void sendRequest(BaseRequest baseRequest, byte[] bArr, VSNetworkHelper.OnReceivedCall onReceivedCall) {
        if (requestWithQUIC(baseRequest)) {
            QLog.e(TAG, 1, "[sendRequest] by quic:" + baseRequest.getTraceId());
            sendByQUIC((VSBaseRequest) baseRequest, bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), VSBaseServlet.class);
        if (baseRequest instanceof VSBaseRequest) {
            newIntent.withouLogin = ((VSBaseRequest) baseRequest).isWithouLogin().booleanValue();
        }
        newIntent.putExtra("key_request_data", bArr);
        newIntent.putExtra(VSBaseServlet.KEY_REQUEST, baseRequest);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "[sendRequest] app runtime should not be null.");
        } else {
            peekAppRuntime.startServlet(newIntent);
        }
    }
}
