package pb.unify.search;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchAssociationWord$ReqBody extends MessageMicro<UnifySearchAssociationWord$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business;
    public final PBUInt32Field from_tabbar_index;
    public final PBBytesField key_word;
    public final PBUInt32Field key_word_src;
    public final PBUInt32Field need_flag;
    public final PBUInt32Field req_src;
    public final PBBytesField version;

    static {
        String[] strArr = {QCircleSchemeAttr.Detail.KEY_WORD, "version", "business", "key_word_src", "need_flag", "from_tabbar_index", "req_src"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 56, 64}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0}, UnifySearchAssociationWord$ReqBody.class);
    }

    public UnifySearchAssociationWord$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key_word = PBField.initBytes(byteStringMicro);
        this.version = PBField.initBytes(byteStringMicro);
        this.business = PBField.initUInt32(0);
        this.key_word_src = PBField.initUInt32(0);
        this.need_flag = PBField.initUInt32(0);
        this.from_tabbar_index = PBField.initUInt32(0);
        this.req_src = PBField.initUInt32(0);
    }
}
