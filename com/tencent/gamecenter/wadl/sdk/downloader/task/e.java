package com.tencent.gamecenter.wadl.sdk.downloader.task;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public long f107488a;

    /* renamed from: b, reason: collision with root package name */
    public volatile long f107489b;

    /* renamed from: c, reason: collision with root package name */
    volatile long f107490c;

    /* renamed from: d, reason: collision with root package name */
    volatile long f107491d;

    /* renamed from: g, reason: collision with root package name */
    public boolean f107494g;

    /* renamed from: j, reason: collision with root package name */
    private volatile long f107497j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f107498k;

    /* renamed from: e, reason: collision with root package name */
    private String f107492e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f107493f = "";

    /* renamed from: h, reason: collision with root package name */
    List<com.tencent.gamecenter.wadl.sdk.downloader.task.i.a> f107495h = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    List<com.tencent.gamecenter.wadl.sdk.downloader.task.i.a> f107496i = new LinkedList();

    public e(String str) {
        this.f107488a = -1L;
        this.f107489b = 0L;
        this.f107490c = 0L;
        this.f107491d = 0L;
        this.f107494g = false;
        this.f107497j = 0L;
        this.f107498k = 0;
        this.f107494g = false;
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.split("\\|");
                    if (a(split)) {
                        return;
                    }
                    try {
                        this.f107488a = Long.parseLong(split[1]);
                        this.f107489b = Long.parseLong(split[2]);
                        this.f107490c = Long.parseLong(split[3]);
                        this.f107491d = Long.parseLong(split[4]);
                        for (String str2 : split[5].split(";")) {
                            com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.i.a(this, str2);
                            if (aVar.f107557a) {
                                this.f107495h.add(aVar);
                            } else {
                                this.f107495h.clear();
                                return;
                            }
                        }
                        if (split.length >= 9) {
                            a(split[7]);
                            b(split[8]);
                        }
                        if (split.length >= 11) {
                            for (String str3 : split[9].split(";")) {
                                com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 = new com.tencent.gamecenter.wadl.sdk.downloader.task.i.a(this, str3);
                                if (aVar2.f107557a) {
                                    this.f107496i.add(aVar2);
                                } else {
                                    this.f107496i.clear();
                                }
                            }
                            try {
                                String[] split2 = split[10].split(";");
                                this.f107497j = Long.parseLong(split2[0]);
                                this.f107498k = Integer.parseInt(split2[1]);
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                                return;
                            }
                        }
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskDivider", "parseLong for totalLen fail.", e16);
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            c();
            this.f107494g = true;
        } catch (Exception e17) {
            this.f107494g = false;
            e17.printStackTrace();
        }
    }

    private long b() {
        long j3;
        long j16;
        long j17;
        synchronized (this.f107495h) {
            j3 = 0;
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar : this.f107495h) {
                j3 += aVar.f107561e - aVar.f107560d;
            }
        }
        synchronized (this.f107496i) {
            j16 = 0;
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 : this.f107496i) {
                j16 += aVar2.f107563g - aVar2.f107560d;
            }
            j17 = 0;
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar3 : this.f107496i) {
                j17 += aVar3.f107561e - aVar3.f107560d;
            }
        }
        long j18 = (j3 - j16) + j17;
        if (j18 > 0) {
            return j18;
        }
        return 0L;
    }

    private long c() {
        long j3;
        synchronized (this.f107495h) {
            j3 = 0;
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar : this.f107495h) {
                j3 += aVar.f107561e - aVar.f107560d;
            }
        }
        synchronized (this.f107496i) {
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 : this.f107496i) {
                j3 += aVar2.f107561e - aVar2.f107560d;
            }
        }
        return j3;
    }

    private com.tencent.gamecenter.wadl.sdk.downloader.task.i.a j() {
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar;
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2;
        synchronized (this.f107495h) {
            if (this.f107495h.size() == 0) {
                aVar2 = new com.tencent.gamecenter.wadl.sdk.downloader.task.i.a(this, 0L, 0L, 0L, -1L);
                Log.i("Wadl-downloader-TaskDivider", "getSectionFromSectionList first");
            } else {
                com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar3 = this.f107495h.get(0);
                Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.a> it = this.f107495h.iterator();
                while (true) {
                    if (it.hasNext()) {
                        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a next = it.next();
                        if (!next.f107564h && next.a(this.f107488a) > 0) {
                            Log.i("Wadl-downloader-TaskDivider", "Old task is found, return it+++++++++++++, eachSection.id:" + next.f107558b);
                            next.f107565i = true;
                            aVar = next;
                            break;
                        }
                        if (next.a(this.f107488a) > aVar3.a(this.f107488a)) {
                            aVar3 = next;
                        }
                    } else {
                        aVar = null;
                        break;
                    }
                }
                if (aVar == null) {
                    long a16 = aVar3.a(this.f107488a);
                    long j3 = aVar3.f107562f;
                    if (a16 > com.tencent.gamecenter.wadl.sdk.downloader.a.a.l() * 2) {
                        long j16 = j3 + (a16 / 2);
                        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar4 = new com.tencent.gamecenter.wadl.sdk.downloader.task.i.a(this, j16, j16, j16, aVar3.f107563g);
                        aVar4.f107559c = aVar3.f107558b;
                        aVar2 = aVar4;
                    } else {
                        Log.w("Wadl-downloader-TaskDivider", "getSectionFromSectionList end remain invalid");
                    }
                }
                aVar2 = aVar;
            }
            if (aVar2 != null) {
                aVar2.f107564h = true;
            }
        }
        return aVar2;
    }

    public com.tencent.gamecenter.wadl.sdk.downloader.task.i.a a(int i3) {
        synchronized (this.f107495h) {
            try {
                try {
                    for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar : this.f107495h) {
                        if (aVar.f107558b == i3) {
                            return aVar;
                        }
                    }
                } catch (Exception e16) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskDivider", e16);
                }
                synchronized (this.f107496i) {
                    try {
                        try {
                            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 : this.f107496i) {
                                if (aVar2.f107558b == i3) {
                                    return aVar2;
                                }
                            }
                        } catch (Exception e17) {
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskDivider", e17);
                        }
                        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskDivider", "getSection fail. sectionId:" + i3 + ", divider:" + l());
                        return null;
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    public int d() {
        return this.f107498k;
    }

    public long e() {
        return this.f107497j;
    }

    public com.tencent.gamecenter.wadl.sdk.downloader.task.i.a f() {
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a j3 = j();
        if (j3 != null) {
            return j3;
        }
        return i();
    }

    public long g() {
        long j3;
        long j16;
        long j17;
        synchronized (this.f107495h) {
            j3 = 0;
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar : this.f107495h) {
                j3 += aVar.f107562f - aVar.f107560d;
            }
        }
        synchronized (this.f107496i) {
            j16 = 0;
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 : this.f107496i) {
                j16 += aVar2.f107563g - aVar2.f107560d;
            }
            j17 = 0;
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar3 : this.f107496i) {
                j17 += aVar3.f107562f - aVar3.f107560d;
            }
        }
        long j18 = (j3 - j16) + j17;
        if (j18 <= 0) {
            return 0L;
        }
        return j18;
    }

    public long h() {
        return b();
    }

    public com.tencent.gamecenter.wadl.sdk.downloader.task.i.a i() {
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar;
        synchronized (this.f107496i) {
            Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.a> it = this.f107496i.iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = it.next();
                    if (!aVar.f107564h && aVar.f107562f != aVar.f107563g) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar != null) {
                aVar.f107564h = true;
            }
        }
        return aVar;
    }

    public boolean k() {
        long g16 = g();
        if (g16 > 0 && g16 == this.f107488a) {
            return true;
        }
        return false;
    }

    public String l() {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder("3.0");
        sb5.append("|");
        sb5.append(this.f107488a);
        sb5.append("|");
        sb5.append(this.f107489b);
        sb5.append("|");
        sb5.append(this.f107490c);
        sb5.append("|");
        sb5.append(this.f107491d);
        sb5.append("|");
        synchronized (this.f107495h) {
            Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.a> it = this.f107495h.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().a());
                sb5.append(";");
            }
            if (this.f107495h.size() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        sb5.append("|");
        sb5.append("null");
        sb5.append("|");
        if (TextUtils.isEmpty(this.f107492e)) {
            str = "null";
        } else {
            str = this.f107492e;
        }
        sb5.append(str);
        sb5.append("|");
        if (TextUtils.isEmpty(this.f107493f)) {
            str2 = "null";
        } else {
            str2 = this.f107493f;
        }
        sb5.append(str2);
        sb5.append("|");
        synchronized (this.f107496i) {
            Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.a> it5 = this.f107496i.iterator();
            while (it5.hasNext()) {
                sb5.append(it5.next().a());
                sb5.append(";");
            }
            if (this.f107496i.size() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        sb5.append("|");
        sb5.append(this.f107497j + ";" + this.f107498k);
        return sb5.toString();
    }

    public String toString() {
        return l();
    }

    public void a(long j3, int i3) {
        if (this.f107497j != 0 && this.f107497j > j3) {
            j3 = this.f107497j;
        }
        this.f107497j = j3;
        if (this.f107498k != 0 && this.f107498k > i3) {
            i3 = this.f107498k;
        }
        this.f107498k = i3;
    }

    public void b(com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar) {
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2;
        if (aVar.f107563g != -1 && aVar.f107560d < aVar.f107563g) {
            synchronized (this.f107496i) {
                int i3 = 0;
                int i16 = 0;
                while (true) {
                    if (i16 >= this.f107496i.size()) {
                        aVar2 = null;
                        break;
                    }
                    aVar2 = this.f107496i.get(i16);
                    if (aVar2.f107560d == aVar.f107560d) {
                        i3 = i16;
                        break;
                    }
                    i16++;
                }
                if (aVar2 == null) {
                    int size = this.f107496i.size();
                    int i17 = size > 0 ? this.f107496i.get(size - 1).f107558b + 1 : 10000;
                    aVar.f107559c = i17;
                    aVar.f107558b = i17;
                    this.f107496i.add(aVar);
                    return;
                }
                if (aVar.f107563g <= aVar2.f107563g) {
                    aVar = aVar2;
                }
                aVar.f107558b = aVar2.f107558b;
                aVar.f107559c = aVar2.f107559c;
                this.f107496i.remove(i3);
                this.f107496i.add(i3, aVar);
            }
        }
    }

    public boolean c(com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar) {
        return aVar.f107566j == this;
    }

    public void d(com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar) {
        aVar.f107564h = false;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || str.equals("null")) {
            this.f107492e = "";
        } else {
            this.f107492e = str.replace("|", "");
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || str.equals("null")) {
            this.f107493f = "";
        } else {
            this.f107493f = str.replace("|", "");
        }
    }

    public boolean a() {
        long j3 = this.f107488a;
        return j3 > 0 && j3 == b();
    }

    public boolean a(com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar) {
        if (aVar.f107558b == -1) {
            synchronized (this.f107495h) {
                int i3 = aVar.f107559c;
                if (i3 == -1) {
                    if (this.f107495h.size() == 0) {
                        aVar.f107558b = 0;
                        aVar.f107563g = this.f107488a;
                        this.f107495h.add(aVar);
                        Log.i("Wadl-downloader-TaskDivider", "[" + Thread.currentThread().getName() + "],[addRealSection] success section++++++++  first add  curTaskLen:" + (((aVar.f107563g - aVar.f107560d) / 1000) / 1000) + "M, sectionId=" + aVar.f107558b);
                        return true;
                    }
                    com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskDivider", "[addRealSection] first section, list size should be 0!!!");
                } else {
                    if (i3 < this.f107495h.size()) {
                        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 = null;
                        for (com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar3 : this.f107495h) {
                            if (aVar3.f107558b == aVar.f107559c) {
                                if (aVar3.f107562f >= aVar3.f107563g) {
                                    Log.w("Wadl-downloader-TaskDivider", "addRealSection parent is finish");
                                    return false;
                                }
                                if (aVar3.f107562f + com.tencent.gamecenter.wadl.sdk.downloader.a.a.l() > aVar.f107560d) {
                                    Log.w("Wadl-downloader-TaskDivider", "addRealSection is low limit");
                                    return false;
                                }
                                aVar2 = aVar3;
                            } else if (aVar3.f107563g > aVar.f107560d && aVar3.f107560d < aVar.f107563g) {
                                Log.w("Wadl-downloader-TaskDivider", "addRealSection is same,sectionStart:" + aVar.f107560d + ",sectionEnd:" + aVar.f107563g + ",thread name:" + Thread.currentThread().getName());
                                return false;
                            }
                        }
                        if (aVar2 == null) {
                            Log.i("Wadl-downloader-TaskDivider", "addRealSection parent is null");
                            return false;
                        }
                        aVar.f107558b = this.f107495h.size();
                        aVar2.f107563g = aVar.f107560d;
                        this.f107495h.add(aVar);
                        Log.i("Wadl-downloader-TaskDivider", "[" + Thread.currentThread().getName() + "],[addRealSection] success section++++++++ curTaskLen:" + (((aVar.f107563g - aVar.f107560d) / 1000) / 1000) + "M, sectionId=" + aVar.f107558b + ",total=" + this.f107495h.size() + "; start=" + aVar.f107560d + ",end=" + aVar.f107563g);
                        return true;
                    }
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskDivider", "parent id:" + aVar.f107559c + " wrong!!!");
                }
            }
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskDivider", "addRealSection of id " + aVar.f107558b + " should not happen!!!");
        }
        return false;
    }

    private boolean a(String[] strArr) {
        return strArr == null || strArr.length < 7 || !strArr[0].equals("3.0");
    }
}
