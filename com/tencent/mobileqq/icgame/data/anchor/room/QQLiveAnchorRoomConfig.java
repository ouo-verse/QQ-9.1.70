package com.tencent.mobileqq.icgame.data.anchor.room;

import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomBizData;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveAnchorRoomConfig {
    public PlayerConfig playerConfig = new PlayerConfig();
    public RoomType roomType = RoomType.LIVE;
    public boolean openAudio = true;
    public boolean cameraMirror = false;
    public boolean enableVolumeEvaluation = false;
    public String customVerifyUrl = "";
    public QQLiveAnchorStreamRecordType streamRecordType = QQLiveAnchorStreamRecordType.CAMERA;
    public QQLiveAnchorRoomBizData bizData = new QQLiveAnchorRoomBizData(false);
    public int audioVolumeEvaluation = 200;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public enum RoomType {
        LIVE
    }
}
