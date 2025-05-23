package pb.unify.search;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchBusiHotWord$ReqBody extends MessageMicro<UnifySearchBusiHotWord$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business;
    public final PBBytesField key_word;
    public final PBRepeatMessageField<UnifySearchBusiHotWord$GroupID> rpt_group_id;
    public final PBBytesField version;

    static {
        String[] strArr = {"version", "business", "rpt_group_id", QCircleSchemeAttr.Detail.KEY_WORD};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, strArr, new Object[]{byteStringMicro, 0, null, byteStringMicro}, UnifySearchBusiHotWord$ReqBody.class);
    }

    public UnifySearchBusiHotWord$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.version = PBField.initBytes(byteStringMicro);
        this.business = PBField.initUInt32(0);
        this.rpt_group_id = PBField.initRepeatMessage(UnifySearchBusiHotWord$GroupID.class);
        this.key_word = PBField.initBytes(byteStringMicro);
    }
}
