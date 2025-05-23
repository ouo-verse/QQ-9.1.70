package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f207639a;

        /* renamed from: b, reason: collision with root package name */
        public int f207640b;

        public a(String str, int i3) {
            this.f207639a = str;
            this.f207640b = i3;
        }

        public String toString() {
            return "" + this.f207639a + ":" + this.f207640b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f207641a;

        /* renamed from: b, reason: collision with root package name */
        public int f207642b;

        public b(String str, int i3) {
            this.f207641a = str;
            this.f207642b = i3;
        }

        public String a() {
            String str = this.f207641a;
            if (str != null && str.startsWith("[") && this.f207641a.endsWith("]")) {
                String str2 = this.f207641a;
                return str2.substring(1, str2.length() - 1);
            }
            return this.f207641a;
        }

        public String toString() {
            return "" + this.f207641a + ":" + this.f207642b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f207643a = 0;

        /* renamed from: b, reason: collision with root package name */
        public List<b> f207644b = new ArrayList();

        public boolean a() {
            List<b> list = this.f207644b;
            if (list != null && list.size() != 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            String str;
            if (a()) {
                return "TPType:" + this.f207643a + "IPList:";
            }
            String str2 = "TPType:" + this.f207643a + "IPList:";
            for (b bVar : this.f207644b) {
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.f207641a)) {
                        str = bVar.f207641a + ":" + bVar.f207642b + " ";
                    } else {
                        str = ":" + bVar.f207642b + " ";
                    }
                    str2 = str2 + str;
                }
            }
            return str2;
        }
    }

    public static void a(List<b> list, List<String> list2, boolean z16, boolean z17) {
        if (list != null && list2 != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                b bVar = list.get(size);
                if (bVar != null && !TextUtils.isEmpty(bVar.f207641a)) {
                    if (z16) {
                        if (z17) {
                            if (!TextUtils.isEmpty(bVar.a())) {
                                list2.add(0, bVar.a());
                            }
                        } else {
                            list2.add(0, bVar.f207641a);
                        }
                    } else if (z17) {
                        if (!TextUtils.isEmpty(bVar.a())) {
                            list2.add(0, bVar.a() + ":" + bVar.f207642b);
                        }
                    } else {
                        list2.add(0, bVar.f207641a + ":" + bVar.f207642b);
                    }
                }
            }
        }
    }

    public static boolean b() {
        return false;
    }

    public static IFileIPv6StrateyController c() {
        return (IFileIPv6StrateyController) QRoute.api(IFileIPv6StrateyController.class);
    }
}
