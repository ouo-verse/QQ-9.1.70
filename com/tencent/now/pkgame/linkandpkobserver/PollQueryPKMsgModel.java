package com.tencent.now.pkgame.linkandpkobserver;

import android.os.Handler;
import android.os.Looper;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.now.sso.request.GetAnchorPKInfoRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import g55.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001$\u0018\u0000 \b2\u00020\u0001:\u0002\u0015\u0018B\u0007\u00a2\u0006\u0004\b,\u0010-J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel;", "", "", "roomId", "Lko3/c;", "Lg55/q;", "callback", "", h.F, "", WidgetCacheConstellationData.INTERVAL, "i", "data", "j", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$b;", "queryListener", DomainData.DOMAIN_NAME, "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "a", "I", "queryIntervalMS", "b", "Ljava/lang/Long;", "c", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$b;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "d", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "com/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$c", "f", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$c;", "getAnchorPKInfoCallback", "Ljava/lang/Runnable;", "g", "Ljava/lang/Runnable;", "queryRunnable", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PollQueryPKMsgModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int queryIntervalMS = 2000;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b queryListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c getAnchorPKInfoCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable queryRunnable;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$b;", "", "Lg55/q;", "rsp", "", "isInPK", "", "pkType", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(@NotNull q rsp, boolean isInPK, int pkType);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$c", "Lko3/c;", "Lg55/q;", "data", "", "a", "", "code", "", "msg", "fail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements ko3.c<q> {
        c() {
        }

        @Override // ko3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable q data) {
            if (PollQueryPKMsgModel.this.queryListener == null) {
                AegisLogger.INSTANCE.e("PK_Biz|PollQueryPKMsgModel", "getAnchorPKInfoCallback", "already call stopPollQueryPKMsg.");
                return;
            }
            if (data != null) {
                PollQueryPKMsgModel pollQueryPKMsgModel = PollQueryPKMsgModel.this;
                AegisLogger.INSTANCE.d("PK_Biz|PollQueryPKMsgModel", "callback: roomId: " + pollQueryPKMsgModel.roomId + ", pkType:" + data.f401383f + ", pkStatus:" + data.f401381d);
                pollQueryPKMsgModel.j(data);
            }
            if (data != null) {
                int i3 = data.f401382e;
                PollQueryPKMsgModel pollQueryPKMsgModel2 = PollQueryPKMsgModel.this;
                if (i3 >= 1) {
                    pollQueryPKMsgModel2.queryIntervalMS = i3 * 1000;
                }
            }
            PollQueryPKMsgModel pollQueryPKMsgModel3 = PollQueryPKMsgModel.this;
            pollQueryPKMsgModel3.i(pollQueryPKMsgModel3.queryIntervalMS);
        }

        @Override // ko3.c
        public void fail(int code, @Nullable String msg2) {
            PollQueryPKMsgModel pollQueryPKMsgModel = PollQueryPKMsgModel.this;
            pollQueryPKMsgModel.i(pollQueryPKMsgModel.queryIntervalMS);
        }
    }

    public PollQueryPKMsgModel() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.handler = new Handler(Looper.getMainLooper());
        this.getAnchorPKInfoCallback = new c();
        this.queryRunnable = new Runnable() { // from class: com.tencent.now.pkgame.linkandpkobserver.d
            @Override // java.lang.Runnable
            public final void run() {
                PollQueryPKMsgModel.l(PollQueryPKMsgModel.this);
            }
        };
    }

    private final void h(long roomId, final ko3.c<q> callback) {
        AegisLogger.INSTANCE.i("PK_Biz|PollQueryPKMsgModel", "getAnchorPKInfo --> roomId: " + roomId);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetAnchorPKInfoRequest(roomId), new Function1<QQLiveResponse<q>, Unit>() { // from class: com.tencent.now.pkgame.linkandpkobserver.PollQueryPKMsgModel$getAnchorPKInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<q> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<q> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                q rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|PollQueryPKMsgModel", "getAnchorPKInfo", "success");
                    callback.success(rsp);
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|PollQueryPKMsgModel", "getAnchorPKInfo", "fail, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                ko3.c<q> cVar = callback;
                int retCode = (int) response.getRetCode();
                String errMsg = response.getErrMsg();
                if (errMsg == null) {
                    errMsg = "";
                }
                cVar.fail(retCode, errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int interval) {
        AegisLogger.INSTANCE.i("PK_Biz|PollQueryPKMsgModel", "getAnchorPKInfoForDelay, interval: " + interval);
        if (this.queryListener != null) {
            this.handler.removeCallbacks(this.queryRunnable);
            this.handler.postDelayed(this.queryRunnable, interval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(q data) {
        int i3 = data.f401383f;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                boolean c16 = com.tencent.now.linkscreengame.model.b.f338501a.c(data);
                b bVar = this.queryListener;
                if (bVar != null) {
                    bVar.a(data, c16, data.f401383f);
                    return;
                }
                return;
            }
            return;
        }
        boolean c17 = com.tencent.now.linkscreengame.model.b.f338501a.c(data);
        b bVar2 = this.queryListener;
        if (bVar2 != null) {
            bVar2.a(data, c17, data.f401383f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(PollQueryPKMsgModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.queryListener == null) {
            AegisLogger.INSTANCE.e("PK_Biz|PollQueryPKMsgModel", "queryRunnable", "queryListener\u4e3anull\uff0c\u4e0d\u53d1\u51fa\u8bf7\u6c42\u3002");
            return;
        }
        Long l3 = this$0.roomId;
        if (l3 != null) {
            this$0.h(l3.longValue(), this$0.getAnchorPKInfoCallback);
        }
    }

    public final boolean k() {
        if (this.queryListener != null) {
            return true;
        }
        return false;
    }

    public final void m() {
        if (this.roomId != null && this.queryListener != null) {
            i(200);
        } else {
            AegisLogger.INSTANCE.e("PK_Biz|PollQueryPKMsgModel", "resetPollQuery", "Have not call startPollQueryPKMsg first.");
        }
    }

    public final void n(long roomId, @NotNull b queryListener) {
        Intrinsics.checkNotNullParameter(queryListener, "queryListener");
        AegisLogger.INSTANCE.i("PK_Biz|PollQueryPKMsgModel", "startPollQueryPKMsg, roomId " + roomId);
        this.roomId = Long.valueOf(roomId);
        this.queryListener = queryListener;
        i(200);
    }

    public final void o() {
        AegisLogger.INSTANCE.i("PK_Biz|PollQueryPKMsgModel", "stopPollQueryPKMsg");
        this.queryListener = null;
        this.handler.removeCallbacks(this.queryRunnable);
    }
}
