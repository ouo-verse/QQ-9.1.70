package com.tencent.mobileqq.upgrade.download;

import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.a;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.f;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import protocol.KQQConfig.UpgradeInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00072\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010!\u001a\u00020\u001f\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010&R\u0016\u0010)\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(R$\u0010/\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00105\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/b;", "Lcom/tencent/mobileqq/upgrade/a$a;", "Lcom/tencent/open/downloadnew/f;", "", "errCode", "", "f", "g", "Lcom/tencent/mobileqq/upgrade/download/b$b;", "listener", "j", h.F, "", "checkUpgradeDetail", "d", "versionCode", "c", "success", "", "reqId", "code", "e", "a", "b", "", "Lcom/tencent/open/downloadnew/DownloadInfo;", "infos", "onResult", "errorCode", "errorMsg", "onException", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "mDetailWrapper", "Lcom/tencent/mobileqq/upgrade/a;", "Lcom/tencent/mobileqq/upgrade/a;", "mCodeWriter", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mCheckListenerWeak", "I", "mDownloadingVersionCode", "Ljava/lang/String;", "getMGetAuthCodeId", "()Ljava/lang/String;", "setMGetAuthCodeId", "(Ljava/lang/String;)V", "mGetAuthCodeId", "Z", "getMHasLogout", "()Z", "i", "(Z)V", "mHasLogout", "<init>", "(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements a.InterfaceC8882a, f {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final UpgradeDetailWrapper mDetailWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.upgrade.a mCodeWriter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<InterfaceC8883b> mCheckListenerWeak;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int mDownloadingVersionCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile String mGetAuthCodeId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mHasLogout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.upgrade.download.b$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/b$b;", "", "", "errCode", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "wrapper", "", "g1", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.upgrade.download.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8883b {
        void g1(int errCode, @NotNull UpgradeDetailWrapper wrapper);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63101);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull UpgradeDetailWrapper mDetailWrapper) {
        Intrinsics.checkNotNullParameter(mDetailWrapper, "mDetailWrapper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDetailWrapper);
        } else {
            this.mDetailWrapper = mDetailWrapper;
        }
    }

    private final void f(int errCode) {
        WeakReference<InterfaceC8883b> weakReference;
        InterfaceC8883b interfaceC8883b;
        if (!this.mHasLogout && (weakReference = this.mCheckListenerWeak) != null && (interfaceC8883b = weakReference.get()) != null) {
            UpgradeDetailWrapper upgradeDetailWrapper = this.mDetailWrapper;
            if (upgradeDetailWrapper.f306170d != null) {
                interfaceC8883b.g1(errCode, upgradeDetailWrapper);
            }
            this.mCheckListenerWeak = null;
        }
    }

    private final void g() {
        ArrayList arrayList = new ArrayList();
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f341184e = "100686848";
        downloadInfo.G = "6633";
        downloadInfo.f341189h = MobileQQ.PACKAGE_NAME;
        downloadInfo.I = this.mDownloadingVersionCode;
        arrayList.add(downloadInfo);
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_AuthCode", 2, "queryDownloadInfo:" + downloadInfo);
        }
        DownloadApi.g(arrayList, this);
    }

    @Override // com.tencent.mobileqq.upgrade.a.InterfaceC8882a
    public boolean a(int versionCode) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, versionCode)).booleanValue();
        }
        if (versionCode == this.mDownloadingVersionCode) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && this.mGetAuthCodeId == null) {
            c(versionCode);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.upgrade.a.InterfaceC8882a
    public void b(int errCode) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, errCode);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(errCode));
        StatisticCollector statisticCollector = StatisticCollector.getInstance(MobileQQ.sMobileQQ);
        if (errCode == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance("", "UpgradeWritten", z16, 0L, 0L, hashMap, "", true);
    }

    public final synchronized void c(int versionCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, versionCode);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return;
        }
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.ConfigHandler");
        this.mGetAuthCodeId = MobileQQ.PACKAGE_NAME + "_" + versionCode;
        this.mDownloadingVersionCode = versionCode;
        ((ConfigHandler) businessHandler).I2(MobileQQ.PACKAGE_NAME, versionCode, this.mGetAuthCodeId);
    }

    public final void d(boolean checkUpgradeDetail) {
        ApkUpdateDetail apkUpdateDetail;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, checkUpgradeDetail);
            return;
        }
        if (checkUpgradeDetail && (apkUpdateDetail = this.mDetailWrapper.f306172f) != null) {
            c(apkUpdateDetail.versioncode);
            return;
        }
        UpgradeDetailWrapper.b bVar = this.mDetailWrapper.f306173h;
        if (bVar != null) {
            c(bVar.f306179d);
        } else {
            QLog.e("UpgradeController_AuthCode", 1, "getAuthCode, mDetailWrapper.mNewApkInfo is null");
        }
    }

    public final synchronized void e(boolean success, @NotNull String reqId, @Nullable String code) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(success), reqId, code);
            return;
        }
        Intrinsics.checkNotNullParameter(reqId, "reqId");
        if (!this.mHasLogout && Intrinsics.areEqual(reqId, this.mGetAuthCodeId)) {
            if (success) {
                QLog.d("UpgradeController_AuthCode", 1, "handleGetAuthCode, success");
                if (this.mCodeWriter == null) {
                    g();
                }
                com.tencent.mobileqq.upgrade.a aVar = new com.tencent.mobileqq.upgrade.a(code, this);
                this.mCodeWriter = aVar;
                DownloadApi.n(aVar);
            } else {
                QLog.d("UpgradeController_AuthCode", 1, "handleGetAuthCode, fail");
                if (this.mCodeWriter == null) {
                    this.mDetailWrapper.f306170d = new UpgradeInfo();
                    this.mDetailWrapper.f306173h = null;
                    f(-1);
                }
            }
            this.mGetAuthCodeId = null;
            return;
        }
        QLog.i("UpgradeController_AuthCode", 1, "handleGetAuthCode, mHasLogout:" + this.mHasLogout + ", reqId:" + reqId + ", mGetAuthCodeId:" + this.mGetAuthCodeId);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.upgrade.a aVar = this.mCodeWriter;
        if (aVar != null) {
            DownloadApi.s(aVar);
            this.mCodeWriter = null;
        }
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mHasLogout = z16;
        }
    }

    public final void j(@NotNull InterfaceC8883b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mCheckListenerWeak = new WeakReference<>(listener);
        }
    }

    @Override // com.tencent.open.downloadnew.f
    public void onException(int errorCode, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, errorCode, (Object) errorMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_AuthCode", 2, "onException:" + errorCode + ", " + errorMsg);
        }
        f(0);
    }

    @Override // com.tencent.open.downloadnew.f
    public void onResult(@Nullable List<DownloadInfo> infos) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) infos);
            return;
        }
        List<DownloadInfo> list = infos;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            k.m().o(infos.get(0));
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController_AuthCode", 2, "onResult Status:" + infos.get(0));
            }
        }
        f(0);
    }
}
