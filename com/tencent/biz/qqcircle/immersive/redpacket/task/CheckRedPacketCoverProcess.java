package com.tencent.biz.qqcircle.immersive.redpacket.task;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqcircle.immersive.redpacket.request.QFSGetRedPacketRequest;
import com.tencent.biz.qqcircle.immersive.redpacket.task.o;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudDatacard$GetRedPocketCoverRsp;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\n\u001a\u000eB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/CheckRedPacketCoverProcess;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/e;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", "e", "g", "", "a", "f", "cancel", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/CheckRedPacketCoverProcess$CheckRedPacketRunnable;", "b", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/CheckRedPacketCoverProcess$CheckRedPacketRunnable;", "checkRedPacketCoverTask", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/CheckRedPacketCoverProcess$a;", "c", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/CheckRedPacketCoverProcess$a;", "checkRedPacketCallback", "()Ljava/lang/String;", "tag", "<init>", "()V", "d", "CheckRedPacketRunnable", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class CheckRedPacketCoverProcess extends e<AddRedPacketCoverData> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile CheckRedPacketRunnable checkRedPacketCoverTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a checkRedPacketCallback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/CheckRedPacketCoverProcess$CheckRedPacketRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "action", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class CheckRedPacketRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> action;

        public CheckRedPacketRunnable(@NotNull Function0<Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.action = action;
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("CheckRedPacketCoverProcess", 1, "CheckRedPacketRunnable, run ");
            this.action.invoke();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J@\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/CheckRedPacketCoverProcess$a;", "Lcom/tencent/richframework/sender/call/Call$OnRspCallBack;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "isSuccess", "", "retCode", "", "errMsg", Const.BUNDLE_KEY_REQUEST, "", "rspObj", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "a", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "d", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "e", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
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
            QLog.d("CheckRedPacketCoverProcess", 1, "CheckRedPacketCallback, onReceive, traceId: " + str + ", isSuccess: " + isSuccess + ", retCode: " + retCode + ", errMsg: " + errMsg);
            if (rspObj instanceof FeedCloudDatacard$GetRedPocketCoverRsp) {
                if (isSuccess && retCode == 0) {
                    this.data.j(((FeedCloudDatacard$GetRedPocketCoverRsp) rspObj).cover.get());
                    this.callback.onSuccess(this.data);
                } else {
                    o.a.a(this.callback, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(AddRedPacketCoverData data, o<AddRedPacketCoverData> callback) {
        QLog.d("CheckRedPacketCoverProcess", 1, "checkRedPacketCover, data:" + data);
        QCircleRequestCall b16 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
        FeedCloudDatacard$RedPocketCoverInfo coverInfo = data.getCoverInfo();
        Intrinsics.checkNotNull(coverInfo);
        String str = coverInfo.f398428id.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.coverInfo!!.id.get()");
        BaseCall<QCircleBaseRequest> addRequest = b16.addRequest(new QFSGetRedPacketRequest.a(str).a());
        a aVar = new a(data, callback);
        this.checkRedPacketCallback = aVar;
        addRequest.m250setRspOnCallBack((Call.OnRspCallBack) aVar).execute();
    }

    private final void g() {
        CheckRedPacketRunnable checkRedPacketRunnable = this.checkRedPacketCoverTask;
        if (checkRedPacketRunnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(checkRedPacketRunnable);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    @NotNull
    public String a() {
        return "CheckRedPacketCoverProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e
    @NotNull
    public String c() {
        return "CheckRedPacketCoverProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e, com.tencent.biz.qqcircle.immersive.redpacket.task.p
    public void cancel() {
        super.cancel();
        g();
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull final AddRedPacketCoverData data, @NotNull final o<AddRedPacketCoverData> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("CheckRedPacketCoverProcess", 1, "doProcess, data:" + data);
        if (data.getCoverInfo() == null) {
            QLog.w("CheckRedPacketCoverProcess", 1, "doProcess, coverInfo is null ");
            o.a.a(callback, null, 1, null);
            return;
        }
        g();
        Handler uIHandler = RFWThreadManager.getUIHandler();
        CheckRedPacketRunnable checkRedPacketRunnable = new CheckRedPacketRunnable(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.task.CheckRedPacketCoverProcess$doProcess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CheckRedPacketCoverProcess.this.e(data, callback);
            }
        });
        this.checkRedPacketCoverTask = checkRedPacketRunnable;
        uIHandler.postDelayed(checkRedPacketRunnable, 3000L);
    }
}
