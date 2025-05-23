package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$AROcrInfo extends MessageMicro<ARCloudRecogCustomPb$AROcrInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"uin64_ocr_recog_type", "youtu_ocr_req", "sougou_req", "jd_pic_search_req", "jd_hot_search_req", "jd_search_req"}, new Object[]{0L, null, null, null, null, null}, ARCloudRecogCustomPb$AROcrInfo.class);
    public final PBUInt64Field uin64_ocr_recog_type = PBField.initUInt64(0);
    public YoutuOcr$YoutuOcrReq youtu_ocr_req = new YoutuOcr$YoutuOcrReq();
    public SougouSearch$ClientRequestBodyV2 sougou_req = new MessageMicro<SougouSearch$ClientRequestBodyV2>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.SougouSearch$ClientRequestBodyV2
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 34}, new String[]{"device", "sentences"}, new Object[]{null, ""}, SougouSearch$ClientRequestBodyV2.class);
        public SougouSearch$DeviceV2 device = new MessageMicro<SougouSearch$DeviceV2>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.SougouSearch$DeviceV2
            public static final int Android = 1;
            public static final int IOS = 0;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"platform"}, new Object[]{0}, SougouSearch$DeviceV2.class);
            public final PBEnumField platform = PBField.initEnum(0);
        };
        public final PBRepeatField<String> sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public JDSearch$JdPicSearchReq jd_pic_search_req = new MessageMicro<JDSearch$JdPicSearchReq>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdPicSearchReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin32_timeout_ms"}, new Object[]{0}, JDSearch$JdPicSearchReq.class);
        public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    };
    public JDSearch$JdHotSearchReq jd_hot_search_req = new MessageMicro<JDSearch$JdHotSearchReq>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdHotSearchReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin32_timeout_ms"}, new Object[]{0}, JDSearch$JdHotSearchReq.class);
        public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    };
    public JDSearch$JdSearchReq jd_search_req = new JDSearch$JdSearchReq();
}
