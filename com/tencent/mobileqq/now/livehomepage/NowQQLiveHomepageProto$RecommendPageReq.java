package com.tencent.mobileqq.now.livehomepage;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RecommendPageReq extends MessageMicro<NowQQLiveHomepageProto$RecommendPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 82, 90, 96}, new String[]{"uint32_last_update", "uint32_index", "uint32_count", "is_need_banner_topic", "user_msg_info", "rcmd_col_mode", WadlProxyConsts.CHANNEL, "union_channel", "is_no_public_room", "device_id", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "uin"}, new Object[]{0, 0, 0, 0, null, 0, "", "", 0, "", "", 0L}, NowQQLiveHomepageProto$RecommendPageReq.class);
    public final PBUInt32Field uint32_last_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field is_need_banner_topic = PBField.initUInt32(0);
    public final PBRepeatMessageField<NowQQLiveHomepageProto$UserMsgInfo> user_msg_info = PBField.initRepeatMessage(NowQQLiveHomepageProto$UserMsgInfo.class);
    public final PBUInt32Field rcmd_col_mode = PBField.initUInt32(0);
    public final PBStringField channel = PBField.initString("");
    public final PBStringField union_channel = PBField.initString("");
    public final PBUInt32Field is_no_public_room = PBField.initUInt32(0);
    public final PBStringField device_id = PBField.initString("");
    public final PBStringField qimei = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
