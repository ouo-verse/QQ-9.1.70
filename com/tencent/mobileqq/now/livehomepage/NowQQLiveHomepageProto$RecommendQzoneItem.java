package com.tencent.mobileqq.now.livehomepage;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RecommendQzoneItem extends MessageMicro<NowQQLiveHomepageProto$RecommendQzoneItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uid", INetChannelCallback.KEY_TINY_ID, "enter_room_id", "start_time"}, new Object[]{0L, 0L, "", 0L}, NowQQLiveHomepageProto$RecommendQzoneItem.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField enter_room_id = PBField.initString("");
    public final PBUInt64Field start_time = PBField.initUInt64(0);
}
