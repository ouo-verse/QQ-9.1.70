package feedcloud;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$DialogJumpInfo extends MessageMicro<FeedCloudRead$DialogJumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QCircleSchemeAttr.Detail.KEY_WORD, "jump_url"}, new Object[]{"", ""}, FeedCloudRead$DialogJumpInfo.class);
    public final PBStringField key_word = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
