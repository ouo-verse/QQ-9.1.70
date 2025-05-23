package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tianshu.QQCircleTianShu$AdItem;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$GuideResource extends MessageMicro<FeedCloudPubGuideSvr$GuideResource> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"back_img", "main_title", "sub_title", "guide_word", "btn_word", "jump_url", "thumbnail_img", "ad_item", "guide_tag"}, new Object[]{"", "", "", "", "", "", "", null, ""}, FeedCloudPubGuideSvr$GuideResource.class);
    public final PBStringField back_img = PBField.initString("");
    public final PBStringField main_title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField guide_word = PBField.initString("");
    public final PBStringField btn_word = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField thumbnail_img = PBField.initString("");
    public QQCircleTianShu$AdItem ad_item = new QQCircleTianShu$AdItem();
    public final PBStringField guide_tag = PBField.initString("");
}
