package com.tencent.mobileqq.aio.input;

import android.graphics.Rect;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.AIOInputUIState;
import com.tencent.mobileqq.aio.input.blockstate.TroopBlockStateChange;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.inputbar.compat.AIOInputBarCompatMsgIntent;
import com.tencent.mobileqq.aio.reserve1.blur.BottomBlurMsgIntent;
import com.tencent.mobileqq.aio.reserve1.mask.MaskMsgIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.relatedemo.l;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002 $\b\u0007\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\bR\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/aio/input/c;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "I", "r", "", "v", "w", "E", "Lcom/tencent/mobileqq/aio/input/blockstate/TroopBlockStateChange;", "p", "", "isShare", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isSelected", "u", "isShotMode", "t", "Lcom/tencent/mobileqq/aio/input/f$c;", "handleInputLayoutChange", "", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "handleIntent", "com/tencent/mobileqq/aio/input/c$b", "e", "Lcom/tencent/mobileqq/aio/input/c$b;", "mAction", "com/tencent/mobileqq/aio/input/c$c", "f", "Lcom/tencent/mobileqq/aio/input/c$c;", "mActionR", tl.h.F, "mBottomLayoutHeight", "Lcom/tencent/mobileqq/aio/layout/b;", "i", "Lcom/tencent/mobileqq/aio/layout/b;", "mBottomWrapper", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Rect;", "mInputLayoutRect", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends com.tencent.qqnt.aio.baseVM.a<at.a, InputUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7260c mActionR;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mBottomLayoutHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.layout.b mBottomWrapper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect mInputLayoutRect;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.c$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/c$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            } else {
                Intrinsics.checkNotNullParameter(intent, "intent");
                c.this.E(intent);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/c$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7260c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        C7260c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return c.this.I(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52811);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAction = new b();
        this.mActionR = new C7260c();
        this.mInputLayoutRect = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (QLog.isDebugVersion()) {
            QLog.d("AIOInputContainerVM", 4, "[handleAction] intent:" + intent);
        }
        if (intent instanceof AIOMsgListEvent.SetCommunicationShareButton) {
            q(((AIOMsgListEvent.SetCommunicationShareButton) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            u(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
            return;
        }
        if (intent instanceof TroopBlockStateChange) {
            p((TroopBlockStateChange) intent);
            return;
        }
        if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            t(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
            return;
        }
        if (intent instanceof InputEvent.InputHide) {
            updateUI(AIOInputUIState.InputHide.f189150d);
            return;
        }
        if (intent instanceof InputEvent.InputShow) {
            updateUI(AIOInputUIState.InputShow.f189151d);
            return;
        }
        if (intent instanceof FullScreenMsgIntent.BeforeFullScreenAnimChanged) {
            updateUI(new AIOInputUIState.BeforeFullScreenAnimChanged(((FullScreenMsgIntent.BeforeFullScreenAnimChanged) intent).a()));
            return;
        }
        if (intent instanceof InputEvent.GetInputLayoutRect) {
            Rect rect = new Rect();
            rect.set(this.mInputLayoutRect);
            ((InputEvent.GetInputLayoutRect) intent).b(rect);
        } else if (intent instanceof InputEvent.EnterAIVoiceChatState) {
            updateUI(AIOInputUIState.EnterAIVoiceChatState.f189146d);
        } else if (intent instanceof InputEvent.ExitAIVoiceChatState) {
            updateUI(AIOInputUIState.ExitAIVoiceChatState.f189147d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.GetBottomLayoutHeight) {
            return r();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleInputLayoutChange(final f.c intent) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.InputLayoutChange(intent.b(), intent.d(), intent.c(), intent.a()));
        this.mInputLayoutRect = new Rect(intent.b(), intent.d(), intent.c(), intent.a());
        this.mBottomLayoutHeight = intent.a() - intent.d();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.BottomLayoutHeightChange(intent.a() - intent.d()));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.input.b
            @Override // java.lang.Runnable
            public final void run() {
                c.s(c.this, intent);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int o() {
        AIOInputBarCompatMsgIntent.GetInputBarTopMargin getInputBarTopMargin = new AIOInputBarCompatMsgIntent.GetInputBarTopMargin(0, 1, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getInputBarTopMargin);
        return getInputBarTopMargin.a();
    }

    private final void p(TroopBlockStateChange intent) {
        updateUI(new AIOInputUIState.TroopBlockVisibleChange(com.tencent.mobileqq.aio.input.blockstate.b.a(intent)));
    }

    private final void q(boolean isShare) {
        int i3;
        if (isShare) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        updateUI(new AIOInputUIState.SetCommunicationShareBarVisibility(i3));
    }

    private final k r() {
        return new l.a(this.mBottomLayoutHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(c this$0, f.c intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new BottomBlurMsgIntent.BottomLayoutHeightChange(intent.a() - intent.d()));
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new MaskMsgIntent.BottomLayoutHeightChange(intent.a() - intent.d()));
    }

    private final void t(boolean isShotMode) {
        int i3;
        if (isShotMode) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        updateUI(new AIOInputUIState.SetLongShotBarVisibility(i3));
    }

    private final void u(boolean isSelected) {
        int i3;
        if (isSelected) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        updateUI(new AIOInputUIState.SetMultiSelectBarVisibility(i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.SetCommunicationShareButton");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.blockstate.TroopBlockStateChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.BeforeFullScreenAnimChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.InputHide");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.InputShow");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.GetInputLayoutRect");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.EnterAIVoiceChatState");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.ExitAIVoiceChatState");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetBottomLayoutHeight");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        w();
        com.tencent.mobileqq.aio.layout.b bVar = this.mBottomWrapper;
        if (bVar != null) {
            bVar.b(0);
        }
        this.mInputLayoutRect = new Rect();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof f.c) {
            handleInputLayoutChange((f.c) intent);
        } else if (intent instanceof f.g) {
            this.mBottomWrapper = ((f.g) intent).a();
        } else if (intent instanceof f.b) {
            ((f.b) intent).b(o());
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        if (QLog.isDebugVersion()) {
            QLog.d("AIOInputContainerVM", 4, "[onCreate]");
        }
        v();
    }
}
