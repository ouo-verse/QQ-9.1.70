package com.tencent.mobileqq.filemanager.app;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.GetAppInfoManager;
import com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistant.appinfo.data.AppParam;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes12.dex */
public class QFileAppStorePromoteManager {

    /* renamed from: e, reason: collision with root package name */
    private static long f207020e;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f207021a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f207022b = false;

    /* renamed from: d, reason: collision with root package name */
    private FetchAppInfoCallback f207024d = new FetchAppInfoCallback();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<Integer, f> f207023c = new HashMap<>();

    /* loaded from: classes12.dex */
    class FetchAppInfoCallback extends GetAppInfoCallback {
        FetchAppInfoCallback() {
        }

        @Override // com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback, com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback
        public void onGetAppInfoResponse(final int i3, final int i16, final List<AppDetail> list) {
            if (list != null && list.size() > 0) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.FetchAppInfoCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        f fVar = (f) QFileAppStorePromoteManager.this.f207023c.get(Integer.valueOf(i3));
                        if (fVar != null) {
                            if (i16 == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            fVar.a(z16, (AppDetail) list.get(0));
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes12.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f207037d;

        a(e eVar) {
            this.f207037d = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ReportController.o(null, "dc00898", "", "", "0X800AE40", "0X800AE40", 0, 0, "", "", "", "");
            e eVar = this.f207037d;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f207039d;

        b(e eVar) {
            this.f207039d = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ReportController.o(null, "dc00898", "", "", "0X800AE41", "0X800AE41", 0, 0, "", "", "", "");
            e eVar = this.f207039d;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    /* loaded from: classes12.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f207041d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f207042e;

        c(Context context, String str) {
            this.f207041d = context;
            this.f207042e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ReportController.o(null, "dc00898", "", "", "0X800AE3D", "0X800AE3D", 0, 0, "", "", "", "");
            QFileAppStorePromoteManager.this.e(this.f207041d, this.f207042e);
        }
    }

    /* loaded from: classes12.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ReportController.o(null, "dc00898", "", "", "0X800AE3E", "0X800AE3E", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes12.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes12.dex */
    public interface f {
        void a(boolean z16, AppDetail appDetail);

        void b();
    }

    public QFileAppStorePromoteManager(QQAppInterface qQAppInterface) {
        this.f207021a = qQAppInterface;
    }

    private static String j(String str, int i3) {
        StringBuilder sb5 = new StringBuilder("tmast://appdetails?");
        sb5.append("pname=");
        sb5.append(str);
        if (i3 == 2) {
            sb5.append("&via=");
            sb5.append("ANDROIDQQ.NEWYYB.APKBYYBAPK");
            ReportController.o(null, "dc00898", "", "", "0X800B00E", "0X800B00E", 0, 0, "", "", "", "");
        } else {
            sb5.append("&via=");
            sb5.append("ANDROIDQQ.YYB.APKBYYBAPK");
        }
        sb5.append("&qimei=");
        sb5.append(o.b());
        return sb5.toString();
    }

    public static void m() {
        ReportController.o(null, "dc00898", "", "", "0X800B00D", "0X800B00D", 0, 0, "", "", "", "");
    }

    public static void p(String str, int i3) {
        if (System.currentTimeMillis() - f207020e < 1000) {
            QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast: start app store limit.");
            return;
        }
        f207020e = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : error. apk package name can not be null.");
        }
        if (QLog.isColorLevel()) {
            QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : apkPkgName[" + str + "]");
        }
        String j3 = j(str, i3);
        if (QLog.isColorLevel()) {
            QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : jumpTmast[" + j3 + "]");
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", j3);
        TMAssistantCallYYB_V2.getInstance().addDownloadTaskFromTmast(bundle);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setPackage(SDKConst.SELF_PACKAGENAME);
        intent.setData(Uri.parse(j3));
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_jc_file");
        try {
            BaseApplication.getContext().startActivity(intent);
        } catch (Exception e16) {
            QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : error. " + e16.getMessage());
        }
    }

    public boolean c() {
        boolean z16;
        int i3;
        l();
        int checkQQDownloaderInstalled = TMAssistantCallYYB_V2.getInstance().checkQQDownloaderInstalled();
        if (checkQQDownloaderInstalled != 2 && checkQQDownloaderInstalled != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i3 = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        } else {
            i3 = 0;
        }
        if (z16 && i3 > 7342130) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return f().b();
    }

    public void e(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(IUniformDownloadMgr.PARAMS_OPEN_WITH_YYB, str);
        bundle.putString("big_brother_source_key", "biz_src_jc_file");
        if (k().getApp() == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, context.getString(R.string.f172182pr));
            bundle2.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_jc_file");
            bundle2.putBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA, bundle);
            Intent intent = new Intent(IUniformDownloadMgr.UNIDOWNLOAD_BORDCAST);
            intent.putExtra("param", bundle2);
            intent.putExtra("url", "https://a.app.qq.com/o/myapp-down?g_f=1116518");
            context.sendBroadcast(intent);
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, context.getString(R.string.f172182pr));
        bundle3.putString("big_brother_source_key", "biz_src_jc_file");
        bundle3.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_jc_file");
        bundle3.putBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA, bundle);
        k().startDownloadNoSzie("https://a.app.qq.com/o/myapp-down?g_f=1116518", bundle3);
    }

    com.tencent.mobileqq.config.business.qfile.b f() {
        return ((IQFileConfigManager) this.f207021a.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteConfig();
    }

    public void g(final String str, final f fVar) {
        l();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.1
            @Override // java.lang.Runnable
            public void run() {
                AppDetailReqParam appDetailReqParam = new AppDetailReqParam();
                AppParam appParam = new AppParam();
                appParam.packageName = str;
                appDetailReqParam.apps.add(appParam);
                appDetailReqParam.biz = "mobileqq_file";
                final int requestAppInfo = GetAppInfoManager.get().requestAppInfo(appDetailReqParam, QFileAppStorePromoteManager.this.f207024d);
                if (QLog.isColorLevel()) {
                    QLog.i("QFileAppStorePromoteManager<QFile>", 1, "getApkInfoByPackageName. reqId[" + requestAppInfo + "]");
                }
                if (requestAppInfo < 0) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fVar.b();
                        }
                    });
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QLog.isColorLevel()) {
                                QLog.i("QFileAppStorePromoteManager<QFile>", 1, "request appInfo. add reqId[" + requestAppInfo + "]");
                            }
                            QFileAppStorePromoteManager.this.f207023c.put(Integer.valueOf(requestAppInfo), fVar);
                        }
                    });
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z16;
                            fVar.b();
                            f fVar2 = (f) QFileAppStorePromoteManager.this.f207023c.remove(Integer.valueOf(requestAppInfo));
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("request appInfo time limit. remove reqId[");
                                sb5.append(requestAppInfo);
                                sb5.append("] result[");
                                if (fVar2 != null) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                sb5.append(z16);
                                sb5.append("]");
                                QLog.i("QFileAppStorePromoteManager<QFile>", 1, sb5.toString());
                            }
                        }
                    }, 500L);
                }
            }
        }, 128, null, true);
    }

    public String h(Context context) {
        String a16 = f().a();
        if (TextUtils.isEmpty(a16)) {
            return context.getString(R.string.f187713uq);
        }
        return a16;
    }

    com.tencent.mobileqq.config.business.qfile.c i() {
        return ((IQFileConfigManager) this.f207021a.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteDialogConfig();
    }

    protected IUniformDownloadMgr k() {
        return (IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
    }

    public void l() {
        if (!this.f207022b) {
            QLog.i("QFileAppStorePromoteManager<QFile>", 1, "initAppStoreSDK. start");
            TMAssistantCallYYB_V2.getInstance().initTMAssistantCallYYBApi(BaseApplication.getContext());
            GetAppInfoManager.get();
            this.f207022b = true;
            QLog.i("QFileAppStorePromoteManager<QFile>", 1, "initAppStoreSDK. finish");
        }
    }

    public void n(Context context, String str) {
        if (k().isExistedDownloadOfUrl("https://a.app.qq.com/o/myapp-down?g_f=1116518")) {
            QQToast.makeText(context, 0, R.string.f187733us, 0).show();
        } else {
            DialogUtil.createNoTitleDialog((Activity) context, context.getString(R.string.f187723ur), R.string.cancel, R.string.f171151ok, new c(context, str), new d()).show();
        }
    }

    public boolean o(Context context, String str, e eVar) {
        if (!i().a()) {
            return false;
        }
        DialogUtil.createVerticalThreeBtnDialog(context, 0, context.getString(R.string.f187773uw), String.format(context.getString(R.string.f187743ut), str), context.getString(R.string.f187753uu), context.getString(R.string.f187763uv), context.getString(R.string.cancel), new a(eVar), new b(eVar)).show();
        ReportController.o(null, "dc00898", "", "", "0X800AE3F", "0X800AE3F", 0, 0, "", "", "", "");
        return true;
    }
}
