package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GetMobileDialogReq extends MessageMicro<GetMobileDialogReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"offset", "pageSize", "uin"}, new Object[]{0, 0, 0L}, GetMobileDialogReq.class);
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBInt32Field pageSize = PBField.initInt32(0);
    public final PBInt64Field uin = PBField.initInt64(0);
}
