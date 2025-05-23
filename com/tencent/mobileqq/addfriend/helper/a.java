package com.tencent.mobileqq.addfriend.helper;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.relationx.addFrd.processor.ExtendFriendAddFriendProcessor;
import com.tencent.mobileqq.relationx.addFrd.processor.KplAddFriendProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<com.tencent.mobileqq.addfriend.processor.a> f187349b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqaddfriend-impl/src/main/resources/Inject_AddFriendBusinessProcessor.yml", version = 1)
    public static ArrayList<Class<? extends com.tencent.mobileqq.addfriend.processor.a>> f187350c;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f187351a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f187349b = new ArrayList<>();
        ArrayList<Class<? extends com.tencent.mobileqq.addfriend.processor.a>> arrayList = new ArrayList<>();
        f187350c = arrayList;
        arrayList.add(KplAddFriendProcessor.class);
        f187350c.add(ExtendFriendAddFriendProcessor.class);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f187351a = false;
        }
    }

    private void b(AppInterface appInterface) {
        com.tencent.mobileqq.addfriend.processor.a aVar;
        f187349b.clear();
        Iterator<Class<? extends com.tencent.mobileqq.addfriend.processor.a>> it = f187350c.iterator();
        while (it.hasNext()) {
            Class<? extends com.tencent.mobileqq.addfriend.processor.a> next = it.next();
            if (QLog.isColorLevel()) {
                QLog.d("AddFrd.InjectHelper", 2, "initBusinessProcessors| " + next.getName());
            }
            try {
                aVar = next.getConstructor(AppInterface.class).newInstance(appInterface);
            } catch (Exception e16) {
                QLog.d("AddFrd.InjectHelper", 1, "initBusinessProcessors fail.", e16);
                aVar = null;
            }
            if (aVar != null) {
                f187349b.add(aVar);
            }
        }
    }

    public ArrayList<com.tencent.mobileqq.addfriend.processor.a> a(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        }
        if (!this.f187351a) {
            b(appInterface);
            this.f187351a = true;
        }
        return f187349b;
    }
}
