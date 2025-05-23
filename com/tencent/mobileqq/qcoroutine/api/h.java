package com.tencent.mobileqq.qcoroutine.api;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u001c\u0010\u001b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dR=\u0010\f\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRC\u0010\u0014\u001a \u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/h;", "Lcom/tencent/mobileqq/qcoroutine/api/g;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "j", "Lkotlin/jvm/functions/Function1;", DomainData.DOMAIN_NAME, "()Lkotlin/jvm/functions/Function1;", "setRun", "(Lkotlin/jvm/functions/Function1;)V", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "k", "Ljava/lang/ref/WeakReference;", "o", "()Ljava/lang/ref/WeakReference;", "setRunWrap", "(Ljava/lang/ref/WeakReference;)V", "runWrap", "", ThemeConstants.THEME_DIY_BG_NAME_SUFFIX, "Lcom/tencent/mobileqq/qcoroutine/api/i;", "_type", "", "_canAutoRetrieve", "_run", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qcoroutine/api/i;ZLkotlin/jvm/functions/Function1;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class h extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Continuation<? super Unit>, ? extends Object> run;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Function1<Continuation<? super Unit>, Object>> runWrap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull String _name, @NotNull i _type, boolean z16, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> _run) {
        super(_name, _type, z16, null);
        Intrinsics.checkNotNullParameter(_name, "_name");
        Intrinsics.checkNotNullParameter(_type, "_type");
        Intrinsics.checkNotNullParameter(_run, "_run");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, _name, _type, Boolean.valueOf(z16), _run);
        } else if (b()) {
            this.runWrap = new WeakReference<>(_run);
        } else {
            this.run = _run;
        }
    }

    @Nullable
    public final Function1<Continuation<? super Unit>, Object> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Function1) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.run;
    }

    @Nullable
    public final WeakReference<Function1<Continuation<? super Unit>, Object>> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WeakReference) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.runWrap;
    }
}
