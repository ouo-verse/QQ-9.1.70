package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSSOCmdObserver implements BusinessObserver {
    private static final Map<Integer, MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal<? extends MessageMicro>> CALLBACK_MAP = new ConcurrentHashMap();
    private static final MiniAppSSOCmdObserver OBSERVER = new MiniAppSSOCmdObserver();
    private static final String TAG = "MiniAppSSOCmdObserver";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MiniAppSSOCmdObserver defaultObserver() {
        return OBSERVER;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (z16) {
            FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("msg");
            if (fromServiceMsg != null) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                try {
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal<? extends MessageMicro> remove = CALLBACK_MAP.remove(Integer.valueOf((int) stQWebRsp.Seq.get()));
                    if (remove != null) {
                        boolean z17 = false;
                        if (remove.getResponseClass() != null) {
                            MessageMicro messageMicro = (MessageMicro) remove.getResponseClass().newInstance();
                            messageMicro.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                            if (fromServiceMsg.isSuccess() && stQWebRsp.retCode.get() == 0 && stQWebRsp.busiBuff.get().size() > 0) {
                                z17 = true;
                            }
                            remove.onReceived(z17, messageMicro);
                            return;
                        }
                        QLog.e(TAG, 2, "onReceive", " cmdCallback target class must provided");
                        return;
                    }
                    QLog.e(TAG, 2, "onReceive no cmdCallback for " + stQWebRsp.Seq.get());
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "onReceive", e16);
                    return;
                }
            }
            return;
        }
        QLog.d(TAG, 2, "onReceive() called failed with: i = [" + i3 + "], b = [" + z16 + "], bundle = [" + bundle + "]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendSSOCmdRequest(String str, String str2, MessageMicro<?> messageMicro, MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal<?> miniAppCmdCallbackInternal) {
        try {
            NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), MiniAppSSOCmdServlet.class);
            int callbackIndex = MiniAppCmdUtil.getCallbackIndex();
            newIntent.putExtra(MiniAppCmdUtil.KEY_INDEX, callbackIndex);
            newIntent.putExtra("key_appid", str2);
            CALLBACK_MAP.put(Integer.valueOf(callbackIndex), miniAppCmdCallbackInternal);
            newIntent.putExtra("key_data", messageMicro.toByteArray());
            newIntent.putExtra(MiniAppAbstractServlet.KEY_CMD_NAME, str);
            newIntent.setObserver(defaultObserver());
            BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "sendSSOCmdRequest ", th5);
        }
    }
}
