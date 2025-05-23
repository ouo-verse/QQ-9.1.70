package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$GetUserFeedListReq extends MessageMicro<FeedPB$GetUserFeedListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"user_id", "account_type", "count", "cookies", AudienceReportConst.ANCHOR_ID}, new Object[]{"", 0, 0, ByteStringMicro.EMPTY, ""}, FeedPB$GetUserFeedListReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField anchor_id = PBField.initString("");
}
