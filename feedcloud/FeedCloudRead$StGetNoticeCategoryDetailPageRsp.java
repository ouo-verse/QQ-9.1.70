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
public final class FeedCloudRead$StGetNoticeCategoryDetailPageRsp extends MessageMicro<FeedCloudRead$StGetNoticeCategoryDetailPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58}, new String[]{"ext", "notices", "tatal_count", PictureConst.KEY_HAS_MORE, "attach_info", "last_read_timestamp", "red_point_bytes"}, new Object[]{null, null, 0, Boolean.FALSE, "", 0L, ByteStringMicro.EMPTY}, FeedCloudRead$StGetNoticeCategoryDetailPageRsp.class);
    public FeedCloudCommon$StCommonExt ext = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StNotice> notices = PBField.initRepeatMessage(FeedCloudMeta$StNotice.class);
    public final PBUInt32Field tatal_count = PBField.initUInt32(0);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt64Field last_read_timestamp = PBField.initInt64(0);
    public final PBBytesField red_point_bytes = PBField.initBytes(ByteStringMicro.EMPTY);
}
