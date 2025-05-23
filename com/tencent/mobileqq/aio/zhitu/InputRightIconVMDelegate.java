package com.tencent.mobileqq.aio.zhitu;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.InputRightIconMsgEvent;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent;
import com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent;
import com.tencent.mobileqq.aio.input.reply.a;
import com.tencent.mobileqq.aio.zhitu.InputRightIconUIState;
import com.tencent.mobileqq.aio.zhitu.a;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IRichTextPanelApi;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00014\b\u0007\u0018\u0000 \"2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u0007:\u0001=B\u000f\u0012\u0006\u00101\u001a\u00020\u0005\u00a2\u0006\u0004\b<\u00100J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\fH\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\"\u00101\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00105R\u001d\u0010;\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/aio/zhitu/InputRightIconVMDelegate;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$EditTextChangedMsgIntent;", "intent", "", "p", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "icon", "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", DomainData.DOMAIN_NAME, NodeProps.VISIBLE, "v", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "r", "Landroid/text/Editable;", "editable", "g", "", "content", h.F, "k", "j", "e", "f", "i", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/zhitu/a;", "d0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "u", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mContext", "com/tencent/mobileqq/aio/zhitu/InputRightIconVMDelegate$b", "Lcom/tencent/mobileqq/aio/zhitu/InputRightIconVMDelegate$b;", "mAction", "Lcom/tencent/mobileqq/aio/input/g;", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/aio/input/g;", "geometryReader", "<init>", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class InputRightIconVMDelegate implements e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, g {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy geometryReader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/zhitu/InputRightIconVMDelegate$a;", "", "", "MSG_MAX_LEN", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.zhitu.InputRightIconVMDelegate$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/zhitu/InputRightIconVMDelegate$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputRightIconVMDelegate.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                InputRightIconVMDelegate.this.n(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InputRightIconVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mAction = new b();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<com.tencent.mobileqq.aio.input.g>() { // from class: com.tencent.mobileqq.aio.zhitu.InputRightIconVMDelegate$geometryReader$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InputRightIconVMDelegate.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.mobileqq.aio.input.g invoke() {
                com.tencent.aio.api.runtime.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.aio.input.g) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                aVar = InputRightIconVMDelegate.this.mContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                k k3 = aVar.e().k(AIOInputMsgIntent.GetGeometryReaderIntent.f189143d);
                d.b bVar = k3 instanceof d.b ? (d.b) k3 : null;
                if (bVar != null) {
                    return bVar.a();
                }
                return null;
            }
        });
        this.geometryReader = lazy;
    }

    private final boolean e() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        int c16 = su3.c.c(g16);
        if (c16 == 0 || c16 == 1 || c16 == 3000) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InputRightIconVM", 2, "checkCurSessionType: false illegal session");
        }
        return false;
    }

    private final boolean f() {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        e.a aVar2 = (e.a) aVar.e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        if (aVar2 != null) {
            z16 = aVar2.a();
        } else {
            z16 = false;
        }
        if (z16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("InputRightIconVM", 2, "checkFullScreen: false is FullScreenMode");
            return false;
        }
        return true;
    }

    private final boolean g(Editable editable) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        com.tencent.qqnt.aio.at.c.d(editable, arrayList);
        if (arrayList.size() <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("InputRightIconVM", 4, "checkHasAt: " + z16);
        }
        return z16;
    }

    private final boolean h(String content) {
        boolean z16 = false;
        if (TextUtils.isEmpty(content)) {
            return false;
        }
        com.tencent.mobileqq.aio.zhitu.b bVar = com.tencent.mobileqq.aio.zhitu.b.f194275a;
        if (bVar.a(content) > -1 || bVar.b(content)) {
            z16 = true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("InputRightIconVM", 4, "checkHasEmoji: " + z16);
        }
        return !z16;
    }

    private final boolean i() {
        a.C7282a c7282a;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.mobileqq.aio.input.d dVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        k k3 = aVar.e().k(InputReplyMsgIntent.GetReplyData.f189808d);
        if (k3 instanceof a.C7282a) {
            c7282a = (a.C7282a) k3;
        } else {
            c7282a = null;
        }
        if (c7282a != null) {
            dVar = c7282a.a();
        }
        if (dVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("InputRightIconVM", 2, "checkHasReply: false has replyData");
            }
            return false;
        }
        return true;
    }

    private final boolean j(InputEditTextMsgIntent.EditTextChangedMsgIntent intent, String content) {
        boolean contains$default;
        if (intent.a() <= 1) {
            com.tencent.aio.api.runtime.a aVar = null;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) "\n", false, 2, (Object) null);
            if (!contains$default) {
                if (l() == null) {
                    if (!QLog.isColorLevel()) {
                        return false;
                    }
                    QLog.d("InputRightIconVM", 2, "checkInputTextFitInOneLine: false editText = null");
                    return false;
                }
                com.tencent.mobileqq.aio.zhitu.b bVar = com.tencent.mobileqq.aio.zhitu.b.f194275a;
                com.tencent.aio.api.runtime.a aVar2 = this.mContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    aVar = aVar2;
                }
                Context context = aVar.c().getContext();
                com.tencent.mobileqq.aio.input.g l3 = l();
                Intrinsics.checkNotNull(l3);
                return bVar.c(context, content, l3);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("InputRightIconVM", 2, "checkInputTextFitInOneLine: false line count > 1");
        }
        return false;
    }

    private final boolean k(String content) {
        CharSequence trim;
        boolean z16;
        boolean z17;
        if (content.length() <= 20) {
            trim = StringsKt__StringsKt.trim((CharSequence) content);
            if (trim.toString().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !TextUtils.isEmpty(content)) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("InputRightIconVM", 4, "checkLength: " + z17);
            }
            if (z17) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final com.tencent.mobileqq.aio.input.g l() {
        return (com.tencent.mobileqq.aio.input.g) this.geometryReader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MsgIntent msgIntent) {
        if (msgIntent instanceof InputRightIconMsgEvent.InputRightIconChangeVisibleEvent) {
            v(((InputRightIconMsgEvent.InputRightIconChangeVisibleEvent) msgIntent).a());
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            p((InputEditTextMsgIntent.EditTextChangedMsgIntent) msgIntent);
        } else if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            r((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent);
        } else if (msgIntent instanceof InputGagMsgIntent.OnInputGagModeChanged) {
            x(new InputRightIconUIState.InputRightIconGagState(((InputGagMsgIntent.OnInputGagModeChanged) msgIntent).a()));
        }
    }

    private final void o(View icon) {
        String str;
        CharSequence a16;
        if (QLog.isColorLevel()) {
            QLog.d("InputRightIconVM", 2, "handleInputRightIconIconClickIntent: Click");
        }
        HashMap hashMap = new HashMap();
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        d.C7264d c7264d = (d.C7264d) aVar.e().k(new InputEvent.GetInputString());
        if (c7264d == null || (a16 = c7264d.a()) == null || (str = a16.toString()) == null) {
            str = "";
        }
        hashMap.put(EmotionReportDtImpl.TEXT_IN_TEXTBOX, str);
        com.tencent.mobileqq.aio.utils.b.l("em_aio_textbox_amazing_button", hashMap);
        boolean z16 = !icon.isActivated();
        x(new InputRightIconUIState.InputRightIconChangeActivateState(z16));
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar3 = null;
        }
        aVar3.e().h(new StickerRecommendEvent.HideEmotionKeywordLayout(0L));
        com.tencent.aio.api.runtime.a aVar4 = this.mContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar4 = null;
        }
        aVar4.e().h(new InputRightIconMsgEvent.InputRightIconChangeActivateEvent(z16));
        if (z16) {
            com.tencent.aio.api.runtime.a aVar5 = this.mContext;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar5;
            }
            aVar2.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("InputRightIconVM", 1007, false, 0, 12, null));
            return;
        }
        com.tencent.aio.api.runtime.a aVar6 = this.mContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar6;
        }
        aVar2.e().h(new PanelContainerMsgIntent.HidePanelMsgIntent("InputRightIconVM", 1007, false, 4, null));
    }

    private final void p(InputEditTextMsgIntent.EditTextChangedMsgIntent intent) {
        int i3;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            i3 = c16.e();
        } else {
            i3 = 0;
        }
        if (((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isExperiment(i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("InputRightIconVM", 2, "handleInputRightIconIconClickIntent: assisted chat enable. chatType=" + i3);
            }
            v(false);
            return;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            if (QLog.isColorLevel()) {
                QLog.d("InputRightIconVM", 2, "handleInputRightIconIconClickIntent: SimpleUI");
            }
            v(false);
            return;
        }
        if (!s()) {
            v(false);
            return;
        }
        String obj = intent.c().toString();
        if (k(obj) && j(intent, obj) && e() && f() && i() && h(obj)) {
            Spanned c17 = intent.c();
            Intrinsics.checkNotNull(c17, "null cannot be cast to non-null type android.text.Editable");
            if (g((Editable) c17)) {
                v(true);
                return;
            }
        }
        v(false);
    }

    private final void r(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent msgIntent) {
        if (!msgIntent.b()) {
            x(new InputRightIconUIState.InputRightIconChangeActivateState(false));
        }
        if (msgIntent.b() && msgIntent.a() != 1007) {
            x(new InputRightIconUIState.InputRightIconChangeActivateState(false));
        }
    }

    private final boolean s() {
        return ((IRichTextPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichTextPanelApi.class)).getZhituConfigState();
    }

    private final void v(boolean visible) {
        CharSequence a16;
        String obj;
        String str = "";
        if (visible) {
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            d.C7264d c7264d = (d.C7264d) aVar.e().k(new InputEvent.GetInputString());
            if (c7264d != null && (a16 = c7264d.a()) != null && (obj = a16.toString()) != null) {
                str = obj;
            }
            x(new InputRightIconUIState.InputRightIconChangeVisibleState(true, str));
            return;
        }
        x(new InputRightIconUIState.InputRightIconChangeVisibleState(false, ""));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            e.a.a(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.InputRightIconMsgEvent.InputRightIconChangeVisibleEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent.OnInputGagModeChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        v(false);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7369a) {
            o(((a.C7369a) intent).a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().f(this, this.mAction);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
    }
}
