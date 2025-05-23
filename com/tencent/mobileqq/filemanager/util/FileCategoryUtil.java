package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ReflectBuilder;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileCategoryUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Comparator<FileInfo> f209145a = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Comparator<FileInfo> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            return -Long.valueOf(fileInfo.e()).compareTo(Long.valueOf(fileInfo2.e()));
        }
    }

    public static List<PackageInfo> a(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            List<PackageInfo> installedPackages = InstalledAppListMonitor.getInstalledPackages(context.getPackageManager(), 1024);
            for (int i3 = 0; i3 < installedPackages.size(); i3++) {
                PackageInfo packageInfo = installedPackages.get(i3);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0 && FileUtils.fileExists(applicationInfo.publicSourceDir)) {
                    arrayList.add(packageInfo);
                }
            }
        } catch (Exception e16) {
            QLog.e("FileCategoryUtil", 1, e16, new Object[0]);
        }
        return arrayList;
    }

    public static Drawable b(Context context, String str) {
        ApplicationInfo applicationInfo;
        Drawable foreground;
        Drawable background;
        Drawable drawable = null;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null && (applicationInfo = packageArchiveInfo.applicationInfo) != null) {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                new ReflectBuilder().g(8192).d(true).e("addAssetPath").f(AssetManager.class, assetManager).b(String.class).a(str).c();
                Drawable drawable2 = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration()).getDrawable(applicationInfo.icon);
                try {
                    if (j(drawable2)) {
                        return null;
                    }
                    if (Build.VERSION.SDK_INT >= 26 && (drawable2 instanceof AdaptiveIconDrawable)) {
                        AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable2;
                        foreground = adaptiveIconDrawable.getForeground();
                        background = adaptiveIconDrawable.getBackground();
                        if (i(foreground, background)) {
                            return null;
                        }
                        return drawable2;
                    }
                    return drawable2;
                } catch (ReflectBuilder.WrongParamException e16) {
                    e = e16;
                    drawable = drawable2;
                    e.printStackTrace();
                    return drawable;
                } catch (IllegalAccessException e17) {
                    e = e17;
                    drawable = drawable2;
                    e.printStackTrace();
                    return drawable;
                } catch (InstantiationException e18) {
                    e = e18;
                    drawable = drawable2;
                    e.printStackTrace();
                    return drawable;
                } catch (NoSuchMethodException e19) {
                    e = e19;
                    drawable = drawable2;
                    e.printStackTrace();
                    return drawable;
                } catch (InvocationTargetException e26) {
                    e = e26;
                    drawable = drawable2;
                    e.printStackTrace();
                    return drawable;
                }
            }
            return null;
        } catch (ReflectBuilder.WrongParamException e27) {
            e = e27;
        } catch (IllegalAccessException e28) {
            e = e28;
        } catch (InstantiationException e29) {
            e = e29;
        } catch (NoSuchMethodException e36) {
            e = e36;
        } catch (InvocationTargetException e37) {
            e = e37;
        }
    }

    public static boolean c(final String str, final s sVar) {
        if (str == null) {
            return false;
        }
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.FileCategoryUtil.3
            @Override // java.lang.Runnable
            public void run() {
                PackageManager packageManager = BaseApplication.getContext().getPackageManager();
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
                if (packageArchiveInfo != null) {
                    sVar.a(packageArchiveInfo.applicationInfo.loadLabel(packageManager).toString() + ".apk", packageArchiveInfo.applicationInfo.packageName);
                    return;
                }
                String h06 = ah.h0(str);
                sVar.a(h06, h06);
            }
        });
        return true;
    }

    public static PackageInfo d(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 1024);
        } catch (PackageManager.NameNotFoundException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.i("FileCategoryUtil", 4, "getApp: ", e16);
                return null;
            }
            return null;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        PackageManager packageManager = BaseApplication.getContext().getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.applicationInfo.loadLabel(packageManager).toString();
        }
        return ah.h0(str);
    }

    public static String f(long j3) {
        if (j3 <= 0) {
            return "";
        }
        float baseNumber = FileUtils.getBaseNumber();
        double baseNumberThreshold = FileUtils.getBaseNumberThreshold();
        double d16 = j3;
        if (d16 < baseNumber * baseNumberThreshold) {
            return j3 + "B";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        float f16 = baseNumber * baseNumber;
        if (d16 < f16 * baseNumberThreshold) {
            return decimalFormat.format(((float) j3) / baseNumber) + "KB";
        }
        if (d16 < f16 * baseNumber * baseNumberThreshold) {
            return decimalFormat.format((((float) j3) / baseNumber) / baseNumber) + "MB";
        }
        if (d16 < r6 * baseNumber * baseNumberThreshold) {
            return decimalFormat.format(((((float) j3) / baseNumber) / baseNumber) / baseNumber) + "GB";
        }
        return decimalFormat.format((((((float) j3) / baseNumber) / baseNumber) / baseNumber) / baseNumber) + "TB";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0017, code lost:
    
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(Context context) {
        Cursor cursor = null;
        int i3 = 0;
        try {
            try {
                cursor = n(context, "1=1 )GROUP BY (_data", null, 0);
                i3 = cursor.getCount();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            cursor.close();
            return i3;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public static String h(boolean z16, boolean z17, int i3, String str, String str2) {
        int i16;
        if (!z16) {
            i16 = R.string.f187343tq;
        } else if (z17) {
            i16 = R.string.f187353tr;
        } else {
            i16 = R.string.f187333tp;
        }
        return BaseApplication.getContext().getString(i16, str, String.valueOf(i3), str2);
    }

    private static boolean i(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable2 == null || (drawable instanceof SkinnableBitmapDrawable) || (drawable instanceof SkinnableNinePatchDrawable) || (drawable2 instanceof SkinnableNinePatchDrawable) || (drawable2 instanceof SkinnableBitmapDrawable)) {
            return true;
        }
        return false;
    }

    private static boolean j(Drawable drawable) {
        if (drawable == null || (drawable instanceof SkinnableBitmapDrawable) || (drawable instanceof SkinnableNinePatchDrawable)) {
            return true;
        }
        return false;
    }

    private static Cursor k(Context context, String str, String[] strArr, int i3) {
        return ContactsMonitor.query(context.getContentResolver(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_data"}, str, strArr, "date_added desc");
    }

    public static Map<String, List<FileInfo>> l(Context context) {
        Map<String, List<FileInfo>> m3 = m(context, null, 0);
        if (m3 != null) {
            v(m3);
        }
        return m3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (r1 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
    
        if (r1 != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, List<FileInfo>> m(Context context, String str, int i3) {
        Cursor cursor;
        ?? r06 = 0;
        r0 = null;
        Map<String, List<FileInfo>> map = null;
        try {
            try {
                cursor = k(context, str, null, i3);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r06 != 0) {
                }
                throw th;
            }
            try {
                map = w(cursor, 1);
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
            r06 = context;
            if (r06 != 0) {
                r06.close();
            }
            throw th;
        }
    }

    private static Cursor n(Context context, String str, String[] strArr, int i3) {
        return ContactsMonitor.query(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_id", "bucket_display_name"}, str, strArr, "date_added desc");
    }

    public static Map<String, List<FileInfo>> o(Context context) {
        Map<String, List<FileInfo>> p16 = p(context, null, 0);
        if (p16 != null) {
            v(p16);
        }
        return p16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (r1 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
    
        if (r1 != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, List<FileInfo>> p(Context context, String str, int i3) {
        Cursor cursor;
        ?? r06 = 0;
        r0 = null;
        Map<String, List<FileInfo>> map = null;
        try {
            try {
                cursor = n(context, str, null, i3);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r06 != 0) {
                }
                throw th;
            }
            try {
                map = w(cursor, 0);
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
            r06 = context;
            if (r06 != 0) {
                r06.close();
            }
            throw th;
        }
    }

    private static Cursor q(Context context, String str, String[] strArr, int i3) {
        return ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "bucket_display_name", "_data", "bucket_id", "bucket_display_name"}, str, strArr, "date_added desc");
    }

    public static Map<String, List<FileInfo>> r(Context context) {
        Map<String, List<FileInfo>> s16 = s(context, null, 0);
        if (s16 != null) {
            v(s16);
        }
        return s16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (r1 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
    
        if (r1 != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, List<FileInfo>> s(Context context, String str, int i3) {
        Cursor cursor;
        ?? r06 = 0;
        r0 = null;
        Map<String, List<FileInfo>> map = null;
        try {
            try {
                cursor = q(context, str, null, i3);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r06 != 0) {
                }
                throw th;
            }
            try {
                map = w(cursor, 2);
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
            r06 = context;
            if (r06 != 0) {
                r06.close();
            }
            throw th;
        }
    }

    @TargetApi(9)
    public static List<FileInfo> t(Context context, qb1.f fVar) {
        ArrayList arrayList = new ArrayList();
        List<PackageInfo> a16 = a(context);
        PackageManager packageManager = context.getPackageManager();
        for (PackageInfo packageInfo : a16) {
            try {
                FileInfo fileInfo = new FileInfo(packageInfo.applicationInfo.publicSourceDir);
                fileInfo.B(5);
                fileInfo.y(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                fileInfo.q(packageInfo.applicationInfo.packageName + ".apk");
                fileInfo.r(packageInfo.lastUpdateTime);
                fileInfo.u(HardCodeUtil.qqStr(R.string.zyj));
                arrayList.add(fileInfo);
                if (fVar != null) {
                    fVar.d(fileInfo);
                }
            } catch (Exception e16) {
                QLog.d("FileCategoryUtil", 1, e16, new Object[0]);
            }
        }
        Collections.sort(arrayList, f209145a);
        return arrayList;
    }

    public static void u(boolean z16, String str, String str2, String str3, HashMap<String, List<FileInfo>> hashMap, qb1.f fVar) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        if (fVar != null && fVar.c()) {
            return;
        }
        try {
            LockMethodProxy.sleep(0L);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        File file = new File(str);
        if (file.isDirectory()) {
            if (file.getName().indexOf(".") == 0 || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (!new File(listFiles[i3].getAbsolutePath()).isDirectory() || z16) {
                    u(z16, listFiles[i3].getAbsolutePath(), str2, str3, hashMap, fVar);
                }
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("scanFileList", 1, "inFilter[" + str2 + "],outOfFilter[" + str3 + "],path[" + str + "]");
        }
        String extension = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(str);
        if (str2 != null && str2.length() > 0) {
            if (extension != null && extension.length() > 1) {
                extension = extension.toLowerCase();
                if (str2.indexOf(extension) < 0) {
                    return;
                }
            } else {
                return;
            }
        }
        if (extension != null && extension.length() > 1 && str3 != null && str3.length() > 0) {
            extension = extension.toLowerCase();
            if (str3.indexOf(extension) >= 0) {
                return;
            }
        }
        FileInfo b16 = FileInfo.b(str);
        if (b16 == null) {
            return;
        }
        if (!hashMap.containsKey(extension)) {
            hashMap.put(extension, new ArrayList());
        }
        if (fVar != null) {
            fVar.d(b16);
        }
        hashMap.get(extension).add(b16);
    }

    public static void v(Map<String, List<FileInfo>> map) {
        if (map == null) {
            return;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            Collections.sort(map.get(it.next()), f209145a);
        }
    }

    private static Map<String, List<FileInfo>> w(Cursor cursor, int i3) {
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        String str;
        String qqStr;
        FileInfo b16;
        if (cursor.getCount() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (i3 != 0) {
            columnIndexOrThrow = 0;
            if (i3 != 1) {
                if (i3 != 2) {
                    columnIndexOrThrow4 = 0;
                    columnIndexOrThrow3 = 0;
                    columnIndexOrThrow2 = 0;
                } else {
                    columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                    columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_id");
                    columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("bucket_id");
                    columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("bucket_display_name");
                }
            } else {
                int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("_data");
                columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_id");
                columnIndexOrThrow3 = 0;
                columnIndexOrThrow = columnIndexOrThrow5;
                columnIndexOrThrow4 = 0;
            }
        } else {
            columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
            columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_id");
            columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("bucket_id");
            columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("bucket_display_name");
        }
        if (cu.e()) {
            str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + File.separator + "Camera";
        } else {
            str = "/storage/emulated/0/DCIM/Camera";
        }
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndexOrThrow);
            int i16 = cursor.getInt(columnIndexOrThrow2);
            cursor.getInt(columnIndexOrThrow3);
            if (i3 != 1) {
                if (!TextUtils.isEmpty(string) && (string.contains(str) || string.contains("/storage/sdcard1/DCIM/Camera"))) {
                    qqStr = "camera";
                } else {
                    qqStr = cursor.getString(columnIndexOrThrow4);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.bad);
            }
            if (string != null && (b16 = FileInfo.b(string)) != null) {
                b16.x(i16);
                b16.B(i3);
                b16.u(qqStr);
                if (!hashMap.containsKey(qqStr)) {
                    hashMap.put(qqStr, new ArrayList());
                }
                ((List) hashMap.get(qqStr)).add(b16);
            }
        }
        return hashMap;
    }

    public static void x(final FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null || fileManagerEntity.nFileType != 5 || fileManagerEntity.getCloudType() != 3) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.FileCategoryUtil.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                PackageInfo d16;
                if (!q.p(FileManagerEntity.this.getFilePath()) && (str = FileManagerEntity.this.strApkPackageName) != null && str.length() != 0 && (d16 = FileCategoryUtil.d(BaseApplication.getContext(), FileManagerEntity.this.strApkPackageName)) != null) {
                    FileManagerEntity.this.setFilePath(d16.applicationInfo.publicSourceDir);
                    FileManagerEntity fileManagerEntity2 = FileManagerEntity.this;
                    fileManagerEntity2.fileName = FileCategoryUtil.e(fileManagerEntity2.getFilePath());
                }
            }
        }, 8, null, false);
    }
}
