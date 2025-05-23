package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class preAuth$GuideInfo extends MessageMicro<preAuth$GuideInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{336}, new String[]{"allow_promote_page"}, new Object[]{Boolean.FALSE}, preAuth$GuideInfo.class);
    public final PBBoolField allow_promote_page = PBField.initBool(false);
}
