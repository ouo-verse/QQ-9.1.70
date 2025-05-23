package c.t.m.sapp.c;

import android.app.ActivityManager;
import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class k {
    public static boolean a(Context context, int i3) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (it.hasNext()) {
                if (it.next().pid == i3) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int b(Context context) {
        List<a> d16 = q.d(q.c(context, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
        int e16 = e(context);
        if (e16 <= 3) {
            q.d(context, "__pro_dex_load_info___sapp", "default");
        }
        if (d16.size() == 0) {
            return 0;
        }
        String c16 = q.c(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
        if (c16 != null && !c16.equals("")) {
            if (a(d16, q.d(c16))) {
                if (e16 > 3) {
                    return 3;
                }
                return 2;
            }
            if (e16 <= 3) {
                return 6;
            }
            return 5;
        }
        return 1;
    }

    public static boolean c(Context context) {
        String a16;
        if (!q.c(context, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", "").equals(g.f30163a)) {
            return false;
        }
        String c16 = q.c(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
        if (c16 == null || c16.equals("")) {
            return false;
        }
        List<a> d16 = q.d(c16);
        if (d16.isEmpty()) {
            return false;
        }
        String c17 = q.c(context, "__bad_dex_info___sapp", "preference_default_sapp");
        List<a> d17 = q.d(c17);
        if (!c17.equals("preference_default_sapp") && !d17.isEmpty() && a(d16, d17)) {
            return false;
        }
        byte[] bArr = new byte[2048];
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(q.f30189b);
        String sb6 = sb5.toString();
        String str2 = context.getFilesDir().getAbsolutePath() + str + "TencentLocation_sapp/UpCp";
        ArrayList<a> arrayList = new ArrayList();
        boolean z16 = true;
        for (a aVar : d16) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str2);
            String str3 = File.separator;
            sb7.append(str3);
            sb7.append(aVar.f30130c);
            List<a> list = d16;
            String str4 = str2;
            if (!q.b(context, sb7.toString(), sb6, "tmp_backup__sapp" + aVar.f30130c, aVar.f30131d, bArr)) {
                File file = new File(sb6 + str3 + "tmp_backup__sapp" + aVar.f30130c);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                d16 = list;
                str2 = str4;
                z16 = false;
            } else {
                arrayList.add(aVar);
                d16 = list;
                str2 = str4;
            }
        }
        List<a> list2 = d16;
        if (!z16) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file2 = new File(sb6 + File.separator + "tmp_backup__sapp" + ((a) it.next()).f30130c);
                if (file2.exists() && file2.isFile()) {
                    file2.delete();
                }
            }
            arrayList.clear();
            return false;
        }
        if (list2.size() == arrayList.size()) {
            for (a aVar2 : arrayList) {
                File file3 = new File(sb6, aVar2.f30130c);
                if (file3.exists() && file3.isFile()) {
                    file3.delete();
                }
                if (new File(sb6, "tmp_backup__sapp" + aVar2.f30130c).renameTo(file3) && ((a16 = q.a(file3)) == null || !a16.equals(aVar2.f30132e))) {
                    return false;
                }
            }
            String a17 = q.a(arrayList);
            q.d(context, "__SP_Tencent_Loc_COMP_INFO__sapp_", a17);
            e.a(context).a("DBC", a17);
            return true;
        }
        return false;
    }

    public static boolean d(Context context) {
        boolean z16;
        String c16 = q.c(context);
        if (!q.a(c16)) {
            i.a("clear private dir failed");
        }
        StringBuilder sb5 = new StringBuilder();
        String str = "TencentLocationComp_sapp";
        sb5.append("TencentLocationComp_sapp");
        sb5.append(File.separator);
        sb5.append("comp_list");
        String b16 = q.b(context, sb5.toString());
        i.a("base comp info:" + b16);
        List<a> d16 = q.d(b16);
        byte[] bArr = new byte[2048];
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = d16.iterator();
        while (true) {
            if (it.hasNext()) {
                a next = it.next();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                String str2 = File.separator;
                sb6.append(str2);
                sb6.append(next.f30130c);
                String sb7 = sb6.toString();
                next.f30130c += QZonePatchService.PATCH_SUFFIX_DEX;
                String str3 = "tmp_asset__sapp" + next.f30130c;
                String str4 = str;
                Iterator<a> it5 = it;
                if (!q.a(context, sb7, c16, str3, next.f30131d, bArr)) {
                    File file = new File(c16 + str2 + str3);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    z16 = false;
                } else {
                    arrayList.add(next);
                    it = it5;
                    str = str4;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                File file2 = new File(c16 + File.separator + "tmp_asset__sapp" + ((a) it6.next()).f30130c);
                if (file2.exists() && file2.isFile()) {
                    file2.delete();
                }
            }
            return false;
        }
        if (arrayList.size() == d16.size()) {
            Iterator it7 = arrayList.iterator();
            while (it7.hasNext()) {
                a aVar = (a) it7.next();
                File file3 = new File(c16, aVar.f30130c);
                if (file3.exists() && file3.isFile()) {
                    file3.delete();
                }
                new File(c16, "tmp_asset__sapp" + aVar.f30130c).renameTo(file3);
            }
            q.d(context, "__SP_Tencent_Loc_COMP_INFO__sapp_", q.a(d16));
            return true;
        }
        return false;
    }

    public static int e(Context context) {
        String c16 = q.c(context, "__pro_dex_load_info___sapp", "default");
        boolean z16 = true;
        if (c16.equals("default")) {
            return 1;
        }
        try {
            String[] split = c16.split("#");
            if (split != null && split.length > 0) {
                boolean z17 = true;
                for (String str : split) {
                    String[] split2 = str.split(ContainerUtils.FIELD_DELIMITER);
                    if (split2 != null && split2.length == 2) {
                        String str2 = split2[1];
                        if (a(context, Integer.parseInt(split2[0]))) {
                            z17 = false;
                        }
                    }
                }
                z16 = z17;
            }
            if (z16) {
                return 3;
            }
            return 4;
        } catch (Exception unused) {
            return 4;
        }
    }

    public static void f(Context context) {
        String d16 = q.d(context);
        if (d16 == null) {
            return;
        }
        int g16 = q.g();
        String c16 = q.c(context, "__pro_dex_load_info___sapp", "default");
        if (c16.equals("default")) {
            q.d(context, "__pro_dex_load_info___sapp", g16 + ContainerUtils.FIELD_DELIMITER + d16 + "#");
            return;
        }
        try {
            String[] split = c16.split("#");
            if (split != null && split.length > 0) {
                boolean z16 = false;
                for (int i3 = 0; i3 < split.length; i3++) {
                    String[] split2 = split[i3].split(ContainerUtils.FIELD_DELIMITER);
                    if (split2 != null && split2.length == 2) {
                        String str = split2[1];
                        Integer.parseInt(split2[0]);
                        if (d16.equals(str)) {
                            split[i3] = g16 + ContainerUtils.FIELD_DELIMITER + d16;
                            z16 = true;
                        }
                    }
                }
                String str2 = "";
                for (String str3 : split) {
                    str2 = str2 + str3 + "#";
                }
                if (!z16) {
                    str2 = str2 + g16 + ContainerUtils.FIELD_DELIMITER + d16 + "#";
                }
                q.d(context, "__pro_dex_load_info___sapp", str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context) {
        try {
            File file = new File(context.getFilesDir(), q.f30190c);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.canRead() && file.canWrite() && file.canExecute()) {
                e.b().a("DMK", "ods:ok");
                return;
            }
            boolean readable = file.setReadable(true);
            e.b().a("DMK", "ods:" + file.setWritable(true) + "_" + readable + "_" + file.setExecutable(true));
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.canRead() && file2.canWrite() && file2.canExecute()) {
                    e.b().a("DMK", "ofs:ok");
                }
                e.b().a("DMK", "ofs:" + file2.setWritable(true) + "_" + file2.setReadable(true) + "_" + file2.setExecutable(true));
            }
        } catch (Throwable th5) {
            e.b().a("DMK", "exp:" + th5.toString());
        }
    }

    public static boolean a(List<a> list, List<a> list2) {
        boolean z16;
        boolean z17 = true;
        for (a aVar : list) {
            if (!aVar.f30130c.contains(QZonePatchService.PATCH_SUFFIX_DEX)) {
                aVar.f30130c += QZonePatchService.PATCH_SUFFIX_DEX;
            }
            Iterator<a> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                a next = it.next();
                if (!next.f30130c.contains(QZonePatchService.PATCH_SUFFIX_DEX)) {
                    next.f30130c += QZonePatchService.PATCH_SUFFIX_DEX;
                }
                if (aVar.f30130c.equals(next.f30130c) && aVar.f30131d == next.f30131d && aVar.f30132e.equals(next.f30132e)) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                z17 = false;
            }
        }
        return z17;
    }
}
