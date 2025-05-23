package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$SortOption extends MessageMicro<ECSampleData$SortOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sort_column", "asc"}, new Object[]{0, Boolean.FALSE}, ECSampleData$SortOption.class);
    public final PBEnumField sort_column = PBField.initEnum(0);
    public final PBBoolField asc = PBField.initBool(false);
}
