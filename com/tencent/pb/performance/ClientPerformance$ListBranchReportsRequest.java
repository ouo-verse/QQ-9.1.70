package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class ClientPerformance$ListBranchReportsRequest extends MessageMicro<ClientPerformance$ListBranchReportsRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"app", "page", "size"}, new Object[]{0, 0, 0}, ClientPerformance$ListBranchReportsRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBInt32Field page = PBField.initInt32(0);
    public final PBInt32Field size = PBField.initInt32(0);
}
