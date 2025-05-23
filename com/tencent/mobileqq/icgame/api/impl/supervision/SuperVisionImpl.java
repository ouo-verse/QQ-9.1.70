package com.tencent.mobileqq.icgame.api.impl.supervision;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
abstract class SuperVisionImpl extends IQQLiveBaseModule {
    private static final String GET_ADMIN_REASON_LIST_METHOD = "AdminMenuList";
    public static final String SERVICE_NAME = "trpc.qlive.room_admin_svr.RoomAdminSvr";
    private static final String TAG = "ICGameSuperVisionImpl";
    protected List<AdminReason> reasonList = new ArrayList();

    public abstract int getReasonFlag();

    @Override // com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        super.init(iQQLiveSDK);
    }
}
