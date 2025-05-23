package com.tencent.mobileqq.springhb.entry.helper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.OnGrabActivityData;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75308);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    @Nullable
    public static OnGrabActivityData a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            SpringFestivalEntryManager springFestivalEntryManager = (SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
            BaseActivityData A = springFestivalEntryManager.A(springFestivalEntryManager.I());
            if (A instanceof OnGrabActivityData) {
                return (OnGrabActivityData) A;
            }
            return null;
        }
        return null;
    }
}
