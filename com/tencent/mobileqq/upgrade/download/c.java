package com.tencent.mobileqq.upgrade.download;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.q;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import protocol.KQQConfig.UpgradeInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\u00020\u0001:\u0002\u0011\u001eB\u0019\u0012\b\u0010&\u001a\u0004\u0018\u00010$\u0012\u0006\u0010)\u001a\u00020'\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bJ\u001e\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!R\u0016\u0010&\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010+R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010-R&\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u000f0/j\b\u0012\u0004\u0012\u00020\u000f`08\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00101R\"\u00108\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/c;", "", "", "action", DownloadInfo.spKey_Config, "", DomainData.DOMAIN_NAME, "c", "f", "Lcom/tencent/mobileqq/upgrade/download/d;", "e", "Lcom/tencent/open/downloadnew/DownloadInfo;", "d", "downloadInfo", "o", "Lcom/tencent/mobileqq/upgrade/download/c$b;", "listener", "a", "k", "state", "i", h.F, "", VirtualAppProxy.KEY_AUTO_DOWNLOAD, "r", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "b", "isSuccess", "errorCode", "", "errorMsg", "l", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "mDetailWrapper", "Lcom/tencent/mobileqq/upgrade/k;", "Lcom/tencent/mobileqq/upgrade/k;", "mDownloadController", "Lcom/tencent/mobileqq/upgrade/download/e;", "Lcom/tencent/mobileqq/upgrade/download/e;", "autoDownloadController", "Lcom/tencent/mobileqq/upgrade/download/d;", "mDownloadListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mStateChangedListeners", "Z", "g", "()Z", "p", "(Z)V", "mIsDownloadStarted", "<init>", "(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;Lcom/tencent/mobileqq/upgrade/k;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final UpgradeDetailWrapper mDetailWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k mDownloadController;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e autoDownloadController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mDownloadListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<b> mStateChangedListeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsDownloadStarted;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/c$a;", "", "", "DOWNLOAD_API_NOTIFY_KEY", "Ljava/lang/String;", "DOWNLOAD_API_QQ_APPID", "DOWNLOAD_API_VIA", "", "DOWNLOAD_CODE_LESS_TO_CUR", "I", "DOWNLOAD_CODE_NORMAL", "DOWNLOAD_YYB_ID", "FLAG_IS_WIFI", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.upgrade.download.c$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/c$b;", "", "", "state", "", "onStateChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void onStateChanged(int state);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63111);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@Nullable UpgradeDetailWrapper upgradeDetailWrapper, @NotNull k mDownloadController) {
        Intrinsics.checkNotNullParameter(mDownloadController, "mDownloadController");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) upgradeDetailWrapper, (Object) mDownloadController);
            return;
        }
        this.mDetailWrapper = upgradeDetailWrapper;
        this.mDownloadController = mDownloadController;
        this.mDownloadListener = new d(this);
        this.mStateChangedListeners = new ArrayList<>();
    }

    private final int c() {
        if (this.autoDownloadController == null) {
            return 1;
        }
        return 0;
    }

    private final void n(int action, int config) {
        UpgradeInfo upgradeInfo;
        String str;
        if ((action == 2 || action == 12) && f() == 4) {
            return;
        }
        UpgradeDetailWrapper upgradeDetailWrapper = this.mDetailWrapper;
        String str2 = null;
        if (upgradeDetailWrapper != null) {
            upgradeInfo = upgradeDetailWrapper.f306170d;
        } else {
            upgradeInfo = null;
        }
        if (upgradeInfo == null) {
            return;
        }
        if (!upgradeDetailWrapper.f306170d.isValid) {
            QLog.d("UpgradeController_Download", 1, "[sendActionToDownloadApi] UpgradeInfo invalid");
            this.mDetailWrapper.k();
            return;
        }
        UpgradeDetailWrapper.b bVar = upgradeDetailWrapper.f306173h;
        if (bVar != null) {
            str2 = bVar.f306176a;
        }
        if (str2 != null) {
            str = bVar.f306176a;
        } else {
            str = "\u65b0\u7248\u624bQ";
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, "100686848");
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, this.mDetailWrapper.f306170d.strNewSoftwareURL);
        bundle.putString(com.tencent.open.downloadnew.e.f341497f, MobileQQ.PACKAGE_NAME);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, action);
        if (action == 12) {
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341506o, true);
        }
        bundle.putString(com.tencent.open.downloadnew.e.f341500i, "ANDROIDQQ.QQUPDATE");
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, str);
        if (config != 0) {
            bundle.putString(com.tencent.open.downloadnew.e.f341504m, "_100686848");
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, false);
            if (action != 5 && this.mDetailWrapper.f306170d.iIncrementUpgrade == 0) {
                config = 0;
            }
        } else {
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, true);
        }
        bundle.putString(com.tencent.open.downloadnew.e.f341494c, "6633");
        bundle.putInt(com.tencent.open.downloadnew.e.f341496e, this.mDownloadController.l());
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, true);
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, true);
        bundle.putInt(com.tencent.open.downloadnew.e.f341505n, 1);
        bundle.putInt(com.tencent.open.downloadnew.e.C, this.mDetailWrapper.f306170d.bGray);
        DownloadApi.d(BaseActivity.sTopActivity, bundle, "biz_src_jc_update", this.mDetailWrapper.f306172f, config);
    }

    public final void a(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.mStateChangedListeners) {
            if (!this.mStateChangedListeners.contains(listener)) {
                this.mStateChangedListeners.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(@NotNull com.tencent.open.downloadnew.DownloadInfo downloadInfo) {
        String str;
        int i3;
        int i16;
        TMAssistantDownloadTaskInfo E;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) downloadInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        String apkFilePath = downloadInfo.L;
        if (TextUtils.isEmpty(apkFilePath) && downloadInfo.J == 1 && (E = DownloadManager.C().E(downloadInfo)) != null) {
            apkFilePath = E.mSavePath;
        }
        a aVar = a.f306276a;
        Intrinsics.checkNotNullExpressionValue(apkFilePath, "apkFilePath");
        PackageInfo d16 = aVar.d(apkFilePath, 1);
        if (d16 != null) {
            i3 = d16.versionCode;
            str = d16.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "packageInfo.packageName");
        } else {
            str = "";
            i3 = 0;
        }
        int a16 = com.tencent.mobileqq.cooperation.a.a(BaseApplication.context);
        String encodeFile = PluginStatic.encodeFile(apkFilePath);
        QLog.i("UpgradeController_Download", 1, "downFinished md5=" + encodeFile);
        if (Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, str) && a16 > 0 && i3 >= a16) {
            i(f());
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            com.tencent.mobileqq.upgrade.banner.b.i(0L);
            peekAppRuntime.getPreferences().edit().putString(AppConstants.Preferences.UPGRADE_CHECK_MD5, encodeFile).apply();
            t();
            this.mDownloadController.x(true);
            l(true, 0, "success");
            q.a("0X800716C");
            return;
        }
        boolean z16 = downloadInfo.T;
        if (z16) {
            DownloadApi.b("_100686848");
        } else {
            downloadInfo.T = false;
            n(10, c());
        }
        t();
        File file = new File(apkFilePath);
        if (file.exists()) {
            file.delete();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 < a16) {
            i16 = 101;
        } else {
            i16 = ActivityResultManager.ACTION_REQUEST_PERMISSION;
        }
        hashMap.put("param_FailCode", String.valueOf(i16));
        hashMap.put("param_ErrMsg", "MD5:" + encodeFile + "_PN:" + str);
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance("", "UpgradeErr", false, 0L, 0L, hashMap, "", true);
        if (!z16) {
            this.mDownloadController.f();
        }
    }

    @Nullable
    public final com.tencent.open.downloadnew.DownloadInfo d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.open.downloadnew.DownloadInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mDownloadListener.e();
    }

    @NotNull
    public final d e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mDownloadListener;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mDownloadListener.d();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mIsDownloadStarted;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.open.downloadnew.DownloadInfo d16 = d();
        if (d16 != null && d16.f() == 4) {
            try {
                int i3 = 1;
                if (d16.J != 1) {
                    i3 = 0;
                }
                n(5, i3);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("UpgradeController", 2, "installApk:", e16);
                }
            }
        }
    }

    public final void i(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, state);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_Download", 2, "invokeStateChangedToListeners:" + state);
        }
        synchronized (this.mStateChangedListeners) {
            Iterator<T> it = this.mStateChangedListeners.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onStateChanged(state);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            QLog.d("UpgradeController_Download", 1, "pauseDownload");
            n(3, c());
        }
    }

    public final void k(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
            return;
        }
        synchronized (this.mStateChangedListeners) {
            TypeIntrinsics.asMutableCollection(this.mStateChangedListeners).remove(listener);
        }
    }

    public final void l(boolean isSuccess, int errorCode, @NotNull String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(isSuccess), Integer.valueOf(errorCode), errorMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (NetworkUtil.isWifiConnected(BaseApplication.context)) {
            errorCode |= 1;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(errorCode));
        hashMap.put("param_ErrMsg", errorMsg);
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance("", "UpgradeErr", isSuccess, 0L, 0L, hashMap, "", true);
        com.tencent.mobileqq.upgrade.e.e().k(isSuccess);
    }

    public final void m() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (d() == null) {
            return;
        }
        boolean z16 = true;
        QLog.d("UpgradeController_Download", 1, "resumeDownload");
        UpgradeDetailWrapper upgradeDetailWrapper = this.mDetailWrapper;
        Intrinsics.checkNotNull(upgradeDetailWrapper);
        if (upgradeDetailWrapper.f306172f == null || this.mDetailWrapper.f306172f.updatemethod != 4) {
            z16 = false;
        }
        if (z16) {
            i3 = 12;
        } else {
            i3 = 2;
        }
        n(i3, c());
    }

    public final void o(@Nullable com.tencent.open.downloadnew.DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloadInfo);
        } else {
            this.mDownloadListener.f(downloadInfo);
        }
    }

    public final void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mIsDownloadStarted = z16;
        }
    }

    public final void q(boolean autoDownload) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, autoDownload);
            return;
        }
        if (!this.mIsDownloadStarted) {
            QLog.d("UpgradeController_Download", 1, "startDownload");
            this.mIsDownloadStarted = true;
            UpgradeDetailWrapper upgradeDetailWrapper = this.mDetailWrapper;
            Intrinsics.checkNotNull(upgradeDetailWrapper);
            if (upgradeDetailWrapper.f306172f != null && this.mDetailWrapper.f306172f.updatemethod == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 12;
            } else {
                i3 = 2;
            }
            n(i3, !autoDownload ? 1 : 0);
        }
    }

    public final void r(boolean autoDownload) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, autoDownload);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_Download", 2, "startDownload, autoDownload:" + autoDownload + ", downloadState: " + f() + ", mIsDownloadStarted:" + this.mIsDownloadStarted);
        }
        if (f() == 4 || this.mIsDownloadStarted || this.mIsDownloadStarted || (qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        ConfigHandler.i3(qQAppInterface, autoDownload);
        if (autoDownload) {
            if (this.autoDownloadController == null) {
                e eVar = new e(this);
                this.autoDownloadController = eVar;
                Intrinsics.checkNotNull(eVar);
                eVar.a();
                return;
            }
            return;
        }
        q(false);
    }

    public final synchronized void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.mIsDownloadStarted) {
            this.mIsDownloadStarted = false;
            QLog.d("UpgradeController_Download", 1, "stopDownload");
            try {
                j();
            } catch (Exception e16) {
                QLog.d("UpgradeController_Download", 1, "stop fail", e16);
            }
            t();
            DownloadApi.b("_100686848");
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        e eVar = this.autoDownloadController;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            eVar.b();
            this.autoDownloadController = null;
        }
    }
}
