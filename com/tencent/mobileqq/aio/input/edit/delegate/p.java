package com.tencent.mobileqq.aio.input.edit.delegate;

import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextUIState;
import com.tencent.mobileqq.aio.input.edit.delegate.g;
import com.tencent.mobileqq.aio.input.edit.delegate.o;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\b\u0006*\u0002EH\b\u0007\u0018\u0000 \u000e2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u0007:\u0001LB\u000f\u0012\u0006\u0010@\u001a\u00020\u0005\u00a2\u0006\u0004\bK\u0010?J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\b\u0010,\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020-H\u0002J\u0018\u00103\u001a\u00020\r2\u0006\u00100\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u00020\rH\u0016J\u0010\u00106\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0002H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020807H\u0016R\"\u0010@\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010AR\u0016\u0010D\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/p;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/g;", "Landroid/text/Spanned;", "spannedChars", "", "selectionStart", "lineCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "f", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$AppendTextToEditText;", tl.h.F, "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$ReplaceTextToEditText;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$InsertTextInSelection;", "p", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$PostToDoRunnable;", "r", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$UpdateRobotDrawData;", "v", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$UpdateRobotWriteData;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$UpdateRobotPromptFunctionData;", "w", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SetAIBusinessFlag;", "t", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$SetTextToEditText;", "u", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$AddEmoticonToEditText;", "event", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/k;", "g", "j", "k", "i", "l", "", "text", "o", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "y", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/g;", "d0", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "e", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Z", "inputEditTextPrefTrack", "com/tencent/mobileqq/aio/input/edit/delegate/p$b", "Lcom/tencent/mobileqq/aio/input/edit/delegate/p$b;", "mAction", "com/tencent/mobileqq/aio/input/edit/delegate/p$c", "Lcom/tencent/mobileqq/aio/input/edit/delegate/p$c;", "mActionR", "<init>", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class p implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean inputEditTextPrefTrack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/p$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.edit.delegate.p$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/edit/delegate/p$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                p.this.f(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/edit/delegate/p$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
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
            return p.this.g(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55109);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public p(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.inputEditTextPrefTrack = true;
        this.mAction = new b();
        this.mActionR = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MsgIntent msgIntent) {
        if (msgIntent instanceof InputEditTextMsgIntent.ShowKeyboardMsgIntent) {
            B(new InputEditTextUIState.ShowKeyboardUIState(((InputEditTextMsgIntent.ShowKeyboardMsgIntent) msgIntent).a()));
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.SetHintToEditText) {
            B(new InputEditTextUIState.SetHintTextUIState(((InputEditTextMsgIntent.SetHintToEditText) msgIntent).a()));
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.BackspaceInEditText) {
            B(InputEditTextUIState.BackSpaceInEditTextUIState.f189471d);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.SetEditTextEnableState) {
            InputEditTextMsgIntent.SetEditTextEnableState setEditTextEnableState = (InputEditTextMsgIntent.SetEditTextEnableState) msgIntent;
            String b16 = setEditTextEnableState.b();
            if (b16 == null) {
                b16 = "";
            }
            B(new InputEditTextUIState.SetEnableStatusUIState(b16, setEditTextEnableState.a()));
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.AddEmoticonToEditText) {
            n((InputEditTextMsgIntent.AddEmoticonToEditText) msgIntent);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.SetTextToEditText) {
            u((InputEditTextMsgIntent.SetTextToEditText) msgIntent);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.AppendTextToEditText) {
            h((InputEditTextMsgIntent.AppendTextToEditText) msgIntent);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.ReplaceTextToEditText) {
            s((InputEditTextMsgIntent.ReplaceTextToEditText) msgIntent);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.ClearEditTextContent) {
            B(InputEditTextUIState.ClearEditTextContentUIState.f189472d);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.ClearEditInputFocus) {
            B(InputEditTextUIState.ClearEditTextFocusUIState.f189473d);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.RequestEditTextFocus) {
            B(InputEditTextUIState.RequestEditTextFocusUIState.f189480d);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.SelectAll) {
            B(InputEditTextUIState.SelectAllUIState.f189481d);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.SetSelection) {
            B(new InputEditTextUIState.SetSelectionUIState(((InputEditTextMsgIntent.SetSelection) msgIntent).a()));
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.AddNewLineToEditText) {
            B(InputEditTextUIState.AddNewLineUIState.f189469d);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.InsertTextInSelection) {
            p((InputEditTextMsgIntent.InsertTextInSelection) msgIntent);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.PostToDoRunnable) {
            r((InputEditTextMsgIntent.PostToDoRunnable) msgIntent);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.UpdateRobotDrawData) {
            v((InputEditTextMsgIntent.UpdateRobotDrawData) msgIntent);
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.UpdateRobotWriteData) {
            x((InputEditTextMsgIntent.UpdateRobotWriteData) msgIntent);
        } else if (msgIntent instanceof InputEditTextMsgIntent.UpdateRobotPromptFunctionData) {
            w((InputEditTextMsgIntent.UpdateRobotPromptFunctionData) msgIntent);
        } else if (msgIntent instanceof AIOMsgSendEvent.SetAIBusinessFlag) {
            t((AIOMsgSendEvent.SetAIBusinessFlag) msgIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k g(MsgIntent event) {
        if (event instanceof InputEvent.GetInputString) {
            return j();
        }
        if (event instanceof InputEvent.GetInputTextString) {
            return k();
        }
        if (event instanceof InputEvent.GetInputLineCount) {
            return i();
        }
        if (event instanceof InputEvent.GetRobotCallbackData) {
            return l();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void h(InputEditTextMsgIntent.AppendTextToEditText msgIntent) {
        B(new InputEditTextUIState.AppendContentToEditTextUIState(msgIntent.a()));
        if (msgIntent.b()) {
            B(new InputEditTextUIState.ShowKeyboardUIState(0L));
        }
    }

    private final com.tencent.mvi.base.route.k i() {
        return new d.j(getMHost().fetchVBState(o.b.f189550a).b().getInt("input_line_count", 0));
    }

    private final com.tencent.mvi.base.route.k j() {
        CharSequence charSequence = getMHost().fetchVBState(o.d.f189552a).b().getCharSequence("input_text");
        if (charSequence == null) {
            charSequence = "";
        }
        return new d.C7264d(charSequence);
    }

    private final com.tencent.mvi.base.route.k k() {
        StringBuilder sb5 = new StringBuilder();
        o.a aVar = new o.a(null, 1, null);
        getMHost().fetchVBState(aVar);
        List<f.e> a16 = aVar.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            if (!(((f.e) obj) instanceof f.d)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb5.append(((f.e) it.next()).d());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "ssb.toString()");
        return new d.f(sb6);
    }

    private final com.tencent.mvi.base.route.k l() {
        return new d.g(getMHost().fetchVBState(o.c.f189551a).b().getString("input_callback_data", ""));
    }

    private final void m(Spanned spannedChars, int selectionStart, int lineCount) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new InputEditTextMsgIntent.EditTextChangedMsgIntent(spannedChars, selectionStart, lineCount));
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            o(spannedChars);
        }
    }

    private final void n(InputEditTextMsgIntent.AddEmoticonToEditText event) {
        String emojiString;
        if (event.b() == 1) {
            emojiString = com.tencent.qqnt.emotion.text.c.c(event.a());
        } else {
            emojiString = com.tencent.qqnt.emotion.text.c.a(event.a());
        }
        Intrinsics.checkNotNullExpressionValue(emojiString, "emojiString");
        B(new InputEditTextUIState.InsertInSelectionUIState(emojiString));
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new InputEditTextMsgIntent.AfterAddEmoticonToEditText(event));
    }

    private final void o(CharSequence text) {
        if (!TextUtils.isEmpty(text) && this.inputEditTextPrefTrack) {
            this.inputEditTextPrefTrack = false;
            ((IQQHodorPrefApi) com.tencent.qqnt.trace.g.INSTANCE.a(IQQHodorPrefApi.class)).collectTrackInfo("inputEditText_click_business");
        }
    }

    private final void p(InputEditTextMsgIntent.InsertTextInSelection msgIntent) {
        B(new InputEditTextUIState.InsertInSelectionUIState(msgIntent.a()));
        if (msgIntent.b()) {
            B(new InputEditTextUIState.ShowKeyboardUIState(0L));
        }
    }

    private final void r(InputEditTextMsgIntent.PostToDoRunnable msgIntent) {
        B(new InputEditTextUIState.PostToDoRunnableUIState(msgIntent.a()));
    }

    private final void s(InputEditTextMsgIntent.ReplaceTextToEditText msgIntent) {
        B(new InputEditTextUIState.ReplaceTextToEditTextUIState(msgIntent.a(), msgIntent.c(), msgIntent.b()));
    }

    private final void t(AIOMsgSendEvent.SetAIBusinessFlag msgIntent) {
        B(new InputEditTextUIState.SetAIBusinessFlag(msgIntent.a()));
    }

    private final void u(InputEditTextMsgIntent.SetTextToEditText msgIntent) {
        B(new InputEditTextUIState.SetEditTextContentUIState(msgIntent.a()));
        if (msgIntent.b()) {
            B(new InputEditTextUIState.ShowKeyboardUIState(0L));
        }
    }

    private final void v(InputEditTextMsgIntent.UpdateRobotDrawData msgIntent) {
        B(new InputEditTextUIState.UpdateRobotDrawDataUIState(msgIntent.f(), msgIntent.e(), msgIntent.d(), msgIntent.c(), msgIntent.b(), msgIntent.a()));
    }

    private final void w(InputEditTextMsgIntent.UpdateRobotPromptFunctionData msgIntent) {
        B(new InputEditTextUIState.UpdateRobotPromptFunctionDataUIState(msgIntent.d(), msgIntent.c(), msgIntent.b(), msgIntent.a()));
    }

    private final void x(InputEditTextMsgIntent.UpdateRobotWriteData msgIntent) {
        B(new InputEditTextUIState.UpdateRobotWriteDataUIState(msgIntent.d(), msgIntent.c(), msgIntent.b(), msgIntent.a()));
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void B(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return g.class;
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
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.ShowKeyboardMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.SetHintToEditText");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.BackspaceInEditText");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.SetEditTextEnableState");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.AddEmoticonToEditText");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.SetTextToEditText");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.ClearEditTextContent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.ClearEditInputFocus");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.AppendTextToEditText");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.SelectAll");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.SetSelection");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.AddNewLineToEditText");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.InsertTextInSelection");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.ReplaceTextToEditText");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.PostToDoRunnable");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.UpdateRobotDrawData");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.UpdateRobotWriteData");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SetAIBusinessFlag");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.UpdateRobotPromptFunctionData");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.GetInputString");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.GetInputTextString");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.GetInputLineCount");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.GetRobotCallbackData");
        return hashSet;
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

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof g.a) {
            g.a aVar = (g.a) intent;
            m(aVar.a(), aVar.c(), aVar.b());
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
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

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
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
