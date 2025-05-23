package com.tencent.mobileqq.qqlive.api.impl.room.voiceroom;

import com.tencent.mobileqq.qqlive.api.av.IAudioAbility;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/voiceroom/ITRTCAudioRoom;", "Lcom/tencent/mobileqq/qqlive/api/av/IAudioAbility;", "enterRoom", "", "params", "Lcom/tencent/mobileqq/qqlive/data/trtc/QQLiveRoomParams;", "exitRoom", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public interface ITRTCAudioRoom extends IAudioAbility {
    void enterRoom(@NotNull QQLiveRoomParams params);

    void exitRoom();
}
