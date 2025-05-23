package com.tencent.mobileqq.qqlive.anchor.live.pkstate;

import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import io3.LinkMuteEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/h;", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/a;", "", "uid", "", "g", "i", "Lhn3/b;", "event", "c", "a", "Lio3/a;", "muteEvent", "b", "userID", "", "available", "onUserVideoAvailable", "Lei2/a;", "Lei2/a;", "crossRoomLiveService", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "pkVideoViewService", "Z", "remoteViewStarted", "", "d", "J", "linkScreenAnchorUid", "<init>", "(Lei2/a;Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;)V", "e", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ei2.a crossRoomLiveService;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c pkVideoViewService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean remoteViewStarted;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long linkScreenAnchorUid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.pkstate.h$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20850);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h(@NotNull ei2.a crossRoomLiveService, @NotNull com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c pkVideoViewService) {
        Intrinsics.checkNotNullParameter(crossRoomLiveService, "crossRoomLiveService");
        Intrinsics.checkNotNullParameter(pkVideoViewService, "pkVideoViewService");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) crossRoomLiveService, (Object) pkVideoViewService);
        } else {
            this.crossRoomLiveService = crossRoomLiveService;
            this.pkVideoViewService = pkVideoViewService;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0, LinkScreenAnchorInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|LinkScreenAnchorTRTCImpl", "onLinkScreenStart run");
        this$0.linkScreenAnchorUid = info.getUin();
        this$0.crossRoomLiveService.connectRemote(info.getRoomId(), info.getUin());
        this$0.g(String.valueOf(info.getUin()));
        this$0.crossRoomLiveService.muteRemoteAudio(String.valueOf(info.getUin()), false);
        companion.i("PK_Biz|LinkScreenAnchorTRTCImpl", "startRemoteView, muteRemoteAudio");
    }

    private final void g(final String uid) {
        if (!this.remoteViewStarted) {
            final FrameLayout W1 = this.pkVideoViewService.W1();
            if (W1 == null) {
                AegisLogger.INSTANCE.w("PK_Biz|LinkScreenAnchorTRTCImpl", "videoViewContainer empty!!!");
            } else {
                W1.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkstate.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.h(h.this, uid, W1);
                    }
                });
                this.remoteViewStarted = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h this$0, String uid, FrameLayout container) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(container, "$container");
        this$0.crossRoomLiveService.startRemoteView(uid, container);
    }

    private final void i(String uid) {
        this.crossRoomLiveService.stopRemoteView(uid);
        this.remoteViewStarted = false;
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        i(String.valueOf(this.linkScreenAnchorUid));
        this.linkScreenAnchorUid = 0L;
        this.crossRoomLiveService.disconnectRemote();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void b(@NotNull LinkMuteEvent muteEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) muteEvent);
        } else {
            Intrinsics.checkNotNullParameter(muteEvent, "muteEvent");
            this.crossRoomLiveService.muteRemoteAudio(muteEvent.getUin(), muteEvent.getIsMute());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void c(@NotNull LinkScreenEvent event) {
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
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkstate.f
            @Override // java.lang.Runnable
            public final void run() {
                h.f(h.this, linkScreenAnchorInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkstate.a
    public void onUserVideoAvailable(@NotNull String userID, boolean available) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, userID, Boolean.valueOf(available));
            return;
        }
        Intrinsics.checkNotNullParameter(userID, "userID");
        if (available) {
            g(userID);
        } else {
            i(userID);
        }
    }
}
