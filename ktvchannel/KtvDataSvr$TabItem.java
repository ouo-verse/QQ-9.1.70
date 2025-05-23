package ktvchannel;

import com.qzone.widget.u;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$TabItem extends MessageMicro<KtvDataSvr$TabItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{u.COLUMN_TAB_ID, "tab_name"}, new Object[]{0L, ""}, KtvDataSvr$TabItem.class);
    public final PBUInt64Field tab_id = PBField.initUInt64(0);
    public final PBStringField tab_name = PBField.initString("");
}
