package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mw {

    /* renamed from: a, reason: collision with root package name */
    private static final String f149347a = "tencentmap";

    /* renamed from: b, reason: collision with root package name */
    private static final String f149348b = "/mapsdk_vector/";

    /* renamed from: c, reason: collision with root package name */
    private static String f149349c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f149350d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f149351e = "resourceVersion.dat";

    private static InputStream a(Context context, String str, String str2) {
        return b(context, str + str2);
    }

    public static final InputStream b(Context context, String str) {
        AssetManager assets;
        if (context == null || (assets = context.getAssets()) == null) {
            return null;
        }
        try {
            return assets.open(str);
        } catch (IOException e16) {
            LogUtil.b("asset", e16.getMessage(), e16);
            return null;
        }
    }

    public static void c(mv mvVar, String str) {
        String str2;
        File file = new File(str, er.f148273b);
        String a16 = mvVar.a("indoormap_style_md5");
        String str3 = null;
        if (!TextUtils.isEmpty(a16)) {
            LogUtil.b(ky.f149101g, "\u6821\u9a8c\u6587\u4ef6:indoor_style.dat");
            try {
                str2 = li.a(file);
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                str2 = null;
            }
            if (!TextUtils.equals(str2, a16)) {
                LogUtil.b(ky.f149101g, "\u6587\u4ef6md5\u6821\u9a8c\u5931\u8d25:" + str2 + "," + str2);
                file.delete();
                mvVar.a(new String[]{"indoormap_style_version", "indoormap_style_md5"});
            }
        }
        File file2 = new File(str, er.f148274c);
        String a17 = mvVar.a("indoormap_style_night_md5");
        if (!TextUtils.isEmpty(a17)) {
            LogUtil.b(ky.f149101g, "\u6821\u9a8c\u6587\u4ef6:indoor_style_night.dat");
            try {
                str3 = li.a(file2);
            } catch (FileNotFoundException e17) {
                e17.printStackTrace();
            }
            if (!TextUtils.equals(str3, a17)) {
                LogUtil.b(ky.f149101g, "\u6587\u4ef6md5\u6821\u9a8c\u5931\u8d25:" + str3 + "," + a17);
                file2.delete();
                mvVar.a(new String[]{"indoormap_style_night_version", "indoormap_style_night_md5"});
            }
        }
    }

    public static void d(mv mvVar, String str) {
        File file = new File(str, er.f148276e);
        String a16 = mvVar.a(et.f148322y);
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        try {
            if (TextUtils.equals(li.a(file), a16)) {
                return;
            }
            file.delete();
            mvVar.a(new String[]{et.f148316s, et.f148322y});
        } catch (FileNotFoundException e16) {
            LogUtil.c("config error: ", e16);
            mvVar.a(new String[]{et.f148316s, et.f148322y});
        }
    }

    public static void a(Context context, mv mvVar, String str, String str2) {
        InputStream inputStream;
        File file = new File(str, str2);
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = ku.b(mz.a(context, (TencentMapOptions) null).b((String) null) + str2);
            if (inputStream == null) {
                try {
                    try {
                        if (f149349c != null) {
                            if (!file.exists() || a(context, mvVar, f149349c, str2, true)) {
                                inputStream = b(context, f149349c + str2);
                            }
                        } else if (f149350d != null && (!file.exists() || a(context, mvVar, f149350d, str2, false))) {
                            inputStream = ku.b(f149350d + str2);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        ku.a(fileOutputStream);
                        ku.a((Closeable) inputStream);
                        throw th;
                    }
                } catch (IOException e16) {
                    e = e16;
                    e.printStackTrace();
                    ku.a(fileOutputStream);
                    ku.a((Closeable) inputStream);
                }
            }
            if (inputStream == null) {
                String e17 = mz.a(context, (TencentMapOptions) null).e();
                if (!file.exists() || a(context, mvVar, e17, str2, false)) {
                    inputStream = ku.b(e17 + str2);
                }
            }
            if (inputStream == null && (!file.exists() || a(context, mvVar, ho.f148701d, str2, true))) {
                inputStream = a(context, str2);
            }
        } catch (IOException e18) {
            e = e18;
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
        if (inputStream != null) {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                ku.a(inputStream, fileOutputStream2);
                ku.a(fileOutputStream2);
            } catch (IOException e19) {
                fileOutputStream = fileOutputStream2;
                e = e19;
                e.printStackTrace();
                ku.a(fileOutputStream);
                ku.a((Closeable) inputStream);
            } catch (Throwable th7) {
                fileOutputStream = fileOutputStream2;
                th = th7;
                ku.a(fileOutputStream);
                ku.a((Closeable) inputStream);
                throw th;
            }
            ku.a((Closeable) inputStream);
        }
        ku.a(fileOutputStream);
        ku.a((Closeable) inputStream);
    }

    public static boolean b(mv mvVar, String str) {
        File file = new File(str, er.f148272a);
        String a16 = mvVar.a(et.f148317t);
        if (!file.exists() && TextUtils.isEmpty(a16)) {
            return true;
        }
        try {
            if (TextUtils.equals(li.a(file), a16)) {
                return true;
            }
            file.delete();
            mvVar.a();
            return false;
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
            mvVar.a();
            return false;
        }
    }

    private static void b(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        f149350d = str;
    }

    public static String b() {
        return f149350d;
    }

    public static void a(mv mvVar, String str) {
        if (b(mvVar, str)) {
            c(mvVar, str);
            d(mvVar, str);
        }
    }

    private static boolean a(Context context, mv mvVar, String str, String str2, boolean z16) {
        String str3;
        InputStream b16;
        if (mvVar == null || (mvVar instanceof mx)) {
            return false;
        }
        String str4 = er.f148280i;
        InputStream inputStream = null;
        if (str2.startsWith(er.f148280i)) {
            str3 = et.f148298a;
        } else {
            str4 = er.f148281j;
            if (str2.startsWith(er.f148281j)) {
                str3 = et.f148301d;
            } else {
                str4 = "poi_icon";
                if (str2.startsWith("poi_icon")) {
                    str3 = et.f148300c;
                } else {
                    str3 = null;
                    str4 = null;
                }
            }
        }
        if (str4 == null) {
            return false;
        }
        int b17 = mvVar.b(str3);
        String str5 = str + f149351e;
        try {
            if (z16) {
                b16 = b(context, str5);
            } else {
                b16 = ku.b(str5);
            }
            inputStream = b16;
            if (inputStream == null) {
                return false;
            }
            byte[] b18 = ku.b(inputStream);
            if (b18 == null) {
                return false;
            }
            int optInt = new JSONObject(new String(b18)).optInt(str4, -1);
            if (optInt == -1) {
                return false;
            }
            if (optInt <= b17) {
                return false;
            }
            mvVar.a(new String[]{str3});
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        } finally {
            ku.a((Closeable) inputStream);
        }
    }

    private static void a(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        f149349c = str;
    }

    public static String a() {
        return f149349c;
    }

    public static void a(TencentMapOptions tencentMapOptions) {
        String customLocalPath;
        if (tencentMapOptions != null) {
            if (tencentMapOptions.getCustomAssetsPath() != null) {
                String customAssetsPath = tencentMapOptions.getCustomAssetsPath();
                if (customAssetsPath == null || customAssetsPath.trim().length() == 0) {
                    return;
                }
                String str = File.separator;
                if (!customAssetsPath.endsWith(str)) {
                    customAssetsPath = customAssetsPath + str;
                }
                f149349c = customAssetsPath;
                return;
            }
            if (tencentMapOptions.getCustomLocalPath() == null || (customLocalPath = tencentMapOptions.getCustomLocalPath()) == null || customLocalPath.trim().length() == 0) {
                return;
            }
            String str2 = File.separator;
            if (!customLocalPath.endsWith(str2)) {
                customLocalPath = customLocalPath + str2;
            }
            f149350d = customLocalPath;
        }
    }

    public static final InputStream a(Context context, String str) {
        return b(context, ho.f148701d + str);
    }
}
