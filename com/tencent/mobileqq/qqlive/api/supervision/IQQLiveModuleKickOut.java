package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryKickOutHistoryCallback;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import java.util.List;
import ki2.b;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveModuleKickOut extends IQQLiveModule {
    void addKickedOutOfRoomListener(b bVar);

    void cancelKickOutUser(long j3, long j16, long j17, KickOutUserCallback kickOutUserCallback);

    List<AdminReason> getKickOutReasonList();

    void kickOutUser(long j3, long j16, long j17, int i3, KickOutUserCallback kickOutUserCallback);

    void queryKickOutHistory(long j3, int i3, int i16, QueryKickOutHistoryCallback queryKickOutHistoryCallback);

    void removeKickedOutOfRoomListener(b bVar);
}
