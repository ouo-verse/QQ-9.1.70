package com.tencent.aio.stranger;

import com.tencent.mobileqq.aio.api.IQQTabApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/stranger/a;", "", "", "b", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "getExperimentEntity", "()Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "a", "(Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;)V", "experimentEntity", "<init>", "()V", "aio_stranger_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f69857a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IQQTabApi.a experimentEntity;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f69857a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable IQQTabApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            experimentEntity = aVar;
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (experimentEntity == null) {
            experimentEntity = ((IQQTabApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTabApi.class)).getExpEntity("exp_aio_tmp_ptt_file", true);
        }
        IQQTabApi.a aVar = experimentEntity;
        if (aVar != null) {
            return aVar.isExperiment("exp_aio_tmp_ptt_file_B");
        }
        return false;
    }
}
