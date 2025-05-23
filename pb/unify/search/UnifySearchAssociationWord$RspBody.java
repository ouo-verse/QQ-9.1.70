package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchAssociationWord$RspBody extends MessageMicro<UnifySearchAssociationWord$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"result_code", "error_msg", "association_items", "suggest_url_items", "completed_url_item"}, new Object[]{0, "", null, null, null}, UnifySearchAssociationWord$RspBody.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBRepeatMessageField<UnifySearchAssociationWord$AssociationItem> association_items = PBField.initRepeatMessage(UnifySearchAssociationWord$AssociationItem.class);
    public final PBRepeatMessageField<UnifySearchAssociationWord$SuggestUrlItem> suggest_url_items = PBField.initRepeatMessage(UnifySearchAssociationWord$SuggestUrlItem.class);
    public UnifySearchAssociationWord$SuggestUrlItem completed_url_item = new MessageMicro<UnifySearchAssociationWord$SuggestUrlItem>() { // from class: pb.unify.search.UnifySearchAssociationWord$SuggestUrlItem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField title;
        public final PBBytesField url;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "title"}, new Object[]{byteStringMicro, byteStringMicro}, UnifySearchAssociationWord$SuggestUrlItem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.url = PBField.initBytes(byteStringMicro);
            this.title = PBField.initBytes(byteStringMicro);
        }
    };
}
