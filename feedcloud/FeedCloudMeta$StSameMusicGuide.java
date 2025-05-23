package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StSameMusicGuide extends MessageMicro<FeedCloudMeta$StSameMusicGuide> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"isButtonDisplayed", "displayDelayTime", "buttonSchema"}, new Object[]{Boolean.FALSE, 0, ""}, FeedCloudMeta$StSameMusicGuide.class);
    public final PBBoolField isButtonDisplayed = PBField.initBool(false);
    public final PBUInt32Field displayDelayTime = PBField.initUInt32(0);
    public final PBStringField buttonSchema = PBField.initString("");
}
