package com.tencent.luggage.wxa.o7;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.luggage.wxa.fd.k0;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.hn.r0;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.hn.z0;
import com.tencent.luggage.wxa.ii.i;
import com.tencent.luggage.wxa.ii.q;
import com.tencent.luggage.wxa.ii.s;
import com.tencent.luggage.wxa.mc.d0;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.mc.e0;
import com.tencent.luggage.wxa.mc.h0;
import com.tencent.luggage.wxa.mc.i0;
import com.tencent.luggage.wxa.mc.l0;
import com.tencent.luggage.wxa.mc.p0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.WxaSyncCmdPersistentStorage;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends ContentProvider {

    /* renamed from: c, reason: collision with root package name */
    public static volatile UriMatcher f136195c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile SparseArray f136196d;

    /* renamed from: a, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.xn.b f136197a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f136198b = new ConcurrentHashMap();

    public static synchronized boolean a(ContentProvider contentProvider) {
        synchronized (c.class) {
            if (f136196d != null) {
                return true;
            }
            try {
                if (z.c() == null) {
                    z.b(contentProvider.getContext());
                }
                f136196d = new SparseArray();
                f136196d.put(1, "WxaAttributesTable");
                f136196d.put(2, "LaunchWxaAppPBTableNew");
                f136196d.put(4, "DevPkgLaunchExtInfo");
                f136196d.put(5, "AppBrandWxaPkgManifestRecord");
                f136196d.put(6, "WxaPluginCodeVersionInfo");
                f136196d.put(7, "PluginDevLaunchInfo");
                f136196d.put(8, "AppBrandWxaPkgManifestRecordWithDesc");
                f136196d.put(9, "WxaJsApiPluginInfo");
                f136196d.put(10, "PersistentWxaSyncInvalidContactCmd");
                f136195c = new UriMatcher(-1);
                for (int i3 = 0; i3 < f136196d.size(); i3++) {
                    f136195c.addURI(a.f136193a, (String) f136196d.valueAt(i3), f136196d.keyAt(i3));
                }
                return true;
            } catch (Exception e16) {
                w.b("Luggage.WxaCriticalDataProvider", "init() setup ggMatcher get exception:%s", e16);
                return false;
            }
        }
    }

    public abstract com.tencent.luggage.wxa.xn.b b();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (!a()) {
            return -1;
        }
        int a16 = a(uri);
        if (a16 != 7) {
            if (a16 != 10) {
                return 0;
            }
            if (strArr == null || strArr.length < 1) {
                return -1;
            }
            String str2 = strArr[0];
            if (TextUtils.isEmpty(str2)) {
                return -1;
            }
            return ((WxaSyncCmdPersistentStorage) a(WxaSyncCmdPersistentStorage.class)).a(str2) ? 1 : 0;
        }
        return this.f136197a.a("DevPkgLaunchExtInfo", str, strArr);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        List list;
        h0 a16;
        i0 a17;
        if (!a()) {
            return null;
        }
        switch (a(uri)) {
            case 1:
                try {
                    if (contentValues.containsKey("CONTENT_KEY_SYNC_PROTO")) {
                        if (contentValues.containsKey("CONTENT_KEY_APPID")) {
                            ((k0) a(k0.class)).b(contentValues.getAsString("CONTENT_KEY_APPID"), (se) new se().a(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO")));
                        } else if (contentValues.containsKey("CONTENT_KEY_USERNAME")) {
                            ((k0) a(k0.class)).a(contentValues.getAsString("CONTENT_KEY_USERNAME"), (se) new se().a(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO")));
                        }
                    } else if (contentValues.containsKey("CONTENT_KEY_BATCH_SYNC_PROTO")) {
                        ((k0) a(k0.class)).a(w0.a(contentValues.getAsInteger("CONTENT_KEY_BATCH_SYNC_SCENE"), 0), (r0) new r0().a(contentValues.getAsByteArray("CONTENT_KEY_BATCH_SYNC_PROTO")));
                    }
                    return null;
                } catch (Exception e16) {
                    w.b("Luggage.WxaCriticalDataProvider", "insert WxaAttributes, e = %s, stack = %s", e16, Log.getStackTraceString(e16));
                    return null;
                }
            case 2:
                try {
                    ((q) a(q.class)).a(contentValues.getAsString("CONTENT_KEY_APPID"), (i6) new i6().a(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO")));
                    return null;
                } catch (Exception e17) {
                    w.b("Luggage.WxaCriticalDataProvider", "insert LaunchWxaAppPB, e = %s", e17);
                    return null;
                }
            case 3:
            default:
                return null;
            case 4:
                try {
                    ((i) a(i.class)).a(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_VERSION_TYPE").intValue(), contentValues.getAsString("CONTENT_KEY_EXT_INFO"));
                    return null;
                } catch (Exception e18) {
                    w.b("Luggage.WxaCriticalDataProvider", "insert LaunchExtInfoForDevPkg, e = %s", e18);
                    return null;
                }
            case 5:
                String asString = contentValues.getAsString("CONTENT_KEY_ACTION");
                asString.hashCode();
                char c16 = '\uffff';
                switch (asString.hashCode()) {
                    case -2005549818:
                        if (asString.equals("ACTION_INSERT_OR_UPDATE_MANIFEST")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -1507094307:
                        if (asString.equals("ACTION_FLUSH_RELEASE_PKG_INFO")) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case -1297425212:
                        if (asString.equals("ACTION_UPDATE_MODULE_LIST")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case -946499957:
                        if (asString.equals("ACTION_FLUSH_WXA_PKG_VERSION_INFO")) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case -214401522:
                        if (asString.equals("ACTION_UPDATE_PKG_INFO")) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 396944:
                        if (asString.equals("ACTION_UPDATE_PLUGINCODE_LIST")) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case 755152062:
                        if (asString.equals("ACIION_UPDATE_WITHOUT_PLUGINCODE_INFO")) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case 1067970480:
                        if (asString.equals("ACTION_FLUSH_WXA_DEBUG_PKG_INFO")) {
                            c16 = 7;
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                        try {
                            contentValues.remove("CONTENT_KEY_ACTION");
                            h0 h0Var = new h0();
                            h0Var.a(contentValues);
                            if (!((l0) a(l0.class)).c(h0Var)) {
                                return null;
                            }
                            return ContentUris.withAppendedId(uri, h0Var.f145157a);
                        } catch (Throwable th5) {
                            w.b("Luggage.WxaCriticalDataProvider", "insert()-WxaPkg-insertOrUpdate get exception %s", th5);
                            throw th5;
                        }
                    case 1:
                        String asString2 = contentValues.getAsString("CONTENT_KEY_APPID");
                        int intValue = contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue();
                        if (((l0) a(l0.class)).a(asString2, intValue, contentValues.getAsString("CONTENT_KEY_PKG_VERSION_MD5")) && (a16 = ((l0) a(l0.class)).a(asString2, intValue, 0, "rowid")) != null) {
                            return ContentUris.withAppendedId(uri, a16.f145157a);
                        }
                        return null;
                    case 2:
                        try {
                            String asString3 = contentValues.getAsString("CONTENT_KEY_APPID");
                            int intValue2 = contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue();
                            int intValue3 = contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue();
                            try {
                                list = n0.h.a(contentValues.getAsString("CONTENT_KEY_MODULE_LIST_JSON"));
                            } catch (Exception unused) {
                                list = null;
                            }
                            if (w0.a(list)) {
                                return null;
                            }
                            ((l0) a(l0.class)).a(asString3, intValue2, intValue3, list);
                            return null;
                        } catch (Exception e19) {
                            w.b("Luggage.WxaCriticalDataProvider", "insert LaunchExtInfoForDevPkg, e = %s", e19);
                            return null;
                        }
                    case 3:
                        n0.g a18 = n0.g.a(contentValues.getAsString("CONTENT_KEY_WXA_VERSION_INFO_JSON"));
                        String asString4 = contentValues.getAsString("CONTENT_KEY_APPID");
                        if (!e.a.b(contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue())) {
                            return null;
                        }
                        ((l0) a(l0.class)).a(asString4, a18);
                        return null;
                    case 4:
                        ((l0) a(l0.class)).a(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue(), contentValues.getAsInteger("CONTENT_KEY_CODE_TYPE").intValue(), contentValues.getAsString("CONTENT_KEY_MODULE_NAME"), n0.i.a(contentValues.getAsString("CONTENT_KEY_PKGINFO_LIST")));
                        return null;
                    case 5:
                        ((l0) a(l0.class)).a(n0.e.a(contentValues.getAsString("CONTENT_KEY_PLUGINCODE_LIST")));
                        return null;
                    case 6:
                        ((l0) a(l0.class)).a(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsString("CONTENT_KEY_MODULE_NAME"), contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue(), contentValues.getAsInteger("CONTENT_KEY_CODE_TYPE").intValue(), contentValues.getAsString("CONTENT_KEY_PKG_VERSION_MD5"), contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue());
                        return null;
                    case 7:
                        if (!((l0) a(l0.class)).a(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue(), contentValues.getAsString("CONTENT_KEY_PKG_DOWNLOAD_URL"), contentValues.getAsString("CONTENT_KEY_PKG_VERSION_MD5"), 0L, System.currentTimeMillis())) {
                            return null;
                        }
                        return ContentUris.withAppendedId(uri, String.format(Locale.US, "%s_%d_%s", r3, Integer.valueOf(r4), r7).hashCode());
                    default:
                        return null;
                }
            case 6:
                String d16 = w0.d(contentValues.getAsString("CONTENT_KEY_ACTION"));
                d16.hashCode();
                if (!d16.equals("ACTION_SET_PLUGIN_STRING_VERSION")) {
                    return null;
                }
                try {
                    ((p0) a(p0.class)).a(contentValues.getAsString("CONTENT_KEY_PLUGIN_APPID"), contentValues.getAsInteger("CONTENT_KEY_PLUGIN_APP_VERSION").intValue(), contentValues.getAsString("CONTENT_KEY_PLUGIN_APP_STRING_VERSION"));
                    return ContentUris.withAppendedId(uri, String.format(Locale.ENGLISH, "%s_%d", r3, Integer.valueOf(r4)).hashCode());
                } catch (Throwable unused2) {
                    return null;
                }
            case 7:
                if (contentValues == null) {
                    return null;
                }
                if (!((com.tencent.luggage.wxa.ii.w) a(com.tencent.luggage.wxa.ii.w.class)).a(contentValues.getAsString("appId"), contentValues.getAsString("versionDesc"), contentValues.getAsLong("devKey").longValue())) {
                    return null;
                }
                return ContentUris.withAppendedId(uri, String.format(Locale.ENGLISH, "%s_%s", r3, r4).hashCode());
            case 8:
                if (contentValues == null) {
                    return null;
                }
                i0 i0Var = new i0();
                d0.a(i0Var, contentValues);
                if (!((e0) a(e0.class)).b(i0Var) || (a17 = ((e0) a(e0.class)).a(i0Var.f138305b, i0Var.f138319p, i0Var.Z, "rowid")) == null) {
                    return null;
                }
                return ContentUris.withAppendedId(uri, a17.f145157a);
            case 9:
                if (contentValues == null) {
                    return null;
                }
                try {
                    String asString5 = contentValues.getAsString("appId");
                    byte[] asByteArray = contentValues.getAsByteArray("permissionProtoBlob");
                    z0 z0Var = new z0();
                    z0Var.a(asByteArray);
                    if (!((s) a(s.class)).a(asString5, z0Var)) {
                        return null;
                    }
                    return ContentUris.withAppendedId(uri, asString5.hashCode());
                } catch (Exception e26) {
                    w.b("Luggage.WxaCriticalDataProvider", "insert for ID_WxaPluginJsApiInfo, get exception %s", e26);
                    return null;
                }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!a()) {
            return null;
        }
        String str3 = (String) f136196d.get(f136195c.match(uri));
        if (TextUtils.isEmpty(str3)) {
            w.h("Luggage.WxaCriticalDataProvider", "query: uri [%s] mismatch", uri);
            return null;
        }
        return this.f136197a.a(str3, strArr, str, strArr2, null, null, str2);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!a()) {
            return -1;
        }
        int a16 = a(uri);
        if (a16 != 5) {
            if (a16 != 8 || contentValues == null) {
                return 0;
            }
            i0 i0Var = new i0();
            d0.a(i0Var, contentValues);
            return ((e0) a(e0.class)).c(i0Var) ? 1 : 0;
        }
        String d16 = w0.d(contentValues.getAsString("CONTENT_KEY_ACTION"));
        d16.hashCode();
        if (!d16.equals("ACTION_DELETE_MODULE_LIST")) {
            if (!d16.equals("ACTION_UPDATE_MANIFEST")) {
                return 0;
            }
            contentValues.remove("CONTENT_KEY_ACTION");
            return this.f136197a.a("AppBrandWxaPkgManifestRecord", contentValues, str, strArr);
        }
        return ((l0) a(l0.class)).a(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue(), contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue());
    }

    public final boolean a() {
        if (!a(this)) {
            return false;
        }
        if (this.f136197a == null) {
            this.f136197a = b();
        }
        return (this.f136197a == null || this.f136197a.a()) ? false : true;
    }

    public final int a(Uri uri) {
        return f136195c.match(uri);
    }

    public final void a(Class cls, Object obj) {
        w.d("Luggage.WxaCriticalDataProvider", "installStorage clazz:%s storage:%s", cls, obj);
        this.f136198b.put(cls, obj);
    }

    public final Object a(Class cls) {
        return this.f136198b.get(cls);
    }
}
