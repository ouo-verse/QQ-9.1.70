package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CheckZplanAccessableAction$AccessableItem extends MessageMicro<CheckZplanAccessableAction$AccessableItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "appid_results", "appid_detail_results"}, new Object[]{0L, ByteStringMicro.EMPTY, null}, CheckZplanAccessableAction$AccessableItem.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBytesField appid_results = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<CheckZplanAccessableAction$DetailResult> appid_detail_results = PBField.initRepeatMessage(CheckZplanAccessableAction$DetailResult.class);
}
