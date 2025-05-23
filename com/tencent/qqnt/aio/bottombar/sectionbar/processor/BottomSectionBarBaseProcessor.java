package com.tencent.qqnt.aio.bottombar.sectionbar.processor;

import androidx.annotation.CallSuper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.f;
import com.tencent.mvi.base.route.g;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tl.h;

@KeepClassConstructor
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b'\u0018\u0000 \u00162\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0017J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0013H&J\b\u0010\u0018\u001a\u00020\bH\u0017J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0013R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010#\u001a\u0004\b \u0010$\"\u0004\b%\u0010&R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/a;", "callback", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "vmScope", "", "b", "", "f", "e", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", h.F, "Lol3/b;", "i", "j", "k", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "model", "p", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "d", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/a;", "bottomSectionBarVMAbility", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", DomainData.DOMAIN_NAME, "(Lcom/tencent/aio/api/runtime/a;)V", "Lkotlinx/coroutines/CoroutineScope;", "g", "()Lkotlinx/coroutines/CoroutineScope;", "o", "(Lkotlinx/coroutines/CoroutineScope;)V", "Z", "hasInit", "<init>", "()V", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BottomSectionBarBaseProcessor implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a bottomSectionBarVMAbility;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public CoroutineScope vmScope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51026);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BottomSectionBarBaseProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void b(@NotNull a callback, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope vmScope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, callback, aioContext, vmScope);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(vmScope, "vmScope");
        this.bottomSectionBarVMAbility = callback;
        n(aioContext);
        o(vmScope);
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        a aVar = this.bottomSectionBarVMAbility;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSectionBarVMAbility");
            aVar = null;
        }
        return aVar.b();
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        return null;
    }

    public abstract int e();

    public abstract int f();

    @NotNull
    public final CoroutineScope g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        CoroutineScope coroutineScope = this.vmScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vmScope");
        return null;
    }

    @Override // com.tencent.mvi.base.route.g
    public /* synthetic */ Set getSubscribeEventNames() {
        return f.a(this);
    }

    @Override // com.tencent.mvi.base.route.g
    public /* synthetic */ Set getSubscribeEventRNames() {
        return f.b(this);
    }

    public abstract boolean h(@NotNull MsgIntent intent);

    public abstract void i(@NotNull ol3.b intent);

    public abstract boolean j();

    @CallSuper
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.hasInit = false;
        }
    }

    @CallSuper
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.hasInit = true;
        QLog.d("BottomSectionBarBaseProcessor", 4, "onInitData, contact=" + d().g().r().c());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> m() {
        List<String> emptyList;
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Set subscribeEventNames = getSubscribeEventNames();
        if (subscribeEventNames == null || list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public final void n(@NotNull com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.aioContext = aVar;
        }
    }

    public final void o(@NotNull CoroutineScope coroutineScope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) coroutineScope);
        } else {
            Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
            this.vmScope = coroutineScope;
        }
    }

    public final void p(@NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.b model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        if (!this.hasInit) {
            QLog.i("BottomSectionBarBaseProcessor", 1, "submitSection but VB has not ready.");
        }
        a aVar = this.bottomSectionBarVMAbility;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSectionBarVMAbility");
            aVar = null;
        }
        aVar.a(model);
    }

    public final void q(@NotNull MviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (!this.hasInit) {
            QLog.i("BottomSectionBarBaseProcessor", 1, "updateUI but VB has not ready.");
        }
        a aVar = this.bottomSectionBarVMAbility;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSectionBarVMAbility");
            aVar = null;
        }
        aVar.c(f(), state);
    }
}
