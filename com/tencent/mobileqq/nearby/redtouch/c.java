package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: j, reason: collision with root package name */
    public static HashMap<Integer, Integer> f253067j;

    /* renamed from: f, reason: collision with root package name */
    public int f253073f;

    /* renamed from: g, reason: collision with root package name */
    public int f253074g;

    /* renamed from: a, reason: collision with root package name */
    public int f253068a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f253069b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f253070c = "";

    /* renamed from: d, reason: collision with root package name */
    public List<String> f253071d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public long f253072e = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f253075h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f253076i = "";

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f253067j = hashMap;
        hashMap.put(11, 20);
        f253067j.put(3, 40);
        f253067j.put(5, 60);
        f253067j.put(0, 80);
        f253067j.put(-1, 100);
    }

    public void c(int i3) {
        this.f253069b += i3;
    }

    public void d(String str) {
        int i3;
        try {
            i3 = Integer.valueOf(str).intValue();
        } catch (NumberFormatException e16) {
            QLog.e("NearbyRedInfo", 1, e16, new Object[0]);
            this.f253070c = str;
            i3 = 0;
        }
        this.f253069b += i3;
    }

    public void e(int i3) {
        Integer num = f253067j.get(Integer.valueOf(i3));
        Integer num2 = f253067j.get(Integer.valueOf(this.f253068a));
        if (num == null || num2 == null || num.compareTo(num2) >= 0) {
            return;
        }
        this.f253068a = i3;
    }

    public String toString() {
        return "[redType=" + this.f253068a + ", redNum=" + this.f253069b + ", redTxt=" + this.f253070c + ", redAppIdType=" + this.f253074g + ", url=" + this.f253071d + "]";
    }

    public void a(String str, boolean z16) {
        if (str == null) {
            return;
        }
        if (z16) {
            this.f253071d.clear();
        }
        this.f253071d.add(str);
    }

    public void b(List<String> list, boolean z16) {
        if (list == null) {
            return;
        }
        if (z16) {
            this.f253071d.clear();
        }
        this.f253071d.addAll(list);
    }
}
