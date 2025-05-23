package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$OperationHotSearch extends MessageMicro<UnifySearchDiscovery$OperationHotSearch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"title", "pic_url", "pic_jump_link", "items"}, new Object[]{"", "", null, null}, UnifySearchDiscovery$OperationHotSearch.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public UnifySearchDiscovery$JumpLink pic_jump_link = new UnifySearchDiscovery$JumpLink();
    public final PBRepeatMessageField<UnifySearchDiscovery$OperationHotSearchItem> items = PBField.initRepeatMessage(UnifySearchDiscovery$OperationHotSearchItem.class);
}
