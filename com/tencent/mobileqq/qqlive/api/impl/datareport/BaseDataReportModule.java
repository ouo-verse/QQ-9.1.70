package com.tencent.mobileqq.qqlive.api.impl.datareport;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.data.datareport.CommonReportData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import ft3.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BaseDataReportModule extends IQQLiveBaseModule implements IDataReportModule {
    static IPatchRedirector $redirector_;
    private volatile CommonReportData commonReportData;
    private final long enterRoomStamp;

    public BaseDataReportModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.enterRoomStamp = NetConnInfoCenter.getServerTimeMillis();
        }
    }

    private void addCommonReportData(c cVar) {
        cVar.addKeyValue("appid", this.commonReportData.getAppId()).addKeyValue("commid", this.commonReportData.getCommid()).addKeyValue("roomid", this.commonReportData.getRoomId()).addKeyValue("programid", this.commonReportData.getProgramId()).addKeyValue("uid", this.commonReportData.getUid()).addKeyValue("testid", this.commonReportData.getTestId()).addKeyValue("expgrpid", this.commonReportData.getExpgrpid()).addKeyValue(TPReportKeys.LiveExKeys.LIVE_EX_DEV_TYPE, this.commonReportData.getReportDevType());
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        super.init(iQQLiveSDK);
        this.commonReportData = new CommonReportData(iQQLiveSDK.getAppId());
        this.commonReportData.setEnterRoomTime(this.enterRoomStamp);
        ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).init();
    }

    @Override // com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule
    public c newReportTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        c newReportTask = ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).newReportTask();
        addCommonReportData(newReportTask);
        return newReportTask;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule
    public void setLoginInfo(LoginInfo loginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) loginInfo);
        } else {
            this.commonReportData.setLoginInfo(loginInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule
    public void setRoomInfo(BaseRoomInfo baseRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseRoomInfo);
        } else {
            this.commonReportData.setRoomInfo(baseRoomInfo);
        }
    }
}
