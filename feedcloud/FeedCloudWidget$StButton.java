package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWidget$StButton extends MessageMicro<FeedCloudWidget$StButton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"name", WadlProxyConsts.KEY_JUMP_URL, "buttonValue", "type", "datongJsonData", "style"}, new Object[]{"", "", 0, 0, "", null}, FeedCloudWidget$StButton.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBUInt32Field buttonValue = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField datongJsonData = PBField.initString("");
    public FeedCloudWidget$StButtonStyle style = new FeedCloudWidget$StButtonStyle();
}
