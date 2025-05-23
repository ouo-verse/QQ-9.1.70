package com.tencent.mobileqq.qqlive.anchor.live.pkstate;

import android.os.Handler;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.live.pkstate.c;
import com.tencent.mobileqq.qqlive.api.player.IQQLivePlayerFactory;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnFirstVideoFrameEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import io3.LinkMuteEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/c;", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/a;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "", tl.h.F, "Lhn3/b;", "event", "c", "a", "Lio3/a;", "muteEvent", "b", "", "userID", "", "available", "onUserVideoAvailable", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "pkVideoViewService", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "qqLivePlayer", "", "J", "otherAnchorUid", "<init>", "(Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;)V", "d", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c pkVideoViewService;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQLivePlayer qqLivePlayer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long otherAnchorUid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.pkstate.c$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/pkstate/c$b", "Lmi2/g;", "", "onVideoPrepared", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements mi2.g {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            IQQLivePlayer iQQLivePlayer = this$0.qqLivePlayer;
            if (iQQLivePlayer != null) {
                FrameLayout W1 = this$0.pkVideoViewService.W1();
                if (W1 != null) {
                    W1.removeAllViews();
                }
                if (W1 != null) {
                    W1.addView(iQQLivePlayer.getVideoView(), new ConstraintLayout.LayoutParams(-1, -1));
                }
            }
        }

        @Override // mi2.g
        public void onVideoPrepared() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final c cVar = c.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkstate.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.b(c.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/pkstate/c$c", "Lmi2/d;", "", "onFirstFrameRendered", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.pkstate.c$c, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8349c implements mi2.d {
        static IPatchRedirector $redirector_;

        C8349c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SimpleEventBus.getInstance().dispatchEvent(new OnFirstVideoFrameEvent(QQLiveBusinessConfig.QQLIVE_APP_ID, String.valueOf(this$0.otherAnchorUid), 0, 0, 0));
        }

        @Override // mi2.d
        public void onFirstFrameRendered() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final c cVar = c.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkstate.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C8349c.b(c.this);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c pkVideoViewService) {
        Intrinsics.checkNotNullParameter(pkVideoViewService, "pkVideoViewService");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pkVideoViewService);
        } else {
            this.pkVideoViewService = pkVideoViewService;
        }
    }

    private final void h(IQQLivePlayer player) {
        if (player == null) {
            AegisLogger.INSTANCE.w("PK_Biz|PKWithOBS|LinkScreenAnchorPlayerImpl", "addCallback", "invalid player");
        } else {
            player.registerVideoPreparedListener(new b());
            player.registerFirstFrameRenderedListener(new C8349c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(c this$0, LinkScreenAnchorInfo info, LinkScreenEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(event, "$event");
        IQQLivePlayer qQLivePlayer = ((IQQLivePlayerFactory) QRoute.api(IQQLivePlayerFactory.class)).getQQLivePlayer(new PlayerConfig(129, false, false, 0L, false, false, null, 0L, 0L, 0L, 0L, 0L, 0L, null, 0.0f, false, 0L, 0L, false, false, null, 0L, false, 8388606, null));
        this$0.qqLivePlayer = qQLivePlayer;
        this$0.h(qQLivePlayer);
        this$0.otherAnchorUid = info.getUin();
        String c16 = event.c(info.getUin());
        AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkScreenAnchorPlayerImpl", "innerLinkScreenStart, videoUrl:" + c16);
        IQQLivePlayer iQQLivePlayer = this$0.qqLivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.startPlay(c16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkScreenAnchorPlayerImpl", "innerLinkScreenEnd, qqLivePlayer:" + this.qqLivePlayer);
        IQQLivePlayer iQQLivePlayer = this.qqLivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.release();
        }
        this.qqLivePlayer = null;
        this.otherAnchorUid = 0L;
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void b(@NotNull LinkMuteEvent muteEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) muteEvent);
            return;
        }
        Intrinsics.checkNotNullParameter(muteEvent, "muteEvent");
        IQQLivePlayer iQQLivePlayer = this.qqLivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.setOutputMute(muteEvent.getIsMute());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void c(@NotNull final LinkScreenEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        final LinkScreenAnchorInfo linkScreenAnchorInfo = event.getLinkScreenAnchorInfo();
        if (linkScreenAnchorInfo == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkstate.b
            @Override // java.lang.Runnable
            public final void run() {
                c.i(c.this, linkScreenAnchorInfo, event);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void onUserVideoAvailable(@NotNull String userID, boolean available) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, userID, Boolean.valueOf(available));
        } else {
            Intrinsics.checkNotNullParameter(userID, "userID");
        }
    }
}
