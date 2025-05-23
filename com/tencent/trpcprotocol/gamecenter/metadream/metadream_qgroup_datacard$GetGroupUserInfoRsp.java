package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$GetGroupUserInfoRsp extends MessageMicro<metadream_qgroup_datacard$GetGroupUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"user_profile", "jump_url", "switch_err", ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS}, new Object[]{null, "", 0, 0}, metadream_qgroup_datacard$GetGroupUserInfoRsp.class);
    public metadream_qgroup_datacard$UserProfile user_profile = new metadream_qgroup_datacard$UserProfile();
    public final PBStringField jump_url = PBField.initString("");
    public final PBEnumField switch_err = PBField.initEnum(0);
    public final PBEnumField switch_status = PBField.initEnum(0);
}
