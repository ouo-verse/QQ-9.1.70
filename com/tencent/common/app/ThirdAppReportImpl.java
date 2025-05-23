package com.tencent.common.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.IATHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.IBrowserThirdAppReport;
import mqq.app.IThirdAppOpenReport;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ThirdAppReportImpl implements IThirdAppOpenReport {
    static IPatchRedirector $redirector_;

    public ThirdAppReportImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(Intent intent, String str, int i3, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String dataString;
        boolean z16;
        boolean z17;
        String str8;
        String str9;
        boolean z18;
        if (!PrivacyPolicyHelper.isUserAllow()) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        String str10 = MobileQQ.processName;
        String action = intent.getAction();
        String str11 = "";
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if (str3 == null) {
            str5 = "";
        } else {
            str5 = str3;
        }
        String type = intent.getType();
        if (CommonConstant.ACTION.HWID_SCHEME_URL.equals(action) && "application/vnd.android.package-archive".equalsIgnoreCase(type)) {
            Uri data = intent.getData();
            str8 = FileProvider7Helper.getRealPathFromContentURI(context, data);
            boolean exists = new File(str8).exists();
            if (QLog.isDevelopLevel()) {
                QLog.d("ThirdAppReport", 4, "install data-uri " + data.toString() + " real filePath = " + str8 + "isFileExists = " + exists);
            }
            if (!exists) {
                str6 = "";
                z18 = false;
            } else {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str8, 0);
                if (packageArchiveInfo == null) {
                    str6 = "";
                } else {
                    str6 = packageArchiveInfo.packageName;
                }
                z18 = true;
            }
            z17 = true;
            z16 = z18;
            dataString = "";
        } else {
            str6 = intent.getPackage();
            if (intent.getComponent() == null) {
                str7 = "";
            } else {
                str7 = intent.getComponent().getClassName();
            }
            dataString = intent.getDataString();
            z16 = false;
            z17 = false;
            String str12 = str7;
            str8 = "";
            str11 = str12;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ThirdAppReport", 4, String.format("params:sProcessName = %s,sComponentName = %s,dPkgName = %s,dAction = %s,dComponentName = %s,dScheme = %s,isInstall = %b,sInstallFilePath = = %s,fromType = %d,isValid = %b,sOriginalUrl = %s,sCurrentUrl = %s", str10, str, str6, action, str11, dataString, Boolean.valueOf(z17), str8, Integer.valueOf(i3), Boolean.valueOf(z16), str4, str5));
        }
        if (z16 && !TextUtils.isEmpty(str6) && !context.getPackageName().equalsIgnoreCase(str6)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sComponentName", str);
            hashMap.put("sProcessName", str10);
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISOFFLINE, String.valueOf(i3));
            hashMap.put("dPkgName", str6);
            if (z17) {
                hashMap.put("installFilePath", str8);
            } else {
                hashMap.put("dActionName", action);
                hashMap.put("dCompomentName", str11);
                hashMap.put("dSchema", dataString);
            }
            hashMap.put("sOriginalUrl", str4);
            hashMap.put("sCurrentUrl", str5);
            if (z17) {
                str9 = "ThirdAppInstall";
            } else {
                str9 = "ThirdAppOpen";
            }
            String str13 = str9;
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            if (QLog.isColorLevel()) {
                QLog.d("ThirdAppReport", 2, "report real... ");
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(account, str13, true, 0L, 0L, hashMap, null);
        }
    }

    @Override // mqq.app.IThirdAppOpenReport
    public void report(Context context, Intent intent, int i3) {
        String name;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (context != 0 && intent != null) {
            try {
                a();
            } catch (Throwable th5) {
                QLog.e("ThirdAppReport", 1, th5, new Object[0]);
            }
            ComponentName component = intent.getComponent();
            if (component == null || !context.getPackageName().equalsIgnoreCase(component.getPackageName())) {
                z16 = true;
            }
            if (z16) {
                if (context instanceof BaseActivity) {
                    name = ((BaseActivity) context).getCIOPageName();
                } else if (context instanceof PluginProxyActivity) {
                    name = ((PluginProxyActivity) context).getPluginActivity();
                } else {
                    name = context.getClass().getName();
                }
                String str3 = name;
                if (context instanceof IBrowserThirdAppReport) {
                    IBrowserThirdAppReport iBrowserThirdAppReport = (IBrowserThirdAppReport) context;
                    String originalUrl = iBrowserThirdAppReport.getOriginalUrl();
                    str2 = iBrowserThirdAppReport.getCurrentUrl();
                    str = originalUrl;
                } else {
                    str = null;
                    str2 = null;
                }
                ThreadManagerV2.excute(new Runnable(intent, str3, i3, str, str2) { // from class: com.tencent.common.app.ThirdAppReportImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Intent f99527d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f99528e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f99529f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f99530h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f99531i;

                    {
                        this.f99527d = intent;
                        this.f99528e = str3;
                        this.f99529f = i3;
                        this.f99530h = str;
                        this.f99531i = str2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ThirdAppReportImpl.this, intent, str3, Integer.valueOf(i3), str, str2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            ThirdAppReportImpl.b(this.f99527d, this.f99528e, this.f99529f, this.f99530h, this.f99531i);
                        } catch (Exception e16) {
                            QLog.e("ThirdAppReport", 2, e16, new Object[0]);
                        }
                    }
                }, 64, null, true);
            }
        }
    }

    @Override // mqq.app.IThirdAppOpenReport
    public void startActivityForResult(Activity activity, Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, intent, Integer.valueOf(i3), bundle);
        } else if (intent == null) {
            QLog.e("ThirdAppReport", 1, "intent is null! could not start activity!");
        } else {
            IATHandler.shellStartActivityForResult(activity, intent, i3, bundle);
        }
    }

    public static void a() {
    }
}
