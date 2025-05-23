package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StSplitPkgInfo extends MessageMicro<INTERFACE$StSplitPkgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"subPkgName", "fileId", "independent", "pages", "file_size"}, new Object[]{"", "", 0, "", 0}, INTERFACE$StSplitPkgInfo.class);
    public final PBStringField subPkgName = PBField.initString("");
    public final PBStringField fileId = PBField.initString("");
    public final PBInt32Field independent = PBField.initInt32(0);
    public final PBRepeatField<String> pages = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field file_size = PBField.initInt32(0);
}
