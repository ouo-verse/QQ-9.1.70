package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.notification.base.AIOTopTipContainerVBFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/aio/Inject_aio_reverse1_vb_factory.yml", version = 1)
    public static ArrayList<com.tencent.qqnt.aio.data.a> f348972a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f348973b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65972);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f348973b = arrayList;
        arrayList.add(AIOTopTipContainerVBFactory.class);
        f348972a = new ArrayList<>();
        a();
    }

    @QAutoInitMethod
    private static void a() {
        com.tencent.mobileqq.qroute.utils.b.c(f348973b, f348972a);
    }
}
