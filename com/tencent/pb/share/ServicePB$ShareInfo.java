package com.tencent.pb.share;

import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ServicePB$ShareInfo extends MessageMicro<ServicePB$ShareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"busi_id", DittoImageArea.RESOURCE_ID, "template", "busi_data", "plat"}, new Object[]{"", "", "", ByteStringMicro.EMPTY, 0}, ServicePB$ShareInfo.class);
    public final PBStringField busi_id = PBField.initString("");
    public final PBStringField resource_id = PBField.initString("");
    public final PBStringField template = PBField.initString("");
    public final PBBytesField busi_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField plat = PBField.initEnum(0);
}
