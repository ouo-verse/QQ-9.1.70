package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.os.Handler;
import com.google.protobuf.nano.MessageNano;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.sso.request.QQLiveAnchorGetLiveStatRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u000b\u000fB\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/m;", "", "", "delayMillis", "", tl.h.F, "g", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/m$b;", "callback", "i", "j", "a", "J", "anchorId", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "checkerHandler", "c", WidgetCacheConstellationData.INTERVAL, "d", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/m$b;", "checkCallback", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "checkRunnable", "<init>", "(J)V", "f", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long anchorId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b checkCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler checkerHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long interval = 2000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable checkRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.l
        @Override // java.lang.Runnable
        public final void run() {
            m.f(m.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/m$b;", "", "", "isLiving", "", "onResult", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void onResult(boolean isLiving);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/m$c", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lcom/google/protobuf/nano/MessageNano;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ILiveNetRequest.Callback<MessageNano> {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<MessageNano> response) {
            kp4.c cVar;
            boolean z16;
            long j3;
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isFailed()) {
                AegisLogger.INSTANCE.e("Open_Live|RtmpPushStateChecker", "requestAnchorLiveStat error", "code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Open_Live|RtmpPushStateChecker", "requestAnchorLiveStat", "isSuccess = " + response.isSuccess());
            MessageNano rsp = response.getRsp();
            if (rsp instanceof kp4.c) {
                cVar = (kp4.c) rsp;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                m mVar = m.this;
                int i3 = cVar.f412854a;
                if (i3 != 0) {
                    companion.i("Open_Live|RtmpPushStateChecker", "requestAnchorLiveStat", "request fail! GetLiveStatRsp.result = " + i3);
                    return;
                }
                kp4.b[] bVarArr = cVar.f412855b;
                if (bVarArr != null) {
                    Intrinsics.checkNotNullExpressionValue(bVarArr, "it.liveStat");
                    boolean z17 = true;
                    if (bVarArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        kp4.b bVar = cVar.f412855b[0];
                        if (bVar == null || bVar.f412849c <= 0) {
                            z17 = false;
                        }
                        if (z17) {
                            j3 = 4000;
                        } else {
                            j3 = 2000;
                        }
                        mVar.interval = j3;
                        b bVar2 = mVar.checkCallback;
                        if (bVar2 != null) {
                            bVar2.onResult(z17);
                        }
                        mVar.h(mVar.interval);
                        return;
                    }
                }
                companion.i("Open_Live|RtmpPushStateChecker", "requestAnchorLiveStat", "request fail! GetLiveStatRsp.liveStat is empty!");
            }
        }
    }

    public m(long j3) {
        this.anchorId = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    private final void g() {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveAnchorGetLiveStatRequest(this.anchorId), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(long delayMillis) {
        this.checkerHandler.removeCallbacks(this.checkRunnable);
        this.checkerHandler.postDelayed(this.checkRunnable, delayMillis);
    }

    public final void i(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.checkCallback = callback;
        h(0L);
    }

    public final void j() {
        this.checkerHandler.removeCallbacks(this.checkRunnable);
        this.checkCallback = null;
    }
}
