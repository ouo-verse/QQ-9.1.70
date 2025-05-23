package com.tencent.mobileqq.qqlive.push;

import com.google.protobuf.nano.MessageNano;
import com.huya.huyasdk.api.HuyaLiveBarrageReceiveInfo;
import com.huya.huyasdk.api.HuyaPresenterSubscriptionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveHuYaRoomApi;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYaPushHandler;
import com.tencent.mobileqq.qqlive.huya.m;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq3.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\rB\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/a;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler$b;", "", "msg", "", "c", "d", "e", "f", "b", "", "cmd", "a", "Lkotlinx/coroutines/channels/Channel;", "Lfp4/c;", "Lkotlinx/coroutines/channels/Channel;", "huYaChannel", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler;", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler;", "pushHandler", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lkotlinx/coroutines/channels/Channel;)V", h.F, "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements CoroutineScope, QQLiveHuYaPushHandler.b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<fp4.c> huYaChannel;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f271418e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQLiveHuYaPushHandler pushHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.push.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Channel<fp4.c> huYaChannel) {
        Intrinsics.checkNotNullParameter(huYaChannel, "huYaChannel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) huYaChannel);
            return;
        }
        this.huYaChannel = huYaChannel;
        this.f271418e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(LiveCoroutineScopes.f273421a.a()));
        this.pushHandler = new QQLiveHuYaPushHandler();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c(Object msg2) {
        boolean z16;
        if (!(msg2 instanceof HuyaLiveBarrageReceiveInfo)) {
            QLog.e("HuYaPushHandler", 1, "handleDeliverLiveBarrage msg type error " + msg2);
            return;
        }
        com.tencent.mobileqq.qqlive.huya.c g16 = m.f271359a.g();
        if (g16 != null) {
            Long c16 = g16.c();
            long j3 = ((HuyaLiveBarrageReceiveInfo) msg2).senderUid;
            if (c16 != null && c16.longValue() == j3) {
                z16 = true;
                if (!z16) {
                    return;
                }
                rq3.a aVar = new rq3.a();
                i iVar = new i();
                HuyaLiveBarrageReceiveInfo huyaLiveBarrageReceiveInfo = (HuyaLiveBarrageReceiveInfo) msg2;
                iVar.f431959b = huyaLiveBarrageReceiveInfo.senderNick;
                aVar.f431934a = iVar;
                rq3.d dVar = new rq3.d();
                rq3.e eVar = new rq3.e();
                eVar.f431945a = 1;
                rq3.h hVar = new rq3.h();
                String str = huyaLiveBarrageReceiveInfo.content;
                Intrinsics.checkNotNullExpressionValue(str, "msg.content");
                Charset forName = Charset.forName("utf-16LE");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"utf-16LE\")");
                byte[] bytes = str.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                hVar.f431957a = bytes;
                eVar.f431946b = hVar;
                Unit unit = Unit.INSTANCE;
                dVar.f431942a = new rq3.e[]{eVar};
                dVar.f431943b = new rq3.b[0];
                aVar.f431935b = dVar;
                fp4.c cVar = new fp4.c();
                cVar.f400284b = 33;
                cVar.f400285c = MessageNano.toByteArray(aVar);
                this.huYaChannel.mo2003trySendJP2dKIU(cVar);
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final void d(Object msg2) {
        boolean z16 = true;
        if (!(msg2 instanceof HuyaPresenterSubscriptionInfo)) {
            QLog.e("HuYaPushHandler", 1, "handleDeliverSubscribeMessage msg type error " + msg2);
            return;
        }
        hr4.f fVar = new hr4.f();
        fVar.f406110d = 1;
        HuyaPresenterSubscriptionInfo huyaPresenterSubscriptionInfo = (HuyaPresenterSubscriptionInfo) msg2;
        fVar.f406108b = huyaPresenterSubscriptionInfo.subscriberNick;
        UserInfo currentAnchorInfo = ((IQQLiveHuYaRoomApi) QRoute.api(IQQLiveHuYaRoomApi.class)).getCurrentAnchorInfo();
        if (currentAnchorInfo == null || currentAnchorInfo.e() != huyaPresenterSubscriptionInfo.presenterUid) {
            z16 = false;
        }
        if (z16) {
            fVar.f406109c = currentAnchorInfo.f();
        }
        gp4.a aVar = new gp4.a();
        aVar.f403047a = 19;
        aVar.f403049c = MessageNano.toByteArray(fVar);
        fp4.c cVar = new fp4.c();
        cVar.f400284b = 263;
        cVar.f400285c = MessageNano.toByteArray(aVar);
        this.huYaChannel.mo2003trySendJP2dKIU(cVar);
    }

    private final void e(Object msg2) {
        Long l3;
        if (!(msg2 instanceof Long)) {
            QLog.e("HuYaPushHandler", 1, "handleHuyaLiveEnd msg type error " + msg2);
            return;
        }
        UserInfo currentAnchorInfo = ((IQQLiveHuYaRoomApi) QRoute.api(IQQLiveHuYaRoomApi.class)).getCurrentAnchorInfo();
        Long l16 = null;
        if (currentAnchorInfo != null) {
            l3 = Long.valueOf(currentAnchorInfo.e());
        } else {
            l3 = null;
        }
        if (!Intrinsics.areEqual(l3, msg2)) {
            if (currentAnchorInfo != null) {
                l16 = Long.valueOf(currentAnchorInfo.e());
            }
            QLog.w("HuYaPushHandler", 1, "handleHuyaLiveEnd msg uid error end uin:" + msg2 + ", current uin:" + l16);
            return;
        }
        fp4.c cVar = new fp4.c();
        cVar.f400284b = 75;
        cVar.f400285c = new byte[0];
        cVar.f400287e = 2;
        cVar.f400288f = currentAnchorInfo.f();
        this.huYaChannel.mo2003trySendJP2dKIU(cVar);
    }

    @Override // com.tencent.mobileqq.qqlive.huya.QQLiveHuYaPushHandler.b
    public void a(int cmd, @Nullable Object msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, cmd, msg2);
            return;
        }
        if (cmd != 1) {
            if (cmd != 2) {
                if (cmd == 3) {
                    d(msg2);
                    return;
                }
                return;
            }
            e(msg2);
            return;
        }
        c(msg2);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.pushHandler.a();
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.pushHandler.b(this);
            this.pushHandler.c();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271418e.getCoroutineContext();
    }
}
