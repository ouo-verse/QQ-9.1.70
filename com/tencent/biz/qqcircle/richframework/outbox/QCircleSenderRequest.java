package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$BytesEntry;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSenderRequest extends QCircleBaseRequest {
    public static final String KEY_RESPONSE_DATA = "response_data";
    private byte[] mRequestByteData;
    private String mRequestCmdName;
    private long[] mRequestRetCodes;

    public QCircleSenderRequest(String str, byte[] bArr) {
        this.mRequestRetCodes = null;
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

    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public long[] getRetryRetCodes() {
        return this.mRequestRetCodes;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
        feedCloudCommon$BytesEntry.key.set("response_data");
        feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(bArr));
        return feedCloudCommon$BytesEntry;
    }

    public QCircleSenderRequest(String str, byte[] bArr, long[] jArr) {
        this.mRequestCmdName = str;
        this.mRequestByteData = bArr;
        this.mRequestRetCodes = jArr;
        setRetryCount(2);
    }
}
