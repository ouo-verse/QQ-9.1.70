package pb.unify.search;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchGroupDiscovery$GroupDiscoveryReq extends MessageMicro<UnifySearchGroupDiscovery$GroupDiscoveryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 802}, new String[]{"from", AppConstants.Key.SESSION_INFO, "sug_trans_info"}, new Object[]{0, ByteStringMicro.EMPTY, ""}, UnifySearchGroupDiscovery$GroupDiscoveryReq.class);
    public final PBEnumField from = PBField.initEnum(0);
    public final PBBytesField session_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField sug_trans_info = PBField.initString("");
}
