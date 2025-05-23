package com.tencent.qne;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qne/QneSDKTester;", "", "()V", "nTestModel", "", "modelId", "enableNPU", "", "enableCPU", "testModel", "qne_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class QneSDKTester {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final QneSDKTester INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new QneSDKTester();
        }
    }

    QneSDKTester() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final native String nTestModel(String modelId, boolean enableNPU, boolean enableCPU);

    @NotNull
    public final String testModel(@NotNull String modelId, boolean enableNPU, boolean enableCPU) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, modelId, Boolean.valueOf(enableNPU), Boolean.valueOf(enableCPU));
        }
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return nTestModel(modelId, enableNPU, enableCPU);
    }
}
