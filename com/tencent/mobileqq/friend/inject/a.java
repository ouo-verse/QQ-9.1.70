package com.tencent.mobileqq.friend.inject;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_PhoneContactService.yml", version = 1)
    private static ArrayList<Class<? extends c>> f211686a;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_ContactFacadeService.yml", version = 1)
    private static ArrayList<Class<? extends b>> f211687b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_PubAccountService.yml", version = 1)
    private static ArrayList<Class<? extends d>> f211688c;

    /* renamed from: d, reason: collision with root package name */
    private static b f211689d;

    /* renamed from: e, reason: collision with root package name */
    private static c f211690e;

    /* renamed from: f, reason: collision with root package name */
    private static d f211691f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41634);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f211686a = arrayList;
        arrayList.add(com.tencent.mobileqq.relation.friend.inject.a.class);
        f211687b = new ArrayList<>();
        ArrayList<Class<? extends d>> arrayList2 = new ArrayList<>();
        f211688c = arrayList2;
        arrayList2.add(com.tencent.mobileqq.relation.friend.inject.b.class);
    }

    public static b a() {
        if (f211689d == null) {
            synchronized (b.class) {
                if (f211689d == null) {
                    try {
                        if (f211687b.size() == 0) {
                            return null;
                        }
                        f211689d = f211687b.get(0).newInstance();
                    } catch (Exception e16) {
                        QLog.d("FriendInjectFactory", 1, "getContactFacadeService", e16);
                    }
                }
            }
        }
        return f211689d;
    }

    public static c b() {
        if (f211690e == null) {
            synchronized (c.class) {
                if (f211690e == null) {
                    try {
                        if (f211686a.size() == 0) {
                            return null;
                        }
                        f211690e = f211686a.get(0).newInstance();
                    } catch (Exception e16) {
                        QLog.d("FriendInjectFactory", 1, "getPhoneContactService", e16);
                    }
                }
            }
        }
        return f211690e;
    }

    public static d c() {
        if (f211691f == null) {
            synchronized (d.class) {
                if (f211691f == null) {
                    try {
                        if (f211688c.size() == 0) {
                            return null;
                        }
                        f211691f = f211688c.get(0).newInstance();
                    } catch (Exception e16) {
                        QLog.d("FriendInjectFactory", 1, "getPubAccountService", e16);
                    }
                }
            }
        }
        return f211691f;
    }
}
