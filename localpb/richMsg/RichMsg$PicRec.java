package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class RichMsg$PicRec extends MessageMicro<RichMsg$PicRec> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField localPath = PBField.initString("");
    public final PBUInt64Field size = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBoolField isRead = PBField.initBool(false);
    public final PBStringField uuid = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField serverStorageSource = PBField.initString("");
    public final PBStringField thumbMsgUrl = PBField.initString("");
    public final PBStringField bigMsgUrl = PBField.initString("");
    public final PBStringField rawMsgUrl = PBField.initString("");
    public final PBInt32Field fileSizeFlag = PBField.initInt32(0);
    public final PBInt32Field uiOperatorFlag = PBField.initInt32(0);
    public RichMsg$ForwardExtra fowardInfo = new RichMsg$ForwardExtra();
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBInt32Field isReport = PBField.initInt32(0);
    public final PBUInt64Field groupFileID = PBField.initUInt64(0);
    public final PBStringField localUUID = PBField.initString("");
    public final PBInt32Field preDownState = PBField.initInt32(0);
    public final PBInt32Field preDownNetwork = PBField.initInt32(0);
    public final PBInt32Field previewed = PBField.initInt32(0);
    public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_image_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_current_len = PBField.initUInt32(0);
    public final PBUInt32Field notPredownloadReason = PBField.initUInt32(0);
    public final PBBoolField enableEnc = PBField.initBool(false);
    public final PBStringField bigthumbMsgUrl = PBField.initString("");
    public final PBBytesField bytes_pb_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField bool_story_pic_send_to_recent = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66, 74, 82, 88, 96, 106, 120, 128, 136, 146, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248, 258, 266, 272}, new String[]{"localPath", "size", "type", "isRead", "uuid", "md5", "serverStorageSource", "thumbMsgUrl", "bigMsgUrl", "rawMsgUrl", "fileSizeFlag", "uiOperatorFlag", "fowardInfo", "version", "isReport", "groupFileID", "localUUID", "preDownState", "preDownNetwork", "previewed", "uint32_thumb_width", "uint32_thumb_height", "uint32_width", "uint32_height", "uint32_image_type", "uint32_show_len", "uint32_download_len", "uint32_current_len", "notPredownloadReason", "enableEnc", "bigthumbMsgUrl", "bytes_pb_reserved", "bool_story_pic_send_to_recent"}, new Object[]{"", 0L, 0, bool, "", "", "", "", "", "", 0, 0, null, 0, 0, 0L, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, bool, "", ByteStringMicro.EMPTY, bool}, RichMsg$PicRec.class);
    }
}
