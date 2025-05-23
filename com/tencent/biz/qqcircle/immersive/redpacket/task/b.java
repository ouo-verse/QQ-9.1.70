package com.tencent.biz.qqcircle.immersive.redpacket.task;

import android.os.Bundle;
import com.tencent.biz.qqcircle.immersive.redpacket.request.QFSAddRedPacketRequest;
import com.tencent.biz.qqcircle.immersive.redpacket.task.o;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudDatacard$AddRedPocketCoverRsp;
import feedcloud.FeedCloudMeta$StImage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0004\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/b;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/e;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "", "a", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", "d", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/b$a;", "b", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/b$a;", "addRedPacketCallback", "c", "()Ljava/lang/String;", "tag", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends e<AddRedPacketCoverData> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a addRedPacketCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J@\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/b$a;", "Lcom/tencent/richframework/sender/call/Call$OnRspCallBack;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "isSuccess", "", "retCode", "", "errMsg", Const.BUNDLE_KEY_REQUEST, "", "rspObj", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "a", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "d", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "e", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements Call.OnRspCallBack<QCircleBaseRequest> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AddRedPacketCoverData data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final o<AddRedPacketCoverData> callback;

        public a(@NotNull AddRedPacketCoverData data, @NotNull o<AddRedPacketCoverData> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.data = data;
            this.callback = callback;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable QCircleBaseRequest request, @Nullable Object rspObj, @Nullable Bundle extraData) {
            String str;
            if (request != null) {
                str = request.getTraceId();
            } else {
                str = null;
            }
            QLog.d("AddRedPacketCoverProcess", 1, "AddRedPacketCallback, onReceive, traceId: " + str + ", isSuccess: " + isSuccess + ", retCode: " + retCode + ", errMsg: " + errMsg);
            if (rspObj instanceof FeedCloudDatacard$AddRedPocketCoverRsp) {
                if (isSuccess && retCode == 0) {
                    this.data.j(((FeedCloudDatacard$AddRedPocketCoverRsp) rspObj).cover_info.get());
                    this.callback.onSuccess(this.data);
                } else {
                    o.a.a(this.callback, null, 1, null);
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    @NotNull
    public String a() {
        return "AddRedPacketCoverProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e
    @NotNull
    public String c() {
        return "AddRedPacketCoverProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull AddRedPacketCoverData data, @NotNull o<AddRedPacketCoverData> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("AddRedPacketCoverProcess", 1, "doProcess, data:" + data);
        ImageResult staticCover = data.getStaticCover();
        ImageResult apngCover = data.getApngCover();
        if (staticCover != null && apngCover != null) {
            QCircleRequestCall b16 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
            String str = data.getPreviewBean().getFeed().poster.f398463id.get();
            Intrinsics.checkNotNullExpressionValue(str, "data.previewBean.feed.poster.id.get()");
            String str2 = data.getPreviewBean().getFeed().f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str2, "data.previewBean.feed.id.get()");
            long j3 = data.getPreviewBean().getFeed().createTime.get();
            FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
            feedCloudMeta$StImage.picUrl.set(apngCover.getBigUrl());
            feedCloudMeta$StImage.width.set(apngCover.getBigWidth());
            feedCloudMeta$StImage.height.set(apngCover.getBigHeight());
            feedCloudMeta$StImage.imageMD5.set(apngCover.getMd5());
            Unit unit = Unit.INSTANCE;
            FeedCloudMeta$StImage feedCloudMeta$StImage2 = new FeedCloudMeta$StImage();
            feedCloudMeta$StImage2.picUrl.set(staticCover.getBigUrl());
            feedCloudMeta$StImage2.width.set(staticCover.getBigWidth());
            feedCloudMeta$StImage2.height.set(staticCover.getBigHeight());
            feedCloudMeta$StImage2.imageMD5.set(staticCover.getMd5());
            BaseCall<QCircleBaseRequest> addRequest = b16.addRequest(new QFSAddRedPacketRequest.a(str, str2, j3, feedCloudMeta$StImage, feedCloudMeta$StImage2).a());
            a aVar = new a(data, callback);
            this.addRedPacketCallback = aVar;
            addRequest.m250setRspOnCallBack((Call.OnRspCallBack) aVar).execute();
            return;
        }
        QLog.w("AddRedPacketCoverProcess", 1, "doProcess, staticCover or apngCover is null ");
        o.a.a(callback, null, 1, null);
    }
}
