package com.tencent.mobileqq.app.friendlist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0007J\b\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/friendlist/b;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "param", "", "b", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f195634a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f195634a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102056", false);
    }

    @JvmStatic
    public static final void b(@NotNull HashMap<String, String> param) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i("FriendListInterfaceHelper", 1, "reportInfo,key=" + param.keySet() + ",value=" + param.values());
        if (param.isEmpty()) {
            QLog.w("FriendListInterfaceHelper", 1, "can't Report, param is invalid!");
        } else {
            c.f195635a.b(param);
        }
    }
}
