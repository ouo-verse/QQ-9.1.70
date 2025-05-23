package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends QIPCModule implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static h D;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private long f183490d;

    /* renamed from: e, reason: collision with root package name */
    private bc f183491e;

    /* renamed from: f, reason: collision with root package name */
    private b f183492f;

    /* renamed from: h, reason: collision with root package name */
    private b f183493h;

    /* renamed from: i, reason: collision with root package name */
    private b f183494i;

    /* renamed from: m, reason: collision with root package name */
    private b f183495m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements IMiniCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f183496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f183497b;

        a(Bundle bundle, int i3) {
            this.f183496a = bundle;
            this.f183497b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, bundle, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.mini.api.IMiniCallback
        public void onCallbackResult(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            EIPCResult eIPCResult = new EIPCResult();
            if (z16) {
                String replaceFirst = bundle.getString("imageUrl", "").replaceFirst("https*://", "");
                QLog.d("mini_msg_IPCServer", 1, "doMiniShareUploadImage newImagePath: " + replaceFirst);
                this.f183496a.putString("preview", replaceFirst);
            }
            eIPCResult.data = this.f183496a;
            h.this.callbackResult(this.f183497b, eIPCResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f183499a;

        /* renamed from: b, reason: collision with root package name */
        private String f183500b;

        /* renamed from: c, reason: collision with root package name */
        public int f183501c;

        public b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f183499a = str;
                this.f183500b = str2;
            }
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f183500b;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f183499a;
        }
    }

    h() {
        super("MiniMsgIPCServer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = false;
            this.f183491e = ThreadManagerV2.newHandlerRecycleThread("mini_msg", 0).a(this);
        }
    }

    public static void c(int i3) {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            ((MiniMsgHandler) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).E2(Integer.valueOf(i3));
        }
    }

    private void d(Bundle bundle) {
        if (this.f183494i != null) {
            QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_MINI_CREATE_UPDATABLE_MSG_CALLBACK, bundle, null);
        }
    }

    private void e() {
        if (this.f183494i != null) {
            QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_MINI_DIRECT_SHARE_FAIL_CALLBACK, null, null);
        }
    }

    private void f() {
        if (this.f183494i != null) {
            QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_MINI_DIRECT_SHARE_SUC_CALLBACK, null, null);
        }
    }

    private void g(Bundle bundle) {
        if (this.f183494i != null) {
            QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_MINI_REPORT_EVENT, bundle, null);
        }
    }

    private void h() {
        if (this.f183495m != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(MiniConst.UnityClientQIPCModuleConst.KEY_UNITY_CALLBACK_ID, this.f183495m.f183501c);
            QIPCServerHelper.getInstance().callClient(this.f183495m.f183499a, this.f183495m.f183500b, MiniChatConstants.ACTION_MINI_SHARE_FAIL_CALLBACK, bundle, null);
        } else if (this.f183494i != null) {
            QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_MINI_SHARE_FAIL_CALLBACK, null, null);
        }
    }

    private void i() {
        if (this.f183495m != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(MiniConst.UnityClientQIPCModuleConst.KEY_UNITY_CALLBACK_ID, this.f183495m.f183501c);
            QIPCServerHelper.getInstance().callClient(this.f183495m.f183499a, this.f183495m.f183500b, MiniChatConstants.ACTION_MINI_SHARE_SUC_CALLBACK, bundle, null);
        } else if (this.f183494i != null) {
            QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_MINI_SHARE_SUC_CALLBACK, null, null);
        }
    }

    private void j(int i3, Bundle bundle) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).performUploadArkShareImage(bundle.getString("preview"), new a(bundle, i3));
    }

    private void k() {
        QQAppInterface qQAppInterface;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        b bVar = this.f183492f;
        int b16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT, b16);
            if (QLog.isColorLevel()) {
                QLog.d("MiniMsgIPCServer", 2, "doNotifyUnreadState unread = " + b16);
            }
            QIPCServerHelper.getInstance().callClient(bVar.f183499a, bVar.f183500b, MiniChatConstants.ACTION_MSG_TAB_BACK_REFRESH, bundle, null);
        }
    }

    private void l() {
        QQAppInterface qQAppInterface;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        b bVar = this.f183492f;
        int b16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT, b16);
            if (QLog.isColorLevel()) {
                QLog.d("mini_msg_IPCServer", 2, "notifyGetUnread unread = " + b16);
            }
            QIPCServerHelper.getInstance().callClient(bVar.f183499a, bVar.f183500b, MiniChatConstants.ACTION_GET_UNREAD, bundle, null);
        }
    }

    private void m() {
        QQAppInterface qQAppInterface;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        b bVar = this.f183492f;
        if (qQAppInterface != null && bVar != null) {
            Bundle bundle = new Bundle();
            if (QLog.isColorLevel()) {
                QLog.d("mini_msg_IPCServer", 2, "doNotifyGoToConversation  ");
            }
            QIPCServerHelper.getInstance().callClient(bVar.f183499a, bVar.f183500b, MiniChatConstants.ACTION_MINI_MSGTAB_NOTIFY_TO_CONVERSATION, bundle, null);
        }
    }

    private void n(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        final String string = bundle.getString(MiniChatConstants.PARAM_PROC_UIN);
        final int i3 = bundle.getInt(MiniChatConstants.PARAM_PROC_UIN_TYPE);
        final b bVar = this.f183493h;
        if (bVar != null) {
            ((IChatsUtil) QRoute.api(IChatsUtil.class)).findRecentContact(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(string), i3, new Function1() { // from class: com.tencent.mobileqq.activity.miniaio.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit w3;
                    w3 = h.this.w(string, i3, bVar, (RecentContactInfo) obj);
                    return w3;
                }
            });
        }
    }

    private void o() {
        QQAppInterface qQAppInterface;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f183490d;
        if (j3 > currentTimeMillis && j3 - currentTimeMillis < 5000) {
            return;
        }
        this.f183490d = currentTimeMillis;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        b bVar = this.f183492f;
        if (qQAppInterface != null && bVar != null) {
            int b16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
            Bundle bundle = new Bundle();
            bundle.putInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT, b16);
            if (QLog.isColorLevel()) {
                QLog.d("mini_msg_IPCServer", 2, "doNotifyUnreadState unread = " + b16);
            }
            QIPCServerHelper.getInstance().callClient(bVar.f183499a, bVar.f183500b, MiniChatConstants.ACTION_SYNC_UNREADCOUNT, bundle, null);
            if (this.f183494i != null) {
                QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_SYNC_UNREADCOUNT, bundle, null);
            }
        }
    }

    private void p(Bundle bundle) {
        if (this.f183492f != null) {
            String string = bundle.getString(MiniChatConstants.PARAM_PROC_NAME);
            String string2 = bundle.getString(MiniChatConstants.PARAM_PROC_MODULENAME);
            bundle.getString(MiniChatConstants.PARAM_PROC_BUSINAME);
            if (string != null && string.equals(this.f183492f.d()) && string2 != null && string2.equals(this.f183492f.c())) {
                this.C = false;
            }
        }
    }

    private void q(Bundle bundle) {
        String string = bundle.getString(MiniChatConstants.PARAM_PROC_NAME);
        String string2 = bundle.getString(MiniChatConstants.PARAM_PROC_MODULENAME);
        int i3 = bundle.getInt(MiniChatConstants.PARAM_PROC_BUSINAME);
        this.f183492f = new b(string, string2);
        this.f183493h = new b(string, "aio_client_module");
        if (MiniAppClientQIPCModule.MODULE_NAME.equals(string2) | MiniConst.MiniSDKClientQIPCModuleConst.MODULE_NAME.equals(string2)) {
            this.f183494i = new b(string, string2);
        }
        this.f183492f.f183501c = i3;
        this.C = true;
        boolean z16 = bundle.getBoolean(MiniChatConstants.PARAM_PROC_FIRST_STARR, false);
        if (QLog.isColorLevel()) {
            QLog.d("MiniMsgIPCServer", 2, string + "doOnProcForeGround isFirst = " + z16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("moduleName:");
            sb5.append(string2);
            QLog.d("MiniMsgIPCServer", 2, sb5.toString());
        }
        if (z16) {
            B();
        }
    }

    private void r(Bundle bundle) {
        String string = bundle.getString(MiniChatConstants.PARAM_PROC_NAME);
        String string2 = bundle.getString(MiniChatConstants.PARAM_PROC_MODULENAME);
        int i3 = bundle.getInt(MiniChatConstants.PARAM_CMD_BUSIID);
        b bVar = new b(string, string2);
        this.f183495m = bVar;
        bVar.f183501c = i3;
    }

    private void s(int i3, Bundle bundle) {
        QQAppInterface qQAppInterface;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f183490d;
        if (j3 > currentTimeMillis && j3 - currentTimeMillis < 5000) {
            return;
        }
        this.f183490d = currentTimeMillis;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        b bVar = this.f183492f;
        if (qQAppInterface != null && bVar != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int b16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
            bundle.putInt(MiniChatConstants.PARAM_CMD, 0);
            bundle.putInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT, b16);
            EIPCResult eIPCResult = new EIPCResult();
            eIPCResult.data = bundle;
            callbackResult(i3, eIPCResult);
            bundle.putInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT, b16);
            QIPCServerHelper.getInstance().callClient(bVar.f183499a, bVar.f183500b, MiniChatConstants.ACTION_SYNC_UNREADCOUNT, bundle, null);
            if (this.f183494i != null) {
                QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_SYNC_UNREADCOUNT, bundle, null);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniMsgIPCServer", 2, "doNotifyUnreadState unread = " + b16);
            }
        }
    }

    public static h v() {
        if (D == null) {
            synchronized (h.class) {
                if (D == null) {
                    D = new h();
                }
            }
        }
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit w(String str, int i3, b bVar, RecentContactInfo recentContactInfo) {
        int i16;
        if (recentContactInfo != null) {
            i16 = (int) recentContactInfo.getUnreadCnt();
        } else {
            i16 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MiniChatConstants.PARAM_PROC_UIN, str);
        bundle.putInt(MiniChatConstants.PARAM_PROC_UIN_TYPE, i3);
        bundle.putInt(MiniChatConstants.PARAM_PROC_SINGLE_CON_BADGE_COUNT, i16);
        if (QLog.isColorLevel()) {
            QLog.d("mini_msg_IPCServer", 2, "doNotifySingleConUnreadState uin = " + str + "; unread = " + i16);
        }
        QIPCServerHelper.getInstance().callClient(bVar.f183499a, bVar.f183500b, MiniChatConstants.ACTION_SYNC_SINGLE_CON_UNREAD_COUNT, bundle, null);
        if (this.f183494i != null) {
            QIPCServerHelper.getInstance().callClient(this.f183494i.f183499a, this.f183494i.f183500b, MiniChatConstants.ACTION_SYNC_SINGLE_CON_UNREAD_COUNT, bundle, null);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(String str, int i3) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        Bundle bundle = new Bundle();
        bundle.putString(MiniChatConstants.PARAM_PROC_UIN, str);
        bundle.putInt(MiniChatConstants.PARAM_PROC_UIN_TYPE, i3);
        obtain.setData(bundle);
        this.f183491e.h(obtain);
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f183491e.sendEmptyMessage(3);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 1:
                q((Bundle) message.obj);
                return true;
            case 2:
                p((Bundle) message.obj);
                return true;
            case 3:
                if (l.f183505a) {
                    o();
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MiniMsgIPCServer", 2, "isAfterActionB = " + l.f183505a);
                    return true;
                }
                return true;
            case 4:
                if (l.f183505a) {
                    s(message.arg1, (Bundle) message.obj);
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MiniMsgIPCServer", 2, "isAfterActionB = " + l.f183505a);
                    return true;
                }
                return true;
            case 5:
                k();
                return true;
            case 6:
                i();
                return true;
            case 7:
                h();
                return true;
            case 8:
                l();
                return true;
            case 9:
                m();
                return true;
            case 10:
                g((Bundle) message.obj);
                return true;
            case 11:
                n(message.getData());
                return true;
            case 12:
                f();
                return true;
            case 13:
                e();
                return true;
            case 14:
                d((Bundle) message.obj);
                return true;
            case 15:
                j(message.arg1, (Bundle) message.obj);
                return true;
            case 16:
                r((Bundle) message.obj);
                return true;
            case 17:
                t((Bundle) message.obj);
                return true;
            default:
                return true;
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 4, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel() && bundle != null) {
            QLog.d("MiniMsgIPCServer", 2, "MiniMsgIPCServer : " + str + ", " + bundle.toString(), ", " + i3);
        }
        Message obtain = Message.obtain();
        obtain.obj = bundle;
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase(MiniChatConstants.CMD_PROC_FOREGROUND)) {
                obtain.what = 1;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_PROC_BACKGROUND)) {
                obtain.what = 2;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_REFRESH_MINI_BADGE)) {
                obtain.what = 4;
                obtain.arg1 = i3;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MSG_TAB_BACK_REFRESH)) {
                obtain.what = 8;
                obtain.arg1 = i3;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK)) {
                obtain.what = 6;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_SHARE_FAIL_CALLBACK)) {
                obtain.what = 7;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_GET_UNREAD)) {
                obtain.what = 8;
                obtain.arg1 = i3;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_CLEAR_BUSINESS)) {
                if (bundle != null) {
                    c(bundle.getInt(MiniChatConstants.PARAM_CMD_BUSIID));
                }
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_REPORT_EVENT)) {
                obtain.what = 10;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_DIRECT_SHARE_SUC_CALLBACK)) {
                obtain.what = 12;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_DIRECT_SHARE_FAIL_CALLBACK)) {
                obtain.what = 13;
            } else if (str.equals(MiniChatConstants.CMD_MINI_CREATE_UPDATABLE_MSG_CALLBACK)) {
                obtain.what = 14;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_SHARE_UPLOAD_IMAGE)) {
                obtain.what = 15;
                obtain.arg1 = i3;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_SET_UNITY_PROC)) {
                obtain.what = 16;
            } else if (str.equalsIgnoreCase(MiniChatConstants.CMD_MINI_FORWARD_PIC)) {
                obtain.what = 17;
            }
            this.f183491e.h(obtain);
            return null;
        }
        return null;
    }

    public void t(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        if (bundle == null) {
            QLog.e("mini_msg_IPCServer", 1, "forwardPic is error, bundle is null!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("mini_msg_IPCServer", 1, "forwardPic is error, appRuntime is null!");
            return;
        }
        String string = bundle.getString(AppConstants.Key.FORWARD_FILEPATH);
        if (!FileUtils.fileExistsAndNotEmpty(string)) {
            QLog.e("mini_msg_IPCServer", 1, "forwardPic is error, forwardFilePath is null!");
        } else {
            ForwardSendPicUtil.b((QQAppInterface) peekAppRuntime, string, 0, bundle.getString("uin"), bundle.getInt("uintype"), bundle.getString("uin"), false, BaseApplication.getContext(), 0);
        }
    }

    public b u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183492f;
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f183491e.sendEmptyMessage(5);
        }
    }

    public boolean y(Bundle bundle) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle)).booleanValue();
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        b bVar = this.f183492f;
        if (this.C && qQAppInterface != null && bVar != null) {
            QLog.d("mini_msg_IPCServer", 1, "notifyStartMiniAIO call client " + this.f183492f.d());
            QIPCServerHelper.getInstance().callClient(bVar.f183499a, bVar.f183500b, MiniChatConstants.ACTION_MINI_START_MINI_AIO, bundle, null);
            return true;
        }
        return false;
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            m();
        }
    }
}
