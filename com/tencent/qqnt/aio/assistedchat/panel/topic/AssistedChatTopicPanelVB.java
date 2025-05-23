package com.tencent.qqnt.aio.assistedchat.panel.topic;

import android.view.View;
import android.widget.LinearLayout;
import at.c;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.panel.extend.PanelExtendRecyclerView;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelUIState;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelView;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.i;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.n;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001a\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/n;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$UpdateRecommendsUIState;", "state", "", "g1", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelUIState$RequestRecommendsFailUIState;", "e1", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommends", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "d1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "b0", "f1", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelView;", "d", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelView;", "panelView", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "e", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "panelExtendHelper", "Landroid/widget/LinearLayout;", "f", "Lkotlin/Lazy;", "c1", "()Landroid/widget/LinearLayout;", "bottomBar", "<init>", "()V", h.F, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatTopicPanelVB extends com.tencent.aio.base.mvvm.a<c, PanelUIState> implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AssistedChatSubPanelView panelView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.assistedchat.panel.extend.b panelExtendHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bottomBar;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVB$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59774);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatTopicPanelVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new AssistedChatTopicPanelVB$bottomBar$2(this));
            this.bottomBar = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final LinearLayout c1() {
        return (LinearLayout) this.bottomBar.getValue();
    }

    private final com.tencent.qqnt.aio.assistedchat.panel.subpanel.a d1(List<com.tencent.qqnt.aio.assistedchat.model.c> recommends) {
        if (!recommends.isEmpty()) {
            return null;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            String string = getMContext().getString(R.string.yom);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026isted_chat_network_error)");
            String string2 = getMContext().getString(R.string.yot);
            Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(R.str\u2026.aio_assisted_chat_retry)");
            return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.a(5, string, string2, "3");
        }
        String string3 = getMContext().getString(R.string.yon);
        Intrinsics.checkNotNullExpressionValue(string3, "mContext.getString(R.str\u2026o_assisted_chat_no_topic)");
        String string4 = getMContext().getString(R.string.yot);
        Intrinsics.checkNotNullExpressionValue(string4, "mContext.getString(R.str\u2026.aio_assisted_chat_retry)");
        return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.a(13, string3, string4, null, 8, null);
    }

    private final void e1(AssistedChatSubPanelUIState.RequestRecommendsFailUIState state) {
        String string;
        AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
        if (assistedChatSubPanelView != null) {
            assistedChatSubPanelView.d(state.c(), false);
            assistedChatSubPanelView.setData(state.b(), state.c(), d1(state.b()));
        }
        int i3 = 1;
        if (!state.b().isEmpty()) {
            if (!AppNetConnInfo.isNetSupport()) {
                string = getMContext().getString(R.string.yom);
            } else if (state.a() == 0) {
                string = getMContext().getString(R.string.yoo);
                i3 = 0;
            } else {
                string = getMContext().getString(R.string.yop);
            }
            Intrinsics.checkNotNullExpressionValue(string, "if (!AppNetConnInfo.isNe\u2026ther_error)\n            }");
            QQToast.makeText(getMContext(), i3, string, 0).show();
        }
    }

    private final void g1(AssistedChatSubPanelUIState.UpdateRecommendsUIState state) {
        AssistedChatSubPanelView assistedChatSubPanelView = this.panelView;
        if (assistedChatSubPanelView != null) {
            assistedChatSubPanelView.d(state.c(), state.a());
            assistedChatSubPanelView.setData(state.b(), state.c(), d1(state.b()));
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.n
    public void b0(boolean first) {
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
        sendIntent(i.C9459i.f349331d);
        sendIntent(i.h.f349330d);
        if (first) {
            sendIntent(i.a.f349323d);
            AssistedChatSubPanelView assistedChatSubPanelView2 = this.panelView;
            if (assistedChatSubPanelView2 != null) {
                AssistedChatSubPanelView.n(assistedChatSubPanelView2, false, 1, null);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<c, PanelUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new AssistedChatTopicPanelVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PanelUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AssistedChatSubPanelUIState.UpdateRecommendsUIState) {
            g1((AssistedChatSubPanelUIState.UpdateRecommendsUIState) state);
        } else if (state instanceof AssistedChatSubPanelUIState.RequestRecommendsFailUIState) {
            e1((AssistedChatSubPanelUIState.RequestRecommendsFailUIState) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        if (QLog.isDevelopLevel()) {
            QLog.d("AssistedChatTopicPanelVB", 4, "onCreateView");
        }
        AssistedChatSubPanelView assistedChatSubPanelView = new AssistedChatSubPanelView(createViewParams.a());
        this.panelView = assistedChatSubPanelView;
        assistedChatSubPanelView.setSubPanelId(1);
        assistedChatSubPanelView.setRefreshListener(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVB$onCreateView$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatTopicPanelVB.this);
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
                    AssistedChatTopicPanelVB.this.sendIntent(i.d.f349326d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        assistedChatSubPanelView.setLoadMoreListener(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVB$onCreateView$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatTopicPanelVB.this);
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
                    AssistedChatTopicPanelVB.this.sendIntent(i.c.f349325d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        assistedChatSubPanelView.setItemClickListener(new Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVB$onCreateView$1$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatTopicPanelVB.this);
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
                    AssistedChatTopicPanelVB.this.sendIntent(new i.b(it));
                }
            }
        });
        assistedChatSubPanelView.b(c1());
        return assistedChatSubPanelView;
    }
}
