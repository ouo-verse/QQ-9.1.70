package com.tencent.qqnt.miniaio;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
/* synthetic */ class MiniaioFactory$buildMsgLevel$1 extends FunctionReferenceImpl implements Function1<Context, Integer> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniaioFactory$buildMsgLevel$1(Object obj) {
        super(1, obj, MiniaioFactory.class, "getMsgListHeadPadding", "getMsgListHeadPadding(Landroid/content/Context;)I", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Integer invoke(@NotNull Context p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return Integer.valueOf(((MiniaioFactory) this.receiver).d(p06));
    }
}
