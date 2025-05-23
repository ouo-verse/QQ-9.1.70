package com.tencent.mobileqq.tvideo.danmaku.vm;

import com.tencent.biz.qqcircle.immersive.layer.base.e;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.danmaku.manager.TVideoDmDataProvider;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudRead$StGetBarrageListReq;
import feedcloud.FeedCloudRead$StGetBarrageListRsp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001eB\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/danmaku/vm/TVideoDmViewModel;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/e;", "", "getLogTag", "Lcom/tencent/mobileqq/tvideo/danmaku/manager/TVideoDmDataProvider$a;", "callback", "", ICustomDataEditor.NUMBER_PARAM_2, "Lux2/a;", "K", "Lux2/a;", "getBean", "()Lux2/a;", "bean", "", "L", "J", "getPlayTime", "()J", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "Lcom/tencent/mobileqq/tvideo/danmaku/vm/TVideoDmViewModel$TVideoDanmakuRequest;", "M", "Lcom/tencent/mobileqq/tvideo/danmaku/vm/TVideoDmViewModel$TVideoDanmakuRequest;", "getMBarrageListReq", "()Lcom/tencent/mobileqq/tvideo/danmaku/vm/TVideoDmViewModel$TVideoDanmakuRequest;", "mBarrageListReq", "<init>", "(Lux2/a;J)V", "N", "a", "TVideoDanmakuRequest", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoDmViewModel extends e {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ux2.a bean;

    /* renamed from: L, reason: from kotlin metadata */
    private final long playTime;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final TVideoDanmakuRequest mBarrageListReq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001f\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/danmaku/vm/TVideoDmViewModel$TVideoDanmakuRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest;", "", "getCallee", "getFunc", "", "getRequestByteData", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "feedUserID", "Ljava/lang/String;", "getFeedUserID", "()Ljava/lang/String;", "setFeedUserID", "(Ljava/lang/String;)V", "feedID", "getFeedID", "setFeedID", "", "feedPlayTime", "Ljava/lang/Long;", "getFeedPlayTime", "()Ljava/lang/Long;", "setFeedPlayTime", "(Ljava/lang/Long;)V", "<init>", "()V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class TVideoDanmakuRequest extends TVideoBaseRequest {

        @Nullable
        private String feedID;

        @Nullable
        private Long feedPlayTime;

        @Nullable
        private String feedUserID;

        public TVideoDanmakuRequest() {
            super(null, 1, null);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudRead$StGetBarrageListRsp] */
        @Override // com.tencent.biz.richframework.network.request.BaseRequest
        public <T> T decode(@Nullable byte[] bytes) {
            ?? r06 = (T) new FeedCloudRead$StGetBarrageListRsp();
            try {
                Object mergeFrom = r06.mergeFrom(bytes);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "response.mergeFrom(bytes)");
                return (T) ((FeedCloudRead$StGetBarrageListRsp) mergeFrom);
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

        @Nullable
        public final String getFeedID() {
            return this.feedID;
        }

        @Nullable
        public final Long getFeedPlayTime() {
            return this.feedPlayTime;
        }

        @Nullable
        public final String getFeedUserID() {
            return this.feedUserID;
        }

        @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
        @NotNull
        public String getFunc() {
            return "/trpc.growth.video_server.VideoServer/GetQQDmContent";
        }

        @Override // com.tencent.biz.richframework.network.request.BaseRequest
        @NotNull
        /* renamed from: getRequestByteData */
        protected byte[] get$pbReqBytes() {
            FeedCloudRead$StGetBarrageListReq feedCloudRead$StGetBarrageListReq = new FeedCloudRead$StGetBarrageListReq();
            feedCloudRead$StGetBarrageListReq.feedID.set(this.feedID);
            feedCloudRead$StGetBarrageListReq.feedUserID.set(this.feedUserID);
            Long l3 = this.feedPlayTime;
            if (l3 != null) {
                feedCloudRead$StGetBarrageListReq.feedPlayTime.set(l3.longValue());
            }
            QLog.d("TVideoDanmakuRequest", 4, "getRequestByteData request = " + feedCloudRead$StGetBarrageListReq);
            byte[] byteArray = feedCloudRead$StGetBarrageListReq.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
            return byteArray;
        }

        public final void setFeedID(@Nullable String str) {
            this.feedID = str;
        }

        public final void setFeedPlayTime(@Nullable Long l3) {
            this.feedPlayTime = l3;
        }

        public final void setFeedUserID(@Nullable String str) {
            this.feedUserID = str;
        }
    }

    public TVideoDmViewModel(@NotNull ux2.a bean, long j3) {
        VideoBaseInfo videoBaseInfo;
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.bean = bean;
        this.playTime = j3;
        Video c16 = bean.c();
        TVideoDanmakuRequest tVideoDanmakuRequest = new TVideoDanmakuRequest();
        this.mBarrageListReq = tVideoDanmakuRequest;
        if (c16 != null) {
            videoBaseInfo = c16.video_base_info;
        } else {
            videoBaseInfo = null;
        }
        if (videoBaseInfo != null) {
            tVideoDanmakuRequest.setFeedUserID(c16.video_base_info.cid);
            tVideoDanmakuRequest.setFeedID(c16.video_base_info.vid);
        }
        if (j3 >= 0) {
            tVideoDanmakuRequest.setFeedPlayTime(Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(TVideoDmDataProvider.a callback, TVideoDmViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetBarrageListRsp feedCloudRead$StGetBarrageListRsp) {
        Integer num;
        PBRepeatMessageField<FeedCloudMeta$StBarrage> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (feedCloudRead$StGetBarrageListRsp != null && (pBRepeatMessageField = feedCloudRead$StGetBarrageListRsp.vecBarrage) != null) {
            num = Integer.valueOf(pBRepeatMessageField.size());
        } else {
            num = null;
        }
        QLog.d("TVideoDanmakuViewModel", 4, "isSuccess=" + z16 + " \uff1b retCode=" + j3 + " \uff1b errMsg=" + str + " \uff1b rsp.size=" + num);
        if (z16 && feedCloudRead$StGetBarrageListRsp != null && feedCloudRead$StGetBarrageListRsp.vecBarrage != null && j3 == 0) {
            callback.onReceive(this$0.mBarrageListReq, z16, j3, str, feedCloudRead$StGetBarrageListRsp);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoDanmakuViewModel";
    }

    public final void n2(@NotNull final TVideoDmDataProvider.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendRequest(this.mBarrageListReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.danmaku.vm.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                TVideoDmViewModel.o2(TVideoDmDataProvider.a.this, this, baseRequest, z16, j3, str, (FeedCloudRead$StGetBarrageListRsp) obj);
            }
        });
    }
}
