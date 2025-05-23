package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$TacitFAQ extends MessageMicro<userInfo$TacitFAQ> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64}, new String[]{"id", "type", "question", "tag", "answer", "options", "status", "created_at"}, new Object[]{0, 0, "", null, 0, "", 0, 0L}, userInfo$TacitFAQ.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f381583id = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField question = PBField.initString("");
    public userInfo$Tag tag = new userInfo$Tag();
    public final PBUInt32Field answer = PBField.initUInt32(0);
    public final PBRepeatField<String> options = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field created_at = PBField.initInt64(0);
}
