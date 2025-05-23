package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class AbsRecentUserBusinessBaseData extends RecentUserBaseData {
    static IPatchRedirector $redirector_;

    public AbsRecentUserBusinessBaseData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void buildMessageBody(Message message, int i3, BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, message, Integer.valueOf(i3), baseQQAppInterface, context, msgSummary);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            k(message, i3, (QQAppInterface) baseQQAppInterface, context, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void dealDraft(BaseQQAppInterface baseQQAppInterface, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) msgSummary);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            l((QQAppInterface) baseQQAppInterface, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void dealStatus(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseQQAppInterface);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            m((QQAppInterface) baseQQAppInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void extraUpdate(BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, baseQQAppInterface, context, msgSummary);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            n((QQAppInterface) baseQQAppInterface, context, msgSummary);
        }
    }

    protected void k(Message message, int i3, QQAppInterface qQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, message, Integer.valueOf(i3), qQAppInterface, context, msgSummary);
        } else {
            super.buildMessageBody(message, i3, qQAppInterface, context, msgSummary);
        }
    }

    public void l(QQAppInterface qQAppInterface, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) msgSummary);
        } else {
            super.dealDraft(qQAppInterface, msgSummary);
        }
    }

    public void m(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface);
        } else {
            super.dealStatus(qQAppInterface);
        }
    }

    protected void n(QQAppInterface qQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, qQAppInterface, context, msgSummary);
        } else {
            super.extraUpdate(qQAppInterface, context, msgSummary);
        }
    }

    public void o(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            super.update(qQAppInterface, context);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, (Object) context);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            o((QQAppInterface) baseQQAppInterface, context);
        }
    }
}
