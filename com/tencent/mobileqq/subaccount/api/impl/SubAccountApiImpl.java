package com.tencent.mobileqq.subaccount.api.impl;

import QQService.BindUin;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.dc;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.ae;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ci;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubAccountApiImpl implements ISubAccountApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ISubAccountApi.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISubAccountControlService.a f291058a;

        a(ISubAccountControlService.a aVar) {
            this.f291058a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountApiImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.g
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f291058a.f291056a;
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.g
        public boolean isShowRedDot() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.f291058a.f291057b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements ISubAccountApi.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SubAccountInfo f291060a;

        b(SubAccountInfo subAccountInfo) {
            this.f291060a = subAccountInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountApiImpl.this, (Object) subAccountInfo);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.f
        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f291060a.subuin;
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.f
        public int getStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f291060a.status;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c extends dc {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISubAccountApi.e f291062d;

        c(ISubAccountApi.e eVar) {
            this.f291062d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountApiImpl.this, (Object) eVar);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
                return;
            }
            ISubAccountApi.e eVar = this.f291062d;
            if (aVar != null) {
                z17 = false;
            }
            eVar.c(z16, z17);
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void b(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
                return;
            }
            ISubAccountApi.e eVar = this.f291062d;
            if (aVar != null) {
                z17 = false;
            }
            eVar.a(z16, z17);
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void c(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar);
                return;
            }
            ISubAccountApi.e eVar = this.f291062d;
            if (aVar != null) {
                z17 = false;
            }
            eVar.b(z16, z17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d extends bs {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISubAccountApi.d f291064d;

        d(ISubAccountApi.d dVar) {
            this.f291064d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountApiImpl.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onGetSubAccountMsg(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, aVar);
                return;
            }
            ISubAccountApi.d dVar = this.f291064d;
            if (aVar != null) {
                z17 = false;
            }
            dVar.c(z16, str, z17);
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onSubAccountMsgNumConfirm(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2);
            } else {
                this.f291064d.a(z16, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onSubAccountThirdQQUnreadMsgNum(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, bVar);
                return;
            }
            ISubAccountApi.d dVar = this.f291064d;
            if (bVar != null) {
                z17 = false;
            }
            dVar.b(z16, str, z17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e extends bs {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISubAccountApi.c f291066d;

        e(ISubAccountApi.c cVar) {
            this.f291066d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountApiImpl.this, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onGetSubAccountMsg(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, aVar);
            } else {
                this.f291066d.d(z16, str, aVar);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onPushSubAccountMsg(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, aVar);
            } else {
                this.f291066d.b(z16, str, aVar);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onSubAccountMsgNumConfirm(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2);
            } else {
                this.f291066d.a(z16, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onSubAccountThirdQQUnreadMsgNum(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, bVar);
            } else {
                this.f291066d.c(z16, str, bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class f extends ar {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISubAccountApi.b f291068d;

        f(ISubAccountApi.b bVar) {
            this.f291068d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountApiImpl.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else {
                this.f291068d.a(str, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class g extends CardObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISubAccountApi.a f291070d;

        g(ISubAccountApi.a aVar) {
            this.f291070d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountApiImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetSubaccountDisplayThirdQQ(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.f291070d.a(z16);
            }
        }
    }

    public SubAccountApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public boolean cleanThirdQQUnreadMsgNum(SimpleAccount simpleAccount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) simpleAccount)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanThirdQQUnreadMsgNum((AppInterface) peekAppRuntime, simpleAccount);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void clearGestureData(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) str);
        } else {
            BaseGesturePWDUtil.clearGestureData(context, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public BusinessObserver createMessageObserver(ISubAccountApi.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
        }
        return new d(dVar);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public BusinessObserver createSubAccountBindObserver(ISubAccountApi.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        }
        return new c(eVar);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void deleteHistory(AppInterface appInterface, String str) {
        ProxyManager proxyManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        if ((appInterface instanceof QQAppInterface) && (proxyManager = ((QQAppInterface) appInterface).getProxyManager()) != null) {
            proxyManager.transSaveToDatabase();
            try {
                String uid = ((IUidService) QRoute.api(IUidService.class)).getUid(str);
                if (!TextUtils.isEmpty(uid)) {
                    ci.k().ClearMoblieQQAccountData(uid);
                }
            } catch (Exception e16) {
                QLog.e("SubAccountApiImpl", 1, "clear nt data error:", e16);
            }
            new com.tencent.mobileqq.managers.c().a(str);
            ae.a().c(appInterface.getApp(), str, false);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public String getAccountManagerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "AccountManagerFragment";
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public List<ISubAccountApi.f> getAllSubAccountInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ArrayList arrayList = new ArrayList();
        if (peekAppRuntime instanceof QQAppInterface) {
            Iterator<SubAccountInfo> it = ((ISubAccountService) peekAppRuntime.getRuntimeService(ISubAccountService.class, "")).getAllSubAccountInfo().iterator();
            while (it.hasNext()) {
                arrayList.add(new b(it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public BusinessObserver getCardObserver(ISubAccountApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
        }
        return new g(aVar);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public BusinessObserver getFriendListObserver(ISubAccountApi.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
        }
        return new f(bVar);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public BusinessObserver getMessageObserver(ISubAccountApi.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 14, (Object) this, (Object) cVar);
        }
        return new e(cVar);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public com.tencent.mobileqq.app.message.a getProcessor(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (com.tencent.mobileqq.app.message.a) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appInterface);
        }
        if (appInterface instanceof QQAppInterface) {
            return ((QQAppInterface) appInterface).getMsgHandler().l3();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public String getQRCodeKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "qrcode";
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public String getServerConfigValue(ServerConfigManager.ConfigType configType, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) configType, (Object) str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) peekAppRuntime).getServerConfigValue(configType, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public String getTabIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "tab_index";
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public ISubAccountApi.g getUnreadCount(String str) {
        ISubAccountControlService.a unreadCount;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ISubAccountApi.g) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && (unreadCount = ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getUnreadCount((QQAppInterface) peekAppRuntime, str)) != null) {
            return new a(unreadCount);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void loginSuccessInit(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            BusinessUtils.Z(appRuntime, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void notifyBusinessMessage(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((QQAppInterface) peekAppRuntime).getMsgHandler().l3().l(i3, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void notifyUI(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((QQAppInterface) peekAppRuntime).getMsgHandler().notifyUI(i3, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void refreshConversation() {
        MqqHandler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && (handler = ((QQAppInterface) peekAppRuntime).getHandler(Conversation.class)) != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void setBindUinStatus(AppInterface appInterface, byte b16, ArrayList<BindUin> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, appInterface, Byte.valueOf(b16), arrayList);
            return;
        }
        FriendListHandler friendListHandler = (FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler != null) {
            friendListHandler.setBindUinStatus(b16, arrayList);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void setDisplayThirdQQSwitch(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, appInterface, Boolean.valueOf(z16));
        } else {
            ((CardHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).h5(z16);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public void startAllSubMessageAccountMsg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((QQAppInterface) peekAppRuntime).startAllSubMessageAccountMsg(z16);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public int startGetThirdQQUnreadNum(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, z16)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi
    public boolean startAllSubMessageAccountMsg(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Integer.valueOf(i3))).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) peekAppRuntime).startAllSubMessageAccountMsg(z16, i3);
        }
        return false;
    }
}
