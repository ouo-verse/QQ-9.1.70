package com.tencent.mobileqq.aio.input.at;

import android.view.View;
import android.widget.EditText;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.at.a;
import com.tencent.mobileqq.aio.input.at.b;
import com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase;
import com.tencent.mobileqq.aio.input.at.d;
import com.tencent.mobileqq.aio.input.dialog.msgintent.InputDialogPriorityMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.input.api.IInputAtApi;
import com.tencent.qqnt.robot.api.IRobotAtApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.util.QQToastUtil;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0002;>\b\u0007\u0018\u0000 B2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u0007:\u0001CB\u000f\u0012\u0006\u00102\u001a\u00020\u0005\u00a2\u0006\u0004\bA\u00101J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J.\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00182\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020!H\u0002J\u0018\u0010%\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0002H\u0016R\"\u00102\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/InputAtVMDelegate;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/g;", "Landroid/view/View;", "anchor", "Landroid/widget/EditText;", "editText", "", "i", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "f", "", "memberUid", "memberUin", "nickName", "", "showKeyboard", "k", "Lkotlin/Pair;", "p", DomainData.DOMAIN_NAME, "o", "msg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lcom/tencent/mvi/base/route/k;", "g", "Lcom/tencent/mobileqq/aio/input/at/InputAtMsgIntent$CreateAtSpan;", h.F, "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/at/b;", "d0", "intent", "l", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "e", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "r", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/aio/input/at/business/h;", "Lcom/tencent/mobileqq/aio/input/at/business/h;", "mAtSelectMemberUseCase", "Lcom/tencent/qqnt/aio/input/api/IInputAtApi;", "Lcom/tencent/qqnt/aio/input/api/IInputAtApi;", "mInputAtApi", "com/tencent/mobileqq/aio/input/at/InputAtVMDelegate$b", "Lcom/tencent/mobileqq/aio/input/at/InputAtVMDelegate$b;", "mAction", "com/tencent/mobileqq/aio/input/at/InputAtVMDelegate$c", "Lcom/tencent/mobileqq/aio/input/at/InputAtVMDelegate$c;", "mActionR", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class InputAtVMDelegate implements e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.input.at.business.h mAtSelectMemberUseCase;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IInputAtApi mInputAtApi;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/InputAtVMDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.InputAtVMDelegate$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/at/InputAtVMDelegate$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputAtVMDelegate.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                InputAtVMDelegate.this.f(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/at/InputAtVMDelegate$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputAtVMDelegate.this);
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
            return InputAtVMDelegate.this.g(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InputAtVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MsgIntent msgIntent) {
        if (msgIntent instanceof InputAtMsgIntent.InsertAtMemberSpan) {
            InputAtMsgIntent.InsertAtMemberSpan insertAtMemberSpan = (InputAtMsgIntent.InsertAtMemberSpan) msgIntent;
            k(insertAtMemberSpan.c(), insertAtMemberSpan.d(), insertAtMemberSpan.a(), insertAtMemberSpan.b());
        } else if (msgIntent instanceof InputAtMsgIntent.InsertAtAllMemberSpan) {
            j(((InputAtMsgIntent.InsertAtAllMemberSpan) msgIntent).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k g(MsgIntent msgIntent) {
        if (msgIntent instanceof InputAtMsgIntent.CreateAtSpan) {
            return h((InputAtMsgIntent.CreateAtSpan) msgIntent);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final k h(InputAtMsgIntent.CreateAtSpan msgIntent) {
        CharSequence atSpan = getMHost().fetchVBState(new d.C7258d(msgIntent.b(), msgIntent.c(), msgIntent.d(), msgIntent.a())).b().getCharSequence("at_member_span", "");
        Intrinsics.checkNotNullExpressionValue(atSpan, "atSpan");
        return new a.C7251a(atSpan);
    }

    private final void i(View anchor, EditText editText) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOContact c16 = aVar.g().r().c();
        if (c16.e() == 2) {
            QLog.i("InputAtVMDelegate", 1, "handleInitAtSelectMemberMviIntent troopUin = " + c16.j());
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar3;
            }
            AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase = new AIOAtSelectMemberUseCase(aVar2, anchor, editText);
            aIOAtSelectMemberUseCase.d0();
            this.mAtSelectMemberUseCase = aIOAtSelectMemberUseCase;
            IInputAtApi iInputAtApi = (IInputAtApi) QRoute.api(IInputAtApi.class);
            iInputAtApi.initInput(editText);
            this.mInputAtApi = iInputAtApi;
        }
    }

    private final void j(boolean showKeyboard) {
        boolean z16;
        CharSequence it = getMHost().fetchVBState(d.b.f189316b).b().getCharSequence("at_all_span", "");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.aio.api.runtime.a aVar = null;
        if (!z16) {
            it = null;
        }
        if (it != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().h(new InputEditTextMsgIntent.InsertTextInSelection(it, showKeyboard));
        }
    }

    private final void k(String memberUid, String memberUin, String nickName, boolean showKeyboard) {
        boolean z16;
        Pair<Boolean, String> p16 = p(memberUid, memberUin, nickName);
        boolean booleanValue = p16.component1().booleanValue();
        String component2 = p16.component2();
        if (booleanValue) {
            m(component2);
            return;
        }
        CharSequence it = getMHost().fetchVBState(new d.C7258d(memberUid, memberUin, nickName, false, 8, null)).b().getCharSequence("at_member_span", "");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.aio.api.runtime.a aVar = null;
        if (!z16) {
            it = null;
        }
        if (it != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().h(new InputEditTextMsgIntent.InsertTextInSelection(it, showKeyboard));
        }
    }

    private final void m(String msg2) {
        boolean z16;
        if (msg2 != null && msg2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QQToastUtil.showQQToastInUiThread(0, msg2);
    }

    private final boolean n(String memberUid, String memberUin, String nickName) {
        return getMHost().fetchVBState(new d.e(memberUid, memberUin, nickName)).b().getBoolean("has_at_member_span", false);
    }

    private final boolean o() {
        if (getMHost().fetchVBState(new d.c(InputAtVMDelegate$hasReachAtMemberLimit$result$1.INSTANCE)).b().getInt("get_match_at_span_count", 0) < ((IRobotAtApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotAtApi.class)).getAtRobotLimit()) {
            return false;
        }
        return true;
    }

    private final Pair<Boolean, String> p(String memberUid, String memberUin, String nickName) {
        if (((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotUin(memberUin)) {
            if (n(memberUid, memberUin, nickName)) {
                return new Pair<>(Boolean.TRUE, null);
            }
            if (o()) {
                return new Pair<>(Boolean.TRUE, null);
            }
        }
        return new Pair<>(Boolean.FALSE, null);
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
        return com.tencent.mobileqq.aio.input.at.b.class;
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

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.at.InputAtMsgIntent.InsertAtMemberSpan");
        hashSet.add("com.tencent.mobileqq.aio.input.at.InputAtMsgIntent.InsertAtAllMemberSpan");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.at.InputAtMsgIntent.CreateAtSpan");
        return hashSet;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.c) {
            b.c cVar = (b.c) intent;
            i(cVar.a(), cVar.b());
            return;
        }
        if (intent instanceof b.C7252b) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().h(new InputDialogPriorityMsgIntent.AddProcessBarrier("InputAtVMDelegate", 0, 2, null));
            return;
        }
        if (intent instanceof b.a) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            aVar2.e().h(new InputDialogPriorityMsgIntent.RemoveProcessBarrier("InputAtVMDelegate", 0, 2, null));
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.aio.input.at.business.h hVar = this.mAtSelectMemberUseCase;
        if (hVar != null) {
            hVar.onDestroy();
        }
        IInputAtApi iInputAtApi = this.mInputAtApi;
        if (iInputAtApi != null) {
            iInputAtApi.onDestroy();
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().e(this);
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAIOContext = context;
        com.tencent.aio.api.runtime.a aVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            context = null;
        }
        context.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().l(this, this.mActionR);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }
}
