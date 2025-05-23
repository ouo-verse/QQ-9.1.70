package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudViewHistory$StDelViewHistoryReq extends MessageMicro<FeedCloudViewHistory$StDelViewHistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{PictureConst.KEY_DEL_TYPE}, new Object[]{0}, FeedCloudViewHistory$StDelViewHistoryReq.class);
    public final PBEnumField del_type = PBField.initEnum(0);
}
