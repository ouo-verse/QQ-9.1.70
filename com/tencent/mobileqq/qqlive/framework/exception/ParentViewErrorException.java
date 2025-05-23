package com.tencent.mobileqq.qqlive.framework.exception;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/exception/ParentViewErrorException;", "Lcom/tencent/mobileqq/qqlive/framework/exception/QQLiveException;", "msg", "", "(Ljava/lang/String;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ParentViewErrorException extends QQLiveException {
    static IPatchRedirector $redirector_;

    public ParentViewErrorException() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentViewErrorException(@NotNull String msg2) {
        super(msg2);
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msg2);
    }

    public /* synthetic */ ParentViewErrorException(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
