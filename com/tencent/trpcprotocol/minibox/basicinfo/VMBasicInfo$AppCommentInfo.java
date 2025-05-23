package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$AppCommentInfo extends MessageMicro<VMBasicInfo$AppCommentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"avatar", "nick", "content"}, new Object[]{"", "", ""}, VMBasicInfo$AppCommentInfo.class);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
