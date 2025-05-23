package com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class SvipPrivilegeShowPB$SetPrivilegeRsp extends MessageMicro<SvipPrivilegeShowPB$SetPrivilegeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "msg"}, new Object[]{0, ""}, SvipPrivilegeShowPB$SetPrivilegeRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381643msg = PBField.initString("");
}
