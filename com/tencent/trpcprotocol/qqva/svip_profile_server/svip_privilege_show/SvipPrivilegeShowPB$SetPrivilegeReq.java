package com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class SvipPrivilegeShowPB$SetPrivilegeReq extends MessageMicro<SvipPrivilegeShowPB$SetPrivilegeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"privilege_items"}, new Object[]{null}, SvipPrivilegeShowPB$SetPrivilegeReq.class);
    public final PBRepeatMessageField<SvipPrivilegeShowPB$SetPrivilegeItem> privilege_items = PBField.initRepeatMessage(SvipPrivilegeShowPB$SetPrivilegeItem.class);
}
