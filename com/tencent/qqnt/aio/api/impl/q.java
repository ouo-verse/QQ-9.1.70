package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.animation.AIOAnimationVBFactory;
import com.tencent.mobileqq.aio.notification.base.AIONotificationVBFactory;
import com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVBFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutSubMenuFactory;
import com.tencent.qqnt.aio.reserve2.BusiAnimationVBFactory;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/aio/foreground_vb_factory.yml", version = 2)
    static ArrayList<com.tencent.qqnt.aio.data.a> f348968a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f348969b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f348969b = arrayList;
        arrayList.add(AIONotificationVBFactory.class);
        f348969b.add(AIOAnimationVBFactory.class);
        f348969b.add(BusiAnimationVBFactory.class);
        f348969b.add(QQStrangerQuoteVBFactory.class);
        f348969b.add(TroopShortcutSubMenuFactory.class);
        f348968a = new ArrayList<>();
        a();
    }

    @QAutoInitMethod
    private static void a() {
        com.tencent.mobileqq.qroute.utils.b.c(f348969b, f348968a);
    }
}
