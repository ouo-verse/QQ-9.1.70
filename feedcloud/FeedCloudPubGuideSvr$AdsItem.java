package feedcloud;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$AdsItem extends MessageMicro<FeedCloudPubGuideSvr$AdsItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"id", "title", "desc", "back_img", "jump_url", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "material_id", "icon_url"}, new Object[]{"", "", "", "", "", "", "", ""}, FeedCloudPubGuideSvr$AdsItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398467id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField back_img = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField material_id = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
}
