package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$CovenantLiteDialog extends MessageMicro<FeedCloudMeta$CovenantLiteDialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"type", "id", "icon_url", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, "title", "description", "internal_title", "jump_url", "template_id"}, new Object[]{0, "", "", "", "", "", "", "", ""}, FeedCloudMeta$CovenantLiteDialog.class);
    public final PBUInt32Field type = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398439id = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField background_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField internal_title = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField template_id = PBField.initString("");
}
