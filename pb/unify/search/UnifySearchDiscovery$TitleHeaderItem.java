package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$TitleHeaderItem extends MessageMicro<UnifySearchDiscovery$TitleHeaderItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field header_type;
    public final PBBytesField icon_url;
    public final PBBytesField morn_text;
    public final PBBytesField morn_url;
    public final PBBytesField qq_index_jump_url;
    public final PBBytesField title;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"title", "icon_url", "morn_text", "morn_url", "header_type", "qq_index_jump_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro}, UnifySearchDiscovery$TitleHeaderItem.class);
    }

    public UnifySearchDiscovery$TitleHeaderItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.title = PBField.initBytes(byteStringMicro);
        this.icon_url = PBField.initBytes(byteStringMicro);
        this.morn_text = PBField.initBytes(byteStringMicro);
        this.morn_url = PBField.initBytes(byteStringMicro);
        this.header_type = PBField.initUInt32(0);
        this.qq_index_jump_url = PBField.initBytes(byteStringMicro);
    }
}
