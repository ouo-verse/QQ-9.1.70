package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class VIPRecommendPayHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195184d;

    protected VIPRecommendPayHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195184d = qQAppInterface;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return dl.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (TextUtils.isEmpty(serviceCmd)) {
                notifyUI(1, false, null);
                return;
            }
            if (serviceCmd.compareTo("VipPayLogicServer.getCommPayInfo ") == 0 && QLog.isColorLevel()) {
                QLog.i("VIPRecommendPayHandler", 2, "req---" + toServiceMsg + ",res----" + fromServiceMsg + ",data-----" + obj);
            }
            if (serviceCmd.compareTo("VipPayLogicServer.getCommPayInfo ") == 0) {
                notifyUI(1, true, obj);
                FileUtils.writeObject(this.f195184d.getCurrentAccountUin() + "_" + VasWebviewUtil.VIP_RECOMMEND_FILE_NAME, obj);
                return;
            }
            return;
        }
        notifyUI(1, false, null);
    }
}
