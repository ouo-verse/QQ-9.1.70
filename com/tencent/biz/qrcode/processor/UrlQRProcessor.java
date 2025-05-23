package com.tencent.biz.qrcode.processor;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor;
import com.tencent.biz.qrcode.processor.UrlQRProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.qrscan.m;
import com.tencent.mobileqq.qrscan.o;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.fc;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class UrlQRProcessor extends BaseQRScanResultProcessor {

    /* renamed from: c, reason: collision with root package name */
    public static String f94996c = "addDisSource";

    /* renamed from: d, reason: collision with root package name */
    public static int f94997d = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QQAppInterface> f94998a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<k> f94999b;

        /* renamed from: c, reason: collision with root package name */
        private final ScannerParams f95000c;

        /* renamed from: d, reason: collision with root package name */
        private final String f95001d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f95002e = false;

        /* renamed from: f, reason: collision with root package name */
        private f f95003f = null;

        /* renamed from: g, reason: collision with root package name */
        private e f95004g = null;

        /* renamed from: h, reason: collision with root package name */
        private final o f95005h = new C0950a();

        /* renamed from: i, reason: collision with root package name */
        private final MiniAppCmdInterface f95006i = new b();

        /* renamed from: com.tencent.biz.qrcode.processor.UrlQRProcessor$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0950a extends o {
            C0950a() {
            }

            @Override // com.tencent.mobileqq.qrscan.o, mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                super.onReceive(i3, z16, bundle);
                a.this.f95003f = new f(i3, z16, bundle);
                a.this.i();
            }
        }

        /* loaded from: classes5.dex */
        class b implements MiniAppCmdInterface {
            b() {
            }

            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                a.this.f95004g = new e(z16, jSONObject);
                a.this.i();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class c extends BaseQRScanResultProcessor.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ k f95009d;

            c(k kVar) {
                this.f95009d = kVar;
            }

            @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor.a
            public void a() {
                this.f95009d.a(false);
                this.f95009d.finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class d implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f95011d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Activity f95012e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ k f95013f;

            d(String str, Activity activity, k kVar) {
                this.f95011d = str;
                this.f95012e = activity;
                this.f95013f = kVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                String str;
                String lowerCase = this.f95011d.toLowerCase();
                if (lowerCase.startsWith("www.")) {
                    str = "http://" + this.f95011d;
                } else if (lowerCase.startsWith("https:")) {
                    str = "https" + this.f95011d.substring(5);
                } else if (lowerCase.startsWith("http:")) {
                    str = "http" + this.f95011d.substring(4);
                } else {
                    str = this.f95011d;
                }
                Intent intent = new Intent(this.f95012e, (Class<?>) QQBrowserDelegationActivity.class);
                intent.putExtra("url", str);
                intent.putExtra("param_force_internal_browser", true);
                intent.putExtra("key_isReadModeEnabled", true);
                intent.putExtra("fromQrcode", true);
                intent.putExtra("injectrecommend", false);
                intent.putExtra("big_brother_source_key", "biz_src_jc_sacan_qr");
                this.f95012e.startActivity(intent);
                this.f95013f.finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static class e {

            /* renamed from: a, reason: collision with root package name */
            boolean f95015a;

            /* renamed from: b, reason: collision with root package name */
            JSONObject f95016b;

            public e(boolean z16, JSONObject jSONObject) {
                this.f95015a = z16;
                this.f95016b = jSONObject;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static class f {

            /* renamed from: a, reason: collision with root package name */
            int f95017a;

            /* renamed from: b, reason: collision with root package name */
            boolean f95018b;

            /* renamed from: c, reason: collision with root package name */
            Bundle f95019c;

            public f(int i3, boolean z16, Bundle bundle) {
                this.f95017a = i3;
                this.f95018b = z16;
                this.f95019c = bundle;
            }
        }

        public a(QQAppInterface qQAppInterface, ScannerParams scannerParams, String str, k kVar) {
            this.f94998a = new WeakReference<>(qQAppInterface);
            this.f94999b = new WeakReference<>(kVar);
            this.f95000c = scannerParams;
            this.f95001d = str;
        }

        private int e() {
            ScannerParams scannerParams = this.f95000c;
            if (scannerParams != null && scannerParams.f276518i) {
                return 1012;
            }
            return 1011;
        }

        @Nullable
        private INTERFACE$StApiAppInfo h() {
            JSONObject jSONObject;
            e eVar = this.f95004g;
            if (eVar != null && (jSONObject = eVar.f95016b) != null) {
                boolean z16 = eVar.f95015a;
                long optLong = jSONObject.optLong("retCode");
                String optString = jSONObject.optString("errMsg");
                if (z16 && optLong == 0) {
                    byte[] bArr = (byte[]) jSONObject.opt("appInfo_pb");
                    if (bArr != null && bArr.length != 0) {
                        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
                        try {
                            iNTERFACE$StApiAppInfo.mergeFrom(bArr);
                            if (!TextUtils.isEmpty(iNTERFACE$StApiAppInfo.appId.get())) {
                                return iNTERFACE$StApiAppInfo;
                            }
                        } catch (InvalidProtocolBufferMicroException e16) {
                            QLog.e("IQRScanConst_BaseQRScanResultProcessor", 2, "handleMiniAppReqResult: pb error", e16);
                        }
                    }
                    return null;
                }
                QLog.e("IQRScanConst_BaseQRScanResultProcessor", 2, "getMiniAppInfo, retCode=" + optLong + ",errMsg = " + optString);
                return null;
            }
            QLog.e("IQRScanConst_BaseQRScanResultProcessor", 2, "mMiniAppReqResult or jsonObject is null!");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i() {
            k kVar = this.f94999b.get();
            QQAppInterface qQAppInterface = this.f94998a.get();
            if (kVar != null && qQAppInterface != null && this.f95000c != null) {
                AppActivity appActivity = (AppActivity) kVar.getContext();
                if (!appActivity.isDestroyed() && !appActivity.isFinishing() && this.f95003f != null) {
                    boolean z16 = this.f95002e;
                    if (!z16 || this.f95004g != null) {
                        if (z16 && j(appActivity, kVar)) {
                            return;
                        }
                        l(qQAppInterface, appActivity, kVar);
                    }
                }
            }
        }

        private boolean j(Activity activity, k kVar) {
            INTERFACE$StApiAppInfo h16;
            f fVar = this.f95003f;
            if (fVar == null || !fVar.f95018b || fVar.f95019c == null || (h16 = h()) == null) {
                return false;
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppByApiAppInfo(activity, h16, e());
            kVar.finish();
            return true;
        }

        private void k(final String str, final int i3, final String str2) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).requestWxMiniAppInfo(e(), this.f95001d, 19, new db3.a() { // from class: com.tencent.biz.qrcode.processor.f
                @Override // db3.a
                public final void a(boolean z16, com.tencent.mobileqq.wxmini.api.data.e eVar) {
                    UrlQRProcessor.a.this.m(str, i3, str2, z16, eVar);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1, types: [int] */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v7 */
        private void l(QQAppInterface qQAppInterface, Activity activity, k kVar) {
            String queryParameter;
            boolean z16;
            ?? r142;
            JSONObject jSONObject;
            String str = "a_a";
            String str2 = this.f95001d;
            Uri parse = Uri.parse(str2);
            if (parse == null) {
                queryParameter = null;
            } else {
                queryParameter = parse.getQueryParameter("authKey");
            }
            String str3 = null;
            if (QLog.isColorLevel()) {
                QLog.i("IQRScanConst_BaseQRScanResultProcessor", 2, String.format("JumpUrl requestUrlDecode authSig=%s url=%s", queryParameter, str2));
            }
            f fVar = this.f95003f;
            boolean z17 = fVar.f95018b;
            Bundle bundle = fVar.f95019c;
            if (z17 && bundle != null) {
                String string = bundle.getString("result");
                try {
                    jSONObject = new JSONObject(string);
                } catch (Exception e16) {
                    e = e16;
                }
                if (!jSONObject.isNull("r") && jSONObject.optInt("r") == 0) {
                    try {
                        if (jSONObject.has("d")) {
                            try {
                                if (!jSONObject.isNull("d")) {
                                    m mVar = new m(jSONObject.optString("d"));
                                    Bundle bundle2 = new Bundle();
                                    com.tencent.biz.qrcode.util.g.c(bundle2, jSONObject);
                                    com.tencent.biz.qrcode.util.g.a(bundle2, mVar.f276675c, jSONObject, queryParameter);
                                    if (jSONObject.has("url") && !jSONObject.isNull("url")) {
                                        parse = Uri.parse(jSONObject.optString("url"));
                                    }
                                    if (parse != null) {
                                        com.tencent.biz.qrcode.util.g.d(bundle2, parse);
                                        com.tencent.biz.qrcode.util.g.b(bundle2, parse);
                                    }
                                    UrlQRProcessor.n(((IQRJumpApi) QRoute.api(IQRJumpApi.class)).handleResult(qQAppInterface, activity, mVar, string, bundle2), string, activity, qQAppInterface);
                                    kVar.finish();
                                    return;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str3 = null;
                                QLog.e("IQRScanConst_BaseQRScanResultProcessor", 1, "handle url error: " + e.getMessage());
                                r142 = str3;
                                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
                                createCustomDialog.setTitle(R.string.g2p);
                                createCustomDialog.setMessage(str2);
                                c cVar = new c(kVar);
                                createCustomDialog.setPositiveButton(R.string.f171151ok, new d(str2, activity, kVar));
                                createCustomDialog.setNegativeButton(R.string.cancel, cVar);
                                createCustomDialog.setOnCancelListener(cVar);
                                createCustomDialog.show();
                                UrlQRProcessor.n(r142, str2, activity, qQAppInterface);
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                    try {
                        if (jSONObject.has("a_a") && !jSONObject.isNull("a_a")) {
                            ax c16 = bi.c(qQAppInterface, activity, jSONObject.optString("a_a"));
                            if (c16 != null) {
                                c16.b();
                                return;
                            }
                        } else if (jSONObject.has("url") && !jSONObject.isNull("url")) {
                            int optInt = jSONObject.optInt("url_level");
                            String optString = jSONObject.optString("url");
                            if (!TextUtils.isEmpty(optString)) {
                                if (optInt == 2) {
                                    str2 = Uri.parse(optString).toString();
                                } else {
                                    str2 = optString;
                                }
                            } else {
                                optInt = 0;
                            }
                            if (optInt == 1 || optInt == 2) {
                                k(str2, 0, string);
                                return;
                            }
                        }
                        z16 = false;
                        r142 = z16;
                    } catch (Exception e19) {
                        e = e19;
                        str = null;
                        str3 = str;
                        QLog.e("IQRScanConst_BaseQRScanResultProcessor", 1, "handle url error: " + e.getMessage());
                        r142 = str3;
                        QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(activity, 230);
                        createCustomDialog2.setTitle(R.string.g2p);
                        createCustomDialog2.setMessage(str2);
                        c cVar2 = new c(kVar);
                        createCustomDialog2.setPositiveButton(R.string.f171151ok, new d(str2, activity, kVar));
                        createCustomDialog2.setNegativeButton(R.string.cancel, cVar2);
                        createCustomDialog2.setOnCancelListener(cVar2);
                        createCustomDialog2.show();
                        UrlQRProcessor.n(r142, str2, activity, qQAppInterface);
                    }
                    QQCustomDialog createCustomDialog22 = DialogUtil.createCustomDialog(activity, 230);
                    createCustomDialog22.setTitle(R.string.g2p);
                    createCustomDialog22.setMessage(str2);
                    c cVar22 = new c(kVar);
                    createCustomDialog22.setPositiveButton(R.string.f171151ok, new d(str2, activity, kVar));
                    createCustomDialog22.setNegativeButton(R.string.cancel, cVar22);
                    createCustomDialog22.setOnCancelListener(cVar22);
                    createCustomDialog22.show();
                    UrlQRProcessor.n(r142, str2, activity, qQAppInterface);
                }
            }
            z16 = false;
            r142 = z16;
            QQCustomDialog createCustomDialog222 = DialogUtil.createCustomDialog(activity, 230);
            createCustomDialog222.setTitle(R.string.g2p);
            createCustomDialog222.setMessage(str2);
            c cVar222 = new c(kVar);
            createCustomDialog222.setPositiveButton(R.string.f171151ok, new d(str2, activity, kVar));
            createCustomDialog222.setNegativeButton(R.string.cancel, cVar222);
            createCustomDialog222.setOnCancelListener(cVar222);
            createCustomDialog222.show();
            UrlQRProcessor.n(r142, str2, activity, qQAppInterface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i3, String str2, boolean z16, com.tencent.mobileqq.wxmini.api.data.e eVar) {
            AppActivity appActivity;
            k kVar = this.f94999b.get();
            QQAppInterface qQAppInterface = this.f94998a.get();
            if (kVar != null && qQAppInterface != null && (appActivity = (AppActivity) kVar.getContext()) != null && !appActivity.isDestroyed() && !appActivity.isFinishing()) {
                if (z16 && eVar != null) {
                    ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniApp(appActivity, eVar, e());
                    if (eVar.f327614b) {
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).setWxAppUrl(19, this.f95001d, eVar.f327613a);
                    }
                } else {
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(appActivity, IPublicAccountBrowser.ROUTE_NAME);
                    activityURIRequest.extra().putBoolean("key_isReadModeEnabled", true);
                    activityURIRequest.extra().putBoolean("fromQrcode", true);
                    activityURIRequest.extra().putString("url", str);
                    activityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_sacan_qr");
                    QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
                }
                UrlQRProcessor.n(i3, str2, appActivity, qQAppInterface);
                kVar.finish();
            }
        }

        @NonNull
        public MiniAppCmdInterface f() {
            return this.f95006i;
        }

        @NonNull
        public o g() {
            return this.f95005h;
        }

        public void n(boolean z16) {
            this.f95002e = z16;
        }
    }

    public UrlQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    public static void n(int i3, String str, Activity activity, QQAppInterface qQAppInterface) {
        String str2;
        if (i3 == 1) {
            str2 = "ConsumerQRcard";
        } else if (i3 == 2) {
            str2 = "GroupQRcard";
        } else {
            if (i3 == 3) {
                return;
            }
            if (com.tencent.biz.qrcode.util.h.K(str)) {
                StatisticCollector.getInstance(activity.getApplicationContext()).reportButtonClick(qQAppInterface, "", "TPQRcardurl", 1);
            } else {
                StatisticCollector.getInstance(activity.getApplicationContext()).reportButtonClick(qQAppInterface, "", "TPQRcardtext", 1);
                if (com.tencent.biz.qrcode.util.h.C(str)) {
                    StatisticCollector.getInstance(activity.getApplicationContext()).reportButtonClick(qQAppInterface, "", "TPQRcardphone", 1);
                }
            }
            str2 = "ThirdpartyQRcard";
        }
        StatisticCollector.getInstance(activity.getApplicationContext()).reportButtonClick(qQAppInterface, "", str2, 1);
    }

    private void o(String str, a aVar) {
        boolean isNetworkUrl = URLUtil.isNetworkUrl(str);
        aVar.n(isNetworkUrl);
        if (isNetworkUrl) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).getAppInfoByLink(str, 3, aVar.f());
        }
    }

    private void p(QQAppInterface qQAppInterface, String str, JSONObject jSONObject, a aVar) {
        ((IQRDataApi) QRoute.api(IQRDataApi.class)).requestUrlDecode(qQAppInterface, str, jSONObject, null, aVar.g());
        if (!TextUtils.isEmpty(str) && str.contains("://aq.qq.com")) {
            qQAppInterface.sendWirelessPswReq(3);
        }
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        String lowerCase = str.toLowerCase();
        if (m(i3) && com.tencent.biz.qrcode.util.h.J(lowerCase)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return super.g();
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "UrlQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        ax c16;
        AppRuntime appRuntime = this.f94979a;
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        AppActivity appActivity = (AppActivity) this.f94980b.getContext();
        String lowerCase = str.toLowerCase();
        if (!com.tencent.biz.qrcode.util.h.J(lowerCase)) {
            return false;
        }
        if (com.tencent.biz.qrcode.util.h.A(lowerCase)) {
            Intent intent = new Intent(appActivity, (Class<?>) JoinDiscussionActivity.class);
            intent.putExtra("innerSig", str);
            intent.putExtra(f94996c, f94997d);
            this.f94980b.finish();
            return true;
        }
        if (fc.b(str)) {
            fc.c(qQAppInterface, appActivity, str);
            return true;
        }
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isGuildShareUrl(str)) {
            GuildShareUrlParam guildShareUrlParam = new GuildShareUrlParam(str);
            if (appActivity.getIntent() != null) {
                String stringExtra = appActivity.getIntent().getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
                String stringExtra2 = appActivity.getIntent().getStringExtra("friendUin");
                guildShareUrlParam.a().putString(AppConstants.Key.COLUMN_MSG_SENDER_UIN, stringExtra);
                guildShareUrlParam.a().putString("friendUin", stringExtra2);
                if (appActivity.getIntent().hasExtra("o3_scan_pic_data")) {
                    guildShareUrlParam.a().putParcelable("o3_scan_pic_data", appActivity.getIntent().getParcelableExtra("o3_scan_pic_data"));
                }
                guildShareUrlParam.a().putInt(IProfileCardConst.KEY_FROM_TYPE, scannerParams.D);
            }
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuild(appActivity, guildShareUrlParam);
            this.f94980b.finish();
            return true;
        }
        if (((IFeatureRuntimeService) qQAppInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("enable_open_schema_in_h5_directly") && com.tencent.biz.qrcode.util.h.G(str)) {
            String str3 = com.tencent.util.URLUtil.getArgumentsFromURL(str).get("url");
            if (com.tencent.biz.qrcode.util.h.H(str3) && (c16 = bi.c(qQAppInterface, appActivity, str3)) != null) {
                c16.b();
                this.f94980b.finish();
                return true;
            }
        }
        this.f94980b.a(true);
        a aVar = new a(qQAppInterface, scannerParams, str, this.f94980b);
        o(str, aVar);
        p(qQAppInterface, str, this.f94980b.b(), aVar);
        com.tencent.mobileqq.webview.b.f313815d = 2;
        return true;
    }
}
