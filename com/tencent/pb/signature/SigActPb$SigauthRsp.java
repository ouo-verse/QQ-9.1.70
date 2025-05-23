package com.tencent.pb.signature;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class SigActPb$SigauthRsp extends MessageMicro<SigActPb$SigauthRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"result", "url", "tips_info", "authfailed_appid"}, new Object[]{ByteStringMicro.EMPTY, "", null, 0}, SigActPb$SigauthRsp.class);
    public final PBBytesField result = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField url = PBField.initString("");
    public TipsInfo tips_info = new TipsInfo();
    public final PBInt32Field authfailed_appid = PBField.initInt32(0);

    /* loaded from: classes22.dex */
    public static final class TipsInfo extends MessageMicro<TipsInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 72, 82}, new String[]{"valid", "ret", "type", "title_wording", "wording", "right_btn_wording", "left_btn_wording", AppConstants.VIPKey.KEY_FOR_VIP_TYPE, "vip_month", "url"}, new Object[]{Boolean.FALSE, 0, 0, "", "", "", "", "", 0, ""}, TipsInfo.class);
        public final PBBoolField valid = PBField.initBool(false);
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBStringField title_wording = PBField.initString("");
        public final PBStringField wording = PBField.initString("");
        public final PBStringField right_btn_wording = PBField.initString("");
        public final PBStringField left_btn_wording = PBField.initString("");
        public final PBStringField vip_type = PBField.initString("");
        public final PBUInt32Field vip_month = PBField.initUInt32(0);
        public final PBStringField url = PBField.initString("");
    }
}
