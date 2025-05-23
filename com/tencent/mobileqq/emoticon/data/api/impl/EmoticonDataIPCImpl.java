package com.tencent.mobileqq.emoticon.data.api.impl;

import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataIPC;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/impl/EmoticonDataIPCImpl;", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataIPC;", "()V", "getIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getModuleName", "", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmoticonDataIPCImpl implements IEmoticonDataIPC {
    static IPatchRedirector $redirector_;

    public EmoticonDataIPCImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataIPC
    @NotNull
    public QIPCModule getIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.emoticon.data.ipc.b.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataIPC
    @NotNull
    public String getModuleName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "EmoticonDataServiceIPC";
    }
}
