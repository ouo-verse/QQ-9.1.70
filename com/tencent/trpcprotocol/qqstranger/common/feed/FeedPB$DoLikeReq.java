package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$DoLikeReq extends MessageMicro<FeedPB$DoLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"oper_type", "feed_id", "poster_tid", "account_type"}, new Object[]{0, "", "", 0}, FeedPB$DoLikeReq.class);
    public final PBUInt32Field oper_type = PBField.initUInt32(0);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField poster_tid = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
}
