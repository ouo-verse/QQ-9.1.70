package com.tencent.mobileqq.utils.abtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.statistics.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tab.exp.sdk.impl.k;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class ABTestController extends QCommonOnlineExpProviderImpl {
    public static final String APPID_1504 = "1504";
    public static final String APPID_1505 = "1505";
    public static final String APPID_5608 = "5608";
    public static final String APPID_571 = "571";
    public static final String APPID_8881 = "8881";
    public static final String APPKEY_1505 = "0c9ebb2ded806d7ffda75cd0b95eb70c";
    public static final String APPKEY_5608 = "487129304eca93e3646dd0c7dd441bf5";
    public static final String APPKEY_571 = "c9892a989183de32e976c6f04e700201";
    public static final String APPKEY_8881 = "76bba5ee241042431796c97a92e64f5d";
    private static final String EVENT_NAME = "tabGetBeforeInit";
    public static final int EXP_MODE_ACCOT = 1;
    public static final String EXP_MODE_CUKEY1505 = "ABTLoginActModule_ExpMode_1505";
    public static final int EXP_MODE_QIMEI = 0;
    public static final String SCENE_5608 = "5604002";
    public static final String SCENE_571 = "20230512";
    private static final ABTestController sABTestController = new ABTestController();
    private static volatile ABHolder tabImplAt1504;
    private static volatile ABHolder tabImplAt1505;
    private static volatile ABHolder tabImplAt5608;
    private static volatile ABHolder tabImplAt571;
    private static volatile ABHolder tabImplAt8881;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ABTestUtil.log("[ACTION_ACCOUNT_CHANGED] tabAccountReceiver callback");
            String loginAccountUin = ABTestController.this.getLoginAccountUin();
            if (ABTestController.tabImplAt1505 != null) {
                ABTestController.tabImplAt1505.checkSwitchWhenAccountReceive(loginAccountUin);
            }
            if (ABTestController.tabImplAt8881 != null) {
                ABTestController.tabImplAt8881.checkSwitchWhenAccountReceive(loginAccountUin);
            }
            if (ABTestController.tabImplAt571 != null) {
                ABTestController.tabImplAt571.checkSwitchWhenAccountReceive(loginAccountUin);
            }
        }
    }

    ABTestController() {
        ABTestUtil.log("register [ACTION_ACCOUNT_CHANGED] tabAccountReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        MobileQQ.sMobileQQ.registerReceiver(new a(), intentFilter);
    }

    @NonNull
    private ExpEntityInfo getExpEntityInner(String str, @NonNull String str2, boolean z16) {
        if (TextUtils.equals(APPID_1505, str) && tabImplAt1505 != null) {
            return tabImplAt1505.getExpEntity(str2, z16);
        }
        if (TextUtils.equals(APPID_8881, str) && tabImplAt8881 != null) {
            return tabImplAt8881.getExpEntity(str2, z16);
        }
        if (TextUtils.equals(APPID_1504, str) && tabImplAt1504 != null) {
            return tabImplAt1504.getExpEntity(str2, z16);
        }
        if (TextUtils.equals(APPID_5608, str) && tabImplAt5608 != null) {
            return tabImplAt5608.getExpEntity(str2, z16);
        }
        if (TextUtils.equals(APPID_571, str) && tabImplAt571 != null) {
            return tabImplAt571.getExpEntity(str2, z16);
        }
        reportGetExpEntityBeforeInit(str2);
        return new ExpEntityInfo(str, str2, "", 0);
    }

    public static ABTestController getInstance() {
        return sABTestController;
    }

    public void clearAllExpData(Context context) {
        com.tencent.qqperf.crashdefend.c.a(context);
        if (initWithAppID(APPID_1505)) {
            getInstance().clearExpData(context, APPID_1505, "");
        }
        if (initWithAppID(APPID_8881)) {
            getInstance().clearExpData(context, APPID_8881, "");
        }
        if (initWithAppID(APPID_5608)) {
            getInstance().clearExpData(context, APPID_5608, "");
        }
        if (initWithAppID(APPID_571)) {
            getInstance().clearExpData(context, APPID_571, "");
        }
        if (initWithAppID(APPID_1504)) {
            getInstance().clearExpData(context, APPID_1504, "");
        }
    }

    public boolean clearExpData(Context context, String str, @NonNull String str2) {
        if (TextUtils.equals(APPID_1505, str) && tabImplAt1505 != null) {
            return tabImplAt1505.clearExpData(str2);
        }
        if (TextUtils.equals(APPID_8881, str) && tabImplAt8881 != null) {
            return tabImplAt8881.clearExpData(str2);
        }
        if (TextUtils.equals(APPID_1504, str) && tabImplAt1504 != null) {
            return tabImplAt1504.clearExpData(str2);
        }
        if (TextUtils.equals(APPID_5608, str) && tabImplAt5608 != null) {
            return tabImplAt5608.clearExpData(str2);
        }
        if (TextUtils.equals(APPID_571, str) && tabImplAt571 != null) {
            return tabImplAt571.clearExpData(str2);
        }
        return false;
    }

    public void doInit1504(String str) {
        if (!TextUtils.isEmpty(str) && tabImplAt1504 == null) {
            synchronized (ABTestController.class) {
                if (tabImplAt1504 == null) {
                    ABTestUtil.log("init1504 expGuid=" + str);
                    tabImplAt1504 = new ABHolder(APPID_1504, APPKEY_1505, "", str, null);
                }
            }
        }
    }

    public void doInit1505(String str, boolean z16) {
        if (z16 && !TextUtils.isEmpty(str) && tabImplAt1505 == null) {
            long nanoTime = System.nanoTime();
            synchronized (ABTestController.class) {
                if (tabImplAt1505 == null) {
                    ABTestUtil.log(String.format("init1505 proc:%s expGuid:%s", Integer.valueOf(MobileQQ.sProcessId), str));
                    tabImplAt1505 = new ABHolder(APPID_1505, APPKEY_1505, "", str, ABTestUtil.getInjectedProfiles());
                }
            }
            ABTestUtil.log(String.format("init1505 cost: %s ms, guid: %s", Long.valueOf(Math.abs(System.nanoTime() - nanoTime) / 1000000), str));
        }
    }

    public void doInit1505SubProc() {
        String str;
        boolean z16;
        if (ABTLoginActModule.getImpl().isProcEnable()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = "";
            }
            boolean z17 = true;
            if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
                z16 = true;
            } else {
                z16 = false;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doInit1505SubProc account=");
            sb5.append(str);
            sb5.append(", runtime=");
            if (peekAppRuntime == null) {
                z17 = false;
            }
            sb5.append(z17);
            ABTestUtil.log(sb5.toString());
            if (TextUtils.isEmpty(str)) {
                ABTestUtil.log("doInit when subproc guid empty. start ipc");
                ABTLoginActModule.getImpl().doInitByIpc();
            } else {
                doInit1505(str, z16);
            }
        }
    }

    public void doInit5608(String str) {
        if (!TextUtils.isEmpty(str) && tabImplAt5608 == null) {
            synchronized (ABTestController.class) {
                if (tabImplAt5608 == null) {
                    ABTestUtil.log("doInit5608 expGuid=" + str);
                    tabImplAt5608 = new ABHolder(APPID_5608, APPKEY_5608, SCENE_5608, str, null);
                }
            }
        }
    }

    public void doInit571(String str, boolean z16) {
        if (!TextUtils.isEmpty(str) && tabImplAt571 == null) {
            synchronized (ABTestController.class) {
                if (tabImplAt571 == null) {
                    ABTestUtil.log("init571 expGuid=" + str + " isLogin=" + z16);
                    tabImplAt571 = new ABHolder(APPID_571, APPKEY_571, SCENE_571, str, null);
                }
            }
        }
    }

    public void doInit8881(String str, boolean z16) {
        if (z16 && !TextUtils.isEmpty(str) && tabImplAt8881 == null) {
            synchronized (ABTestController.class) {
                if (tabImplAt8881 == null) {
                    ABTestUtil.log("init8881 expGuid=" + str);
                    tabImplAt8881 = new ABHolder(APPID_8881, APPKEY_8881, "", str, null);
                }
            }
        }
    }

    @NonNull
    public ExpEntityInfo getExpEntity(String str, @NonNull String str2) {
        return getExpEntityInner(str, str2, false);
    }

    @NonNull
    public ExpEntityInfo getExpEntityByLayerCode(String str, @NonNull String str2) {
        return getExpEntityInner(str, str2, true);
    }

    public String getLoginAccountUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            return peekAppRuntime.getAccount();
        }
        return "";
    }

    public boolean initWithAppID(String str) {
        String str2;
        boolean z16;
        String str3;
        boolean z17;
        if (!getInstance().isTabInited(str)) {
            String str4 = "";
            boolean z18 = false;
            if (TextUtils.equals(APPID_1505, str)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    str3 = "";
                } else {
                    str3 = peekAppRuntime.getAccount();
                }
                if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                getInstance().doInit1505(str3, z17);
            }
            if (TextUtils.equals(APPID_8881, str)) {
                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime2 == null) {
                    str2 = "";
                } else {
                    str2 = peekAppRuntime2.getAccount();
                }
                if (peekAppRuntime2 != null && peekAppRuntime2.isLogin()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                getInstance().doInit8881(str2, z16);
            }
            if (TextUtils.equals(APPID_1504, str)) {
                QLog.e("ABTestController", 1, "clearTABData failed with APPID_1504!");
                return false;
            }
            if (TextUtils.equals(APPID_5608, str)) {
                getInstance().doInit5608(o.c());
            }
            if (TextUtils.equals(APPID_571, str)) {
                AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime3 != null) {
                    str4 = peekAppRuntime3.getAccount();
                }
                if (peekAppRuntime3 != null && peekAppRuntime3.isLogin()) {
                    z18 = true;
                }
                getInstance().doInit571(str4, z18);
            }
        }
        return true;
    }

    public boolean isTabInited(String str) {
        if (TextUtils.equals(APPID_1505, str) && tabImplAt1505 != null) {
            return tabImplAt1505.isTabInited();
        }
        if (TextUtils.equals(APPID_8881, str) && tabImplAt8881 != null) {
            return tabImplAt8881.isTabInited();
        }
        if (TextUtils.equals(APPID_1504, str) && tabImplAt1504 != null) {
            return tabImplAt1504.isTabInited();
        }
        if (TextUtils.equals(APPID_5608, str) && tabImplAt5608 != null) {
            return tabImplAt5608.isTabInited();
        }
        if (TextUtils.equals(APPID_571, str) && tabImplAt571 != null) {
            return tabImplAt571.isTabInited();
        }
        return false;
    }

    @Deprecated
    public boolean isTabSDKInited() {
        return isTabInited(APPID_1505);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportExposure(String str, k kVar) {
        if (TextUtils.equals(APPID_1505, str) && tabImplAt1505 != null) {
            tabImplAt1505.reportExposure(kVar);
        }
        if (TextUtils.equals(APPID_8881, str) && tabImplAt8881 != null) {
            tabImplAt8881.reportExposure(kVar);
        }
        if (TextUtils.equals(APPID_1504, str) && tabImplAt1504 != null) {
            tabImplAt1504.reportExposure(kVar);
        }
        if (TextUtils.equals(APPID_5608, str) && tabImplAt5608 != null) {
            tabImplAt5608.reportExposure(kVar);
        }
        if (TextUtils.equals(APPID_571, str) && tabImplAt571 != null) {
            tabImplAt571.reportExposure(kVar);
        }
    }

    @NonNull
    public ExpEntityInfo getExpEntity(@NonNull String str) {
        return getExpEntity(APPID_1505, str);
    }

    @NonNull
    public ExpEntityInfo getExpEntityByLayerCode(@NonNull String str) {
        return getExpEntityByLayerCode(APPID_1505, str);
    }

    private void reportGetExpEntityBeforeInit(@NonNull String str) {
    }

    @Deprecated
    public void registerExpConfigInfo(String str) {
    }
}
