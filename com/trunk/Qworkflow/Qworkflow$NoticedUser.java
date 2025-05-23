package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$NoticedUser extends MessageMicro<Qworkflow$NoticedUser> {
    public static final int ACCEPTED = 2;
    public static final int UNHANDLED = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_uin", "msg_user_source", "enum_handle_state"}, new Object[]{0L, null, 1}, Qworkflow$NoticedUser.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public Qworkflow$UserSource msg_user_source = new Qworkflow$UserSource();
    public final PBEnumField enum_handle_state = PBField.initEnum(1);
}
