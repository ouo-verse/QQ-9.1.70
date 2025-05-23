package com.tencent.mobileqq.tvideo.danmaku.vm;

import com.squareup.wire.ProtoAdapter;
import com.tencent.biz.qqcircle.immersive.layer.base.e;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.mobileqq.tvideo.danmaku.protocol.VideoDmSwitchRequest;
import com.tencent.mobileqq.tvideo.danmaku.protocol.VideoDmSwitchResponse;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.Video;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/tvideo/danmaku/vm/VideoDmSwitchViewModel;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/e;", "", "getLogTag", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lcom/tencent/mobileqq/tvideo/danmaku/protocol/VideoDmSwitchResponse;", "callback", "", "m2", "Ltvideo/Video;", "K", "Ltvideo/Video;", "getBean", "()Ltvideo/Video;", "bean", "Lcom/tencent/mobileqq/tvideo/danmaku/vm/VideoDmSwitchViewModel$TVideoDanmakuRequest;", "L", "Lcom/tencent/mobileqq/tvideo/danmaku/vm/VideoDmSwitchViewModel$TVideoDanmakuRequest;", "mBarrageListReq", "<init>", "(Ltvideo/Video;)V", "M", "a", "TVideoDanmakuRequest", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class VideoDmSwitchViewModel extends e {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Video bean;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private TVideoDanmakuRequest mBarrageListReq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0013\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001f\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/tvideo/danmaku/vm/VideoDmSwitchViewModel$TVideoDanmakuRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest;", "", "getCallee", "getFunc", "", "getRequestByteData", "T", "buffer", "decode", "([B)Ljava/lang/Object;", "cid", "Ljava/lang/String;", "getCid", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "vid", "getVid", "setVid", "<init>", "()V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class TVideoDanmakuRequest extends TVideoBaseRequest {

        @Nullable
        private String cid;

        @Nullable
        private String vid;

        public TVideoDanmakuRequest() {
            super(null, 1, null);
        }

        @Override // com.tencent.biz.richframework.network.request.BaseRequest
        public <T> T decode(@Nullable byte[] buffer) {
            ProtoAdapter<VideoDmSwitchResponse> protoAdapter = VideoDmSwitchResponse.ADAPTER;
            Intrinsics.checkNotNull(buffer);
            return (T) ((VideoDmSwitchResponse) protoAdapter.decode(buffer));
        }

        @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
        @NotNull
        public String getCallee() {
            return "trpc.growth.video_server.VideoServer";
        }

        @Nullable
        public final String getCid() {
            return this.cid;
        }

        @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
        @NotNull
        public String getFunc() {
            return "/trpc.growth.video_server.VideoServer/VideoDmSwitch";
        }

        @Override // com.tencent.biz.richframework.network.request.BaseRequest
        @NotNull
        /* renamed from: getRequestByteData */
        protected byte[] get$pbReqBytes() {
            VideoDmSwitchRequest.a aVar = new VideoDmSwitchRequest.a();
            aVar.f304418b = this.cid;
            aVar.f304417a = this.vid;
            return aVar.build().encode();
        }

        @Nullable
        public final String getVid() {
            return this.vid;
        }

        public final void setCid(@Nullable String str) {
            this.cid = str;
        }

        public final void setVid(@Nullable String str) {
            this.vid = str;
        }
    }

    public VideoDmSwitchViewModel(@NotNull Video bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.bean = bean;
        TVideoDanmakuRequest tVideoDanmakuRequest = new TVideoDanmakuRequest();
        this.mBarrageListReq = tVideoDanmakuRequest;
        tVideoDanmakuRequest.setCid(bean.video_base_info.cid);
        this.mBarrageListReq.setVid(bean.video_base_info.vid);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoDanmakuViewModel";
    }

    public final void m2(@NotNull VSDispatchObserver.OnVSRspCallBack<VideoDmSwitchResponse> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendRequest(this.mBarrageListReq, callback);
    }
}
