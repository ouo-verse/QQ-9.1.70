package com.tencent.pb.now;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$RoomInfo extends MessageMicro<ilive_short_video_label$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64, 74, 82, 88, 98, 106, 112, 122, 130, 136, 146, 400, 408}, new String[]{AudienceReportConst.ROOM_ID, "subroom_id", "anchor_uin", "vid", AudienceReportConst.ROOM_NAME, "title_info", "total_people", "total_money", "room_cover_url_90", "video_cover_url", QzoneCameraConst.Tag.ARG_PARAM_VIDEO_END_TIME, "room_cover_url_640", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, QzoneCameraConst.Tag.ARG_PARAM_VIDEO_START_TIME, "anchor_logo_80", "anchor_logo_640", "total_record_people", "city", "video_end_action_svr_is_seted", "get_from_room_info_svr_is_seted"}, new Object[]{0, 0, 0L, "", "", null, 0, 0, "", "", 0, "", "", 0, "", "", 0, ByteStringMicro.EMPTY, 0, 0}, ilive_short_video_label$RoomInfo.class);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt32Field subroom_id = PBField.initUInt32(0);
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0);
    public final PBStringField vid = PBField.initString("");
    public final PBStringField room_name = PBField.initString("");
    public final PBRepeatMessageField<ilive_short_video_label$RichTitleElement> title_info = PBField.initRepeatMessage(ilive_short_video_label$RichTitleElement.class);
    public final PBUInt32Field total_people = PBField.initUInt32(0);
    public final PBUInt32Field total_money = PBField.initUInt32(0);
    public final PBStringField room_cover_url_90 = PBField.initString("");
    public final PBStringField video_cover_url = PBField.initString("");
    public final PBUInt32Field video_end_time = PBField.initUInt32(0);
    public final PBStringField room_cover_url_640 = PBField.initString("");
    public final PBStringField nick_name = PBField.initString("");
    public final PBUInt32Field video_start_time = PBField.initUInt32(0);
    public final PBStringField anchor_logo_80 = PBField.initString("");
    public final PBStringField anchor_logo_640 = PBField.initString("");
    public final PBUInt32Field total_record_people = PBField.initUInt32(0);
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_end_action_svr_is_seted = PBField.initUInt32(0);
    public final PBUInt32Field get_from_room_info_svr_is_seted = PBField.initUInt32(0);
}
