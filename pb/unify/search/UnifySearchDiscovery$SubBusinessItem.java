package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$SubBusinessItem extends MessageMicro<UnifySearchDiscovery$SubBusinessItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field bzid;
    public final PBRepeatField<Long> group_masks;
    public final PBUInt32Field has_red_dot;
    public final PBBytesField icon_url;
    public final PBUInt32Field is_hot_words_list;
    public final PBBytesField jump_url;
    public final PBUInt32Field red_seq;
    public final PBBytesField title;

    static {
        String[] strArr = {"title", "icon_url", "group_masks", "is_hot_words_list", "jump_url", QCircleScheme.AttrDetail.HAS_RED_DOT, "red_seq", "bzid"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 64}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0L, 0, byteStringMicro, 0, 0, 0}, UnifySearchDiscovery$SubBusinessItem.class);
    }

    public UnifySearchDiscovery$SubBusinessItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.title = PBField.initBytes(byteStringMicro);
        this.icon_url = PBField.initBytes(byteStringMicro);
        this.group_masks = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.is_hot_words_list = PBField.initUInt32(0);
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.has_red_dot = PBField.initUInt32(0);
        this.red_seq = PBField.initUInt32(0);
        this.bzid = PBField.initUInt32(0);
    }
}
