package com.tencent.gamecenter.wadl.api.impl;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.gamecenter.wadl.api.IQQGameMMKVService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.notification.WadlDLFloatWnd;
import com.tencent.gamecenter.wadl.notification.WadlNotificationController;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameIntercept$GetFloatingWindowResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameNoticeServiceImpl extends CopyOnWriteArrayList<GameNoticeInfo> implements Handler.Callback, IQQGameNoticeService, WadlProxyServiceCallBackInterface {
    public static final long CHECK_INTERVAL_TIME = 10000;
    private static final long DELAY_SHOW_INSTALL_WINDOW = 2500;
    private static final long EXP_NOTIFICATION_TIMEOUT = 1800000;
    private static final byte[] LOCK = new byte[0];
    public static final long ONE_DAY = 86400000;
    public static final long SEVEN_DAY = 604800000;
    public static final String TAG = "Wadl_QQGameNoticeServiceImpl";
    public static final long TWO_DAY = 172800000;
    public static final int WHAT_CLICK_BANNER = 2;
    public static final int WHAT_CLOSE_BANNER = 1;
    private com.tencent.gamecenter.wadl.notification.d gameCenterNotification;
    private GameNoticeInfo mCurrentBanner;
    private MqqHandler mHandler;
    private long mLastRefreshTime;
    private WadlDLFloatWnd wadlDLFloatWnd;
    private volatile AtomicBoolean mCheckBannerPosted = new AtomicBoolean(false);
    private volatile AtomicBoolean mInit = new AtomicBoolean(false);
    private com.tencent.gamecenter.wadl.biz.db.b gameNoticeDBHelper = null;
    private kl0.b simpleTaskDBHelper = null;
    private boolean lastIsExperiment = false;
    private long lastUpdateExpTime = 0;
    private Runnable mCheckBanner = new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.1
        @Override // java.lang.Runnable
        public void run() {
            QQGameNoticeServiceImpl.this.checkBanner();
            QQGameNoticeServiceImpl.this.mCheckBannerPosted.set(false);
        }
    };

    private void check(String str) {
        boolean z16;
        QLog.d(TAG, 1, "check from=" + str + ",mCheckBannerPosted=" + this.mCheckBannerPosted);
        if (!this.mCheckBannerPosted.getAndSet(true)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ThreadManagerV2.excute(this.mCheckBanner, 16, null, true);
            } else {
                this.mCheckBanner.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBanner() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        checkCurrentBanner();
        if (serverTimeMillis - this.mLastRefreshTime < 10000) {
            QLog.w(TAG, 1, "checkBanner time limit! notice size=" + size());
            return;
        }
        this.mLastRefreshTime = serverTimeMillis;
        if (!this.mInit.getAndSet(true)) {
            initGameNoticeInfos();
        }
        try {
            Iterator<GameNoticeInfo> it = iterator();
            GameNoticeInfo gameNoticeInfo = null;
            while (it.hasNext()) {
                GameNoticeInfo next = it.next();
                int a16 = next.a();
                if (a16 != 0) {
                    if (a16 == 1 && next.j()) {
                        QLog.i(TAG, 1, "checkBanner update notice by timeout, simpleInfo=" + next.p());
                        getNoticeDBHelper().f(next);
                    } else {
                        QLog.d(TAG, 1, "checkBanner remove invalid notice, simpleInfo=" + next.p());
                        remove(next);
                    }
                } else {
                    QLog.d(TAG, 1, "checkBanner info=" + next);
                    if (next.F == 1) {
                        requestRedPointIfNeed(new File(next.f106727m).lastModified(), serverTimeMillis, next);
                    }
                    if (serverTimeMillis < next.J) {
                        QLog.w(TAG, 1, "checkBanner is not time, info=" + next.p());
                    } else {
                        int i3 = next.F;
                        if (i3 == 1) {
                            if (gameNoticeInfo != null && gameNoticeInfo.F == 1 && next.C >= gameNoticeInfo.C) {
                            }
                            gameNoticeInfo = next;
                        } else if (gameNoticeInfo == null || gameNoticeInfo.F != 1) {
                            if (i3 == 3) {
                                if (checkPauseStatus(next)) {
                                    if (gameNoticeInfo != null && next.C >= gameNoticeInfo.C) {
                                    }
                                    gameNoticeInfo = next;
                                } else {
                                    remove(next);
                                }
                            }
                        }
                    }
                }
            }
            if (gameNoticeInfo == null) {
                QLog.i(TAG, 1, "checkBanner no banner be show");
                return;
            }
            showBanner(gameNoticeInfo);
            if (gameNoticeInfo.j()) {
                QLog.i(TAG, 1, "checkBanner update notice success, simpleInfo=" + gameNoticeInfo.p());
                getNoticeDBHelper().f(gameNoticeInfo);
                return;
            }
            QLog.d(TAG, 1, "checkBanner remove notice");
            remove(gameNoticeInfo);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "checkBanner exception!", th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkCurrentBanner() {
        String str;
        if (this.mCurrentBanner != null) {
            synchronized (LOCK) {
                GameNoticeInfo gameNoticeInfo = this.mCurrentBanner;
                if (gameNoticeInfo == null) {
                    return;
                }
                if (gameNoticeInfo.a() == 0) {
                    GameNoticeInfo gameNoticeInfo2 = this.mCurrentBanner;
                    if (gameNoticeInfo2.F != 3 || checkPauseStatus(gameNoticeInfo2)) {
                        str = null;
                        if (TextUtils.isEmpty(str)) {
                            hideCurrBanner(str);
                            return;
                        }
                        return;
                    }
                }
                str = this.mCurrentBanner.f106722d;
                if (TextUtils.isEmpty(str)) {
                }
            }
        }
    }

    private boolean checkPauseStatus(GameNoticeInfo gameNoticeInfo) {
        com.tencent.gamecenter.wadl.biz.entity.f d16 = getSimpleTaskDBHelper().d(gameNoticeInfo.f106722d);
        if (d16 != null && d16.taskStatus == 5) {
            return true;
        }
        return false;
    }

    private GameNoticeInfo findGameNoticeFromCache(String str) {
        GameNoticeInfo gameNoticeInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<GameNoticeInfo> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GameNoticeInfo next = it.next();
            if (str.equals(next.f106722d)) {
                gameNoticeInfo = next;
                break;
            }
        }
        QLog.d(TAG, 1, "findGameNoticeFromCache appId=" + str + ",noticeInfo=" + gameNoticeInfo);
        return gameNoticeInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.tencent.gamecenter.wadl.biz.db.b getNoticeDBHelper() {
        if (this.gameNoticeDBHelper == null) {
            this.gameNoticeDBHelper = new com.tencent.gamecenter.wadl.biz.db.b();
        }
        return this.gameNoticeDBHelper;
    }

    private synchronized kl0.b getSimpleTaskDBHelper() {
        if (this.simpleTaskDBHelper == null) {
            this.simpleTaskDBHelper = new kl0.b();
        }
        return this.simpleTaskDBHelper;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initFloatWnd() {
        int i3;
        int i16;
        int i17;
        boolean z16;
        QLog.d(TAG, 1, "initFloatWnd");
        boolean z17 = false;
        int i18 = 7;
        try {
            JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.FLOAT_DLG_CONFIG);
            if (configJsonObj != null) {
                QLog.d(TAG, 1, "initFloatWnd json=" + configJsonObj.toString());
                i16 = configJsonObj.optInt("toggle", 1);
                try {
                    i17 = configJsonObj.optInt("installDialog", 1);
                    try {
                        i3 = configJsonObj.optInt("completeDialog", 0);
                        try {
                            i18 = configJsonObj.optInt("frontDay", 7);
                        } catch (Exception e16) {
                            e = e16;
                            QLog.e(TAG, 1, "initFloatWnd exception", e);
                            if (i16 != 1) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        i3 = 0;
                    }
                } catch (Exception e18) {
                    e = e18;
                    i3 = 0;
                    i17 = 1;
                }
            } else {
                QLog.w(TAG, 1, "initFloatWnd json is null");
                i3 = 0;
                i16 = 1;
                i17 = 1;
            }
        } catch (Exception e19) {
            e = e19;
            i3 = 0;
            i16 = 1;
            i17 = 1;
        }
        if (i16 != 1) {
            try {
                if (i3 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i17 == 1) {
                    z17 = true;
                }
                this.wadlDLFloatWnd = new WadlDLFloatWnd(z16, z17, i18);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "initFloatWnd exception", th5);
            }
        }
    }

    private void initGameNoticeInfos() {
        int i3;
        try {
            List<GameNoticeInfo> d16 = getNoticeDBHelper().d();
            if (d16 != null && d16.size() > 0) {
                Iterator<GameNoticeInfo> it = d16.iterator();
                while (it.hasNext()) {
                    GameNoticeInfo next = it.next();
                    int a16 = next.a();
                    if (a16 == -1 || (a16 == 1 && !next.j())) {
                        it.remove();
                        QLog.d(TAG, 1, "initGameNoticeInfos remove invalid notice");
                    }
                }
                if (d16.size() > 0) {
                    addAll(d16);
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initGameNoticeInfos db size=");
            if (d16 != null) {
                i3 = d16.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append(", cache size=");
            sb5.append(size());
            QLog.d(TAG, 1, sb5.toString());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initGameNoticeInfos exception", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGameCenterBar$0(GameNoticeInfo gameNoticeInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = gameNoticeInfo;
        obtainMessage.sendToTarget();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGameCenterBar$1(GameNoticeInfo gameNoticeInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = gameNoticeInfo;
        obtainMessage.sendToTarget();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void onInstallTipsClick(GameNoticeInfo gameNoticeInfo) {
        QLog.i(TAG, 2, "onInstallTipsClick");
        GameCenterUtil.goToInstallWithJump(gameNoticeInfo.f106722d, gameNoticeInfo.f106724f, gameNoticeInfo.f106727m, "biz_src_zf_games", "tips", false);
        reportByClick(gameNoticeInfo);
    }

    private void onPauseTipsClick(GameNoticeInfo gameNoticeInfo) {
        QLog.i(TAG, 2, "onPauseTipsClick");
        WadlProxyServiceUtil.getProxyService().doResumeAction(8, gameNoticeInfo.f106722d);
        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, gameNoticeInfo.I);
        reportByClick(gameNoticeInfo);
    }

    private void reportByClick(GameNoticeInfo gameNoticeInfo) {
        reportToDC87(WadlProxyConsts.OPER_ID_MSG_TIPS_CLICK, "20", gameNoticeInfo.f106722d, gameNoticeInfo.F, gameNoticeInfo.e());
        int i3 = gameNoticeInfo.F;
        if (i3 == 1) {
            WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
            wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(gameNoticeInfo.f106722d).setOperModule("81706").setOperId(WadlProxyConsts.OPER_ID_INSTALL_MSG_TIPS_CLICK).setExt(4, "20").setExt(35, gameNoticeInfo.f106726i).setExt(10, gameNoticeInfo.e());
            wadlReportBuilder.report();
        } else if (i3 == 3) {
            WadlReportBuilder wadlReportBuilder2 = new WadlReportBuilder();
            wadlReportBuilder2.setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(gameNoticeInfo.f106722d).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setExt(1, "81717").setOperId(WadlProxyConsts.OPER_ID_PAUSE_MSG_TIPS_CLICK).setExt(4, "20").setExt(35, gameNoticeInfo.f106726i).setExt(10, gameNoticeInfo.e());
            wadlReportBuilder2.report();
        }
    }

    private void reportByClose(GameNoticeInfo gameNoticeInfo) {
        if (gameNoticeInfo == null) {
            return;
        }
        int i3 = gameNoticeInfo.F;
        if (i3 == 1) {
            WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
            wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(gameNoticeInfo.f106722d).setOperModule("81706").setOperId(WadlProxyConsts.OPER_ID_INSTALL_MSG_TIPS_CLOSE).setExt(4, "20").setExt(35, gameNoticeInfo.f106726i).setExt(10, gameNoticeInfo.e());
            wadlReportBuilder.report();
        } else if (i3 == 3) {
            WadlReportBuilder wadlReportBuilder2 = new WadlReportBuilder();
            wadlReportBuilder2.setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(gameNoticeInfo.f106722d).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setExt(1, "81717").setOperId(WadlProxyConsts.OPER_ID_PAUSE_MSG_TIPS_CLOSE).setExt(4, "20").setExt(35, gameNoticeInfo.f106726i).setExt(10, gameNoticeInfo.e());
            wadlReportBuilder2.report();
        }
    }

    private void reportByShow(GameNoticeInfo gameNoticeInfo) {
        if (gameNoticeInfo == null) {
            return;
        }
        reportToDC87(WadlProxyConsts.OPER_ID_MSG_TIPS_SHOW, "8", gameNoticeInfo.f106722d, gameNoticeInfo.F, gameNoticeInfo.e());
        int i3 = gameNoticeInfo.F;
        if (i3 == 1) {
            WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
            wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(gameNoticeInfo.f106722d).setOperModule("81706").setOperId(WadlProxyConsts.OPER_ID_INSTALL_MSG_TIPS).setExt(4, "8").setExt(35, gameNoticeInfo.f106726i).setExt(10, gameNoticeInfo.e());
            wadlReportBuilder.report();
        } else if (i3 == 3) {
            WadlReportBuilder wadlReportBuilder2 = new WadlReportBuilder();
            wadlReportBuilder2.setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(gameNoticeInfo.f106722d).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId(WadlProxyConsts.OPER_ID_PAUSE_MSG_TIPS).setExt(1, "81717").setExt(4, "8").setExt(35, gameNoticeInfo.f106726i).setExt(10, gameNoticeInfo.e());
            wadlReportBuilder2.report();
        }
    }

    private void reportToDC87(String str, String str2, String str3, int i3, String str4) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setPageId(WadlProxyConsts.PAGE_ID_DOWNLOAD).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setModuleType(WadlProxyConsts.BUSINESS_ID_DOWNLOAD).setBussinessId("1").setOperId(str).setOperType(str2).setGameAppId(str3).setExt(10, str4).setRetId(i3).report();
    }

    private void requestRedPointIfNeed(long j3, long j16, GameNoticeInfo gameNoticeInfo) {
        boolean z16;
        long readFromSpLong = GameCenterSpUtils.readFromSpLong(GameCenterSpUtils.KEY_REQUEST_RED_POINT_TIME + gameNoticeInfo.f106722d);
        if (j16 - readFromSpLong <= 604800000 && readFromSpLong <= j16) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.d(TAG, 1, "requestRedPointIfNeed lastReqRedDotTime=" + readFromSpLong + ",now=" + j16 + ",fileLastModifiedTime=" + j3 + ",bRequestRedDot=" + z16);
        if (z16) {
            long j17 = j16 - j3;
            if (j17 > 86400000 && j17 < 172800000) {
                GameCenterSpUtils.writeToSpLong(GameCenterSpUtils.KEY_REQUEST_RED_POINT_TIME + gameNoticeInfo.f106722d, j16);
                if (!PackageUtil.isAppInstalled(MobileQQ.sMobileQQ, gameNoticeInfo.f106724f)) {
                    ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).requestRedPoint(9);
                }
            }
        }
    }

    private void showBanner(GameNoticeInfo gameNoticeInfo) {
        gameNoticeInfo.G = gameNoticeInfo.K;
        if (gameNoticeInfo.equals(this.mCurrentBanner)) {
            QLog.w(TAG, 1, "showBanner mCurrentBanner not changed, mCurrentBanner=" + this.mCurrentBanner);
            return;
        }
        synchronized (LOCK) {
            this.mCurrentBanner = (GameNoticeInfo) gameNoticeInfo.clone();
        }
        QLog.d(TAG, 1, "showBanner nextNoticeInfo=" + gameNoticeInfo);
        Bundle bundle = new Bundle();
        bundle.putParcelable("noticeInfo", gameNoticeInfo);
        bundle.putString("tips", gameNoticeInfo.H);
        Message message = new Message();
        message.what = 1134071;
        message.obj = bundle;
        BannerManager.l().O(com.tencent.mobileqq.banner.d.I, 2, message);
        reportByShow(gameNoticeInfo);
    }

    private void showInstallDialogGuide(final String str) {
        if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
            QLog.w(TAG, 1, "showInstallDialogGuide has not float permission");
        } else {
            ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).requestFloatingWindow(str, Build.MANUFACTURER, DeviceInfoMonitor.getModel(), new nl0.e() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.3
                @Override // nl0.e
                public void a() {
                    QLog.w(QQGameNoticeServiceImpl.TAG, 1, "showInstallDialogGuide onGetFloatingWindowingFail");
                }

                @Override // nl0.e
                public void b(@NotNull final QQGameIntercept$GetFloatingWindowResponse qQGameIntercept$GetFloatingWindowResponse) {
                    if (qQGameIntercept$GetFloatingWindowResponse != null && qQGameIntercept$GetFloatingWindowResponse.f436036ok.get()) {
                        if (QQGameNoticeServiceImpl.this.wadlDLFloatWnd != null) {
                            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        QQGameNoticeServiceImpl.this.wadlDLFloatWnd.u(str, qQGameIntercept$GetFloatingWindowResponse);
                                    } catch (Throwable th5) {
                                        QLog.e(QQGameNoticeServiceImpl.TAG, 1, "showFloatInstallWindow exception", th5);
                                    }
                                }
                            }, QQGameNoticeServiceImpl.DELAY_SHOW_INSTALL_WINDOW);
                        }
                    } else {
                        QLog.d(QQGameNoticeServiceImpl.TAG, 1, "onGetFloatingWindowingSuccess not match, appId=" + str);
                    }
                }
            });
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void checkBannerFromResume() {
        check("checkBannerFromResume");
        ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).setReadyToPreloadHippy(true);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public ArrayList<WadlResult> getNotificationTask() {
        return WadlNotificationController.b().d();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                hideCurrBanner(null);
                QLog.d(TAG, 1, "handleMessage clickBanner appid=" + message.obj);
                Object obj = message.obj;
                if (obj instanceof GameNoticeInfo) {
                    GameNoticeInfo gameNoticeInfo = (GameNoticeInfo) obj;
                    GameNoticeInfo findGameNoticeFromCache = findGameNoticeFromCache(gameNoticeInfo.f106722d);
                    if (findGameNoticeFromCache != null) {
                        remove(findGameNoticeFromCache);
                    }
                    int i16 = gameNoticeInfo.F;
                    if (i16 == 1) {
                        onInstallTipsClick(gameNoticeInfo);
                        return false;
                    }
                    if (i16 == 3) {
                        onPauseTipsClick(gameNoticeInfo);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        hideCurrBanner(null);
        QLog.d(TAG, 1, "handleMessage closeBanner appid=" + message.obj);
        Object obj2 = message.obj;
        if (obj2 instanceof GameNoticeInfo) {
            GameNoticeInfo gameNoticeInfo2 = (GameNoticeInfo) obj2;
            GameNoticeInfo findGameNoticeFromCache2 = findGameNoticeFromCache(gameNoticeInfo2.f106722d);
            if (findGameNoticeFromCache2 != null) {
                remove(findGameNoticeFromCache2);
            }
            reportByClose(gameNoticeInfo2);
        }
        this.mLastRefreshTime = 0L;
        check("checkBannerFromClose");
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public boolean hasApkDownloadComplete(String str) {
        com.tencent.gamecenter.wadl.biz.entity.f d16 = getSimpleTaskDBHelper().d(str);
        if (d16 != null && d16.taskStatus == 6) {
            return true;
        }
        return false;
    }

    protected void hideCurrBanner(String str) {
        QLog.d(TAG, 1, "hideCurrBanner appId=" + str + ", mCurrentBanner=" + this.mCurrentBanner);
        if (this.mCurrentBanner != null) {
            synchronized (LOCK) {
                if (this.mCurrentBanner == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str) && !str.equals(this.mCurrentBanner.f106722d)) {
                    return;
                }
                Bundle bundle = new Bundle();
                Message message = new Message();
                message.what = 1134072;
                message.obj = bundle;
                BannerManager.l().O(com.tencent.mobileqq.banner.d.I, 0, message);
                this.mCurrentBanner = null;
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public boolean isShowKeepView() {
        boolean z16;
        WadlDLFloatWnd wadlDLFloatWnd = this.wadlDLFloatWnd;
        if (wadlDLFloatWnd != null) {
            z16 = wadlDLFloatWnd.p();
        } else {
            z16 = false;
        }
        QLog.i(TAG, 2, "isShowKeepView isShow=" + z16);
        return z16;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void onBindService() {
        boolean h16 = g.Z().h1();
        QLog.d(TAG, 1, "onBindService...isServiceLaunched=" + h16);
        if (!h16) {
            g.Z().g4(5);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.d(TAG, 1, "onCreate appRuntime=" + appRuntime);
        this.mHandler = new MqqHandler(Looper.getMainLooper(), this);
        this.gameCenterNotification = new com.tencent.gamecenter.wadl.notification.d();
        initFloatWnd();
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(WadlProxyConsts.EXP_QQ_QQGAME_NOTIFICATION);
        if (expEntity != null) {
            this.lastIsExperiment = expEntity.isExperiment();
        }
        QLog.d(TAG, 1, "onCreate isExperiment=" + this.lastIsExperiment);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
        hideCurrBanner(null);
        this.mInit.set(false);
        clear();
        this.gameCenterNotification.v();
        WadlNotificationController.b().g();
        removeFloatWnd();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void onEvent(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onEvent eventId=" + i3);
        }
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return;
        }
        check("event_" + i3);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void onInstallStart(WadlResult wadlResult) {
        WadlDLFloatWnd wadlDLFloatWnd = this.wadlDLFloatWnd;
        if (wadlDLFloatWnd != null) {
            try {
                wadlDLFloatWnd.y(wadlResult);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onInstallStart wadlDLFloatWnd exception", th5);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void onNoticeAdd(GameNoticeInfo gameNoticeInfo) {
        if (gameNoticeInfo != null && !TextUtils.isEmpty(gameNoticeInfo.f106722d)) {
            hideCurrBanner(gameNoticeInfo.f106722d);
            GameNoticeInfo findGameNoticeFromCache = findGameNoticeFromCache(gameNoticeInfo.f106722d);
            QLog.i(TAG, 2, "onNoticeAdd " + gameNoticeInfo.p());
            if (findGameNoticeFromCache != null) {
                GameNoticeInfo.l(findGameNoticeFromCache, gameNoticeInfo);
                QLog.i(TAG, 2, "onNoticeAdd replace cache");
            } else {
                add(gameNoticeInfo);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void onNoticeDelete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hideCurrBanner(str);
        GameNoticeInfo findGameNoticeFromCache = findGameNoticeFromCache(str);
        QLog.i(TAG, 2, "onNoticeDelete appId=" + str + ",info=" + findGameNoticeFromCache);
        if (findGameNoticeFromCache != null) {
            remove(findGameNoticeFromCache);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        QLog.d(TAG, 1, "onQueryCallback");
        WadlDLFloatWnd wadlDLFloatWnd = this.wadlDLFloatWnd;
        if (wadlDLFloatWnd != null) {
            try {
                wadlDLFloatWnd.w(arrayList);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onQueryCallback wadlDLFloatWnd exception", th5);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void onRequestInstall(String str) {
        QLog.i(TAG, 2, "onRequestInstall appId=" + str);
        showInstallDialogGuide(str);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void onUserCleanNotification() {
        WadlNotificationController.b().h();
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        boolean z16 = this.lastIsExperiment;
        if (this.lastUpdateExpTime + 1800000 < serverTimeMillis) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(WadlProxyConsts.EXP_QQ_QQGAME_NOTIFICATION);
            this.lastUpdateExpTime = serverTimeMillis;
            if (expEntity != null) {
                z16 = expEntity.isExperiment();
            } else {
                z16 = false;
            }
        }
        if (z16) {
            try {
                WadlNotificationController.b().i(wadlResult);
                if (!this.lastIsExperiment) {
                    this.lastIsExperiment = true;
                    this.gameCenterNotification.v();
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onWadlTaskStatusChanged ctr exception", th5);
            }
        } else {
            this.gameCenterNotification.w(wadlResult);
            if (this.lastIsExperiment) {
                this.lastIsExperiment = false;
                WadlNotificationController.b().g();
            }
        }
        WadlDLFloatWnd wadlDLFloatWnd = this.wadlDLFloatWnd;
        if (wadlDLFloatWnd != null) {
            try {
                wadlDLFloatWnd.y(wadlResult);
            } catch (Throwable th6) {
                QLog.e(TAG, 1, "onWadlTaskStatusChanged dlw exception", th6);
            }
        }
    }

    public void removeDatabase(final GameNoticeInfo gameNoticeInfo) {
        boolean z16;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    QQGameNoticeServiceImpl.this.getNoticeDBHelper().b(gameNoticeInfo.f106722d);
                }
            }, 16, null, true);
        } else {
            getNoticeDBHelper().b(gameNoticeInfo.f106722d);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void removeFloatWnd() {
        QLog.d(TAG, 1, "removeFloatWnd");
        WadlDLFloatWnd wadlDLFloatWnd = this.wadlDLFloatWnd;
        if (wadlDLFloatWnd != null) {
            try {
                wadlDLFloatWnd.t();
                this.wadlDLFloatWnd = null;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "removeFloatWnd wadlDLFloatWnd exception", th5);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void setFloatWndToggle(int i3) {
        QLog.d(TAG, 1, "setFloatWndToggle toggle=" + i3 + ",wadlDLFloatWnd=" + this.wadlDLFloatWnd);
        ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).setIntOutAccount(WadlProxyConsts.KEY_FLOAT_WND_TOGGLE, i3);
        WadlDLFloatWnd wadlDLFloatWnd = this.wadlDLFloatWnd;
        if (wadlDLFloatWnd != null) {
            try {
                wadlDLFloatWnd.x(i3);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "setFloatWndToggle onToggleChange exception", th5);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void showKeepLiveView(long j3) {
        QLog.i(TAG, 2, "showKeepLiveView wadlDLFloatWnd=" + this.wadlDLFloatWnd);
        WadlDLFloatWnd wadlDLFloatWnd = this.wadlDLFloatWnd;
        if (wadlDLFloatWnd != null) {
            wadlDLFloatWnd.G(j3);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNoticeService
    public void updateGameCenterBar(View view, Message message) {
        com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.l().d(view);
        if (d16 != null && message != null) {
            int i3 = message.what;
            if (i3 == 1134071 || i3 == 1134072) {
                if (i3 == 1134072) {
                    QLog.d(TAG, 1, "updateGameCenterBar hide bar");
                    view.setVisibility(8);
                    return;
                }
                view.setVisibility(0);
                d16.setIcon(MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.c47));
                d16.setMsg("");
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    final GameNoticeInfo gameNoticeInfo = (GameNoticeInfo) bundle.getParcelable("noticeInfo");
                    if (gameNoticeInfo == null) {
                        return;
                    }
                    String string = bundle.getString("tips");
                    QLog.d(TAG, 1, "updateGameCenterBar show bar gameNoticeInfo=" + gameNoticeInfo.p());
                    d16.c(new View.OnClickListener() { // from class: com.tencent.gamecenter.wadl.api.impl.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            QQGameNoticeServiceImpl.this.lambda$updateGameCenterBar$0(gameNoticeInfo, view2);
                        }
                    });
                    d16.k(new View.OnClickListener() { // from class: com.tencent.gamecenter.wadl.api.impl.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            QQGameNoticeServiceImpl.this.lambda$updateGameCenterBar$1(gameNoticeInfo, view2);
                        }
                    });
                    d16.setMsg(string);
                    if (!TextUtils.isEmpty(gameNoticeInfo.E)) {
                        d16.setIcon(URLDrawable.getDrawable(gameNoticeInfo.E, URLDrawable.URLDrawableOptions.obtain()));
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        QLog.d(TAG, 1, "remove ret=" + remove);
        if (obj instanceof GameNoticeInfo) {
            removeDatabase((GameNoticeInfo) obj);
        }
        return remove;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public GameNoticeInfo remove(int i3) {
        GameNoticeInfo gameNoticeInfo = (GameNoticeInfo) super.remove(i3);
        QLog.d(TAG, 1, "remove index=" + i3 + ",gameNoticeInfo=" + gameNoticeInfo);
        if (gameNoticeInfo != null) {
            removeDatabase(gameNoticeInfo);
        }
        return gameNoticeInfo;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
    }
}
