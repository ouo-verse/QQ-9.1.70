package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$OperationHotSearchItem extends MessageMicro<UnifySearchDiscovery$OperationHotSearchItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"word", "icons", "serial_num_url", "jump_link", "reportData", "is_manual_operation", "hot_search_text_id"}, new Object[]{"", null, "", null, ByteStringMicro.EMPTY, Boolean.FALSE, ""}, UnifySearchDiscovery$OperationHotSearchItem.class);
    public final PBStringField word = PBField.initString("");
    public UnifySearchDiscovery$HotSearchIcon icons = new UnifySearchDiscovery$HotSearchIcon();
    public final PBStringField serial_num_url = PBField.initString("");
    public UnifySearchDiscovery$JumpLink jump_link = new UnifySearchDiscovery$JumpLink();
    public final PBBytesField reportData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField is_manual_operation = PBField.initBool(false);
    public final PBStringField hot_search_text_id = PBField.initString("");
}
