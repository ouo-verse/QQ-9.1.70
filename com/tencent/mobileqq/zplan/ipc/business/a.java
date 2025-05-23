package com.tencent.mobileqq.zplan.ipc.business;

import com.tencent.mobileqq.zplan.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZPlanAvatarImpl.class)
/* loaded from: classes34.dex */
public interface a {

    /* compiled from: P */
    @RemoteCallBack
    /* renamed from: com.tencent.mobileqq.zplan.ipc.business.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public interface InterfaceC9181a {
        void a(boolean z16, String str);
    }

    /* compiled from: P */
    @RemoteCallBack
    /* loaded from: classes34.dex */
    public interface b {
        void onResult(boolean z16, String str);
    }

    /* compiled from: P */
    @RemoteCallBack
    /* loaded from: classes34.dex */
    public interface c {
    }

    /* compiled from: P */
    @RemoteCallBack
    /* loaded from: classes34.dex */
    public interface d {
        void onResult(String str, String str2);
    }

    /* compiled from: P */
    @RemoteCallBack
    /* loaded from: classes34.dex */
    public interface e {
        void a(boolean z16, String str);
    }

    void getUserAvatar(String str, b bVar);

    void saveUserRoleImage(String str, e eVar);
}
