package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.mobileqq.matchfriend.api.IMatchFriendIPCServer;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes33.dex */
public class MatchFriendIPCServerImpl implements IMatchFriendIPCServer {
    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendIPCServer
    public QIPCModule getFlutterIpcModule() {
        return o72.a.d();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendIPCServer
    public QIPCModule getVoiceChatIpcModule() {
        return o72.c.c();
    }
}
