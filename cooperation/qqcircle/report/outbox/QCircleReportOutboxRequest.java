package cooperation.qqcircle.report.outbox;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudCommon$BytesEntry;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportOutboxRequest extends QCircleBaseRequest {
    public static final String KEY_RESPONSE_DATA = "response_data";
    private byte[] mRequestByteData;
    private String mRequestCmdName;

    public QCircleReportOutboxRequest(String str, byte[] bArr) {
        this.mRequestCmdName = str;
        this.mRequestByteData = bArr;
        setRetryCount(2);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return this.mRequestCmdName;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequestByteData;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
        feedCloudCommon$BytesEntry.key.set("response_data");
        feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(bArr));
        return feedCloudCommon$BytesEntry;
    }
}
