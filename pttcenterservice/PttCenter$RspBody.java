package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttCenter$RspBody extends MessageMicro<PttCenter$RspBody> {
    public static final int MSG_PTTINTRODAPPLYUPLOAD_RESP_FIELD_NUMBER = 3;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_cmd", "uint32_seq", "msg_pttIntrodApplyUpload_resp"}, new Object[]{0, 0, null}, PttCenter$RspBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public PttCenter$PttIntrodApplyUploadResp msg_pttIntrodApplyUpload_resp = new MessageMicro<PttCenter$PttIntrodApplyUploadResp>() { // from class: pttcenterservice.PttCenter$PttIntrodApplyUploadResp
        public static final int BYTES_UP_FILEKEY_FIELD_NUMBER = 4;
        public static final int BYTES_UP_UKEY_FIELD_NUMBER = 5;
        public static final int INT32_RET_CODE_FIELD_NUMBER = 1;
        public static final int RPT_MSG_TRYUP_IPLIST_FIELD_NUMBER = 3;
        public static final int STR_RET_MSG_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_up_filekey;
        public final PBBytesField bytes_up_ukey;
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBRepeatMessageField<PttCenter$ServerListInfo> rpt_msg_tryup_iplist = PBField.initRepeatMessage(PttCenter$ServerListInfo.class);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"int32_ret_code", "str_ret_msg", "rpt_msg_tryup_iplist", "bytes_up_filekey", "bytes_up_ukey"}, new Object[]{0, "", null, byteStringMicro, byteStringMicro}, PttCenter$PttIntrodApplyUploadResp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_up_filekey = PBField.initBytes(byteStringMicro);
            this.bytes_up_ukey = PBField.initBytes(byteStringMicro);
        }
    };
}
