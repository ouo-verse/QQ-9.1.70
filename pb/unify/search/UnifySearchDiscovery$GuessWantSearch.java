package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$GuessWantSearch extends MessageMicro<UnifySearchDiscovery$GuessWantSearch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "items"}, new Object[]{"", null}, UnifySearchDiscovery$GuessWantSearch.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<UnifySearchDiscovery$GuessWantItem> items = PBField.initRepeatMessage(UnifySearchDiscovery$GuessWantItem.class);
}
