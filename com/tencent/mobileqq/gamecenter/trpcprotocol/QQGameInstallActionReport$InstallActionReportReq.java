package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQGameInstallActionReport$InstallActionReportReq extends MessageMicro<QQGameInstallActionReport$InstallActionReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"pkg_name", "channel_id", VipFunCallConstants.KEY_LOCAL_VERSION}, new Object[]{"", "", 0}, QQGameInstallActionReport$InstallActionReportReq.class);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBInt32Field local_version = PBField.initInt32(0);
}
