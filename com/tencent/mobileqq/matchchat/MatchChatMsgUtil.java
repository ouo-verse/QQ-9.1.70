package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.z;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.QProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MatchChatMsgUtil {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return;
        }
        List<MessageRecord> o16 = qQAppInterface.getMessageProxy(1044).o(AppConstants.MATCH_CHAT_UIN, 1044);
        if (o16 == null) {
            QLog.i("MatchChatMsgUtil", 1, "clearMatchChatMessageBox null");
            return;
        }
        for (MessageRecord messageRecord : o16) {
            if (QLog.isColorLevel()) {
                QLog.i("MatchChatMsgUtil", 1, "clearMatchChatMessageBox, delete uin = " + messageRecord.senderuin);
            }
            qQAppInterface.getMessageFacade().q(messageRecord.senderuin, messageRecord.istroop);
        }
    }

    public static Intent b(Context context) {
        Intent intent = new Intent(context, (Class<?>) PublicFragmentActivity.class);
        intent.putExtra("uintype", 1044);
        intent.putExtra("uin", AppConstants.MATCH_CHAT_UIN);
        intent.putExtra("public_fragment_class", MatchChatMsgListFragment.class.getName());
        intent.addFlags(268435456);
        return intent;
    }

    public static BusinessInfoCheckUpdate.AppInfo c(QQAppInterface qQAppInterface, String str) {
        int d16 = d(qQAppInterface);
        QLog.i("MatchChatMsgUtil", 1, "getMatchChatRedPointAppInfo num = " + d16);
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        appInfo.path.set(str);
        appInfo.num.set(d16);
        appInfo.type.set(2);
        appInfo.iNewFlag.set(1);
        return appInfo;
    }

    public static int d(AppInterface appInterface) {
        int i3 = 0;
        if (appInterface == null) {
            return 0;
        }
        if (!e(appInterface)) {
            if (QLog.isColorLevel()) {
                QLog.i("MatchChatMsgUtil", 2, "isMatchChatRedPointSwitchOn false");
            }
            return 0;
        }
        IConversationFacade iConversationFacade = (IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "");
        List<MessageRecord> o16 = ((z) ((QProxyManager) appInterface.getProxyManagerInner()).getProxy(0)).e(1044).o(AppConstants.MATCH_CHAT_UIN, 1044);
        if (o16 == null) {
            QLog.i("MatchChatMsgUtil", 1, "getMatchChatRedPointNum null");
            return 0;
        }
        for (MessageRecord messageRecord : o16) {
            i3 += iConversationFacade.getUnreadCount(messageRecord.senderuin, messageRecord.istroop);
        }
        return i3;
    }

    public static boolean e(AppInterface appInterface) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(QQAppInterface qQAppInterface) {
        return true;
    }

    public static void h(RedTouch redTouch, BaseQQAppInterface baseQQAppInterface) {
        ThreadManagerV2.excute(new Runnable(redTouch) { // from class: com.tencent.mobileqq.matchchat.MatchChatMsgUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RedTouch f243782e;

            {
                this.f243782e = redTouch;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseQQAppInterface.this, (Object) redTouch);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int d16 = MatchChatMsgUtil.d(BaseQQAppInterface.this);
                if (QLog.isColorLevel()) {
                    QLog.d("MatchChatMsgUtil", 2, "updateExtendFriendRedTouch() : " + d16);
                }
                if (this.f243782e != null) {
                    ThreadManager.getUIHandler().post(new Runnable(d16) { // from class: com.tencent.mobileqq.matchchat.MatchChatMsgUtil.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f243783d;

                        {
                            this.f243783d = d16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, d16);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f243783d <= 0) {
                                AnonymousClass1.this.f243782e.clearRedTouch();
                                return;
                            }
                            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                            AnonymousClass1.this.f243782e.setMaxNum(99);
                            redTypeInfo.red_content.set(String.valueOf(this.f243783d));
                            redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
                            redTypeInfo.red_type.set(5);
                            AnonymousClass1.this.f243782e.parseRedTouch(redTypeInfo);
                        }
                    });
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(QQAppInterface qQAppInterface) {
    }
}
