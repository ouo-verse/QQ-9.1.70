package localpb.dataline;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DatalineMsgData$MsgData extends MessageMicro<DatalineMsgData$MsgData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_sended;
    public final PBBytesField bytes_tokenkey;
    public final PBBytesField bytes_url_notify;
    public final PBStringField str_fileUuid;
    public final PBStringField str_weiyundirkey;
    public final PBStringField str_weiyunid;
    public final PBStringField str_weiyunmd5;
    public final PBStringField str_weiyunsha;
    public final PBUInt32Field uint32_busId;
    public final PBUInt32Field uint32_fileFrom;
    public final PBUInt32Field uint32_forwardTroopFileEntranc;
    public final PBUInt32Field uint32_ismoloimage;
    public final PBUInt32Field uint32_nOpType;
    public final PBUInt32Field uint32_weiyunsrctype;
    public final PBUInt64Field uint64_OwnerUin;
    public final PBUInt64Field uint64_entityID;
    public final PBStringField str_msg = PBField.initString("");
    public final PBUInt64Field uint64_filemsgstatus = PBField.initUInt64(0);
    public final PBUInt64Field uint64_weiyunsessionid = PBField.initUInt64(0);
    public final PBStringField str_molokey = PBField.initString("");
    public final PBStringField str_moloiconurl = PBField.initString("");
    public final PBStringField str_molosource = PBField.initString("");
    public final PBStringField str_molosrcurl = PBField.initString("");
    public final PBStringField str_reserve1 = PBField.initString("");
    public final PBUInt32Field uint32_isapkfile = PBField.initUInt32(0);
    public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 72, 85, 88, 98, 106, 112, 120, 130, 136, 144, 152, 160, 168, 176, 186, 194, 200, 210, 218}, new String[]{"str_msg", "uint64_filemsgstatus", "uint64_weiyunsessionid", "str_molokey", "str_moloiconurl", "str_molosource", "str_molosrcurl", "str_reserve1", "uint32_isapkfile", "fixed32_ip", "uint32_port", "bytes_url_notify", "bytes_tokenkey", "uint32_ismoloimage", "uint32_fileFrom", "str_fileUuid", "uint32_nOpType", "uint64_entityID", "uint64_OwnerUin", "uint32_busId", "uint32_forwardTroopFileEntranc", "bool_sended", "str_weiyunid", "str_weiyundirkey", "uint32_weiyunsrctype", "str_weiyunmd5", "str_weiyunsha"}, new Object[]{"", 0L, 0L, "", "", "", "", "", 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, "", 0, 0L, 0L, 0, 0, Boolean.FALSE, "", "", 0, "", ""}, DatalineMsgData$MsgData.class);
    }

    public DatalineMsgData$MsgData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_url_notify = PBField.initBytes(byteStringMicro);
        this.bytes_tokenkey = PBField.initBytes(byteStringMicro);
        this.uint32_ismoloimage = PBField.initUInt32(0);
        this.uint32_fileFrom = PBField.initUInt32(0);
        this.str_fileUuid = PBField.initString("");
        this.uint32_nOpType = PBField.initUInt32(0);
        this.uint64_entityID = PBField.initUInt64(0L);
        this.uint64_OwnerUin = PBField.initUInt64(0L);
        this.uint32_busId = PBField.initUInt32(0);
        this.uint32_forwardTroopFileEntranc = PBField.initUInt32(0);
        this.bool_sended = PBField.initBool(false);
        this.str_weiyunid = PBField.initString("");
        this.str_weiyundirkey = PBField.initString("");
        this.uint32_weiyunsrctype = PBField.initUInt32(0);
        this.str_weiyunmd5 = PBField.initString("");
        this.str_weiyunsha = PBField.initString("");
    }
}
