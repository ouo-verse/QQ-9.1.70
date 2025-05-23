package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class SplashAd {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ExpInfo extends MessageMicro<ExpInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"key", "value", "exp_id"}, new Object[]{"", "", ""}, ExpInfo.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
        public final PBStringField exp_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class SplashAdGetReq extends MessageMicro<SplashAdGetReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ad_req", "client_mod"}, new Object[]{"", ""}, SplashAdGetReq.class);
        public final PBStringField ad_req = PBField.initString("");
        public final PBStringField client_mod = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class SplashAdGetRsp extends MessageMicro<SplashAdGetRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"ad_rsp", IQQComicPluginUtil.PPP_PRELOAD_SWITCH, "united_exp_ids", "ext"}, new Object[]{"", Boolean.FALSE, "", null}, SplashAdGetRsp.class);
        public final PBStringField ad_rsp = PBField.initString("");
        public final PBBoolField preload_switch = PBField.initBool(false);
        public final PBRepeatField<String> united_exp_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBRepeatMessageField<ExpInfo> ext = PBField.initRepeatMessage(ExpInfo.class);
    }

    SplashAd() {
    }
}
