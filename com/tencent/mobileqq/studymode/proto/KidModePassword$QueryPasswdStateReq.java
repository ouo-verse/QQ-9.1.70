package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$QueryPasswdStateReq extends MessageMicro<KidModePassword$QueryPasswdStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"acct_type", "account", "scene_id"}, new Object[]{0, "", 0}, KidModePassword$QueryPasswdStateReq.class);
    public final PBEnumField acct_type = PBField.initEnum(0);
    public final PBStringField account = PBField.initString("");
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
}
