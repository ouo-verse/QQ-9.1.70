package com.tencent.pb.now;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* loaded from: classes22.dex */
public final class FeedsProtocol$VideoItem extends MessageMicro<FeedsProtocol$VideoItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field anchor_type;

    /* renamed from: id, reason: collision with root package name */
    public final PBBytesField f342132id;
    public final PBBytesField jump_url;
    public final PBUInt32Field live_duration_time;
    public final PBBytesField room_cover_url;
    public final PBBytesField room_name;
    public final PBRepeatMessageField<FeedsProtocol$RichTitleElement> rpt_msg_rich_title;
    public final PBUInt32Field total_money;
    public final PBUInt32Field total_view;
    public FeedsProtocol$UserInfo user_info;
    public final PBBytesField vid;
    public final PBBytesField video_cover_url;
    public final PBUInt32Field video_end_time;
    public final PBUInt64Field video_start_time;

    static {
        String[] strArr = {"id", "user_info", "vid", AudienceReportConst.ROOM_NAME, "rpt_msg_rich_title", "video_cover_url", "room_cover_url", "total_view", "total_money", QzoneCameraConst.Tag.ARG_PARAM_VIDEO_END_TIME, "jump_url", "anchor_type", QzoneCameraConst.Tag.ARG_PARAM_VIDEO_START_TIME, "live_duration_time"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 96, 104, 112}, strArr, new Object[]{byteStringMicro, null, byteStringMicro, byteStringMicro, null, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0L, 0}, FeedsProtocol$VideoItem.class);
    }

    public FeedsProtocol$VideoItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f342132id = PBField.initBytes(byteStringMicro);
        this.user_info = new FeedsProtocol$UserInfo();
        this.vid = PBField.initBytes(byteStringMicro);
        this.room_name = PBField.initBytes(byteStringMicro);
        this.rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol$RichTitleElement.class);
        this.video_cover_url = PBField.initBytes(byteStringMicro);
        this.room_cover_url = PBField.initBytes(byteStringMicro);
        this.total_view = PBField.initUInt32(0);
        this.total_money = PBField.initUInt32(0);
        this.video_end_time = PBField.initUInt32(0);
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.anchor_type = PBField.initUInt32(0);
        this.video_start_time = PBField.initUInt64(0L);
        this.live_duration_time = PBField.initUInt32(0);
    }
}
