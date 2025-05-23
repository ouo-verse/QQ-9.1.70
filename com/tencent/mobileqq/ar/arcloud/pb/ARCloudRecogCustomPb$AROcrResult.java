package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$AROcrResult extends MessageMicro<ARCloudRecogCustomPb$AROcrResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"uin64_ocr_recog_type", "youtu_ocr_rsp", "sougou_rsp", "jd_pic_search_rsp", "jd_hot_search_rsp", "jd_search_rsp"}, new Object[]{0L, null, null, null, null, null}, ARCloudRecogCustomPb$AROcrResult.class);
    public final PBUInt64Field uin64_ocr_recog_type = PBField.initUInt64(0);
    public YoutuOcr$YoutuOcrRsp youtu_ocr_rsp = new YoutuOcr$YoutuOcrRsp();
    public SougouSearch$ServerResponseBodyV2 sougou_rsp = new MessageMicro<SougouSearch$ServerResponseBodyV2>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.SougouSearch$ServerResponseBodyV2
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"cards", "request_class", "container_properties", "is_recommended", ServiceConst.PARA_SESSION_ID}, new Object[]{null, "", null, Boolean.FALSE, 0L}, SougouSearch$ServerResponseBodyV2.class);
        public final PBRepeatMessageField<SougouSearch$CardV2> cards = PBField.initRepeatMessage(SougouSearch$CardV2.class);
        public final PBStringField request_class = PBField.initString("");
        public final PBRepeatMessageField<SougouSearch$MapItem> container_properties = PBField.initRepeatMessage(SougouSearch$MapItem.class);
        public final PBBoolField is_recommended = PBField.initBool(false);
        public final PBInt64Field session_id = PBField.initInt64(0);
    };
    public JDSearch$JdPicSearchRsp jd_pic_search_rsp = new MessageMicro<JDSearch$JdPicSearchRsp>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdPicSearchRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"jd_pic_search_errorcode", "jd_pic_search_ocr_errormsg", "jd_pic_search_detail"}, new Object[]{0, "", null}, JDSearch$JdPicSearchRsp.class);
        public final PBInt32Field jd_pic_search_errorcode = PBField.initInt32(0);
        public final PBStringField jd_pic_search_ocr_errormsg = PBField.initString("");
        public JDSearch$JdPicSearchDetail jd_pic_search_detail = new MessageMicro<JDSearch$JdPicSearchDetail>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdPicSearchDetail
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58}, new String[]{ServiceConst.PARA_SESSION_ID, "errorcode", "errormsg", "promotion_url", "coupon_url", "rectangle", "jd_sku_item"}, new Object[]{"", 0, "", "", "", null, null}, JDSearch$JdPicSearchDetail.class);
            public final PBStringField session_id = PBField.initString("");
            public final PBInt32Field errorcode = PBField.initInt32(0);
            public final PBStringField errormsg = PBField.initString("");
            public final PBStringField promotion_url = PBField.initString("");
            public final PBStringField coupon_url = PBField.initString("");
            public JDSearch$Rectangle rectangle = new JDSearch$Rectangle();
            public final PBRepeatMessageField<JDSearch$JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch$JdSkuItem.class);
        };
    };
    public JDSearch$JdHotSearchRsp jd_hot_search_rsp = new MessageMicro<JDSearch$JdHotSearchRsp>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdHotSearchRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"jd_hot_search_errorcode", "jd_hot_search_ocr_errormsg", "jd_hot_search_detail"}, new Object[]{0, "", null}, JDSearch$JdHotSearchRsp.class);
        public final PBInt32Field jd_hot_search_errorcode = PBField.initInt32(0);
        public final PBStringField jd_hot_search_ocr_errormsg = PBField.initString("");
        public JDSearch$JdHotSearchDetail jd_hot_search_detail = new MessageMicro<JDSearch$JdHotSearchDetail>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdHotSearchDetail
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{ServiceConst.PARA_SESSION_ID, "errorcode", "errormsg", "jd_sku_item"}, new Object[]{"", 0, "", null}, JDSearch$JdHotSearchDetail.class);
            public final PBStringField session_id = PBField.initString("");
            public final PBInt32Field errorcode = PBField.initInt32(0);
            public final PBStringField errormsg = PBField.initString("");
            public final PBRepeatMessageField<JDSearch$JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch$JdSkuItem.class);
        };
    };
    public JDSearch$JdSearchRsp jd_search_rsp = new JDSearch$JdSearchRsp();
}
