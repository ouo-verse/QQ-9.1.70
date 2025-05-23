package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetNoticeCategoriesPageReq extends MessageMicro<FeedCloudRead$StGetNoticeCategoriesPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 56}, new String[]{"ext", "count", "attach_info", "scene", QCircleSchemeAttr.NoticeList.DRAWER_ID, PictureConst.KEY_CATEGORY_ID, "quick_thank_timestamp"}, new Object[]{null, 0, "", 0, 0, 0, 0L}, FeedCloudRead$StGetNoticeCategoriesPageReq.class);
    public FeedCloudCommon$StCommonExt ext = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBInt32Field drawer_id = PBField.initInt32(0);
    public final PBEnumField category_id = PBField.initEnum(0);
    public final PBInt64Field quick_thank_timestamp = PBField.initInt64(0);
}
