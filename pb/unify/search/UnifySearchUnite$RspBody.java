package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import unify.search.UnifySearchCommon$ResultItemGroup;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchUnite$RspBody extends MessageMicro<UnifySearchUnite$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField contain_masked_word;
    public final PBBytesField cookie_topic;
    public final PBUInt32Field exhibition_flags;
    public final PBBoolField is_hide_person_group_search_node;
    public final PBFloatField kw_timeliness;
    public final PBRepeatMessageField<UnifySearchUnite$SearchBusiSortInfo> search_busi_sort_infos;
    public final PBBytesField search_ver;
    public final PBUInt32Field trigger_netword_num;
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBRepeatMessageField<UnifySearchCommon$ResultItemGroup> item_groups = PBField.initRepeatMessage(UnifySearchCommon$ResultItemGroup.class);
    public final PBRepeatMessageField<UnifySearchUnite$TabItemGroup> tab_groups = PBField.initRepeatMessage(UnifySearchUnite$TabItemGroup.class);
    public final PBUInt32Field is_end_topic = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 64, 77, 80, 88, 96, 106}, new String[]{"result_code", "error_msg", "item_groups", "tab_groups", "is_end_topic", "cookie_topic", "search_ver", "trigger_netword_num", "kw_timeliness", "exhibition_flags", "contain_masked_word", "is_hide_person_group_search_node", "search_busi_sort_infos"}, new Object[]{0, "", null, null, 0, byteStringMicro, byteStringMicro, 0, Float.valueOf(0.0f), 0, bool, bool, null}, UnifySearchUnite$RspBody.class);
    }

    public UnifySearchUnite$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookie_topic = PBField.initBytes(byteStringMicro);
        this.search_ver = PBField.initBytes(byteStringMicro);
        this.trigger_netword_num = PBField.initUInt32(0);
        this.kw_timeliness = PBField.initFloat(0.0f);
        this.exhibition_flags = PBField.initUInt32(0);
        this.contain_masked_word = PBField.initBool(false);
        this.is_hide_person_group_search_node = PBField.initBool(false);
        this.search_busi_sort_infos = PBField.initRepeatMessage(UnifySearchUnite$SearchBusiSortInfo.class);
    }
}
