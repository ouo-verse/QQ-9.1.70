package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$HotSearchItem extends MessageMicro<UnifySearchDiscovery$HotSearchItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField detail_text;
    public final PBBytesField img_bg_url;
    public final PBBytesField img_url;
    public final PBBytesField item_ext;
    public final PBBytesField jump_url;
    public final PBBytesField mark_bg_color;
    public final PBBytesField mark_text_color;
    public final PBBytesField recall_word;
    public final PBBytesField right_icon_url;
    public final PBUInt32Field show_type = PBField.initUInt32(0);
    public final PBBytesField text_color;
    public final PBBytesField title;
    public final PBUInt32Field wz_ts;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106}, new String[]{"show_type", "img_url", "title", "detail_text", "jump_url", "mark_text_color", "mark_bg_color", "img_bg_url", "text_color", "right_icon_url", "wz_ts", "recall_word", "item_ext"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro}, UnifySearchDiscovery$HotSearchItem.class);
    }

    public UnifySearchDiscovery$HotSearchItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.img_url = PBField.initBytes(byteStringMicro);
        this.title = PBField.initBytes(byteStringMicro);
        this.detail_text = PBField.initBytes(byteStringMicro);
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.mark_text_color = PBField.initBytes(byteStringMicro);
        this.mark_bg_color = PBField.initBytes(byteStringMicro);
        this.img_bg_url = PBField.initBytes(byteStringMicro);
        this.text_color = PBField.initBytes(byteStringMicro);
        this.right_icon_url = PBField.initBytes(byteStringMicro);
        this.wz_ts = PBField.initUInt32(0);
        this.recall_word = PBField.initBytes(byteStringMicro);
        this.item_ext = PBField.initBytes(byteStringMicro);
    }
}
