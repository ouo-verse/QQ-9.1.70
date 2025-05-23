package com.tencent.mobileqq.qqlive.sail.ui.like;

import android.view.View;
import android.view.ViewStub;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.like.LikeConfig;
import com.tencent.timi.game.liveroom.impl.room.like.LikeResourceMgr;
import com.tencent.timi.game.liveroom.impl.room.like.LiveLikeView;
import com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uq4.d;
import uq4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/like/b;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qqlive/sail/ui/like/QQLiveLikeEvent;", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "U9", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "V9", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveLikeView;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveLikeView;", "otherLikeView", "f", "Landroid/view/View;", "myLikeViewContainer", "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView;", h.F, "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView;", "myLikeView", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends c implements SimpleEventReceiver<QQLiveLikeEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveLikeView otherLikeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View myLikeViewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveOwnerLikeView myLikeView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/like/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.like.b$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/like/b$b", "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView$AnimateStatusListener;", "", "onComboStart", "onComboEnd", "onAnimateEnd", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.like.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8394b implements LiveOwnerLikeView.AnimateStatusListener {
        static IPatchRedirector $redirector_;

        C8394b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView.AnimateStatusListener
        public void onAnimateEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView.AnimateStatusListener
        public void onComboEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView.AnimateStatusListener
        public void onComboStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LiveLikeView liveLikeView = b.this.otherLikeView;
                if (liveLikeView != null) {
                    liveLikeView.sendAvatarLike();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LiveOwnerLikeView liveOwnerLikeView = this$0.myLikeView;
        if (liveOwnerLikeView != null) {
            liveOwnerLikeView.like(liveOwnerLikeView.getWidth() / 2.0f, liveOwnerLikeView.getHeight() / 2.0f);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        super.S9(updater);
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        d l3 = busConfigHelper.l(H9());
        if (l3 != null) {
            if (l3.f439831a && R9()) {
                startInit();
                LikeConfig.INSTANCE.loadConfig(l3.f439832b);
                LiveLikeView liveLikeView = this.otherLikeView;
                if (liveLikeView != null) {
                    liveLikeView.onEnterRoom(H9());
                }
                LiveOwnerLikeView liveOwnerLikeView = this.myLikeView;
                if (liveOwnerLikeView != null) {
                    liveOwnerLikeView.onEnterRoom(H9(), null);
                }
            } else {
                AegisLogger.INSTANCE.w("Audience|QQLiveLikePart", "onEnterRoom", H9() + " cannot like");
            }
        }
        uq4.c cVar = busConfigHelper.j().get(Long.valueOf(H9()));
        if (cVar != null && (fVar = cVar.f439830e) != null) {
            LikeResourceMgr.INSTANCE.initLikeResource(fVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.U9();
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.V9();
        LiveLikeView liveLikeView = this.otherLikeView;
        if (liveLikeView != null) {
            liveLikeView.onExitRoom();
        }
        LiveOwnerLikeView liveOwnerLikeView = this.myLikeView;
        if (liveOwnerLikeView != null) {
            liveOwnerLikeView.onExitRoom();
        }
        LikeResourceMgr.INSTANCE.release();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QQLiveLikeEvent>> getEventClass() {
        ArrayList<Class<QQLiveLikeEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQLiveLikeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f61182xf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        LiveLikeView liveLikeView;
        View view;
        ViewStub viewStub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        LiveOwnerLikeView liveOwnerLikeView = null;
        if (rootView != null) {
            liveLikeView = (LiveLikeView) rootView.findViewById(R.id.f61172xe);
        } else {
            liveLikeView = null;
        }
        this.otherLikeView = liveLikeView;
        if (rootView != null && (viewStub = (ViewStub) rootView.findViewById(R.id.f61132xa)) != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        this.myLikeViewContainer = view;
        if (view != null) {
            liveOwnerLikeView = (LiveOwnerLikeView) view.findViewById(R.id.f61122x_);
        }
        this.myLikeView = liveOwnerLikeView;
        if (liveOwnerLikeView != null) {
            liveOwnerLikeView.setAnimateStatusListener(new C8394b());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
        } else {
            if (!(event instanceof QQLiveLikeEvent) || ((QQLiveLikeEvent) event).getRoomId() != H9()) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.like.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.ja(b.this);
                }
            });
        }
    }
}
