package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MixedMsg$Elem extends MessageMicro<MixedMsg$Elem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"textMsg", "picMsg", "markfaceMsg", "sourceMsgInfo", "videoMsg"}, new Object[]{"", null, null, "", null}, MixedMsg$Elem.class);
    public final PBStringField textMsg = PBField.initString("");
    public RichMsg$PicRec picMsg = new RichMsg$PicRec();
    public MarketFaceMsg$MarketFaceRec markfaceMsg = new MessageMicro<MarketFaceMsg$MarketFaceRec>() { // from class: localpb.richMsg.MarketFaceMsg$MarketFaceRec
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_face_id;
        public final PBBytesField bytes_face_name;
        public final PBBytesField bytes_key;
        public final PBBytesField bytes_param;
        public final PBUInt32Field uint32_face_info;
        public final PBUInt32Field uint32_image_height;
        public final PBUInt32Field uint32_image_width;
        public final PBUInt32Field uint32_item_type;
        public final PBUInt32Field uint32_media_type;
        public final PBUInt32Field uint32_sub_type;
        public final PBUInt32Field uint32_tab_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88}, new String[]{"bytes_face_name", "uint32_item_type", "uint32_face_info", "bytes_face_id", "uint32_tab_id", "uint32_sub_type", "bytes_key", "bytes_param", "uint32_media_type", "uint32_image_width", "uint32_image_height"}, new Object[]{byteStringMicro, 0, 0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0}, MarketFaceMsg$MarketFaceRec.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_face_name = PBField.initBytes(byteStringMicro);
            this.uint32_item_type = PBField.initUInt32(0);
            this.uint32_face_info = PBField.initUInt32(0);
            this.bytes_face_id = PBField.initBytes(byteStringMicro);
            this.uint32_tab_id = PBField.initUInt32(0);
            this.uint32_sub_type = PBField.initUInt32(0);
            this.bytes_key = PBField.initBytes(byteStringMicro);
            this.bytes_param = PBField.initBytes(byteStringMicro);
            this.uint32_media_type = PBField.initUInt32(0);
            this.uint32_image_width = PBField.initUInt32(0);
            this.uint32_image_height = PBField.initUInt32(0);
        }
    };
    public final PBStringField sourceMsgInfo = PBField.initString("");
    public RichMsg$VideoFile videoMsg = new RichMsg$VideoFile();
}
