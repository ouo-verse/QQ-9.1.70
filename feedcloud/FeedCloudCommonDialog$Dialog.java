package feedcloud;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudCommonDialog$Dialog extends MessageMicro<FeedCloudCommonDialog$Dialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{LinkReportConstant$BizKey.DIALOG_TYPE, "icon", "title", "content", "jump_url", "jump_text"}, new Object[]{0, "", "", "", "", ""}, FeedCloudCommonDialog$Dialog.class);
    public final PBUInt32Field dialog_type = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField jump_text = PBField.initString("");
}
