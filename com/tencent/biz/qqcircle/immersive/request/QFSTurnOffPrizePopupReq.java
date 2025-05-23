package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSpringPrizePopup$StTurnOffPrizePopupReq;
import qqcircle.QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/request/QFSTurnOffPrizePopupReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "popupId", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSTurnOffPrizePopupReq extends QCircleBaseRequest {

    @NotNull
    private final String popupId;

    public QFSTurnOffPrizePopupReq(@NotNull String popupId) {
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        this.popupId = popupId;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qqcircle.QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp>() { // from class: qqcircle.QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp.class);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSTurnOffPrizePopupReq", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.activitypopup.SpringPrizePopup.TurnOffPrizePopup";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        QQCircleSpringPrizePopup$StTurnOffPrizePopupReq qQCircleSpringPrizePopup$StTurnOffPrizePopupReq = new QQCircleSpringPrizePopup$StTurnOffPrizePopupReq();
        qQCircleSpringPrizePopup$StTurnOffPrizePopupReq.popup_id.set(this.popupId);
        byte[] byteArray = qQCircleSpringPrizePopup$StTurnOffPrizePopupReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "StTurnOffPrizePopupReq()\u2026)\n        }.toByteArray()");
        return byteArray;
    }
}
