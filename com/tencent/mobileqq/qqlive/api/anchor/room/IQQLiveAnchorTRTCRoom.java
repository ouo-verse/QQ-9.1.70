package com.tencent.mobileqq.qqlive.api.anchor.room;

import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamControl;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality;
import com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom;
import com.tencent.mobileqq.qqlive.report.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorTRTCRoom extends IQQLiveAnchorRoom, ILiveMediaRoom<FrameLayout>, IQQLiveModuleCamera, IQQLiveAnchorStreamControl, IQQLiveAnchorMediaControl, IQQLiveAnchorStreamQuality, IQQLiveAnchorRemoteControl {
    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);
}
