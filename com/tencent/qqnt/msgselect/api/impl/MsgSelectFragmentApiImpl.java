package com.tencent.qqnt.msgselect.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.msgselect.MsgSelectFragment;
import com.tencent.qqnt.msgselect.api.IMsgSelectFragmentApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/msgselect/api/impl/MsgSelectFragmentApiImpl;", "Lcom/tencent/qqnt/msgselect/api/IMsgSelectFragmentApi;", "()V", "getFragmentClass", "Ljava/lang/Class;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class MsgSelectFragmentApiImpl implements IMsgSelectFragmentApi {
    static IPatchRedirector $redirector_;

    public MsgSelectFragmentApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msgselect.api.IMsgSelectFragmentApi
    @NotNull
    public Class<?> getFragmentClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return MsgSelectFragment.class;
    }
}
