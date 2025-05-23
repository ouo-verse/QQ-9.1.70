package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetNoticeCategoriesPageRsp extends MessageMicro<FeedCloudRead$StGetNoticeCategoriesPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 64, 72}, new String[]{"ext", "top_items", "items", "tatal_count", PictureConst.KEY_HAS_MORE, "attach_info", "red_point_bytes", "rsp_timestamp", "last_read_timestamp"}, new Object[]{null, null, null, 0, Boolean.FALSE, "", ByteStringMicro.EMPTY, 0L, 0L}, FeedCloudRead$StGetNoticeCategoriesPageRsp.class);
    public FeedCloudCommon$StCommonExt ext = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$StNoticeCategoryItem> top_items = PBField.initRepeatMessage(FeedCloudRead$StNoticeCategoryItem.class);
    public final PBRepeatMessageField<FeedCloudRead$StNoticeCategoryItem> items = PBField.initRepeatMessage(FeedCloudRead$StNoticeCategoryItem.class);
    public final PBUInt32Field tatal_count = PBField.initUInt32(0);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBytesField red_point_bytes = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field rsp_timestamp = PBField.initInt64(0);
    public final PBInt64Field last_read_timestamp = PBField.initInt64(0);
}
