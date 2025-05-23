package com.tencent.mobileqq.msf.core.auth;

import android.os.Build;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.thirdsig.api.impl.ThirdSigServiceImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AppSetting;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeResult;
import com.tencent.qqnt.kernel.nativeinterface.CopyImgWithDelGPSResult;
import com.tencent.qqnt.kernel.nativeinterface.DeviceCodecFormatInfo;
import com.tencent.qqnt.kernel.nativeinterface.DeviceInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService;
import com.tencent.qqnt.kernel.nativeinterface.ILoginTicketListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateResult;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine;
import com.tencent.qqnt.kernel.nativeinterface.InitGlobalPathConfig;
import com.tencent.qqnt.kernel.nativeinterface.InitLoginConfig;
import com.tencent.qqnt.kernel.nativeinterface.LoginPlatformType;
import com.tencent.qqnt.kernel.nativeinterface.LoginTicketInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseReq;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseRsp;
import com.tencent.qqnt.kernel.nativeinterface.OpentelemetryTracePlan;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaImgSize;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import com.tencent.qqnt.kernel.nativeinterface.WrapperEngineGlobalConfig;
import com.tencent.qqnt.kernel.nativeinterface.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f247460b = "NT_WT_WRAPPER";

    /* renamed from: c, reason: collision with root package name */
    private static final String f247461c = "NT_WT_ENGINE";

    /* renamed from: d, reason: collision with root package name */
    public static AtomicBoolean f247462d;

    /* renamed from: e, reason: collision with root package name */
    public static AtomicBoolean f247463e;

    /* renamed from: f, reason: collision with root package name */
    private static IQQNTWrapperEngine f247464f;

    /* renamed from: a, reason: collision with root package name */
    public MsfCore f247465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ILoginTicketListCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginTicketListCallback
        public void onResult(int i3, String str, HashMap<Long, LoginTicketInfo> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, hashMap);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAllLoginTicket result = [");
            sb5.append(i3);
            sb5.append("], errMsg = [");
            sb5.append(str);
            sb5.append("], size = [");
            if (hashMap != null) {
                i16 = hashMap.size();
            }
            sb5.append(i16);
            sb5.append("]");
            QLog.d(h.f247460b, 1, sb5.toString());
            if (hashMap == null) {
                return;
            }
            Iterator<Long> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                LoginTicketInfo loginTicketInfo = hashMap.get(Long.valueOf(longValue));
                if (loginTicketInfo == null) {
                    QLog.e(h.f247460b, 1, "getAllLoginTicket ticketInfo is null, uin = [" + longValue + "]");
                } else if (!h.this.a(loginTicketInfo.getA2()) && !h.this.a(loginTicketInfo.getD2()) && !h.this.a(loginTicketInfo.getD2Key())) {
                    QLog.d(h.f247460b, 1, "add nt account: " + longValue);
                    com.tencent.mobileqq.msf.core.auth.a aVar = new com.tencent.mobileqq.msf.core.auth.a(String.valueOf(longValue));
                    aVar.b(loginTicketInfo.getA2());
                    aVar.g(loginTicketInfo.getD2Key());
                    aVar.f(loginTicketInfo.getD2());
                    aVar.a(true);
                    h.this.f247465a.getAccountCenter().b(aVar);
                } else {
                    QLog.e(h.f247460b, 1, "getAllLoginTicket ticketInfo is null, uin = [" + longValue + "]");
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements IGlobalAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public AvifTranscodeResult avifTranscodeJpgAndGenAIOThumb(int i3, AvifTranscodeInfo avifTranscodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (AvifTranscodeResult) iPatchRedirector.redirect((short) 25, (Object) this, i3, (Object) avifTranscodeInfo);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public /* synthetic */ CopyImgWithDelGPSResult copyImgWithDelGPS(String str, String str2) {
            return r.b(this, str, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public Integer fixPicImgType(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public Boolean generatePicAioThumb(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public Boolean generateThumb(String str, String str2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Boolean) iPatchRedirector.redirect((short) 12, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public Integer getActiveIPStackType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Integer) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public AppSetting getAppSetting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AppSetting) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new AppSetting(QLog.isColorLevel(), BaseApplication.getContext().getMSFInterfaceAdapter().isDebugVersion(), BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion(), BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion());
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public DeviceCodecFormatInfo getDeviceCodecFormatInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (DeviceCodecFormatInfo) iPatchRedirector.redirect((short) 23, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public DeviceInfo getDeviceInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (DeviceInfo) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public Integer getMSFUsedIpProtocolType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Integer) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public RichMediaImgSize getRichMediaImgSize(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (RichMediaImgSize) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public IOperateResult onCompressVideo(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (IOperateResult) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) str2);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onDataReport(String str, String str2, boolean z16, HashMap<String, String> hashMap, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, str, str2, Boolean.valueOf(z16), hashMap, Boolean.valueOf(z17));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public /* synthetic */ void onDataReportWithAppKey(String str, String str2, String str3, boolean z16, HashMap hashMap, boolean z17) {
            r.n(this, str, str2, str3, z16, hashMap, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public OpentelemetryTracePlan onGetMqqOpentelemetryTraceReportPlan() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (OpentelemetryTracePlan) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onGetOfflineMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public Long onGetSrvCalTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Long) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onInstallFinished(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onLog(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            } else {
                QLog.d(h.f247461c, 1, str);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public MarkdownParseRsp onParseMarkdown(MarkdownParseReq markdownParseReq) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (MarkdownParseRsp) iPatchRedirector.redirect((short) 15, (Object) this, (Object) markdownParseReq);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onRegisterCountInstruments(ArrayList<String> arrayList, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onRegisterValueInstruments(ArrayList<String> arrayList, ArrayList<Double> arrayList2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, this, arrayList, arrayList2, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onReportCountIndicators(HashMap<String, String> hashMap, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, hashMap, str, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onReportValueIndicators(HashMap<String, String> hashMap, String str, double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, this, hashMap, str, Double.valueOf(d16));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onSendSSORequest(long j3, String str, byte[] bArr, SendRequestParam sendRequestParam, String str2, HashMap<String, byte[]> hashMap, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, bArr, sendRequestParam, str2, hashMap, Integer.valueOf(i3));
            } else {
                r.y(this, j3, str, bArr, sendRequestParam, str2, hashMap, i3);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onShowErrUITips(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
        public void onUpdateGeneralFlag(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f247462d = new AtomicBoolean(false);
        f247463e = new AtomicBoolean(false);
        f247464f = null;
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b() {
        QLog.d(f247460b, 1, "initNtKernel");
        int i3 = 0;
        if (f247463e.compareAndSet(false, true)) {
            System.loadLibrary("basic_share");
            System.loadLibrary("djinni_support_lib");
            System.loadLibrary("module_service");
            System.loadLibrary("djinni_interface_core_public");
            System.loadLibrary("kernel");
            QLog.d(f247460b, 1, "initNtKernel real");
            if (!QLog.isColorLevel()) {
                i3 = 2;
            }
            IQQNTWrapperEngine.CppProxy.get().setLogLevel(i3);
            WrapperEngineGlobalConfig wrapperEngineGlobalConfig = new WrapperEngineGlobalConfig();
            wrapperEngineGlobalConfig.platformType = 1;
            wrapperEngineGlobalConfig.appType = 6;
            wrapperEngineGlobalConfig.appVersion = BaseApplication.getContext().getMSFInterfaceAdapter().getAppReportVersionName();
            wrapperEngineGlobalConfig.osVersion = String.valueOf(Build.VERSION.SDK_INT);
            InitGlobalPathConfig initGlobalPathConfig = new InitGlobalPathConfig();
            initGlobalPathConfig.desktopGlobalPath = "";
            initGlobalPathConfig.mobileGlobalDBPath = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/nt_databases/";
            initGlobalPathConfig.mobileGlobalDataPath = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/QQfile_recv/";
            initGlobalPathConfig.mobileGlobalTempPath = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/nt_runtimetmp/";
            initGlobalPathConfig.basePathPrefix = "";
            wrapperEngineGlobalConfig.globalPathConfig = initGlobalPathConfig;
            wrapperEngineGlobalConfig.useXlog = QLog.isUseXlog();
            f247464f = IQQNTWrapperEngine.CppProxy.get();
            QLog.d(f247460b, 1, "initNtKernel initState = " + IQQNTWrapperEngine.CppProxy.get().initWithMobileConfig(wrapperEngineGlobalConfig, new b()));
        }
    }

    private void c() {
        a();
        IKernelLoginService.CppProxy.getLoginService().getAllLoginTicket(new a());
    }

    public void a(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msfCore);
            return;
        }
        this.f247465a = msfCore;
        b();
        c();
    }

    private void a() {
        if (f247462d.compareAndSet(false, true)) {
            InitLoginConfig initLoginConfig = new InitLoginConfig();
            initLoginConfig.appid = 16L;
            initLoginConfig.bid = BaseApplication.getContext().getMSFInterfaceAdapter().getAppid();
            initLoginConfig.guid = util.buf_to_string(NetConnInfoCenter.GUID);
            initLoginConfig.qua = BaseApplication.getContext().getMSFInterfaceAdapter().getQUA();
            initLoginConfig.clientVer = BaseApplication.getContext().getMSFInterfaceAdapter().getClientVersion();
            initLoginConfig.commonPath = BaseApplication.getContext().getFilesDir().getAbsolutePath() + ThirdSigServiceImpl.NT_WTLOGIN_DIR;
            initLoginConfig.deviceType = "ANDROID";
            initLoginConfig.hostName = DeviceInfoMonitor.getModel();
            initLoginConfig.platform = LoginPlatformType.PLATFORM_ANDROID;
            IKernelLoginService.CppProxy.getLoginService().initConfig(initLoginConfig, null);
            QLog.d(f247460b, 1, "init guid = " + util.buf_to_string(NetConnInfoCenter.GUID));
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                return;
            }
            IQQNTWrapperEngine.CppProxy.get().getECDHService().setIsDebug(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }
}
