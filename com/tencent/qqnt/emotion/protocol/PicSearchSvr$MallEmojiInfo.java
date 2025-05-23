package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes24.dex */
public final class PicSearchSvr$MallEmojiInfo extends MessageMicro<PicSearchSvr$MallEmojiInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"mall_emoji_pack_id", "mall_emoji_pic_id"}, new Object[]{0, ""}, PicSearchSvr$MallEmojiInfo.class);
    public final PBUInt32Field mall_emoji_pack_id = PBField.initUInt32(0);
    public final PBStringField mall_emoji_pic_id = PBField.initString("");
}
