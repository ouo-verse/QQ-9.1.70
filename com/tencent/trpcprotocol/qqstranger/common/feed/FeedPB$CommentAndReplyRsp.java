package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$CommentAndReplyRsp extends MessageMicro<FeedPB$CommentAndReplyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 34}, new String[]{"ret_code", "msg", "id"}, new Object[]{0, "", ""}, FeedPB$CommentAndReplyRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381603msg = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381602id = PBField.initString("");
}
