package com.tencent.mobileqq.groupvideo.api.impl;

import com.tencent.mobileqq.groupvideo.api.IGroupVideoQIPCApi;
import com.tencent.mobileqq.groupvideo.ipc.GroupVideoQIPCServer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/api/impl/GroupVideoQIPCApiImpl;", "Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoQIPCApi;", "()V", "getTroopIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GroupVideoQIPCApiImpl implements IGroupVideoQIPCApi {
    static IPatchRedirector $redirector_;

    public GroupVideoQIPCApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoQIPCApi
    @NotNull
    public QIPCModule getTroopIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return GroupVideoQIPCServer.INSTANCE.b();
    }
}
