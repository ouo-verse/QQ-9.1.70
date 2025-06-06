package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetNavigationMenuConfigReqBody extends MessageMicro<mobileqq_qidian$GetNavigationMenuConfigReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_puin", "uint64_uin", "uint32_ver_no", "uint32_unread_msg_count", "uint32_is_click_graytip", "uint32_is_support_cc_nav"}, new Object[]{0L, 0L, 0, 0, 0, 0}, mobileqq_qidian$GetNavigationMenuConfigReqBody.class);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_msg_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_click_graytip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_support_cc_nav = PBField.initUInt32(0);
}
