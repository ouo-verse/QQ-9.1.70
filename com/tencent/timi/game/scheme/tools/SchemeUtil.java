package com.tencent.timi.game.scheme.tools;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import java.net.URLDecoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SchemeUtil {

    /* renamed from: a, reason: collision with root package name */
    public static String f379337a = "SchemeUtil";

    /* renamed from: b, reason: collision with root package name */
    public static String f379338b = "biz_src_wzgamelive_open";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f379343a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f379344b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f379345c;

        a(boolean z16, String str, String str2) {
            this.f379343a = z16;
            this.f379344b = str;
            this.f379345c = str2;
        }

        @Override // com.tencent.timi.game.scheme.tools.SchemeUtil.d
        public void a(Exception exc) {
            l.f(SchemeUtil.f379337a, "launchGame ERROR " + this.f379343a, exc);
            if (!this.f379343a && exc != null && (exc instanceof SecurityException) && eh4.a.b() != null) {
                Application b16 = eh4.a.b();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("schemestring", this.f379344b);
                intent.putExtra("src_biz", this.f379345c);
                QPublicFragmentActivity.b.b(b16, intent, QPublicTransFragmentActivity.class, SchemeRouteTranslucentFragment.class);
                return;
            }
            f.d(true, "\u542f\u52a8\u5e94\u7528\u7a0b\u5e8f\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements com.tencent.mobileqq.bigbrother.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f379346a;

        b(c cVar) {
            this.f379346a = cVar;
        }

        @Override // com.tencent.mobileqq.bigbrother.b
        public void onJump(int i3, int i16) {
            l.i(SchemeUtil.f379337a, "launchCommonScheme onJump - callbackId= " + i3 + ", action = " + i16);
            c cVar = this.f379346a;
            if (cVar != null) {
                cVar.onResult(i16);
            }
            com.tencent.mobileqq.bigbrother.d.b().d(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface c {
        void onResult(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface d {
        void a(Exception exc);
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            str2 = "http://" + str;
        } else {
            str2 = str;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str2));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("big_brother_source_key", f379338b);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e16) {
            l.f(f379337a, "gotoSysBrowser error" + str, e16);
            return false;
        }
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(eh4.a.b().getPackageManager(), new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str)), 131072);
                if (queryIntentActivities != null) {
                    if (queryIntentActivities.size() > 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e16) {
                l.f("SchemeUtil", "isAppInstalledByScheme error " + str, e16);
                return false;
            }
        }
        return false;
    }

    public static boolean c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 1024);
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            l.f(f379337a, "isAppIntalled exception", e16);
            return false;
        }
    }

    public static void d(Context context, String str) {
        l.i(f379337a, "launchApp pkgName:" + str);
        if (context != null && str != null) {
            Context applicationContext = context.getApplicationContext();
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(applicationContext.getPackageManager(), str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setPackage(applicationContext.getPackageName());
                launchIntentForPackage.setFlags(268435456);
                applicationContext.startActivity(launchIntentForPackage);
                return;
            }
            l.e(f379337a, "launchApp err intent == null");
            return;
        }
        l.e(f379337a, "launchApp context = null || pkgName = null");
    }

    private static void e(final Context context, final Intent intent, final String str, final d dVar) {
        if (intent == null && (TextUtils.isEmpty(str) || !c(context, str))) {
            f.c("\u5e94\u7528\u7a0b\u5e8f\u672a\u5b89\u88c5");
            return;
        }
        if (!"oppo".equalsIgnoreCase(Build.MANUFACTURER)) {
            try {
                if (intent != null) {
                    context.startActivity(intent);
                } else {
                    d(context, str);
                }
                return;
            } catch (Exception e16) {
                if (dVar != null) {
                    dVar.a(e16);
                    return;
                }
                return;
            }
        }
        w.d(new Runnable() { // from class: com.tencent.timi.game.scheme.tools.SchemeUtil.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent2 = intent;
                    if (intent2 != null) {
                        context.startActivity(intent2);
                    } else {
                        SchemeUtil.d(context, str);
                    }
                } catch (Exception e17) {
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a(e17);
                    }
                }
            }
        }, 500L);
    }

    public static boolean f(Context context, String str, String str2, boolean z16) {
        return g(context, str, str2, z16, null);
    }

    public static boolean g(Context context, String str, String str2, boolean z16, c cVar) {
        Uri uri;
        l.i(f379337a, "launchCommonScheme " + context + ", fromSchemeActivity - " + z16 + ", qqSrcBizId - " + str2 + "\n" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = f379338b;
        }
        String str3 = null;
        try {
            uri = Uri.parse(str);
        } catch (Exception e16) {
            l.f(f379337a, "launchCommonScheme parseUri exception ", e16);
            uri = null;
        }
        if (uri != null) {
            str3 = uri.getScheme();
        }
        if (TextUtils.isEmpty(str3)) {
            f.d(true, "\u542f\u52a8\u53c2\u6570\u9519\u8bef");
            l.e(f379337a, "launchCommonScheme schemeName is null");
            return false;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, uri);
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 131072);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            String query = uri.getQuery();
            if (!TextUtils.isEmpty(query)) {
                Bundle h16 = h(query);
                if (h16 != null) {
                    intent.putExtras(h16);
                }
                l.i(f379337a, "launchCommonScheme  extraBundles - " + h16);
            }
            l.i(f379337a, "launchCommonScheme activityList.size = " + queryIntentActivities.size() + ", activityInfo1 = " + queryIntentActivities.get(0).activityInfo);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            a aVar = new a(z16, str, str2);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("big_brother_source_key", str2);
            }
            int a16 = com.tencent.mobileqq.bigbrother.d.b().a(new b(cVar));
            l.i(f379337a, "launchCommonScheme callbackId= " + a16);
            intent.putExtra("key_callback_id", a16);
            e(context, intent, "", aVar);
            return true;
        }
        l.e(f379337a, "launchCommonScheme IntentActivity not found - " + str3);
        f.d(true, "\u542f\u52a8\u5e94\u7528\u7a0b\u5e8f\u5931\u8d25");
        return false;
    }

    private static Bundle h(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
            } catch (Exception e16) {
                l.e(f379337a, e16.toString());
            }
            if (!str.isEmpty()) {
                for (String str2 : str.split("[&]")) {
                    String[] split = str2.split("[=]");
                    if (split.length > 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), split[1]);
                    } else {
                        bundle.putString(split[0], "");
                    }
                }
                return bundle;
            }
        }
        l.e(f379337a, "url has no params");
        return bundle;
    }
}
