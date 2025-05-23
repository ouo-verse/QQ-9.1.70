package com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes27.dex */
public final class SvipPrivilegeShowPB$ReportExposureReq extends MessageMicro<SvipPrivilegeShowPB$ReportExposureReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"exposure_time"}, new Object[]{0L}, SvipPrivilegeShowPB$ReportExposureReq.class);
    public final PBInt64Field exposure_time = PBField.initInt64(0);
}
