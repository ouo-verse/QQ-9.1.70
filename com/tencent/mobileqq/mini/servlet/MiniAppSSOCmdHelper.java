package com.tencent.mobileqq.mini.servlet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSSOCmdHelper {
    private static final String TAG = "MiniAppSSOCmdHelper";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface MiniAppCmdCallback<RESPONSE extends MessageMicro<RESPONSE>> {
        void onReceived(boolean z16, RESPONSE response);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface MiniAppCmdCallbackInternal<RESPONSE extends MessageMicro<RESPONSE>> extends MiniAppCmdCallback<RESPONSE> {
        Class<? extends RESPONSE> getResponseClass();
    }

    MiniAppSSOCmdHelper() {
    }

    public static <REQUEST extends MessageMicro<REQUEST>, RESPONSE extends MessageMicro<RESPONSE>> void sendSSOCmdRequest(String str, String str2, REQUEST request, final Class<RESPONSE> cls, final MiniAppCmdCallback<RESPONSE> miniAppCmdCallback) {
        if (cls == null) {
            QLog.e(TAG, 2, "sendSSOCmdRequest response class is null, not send sso request for " + str);
            return;
        }
        MiniAppSSOCmdObserver.defaultObserver().sendSSOCmdRequest(str, str2, request, new MiniAppCmdCallbackInternal<RESPONSE>() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.1
            @Override // com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal
            public Class<? extends RESPONSE> getResponseClass() {
                return cls;
            }

            /* JADX WARN: Incorrect types in method signature: (ZTRESPONSE;)V */
            @Override // com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback
            public void onReceived(boolean z16, MessageMicro messageMicro) {
                MiniAppCmdCallback miniAppCmdCallback2 = MiniAppCmdCallback.this;
                if (miniAppCmdCallback2 != null) {
                    miniAppCmdCallback2.onReceived(z16, messageMicro);
                }
            }
        });
    }
}
