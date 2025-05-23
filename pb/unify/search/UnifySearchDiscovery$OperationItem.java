package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$OperationItem extends MessageMicro<UnifySearchDiscovery$OperationItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField detail_text;
    public final PBBytesField img_url;
    public final PBBytesField jump_url;
    public final PBBytesField left_title;
    public final PBBytesField right_title;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"left_title", "right_title", "detail_text", "img_url", "jump_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, UnifySearchDiscovery$OperationItem.class);
    }

    public UnifySearchDiscovery$OperationItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.left_title = PBField.initBytes(byteStringMicro);
        this.right_title = PBField.initBytes(byteStringMicro);
        this.detail_text = PBField.initBytes(byteStringMicro);
        this.img_url = PBField.initBytes(byteStringMicro);
        this.jump_url = PBField.initBytes(byteStringMicro);
    }
}
