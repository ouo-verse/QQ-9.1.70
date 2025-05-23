package com.tencent.mobileqq.qqlive.runtime;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.api.ILiveRoomApi;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.utils.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppActivity;
import mqq.app.Constants;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveToolAppInterface extends BaseToolAppInterface implements IToolProcEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private MobileQQServiceBase f272155d;

    /* renamed from: e, reason: collision with root package name */
    private ComponentCallbacks f272156e;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements ComponentCallbacks2 {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveToolAppInterface.this);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                QQLiveToolAppInterface.this.m(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements MainTicketCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f272158a;

        b(String str) {
            this.f272158a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveToolAppInterface.this, (Object) str);
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                QLog.i("Open_Live|QQLiveToolAppInterface", 1, "async get login ticket fail");
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mainTicketInfo);
            } else {
                QLog.i("Open_Live|QQLiveToolAppInterface", 1, "async get login ticket success");
                QQLiveToolAppInterface.this.k(this.f272158a, mainTicketInfo.getA2());
            }
        }
    }

    public QQLiveToolAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ, (Object) str);
            return;
        }
        try {
            if (this.f272156e == null) {
                this.f272156e = new a();
                getApplication().getApplicationContext().registerComponentCallbacks(this.f272156e);
            }
        } catch (Throwable th5) {
            AegisLogger.e("Open_Live|QQLiveToolAppInterface", "QQLiveToolAppInterface", "throwable:", th5);
        }
    }

    private boolean h() {
        Long valueOf;
        boolean z16;
        String currentAccountUin = getCurrentAccountUin();
        QQLiveAnchorRecord existAnchorRecord = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getExistAnchorRecord(QQLiveConfigConst.APP_ID, currentAccountUin);
        Long l3 = null;
        if (existAnchorRecord == null) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(existAnchorRecord.roomId);
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "isOpenLive", "old room, uin=" + currentAccountUin + ", roomId=" + String.valueOf(valueOf));
        if (existAnchorRecord != null) {
            return true;
        }
        AnchorRoomInfo lastAnchorRoomInfo = ((ILiveRoomApi) QRoute.api(ILiveRoomApi.class)).getLastAnchorRoomInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, currentAccountUin);
        if (lastAnchorRoomInfo != null) {
            l3 = Long.valueOf(lastAnchorRoomInfo.getRoomId());
        }
        String valueOf2 = String.valueOf(l3);
        if (lastAnchorRoomInfo != null && lastAnchorRoomInfo.v()) {
            z16 = true;
        } else {
            z16 = false;
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "isOpenLive", "new room, uin=" + currentAccountUin + ", roomId=" + valueOf2 + ", isValid=" + z16);
        if (lastAnchorRoomInfo != null) {
            return true;
        }
        return false;
    }

    private boolean i() {
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE).decodeBool("key_qqlive_float_window_is_show", false);
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "isShowFloatWindow", "isShow=" + decodeBool);
        return decodeBool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit j(QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            AegisLogger.e("Open_Live|QQLiveToolAppInterface", "onCreate", "plantCookies");
            ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies();
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, String str2) {
        ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(QQLiveBusinessConfig.QQLIVE_APP_ID, str, str2, new Function1() { // from class: com.tencent.mobileqq.qqlive.runtime.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j3;
                j3 = QQLiveToolAppInterface.j((QQLiveResponse) obj);
                return j3;
            }
        });
    }

    private void l(String str) {
        String str2 = "";
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("process_memInfo_com.tencent.mobileqq:tool", "");
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str2 = c16.n();
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "reportLiveMemory", "memInfo=" + decodeString);
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().eventId(QQLiveReportConstants.Event.E_PRE_EXIT_PROCESS).traceId(str2).ext6(decodeString).ext7(str));
    }

    private void n() {
        try {
            if (this.f272156e != null) {
                getApplication().unregisterComponentCallbacks(this.f272156e);
            }
        } catch (Throwable th5) {
            AegisLogger.e("Open_Live|QQLiveToolAppInterface", "unregisterComponentCallbacks", "throwable:", th5);
        }
    }

    private void release() {
        MobileQQServiceBase mobileQQServiceBase = this.f272155d;
        if (mobileQQServiceBase != null) {
            mobileQQServiceBase.destroy();
        }
        n();
    }

    @Override // mqq.app.AppRuntime
    public void exit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "exit");
        release();
        super.exit(z16);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getAccount();
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MobileQQServiceBase) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f272155d;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "qq_live_tool";
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (h()) {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "highPriorityWhenBackground", "opening live");
            return true;
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "highPriorityWhenBackground", "no live");
        if (i()) {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "highPriorityWhenBackground", "show float window");
            return true;
        }
        return false;
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (h()) {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "isProcessIdle", "opening live");
            return false;
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "isProcessIdle", "no live");
        if (i()) {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "isProcessIdle", "show float window");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void logout(Constants.LogoutReason logoutReason, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, logoutReason, Boolean.valueOf(z16));
            return;
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "logout");
        release();
        super.logout(logoutReason, z16);
    }

    public void m(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        if (i3 > 15) {
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 != null) {
                str = c16.n();
            } else {
                str = "";
            }
            double round = Math.round(f.f273448a.a() * 10000.0d) / 100;
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "onTrimMemory", "level:" + i3 + " usedMemPercentage\uff1a" + round);
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().eventId(QQLiveReportConstants.Event.E_ON_TRIM_MEMORY).traceId(str).ext6(String.valueOf(round)).ext7(String.valueOf(i3)));
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "onBeforeExitProc");
            l("1");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.f272155d = new c(this);
        AegisLogger.e("Open_Live|QQLiveToolAppInterface", "onCreate", "savedInstanceState=" + bundle);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        TicketManager ticketManager = (TicketManager) getManager(2);
        if (ticketManager != null) {
            if (ticketManager.useAsyncTicketInterface()) {
                ticketManager.getA2(bv.b(getCurrentUin(), 0L), 16, new b(account));
                return;
            }
            String a26 = ticketManager.getA2(getCurrentUin());
            QLog.i("Open_Live|QQLiveToolAppInterface", 1, "sync get login ticket");
            k(account, a26);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        release();
        super.onDestroy();
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) intent)).booleanValue();
        }
        if (TextUtils.equals(str, NewIntent.ACTION_ACCOUNT_KICKED)) {
            Iterator<WeakReference<AppActivity>> it = MobileQQ.sMobileQQ.appActivities.iterator();
            while (it.hasNext()) {
                AppActivity appActivity = it.next().get();
                if (appActivity != null && !appActivity.isFinishing()) {
                    AegisLogger.i("Open_Live|QQLiveToolAppInterface", "onReceiveAccountAction", "has activity");
                    return true;
                }
            }
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "onReceiveAccountAction", "no activity");
        return false;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent)).booleanValue();
        }
        if (h()) {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "onReceiveLegalExitProcAction", "opening live");
            return true;
        }
        AegisLogger.i("Open_Live|QQLiveToolAppInterface", "onReceiveLegalExitProcAction", "no live");
        if (i()) {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "onReceiveLegalExitProcAction", "show float window");
            return true;
        }
        return false;
    }

    @Override // mqq.app.AppRuntime
    public void preExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            AegisLogger.i("Open_Live|QQLiveToolAppInterface", "preExit");
            l("2");
        }
    }
}
