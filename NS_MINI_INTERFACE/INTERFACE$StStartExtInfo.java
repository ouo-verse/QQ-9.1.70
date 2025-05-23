package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StStartExtInfo extends MessageMicro<INTERFACE$StStartExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"deviceOrientation", "showStatusBar"}, new Object[]{0, 0}, INTERFACE$StStartExtInfo.class);
    public final PBInt32Field deviceOrientation = PBField.initInt32(0);
    public final PBInt32Field showStatusBar = PBField.initInt32(0);
}
