package com.tencent.mobileqq.proavatar.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/c;", "", "", "a", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f259718a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/c$a;", "Lcom/tencent/mobileqq/friend/observer/b;", "", "isSuccess", "", "data", "", "a", "b", "", "type", "onUpdate", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.mobileqq.friend.observer.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final a f259719d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33909);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f259719d = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final void a(boolean isSuccess, Object data) {
            QLog.d("ProAvatarFriendListObserverHelper", 2, "handleGetStoreHead isSuccess? " + isSuccess + ", data: " + data);
            if (!isSuccess || !(data instanceof HashSet)) {
                return;
            }
            Iterator it = ((HashSet) data).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof String) {
                    AvatarInfoCheck.b(1, (String) next);
                }
            }
        }

        private final void b(boolean isSuccess, Object data) {
            QLog.d("ProAvatarFriendListObserverHelper", 2, "handleGetStrangerInfo isSuccess? " + isSuccess + ", data: " + data);
            if (!isSuccess || !(data instanceof HashSet)) {
                return;
            }
            Iterator it = ((HashSet) data).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof String) {
                    AvatarInfoCheck.b(1, (String) next);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
            } else {
                if (type != 46) {
                    if (type == 62) {
                        b(isSuccess, data);
                        return;
                    }
                    return;
                }
                a(isSuccess, data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33920);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f259718a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).addObserver(a.f259719d, true);
        }
    }
}
