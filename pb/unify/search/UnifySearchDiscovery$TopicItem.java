package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$TopicItem extends MessageMicro<UnifySearchDiscovery$TopicItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField config_color;
    public final PBBytesField config_time;
    public final PBUInt32Field is_hotsearch;
    public final PBBytesField jump_url;
    public final PBBytesField title_color;
    public final PBBytesField trait_title;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"trait_title", "title_color", "config_time", "config_color", "jump_url", "is_hotsearch"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, UnifySearchDiscovery$TopicItem.class);
    }

    public UnifySearchDiscovery$TopicItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.trait_title = PBField.initBytes(byteStringMicro);
        this.title_color = PBField.initBytes(byteStringMicro);
        this.config_time = PBField.initBytes(byteStringMicro);
        this.config_color = PBField.initBytes(byteStringMicro);
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.is_hotsearch = PBField.initUInt32(0);
    }
}
