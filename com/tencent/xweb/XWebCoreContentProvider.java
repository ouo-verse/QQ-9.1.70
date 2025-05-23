package com.tencent.xweb;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Marker;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class XWebCoreContentProvider extends ContentProvider {
    public static final String MM_PACKAGE_NAME = "com.tencent.mm";
    public static final int OP_TYPE_GET_FILE = 2;
    public static final int OP_TYPE_INVALID = -1;
    public static final int OP_TYPE_REPORT_KV = 3;
    public static final int OP_TYPE_TEST = 1;
    public static final String URI_APPEND_STR = ".sdk.xweb.XWebCoreProvider";
    public static final String[] XWALK_CORE_PROVIDER_LIST = {"com.tencent.mm"};

    /* renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f385024a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public static AtomicLong f385025b = new AtomicLong(0);

    /* loaded from: classes27.dex */
    public static class CachedInfoMgr {

        /* renamed from: a, reason: collision with root package name */
        public static List f385026a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public static final Object f385027b = new Object();

        public static void add(KVInfo kVInfo) {
            synchronized (f385027b) {
                f385026a.add(kVInfo);
            }
        }

        public static void process() {
            x0.d("XWebCoreContentProvider", "CachedInfoMgr process cached info");
            synchronized (f385027b) {
                for (KVInfo kVInfo : f385026a) {
                    n0.a(kVInfo.key, kVInfo.value);
                }
                f385026a.clear();
            }
        }
    }

    /* loaded from: classes27.dex */
    public static class KVInfo {
        public int key = -1;
        public String value = "";
    }

    /* loaded from: classes27.dex */
    public static class ReportInfo {
        public int errCode = -1;
        public String currentPackageName = "";
        public UriInfo uriInfo = new UriInfo();
    }

    /* loaded from: classes27.dex */
    public static class UriInfo {
        public int opType = -1;
        public String callerName = "";
        public int targetVersion = 0;
        public String targetFileName = "";
    }

    public static void a(Context context, ReportInfo reportInfo) {
        if (reportInfo == null) {
            return;
        }
        String str = reportInfo.errCode + "," + (reportInfo.currentPackageName.length() > 100 ? reportInfo.currentPackageName.substring(0, 99) : reportInfo.currentPackageName) + "," + reportInfo.uriInfo.opType + "," + (reportInfo.uriInfo.callerName.length() > 100 ? reportInfo.uriInfo.callerName.substring(0, 99) : reportInfo.uriInfo.callerName) + "," + reportInfo.uriInfo.targetVersion + "," + (reportInfo.uriInfo.targetFileName.length() > 100 ? reportInfo.uriInfo.targetFileName.substring(0, 99) : reportInfo.uriInfo.targetFileName) + "," + XWebSdk.getXWebSdkVersion() + "," + XWebSdk.getAvailableVersion();
        if (context != null && !"com.tencent.mm".equals(reportInfo.currentPackageName)) {
            x0.b("XWebCoreContentProvider", "doReport need post to mm " + str);
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                x0.c("XWebCoreContentProvider", "doReport content resolver is null");
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(String.valueOf(15625), str);
                contentResolver.insert(buildUri("com.tencent.mm", reportInfo.currentPackageName, 3, 0, ""), contentValues);
                return;
            } catch (Throwable unused) {
                x0.b("XWebCoreContentProvider", "doReport error post to mm");
                return;
            }
        }
        if (n0.c()) {
            x0.b("XWebCoreContentProvider", "doReport " + str);
            n0.a(15625, str);
            return;
        }
        x0.b("XWebCoreContentProvider", "doReport reporter not init, cache " + str);
        KVInfo kVInfo = new KVInfo();
        kVInfo.key = 15625;
        kVInfo.value = str;
        CachedInfoMgr.add(kVInfo);
    }

    public static Uri buildUri(String str, String str2, int i3, int i16, String str3) {
        if (str2.isEmpty()) {
            str2 = " ";
        }
        if (i3 == 2) {
            return Uri.parse("content://" + str + URI_APPEND_STR + "/" + str2 + "/" + i3 + "/" + i16 + "/" + str3);
        }
        return Uri.parse("content://" + str + URI_APPEND_STR + "/" + str2 + "/" + i3);
    }

    public static boolean isBusy() {
        if (!f385024a.get()) {
            x0.d("XWebCoreContentProvider", "isBusy = true, xweb not init yet");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - f385025b.get();
        if (currentTimeMillis >= 0 && currentTimeMillis <= 10000) {
            x0.d("XWebCoreContentProvider", "isBusy = true, is operating now");
            return true;
        }
        x0.d("XWebCoreContentProvider", "isBusy = false");
        return false;
    }

    public static boolean isProvider(String str) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : XWALK_CORE_PROVIDER_LIST) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        x0.c("XWebCoreContentProvider", "isProvider, packageName is null or empty");
        return false;
    }

    public static boolean isSelfProvider() {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c("XWebCoreContentProvider", "isSelfProvider, sApplicationContext is null");
            return true;
        }
        return isProvider(XWalkEnvironment.getApplicationContext().getPackageName());
    }

    public static void onXWebInitFinished() {
        x0.d("XWebCoreContentProvider", "onXWebInitFinished");
        CachedInfoMgr.process();
        f385024a.set(true);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        f385025b.set(System.currentTimeMillis());
        if (contentValues != null && contentValues.size() != 0) {
            if (a(uri).opType != 3) {
                x0.b("XWebCoreContentProvider", "insert wrong opType");
                return null;
            }
            Context context = getContext();
            if (context == null) {
                x0.c("XWebCoreContentProvider", "insert context is null");
                return null;
            }
            if (!"com.tencent.mm".equals(context.getPackageName())) {
                x0.c("XWebCoreContentProvider", "insert current not mm, return");
                return null;
            }
            x0.b("XWebCoreContentProvider", "insert start report");
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                try {
                    int parseInt = Integer.parseInt(entry.getKey());
                    String str = (String) entry.getValue();
                    if (n0.a(parseInt) && str != null && !str.isEmpty()) {
                        if (n0.c()) {
                            x0.b("XWebCoreContentProvider", "insert report " + parseInt + " " + str);
                            n0.a(parseInt, str);
                        } else {
                            x0.b("XWebCoreContentProvider", "insert reporter not init, cache " + parseInt + " " + str);
                            KVInfo kVInfo = new KVInfo();
                            kVInfo.key = parseInt;
                            kVInfo.value = str;
                            CachedInfoMgr.add(kVInfo);
                        }
                    }
                } catch (Throwable th5) {
                    x0.a("XWebCoreContentProvider", "insert parse error", th5);
                }
            }
            return null;
        }
        x0.b("XWebCoreContentProvider", "insert values is null or empty");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        File file;
        f385025b.set(System.currentTimeMillis());
        UriInfo a16 = a(uri);
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.errCode = -1;
        reportInfo.uriInfo = a16;
        Context context = getContext();
        if (context == null) {
            x0.c("XWebCoreContentProvider", "openFile context is null");
            reportInfo.errCode = -2;
            a((Context) null, reportInfo);
            return null;
        }
        a(context, a16);
        String packageName = context.getPackageName();
        reportInfo.currentPackageName = packageName;
        x0.b("XWebCoreContentProvider", "openFile current package: " + packageName);
        if (!isProvider(packageName)) {
            x0.c("XWebCoreContentProvider", "openFile current is not provider");
            reportInfo.errCode = -3;
            a(context, reportInfo);
            return null;
        }
        int i3 = a16.opType;
        if (i3 == 1) {
            x0.b("XWebCoreContentProvider", "openFile test msg from " + a16.callerName);
            reportInfo.errCode = 2;
            a(context, reportInfo);
            return null;
        }
        if (i3 == 2) {
            x0.b("XWebCoreContentProvider", "openFile request from " + a16.callerName);
            File file2 = new File(u0.c(context, a16.targetVersion));
            if (!file2.exists()) {
                file2 = new File(u0.b(context, a16.targetVersion));
                if (!file2.exists()) {
                    x0.b("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + a16.targetVersion);
                    reportInfo.errCode = -4;
                    a(context, reportInfo);
                    return null;
                }
            }
            if (a16.targetFileName.equals(XWalkPlugin.FILELIST_CONFIG_NAME)) {
                if (XWalkEnvironment.getInstalledNewstVersion(context) == -1) {
                    x0.b("XWebCoreContentProvider", "openFile can not get current version");
                    reportInfo.errCode = -8;
                    a(context, reportInfo);
                    return null;
                }
                x0.b("XWebCoreContentProvider", "openFile return listConfigFile");
                reportInfo.errCode = 1;
                a(context, reportInfo);
                return ParcelFileDescriptor.open(file2, 268435456);
            }
            Map a17 = a(file2);
            if (a17 != null && a17.size() != 0) {
                if (a17.containsKey(a16.targetFileName)) {
                    if (a16.targetFileName.equals("base.apk")) {
                        file = new File(u0.a(context, a16.targetVersion));
                    } else {
                        file = new File(u0.a(context, a16.targetVersion, a16.targetFileName));
                    }
                    if (file.exists()) {
                        x0.b("XWebCoreContentProvider", "openFile return file " + a16.targetFileName);
                        reportInfo.errCode = 0;
                        a(context, reportInfo);
                        return ParcelFileDescriptor.open(file, 268435456);
                    }
                    x0.b("XWebCoreContentProvider", "openFile file not exist " + a16.targetFileName);
                    reportInfo.errCode = -6;
                    a(context, reportInfo);
                    return null;
                }
                x0.b("XWebCoreContentProvider", "openFile caller attempt to get file " + a16.targetFileName);
                reportInfo.errCode = -7;
                a(context, reportInfo);
                return null;
            }
            x0.c("XWebCoreContentProvider", "openFile fileMap is null or empty");
            reportInfo.errCode = -5;
            a(context, reportInfo);
            return null;
        }
        x0.b("XWebCoreContentProvider", "openFile invalid uri");
        reportInfo.errCode = -1;
        a(context, reportInfo);
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    public static Map a(File file) {
        BufferedReader bufferedReader;
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!readLine.isEmpty()) {
                        String[] split = readLine.split(":");
                        if (split.length == 2 && (str = split[0]) != null && !str.isEmpty() && (str2 = split[1]) != null && !str2.isEmpty()) {
                            hashMap.put(split[0], split[1]);
                            x0.b("XWebCoreContentProvider", "readListConfigFile found " + split[0]);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        x0.c("XWebCoreContentProvider", "readListConfigFile error: " + th);
                        return hashMap;
                    } finally {
                        w.a(bufferedReader);
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
        return hashMap;
    }

    public static UriInfo a(Uri uri) {
        String str;
        int i3;
        UriInfo uriInfo = new UriInfo();
        uriInfo.opType = -1;
        String uri2 = uri.toString();
        if (uri2.length() > 1000) {
            x0.b("XWebCoreContentProvider", "parseUri exceed max length");
            return uriInfo;
        }
        x0.b("XWebCoreContentProvider", "parseUri " + uri2);
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments != null && pathSegments.size() >= 2) {
            String str2 = pathSegments.get(0);
            if (str2 != null && !str2.isEmpty()) {
                uriInfo.callerName = str2;
                try {
                    int parseInt = Integer.parseInt(pathSegments.get(1));
                    if (parseInt == 1 || parseInt == 3) {
                        if (pathSegments.size() == 2) {
                            uriInfo.opType = parseInt;
                            x0.b("XWebCoreContentProvider", "parseUri result: " + parseInt);
                        } else {
                            x0.b("XWebCoreContentProvider", "parseUri wrong params on test or report");
                        }
                        return uriInfo;
                    }
                    if (parseInt == 2) {
                        if (pathSegments.size() == 4) {
                            str = pathSegments.get(3);
                            try {
                                i3 = Integer.parseInt(pathSegments.get(2));
                            } catch (Throwable th5) {
                                x0.a("XWebCoreContentProvider", "parseUri error parse targetVersion, error", th5);
                            }
                            if (i3 == -1 && str != null && !str.isEmpty()) {
                                uriInfo.opType = parseInt;
                                uriInfo.targetVersion = i3;
                                uriInfo.targetFileName = str;
                                x0.b("XWebCoreContentProvider", "parseUri result: " + parseInt + " " + i3 + " " + str);
                            } else {
                                x0.b("XWebCoreContentProvider", "parseUri wrong params on get file");
                            }
                            return uriInfo;
                        }
                        str = "";
                        i3 = -1;
                        if (i3 == -1) {
                        }
                        x0.b("XWebCoreContentProvider", "parseUri wrong params on get file");
                        return uriInfo;
                    }
                    x0.b("XWebCoreContentProvider", "parseUri invalid opType");
                    return uriInfo;
                } catch (Throwable th6) {
                    x0.a("XWebCoreContentProvider", "parseUri error parse opType, error", th6);
                    return uriInfo;
                }
            }
            x0.b("XWebCoreContentProvider", "parseUri callerName invalid");
            return uriInfo;
        }
        x0.b("XWebCoreContentProvider", "parseUri strList invalid");
        return uriInfo;
    }

    public static void a(Context context, UriInfo uriInfo) {
        try {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid == null) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < packagesForUid.length; i3++) {
                if (i3 != packagesForUid.length - 1) {
                    sb5.append(packagesForUid[i3]);
                    sb5.append(Marker.ANY_NON_NULL_MARKER);
                } else {
                    sb5.append(packagesForUid[i3]);
                }
            }
            String sb6 = sb5.toString();
            if (sb6.isEmpty()) {
                return;
            }
            uriInfo.callerName = sb6;
        } catch (Throwable th5) {
            x0.a("XWebCoreContentProvider", "tryRefillCallerName error", th5);
        }
    }
}
