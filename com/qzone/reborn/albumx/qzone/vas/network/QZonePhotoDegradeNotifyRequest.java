package com.qzone.reborn.albumx.qzone.vas.network;

import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$QueryNotifyMsgReq;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/network/QZonePhotoDegradeNotifyRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgReq;", "mRequest", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgReq;", "", "scene", "<init>", "(I)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoDegradeNotifyRequest extends QZoneBaseRequest {
    private final QZonePhotoDegrade$QueryNotifyMsgReq mRequest;

    public QZonePhotoDegradeNotifyRequest(int i3) {
        QZonePhotoDegrade$QueryNotifyMsgReq qZonePhotoDegrade$QueryNotifyMsgReq = new QZonePhotoDegrade$QueryNotifyMsgReq();
        this.mRequest = qZonePhotoDegrade$QueryNotifyMsgReq;
        if (i3 > 0) {
            qZonePhotoDegrade$QueryNotifyMsgReq.scene.set(i3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZonePhotoDegrade$QueryNotifyMsgRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] responseData) {
        ?? r06 = (T) new QZonePhotoDegrade$QueryNotifyMsgRsp();
        try {
            r06.mergeFrom(responseData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZonePhotoDegradeNotifyRequest", 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.photo_degrade.PhotoNotify.QueryNotifyMsg";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mRequest.toByteArray()");
        return byteArray;
    }
}
