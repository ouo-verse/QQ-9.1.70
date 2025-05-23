package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserInfo$QuestionAndAnswer extends MessageMicro<UserInfo$QuestionAndAnswer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "question", "answer"}, new Object[]{"", "", ""}, UserInfo$QuestionAndAnswer.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381600id = PBField.initString("");
    public final PBStringField question = PBField.initString("");
    public final PBStringField answer = PBField.initString("");
}
