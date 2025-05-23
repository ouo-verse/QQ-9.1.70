package nearby_interact_state;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class interact_value$Tribe extends MessageMicro<interact_value$Tribe> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cid;
    public final PBBytesField bytes_content_2;
    public final PBBytesField bytes_content_3;
    public final PBBytesField bytes_content_txt2;
    public final PBBytesField bytes_content_txt3;
    public final PBBytesField bytes_pid;
    public final PBBytesField bytes_ref_cid;
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_color_2_row;
    public final PBUInt32Field uint32_color_3_row;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 72, 80}, new String[]{"uint32_bid", "bytes_pid", "bytes_cid", "bytes_ref_cid", "bytes_content_txt2", "bytes_content_2", "bytes_content_txt3", "bytes_content_3", "uint32_color_2_row", "uint32_color_3_row"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, interact_value$Tribe.class);
    }

    public interact_value$Tribe() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pid = PBField.initBytes(byteStringMicro);
        this.bytes_cid = PBField.initBytes(byteStringMicro);
        this.bytes_ref_cid = PBField.initBytes(byteStringMicro);
        this.bytes_content_txt2 = PBField.initBytes(byteStringMicro);
        this.bytes_content_2 = PBField.initBytes(byteStringMicro);
        this.bytes_content_txt3 = PBField.initBytes(byteStringMicro);
        this.bytes_content_3 = PBField.initBytes(byteStringMicro);
        this.uint32_color_2_row = PBField.initUInt32(0);
        this.uint32_color_3_row = PBField.initUInt32(0);
    }
}
