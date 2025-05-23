package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ExpeDataAcc$AccountInfo extends MessageMicro<ExpeDataAcc$AccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"uid", "openId", "accountType", "toUid"}, new Object[]{"", "", 0L, ""}, ExpeDataAcc$AccountInfo.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField openId = PBField.initString("");
    public final PBInt64Field accountType = PBField.initInt64(0);
    public final PBStringField toUid = PBField.initString("");
}
