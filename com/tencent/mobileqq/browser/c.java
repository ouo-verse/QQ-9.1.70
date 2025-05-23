package com.tencent.mobileqq.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.BrowserOpenBean;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001a\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002\u001a\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0013"}, d2 = {"Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "packageName", "", "d", "b", "Landroid/content/Context;", "context", "downloadUrl", "targetUrl", "a", "", "e", "Lcom/tencent/mobileqq/config/business/d;", "browserOpenBean", "Lcom/tencent/mobileqq/browser/b;", "c", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    public static final void a(@NotNull Context context, @NotNull String downloadUrl, @NotNull String targetUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        try {
            Intent intent = new Intent();
            intent.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
            intent.addFlags(268435456);
            RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        } catch (Throwable th5) {
            QLog.e("[BrowserOpt] BrowserUtil", 2, "startActivity er:", th5);
        }
    }

    @NotNull
    public static final String b() {
        String account;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null || (account = runtime.getAccount()) == null) {
            return "";
        }
        return account;
    }

    @NotNull
    public static final List<b> c(@NotNull Context context, @Nullable BrowserOpenBean browserOpenBean) {
        boolean z16;
        boolean z17;
        boolean z18;
        String applicationName;
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (browserOpenBean != null) {
            for (b bVar : browserOpenBean.b()) {
                arrayList.add(bVar);
                linkedHashSet.add(bVar.d());
            }
            for (String str : e(context)) {
                try {
                    z16 = PackageUtil.isPackageInstalled(BaseApplication.context, str);
                } catch (Exception e16) {
                    QLog.e("[BrowserOpt] BrowserUtil", 1, "convertToTopBrowserList: called. ", "topBrowsers: " + browserOpenBean.b(), e16);
                    z16 = false;
                }
                boolean contains = linkedHashSet.contains(str);
                boolean contains2 = browserOpenBean.a().contains(str);
                if (z16 && !contains2 && !contains && (applicationName = PackageUtil.getApplicationName(BaseApplication.context, str)) != null) {
                    z17 = contains2;
                    z18 = contains;
                    arrayList.add(new b(applicationName, "", "", "", str, true));
                } else {
                    z17 = contains2;
                    z18 = contains;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("[BrowserOpt] BrowserUtil", 2, "loadValidBrowserList: called. ", "topBrowsers: " + browserOpenBean.b() + "  packageInstalled: " + z16 + "  inBlackList: " + z17 + " inTopBrowserList: " + z18);
                }
            }
        }
        return arrayList;
    }

    public static final void d(@NotNull Activity activity, @NotNull String url, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(url));
        intent.setPackage(packageName);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    private static final List<String> e(Context context) {
        ActivityInfo activityInfo;
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("https://www.qq.com")), 65536);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryInte\u2026nager.MATCH_DEFAULT_ONLY)");
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo != null) {
                    activityInfo = resolveInfo.activityInfo;
                } else {
                    activityInfo = null;
                }
                if (activityInfo != null) {
                    String pkgName = resolveInfo.activityInfo.processName;
                    if (!TextUtils.isEmpty(pkgName)) {
                        Intrinsics.checkNotNullExpressionValue(pkgName, "pkgName");
                        arrayList.add(pkgName);
                    }
                    QLog.d("[BrowserOpt] BrowserUtil", 2, "systemLocalBrowsers: called. ", "pkgName: " + pkgName);
                }
            }
        } catch (Exception e16) {
            QLog.e("[BrowserOpt] BrowserUtil", 1, "systemLocalBrowsers failed", e16);
        }
        return arrayList;
    }
}
