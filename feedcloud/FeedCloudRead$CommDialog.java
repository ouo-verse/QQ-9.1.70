package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$CommDialog extends MessageMicro<FeedCloudRead$CommDialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"title", "text", "jump_infos", "ok_btn_text", "cancel_btn_text", "check_box_text"}, new Object[]{"", "", null, "", "", ""}, FeedCloudRead$CommDialog.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$DialogJumpInfo> jump_infos = PBField.initRepeatMessage(FeedCloudRead$DialogJumpInfo.class);
    public final PBStringField ok_btn_text = PBField.initString("");
    public final PBStringField cancel_btn_text = PBField.initString("");
    public final PBStringField check_box_text = PBField.initString("");
}
