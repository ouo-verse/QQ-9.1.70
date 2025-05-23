package com.tencent.qqnt.aio.inputstatus.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.inputstatus.api.IInputStatusConfigApi;
import iv3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/inputstatus/api/impl/InputStatusConfigApiNtImpl;", "Lcom/tencent/qqnt/aio/inputstatus/api/IInputStatusConfigApi;", "Liv3/a;", "inputStateShowSwitchListener", "", "getInputStatusSwitch", "", "getMyOnlineStatus", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class InputStatusConfigApiNtImpl implements IInputStatusConfigApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    public InputStatusConfigApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "InputStatusConfigApiNtImpl";
        }
    }

    @Override // com.tencent.qqnt.aio.inputstatus.api.IInputStatusConfigApi
    public void getInputStatusSwitch(@NotNull a inputStateShowSwitchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputStateShowSwitchListener);
        } else {
            Intrinsics.checkNotNullParameter(inputStateShowSwitchListener, "inputStateShowSwitchListener");
            QLog.d(this.TAG, 1, "NT InputStatusConfigApiNtImpl getInputStatusSwitch");
        }
    }

    @Override // com.tencent.qqnt.aio.inputstatus.api.IInputStatusConfigApi
    public boolean getMyOnlineStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QLog.d(this.TAG, 1, "NT InputStatusConfigApiNtImpl getMyOnlineStatus");
        return false;
    }
}
