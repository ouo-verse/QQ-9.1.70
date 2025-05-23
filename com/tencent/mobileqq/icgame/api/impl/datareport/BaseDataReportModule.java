package com.tencent.mobileqq.icgame.api.impl.datareport;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.datareport.IDataReportModule;
import com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.icgame.data.datareport.CommonReportData;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BaseDataReportModule extends IQQLiveBaseModule implements IDataReportModule {
    private volatile CommonReportData commonReportData;
    private final long enterRoomStamp = NetConnInfoCenter.getServerTimeMillis();

    @Override // com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        super.init(iQQLiveSDK);
        this.commonReportData = new CommonReportData(iQQLiveSDK.getAppId());
        this.commonReportData.setEnterRoomTime(this.enterRoomStamp);
    }

    @Override // com.tencent.mobileqq.icgame.api.datareport.IDataReportModule
    public void setLoginInfo(LoginInfo loginInfo) {
        this.commonReportData.setLoginInfo(loginInfo);
    }

    @Override // com.tencent.mobileqq.icgame.api.datareport.IDataReportModule
    public void setRoomInfo(BaseRoomInfo baseRoomInfo) {
        this.commonReportData.setRoomInfo(baseRoomInfo);
    }

    private void addCommonReportData() {
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
