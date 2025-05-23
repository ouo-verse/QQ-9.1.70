package com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes27.dex */
public final class SvipPrivilegeShowPB$SetPrivilegeItem extends MessageMicro<SvipPrivilegeShowPB$SetPrivilegeItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "item_id"}, new Object[]{0, 0}, SvipPrivilegeShowPB$SetPrivilegeItem.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field item_id = PBField.initInt32(0);
}
