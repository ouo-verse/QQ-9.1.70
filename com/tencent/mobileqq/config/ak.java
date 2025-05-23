package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mapsdk.internal.er;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ak {

    /* renamed from: i, reason: collision with root package name */
    private static volatile ak f202278i;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f202281c;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f202279a = false;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f202280b = false;

    /* renamed from: d, reason: collision with root package name */
    private final Set<a> f202282d = new HashSet(20);

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, SharedPreferences> f202283e = new HashMap(20);

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, SharedPreferences.Editor> f202284f = new HashMap(20);

    /* renamed from: g, reason: collision with root package name */
    private final ReadWriteLock f202285g = new ReentrantReadWriteLock();

    /* renamed from: h, reason: collision with root package name */
    private final Object f202286h = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f202287a;

        /* renamed from: b, reason: collision with root package name */
        public String f202288b;

        /* renamed from: c, reason: collision with root package name */
        public long f202289c;

        /* renamed from: d, reason: collision with root package name */
        public String f202290d;

        /* renamed from: e, reason: collision with root package name */
        private final String f202291e;

        public a(int i3, String str, long j3, String str2) {
            this.f202287a = i3;
            this.f202288b = str;
            this.f202289c = j3;
            this.f202290d = str2;
            this.f202291e = this.f202287a + "-" + this.f202288b + "-" + this.f202289c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f202287a != aVar.f202287a || !this.f202288b.equals(aVar.f202288b) || this.f202289c != aVar.f202289c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f202291e.hashCode();
        }

        public String toString() {
            return "Entry{type=" + this.f202287a + ", key='" + this.f202288b + "', uin=" + this.f202289c + ", path='" + this.f202290d + "'}";
        }
    }

    ak() {
    }

    public static ak b() {
        if (f202278i == null) {
            synchronized (ak.class) {
                if (f202278i == null) {
                    f202278i = new ak();
                }
            }
        }
        return f202278i;
    }

    private SharedPreferences c() {
        if (this.f202281c == null) {
            this.f202281c = MobileQQ.sMobileQQ.getSharedPreferences("q_journey_safe_mode_pref", 0);
        }
        return this.f202281c;
    }

    private SharedPreferences d(String str) {
        SharedPreferences sharedPreferences = this.f202283e.get(str);
        if (sharedPreferences == null && (sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(str, 0)) != null) {
            this.f202283e.put(str, sharedPreferences);
        }
        return sharedPreferences;
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.d("QConfigJourney", 2, "clearFakeJourney");
        }
        this.f202280b = false;
        SharedPreferences c16 = c();
        if (c16 != null) {
            Set<String> stringSet = c16.getStringSet("safe_scoop", new HashSet());
            if (stringSet.contains("fate_log_tag")) {
                stringSet.remove("fate_log_tag");
                SharedPreferences.Editor edit = c16.edit();
                edit.remove("fate_log_tag");
                edit.putStringSet("safe_scoop", stringSet);
                edit.commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(int i3, int i16) {
        SharedPreferences d16 = d("q_journey_safe_mode_deleted_confs_pref");
        if (d16 == null) {
            return false;
        }
        int i17 = d16.getInt(i3 + er.f148291t, -1);
        if (i17 == -1 || i17 != i16) {
            return false;
        }
        long j3 = d16.getLong(String.valueOf(i3), -1L);
        if (j3 == -1 || j3 + 10800000 <= System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(String str, String str2, String str3) {
        ReadWriteLock readWriteLock;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                long parseLong = Long.parseLong(str2);
                SharedPreferences d16 = d("q_journey_safe_mode_deleted_files_pref");
                if (d16 == null) {
                    return false;
                }
                String str4 = "2-" + str + "-" + parseLong;
                this.f202285g.readLock().lock();
                String str5 = null;
                try {
                    try {
                        str5 = d16.getString(str4, null);
                        readWriteLock = this.f202285g;
                    } catch (Throwable th5) {
                        this.f202285g.readLock().unlock();
                        throw th5;
                    }
                } catch (Exception unused) {
                    readWriteLock = this.f202285g;
                }
                readWriteLock.readLock().unlock();
                return TextUtils.equals(str3, str5);
            } catch (NumberFormatException unused2) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i3, long j3, boolean z16) {
        if (this.f202279a) {
            a aVar = new a(z16 ? 1 : 0, String.valueOf(i3), j3, null);
            synchronized (this.f202286h) {
                this.f202282d.add(aVar);
            }
            if (this.f202280b) {
                i(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, String str3) {
        if (this.f202279a && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                a aVar = new a(2, str, Long.parseLong(str2), str3);
                synchronized (this.f202286h) {
                    this.f202282d.add(aVar);
                }
            } catch (NumberFormatException unused) {
            }
            if (this.f202280b) {
                i(true);
            }
        }
    }

    public void i(boolean z16) {
        int size;
        HashSet<a> hashSet;
        SharedPreferences c16;
        String valueOf;
        Set<String> stringSet;
        if (!z16) {
            this.f202279a = false;
        }
        synchronized (this.f202286h) {
            size = this.f202282d.size();
            hashSet = new HashSet(this.f202282d);
            this.f202282d.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QConfigJourney", 2, "makeAJourney, size=" + size + ", fate=" + z16);
        }
        if (!hashSet.isEmpty() && (c16 = c()) != null) {
            SharedPreferences.Editor edit = c16.edit();
            Set<String> stringSet2 = c16.getStringSet("safe_scoop", new HashSet());
            if (z16) {
                valueOf = "fate_log_tag";
            } else {
                valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            }
            HashSet hashSet2 = new HashSet(size);
            if (z16 && (stringSet = c16.getStringSet(valueOf, null)) != null && !stringSet.isEmpty()) {
                hashSet2.addAll(stringSet);
            }
            for (a aVar : hashSet) {
                String str = aVar.f202287a + "-" + aVar.f202288b + "-" + aVar.f202289c;
                if (aVar.f202287a == 2) {
                    edit.putString(str, aVar.f202290d);
                }
                hashSet2.add(str);
            }
            stringSet2.add(valueOf);
            edit.putStringSet(valueOf, hashSet2);
            edit.putStringSet("safe_scoop", stringSet2);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, String str3) {
        ReadWriteLock readWriteLock;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                long parseLong = Long.parseLong(str2);
                SharedPreferences d16 = d("q_journey_safe_mode_deleted_files_pref");
                if (d16 != null) {
                    String str4 = "2-" + str + "-" + parseLong;
                    if (TextUtils.equals(str3, d16.getString(str4, null))) {
                        SharedPreferences.Editor edit = d16.edit();
                        this.f202285g.writeLock().lock();
                        try {
                            edit.remove(str4);
                            edit.commit();
                            readWriteLock = this.f202285g;
                        } catch (Exception unused) {
                            readWriteLock = this.f202285g;
                        } catch (Throwable th5) {
                            this.f202285g.writeLock().unlock();
                            throw th5;
                        }
                        readWriteLock.writeLock().unlock();
                    }
                }
            } catch (NumberFormatException unused2) {
            }
        }
    }
}
