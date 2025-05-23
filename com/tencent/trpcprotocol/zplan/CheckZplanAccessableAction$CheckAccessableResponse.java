package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CheckZplanAccessableAction$CheckAccessableResponse extends MessageMicro<CheckZplanAccessableAction$CheckAccessableResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"accessable_items", "req_gap_seconds"}, new Object[]{null, 0L}, CheckZplanAccessableAction$CheckAccessableResponse.class);
    public final PBRepeatMessageField<CheckZplanAccessableAction$AccessableItem> accessable_items = PBField.initRepeatMessage(CheckZplanAccessableAction$AccessableItem.class);
    public final PBUInt64Field req_gap_seconds = PBField.initUInt64(0);
}
