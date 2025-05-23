package com.tencent.qqnt.aio.assistedchat.panel.polish;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.d;
import com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPromptRepository;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelUIState;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.i;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0007*\u0001>\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001CB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0016\u00108\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00107R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "", "content", BdhLogUtil.LogTag.Tag_Conn, "v", "", "p", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "y", "B", "G", HippyTKDListViewAdapter.X, "", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "promptList", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "result", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommend", "t", "", "text", UserInfo.SEX_FEMALE, "prompt", "D", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "w", "Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelRepository;", "e", "Lkotlin/Lazy;", "r", "()Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelRepository;", "repository", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPromptRepository;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPromptRepository;", "promptRepository", h.F, "Z", "hasRequestPromptList", "i", "Ljava/lang/String;", "promptId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isParentPanelShown", "com/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelVM$b", "Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelVM$b;", "action", "<init>", "()V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPolishPanelVM extends com.tencent.qqnt.aio.baseVM.a<at.c, PanelUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy repository;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy promptRepository;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasRequestPromptList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String promptId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isParentPanelShown;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVM$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AssistedChatPolishPanelVM.this.E(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59328);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPolishPanelVM() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AssistedChatPolishPanelRepository>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVM$repository$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AssistedChatPolishPanelRepository invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AssistedChatPolishPanelRepository(((com.tencent.aio.api.runtime.a) AssistedChatPolishPanelVM.this.getMContext()).g().r().c()) : (AssistedChatPolishPanelRepository) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.repository = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AssistedChatPromptRepository>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVM$promptRepository$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AssistedChatPromptRepository invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AssistedChatPromptRepository(((com.tencent.aio.api.runtime.a) AssistedChatPolishPanelVM.this.getMContext()).g().r().c()) : (AssistedChatPromptRepository) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.promptRepository = lazy2;
            this.promptId = "";
            this.action = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(com.tencent.qqnt.aio.assistedchat.panel.subpanel.d result) {
        AssistedChatSubPanelUIState requestRecommendsFailUIState;
        if (!Intrinsics.areEqual(result.h(), this.promptId)) {
            QLog.w("AssistedChatPolishPanelVM", 4, "handleRecommendsResponse promptId changed!!!");
            return;
        }
        QLog.d("AssistedChatPolishPanelVM", 4, "handleRecommendsResponse");
        if (result.i()) {
            requestRecommendsFailUIState = new AssistedChatSubPanelUIState.UpdateRecommendsUIState(result.g(), result.j(), result.f(), result.e());
        } else {
            requestRecommendsFailUIState = new AssistedChatSubPanelUIState.RequestRecommendsFailUIState(result.b(), result.g(), result.j());
        }
        updateUI(requestRecommendsFailUIState);
    }

    private final void B() {
        QLog.d("AssistedChatPolishPanelVM", 1, "refresh recommends hasReqPrompt=" + this.hasRequestPromptList);
        G();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(r().k(), new AssistedChatPolishPanelVM$handleRefresh$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    private final void C(String content) {
        r().n(content);
        QLog.d("AssistedChatPolishPanelVM", 1, "handleSetInputContent " + content);
    }

    private final void D(com.tencent.qqnt.aio.assistedchat.model.a prompt) {
        String str;
        String str2;
        if (prompt != null) {
            str = prompt.c();
        } else {
            str = null;
        }
        QLog.d("AssistedChatPolishPanelVM", 1, "handleSetPrompt " + str);
        if (prompt == null || (str2 = prompt.c()) == null) {
            str2 = "";
        }
        this.promptId = str2;
        r().o(this.promptId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            y((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent);
        } else if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            v(((InputEditTextMsgIntent.EditTextChangedMsgIntent) intent).c().toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(CharSequence text) {
        QLog.d("AssistedChatPolishPanelVM", 1, "handleSetTextToEditText " + ((Object) text));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.SetTextToEditText(text, true));
    }

    private final void G() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(q().d(), new AssistedChatPolishPanelVM$requestPromptList$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int p() {
        d.b bVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AssistedChatPanelContainerMsgIntent.GetCurrentSubPanelIdMsgIntent.f349125d);
        if (k3 instanceof d.b) {
            bVar = (d.b) k3;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.a();
        }
        return -1;
    }

    private final AssistedChatPromptRepository q() {
        return (AssistedChatPromptRepository) this.promptRepository.getValue();
    }

    private final AssistedChatPolishPanelRepository r() {
        return (AssistedChatPolishPanelRepository) this.repository.getValue();
    }

    private final void s() {
        r().m(new byte[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(final com.tencent.qqnt.aio.assistedchat.model.c recommend) {
        boolean z16;
        QLog.d("AssistedChatPolishPanelVM", 1, "click recommend");
        boolean z17 = false;
        if (recommend.a().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AssistedChatMsgIntent.OnPanelRecommendItemClick(recommend.a()));
            F(recommend.a());
        }
        if (recommend.a().length() > 0) {
            z17 = true;
        }
        if (z17 && recommend.b() != null) {
            final AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.e
                @Override // java.lang.Runnable
                public final void run() {
                    AssistedChatPolishPanelVM.u(AIOContact.this, recommend);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AIOContact aioContact, com.tencent.qqnt.aio.assistedchat.model.c recommend) {
        int i3;
        Intrinsics.checkNotNullParameter(aioContact, "$aioContact");
        Intrinsics.checkNotNullParameter(recommend, "$recommend");
        com.tencent.qqnt.aio.assistedchat.request.a aVar = com.tencent.qqnt.aio.assistedchat.request.a.f349425a;
        int e16 = aioContact.e();
        String j3 = aioContact.j();
        Integer d16 = recommend.d();
        if (d16 != null) {
            i3 = d16.intValue();
        } else {
            i3 = 0;
        }
        com.tencent.qqnt.aio.assistedchat.request.a.e(aVar, e16, j3, i3, 0, null, 24, null);
    }

    private final void v(String content) {
        boolean z16;
        if (this.isParentPanelShown && p() == 2) {
            if (content.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            QLog.d("AssistedChatPolishPanelVM", 1, "handleEditTextChanged input is empty");
            C("");
            updateUI(new AssistedChatSubPanelUIState.OnInputContentChangedState(content));
        }
    }

    private final void x() {
        QLog.d("AssistedChatPolishPanelVM", 1, "load more recommends");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(r().j(), new AssistedChatPolishPanelVM$handleLoadMore$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    private final void y(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent intent) {
        boolean z16;
        if (intent.b() && intent.a() == 1014) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isParentPanelShown = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(List<com.tencent.qqnt.aio.assistedchat.model.a> promptList) {
        if (QLog.isDevelopLevel()) {
            QLog.d("AssistedChatPolishPanelVM", 4, "handlePromptResponse " + promptList.size());
        }
        updateUI(new AssistedChatSubPanelUIState.UpdatePromptListUIState(promptList));
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        context.e().f(this, this.action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        if (e16 != null) {
            e16.i(this, this.action);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull at.c intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof i.d) {
            B();
            return;
        }
        if (intent instanceof i.c) {
            x();
            return;
        }
        if (intent instanceof i.b) {
            t(((i.b) intent).a());
            return;
        }
        if (intent instanceof i.g) {
            F(((i.g) intent).a());
            return;
        }
        if (intent instanceof i.e) {
            C(((i.e) intent).a());
        } else if (intent instanceof i.f) {
            D(((i.f) intent).a());
        } else if (intent instanceof i.a) {
            s();
        }
    }
}
