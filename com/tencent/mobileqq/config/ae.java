package com.tencent.mobileqq.config;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static final LinkedHashMap<Integer, String> f202258a;

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<Integer> f202259b;

    static {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        f202258a = linkedHashMap;
        linkedHashMap.put(567, "migrate_manage_567");
        linkedHashMap.put(816, "beacon_channel_config");
        HashSet<Integer> hashSet = new HashSet<>();
        f202259b = hashSet;
        hashSet.add(816);
    }

    private static void a(int i3) {
        long j3;
        boolean contains = f202259b.contains(Integer.valueOf(i3));
        if (!contains) {
            am.s().B(0L, i3, f202258a.get(Integer.valueOf(i3)));
        }
        boolean z16 = false;
        while (true) {
            try {
                List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
                if (allAccounts == null) {
                    return;
                }
                Iterator it = new ArrayList(allAccounts).iterator();
                while (it.hasNext()) {
                    try {
                        long parseLong = Long.parseLong(((SimpleAccount) it.next()).getUin());
                        am s16 = am.s();
                        if (contains) {
                            j3 = 0;
                        } else {
                            j3 = parseLong;
                        }
                        s16.C(j3, parseLong, i3, f202258a.get(Integer.valueOf(i3)));
                    } catch (RuntimeException e16) {
                        QLog.e("ManageMigrate", 1, e16, new Object[0]);
                    }
                }
                return;
            } catch (ConcurrentModificationException e17) {
                QLog.e("ManageMigrate", 1, e17, new Object[0]);
                if (!z16) {
                    QLog.w("ManageMigrate", 1, "retry: " + i3);
                    z16 = true;
                } else {
                    QLog.w("ManageMigrate", 1, "give up: " + i3);
                    return;
                }
            }
        }
    }

    public static void b() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int i3 = 0;
        int decodeInt = from.decodeInt("manage_migrate_freesia_version", 0);
        QLog.d("ManageMigrate", 1, "migrateAll current version: " + decodeInt);
        Iterator<Integer> it = f202258a.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            int i16 = i3 + 1;
            if (i3 >= decodeInt) {
                a(intValue);
                from.encodeInt("manage_migrate_freesia_version", i16);
            }
            i3 = i16;
        }
    }

    @Nullable
    public static String c(int i3) {
        String str = f202258a.get(Integer.valueOf(i3));
        if (MigrateBlackListParser.d(str)) {
            return null;
        }
        return str;
    }
}
