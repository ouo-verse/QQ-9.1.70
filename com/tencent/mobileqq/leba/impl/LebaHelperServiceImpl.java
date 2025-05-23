package com.tencent.mobileqq.leba.impl;

import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.core.BasePluginDataManager;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.core.e;
import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.core.g;
import com.tencent.mobileqq.leba.data.LebaFeedGoOfflineSwitch;
import com.tencent.mobileqq.leba.entity.LebaPluginConfig;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.RedPointHolder;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaHelperServiceImpl implements ILebaHelperService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "LebaHelperServiceImpl";
    public static int redTouchDongTaiPath;
    public static int redTouchShiPinPath;
    private final LebaFeedGoOfflineSwitch lebaFeedGoOfflineSwitch;
    private AppRuntime mApp;
    private LebaHelper mLebaHelper;
    private final g mLebaWebPreloadHelper;
    private com.tencent.mobileqq.leba.data.b patchConfig;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21512);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            redTouchDongTaiPath = 10000;
            redTouchShiPinPath = 4045;
        }
    }

    public LebaHelperServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mLebaWebPreloadHelper = new g();
            this.lebaFeedGoOfflineSwitch = new LebaFeedGoOfflineSwitch();
        }
    }

    private boolean isNormalModeOrSimpleMode() {
        if (SimpleUIUtil.isNowElderMode()) {
            QLog.i(TAG, 1, "elderMode");
            return false;
        }
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return true;
        }
        QLog.i(TAG, 1, "studyMode");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyLebaStyleChange$1(int i3) {
        BasePluginDataManager b16 = com.tencent.mobileqq.leba.core.b.b(i3);
        if (b16.f().isEmpty()) {
            b16.j(0, "notifyLebaStyleChange style: " + i3);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void addLebaListener(ResourcePluginListener resourcePluginListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) resourcePluginListener);
            return;
        }
        initLebaHelper();
        LebaHelper lebaHelper = this.mLebaHelper;
        if (lebaHelper == null) {
            QLog.i(TAG, 1, "addLebaListener mLebaHelper == null");
        } else {
            lebaHelper.b(resourcePluginListener);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void checkModleAndRefesh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        initLebaHelper();
        LebaHelper lebaHelper = this.mLebaHelper;
        if (lebaHelper == null) {
            QLog.i(TAG, 1, "checkModleAndRefesh mLebaHelper == null");
        } else {
            lebaHelper.e();
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void getAllPluginList(final AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) appRuntime);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.leba.core.a.a(AppRuntime.this);
                }
            }, 160, null, false);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public List<LebaPluginInfo> getLebaConfigList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        initLebaHelper();
        LebaHelper lebaHelper = this.mLebaHelper;
        if (lebaHelper == null) {
            QLog.i(TAG, 1, "addLebaListener mLebaHelper == null");
            return null;
        }
        return lebaHelper.j();
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public Object getLebaHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        initLebaHelper();
        return this.mLebaHelper;
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public List<n> getLebaMgrList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return e.a().b();
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public List<RedPointHolder> getLebaPluginRedPointIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (List) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<LebaPluginConfig> all = LebaPluginConfig.getAll(peekAppRuntime.getEntityManagerFactory().createEntityManager());
        for (int i3 = 0; i3 < all.size(); i3++) {
            RedPointHolder redPointHolder = new RedPointHolder();
            long j3 = all.get(i3).uiResId;
            redPointHolder.uiResId = j3;
            redPointHolder.appid = (int) j3;
            arrayList.add(redPointHolder);
        }
        if (TianshuRedTouch.INSTANCE.j()) {
            RedPointHolder redPointHolder2 = new RedPointHolder();
            int i16 = redTouchShiPinPath;
            redPointHolder2.uiResId = i16;
            redPointHolder2.appid = i16;
            arrayList.add(redPointHolder2);
            RedPointHolder redPointHolder3 = new RedPointHolder();
            int i17 = redTouchDongTaiPath;
            redPointHolder3.uiResId = i17;
            redPointHolder3.appid = i17;
            arrayList.add(redPointHolder3);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public List<n> getLebaShowList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return e.a().c();
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public n getLebaViewItemById(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (n) iPatchRedirector.redirect((short) 19, (Object) this, j3);
        }
        return e.a().e(j3);
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void getUserSettingNet(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) appRuntime);
        } else {
            com.tencent.mobileqq.leba.core.a.b(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void initLebaHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime == null) {
            QLog.i(TAG, 1, "initLebaHelper mApp == null");
        } else if (this.mLebaHelper == null) {
            LebaHelper lebaHelper = new LebaHelper(appRuntime);
            this.mLebaHelper = lebaHelper;
            lebaHelper.o();
            this.mLebaHelper.p();
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public boolean isFeedGoOffline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        if (this.lebaFeedGoOfflineSwitch.a() && isNormalModeOrSimpleMode()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public boolean isNeedPreloadPlugin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str)).booleanValue();
        }
        return this.mLebaWebPreloadHelper.a(this.mApp, str);
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public boolean isPluginInfoPatchEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.leba.data.b bVar = this.patchConfig;
        if (bVar == null) {
            QLog.e(TAG, 1, "isPluginInfoPatchEnable patchConfig is null");
            return false;
        }
        if (!bVar.b()) {
            return false;
        }
        return isNormalModeOrSimpleMode();
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public boolean isPluginOpen(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, j3)).booleanValue();
        }
        return e.a().g(j3);
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public boolean isTableModel(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return f.t(appRuntime);
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public boolean needShowRedDot(AppRuntime appRuntime, long j3, Set<Long> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, appRuntime, Long.valueOf(j3), set)).booleanValue();
        }
        return f.v(appRuntime, j3, set);
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void netSetPluginState(String str, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        QLog.i(TAG, 1, "netSetPluginState path=" + str + ",status=" + z16 + ",time=" + j3 + ",trace=" + Log.getStackTraceString(new Throwable()));
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void notifyLebaStyleChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
            return;
        }
        final int i3 = 1;
        QLog.i(TAG, 1, "notifyLebaStyleChange: " + z16);
        if (LebaHelper.s()) {
            if (z16) {
                i3 = 2;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    LebaHelperServiceImpl.lambda$notifyLebaStyleChange$1(i3);
                }
            }, 240, null, false);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void notifyPluginListChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        initLebaHelper();
        LebaHelper lebaHelper = this.mLebaHelper;
        if (lebaHelper == null) {
            QLog.i(TAG, 1, "notifyPluginListChanged mLebaHelper == null");
        } else {
            lebaHelper.x();
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void notifyRefreshWebProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            this.mLebaWebPreloadHelper.b(this.mApp);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void notifySetPluginState(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        QLog.i(TAG, 1, "notifySetPluginState type=" + i3 + ",isSuccess=" + z16 + ",trace=" + Log.getStackTraceString(new Throwable()));
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void notifyUpdatePluginPatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        com.tencent.mobileqq.leba.data.b bVar = this.patchConfig;
        if (bVar == null || bVar.c()) {
            QLog.i(TAG, 1, "notifyUpdatePluginPatch patchConfig is null or default");
            this.patchConfig = com.tencent.mobileqq.leba.data.b.a();
            com.tencent.mobileqq.leba.core.b.c(8, "");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        QLog.i(TAG, 1, "onCreate");
        this.mApp = appRuntime;
        com.tencent.mobileqq.leba.data.b a16 = com.tencent.mobileqq.leba.data.b.a();
        this.patchConfig = a16;
        a16.f();
        QLog.e(TAG, 1, "lebaService onCreate");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        LebaHelper lebaHelper = this.mLebaHelper;
        if (lebaHelper != null) {
            lebaHelper.g();
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void pluginInfoPatch(List<LebaPluginInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) list);
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return;
        }
        boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
        com.tencent.mobileqq.leba.data.b bVar = this.patchConfig;
        if (bVar != null && bVar.b()) {
            for (LebaPluginInfo lebaPluginInfo : list) {
                this.patchConfig.e(lebaPluginInfo);
                if (!isNowElderMode) {
                    this.patchConfig.d(lebaPluginInfo);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public List<n> reloadLebaItems(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appRuntime);
        }
        return e.a().h(appRuntime);
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void removeLebaListener(ResourcePluginListener resourcePluginListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) resourcePluginListener);
            return;
        }
        initLebaHelper();
        LebaHelper lebaHelper = this.mLebaHelper;
        if (lebaHelper == null) {
            QLog.i(TAG, 1, "addLebaListener mLebaHelper == null");
        } else {
            lebaHelper.C(resourcePluginListener);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void reportPluginStatus(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) appRuntime);
        } else {
            e.a().i(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void setFlagBackFromMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            e.f240372e |= 1;
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void setFlagUpdateFinishResourceDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            e.f240372e |= 8;
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void setFlagUpdateFromH5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            e.f240372e |= 4;
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void setFlagUpdateOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            e.f240372e |= 2;
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void updateAllLebaListFlag(List<BusinessInfoCheckUpdate.AppSetting> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void updateAppSetting(AppRuntime appRuntime, long j3, boolean z16, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, appRuntime, Long.valueOf(j3), Boolean.valueOf(z16), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        QLog.i(TAG, 1, "updateAppSetting appId=" + j3 + ",status=" + z16 + ",time=" + j16 + ",trace=" + Log.getStackTraceString(new Throwable()));
    }

    @Override // com.tencent.mobileqq.leba.ILebaHelperService
    public void updateBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.mLebaWebPreloadHelper.d(this.mApp);
        }
    }
}
