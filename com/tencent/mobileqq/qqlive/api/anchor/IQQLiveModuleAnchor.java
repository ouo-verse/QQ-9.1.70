package com.tencent.mobileqq.qqlive.api.anchor;

import android.content.Context;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveSetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveModuleAnchor extends IQQLiveModule {
    IQQLiveAnchorRoom createFastResumeRoom(QQLiveAnchorRecord qQLiveAnchorRecord, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback);

    IQQLiveAnchorPrepareWrapper createPrepareWrapper();

    IQQLiveAnchorRoom createRoom(Context context, QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback);

    void destroyRoom();

    IQQLiveAnchorRoom getCurRoom();

    void getRoomSetting(long j3, IQQLiveGetRoomSettingCallback iQQLiveGetRoomSettingCallback);

    QQLiveAnchorRecord getValidAnchorRecord(String str);

    void removeAnchorRecord(String str);

    void setRoomSetting(long j3, boolean z16, IQQLiveSetRoomSettingCallback iQQLiveSetRoomSettingCallback);

    int tryCloseIsolatedRoom(long j3, String str);
}
