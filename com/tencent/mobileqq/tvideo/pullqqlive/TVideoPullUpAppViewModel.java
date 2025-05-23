package com.tencent.mobileqq.tvideo.pullqqlive;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\f\rB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/pullqqlive/TVideoPullUpAppViewModel;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lcom/tencent/mobileqq/tvideo/pullqqlive/TVideoPullUpAppProto$GetPullUpAppEntranceResponse;", "callBack", "", "L1", "", "getLogTag", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "TVideoDanmakuRequest", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoPullUpAppViewModel extends com.tencent.biz.qqcircle.viewmodels.a {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/pullqqlive/TVideoPullUpAppViewModel$TVideoDanmakuRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest;", "()V", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCallee", "", "getFunc", "getRequestByteData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class TVideoDanmakuRequest extends TVideoBaseRequest {
        public TVideoDanmakuRequest() {
            super(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.tvideo.pullqqlive.TVideoPullUpAppProto$GetPullUpAppEntranceResponse, T, com.tencent.mobileqq.pb.MessageMicro] */
        @Override // com.tencent.biz.richframework.network.request.BaseRequest
        public <T> T decode(@Nullable byte[] bytes) {
            ?? r06 = (T) new TVideoPullUpAppProto$GetPullUpAppEntranceResponse();
            try {
                Object mergeFrom = r06.mergeFrom(bytes);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "response.mergeFrom(bytes)");
                return (T) ((TVideoPullUpAppProto$GetPullUpAppEntranceResponse) mergeFrom);
            } catch (IOException e16) {
                e16.printStackTrace();
                return r06;
            }
        }

        @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
        @NotNull
        public String getCallee() {
            return "trpc.growth.video_server.VideoServer";
        }

        @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
        @NotNull
        public String getFunc() {
            return "/trpc.growth.video_server.VideoServer/GetPullUpAppEntrance";
        }

        @Override // com.tencent.biz.richframework.network.request.BaseRequest
        @NotNull
        protected byte[] getRequestByteData() {
            byte[] byteArray = new MessageMicro<TVideoPullUpAppProto$GetPullUpAppEntranceRequest>() { // from class: com.tencent.mobileqq.tvideo.pullqqlive.TVideoPullUpAppProto$GetPullUpAppEntranceRequest
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TVideoPullUpAppProto$GetPullUpAppEntranceRequest.class);
            }.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
            return byteArray;
        }
    }

    public final void L1(@NotNull VSDispatchObserver.OnVSRspCallBack<TVideoPullUpAppProto$GetPullUpAppEntranceResponse> callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        sendRequest(new TVideoDanmakuRequest(), callBack);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoPullUpAppViewModel";
    }
}
