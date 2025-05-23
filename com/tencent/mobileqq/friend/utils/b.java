package com.tencent.mobileqq.friend.utils;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f211738a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.friend.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C7638b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final b f211739a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41722);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f211739a = new b(null);
            }
        }
    }

    /* synthetic */ b(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
    }

    public static String b(String str) {
        return str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static b d() {
        return C7638b.f211739a;
    }

    public long c(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, z16)).longValue();
        }
        if (z16) {
            str = "friendListFetchLocalStart";
        } else {
            str = "friendListFetchLocalEnd";
        }
        return this.f211738a.decodeLong(b(str), 0L);
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f211738a.decodeBool(b("isFriendlistok"), false);
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f211738a.decodeInt(b("request_friend_list_seq"), 0);
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        String a16 = a("uid_prefix_key_" + str);
        String a17 = a("uid_prefix_key_" + MMKForUinUid.c(a16, ""));
        arrayList.add(a16);
        arrayList.add(a17);
        MMKForUinUid.j(arrayList);
    }

    public void h(boolean z16, long j3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (z16) {
            str = "friendListFetchLocalStart";
        } else {
            str = "friendListFetchLocalEnd";
        }
        this.f211738a.encodeLong(b(str), j3);
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f211738a.encodeBool(b("isFriendlistok"), z16);
        }
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f211738a.encodeInt(b("request_friend_list_seq"), i3);
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f211738a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(String str) {
        return str;
    }
}
