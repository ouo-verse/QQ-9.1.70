package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchAssociationWord$AssociationItem extends MessageMicro<UnifySearchAssociationWord$AssociationItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field gbar_id;
    public final PBUInt32Field group_mask;
    public final PBBytesField jmp_url;
    public final PBBytesField pic_url;
    public final PBBytesField sub_word;
    public final PBUInt32Field type;
    public final PBBytesField word;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56}, new String[]{"word", "jmp_url", "pic_url", "sub_word", "type", "group_mask", "gbar_id"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0}, UnifySearchAssociationWord$AssociationItem.class);
    }

    public UnifySearchAssociationWord$AssociationItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.word = PBField.initBytes(byteStringMicro);
        this.jmp_url = PBField.initBytes(byteStringMicro);
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.sub_word = PBField.initBytes(byteStringMicro);
        this.type = PBField.initUInt32(0);
        this.group_mask = PBField.initUInt32(0);
        this.gbar_id = PBField.initUInt32(0);
    }
}
