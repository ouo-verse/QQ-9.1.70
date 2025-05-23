package com.tencent.qqnt.aio.assistedchat.panel.topic;

import at.c;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.d;
import com.tencent.qqnt.aio.assistedchat.panel.j;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelUIState;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "", "v", "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "result", "t", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommend", "p", "o", "intent", "r", "Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelRepository;", "e", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelRepository;", "repository", "<init>", "()V", "f", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatTopicPanelVM extends com.tencent.qqnt.aio.baseVM.a<c, PanelUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy repository;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/topic/AssistedChatTopicPanelVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVM$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatTopicPanelVM() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AssistedChatTopicPanelRepository>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVM$repository$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatTopicPanelVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AssistedChatTopicPanelRepository invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AssistedChatTopicPanelRepository(((com.tencent.aio.api.runtime.a) AssistedChatTopicPanelVM.this.getMContext()).g().r().c()) : (AssistedChatTopicPanelRepository) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.repository = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final AssistedChatTopicPanelRepository n() {
        return (AssistedChatTopicPanelRepository) this.repository.getValue();
    }

    private final void o() {
        n().o(new byte[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p(final com.tencent.qqnt.aio.assistedchat.model.c recommend) {
        boolean z16;
        QLog.d("AssistedChatTopicPanelVM", 1, "click recommend");
        if (recommend.a().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AssistedChatMsgIntent.OnPanelRecommendItemClick(recommend.a()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.SetTextToEditText(recommend.a(), true));
        }
        final AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.b
            @Override // java.lang.Runnable
            public final void run() {
                AssistedChatTopicPanelVM.q(AIOContact.this, recommend);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AIOContact aioContact, com.tencent.qqnt.aio.assistedchat.model.c recommend) {
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

    private final void s() {
        QLog.d("AssistedChatTopicPanelVM", 1, "load more recommends");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(n().m(), new AssistedChatTopicPanelVM$handleLoadMore$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(d result) {
        AssistedChatSubPanelUIState requestRecommendsFailUIState;
        if (result.i()) {
            requestRecommendsFailUIState = new AssistedChatSubPanelUIState.UpdateRecommendsUIState(result.g(), result.j(), result.f(), result.e());
        } else {
            requestRecommendsFailUIState = new AssistedChatSubPanelUIState.RequestRecommendsFailUIState(result.b(), result.g(), result.j());
        }
        updateUI(requestRecommendsFailUIState);
    }

    private final void u() {
        QLog.d("AssistedChatTopicPanelVM", 1, "refresh recommends");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(n().n(), new AssistedChatTopicPanelVM$handleRefresh$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        d.a aVar;
        j a16;
        String a17;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AssistedChatPanelContainerMsgIntent.GetShowPanelParamMsgIntent.f349126d);
        if (k3 instanceof d.a) {
            aVar = (d.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null && (a16 = aVar.a()) != null && (a17 = a16.a()) != null) {
            n().p(a17);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull c intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof i.C9459i) {
            v();
            return;
        }
        if (intent instanceof i.d) {
            u();
            return;
        }
        if (intent instanceof i.c) {
            s();
        } else if (intent instanceof i.b) {
            p(((i.b) intent).a());
        } else if (intent instanceof i.a) {
            o();
        }
    }
}
