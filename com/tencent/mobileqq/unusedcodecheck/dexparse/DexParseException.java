package com.tencent.mobileqq.unusedcodecheck.dexparse;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/dexparse/DexParseException;", "Ljava/lang/Exception;", "message", "", "(Ljava/lang/String;)V", "dexparse"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class DexParseException extends Exception {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DexParseException(@NotNull String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) message);
        }
    }
}
