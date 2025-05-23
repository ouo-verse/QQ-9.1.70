package com.tencent.mobileqq.highway.api.impl;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/highway/api/impl/KernelConfigBean;", "Lcom/tencent/freesia/IConfigData;", "()V", "isAllUseKernel", "", "()Z", "setAllUseKernel", "(Z)V", "useKernelCommands", "", "", "getUseKernelCommands", "()Ljava/util/List;", "setUseKernelCommands", "(Ljava/util/List;)V", "toString", "", "Transfile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class KernelConfigBean implements IConfigData {
    static IPatchRedirector $redirector_;
    private boolean isAllUseKernel;

    @NotNull
    private List<Integer> useKernelCommands;

    public KernelConfigBean() {
        List<Integer> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isAllUseKernel = true;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.useKernelCommands = emptyList;
    }

    @NotNull
    public final List<Integer> getUseKernelCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.useKernelCommands;
    }

    public final boolean isAllUseKernel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isAllUseKernel;
    }

    public final void setAllUseKernel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isAllUseKernel = z16;
        }
    }

    public final void setUseKernelCommands(@NotNull List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.useKernelCommands = list;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "KernelConfigBean(isAllUseKernel=" + this.isAllUseKernel + ", useKernelCommands=" + this.useKernelCommands + ')';
    }
}
