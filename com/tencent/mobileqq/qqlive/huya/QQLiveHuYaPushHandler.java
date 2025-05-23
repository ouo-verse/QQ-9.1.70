package com.tencent.mobileqq.qqlive.huya;

import com.huya.huyasdk.api.HuyaLiveBarrage;
import com.huya.huyasdk.api.HuyaLiveBarrageReceiveInfo;
import com.huya.huyasdk.api.HuyaLiveBeginLive;
import com.huya.huyasdk.api.HuyaLiveRoom;
import com.huya.huyasdk.api.HuyaPresenterSubscriptionInfo;
import com.huya.huyasdk.api.HuyaSubscribe;
import com.huya.huyasdk.api.LiveBarrageCallback;
import com.huya.huyasdk.api.LiveRoomEventCallback;
import com.huya.huyasdk.api.SubscribeCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\t\bB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler;", "Lcom/huya/huyasdk/api/LiveBarrageCallback;", "Lcom/huya/huyasdk/api/LiveRoomEventCallback;", "Lcom/huya/huyasdk/api/SubscribeCallback;", "", "c", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler$b;", "pushHandler", "b", "a", "Lcom/huya/huyasdk/api/HuyaLiveBarrageReceiveInfo;", "receive", "onLiveBarrageReceive", "Lcom/huya/huyasdk/api/HuyaLiveBeginLive;", "beginLive", "onLiveBegin", "", "presenterUid", "onLiveEnd", "onLiveInfoChange", "", "attendeeCount", "onAttendeeCountChange", "Lcom/huya/huyasdk/api/HuyaPresenterSubscriptionInfo;", "info", "onSubscriptionInfoNotify", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler$b;", "listener", "<init>", "()V", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveHuYaPushHandler implements LiveBarrageCallback, LiveRoomEventCallback, SubscribeCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b listener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler$a;", "", "", "CMD_LIVE_BARRAGE_RECEIVE", "I", "CMD_LIVE_END", "CMD_LIVE_SUBSCRIBE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.huya.QQLiveHuYaPushHandler$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaPushHandler$b;", "", "", "cmd", "msg", "", "a", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(int cmd, @Nullable Object msg2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveHuYaPushHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.listener = null;
        }
    }

    public final void b(@NotNull b pushHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pushHandler);
        } else {
            Intrinsics.checkNotNullParameter(pushHandler, "pushHandler");
            this.listener = pushHandler;
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QQLiveHuYa.f271333a.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.huya.QQLiveHuYaPushHandler$start$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveHuYaPushHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    HuyaLiveBarrage.setLiveBarrageCallback(QQLiveHuYaPushHandler.this);
                    HuyaLiveRoom.setLiveRoomEventCallback(QQLiveHuYaPushHandler.this);
                    HuyaSubscribe.setSubscribeCallback(QQLiveHuYaPushHandler.this);
                }
            }, QQLiveHuYaPushHandler$start$2.INSTANCE);
        }
    }

    @Override // com.huya.huyasdk.api.LiveRoomEventCallback
    public void onAttendeeCountChange(int attendeeCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, attendeeCount);
            return;
        }
        QLog.d("QQLiveHuYaPushHandler", 4, "onAttendeeCountChange: attendeeCount:" + attendeeCount);
    }

    @Override // com.huya.huyasdk.api.LiveBarrageCallback
    public void onLiveBarrageReceive(@Nullable HuyaLiveBarrageReceiveInfo receive) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) receive);
            return;
        }
        if (receive != null) {
            str = receive.content;
        } else {
            str = null;
        }
        QLog.d("QQLiveHuYaPushHandler", 4, "onLiveBarrageReceive: " + str);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.a(1, receive);
        }
    }

    @Override // com.huya.huyasdk.api.LiveRoomEventCallback
    public void onLiveBegin(@Nullable HuyaLiveBeginLive beginLive) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) beginLive);
            return;
        }
        Long l3 = null;
        if (beginLive != null) {
            str = beginLive.title;
        } else {
            str = null;
        }
        if (beginLive != null) {
            l3 = Long.valueOf(beginLive.presenterUid);
        }
        QLog.d("QQLiveHuYaPushHandler", 4, "onLiveBegin: " + str + " presenterUid:" + l3);
    }

    @Override // com.huya.huyasdk.api.LiveRoomEventCallback
    public void onLiveEnd(long presenterUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, presenterUid);
            return;
        }
        QLog.d("QQLiveHuYaPushHandler", 4, "onLiveEnd: presenterUid:" + presenterUid);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.a(2, Long.valueOf(presenterUid));
        }
    }

    @Override // com.huya.huyasdk.api.LiveRoomEventCallback
    public void onLiveInfoChange(@Nullable HuyaLiveBeginLive beginLive) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) beginLive);
            return;
        }
        Long l3 = null;
        if (beginLive != null) {
            str = beginLive.title;
        } else {
            str = null;
        }
        if (beginLive != null) {
            l3 = Long.valueOf(beginLive.presenterUid);
        }
        QLog.d("QQLiveHuYaPushHandler", 4, "onLiveInfoChange: " + str + " presenterUid:" + l3);
    }

    @Override // com.huya.huyasdk.api.SubscribeCallback
    public void onSubscriptionInfoNotify(@Nullable HuyaPresenterSubscriptionInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) info);
            return;
        }
        QLog.d("QQLiveHuYaPushHandler", 4, "onSubscriptionInfoNotify: " + info);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.a(3, info);
        }
    }
}
