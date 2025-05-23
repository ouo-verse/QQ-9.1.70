package com.tencent.mobileqq.aio.input.edit.delegate;

import android.content.Context;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.delegate.f;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.v;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00162\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006:\u0001+B\u000f\u0012\u0006\u0010%\u001a\u00020\u0005\u00a2\u0006\u0004\b*\u0010$J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016R\"\u0010%\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010)\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/e;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "", "l", "f", "j", "k", "Landroid/view/Menu;", "menu", "Landroid/content/Context;", "context", "g", "Lcom/tencent/mobileqq/aio/input/edit/delegate/f$b;", "intent", "e", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/input/edit/delegate/f$h;", tl.h.F, "d", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/f;", "d0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/c;", "c", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "o", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Z", "mIsFullScreenModeWhenShowMenu", "<init>", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenModeWhenShowMenu;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/e$a;", "", "", "MENU_CLICK_REPORT_NEW_LINE", "I", "MENU_CLICK_REPORT_OTHER", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.edit.delegate.e$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
        }
    }

    private final void d() {
        QLog.i("AIOEditTextInitializeVMDelegate", 1, "handleClickEnterKey");
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(AIOMsgSendEvent.InputSendEvent.f188428d);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
    }

    private final void e(f.b intent) {
        boolean z16;
        KeyEvent a16 = intent.a();
        if (a16 != null && a16.getKeyCode() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            InputEditTextMsgIntent.DispatchKeyBackEventInPreIme dispatchKeyBackEventInPreIme = new InputEditTextMsgIntent.DispatchKeyBackEventInPreIme(false);
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            aVar.e().h(dispatchKeyBackEventInPreIme);
            intent.c(dispatchKeyBackEventInPreIme.a());
        }
    }

    private final void f() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new FullScreenMsgIntent.SetFullScreenMode(false));
    }

    private final void g(Menu menu, Context context) {
        boolean z16;
        menu.add(0, 4, 196608, context.getString(R.string.yrd));
        new HashMap().put("longpress_menu_action_item", 0);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        e.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        boolean z17 = k3 instanceof e.a;
        if (z17) {
            aVar2 = (e.a) k3;
        }
        if (aVar2 != null) {
            z16 = aVar2.a();
        } else {
            z16 = false;
        }
        if (z17) {
            if (z16) {
                menu.add(0, 3, 196608, context.getString(R.string.yr_));
            } else {
                menu.add(0, 2, 196608, context.getString(R.string.yra));
            }
        }
        this.mIsFullScreenModeWhenShowMenu = z16;
        if (z16) {
            com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_full_screen_press_menu");
        } else {
            com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_input_press_menu");
        }
    }

    private final void h(f.h intent) {
        com.tencent.aio.api.runtime.a aVar;
        QLog.i("NTSogou", 1, "get ime intent");
        if (intent.a() != null && intent.b() != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            Context context = aVar2.c().getContext();
            if (context != null) {
                v vVar = v.f352323a;
                com.tencent.aio.api.runtime.a aVar3 = this.mContext;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                } else {
                    aVar = aVar3;
                }
                vVar.i(context, aVar, intent.a(), intent.b(), intent.c());
            }
        }
    }

    private final void j() {
        e.a aVar;
        boolean z16;
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        com.tencent.aio.api.runtime.a aVar3 = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar2.e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        if (k3 instanceof e.a) {
            aVar = (e.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            z16 = aVar.a();
        } else {
            z16 = false;
        }
        if (z16) {
            HashMap hashMap = new HashMap();
            hashMap.put("longpress_menu_action_item", 0);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_full_screen_press_menu", hashMap);
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("longpress_menu_action_item", 0);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_input_press_menu", hashMap2);
        }
        com.tencent.aio.api.runtime.a aVar4 = this.mContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar3 = aVar4;
        }
        aVar3.e().h(InputEditTextMsgIntent.AddNewLineToEditText.f189402d);
    }

    private final void k() {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        e.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        if (k3 instanceof e.a) {
            aVar2 = (e.a) k3;
        }
        if (aVar2 != null) {
            z16 = aVar2.a();
        } else {
            z16 = false;
        }
        if (z16) {
            HashMap hashMap = new HashMap();
            hashMap.put("longpress_menu_action_item", 2);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_full_screen_press_menu", hashMap);
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("longpress_menu_action_item", 2);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_input_press_menu", hashMap2);
        }
    }

    private final void l() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new FullScreenMsgIntent.SetFullScreenMode(true));
    }

    private final void n() {
        if (this.mIsFullScreenModeWhenShowMenu) {
            com.tencent.mobileqq.aio.utils.b.f194119a.s("em_bas_full_screen_press_menu");
        } else {
            com.tencent.mobileqq.aio.utils.b.f194119a.s("em_bas_input_press_menu");
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

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return f.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof f.b) {
            e((f.b) intent);
            return;
        }
        if (intent instanceof f.g) {
            f.g gVar = (f.g) intent;
            g(gVar.b(), gVar.a());
            return;
        }
        if (intent instanceof f.i) {
            n();
            return;
        }
        if (intent instanceof f.C7265f) {
            l();
            return;
        }
        if (intent instanceof f.c) {
            f();
            return;
        }
        if (intent instanceof f.d) {
            j();
            return;
        }
        if (intent instanceof f.e) {
            k();
        } else if (intent instanceof f.h) {
            h((f.h) intent);
        } else if (intent instanceof f.a) {
            d();
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            this.mContext = context;
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
