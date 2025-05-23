package com.tencent.mobileqq.activity.aio.photo;

import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.emotionintegrate.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f179731d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private ArrayMap<String, List<Object>> f179732a = new ArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayMap<String, Boolean> f179733b = new ArrayMap<>();

    /* renamed from: c, reason: collision with root package name */
    private int f179734c = 0;

    private void a(int i3, String str, List<Object> list) {
        List<Object> list2;
        b();
        if (str == null || i3 < 0 || list == null || (list2 = this.f179732a.get(str)) == null) {
            return;
        }
        list.addAll(i3, list2);
        this.f179734c -= list2.size();
    }

    private int f(String str, int i3, List<Object> list) {
        b();
        if (str == null || i3 <= 0 || list == null) {
            return -1;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            Object obj = list.get(i16);
            if ((obj instanceof String) && ((String) obj).equals(str)) {
                return i16 + i3;
            }
        }
        return -1;
    }

    private void i(int i3, String str, List<Object> list) {
        List<Object> list2;
        b();
        if (str == null || i3 < 0 || list == null || (list2 = this.f179732a.get(str)) == null) {
            return;
        }
        for (int size = list2.size(); size > 0 && i3 < list.size(); size--) {
            list.remove(i3);
        }
        this.f179734c += list2.size();
    }

    public void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
        } else {
            throw new RuntimeException("This method must be called on UI thread");
        }
    }

    public boolean c(String str, int i3, List<Object> list) {
        boolean z16;
        b();
        if (this.f179732a.get(str) == null) {
            return false;
        }
        if (this.f179733b.get(str) != null) {
            z16 = this.f179733b.get(str).booleanValue();
        } else {
            z16 = true;
        }
        this.f179733b.put(str, Boolean.valueOf(!z16));
        int f16 = f(str, i3, list);
        if (!z16) {
            a(f16, str, list);
        } else {
            i(f16, str, list);
        }
        return z16;
    }

    public void d(boolean z16, int i3, List<Object> list) {
        b();
        if (list != null && i3 > 0) {
            this.f179732a.clear();
            List<Object> list2 = null;
            for (int i16 = 0; i16 < list.size(); i16++) {
                Object obj = list.get(i16);
                if (obj instanceof String) {
                    list2 = this.f179732a.get(obj);
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                        this.f179732a.put((String) obj, list2);
                    }
                } else if (list2 != null && ((obj instanceof f) || obj == f179731d || (obj instanceof s) || obj == com.tencent.mobileqq.emotionintegrate.i.U)) {
                    list2.add(obj);
                }
            }
            this.f179734c = 0;
            if (z16) {
                for (Map.Entry<String, Boolean> entry : this.f179733b.entrySet()) {
                    String key = entry.getKey();
                    Boolean value = entry.getValue();
                    if (value != null && !value.booleanValue()) {
                        i(f(key, i3, list), key, list);
                    }
                }
                return;
            }
            this.f179733b.clear();
        }
    }

    public List<Object> e(String str) {
        b();
        return this.f179732a.get(str);
    }

    public int g() {
        b();
        return this.f179734c;
    }

    public boolean h(String str) {
        b();
        Boolean bool = this.f179733b.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public void j(List<Object> list, int i3) {
        b();
        if (list != null && i3 > 0) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                Object obj = list.get(i16);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (this.f179733b.get(str) != null && !this.f179733b.get(str).booleanValue() && this.f179732a.get(obj) != null) {
                        list.addAll(i16 + i3, this.f179732a.get(obj));
                    }
                }
            }
        }
    }
}
