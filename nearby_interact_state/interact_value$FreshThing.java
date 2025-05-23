package nearby_interact_state;

import appoint.define.appoint_define$FeedComment;
import appoint.define.appoint_define$RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class interact_value$FreshThing extends MessageMicro<interact_value$FreshThing> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content_2;
    public final PBBytesField bytes_content_3;
    public final PBStringField bytes_fresh_thing_comment_id;
    public final PBBytesField bytes_fresh_thing_id;
    public appoint_define$FeedComment fresh_comment;
    public appoint_define$RichText fresh_thing_info;
    public final PBUInt32Field uint32_color_2_row;
    public final PBUInt32Field uint32_color_3_row;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64}, new String[]{"bytes_fresh_thing_id", "bytes_fresh_thing_comment_id", "bytes_content_2", "fresh_comment", "bytes_content_3", "fresh_thing_info", "uint32_color_2_row", "uint32_color_3_row"}, new Object[]{byteStringMicro, "", byteStringMicro, null, byteStringMicro, null, 0, 0}, interact_value$FreshThing.class);
    }

    public interact_value$FreshThing() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fresh_thing_id = PBField.initBytes(byteStringMicro);
        this.bytes_fresh_thing_comment_id = PBField.initString("");
        this.bytes_content_2 = PBField.initBytes(byteStringMicro);
        this.fresh_comment = new appoint_define$FeedComment();
        this.bytes_content_3 = PBField.initBytes(byteStringMicro);
        this.fresh_thing_info = new appoint_define$RichText();
        this.uint32_color_2_row = PBField.initUInt32(0);
        this.uint32_color_3_row = PBField.initUInt32(0);
    }
}
