package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$MiniGameBox extends MessageMicro<INTERFACE$MiniGameBox> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64}, new String[]{"display", MiniBoxNoticeInfo.KEY_ICON_URL, "iconTitle", VasWebviewConstants.KEY_PAGE_TITLE, "jumpURL", "taskURL", "redDot", "displayDuration"}, new Object[]{Boolean.FALSE, "", "", "", "", "", null, 0L}, INTERFACE$MiniGameBox.class);
    public final PBBoolField display = PBField.initBool(false);
    public final PBStringField iconURL = PBField.initString("");
    public final PBStringField iconTitle = PBField.initString("");
    public final PBStringField pageTitle = PBField.initString("");
    public final PBStringField jumpURL = PBField.initString("");
    public final PBStringField taskURL = PBField.initString("");
    public INTERFACE$MiniGameBoxRedDot redDot = new INTERFACE$MiniGameBoxRedDot();
    public final PBInt64Field displayDuration = PBField.initInt64(0);
}
