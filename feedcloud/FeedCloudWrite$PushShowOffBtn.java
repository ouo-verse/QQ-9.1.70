package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$PushShowOffBtn extends MessageMicro<FeedCloudWrite$PushShowOffBtn> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"url", "id", "jump_url", "ext_info"}, new Object[]{"", "", "", null}, FeedCloudWrite$PushShowOffBtn.class);
    public final PBStringField url = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398480id = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
