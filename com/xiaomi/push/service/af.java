package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.fv;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.ii;
import com.xiaomi.push.in;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes28.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicLong f389576a = new AtomicLong(0);

    /* renamed from: b, reason: collision with root package name */
    private static SimpleDateFormat f389577b;

    /* renamed from: c, reason: collision with root package name */
    private static String f389578c;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f389577b = simpleDateFormat;
        f389578c = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    private static he a(String str, String str2, gi giVar) {
        return new he("-1", false).d(str).b(str2).a(in.h(fv.e(giVar))).c(gp.UploadTinyData.f24750a);
    }

    public static synchronized String b() {
        String str;
        synchronized (af.class) {
            String format = f389577b.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f389578c, format)) {
                f389576a.set(0L);
                f389578c = format;
            }
            str = format + "-" + f389576a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<he> c(List<gj> list, String str, String str2, int i3) {
        int i16;
        if (list == null) {
            jz4.c.B("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        }
        if (list.size() == 0) {
            jz4.c.B("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        }
        ArrayList<he> arrayList = new ArrayList<>();
        gi giVar = new gi();
        int i17 = 0;
        for (int i18 = 0; i18 < list.size(); i18++) {
            gj gjVar = list.get(i18);
            if (gjVar != null) {
                if (gjVar.m310a() != null && gjVar.m310a().containsKey("item_size")) {
                    String str3 = gjVar.m310a().get("item_size");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            i16 = Integer.parseInt(str3);
                        } catch (Exception unused) {
                        }
                        if (gjVar.m310a().size() != 1) {
                            gjVar.a((Map<String, String>) null);
                        } else {
                            gjVar.m310a().remove("item_size");
                        }
                    }
                    i16 = 0;
                    if (gjVar.m310a().size() != 1) {
                    }
                } else {
                    i16 = 0;
                }
                if (i16 <= 0) {
                    i16 = fv.e(gjVar).length;
                }
                if (i16 > i3) {
                    jz4.c.B("TinyData is too big, ignore upload request item:" + gjVar.d());
                } else {
                    if (i17 + i16 > i3) {
                        arrayList.add(a(str, str2, giVar));
                        giVar = new gi();
                        i17 = 0;
                    }
                    giVar.a(gjVar);
                    i17 += i16;
                }
            }
        }
        if (giVar.a() != 0) {
            arrayList.add(a(str, str2, giVar));
        }
        return arrayList;
    }

    public static void d(Context context, String str, String str2, long j3, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j3);
        gjVar.b(str3);
        gjVar.a("push_sdk_channel");
        gjVar.g(context.getPackageName());
        gjVar.e(context.getPackageName());
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.f(b());
        ba.a(context, gjVar);
    }

    public static boolean e(gj gjVar, boolean z16) {
        if (gjVar == null) {
            jz4.c.m("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z16 && TextUtils.isEmpty(gjVar.f24732a)) {
            jz4.c.m("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f389019d)) {
            jz4.c.m("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f389018c)) {
            jz4.c.m("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.ag.i(gjVar.f389019d)) {
            jz4.c.m("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.ag.i(gjVar.f389018c)) {
            jz4.c.m("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = gjVar.f24736b;
        if (str != null && str.length() > 30720) {
            jz4.c.m("item.data is too large(" + gjVar.f24736b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
            return true;
        }
        return false;
    }

    public static boolean f(String str) {
        if (ii.i() && !"com.miui.hybrid".equals(str)) {
            return false;
        }
        return true;
    }
}
