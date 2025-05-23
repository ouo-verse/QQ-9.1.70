package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class FeedPB$Topic extends MessageMicro<FeedPB$Topic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"id", "name", "jump_url", "border"}, new Object[]{"", "", "", ""}, FeedPB$Topic.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381611id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField border = PBField.initString("");
}
