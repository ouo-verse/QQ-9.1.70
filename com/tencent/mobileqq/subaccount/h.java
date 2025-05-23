package com.tencent.mobileqq.subaccount;

import QQService.BindUin;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.utils.api.IDBUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.loginregister.servlet.g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f291110d;

        a(AppInterface appInterface) {
            this.f291110d = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.g
        protected void a(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() thread.name=" + Thread.currentThread().getName());
            }
            ISubAccountService iSubAccountService = (ISubAccountService) this.f291110d.getRuntimeService(ISubAccountService.class, "");
            boolean z16 = false;
            if (str3 != null && str3.length() > 0) {
                if (iSubAccountService != null) {
                    iSubAccountService.updateA2(str2, str3, false);
                }
                z16 = true;
            }
            if (!z16) {
                iSubAccountService.clearUnreadNum(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f291111d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f291112e;

        b(AppRuntime appRuntime, QBaseActivity qBaseActivity) {
            this.f291111d = appRuntime;
            this.f291112e = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            f.b(this.f291111d);
            f.d(this.f291111d);
            f.e(this.f291111d);
            Intent intent = new Intent();
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            intent.setFlags(67108864);
            RouteUtils.startActivity(this.f291112e, intent, RouterConstants.UI_ROUTER_SPLASH);
            this.f291112e.finish();
        }
    }

    public static boolean A(AppInterface appInterface) {
        int i3;
        ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
        boolean z16 = false;
        if (iSubAccountService != null) {
            i3 = iSubAccountService.getBindedNumber();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "checkAccountBind, bindedNum=" + i3 + " ret=" + z16);
        }
        return z16;
    }

    public static boolean B(AppInterface appInterface) {
        ArrayList<SubAccountInfo> allSubAccountInfo;
        ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null && (allSubAccountInfo = iSubAccountService.getAllSubAccountInfo()) != null) {
            Iterator<SubAccountInfo> it = allSubAccountInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (next != null && next.isTop) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean C(AppInterface appInterface, boolean z16) {
        ISubAccountControlService iSubAccountControlService;
        if (appInterface == null || !appInterface.isRunning() || TextUtils.isEmpty(appInterface.getCurrentUin()) || (iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")) == null) {
            return false;
        }
        return iSubAccountControlService.isHeadIconLongClickFunc(z16);
    }

    public static boolean D(int i3) {
        if ((i3 <= -1006 && i3 >= -1010) || i3 == -1011) {
            return true;
        }
        if (i3 >= 187 && i3 <= 191) {
            return true;
        }
        return false;
    }

    public static boolean E(AppInterface appInterface, boolean z16) {
        return true;
    }

    public static boolean G(AppInterface appInterface, String str, boolean z16) {
        String str2;
        boolean bindAccountFinish;
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getSubAccountMessage() subUin=" + str + " isFromPush=" + z16);
        }
        if (appInterface != null && appInterface.isRunning()) {
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService != null) {
                str2 = iSubAccountService.getA2(str);
            } else {
                str2 = null;
            }
            String str3 = str2;
            ISubAccountProtocService iSubAccountProtocService = (ISubAccountProtocService) appInterface.getRuntimeService(ISubAccountProtocService.class, "");
            if (iSubAccountProtocService != null && !(bindAccountFinish = iSubAccountProtocService.getBindAccountFinish())) {
                com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
                aVar.f291122b = "";
                aVar.f291123c = appInterface.getAccount();
                aVar.f291124d = str;
                aVar.f291121a = 1009;
                ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).notifyUI(8003, false, aVar);
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getSubAccountMessage() return, get bind subaccount isFinish = " + bindAccountFinish);
                }
                return false;
            }
            if (str != null && str.length() != 0 && str3 != null && str3.length() != 0 && !str3.trim().equals("")) {
                com.tencent.mobileqq.app.message.a processor = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getProcessor(appInterface);
                if (processor != null) {
                    processor.Z0((byte) 3, 0, str, str3, null);
                    return true;
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getSubAccountMessage() return, subUin=" + str + " a2=" + str3);
            }
            com.tencent.mobileqq.subaccount.logic.a aVar2 = new com.tencent.mobileqq.subaccount.logic.a();
            aVar2.f291122b = "";
            aVar2.f291123c = appInterface.getAccount();
            aVar2.f291124d = str;
            aVar2.f291121a = 1010;
            ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).notifyUI(8003, false, aVar2);
            return false;
        }
        return true;
    }

    public static boolean H(AppInterface appInterface, String str) {
        ISubAccountControlService iSubAccountControlService;
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        if (appInterface != null && (iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")) != null) {
            z16 = iSubAccountControlService.handleListWaittingHint(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "needShowHintDialog() subUin=" + str + " bool=" + z16);
        }
        return z16;
    }

    public static void I(AppInterface appInterface, String str) {
        if (!TextUtils.isEmpty(str)) {
            ((ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")).setDateFormate(str);
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService != null) {
                iSubAccountService.updateMsgTimeStr(((ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")).getDateFormate());
            }
        }
    }

    public static void J(final AppInterface appInterface, final byte b16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setBindUinStatus() subUin=" + str + " cmd=" + ((int) b16));
        }
        if (str == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.subaccount.g
            @Override // java.lang.Runnable
            public final void run() {
                h.K(AppInterface.this, b16, arrayList);
            }
        }, 64, null, false);
    }

    public static void K(AppInterface appInterface, byte b16, ArrayList<String> arrayList) {
        long j3;
        long j16;
        String str;
        byte[] hexStr2Bytes;
        Object valueOf;
        String str2 = "null";
        if (arrayList != null && arrayList.size() != 0) {
            if (b16 != 0 && b16 != 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setBindUinStatus() return, cmd=" + ((int) b16));
                    return;
                }
                return;
            }
            ArrayList<BindUin> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    j3 = Long.parseLong(next);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    j3 = 0;
                }
                if (j3 != 0 && j3 > 10000) {
                    if (b16 == 1) {
                        AppRuntime.Status onlineStatusFromSP = ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatusFromSP(next);
                        if (onlineStatusFromSP == null) {
                            onlineStatusFromSP = AppRuntime.Status.online;
                        }
                        j16 = onlineStatusFromSP.getValue();
                    } else {
                        j16 = 21;
                    }
                    ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
                    if (iSubAccountService != null) {
                        str = iSubAccountService.getA2(next);
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        hexStr2Bytes = new byte[0];
                    } else {
                        hexStr2Bytes = HexUtil.hexStr2Bytes(str);
                    }
                    BindUin bindUin = new BindUin();
                    bindUin.lUin = j3;
                    bindUin.iStatus = (int) j16;
                    bindUin.sKey = hexStr2Bytes;
                    arrayList2.add(bindUin);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("setBindUinStatus() add<QQService.BindUin>:lUin=");
                        sb5.append(j3);
                        sb5.append(" cmd=");
                        sb5.append((int) b16);
                        sb5.append(" status=");
                        sb5.append(j16);
                        sb5.append(" sKey=");
                        if (hexStr2Bytes == null) {
                            valueOf = "null";
                        } else {
                            valueOf = Integer.valueOf(hexStr2Bytes.length);
                        }
                        sb5.append(valueOf);
                        QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
                    }
                }
            }
            if (arrayList2.size() > 0) {
                ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).setBindUinStatus(appInterface, b16, arrayList2);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setBindUinStatus() return, ArrayList<QQService.BindUin> list.size=0");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("setBindUinStatus() return, listSubUin:");
            if (arrayList != null) {
                str2 = "size=0";
            }
            sb6.append(str2);
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb6.toString());
        }
    }

    public static void L(AppInterface appInterface, boolean z16) {
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(appInterface.getCurrentUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setDisplayThirdQQChecked checked=" + z16);
            }
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountControlService != null) {
                iSubAccountControlService.putAssociatedQQCache(appInterface.getCurrentUin() + "_display_third_qq_checked", String.valueOf(z16));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01de A[Catch: all -> 0x02bb, TryCatch #2 {all -> 0x02bb, blocks: (B:77:0x012d, B:83:0x0149, B:88:0x0172, B:90:0x017c, B:94:0x0181, B:155:0x01c2, B:160:0x01d1, B:162:0x01de, B:168:0x020a, B:170:0x0218, B:174:0x0228, B:177:0x0235, B:178:0x0246, B:180:0x024a, B:182:0x0260, B:184:0x0269, B:186:0x0277, B:187:0x02ae, B:189:0x029b, B:191:0x02a6, B:192:0x02a9, B:193:0x02ac, B:194:0x0250, B:196:0x0254, B:199:0x0240), top: B:76:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0235 A[Catch: all -> 0x02bb, TRY_ENTER, TryCatch #2 {all -> 0x02bb, blocks: (B:77:0x012d, B:83:0x0149, B:88:0x0172, B:90:0x017c, B:94:0x0181, B:155:0x01c2, B:160:0x01d1, B:162:0x01de, B:168:0x020a, B:170:0x0218, B:174:0x0228, B:177:0x0235, B:178:0x0246, B:180:0x024a, B:182:0x0260, B:184:0x0269, B:186:0x0277, B:187:0x02ae, B:189:0x029b, B:191:0x02a6, B:192:0x02a9, B:193:0x02ac, B:194:0x0250, B:196:0x0254, B:199:0x0240), top: B:76:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0269 A[Catch: all -> 0x02bb, TryCatch #2 {all -> 0x02bb, blocks: (B:77:0x012d, B:83:0x0149, B:88:0x0172, B:90:0x017c, B:94:0x0181, B:155:0x01c2, B:160:0x01d1, B:162:0x01de, B:168:0x020a, B:170:0x0218, B:174:0x0228, B:177:0x0235, B:178:0x0246, B:180:0x024a, B:182:0x0260, B:184:0x0269, B:186:0x0277, B:187:0x02ae, B:189:0x029b, B:191:0x02a6, B:192:0x02a9, B:193:0x02ac, B:194:0x0250, B:196:0x0254, B:199:0x0240), top: B:76:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ac A[Catch: all -> 0x02bb, TryCatch #2 {all -> 0x02bb, blocks: (B:77:0x012d, B:83:0x0149, B:88:0x0172, B:90:0x017c, B:94:0x0181, B:155:0x01c2, B:160:0x01d1, B:162:0x01de, B:168:0x020a, B:170:0x0218, B:174:0x0228, B:177:0x0235, B:178:0x0246, B:180:0x024a, B:182:0x0260, B:184:0x0269, B:186:0x0277, B:187:0x02ae, B:189:0x029b, B:191:0x02a6, B:192:0x02a9, B:193:0x02ac, B:194:0x0250, B:196:0x0254, B:199:0x0240), top: B:76:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void M(AppInterface appInterface, Context context, RecentItemSubAccount recentItemSubAccount, MsgSummary msgSummary) {
        String str;
        ArrayList<SubAccountInfo> arrayList;
        IConversationFacade iConversationFacade;
        String str2;
        int i3;
        SubAccountMessage subAccountMessage;
        SubAccountInfo subAccountInfo;
        SubAccountInfo subAccountInfo2;
        int i16;
        int i17;
        SubAccountMessage subAccountMessage2;
        SubAccountInfo subAccountInfo3;
        String str3;
        CharSequence charSequence;
        ISubAccountService iSubAccountService;
        SubAccountMessage subAccountMessage3;
        SubAccountMessage subAccountMessage4;
        SubAccountMessage subAccountMessage5;
        SubAccountMessage subAccountMessage6;
        SubAccountMessage subAccountMessage7;
        if (appInterface != null && appInterface.isRunning() && recentItemSubAccount != null && context != null) {
            String str4 = "";
            ISubAccountService iSubAccountService2 = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() subMgr == null");
                    return;
                }
                return;
            }
            ArrayList<SubAccountInfo> allSubAccountInfo = iSubAccountService2.getAllSubAccountInfo();
            ArrayList arrayList2 = new ArrayList();
            List<SimpleAccount> allAccounts = appInterface.getApplication().getAllAccounts();
            if (allAccounts != null && allAccounts.size() > 0) {
                arrayList2.addAll(allAccounts);
            }
            recentItemSubAccount.mMsgExtroInfo = "";
            SubAccountMessage subAccountMessage8 = null;
            if (allSubAccountInfo.size() == 0) {
                msgSummary.strContent = context.getString(R.string.f229606ww);
                recentItemSubAccount.showSubUin = null;
                return;
            }
            long j3 = 0;
            for (SubAccountInfo subAccountInfo4 : allSubAccountInfo) {
                if (subAccountInfo4 != null) {
                    long j16 = subAccountInfo4.lasttime;
                    if (j3 < j16) {
                        j3 = j16;
                    }
                }
            }
            o(appInterface);
            IConversationFacade iConversationFacade2 = (IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "");
            int m3 = m(appInterface, iConversationFacade2);
            int n3 = n(appInterface, iConversationFacade2);
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "subUnreadNum=" + m3 + " subTroopUnreadNum=" + n3);
            }
            int i18 = 1;
            try {
                subAccountMessage = null;
                subAccountInfo = null;
                subAccountInfo2 = null;
                i16 = 0;
                i17 = 0;
                for (SubAccountInfo subAccountInfo5 : allSubAccountInfo) {
                    if (subAccountInfo5 != null && !TextUtils.isEmpty(subAccountInfo5.subuin) && iSubAccountService2.getStatus(subAccountInfo5.subuin) == i18) {
                        List<SubAccountMessage> allMessage = iSubAccountService2.getAllMessage(subAccountInfo5.subuin);
                        if (allMessage != null && allMessage.size() > 0) {
                            try {
                                subAccountMessage3 = allMessage.get(0);
                                iSubAccountService = iSubAccountService2;
                                str = str4;
                            } catch (Throwable th5) {
                                th = th5;
                                str = str4;
                                arrayList = allSubAccountInfo;
                                iConversationFacade = iConversationFacade2;
                                i3 = 0;
                                QLog.e("SubAccountControllUtil_SUB_ACCOUNT", 1, th, new Object[i3]);
                                if (m3 > 0) {
                                }
                                recentItemSubAccount.showSubUin = null;
                                recentItemSubAccount.mUnreadNum = 0;
                                recentItemSubAccount.mUnreadFlag = 0;
                                msgSummary.strContent = context.getString(R.string.hr8);
                                return;
                            }
                            try {
                                if (AppConstants.SUBACCOUNT_TROOP_UIN.equals(subAccountMessage3.senderuin)) {
                                    if (allMessage.size() > 1) {
                                        subAccountMessage4 = allMessage.get(1);
                                    } else {
                                        subAccountMessage4 = null;
                                    }
                                } else {
                                    subAccountMessage4 = subAccountMessage3;
                                    subAccountMessage3 = null;
                                }
                                if (subAccountMessage8 != null) {
                                    if (subAccountMessage3 != null) {
                                        arrayList = allSubAccountInfo;
                                        try {
                                            iConversationFacade = iConversationFacade2;
                                            subAccountMessage7 = subAccountMessage8;
                                            try {
                                                if (subAccountMessage8.time < subAccountMessage3.time) {
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                i3 = 0;
                                                QLog.e("SubAccountControllUtil_SUB_ACCOUNT", 1, th, new Object[i3]);
                                                if (m3 > 0) {
                                                }
                                                recentItemSubAccount.showSubUin = null;
                                                recentItemSubAccount.mUnreadNum = 0;
                                                recentItemSubAccount.mUnreadFlag = 0;
                                                msgSummary.strContent = context.getString(R.string.hr8);
                                                return;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            iConversationFacade = iConversationFacade2;
                                            i3 = 0;
                                            QLog.e("SubAccountControllUtil_SUB_ACCOUNT", 1, th, new Object[i3]);
                                            if (m3 > 0) {
                                            }
                                            recentItemSubAccount.showSubUin = null;
                                            recentItemSubAccount.mUnreadNum = 0;
                                            recentItemSubAccount.mUnreadFlag = 0;
                                            msgSummary.strContent = context.getString(R.string.hr8);
                                            return;
                                        }
                                    } else {
                                        arrayList = allSubAccountInfo;
                                        iConversationFacade = iConversationFacade2;
                                        subAccountMessage7 = subAccountMessage8;
                                    }
                                    subAccountMessage5 = subAccountMessage7;
                                    if (subAccountMessage == null) {
                                        if (subAccountMessage4 != null) {
                                            subAccountMessage6 = subAccountMessage5;
                                            if (subAccountMessage.time < subAccountMessage4.time) {
                                            }
                                        } else {
                                            subAccountMessage6 = subAccountMessage5;
                                        }
                                        subAccountMessage8 = subAccountMessage6;
                                    } else {
                                        subAccountMessage6 = subAccountMessage5;
                                    }
                                    subAccountMessage = subAccountMessage4;
                                    subAccountInfo = subAccountInfo5;
                                    subAccountMessage8 = subAccountMessage6;
                                } else {
                                    arrayList = allSubAccountInfo;
                                    iConversationFacade = iConversationFacade2;
                                }
                                subAccountInfo2 = subAccountInfo5;
                                subAccountMessage5 = subAccountMessage3;
                                if (subAccountMessage == null) {
                                }
                                subAccountMessage = subAccountMessage4;
                                subAccountInfo = subAccountInfo5;
                                subAccountMessage8 = subAccountMessage6;
                            } catch (Throwable th8) {
                                th = th8;
                                arrayList = allSubAccountInfo;
                                iConversationFacade = iConversationFacade2;
                                i3 = 0;
                                QLog.e("SubAccountControllUtil_SUB_ACCOUNT", 1, th, new Object[i3]);
                                if (m3 > 0) {
                                }
                                recentItemSubAccount.showSubUin = null;
                                recentItemSubAccount.mUnreadNum = 0;
                                recentItemSubAccount.mUnreadFlag = 0;
                                msgSummary.strContent = context.getString(R.string.hr8);
                                return;
                            }
                        } else {
                            iSubAccountService = iSubAccountService2;
                            str = str4;
                            arrayList = allSubAccountInfo;
                            iConversationFacade = iConversationFacade2;
                            subAccountMessage8 = subAccountMessage8;
                        }
                        ISubAccountControlService.a y16 = y(appInterface, subAccountInfo5.subuin);
                        if (y16.f291057b) {
                            i17 += y16.f291056a;
                        } else {
                            i16 += y16.f291056a;
                        }
                        allSubAccountInfo = arrayList;
                        iSubAccountService2 = iSubAccountService;
                        str4 = str;
                        iConversationFacade2 = iConversationFacade;
                        i18 = 1;
                    }
                    allSubAccountInfo = allSubAccountInfo;
                    iSubAccountService2 = iSubAccountService2;
                    str4 = str4;
                    iConversationFacade2 = iConversationFacade2;
                    subAccountMessage8 = subAccountMessage8;
                    i18 = 1;
                }
                str = str4;
                arrayList = allSubAccountInfo;
                iConversationFacade = iConversationFacade2;
                subAccountMessage2 = subAccountMessage8;
            } catch (Throwable th9) {
                th = th9;
                str = str4;
            }
            if (i16 <= 0) {
                if (i16 == 0 && i17 > 0) {
                    subAccountInfo3 = subAccountInfo2;
                    subAccountMessage = subAccountMessage2;
                } else if (i16 != 0 || i17 != 0) {
                    subAccountInfo3 = null;
                    subAccountMessage = null;
                }
                if (subAccountInfo3 != null && subAccountMessage != null) {
                    msgSummary.strContent = context.getString(R.string.hr8);
                    try {
                        recentItemSubAccount.mUnreadNum = 0;
                        recentItemSubAccount.mUnreadFlag = 0;
                        recentItemSubAccount.showSubUin = null;
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        if (QLog.isColorLevel()) {
                            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() subUin=" + subAccountInfo3.subuin + " mMsgExtroInfo=" + ((Object) recentItemSubAccount.mMsgExtroInfo));
                        }
                        if (i16 <= 0 && (i16 != 0 || i17 != 0)) {
                            if (i17 <= 0 && !((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                                msgSummary.strContent = "\u6709\u65b0\u7684\u7fa4\u6d88\u606f";
                                recentItemSubAccount.showSubUin = subAccountInfo3.subuin;
                                recentItemSubAccount.mUnreadNum = n3;
                                recentItemSubAccount.mUnreadFlag = 2;
                                return;
                            }
                            return;
                        }
                        String str5 = subAccountMessage.frienduin;
                        str3 = subAccountMessage.sendername;
                        if (TextUtils.isEmpty(str3)) {
                            spannableStringBuilder.append((CharSequence) str3);
                            spannableStringBuilder.append((CharSequence) MsgSummary.STR_COLON);
                        } else {
                            if (str5 == null) {
                                str5 = str;
                            }
                            spannableStringBuilder.append((CharSequence) str5);
                            spannableStringBuilder.append((CharSequence) MsgSummary.STR_COLON);
                        }
                        charSequence = subAccountMessage.mEmoRecentMsg;
                        if ((charSequence != null || charSequence.length() == 0) && subAccountMessage.f203118msg != null) {
                            subAccountMessage.mEmoRecentMsg = new QQText(subAccountMessage.f203118msg, 3, 16);
                        }
                        spannableStringBuilder.append(subAccountMessage.mEmoRecentMsg);
                        if (subAccountMessage.isread) {
                            if (v(appInterface, subAccountInfo3.subuin).contains(subAccountMessage.senderuin)) {
                                recentItemSubAccount.mMsgExtroInfo = "[" + context.getString(R.string.f172976g92) + "]";
                                msgSummary.strContent = spannableStringBuilder;
                            } else if (SubAccountMessage.SUB_EXTR_RED_PACKET.equals(subAccountMessage.subExtr)) {
                                recentItemSubAccount.mMsgExtroInfo = spannableStringBuilder;
                            } else {
                                msgSummary.strContent = spannableStringBuilder;
                            }
                        } else {
                            msgSummary.strContent = spannableStringBuilder;
                        }
                        recentItemSubAccount.showSubUin = subAccountInfo3.subuin;
                        recentItemSubAccount.mUnreadNum = m3;
                        recentItemSubAccount.mUnreadFlag = 1;
                        return;
                    } catch (Throwable th10) {
                        th = th10;
                        i3 = 0;
                        QLog.e("SubAccountControllUtil_SUB_ACCOUNT", 1, th, new Object[i3]);
                        if (m3 > 0) {
                        }
                        recentItemSubAccount.showSubUin = null;
                        recentItemSubAccount.mUnreadNum = 0;
                        recentItemSubAccount.mUnreadFlag = 0;
                        msgSummary.strContent = context.getString(R.string.hr8);
                        return;
                    }
                }
                if (m3 > 0 && iConversationFacade != null) {
                    for (SubAccountInfo subAccountInfo6 : arrayList) {
                        if (subAccountInfo6 != null && !TextUtils.isEmpty(subAccountInfo6.subuin)) {
                            IConversationFacade iConversationFacade3 = iConversationFacade;
                            int unreadCount = iConversationFacade3.getUnreadCount(subAccountInfo6.subuin, 7000);
                            if (unreadCount > 0) {
                                str2 = str;
                                IMessageFacade iMessageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, str2);
                                if (iMessageFacade != null) {
                                    iMessageFacade.setReaded(subAccountInfo6.subuin, 7000, true, false);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setRecentItemSubAccountContentAndUnread some error clean unread subuin= " + subAccountInfo6.subuin + "  num=" + unreadCount);
                                    }
                                    iConversationFacade = iConversationFacade3;
                                    str = str2;
                                }
                            } else {
                                str2 = str;
                            }
                            if (QLog.isColorLevel()) {
                            }
                            iConversationFacade = iConversationFacade3;
                            str = str2;
                        }
                    }
                }
                recentItemSubAccount.showSubUin = null;
                recentItemSubAccount.mUnreadNum = 0;
                recentItemSubAccount.mUnreadFlag = 0;
                msgSummary.strContent = context.getString(R.string.hr8);
                return;
            }
            subAccountInfo3 = subAccountInfo;
            if (subAccountInfo3 != null) {
                msgSummary.strContent = context.getString(R.string.hr8);
                recentItemSubAccount.mUnreadNum = 0;
                recentItemSubAccount.mUnreadFlag = 0;
                recentItemSubAccount.showSubUin = null;
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                if (QLog.isColorLevel()) {
                }
                if (i16 <= 0) {
                    if (i17 <= 0) {
                        return;
                    } else {
                        return;
                    }
                }
                String str52 = subAccountMessage.frienduin;
                str3 = subAccountMessage.sendername;
                if (TextUtils.isEmpty(str3)) {
                }
                charSequence = subAccountMessage.mEmoRecentMsg;
                if (charSequence != null) {
                }
                subAccountMessage.mEmoRecentMsg = new QQText(subAccountMessage.f203118msg, 3, 16);
                spannableStringBuilder2.append(subAccountMessage.mEmoRecentMsg);
                if (subAccountMessage.isread) {
                }
                recentItemSubAccount.showSubUin = subAccountInfo3.subuin;
                recentItemSubAccount.mUnreadNum = m3;
                recentItemSubAccount.mUnreadFlag = 1;
                return;
            }
            if (m3 > 0) {
                while (r0.hasNext()) {
                }
            }
            recentItemSubAccount.showSubUin = null;
            recentItemSubAccount.mUnreadNum = 0;
            recentItemSubAccount.mUnreadFlag = 0;
            msgSummary.strContent = context.getString(R.string.hr8);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() params error");
        }
    }

    public static void N(AppInterface appInterface, String str, boolean z16) {
        String str2;
        if (appInterface != null && str != null) {
            String str3 = AppConstants.SUBACCOUNT_ASSISTANT_UIN;
            if (str3.equals(str)) {
                if (z16) {
                    U(appInterface, str3, 7);
                }
            } else {
                ((ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "")).setRecentListTop(str, z16);
                if (z16) {
                    U(appInterface, str, 4);
                } else {
                    U(appInterface, str, 5);
                }
            }
            ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).refreshConversation();
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setSBTopInRecentList() return, ");
            if (appInterface == null) {
                str2 = "app==null";
            } else {
                str2 = "subUin==null";
            }
            sb5.append(str2);
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
        }
    }

    public static void O(AppRuntime appRuntime, QBaseActivity qBaseActivity) {
        String simpleName;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showMaxHintDialog() actCaller=");
            if (qBaseActivity == null) {
                simpleName = "null";
            } else {
                simpleName = qBaseActivity.getClass().getSimpleName();
            }
            sb5.append(simpleName);
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
        }
        if (qBaseActivity == null) {
            return;
        }
        QQCustomDialog message = DialogUtil.createCustomDialog(qBaseActivity, 230).setTitle(qBaseActivity.getString(R.string.f173180ht0)).setMessage(qBaseActivity.getString(R.string.hrz, 2));
        message.setOwnerActivity(qBaseActivity);
        message.setPositiveButton(qBaseActivity.getString(R.string.hsi), new b(appRuntime, qBaseActivity));
        message.setCancelable(false);
        message.show();
    }

    public static boolean P(AppInterface appInterface, boolean z16) {
        if (appInterface != null && appInterface.isRunning()) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "startGetThirdQQUnreadNum()");
            }
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountControlService != null) {
                return iSubAccountControlService.startGetThirdQQUnreadNum(z16);
            }
        }
        return false;
    }

    public static void Q(AppInterface appInterface, String str, int i3) {
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(str) && TextUtils.equals(str, appInterface.getCurrentUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "storeThirdQQUnreadMsgNumInterval mainAccount=" + str + " interval=" + i3);
            }
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountControlService != null) {
                iSubAccountControlService.putAssociatedQQCache(appInterface.getCurrentUin() + "_unread_msg_num_interval", Integer.valueOf(i3));
                iSubAccountControlService.updateThirdQQUnreadDelayTime(i3);
            }
        }
    }

    public static void R(AppInterface appInterface, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "unbindAllRecentitem() defAct=" + i3);
        }
        U(appInterface, AppConstants.SUBACCOUNT_ASSISTANT_UIN, i3);
    }

    public static void S(AppInterface appInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "unbindRecentItem subUin=" + str);
        }
        if (str != null && str.length() >= 4) {
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).setReaded(str, 7000);
            if (((ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "")).getBindedNumber() == 0) {
                U(appInterface, AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7);
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "bindRecentItem() unbind, add default RecentUser");
                }
            }
        }
    }

    public static boolean T(AppInterface appInterface, int i3) {
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(appInterface.getCurrentUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "updateAllThirdQQMsgUnreadLastTime() lastMsgTime=" + i3);
            }
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountControlService != null) {
                return iSubAccountControlService.putAssociatedQQCache(appInterface.getCurrentUin() + "_all_third_last_msg_time", Integer.valueOf(i3));
            }
        }
        return false;
    }

    private static void U(AppInterface appInterface, String str, int i3) {
        String str2;
        long actionTime;
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "updateRecentUser() subUin=" + str + " actionType=" + i3);
        }
        if (str != null && str.length() != 0 && i3 != 0) {
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str)) {
                Iterator<String> it = iSubAccountService.getAllSubUin().iterator();
                actionTime = 0;
                while (it.hasNext()) {
                    long actionTime2 = iSubAccountService.getActionTime(it.next());
                    if (actionTime < actionTime2) {
                        actionTime = actionTime2;
                    }
                }
                if (actionTime <= 0) {
                    actionTime = com.tencent.mobileqq.service.message.e.K0();
                }
                if ((i3 == 1 || i3 == 2 || i3 == 6 || i3 == 7) && i3 == 7) {
                    actionTime = com.tencent.mobileqq.service.message.e.K0();
                }
            } else {
                actionTime = iSubAccountService.getActionTime(str);
                if (actionTime <= 0) {
                    actionTime = com.tencent.mobileqq.service.message.e.K0();
                }
                if (i3 == 1 || i3 == 2 || i3 == 6 || i3 == 7) {
                    long K0 = com.tencent.mobileqq.service.message.e.K0();
                    ArrayList<SubAccountMessage> arrayList = iSubAccountService.getMapSubMsg().get(str);
                    if (i3 == 6 && arrayList != null && arrayList.size() != 0) {
                        K0 = arrayList.get(0).time;
                    }
                    iSubAccountService.setActionTime(str, K0);
                    if (actionTime < K0) {
                        actionTime = K0;
                    }
                }
            }
            SubAccountAssistantUtil.f291050a.i(actionTime);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateRecentUser() return,");
            if (str == null) {
                str2 = "subUin==null";
            } else {
                str2 = "subUin.len=0 action=" + i3;
            }
            sb5.append(str2);
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
        }
    }

    public static void b(AppInterface appInterface, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "bindRecentItem() subUin=" + str + " actionType=" + i3);
        }
        if (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str) && (str == null || str.length() < 5)) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "bindRecentItem() return, subUin==null || subUin.length()<5");
                return;
            }
            return;
        }
        U(appInterface, str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + str);
        }
    }

    public static void c(AppInterface appInterface, ArrayList<String> arrayList, int i3) {
        Object valueOf;
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "bindRecentItem() list=" + String.valueOf(arrayList) + " actionType=" + i3);
        }
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                U(appInterface, next, i3);
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + next);
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bindRecentItem() return, list=");
            if (arrayList == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(arrayList.size());
            }
            sb5.append(valueOf);
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
        }
    }

    public static Pair<Boolean, Boolean> d(AppInterface appInterface, String str) {
        boolean z16;
        boolean z17 = true;
        boolean z18 = false;
        if (appInterface != null && str != null) {
            List<SimpleAccount> allAccounts = appInterface.getApplication().getAllAccounts();
            if (allAccounts != null && allAccounts.size() != 0) {
                int i3 = 0;
                while (true) {
                    if (i3 < allAccounts.size()) {
                        SimpleAccount simpleAccount = allAccounts.get(i3);
                        if (simpleAccount == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount == null");
                            }
                        } else if (simpleAccount.getUin() == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount.getUin() == null");
                            }
                        } else if (simpleAccount.getUin().equalsIgnoreCase(str)) {
                            if (simpleAccount.isLogined()) {
                                z18 = true;
                            }
                        }
                        i3++;
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() hasAccount=" + z17 + " isLogin=" + z18);
                }
                return new Pair<>(Boolean.valueOf(z17), Boolean.valueOf(z18));
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("checkSubAccountLoginStatus() app.getAllAccounts() is null? =>");
                if (allAccounts != null) {
                    z17 = false;
                }
                sb5.append(z17);
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("checkSubAccountLoginStatus() app is null?=>");
            if (appInterface == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb6.append(z16);
            sb6.append(" subUin is null?=>");
            if (str != null) {
                z17 = false;
            }
            sb6.append(z17);
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb6.toString());
        }
        Boolean bool2 = Boolean.FALSE;
        return new Pair<>(bool2, bool2);
    }

    public static void e(AppInterface appInterface, boolean z16, String str) {
        ISubAccountService iSubAccountService;
        if (appInterface != null && appInterface.isRunning() && (iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "")) != null) {
            Iterator<String> it = iSubAccountService.getAllSubUin().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    int unreadAllMsgNum = iSubAccountService.getUnreadAllMsgNum(next);
                    iSubAccountService.setAllMessageReaded(next);
                    if (z16 || unreadAllMsgNum > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=" + next + " needConfirm=" + z16);
                        }
                        com.tencent.mobileqq.app.message.a processor = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getProcessor(appInterface);
                        if (processor != null) {
                            processor.Y0(next, str);
                        }
                    }
                }
            }
        }
    }

    public static boolean f(AppInterface appInterface) {
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(appInterface.getCurrentUin())) {
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountService != null && iSubAccountControlService != null) {
                ArrayList<String> allSubUin = iSubAccountService.getAllSubUin();
                ArrayList<SimpleAccount> arrayList = new ArrayList();
                List<SimpleAccount> allAccounts = appInterface.getApplication().getAllAccounts();
                if (allAccounts != null && allAccounts.size() > 0) {
                    arrayList.addAll(allAccounts);
                }
                String currentUin = appInterface.getCurrentUin();
                for (SimpleAccount simpleAccount : arrayList) {
                    if (simpleAccount != null && !TextUtils.isEmpty(simpleAccount.getUin()) && !simpleAccount.getUin().equals(currentUin) && !allSubUin.contains(simpleAccount.getUin())) {
                        String str = currentUin + "_" + simpleAccount.getUin();
                        String associatedQQCacheString = iSubAccountControlService.getAssociatedQQCacheString(str + "_last_cookie");
                        if (!TextUtils.isEmpty(associatedQQCacheString)) {
                            iSubAccountControlService.putAssociatedQQCache(str + "_cookie", associatedQQCacheString);
                        }
                        iSubAccountControlService.putAssociatedQQCache(str + "_msgNum", 0);
                        iSubAccountControlService.putAssociatedQQCache(str + "_msgFlag", 0);
                        iSubAccountControlService.putAssociatedQQCache(str + "_redBagTime", 0);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static void g(AppInterface appInterface, boolean z16, String str, String str2) {
        ISubAccountService iSubAccountService;
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(str2) && (iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "")) != null) {
            int unreadAllMsgNum = iSubAccountService.getUnreadAllMsgNum(str2);
            iSubAccountService.setAllMessageReaded(str2);
            if (z16 || unreadAllMsgNum > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=" + str2 + " needConfirm=" + z16);
                }
                com.tencent.mobileqq.app.message.a processor = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getProcessor(appInterface);
                if (processor != null) {
                    processor.Y0(str2, str);
                }
            }
        }
    }

    public static void h(AppInterface appInterface) {
        ISubAccountService iSubAccountService;
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(appInterface.getCurrentUin()) && (iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "")) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(iSubAccountService.getAllSubAccountInfo());
            SharedPreferences p16 = p(appInterface);
            if (p16 != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = ((SubAccountInfo) it.next()).subuin + "_" + appInterface.getCurrentUin() + "_spcares_sysTime";
                    p16.edit().putInt(str, 0).commit();
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "cleanReqSubAccountSpecialCareListSysTime key=" + str);
                    }
                }
            }
        }
    }

    public static boolean i(AppInterface appInterface, SimpleAccount simpleAccount) {
        ISubAccountControlService iSubAccountControlService;
        if (appInterface == null || !appInterface.isRunning() || TextUtils.isEmpty(appInterface.getCurrentUin()) || simpleAccount == null || (iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")) == null) {
            return false;
        }
        String str = appInterface.getCurrentUin() + "_" + simpleAccount.getUin();
        String associatedQQCacheString = iSubAccountControlService.getAssociatedQQCacheString(str + "_last_cookie");
        if (!TextUtils.isEmpty(associatedQQCacheString)) {
            iSubAccountControlService.putAssociatedQQCache(str + "_cookie", associatedQQCacheString);
        }
        iSubAccountControlService.putAssociatedQQCache(str + "_msgNum", 0);
        iSubAccountControlService.putAssociatedQQCache(str + "_msgFlag", 0);
        iSubAccountControlService.putAssociatedQQCache(str + "_redBagTime", 0);
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
            return true;
        }
        return true;
    }

    public static void j(AppInterface appInterface, String str) {
        ISubAccountService iSubAccountService;
        ArrayList<String> arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "clearAllData() subUin=" + str);
        }
        if (ISubAccountControlService.UIN_ALL.equals(str)) {
            ISubAccountService iSubAccountService2 = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService2 != null) {
                arrayList = iSubAccountService2.getAllSubUin();
            } else {
                arrayList = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "clearAllData() clear all_sub_uin. list=" + arrayList);
            }
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!ISubAccountControlService.UIN_ALL.equals(next)) {
                        j(appInterface, next);
                    }
                }
                return;
            }
            return;
        }
        if (appInterface != null && (iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "")) != null) {
            iSubAccountService.removeSubAccountInfo(str);
            iSubAccountService.removeAllMessage(str);
            ((IContactUtils) QRoute.api(IContactUtils.class)).getBuddyNickName(appInterface, str, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(AppInterface appInterface, String str, int i3, String str2) {
        BaseApplication app = appInterface.getApp();
        String str3 = null;
        if (!D(i3)) {
            return null;
        }
        switch (i3) {
            case -1011:
            case -1006:
                str3 = app.getString(R.string.f170058eb);
                break;
            case -1010:
                str3 = app.getString(R.string.f170082fd);
                break;
            case -1009:
                str3 = app.getString(R.string.h0f);
                break;
            case -1008:
                str3 = app.getString(R.string.f169981b3);
                break;
            case -1007:
                str3 = app.getString(R.string.f169982b4);
                break;
            default:
                switch (i3) {
                }
        }
        String a16 = com.tencent.mobileqq.imcore.proxy.utils.a.a((BaseQQAppInterface) appInterface, str2, true);
        if (a16 != null && a16.trim().length() > 0 && !a16.equals(str2)) {
            return a16 + str3;
        }
        return str2 + str3;
    }

    public static String l(AppInterface appInterface, String str) {
        Friends friend;
        if (str == null) {
            return null;
        }
        String property = appInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + str);
        if (TextUtils.isEmpty(property) && (friend = ((IFriendDataService) appInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(str, true)) != null) {
            property = friend.name;
        }
        if (!TextUtils.isEmpty(property)) {
            return property;
        }
        return str;
    }

    public static int m(AppInterface appInterface, IConversationFacade iConversationFacade) {
        int i3;
        Object obj;
        int i16 = 0;
        if (appInterface != null && appInterface.isRunning() && iConversationFacade != null) {
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService != null) {
                int i17 = 0;
                for (SubAccountInfo subAccountInfo : iSubAccountService.getAllSubAccountInfo()) {
                    if (subAccountInfo != null && !TextUtils.isEmpty(subAccountInfo.subuin) && iSubAccountService.getStatus(subAccountInfo.subuin) == 1) {
                        i3 = iConversationFacade.getUnreadCount(subAccountInfo.subuin, 7000);
                    } else {
                        i3 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getAllSubAccountMsgUnreadNum() subuin=");
                        if (subAccountInfo == null) {
                            obj = 0;
                        } else {
                            obj = subAccountInfo.subuin;
                        }
                        sb5.append(obj);
                        sb5.append(" num=");
                        sb5.append(i3);
                        QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
                    }
                    i17 += i3;
                }
                i16 = i17;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getAllSubAccountMsgUnreadNum() currentUin=" + appInterface.getCurrentUin() + " allNum=" + i16);
            }
        }
        return i16;
    }

    public static int n(AppInterface appInterface, IConversationFacade iConversationFacade) {
        int i3;
        Object obj;
        int i16 = 0;
        if (appInterface != null && appInterface.isRunning() && iConversationFacade != null) {
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService != null) {
                int i17 = 0;
                for (SubAccountInfo subAccountInfo : iSubAccountService.getAllSubAccountInfo()) {
                    if (subAccountInfo != null && !TextUtils.isEmpty(subAccountInfo.subuin) && iSubAccountService.getStatus(subAccountInfo.subuin) == 1) {
                        i3 = iConversationFacade.getUnreadCountFromExtInt2(subAccountInfo.subuin, 7000);
                    } else {
                        i3 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getAllSubAccountTroopMsgUnreadNum() subuin=");
                        if (subAccountInfo == null) {
                            obj = 0;
                        } else {
                            obj = subAccountInfo.subuin;
                        }
                        sb5.append(obj);
                        sb5.append(" num=");
                        sb5.append(i3);
                        QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
                    }
                    i17 += i3;
                }
                i16 = i17;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getAllSubAccountTroopMsgUnreadNum() currentUin=" + appInterface.getCurrentUin() + " allNum=" + i16);
            }
        }
        return i16;
    }

    public static int o(AppInterface appInterface) {
        int i3 = 0;
        if (appInterface == null || !appInterface.isRunning() || TextUtils.isEmpty(appInterface.getCurrentUin())) {
            return 0;
        }
        ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
        if (iSubAccountControlService != null) {
            i3 = iSubAccountControlService.getAssociatedQQCacheInt(appInterface.getCurrentUin() + "_all_third_last_msg_time");
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getAllThirdQQMsgUnreadLastTime() lastTime=" + i3);
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (i3 > K0) {
            int i16 = (int) K0;
            T(appInterface, i16);
            return i16;
        }
        return i3;
    }

    public static SharedPreferences p(AppInterface appInterface) {
        Context applicationContext = appInterface.getApplicationContext();
        if (applicationContext == null) {
            QLog.e("SubAccountControllUtil_SUB_ACCOUNT", 1, "getAssociatedQQCacheSp context == null");
        }
        return QMMKV.fromSpAdapter(applicationContext, "qq_subaccount_associated_cache", "common_mmkv_configurations");
    }

    public static boolean q(AppInterface appInterface) {
        ISubAccountControlService iSubAccountControlService;
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(appInterface.getCurrentUin()) && (iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")) != null) {
            if (TextUtils.equals(iSubAccountControlService.getAssociatedQQCacheString(appInterface.getCurrentUin() + "_display_third_qq_checked"), String.valueOf(false))) {
                return false;
            }
        }
        return true;
    }

    public static String r(AppInterface appInterface, String str) {
        Friends friend = ((IFriendDataService) appInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(str, true);
        if (friend != null && !TextUtils.isEmpty(friend.name)) {
            return friend.name;
        }
        Card profileCardFromCache = ((IProfileDataService) appInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(str);
        if (profileCardFromCache != null && !TextUtils.isEmpty(profileCardFromCache.strNick)) {
            return profileCardFromCache.strNick;
        }
        return str;
    }

    public static int s(AppInterface appInterface, String str) {
        ISubAccountControlService iSubAccountControlService;
        if (appInterface == null || !appInterface.isRunning() || TextUtils.isEmpty(str) || TextUtils.isEmpty(appInterface.getCurrentUin()) || (iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")) == null) {
            return 0;
        }
        return iSubAccountControlService.getAssociatedQQCacheInt(appInterface.getCurrentUin() + "_" + str + "_msgNum");
    }

    public static int t(AppInterface appInterface, String str, String str2) {
        int i3 = 0;
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(str) && TextUtils.equals(str, appInterface.getCurrentUin())) {
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountControlService != null) {
                i3 = iSubAccountControlService.getAssociatedQQCacheInt(str + "_" + str2 + "_spcares_sysTime");
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getReqSubAccountSpecialCareListSysTime mainUin=" + str + " subUin=" + str2 + " sysTime=" + i3);
            }
        }
        return i3;
    }

    public static String u(AppInterface appInterface, SimpleAccount simpleAccount) {
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(appInterface.getCurrentUin()) && simpleAccount != null) {
            String l3 = l(appInterface, simpleAccount.getUin());
            if (simpleAccount.isLogined() && (TextUtils.isEmpty(l3) || l3.equals(simpleAccount.getUin()))) {
                l3 = r(appInterface, simpleAccount.getUin());
            }
            if (TextUtils.isEmpty(l3)) {
                return simpleAccount.getUin();
            }
            return l3;
        }
        return "";
    }

    public static ArrayList<String> v(AppInterface appInterface, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(appInterface.getCurrentUin()) && !TextUtils.isEmpty(str)) {
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountControlService != null) {
                iSubAccountControlService.getSubAccountSpecialCareList(arrayList, str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getSubAccountSpecialCareList  list=" + arrayList);
            }
        }
        return arrayList;
    }

    public static void w(AppInterface appInterface, boolean z16, String str) {
        if (appInterface != null && appInterface.isRunning()) {
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "");
            if (iSubAccountControlService != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long lastSpecialCareRequestTime = (currentTimeMillis - iSubAccountControlService.getLastSpecialCareRequestTime()) / 1000;
                if (lastSpecialCareRequestTime < iSubAccountControlService.getSpecialCareReqAdviseGap()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getSubAccountSpecialCareListFromService skip adviseGap=" + iSubAccountControlService.getSpecialCareReqAdviseGap() + "  realGap=" + lastSpecialCareRequestTime);
                        return;
                    }
                    return;
                }
                iSubAccountControlService.setLastSpecialCareRequestTime(currentTimeMillis);
            }
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService != null) {
                ArrayList<SubAccountInfo> arrayList = new ArrayList();
                if (z16) {
                    arrayList.addAll(iSubAccountService.getAllSubAccountInfo());
                } else {
                    arrayList.add(iSubAccountService.getSubAccountInfo(str));
                }
                for (SubAccountInfo subAccountInfo : arrayList) {
                    if (subAccountInfo != null && !TextUtils.isEmpty(subAccountInfo.subuin)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "getSubAccountSpecialCareListFromService uin=" + subAccountInfo.subuin);
                        }
                        if (((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getProcessor(appInterface) != null) {
                            ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getProcessor(appInterface).a1(subAccountInfo);
                        }
                    }
                }
            }
        }
    }

    public static byte[] x(AppInterface appInterface, String str) {
        ISubAccountControlService iSubAccountControlService;
        if (appInterface != null && appInterface.isRunning() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(appInterface.getCurrentUin()) && (iSubAccountControlService = (ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")) != null) {
            String associatedQQCacheString = iSubAccountControlService.getAssociatedQQCacheString(appInterface.getCurrentUin() + "_" + str + "_cookie");
            if (!TextUtils.isEmpty(associatedQQCacheString)) {
                return PkgTools.hexToBytes(associatedQQCacheString);
            }
        }
        return null;
    }

    public static ISubAccountControlService.a y(AppInterface appInterface, String str) {
        ISubAccountControlService.a aVar = new ISubAccountControlService.a();
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
            int unreadAllMsgNum = iSubAccountService.getUnreadAllMsgNum(str);
            if (unreadAllMsgNum > 0) {
                aVar.f291056a = unreadAllMsgNum;
                return aVar;
            }
            if (((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                return aVar;
            }
            int unreadAllTroopMsgNum = iSubAccountService.getUnreadAllTroopMsgNum(str);
            if (unreadAllTroopMsgNum > 0) {
                aVar.f291056a = unreadAllTroopMsgNum;
                aVar.f291057b = true;
            }
        }
        return aVar;
    }

    public static void z(AppInterface appInterface) {
        long j3;
        RecentUser recentUser;
        Class<IConversationFacade> cls;
        boolean z16;
        int i3;
        String str;
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() return, app == null");
                return;
            }
            return;
        }
        ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService == null) {
            return;
        }
        long subAccountVersion = ((IDBUtils) QRoute.api(IDBUtils.class)).getSubAccountVersion(appInterface.getApp());
        long a16 = com.tencent.mobileqq.cooperation.a.a(appInterface.getApp());
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData()..start, historyVersion=" + subAccountVersion + " thisApkVersion=" + a16);
        }
        Class<IConversationFacade> cls2 = IConversationFacade.class;
        if (subAccountVersion < a16) {
            if (subAccountVersion == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() need to update (v5.0 or lower) data");
                }
                boolean subAccountOldVersionUpdate = ((IDBUtils) QRoute.api(IDBUtils.class)).subAccountOldVersionUpdate(appInterface.getApp(), appInterface.getAccount());
                SubAccountInfo subAccountInfo = iSubAccountService.getSubAccountInfo(ISubAccountControlService.UIN_DEFAULT);
                if (subAccountInfo != null && (str = subAccountInfo.subuin) != null) {
                    iSubAccountService.updateMsgData2SupportSubUin(str);
                    int unreadAllMsgNum = iSubAccountService.getUnreadAllMsgNum(subAccountInfo.subuin);
                    IConversationFacade iConversationFacade = (IConversationFacade) appInterface.getRuntimeService(cls2, "");
                    int unreadCount = unreadAllMsgNum - iConversationFacade.getUnreadCount(subAccountInfo.subuin, 7000);
                    if (unreadCount != 0) {
                        iConversationFacade.increaseUnread(subAccountInfo.subuin, 7000, unreadCount);
                        ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[]{AppConstants.SUBACCOUNT_ASSISTANT_UIN, subAccountInfo.subuin});
                    }
                    if (subAccountOldVersionUpdate) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData(), setTopInRecentList, isTop=" + subAccountOldVersionUpdate);
                        }
                        N(appInterface, subAccountInfo.subuin, true);
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() (v5.1 or later) update..");
            }
            ((IDBUtils) QRoute.api(IDBUtils.class)).setSubAccountVersion(appInterface.getApp());
        }
        if (!((IDBUtils) QRoute.api(IDBUtils.class)).showSubAccountInRecentList(appInterface.getApp(), appInterface.getAccount())) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() showedBefore:false, isFirstTime to user SubAccount.");
            }
            ((IDBUtils) QRoute.api(IDBUtils.class)).setShowSubAccountInRecentList(appInterface.getApp(), appInterface.getAccount(), true);
            R(appInterface, 7);
        }
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser findRecentUser = recentUserCache.findRecentUser(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
        if (iSubAccountService.getBindedNumber() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() getBindedNumber > 0, go to initAllData");
            }
            ArrayList<SubAccountInfo> allSubAccountInfo = iSubAccountService.getAllSubAccountInfo();
            int size = allSubAccountInfo.size();
            int i16 = 0;
            while (i16 < size) {
                SubAccountInfo subAccountInfo2 = allSubAccountInfo.get(i16);
                if (subAccountInfo2 == null) {
                    j3 = subAccountVersion;
                    recentUser = findRecentUser;
                    cls = cls2;
                } else {
                    if (findRecentUser != null && QLog.isColorLevel()) {
                        QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() delete defaultRU:" + findRecentUser.uin + " type=" + findRecentUser.getType());
                    }
                    if (findRecentUser != null) {
                        if (subAccountVersion == 0) {
                            b(appInterface, subAccountInfo2.subuin, 7);
                            if (QLog.isColorLevel()) {
                                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() add RU:" + subAccountInfo2.subuin);
                            }
                            IConversationFacade iConversationFacade2 = (IConversationFacade) appInterface.getRuntimeService(cls2, "");
                            j3 = subAccountVersion;
                            int unreadCount2 = iConversationFacade2.getUnreadCount(subAccountInfo2.subuin, 7000);
                            int unreadAllMsgNum2 = iSubAccountService.getUnreadAllMsgNum(subAccountInfo2.subuin);
                            int i17 = unreadAllMsgNum2 - unreadCount2;
                            if (QLog.isColorLevel()) {
                                recentUser = findRecentUser;
                                StringBuilder sb5 = new StringBuilder();
                                cls = cls2;
                                sb5.append("initAllData() onGetKeyBack() setReaded subaccount,old:");
                                sb5.append(unreadCount2);
                                sb5.append(" target:");
                                sb5.append(unreadAllMsgNum2);
                                sb5.append(" increase:");
                                sb5.append(i17);
                                i3 = 2;
                                QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, sb5.toString());
                            } else {
                                recentUser = findRecentUser;
                                cls = cls2;
                                i3 = 2;
                            }
                            if (i17 != 0) {
                                iConversationFacade2.increaseUnread(subAccountInfo2.subuin, 7000, i17);
                                IMessageFacade iMessageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
                                String[] strArr = new String[i3];
                                strArr[0] = AppConstants.SUBACCOUNT_ASSISTANT_UIN;
                                strArr[1] = subAccountInfo2.subuin;
                                iMessageFacade.setChangeAndNotify(strArr);
                            }
                        } else {
                            j3 = subAccountVersion;
                            recentUser = findRecentUser;
                            cls = cls2;
                        }
                    } else {
                        j3 = subAccountVersion;
                        recentUser = findRecentUser;
                        cls = cls2;
                    }
                    Pair<Boolean, Boolean> d16 = d(appInterface, subAccountInfo2.subuin);
                    if (d16 != null) {
                        z16 = d16.second.booleanValue();
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        ((ILoginServletService) appInterface.getRuntimeService(ILoginServletService.class, "all")).getSubAccountKey(appInterface.getAccount(), subAccountInfo2.subuin, new a(appInterface));
                    }
                }
                i16++;
                subAccountVersion = j3;
                findRecentUser = recentUser;
                cls2 = cls;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() delete subaccount recentuser, add default subaccount box");
        }
        ArrayList<SubAccountInfo> allSubAccountInfo2 = iSubAccountService.getAllSubAccountInfo();
        int size2 = allSubAccountInfo2.size();
        for (int i18 = 0; i18 < size2; i18++) {
            SubAccountInfo subAccountInfo3 = allSubAccountInfo2.get(i18);
            if (subAccountInfo3 != null && !AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(subAccountInfo3.subuin)) {
                RecentUser findRecentUser2 = recentUserCache.findRecentUser(subAccountInfo3.subuin, 7000);
                if (findRecentUser2 != null) {
                    recentUserCache.delRecentUser(findRecentUser2);
                }
            }
        }
        String str2 = AppConstants.SUBACCOUNT_ASSISTANT_UIN;
        RecentUser findRecentUser3 = recentUserCache.findRecentUser(str2, 7000);
        SharedPreferences p16 = p(appInterface);
        String str3 = appInterface.getAccount() + "_initDataTimes";
        int i19 = p16.getInt(str3, 0);
        if ((findRecentUser3 == null && i19 == 0) || (findRecentUser3 != null && i19 < 3)) {
            U(appInterface, str2, 7);
            p16.edit().putInt(str3, i19 + 1).commit();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountControllUtil_SUB_ACCOUNT", 2, "initAllData() end");
        }
        ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).refreshConversation();
    }
}
