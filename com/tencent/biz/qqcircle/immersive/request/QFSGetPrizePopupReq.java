package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSpringPrizePopup$StActivityInfo;
import qqcircle.QQCircleSpringPrizePopup$StGetPrizePopupReq;
import qqcircle.QQCircleSpringPrizePopup$StGetPrizePopupRsp;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/request/QFSGetPrizePopupReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "activityId", "Ljava/lang/String;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "J", "_feedId", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSGetPrizePopupReq extends QCircleBaseRequest {

    @NotNull
    private final String _feedId;

    @NotNull
    private final String activityId;
    private final long taskId;

    public QFSGetPrizePopupReq(@NotNull String activityId, long j3, @NotNull String _feedId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(_feedId, "_feedId");
        this.activityId = activityId;
        this.taskId = j3;
        this._feedId = _feedId;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qqcircle.QQCircleSpringPrizePopup$StGetPrizePopupRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QQCircleSpringPrizePopup$StGetPrizePopupRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSGetPrizePopupReq", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.activitypopup.SpringPrizePopup.GetPrizePopup";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        QQCircleSpringPrizePopup$StGetPrizePopupReq qQCircleSpringPrizePopup$StGetPrizePopupReq = new QQCircleSpringPrizePopup$StGetPrizePopupReq();
        qQCircleSpringPrizePopup$StGetPrizePopupReq.popup_scene.set(1);
        QQCircleSpringPrizePopup$StActivityInfo qQCircleSpringPrizePopup$StActivityInfo = qQCircleSpringPrizePopup$StGetPrizePopupReq.activity_info;
        QQCircleSpringPrizePopup$StActivityInfo qQCircleSpringPrizePopup$StActivityInfo2 = new QQCircleSpringPrizePopup$StActivityInfo();
        qQCircleSpringPrizePopup$StActivityInfo2.activity_id.set(this.activityId);
        qQCircleSpringPrizePopup$StActivityInfo2.task_id.set(this.taskId);
        qQCircleSpringPrizePopup$StGetPrizePopupReq.f429314id.set(this._feedId);
        qQCircleSpringPrizePopup$StActivityInfo.set(qQCircleSpringPrizePopup$StActivityInfo2);
        byte[] byteArray = qQCircleSpringPrizePopup$StGetPrizePopupReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "StGetPrizePopupReq().app\u2026)\n        }.toByteArray()");
        return byteArray;
    }
}
