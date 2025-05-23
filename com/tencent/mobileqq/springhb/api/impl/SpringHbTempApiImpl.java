package com.tencent.mobileqq.springhb.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.api.ISearchPopService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.springhb.ad;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.b;
import com.tencent.mobileqq.springhb.config.SpringHbCommonConfProcessor;
import com.tencent.mobileqq.springhb.config.a;
import com.tencent.mobileqq.springhb.config.g;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import com.tencent.mobileqq.springhb.main.SpringToMainHelper;
import com.tencent.mobileqq.springhb.preload.SpringHbPreloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.Serializable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SpringHbTempApiImpl implements ISpringHbTempApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SpringHbTempApiImpl";

    public SpringHbTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean activityTypeValid() {
        try {
            Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
            if (!(manager instanceof SpringFestivalEntryManager)) {
                return false;
            }
            return ((SpringFestivalEntryManager) manager).s();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "activityTypeValid error" + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean activityConfigLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return activityTypeValid();
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean disableReport(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        a d16 = SpringHbCommonConfProcessor.d();
        if (d16 == null || d16.d(i3, "ReportRequestDisabled", 0) == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public int getApngPlayCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            EntryConfigBean J = ((SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).J();
            if (J != null) {
                return J.commonData.animationPlayCount;
            }
            QLog.e(TAG, 1, "entryConfigBean is null");
            return 10;
        }
        return 10;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public DragonCardConfigData getDragonCardConfig(AppRuntime appRuntime) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (DragonCardConfigData) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
        }
        if (MobileQQ.sProcessId == 1) {
            return getDragonCardConfigFromCache(appRuntime);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "SpringHbIPCModule", "GetDragonCardConfig", null);
        if (callServer == null || !callServer.isSuccess() || (bundle = callServer.data) == null) {
            return null;
        }
        Serializable serializable = bundle.getSerializable("resultDragonCardConfig");
        if (!(serializable instanceof DragonCardConfigData)) {
            return null;
        }
        return (DragonCardConfigData) serializable;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public DragonCardConfigData getDragonCardConfigFromCache(AppRuntime appRuntime) {
        g gVar;
        EntryConfigBean o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (DragonCardConfigData) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime);
        }
        if (appRuntime == null || (gVar = (g) appRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)) == null || (o16 = gVar.o()) == null) {
            return null;
        }
        return o16.dragonCardConfigData;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public int getEntryConfigTaskId(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime)).intValue();
        }
        EntryConfigBean o16 = ((g) appRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).o();
        if (o16 != null) {
            return o16.taskId;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public int getEntryConfigVersion(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).intValue();
        }
        EntryConfigBean o16 = ((g) appRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).o();
        if (o16 != null) {
            return o16.version;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public int getGameCenterPreloadConfVersion(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime)).intValue();
        }
        return ((SpringHbPreloadManager) appRuntime.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER)).h(0);
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public long getReportConfigDelayTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        a d16 = SpringHbCommonConfProcessor.d();
        if (d16 != null) {
            return d16.b(i3, "ResCoverReportInterval");
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public long getSpringHBSpeedTime() {
        SpringFestivalEntryManager springFestivalEntryManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (springFestivalEntryManager = (SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)) != null) {
            return springFestivalEntryManager.I();
        }
        return NetConnInfoCenter.getServerTimeMillis();
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public int getSpringHbPreloadConfVersion(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime)).intValue();
        }
        return ((SpringHbPreloadManager) appRuntime.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER)).h(2);
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean isCurTimeInTime(TimeInfo timeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) timeInfo)).booleanValue();
        }
        return isInTime(timeInfo, NetConnInfoCenter.getServerTimeMillis());
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean isFoldDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (PadUtil.a(BaseApplicationImpl.getApplication()) == DeviceType.FOLD) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean isGameCenterActivity(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((SpringFestivalEntryManager) appRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).T();
        }
        QLog.i(TAG, 1, "isGameCenterActivity appRuntime QQAppInterface");
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean isInTime(TimeInfo timeInfo, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, timeInfo, Long.valueOf(j3))).booleanValue();
        }
        return b.c(timeInfo, j3);
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean isLoadingShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return SpringToMainHelper.f289366a.i();
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean isSplashActivity(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context)).booleanValue();
        }
        if (context instanceof SplashActivity) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean isSpringHbActivity(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((SpringFestivalEntryManager) appRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).X();
        }
        QLog.i(TAG, 1, "isGameCenterActivity appRuntime QQAppInterface");
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public boolean needReportFullTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        a d16 = SpringHbCommonConfProcessor.d();
        if (d16 != null && d16.c("ReportFullExceptionStack", true)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public void openCommonHbPage() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            EntryConfigBean J = ((SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).J();
            if (J != null) {
                str = J.commonData.springHBMainUrl;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                SpringToMainHelper.k(BaseApplication.getContext(), str, "2");
            }
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public void openSpringHbWebView(Context context, String str, int i3, String str2, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), bundle);
        } else {
            SpringToMainHelper.f289366a.x(context, str, i3, str2, z16, bundle);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public Long parseTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Long) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return Long.valueOf(ad.d(str));
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public void requestSpringHBPreloadSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        QLog.i(TAG, 2, "requestSpringHBPreloadSource processId:" + MobileQQ.sProcessId);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (MobileQQ.sProcessId == 1 && (peekAppRuntime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            ((SpringHbPreloadManager) qQAppInterface.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER)).v(true, 4);
            ((g) qQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).f(qQAppInterface, 3);
            ISearchPopService iSearchPopService = (ISearchPopService) qQAppInterface.getRuntimeService(ISearchPopService.class, "all");
            if (iSearchPopService != null) {
                iSearchPopService.requestPreloadConfig(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbTempApi
    public void setIsLoadingShowing(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            SpringToMainHelper.f289366a.t(z16);
        }
    }
}
