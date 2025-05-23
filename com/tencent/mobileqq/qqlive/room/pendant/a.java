package com.tencent.mobileqq.qqlive.room.pendant;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.now.pkgame.pkgame.event.LinkMicEvent;
import com.tencent.now.pkgame.pkgame.event.NormalLinkMicEvent;
import com.tencent.now.pkgame.pkgame.event.PKLinkMicEvent;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLivePendantWebViewDelegate;
import com.tencent.timi.game.liveroom.impl.room.pendant.webview.RightBottomPendantPushEvent;
import gk4.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J(\u0010\r\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0018\u00010\nj\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0018\u0001`\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/pendant/a;", "Lgk4/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "rightMargin", "", "H", h.F, "w", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "<init>", "()V", "M", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends gk4.b implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/pendant/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.pendant.a$a, reason: collision with other inner class name and from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/room/pendant/a$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Pendant|QQLivePendantManager", "onReceiveEvent", "onAnimationEnd");
            companion.i("Pendant|QQLivePendantManager", "onReceiveEvent", "RightBottomPendantPushEvent  hide");
            ((gk4.a) a.this).C.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(NormalLinkMicEvent.class);
        arrayList.add(PKLinkMicEvent.class);
        arrayList.add(RightBottomPendantPushEvent.class);
        return arrayList;
    }

    @Override // gk4.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.h();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent == null) {
            return;
        }
        if (simpleBaseEvent instanceof NormalLinkMicEvent) {
            NormalLinkMicEvent normalLinkMicEvent = (NormalLinkMicEvent) simpleBaseEvent;
            if (normalLinkMicEvent.isLinkMicOn()) {
                H(120);
            } else {
                H(0);
            }
            FrameLayout frameLayout = this.C;
            if (frameLayout != null && (frameLayout.getParent() instanceof ViewGroup)) {
                Object parent = this.C.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                View view = (View) parent;
                int c16 = x.c(view.getContext(), 30.0f);
                if (normalLinkMicEvent.isLinkMicOn()) {
                    i3 = R.id.tto;
                } else {
                    i3 = R.id.sn5;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(2, i3);
                layoutParams2.bottomMargin = c16;
                if (normalLinkMicEvent.isLinkMicOn()) {
                    layoutParams2.bottomMargin = (this.C.getRootView().findViewById(R.id.tto).getHeight() * (-1)) / 3;
                }
                view.setLayoutParams(layoutParams2);
            }
        }
        if (simpleBaseEvent instanceof LinkMicEvent) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            LinkMicEvent linkMicEvent = (LinkMicEvent) simpleBaseEvent;
            companion.i("Pendant|QQLivePendantManager", "onReceiveEvent", "receive link mic event, type=" + linkMicEvent.getLinkType() + ", isLinkMicOn=" + linkMicEvent.isLinkMicOn() + ", roomId=" + linkMicEvent.getRoomId());
            if (linkMicEvent.getRoomId() != this.f402361e) {
                companion.i("Pendant|QQLivePendantManager", "onReceiveEvent", "receive link mic event, not current room, eventRoomId= " + linkMicEvent.getRoomId() + ", curRoomId= " + this.f402361e);
                return;
            }
            Iterator<Map.Entry<Long, b.PendantViewHolder>> it = y().entrySet().iterator();
            while (it.hasNext()) {
                QQLivePendantWebViewDelegate pendant = it.next().getValue().getPendant();
                if (pendant != null) {
                    pendant.h("setLinkMicState", String.valueOf(linkMicEvent.getLinkType()));
                }
            }
            QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = this.f402365m;
            if (qQLivePendantWebViewDelegate != null) {
                qQLivePendantWebViewDelegate.h("setLinkMicState", String.valueOf(linkMicEvent.getLinkType()));
            }
        }
        if (simpleBaseEvent instanceof RightBottomPendantPushEvent) {
            if (this.D) {
                AegisLogger.INSTANCE.i("Pendant|QQLivePendantManager", "onReceiveEvent", "mShouldHideRightBottom");
                return;
            }
            if (((RightBottomPendantPushEvent) simpleBaseEvent).getNeedShow()) {
                AegisLogger.INSTANCE.i("Pendant|QQLivePendantManager", "onReceiveEvent", "RightBottomPendantPushEvent show");
                this.C.setVisibility(0);
                this.E = true;
            } else {
                this.E = false;
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, this.C.getWidth() / 2, this.C.getHeight());
                scaleAnimation.setDuration(500L);
                scaleAnimation.setAnimationListener(new b());
                AegisLogger.INSTANCE.i("Pendant|QQLivePendantManager", "onReceiveEvent", "RightBottomPendantPushEvent  startAnim");
                this.C.startAnimation(scaleAnimation);
            }
        }
    }

    @Override // gk4.b, gk4.a
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.w();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    private final void H(int rightMargin) {
    }
}
