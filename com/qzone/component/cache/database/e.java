package com.qzone.component.cache.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    protected static final Object f46678d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static boolean f46679e = false;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, ArrayList<String>> f46680a = new ConcurrentHashMap(32);

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, ArrayList<String>> f46681b = new ConcurrentHashMap(32);

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f46682c;

    public e(SQLiteDatabase sQLiteDatabase) {
        this.f46682c = sQLiteDatabase;
    }

    private ArrayList<String> a(String str) {
        if (this.f46681b.containsKey(str)) {
            return this.f46681b.get(str);
        }
        Matcher matcher = Pattern.compile("\\s*\\w+\\s*(!<|!>|>|<|==|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(str);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            Matcher matcher2 = Pattern.compile("\\w+").matcher(matcher.group().trim());
            matcher2.find();
            arrayList.add(matcher2.group());
        }
        this.f46681b.put(str, arrayList);
        return arrayList;
    }

    private ArrayList<String> b(String str, String[] strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("DbCacheDatabase.EncryptUtil", 2, str);
        }
        try {
            String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : strArr) {
                String trim = str2.toLowerCase().trim();
                for (String str3 : split) {
                    String[] split2 = str3.trim().split(" ");
                    if (split2.length > 1 && trim.equals(split2[1].toLowerCase())) {
                        arrayList.add(split2[0]);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DbCacheDatabase.EncryptUtil", 2, "analyseTableField exception: ", e16);
            }
            return new ArrayList<>();
        }
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("@$#%&^")) {
            return str;
        }
        synchronized (f46678d) {
            String substring = str.substring(6);
            String encode = substring.length() > 0 ? SecurityUtile.encode(substring) : substring;
            if (TextUtils.isEmpty(encode) || encode.equals(substring)) {
                try {
                    LockMethodProxy.sleep(200L);
                } catch (Exception e16) {
                    QZLog.e("DbCacheDatabase.EncryptUtil", 1, e16, new Object[0]);
                }
                encode = SecurityUtile.encode(substring);
                if (!TextUtils.isEmpty(encode)) {
                    if (encode.equals(substring)) {
                    }
                }
                l(0);
                u5.c.D("dbencrypt_" + QUA.getQUA3(), 0);
                return encode;
            }
            return encode;
        }
    }

    public static String g(String str) {
        if (!i() || TextUtils.isEmpty(str) || str.startsWith("@$#%&^")) {
            return str;
        }
        String encode = str.length() > 0 ? SecurityUtile.encode(str) : str;
        if (!TextUtils.isEmpty(encode) && !encode.equals(str)) {
            return "@$#%&^" + encode;
        }
        l(1);
        return str;
    }

    public static boolean i() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", "db_encryption", 0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dbencrypt_");
        sb5.append(QUA.getQUA3());
        return config == 1 && u5.c.h(sb5.toString(), 1) == 1;
    }

    public static boolean j(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            if (str2.equals("ContentCache") && str.equals(AbstractDbCacheManager.k(MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin(), c.f46667e))) {
                return true;
            }
            if (str2.equals("UserInfoTB") && str.equals(AbstractDbCacheManager.k(-1L, c.f46668f))) {
                return true;
            }
        }
        return false;
    }

    private Cursor k(String str, String[] strArr) {
        System.currentTimeMillis();
        try {
            Cursor rawQuery = this.f46682c.rawQuery(str, strArr);
            if (rawQuery == null) {
                return null;
            }
            try {
                return new d(rawQuery, this.f46682c.getPath());
            } catch (Throwable unused) {
                return rawQuery;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void l(int i3) {
        if (f46679e) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", "0");
        hashMap.put("type", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), StatisticCollector.QZONE_DB_ENCRYPT_ERROR, true, 0L, 0L, hashMap, (String) null, true);
        f46679e = true;
    }

    public ArrayList<String> h(String str) {
        Cursor k3;
        if (!i()) {
            return null;
        }
        if (!this.f46680a.containsKey(str) && (k3 = k("select sql from sqlite_master where type=? and name=?", new String[]{"table", str})) != null) {
            if (k3.moveToFirst()) {
                this.f46680a.put(str, b(k3.getString(0), new String[]{"STRING"}));
            }
            k3.close();
        }
        return this.f46680a.get(str);
    }

    private byte[] c(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : SecurityUtile.encode(bArr);
    }

    public ContentValues d(String str, String str2, ContentValues contentValues) {
        if (contentValues == null || contentValues.size() <= 0 || !j(str, str2)) {
            return contentValues;
        }
        ContentValues contentValues2 = new ContentValues(contentValues);
        ArrayList<String> h16 = h(str2);
        if (h16 != null) {
            Iterator<String> it = h16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (contentValues.containsKey(next)) {
                    Object obj = contentValues.get(next);
                    if (obj instanceof String) {
                        String str3 = (String) contentValues.get(next);
                        if (str3 != null && str3.length() > 0) {
                            contentValues2.put(next, g(str3));
                        }
                    } else if (obj instanceof byte[]) {
                        contentValues2.put(next, c((byte[]) obj));
                    } else if (obj instanceof Long) {
                        contentValues2.put(next, g(String.valueOf(obj)));
                    } else if (obj instanceof Integer) {
                        contentValues2.put(next, g(String.valueOf(obj)));
                    } else if (obj instanceof Double) {
                        contentValues2.put(next, g(String.valueOf(obj)));
                    }
                }
            }
        }
        return contentValues2;
    }

    public void e(String str, String str2, String str3, String[] strArr) {
        ArrayList<String> h16;
        if (str3 == null || strArr == null || !j(str, str2) || (h16 = h(str2)) == null) {
            return;
        }
        ArrayList<String> a16 = a(str3);
        for (int i3 = 0; i3 < a16.size(); i3++) {
            if (h16.contains(a16.get(i3))) {
                String str4 = strArr[i3];
                if (str4 instanceof String) {
                    strArr[i3] = g(str4);
                }
            }
        }
    }
}
