package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_submit_homework$HwCommentInfo extends MessageMicro<hw_submit_homework$HwCommentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 32, 40, 48}, new String[]{"id", "text", "createts", "modifyts", "uin"}, new Object[]{"", ByteStringMicro.EMPTY, 0L, 0L, 0L}, hw_submit_homework$HwCommentInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342203id = PBField.initString("");
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createts = PBField.initUInt64(0);
    public final PBUInt64Field modifyts = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
