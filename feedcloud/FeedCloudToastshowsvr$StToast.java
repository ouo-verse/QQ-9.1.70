package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudToastshowsvr$StToast extends MessageMicro<FeedCloudToastshowsvr$StToast> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData;
    public final PBBytesField busiReport;
    public final PBInt64Field pushTime;
    public final PBStringField toastId = PBField.initString("");
    public final PBUInt32Field toastType = PBField.initUInt32(0);
    public FeedCloudToastshowsvr$StToastContent toastContent = new FeedCloudToastshowsvr$StToastContent();
    public FeedCloudToastshowsvr$StShowControl showControl = new FeedCloudToastshowsvr$StShowControl();

    static {
        String[] strArr = {"toastId", "toastType", "toastContent", "showControl", "busiReport", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "pushTime"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56}, strArr, new Object[]{"", 0, null, null, byteStringMicro, byteStringMicro, 0L}, FeedCloudToastshowsvr$StToast.class);
    }

    public FeedCloudToastshowsvr$StToast() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiReport = PBField.initBytes(byteStringMicro);
        this.busiData = PBField.initBytes(byteStringMicro);
        this.pushTime = PBField.initInt64(0L);
    }
}
