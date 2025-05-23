package com.tencent.mobileqq.icgame.api.datareport;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IDataReportModule extends IQQLiveModule {
    void setLoginInfo(LoginInfo loginInfo);

    void setRoomInfo(BaseRoomInfo baseRoomInfo);
}
