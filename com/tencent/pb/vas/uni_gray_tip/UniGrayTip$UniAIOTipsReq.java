package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class UniGrayTip$UniAIOTipsReq extends MessageMicro<UniGrayTip$UniAIOTipsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"cmd", "from", "platInfo", "exInfo"}, new Object[]{0, null, null, ByteStringMicro.EMPTY}, UniGrayTip$UniAIOTipsReq.class);
    public final PBInt32Field cmd = PBField.initInt32(0);
    public UniGrayTip$FromChannel from = new UniGrayTip$FromChannel();
    public UniGrayTip$PlatformComm platInfo = new UniGrayTip$PlatformComm();
    public final PBBytesField exInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
