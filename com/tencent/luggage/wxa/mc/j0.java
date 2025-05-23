package com.tencent.luggage.wxa.mc;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j0 implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f134315a = new j0();

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f134316b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f134317c;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("content://");
        String str = com.tencent.luggage.wxa.o7.a.f136193a;
        sb5.append(str);
        sb5.append("/");
        sb5.append("AppBrandWxaPkgManifestRecord");
        f134316b = Uri.parse(sb5.toString());
        f134317c = Uri.parse("content://" + str + "/WxaPluginCodeVersionInfo");
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 a(String str, int i3, int i16, String... strArr) {
        int i17;
        StringBuilder sb5;
        long a16 = w0.a();
        try {
            sb5 = new StringBuilder();
            for (String str2 : h0.Z) {
                try {
                    sb5.append(str2);
                    sb5.append("=? and ");
                } catch (Throwable th5) {
                    th = th5;
                    i17 = i3;
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", str, Integer.valueOf(i17), Integer.valueOf(i16), Arrays.toString(strArr), Long.valueOf(w0.a() - a16));
                    throw th;
                }
            }
            sb5.append("1=1");
            i17 = e.a.a(i16) ? 1 : i3;
        } catch (Throwable th6) {
            th = th6;
            i17 = i3;
        }
        try {
            h0 h0Var = null;
            Cursor a17 = a("AppBrandWxaPkgManifestRecord", w0.a(strArr) ? null : strArr, sb5.toString(), new String[]{str, String.valueOf(i17), String.valueOf(i16)}, null, null, null);
            if (a17 == null) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", str, Integer.valueOf(i17), Integer.valueOf(i16), Arrays.toString(strArr), Long.valueOf(w0.a() - a16));
                return null;
            }
            if (a17.moveToFirst()) {
                h0 h0Var2 = new h0();
                h0Var2.a(a17);
                h0Var2.f138305b = str;
                h0Var2.f138307d = i17;
                try {
                    h0Var2.f138319p = i16;
                    h0Var = h0Var2;
                } catch (Throwable th7) {
                    th = th7;
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", str, Integer.valueOf(i17), Integer.valueOf(i16), Arrays.toString(strArr), Long.valueOf(w0.a() - a16));
                    throw th;
                }
            }
            a17.close();
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", str, Integer.valueOf(i17), Integer.valueOf(i16), Arrays.toString(strArr), Long.valueOf(w0.a() - a16));
            return h0Var;
        } catch (Throwable th8) {
            th = th8;
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", str, Integer.valueOf(i17), Integer.valueOf(i16), Arrays.toString(strArr), Long.valueOf(w0.a() - a16));
            throw th;
        }
    }

    public static j0 a() {
        return f134315a;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f134316b, strArr, str2, strArr2, str5);
    }

    public boolean a(String str, int i3, int i16, String str2) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgResolver", "updateModuleList appId:%s, pkgType:%d, pkgVersion:%d", str, Integer.valueOf(i3), Integer.valueOf(i16));
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_MODULE_LIST");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(i16));
            contentValues.put("CONTENT_KEY_MODULE_LIST_JSON", str2);
            com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f134316b, contentValues);
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgResolver", "updateModuleList failed appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", str, Integer.valueOf(i3), Integer.valueOf(i16), e16);
            return false;
        }
    }

    public boolean a(String str, int i3, int i16) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgResolver", "deleteModuleList appId:%s, pkgType:%d, pkgVersion:%d", str, Integer.valueOf(i3), Integer.valueOf(i16));
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_DELETE_MODULE_LIST");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(i16));
            com.tencent.luggage.wxa.tn.z.c().getContentResolver().update(f134316b, contentValues, null, null);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgResolver", "deleteModuleList failed, appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", str, Integer.valueOf(i3), Integer.valueOf(i16), e16);
        }
        return true;
    }

    public final boolean b(h0 h0Var) {
        if (e.a.a(h0Var.f138319p)) {
            h0Var.f138307d = 1;
        }
        ContentValues a16 = h0Var.a();
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = new String[h0.Z.length];
        int i3 = 0;
        while (true) {
            String[] strArr2 = h0.Z;
            if (i3 >= strArr2.length) {
                break;
            }
            String str = strArr2[i3];
            sb5.append(str);
            sb5.append(" =? AND ");
            strArr[i3] = a16.getAsString(str);
            a16.remove(str);
            i3++;
        }
        sb5.append(" 1=1 ");
        a16.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_MANIFEST");
        return com.tencent.luggage.wxa.tn.z.c().getContentResolver().update(f134316b, a16, sb5.toString(), strArr) > 0;
    }

    public boolean a(String str, int i3, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("CONTENT_KEY_ACTION", "ACTION_FLUSH_WXA_DEBUG_PKG_INFO");
                contentValues.put("CONTENT_KEY_APPID", str);
                contentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(i3));
                contentValues.put("CONTENT_KEY_PKG_VERSION_MD5", str3);
                contentValues.put("CONTENT_KEY_PKG_DOWNLOAD_URL", str2);
                return com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f134316b, contentValues) != null;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("Luggage.WxaPkgResolver", e16, "flushWxaDebugAppVersionInfo appId[%s] type[%d] md5p[%s]", str, Integer.valueOf(i3), str3);
            }
        }
        return false;
    }

    public void a(String str, String str2, int i3, int i16, String str3, int i17) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACIION_UPDATE_WITHOUT_PLUGINCODE_INFO");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_MODULE_NAME", str2);
            contentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(i16));
            contentValues.put("CONTENT_KEY_PKG_VERSION_MD5", str3);
            contentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(i17));
            com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f134316b, contentValues);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WxaPkgResolver", e16, "updateWithoutPluginCodeInfo, appId[%s] module[%s], version[%d], codeType[%d], md5[%s], pkgType[%d]", str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3, Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 a(String str, int i3, String... strArr) {
        String str2;
        h0 h0Var = null;
        if (w0.c(str)) {
            return null;
        }
        if (e.a.b(i3)) {
            str2 = "version desc";
        } else {
            if (!e.a.a(i3)) {
                throw new RuntimeException("Illegal pkgType " + i3);
            }
            str2 = "createTime desc";
        }
        Cursor a16 = a("AppBrandWxaPkgManifestRecord", w0.a(strArr) ? null : strArr, String.format(Locale.US, "%s=? and %s=?", "appId", "debugType"), new String[]{str, String.valueOf(i3)}, null, null, str2);
        if (a16 == null) {
            return null;
        }
        if (a16.moveToFirst()) {
            h0Var = new h0();
            h0Var.a(a16);
            h0Var.f138305b = str;
            h0Var.f138319p = i3;
        }
        a16.close();
        return h0Var;
    }

    public void a(String str, String str2, int i3, int i16, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_PKG_INFO");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_MODULE_NAME", str2);
            contentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(i16));
            contentValues.put("CONTENT_KEY_PKGINFO_LIST", str3);
            com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f134316b, contentValues);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WxaPkgResolver", e16, "updatePkgInfoList", new Object[0]);
        }
    }

    public void b(String str, int i3, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_SET_PLUGIN_STRING_VERSION");
            contentValues.put("CONTENT_KEY_PLUGIN_APPID", str);
            contentValues.put("CONTENT_KEY_PLUGIN_APP_VERSION", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_PLUGIN_APP_STRING_VERSION", str2);
            com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f134317c, contentValues);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WxaPkgResolver", e16, "setPluginStringVersion", new Object[0]);
        }
    }

    public boolean a(h0 h0Var) {
        if (h0Var == null) {
            return false;
        }
        try {
            ContentValues a16 = h0Var.a();
            a16.put("CONTENT_KEY_ACTION", "ACTION_INSERT_OR_UPDATE_MANIFEST");
            return com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f134316b, a16) != null;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WxaPkgResolver", e16, "insertOrUpdate", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0069 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:7:0x0022, B:11:0x0069, B:21:0x0065, B:24:0x0062, B:20:0x005d, B:14:0x0051, B:16:0x0057), top: B:6:0x0022, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, int i3) {
        String string;
        ContentResolver contentResolver = com.tencent.luggage.wxa.tn.z.c().getContentResolver();
        if (contentResolver == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgResolver", "getPluginStringVersion (%s, %d) NULL ContentResolver", str, Integer.valueOf(i3));
            return null;
        }
        try {
            Cursor query = ContactsMonitor.query(contentResolver, f134317c, new String[]{"pluginStringVersion"}, String.format(Locale.ENGLISH, "%s=? and %s=?", "pluginAppID", "pluginAppVersion"), new String[]{str, String.valueOf(i3)}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        string = query.getString(0);
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } finally {
                }
            }
            string = null;
            if (query != null) {
            }
            return string;
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgResolver", "getPluginStringVersion (%s, %d) NULL, query get throwable:%s", str, Integer.valueOf(i3), th5);
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 a(String str, int i3, String str2, String... strArr) {
        return a(str, i3, strArr);
    }

    public boolean a(String str, int i3, String str2) {
        ContentResolver contentResolver = com.tencent.luggage.wxa.tn.z.c().getContentResolver();
        if (contentResolver == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgResolver", "flushReleasePkgInfo(%s, %d, %s) NULL ContentResolver", str, Integer.valueOf(i3), str2);
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_FLUSH_RELEASE_PKG_INFO");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_PKG_VERSION_MD5", str2);
            return contentResolver.insert(f134316b, contentValues) != null;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WxaPkgResolver", e16, "flushReleasePkgInfo", new Object[0]);
            return false;
        }
    }
}
