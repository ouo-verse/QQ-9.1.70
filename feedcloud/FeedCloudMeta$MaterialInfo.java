package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$MaterialInfo extends MessageMicro<FeedCloudMeta$MaterialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"id", "title", "buttonName", MiniBoxNoticeInfo.KEY_ICON_URL, "jumpURL"}, new Object[]{"", "", "", "", ""}, FeedCloudMeta$MaterialInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398443id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField buttonName = PBField.initString("");
    public final PBStringField iconURL = PBField.initString("");
    public final PBStringField jumpURL = PBField.initString("");
}
