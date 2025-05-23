package com.tencent.mobileqq.aio.factory;

import com.tencent.aio.api.factory.j;
import com.tencent.mobileqq.aio.AIOFactory;
import com.tencent.mobileqq.aio.helper.provider.C2CAIOHelperProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/C2CAIOFactory;", "Lcom/tencent/mobileqq/aio/AIOFactory;", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/mobileqq/aio/factory/AIOThirdLevelFactory;", "d", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class C2CAIOFactory extends AIOFactory {
    static IPatchRedirector $redirector_;

    public C2CAIOFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new C2CAIOHelperProvider();
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (j) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new AIOMsgAdornApiImpl(null, C2CAIOFactory$buildMsgLevel$1.INSTANCE, null, null, new C2CAIOFactory$buildMsgLevel$2(this), 13, null);
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AIOThirdLevelFactory buildBusinessLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOThirdLevelFactory) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AIOThirdLevelFactory(new com.tencent.mobileqq.aio.factory.inputadorn.a());
    }
}
