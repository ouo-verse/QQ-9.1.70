package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class TroopBaseHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, Pair<Long, Integer>> f296237d;

    public TroopBaseHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f296237d = null;
        }
    }

    public void E2(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d(getTag(), 2, "sendPbRequest. request is null.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, "sendPbRequest. cmd=" + toServiceMsg.getServiceCmd());
        }
        sendPbReq(toServiceMsg);
    }

    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void send(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!TextUtils.isEmpty(getTag())) {
            toServiceMsg.extraData.putString("REQ_TAG", getTag());
        }
        super.send(toServiceMsg);
        D2(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void sendPbReq(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!TextUtils.isEmpty(getTag())) {
            toServiceMsg.extraData.putString("REQ_TAG", getTag());
        }
        super.sendPbReq(toServiceMsg);
        D2(toServiceMsg);
    }

    private void D2(ToServiceMsg toServiceMsg) {
    }
}
