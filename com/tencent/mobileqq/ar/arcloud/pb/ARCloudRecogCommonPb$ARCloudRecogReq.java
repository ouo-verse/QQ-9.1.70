package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCommonPb$ARCloudRecogReq extends MessageMicro<ARCloudRecogCommonPb$ARCloudRecogReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130, 138, 146, 162, 170}, new String[]{"str_session_id", "msg_ar_req_file_info", "uint32_lon", "uint32_lat", "uin64_req_recog_type", "uin32_business_type", "msg_ar_marker_recog_info", "msg_object_classify_info", "msg_face_recog_info", "msg_face_reg_info", "str_clt_version", "uint64_uin", "msg_ocr_info", "msg_game_info", "msg_word_detect_info", "msg_img_retrieval_info", "msg_face_detect_info", "msg_search_question_info", "msg_scene_classify_info", "msg_image_translate_req_info"}, new Object[]{"", null, 0, 0, 0L, 0, null, null, null, null, "", 0L, null, null, null, null, null, null, null, null}, ARCloudRecogCommonPb$ARCloudRecogReq.class);
    public final PBStringField str_session_id = PBField.initString("");
    public ARCloudRecogCommonPb$ARFileReqInfo msg_ar_req_file_info = new ARCloudRecogCommonPb$ARFileReqInfo();
    public final PBUInt32Field uint32_lon = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lat = PBField.initUInt32(0);
    public final PBUInt64Field uin64_req_recog_type = PBField.initUInt64(0);
    public final PBUInt32Field uin32_business_type = PBField.initUInt32(0);
    public ARCloudRecogCustomPb$ARMarkerRecogInfo msg_ar_marker_recog_info = new ARCloudRecogCustomPb$ARMarkerRecogInfo();
    public ARCloudRecogCustomPb$ARObjectClassifyInfo msg_object_classify_info = new ARCloudRecogCustomPb$ARObjectClassifyInfo();
    public ARCloudRecogCustomPb$ARFaceRecogInfo msg_face_recog_info = new ARCloudRecogCustomPb$ARFaceRecogInfo();
    public ARCloudRecogCustomPb$ARFaceRegInfo msg_face_reg_info = new ARCloudRecogCustomPb$ARFaceRegInfo();
    public final PBStringField str_clt_version = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public ARCloudRecogCustomPb$AROcrInfo msg_ocr_info = new ARCloudRecogCustomPb$AROcrInfo();
    public ARCloudRecogCustomPb$ARGameInfo msg_game_info = new MessageMicro<ARCloudRecogCustomPb$ARGameInfo>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARGameInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98}, new String[]{"uint32_ar_game_cmd", "msg_get_id_req", "msg_recog_id_req"}, new Object[]{0, null, null}, ARCloudRecogCustomPb$ARGameInfo.class);
        public final PBUInt32Field uint32_ar_game_cmd = PBField.initUInt32(0);
        public ARCloudRecogCustomPb$GetIdentityReq msg_get_id_req = new MessageMicro<ARCloudRecogCustomPb$GetIdentityReq>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$GetIdentityReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_face_reg_info"}, new Object[]{null}, ARCloudRecogCustomPb$GetIdentityReq.class);
            public ARCloudRecogCustomPb$ARFaceRegInfo msg_face_reg_info = new ARCloudRecogCustomPb$ARFaceRegInfo();
        };
        public ARCloudRecogCustomPb$RecogIdentityReq msg_recog_id_req = new MessageMicro<ARCloudRecogCustomPb$RecogIdentityReq>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$RecogIdentityReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_face_recog_info"}, new Object[]{null}, ARCloudRecogCustomPb$RecogIdentityReq.class);
            public ARCloudRecogCustomPb$ARFaceRecogInfo msg_face_recog_info = new ARCloudRecogCustomPb$ARFaceRecogInfo();
        };
    };
    public ARCloudRecogCustomPb$ARWordDetectInfo msg_word_detect_info = new ARCloudRecogCustomPb$ARWordDetectInfo();
    public ARCloudRecogCustomPb$ImgRetrievalInfo msg_img_retrieval_info = new ARCloudRecogCustomPb$ImgRetrievalInfo();
    public ARCloudRecogCustomPb$ARFaceDetectInfo msg_face_detect_info = new MessageMicro<ARCloudRecogCustomPb$ARFaceDetectInfo>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARFaceDetectInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin32_timeout_ms"}, new Object[]{0}, ARCloudRecogCustomPb$ARFaceDetectInfo.class);
        public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    };
    public ARCloudRecogCustomPb$SearchQuestionInfo msg_search_question_info = new ARCloudRecogCustomPb$SearchQuestionInfo();
    public ARCloudRecogCustomPb$ARSceneClassifyInfo msg_scene_classify_info = new ARCloudRecogCustomPb$ARSceneClassifyInfo();
    public ARCloudRecogCustomPb$ImageTranslateReqInfo msg_image_translate_req_info = new ARCloudRecogCustomPb$ImageTranslateReqInfo();
}
