package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.city_views;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPPromoteCity implements Comparable<QPPromoteCity> {
    public ArrayList<Integer> cidx;
    public String fullname;

    /* renamed from: id, reason: collision with root package name */
    public String f114255id;
    public ArrayList<String> pinyin;

    public QPPromoteCity() {
        this(null, null, null, null, null, 63);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0094, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        if (r5.length() > r6.length()) goto L19;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compareTo(QPPromoteCity qPPromoteCity) {
        QPPromoteCity qPPromoteCity2 = qPPromoteCity;
        int min = Math.min(this.pinyin.size(), qPPromoteCity2.pinyin.size());
        int i3 = 0;
        while (true) {
            int i16 = -1;
            if (i3 < min) {
                String str = this.pinyin.get(i3);
                String str2 = qPPromoteCity2.pinyin.get(i3);
                int min2 = Math.min(str.length(), str2.length());
                int i17 = 0;
                while (true) {
                    if (i17 < min2) {
                        if (Intrinsics.compare((int) str.charAt(i17), (int) str2.charAt(i17)) > 0) {
                            break;
                        }
                        if (Intrinsics.compare((int) str.charAt(i17), (int) str2.charAt(i17)) < 0) {
                            break;
                        }
                        i17++;
                    } else if (str.length() == str2.length()) {
                        i16 = 0;
                    }
                }
                i16 = 1;
                if (i16 != 0) {
                    break;
                }
                i3++;
            } else {
                if (this.pinyin.size() == qPPromoteCity2.pinyin.size()) {
                    return 0;
                }
                if (this.pinyin.size() > qPPromoteCity2.pinyin.size()) {
                    return 1;
                }
            }
        }
    }

    public final QPPromoteCity decode(e eVar) {
        String p16 = eVar.p("id");
        if (p16.length() == 0) {
            p16 = eVar.p("id_");
        }
        String str = p16;
        String p17 = eVar.p("name");
        String p18 = eVar.p("fullname");
        ArrayList arrayList = new ArrayList(10);
        ArrayList arrayList2 = new ArrayList(2);
        b l3 = eVar.l("pinyin");
        if (l3 != null) {
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                String o16 = l3.o(i3);
                if (!(o16 == null || o16.length() == 0)) {
                    arrayList.add(o16);
                }
            }
        }
        b l16 = eVar.l("cidx");
        if (l16 != null) {
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                arrayList2.add(Integer.valueOf(l16.i(i16)));
            }
        }
        return new QPPromoteCity(str, p17, p18, arrayList, arrayList2, 32);
    }

    public final int hashCode() {
        return this.f114255id.hashCode();
    }

    public QPPromoteCity(String str, String str2, ArrayList arrayList, ArrayList arrayList2) {
        this.f114255id = str;
        this.fullname = str2;
        this.pinyin = arrayList;
        this.cidx = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QPPromoteCity)) {
            return false;
        }
        return Intrinsics.areEqual(((QPPromoteCity) obj).f114255id, this.f114255id);
    }

    public /* synthetic */ QPPromoteCity(String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? new ArrayList(10) : arrayList, (i3 & 16) != 0 ? new ArrayList(2) : arrayList2);
    }
}
