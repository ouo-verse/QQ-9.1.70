package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.google.protobuf.nano.MessageNano;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveAnchorGetLiveStatRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/room/helper/s;", "", "", "delayMillis", "", tl.h.F, "f", "i", "j", "a", "J", "anchorId", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "e", "()Landroidx/lifecycle/MutableLiveData;", "isRtmpLiving", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "rtmpCheckerHandler", "d", WidgetCacheConstellationData.INTERVAL, "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "rtmpPushStatCheckerTask", "<init>", "(J)V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class s {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long anchorId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isRtmpLiving;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler rtmpCheckerHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long interval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable rtmpPushStatCheckerTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/room/helper/s$a;", "", "", "QQLIVE_RTMP_PUSH_STAT_CHECK_INTERVAL_ON_FAIL", "J", "QQLIVE_RTMP_PUSH_STAT_CHECK_INTERVAL_ON_SUCCESS", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.room.helper.s$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/room/helper/s$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lcom/google/protobuf/nano/MessageNano;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements ILiveNetRequest.Callback<MessageNano> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<MessageNano> response) {
            kp4.c cVar;
            boolean z16;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("VSRequest|RtmpPushStateChecker", "requestAnchorLiveStat", "isSuccess = " + response.isSuccess());
            MessageNano rsp = response.getRsp();
            if (rsp instanceof kp4.c) {
                cVar = (kp4.c) rsp;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                s sVar = s.this;
                int i3 = cVar.f412854a;
                if (i3 != 0) {
                    companion.i("VSRequest|RtmpPushStateChecker", "requestAnchorLiveStat", "request fail! GetLiveStatRsp.result = " + i3);
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
                        sVar.interval = j3;
                        sVar.e().postValue(Boolean.valueOf(z17));
                        sVar.h(sVar.interval);
                        return;
                    }
                }
                companion.i("VSRequest|RtmpPushStateChecker", "requestAnchorLiveStat", "request fail! GetLiveStatRsp.liveStat is empty!");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31528);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public s(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.anchorId = j3;
        this.isRtmpLiving = new MutableLiveData<>();
        this.rtmpCheckerHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.interval = 2000L;
        this.rtmpPushStatCheckerTask = new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.r
            @Override // java.lang.Runnable
            public final void run() {
                s.g(s.this);
            }
        };
    }

    private final void f() {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveAnchorGetLiveStatRequest(this.anchorId), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(s this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(long delayMillis) {
        this.rtmpCheckerHandler.removeCallbacks(this.rtmpPushStatCheckerTask);
        this.rtmpCheckerHandler.postDelayed(this.rtmpPushStatCheckerTask, delayMillis);
    }

    @NotNull
    public final MutableLiveData<Boolean> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.isRtmpLiving;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            h(0L);
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.rtmpCheckerHandler.removeCallbacks(this.rtmpPushStatCheckerTask);
        }
    }
}
