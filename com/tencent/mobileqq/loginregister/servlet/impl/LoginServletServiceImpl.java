package com.tencent.mobileqq.loginregister.servlet.impl;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.login.servlet.d;
import com.tencent.mobileqq.login.z;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.servlet.c;
import com.tencent.mobileqq.loginregister.servlet.f;
import com.tencent.mobileqq.loginregister.servlet.g;
import com.tencent.mobileqq.loginregister.servlet.h;
import com.tencent.mobileqq.loginregister.servlet.i;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginServletServiceImpl implements ILoginServletService {
    static IPatchRedirector $redirector_ = null;
    public static final String PROCESS = "process";
    private AppRuntime app;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ z f242897d;

        a(z zVar) {
            this.f242897d = zVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginServletServiceImpl.this, (Object) zVar);
            }
        }

        @Override // com.tencent.mobileqq.login.servlet.d, com.tencent.mobileqq.login.z
        public void b(int i3, String str, DevlockInfo devlockInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, devlockInfo);
                return;
            }
            z zVar = this.f242897d;
            if (zVar != null) {
                zVar.b(i3, str, devlockInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ z f242899d;

        b(z zVar) {
            this.f242899d = zVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginServletServiceImpl.this, (Object) zVar);
            }
        }

        @Override // com.tencent.mobileqq.login.servlet.d, com.tencent.mobileqq.login.z
        public void a(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            z zVar = this.f242899d;
            if (zVar != null) {
                zVar.a(i3, str, bundle);
            }
        }
    }

    public LoginServletServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int askDevLockSms(String str, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2109);
        newIntent.putExtra("userAccount", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void cancelCode(String str, long j3, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Long.valueOf(j3), bArr, bArr2);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CANCEL_CODE);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("code", bArr);
        newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_PB_DATA, bArr2);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int checkDevLockSms(String str, long j3, String str2, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, this, str, Long.valueOf(j3), str2, bArr, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2110);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("subAppid", j3);
        newIntent.putExtra("smsCode", str2);
        newIntent.putExtra("sppKey", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int checkDevLockStatus(String str, long j3, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, this, str, Long.valueOf(j3), hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2108);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("subAppid", j3);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int checkPictureAndGetSt(String str, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, str, bArr, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2102);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("userInput", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int checkSMSAndGetSt(String str, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, this, str, bArr, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("userInput", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int checkSMSAndGetStExt(String str, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, this, str, bArr, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("userInput", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int checkSMSVerifyLoginAccount(String str, String str2, int i3, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, this, str, str2, Integer.valueOf(i3), hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("countryCode", str2);
        newIntent.putExtra("appid", i3);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void checkWTSigIfExisted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2402);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int closeCode(String str, long j3, byte[] bArr, int i3, ArrayList<String> arrayList, h hVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, str, Long.valueOf(j3), bArr, Integer.valueOf(i3), arrayList, hVar, bundle)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2105);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("code", bArr);
        newIntent.putStringArrayListExtra("data", arrayList);
        if (bundle != null) {
            newIntent.putExtra("extra", bundle);
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int closeDevLock(String str, long j3, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, str, Long.valueOf(j3), hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2111);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("subAppid", j3);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void deleteAccount(String str, String str2, com.tencent.mobileqq.loginregister.servlet.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, bVar);
            return;
        }
        MsfSdkUtils.delSimpleAccount(str);
        this.app.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.putExtra("action", 1007);
        newIntent.putExtra("uin", str);
        newIntent.putExtra(NotificationActivity.KEY_ALIAS, str2);
        newIntent.setObserver(bVar);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("login_delete_account_sync", false)) {
            newIntent.runNow = true;
        }
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
        List<SimpleAccount> allAccounts = this.app.getApplication().getAllAccounts();
        if (allAccounts != null) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (simpleAccount.getUin().equals(str)) {
                    allAccounts.remove(simpleAccount);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void devLockSmsVerifyLogin(int i3, String str, String str2, Bundle bundle, z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Integer.valueOf(i3), str, str2, bundle, zVar);
        } else {
            com.tencent.mobileqq.login.servlet.b.a(i3, str, str2, bundle, new b(zVar));
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int getA1WithA1(String str, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WFastLoginInfo wFastLoginInfo, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, str, Long.valueOf(j3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wFastLoginInfo, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2106);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("dwSrcAppid", j3);
        newIntent.putExtra("dwSubSrcAppid", j16);
        newIntent.putExtra("dstAppName", bArr);
        newIntent.putExtra("dwDstSsoVer", j17);
        newIntent.putExtra("dwDstAppid", j18);
        newIntent.putExtra("dwSubDstAppid", j19);
        newIntent.putExtra("dstAppVer", bArr2);
        newIntent.putExtra("dstAppSign", bArr3);
        HashMap<String, Parcelable> hashMap = new HashMap<>();
        newIntent.intentMap = hashMap;
        hashMap.put("fastLoginInfo", wFastLoginInfo);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void getDevLockSmsVerifyCode(String str, Bundle bundle, z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, str, bundle, zVar);
        } else {
            com.tencent.mobileqq.login.servlet.b.d(str, bundle, new a(zVar));
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void getKey(com.tencent.mobileqq.loginregister.servlet.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.putExtra("action", 1030);
        newIntent.setObserver(bVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void getStViaGatewayLogin(byte[] bArr, boolean z16, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, bArr, Boolean.valueOf(z16), hVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_LOGIN_START_NOTIFY);
        newIntent.putExtra("appid", AppSetting.f());
        if (bArr != null) {
            newIntent.putExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542, bArr);
        }
        if (z16) {
            newIntent.putExtra("from_where", "subaccount");
            newIntent.putExtra("mainaccount", this.app.getCurrentAccountUin());
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void getStViaPhonePwdLogin(byte[] bArr, boolean z16, boolean z17, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, bArr, Boolean.valueOf(z16), Boolean.valueOf(z17), hVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", JsonGrayBusiId.AIO_GROUP_ESSENCE_MSG_TIP);
        if (z17) {
            newIntent.putExtra("appid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            newIntent.putExtra("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        } else {
            newIntent.putExtra("appid", 16L);
        }
        newIntent.putExtra("subappid", AppSetting.f());
        if (bArr != null) {
            newIntent.putExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542, bArr);
        }
        if (z16) {
            newIntent.putExtra("from_where", "subaccount");
            newIntent.putExtra("mainaccount", this.app.getCurrentAccountUin());
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int getStViaSMSVerifyLogin(String str, String str2, boolean z16, boolean z17, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, this, str, str2, Boolean.valueOf(z16), Boolean.valueOf(z17), bArr, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2121);
        newIntent.putExtra("userAccount", str2);
        newIntent.putExtra("countryCode", str);
        newIntent.putExtra("appid", AppSetting.f());
        if (z17) {
            newIntent.putExtra("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        }
        if (z16) {
            newIntent.putExtra("from_where", "subaccount");
            newIntent.putExtra("mainaccount", this.app.getCurrentAccountUin());
        }
        if (bArr != null) {
            newIntent.putExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542, bArr);
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int getStWithPasswd(String str, long j3, String str2, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, str, Long.valueOf(j3), str2, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2100);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("passwd", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int getStWithoutPasswd(String str, long j3, long j16, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3), Long.valueOf(j16), hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2101);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("dwSrcAppid", j3);
        newIntent.putExtra("dwDstAppid", j16);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void getSubAccountKey(String str, String str2, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, gVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.setObserver(gVar);
        newIntent.putExtra("subaccountuin", str2);
        newIntent.putExtra("mainaccount", str);
        newIntent.putExtra("action", 1037);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int quickLoginByGateway(byte[] bArr, boolean z16, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, this, bArr, Boolean.valueOf(z16), hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_QUICK_LOGIN_BY_GATEWAY);
        newIntent.putExtra(BaseConstants.ATTR_KET_PHONE_TOKEN, bArr);
        if (z16) {
            newIntent.putExtra("from_where", "subaccount");
            newIntent.putExtra("mainaccount", this.app.getCurrentAccountUin());
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void refreshMemorySigInMsf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2305);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int refreshPictureData(String str, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2103);
        newIntent.putExtra("uin", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int refreshSMSData(String str, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, (Object) hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2112);
        newIntent.putExtra("userAccount", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int refreshSMSVerifyLoginCode(String str, String str2, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, this, str, str2, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2119);
        newIntent.putExtra("userAccount", str2);
        newIntent.putExtra("countryCode", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int regGetSMSVerifyLoginAccount(byte[] bArr, byte[] bArr2, String str, String str2, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, this, bArr, bArr2, str, str2, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("msgchk", bArr);
        newIntent.putExtra("nick", bArr2);
        if (str != null && str.length() > 0) {
            newIntent.putExtra("unBindlhUin", str);
        }
        newIntent.putExtra("appVersion", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int regGetSMSVerifyLoginAccountWithLH(byte[] bArr, byte[] bArr2, String str, String str2, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, this, bArr, bArr2, str, str2, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("msgchk", bArr);
        newIntent.putExtra("nick", bArr2);
        newIntent.putExtra("lhuin", str);
        newIntent.putExtra("appVersion", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void setDevLockMobileType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_SET_DEVLOCK_MOBILE_TYPE);
        newIntent.putExtra("mobile_type", i3);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void setRegDevLockFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_SET_REG_DEV_LOCK_FLAG);
        newIntent.putExtra("flag", i3);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void ssoGetA1WithA1(String str, byte[] bArr, long j3, long j16, long j17, byte[] bArr2, byte[] bArr3, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            ssoGetA1WithA1(str, bArr, j3, j16, j17, bArr2, bArr3, fVar, null);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, bArr, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), bArr2, bArr3, fVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void ssoGetTicketNoPasswd(String str, int i3, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            ssoGetTicketNoPasswd(str, i3, fVar, null);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), fVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void transformNTSigToWT(String str, int i3, Bundle bundle, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, str, Integer.valueOf(i3), bundle, hVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", JsonGrayBusiId.GROUP_AIO_UPLOAD_PERMISSIONS_GRAY_TIP_ID);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("appid", i3);
        if (i3 == BaseConstants.OPEN_SDK_BUFLAG_B1) {
            newIntent.putExtra("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
            if (bundle != null) {
                newIntent.putExtra("extra", bundle);
            }
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int verifyCode(String str, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, h hVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, str, Long.valueOf(j3), Boolean.valueOf(z16), bArr, iArr, Integer.valueOf(i3), hVar, bundle)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2104);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("close", z16);
        newIntent.putExtra("code", bArr);
        newIntent.putExtra("tlv", iArr);
        newIntent.putExtra("version", i3);
        newIntent.putExtra("extra", bundle);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void verifyPasswd(String str, String str2, com.tencent.mobileqq.loginregister.servlet.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, bVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.putExtra("action", Constants.Action.ACTION_VERIFY_PASSWD);
        newIntent.putExtra("account", str);
        newIntent.putExtra(NotificationActivity.PASSWORD, str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(bVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void verifyPasswdRefreshImage(String str, com.tencent.mobileqq.loginregister.servlet.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) bVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.putExtra("action", Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE);
        newIntent.putExtra("account", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(bVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void verifyPasswdSubmitImage(String str, String str2, com.tencent.mobileqq.loginregister.servlet.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, bVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.putExtra("action", Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE);
        newIntent.putExtra("account", str);
        newIntent.putExtra("verifyCode", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(bVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int verifySMSVerifyLoginCode(String str, String str2, String str3, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, this, str, str2, str3, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", 2120);
        newIntent.putExtra("userAccount", str2);
        newIntent.putExtra("countryCode", str);
        newIntent.putExtra("code", str3);
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void ssoGetA1WithA1(String str, byte[] bArr, long j3, long j16, long j17, byte[] bArr2, byte[] bArr3, f fVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, bArr, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), bArr2, bArr3, fVar, bundle);
            return;
        }
        this.app.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.setObserver(fVar);
        newIntent.putExtra("ssoAccount", str);
        newIntent.putExtra("dstAppName", bArr);
        newIntent.putExtra("dwDstSsoVer", j3);
        newIntent.putExtra("dwDstAppid", j16);
        newIntent.putExtra("dwSubDstAppid", j17);
        newIntent.putExtra("dstAppVer", bArr2);
        newIntent.putExtra("dstAppSign", bArr3);
        newIntent.putExtra("action", 1102);
        if (bundle != null) {
            newIntent.putExtra("process", this.app.getApplication().getQQProcessName());
            newIntent.putExtra("extra", bundle);
        }
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public void ssoGetTicketNoPasswd(String str, int i3, f fVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), fVar, bundle);
            return;
        }
        this.app.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        NewIntent newIntent = new NewIntent(this.app.getApplication(), c.class);
        newIntent.setObserver(fVar);
        newIntent.putExtra("process", this.app.getApplication().getQQProcessName());
        newIntent.putExtra("ssoAccount", str);
        newIntent.putExtra("action", 1101);
        newIntent.putExtra("targetTicket", i3);
        newIntent.putExtra("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        if (bundle != null) {
            newIntent.putExtra("extra", bundle);
        }
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.ILoginServletService
    public int checkSMSVerifyLoginAccount(String str, String str2, int i3, boolean z16, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), bArr, hVar)).intValue();
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), i.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("countryCode", str2);
        newIntent.putExtra("appid", i3);
        newIntent.putExtra("verifyToken", bArr);
        if (z16) {
            newIntent.putExtra("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(hVar);
        this.app.startServlet(newIntent);
        return 0;
    }
}
