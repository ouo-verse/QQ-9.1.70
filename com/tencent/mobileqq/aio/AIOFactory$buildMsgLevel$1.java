package com.tencent.mobileqq.aio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
/* synthetic */ class AIOFactory$buildMsgLevel$1 extends FunctionReferenceImpl implements Function0<String> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIOFactory$buildMsgLevel$1(Object obj) {
        super(0, obj, AIOFactory.class, "getListVBToken", "getListVBToken()Ljava/lang/String;", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final String invoke() {
        return ((AIOFactory) this.receiver).c();
    }
}
