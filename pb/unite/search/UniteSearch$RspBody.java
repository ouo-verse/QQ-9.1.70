package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import unite.DynamicSearch$ResultItemGroup;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UniteSearch$RspBody extends MessageMicro<UniteSearch$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie_topic;
    public final PBBytesField search_ver;
    public final PBUInt32Field trigger_netword_num;
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBRepeatMessageField<DynamicSearch$ResultItemGroup> item_groups = PBField.initRepeatMessage(DynamicSearch$ResultItemGroup.class);
    public final PBRepeatMessageField<UniteSearch$TabItemGroup> tab_groups = PBField.initRepeatMessage(UniteSearch$TabItemGroup.class);
    public final PBUInt32Field is_end_topic = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 64}, new String[]{"result_code", "error_msg", "item_groups", "tab_groups", "is_end_topic", "cookie_topic", "search_ver", "trigger_netword_num"}, new Object[]{0, "", null, null, 0, byteStringMicro, byteStringMicro, 0}, UniteSearch$RspBody.class);
    }

    public UniteSearch$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookie_topic = PBField.initBytes(byteStringMicro);
        this.search_ver = PBField.initBytes(byteStringMicro);
        this.trigger_netword_num = PBField.initUInt32(0);
    }
}
