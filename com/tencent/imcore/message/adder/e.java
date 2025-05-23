package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements i {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.adder.i
    public boolean[] a(AppRuntime appRuntime, IMessageFacade iMessageFacade, MessageRecord messageRecord, EntityManager entityManager, RecentUserProxy recentUserProxy, String str, int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appRuntime, iMessageFacade, messageRecord, entityManager, recentUserProxy, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        }
        if (IceBreakingUtil.s(i16)) {
            IceBreakingUtil.o((QQAppInterface) appRuntime, str, i16, messageRecord);
            return new boolean[]{z16, true};
        }
        return new boolean[]{z16, false};
    }
}
