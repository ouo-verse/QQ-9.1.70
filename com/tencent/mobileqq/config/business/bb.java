package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    public List<a> f202590a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @Alias("bkgURL")
        public String f202591a;

        /* renamed from: b, reason: collision with root package name */
        @Alias("isStatusBarWhite")
        public int f202592b;

        /* renamed from: c, reason: collision with root package name */
        @Alias("isNavBarWhite")
        public int f202593c;

        /* renamed from: d, reason: collision with root package name */
        @Alias("logoColor")
        public String f202594d;

        /* renamed from: e, reason: collision with root package name */
        @Alias("needShowLogo")
        public int f202595e;

        public a() {
            this.f202591a = "";
            this.f202592b = 0;
            this.f202593c = 0;
            this.f202594d = "";
            this.f202595e = 1;
        }

        public boolean a() {
            if (("default_bg".equals(this.f202591a) && SimpleModeHelper.A()) || this.f202593c == 1) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (this.f202595e == 1) {
                return true;
            }
            return false;
        }

        public boolean c() {
            if (("default_bg".equals(this.f202591a) && SimpleModeHelper.A()) || this.f202592b == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "QrCodeList{bkgURL = " + this.f202591a + ", isStatusBarWhite = " + this.f202592b + ", isNavBarWhite = " + this.f202593c + ", logoColor = " + this.f202594d + ", needShowLogo = " + this.f202595e + '}';
        }

        public a(a aVar, String str, int i3) {
            this.f202591a = "";
            this.f202592b = 0;
            this.f202593c = 0;
            this.f202594d = "";
            this.f202595e = 1;
            aVar = aVar == null ? new a() : aVar;
            this.f202592b = aVar.f202592b;
            this.f202594d = aVar.f202594d;
            this.f202595e = aVar.f202595e;
            this.f202593c = i3;
            this.f202591a = str;
        }
    }
}
