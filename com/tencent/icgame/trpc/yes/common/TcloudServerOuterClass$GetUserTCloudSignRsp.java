package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TcloudServerOuterClass$GetUserTCloudSignRsp extends MessageMicro<TcloudServerOuterClass$GetUserTCloudSignRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"im_sign", "trtc_sign", VasQQSettingMeImpl.EXPIRE_TIME, "live_trtc_sign", "user_id_im_sign", "current_uid"}, new Object[]{"", "", 0, "", "", 0L}, TcloudServerOuterClass$GetUserTCloudSignRsp.class);
    public final PBStringField im_sign = PBField.initString("");
    public final PBStringField trtc_sign = PBField.initString("");
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBStringField live_trtc_sign = PBField.initString("");
    public final PBStringField user_id_im_sign = PBField.initString("");
    public final PBUInt64Field current_uid = PBField.initUInt64(0);
}
