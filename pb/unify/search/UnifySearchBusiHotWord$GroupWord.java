package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchBusiHotWord$GroupWord extends MessageMicro<UnifySearchBusiHotWord$GroupWord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"group_id", "rpt_hot_word_items", "clue_word_item", "title"}, new Object[]{null, null, null, ""}, UnifySearchBusiHotWord$GroupWord.class);
    public UnifySearchBusiHotWord$GroupID group_id = new UnifySearchBusiHotWord$GroupID();
    public final PBRepeatMessageField<UnifySearchBusiHotWord$HotWordItem> rpt_hot_word_items = PBField.initRepeatMessage(UnifySearchBusiHotWord$HotWordItem.class);
    public UnifySearchBusiHotWord$ClueWordItem clue_word_item = new UnifySearchBusiHotWord$ClueWordItem();
    public final PBStringField title = PBField.initString("");
}
