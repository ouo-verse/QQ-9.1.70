package com.tencent.mobileqq.aio.reserve1.floatlayout;

import com.tencent.mobileqq.aio.reserve1.floatlayout.ReserveFloatMviUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.lazy.AIOLazyVB;
import com.tencent.qqnt.aio.lazy.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/floatlayout/a;", "Lcom/tencent/qqnt/aio/lazy/AIOLazyVB;", "", "Lcom/tencent/mobileqq/aio/reserve1/floatlayout/ReserveFloatMviUIState;", "Lcom/tencent/mobileqq/aio/reserve1/floatlayout/ReserveFloatMviUIState$AddFloatView;", "state", "", "i1", "Lcom/tencent/mobileqq/aio/reserve1/floatlayout/ReserveFloatMviUIState$RemoveFloatView;", "k1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "j1", "Lcom/tencent/qqnt/aio/lazy/c;", "fetcher", "<init>", "(Lcom/tencent/qqnt/aio/lazy/c;)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends AIOLazyVB<Object, ReserveFloatMviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/floatlayout/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.floatlayout.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull c fetcher) {
        super(fetcher);
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fetcher);
        }
    }

    private final void i1(ReserveFloatMviUIState.AddFloatView state) {
        QLog.i("AIOBusinessFloatVB", 1, "[addFloatVB]: busiType is " + state.a());
        h1(state.b());
    }

    private final void k1(ReserveFloatMviUIState.RemoveFloatView state) {
        QLog.i("AIOBusinessFloatVB", 1, "[removeFloatView]: busiType is " + state.a());
        g1(state.b());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<Object, ReserveFloatMviUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ReserveFloatMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof ReserveFloatMviUIState.AddFloatView) {
            i1((ReserveFloatMviUIState.AddFloatView) state);
        } else if (state instanceof ReserveFloatMviUIState.RemoveFloatView) {
            k1((ReserveFloatMviUIState.RemoveFloatView) state);
        }
    }
}
