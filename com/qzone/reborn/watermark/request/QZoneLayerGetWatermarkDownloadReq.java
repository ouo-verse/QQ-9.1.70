package com.qzone.reborn.watermark.request;

import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.Watermark$GetDownloadUrlReq;
import qzone.Watermark$GetDownloadUrlRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/watermark/request/QZoneLayerGetWatermarkDownloadReq;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "source", "", "urlList", "", "", "(ILjava/util/List;)V", "TAG", "mGetWatermarkDownloadReq", "Lqzone/Watermark$GetDownloadUrlReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public class QZoneLayerGetWatermarkDownloadReq extends QZoneBaseRequest {
    private final String TAG;
    private Watermark$GetDownloadUrlReq mGetWatermarkDownloadReq;

    public QZoneLayerGetWatermarkDownloadReq(int i3, List<String> urlList) {
        Intrinsics.checkNotNullParameter(urlList, "urlList");
        this.TAG = "QZoneLayerGetWatermarkDownloadReq";
        Watermark$GetDownloadUrlReq watermark$GetDownloadUrlReq = new Watermark$GetDownloadUrlReq();
        this.mGetWatermarkDownloadReq = watermark$GetDownloadUrlReq;
        watermark$GetDownloadUrlReq.source.set(i3);
        this.mGetWatermarkDownloadReq.urls.set(urlList);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.Watermark$GetDownloadUrlRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new Watermark$GetDownloadUrlRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(this.TAG, 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.watermark.Watermark.GetDownloadUrl";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetWatermarkDownloadReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetWatermarkDownloadReq.toByteArray()");
        return byteArray;
    }
}
