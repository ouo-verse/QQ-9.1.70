package com.tencent.mobileqq.transfile.ptt;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.proto.IProtoReqStrategy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* loaded from: classes19.dex */
public class PttProtoReqStrategy implements IProtoReqStrategy {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PttProtoReqStrategy";

    public PttProtoReqStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private QQAppInterface getQQAppinterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.proto.IProtoReqStrategy
    public void updateIntent(NewIntent newIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newIntent);
            return;
        }
        QQAppInterface qQAppinterface = getQQAppinterface();
        if (qQAppinterface != null && ((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).doesSupportHttpSideWay(qQAppinterface)) {
            newIntent.putExtra(ProtoServlet.QUICK_SEND_ENABLE, true);
            newIntent.putExtra(ProtoServlet.QUICK_SEND_STRATEGY, 1);
            if (QLog.isColorLevel()) {
                QLog.d("http_sideway", 2, "set");
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.proto.IProtoReqStrategy
    public void updateReq(ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoReq);
            return;
        }
        if (protoReq.ssoCmd.equals(RichMediaConstants.CMD_LONGCONN_GROUPPTT_UP) || protoReq.ssoCmd.equals(RichMediaConstants.CMD_TEMP_PTT_UPLOAD)) {
            QQAppInterface qQAppinterface = getQQAppinterface();
            if (getQQAppinterface() != null) {
                protoReq.tryTime = ((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).getTryTime_dpc(qQAppinterface);
                protoReq.tryCount = ((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).getTryCount_dpc(qQAppinterface);
                protoReq.fixScheduleCount = ((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).getFixScheduleTryCount_dpc(qQAppinterface);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "ptt config from dpc:" + protoReq.tryTime + protoReq.tryCount + protoReq.fixScheduleCount);
                }
            }
        }
    }
}
