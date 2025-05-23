package feedcloud;

import com.qzone.widget.v;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StIconDecorate extends MessageMicro<FeedCloudMeta$StIconDecorate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 82}, new String[]{"mainpageUrl", "layerUrl", "endTime", "id", v.COLUMN_COMMENT_URL, "jumpInfo"}, new Object[]{"", "", 0L, "", "", null}, FeedCloudMeta$StIconDecorate.class);
    public final PBStringField mainpageUrl = PBField.initString("");
    public final PBStringField layerUrl = PBField.initString("");
    public final PBUInt64Field endTime = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398453id = PBField.initString("");
    public final PBStringField comment_url = PBField.initString("");
    public FeedCloudMeta$DecorateJumpInfo jumpInfo = new FeedCloudMeta$DecorateJumpInfo();
}
