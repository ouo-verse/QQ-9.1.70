package NS_MINI_APP_SEARCH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SEARCH$StAppSearchItem extends MessageMicro<SEARCH$StAppSearchItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"appid", "appname", "appIcon", "desc", "showMask"}, new Object[]{"", "", "", "", 0}, SEARCH$StAppSearchItem.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField appname = PBField.initString("");
    public final PBStringField appIcon = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field showMask = PBField.initInt32(0);
}
