package com.tencent.qqnt.aio.assistedchat.panel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.a;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerUIState;
import com.tencent.qqnt.aio.assistedchat.panel.c;
import com.tencent.qqnt.aio.assistedchat.panel.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u000226\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\tR\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/f;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "t", "o", "v", "Lcom/tencent/qqnt/aio/assistedchat/panel/d$a;", "r", "", "subPanelId", "u", "Lcom/tencent/qqnt/aio/assistedchat/panel/d$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/aio/assistedchat/panel/j;", "e", "Lcom/tencent/qqnt/aio/assistedchat/panel/j;", "p", "()Lcom/tencent/qqnt/aio/assistedchat/panel/j;", "setShowPanelParam", "(Lcom/tencent/qqnt/aio/assistedchat/panel/j;)V", "showPanelParam", "f", "Z", "isPanelShow", tl.h.F, "isPanelSelected", "i", "currentSubPanelId", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "messageList", BdhLogUtil.LogTag.Tag_Conn, "messageRList", "com/tencent/qqnt/aio/assistedchat/panel/f$b", "D", "Lcom/tencent/qqnt/aio/assistedchat/panel/f$b;", "action", "com/tencent/qqnt/aio/assistedchat/panel/f$c", "Lcom/tencent/qqnt/aio/assistedchat/panel/f$c;", "actionR", "Landroidx/lifecycle/LifecycleEventObserver;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleObserver", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f extends com.tencent.qqnt.aio.baseVM.a<at.c, PanelUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<String> messageRList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c actionR;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LifecycleEventObserver lifecycleObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j showPanelParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelShow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelSelected;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentSubPanelId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> messageList;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f349173a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58917);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f349173a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/f$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                f.this.E(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/f$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return f.this.I(i3);
        }
    }

    public f() {
        List<String> listOf;
        List<String> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.currentSubPanelId = -1;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), jVar.a(Reflection.getOrCreateKotlinClass(AssistedChatPanelContainerMsgIntent.HideSettingPanel.class))});
        this.messageList = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{jVar.a(Reflection.getOrCreateKotlinClass(AssistedChatPanelContainerMsgIntent.GetShowPanelParamMsgIntent.class)), jVar.a(Reflection.getOrCreateKotlinClass(AssistedChatPanelContainerMsgIntent.GetCurrentSubPanelIdMsgIntent.class))});
        this.messageRList = listOf2;
        this.action = new b();
        this.actionR = new c();
        this.lifecycleObserver = new LifecycleEventObserver() { // from class: com.tencent.qqnt.aio.assistedchat.panel.e
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                f.w(f.this, lifecycleOwner, event);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            t((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent);
        } else if (intent instanceof AssistedChatPanelContainerMsgIntent.HideSettingPanel) {
            updateUI(new AssistedChatPanelContainerUIState.SetSettingPanelVisibility(8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent intent) {
        if (Intrinsics.areEqual(intent, AssistedChatPanelContainerMsgIntent.GetShowPanelParamMsgIntent.f349126d)) {
            return r();
        }
        if (Intrinsics.areEqual(intent, AssistedChatPanelContainerMsgIntent.GetCurrentSubPanelIdMsgIntent.f349125d)) {
            return q();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        boolean z16;
        if (((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.isPanelSelected) {
            if (!this.isPanelShow) {
                this.isPanelShow = true;
                updateUI(AssistedChatPanelContainerUIState.PanelShowUIState.f349129d);
                return;
            }
            return;
        }
        if (this.isPanelShow) {
            this.isPanelShow = false;
            updateUI(AssistedChatPanelContainerUIState.PanelHideUIState.f349128d);
        }
    }

    private final d.b q() {
        return new d.b(this.currentSubPanelId);
    }

    private final d.a r() {
        return new d.a(this.showPanelParam);
    }

    private final void t(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent intent) {
        boolean z16;
        if (intent.b() && intent.a() == 1014) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isPanelSelected = z16;
        o();
        if (!intent.b() && intent.a() == 1014) {
            updateUI(new AssistedChatPanelContainerUIState.SetSettingPanelVisibility(8));
        }
    }

    private final void u(int subPanelId) {
        this.currentSubPanelId = subPanelId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        a.c cVar;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AssistedChatMsgIntent.GetAndRemoveShowPanelParamIntent.f348979d);
        j jVar = null;
        if (k3 instanceof a.c) {
            cVar = (a.c) k3;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            jVar = cVar.a();
        }
        this.showPanelParam = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(f this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = a.f349173a[event.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this$0.o();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        for (String str : this.messageList) {
            com.tencent.mvi.base.route.j e16 = context.e();
            b bVar = this.action;
            LifecycleOwner d16 = context.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            e16.c(str, bVar, d16);
        }
        for (String str2 : this.messageRList) {
            com.tencent.mvi.base.route.j e17 = context.e();
            c cVar = this.actionR;
            LifecycleOwner d17 = context.d();
            Intrinsics.checkNotNullExpressionValue(d17, "context.lifecycleOwner");
            e17.g(str2, cVar, d17);
        }
        context.d().getLifecycle().addObserver(this.lifecycleObserver);
        this.isPanelSelected = true;
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) it.next(), this.action);
        }
        Iterator<T> it5 = this.messageRList.iterator();
        while (it5.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) it5.next());
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this.lifecycleObserver);
    }

    @Nullable
    public final j p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.showPanelParam;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull at.c intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.b) {
            v();
        } else if (intent instanceof c.a) {
            u(((c.a) intent).a());
        }
    }
}
