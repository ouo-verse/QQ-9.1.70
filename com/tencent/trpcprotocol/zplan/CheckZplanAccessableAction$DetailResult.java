package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CheckZplanAccessableAction$DetailResult extends MessageMicro<CheckZplanAccessableAction$DetailResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 80}, new String[]{"appid", "appid_exsit", "phone_pass", "uin_pass", "switch_pass", "setting_pass", "entrance_type", "all_pass"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0}, CheckZplanAccessableAction$DetailResult.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt32Field appid_exsit = PBField.initUInt32(0);
    public final PBUInt32Field phone_pass = PBField.initUInt32(0);
    public final PBUInt32Field uin_pass = PBField.initUInt32(0);
    public final PBUInt32Field switch_pass = PBField.initUInt32(0);
    public final PBUInt32Field setting_pass = PBField.initUInt32(0);
    public final PBEnumField entrance_type = PBField.initEnum(0);
    public final PBUInt32Field all_pass = PBField.initUInt32(0);
}
