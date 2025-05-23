package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$AnchorInfo extends MessageMicro<NowQQLiveFocusProto$AnchorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 58, 64, 74, 82, 90, 98, 104, 112, 120}, new String[]{"uin", AudienceReportConst.ROOM_ID, "start_time", "cover_url", "audience_sum", "jump_url", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "user_type", "room_city", "anchor_logo_url", AudienceReportConst.ROOM_NAME, "medal_info_list", "cover_ts", "type", "content_type"}, new Object[]{0L, 0, 0, "", 0, "", "", 0, "", "", "", null, 0, 0, 0}, NowQQLiveFocusProto$AnchorInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBStringField cover_url = PBField.initString("");
    public final PBUInt32Field audience_sum = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField nick_name = PBField.initString("");
    public final PBUInt32Field user_type = PBField.initUInt32(0);
    public final PBStringField room_city = PBField.initString("");
    public final PBStringField anchor_logo_url = PBField.initString("");
    public final PBStringField room_name = PBField.initString("");
    public final PBRepeatMessageField<NowQQLiveFocusProto$MedalInfo> medal_info_list = PBField.initRepeatMessage(NowQQLiveFocusProto$MedalInfo.class);
    public final PBUInt32Field cover_ts = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field content_type = PBField.initUInt32(0);
}
