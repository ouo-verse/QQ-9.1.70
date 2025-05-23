package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$StImage extends MessageMicro<FeedPB$StImage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 32}, new String[]{"url", "high", "width"}, new Object[]{"", 0, 0}, FeedPB$StImage.class);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field high = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
}
