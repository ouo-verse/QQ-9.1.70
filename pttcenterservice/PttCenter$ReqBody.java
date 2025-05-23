package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PttCenter$ReqBody extends MessageMicro<PttCenter$ReqBody> {
    public static final int MSG_PTTINTRODAPPLYUPLOAD_REQ_FIELD_NUMBER = 3;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_cmd", "uint32_seq", "msg_pttIntrodApplyUpload_req"}, new Object[]{0, 0, null}, PttCenter$ReqBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public PttCenter$PttIntrodApplyUploadReq msg_pttIntrodApplyUpload_req = new MessageMicro<PttCenter$PttIntrodApplyUploadReq>() { // from class: pttcenterservice.PttCenter$PttIntrodApplyUploadReq
        public static final int BYTES_MD5_FIELD_NUMBER = 3;
        public static final int STR_FILE_NAME_FIELD_NUMBER = 2;
        public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_file_size", "str_file_name", "bytes_md5"}, new Object[]{0L, "", ByteStringMicro.EMPTY}, PttCenter$PttIntrodApplyUploadReq.class);
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        public final PBStringField str_file_name = PBField.initString("");
        public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
