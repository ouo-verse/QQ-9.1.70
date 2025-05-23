package pb.unify.search;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchGroupDiscovery$GroupDiscoveryRsp extends MessageMicro<UnifySearchGroupDiscovery$GroupDiscoveryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"guess_want_items", AppConstants.Key.SESSION_INFO, "is_jump_to_net_result_page"}, new Object[]{null, ByteStringMicro.EMPTY, Boolean.FALSE}, UnifySearchGroupDiscovery$GroupDiscoveryRsp.class);
    public UnifySearchGroupDiscovery$GuessWantSearch guess_want_items = new UnifySearchGroupDiscovery$GuessWantSearch();
    public final PBBytesField session_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField is_jump_to_net_result_page = PBField.initBool(false);
}
