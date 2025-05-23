package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$WebviewWhiteListRequset extends MessageMicro<mobileqq_mp$WebviewWhiteListRequset> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"version", "qqversion", "gziped", "implat"}, new Object[]{"", "", Boolean.FALSE, 0}, mobileqq_mp$WebviewWhiteListRequset.class);
    public final PBStringField version = PBField.initString("");
    public final PBStringField qqversion = PBField.initString("");
    public final PBBoolField gziped = PBField.initBool(false);
    public final PBUInt32Field implat = PBField.initUInt32(0);
}
