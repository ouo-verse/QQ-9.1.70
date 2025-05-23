package com.tencent.qphone.base.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f344420a = "DeviceUtil";

    /* renamed from: b, reason: collision with root package name */
    public static final String f344421b = "key_is_miui6";

    /* renamed from: c, reason: collision with root package name */
    public static final String f344422c = "key_third_push_type";

    /* renamed from: d, reason: collision with root package name */
    public static final int f344423d = 1024;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public static int f344424e = 320;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public static int f344425f = 480;

    /* renamed from: g, reason: collision with root package name */
    private static String f344426g = "";

    /* renamed from: h, reason: collision with root package name */
    public static int f344427h;

    /* renamed from: i, reason: collision with root package name */
    private static long f344428i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f344429a;

        a(d dVar) {
            this.f344429a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean isMIUI6 = CommonBadgeUtilImpl.isMIUI6();
            MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
            if (a16 != null) {
                a16.encodeBool(c.f344421b, isMIUI6);
            }
            this.f344429a.a(isMIUI6);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements FileFilter {
        b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qphone.base.util.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class RunnableC9349c implements Runnable {
        RunnableC9349c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int thirdPushType = BaseApplication.getContext().getThirdPushType();
            MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
            if (a16 != null) {
                a16.encodeInt(c.f344422c, thirdPushType);
            }
            QLog.d("DeviceUtil", 1, "[asyncGetThirdPushType], pushType: " + thirdPushType);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
        void a(boolean z16);
    }

    static {
        WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
        if (windowManager.getDefaultDisplay() != null) {
            f344424e = windowManager.getDefaultDisplay().getWidth();
            f344425f = windowManager.getDefaultDisplay().getHeight();
        }
        f344427h = -1;
        f344428i = 0L;
    }

    public static String a(Context context) {
        try {
            return DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Throwable th5) {
            QLog.e("DeviceUtil", 1, th5, new Object[0]);
            return null;
        }
    }

    private static final int b() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new b()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    @SuppressLint({"NewApi"})
    public static final int c() {
        if (f344427h == -1) {
            f344427h = Runtime.getRuntime().availableProcessors();
        }
        return f344427h;
    }

    public static long[] d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return new long[]{g() / 1048576, (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1048576};
        } catch (Exception e16) {
            e16.printStackTrace();
            return new long[]{-1, -1};
        }
    }

    public static double e() {
        try {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            return Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006a A[Catch: Exception -> 0x006d, TRY_LEAVE, TryCatch #3 {Exception -> 0x006d, blocks: (B:37:0x0065, B:32:0x006a), top: B:36:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long f() {
        FileReader fileReader;
        Throwable th5;
        if (f344428i == 0) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                } catch (Exception unused) {
                    fileReader = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileReader = null;
                }
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader, 1024);
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            f344428i = Long.valueOf(readLine.split("\\s+")[1]).longValue() * 1024;
                        }
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        try {
                            f344428i = 0L;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            if (f344428i == 0) {
                            }
                            return f344428i;
                        } catch (Throwable th7) {
                            BufferedReader bufferedReader3 = bufferedReader;
                            th5 = th7;
                            bufferedReader2 = bufferedReader3;
                            Throwable th8 = th5;
                            bufferedReader = bufferedReader2;
                            th = th8;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                    throw th;
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th9) {
                        th5 = th9;
                        Throwable th82 = th5;
                        bufferedReader = bufferedReader2;
                        th = th82;
                        if (bufferedReader != null) {
                        }
                        if (fileReader != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                } catch (Throwable th10) {
                    th = th10;
                    if (bufferedReader != null) {
                    }
                    if (fileReader != null) {
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                if (f344428i == 0) {
                    return 1073741824L;
                }
                return f344428i;
            }
        }
        return f344428i;
    }

    public static long g() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static int h() {
        int i3;
        MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
        if (a16 != null && a16.containsKey(f344422c)) {
            i3 = a16.decodeInt(f344422c, 0);
        } else {
            int thirdPushType = BaseApplication.getContext().getThirdPushType();
            if (a16 != null) {
                a16.encodeInt(f344422c, thirdPushType);
            }
            i3 = thirdPushType;
        }
        QLog.d("DeviceUtil", 1, "[syncGetThirdPushType], pushType: " + i3);
        a();
        return i3;
    }

    public static boolean i() {
        MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
        if (a16 == null) {
            return CommonBadgeUtilImpl.isMIUI6();
        }
        if (!a16.containsKey(f344421b)) {
            boolean isMIUI6 = CommonBadgeUtilImpl.isMIUI6();
            a16.encodeBool(f344421b, isMIUI6);
            return isMIUI6;
        }
        return a16.decodeBool(f344421b, false);
    }

    public static void a(d dVar) {
        com.tencent.mobileqq.msf.core.q.s().post(new a(dVar));
    }

    public static void a() {
        com.tencent.mobileqq.msf.core.q.s().post(new RunnableC9349c());
    }
}
