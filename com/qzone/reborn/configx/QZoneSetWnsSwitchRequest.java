package com.qzone.reborn.configx;

import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.qzoneWnsSwitch$SetWnsSwitchReq;
import qzone.qzoneWnsSwitch$SetWnsSwitchRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/configx/QZoneSetWnsSwitchRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/qzoneWnsSwitch$SetWnsSwitchReq;", Const.BUNDLE_KEY_REQUEST, "Lqzone/qzoneWnsSwitch$SetWnsSwitchReq;", "secondKey", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneSetWnsSwitchRequest extends QZoneIntimateBaseRequest {
    private final qzoneWnsSwitch$SetWnsSwitchReq request;

    public QZoneSetWnsSwitchRequest(String secondKey, String value) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        Intrinsics.checkNotNullParameter(value, "value");
        qzoneWnsSwitch$SetWnsSwitchReq qzonewnsswitch_setwnsswitchreq = new qzoneWnsSwitch$SetWnsSwitchReq();
        this.request = qzonewnsswitch_setwnsswitchreq;
        qzonewnsswitch_setwnsswitchreq.f430357sw.setHasFlag(true);
        qzonewnsswitch_setwnsswitchreq.f430357sw.key.set("qzone_wns." + secondKey);
        qzonewnsswitch_setwnsswitchreq.f430357sw.value.set(value);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.qzoneWnsSwitch$SetWnsSwitchRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<qzoneWnsSwitch$SetWnsSwitchRsp>() { // from class: qzone.qzoneWnsSwitch$SetWnsSwitchRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], qzoneWnsSwitch$SetWnsSwitchRsp.class);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZoneSetWnsSwitchRequest", 1, "exception is " + e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_circle_switch.WnsSwitch.SetWnsSwitch";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
