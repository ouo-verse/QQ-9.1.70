package com.tencent.mobileqq.zplan.ipc.business;

import com.tencent.mobileqq.zplan.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZPlanFriendImpl.class)
/* loaded from: classes34.dex */
public interface c {

    /* compiled from: P */
    @RemoteCallBack
    /* loaded from: classes34.dex */
    public interface a {
        void a(boolean z16);
    }

    void addFriend(Boolean bool, String str, String str2, String str3, int i3, int i16);

    void isFriend(String str, a aVar);
}
