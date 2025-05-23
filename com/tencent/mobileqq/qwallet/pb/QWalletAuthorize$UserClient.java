package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$UserClient extends MessageMicro<QWalletAuthorize$UserClient> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"device_type", "device_id", AudienceReportConst.CLIENT_TYPE, "cellular_network_ip", "user_ip"}, new Object[]{0, "", 0, "", ""}, QWalletAuthorize$UserClient.class);
    public final PBEnumField device_type = PBField.initEnum(0);
    public final PBStringField device_id = PBField.initString("");
    public final PBEnumField client_type = PBField.initEnum(0);
    public final PBStringField cellular_network_ip = PBField.initString("");
    public final PBStringField user_ip = PBField.initString("");
}
