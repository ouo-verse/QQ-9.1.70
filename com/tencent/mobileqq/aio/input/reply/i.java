package com.tencent.mobileqq.aio.input.reply;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputRightIconMsgEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.input.accessability.AIOInputAccessibilityUIState;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockStateIntent;
import com.tencent.mobileqq.aio.input.blockstate.f;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent;
import com.tencent.mobileqq.aio.input.gag.a;
import com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent;
import com.tencent.mobileqq.aio.input.joinstate.c;
import com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent;
import com.tencent.mobileqq.aio.input.reply.InputReplyUIState;
import com.tencent.mobileqq.aio.input.reply.a;
import com.tencent.mobileqq.aio.input.reply.b;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u00028;\b\u0007\u0018\u0000 ?2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u0007:\u0001@B\u000f\u0012\u0006\u00101\u001a\u00020\u0005\u00a2\u0006\u0004\b>\u00100J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0002H\u0016J\u000e\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020(J\u000e\u0010+\u001a\u00020*2\u0006\u0010&\u001a\u00020(R\"\u00101\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00102R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/i;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "from", "", "invokeKeyboard", "", "i", "l", "c", "j", "", "msgSeq", "msgId", "o", "k", "", "nickName", "", "replyText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/reply/b;", "d0", "intent", tl.h.F, "Lcom/tencent/mvi/base/route/MsgIntent;", "f", "Lcom/tencent/mvi/base/route/k;", "g", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "e", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "p", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "I", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Lcom/tencent/mobileqq/aio/input/d;", "Lcom/tencent/mobileqq/aio/input/d;", "replyData", "com/tencent/mobileqq/aio/input/reply/i$b", "Lcom/tencent/mobileqq/aio/input/reply/i$b;", "mAction", "com/tencent/mobileqq/aio/input/reply/i$c", "Lcom/tencent/mobileqq/aio/input/reply/i$c;", "mActionR", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.input.d replyData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/i$a;", "", "", "SOURCE_INPUT_REPLY", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.reply.i$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/reply/i$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgIntent);
            } else {
                Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
                i.this.f(msgIntent);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/reply/i$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent msgIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgIntent);
            }
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            return i.this.g(msgIntent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56856);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mAction = new b();
        this.mActionR = new c();
    }

    private final boolean c() {
        a.C7269a c7269a;
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        k k3 = aVar.e().k(InputGagMsgIntent.GetGagMode.f189666d);
        if (k3 instanceof a.C7269a) {
            c7269a = (a.C7269a) k3;
        } else {
            c7269a = null;
        }
        if (c7269a != null && c7269a.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        QQToast.makeText(aVar2.c().getContext(), R.string.emm, 0).show();
        return true;
    }

    private final void d() {
        com.tencent.aio.api.runtime.a aVar = null;
        this.replyData = null;
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().h(InputRightIconMsgEvent.UpdateRightIconVisibleEvent.f188584d);
        s(InputReplyUIState.ClearReplyUIState.f189810d);
    }

    private final void i(AIOMsgItem msgItem, int from, boolean invokeKeyboard) {
        if (l()) {
            return;
        }
        if (!c()) {
            j(msgItem, from, invokeKeyboard);
        }
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            s(AIOInputAccessibilityUIState.RequestInputFocus.f189163d);
        }
    }

    private final void j(AIOMsgItem msgItem, int from, boolean invokeKeyboard) {
        String h16 = com.tencent.mobileqq.aio.reply.c.h(msgItem);
        QRouteApi api = QRoute.api(INickNameApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INickNameApi::class.java)");
        com.tencent.aio.api.runtime.a aVar = null;
        String obj = INickNameApi.a.a((INickNameApi) api, h16, false, 2, null).toString();
        CharSequence d16 = com.tencent.mobileqq.aio.reply.c.d(msgItem.getMsgRecord(), true, obj);
        this.from = from;
        q(obj, d16, msgItem.getMsgSeq(), msgItem.getMsgId());
        if (invokeKeyboard) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            aVar2.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L, 1, null));
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar3;
        }
        if (aVar.g().r().c().e() == 2) {
            k(msgItem);
        }
    }

    private final void k(AIOMsgItem msgItem) {
        if (!msgItem.isSelf() && !com.tencent.mobileqq.aio.utils.d.s(msgItem)) {
            String obj = com.tencent.mobileqq.aio.utils.c.a(msgItem).toString();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            j e16 = aVar.e();
            String str = msgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
            e16.h(new InputAtMsgIntent.InsertAtMemberSpan(str, String.valueOf(msgItem.getMsgRecord().senderUin), obj, false, 8, null));
        }
    }

    private final boolean l() {
        c.a aVar;
        boolean z16;
        boolean z17;
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        f.a aVar3 = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        k k3 = aVar2.e().k(GroupJoinStateIntent.GetJoinState.f189732d);
        if (k3 instanceof c.a) {
            aVar = (c.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null && !aVar.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.aio.api.runtime.a aVar4 = this.mContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar4 = null;
        }
        k k16 = aVar4.e().k(GroupBlockStateIntent.GetTroopBlockState.f189333d);
        if (k16 instanceof f.a) {
            aVar3 = (f.a) k16;
        }
        if (aVar3 != null && aVar3.b()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("InputReplyVMDelegate", 4, "[isNeedSkipReplyEvent] isExit:" + z16 + ", isBlock:" + z17);
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    private final void m() {
        h.a aVar;
        boolean z16;
        com.tencent.mobileqq.aio.input.d dVar = this.replyData;
        if (dVar != null) {
            long b16 = dVar.b();
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            com.tencent.aio.api.runtime.a aVar3 = null;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            k k3 = aVar2.e().k(PanelContainerMsgIntent.GetPanelContainerStateMsgIntent.f116805d);
            if (k3 instanceof h.a) {
                aVar = (h.a) k3;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                if (!aVar.b() && !aVar.c()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    aVar = null;
                }
                if (aVar != null) {
                    com.tencent.aio.api.runtime.a aVar4 = this.mContext;
                    if (aVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    } else {
                        aVar3 = aVar4;
                    }
                    aVar3.e().h(new MsgNavigationEvent.NavigateBySeqEvent("INPUT_REPLY_SPAN", b16, 0L, false, null, false, false, null, 252, null));
                }
            }
        }
    }

    private final void o(long msgSeq, long msgId) {
        boolean z16;
        com.tencent.mobileqq.aio.input.d dVar = this.replyData;
        if (dVar != null) {
            boolean z17 = true;
            if (dVar != null && dVar.b() == msgSeq) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.aio.input.d dVar2 = this.replyData;
                if (dVar2 == null || dVar2.a() != msgId) {
                    z17 = false;
                }
                if (z17) {
                    d();
                }
            }
        }
    }

    private final void q(String nickName, CharSequence replyText, long msgSeq, long msgId) {
        this.replyData = new com.tencent.mobileqq.aio.input.d(nickName, replyText.toString(), msgSeq, msgId);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new InputRightIconMsgEvent.InputRightIconChangeVisibleEvent(false));
        AIOUtil aIOUtil = AIOUtil.f194084a;
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        s(new InputReplyUIState.SetReplyUIState(msgId, nickName, replyText, this.from, aIOUtil.c(aVar2)));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
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
        return com.tencent.mobileqq.aio.input.reply.b.class;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    public final void f(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgSendEvent.MsgOnClickReplyEvent) {
            AIOMsgSendEvent.MsgOnClickReplyEvent msgOnClickReplyEvent = (AIOMsgSendEvent.MsgOnClickReplyEvent) intent;
            i(msgOnClickReplyEvent.c(), msgOnClickReplyEvent.a(), msgOnClickReplyEvent.b());
            return;
        }
        if (intent instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            AIOMsgSendEvent.MsgOnRevokeEvent msgOnRevokeEvent = (AIOMsgSendEvent.MsgOnRevokeEvent) intent;
            o(msgOnRevokeEvent.b(), msgOnRevokeEvent.a());
            return;
        }
        if (intent instanceof InputReplyMsgIntent.SetReplyData) {
            InputReplyMsgIntent.SetReplyData setReplyData = (InputReplyMsgIntent.SetReplyData) intent;
            String str = setReplyData.a().senderUidStr;
            Intrinsics.checkNotNullExpressionValue(str, "intent.replyElement.senderUidStr");
            String str2 = setReplyData.a().sourceMsgText;
            Intrinsics.checkNotNullExpressionValue(str2, "intent.replyElement.sourceMsgText");
            Long l3 = setReplyData.a().replayMsgSeq;
            Intrinsics.checkNotNullExpressionValue(l3, "intent.replyElement.replayMsgSeq");
            q(str, str2, l3.longValue(), setReplyData.a().replayMsgId);
            return;
        }
        if (intent instanceof InputReplyMsgIntent.ClearReplyData) {
            d();
        } else if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            s(new InputReplyUIState.SetFullScreenModeUIState(((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a()));
        }
    }

    @NotNull
    public final k g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (k) iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof InputReplyMsgIntent.GetReplyData) {
            return new a.C7282a(this.replyData);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnClickReplyEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnRevokeEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent.SetReplyData");
        hashSet.add("com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent.ClearReplyData");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenModeChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Set) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent.GetReplyData");
        return hashSet;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            d();
        } else if (intent instanceof b.C7283b) {
            m();
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        com.tencent.aio.api.runtime.a aVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().l(this, this.mActionR);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().e(this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void s(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
    }
}
