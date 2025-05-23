package com.tencent.mobileqq.onlinestatus.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BatteryBroadcastReceiver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.business.ah;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.onlinestatus.AccountPanelFragment;
import com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.bw;
import com.tencent.mobileqq.onlinestatus.guide.StatusConversationHelper;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.utils.NewStatusCache;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.utils.aa;
import com.tencent.mobileqq.onlinestatus.view.ak;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.onlinestatus.z;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import tencent.im.onlinestatus.RegisterExt$RegisterExtData;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusServiceImpl implements IOnlineStatusService {
    private static final String PREFERENCE_NAME = "acc_info";
    public static final String TAG = "OnlineStatusServiceImpl";
    private IOnlineStatusService.AIOStatusPopupDialogListener aioStatusPopupDialogListener;
    private AppRuntime mApp;
    private BatteryBroadcastReceiver mBatteryBroadcastReceiver;
    private IOnlineStatusService.OnlineStatusZplanPanelListener onlineStatusZplanPanelListener;
    private AppRuntime.Status onlineStatus = AppRuntime.Status.offline;
    private long uExtOnlineStatus = -1;
    private int batteryCapacity = 0;
    private int powerConnect = -1;
    private DiyStatusEmoInfo mInfo = null;
    private h43.f mStepStatusInfo = null;
    private h43.a mGetStepInfoCallback = null;
    private StatusConversationHelper statusConversationHelper = new StatusConversationHelper();
    private AccountObserver mAccountObserver = new a();
    WeakReference<ak> curDialog = new WeakReference<>(null);

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends AccountObserver {
        a() {
        }

        @Override // mqq.observer.AccountObserver
        protected void onOnlineStatusChanged(boolean z16, AppRuntime.Status status, long j3, boolean z17, boolean z18, long j16, boolean z19) {
            if (!z16) {
                return;
            }
            try {
                OnlineStatusServiceImpl.this.setOnlineStatus(status, "AccountObserver onOnlineStatusChanged");
                OnlineStatusServiceImpl.this.setExtOnlineStatus(j3);
            } catch (Throwable th5) {
                QLog.e(OnlineStatusServiceImpl.TAG, 1, "onOnlineStatusChanged exception: ", th5);
            }
        }
    }

    private SharedPreferences getOnlineStatusSharedPreference(String str) {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), PREFERENCE_NAME + str, "common_mmkv_configurations");
    }

    private void initStepStatusInfo() {
        if (((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            this.mGetStepInfoCallback = new h43.a() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.s
                @Override // h43.a
                public final void a(h43.f fVar) {
                    OnlineStatusServiceImpl.this.lambda$initStepStatusInfo$0(fVar);
                }
            };
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(this.mApp.getCurrentUin(), Boolean.TRUE, this.mGetStepInfoCallback);
        } else {
            this.mStepStatusInfo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStepStatusInfo$0(h43.f fVar) {
        this.mStepStatusInfo = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showAIOStatusPopupDialog$1(ak akVar) {
        IOnlineStatusService.AIOStatusPopupDialogListener aIOStatusPopupDialogListener = this.aioStatusPopupDialogListener;
        if (aIOStatusPopupDialogListener != null) {
            aIOStatusPopupDialogListener.onDismiss();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showAIOStatusPopupDialog$2(ak akVar) {
        IOnlineStatusService.AIOStatusPopupDialogListener aIOStatusPopupDialogListener = this.aioStatusPopupDialogListener;
        if (aIOStatusPopupDialogListener != null) {
            aIOStatusPopupDialogListener.onShow();
            return null;
        }
        return null;
    }

    private void restoreState() {
        String account = this.mApp.getAccount();
        AppRuntime.Status status = AppRuntime.Status.offline;
        AppRuntime.Status onlineStatusFromSP = getOnlineStatusFromSP(account, status.getValue());
        this.onlineStatus = onlineStatusFromSP;
        if (onlineStatusFromSP == null) {
            this.onlineStatus = status;
        }
        QLog.i(TAG, 1, "[restoreState] onlineStatus=" + this.onlineStatus.name());
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void checkAndSetConversationGuide(TextView textView, TextView textView2) {
        this.statusConversationHelper.g(textView, textView2);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void checkBatteryStatus() {
        int batteryCapacity = getBatteryCapacity();
        int powerConnect = getPowerConnect();
        if (batteryCapacity == 0 || powerConnect == -1) {
            int D = af.D();
            int E = af.E();
            setBatteryCapacity(D);
            setPowerConnect(E);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("checkBatteryStatus, curBattery: %s, powerConnect:%s", Integer.valueOf(D), Integer.valueOf(E)));
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public boolean dismissAIOStatusPopupDialog() {
        ak akVar = this.curDialog.get();
        if (akVar != null && akVar.r()) {
            akVar.Z();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public int getBatteryCapacity() {
        return this.batteryCapacity;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public DiyStatusEmoInfo getDiyInfo() {
        DiyStatusEmoInfo diyStatusEmoInfo = this.mInfo;
        if (diyStatusEmoInfo == null) {
            return aa.d();
        }
        return diyStatusEmoInfo;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public long getExtOnlineStatus() {
        return this.uExtOnlineStatus;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public long getExtOnlineStatusFromSP() {
        return getExtOnlineStatusFromSP(this.mApp.getCurrentAccountUin());
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void getOlympicMedalEventReq(boolean z16, boolean z17) {
        if ((this.mApp instanceof AppInterface) && af.C().H() != null) {
            if (this.mApp.getAccount() != null) {
                ((OnlineStatusHandler) ((AppInterface) this.mApp).getBusinessHandler(OnlineStatusHandler.class.getName())).K2(z16, z17);
            } else {
                QLog.d(TAG, 1, String.format("getOlympicMedalEvent not login!", new Object[0]));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "getOlympicMedalEvent");
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public AppRuntime.Status getOnlineStatus() {
        return this.onlineStatus;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public AppRuntime.Status getOnlineStatusFromSP() {
        return getOnlineStatusFromSP(this.mApp.getCurrentAccountUin(), 0);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public int getPowerConnect() {
        return this.powerConnect;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public SharedPreferences getSharedPreference() {
        return getOnlineStatusSharedPreference(this.mApp.getCurrentAccountUin());
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    @Nullable
    public h43.f getStepStatusInfo() {
        return this.mStepStatusInfo;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public boolean isAIODialogNotShowing() {
        ak akVar;
        WeakReference<ak> weakReference = this.curDialog;
        if (weakReference != null && (akVar = weakReference.get()) != null && akVar.r()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public y newAccountPanel(QBaseActivity qBaseActivity) {
        return newAccountPanel(qBaseActivity, 10);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public z newPresenter(QBaseActivity qBaseActivity, bw bwVar) {
        return new OnLineStatusPresenter(qBaseActivity, bwVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void onAIODialogResult(int i3, int i16, Intent intent) {
        ak akVar = this.curDialog.get();
        if (akVar != null && akVar.r()) {
            akVar.doOnActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void onClickConversationGuide(AppRuntime appRuntime, TextView textView, TextView textView2) {
        this.statusConversationHelper.k(appRuntime, textView, textView2);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        ah.f202497a.b();
        restoreState();
        com.tencent.mobileqq.config.business.ak.f202506a.b();
        com.tencent.mobileqq.config.square.a.f202944a.c();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void onZplanPanelCallback(int i3) {
        IOnlineStatusService.OnlineStatusZplanPanelListener onlineStatusZplanPanelListener = this.onlineStatusZplanPanelListener;
        if (onlineStatusZplanPanelListener != null) {
            onlineStatusZplanPanelListener.onZplanPanelCallback(i3);
            this.onlineStatusZplanPanelListener = null;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void registerBatteryBroadcastReceiver() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "registerBatteryBroadcastReceiver start");
        }
        try {
            if (this.mBatteryBroadcastReceiver == null) {
                IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.mApp.getRuntimeService(IOnlineStatusService.class, "");
                if (iOnlineStatusService.getOnlineStatus() == AppRuntime.Status.online && iOnlineStatusService.getExtOnlineStatus() == 1000) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                    intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                    this.mBatteryBroadcastReceiver = new BatteryBroadcastReceiver(this.mApp);
                    BaseApplication.getContext().registerReceiver(this.mBatteryBroadcastReceiver, intentFilter);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "registerBatteryBroadcastReceiver success");
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, "registerBatteryBroadcastReceiver fail");
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void registerObserver() {
        this.mApp.registObserver(this.mAccountObserver);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void requestSetPushToken(AppRuntime appRuntime, String str, String str2) {
        ((OnlineStatusHandler) ((AppInterface) appRuntime).getBusinessHandler(OnlineStatusHandler.class.getName())).f3(str, str2);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void sendOnlineStatus(AppRuntime.Status status, boolean z16, long j3, boolean z17) {
        AppRuntime.Status onlineStatus = getOnlineStatus();
        boolean notifySwitch = ((ISubAccountService) this.mApp.getRuntimeService(ISubAccountService.class, "")).getNotifySwitch();
        this.mApp.sendOnlineStatus(status, onlineStatus, z16, j3, z17, notifySwitch ? 1 : 0, ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getLoginType(this.mApp.getCurrentAccountUin()));
        setOnlineStatus(status, "sendOnlineStatus");
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void sendOnlineStatusWithExt(AppRuntime.Status status, boolean z16, long j3, boolean z17, long j16) {
        AppRuntime.Status onlineStatus = getOnlineStatus();
        boolean notifySwitch = ((ISubAccountService) this.mApp.getRuntimeService(ISubAccountService.class, "")).getNotifySwitch();
        byte loginType = ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getLoginType(this.mApp.getCurrentAccountUin());
        boolean z18 = com.tencent.mobileqq.automator.a.f199911b;
        RegisterExt$RegisterExtData registerExt$RegisterExtData = new RegisterExt$RegisterExtData();
        registerExt$RegisterExtData.set_status_scene.set(0);
        registerExt$RegisterExtData.first_login_after_update.set(z18 ? 1 : 0);
        byte[] byteArray = registerExt$RegisterExtData.toByteArray();
        QLog.d(TAG, 1, "sendOnlineStatusWithExt: " + (z18 ? 1 : 0));
        this.mApp.sendOnlineStatusWithExt(status, onlineStatus, z16, j3, z17, j16, (long) getBatteryCapacity(), (long) getPowerConnect(), notifySwitch ? 1 : 0, loginType, byteArray);
        setOnlineStatus(status, "sendRegisterPush");
        setExtOnlineStatus(j16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setAIOStatusPopupDialogListener(IOnlineStatusService.AIOStatusPopupDialogListener aIOStatusPopupDialogListener) {
        this.aioStatusPopupDialogListener = aIOStatusPopupDialogListener;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setBatteryCapacity(int i3) {
        boolean z16;
        if (this.batteryCapacity != i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.batteryCapacity = i3;
        if (i3 != 0) {
            aa.j(this.mApp.getApplicationContext(), i3, z16);
            if (QLog.isColorLevel() && z16) {
                QLog.d(TAG, 2, "setBatteryCapacity, capacity:", Integer.valueOf(i3));
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setDiyInfo(DiyStatusEmoInfo diyStatusEmoInfo) {
        this.mInfo = diyStatusEmoInfo;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setExtOnlineStatus(long j3) {
        if (j3 == -1) {
            return;
        }
        if (this.uExtOnlineStatus != j3) {
            QLog.d(TAG, 1, "setExtOnlineStatus, status: " + j3);
            NewStatusCache.f256304a.l(this.onlineStatus, j3);
        }
        this.uExtOnlineStatus = j3;
        if (OnlineStatusToggleUtils.A() && this.uExtOnlineStatus == 2017) {
            initStepStatusInfo();
        }
        if (j3 != -1) {
            getOnlineStatusSharedPreference(this.mApp.getAccount()).edit().putLong(AppConstants.Preferences.GET_ONLINE_STATUS_EXT, j3).apply();
        }
        if (j3 == 1030) {
            ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).enterWeatherModule();
        }
        long j16 = this.uExtOnlineStatus;
        if (j16 != j3 && j16 == 1030) {
            ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).exitWeatherModule();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setOnlineStatus(AppRuntime.Status status, String str) {
        if (status == null) {
            QLog.e(TAG, 1, "online status null! Invalid data from: " + str);
            return;
        }
        AppRuntime.Status status2 = this.onlineStatus;
        if (status2 != status) {
            QLog.d(TAG, 1, "setOnlineStatus, status: " + status2 + "->" + status + ", from: " + str);
        }
        this.onlineStatus = status;
        if (status != AppRuntime.Status.offline && status != AppRuntime.Status.receiveofflinemsg) {
            getSharedPreference().edit().putInt(AppConstants.Preferences.GET_PROFILE_STATUS, status.getValue()).apply();
        }
        com.tencent.mobileqq.onlinestatus.manager.l.f255972a.c(status);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setOnlineStatusZplanPanelListener(IOnlineStatusService.OnlineStatusZplanPanelListener onlineStatusZplanPanelListener) {
        this.onlineStatusZplanPanelListener = onlineStatusZplanPanelListener;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setPowerConnect(int i3) {
        this.powerConnect = i3;
        if (i3 != -1) {
            aa.l(this.mApp.getApplicationContext(), i3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setPowerConnect, powerConnect: %s", Integer.valueOf(i3));
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void setStepStatusInfo(@NonNull h43.f fVar) {
        this.mStepStatusInfo = fVar;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void showAIOStatusPopupDialog(com.tencent.mobileqq.onlinestatus.model.d dVar, Activity activity, int i3, boolean z16) {
        if (dVar != null && isAIODialogNotShowing()) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
            if (activity instanceof FragmentActivity) {
                try {
                    this.curDialog = new WeakReference<>(com.tencent.mobileqq.onlinestatus.view.withAvatar.m.a((FragmentActivity) activity, dVar, i3));
                } catch (IllegalStateException e16) {
                    QLog.w(TAG, 1, "[showAIOStatusPopupDialog] exception, stack=" + QLog.getStackTraceString(e16));
                }
            } else {
                QLog.d(TAG, 1, "Failed to get supported fragment manager to show dialog!");
            }
            ak akVar = this.curDialog.get();
            if (akVar != null) {
                akVar.z1(new Function1() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$showAIOStatusPopupDialog$1;
                        lambda$showAIOStatusPopupDialog$1 = OnlineStatusServiceImpl.this.lambda$showAIOStatusPopupDialog$1((ak) obj);
                        return lambda$showAIOStatusPopupDialog$1;
                    }
                });
                akVar.Dg(new Function1() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$showAIOStatusPopupDialog$2;
                        lambda$showAIOStatusPopupDialog$2 = OnlineStatusServiceImpl.this.lambda$showAIOStatusPopupDialog$2((ak) obj);
                        return lambda$showAIOStatusPopupDialog$2;
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void syncBusinessInfo(int i3, Bundle bundle) {
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof AppInterface)) {
            return;
        }
        if (appRuntime.getAccount() != null && this.mApp.isLogin()) {
            ((OnlineStatusHandler) ((AppInterface) this.mApp).getBusinessHandler(OnlineStatusHandler.class.getName())).g3(i3, bundle);
        } else {
            QLog.d(TAG, 1, "syncBusinessInfo not login!");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "syncBusinessInfo, type: " + i3);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void unRegisterBatteryBroadcastReceiver() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unRegisterBatteryBroadcastReceiver start");
        }
        try {
            if (this.mBatteryBroadcastReceiver != null) {
                BaseApplication.getContext().unregisterReceiver(this.mBatteryBroadcastReceiver);
                this.mBatteryBroadcastReceiver = null;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "unRegisterBatteryBroadcastReceiver success");
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, "unRegisterBatteryBroadcastReceiver fail");
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void updateDiyOnlineStatus(AppRuntime.Status status, long j3, DiyStatusEmoInfo diyStatusEmoInfo) {
        updateDiyOnlineStatus(diyStatusEmoInfo, status, j3, false, 0);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void updateOnlineStatus(AppRuntime.Status status, long j3, boolean z16) {
        updateOnlineStatus(status, j3, z16, 0);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void updateOnlineStatusUsingShareInfo(CustomShareInfo customShareInfo) {
        updateOnlineStatusUsingShareInfo(customShareInfo, null, false, 0);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public long getExtOnlineStatusFromSP(String str) {
        return getOnlineStatusSharedPreference(str).getLong(AppConstants.Preferences.GET_ONLINE_STATUS_EXT, -1L);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public AppRuntime.Status getOnlineStatusFromSP(String str) {
        return getOnlineStatusFromSP(str, 0);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public y newAccountPanel(QBaseActivity qBaseActivity, int i3) {
        return new AccountPanelFragment(qBaseActivity, i3);
    }

    public void updateDiyOnlineStatus(DiyStatusEmoInfo diyStatusEmoInfo, AppRuntime.Status status, long j3, boolean z16, int i3) {
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            if (appRuntime.getAccount() != null && this.mApp.isLogin()) {
                long j16 = MobileQQ.sMobileQQ.getSharedPreferences(this.mApp.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
                AppInterface appInterface = (AppInterface) this.mApp;
                ((OnlineStatusHandler) appInterface.getBusinessHandler(OnlineStatusHandler.class.getName())).d3(appInterface, status, j3, j16, z16, i3, diyStatusEmoInfo);
            } else {
                QLog.d(TAG, 1, String.format("updateOnlineStatus not login!", new Object[0]));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, String.format("updateOnlineStatus, status: %s", status.name()), " ext:", Long.valueOf(j3));
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void updateOnlineStatus(AppRuntime.Status status, long j3) {
        updateOnlineStatus(status, j3, false);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void updateOnlineStatusUsingShareInfo(CustomShareInfo customShareInfo, DiyStatusEmoInfo diyStatusEmoInfo, boolean z16, int i3) {
        updateOnlineStatus(customShareInfo.getOriginStatus(), customShareInfo.getExtStatus(), z16, i3, diyStatusEmoInfo, customShareInfo);
    }

    private AppRuntime.Status getOnlineStatusFromSP(String str, int i3) {
        return AppRuntime.Status.build(getOnlineStatusSharedPreference(str).getInt(AppConstants.Preferences.GET_PROFILE_STATUS, i3));
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void updateOnlineStatus(AppRuntime.Status status, long j3, int i3) {
        updateOnlineStatus(status, j3, false, i3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
    public void updateOnlineStatus(AppRuntime.Status status, long j3, boolean z16, int i3) {
        updateOnlineStatus(status, j3, z16, i3, null, null);
    }

    private void updateOnlineStatus(AppRuntime.Status status, long j3, boolean z16, int i3, DiyStatusEmoInfo diyStatusEmoInfo, CustomShareInfo customShareInfo) {
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            if (appRuntime.getAccount() != null && this.mApp.isLogin()) {
                long j16 = MobileQQ.sMobileQQ.getSharedPreferences(this.mApp.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
                AppInterface appInterface = (AppInterface) this.mApp;
                ((OnlineStatusHandler) appInterface.getBusinessHandler(OnlineStatusHandler.class.getName())).e3(appInterface, status, j3, j16, z16, i3, diyStatusEmoInfo, customShareInfo);
            } else {
                QLog.d(TAG, 1, String.format("updateOnlineStatus not login!", new Object[0]));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, String.format("updateOnlineStatus, status: %s", status.name()), " ext:", Long.valueOf(j3));
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
