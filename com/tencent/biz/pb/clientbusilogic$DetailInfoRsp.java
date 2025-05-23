package com.tencent.biz.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$DetailInfoRsp extends MessageMicro<clientbusilogic$DetailInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"oidb_0x4cc"}, new Object[]{null}, clientbusilogic$DetailInfoRsp.class);
    public Rsp oidb_0x4cc = new Rsp();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DetailInfo extends MessageMicro<DetailInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 274}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "verify_name", "background_color", "background_img", "account_display_flag", "account_uid"}, new Object[]{0L, "", "", "", 0, ""}, DetailInfo.class);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBStringField verify_name = PBField.initString("");
        public final PBStringField background_color = PBField.initString("");
        public final PBStringField background_img = PBField.initString("");
        public final PBUInt32Field account_display_flag = PBField.initUInt32(0);
        public final PBStringField account_uid = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Rsp extends MessageMicro<Rsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"ret", "info", "seqno"}, new Object[]{null, null, 0}, Rsp.class);
        public clientbusilogic$RetInfo ret = new clientbusilogic$RetInfo();
        public DetailInfo info = new DetailInfo();
        public final PBUInt32Field seqno = PBField.initUInt32(0);
    }
}
