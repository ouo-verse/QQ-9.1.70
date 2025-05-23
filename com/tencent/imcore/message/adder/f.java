package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f implements i {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.adder.i
    public boolean[] a(AppRuntime appRuntime, IMessageFacade iMessageFacade, MessageRecord messageRecord, EntityManager entityManager, RecentUserProxy recentUserProxy, String str, int i3, boolean z16, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appRuntime, iMessageFacade, messageRecord, entityManager, recentUserProxy, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        }
        if ((messageRecord instanceof MessageForVideo) && (i17 = messageRecord.istroop) != 3000 && i17 != 1) {
            int i18 = -1;
            try {
                String[] split = messageRecord.f203106msg.split("\\|");
                if (split != null && split.length >= 2) {
                    i18 = Integer.valueOf(split[1]).intValue();
                }
            } catch (Exception unused) {
            }
            com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) appRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
            if (i18 == 6) {
                fVar.C((MessageForVideo) messageRecord, true);
            } else {
                fVar.C((MessageForVideo) messageRecord, false);
            }
            fVar.D((MessageForVideo) messageRecord);
        }
        return new boolean[]{z16, false};
    }
}
