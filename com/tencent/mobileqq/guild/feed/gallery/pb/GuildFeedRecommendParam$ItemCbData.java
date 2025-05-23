package com.tencent.mobileqq.guild.feed.gallery.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes13.dex */
public final class GuildFeedRecommendParam$ItemCbData extends MessageMicro<GuildFeedRecommendParam$ItemCbData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"stat_data", "cb_ext_data"}, new Object[]{"", ByteStringMicro.EMPTY}, GuildFeedRecommendParam$ItemCbData.class);
    public final PBStringField stat_data = PBField.initString("");
    public final PBBytesField cb_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
