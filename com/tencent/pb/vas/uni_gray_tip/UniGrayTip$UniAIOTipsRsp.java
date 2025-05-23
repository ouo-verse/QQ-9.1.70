package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class UniGrayTip$UniAIOTipsRsp extends MessageMicro<UniGrayTip$UniAIOTipsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "msg", "exInfo"}, new Object[]{0L, "", ByteStringMicro.EMPTY}, UniGrayTip$UniAIOTipsRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342175msg = PBField.initString("");
    public final PBBytesField exInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
