package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchSuggest$NetSugItem extends MessageMicro<UnifySearchSuggest$NetSugItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 802}, new String[]{"word", "hit_key_word", "sug_trans_info"}, new Object[]{"", "", ""}, UnifySearchSuggest$NetSugItem.class);
    public final PBStringField word = PBField.initString("");
    public final PBStringField hit_key_word = PBField.initString("");
    public final PBStringField sug_trans_info = PBField.initString("");
}
