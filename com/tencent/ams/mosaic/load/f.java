package com.tencent.ams.mosaic.load;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.hippo.quickjs.android.QuickJS;
import com.tencent.ams.mosaic.load.d;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context, d dVar) {
        if (dVar == null) {
            com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "checkSoConfigEffective, config is null");
            return false;
        }
        List<d.c> d16 = dVar.d(context);
        if (d16 != null && !d16.isEmpty()) {
            for (d.c cVar : d16) {
                if (cVar.f71522e != 0) {
                    com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "checkSoConfigEffective, item error. failReason: " + cVar.f71522e);
                    return false;
                }
            }
            return true;
        }
        com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "checkSoConfigEffective, o item list is empty.");
        return false;
    }

    public static boolean b(Context context, d dVar) {
        com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "checkSoFileExist, config: " + dVar);
        if (dVar == null) {
            return false;
        }
        List<d.c> d16 = dVar.d(context);
        if (d16 != null && !d16.isEmpty()) {
            for (d.c cVar : d16) {
                if (cVar.f71522e != 0) {
                    com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "item error. failReason: " + cVar.f71522e);
                    return false;
                }
                String h16 = h(context, cVar);
                String g16 = g(cVar);
                com.tencent.ams.mosaic.utils.f.a("QuickJSSoLoaderHelper", "path: " + h16 + ", name: " + g16);
                File file = new File(h16, g16);
                if (!file.exists()) {
                    com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "so file not exist. " + file.getAbsolutePath());
                    return false;
                }
            }
            return true;
        }
        com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "so item list is empty.");
        return false;
    }

    public static List<String> c(Context context, d dVar) {
        List<d.c> d16;
        ArrayList arrayList = null;
        if (dVar != null && context != null && (d16 = dVar.d(context)) != null && !d16.isEmpty()) {
            arrayList = new ArrayList();
            Iterator<d.c> it = d16.iterator();
            while (it.hasNext()) {
                File e16 = e(context, it.next());
                if (e16 != null) {
                    arrayList.add(e16.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    private static List<File> d(File file) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (file == null) {
            return arrayList;
        }
        if (file.isFile()) {
            arrayList.add(file);
        } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                List<File> d16 = d(file2);
                if (!d16.isEmpty()) {
                    arrayList.addAll(d16);
                }
            }
        }
        return arrayList;
    }

    public static File e(Context context, d.c cVar) {
        if (cVar != null && cVar.f71522e == 0) {
            return new File(h(context, cVar), g(cVar));
        }
        return null;
    }

    public static List<File> f(Context context) {
        String i3 = i(context);
        if (!TextUtils.isEmpty(i3)) {
            return d(new File(i3));
        }
        return null;
    }

    public static String g(d.c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f71518a)) {
            return MosaicUtils.Z(cVar.f71518a) + ".so";
        }
        return null;
    }

    public static String h(Context context, d.c cVar) {
        String i3 = i(context);
        if (!TextUtils.isEmpty(i3) && cVar != null) {
            return new File(i3, cVar.f71520c).getAbsolutePath();
        }
        return null;
    }

    private static String i(Context context) {
        File filesDir;
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(filesDir.getAbsolutePath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("tad_cache");
            sb5.append(str);
            sb5.append("mosaic_so");
            sb5.append(str);
            return sb5.toString();
        }
        return null;
    }

    public static boolean j(String str) {
        boolean z16 = false;
        try {
            String quickJSSoVersion = QuickJS.getQuickJSSoVersion();
            if (MosaicUtils.i(quickJSSoVersion, str) >= 0) {
                z16 = true;
            }
            com.tencent.ams.mosaic.utils.f.e("QuickJSSoLoaderHelper", "isSupportQuickJS, nativeVersion: " + quickJSSoVersion + ", configVersion: " + str + ", result: " + z16);
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("QuickJSSoLoaderHelper", "get quick js so version error.", th5);
        }
        return z16;
    }
}
