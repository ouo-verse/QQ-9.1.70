package com.tencent.mobileqq.qqlive.callback.room.audience;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface LiveRoomStatusListener {
    void onRoomClose(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);

    void onRoomOpen(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);

    void onRoomPause(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);

    void onRoomResume(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);
}
