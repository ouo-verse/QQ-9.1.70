package com.tencent.mobileqq.vip.api.impl;

import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/f;", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f implements com.tencent.cachedrawable.dynamicdrawable.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f312873a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49697);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f312873a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.e
    @NotNull
    public AbsFileDecoder a(@NotNull String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsFileDecoder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath);
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new PngsDecoderForQzone100(filePath);
    }
}
