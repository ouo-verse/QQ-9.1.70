package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StAppResidueModifyTime extends MessageMicro<META_PROTOCOL$StAppResidueModifyTime> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"appname", "appIcon", "appDesc", "serviceCategory", "serverDomain"}, new Object[]{0, 0, 0, 0, 0}, META_PROTOCOL$StAppResidueModifyTime.class);
    public final PBInt32Field appname = PBField.initInt32(0);
    public final PBInt32Field appIcon = PBField.initInt32(0);
    public final PBInt32Field appDesc = PBField.initInt32(0);
    public final PBInt32Field serviceCategory = PBField.initInt32(0);
    public final PBInt32Field serverDomain = PBField.initInt32(0);
}
