package com.tencent.mobileqq.msf.core.f0.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.f0.a;
import com.tencent.mobileqq.msf.core.f0.c.b;
import com.tencent.mobileqq.msf.core.k;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msfcore.BeaconBridge;
import com.tencent.mobileqq.msfcore.IAppInfoProvider;
import com.tencent.mobileqq.msfcore.ILogger;
import com.tencent.mobileqq.msfcore.IMSFCallbackBridge;
import com.tencent.mobileqq.msfcore.ISoLoader;
import com.tencent.mobileqq.msfcore.MSFExternNetworkInfo;
import com.tencent.mobileqq.msfcore.MSFKernel;
import com.tencent.mobileqq.msfcore.MSFResponseAdapter;
import com.tencent.mobileqq.msfcore.UpperBridgesImpl;
import com.tencent.mobileqq.msfcore.config.MSFCoreModifyConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFCoreNetworkConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFCoreQuicEngineConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFCoreSSIDConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFDualEngineConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFMultiTcpConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFPacketCombineConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFPkgCompressConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFPkgStatisticsConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFSideWayHttpConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFSideWayUdpConfigAdapter;
import com.tencent.mobileqq.msfcore.config.MSFTcpEngineConfigAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements com.tencent.mobileqq.msf.core.f0.a, com.tencent.mobileqq.msf.core.y.c, com.tencent.mobileqq.msf.core.y.d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: q, reason: collision with root package name */
    public static final String f248032q = "MSF.C.NewSender";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248033r = "param_is_support_no_bssid";

    /* renamed from: s, reason: collision with root package name */
    public static final int f248034s = -1;

    /* renamed from: a, reason: collision with root package name */
    private final MsfCore f248035a;

    /* renamed from: b, reason: collision with root package name */
    private final MSFKernel f248036b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.c.d.a f248037c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.c.d.c f248038d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f248039e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.c.c f248040f;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.c.a f248041g;

    /* renamed from: h, reason: collision with root package name */
    private long f248042h;

    /* renamed from: i, reason: collision with root package name */
    private long f248043i;

    /* renamed from: j, reason: collision with root package name */
    private final ISoLoader f248044j;

    /* renamed from: k, reason: collision with root package name */
    private final BeaconBridge f248045k;

    /* renamed from: l, reason: collision with root package name */
    private final ILogger f248046l;

    /* renamed from: m, reason: collision with root package name */
    private final IAppInfoProvider f248047m;

    /* renamed from: n, reason: collision with root package name */
    private final IMSFCallbackBridge f248048n;

    /* renamed from: o, reason: collision with root package name */
    private final b.InterfaceC8070b f248049o;

    /* renamed from: p, reason: collision with root package name */
    private final INetInfoHandler f248050p;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements ISoLoader {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.ISoLoader
        public boolean load(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
            }
            int msfLoadSo = StringUtils.msfLoadSo("MSF.C.NewSender", str);
            boolean loadResult = StringUtils.getLoadResult(msfLoadSo);
            if (!loadResult) {
                com.tencent.mobileqq.msf.core.c0.j.a(str, false, msfLoadSo, "");
            }
            return loadResult;
        }

        @Override // com.tencent.mobileqq.msfcore.ISoLoader
        public void reportLoadSoError(String str, boolean z16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), str2);
            } else {
                com.tencent.mobileqq.msf.core.c0.j.a(str, z16, -1, str2);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.f0.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8077b implements BeaconBridge {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.msf.core.f0.c.b$b$a */
        /* loaded from: classes15.dex */
        class a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f248053a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.msf.core.c0.j f248054b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f248055c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f248056d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f248057e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f248058f;

            a(Map map, com.tencent.mobileqq.msf.core.c0.j jVar, String str, boolean z16, long j3, long j16) {
                this.f248053a = map;
                this.f248054b = jVar;
                this.f248055c = str;
                this.f248056d = z16;
                this.f248057e = j3;
                this.f248058f = j16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, C8077b.this, map, jVar, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                this.f248053a.put(b.f248033r, String.valueOf(com.tencent.mobileqq.msf.core.x.d.F()));
                this.f248054b.a(this.f248055c + "_android", this.f248056d, this.f248057e, this.f248058f, this.f248053a, false, false);
            }
        }

        C8077b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.BeaconBridge
        public void report(@NonNull String str, boolean z16, long j3, long j16, @NonNull HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap);
                return;
            }
            com.tencent.mobileqq.msf.core.c0.j statReporter = b.this.f248035a.getStatReporter();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(hashMap);
            if (statReporter == null) {
                return;
            }
            q.q().post(new a(concurrentHashMap, statReporter, str, z16, j3, j16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements ILogger {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.ILogger
        public void d(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            QLog.d("MSF.C.NewSender." + str, 1, str2);
        }

        @Override // com.tencent.mobileqq.msfcore.ILogger
        public void e(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
                return;
            }
            QLog.e("MSF.C.NewSender." + str, 1, str2);
        }

        @Override // com.tencent.mobileqq.msfcore.ILogger
        public void i(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
                return;
            }
            QLog.i("MSF.C.NewSender." + str, 1, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements IAppInfoProvider {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public String getAppIdentifier() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            PackageManager packageManager = BaseApplication.getContext().getPackageManager();
            try {
                for (String str : packageManager.getPackagesForUid(Binder.getCallingUid())) {
                    PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 64);
                    if (packageInfo != null) {
                        for (Signature signature : packageInfo.signatures) {
                            String charsString = signature.toCharsString();
                            if (!TextUtils.isEmpty(charsString)) {
                                return o.c(charsString);
                            }
                        }
                    }
                }
                return "";
            } catch (PackageManager.NameNotFoundException e16) {
                QLog.e("MSF.C.NewSender", 1, e16.toString(), e16);
                return "";
            }
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public String getAppVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return BaseApplication.getContext().getPublishVersion();
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public int getAppid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return BaseApplication.getContext().getAppId();
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public int getBuildType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) {
                return 1;
            }
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                return 0;
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public String getImei() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return o.e();
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public String getQimei36() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return o.k();
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public String getQua() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return BaseApplication.getContext().getQua();
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public String getSandBoxPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return BaseApplication.getContext().getFilesDir() + "/msfCore";
        }

        @Override // com.tencent.mobileqq.msfcore.IAppInfoProvider
        public String getSystemVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return Build.VERSION.RELEASE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements IMSFCallbackBridge {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.IMSFCallbackBridge
        public void onMSFApnState(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.IMSFCallbackBridge
        public void onMSFBadNetworkState(final boolean z16, final int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            QLog.d("MSF.C.NewSender", 1, "[onMSFBadNetworkState], isBadNet: " + z16 + ", reason: " + i3);
            b.this.f248039e.post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.f0.c.g
                @Override // java.lang.Runnable
                public final void run() {
                    b.e.this.a(z16, i3);
                }
            });
        }

        @Override // com.tencent.mobileqq.msfcore.IMSFCallbackBridge
        public void onMSFError(final int i3, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, str4);
                return;
            }
            QLog.d("MSF.C.NewSender", 1, "[onMSFError], onInvalidSign, error: " + i3 + ", errTitle: " + str2 + ", errContent: " + str3 + ", extInfo: " + str4);
            b.this.f248039e.post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.f0.c.i
                @Override // java.lang.Runnable
                public final void run() {
                    b.e.this.a(i3);
                }
            });
        }

        @Override // com.tencent.mobileqq.msfcore.IMSFCallbackBridge
        public void onMSFNetworkState(final int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            QLog.d("MSF.C.NewSender", 1, "[onMSFNetworkState], state: " + i3 + ", reason: " + i16);
            b.this.f248039e.post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.f0.c.j
                @Override // java.lang.Runnable
                public final void run() {
                    b.e.this.b(i3);
                }
            });
        }

        @Override // com.tencent.mobileqq.msfcore.IMSFCallbackBridge
        public void onMSFPacketState(@NonNull final MSFResponseAdapter mSFResponseAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) mSFResponseAdapter);
                return;
            }
            QLog.d("MSF.C.NewSender", 1, "[onMSFPacketState], MSFResponse: " + mSFResponseAdapter);
            b.this.f248042h = SystemClock.uptimeMillis();
            b.this.f248039e.post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.f0.c.f
                @Override // java.lang.Runnable
                public final void run() {
                    b.e.this.a(mSFResponseAdapter);
                }
            });
        }

        @Override // com.tencent.mobileqq.msfcore.IMSFCallbackBridge
        public void onMSFServerTimeUpdated(final int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            QLog.d("MSF.C.NewSender", 1, "[onMSFServerTimeUpdated], timeDiff: " + i3);
            b.this.f248039e.post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.f0.c.h
                @Override // java.lang.Runnable
                public final void run() {
                    NetConnInfoCenter.handleGetServerTimeDiff(i3);
                }
            });
        }

        @Override // com.tencent.mobileqq.msfcore.IMSFCallbackBridge
        public void onSSORetError(int i3, @NonNull String str, @NonNull String str2, @NonNull String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, str3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i3) {
            if (i3 == 1) {
                b.this.f248038d.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3) {
            if (i3 == 2) {
                b.this.f248037c.k();
            }
            if (i3 == 3) {
                b.this.f248037c.c(b.this.c());
                return;
            }
            if (i3 == 5) {
                b.this.f248037c.i();
                return;
            }
            if (i3 == 8) {
                b.this.f248037c.j();
            } else if (i3 == 7) {
                b.this.f248037c.l();
            } else if (i3 == 10) {
                b.this.f248037c.d(b.this.f248036b.getClientIP());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MSFResponseAdapter mSFResponseAdapter) {
            ToServiceMsg b16 = b.this.f248040f.b(mSFResponseAdapter.getSeq());
            if (b16 != null && !b16.isNeedCallback() && mSFResponseAdapter.getState() == 3 && mSFResponseAdapter.getRecvData().length == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NewSender", 2, "[onMSFPacketState], cmd:" + mSFResponseAdapter.getCmd() + " has send OK but return with no recvData, toServiceMsg:" + com.tencent.mobileqq.msf.core.z.a.b(b16));
                    return;
                }
                return;
            }
            if (!mSFResponseAdapter.getCmd().equals(BaseConstants.CMD_SSOHELLOPUSH)) {
                b.this.f248038d.a(b16, mSFResponseAdapter);
            } else if (b16 == null && mSFResponseAdapter.getIsRecvFromMainConn()) {
                b.this.f248035a.getMsfProbeManager().a(null, b.this.f248038d.a().a(mSFResponseAdapter));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z16, int i3) {
            b.this.f248037c.a(z16, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f implements b.InterfaceC8070b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.auth.b.InterfaceC8070b
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else if (!TextUtils.isEmpty(str) && !str.equals("0")) {
                b.this.f248035a.getAccountCenter().m(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class g implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                b.this.a(0, "");
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                b.this.a(2, str);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.this.a(1, str);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                b.this.a(2, str);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                b.this.a(1, str);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                b.this.a(0, "");
            } else {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class h implements QLog.ColorLevelChangeListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.qphone.base.util.QLog.ColorLevelChangeListener
        public void colorLevelChange(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else {
                b.this.f248036b.setLogLevel(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class i implements o.d {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.o.d
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else if (!TextUtils.isEmpty(str2)) {
                b.this.f248036b.setQimei36(str2);
            }
        }
    }

    public b(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f248042h = 0L;
        this.f248043i = 0L;
        a aVar = new a();
        this.f248044j = aVar;
        C8077b c8077b = new C8077b();
        this.f248045k = c8077b;
        c cVar = new c();
        this.f248046l = cVar;
        this.f248047m = new d();
        e eVar = new e();
        this.f248048n = eVar;
        this.f248049o = new f();
        this.f248050p = new g();
        this.f248035a = msfCore;
        this.f248039e = q.d();
        MSFKernel mSFKernel = MSFKernel.getInstance(new UpperBridgesImpl(eVar, aVar, c8077b, cVar), QLog.isUseXlog());
        this.f248036b = mSFKernel;
        com.tencent.mobileqq.msf.core.f0.c.d.b bVar = new com.tencent.mobileqq.msf.core.f0.c.d.b();
        com.tencent.mobileqq.msf.core.f0.c.d.a aVar2 = new com.tencent.mobileqq.msf.core.f0.c.d.a();
        this.f248037c = aVar2;
        this.f248040f = new com.tencent.mobileqq.msf.core.f0.c.c(mSFKernel, bVar, aVar2);
        this.f248038d = new com.tencent.mobileqq.msf.core.f0.c.d.c(msfCore.getSsoRespHandler(), aVar2, bVar);
        this.f248041g = new com.tencent.mobileqq.msf.core.f0.c.a(mSFKernel);
    }

    private void t() {
        try {
            StringBuilder sb5 = new StringBuilder();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    for (X509Certificate x509Certificate : ((X509TrustManager) trustManager).getAcceptedIssuers()) {
                        sb5.append("-----BEGIN CERTIFICATE-----\n");
                        sb5.append(Base64.encodeToString(x509Certificate.getEncoded(), 0));
                        sb5.append("-----END CERTIFICATE-----\n");
                    }
                    this.f248036b.setCertificateData(sb5.toString());
                    return;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (IllegalStateException | GeneralSecurityException e16) {
            QLog.e("MSF.C.NewSender", 1, "[initHttpsCertificateData] error ", e16);
        }
    }

    private void u() {
        this.f248036b.setMSFConfig(4, new MSFMultiTcpConfigAdapter.Builder().isOpen(com.tencent.mobileqq.msf.core.x.d.c0()).sendDelayTimeInXg(com.tencent.mobileqq.msf.core.x.d.g0()).sendDelayTimeInWiFi(com.tencent.mobileqq.msf.core.x.d.f0()).resendIntervalTimeInXg(com.tencent.mobileqq.msf.core.x.d.e0()).resendIntervalTimeInWiFi(com.tencent.mobileqq.msf.core.x.d.d0()).sidewayMode(com.tencent.mobileqq.msf.core.x.d.h0()).build());
        this.f248036b.setMSFConfig(1, new MSFPacketCombineConfigAdapter.Builder().isOpen(com.tencent.mobileqq.msf.core.x.d.l0()).maxPacketCount(com.tencent.mobileqq.msf.core.x.d.Y()).maxPacketSize(com.tencent.mobileqq.msf.core.x.d.a0()).minPacketSize(com.tencent.mobileqq.msf.core.x.d.b0()).maxPacketDelayTime(com.tencent.mobileqq.msf.core.x.d.Z()).maxCombineWindowTime(com.tencent.mobileqq.msf.core.x.d.U()).isSupportNTRequest(com.tencent.mobileqq.msf.core.x.d.x()).build());
        this.f248036b.setMSFConfig(6, new MSFPkgStatisticsConfigAdapter.Builder().isOpen(com.tencent.mobileqq.msf.core.x.d.o0()).tooLongConnTime(com.tencent.mobileqq.msf.core.x.d.V0()).RTTUpBound(com.tencent.mobileqq.msf.core.x.d.B0()).RTTLowBound(com.tencent.mobileqq.msf.core.x.d.A0()).thresholdForHeartBeatRtt(com.tencent.mobileqq.msf.core.x.d.U0()).build());
        this.f248036b.setMSFConfig(2, new MSFSideWayHttpConfigAdapter.Builder().isOpen(com.tencent.mobileqq.msf.core.x.d.F0()).quickRetryDelay(com.tencent.mobileqq.msf.core.x.d.H0()).sendDelayTimeInXg(com.tencent.mobileqq.msf.core.x.d.L0()).sendDelayTimeInWiFi(com.tencent.mobileqq.msf.core.x.d.K0()).resendIntervalTimeInXg(com.tencent.mobileqq.msf.core.x.d.J0()).resendIntervalTimeInWiFi(com.tencent.mobileqq.msf.core.x.d.I0()).maxParallelCount(com.tencent.mobileqq.msf.core.x.d.G0()).sidewayMode(com.tencent.mobileqq.msf.core.x.d.M0()).build());
        this.f248036b.setMSFConfig(3, new MSFSideWayUdpConfigAdapter.Builder().isOpen(com.tencent.mobileqq.msf.core.x.d.N0()).sendDelayTimeInXg(com.tencent.mobileqq.msf.core.x.d.R0()).sendDelayTimeInWiFi(com.tencent.mobileqq.msf.core.x.d.Q0()).resendIntervalTimeInXg(com.tencent.mobileqq.msf.core.x.d.P0()).resendIntervalTimeInWiFi(com.tencent.mobileqq.msf.core.x.d.O0()).sidewayMode(com.tencent.mobileqq.msf.core.x.d.S0()).build());
        this.f248036b.setMSFConfig(5, new MSFTcpEngineConfigAdapter.Builder().serialConnNum(com.tencent.mobileqq.msf.core.x.d.D0()).parallelConnNum(com.tencent.mobileqq.msf.core.x.d.n0()).parallelConnInterval(com.tencent.mobileqq.msf.core.x.d.m0()).connMode(com.tencent.mobileqq.msf.core.x.d.g()).sideWayConnLimit(com.tencent.mobileqq.msf.core.x.d.E0()).isEnableHearbeatOpt(com.tencent.mobileqq.msf.core.x.d.s()).checkPingTimeout(com.tencent.mobileqq.msf.core.x.d.f()).activeCheckPingInterval(com.tencent.mobileqq.msf.core.x.d.c()).backgroundCheckPingInterval(com.tencent.mobileqq.msf.core.x.d.e()).build());
        this.f248036b.setMSFConfig(7, new MSFPkgCompressConfigAdapter.Builder().isOpen(com.tencent.mobileqq.msf.core.x.d.B()).compressThreshold(com.tencent.mobileqq.msf.core.x.d.C()).compressThresholdMap(com.tencent.mobileqq.msf.core.x.d.D()).build());
        this.f248036b.setMSFConfig(11, new MSFCoreSSIDConfigAdapter.Builder().isOpen(com.tencent.mobileqq.msf.core.x.d.F().booleanValue()).historySSIDValidity(com.tencent.mobileqq.msf.core.x.d.E()).build());
        this.f248036b.setMSFConfig(9, new MSFCoreNetworkConfigAdapter.Builder().connMode(com.tencent.mobileqq.msf.core.x.d.A()).isQuicRevertTCPOnConnFail(com.tencent.mobileqq.msf.core.x.d.x0()).isQuicRevertTCPOnIPv6(com.tencent.mobileqq.msf.core.x.d.y0()).quickIdleCheckTimeout(com.tencent.mobileqq.msf.core.x.d.z0()).build());
        this.f248036b.setMSFConfig(10, new MSFCoreQuicEngineConfigAdapter.Builder().parallelConnNum(com.tencent.mobileqq.msf.core.x.d.t0()).parallelConnInterval(com.tencent.mobileqq.msf.core.x.d.v0()).sideWayConnLimit(com.tencent.mobileqq.msf.core.x.d.w0()).isEnableHeartbeatOpt(com.tencent.mobileqq.msf.core.x.d.u0()).checkPingTimeout(com.tencent.mobileqq.msf.core.x.d.s0()).activeCheckPingInterval(com.tencent.mobileqq.msf.core.x.d.q0()).backgroundCheckPingInterval(com.tencent.mobileqq.msf.core.x.d.r0()).enableHandshakePersist(com.tencent.mobileqq.msf.core.x.d.p0()).build());
        this.f248036b.setMSFConfig(13, new MSFDualEngineConfigAdapter.Builder().mainConnType(com.tencent.mobileqq.msf.core.x.d.p()).sideWayConnType(com.tencent.mobileqq.msf.core.x.d.r()).sideWayConnLimit(com.tencent.mobileqq.msf.core.x.d.q()).isEnableHeartbeatOpt(com.tencent.mobileqq.msf.core.x.d.o()).checkPingTimeout(com.tencent.mobileqq.msf.core.x.d.k()).activeCheckPingInterval(com.tencent.mobileqq.msf.core.x.d.i()).backgroundCheckPingInterval(com.tencent.mobileqq.msf.core.x.d.j()).enableDynamicSideConnPool(com.tencent.mobileqq.msf.core.x.d.m()).enableHandshakePersist(com.tencent.mobileqq.msf.core.x.d.n()).enable0RTTPing(com.tencent.mobileqq.msf.core.x.d.l()).build());
        this.f248036b.setMSFConfig(8, new MSFCoreModifyConfigAdapter.Builder().ConfigMap(com.tencent.mobileqq.msf.core.x.d.d()).build());
        HashMap<String, Integer> G = com.tencent.mobileqq.msf.core.x.d.G();
        if (!G.isEmpty()) {
            this.f248036b.setMSFReportSampleRate(G);
        }
    }

    private void v() {
        this.f248036b.setMSFWhiteList(16, new ArrayList<>(com.tencent.mobileqq.msf.core.x.o.x().e()));
        this.f248036b.setMSFWhiteList(1, new ArrayList<>(com.tencent.mobileqq.msf.core.x.o.x().h()));
        this.f248036b.setMSFWhiteList(2, new ArrayList<>(com.tencent.mobileqq.msf.core.x.o.x().j()));
        this.f248036b.setMSFWhiteList(4, new ArrayList<>(com.tencent.mobileqq.msf.core.x.o.x().i()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC);
        this.f248036b.setMSFWhiteList(32, new ArrayList<>(arrayList));
    }

    private void y() {
        com.tencent.mobileqq.msf.core.e0.a aVar = new com.tencent.mobileqq.msf.core.e0.a();
        this.f248040f.a(aVar);
        this.f248038d.a(aVar);
        com.tencent.mobileqq.msf.core.e0.b bVar = new com.tencent.mobileqq.msf.core.e0.b();
        this.f248040f.a(bVar);
        this.f248038d.a(bVar);
        this.f248038d.a(k.c());
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            x();
            this.f248036b.connect();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f248037c.c();
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.f248036b.onAppBackground();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (b() && this.f248037c.g()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f248036b.isBadNetwork();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.f248036b.getConnSeq();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.f248036b.connectState();
    }

    public long o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        return this.f248036b.currentRtt();
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            q.s().post(new com.tencent.mobileqq.msf.core.f0.c.d(this));
        }
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.f248036b.currentConnType();
    }

    public long q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this)).longValue();
        }
        return this.f248042h;
    }

    public long r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
        }
        return this.f248043i;
    }

    public Map<String, String> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Map) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_MSF_CORE_CONN_STATE, c(n()));
        hashMap.put(BaseConstants.KEY_MSF_CORE_RTT, o() + "ms");
        hashMap.put(BaseConstants.KEY_MSF_CORE_PACKET_SIZE, "\u2191" + z() + " \u2193" + w());
        return hashMap;
    }

    public long w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Long) iPatchRedirector.redirect((short) 29, (Object) this)).longValue();
        }
        return this.f248036b.recvQueueSize();
    }

    public void x() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        NetConnInfoCenter.checkConnInfo();
        int a16 = this.f248037c.a();
        int a17 = this.f248037c.a(true);
        MSFExternNetworkInfo mSFExternNetworkInfo = new MSFExternNetworkInfo();
        if (a16 == 1) {
            String currentSSID = NetConnInfoCenter.getCurrentSSID(true);
            if (this.f248037c.b(currentSSID)) {
                str = currentSSID;
            } else {
                str = BaseConstants.DEFAULT_UNKNOWN_SSID;
            }
            mSFExternNetworkInfo.setNetName(str);
            if (!this.f248037c.b(currentSSID)) {
                currentSSID = BaseConstants.DEFAULT_UNKNOWN_BSSID;
            }
            mSFExternNetworkInfo.setNetIdentifier(currentSSID);
            mSFExternNetworkInfo.setSubType(com.tencent.mobileqq.msf.core.net.k.d());
        } else if (a16 == 2) {
            String currentAPN = NetConnInfoCenter.getCurrentAPN(true);
            if (TextUtils.isEmpty(currentAPN)) {
                currentAPN = BaseConstants.DEFAULT_UNKNOWN_XG_NET_NAME;
            }
            mSFExternNetworkInfo.setNetName(currentAPN);
            mSFExternNetworkInfo.setNetIdentifier(BaseConstants.DEFAULT_UNKNOWN_XG_NET_IDENTIFIER);
            mSFExternNetworkInfo.setSubType(com.tencent.mobileqq.msf.core.net.k.d());
        }
        if (a16 != 0 && a17 == 0) {
            QLog.e("MSF.C.NewSender", 1, "refreshNetworkInfo get error IpFamily, networkType: " + a16 + ", ipFamily: " + a17);
            com.tencent.mobileqq.msf.core.c0.j statReporter = this.f248035a.getStatReporter();
            if (statReporter != null) {
                statReporter.a(a16, a17);
            }
            a17 = 1;
        }
        this.f248036b.notifyNetworkInfo(a16, a17, mSFExternNetworkInfo);
        QLog.d("MSF.C.NewSender", 1, "[notifyNetworkState], networkType: " + a16 + ", ipFamily: " + a17 + ", networkInfo: " + mSFExternNetworkInfo);
    }

    public long z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this)).longValue();
        }
        return this.f248036b.sendQueueSize();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f248037c.e(str);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.f248036b.currentSSOIP() : (String) iPatchRedirector.redirect((short) 12, (Object) this);
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.f248037c.b() : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.f248036b.onAppForeground();
            q.s().post(new com.tencent.mobileqq.msf.core.f0.c.d(this));
        }
    }

    private String c(int i3) {
        switch (i3) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 6:
            case 8:
            case 9:
                return "\u8fde\u63a5\u4e2d";
            case 3:
                return "\u5df2\u8fde\u63a5";
            case 5:
                return "\u5df2\u65ad\u8fde";
            case 7:
                return "\u7f51\u7edc\u5f85\u9a8c\u8bc1";
            case 10:
                int p16 = p();
                return p16 == 1 ? "TCP\u5df2\u8fde\u63a5" : p16 == 2 ? "\u4e3b\u526fTCP\u5df2\u8fde\u63a5" : p16 == 5 ? "Quic\u5df2\u8fde\u63a5" : p16 == 6 ? "UDP\u5df2\u8fde\u63a5" : p16 == 4 ? "http\u77ed\u94fe\u5df2\u8fde\u63a5" : "\u5df2\u8fde\u63a5";
            default:
                return "";
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f248037c.f(i3);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f248036b.isConnected() : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
    }

    private void b(final a.InterfaceC8075a interfaceC8075a) {
        q.s().post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.f0.c.e
            @Override // java.lang.Runnable
            public final void run() {
                b.this.a(interfaceC8075a);
            }
        });
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean a(Context context, a.InterfaceC8075a interfaceC8075a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) interfaceC8075a)).booleanValue();
        }
        this.f248036b.init(context, this.f248047m, this.f248048n);
        this.f248036b.setLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
        QLog.setColorLevelChangeListener(new h());
        o.a(new i());
        com.tencent.mobileqq.msf.core.y.a.h().a((com.tencent.mobileqq.msf.core.y.c) this);
        com.tencent.mobileqq.msf.core.y.a.h().a((com.tencent.mobileqq.msf.core.y.d) this);
        AppNetConnInfo.registerConnectionChangeReceiver(context, this.f248050p);
        this.f248035a.getAccountCenter().a(this.f248049o);
        y();
        b(interfaceC8075a);
        return true;
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int currentUsedIPType = this.f248036b.getCurrentUsedIPType();
        if (currentUsedIPType == 1) {
            return 1;
        }
        if (currentUsedIPType == 2) {
            return 2;
        }
        return currentUsedIPType == 3 ? 3 : 0;
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public int a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        if (this.f248038d.b()) {
            FromServiceMsg a16 = o.a(toServiceMsg);
            a16.setBusinessFail(2014, "error");
            this.f248035a.addRespToQuque(toServiceMsg, a16);
            return toServiceMsg.getRequestSsoSeq();
        }
        this.f248043i = SystemClock.uptimeMillis();
        return this.f248040f.c(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(String str, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, str2);
            return;
        }
        try {
            str3 = MsfCore.sCore.getAccountCenter().g().d(str);
        } catch (Exception e16) {
            QLog.d("MSF.C.NewSender", 1, "getUid error", e16);
            str3 = "";
        }
        StringBuilder sb5 = new StringBuilder("setAccountKey using ");
        if (this.f248035a.getMainAccount().equals(str)) {
            sb5.append("notifyLoginSuccess");
            this.f248036b.notifyLoginSuccess(str, i3, str3, bArr2, bArr5, bArr7);
        } else {
            sb5.append("notifyRefreshSign");
            this.f248036b.notifyRefreshSign(str, i3, str3, bArr2, bArr5, bArr7);
        }
        sb5.append(", uin=");
        sb5.append(MsfSdkUtils.getShortUin(str));
        sb5.append(", uid=");
        sb5.append(str3);
        sb5.append(", mainAccount=");
        sb5.append(this.f248035a.getMainAccount());
        MsfSdkUtils.printBytes(",A2=", bArr2, sb5);
        MsfSdkUtils.printBytes(",D2=", bArr5, sb5);
        MsfSdkUtils.printBytes(",key=", bArr7, sb5);
        QLog.d("MSF.C.NewSender", 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        this.f248036b.clearSign(str);
        QLog.d("MSF.C.NewSender", 1, "removeAccountKey uin=" + MsfSdkUtils.getShortUin(str));
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            this.f248036b.sendMSFPingCheck(i3);
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a.InterfaceC8075a interfaceC8075a) {
        v();
        u();
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            String a16 = com.tencent.mobileqq.msf.core.e0.k.c().a();
            String b16 = com.tencent.mobileqq.msf.core.e0.k.c().b();
            if (!TextUtils.isEmpty(a16)) {
                com.tencent.mobileqq.msf.core.d a17 = com.tencent.mobileqq.msf.core.d.a(a16);
                this.f248036b.setSSOTestEnv(a17.b(), a17.d(), b16);
            }
        }
        if (com.tencent.mobileqq.msf.core.x.d.A() == 6) {
            if (com.tencent.mobileqq.msf.core.y.a.h().i()) {
                this.f248036b.onAppForeground();
            } else {
                this.f248036b.onAppBackground();
            }
        }
        this.f248035a.getAccountCenter().j();
        t();
        A();
        k.a(this);
        interfaceC8075a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        int c16 = this.f248037c.c(i3);
        int a16 = this.f248037c.a(true);
        MSFExternNetworkInfo mSFExternNetworkInfo = new MSFExternNetworkInfo();
        if (c16 == 1) {
            if (!this.f248037c.b(str)) {
                str = NetConnInfoCenter.getCurrentSSID(true);
            }
            mSFExternNetworkInfo.setNetName(this.f248037c.b(str) ? str : BaseConstants.DEFAULT_UNKNOWN_SSID);
            if (!this.f248037c.b(str)) {
                str = BaseConstants.DEFAULT_UNKNOWN_BSSID;
            }
            mSFExternNetworkInfo.setNetIdentifier(str);
            mSFExternNetworkInfo.setSubType(com.tencent.mobileqq.msf.core.net.k.d());
        } else if (c16 == 2) {
            if (TextUtils.isEmpty(str)) {
                str = NetConnInfoCenter.getCurrentAPN(true);
            }
            if (TextUtils.isEmpty(str)) {
                str = BaseConstants.DEFAULT_UNKNOWN_XG_NET_NAME;
            }
            mSFExternNetworkInfo.setNetName(str);
            mSFExternNetworkInfo.setNetIdentifier(BaseConstants.DEFAULT_UNKNOWN_XG_NET_IDENTIFIER);
            mSFExternNetworkInfo.setSubType(com.tencent.mobileqq.msf.core.net.k.d());
        }
        if (i3 != 0 && a16 == 0) {
            QLog.e("MSF.C.NewSender", 1, "refreshNetworkInfo get error IpFamily, networkType: " + i3 + ", ipFamily: " + a16);
            com.tencent.mobileqq.msf.core.c0.j statReporter = this.f248035a.getStatReporter();
            if (statReporter != null) {
                statReporter.a(i3, a16);
            }
            a16 = 1;
        }
        this.f248036b.notifyNetworkInfo(c16, a16, mSFExternNetworkInfo);
        QLog.d("MSF.C.NewSender", 1, "[notifyNetworkState], networkType: " + c16 + ", ipFamily: " + a16 + ", networkInfo: " + mSFExternNetworkInfo);
    }
}
