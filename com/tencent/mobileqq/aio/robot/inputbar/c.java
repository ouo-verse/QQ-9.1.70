package com.tencent.mobileqq.aio.robot.inputbar;

import android.graphics.Rect;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.AIOInputUIState;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.inputbar.compat.AIOInputBarCompatMsgIntent;
import com.tencent.mobileqq.aio.reserve1.blur.BottomBlurMsgIntent;
import com.tencent.mobileqq.aio.reserve1.mask.MaskMsgIntent;
import com.tencent.mobileqq.aio.robot.inputbar.RobotInputUIState;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.relatedemo.l;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002 $\b\u0007\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\bR\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/inputbar/c;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "v", "E", "", "isShare", "p", "", "source", "isSelected", "t", "isShotMode", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/input/f$c;", "handleInputLayoutChange", "", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "handleIntent", "com/tencent/mobileqq/aio/robot/inputbar/c$b", "e", "Lcom/tencent/mobileqq/aio/robot/inputbar/c$b;", "mAction", "com/tencent/mobileqq/aio/robot/inputbar/c$c", "f", "Lcom/tencent/mobileqq/aio/robot/inputbar/c$c;", "mActionR", h.F, "mBottomLayoutHeight", "Lcom/tencent/mobileqq/aio/layout/b;", "i", "Lcom/tencent/mobileqq/aio/layout/b;", "mBottomWrapper", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Rect;", "mInputLayoutRect", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends com.tencent.qqnt.aio.baseVM.a<at.a, InputUIState> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mBottomLayoutHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.layout.b mBottomWrapper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7354c mActionR = new C7354c();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect mInputLayoutRect = new Rect();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/robot/inputbar/c$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            c.this.E(intent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/robot/inputbar/c$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.robot.inputbar.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7354c implements com.tencent.mvi.base.route.b {
        C7354c() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return c.this.I(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (QLog.isDebugVersion()) {
            QLog.d("RobotAIOInputContainerVM", 4, "[handleAction] intent:" + intent);
        }
        if (intent instanceof AIOMsgListEvent.SetCommunicationShareButton) {
            p(((AIOMsgListEvent.SetCommunicationShareButton) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            AIOMsgListEvent.MultiSelectModeChangeEvent multiSelectModeChangeEvent = (AIOMsgListEvent.MultiSelectModeChangeEvent) intent;
            t(multiSelectModeChangeEvent.a(), multiSelectModeChangeEvent.b());
            return;
        }
        if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            s(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
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
            return q();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleInputLayoutChange(final f.c intent) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.InputLayoutChange(intent.b(), intent.d(), intent.c(), intent.a()));
        this.mInputLayoutRect = new Rect(intent.b(), intent.d(), intent.c(), intent.a());
        this.mBottomLayoutHeight = intent.a() - intent.d();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.BottomLayoutHeightChange(intent.a() - intent.d()));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.inputbar.b
            @Override // java.lang.Runnable
            public final void run() {
                c.r(c.this, intent);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int o() {
        AIOInputBarCompatMsgIntent.GetInputBarTopMargin getInputBarTopMargin = new AIOInputBarCompatMsgIntent.GetInputBarTopMargin(0, 1, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getInputBarTopMargin);
        return getInputBarTopMargin.a();
    }

    private final void p(boolean isShare) {
        int i3;
        if (isShare) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        updateUI(new AIOInputUIState.SetCommunicationShareBarVisibility(i3));
    }

    private final k q() {
        return new l.a(this.mBottomLayoutHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(c this$0, f.c intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new BottomBlurMsgIntent.BottomLayoutHeightChange(intent.a() - intent.d()));
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new MaskMsgIntent.BottomLayoutHeightChange(intent.a() - intent.d()));
    }

    private final void s(boolean isShotMode) {
        int i3;
        if (isShotMode) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        updateUI(new AIOInputUIState.SetLongShotBarVisibility(i3));
    }

    private final void t(String source, boolean isSelected) {
        if (isSelected) {
            updateUI(new RobotInputUIState.SetMultiSelectBarVisibility(source, 0));
        } else {
            updateUI(new RobotInputUIState.SetMultiSelectBarVisibility(source, 8));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.SetCommunicationShareButton");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
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
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetBottomLayoutHeight");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        v();
        com.tencent.mobileqq.aio.layout.b bVar = this.mBottomWrapper;
        if (bVar != null) {
            bVar.b(0);
        }
        this.mInputLayoutRect = new Rect();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull at.a intent) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        if (QLog.isDebugVersion()) {
            QLog.d("RobotAIOInputContainerVM", 4, "[onCreate]");
        }
        u();
    }
}
