package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.service.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f389709a = {1, 2, 4, 8, 16};

    /* renamed from: b, reason: collision with root package name */
    private static final SparseArray<k.b<String, String, String>> f389710b = new a(5);

    /* renamed from: c, reason: collision with root package name */
    private static final SparseArray<Integer> f389711c = new b(5);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a extends SparseArray<k.b<String, String, String>> {
        a(int i3) {
            super(i3);
            put(1, k.f389737d);
            put(2, k.f389738e);
            put(4, k.f389739f);
            put(8, k.f389741h);
            put(16, k.f389740g);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class b extends SparseArray<Integer> {
        b(int i3) {
            super(i3);
            put(1, 32);
            put(2, 16);
            put(4, 8);
            put(8, 4);
            put(16, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r0 >= 4) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007c, code lost:
    
        if (r1 == 0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str, NotificationChannel notificationChannel) {
        int importance;
        int i3;
        String id5;
        String id6;
        int d16;
        int importance2;
        Uri sound;
        int i16;
        boolean shouldVibrate;
        int i17;
        String id7;
        int importance3;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str) && notificationChannel != null) {
            importance = notificationChannel.getImportance();
            if (importance != 0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            int i18 = i3 | 0;
            int i19 = 16;
            int i26 = 4;
            if (k.p()) {
                id7 = notificationChannel.getId();
                Bundle f16 = f(str, id7);
                k.b<String, String, String> bVar = k.f389741h;
                if (f16.containsKey(bVar.f389747c)) {
                    if (f16.getBoolean(bVar.f389747c)) {
                        importance3 = notificationChannel.getImportance();
                    }
                    i26 = 8;
                    i18 |= i26;
                }
                k.b<String, String, String> bVar2 = k.f389740g;
                if (f16.containsKey(bVar2.f389747c)) {
                    if (!f16.getBoolean(bVar2.f389747c)) {
                        i19 = 32;
                    }
                    i18 |= i19;
                }
            } else {
                id5 = notificationChannel.getId();
                int d17 = d(str, id5, 8);
                if (d17 == 1) {
                    importance2 = notificationChannel.getImportance();
                    if (importance2 >= 4) {
                        i18 |= 4;
                        id6 = notificationChannel.getId();
                        d16 = d(str, id6, 16);
                        if (d16 != 1) {
                            i18 |= 16;
                        } else if (d16 == 0) {
                            i18 |= 32;
                        }
                    }
                    i18 |= 8;
                    id6 = notificationChannel.getId();
                    d16 = d(str, id6, 16);
                    if (d16 != 1) {
                    }
                }
            }
            sound = notificationChannel.getSound();
            if (sound != null) {
                i16 = i18 | 64;
            } else {
                i16 = i18 | 128;
            }
            shouldVibrate = notificationChannel.shouldVibrate();
            if (shouldVibrate) {
                i17 = 256;
            } else {
                i17 = 512;
            }
            return i16 | i17;
        }
        jz4.c.m("context|packageName|channel must not be null ");
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r1 == 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(Context context, String str, String str2) {
        int importance;
        int i3;
        String id5;
        String id6;
        int i16;
        int importance2;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str)) {
            j e16 = j.e(context, str);
            if (e16 != null) {
                NotificationChannel b16 = e16.b(e16.i(str2));
                if (b16 != null) {
                    importance = b16.getImportance();
                    if (importance != 0) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    int i17 = i3 | 0;
                    id5 = b16.getId();
                    int d16 = d(str, id5, 8);
                    if (d16 == 1) {
                        importance2 = b16.getImportance();
                        if (importance2 >= 4) {
                            i17 |= 4;
                        }
                        i17 |= 8;
                    }
                    id6 = b16.getId();
                    int d17 = d(str, id6, 16);
                    if (d17 == 1) {
                        i16 = i17 | 16;
                    } else if (d17 == 0) {
                        i16 = i17 | 32;
                    } else {
                        return i17;
                    }
                    return i16;
                }
                jz4.c.m("Channel must not be null");
                return 0;
            }
            jz4.c.m("create NMHelper error");
            return 0;
        }
        jz4.c.m("Must greater than or equal android O and context|packageName not be null");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(String str, String str2) {
        int i3 = 8;
        if (!p(str, str2, 8)) {
            i3 = 0;
        }
        if (p(str, str2, 16)) {
            i3 |= 16;
        }
        if (p(str, str2, 1)) {
            i3 |= 1;
        }
        if (p(str, str2, 2)) {
            i3 |= 2;
        }
        if (p(str, str2, 4)) {
            return i3 | 4;
        }
        return i3;
    }

    public static int d(String str, String str2, int i3) {
        return k.c(ii.b(), str, str2, f389710b.get(i3));
    }

    private static SharedPreferences e(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }

    public static Bundle f(String str, String str2) {
        return k.d(ii.b(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Context context, String str) {
        List<NotificationChannel> l3;
        if (hz.j(context) && !TextUtils.isEmpty(str) && (l3 = j.e(context, str).l()) != null) {
            synchronized (f.class) {
                SharedPreferences e16 = e(context);
                ArrayList arrayList = new ArrayList();
                Iterator<NotificationChannel> it = l3.iterator();
                while (it.hasNext()) {
                    String str2 = (String) com.xiaomi.push.y.d(it.next(), "mId");
                    if (!TextUtils.isEmpty(str2) && e16.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    l(e16, arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Context context, String str, String str2, int i3, String str3, boolean z16, int i16) {
        if (hz.j(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int a16 = ij.a(str3, 0);
            boolean o16 = o(i3, a16);
            if (z16) {
                m(str, str2, a16, i16);
                if (o16) {
                    synchronized (f.class) {
                        i(e(context), a16, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (f.class) {
                SharedPreferences e16 = e(context);
                if (o16 || e16.contains(str2)) {
                    j(e16, a16, str, str2, i16);
                    if (o16) {
                        i(e16, a16, str2);
                    } else {
                        k(e16, str2);
                    }
                }
            }
            return;
        }
        if (hz.j(context)) {
            jz4.c.m("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    private static void i(SharedPreferences sharedPreferences, int i3, String str) {
        sharedPreferences.edit().putInt(str, i3).commit();
    }

    private static void j(SharedPreferences sharedPreferences, int i3, String str, String str2, int i16) {
        if (sharedPreferences.getInt(str2, 0) != i3) {
            m(str, str2, i3, i16);
        }
    }

    private static void k(SharedPreferences sharedPreferences, String str) {
        l(sharedPreferences, new ArrayList<String>(str) { // from class: com.xiaomi.push.service.f.3

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f389712a;

            {
                this.f389712a = str;
                add(str);
            }
        });
    }

    private static void l(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(String str, String str2, int i3, int i16) {
        boolean z16;
        for (int i17 : f389709a) {
            if ((f389711c.get(i17).intValue() & i16) == 0) {
                if ((i3 & i17) > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                n(str, str2, i17, z16);
            } else {
                jz4.c.m("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i17 + "> :stoped by userLock");
            }
        }
    }

    private static void n(String str, String str2, int i3, boolean z16) {
        jz4.c.m("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i3 + ContainerUtils.KEY_VALUE_DELIMITER + z16 + "> :" + k.s(ii.b(), str, str2, f389710b.get(i3), z16));
    }

    private static boolean o(int i3, int i16) {
        if (i3 < 4 && (i16 & 2) <= 0 && (i16 & 1) <= 0 && (i16 & 8) <= 0 && (i16 & 16) <= 0) {
            return false;
        }
        return true;
    }

    private static boolean p(String str, String str2, int i3) {
        boolean z16 = true;
        if (k.c(ii.b(), str, str2, f389710b.get(i3)) != 1) {
            z16 = false;
        }
        jz4.c.m("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i3 + ContainerUtils.KEY_VALUE_DELIMITER + z16 + ">");
        return z16;
    }
}
