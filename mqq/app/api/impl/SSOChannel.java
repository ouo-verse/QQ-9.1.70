package mqq.app.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.SSORequest;
import mqq.app.api.SSOResponse;
import mqq.app.api.SSOResultCallback;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SSOChannel implements BusinessObserver {
    private static final String KEY_REQUEST_SEQ = "FLUTTER_REQUEST_SEQ";
    private static final String KEY_REQUEST_TIME = "REQUEST_TIME";
    public static final AtomicInteger REQ_FACTORY = new AtomicInteger();
    private static final String TAG = ".SSOChannel";
    private Map<Integer, SSOResultCallback> mResultMethodCache = new HashMap();

    private void notifyFlutterResult(final String str, final SSOResponse sSOResponse, final SSOResultCallback sSOResultCallback) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: mqq.app.api.impl.SSOChannel.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (QLog.isColorLevel()) {
                    SSOResponse sSOResponse2 = sSOResponse;
                    if (sSOResponse2 != null) {
                        z16 = sSOResponse2.isSuc.booleanValue();
                    } else {
                        z16 = false;
                    }
                    QLog.d(SSOChannel.TAG, 2, String.format("notifyResult, cmd: %s, isSuc: %s", str, Boolean.valueOf(z16)));
                }
                sSOResultCallback.callback(sSOResponse);
            }
        });
    }

    public void doSendRequest(SSORequest sSORequest, SSOResultCallback sSOResultCallback) {
        if (sSORequest != null && sSOResultCallback != null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            int incrementAndGet = REQ_FACTORY.incrementAndGet();
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", waitAppRuntime.getAccount(), sSORequest.cmd);
            if (sSORequest.timeout != null) {
                toServiceMsg.setTimeout(r5.intValue() * 1000);
            }
            toServiceMsg.extraData.putLong(KEY_REQUEST_TIME, System.currentTimeMillis());
            toServiceMsg.extraData.putInt(KEY_REQUEST_SEQ, incrementAndGet);
            this.mResultMethodCache.put(Integer.valueOf(incrementAndGet), sSOResultCallback);
            toServiceMsg.putWupBuffer(sSORequest.body);
            NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, SSOEasyServlet.class);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            newIntent.setObserver(this);
            waitAppRuntime.startServlet(newIntent);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("send request cmd: %s, request seq: %s", sSORequest.cmd, Integer.valueOf(incrementAndGet)));
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "send request, packet == null or result == null");
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        SSOResponse sSOResponse = new SSOResponse();
        if (bundle == null) {
            QLog.e(TAG, 1, "onReceive, bundle == null");
            return;
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) bundle.getParcelable(ToServiceMsg.class.getSimpleName());
        SSOResultCallback remove = this.mResultMethodCache.remove(Integer.valueOf(toServiceMsg.extraData.getInt(KEY_REQUEST_SEQ)));
        FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(FromServiceMsg.class.getSimpleName());
        if (fromServiceMsg == null) {
            QLog.e(TAG, 1, "request == null || response == null");
            notifyFlutterResult(toServiceMsg.getServiceCmd(), sSOResponse, remove);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - toServiceMsg.extraData.getLong(KEY_REQUEST_TIME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errCode: %s", toServiceMsg.getServiceCmd(), Integer.valueOf(toServiceMsg.getAppSeq()), Long.valueOf(currentTimeMillis), Integer.valueOf(fromServiceMsg.getResultCode())));
        }
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        sSOResponse.isSuc = Boolean.valueOf(fromServiceMsg.isSuccess());
        sSOResponse.errCode = Integer.valueOf(fromServiceMsg.getResultCode());
        sSOResponse.body = wupBuffer;
        notifyFlutterResult(toServiceMsg.getServiceCmd(), sSOResponse, remove);
    }
}
