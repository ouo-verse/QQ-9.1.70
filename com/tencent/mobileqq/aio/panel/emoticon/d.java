package com.tencent.mobileqq.aio.panel.emoticon;

import android.text.TextUtils;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.panel.emoticon.EmotionUIState;
import com.tencent.mobileqq.aio.panel.emoticon.b;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.e;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.msg.data.g;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001+\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J6\u0010!\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R&\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020+000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/emoticon/d;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/panel/emoticon/b;", "Lcom/tencent/mobileqq/aio/panel/emoticon/EmotionUIState;", "Lcom/tencent/qqnt/aio/api/e$a;", "", "r", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/qqnt/aio/api/e;", "panelProvider", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$EditTextChangedMsgIntent;", "o", "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "p", "send", "", "path", "", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "originalMd5", h.F, "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "c", "serverId", "", "isSingleLottie", "e", "Lcom/tencent/qqnt/aio/api/e;", "mPanelProvider", "com/tencent/mobileqq/aio/panel/emoticon/d$b", "f", "Lcom/tencent/mobileqq/aio/panel/emoticon/d$b;", "mAction", "", "Lkotlin/Pair;", "Ljava/util/List;", "mMessageList", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends com.tencent.qqnt.aio.baseVM.a<com.tencent.mobileqq.aio.panel.emoticon.b, EmotionUIState> implements e.a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e mPanelProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/emoticon/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.emoticon.d$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/panel/emoticon/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                d.this.E(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        List<Pair<String, b>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.EditTextChangedMsgIntent.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class)), bVar)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            o((InputEditTextMsgIntent.EditTextChangedMsgIntent) intent);
        } else if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            q((PanelStatusIntent.PanelStatusChangeIntent) intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        int i3;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new InputEvent.GetInputString());
        if (k3 instanceof d.C7264d) {
            if (TextUtils.isEmpty(((d.C7264d) k3).a())) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            updateUI(new EmotionUIState.SetOperationVisibility(i3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(e panelProvider) {
        if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelVM", 2, "[handleInitEmoPanel] aioContext=" + ((com.tencent.aio.api.runtime.a) getMContext()).hashCode() + " panelProvider=" + panelProvider.hashCode());
        }
        this.mPanelProvider = panelProvider;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(InputEvent.GetEditText.f188569d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.edit.AIOInputMsgResult.GetEditTextResult");
        panelProvider.a((com.tencent.aio.api.runtime.a) getMContext(), ((d.a) k3).a());
        panelProvider.b(this);
    }

    private final void o(InputEditTextMsgIntent.EditTextChangedMsgIntent intent) {
        int i3;
        if (TextUtils.isEmpty(intent.c())) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        updateUI(new EmotionUIState.SetOperationVisibility(i3));
    }

    private final void q(PanelStatusIntent.PanelStatusChangeIntent intent) {
        e eVar;
        Integer a16 = intent.a();
        if (a16 != null && a16.intValue() == 1001 && (eVar = this.mPanelProvider) != null) {
            eVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.api.e.a
    public void c(@NotNull MarkFaceMessage marketFaceMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) marketFaceMessage);
        } else {
            Intrinsics.checkNotNullParameter(marketFaceMessage, "marketFaceMessage");
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.MarketFaceSendEvent(marketFaceMessage));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.api.e.a
    public void e(int serverId, boolean isSingleLottie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(serverId), Boolean.valueOf(isSingleLottie));
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.EmojiFaceSendEvent(serverId, isSingleLottie));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.api.e.a
    public void h(@NotNull String path, int subType, @Nullable String textSummary, @Nullable g picExtBizInfo, @Nullable String originalMd5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, path, Integer.valueOf(subType), textSummary, picExtBizInfo, originalMd5);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelVM", 2, "[sendPicEmotion] aioContext=" + ((com.tencent.aio.api.runtime.a) getMContext()).hashCode() + " subType=" + subType + " path=" + path + " textSummary=" + textSummary);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.PicEmotionSendEvent(path, subType, textSummary, picExtBizInfo, originalMd5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        s();
        if (QLog.isColorLevel()) {
            int hashCode = ((com.tencent.aio.api.runtime.a) getMContext()).hashCode();
            e eVar = this.mPanelProvider;
            if (eVar != null) {
                num = Integer.valueOf(eVar.hashCode());
            } else {
                num = null;
            }
            QLog.d("EmotionPanelVM", 2, "[onDestroy] aioContext=" + hashCode + " panelProvider=" + num);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.aio.panel.emoticon.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C7338b) {
            b.C7338b c7338b = (b.C7338b) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.AddEmoticonToEditText(c7338b.a().c(), c7338b.a().getCode()));
            return;
        }
        if (intent instanceof b.c) {
            m();
            return;
        }
        if (intent instanceof b.a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(InputEditTextMsgIntent.BackspaceInEditText.f189406d);
        } else if (intent instanceof b.e) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgSendEvent.InputSendEvent.f188428d);
        } else if (intent instanceof b.d) {
            n(((b.d) intent).a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.api.e.a
    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgSendEvent.InputSendEvent.f188428d);
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
        if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelVM", 2, "[onCreate]: aioContext=" + context.hashCode());
        }
        r();
    }
}
