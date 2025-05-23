package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc010001;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudEeveeUndealmsg$BizUndealMsg extends MessageMicro<FeedCloudEeveeUndealmsg$BizUndealMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"result", "msgid", QCircleLpReportDc010001.KEY_MAINTYPE, "subid", "bufferData"}, new Object[]{null, "", 0, 0, ByteStringMicro.EMPTY}, FeedCloudEeveeUndealmsg$BizUndealMsg.class);
    public FeedCloudCommon$Result result = new FeedCloudCommon$Result();
    public final PBStringField msgid = PBField.initString("");
    public final PBInt32Field mainType = PBField.initInt32(0);
    public final PBInt32Field subid = PBField.initInt32(0);
    public final PBBytesField bufferData = PBField.initBytes(ByteStringMicro.EMPTY);
}
