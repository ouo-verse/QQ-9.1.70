package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFunCallAndRing$TSsoCmd0x1Rsp extends MessageMicro<VipFunCallAndRing$TSsoCmd0x1Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"u64_server_ver", "st_User_Info"}, new Object[]{0L, null}, VipFunCallAndRing$TSsoCmd0x1Rsp.class);
    public final PBUInt64Field u64_server_ver = PBField.initUInt64(0);
    public VipFunCallAndRing$TUserInfo st_User_Info = new VipFunCallAndRing$TUserInfo();
}
