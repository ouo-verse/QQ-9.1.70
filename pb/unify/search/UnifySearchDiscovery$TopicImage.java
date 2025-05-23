package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$TopicImage extends MessageMicro<UnifySearchDiscovery$TopicImage> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField image_text;
    public final PBBytesField image_url;
    public final PBUInt32Field is_hotsearch;
    public final PBBytesField jump_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"image_url", "image_text", "jump_url", "is_hotsearch"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0}, UnifySearchDiscovery$TopicImage.class);
    }

    public UnifySearchDiscovery$TopicImage() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.image_url = PBField.initBytes(byteStringMicro);
        this.image_text = PBField.initBytes(byteStringMicro);
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.is_hotsearch = PBField.initUInt32(0);
    }
}
