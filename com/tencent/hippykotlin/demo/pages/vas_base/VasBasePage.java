package com.tencent.hippykotlin.demo.pages.vas_base;

import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.aegiskmm.a;
import com.tencent.aegiskmm.bean.AegisConfig;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.LaunchTimestamps;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQBrowser;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQPerformance;
import com.tencent.hippykotlin.demo.pages.foundation.lib.aegis.QQAegis;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyRewardVideoModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyVasJSIModule;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.HttpRequstHelper;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.report.VasCommonReportProxy;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.CollectReport;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.ReportChainImpl;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.impl.QLogProxy;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.impl.ReportConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportChain;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.NetworkModule;
import com.tencent.kuikly.core.module.d;
import com.tencent.kuikly.core.module.r;
import com.tencent.kuikly.core.pager.b;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import defpackage.j;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes33.dex */
public abstract class VasBasePage extends BasePager {
    public static final Companion Companion = new Companion();
    public final PagePerfReport _perfReport;
    public final Lazy clickTime$delegate;
    public long createTime;
    public final Lazy from$delegate;
    public int hasLocalRes;
    public boolean hasQQMcConfig;
    public final Lazy isDebug$delegate;
    public final Lazy isFirstOpenPage$delegate;
    public LaunchTimestamps launchTimestamps;
    public final Lazy pageScope$delegate;
    public final PageTrace pageTrace;
    public final PlatformApi platformApi;
    public ReportChainImpl reportChain;
    public final Function1<Map<String, String>, Unit> vasCommonReportImpl;

    /* loaded from: classes33.dex */
    public static final class Companion {
        public final VasBasePage getCtx() {
            b g16 = c.f117352a.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage");
            return (VasBasePage) g16;
        }
    }

    /* loaded from: classes33.dex */
    public static final class PagePerfReport {
        public long firstScreenShowedTime;
        public boolean isPerfUpload;
        public final VasBasePage page;
        public final ArrayList<String> record = new ArrayList<>();
        public long viewDidLoadTime;

        public PagePerfReport(VasBasePage vasBasePage) {
            this.page = vasBasePage;
        }

        public final void reportPerformance() {
            if (this.isPerfUpload) {
                return;
            }
            this.isPerfUpload = true;
            BuildersKt.b(this.page.getPageScope(), null, null, new VasBasePage$PagePerfReport$reportPerformance$1(this, null), 3, null);
        }
    }

    /* loaded from: classes33.dex */
    public static final class PageTrace {
    }

    /* loaded from: classes33.dex */
    public static final class PlatformApi {
        public final Lazy codecModule$delegate;
        public final Lazy coreModule$delegate;
        public final Lazy networkModule$delegate;
        public final Lazy qqModule$delegate;
        public final Lazy spModule$delegate;
        public final Lazy vasModule$delegate;

        public PlatformApi(final VasBasePage vasBasePage) {
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            Lazy lazy4;
            Lazy lazy5;
            Lazy lazy6;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<BridgeModule>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$coreModule$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final BridgeModule invoke() {
                    return (BridgeModule) VasBasePage.this.acquireModule("HRBridgeModule");
                }
            });
            this.coreModule$delegate = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<VasModule>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$vasModule$2
                @Override // kotlin.jvm.functions.Function0
                public final VasModule invoke() {
                    return VasModule.Companion.getInstance();
                }
            });
            this.vasModule$delegate = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QQKuiklyPlatformApi>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$qqModule$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final QQKuiklyPlatformApi invoke() {
                    return (QQKuiklyPlatformApi) VasBasePage.this.acquireModule("QQKuiklyPlatformApi");
                }
            });
            this.qqModule$delegate = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<NetworkModule>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$networkModule$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final NetworkModule invoke() {
                    return (NetworkModule) VasBasePage.this.acquireModule("KRNetworkModule");
                }
            });
            this.networkModule$delegate = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<r>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$spModule$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final r invoke() {
                    return (r) VasBasePage.this.acquireModule("KRSharedPreferencesModule");
                }
            });
            this.spModule$delegate = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$codecModule$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final d invoke() {
                    return (d) VasBasePage.this.acquireModule("KRCodecModule");
                }
            });
            this.codecModule$delegate = lazy6;
            LazyKt__LazyJVMKt.lazy(new Function0<CacheModule>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$mmkvModule$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final CacheModule invoke() {
                    return (CacheModule) VasBasePage.this.acquireModule("HRCacheModule");
                }
            });
            LazyKt__LazyJVMKt.lazy(new Function0<QQKuiklyRewardVideoModule>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi$gdtModule$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final QQKuiklyRewardVideoModule invoke() {
                    return (QQKuiklyRewardVideoModule) VasBasePage.this.acquireModule("QQKuiklyRewardVideoModule");
                }
            });
        }

        public final d getCodecModule() {
            return (d) this.codecModule$delegate.getValue();
        }

        public final BridgeModule getCoreModule() {
            return (BridgeModule) this.coreModule$delegate.getValue();
        }

        public final QQKuiklyPlatformApi getQqModule() {
            return (QQKuiklyPlatformApi) this.qqModule$delegate.getValue();
        }

        public final r getSpModule() {
            return (r) this.spModule$delegate.getValue();
        }

        public final VasModule getVasModule() {
            return (VasModule) this.vasModule$delegate.getValue();
        }
    }

    public VasBasePage() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$pageScope$2
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return e.f117232d;
            }
        });
        this.pageScope$delegate = lazy;
        this.platformApi = new PlatformApi(this);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$clickTime$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(VasBasePage.this.getPagerData().n().o("clicktime", 0L));
            }
        });
        this.clickTime$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$from$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return TraceHelper.INSTANCE.getEnteranceId();
            }
        });
        this.from$delegate = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$isDebug$2
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(c.f117352a.g().getPageData().u());
            }
        });
        this.isDebug$delegate = lazy4;
        this.pageTrace = new PageTrace();
        this.hasLocalRes = -1;
        this._perfReport = new PagePerfReport(this);
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$isFirstOpenPage$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Integer num = VasBasePage.this.platformApi.getSpModule().getInt(VasBasePage.this.getPageName() + "_isFirstOpenPage");
                boolean z16 = true;
                if (num == null) {
                    VasBasePage.this.platformApi.getSpModule().setInt(VasBasePage.this.getPageName() + "_isFirstOpenPage", 1);
                }
                if (num != null && num.intValue() == 1) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
        });
        this.isFirstOpenPage$delegate = lazy5;
        this.vasCommonReportImpl = new VasBasePage$vasCommonReportImpl$1(this);
        this.createTime = -1L;
        new Keport();
    }

    public boolean autoChangeStatusBarStyle() {
        return !(this instanceof UpLoadBackgroundPage);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object buildCookie(String str, Continuation<? super String> continuation) {
        VasBasePage$buildCookie$1 vasBasePage$buildCookie$1;
        Object coroutine_suspended;
        int i3;
        VasBasePage vasBasePage;
        String str2;
        if (continuation instanceof VasBasePage$buildCookie$1) {
            vasBasePage$buildCookie$1 = (VasBasePage$buildCookie$1) continuation;
            int i16 = vasBasePage$buildCookie$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                vasBasePage$buildCookie$1.label = i16 - Integer.MIN_VALUE;
                Object obj = vasBasePage$buildCookie$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = vasBasePage$buildCookie$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (str.length() > 0) {
                        String uin = this.platformApi.getQqModule().getUin();
                        HttpRequstHelper httpRequstHelper = HttpRequstHelper.INSTANCE;
                        vasBasePage$buildCookie$1.L$0 = this;
                        vasBasePage$buildCookie$1.L$1 = uin;
                        vasBasePage$buildCookie$1.label = 1;
                        Object psk = httpRequstHelper.getPSK(str, vasBasePage$buildCookie$1);
                        if (psk == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        vasBasePage = this;
                        obj = psk;
                        str2 = uin;
                    }
                    return "";
                }
                if (i3 == 1) {
                    str2 = vasBasePage$buildCookie$1.L$1;
                    vasBasePage = vasBasePage$buildCookie$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str3 = (String) obj;
                if (!(str2.length() != 0)) {
                    if (!(str3.length() == 0)) {
                        StringBuilder a16 = j.a("uin=", str2, ";p_skey=", str3, ";p_uin=");
                        a16.append(str2);
                        return a16.toString();
                    }
                }
                KLog.INSTANCE.e(vasBasePage.getPageName(), QUISkinImage$$ExternalSyntheticOutline0.m("error uin=", str2, " psKey=", str3));
                return "";
            }
        }
        vasBasePage$buildCookie$1 = new VasBasePage$buildCookie$1(this, continuation);
        Object obj2 = vasBasePage$buildCookie$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasBasePage$buildCookie$1.label;
        if (i3 != 0) {
        }
        String str32 = (String) obj2;
        if (!(str2.length() != 0)) {
        }
        KLog.INSTANCE.e(vasBasePage.getPageName(), QUISkinImage$$ExternalSyntheticOutline0.m("error uin=", str2, " psKey=", str32));
        return "";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        Map<String, Module> createExternalModules = super.createExternalModules();
        Intrinsics.checkNotNull(createExternalModules);
        mutableMap = MapsKt__MapsKt.toMutableMap(createExternalModules);
        mutableMap.put("VasKuiklyModule", new VasModule());
        mutableMap.put("QQKuiklyPlatformApi", new QQKuiklyPlatformApi());
        mutableMap.put("QQKuiklyVasJSIModule", new QQKuiklyVasJSIModule());
        mutableMap.put("QQKuiklyRewardVideoModule", new QQKuiklyRewardVideoModule());
        return mutableMap;
    }

    public final String getFrom() {
        return (String) this.from$delegate.getValue();
    }

    public final e getPageScope() {
        return (e) this.pageScope$delegate.getValue();
    }

    public final IReportChain getReportChain() {
        ReportConfig reportConfig;
        ReportChainImpl reportChainImpl = this.reportChain;
        if (reportChainImpl != null) {
            return reportChainImpl;
        }
        Triple<String, Integer, Boolean> reportConfig2 = getReportConfig();
        if (reportConfig2 == null) {
            reportConfig = null;
        } else {
            String first = reportConfig2.getFirst();
            reportConfig = new ReportConfig(first, first + util.base64_pad_url + IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp(), reportConfig2.getSecond().intValue(), reportConfig2.getThird().booleanValue(), -1L, this.vasCommonReportImpl, new Function0<Long>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$getReportChainConfig$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Long invoke() {
                    return Long.valueOf(IPagerIdKtxKt.getBridgeModule(VasBasePage.this).currentTimeStamp());
                }
            });
        }
        if (reportConfig == null) {
            return null;
        }
        CollectReport collectReport = CollectReport.INSTANCE;
        ReportChainImpl reportChainImpl2 = new ReportChainImpl(reportConfig);
        reportChainImpl2.logProxy = new QLogProxy();
        CollectReport.reportChainMap.put(reportConfig.setKey, reportChainImpl2);
        this.reportChain = reportChainImpl2;
        return reportChainImpl2;
    }

    public Triple<String, Integer, Boolean> getReportConfig() {
        return null;
    }

    public final boolean isDebug() {
        return ((Boolean) this.isDebug$delegate.getValue()).booleanValue();
    }

    public final VasCommonReportProxy newVasCommonReport(String str) {
        return new VasCommonReportProxy(str, this.vasCommonReportImpl);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onUnhandledException(String str) {
        super.onUnhandledException(str);
        QQAegis qQAegis = QQAegis.INSTANCE;
        a.f61726d.a("onUnhandledException", str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public void pageDidAppear() {
        super.pageDidAppear();
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(500, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(600, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
        this._perfReport.reportPerformance();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public void pageWillDestroy() {
        IReportChain append;
        super.pageWillDestroy();
        this._perfReport.reportPerformance();
        VasUIToken.isCurrentThemeDark = null;
        LaunchTimestamps launchTimestamps = this.launchTimestamps;
        long j3 = launchTimestamps != null ? launchTimestamps.openPage : -1L;
        if (j3 <= 0) {
            j3 = this.createTime;
        }
        VasCommonReportProxy newVasCommonReport = newVasCommonReport("kuikly_open");
        newVasCommonReport.num1 = 2L;
        newVasCommonReport.num2 = j3 > -1 ? IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp() - j3 : 0L;
        String pageName = getPager().getPageName();
        if (pageName != null) {
            newVasCommonReport.value1 = pageName;
        }
        String valueOf = String.valueOf(PageDataExtKt.getResVersion(c.f117352a.g().getPageData()));
        if (valueOf != null) {
            newVasCommonReport.value2 = valueOf;
        }
        String from = getFrom();
        if (from != null) {
            newVasCommonReport.value3 = from;
        }
        newVasCommonReport.report(false);
        long currentTimeStamp = IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp();
        IReportChain reportChain = getReportChain();
        if (reportChain == null || (append = reportChain.append(new Node(1000, currentTimeStamp))) == null) {
            return;
        }
        append.end(currentTimeStamp);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(900, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(400, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        if (this.hasQQMcConfig) {
            LaunchTimestamps launchTimestamps = this.launchTimestamps;
            long j3 = launchTimestamps != null ? launchTimestamps.openPage : -1L;
            VasCommonReportProxy newVasCommonReport = newVasCommonReport("kuikly_open");
            newVasCommonReport.num1 = 1L;
            newVasCommonReport.num2 = j3 > -1 ? IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp() - j3 : 0L;
            newVasCommonReport.num3 = this.hasLocalRes;
            String pageName = getPager().getPageName();
            if (pageName != null) {
                newVasCommonReport.value1 = pageName;
            }
            String valueOf = String.valueOf(PageDataExtKt.getResVersion(c.f117352a.g().getPageData()));
            if (valueOf != null) {
                newVasCommonReport.value2 = valueOf;
            }
            String from = getFrom();
            if (from != null) {
                newVasCommonReport.value3 = from;
            }
            newVasCommonReport.report(false);
        }
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(300, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
        PagePerfReport pagePerfReport = this._perfReport;
        pagePerfReport.getClass();
        pagePerfReport.viewDidLoadTime = ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidUnload() {
        super.viewDidUnload();
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(800, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewWillLoad() {
        super.viewWillLoad();
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(200, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewWillUnload() {
        super.viewWillUnload();
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            reportChain.append(new Node(700, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public void created() {
        super.created();
        this.createTime = ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
        try {
            LaunchTimestamps launchTimestamps = QQPerformance.INSTANCE.getLaunchTimestamps();
            this.launchTimestamps = launchTimestamps;
            Intrinsics.checkNotNull(launchTimestamps);
            long j3 = launchTimestamps.fetchContextEnd;
            LaunchTimestamps launchTimestamps2 = this.launchTimestamps;
            Intrinsics.checkNotNull(launchTimestamps2);
            long j16 = j3 - launchTimestamps2.openPage;
            QQAegis qQAegis = QQAegis.INSTANCE;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.aegiskmm.plugin.a());
            if (j16 > 30000) {
                j16 = 30000;
            }
            arrayList.add(new com.tencent.aegiskmm.plugin.b(Long.valueOf(j16)));
            Unit unit = Unit.INSTANCE;
            AegisConfig aegisConfig = new AegisConfig("46046004c6", "0f446e86-05c4-4889-953c-ea813ec46cb2", null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, 0, false, arrayList, false, null, null, null, null, null, null, null, null, 1072693244, null);
            a aVar = a.f61726d;
            aVar.e(true);
            AegisConfig aegisConfig2 = QQAegis.extendConfig;
            aegisConfig2.b(aegisConfig);
            aVar.d(aegisConfig2);
        } catch (Exception unused) {
            KLog.INSTANCE.e(getPageName(), "initBugly exception:");
        }
        BuildersKt.e(e.f117232d, null, null, new VasBasePage$vasReport$1(this, this, null), 3, null);
        if (getPagerData().n().p("trace_id").length() > 0) {
            this.pageTrace.getClass();
        } else {
            PageTrace pageTrace = this.pageTrace;
            SessionIdGenerator.INSTANCE.getSessionId();
            pageTrace.getClass();
        }
        VasUIToken vasUIToken = VasUIToken.INSTANCE;
        VasUIToken.isCurrentThemeDark = Boolean.valueOf(this.platformApi.getVasModule().isDarkTheme());
        this.hasQQMcConfig = true ^ Intrinsics.areEqual(getPagerData().n().q(KuiklyLaunchParams.PARAM_QQMC_CONFIG, ""), "");
        this.hasLocalRes = getPageData().n().k("has_local_res", -1);
        IReportChain reportChain = getReportChain();
        if (reportChain != null) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("");
            m3.append(((Boolean) this.isFirstOpenPage$delegate.getValue()).booleanValue());
            ReportChainImpl reportChainImpl = (ReportChainImpl) reportChain;
            reportChainImpl.appendExt(m3.toString());
            reportChainImpl.append(new Node(100, IPagerIdKtxKt.getBridgeModule(this).currentTimeStamp()));
        }
        if (autoChangeStatusBarStyle()) {
            BuildersKt.b(getPageScope(), null, null, new VasBasePage$updateStatusBarStyle$1(this, null), 3, null);
        }
        PagePerfReport pagePerfReport = this._perfReport;
        long longValue = ((Number) pagePerfReport.page.clickTime$delegate.getValue()).longValue();
        String str = TGSplashFileUtil.PRELOAD_CACHE_DIR_COLD;
        if (longValue == 0) {
            if (Intrinsics.areEqual("created", "created")) {
                VasCommonReportProxy newVasCommonReport = pagePerfReport.page.newVasCommonReport("page_perf");
                newVasCommonReport.value1 = "created";
                String pageName = pagePerfReport.page.getPageName();
                if (pageName != null) {
                    newVasCommonReport.value5 = pageName;
                }
                if (!((Boolean) pagePerfReport.page.isFirstOpenPage$delegate.getValue()).booleanValue()) {
                    str = "hot";
                }
                newVasCommonReport.value4 = str;
                newVasCommonReport.report(false);
            }
        } else if (!pagePerfReport.record.contains("created")) {
            pagePerfReport.record.add("created");
            VasCommonReportProxy newVasCommonReport2 = pagePerfReport.page.newVasCommonReport("page_perf");
            newVasCommonReport2.value1 = "created";
            String pageName2 = pagePerfReport.page.getPageName();
            if (pageName2 != null) {
                newVasCommonReport2.value5 = pageName2;
            }
            if (!((Boolean) pagePerfReport.page.isFirstOpenPage$delegate.getValue()).booleanValue()) {
                str = "hot";
            }
            newVasCommonReport2.value4 = str;
            newVasCommonReport2.num1 = ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp() - ((Number) pagePerfReport.page.clickTime$delegate.getValue()).longValue();
            newVasCommonReport2.report(false);
        }
        c cVar = c.f117352a;
        if (PageDataExtKt.isPublic(cVar.g().getPageData())) {
            return;
        }
        VLog companion = VLog.Companion.getInstance();
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u9875\u9762\u53c2\u6570=");
        m16.append(cVar.g().getPageData().n());
        companion.log$enumunboxing$(m16.toString(), 2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x013d A[PHI: r1
  0x013d: PHI (r1v12 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:28:0x013a, B:11:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object httpPost(String str, String str2, com.tencent.kuikly.core.nvi.serialization.json.e eVar, boolean z16, com.tencent.kuikly.core.nvi.serialization.json.e eVar2, Continuation<? super String> continuation) {
        VasBasePage$httpPost$1 vasBasePage$httpPost$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.kuikly.core.nvi.serialization.json.e eVar3;
        VasBasePage vasBasePage;
        String str3;
        boolean z17;
        Object obj;
        com.tencent.kuikly.core.nvi.serialization.json.e eVar4;
        Object userAgent;
        String str4;
        final boolean z18;
        final VasBasePage vasBasePage2;
        com.tencent.kuikly.core.nvi.serialization.json.e eVar5;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof VasBasePage$httpPost$1) {
            vasBasePage$httpPost$1 = (VasBasePage$httpPost$1) continuation;
            int i16 = vasBasePage$httpPost$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                vasBasePage$httpPost$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = vasBasePage$httpPost$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = vasBasePage$httpPost$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    vasBasePage$httpPost$1.L$0 = this;
                    vasBasePage$httpPost$1.L$1 = str;
                    eVar3 = eVar;
                    vasBasePage$httpPost$1.L$2 = eVar3;
                    vasBasePage$httpPost$1.L$3 = eVar2;
                    vasBasePage$httpPost$1.Z$0 = z16;
                    vasBasePage$httpPost$1.label = 1;
                    Object buildCookie = buildCookie(str2, vasBasePage$httpPost$1);
                    if (buildCookie == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    vasBasePage = this;
                    str3 = str;
                    z17 = z16;
                    obj = buildCookie;
                    eVar4 = eVar2;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj2);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z18 = vasBasePage$httpPost$1.Z$0;
                        String str5 = vasBasePage$httpPost$1.L$4;
                        eVar4 = vasBasePage$httpPost$1.L$3;
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar6 = vasBasePage$httpPost$1.L$2;
                        str3 = vasBasePage$httpPost$1.L$1;
                        VasBasePage vasBasePage3 = vasBasePage$httpPost$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        str4 = str5;
                        vasBasePage2 = vasBasePage3;
                        eVar5 = eVar6;
                        String str6 = (String) obj2;
                        vasBasePage$httpPost$1.L$0 = vasBasePage2;
                        vasBasePage$httpPost$1.L$1 = str3;
                        vasBasePage$httpPost$1.L$2 = eVar5;
                        vasBasePage$httpPost$1.L$3 = eVar4;
                        vasBasePage$httpPost$1.L$4 = str4;
                        vasBasePage$httpPost$1.L$5 = str6;
                        vasBasePage$httpPost$1.Z$0 = z18;
                        vasBasePage$httpPost$1.label = 3;
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(vasBasePage$httpPost$1);
                        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                        com.tencent.kuikly.core.nvi.serialization.json.e m3 = eVar4 != null ? AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("Content-Type", "application/json", "User-Agent", str6) : eVar4;
                        String m16 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("httpPost : ", str3);
                        KLog kLog = KLog.INSTANCE;
                        kLog.i(vasBasePage2.getPageName(), m16);
                        if (vasBasePage2.isDebug()) {
                            String str7 = "params=" + eVar5;
                            if (vasBasePage2.isDebug()) {
                                kLog.d(vasBasePage2.getPageName(), str7);
                            }
                        }
                        ((NetworkModule) vasBasePage2.platformApi.networkModule$delegate.getValue()).c(str3, true, eVar5, (r18 & 8) != 0 ? null : m3, (r18 & 16) != 0 ? null : str4, (r18 & 32) != 0 ? 30 : 0, new Function3<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$httpPost$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar7, Boolean bool, String str8) {
                                com.tencent.kuikly.core.nvi.serialization.json.e eVar8 = eVar7;
                                boolean booleanValue = bool.booleanValue();
                                VasBasePage vasBasePage4 = VasBasePage.this;
                                String str9 = "response : success=" + booleanValue + " errorMsg=" + str8;
                                KLog kLog2 = KLog.INSTANCE;
                                kLog2.i(vasBasePage4.getPageName(), str9);
                                if (VasBasePage.this.isDebug()) {
                                    VasBasePage vasBasePage5 = VasBasePage.this;
                                    String eVar9 = eVar8.toString();
                                    if (vasBasePage5.isDebug()) {
                                        kLog2.d(vasBasePage5.getPageName(), eVar9);
                                    }
                                }
                                if (z18) {
                                    if (eVar8.a("response")) {
                                        Continuation<String> continuation2 = safeContinuation;
                                        Result.Companion companion = Result.INSTANCE;
                                        continuation2.resumeWith(Result.m476constructorimpl(eVar8.p("response")));
                                    } else if (eVar8.a("data")) {
                                        Continuation<String> continuation3 = safeContinuation;
                                        Result.Companion companion2 = Result.INSTANCE;
                                        continuation3.resumeWith(Result.m476constructorimpl(eVar8.p("data")));
                                    } else {
                                        kLog2.e(VasBasePage.this.getPageName(), "invalid data");
                                        safeContinuation.resumeWith(Result.m476constructorimpl(""));
                                    }
                                } else {
                                    Continuation<String> continuation4 = safeContinuation;
                                    Result.Companion companion3 = Result.INSTANCE;
                                    continuation4.resumeWith(Result.m476constructorimpl(eVar8.toString()));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        obj2 = safeContinuation.getOrThrow();
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj2 == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(vasBasePage$httpPost$1);
                        }
                        return obj2 != coroutine_suspended ? coroutine_suspended : obj2;
                    }
                    boolean z19 = vasBasePage$httpPost$1.Z$0;
                    eVar4 = vasBasePage$httpPost$1.L$3;
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar7 = vasBasePage$httpPost$1.L$2;
                    str3 = vasBasePage$httpPost$1.L$1;
                    vasBasePage = vasBasePage$httpPost$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = obj2;
                    z17 = z19;
                    eVar3 = eVar7;
                }
                String str8 = (String) obj;
                QQBrowser qQBrowser = QQBrowser.INSTANCE;
                vasBasePage$httpPost$1.L$0 = vasBasePage;
                vasBasePage$httpPost$1.L$1 = str3;
                vasBasePage$httpPost$1.L$2 = eVar3;
                vasBasePage$httpPost$1.L$3 = eVar4;
                vasBasePage$httpPost$1.L$4 = str8;
                vasBasePage$httpPost$1.Z$0 = z17;
                vasBasePage$httpPost$1.label = 2;
                userAgent = qQBrowser.getUserAgent(vasBasePage$httpPost$1);
                if (userAgent != coroutine_suspended) {
                    return coroutine_suspended;
                }
                str4 = str8;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar8 = eVar3;
                z18 = z17;
                obj2 = userAgent;
                vasBasePage2 = vasBasePage;
                eVar5 = eVar8;
                String str62 = (String) obj2;
                vasBasePage$httpPost$1.L$0 = vasBasePage2;
                vasBasePage$httpPost$1.L$1 = str3;
                vasBasePage$httpPost$1.L$2 = eVar5;
                vasBasePage$httpPost$1.L$3 = eVar4;
                vasBasePage$httpPost$1.L$4 = str4;
                vasBasePage$httpPost$1.L$5 = str62;
                vasBasePage$httpPost$1.Z$0 = z18;
                vasBasePage$httpPost$1.label = 3;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(vasBasePage$httpPost$1);
                final Continuation<? super String> safeContinuation2 = new SafeContinuation(intercepted);
                if (eVar4 != null) {
                }
                String m162 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("httpPost : ", str3);
                KLog kLog2 = KLog.INSTANCE;
                kLog2.i(vasBasePage2.getPageName(), m162);
                if (vasBasePage2.isDebug()) {
                }
                ((NetworkModule) vasBasePage2.platformApi.networkModule$delegate.getValue()).c(str3, true, eVar5, (r18 & 8) != 0 ? null : m3, (r18 & 16) != 0 ? null : str4, (r18 & 32) != 0 ? 30 : 0, new Function3<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$httpPost$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar72, Boolean bool, String str82) {
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar82 = eVar72;
                        boolean booleanValue = bool.booleanValue();
                        VasBasePage vasBasePage4 = VasBasePage.this;
                        String str9 = "response : success=" + booleanValue + " errorMsg=" + str82;
                        KLog kLog22 = KLog.INSTANCE;
                        kLog22.i(vasBasePage4.getPageName(), str9);
                        if (VasBasePage.this.isDebug()) {
                            VasBasePage vasBasePage5 = VasBasePage.this;
                            String eVar9 = eVar82.toString();
                            if (vasBasePage5.isDebug()) {
                                kLog22.d(vasBasePage5.getPageName(), eVar9);
                            }
                        }
                        if (z18) {
                            if (eVar82.a("response")) {
                                Continuation<String> continuation2 = safeContinuation2;
                                Result.Companion companion = Result.INSTANCE;
                                continuation2.resumeWith(Result.m476constructorimpl(eVar82.p("response")));
                            } else if (eVar82.a("data")) {
                                Continuation<String> continuation3 = safeContinuation2;
                                Result.Companion companion2 = Result.INSTANCE;
                                continuation3.resumeWith(Result.m476constructorimpl(eVar82.p("data")));
                            } else {
                                kLog22.e(VasBasePage.this.getPageName(), "invalid data");
                                safeContinuation2.resumeWith(Result.m476constructorimpl(""));
                            }
                        } else {
                            Continuation<String> continuation4 = safeContinuation2;
                            Result.Companion companion3 = Result.INSTANCE;
                            continuation4.resumeWith(Result.m476constructorimpl(eVar82.toString()));
                        }
                        return Unit.INSTANCE;
                    }
                });
                obj2 = safeContinuation2.getOrThrow();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj2 == coroutine_suspended2) {
                }
                if (obj2 != coroutine_suspended) {
                }
            }
        }
        vasBasePage$httpPost$1 = new VasBasePage$httpPost$1(this, continuation);
        Object obj22 = vasBasePage$httpPost$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasBasePage$httpPost$1.label;
        if (i3 != 0) {
        }
        String str82 = (String) obj;
        QQBrowser qQBrowser2 = QQBrowser.INSTANCE;
        vasBasePage$httpPost$1.L$0 = vasBasePage;
        vasBasePage$httpPost$1.L$1 = str3;
        vasBasePage$httpPost$1.L$2 = eVar3;
        vasBasePage$httpPost$1.L$3 = eVar4;
        vasBasePage$httpPost$1.L$4 = str82;
        vasBasePage$httpPost$1.Z$0 = z17;
        vasBasePage$httpPost$1.label = 2;
        userAgent = qQBrowser2.getUserAgent(vasBasePage$httpPost$1);
        if (userAgent != coroutine_suspended) {
        }
    }
}
