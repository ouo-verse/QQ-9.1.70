package com.tencent.mobileqq.qqlive.api.datareport;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import ft3.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IDataReportModule extends IQQLiveModule {
    c newReportTask();

    void setLoginInfo(LoginInfo loginInfo);

    void setRoomInfo(BaseRoomInfo baseRoomInfo);
}
