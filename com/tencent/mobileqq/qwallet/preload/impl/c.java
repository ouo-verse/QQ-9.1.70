package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f279110a;

        /* renamed from: b, reason: collision with root package name */
        public long f279111b;

        /* renamed from: c, reason: collision with root package name */
        public int f279112c;

        public a(String str, long j3, int i3) {
            this.f279110a = str;
            this.f279111b = j3;
            this.f279112c = i3;
        }
    }

    public static long a(String str, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        return d16.getLong("url_abnormal_retry_last_time" + str, 0L);
    }

    public static int b(String str, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return d16.getInt("url_abnormal_retry_times" + str, 0);
    }

    public static long c(int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 == null) {
            return 0L;
        }
        return d16.getLong("check_surplus_res_time", 0L);
    }

    private static SharedPreferences d(int i3) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            if (i3 == 1) {
                return mobileQQ.getSharedPreferences("qwallet_res_utilinner", 4);
            }
            return mobileQQ.getSharedPreferences("qwallet_res_util", 4);
        }
        return null;
    }

    public static String e(String str, String str2, int i3) {
        String i16 = i(str, "", i3);
        if (TextUtils.isEmpty(i16) && !TextUtils.isEmpty(str2) && new File(str2).exists()) {
            String encodeFile2HexStr = MD5Coding.encodeFile2HexStr(str2);
            q(str, encodeFile2HexStr, i3);
            return encodeFile2HexStr;
        }
        return i16;
    }

    public static ResourceInfo f(String str, boolean z16, int i3, int i16) {
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.url = str;
        String o16 = com.tencent.mobileqq.qwallet.preload.a.o(str, i16);
        if (!TextUtils.isEmpty(o16)) {
            resourceInfo.filePath = o16;
            resourceInfo.fileMd5 = e(str, o16, i16);
            resourceInfo.doneTime = h(str, 0L, i16);
            if (z16 || com.tencent.mobileqq.qwallet.preload.a.s(str, i3)) {
                String folderPathByMD5AndUrl = PreloadResourceImpl.getFolderPathByMD5AndUrl(resourceInfo.fileMd5, str, i16);
                if (PreloadResourceImpl.checkFolderAndUnzip(resourceInfo.filePath, folderPathByMD5AndUrl)) {
                    resourceInfo.folderPath = folderPathByMD5AndUrl;
                }
            }
        }
        return resourceInfo;
    }

    public static List<a> g(int i3) {
        ArrayList arrayList = new ArrayList();
        SharedPreferences d16 = d(i3);
        if (d16 != null) {
            for (Map.Entry<String, ?> entry : d16.getAll().entrySet()) {
                String key = entry.getKey();
                if (key.startsWith("url_last_use_time")) {
                    arrayList.add(new a(key.substring(17, key.length()), ((Long) entry.getValue()).longValue(), i3));
                }
            }
        }
        return arrayList;
    }

    public static long h(String str, long j3, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 != null && !TextUtils.isEmpty(str)) {
            return d16.getLong("url_doneTime" + str, j3);
        }
        return j3;
    }

    public static String i(String str, String str2, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 != null && !TextUtils.isEmpty(str)) {
            return d16.getString("url_md5" + str, str2);
        }
        return str2;
    }

    public static void j(String str, int i3) {
        int b16 = b(str, i3);
        SharedPreferences d16 = d(i3);
        if (d16 != null && !TextUtils.isEmpty(str)) {
            d16.edit().putInt("url_abnormal_retry_times" + str, b16 + 1).putLong("url_abnormal_retry_last_time" + str, NetConnInfoCenter.getServerTimeMillis()).apply();
        }
    }

    public static void k(String str, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 != null && !TextUtils.isEmpty(str)) {
            d16.edit().remove("url_doneTime" + str);
            d16.edit().remove("url_md5" + str);
            d16.edit().remove("url_last_use_time" + str);
            d16.edit().remove("url_abnormal_retry_times" + str).apply();
        }
    }

    public static void l(int i3, PreloadConfig preloadConfig) {
        ResourceInfo f16;
        if (preloadConfig == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis - c(i3) < 86400000) {
            if (QLog.isColorLevel()) {
                QLog.d("ResUtil", 2, "removeSurplusRes already Check Today:" + i3);
                return;
            }
            return;
        }
        String l3 = com.tencent.mobileqq.qwallet.preload.a.l(i3);
        long currentTimeMillis = System.currentTimeMillis();
        long fileOrFolderSize = FileUtils.getFileOrFolderSize(l3);
        if (QLog.isColorLevel()) {
            QLog.d("ResUtil", 2, "resFolderPathSize:" + fileOrFolderSize + "|209715200|" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (fileOrFolderSize > 209715200) {
            for (a aVar : g(i3)) {
                if (aVar != null && !TextUtils.isEmpty(aVar.f279110a) && serverTimeMillis - aVar.f279111b > 2592000000L && !preloadConfig.isUrlInConfig(aVar.f279110a) && (f16 = f(aVar.f279110a, false, 0, aVar.f279112c)) != null) {
                    k(aVar.f279110a, aVar.f279112c);
                    d.d(f16.filePath);
                    d.d(f16.folderPath);
                    b.d(aVar.f279110a, 8, aVar.f279112c);
                }
            }
        }
        m(serverTimeMillis, i3);
    }

    public static void m(long j3, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 != null) {
            d16.edit().putLong("check_surplus_res_time", j3).apply();
        }
    }

    public static void n(String str, int i3, long j3) {
        SharedPreferences d16 = d(i3);
        if (d16 != null && !TextUtils.isEmpty(str)) {
            d16.edit().putLong("url_last_use_time" + str, j3).apply();
        }
    }

    public static void o(String str, String str2, long j3, int i3) {
        q(str, str2, i3);
        p(str, j3, i3);
        n(str, i3, NetConnInfoCenter.getServerTimeMillis());
    }

    public static void p(String str, long j3, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 != null && !TextUtils.isEmpty(str)) {
            d16.edit().putLong("url_doneTime" + str, j3).apply();
        }
    }

    public static void q(String str, String str2, int i3) {
        SharedPreferences d16 = d(i3);
        if (d16 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            d16.edit().putString("url_md5" + str, str2).apply();
        }
    }
}
