package com.tencent.qqnt.aio.assistedchat.panel.polish;

import android.view.View;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.panel.extend.PanelExtendRecyclerView;
import com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPanelPromptBar;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelUIState;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelView;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.i;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u001b\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012H\u0002J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u001a\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/n;", "", "inputContent", "", "inputValid", "", "m1", "l1", "e1", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$UpdateRecommendsUIState;", "state", "k1", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$RequestRecommendsFailUIState;", "g1", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommends", "", "bizErrCode", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "c1", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "promptList", "j1", "prompt", "h1", "content", "f1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "b0", "i1", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelView;", "d", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelView;", "panelView", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "e", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "panelExtendHelper", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar;", "f", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar;", "promptBar", h.F, "Ljava/lang/String;", "lastInputContent", "<init>", "()V", "i", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPolishPanelVB extends com.tencent.aio.base.mvvm.a<at.c, PanelUIState> implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AssistedChatSubPanelView panelView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.assistedchat.panel.extend.b panelExtendHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AssistedChatPanelPromptBar promptBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String lastInputContent;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVB$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59263);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPolishPanelVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.aio.assistedchat.panel.subpanel.a c1(List<com.tencent.qqnt.aio.assistedchat.model.c> recommends, int bizErrCode) {
        if (!recommends.isEmpty()) {
            return null;
        }
        if (bizErrCode == 27007) {
            String string = getMContext().getString(R.string.yor);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026ted_chat_polish_security)");
            return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.a(13, string, null, "2", 4, null);
        }
        if (bizErrCode != 27008 && bizErrCode != 27009) {
            if (AppNetConnInfo.isNetSupport() && bizErrCode == 0) {
                String string2 = getMContext().getString(R.string.yor);
                Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(R.str\u2026ted_chat_polish_security)");
                String string3 = getMContext().getString(R.string.yot);
                Intrinsics.checkNotNullExpressionValue(string3, "mContext.getString(R.str\u2026.aio_assisted_chat_retry)");
                return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.a(13, string2, string3, "4");
            }
            String string4 = getMContext().getString(R.string.yom);
            Intrinsics.checkNotNullExpressionValue(string4, "mContext.getString(R.str\u2026isted_chat_network_error)");
            String string5 = getMContext().getString(R.string.yot);
            Intrinsics.checkNotNullExpressionValue(string5, "mContext.getString(R.str\u2026.aio_assisted_chat_retry)");
            return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.a(5, string4, string5, "3");
        }
        String string6 = getMContext().getString(R.string.yos);
        Intrinsics.checkNotNullExpressionValue(string6, "mContext.getString(R.str\u2026ted_chat_polish_too_long)");
        return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.a(13, string6, null, "4", 4, null);
    }

    static /* synthetic */ com.tencent.qqnt.aio.assistedchat.panel.subpanel.a d1(AssistedChatPolishPanelVB assistedChatPolishPanelVB, List list, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return assistedChatPolishPanelVB.c1(list, i3);
    }

    private final String e1() {
        j jVar;
        String a16;
        com.tencent.aio.api.runtime.a aVar;
        FrameworkVM mUIModel = getMUIModel();
        d.f fVar = null;
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
            jVar = aVar.e();
        } else {
            jVar = null;
        }
        if (jVar == null) {
            return "";
        }
        k k3 = jVar.k(InputEvent.GetInputTextString.f188573d);
        if (k3 instanceof d.f) {
            fVar = (d.f) k3;
        }
        if (fVar == null || (a16 = fVar.a()) == null) {
            return "";
        }
        return a16;
    }

    private final void f1(String content) {
        m1(content, l1(content));
    }

    private final void g1(AssistedChatSubPanelUIState.RequestRecommendsFailUIState state) {
        String string;
        AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
        if (assistedChatSubPanelView != null) {
            assistedChatSubPanelView.d(state.c(), false);
            assistedChatSubPanelView.setData(state.b(), state.c(), c1(state.b(), state.a()));
        }
        int i3 = 1;
        if (!state.b().isEmpty()) {
            if (state.a() == 27007) {
                string = getMContext().getString(R.string.yor);
            } else if (state.a() != 27008 && state.a() != 27009) {
                if (state.a() == 0 && AppNetConnInfo.isNetSupport()) {
                    string = getMContext().getString(R.string.yoo);
                    i3 = 0;
                } else {
                    string = getMContext().getString(R.string.yom);
                }
            } else {
                string = getMContext().getString(R.string.yos);
            }
            Intrinsics.checkNotNullExpressionValue(string, "if (state.bizErrCode == \u2026work_error)\n            }");
            QQToast.makeText(getMContext(), i3, string, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(com.tencent.qqnt.aio.assistedchat.model.a prompt) {
        sendIntent(new i.f(prompt));
        AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
        if (assistedChatSubPanelView != null) {
            assistedChatSubPanelView.m(true);
        }
    }

    private final void j1(List<com.tencent.qqnt.aio.assistedchat.model.a> promptList) {
        if (this.promptBar == null) {
            AssistedChatPanelPromptBar assistedChatPanelPromptBar = new AssistedChatPanelPromptBar(getMContext(), null, 0, 6, null);
            assistedChatPanelPromptBar.setOnPromptSelectedListener(new Function1<com.tencent.qqnt.aio.assistedchat.model.a, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVB$handleUpdatePromptBar$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.aio.assistedchat.model.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable com.tencent.qqnt.aio.assistedchat.model.a aVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AssistedChatPolishPanelVB.this.h1(aVar);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                    }
                }
            });
            AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
            if (assistedChatSubPanelView != null) {
                assistedChatSubPanelView.b(assistedChatPanelPromptBar);
            }
            this.promptBar = assistedChatPanelPromptBar;
        }
        AssistedChatPanelPromptBar assistedChatPanelPromptBar2 = this.promptBar;
        if (assistedChatPanelPromptBar2 != null) {
            assistedChatPanelPromptBar2.setData(promptList);
        }
    }

    private final void k1(AssistedChatSubPanelUIState.UpdateRecommendsUIState state) {
        AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
        if (assistedChatSubPanelView != null) {
            assistedChatSubPanelView.d(state.c(), state.a());
            assistedChatSubPanelView.setData(state.b(), state.c(), d1(this, state.b(), 0, 2, null));
        }
    }

    private final boolean l1(String inputContent) {
        return com.tencent.qqnt.aio.assistedchat.helper.c.f349087a.b(inputContent);
    }

    private final void m1(String inputContent, boolean inputValid) {
        this.lastInputContent = inputContent;
        if (inputValid) {
            AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
            if (assistedChatSubPanelView != null) {
                assistedChatSubPanelView.m(true);
                return;
            }
            return;
        }
        AssistedChatSubPanelView assistedChatSubPanelView2 = this.panelView;
        if (assistedChatSubPanelView2 != null) {
            assistedChatSubPanelView2.k(2);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.n
    public void b0(boolean first) {
        String str;
        PanelExtendRecyclerView g16;
        com.tencent.qqnt.aio.assistedchat.panel.extend.b bVar;
        FrameworkVM mUIModel;
        com.tencent.aio.api.runtime.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, first);
            return;
        }
        if (this.panelExtendHelper == null && (mUIModel = getMUIModel()) != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
            this.panelExtendHelper = new com.tencent.qqnt.aio.assistedchat.panel.extend.b(aVar);
        }
        com.tencent.qqnt.aio.assistedchat.panel.extend.b bVar2 = this.panelExtendHelper;
        if (bVar2 != null) {
            bVar2.n();
        }
        AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
        if (assistedChatSubPanelView != null && (g16 = assistedChatSubPanelView.g()) != null && (bVar = this.panelExtendHelper) != null) {
            bVar.j(g16);
        }
        String e16 = e1();
        boolean z16 = !Intrinsics.areEqual(this.lastInputContent, e16);
        boolean l16 = l1(e16);
        if (l16) {
            str = e16;
        } else {
            str = "";
        }
        sendIntent(new i.e(str));
        if (z16) {
            sendIntent(new i.f(null));
            sendIntent(i.a.f349323d);
        }
        if (z16 || (first && !l16)) {
            m1(e16, l16);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<at.c, PanelUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new AssistedChatPolishPanelVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PanelUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AssistedChatSubPanelUIState.UpdateRecommendsUIState) {
            k1((AssistedChatSubPanelUIState.UpdateRecommendsUIState) state);
            return;
        }
        if (state instanceof AssistedChatSubPanelUIState.RequestRecommendsFailUIState) {
            g1((AssistedChatSubPanelUIState.RequestRecommendsFailUIState) state);
        } else if (state instanceof AssistedChatSubPanelUIState.UpdatePromptListUIState) {
            j1(((AssistedChatSubPanelUIState.UpdatePromptListUIState) state).a());
        } else if (state instanceof AssistedChatSubPanelUIState.OnInputContentChangedState) {
            f1(((AssistedChatSubPanelUIState.OnInputContentChangedState) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        List<com.tencent.qqnt.aio.assistedchat.model.a> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        if (QLog.isDevelopLevel()) {
            QLog.d("AssistedChatPolishPanelVB", 4, "onCreateView");
        }
        AssistedChatSubPanelView assistedChatSubPanelView = new AssistedChatSubPanelView(createViewParams.a());
        this.panelView = assistedChatSubPanelView;
        assistedChatSubPanelView.setSubPanelId(2);
        assistedChatSubPanelView.setRefreshListener(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVB$onCreateView$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVB.this);
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
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AssistedChatPolishPanelVB.this.sendIntent(i.d.f349326d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        assistedChatSubPanelView.setLoadMoreListener(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVB$onCreateView$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVB.this);
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
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AssistedChatPolishPanelVB.this.sendIntent(i.c.f349325d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        assistedChatSubPanelView.setItemClickListener(new Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVB$onCreateView$1$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.aio.assistedchat.model.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.aio.assistedchat.model.c it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AssistedChatPolishPanelVB.this.sendIntent(new i.b(it));
                }
            }
        });
        assistedChatSubPanelView.setGuideClickListener(new Function1<CharSequence, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVB$onCreateView$1$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                invoke2(charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CharSequence it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AssistedChatPolishPanelVB.this.sendIntent(new i.g(it));
                }
            }
        });
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        j1(emptyList);
        return assistedChatSubPanelView;
    }
}
