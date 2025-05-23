package com.tencent.qqnt.msg.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.msg.api.IUnreadCountChangeApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/UnreadCountChangeApiImpl;", "Lcom/tencent/qqnt/msg/api/IUnreadCountChangeApi;", "Lcom/tencent/qqnt/msg/unread/c;", "interceptor", "", "registerUnreadCountInterceptor", "unRegisterUnreadCountInterceptor", "Lcom/tencent/qqnt/msg/unread/a;", "observer", "registerUnreadCountObserver", "unRegisterUnreadCountObserver", "", "uid", "", "getUnreadCount", "getTotalUnreadCount", "notifyCurUnreadInfo", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "getTotalUnreadInfo", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class UnreadCountChangeApiImpl implements IUnreadCountChangeApi {
    static IPatchRedirector $redirector_;

    public UnreadCountChangeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    public int getTotalUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return com.tencent.qqnt.msg.unread.b.f359711a.d();
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    @NotNull
    public Map<String, UnreadCntInfo> getTotalUnreadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return com.tencent.qqnt.msg.unread.b.f359711a.e();
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    public int getUnreadCount(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uid)).intValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        return com.tencent.qqnt.msg.unread.b.f359711a.f(uid);
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    public void notifyCurUnreadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            com.tencent.qqnt.msg.unread.b.f359711a.h();
        }
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    public void registerUnreadCountInterceptor(@NotNull com.tencent.qqnt.msg.unread.c interceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) interceptor);
        } else {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            com.tencent.qqnt.msg.unread.b.f359711a.b().add(interceptor);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    public void registerUnreadCountObserver(@NotNull com.tencent.qqnt.msg.unread.a observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            com.tencent.qqnt.msg.unread.b.f359711a.c().add(observer);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    public void unRegisterUnreadCountInterceptor(@NotNull com.tencent.qqnt.msg.unread.c interceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) interceptor);
        } else {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            com.tencent.qqnt.msg.unread.b.f359711a.b().remove(interceptor);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IUnreadCountChangeApi
    public void unRegisterUnreadCountObserver(@NotNull com.tencent.qqnt.msg.unread.a observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            com.tencent.qqnt.msg.unread.b.f359711a.c().remove(observer);
        }
    }
}
