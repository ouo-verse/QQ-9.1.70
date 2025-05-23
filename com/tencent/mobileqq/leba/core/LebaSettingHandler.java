package com.tencent.mobileqq.leba.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaSettingHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public AppInterface f240361d;

    /* renamed from: e, reason: collision with root package name */
    public i f240362e;

    public LebaSettingHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f240362e = new i();
            this.f240361d = appInterface;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.leba.observer.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (!fromServiceMsg.getServiceCmd().equals(RedTouchConst.Cmd.CMD_RED_TOUCH_ENTRANCE_SETTING) || !fromServiceMsg.isSuccess()) {
            return;
        }
        BusinessInfoCheckUpdate.ReportRspBody reportRspBody = new BusinessInfoCheckUpdate.ReportRspBody();
        try {
            reportRspBody = reportRspBody.mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            reportRspBody.code.set(-1);
            reportRspBody.errmsg.set("prb.mergeFrom exception");
            e16.printStackTrace();
        }
        if (reportRspBody.code.get() == 0) {
            int i17 = reportRspBody.appid.get();
            try {
                try {
                    JSONObject jSONObject = new JSONObject(reportRspBody.buffer.get());
                    if (jSONObject.getInt("cmd") == 4) {
                        boolean z16 = jSONObject.getBoolean("setting");
                        long j17 = jSONObject.getLong("modify_ts");
                        long j18 = jSONObject.getLong("server_ts");
                        if (j17 != j18 && j18 > 0) {
                            ILebaHelperService iLebaHelperService = (ILebaHelperService) this.f240361d.getRuntimeService(ILebaHelperService.class, "");
                            if (iLebaHelperService != null) {
                                j3 = j18;
                                j16 = j17;
                                iLebaHelperService.updateAppSetting(this.f240361d, i17, z16, j17, j3);
                            } else {
                                j3 = j18;
                                j16 = j17;
                                try {
                                    QLog.d("LebaSettingHandler", 1, "onReceive lebaHelperService == null");
                                } catch (Exception e17) {
                                    e = e17;
                                    i16 = 1;
                                    i3 = 0;
                                    QLog.e("LebaSettingHandler", i16, e, new Object[i3]);
                                }
                            }
                        } else {
                            j3 = j18;
                            j16 = j17;
                        }
                        try {
                            QLog.i("LebaSettingHandler", 1, " onReceiver, [" + i17 + "," + z16 + "," + j16 + "," + j3 + "]");
                            notifyUI(2, true, Boolean.valueOf(z16));
                        } catch (Exception e18) {
                            e = e18;
                            i16 = 1;
                            i3 = 0;
                            QLog.e("LebaSettingHandler", i16, e, new Object[i3]);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("LebaSettingHandler", 1, th5, new Object[0]);
                }
            } catch (Exception e19) {
                e = e19;
                i3 = 0;
                i16 = 1;
            }
        }
    }
}
