package com.tencent.relation.common.dispatch.impl;

import com.tencent.mobileqq.partyroom.dispatch.PartySecurityDispatcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.relation.common.dispatch.c;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0x14e.submsgtype0x14e$MsgBody;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/relation-common-impl/src/main/resources/Inject_Dispatcher.yml", version = 3)
    protected static ArrayList<Class<? extends c<submsgtype0x14e$MsgBody>>> f364714a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends c<submsgtype0x14e$MsgBody>>> arrayList = new ArrayList<>();
        f364714a = arrayList;
        arrayList.add(PartySecurityDispatcher.class);
    }
}
