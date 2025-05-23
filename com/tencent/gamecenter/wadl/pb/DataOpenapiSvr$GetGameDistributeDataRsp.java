package com.tencent.gamecenter.wadl.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class DataOpenapiSvr$GetGameDistributeDataRsp extends MessageMicro<DataOpenapiSvr$GetGameDistributeDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 72, 80, 88}, new String[]{"is_show_distribute", "appid", "download_url", "pkg_name", IProfileProtocolConst.KEY_COMPANY, "version", "privacy", "channel_id", "sub_new_version_result", "sub_result", "follow_result"}, new Object[]{Boolean.FALSE, "", "", "", "", "", "", "", 0, 0, 0}, DataOpenapiSvr$GetGameDistributeDataRsp.class);
    public final PBBoolField is_show_distribute = PBField.initBool(false);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField company = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField privacy = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBInt32Field sub_new_version_result = PBField.initInt32(0);
    public final PBInt32Field sub_result = PBField.initInt32(0);
    public final PBInt32Field follow_result = PBField.initInt32(0);
}
