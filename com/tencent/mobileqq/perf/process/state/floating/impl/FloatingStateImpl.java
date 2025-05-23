package com.tencent.mobileqq.perf.process.state.floating.impl;

import com.tencent.mobileqq.perf.process.state.floating.IFloatingState;
import com.tencent.mobileqq.perf.process.state.floating.a;
import com.tencent.mobileqq.perf.process.state.floating.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/perf/process/state/floating/impl/FloatingStateImpl;", "Lcom/tencent/mobileqq/perf/process/state/floating/IFloatingState;", "()V", "checkFloatingExist", "", "floatingBlackList", "", "", "getFloating", "", "getFloatingProcess", "getProcessValue", "name", "pid", "", "removeState", "", "wrapperClassName", "writeState", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class FloatingStateImpl implements IFloatingState {
    static IPatchRedirector $redirector_;

    public FloatingStateImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.perf.process.state.floating.IFloatingState
    public boolean checkFloatingExist(@NotNull Set<String> floatingBlackList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) floatingBlackList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(floatingBlackList, "floatingBlackList");
        return a.f257938a.a(floatingBlackList);
    }

    @Override // com.tencent.mobileqq.perf.process.state.floating.IFloatingState
    @NotNull
    public Set<String> getFloating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a.f257938a.c();
    }

    @Override // com.tencent.mobileqq.perf.process.state.floating.IFloatingState
    @NotNull
    public Set<String> getFloatingProcess(@NotNull Set<String> floatingBlackList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this, (Object) floatingBlackList);
        }
        Intrinsics.checkNotNullParameter(floatingBlackList, "floatingBlackList");
        return a.f257938a.d(floatingBlackList);
    }

    @Override // com.tencent.mobileqq.perf.process.state.floating.IFloatingState
    @NotNull
    public String getProcessValue(@NotNull String name, int pid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) name, pid);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        return b.f257940a.a(name, pid);
    }

    @Override // com.tencent.mobileqq.perf.process.state.floating.IFloatingState
    public void removeState(@NotNull String wrapperClassName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) wrapperClassName);
        } else {
            Intrinsics.checkNotNullParameter(wrapperClassName, "wrapperClassName");
            b.f257940a.b(wrapperClassName);
        }
    }

    @Override // com.tencent.mobileqq.perf.process.state.floating.IFloatingState
    public void writeState(@NotNull String wrapperClassName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) wrapperClassName);
        } else {
            Intrinsics.checkNotNullParameter(wrapperClassName, "wrapperClassName");
            b.f257940a.c(wrapperClassName);
        }
    }
}
