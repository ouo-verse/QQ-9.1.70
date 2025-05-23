package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qr4.c;
import qr4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/ISwitchRoomList;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "sdk", "Lqr4/c;", "req", "Lcom/tencent/mobileqq/qqlive/api/room/ISwitchRoomList$IRoomResult;", "callback", "", "fetchRoomList", "IRoomResult", "qq-live-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ISwitchRoomList extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/ISwitchRoomList$IRoomResult;", "", "Lqr4/d;", "rsp", "", "errCode", "", "errMsg", "", "onResult", "qq-live-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface IRoomResult {
        void onResult(@Nullable d rsp, int errCode, @Nullable String errMsg);
    }

    void fetchRoomList(@Nullable IQQLiveSDK sdk, @NotNull c req, @Nullable IRoomResult callback);
}
