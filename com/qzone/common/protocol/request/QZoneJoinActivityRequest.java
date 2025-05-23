package com.qzone.common.protocol.request;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QzoneActivityPB$JoinActivityReq;
import qzone.QzoneActivityPB$JoinActivityRsp;
import qzone.QzoneActivityPB$KVInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B5\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/common/protocol/request/QZoneJoinActivityRequest;", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QzoneActivityPB$JoinActivityReq;", Const.BUNDLE_KEY_REQUEST, "Lqzone/QzoneActivityPB$JoinActivityReq;", "getRequest", "()Lqzone/QzoneActivityPB$JoinActivityReq;", "scene", "tid", "cookie", "", "Lqzone/QzoneActivityPB$KVInfo;", "kvInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneJoinActivityRequest extends VSBaseRequest {
    private final QzoneActivityPB$JoinActivityReq request;

    public QZoneJoinActivityRequest(String str, String str2, String str3, List<QzoneActivityPB$KVInfo> list) {
        QzoneActivityPB$JoinActivityReq qzoneActivityPB$JoinActivityReq = new QzoneActivityPB$JoinActivityReq();
        this.request = qzoneActivityPB$JoinActivityReq;
        if (str != null) {
            qzoneActivityPB$JoinActivityReq.join_scene.set(str, true);
        }
        if (str2 != null) {
            qzoneActivityPB$JoinActivityReq.tid.set(str2, true);
        }
        if (str3 != null) {
            qzoneActivityPB$JoinActivityReq.cookie.set(str3, true);
        }
        if (list != null) {
            qzoneActivityPB$JoinActivityReq.kf_infos.addAll(list);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QzoneActivityPB$JoinActivityRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QzoneActivityPB$JoinActivityRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZoneJoinActivityRequest", 1, "decode fail: ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qzone.qzone_activity.QzoneActivityWrite.JoinActivity";
    }

    public final QzoneActivityPB$JoinActivityReq getRequest() {
        return this.request;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
