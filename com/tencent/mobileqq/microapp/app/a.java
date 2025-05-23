package com.tencent.mobileqq.microapp.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final List f245876a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f245877b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f245878c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f245879d;

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap f245880g;

    /* renamed from: e, reason: collision with root package name */
    private SharedPreferences f245881e;

    /* renamed from: f, reason: collision with root package name */
    private int f245882f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.microapp.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8028a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f245883a;

        /* renamed from: b, reason: collision with root package name */
        public int f245884b;

        public C8028a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                this.f245883a = str;
                this.f245884b = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        HashMap hashMap = new HashMap();
        f245880g = hashMap;
        ArrayList arrayList = new ArrayList();
        f245876a = arrayList;
        HashMap hashMap2 = new HashMap();
        f245877b = hashMap2;
        HashMap hashMap3 = new HashMap();
        f245878c = hashMap3;
        HashMap hashMap4 = new HashMap();
        f245879d = hashMap4;
        hashMap3.put("chooseLocation", "android.permission.ACCESS_FINE_LOCATION");
        hashMap3.put("openLocation", "android.permission.ACCESS_FINE_LOCATION");
        hashMap3.put("getLocation", "android.permission.ACCESS_FINE_LOCATION");
        hashMap3.put("chooseVideo", QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE);
        hashMap3.put("chooseImage", QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE);
        hashMap3.put("saveImageToPhotosAlbum", QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        hashMap3.put("saveVideoToPhotosAlbum", QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        hashMap4.put(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, "\u9700\u8981\u5b58\u50a8\u6743\u9650\uff0c\u8bf7\u5230\u8bbe\u7f6e\u4e2d\u8bbe\u7f6e");
        hashMap4.put(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "\u9700\u8981\u5b58\u50a8\u6743\u9650\uff0c\u8bf7\u5230\u8bbe\u7f6e\u4e2d\u8bbe\u7f6e");
        hashMap4.put("android.permission.ACCESS_FINE_LOCATION", "\u9700\u8981\u4f4d\u7f6e\u6743\u9650\uff0c\u8bf7\u5230\u8bbe\u7f6e\u4e2d\u8bbe\u7f6e");
        hashMap4.put(QQPermissionConstants.Permission.CALL_PHONE, "\u9700\u8981\u7535\u8bdd\u6743\u9650\uff0c\u8bf7\u5230\u8bbe\u7f6e\u4e2d\u8bbe\u7f6e");
        hashMap4.put(QQPermissionConstants.Permission.RECORD_AUDIO, "\u9700\u8981\u9ea6\u514b\u98ce\u6743\u9650\uff0c\u8bf7\u5230\u8bbe\u7f6e\u4e2d\u8bbe\u7f6e");
        hashMap4.put(QQPermissionConstants.Permission.CAMERA, "\u9700\u8981\u76f8\u673a\u6743\u9650\uff0c\u8bf7\u5230\u8bbe\u7f6e\u4e2d\u8bbe\u7f6e");
        hashMap.put("chooseLocation", AuthorizeCenter.SCOPE_USER_LOCATION);
        hashMap.put("getLocation", AuthorizeCenter.SCOPE_USER_LOCATION);
        hashMap.put("saveImageToPhotosAlbum", AuthorizeCenter.SCOPE_WRITE_PHOTOS_ALBUM);
        hashMap.put("saveVideoToPhotosAlbum", AuthorizeCenter.SCOPE_WRITE_PHOTOS_ALBUM);
        hashMap.put("chooseInvoiceTitle", AuthorizeCenter.SCOPE_INVOICE_TITLE);
        hashMap.put("openAddress", AuthorizeCenter.SCOPE_ADDRESS);
        hashMap.put("openWeRunSetting", "scope.werun");
        arrayList.add(AuthorizeCenter.SCOPE_USER_LOCATION);
        arrayList.add(AuthorizeCenter.SCOPE_USER_INFO);
        arrayList.add(AuthorizeCenter.SCOPE_ADDRESS);
        arrayList.add(AuthorizeCenter.SCOPE_INVOICE_TITLE);
        arrayList.add("scope.werun");
        arrayList.add(AuthorizeCenter.SCOPE_RECORD);
        arrayList.add(AuthorizeCenter.SCOPE_WRITE_PHOTOS_ALBUM);
        arrayList.add(AuthorizeCenter.SCOPE_CAMERA);
        hashMap2.put(AuthorizeCenter.SCOPE_USER_LOCATION, "\u83b7\u53d6\u4f60\u7684\u5730\u7406\u4f4d\u7f6e");
        hashMap2.put(AuthorizeCenter.SCOPE_USER_INFO, "\u83b7\u53d6\u4f60\u7684\u516c\u5f00\u4fe1\u606f\uff08\u6635\u79f0\u3001\u5934\u50cf\u7b49\uff09");
        hashMap2.put(AuthorizeCenter.SCOPE_ADDRESS, "\u83b7\u53d6\u4f60\u7684\u901a\u8baf\u5730\u5740");
        hashMap2.put(AuthorizeCenter.SCOPE_INVOICE_TITLE, "\u83b7\u53d6\u4f60\u7684\u53d1\u7968\u62ac\u5934");
        hashMap2.put("scope.werun", "\u83b7\u53d6\u4f60\u7684\u8fd0\u52a8\u6b65\u6570");
        hashMap2.put(AuthorizeCenter.SCOPE_RECORD, "\u4f7f\u7528\u5f55\u97f3\u529f\u80fd");
        hashMap2.put(AuthorizeCenter.SCOPE_WRITE_PHOTOS_ALBUM, "\u4fdd\u5b58\u89c6\u9891\u6216\u56fe\u7247\u5230\u4f60\u7684\u76f8\u518c");
        hashMap2.put(AuthorizeCenter.SCOPE_CAMERA, "\u4f7f\u7528\u76f8\u673a\u529f\u80fd");
    }

    public a(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        } else {
            this.f245882f = 60;
            this.f245881e = context.getSharedPreferences(str, 0);
        }
    }

    public static boolean b(String str, String str2) {
        return !TextUtils.isEmpty(c(str, str2));
    }

    public static String c(String str, String str2) {
        return (String) f245880g.get(str);
    }

    public static String d(String str, String str2) {
        return (String) f245878c.get(str);
    }

    public int a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        String c16 = c(str, str2);
        if (TextUtils.isEmpty(c16)) {
            return 2;
        }
        return this.f245881e.getInt(c16, 1);
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f245881e.edit().putInt(str, z16 ? 2 : ((int) (System.currentTimeMillis() / 1000)) + this.f245882f).commit();
        }
    }

    public List a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : f245876a) {
            int i16 = this.f245881e.getInt(str, 1);
            if (i16 == 2) {
                if ((i3 & 2) == 2) {
                    arrayList.add(new C8028a(str, 2));
                }
            } else if (i16 == 1) {
                if ((i3 & 1) == 1) {
                    arrayList.add(new C8028a(str, 1));
                }
            } else if ((i3 & 4) == 4) {
                arrayList.add(new C8028a(str, 4));
            }
        }
        return arrayList;
    }
}
