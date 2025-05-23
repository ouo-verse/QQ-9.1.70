package com.tencent.mobileqq.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.reserve1.blur.BottomBlurMsgIntent;
import com.tencent.mobileqq.aio.reserve1.emotion.AIOEmotionAnimContainerMsgIntent;
import com.tencent.mobileqq.aio.reserve1.image.AIOFastImageMsgIntent;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\b\f*\u0001\u0013\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/n;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "b", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "com/tencent/mobileqq/aio/helper/n$b", "d", "Lcom/tencent/mobileqq/aio/helper/n$b;", "mAction", "e", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class n implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.n$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/n$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                n.this.b(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(MsgIntent i3) {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        com.tencent.mvi.base.route.j e16 = bVar.a().e();
        if (i3 instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) i3;
            e16.h(new AIOReserve1CreateModelIntent("fast_image", new AIOFastImageMsgIntent.OnPanelStateChangedMsgIntent(onPanelStateChangedMsgIntent.b(), onPanelStateChangedMsgIntent.a())));
            return;
        }
        if (i3 instanceof AIOMsgListEvent.InputLayoutChange) {
            AIOMsgListEvent.InputLayoutChange inputLayoutChange = (AIOMsgListEvent.InputLayoutChange) i3;
            e16.h(new AIOReserve1CreateModelIntent("aio_emotion_anim_container", new AIOEmotionAnimContainerMsgIntent.InputLayoutChange(inputLayoutChange.b(), inputLayoutChange.d(), inputLayoutChange.c(), inputLayoutChange.a())));
            return;
        }
        if (i3 instanceof AIOMsgListEvent.MsgListScrollEvent) {
            AIOMsgListEvent.MsgListScrollEvent msgListScrollEvent = (AIOMsgListEvent.MsgListScrollEvent) i3;
            e16.h(new AIOReserve1CreateModelIntent("aio_unread_bubble", new UnreadMsgIntent.MsgListScrollEvent(msgListScrollEvent.d(), msgListScrollEvent.b(), msgListScrollEvent.a(), msgListScrollEvent.c())));
            return;
        }
        if (i3 instanceof AIOMsgListEvent.ListScrollDistanceNotify) {
            AIOMsgListEvent.ListScrollDistanceNotify listScrollDistanceNotify = (AIOMsgListEvent.ListScrollDistanceNotify) i3;
            e16.h(new AIOReserve1CreateModelIntent("aio_unread_bubble", new UnreadMsgIntent.ListScrollDistanceNotify(listScrollDistanceNotify.a(), listScrollDistanceNotify.b(), listScrollDistanceNotify.c())));
            return;
        }
        if (i3 instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            AIOMsgSendEvent.MsgOnRevokeEvent msgOnRevokeEvent = (AIOMsgSendEvent.MsgOnRevokeEvent) i3;
            e16.h(new AIOReserve1CreateModelIntent("aio_unread_bubble", new UnreadMsgIntent.MsgOnRevokeEvent(msgOnRevokeEvent.b(), msgOnRevokeEvent.a())));
            return;
        }
        if (i3 instanceof AIOMsgListEvent.ListScrollStateChanged) {
            e16.h(new AIOReserve1CreateModelIntent("aio_unread_bubble", new UnreadMsgIntent.ListScrollStateChanged(((AIOMsgListEvent.ListScrollStateChanged) i3).a())));
            return;
        }
        if (i3 instanceof AIOMsgListEvent.MsgCountChange) {
            e16.h(new AIOReserve1CreateModelIntent("aio_unread_bubble", new UnreadMsgIntent.MsgCountChange(((AIOMsgListEvent.MsgCountChange) i3).a())));
            return;
        }
        if (i3 instanceof AIOMsgListEvent.BottomLayoutHeightChange) {
            e16.h(new AIOReserve1CreateModelIntent("aio_blur_bottom", new BottomBlurMsgIntent.BottomLayoutHeightChange(((AIOMsgListEvent.BottomLayoutHeightChange) i3).a())));
        } else if (i3 instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            AIOMsgListEvent.LongShotModeChangeEvent longShotModeChangeEvent = (AIOMsgListEvent.LongShotModeChangeEvent) i3;
            e16.h(new AIOReserve1CreateModelIntent("aio_blur_bottom", new BottomBlurMsgIntent.LongShotModeChangeEvent(longShotModeChangeEvent.a(), longShotModeChangeEvent.b())));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 55;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.InputLayoutChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MsgListScrollEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ListScrollDistanceNotify");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnRevokeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ListScrollStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MsgCountChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.BottomLayoutHeightChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.AIOBackgroundDrawable");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "AIOReserve1Helper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParam = param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            param = null;
        }
        param.a().e().f(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
        }
    }
}
