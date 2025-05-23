package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HiAnalyticsUtils {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f37568c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f37569d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static HiAnalyticsUtils f37570e;

    /* renamed from: a, reason: collision with root package name */
    private int f37571a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f37572b = com.huawei.hms.stats.c.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37573a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37574b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f37575c;

        a(Context context, String str, Map map) {
            this.f37573a = context;
            this.f37574b = str;
            this.f37575c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent(this.f37573a, this.f37574b, this.f37575c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37577a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37578b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f37579c;

        b(Context context, String str, String str2) {
            this.f37577a = context;
            this.f37578b = str;
            this.f37579c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent2(this.f37577a, this.f37578b, this.f37579c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37581a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37582b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f37583c;

        c(Context context, String str, Map map) {
            this.f37581a = context;
            this.f37582b = str;
            this.f37583c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f37581a, this.f37582b, this.f37583c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37585a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37586b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f37587c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f37588d;

        d(Context context, String str, Map map, int i3) {
            this.f37585a = context;
            this.f37586b = str;
            this.f37587c = map;
            this.f37588d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f37585a, this.f37586b, this.f37587c, this.f37588d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37590a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37591b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f37592c;

        e(Context context, String str, Map map) {
            this.f37590a = context;
            this.f37591b = str;
            this.f37592c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f37590a, this.f37591b, this.f37592c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37594a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37595b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f37596c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f37597d;

        f(Context context, String str, Map map, int i3) {
            this.f37594a = context;
            this.f37595b = str;
            this.f37596c = map;
            this.f37597d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f37594a, this.f37595b, this.f37596c, this.f37597d);
        }
    }

    HiAnalyticsUtils() {
    }

    private static LinkedHashMap<String, String> a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private void b(Context context) {
        synchronized (f37569d) {
            int i3 = this.f37571a;
            if (i3 < 60) {
                this.f37571a = i3 + 1;
            } else {
                this.f37571a = 0;
                if (!this.f37572b) {
                    HmsHiAnalyticsUtils.onReport();
                } else {
                    com.huawei.hms.stats.b.a(context, 0);
                    com.huawei.hms.stats.b.a(context, 1);
                }
            }
        }
    }

    private void c(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new e(context.getApplicationContext(), str, map));
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th5.getMessage());
        }
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f37568c) {
            if (f37570e == null) {
                f37570e = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = f37570e;
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.f37572b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HiAnalyticTools.enableLog(context);
        }
    }

    public boolean getInitFlag() {
        if (!this.f37572b) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public int getOobeAnalyticsState(Context context) {
        if (context == null) {
            return 0;
        }
        int a16 = a(context);
        if (a16 == 1) {
            return a16;
        }
        Bundle bundle = new Bundle();
        bundle.putString("hms_cp_bundle_key", "content://com.huawei.hms.contentprovider/com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        try {
            Bundle call = context.getApplicationContext().getContentResolver().call(Uri.parse("content://com.huawei.hms.contentprovider"), "getAnalyticsState", (String) null, bundle);
            if (call != null) {
                a16 = call.getInt("SWITCH_IS_CHECKED");
                HMSLog.i("HiAnalyticsUtils", "get hms analyticsOobe state " + a16);
                return a16;
            }
            return a16;
        } catch (IllegalArgumentException unused) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
            return a16;
        } catch (SecurityException unused2) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
            return a16;
        } catch (Exception unused3) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
            return a16;
        }
    }

    public boolean hasError(Context context) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        boolean z16;
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (andRefreshAnalyticsState != 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (a(initFlag, z16, map)) {
                a(context, str, map);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f37572b) {
                    HmsHiAnalyticsUtils.onEvent(0, str, a(map));
                    HmsHiAnalyticsUtils.onEvent(1, str, a(map));
                } else {
                    com.huawei.hms.stats.b.a(context, 0, str, a(map));
                    com.huawei.hms.stats.b.a(context, 1, str, a(map));
                }
                b(context);
                return;
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + andRefreshAnalyticsState);
    }

    public void onEvent2(Context context, String str, String str2) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (!initFlag && andRefreshAnalyticsState != 2 && a(str2)) {
            a(context, str, str2);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (!this.f37572b) {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            } else {
                com.huawei.hms.stats.b.a(context, str, str2);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                b(context, str, map);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f37572b) {
                    HmsHiAnalyticsUtils.onEvent(0, str, a((Map<String, String>) map));
                    HmsHiAnalyticsUtils.onEvent(1, str, a((Map<String, String>) map));
                } else {
                    com.huawei.hms.stats.b.a(context, 0, str, a((Map<String, String>) map));
                    com.huawei.hms.stats.b.a(context, 1, str, a((Map<String, String>) map));
                }
                b(context);
                return;
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + andRefreshAnalyticsState);
    }

    public void onReport(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                c(context, str, map);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f37572b) {
                    HmsHiAnalyticsUtils.onStreamEvent(0, str, a((Map<String, String>) map));
                    HmsHiAnalyticsUtils.onStreamEvent(1, str, a((Map<String, String>) map));
                    return;
                } else {
                    com.huawei.hms.stats.b.b(context, 0, str, a((Map<String, String>) map));
                    com.huawei.hms.stats.b.b(context, 1, str, a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + andRefreshAnalyticsState);
    }

    public void enableLog() {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.f37572b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    private int a(Context context) {
        int i3 = 0;
        try {
            i3 = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
            HMSLog.i("HiAnalyticsUtils", "getOobeStateForSettings value is " + i3);
            return i3;
        } catch (Settings.SettingNotFoundException e16) {
            HMSLog.i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e16.getMessage());
            return i3;
        }
    }

    private boolean a(boolean z16, boolean z17, Map<?, ?> map) {
        return !z16 && z17 && b(map);
    }

    private boolean b(Map<?, ?> map) {
        try {
            Iterator<?> it = map.values().iterator();
            long j3 = 0;
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    j3 += ((String) r3).getBytes(Charset.forName("UTF-8")).length;
                }
            }
            return j3 <= 512;
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th5.getMessage());
            return false;
        }
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.getBytes(Charset.forName("UTF-8")).length <= 512;
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th5.getMessage());
            return false;
        }
    }

    public void onReport(Context context, String str, Map map, int i3) {
        if (i3 != 0 && i3 != 1) {
            HMSLog.e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                b(context, str, map, i3);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f37572b) {
                    HmsHiAnalyticsUtils.onStreamEvent(i3, str, a((Map<String, String>) map));
                    return;
                } else {
                    com.huawei.hms.stats.b.b(context, i3, str, a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    private void a(Context context, String str, Map<String, String> map) {
        try {
            com.huawei.hms.stats.a.c().a(new a(context.getApplicationContext(), str, map));
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th5.getMessage());
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i3) {
        if (i3 != 0 && i3 != 1) {
            HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                a(context, str, map, i3);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f37572b) {
                    HmsHiAnalyticsUtils.onEvent(i3, str, a((Map<String, String>) map));
                } else {
                    com.huawei.hms.stats.b.a(context, i3, str, a((Map<String, String>) map));
                }
                b(context);
                return;
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    private void b(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new c(context.getApplicationContext(), str, map));
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th5.getMessage());
        }
    }

    private void a(Context context, String str, String str2) {
        try {
            com.huawei.hms.stats.a.c().a(new b(context.getApplicationContext(), str, str2));
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th5.getMessage());
        }
    }

    private void b(Context context, String str, Map map, int i3) {
        try {
            com.huawei.hms.stats.a.c().a(new f(context.getApplicationContext(), str, map, i3));
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th5.getMessage());
        }
    }

    private void a(Context context, String str, Map map, int i3) {
        try {
            com.huawei.hms.stats.a.c().a(new d(context.getApplicationContext(), str, map, i3));
        } catch (Throwable th5) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th5.getMessage());
        }
    }
}
