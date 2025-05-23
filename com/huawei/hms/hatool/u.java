package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private List<b1> f37231a;

    /* renamed from: b, reason: collision with root package name */
    private String f37232b;

    /* renamed from: c, reason: collision with root package name */
    private String f37233c;

    /* renamed from: d, reason: collision with root package name */
    private String f37234d;

    public u(List<b1> list, String str, String str2, String str3) {
        this.f37231a = list;
        this.f37232b = str;
        this.f37233c = str2;
        this.f37234d = str3;
    }

    public void a() {
        if (!"_default_config_tag".equals(this.f37233c)) {
            a(this.f37231a, this.f37233c, this.f37232b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (b1 b1Var : this.f37231a) {
            String c16 = b1Var.c();
            if (TextUtils.isEmpty(c16) || "oper".equals(c16)) {
                arrayList4.add(b1Var);
            } else if ("maint".equals(c16)) {
                arrayList.add(b1Var);
            } else if ("preins".equals(c16)) {
                arrayList2.add(b1Var);
            } else if ("diffprivacy".equals(c16)) {
                arrayList3.add(b1Var);
            }
        }
        a(arrayList4, "oper", "_default_config_tag");
        a(arrayList, "maint", "_default_config_tag");
        a(arrayList2, "preins", "_default_config_tag");
        a(arrayList3, "diffprivacy", "_default_config_tag");
    }

    private void a(List<b1> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i3 = 0; i3 < size; i3++) {
            int i16 = i3 * 500;
            List<b1> subList = list.subList(i16, Math.min(list.size(), i16 + 500));
            String replace = UUID.randomUUID().toString().replace("-", "");
            long currentTimeMillis = System.currentTimeMillis();
            long b16 = a1.b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (b1 b1Var : subList) {
                if (!c0.a(b1Var.b(), currentTimeMillis, b16)) {
                    arrayList.add(b1Var);
                }
            }
            if (arrayList.size() > 0) {
                new l0(str2, str, this.f37234d, arrayList, replace).a();
            } else {
                v.e("hmsSdk", "No data to report handler");
            }
        }
    }
}
