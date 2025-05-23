package com.tencent.mvi.mvvm.extension;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.api.ability.e;
import com.tencent.mvi.exception.MviException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mvi/mvvm/extension/b;", "Lcom/tencent/mvi/api/ability/b;", "Landroid/os/Bundle;", "vbResult", "", "a", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Lcom/tencent/mvi/api/ability/e;", "fetchVBState", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mvi/api/ability/c;", "d", "Ljava/lang/ref/WeakReference;", "getVb", "()Ljava/lang/ref/WeakReference;", "vb", "<init>", "(Ljava/lang/ref/WeakReference;)V", "e", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public class b implements com.tencent.mvi.api.ability.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<com.tencent.mvi.api.ability.c> vb;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mvi/mvvm/extension/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mvi.mvvm.extension.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull WeakReference<com.tencent.mvi.api.ability.c> vb5) {
        Intrinsics.checkNotNullParameter(vb5, "vb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) vb5);
        } else {
            this.vb = vb5;
        }
    }

    private final void a(Bundle vbResult) {
        if (com.tencent.mvi.a.f337742b.a()) {
            Set<String> keySet = vbResult.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "vbResult.keySet()");
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                if (vbResult.get((String) it.next()) instanceof View) {
                    throw new MviException("can not generateVBState include View in " + this.vb);
                }
            }
        }
    }

    @Override // com.tencent.mvi.api.ability.b
    @NotNull
    public e fetchVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Bundle generateVBState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (e) iPatchRedirector.redirect((short) 1, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        com.tencent.mvi.api.ability.c cVar = this.vb.get();
        if (cVar != null && (generateVBState = cVar.generateVBState(stateCmd)) != null) {
            a(generateVBState);
            e eVar = new e();
            eVar.a(stateCmd, generateVBState);
            return eVar;
        }
        throw new MviException("please implement generateVBState in " + this.vb + "  and deal cmd " + stateCmd);
    }
}
