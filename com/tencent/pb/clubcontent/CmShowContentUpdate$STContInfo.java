package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CmShowContentUpdate$STContInfo extends MessageMicro<CmShowContentUpdate$STContInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "item_id", "name", "ver"}, new Object[]{0, 0L, ByteStringMicro.EMPTY, 0}, CmShowContentUpdate$STContInfo.class);
    public final PBInt32Field biz_id = PBField.initInt32(0);
    public final PBInt64Field item_id = PBField.initInt64(0);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field ver = PBField.initInt32(0);
}
