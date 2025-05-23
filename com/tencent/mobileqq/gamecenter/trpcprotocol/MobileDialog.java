package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class MobileDialog extends MessageMicro<MobileDialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74, 80}, new String[]{"appid", "fromRoleID", "fromOpenID", "fromTinyID", "toRoleID", "toOpenID", "toTinyID", "time", PreloadTRTCPlayerParams.KEY_SIG, "partner_status"}, new Object[]{"", "", "", "", "", "", "", 0L, "", 0L}, MobileDialog.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField fromRoleID = PBField.initString("");
    public final PBStringField fromOpenID = PBField.initString("");
    public final PBStringField fromTinyID = PBField.initString("");
    public final PBStringField toRoleID = PBField.initString("");
    public final PBStringField toOpenID = PBField.initString("");
    public final PBStringField toTinyID = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBStringField sig = PBField.initString("");
    public final PBInt64Field partner_status = PBField.initInt64(0);
}
