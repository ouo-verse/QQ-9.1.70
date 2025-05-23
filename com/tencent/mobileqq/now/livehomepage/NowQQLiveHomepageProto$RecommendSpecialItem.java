package com.tencent.mobileqq.now.livehomepage;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RecommendSpecialItem extends MessageMicro<NowQQLiveHomepageProto$RecommendSpecialItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uid", INetChannelCallback.KEY_TINY_ID, "string_room_img_url", "hall_room_id"}, new Object[]{0L, 0L, "", 0}, NowQQLiveHomepageProto$RecommendSpecialItem.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField string_room_img_url = PBField.initString("");
    public final PBUInt32Field hall_room_id = PBField.initUInt32(0);
}
