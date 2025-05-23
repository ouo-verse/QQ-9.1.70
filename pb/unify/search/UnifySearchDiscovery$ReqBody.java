package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$ReqBody extends MessageMicro<UnifySearchDiscovery$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"from_type", "version", "business", "ignore_gender"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0}, UnifySearchDiscovery$ReqBody.class);
    public final PBUInt32Field from_type = PBField.initUInt32(0);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBUInt32Field ignore_gender = PBField.initUInt32(0);
}
