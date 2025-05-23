package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.d;
import com.tencent.open.downloadnew.e;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.OuterCallLog;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes22.dex */
public class DownloadProxy {

    /* renamed from: d, reason: collision with root package name */
    private static volatile DownloadProxy f340844d;

    /* renamed from: a, reason: collision with root package name */
    private final Object f340845a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f340846b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ITMAssistantExchangeURLListenner f340847c = new a();

    /* loaded from: classes22.dex */
    class a implements ITMAssistantExchangeURLListenner {
        a() {
        }

        @Override // com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner
        public void onExchangedURLSucceed(ArrayList arrayList, boolean z16) {
            AppSimpleDetail appSimpleDetail;
            int i3;
            f.e("DownloadResolver", "onExchangedURLSucceed --- ");
            if (z16 && arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof AppSimpleDetail) && (i3 = (appSimpleDetail = (AppSimpleDetail) next).versionCode) > 0) {
                        DownloadProxy.this.f340846b.put(appSimpleDetail.packageName, Integer.valueOf(i3));
                    }
                }
            }
            synchronized (DownloadProxy.this.f340845a) {
                DownloadProxy.this.f340845a.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f340860d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f340861e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ApkUpdateDetail f340862f;

        b(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail) {
            this.f340860d = bundle;
            this.f340861e = str;
            this.f340862f = apkUpdateDetail;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DownloadProxy.this.i(this.f340860d, this.f340861e, this.f340862f);
            ReportController.o(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
            np3.a.g().j(25, (System.currentTimeMillis() / 1000) + "|101|" + (this.f340860d.getString(e.f341497f) + "_" + this.f340860d.getString(e.f341494c) + "_" + this.f340860d.getString(e.f341495d)));
            AppCenterReporter.p("6006", "2", "0", this.f340860d.getString(e.f341500i), this.f340860d.getString("pageId") + "_" + this.f340860d.getString("moduleId") + "_" + this.f340860d.getString(e.f341497f) + "_" + this.f340860d.getString(e.f341494c) + "_" + this.f340860d.getString(e.f341495d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f340864d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f340865e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ApkUpdateDetail f340866f;

        c(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail) {
            this.f340864d = bundle;
            this.f340865e = str;
            this.f340866f = apkUpdateDetail;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DownloadProxy.this.i(this.f340864d, this.f340865e, this.f340866f);
        }
    }

    DownloadProxy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail, int i3) {
        f.e("DownloadResolver", "[doDownloadActionByMyApp] pParmas =" + bundle + " myAppConfig = " + i3);
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(activity) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadActionByMyApp, System.currentTimeMillis());
        }
        if ("biz_src_jc_update".equals(str)) {
            com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", bundle.getString(e.K));
        }
        if (bundle.getInt(e.f341496e, -10) < 0) {
            TMAssistantGetAppDetailTool tMAssistantGetAppDetailTool = TMAssistantGetAppDetailTool.getInstance(this.f340847c, com.tencent.open.adapter.a.f().e());
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
                synchronized (this.f340845a) {
                    try {
                        this.f340845a.wait(5000L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = this.f340846b;
                if (concurrentHashMap != null) {
                    Integer remove = concurrentHashMap.remove(string);
                    if (remove == null) {
                        DownloadManagerV2.V().y0(com.tencent.open.adapter.a.f().e().getString(R.string.cob));
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
            bundle.putInt("dialogType", 1);
            MyAppApi.z().D(activity, bundle, new b(bundle, str, apkUpdateDetail));
        } else if (i3 == 2 || i3 == 0) {
            MyAppApi.z().E(activity, bundle, new c(bundle, str, apkUpdateDetail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail) {
        String str2;
        int i3;
        int i16;
        int i17;
        DownloadInfo downloadInfo;
        String str3;
        int i18;
        int i19;
        if ("biz_src_jc_update".equals(str)) {
            com.tencent.open.business.base.e.h("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", bundle.getString(e.K));
        }
        f.e("DownloadResolver", "[doDownloadActionBySDK] pParmas =" + bundle);
        String string = bundle.getString(e.f341501j);
        if (TextUtils.isEmpty(string)) {
            f.c("DownloadResolver", "[doDownloadActionBySDK] url is empty");
            return -1;
        }
        String string2 = bundle.getString(e.f341497f);
        int i26 = bundle.getInt(e.f341502k);
        String string3 = bundle.getString(e.f341500i);
        String string4 = bundle.getString(e.f341503l);
        String string5 = bundle.getString(e.F);
        int i27 = bundle.getInt(e.J);
        String string6 = bundle.getString(e.K);
        boolean z16 = bundle.getBoolean(e.f341506o);
        boolean z17 = bundle.getBoolean(e.f341516y, true);
        boolean z18 = bundle.getBoolean("is_qq_self_update_task", false);
        boolean z19 = bundle.getBoolean(e.f341499h, true);
        boolean z26 = bundle.getBoolean(e.f341515x);
        int i28 = bundle.getInt(e.E, 0);
        boolean z27 = bundle.getBoolean(e.L, false);
        String string7 = bundle.getString("appId");
        String string8 = bundle.getString("apkId", "");
        String string9 = bundle.getString("recommendId", "");
        String string10 = bundle.getString(e.M, "");
        String string11 = bundle.getString("sourceFromServer", "");
        String string12 = bundle.getString("pageId", "");
        String string13 = bundle.getString("moduleId", "");
        String string14 = bundle.getString("positionId", "");
        String string15 = bundle.getString(RemoteMessageConst.SEND_TIME, "");
        String string16 = bundle.getString(LaunchParam.KEY_REF_ID, "");
        String str4 = bundle.getInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, 0) + "";
        int i29 = bundle.getInt(e.f341517z);
        if (i26 == 2) {
            str2 = string;
            DownloadInfo downloadInfo2 = new DownloadInfo(string7, string.trim(), string2, string4, string3, null, str, z17);
            i3 = i26;
            downloadInfo2.S = i3;
            if (z17) {
                downloadInfo2.T = z19;
                downloadInfo2.U = z26;
                i17 = i28;
                i16 = 0;
            } else {
                i16 = 0;
                downloadInfo2.T = false;
                downloadInfo2.U = true;
                downloadInfo2.E = 2;
                i17 = i28;
            }
            downloadInfo2.W = i17;
            downloadInfo2.Y = string5;
            downloadInfo2.Z = i27;
            downloadInfo2.f341181c0 = string6;
            downloadInfo2.f341183d0 = z27;
            downloadInfo2.K = i16;
            try {
                downloadInfo2.I = bundle.getInt(e.f341496e);
                downloadInfo2.f341187f0 = bundle.getLong(e.I);
            } catch (NumberFormatException unused) {
            }
            downloadInfo2.H = string8;
            downloadInfo2.f341188g0 = string9;
            downloadInfo2.f341190h0 = string11;
            downloadInfo2.f341192i0 = string10;
            downloadInfo2.f341193j0 = string12;
            downloadInfo2.f341194k0 = string13;
            downloadInfo2.f341195l0 = string14;
            downloadInfo2.f341197m0 = z18;
            downloadInfo2.N = i29;
            if (!TextUtils.isEmpty(string15)) {
                downloadInfo2.f341196m = string15;
            }
            downloadInfo2.j(LaunchParam.KEY_REF_ID, string16);
            downloadInfo2.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, str4);
            downloadInfo2.m();
            f.e("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_DOWNLOAD");
            DownloadManagerV2.V().z0(downloadInfo2);
            downloadInfo = downloadInfo2;
        } else {
            if (i26 == 3) {
                return DownloadManagerV2.V().o0(string);
            }
            if (i26 != 5) {
                if (i26 == 10) {
                    DownloadManagerV2.V().x(string, true);
                    str3 = string;
                } else if (i26 != 12) {
                    str3 = string;
                } else {
                    DownloadInfo downloadInfo3 = new DownloadInfo(string7, string.trim(), string2, string4, string3, null, str, z17);
                    downloadInfo3.S = i26;
                    downloadInfo3.T = z19;
                    downloadInfo3.U = z26;
                    downloadInfo3.K = 0;
                    int i36 = bundle.getInt(e.f341496e);
                    downloadInfo3.I = i36;
                    downloadInfo3.f341181c0 = string6;
                    if (apkUpdateDetail != null && i36 != (i19 = apkUpdateDetail.versioncode) && i19 != 0) {
                        downloadInfo3.I = i19;
                    }
                    if (!TextUtils.isEmpty(string15)) {
                        downloadInfo3.f341196m = string15;
                    }
                    downloadInfo3.H = string8;
                    downloadInfo3.f341188g0 = string9;
                    downloadInfo3.f341190h0 = string11;
                    downloadInfo3.f341192i0 = string10;
                    downloadInfo3.f341193j0 = string12;
                    downloadInfo3.f341194k0 = string13;
                    downloadInfo3.f341195l0 = string14;
                    downloadInfo3.f341197m0 = z18;
                    downloadInfo3.N = i29;
                    downloadInfo3.j(LaunchParam.KEY_REF_ID, string16);
                    downloadInfo3.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, str4);
                    downloadInfo3.m();
                    DownloadManagerV2.V().z0(downloadInfo3);
                    f.a("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_UPDATE " + z16);
                    downloadInfo = downloadInfo3;
                    i3 = i26;
                    str2 = string;
                }
                i18 = i26;
            } else {
                str3 = string;
                i18 = i26;
                if (z17) {
                    com.tencent.open.business.base.e.h("305", string3, string7, string6);
                    DownloadInfo S = DownloadManagerV2.V().S(str3);
                    if (S == null) {
                        S = new DownloadInfo();
                        S.f341184e = string7;
                        S.f341186f = str3.trim();
                        S.f341189h = string2;
                        S.f341191i = string4;
                        S.C = string3;
                        S.G = bundle.getString(e.f341494c);
                        S.I = bundle.getInt(e.f341496e);
                        S.X = bundle.getBoolean(e.f341516y, true);
                        S.W = i28;
                        S.Y = string5;
                        S.K = 0;
                        S.f341181c0 = string6;
                        if (!TextUtils.isEmpty(string15)) {
                            S.f341196m = string15;
                        }
                        S.H = string8;
                        S.f341188g0 = string9;
                        S.f341190h0 = string11;
                        S.f341192i0 = string10;
                        S.f341193j0 = string12;
                        S.f341194k0 = string13;
                        S.f341195l0 = string14;
                        S.m();
                    }
                    downloadInfo = S;
                    downloadInfo.f341197m0 = z18;
                    downloadInfo.N = i29;
                    downloadInfo.j(LaunchParam.KEY_REF_ID, string16);
                    downloadInfo.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, str4);
                    DownloadManagerV2.V().a0(downloadInfo);
                    str2 = str3;
                    i3 = i18;
                }
            }
            downloadInfo = null;
            str2 = str3;
            i3 = i18;
        }
        DownloadInfoReport.g(11, str2, i3, downloadInfo);
        return 0;
    }

    public static DownloadProxy k() {
        if (f340844d == null) {
            synchronized (DownloadProxy.class) {
                if (f340844d == null) {
                    f340844d = new DownloadProxy();
                }
            }
        }
        return f340844d;
    }

    private String l(TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo) {
        if (tMAssistantDownloadTaskInfo == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[mSavePath=" + tMAssistantDownloadTaskInfo.mSavePath);
        sb5.append("\n");
        sb5.append("mState=" + tMAssistantDownloadTaskInfo.mState);
        sb5.append("\n");
        sb5.append("mReceiveDataLen=" + tMAssistantDownloadTaskInfo.mReceiveDataLen);
        sb5.append("\n");
        sb5.append("mTotalDataLen=" + tMAssistantDownloadTaskInfo.mTotalDataLen);
        sb5.append("\n");
        sb5.append("mContentType=" + tMAssistantDownloadTaskInfo.mContentType);
        sb5.append("\n");
        sb5.append("mTaskPackageName=" + tMAssistantDownloadTaskInfo.mTaskPackageName);
        sb5.append("\n");
        sb5.append("mTaskVersionCode=" + tMAssistantDownloadTaskInfo.mTaskVersionCode);
        sb5.append("]");
        return sb5.toString();
    }

    public static boolean m(Bundle bundle) {
        if (bundle.getInt(e.f341502k) != 5) {
            return false;
        }
        String string = bundle.getString(e.f341501j);
        if (TextUtils.isEmpty(string)) {
            f.c("DownloadResolver", "[installApp] url is empty");
            return false;
        }
        String string2 = bundle.getString(e.f341497f);
        String string3 = bundle.getString(e.f341500i);
        String string4 = bundle.getString(e.f341503l);
        String string5 = bundle.getString(e.K);
        String string6 = bundle.getString("appId");
        String string7 = bundle.getString("apkId", "");
        String string8 = bundle.getString("recommendId", "");
        String string9 = bundle.getString(e.M, "");
        String string10 = bundle.getString("sourceFromServer", "");
        String string11 = bundle.getString("pageId", "");
        String string12 = bundle.getString("moduleId", "");
        String string13 = bundle.getString("positionId", "");
        String string14 = bundle.getString(LaunchParam.KEY_REF_ID, "");
        String string15 = bundle.getString("big_brother_source_key");
        int i3 = bundle.getInt(e.f341517z);
        com.tencent.open.business.base.e.h("305", string3, string6, string5);
        DownloadInfo S = DownloadManagerV2.V().S(string);
        if (S == null) {
            S = new DownloadInfo();
            S.f341184e = string6;
            S.f341186f = string.trim();
            S.f341189h = string2;
            S.f341191i = string4;
            S.C = string3;
            S.G = bundle.getString(e.f341494c);
            S.H = bundle.getString(e.f341495d);
            S.I = bundle.getInt(e.f341496e);
            S.f341181c0 = bundle.getString(e.K);
            S.H = string7;
            S.f341188g0 = string8;
            S.f341190h0 = string10;
            S.f341192i0 = string9;
            S.f341193j0 = string11;
            S.f341194k0 = string12;
            S.f341195l0 = string13;
            S.M = string15;
            S.N = i3;
            S.j(LaunchParam.KEY_REF_ID, string14);
            S.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, bundle.getInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, 0) + "");
            S.m();
        } else {
            if (!TextUtils.isEmpty(string3)) {
                S.C = string3;
            }
            if (!TextUtils.isEmpty(string14)) {
                S.j(LaunchParam.KEY_REF_ID, string14);
            }
            if (!TextUtils.isEmpty(string15)) {
                S.M = string15;
            }
            S.j(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, bundle.getInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, 0) + "");
            S.N = i3;
        }
        return DownloadManagerV2.V().a0(S);
    }

    public static void n(Activity activity, Bundle bundle) {
        DownloadApi.m(activity, bundle);
    }

    public static void p(Bundle bundle) {
        DownloadApi.p(bundle);
    }

    public static void q(Bundle bundle) {
        DownloadApi.q(bundle);
    }

    public void e(final String str, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadProxy.6
            @Override // java.lang.Runnable
            public void run() {
                DownloadManagerV2.V().x(str, z16);
            }
        }, 32, null, true);
    }

    public void f(final String str, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadProxy.7
            @Override // java.lang.Runnable
            public void run() {
                DownloadManagerV2.V().G(str, z16);
            }
        }, 32, null, true);
    }

    public void g(final Activity activity, final Bundle bundle, final String str, final ApkUpdateDetail apkUpdateDetail, final int i3) {
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(com.tencent.open.adapter.a.f().e()) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadAction, System.currentTimeMillis());
        }
        if ("biz_src_jc_update".equals(str)) {
            com.tencent.open.business.base.e.h("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", bundle.getString(e.K));
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadProxy.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                boolean z17;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[doDownloadAction] pParams=");
                sb5.append(bundle);
                sb5.append(" source=");
                sb5.append(str);
                sb5.append(" myAppConfig=");
                sb5.append(i3);
                sb5.append(" ac==null is");
                boolean z18 = false;
                if (activity == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                f.e("DownloadResolver", sb5.toString());
                if (bundle == null) {
                    f.e("DownloadResolver", "[doDownloadAction] pParams == null return");
                    return;
                }
                DownloadManagerV2.V().B();
                bundle.getString(e.f341493b);
                bundle.putString(e.f341511t, str);
                bundle.putString("big_brother_source_key", str);
                bundle.putInt(e.G, 1);
                String string = bundle.getString(e.D);
                String string2 = bundle.getString(e.f341500i);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    bundle.putString(e.D, "");
                }
                String string3 = bundle.getString(e.f341501j);
                ApkUpdateDetail apkUpdateDetail2 = apkUpdateDetail;
                if (apkUpdateDetail2 != null && apkUpdateDetail2.updatemethod == 2 && TextUtils.isEmpty(string3) && !TextUtils.isEmpty(apkUpdateDetail.url)) {
                    bundle.putString(e.f341501j, apkUpdateDetail.url);
                    string3 = apkUpdateDetail.url;
                }
                DownloadInfo S = DownloadManagerV2.V().S(string3);
                if (S == null && "biz_src_yyb".equals(str) && d.u()) {
                    int i16 = bundle.getInt(e.f341502k);
                    String string4 = bundle.getString(e.f341497f);
                    if (i16 == 5 && SDKConst.SELF_PACKAGENAME.equals(string4)) {
                        DownloadProxy.m(bundle);
                        return;
                    }
                } else if (S != null && !TextUtils.isEmpty(string2)) {
                    S.C = string2;
                }
                if (DownloadProxy.m(bundle)) {
                    f.h("DownloadResolver", "[doDownloadAction] installApp");
                    return;
                }
                if (bundle.getInt(e.f341502k) == 5) {
                    bundle.putInt(e.f341502k, 2);
                }
                int i17 = i3;
                if (i17 == 0) {
                    if (S != null && S.J == 1) {
                        DownloadProxy.this.h(activity, bundle, str, apkUpdateDetail, i17);
                        return;
                    }
                    boolean a16 = com.tencent.open.base.a.a(com.tencent.open.adapter.a.f().e());
                    boolean k3 = com.tencent.open.base.a.k(com.tencent.open.adapter.a.f().e());
                    if (S != null && S.f() != 1) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (activity == null) {
                        z18 = true;
                    }
                    f.h("DownloadResolver", "check wifi dialog isWifiActive=" + k3 + " isFirstDownload=" + z17 + " acIsNull=" + z18);
                    if (!a16 || z18 || k3 || !z17 || !bundle.getBoolean(e.f341510s)) {
                        DownloadProxy.this.i(bundle, str, apkUpdateDetail);
                        return;
                    } else {
                        DownloadManagerV2.V().E(activity, bundle, str, apkUpdateDetail, i3);
                        return;
                    }
                }
                if (S == null || S.J == 1) {
                    DownloadProxy.this.h(activity, bundle, str, apkUpdateDetail, i17);
                } else {
                    DownloadProxy.this.i(bundle, str, apkUpdateDetail);
                }
            }
        });
    }

    public List<DownloadInfo> j() {
        Object valueOf;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, DownloadInfo> T = DownloadManagerV2.V().T();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DownloadManagerV2 tasks:");
        if (T == null) {
            valueOf = "0";
        } else {
            valueOf = Integer.valueOf(T.size());
        }
        sb5.append(valueOf);
        f.e("DownloadResolver", sb5.toString());
        if (T != null && T.size() != 0) {
            HashMap hashMap = new HashMap(T);
            ArrayList arrayList2 = new ArrayList();
            if (hashMap.size() > 0) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    DownloadInfo downloadInfo = (DownloadInfo) entry.getValue();
                    if (downloadInfo.J == 0 && !TextUtils.isEmpty(downloadInfo.f341189h) && downloadInfo.X) {
                        arrayList.add(downloadInfo);
                        f.e("DownloadResolver", "\ninfo=" + downloadInfo.toString() + "\ntaskInfo:" + l(DownloadManagerV2.V().Y(downloadInfo.f341186f)));
                    } else {
                        f.c("DownloadResolver", "Info is not SDK && APK task!! \ninfo=" + downloadInfo.toString());
                    }
                    arrayList2.add(Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                }
            } else {
                f.c("DownloadResolver", "infos is empty!!");
            }
            Long[] lArr = new Long[arrayList2.size()];
            arrayList2.toArray(lArr);
            f.c("DownloadResolver", "Total time Cost:" + (System.currentTimeMillis() - currentTimeMillis) + ";Every loop time cost:" + Arrays.toString(lArr));
            return arrayList;
        }
        f.c("DownloadResolver", "infos is null!!");
        return arrayList;
    }

    public void o(final List<DownloadInfo> list, final com.tencent.open.downloadnew.f fVar) {
        if (list == null) {
            f.e("DownloadResolver", "[queryByDownloadManagerV2] infos == null");
            return;
        }
        if (fVar == null) {
            f.e("DownloadResolver", "[queryByDownloadManagerV2] listener == null");
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadProxy.2
            @Override // java.lang.Runnable
            public void run() {
                f.e("DownloadResolver", "[queryByDownloadManagerV2] enter");
                DownloadManagerV2.V().B();
                try {
                    ArrayList arrayList = new ArrayList();
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        DownloadInfo downloadInfo = (DownloadInfo) list.get(i3);
                        if (DownloadManagerV2.V().r0(downloadInfo)) {
                            f.e("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + downloadInfo);
                            arrayList.add(downloadInfo);
                        }
                    }
                    com.tencent.open.downloadnew.f fVar2 = fVar;
                    if (fVar2 != null) {
                        fVar2.onResult(arrayList);
                    }
                } catch (Exception e16) {
                    f.d("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", e16);
                    com.tencent.open.downloadnew.f fVar3 = fVar;
                    if (fVar3 != null) {
                        fVar3.onException(-1, e16.getMessage());
                    }
                }
            }
        });
    }
}
