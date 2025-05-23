package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagCategoryRecomReq extends MessageMicro<FeedCloudTagcategorysvr$StTagCategoryRecomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"gpsInfo", "picRecomMap", "reqType", "musicID", "picBufferList"}, new Object[]{null, null, 0, "", ByteStringMicro.EMPTY}, FeedCloudTagcategorysvr$StTagCategoryRecomReq.class);
    public FeedCloudMeta$StGPSV2 gpsInfo = new FeedCloudMeta$StGPSV2();
    public final PBRepeatMessageField<FeedCloudTagcategorysvr$PicRecomEntry> picRecomMap = PBField.initRepeatMessage(FeedCloudTagcategorysvr$PicRecomEntry.class);
    public final PBInt32Field reqType = PBField.initInt32(0);
    public final PBStringField musicID = PBField.initString("");
    public final PBRepeatField<ByteStringMicro> picBufferList = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
