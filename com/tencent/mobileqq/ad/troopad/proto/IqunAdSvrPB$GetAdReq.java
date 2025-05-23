package com.tencent.mobileqq.ad.troopad.proto;

import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.gdt.qq_ad_get;

/* loaded from: classes10.dex */
public final class IqunAdSvrPB$GetAdReq extends MessageMicro<IqunAdSvrPB$GetAdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, n.CTRL_INDEX}, new String[]{"group_code", "ams_get_ad_req", "client_mod", "is_group_channel", "ext"}, new Object[]{0L, null, "", Boolean.FALSE, ByteStringMicro.EMPTY}, IqunAdSvrPB$GetAdReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public qq_ad_get.QQAdGet ams_get_ad_req = new qq_ad_get.QQAdGet();
    public final PBStringField client_mod = PBField.initString("");
    public final PBBoolField is_group_channel = PBField.initBool(false);
    public final PBBytesField ext = PBField.initBytes(ByteStringMicro.EMPTY);
}
