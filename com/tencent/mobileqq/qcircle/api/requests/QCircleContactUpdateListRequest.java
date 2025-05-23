package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFriendFeedMomentReader$SsoReadReq;
import qqcircle.QQCircleFriendFeedMomentReader$SsoReadRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u0010\u001a\u00020\nH\u0014J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/requests/QCircleContactUpdateListRequest;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "lastClkUin", "", "(J)V", "mReq", "Lqqcircle/QQCircleFriendFeedMomentReader$SsoReadReq;", "decode", "T", WebViewPlugin.KEY_RESPONSE, "", "([B)Ljava/lang/Object;", "getCmdName", "", "getFinalRequestData", "requestByte", "getRequestByteData", "parseResponseHeadInfo", "", "", "bytes", "([B)[Ljava/lang/Object;", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCircleContactUpdateListRequest extends BaseRequest {

    @NotNull
    private final QQCircleFriendFeedMomentReader$SsoReadReq mReq;

    public QCircleContactUpdateListRequest(long j3) {
        QQCircleFriendFeedMomentReader$SsoReadReq qQCircleFriendFeedMomentReader$SsoReadReq = new QQCircleFriendFeedMomentReader$SsoReadReq();
        this.mReq = qQCircleFriendFeedMomentReader$SsoReadReq;
        qQCircleFriendFeedMomentReader$SsoReadReq.last_uin.set(j3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qqcircle.QQCircleFriendFeedMomentReader$SsoReadRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] responseData) {
        ?? r06 = (T) new QQCircleFriendFeedMomentReader$SsoReadRsp();
        try {
            r06.mergeFrom(responseData);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.videocircle.friend_feed_moment_reader.FriendFeedMomentReader.SsoRead";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getFinalRequestData(@Nullable byte[] requestByte) {
        if (requestByte == null) {
            return new byte[0];
        }
        return requestByte;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public Object[] parseResponseHeadInfo(@Nullable byte[] bytes) {
        byte[] a16 = fh.a(bytes);
        Intrinsics.checkNotNullExpressionValue(a16, "getWupBuff(bytes)");
        return new Object[]{0L, "", a16};
    }
}
