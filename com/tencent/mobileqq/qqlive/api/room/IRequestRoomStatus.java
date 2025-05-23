package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\bJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", Const.BUNDLE_KEY_REQUEST, "", "roomId", "", "callback", "Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus$IRoomResult;", "IRoomResult", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IRequestRoomStatus extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus$IRoomResult;", "", "onResult", "", "roomId", "", "isLiving", "", "errCode", "", "errMsg", "", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public interface IRoomResult {
        void onResult(long roomId, boolean isLiving, int errCode, @Nullable String errMsg);
    }

    void request(long roomId, @Nullable IRoomResult callback);
}
