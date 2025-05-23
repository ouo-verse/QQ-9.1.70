package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.tmassistantbase.util.OuterCallLog;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadApi {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f341146a = "com.tencent.open.downloadnew.DownloadApi";

    /* renamed from: b, reason: collision with root package name */
    public static Object f341147b = new Object();

    /* renamed from: c, reason: collision with root package name */
    protected static ConcurrentHashMap<String, Integer> f341148c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    protected static ITMAssistantExchangeURLListenner f341149d = new c();

    /* compiled from: P */
    /* renamed from: com.tencent.open.downloadnew.DownloadApi$9, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadManager.C().R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f341172d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f341173e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ApkUpdateDetail f341174f;

        a(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail) {
            this.f341172d = bundle;
            this.f341173e = str;
            this.f341174f = apkUpdateDetail;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DownloadApi.f(this.f341172d, this.f341173e, this.f341174f);
            ReportController.o(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
            np3.a.g().j(25, (System.currentTimeMillis() / 1000) + "|101|" + (this.f341172d.getString(e.f341497f) + "_" + this.f341172d.getString(e.f341494c) + "_" + this.f341172d.getString(e.f341495d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f341175d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f341176e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ApkUpdateDetail f341177f;

        b(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail) {
            this.f341175d = bundle;
            this.f341176e = str;
            this.f341177f = apkUpdateDetail;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DownloadApi.f(this.f341175d, this.f341176e, this.f341177f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c implements ITMAssistantExchangeURLListenner {
        c() {
        }

        @Override // com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner
        public void onExchangedURLSucceed(ArrayList arrayList, boolean z16) {
            AppSimpleDetail appSimpleDetail;
            int i3;
            com.tencent.open.base.f.e(DownloadApi.f341146a, "onExchangedURLSucceed --- ");
            if (z16 && arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof AppSimpleDetail) && (i3 = (appSimpleDetail = (AppSimpleDetail) next).versionCode) > 0) {
                        DownloadApi.f341148c.put(appSimpleDetail.packageName, Integer.valueOf(i3));
                    }
                }
            }
            synchronized (DownloadApi.f341147b) {
                DownloadApi.f341147b.notify();
            }
        }
    }

    public static void a(final String str, final String str2, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.7
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.C().g(str, str2, z16);
            }
        }, 32, null, true);
    }

    public static void b(final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.10
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.C().i(str);
            }
        });
    }

    public static void c(final String str, final String str2, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.8
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.C().q(str, str2, z16);
            }
        }, 32, null, true);
    }

    public static void d(final Activity activity, final Bundle bundle, final String str, final ApkUpdateDetail apkUpdateDetail, final int i3) {
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(com.tencent.open.adapter.a.f().e()) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadAction, System.currentTimeMillis());
        }
        if (str == "biz_src_jc_update") {
            com.tencent.open.business.base.e.h("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", bundle.getString(e.K));
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 1; i16 < stackTrace.length; i16++) {
            sb5.append(stackTrace[i16].toString());
        }
        String string = bundle.getString(e.f341493b);
        String string2 = bundle.getString(e.f341501j);
        if (!TextUtils.isEmpty(string)) {
            DownloadInfoReport.f340780a.put(string, sb5.toString());
        } else if (!TextUtils.isEmpty(string2)) {
            DownloadInfoReport.f340780a.put(string2, sb5.toString());
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                boolean z17;
                String str2 = DownloadApi.f341146a;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("doDownloadAction pParams=");
                sb6.append(bundle);
                sb6.append(" source=");
                sb6.append(str);
                sb6.append(" myAppConfig=");
                sb6.append(i3);
                sb6.append(" ac==null is");
                boolean z18 = false;
                if (activity == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb6.append(z16);
                com.tencent.open.base.f.h(str2, sb6.toString());
                if (bundle == null) {
                    com.tencent.open.base.f.c(str2, "doDownloadAction pParams == null return");
                    return;
                }
                DownloadManager.C().l();
                String string3 = bundle.getString(e.f341493b);
                bundle.putString(e.f341511t, str);
                bundle.putInt(e.G, 1);
                String string4 = bundle.getString(e.D);
                String string5 = bundle.getString(e.f341500i);
                if (TextUtils.isEmpty(string4) || string4.equals("0")) {
                    bundle.putString(e.D, "");
                }
                DownloadInfo w3 = DownloadManager.C().w(string3);
                if (w3 == null && "biz_src_yyb".equals(str) && d.u()) {
                    int i17 = bundle.getInt(e.f341502k);
                    String string6 = bundle.getString(e.f341497f);
                    if (i17 == 5 && string6.equals(SDKConst.SELF_PACKAGENAME)) {
                        DownloadApi.k(bundle);
                        return;
                    }
                } else if (w3 != null && !TextUtils.isEmpty(string5)) {
                    w3.C = string5;
                }
                if (DownloadApi.k(bundle)) {
                    com.tencent.open.base.f.h(str2, "doDownloadAction installApp");
                    return;
                }
                ApkUpdateDetail apkUpdateDetail2 = apkUpdateDetail;
                if (apkUpdateDetail2 != null && apkUpdateDetail2.updatemethod == 2 && TextUtils.isEmpty(bundle.getString(e.f341501j)) && !TextUtils.isEmpty(apkUpdateDetail.url)) {
                    bundle.putString(e.f341501j, apkUpdateDetail.url);
                }
                int i18 = i3;
                if (i18 == 0) {
                    if (w3 != null && w3.J == 1) {
                        DownloadApi.e(activity, bundle, str, apkUpdateDetail, i18);
                        return;
                    }
                    boolean a16 = com.tencent.open.base.a.a(com.tencent.open.adapter.a.f().e());
                    boolean k3 = com.tencent.open.base.a.k(com.tencent.open.adapter.a.f().e());
                    if (w3 != null && w3.f() != 1) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (activity == null) {
                        z18 = true;
                    }
                    com.tencent.open.base.f.h(str2, "check wifi dialog isWifiActive=" + k3 + " isFirstDownload=" + z17 + " acIsNull=" + z18);
                    if (a16 && !z18 && !k3 && z17 && bundle.getBoolean(e.f341510s)) {
                        DownloadManager.C().p(activity, bundle, str, apkUpdateDetail, i3);
                        return;
                    } else {
                        DownloadApi.f(bundle, str, apkUpdateDetail);
                        return;
                    }
                }
                if (w3 != null && w3.J != 1) {
                    DownloadApi.f(bundle, str, apkUpdateDetail);
                } else {
                    DownloadApi.e(activity, bundle, str, apkUpdateDetail, i18);
                }
            }
        });
    }

    protected static void e(Activity activity, Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail, int i3) {
        com.tencent.open.base.f.h(f341146a, "doDownloadActionByMyApp pParmas =" + bundle + " myAppConfig = " + i3);
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(activity) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadActionByMyApp, System.currentTimeMillis());
        }
        if ("biz_src_jc_update".equals(str)) {
            com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", bundle.getString(e.K));
        }
        if (bundle.getInt(e.f341496e, -10) < 0) {
            TMAssistantGetAppDetailTool tMAssistantGetAppDetailTool = TMAssistantGetAppDetailTool.getInstance(f341149d, com.tencent.open.adapter.a.f().e());
            String string = bundle.getString(e.f341497f);
            String string2 = bundle.getString(e.D);
            if (!TextUtils.isEmpty(string)) {
                StringBuilder sb5 = new StringBuilder(string);
                if (!TextUtils.isEmpty(string2)) {
                    sb5.append(";");
                    sb5.append(string2);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(sb5.toString());
                tMAssistantGetAppDetailTool.exchangeUrlsFromPackageNames(arrayList);
                synchronized (f341147b) {
                    try {
                        f341147b.wait(5000L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = f341148c;
                if (concurrentHashMap != null) {
                    Integer remove = concurrentHashMap.remove(string);
                    if (remove == null) {
                        DownloadManager.C().c0(com.tencent.open.adapter.a.f().e().getString(R.string.cob));
                        return;
                    }
                    bundle.putInt(e.f341496e, remove.intValue());
                }
            }
        }
        if (apkUpdateDetail != null) {
            bundle.putInt(e.f341512u, apkUpdateDetail.patchsize);
            bundle.putInt(e.f341513v, apkUpdateDetail.newapksize);
        }
        if (i3 == 1) {
            bundle.putString("source", str);
            MyAppApi.z().D(activity, bundle, new a(bundle, str, apkUpdateDetail));
        } else if (i3 == 2 || i3 == 0) {
            MyAppApi.z().E(activity, bundle, new b(bundle, str, apkUpdateDetail));
        }
    }

    public static int f(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail) {
        String str2;
        int i3;
        int i16;
        int i17;
        if ("biz_src_jc_update".equals(str)) {
            com.tencent.open.business.base.e.h("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", bundle.getString(e.K));
        }
        String str3 = f341146a;
        com.tencent.open.base.f.h(str3, "doDownloadActionBySDK pParmas =" + bundle);
        String string = bundle.getString(e.f341493b);
        String string2 = bundle.getString(e.f341501j);
        String string3 = bundle.getString(e.f341497f);
        int i18 = bundle.getInt(e.f341502k);
        String string4 = bundle.getString(e.f341500i);
        String string5 = bundle.getString(e.f341503l);
        bundle.getString(e.f341504m);
        String string6 = bundle.getString(e.F);
        int i19 = bundle.getInt(e.J);
        String string7 = bundle.getString(e.K);
        boolean z16 = bundle.getBoolean(e.f341506o);
        boolean z17 = bundle.getBoolean(e.f341516y, true);
        boolean z18 = bundle.getBoolean(e.f341499h, true);
        boolean z19 = bundle.getBoolean(e.f341515x);
        int i26 = bundle.getInt(e.E, 0);
        boolean z26 = bundle.getBoolean(e.L, false);
        String string8 = bundle.getString("big_brother_source_key");
        boolean z27 = bundle.getBoolean(e.A, false);
        if (TextUtils.isEmpty(str)) {
            str2 = string8;
        } else {
            str2 = str;
        }
        if (QLog.isColorLevel()) {
            QLog.d(str3, 2, "[UniteDownload] jsapi doDownloadActionBySDK: invoked. ", " sourceFromJsApi: ", string8, " source: ", str2, " isUniteDownload: ", Boolean.valueOf(z27));
        }
        String string9 = bundle.getString(LaunchParam.KEY_REF_ID, "");
        String str4 = bundle.getInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, 0) + "";
        if (i18 != 2) {
            if (i18 != 3) {
                if (i18 != 5) {
                    if (i18 != 10) {
                        if (i18 != 12) {
                            if (i18 == 14) {
                                DownloadManager.C().q(string, null, true);
                            }
                            return 0;
                        }
                        i16 = 0;
                        DownloadInfo downloadInfo = new DownloadInfo(string, string2.trim(), string3, string5, string4, null, str2, z17);
                        downloadInfo.S = i18;
                        downloadInfo.T = z18;
                        downloadInfo.U = z19;
                        downloadInfo.K = 0;
                        downloadInfo.f341203s0 = z27;
                        int i27 = bundle.getInt(e.f341496e);
                        downloadInfo.I = i27;
                        downloadInfo.f341181c0 = string7;
                        if (apkUpdateDetail != null && i27 != (i17 = apkUpdateDetail.versioncode) && i17 != 0) {
                            downloadInfo.I = i17;
                        }
                        downloadInfo.j(LaunchParam.KEY_REF_ID, string9);
                        downloadInfo.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, str4);
                        boolean h16 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_QQ_Patch_Switch");
                        if (!z16) {
                            r(downloadInfo, z27);
                        } else if (h16) {
                            DownloadManager.C().f0(downloadInfo, apkUpdateDetail);
                        } else {
                            r(downloadInfo, z27);
                        }
                        com.tencent.open.base.f.a(str3, "doDownloadAction action == Downloader.ACTION_UPDATE " + z16);
                    } else {
                        i16 = 0;
                        DownloadManager.C().g(string, null, true);
                    }
                } else {
                    i16 = 0;
                    if (z17) {
                        com.tencent.open.business.base.e.h("305", string4, string, string7);
                        DownloadInfo w3 = DownloadManager.C().w(string);
                        if (w3 == null) {
                            w3 = new DownloadInfo();
                            w3.f341184e = string;
                            w3.f341186f = string2.trim();
                            w3.f341189h = string3;
                            w3.f341191i = string5;
                            w3.C = string4;
                            w3.G = bundle.getString(e.f341494c);
                            w3.H = bundle.getString(e.f341495d);
                            w3.I = bundle.getInt(e.f341496e);
                            w3.X = bundle.getBoolean(e.f341516y, true);
                            w3.W = i26;
                            w3.Y = string6;
                            w3.K = 0;
                            w3.f341181c0 = string7;
                        }
                        w3.j(LaunchParam.KEY_REF_ID, string9);
                        w3.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, str4);
                        DownloadManager.C().I(w3);
                    }
                }
                return i16;
            }
            return DownloadManager.C().Q(string);
        }
        DownloadInfo downloadInfo2 = new DownloadInfo(string, string2.trim(), string3, string5, string4, null, str2, z17);
        downloadInfo2.S = i18;
        if (z17) {
            downloadInfo2.T = z18;
            downloadInfo2.U = z19;
            i3 = 0;
        } else {
            i3 = 0;
            downloadInfo2.T = false;
            downloadInfo2.U = true;
            downloadInfo2.E = 2;
        }
        downloadInfo2.W = i26;
        downloadInfo2.Y = string6;
        downloadInfo2.Z = i19;
        downloadInfo2.f341181c0 = string7;
        downloadInfo2.f341183d0 = z26;
        downloadInfo2.K = i3;
        downloadInfo2.f341203s0 = z27;
        try {
            downloadInfo2.I = bundle.getInt(e.f341496e);
            downloadInfo2.f341187f0 = bundle.getLong(e.I);
        } catch (NumberFormatException unused) {
        }
        com.tencent.open.base.f.a(f341146a, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        downloadInfo2.j(LaunchParam.KEY_REF_ID, string9);
        downloadInfo2.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, str4);
        r(downloadInfo2, z27);
        return 0;
    }

    public static void g(final List<DownloadInfo> list, final f fVar) {
        if (list == null) {
            com.tencent.open.base.f.h(f341146a, "getQueryDownloadAction infos == null");
            return;
        }
        if (fVar == null) {
            com.tencent.open.base.f.h(f341146a, "getQueryDownloadAction listener == null");
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.5
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.open.base.f.h(DownloadApi.f341146a, "getQueryDownloadAction enter");
                DownloadManager.C().l();
                try {
                    ArrayList arrayList = new ArrayList();
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        DownloadInfo downloadInfo = (DownloadInfo) list.get(i3);
                        if (DownloadManager.C().W(downloadInfo)) {
                            com.tencent.open.base.f.h(DownloadApi.f341146a, "refreshDownloadInfo true " + downloadInfo);
                            arrayList.add(downloadInfo);
                        }
                    }
                    f fVar2 = fVar;
                    if (fVar2 != null) {
                        fVar2.onResult(arrayList);
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.d(DownloadApi.f341146a, "Exception>>>", e16);
                    f fVar3 = fVar;
                    if (fVar3 != null) {
                        fVar3.onException(-1, e16.getMessage());
                    }
                }
            }
        });
    }

    public static void h(final String str, final f fVar) {
        if (str == null) {
            com.tencent.open.base.f.h(f341146a, "getQueryDownloadActionByVia via == null");
            return;
        }
        if (fVar == null) {
            com.tencent.open.base.f.h(f341146a, "getQueryDownloadActionByVia listener == null");
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.6
            @Override // java.lang.Runnable
            public void run() {
                String str2 = DownloadApi.f341146a;
                com.tencent.open.base.f.h(str2, "getQueryDownloadActionByVia enter");
                try {
                    new ArrayList();
                    List<DownloadInfo> T = DownloadManager.C().T(str);
                    com.tencent.open.base.f.h(str2, "getQueryDownloadActionByVia result = " + T);
                    f fVar2 = fVar;
                    if (fVar2 != null) {
                        fVar2.onResult(T);
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.d(DownloadApi.f341146a, "getQueryDownloadActionByVia Exception>>>", e16);
                    f fVar3 = fVar;
                    if (fVar3 != null) {
                        fVar3.onException(-1, e16.getMessage());
                    }
                }
            }
        });
    }

    public static int i() {
        return 3;
    }

    public static boolean j(String str) {
        DownloadInfo w3 = DownloadManager.C().w(str);
        if (w3 != null && w3.J == 1) {
            return true;
        }
        return false;
    }

    public static boolean k(Bundle bundle) {
        if (bundle.getInt(e.f341502k) != 5) {
            return false;
        }
        String string = bundle.getString(e.f341493b);
        String string2 = bundle.getString(e.f341501j);
        String string3 = bundle.getString(e.f341497f);
        String string4 = bundle.getString(e.f341500i);
        String string5 = bundle.getString(e.f341503l);
        com.tencent.open.business.base.e.h("305", string4, string, bundle.getString(e.K));
        DownloadInfo w3 = DownloadManager.C().w(string);
        if (w3 == null) {
            w3 = new DownloadInfo();
            w3.f341184e = string;
            w3.f341186f = string2.trim();
            w3.f341189h = string3;
            w3.f341191i = string5;
            w3.C = string4;
            w3.G = bundle.getString(e.f341494c);
            w3.H = bundle.getString(e.f341495d);
            w3.I = bundle.getInt(e.f341496e);
            w3.f341181c0 = bundle.getString(e.K);
            w3.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, bundle.getInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, 0) + "");
        } else {
            if (!TextUtils.isEmpty(string4)) {
                w3.C = string4;
            }
            w3.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, bundle.getInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, 0) + "");
        }
        DownloadManager.C().I(w3);
        return true;
    }

    public static boolean l(String str) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            return true;
        }
        return false;
    }

    public static void m(final Activity activity, final Bundle bundle) {
        if (bundle != null && activity != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.2
                @Override // java.lang.Runnable
                public void run() {
                    MyAppApi.z().t0(activity, bundle);
                }
            });
        }
    }

    public static boolean n(com.tencent.open.downloadnew.b bVar) {
        DownloadManagerV2.V().s0(bVar);
        return DownloadManager.C().X(bVar);
    }

    public static void o(final DownloadListener downloadListener) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.11
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.C().Y(DownloadListener.this);
            }
        });
    }

    public static void p(final Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.3
            @Override // java.lang.Runnable
            public void run() {
                MyAppApi.z().m(bundle);
            }
        });
    }

    public static void q(final Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.4
            @Override // java.lang.Runnable
            public void run() {
                MyAppApi.z().l(bundle);
            }
        });
    }

    private static void r(DownloadInfo downloadInfo, boolean z16) {
        if (z16) {
            DownloadManagerV2.V().z0(downloadInfo);
        } else {
            DownloadManager.C().d0(downloadInfo);
        }
    }

    public static boolean s(com.tencent.open.downloadnew.b bVar) {
        DownloadManagerV2.V().C0(bVar);
        return DownloadManager.C().i0(bVar);
    }

    public static void t(final DownloadListener downloadListener) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadApi.12
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.C().j0(DownloadListener.this);
            }
        });
    }
}
