package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.AdminListCallback;
import com.tencent.mobileqq.qqlive.callback.room.IsAdminCallback;
import com.tencent.mobileqq.qqlive.callback.room.SetAdminCallback;
import ki2.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveRoomAdmin extends IQQLiveModule {
    public static final int ERR_CODE_IS_BEEN_SET_ADMIN = 10012;
    public static final int ERR_CODE_NOT_HAVE_ADMIN = 999;

    void addAdminStatusListener(a aVar);

    void getAdminListByAnchorUid(long j3, long j16, AdminListCallback adminListCallback);

    void isAdmin(long j3, long j16, long j17, IsAdminCallback isAdminCallback);

    void removeAdminStatusListener(a aVar);

    void setAdminState(long j3, long j16, long j17, boolean z16, SetAdminCallback setAdminCallback);
}
