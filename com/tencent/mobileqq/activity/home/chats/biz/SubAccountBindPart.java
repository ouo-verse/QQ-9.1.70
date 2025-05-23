package com.tencent.mobileqq.activity.home.chats.biz;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.dc;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class SubAccountBindPart extends d implements Observer {
    static IPatchRedirector $redirector_;
    private final dc C;
    private final bs D;

    /* loaded from: classes10.dex */
    class a extends bs {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindPart.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onGetSubAccountMsg(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                if (aVar != null) {
                    QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + aVar.f291121a + " errorMsg=" + aVar.f291122b + " mainAccount=" + aVar.f291123c + "  subAccount=" + aVar.f291124d + " isNeedStartGetMsg=" + aVar.f291131k);
                } else {
                    QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + z16 + "  subAccount=" + str);
                }
            }
            AppRuntime X9 = SubAccountBindPart.this.X9();
            if (!(X9 instanceof QQAppInterface)) {
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) X9;
            if (aVar != null) {
                int i3 = aVar.f291121a;
                if (i3 != 1002) {
                    if (i3 != 1008) {
                        if (aVar.f291132l && !aVar.f291133m && (str2 = aVar.f291124d) != null && str2.length() > 4) {
                            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(qQAppInterface, str, 6);
                            aVar.f291133m = true;
                        }
                    } else {
                        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).unbindAllRecentItem(qQAppInterface, 0);
                    }
                } else {
                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(qQAppInterface, str);
                }
            }
            SubAccountBindPart.this.va();
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onPushSubAccountMsg(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + z16 + " subAccount=" + str);
                if (aVar != null) {
                    QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + aVar.f291123c + " subAccount=" + aVar.f291124d + " data.errorType=" + aVar.f291121a + " errorMsg=" + aVar.f291122b + " isNeedStartGetMsg=" + aVar.f291131k);
                }
            }
            if (z16 && aVar != null) {
                AppRuntime X9 = SubAccountBindPart.this.X9();
                if (!(X9 instanceof QQAppInterface)) {
                    return;
                }
                QQAppInterface qQAppInterface = (QQAppInterface) X9;
                int i3 = aVar.f291121a;
                if (i3 == 0) {
                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(qQAppInterface, str, 1);
                    ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) X9.getRuntimeService(ISubAccountControlService.class, "");
                    if (iSubAccountControlService != null) {
                        iSubAccountControlService.cancelHintDialog(str, 1, true);
                        return;
                    }
                    return;
                }
                if (i3 == 1) {
                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(qQAppInterface, str);
                    SubAccountBindPart.this.ua();
                }
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onSubAccountMsgNumConfirm(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2);
            } else {
                super.onSubAccountMsgNumConfirm(z16, str, str2);
                SubAccountBindPart.this.va();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindPart.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("SubAccountBindPart", 2, "onResult:" + i3 + " ,errMsg:" + str);
        }
    }

    public SubAccountBindPart(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.C = new dc() { // from class: com.tencent.mobileqq.activity.home.chats.biz.SubAccountBindPart.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountBindPart.this);
                    }
                }

                @Override // com.tencent.mobileqq.app.dc
                protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), aVar2);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + z16);
                        if (aVar2 != null) {
                            QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + aVar2.f291123c + " subAccount=" + aVar2.f291124d + " errType=" + aVar2.f291121a + " errMsg=" + aVar2.f291122b);
                        }
                    }
                    AppRuntime X9 = SubAccountBindPart.this.X9();
                    if (!(X9 instanceof QQAppInterface)) {
                        return;
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) X9;
                    if (z16 && aVar2 != null && aVar2.i()) {
                        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(qQAppInterface, aVar2.f(), 1);
                    } else if (SubAccountBindPart.this.la() && aVar2 != null && !TextUtils.isEmpty(aVar2.f291122b)) {
                        ThreadManager.getUIHandler().post(new Runnable(aVar2) { // from class: com.tencent.mobileqq.activity.home.chats.biz.SubAccountBindPart.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ com.tencent.mobileqq.subaccount.logic.a f182907d;

                            {
                                this.f182907d = aVar2;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) aVar2);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    QQToast.makeText(BaseApplication.getContext(), this.f182907d.f291122b, 0).show();
                                }
                            }
                        });
                    }
                    SubAccountBindPart.this.va();
                }

                @Override // com.tencent.mobileqq.app.dc
                protected void b(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar2) {
                    String str;
                    ArrayList<String> e16;
                    String str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), aVar2);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Conversation.onGetBindSubAccount() return, isSucc=");
                        sb5.append(z16);
                        sb5.append(" mSubUin=");
                        if (aVar2 == null) {
                            str2 = null;
                        } else {
                            str2 = aVar2.f291124d;
                        }
                        sb5.append(str2);
                        QLog.d("SUB_ACCOUNT", 2, sb5.toString());
                    }
                    AppRuntime X9 = SubAccountBindPart.this.X9();
                    if (!(X9 instanceof QQAppInterface)) {
                        return;
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) X9;
                    if (z16 && aVar2 != null) {
                        if (aVar2.f291121a == 1008) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
                            }
                            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).unbindAllRecentItem(qQAppInterface, 0);
                        }
                        if (aVar2.g()) {
                            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(qQAppInterface, aVar2.d(), 2);
                            qQAppInterface.mFirstGetSubAccountName = true;
                        }
                        if (aVar2.h() && (e16 = aVar2.e()) != null) {
                            Iterator<String> it = e16.iterator();
                            while (it.hasNext()) {
                                ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(qQAppInterface, it.next());
                            }
                        }
                        aVar2.b();
                        SubAccountBindPart.this.ua();
                        SubAccountBindPart.this.va();
                        return;
                    }
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Conversation.onGetBindSubAccount() return:");
                        if (z16) {
                            str = "data=null";
                        } else {
                            str = "isSucc=false";
                        }
                        sb6.append(str);
                        QLog.d("SUB_ACCOUNT", 4, sb6.toString());
                    }
                }

                @Override // com.tencent.mobileqq.app.dc
                protected void c(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar2) {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), aVar2);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + z16);
                        if (aVar2 != null) {
                            QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + aVar2.f291123c + " subAccount=" + aVar2.f291124d + " errType=" + aVar2.f291121a + " errMsg=" + aVar2.f291122b);
                        }
                    }
                    AppRuntime X9 = SubAccountBindPart.this.X9();
                    if (!(X9 instanceof QQAppInterface)) {
                        return;
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) X9;
                    if (aVar2 == null) {
                        return;
                    }
                    if (z16 && (str = aVar2.f291124d) != null && str.length() > 4) {
                        qQAppInterface.getMessageFacade().O0(aVar2.f291124d, 7000);
                        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(qQAppInterface, aVar2.f291124d);
                    }
                    SubAccountBindPart.this.va();
                }
            };
            this.D = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ra(ISubAccountControlService iSubAccountControlService, Pair pair, DialogInterface dialogInterface, int i3) {
        iSubAccountControlService.cancelHintDialog((String) pair.first, ((Integer) pair.second).intValue(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sa(AppRuntime appRuntime, QQAppInterface qQAppInterface) {
        if (ha()) {
            return;
        }
        final ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appRuntime.getRuntimeService(ISubAccountControlService.class, "");
        ArrayList<Pair<String, Integer>> popWaittingHintPair = iSubAccountControlService.popWaittingHintPair(ISubAccountControlService.UIN_ALL);
        int size = popWaittingHintPair.size();
        for (int i3 = 0; i3 < size; i3++) {
            final Pair<String, Integer> pair = popWaittingHintPair.get(i3);
            iSubAccountControlService.showHintDialog(qQAppInterface, (BaseActivity) getActivity(), pair, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.home.chats.biz.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    SubAccountBindPart.ra(ISubAccountControlService.this, pair, dialogInterface, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ta(FrameHelperActivity frameHelperActivity) {
        DrawerFrame drawerFrame;
        final AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        final QQAppInterface qQAppInterface = (QQAppInterface) X9;
        if (la() && (drawerFrame = frameHelperActivity.E) != null && !drawerFrame.q() && ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).needShowHintDialog(qQAppInterface, ISubAccountControlService.UIN_ALL)) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.p
                @Override // java.lang.Runnable
                public final void run() {
                    SubAccountBindPart.this.sa(X9, qQAppInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.q
            @Override // java.lang.Runnable
            public final void run() {
                SubAccountBindPart.this.xa();
            }
        }, 16, null, false);
    }

    private void wa(Object obj) {
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            if (strArr.length == 2 && AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(strArr[0]) && strArr[1] != null) {
                va();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa() {
        com.tencent.qqnt.kernel.api.aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("SubAccountBindPart", 1, "onGetSubAccountMsg service is null");
            return;
        }
        RecentContactData recentContactData = ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getRecentContactData();
        if (recentContactData == null) {
            return;
        }
        recentContactService.upsertRecentContactManually(recentContactData, new b());
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.qqnt.chats.biz.main.part.a
    public void A9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        super.A9(appRuntime);
        if (!(appRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        qQAppInterface.addObserver(this.C, true);
        qQAppInterface.addObserver(this.D, true);
        if (qQAppInterface.getMessageFacade() != null) {
            qQAppInterface.getMessageFacade().addObserver(this);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void B9(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            super.B9(i3);
            va();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.qqnt.chats.biz.main.part.a
    public void R9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        if (!(appRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        qQAppInterface.removeObserver(this.C);
        qQAppInterface.removeObserver(this.D);
        if (qQAppInterface.getMessageFacade() != null) {
            qQAppInterface.getMessageFacade().deleteObserver(this);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SubAccountBindPart";
    }

    public void ua() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        final FrameHelperActivity ba5 = ba();
        if (ba5 == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.o
            @Override // java.lang.Runnable
            public final void run() {
                SubAccountBindPart.this.ta(ba5);
            }
        }, 5, null, true);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) observable, obj);
        } else {
            wa(obj);
        }
    }
}
