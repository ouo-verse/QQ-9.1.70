package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes11.dex */
public final class ARCloudRecogCommonPb$ARCloudRecogRsp extends MessageMicro<ARCloudRecogCommonPb$ARCloudRecogRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 130, 138}, new String[]{"str_session_id", "uin64_req_recog_type", "uin32_business_type", "msg_ar_marker_recog_result", "msg_ar_object_classify_result", "msg_face_recog_result", "msg_face_reg_result", "uint64_uin", "msg_ocr_result", "msg_game_result", "msg_word_detect_result", "msg_img_retrieval_result", "msg_face_detect_result", "msg_search_question_result", "msg_scene_classify_result", "msg_image_translate_rsp_result"}, new Object[]{"", 0L, 0, null, null, null, null, 0L, null, null, null, null, null, null, null, null}, ARCloudRecogCommonPb$ARCloudRecogRsp.class);
    public final PBStringField str_session_id = PBField.initString("");
    public final PBUInt64Field uin64_req_recog_type = PBField.initUInt64(0);
    public final PBUInt32Field uin32_business_type = PBField.initUInt32(0);
    public ARCloudRecogCustomPb$ARMarkerRecogResult msg_ar_marker_recog_result = new ARCloudRecogCustomPb$ARMarkerRecogResult();
    public ARCloudRecogCustomPb$ARObjectClassifyResult msg_ar_object_classify_result = new ARCloudRecogCustomPb$ARObjectClassifyResult();
    public ARCloudRecogCustomPb$ARFaceRecogResult msg_face_recog_result = new ARCloudRecogCustomPb$ARFaceRecogResult();
    public ARCloudRecogCustomPb$ARFaceRegResult msg_face_reg_result = new MessageMicro<ARCloudRecogCustomPb$ARFaceRegResult>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARFaceRegResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"errorcode", "errormsg", "ar_face_reg_errorcode", "ar_face_reg_errormsg", ServiceConst.PARA_SESSION_ID}, new Object[]{0, "", 0, "", ""}, ARCloudRecogCustomPb$ARFaceRegResult.class);
        public final PBInt32Field errorcode = PBField.initInt32(0);
        public final PBStringField errormsg = PBField.initString("");
        public final PBInt32Field ar_face_reg_errorcode = PBField.initInt32(0);
        public final PBStringField ar_face_reg_errormsg = PBField.initString("");
        public final PBStringField session_id = PBField.initString("");
    };
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public ARCloudRecogCustomPb$AROcrResult msg_ocr_result = new ARCloudRecogCustomPb$AROcrResult();
    public ARCloudRecogCustomPb$ARGameResult msg_game_result = new MessageMicro<ARCloudRecogCustomPb$ARGameResult>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARGameResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 90, 98}, new String[]{"uint32_ar_game_cmd", "errorcode", "errormsg", "msg_get_id_rsp", "msg_recog_id_rsp"}, new Object[]{0, 0, "", null, null}, ARCloudRecogCustomPb$ARGameResult.class);
        public final PBUInt32Field uint32_ar_game_cmd = PBField.initUInt32(0);
        public final PBInt32Field errorcode = PBField.initInt32(0);
        public final PBStringField errormsg = PBField.initString("");
        public ARCloudRecogCustomPb$GetIdentityRsp msg_get_id_rsp = new MessageMicro<ARCloudRecogCustomPb$GetIdentityRsp>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$GetIdentityRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"enum_game_id", "uint32_confirmed"}, new Object[]{0, 0}, ARCloudRecogCustomPb$GetIdentityRsp.class);
            public final PBEnumField enum_game_id = PBField.initEnum(0);
            public final PBUInt32Field uint32_confirmed = PBField.initUInt32(0);
        };
        public ARCloudRecogCustomPb$RecogIdentityRsp msg_recog_id_rsp = new MessageMicro<ARCloudRecogCustomPb$RecogIdentityRsp>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$RecogIdentityRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"image_ar_face_recog_res"}, new Object[]{null}, ARCloudRecogCustomPb$RecogIdentityRsp.class);
            public ARCloudRecogCustomPb$ARFaceRecogRes image_ar_face_recog_res = new ARCloudRecogCustomPb$ARFaceRecogRes();
        };
    };
    public ARCloudRecogCustomPb$ARWordDetectResult msg_word_detect_result = new ARCloudRecogCustomPb$ARWordDetectResult();
    public ARCloudRecogCustomPb$ImgRetrievalResult msg_img_retrieval_result = new ARCloudRecogCustomPb$ImgRetrievalResult();
    public ARCloudRecogCustomPb$ARFaceDetectResult msg_face_detect_result = new MessageMicro<ARCloudRecogCustomPb$ARFaceDetectResult>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARFaceDetectResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ar_face_detect_errorcode", "ar_face_detect_errormsg", "cdb_res", "image_ar_face_detect_res"}, new Object[]{0, "", ByteStringMicro.EMPTY, null}, ARCloudRecogCustomPb$ARFaceDetectResult.class);
        public final PBInt32Field ar_face_detect_errorcode = PBField.initInt32(0);
        public final PBStringField ar_face_detect_errormsg = PBField.initString("");
        public final PBRepeatField<ByteStringMicro> cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
        public YTOpenDetection$DetectFaceRsp image_ar_face_detect_res = new MessageMicro<YTOpenDetection$DetectFaceRsp>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection$DetectFaceRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24, 32, 42, 48, 58}, new String[]{ServiceConst.PARA_SESSION_ID, "image_height", "image_width", PreDetect.FACE_DETECT, "errorcode", "errormsg"}, new Object[]{"", 0, 0, null, 0, ""}, YTOpenDetection$DetectFaceRsp.class);
            public final PBStringField session_id = PBField.initString("");
            public final PBInt32Field image_height = PBField.initInt32(0);
            public final PBInt32Field image_width = PBField.initInt32(0);

            /* renamed from: face, reason: collision with root package name */
            public final PBRepeatMessageField<YTOpenBase$FaceItem> f197729face = PBField.initRepeatMessage(YTOpenBase$FaceItem.class);
            public final PBInt32Field errorcode = PBField.initInt32(0);
            public final PBStringField errormsg = PBField.initString("");
        };
    };
    public ARCloudRecogCustomPb$SearchQuestionResult msg_search_question_result = new ARCloudRecogCustomPb$SearchQuestionResult();
    public ARCloudRecogCustomPb$ARSceneClassifyResult msg_scene_classify_result = new ARCloudRecogCustomPb$ARSceneClassifyResult();
    public ARCloudRecogCustomPb$ImageTranslateRspResult msg_image_translate_rsp_result = new MessageMicro<ARCloudRecogCustomPb$ImageTranslateRspResult>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ImageTranslateRspResult
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBInt32Field image_translate_err_code = PBField.initInt32(0);
        public final PBBytesField image_translate_err_msg;
        public final PBRepeatMessageField<ARCloudRecogCustomPb$ImageRecord> msg_image_record_list;
        public final PBBytesField session_uuid;
        public final PBBytesField source_lange;
        public final PBRepeatField<ByteStringMicro> support_translate_lang;
        public final PBBytesField target_lang;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"image_translate_err_code", "image_translate_err_msg", "session_uuid", "source_lange", "target_lang", "msg_image_record_list", "support_translate_lang"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, null, byteStringMicro}, ARCloudRecogCustomPb$ImageTranslateRspResult.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.image_translate_err_msg = PBField.initBytes(byteStringMicro);
            this.session_uuid = PBField.initBytes(byteStringMicro);
            this.source_lange = PBField.initBytes(byteStringMicro);
            this.target_lang = PBField.initBytes(byteStringMicro);
            this.msg_image_record_list = PBField.initRepeatMessage(ARCloudRecogCustomPb$ImageRecord.class);
            this.support_translate_lang = PBField.initRepeat(PBBytesField.__repeatHelper__);
        }
    };
}
