package mqq.app;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.Constants;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WtloginManagerImpl implements WtloginManager {
    private final AppRuntime app;
    private WtloginHelper localWtloginHelper;

    public WtloginManagerImpl(AppRuntime appRuntime) {
        this.app = appRuntime;
        WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
        WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
        this.localWtloginHelper = new WtloginHelper((Context) appRuntime.getApplication(), true, (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
    }

    @Override // mqq.manager.WtloginManager
    public int askDevLockSms(String str, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2109);
        newIntent.putExtra("userAccount", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public void cancelCode(String str, long j3, byte[] bArr) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CANCEL_CODE);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("code", bArr);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.WtloginManager
    public int checkDevLockSms(String str, long j3, String str2, byte[] bArr, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2110);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("subAppid", j3);
        newIntent.putExtra("smsCode", str2);
        newIntent.putExtra("sppKey", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int checkDevLockStatus(String str, long j3, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2108);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("subAppid", j3);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int checkPictureAndGetSt(String str, byte[] bArr, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2102);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("userInput", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int checkSMSAndGetSt(String str, byte[] bArr, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("userInput", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int checkSMSAndGetStExt(String str, byte[] bArr, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("userInput", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int checkSMSVerifyLoginAccount(String str, String str2, int i3, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("countryCode", str2);
        newIntent.putExtra("appid", i3);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public Boolean clearUserFastLoginData(String str, long j3) {
        this.localWtloginHelper.setHasPassword(Long.parseLong(str), true);
        return this.localWtloginHelper.ClearUserLoginData(str, j3);
    }

    @Override // mqq.manager.WtloginManager
    public int closeCode(String str, long j3, byte[] bArr, int i3, ArrayList<String> arrayList, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2105);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("code", bArr);
        newIntent.putStringArrayListExtra("data", arrayList);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int closeDevLock(String str, long j3, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2111);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("subAppid", j3);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int getA1WithA1(String str, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WFastLoginInfo wFastLoginInfo, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
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
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public List<WloginLoginInfo> getAllLoginInfo() {
        return this.localWtloginHelper.GetAllLoginInfo();
    }

    @Override // mqq.manager.WtloginManager
    public Boolean getBasicUserInfo(String str, WloginSimpleInfo wloginSimpleInfo) {
        return this.localWtloginHelper.GetBasicUserInfo(str, wloginSimpleInfo);
    }

    @Override // mqq.manager.WtloginManager
    public byte[] getGUID() {
        return this.localWtloginHelper.GetGuid();
    }

    @Override // mqq.manager.WtloginManager
    public boolean getHasPwd(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("sp", 2, "getHasPwd uin= " + str);
        }
        try {
            return this.localWtloginHelper.getHasPassword(Long.valueOf(str).longValue());
        } catch (NumberFormatException e16) {
            QLog.d("sp", 1, "getHasPwd e:", e16);
            return false;
        }
    }

    @Override // mqq.manager.WtloginManager
    public WUserSigInfo getLocalSig(String str, long j3) {
        return this.localWtloginHelper.GetLocalSig(str, j3);
    }

    @Override // mqq.manager.WtloginManager
    public Ticket getLocalTicket(String str, long j3, int i3) {
        return this.localWtloginHelper.GetLocalTicket(str, j3, i3);
    }

    @Override // mqq.manager.WtloginManager
    public int getOpenKeyWithoutPasswd(String str, long j3, long j16, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_GET_OPEN_KEY_WITHOUT_PASSWD);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("dwSrcAppid", j3);
        newIntent.putExtra("dwDstAppid", j16);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public byte[] getPkgSigFromApkName(Context context, String str) {
        return util.getPkgSigFromApkName(context, str);
    }

    @Override // mqq.manager.WtloginManager
    public int getStViaSMSVerifyLogin(String str, String str2, int i3, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2121);
        newIntent.putExtra("userAccount", str2);
        newIntent.putExtra("countryCode", str);
        newIntent.putExtra("appid", i3);
        if ("com.tencent.mobileqq:openSdk".equals(this.app.getApplication().getQQProcessName())) {
            newIntent.putExtra("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        }
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int getStWithPasswd(String str, long j3, String str2, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2100);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("passwd", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int getStWithoutPasswd(String str, long j3, long j16, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2101);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("dwSrcAppid", j3);
        newIntent.putExtra("dwDstAppid", j16);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int getSubAccountStViaSMSVerifyLogin(String str, String str2, String str3, int i3, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2122);
        newIntent.putExtra("userAccount", str3);
        newIntent.putExtra("countryCode", str2);
        newIntent.putExtra("appid", i3);
        newIntent.putExtra("mainaccount", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public boolean isNeedLoginWithPasswd(String str, int i3) {
        return this.localWtloginHelper.IsNeedLoginWithPasswd(str, i3).booleanValue();
    }

    @Override // mqq.manager.WtloginManager
    public boolean isUserHaveA1(String str, long j3) {
        return this.localWtloginHelper.IsUserHaveA1(str, j3).booleanValue();
    }

    @Override // mqq.manager.WtloginManager
    public boolean isWtLoginUrl(String str) {
        return this.localWtloginHelper.IsWtLoginUrl(str);
    }

    @Override // mqq.manager.WtloginManager
    public int quickLoginByGateway(byte[] bArr, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_QUICK_LOGIN_BY_GATEWAY);
        newIntent.putExtra(BaseConstants.ATTR_KET_PHONE_TOKEN, bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public void refreLocalHelper(Context context) {
        this.localWtloginHelper = new WtloginHelper(context, true, (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
    }

    @Override // mqq.manager.WtloginManager
    public void refreshMemorySig() {
        this.localWtloginHelper.RefreshMemorySig();
    }

    @Override // mqq.manager.WtloginManager
    public int refreshPictureData(String str, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2103);
        newIntent.putExtra("uin", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int refreshSMSData(String str, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2112);
        newIntent.putExtra("userAccount", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int refreshSMSVerifyLoginCode(String str, String str2, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2119);
        newIntent.putExtra("userAccount", str2);
        newIntent.putExtra("countryCode", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int regGetSMSVerifyLoginAccount(byte[] bArr, byte[] bArr2, String str, String str2, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("msgchk", bArr);
        newIntent.putExtra("nick", bArr2);
        if (str != null && str.length() > 0) {
            newIntent.putExtra("unBindlhUin", str);
        }
        newIntent.putExtra("appVersion", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int regGetSMSVerifyLoginAccountWithLH(byte[] bArr, byte[] bArr2, String str, String str2, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("msgchk", bArr);
        newIntent.putExtra("nick", bArr2);
        newIntent.putExtra("lhuin", str);
        newIntent.putExtra("appVersion", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public void setDevLockMobileType(int i3) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_SET_DEVLOCK_MOBILE_TYPE);
        newIntent.putExtra("mobile_type", i3);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.WtloginManager
    public void setHasPwd(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("sp", 2, "setHasPwd uin= " + str + " hasPwd= " + z16);
        }
        this.localWtloginHelper.setHasPassword(Long.valueOf(str).longValue(), z16);
    }

    @Override // mqq.manager.WtloginManager
    public void setRegDevLockFlag(int i3) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_SET_REG_DEV_LOCK_FLAG);
        newIntent.putExtra("flag", i3);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.WtloginManager
    public int verifyCode(String str, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2104);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("close", z16);
        newIntent.putExtra("code", bArr);
        newIntent.putExtra("tlv", iArr);
        newIntent.putExtra("version", i3);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int verifySMSVerifyLoginCode(String str, String str2, String str3, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", 2120);
        newIntent.putExtra("userAccount", str2);
        newIntent.putExtra("countryCode", str);
        newIntent.putExtra("code", str3);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.WtloginManager
    public int checkSMSVerifyLoginAccount(String str, String str2, int i3, byte[] bArr, WtloginObserver wtloginObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT);
        newIntent.putExtra("userAccount", str);
        newIntent.putExtra("countryCode", str2);
        newIntent.putExtra("appid", i3);
        newIntent.putExtra("verifyToken", bArr);
        newIntent.withouLogin = true;
        newIntent.setObserver(wtloginObserver);
        this.app.startServlet(newIntent);
        return 0;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
