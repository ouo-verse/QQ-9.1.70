package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$GetWindowsControlReq extends MessageMicro<Security$GetWindowsControlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"source", "window_item_ids"}, new Object[]{"", 0}, Security$GetWindowsControlReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBRepeatField<Integer> window_item_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
