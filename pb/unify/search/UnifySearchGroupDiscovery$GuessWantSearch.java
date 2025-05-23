package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchGroupDiscovery$GuessWantSearch extends MessageMicro<UnifySearchGroupDiscovery$GuessWantSearch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "items"}, new Object[]{"", null}, UnifySearchGroupDiscovery$GuessWantSearch.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<UnifySearchGroupDiscovery$GuessWantItem> items = PBField.initRepeatMessage(UnifySearchGroupDiscovery$GuessWantItem.class);
}
