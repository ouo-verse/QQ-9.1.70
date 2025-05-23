package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation$NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemChatMsgBaseData extends RecentUserBaseData {
    static IPatchRedirector $redirector_ = null;
    public static final String IS_ENABLE_UNREAD_STATE = "isEnableUnreadState";

    @ParcelAnnotation$NotParcel
    protected Message mLastMessage;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgBaseData$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Message f185391d;
        final /* synthetic */ RecentItemChatMsgBaseData this$0;

        @Override // java.lang.Runnable
        public void run() {
            IMessageFacade iMessageFacade;
            Message message;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iMessageFacade = (IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")) != null && (message = this.f185391d) != null) {
                iMessageFacade.updateMsgFieldByUniseq(message.frienduin, message.istroop, message.uniseq, AppConstants.Key.COLUMN_EXT_STR, message.extStr);
            }
        }
    }

    public RecentItemChatMsgBaseData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        }
    }

    private void k(BaseQQAppInterface baseQQAppInterface) {
        this.mLastMessage = null;
        IMessageFacade iMessageFacade = (IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
        if (iMessageFacade != null && (iMessageFacade.getQQMessageFacadeStub() instanceof QQMessageFacadeStub)) {
            QQMessageFacadeStub qQMessageFacadeStub = (QQMessageFacadeStub) iMessageFacade.getQQMessageFacadeStub();
            if (qQMessageFacadeStub != null) {
                RecentUser recentUser = this.mUser;
                this.mLastMessage = qQMessageFacadeStub.getLastMessage(recentUser.uin, recentUser.getType());
            }
            Message message = this.mLastMessage;
            if (message != null) {
                this.mUnreadNum = com.tencent.mobileqq.imcore.proxy.msg.a.a(message, baseQQAppInterface);
            } else {
                this.mUnreadNum = 0;
            }
            this.msgSummary = getMsgSummaryTemp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void buildMessageBody(Message message, int i3, BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, message, Integer.valueOf(i3), baseQQAppInterface, context, msgSummary);
        } else {
            super.buildMessageBody(message, i3, baseQQAppInterface, context, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void dealDraft(BaseQQAppInterface baseQQAppInterface, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseQQAppInterface, (Object) msgSummary);
        } else {
            super.dealDraft(baseQQAppInterface, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void dealStatus(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseQQAppInterface);
        } else {
            super.dealStatus(baseQQAppInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public void extraUpdate(BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, context, msgSummary);
            return;
        }
        dealStatus(baseQQAppInterface);
        dealDraft(baseQQAppInterface, msgSummary);
        j();
        super.extraUpdate(baseQQAppInterface, context, msgSummary);
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.mUser.getType() != 0 && !a(IS_ENABLE_UNREAD_STATE, false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Message message = this.mLastMessage;
        if (message != null && message.getTime() != 0) {
            this.mDisplayTime = message.getTime();
            if (this.mDisplayTime == 0) {
                this.mDisplayTime = this.mUser.opTime;
                return;
            }
            return;
        }
        this.mDisplayTime = this.mUser.opTime;
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        super.update(baseQQAppInterface, context);
        k(baseQQAppInterface);
        if (this.mUser.getType() == 0) {
            l();
            this.mTitleName = com.tencent.mobileqq.imcore.proxy.utils.a.a(baseQQAppInterface, this.mUser.uin, true);
            buildMessageBody(this.mLastMessage, this.mUser.getType(), baseQQAppInterface, context, this.msgSummary);
        }
    }
}
