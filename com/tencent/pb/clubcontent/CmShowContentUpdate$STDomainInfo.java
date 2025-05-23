package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CmShowContentUpdate$STDomainInfo extends MessageMicro<CmShowContentUpdate$STDomainInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"domain_id", "url"}, new Object[]{0, ByteStringMicro.EMPTY}, CmShowContentUpdate$STDomainInfo.class);
    public final PBInt32Field domain_id = PBField.initInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
}
