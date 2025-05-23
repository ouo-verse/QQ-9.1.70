package com.tencent.luggage.wxa.m6;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.m2;
import com.tencent.luggage.wxa.hn.w8;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/luggage/wxa/m6/k;", "Lcom/tencent/luggage/wxa/hn/m2;", "", "f", "", "o", "", "equals", "", "hashCode", "", "e", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class k extends m2 {
    public final String e() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "no";
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return Global.TRACKING_WIFI;
        }
        if (NetworkMonitor.netGetExInfo(activeNetworkInfo) == null) {
            return "no";
        }
        String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
        Intrinsics.checkNotNullExpressionValue(netGetExInfo, "activeNetInfo.extraInfo");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = netGetExInfo.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public boolean equals(Object o16) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        byte[] bArr;
        byte[] bArr2;
        boolean z37;
        boolean z38;
        boolean z39;
        if (this == o16) {
            return true;
        }
        boolean z46 = false;
        if (o16 == null || !Intrinsics.areEqual(k.class, o16.getClass())) {
            return false;
        }
        m2 m2Var = (m2) o16;
        if (this.f128113e != m2Var.f128113e || this.f128120l != m2Var.f128120l || this.f128121m != m2Var.f128121m || this.f128125q != m2Var.f128125q || this.f128126r != m2Var.f128126r || this.f128127s != m2Var.f128127s || this.f128129u != m2Var.f128129u || this.f128130v != m2Var.f128130v || this.f128133y != m2Var.f128133y || this.B != m2Var.B) {
            return false;
        }
        e9 e9Var = this.f128115g;
        if (e9Var == null ? m2Var.f128115g != null : !Intrinsics.areEqual(e9Var.f(), m2Var.f128115g.f())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        e9 e9Var2 = this.f128116h;
        if (e9Var2 == null ? m2Var.f128116h != null : !Intrinsics.areEqual(e9Var2.f(), m2Var.f128116h.f())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return false;
        }
        e9 e9Var3 = this.f128117i;
        if (e9Var3 == null ? m2Var.f128117i != null : !Intrinsics.areEqual(e9Var3.f(), m2Var.f128117i.f())) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return false;
        }
        e9 e9Var4 = this.f128118j;
        if (e9Var4 == null ? m2Var.f128118j != null : !Intrinsics.areEqual(e9Var4.f(), m2Var.f128118j.f())) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return false;
        }
        String str = this.f128119k;
        if (str == null ? m2Var.f128119k != null : !Intrinsics.areEqual(str, m2Var.f128119k)) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            return false;
        }
        String str2 = this.f128122n;
        if (str2 == null ? m2Var.f128122n != null : !Intrinsics.areEqual(str2, m2Var.f128122n)) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            return false;
        }
        String str3 = this.f128123o;
        if (str3 == null ? m2Var.f128123o != null : !Intrinsics.areEqual(str3, m2Var.f128123o)) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z28) {
            return false;
        }
        String str4 = this.f128128t;
        if (str4 == null ? m2Var.f128128t != null : !Intrinsics.areEqual(str4, m2Var.f128128t)) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z29) {
            return false;
        }
        String str5 = this.f128132x;
        if (str5 == null ? m2Var.f128132x != null : !Intrinsics.areEqual(str5, m2Var.f128132x)) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (z36) {
            return false;
        }
        w8 w8Var = this.f128134z;
        String str6 = null;
        if (w8Var != null) {
            bArr = w8Var.f();
        } else {
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        String a16 = w0.a(bArr);
        if (a16 == null) {
            a16 = null;
        }
        w8 w8Var2 = m2Var.f128134z;
        if (w8Var2 != null) {
            bArr2 = w8Var2.f();
        } else {
            bArr2 = null;
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        String a17 = w0.a(bArr2);
        if (a17 != null) {
            str6 = a17;
        }
        if (a16 == null ? str6 != null : !Intrinsics.areEqual(a16, str6)) {
            z37 = true;
        } else {
            z37 = false;
        }
        if (z37) {
            return false;
        }
        String str7 = this.A;
        if (str7 == null ? m2Var.A != null : !Intrinsics.areEqual(str7, m2Var.A)) {
            z38 = true;
        } else {
            z38 = false;
        }
        if (z38) {
            return false;
        }
        String str8 = this.C;
        if (str8 == null ? m2Var.C != null : !Intrinsics.areEqual(str8, m2Var.C)) {
            z39 = true;
        } else {
            z39 = false;
        }
        if (z39) {
            return false;
        }
        String str9 = this.D;
        String str10 = m2Var.D;
        if (str9 == null ? str10 != null : !Intrinsics.areEqual(str9, str10)) {
            z46 = true;
        }
        return !z46;
    }

    public final void f() {
        this.f128128t = e();
        this.f128131w = (int) w0.c();
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        byte[] bArr;
        int i36;
        int i37;
        int i38;
        int i39 = this.f128113e * 31;
        e9 e9Var = this.f128115g;
        int i46 = 0;
        if (e9Var != null) {
            i3 = e9Var.f().hashCode();
        } else {
            i3 = 0;
        }
        int i47 = (i39 + i3) * 31;
        e9 e9Var2 = this.f128116h;
        if (e9Var2 != null) {
            i16 = e9Var2.f().hashCode();
        } else {
            i16 = 0;
        }
        int i48 = (i47 + i16) * 31;
        e9 e9Var3 = this.f128117i;
        if (e9Var3 != null) {
            i17 = e9Var3.f().hashCode();
        } else {
            i17 = 0;
        }
        int i49 = (i48 + i17) * 31;
        e9 e9Var4 = this.f128118j;
        if (e9Var4 != null) {
            i18 = e9Var4.f().hashCode();
        } else {
            i18 = 0;
        }
        int i56 = (i49 + i18) * 31;
        String str = this.f128119k;
        if (str != null) {
            i19 = str.hashCode();
        } else {
            i19 = 0;
        }
        int i57 = (((((i56 + i19) * 31) + this.f128120l) * 31) + this.f128121m) * 31;
        String str2 = this.f128122n;
        if (str2 != null) {
            i26 = str2.hashCode();
        } else {
            i26 = 0;
        }
        int i58 = (i57 + i26) * 31;
        String str3 = this.f128123o;
        if (str3 != null) {
            i27 = str3.hashCode();
        } else {
            i27 = 0;
        }
        int i59 = (((((((i58 + i27) * 31) + this.f128125q) * 31) + this.f128126r) * 31) + this.f128127s) * 31;
        String str4 = this.f128128t;
        if (str4 != null) {
            i28 = str4.hashCode();
        } else {
            i28 = 0;
        }
        int i65 = (((((i59 + i28) * 31) + this.f128129u) * 31) + this.f128130v) * 31;
        String str5 = this.f128132x;
        if (str5 != null) {
            i29 = str5.hashCode();
        } else {
            i29 = 0;
        }
        int i66 = ((i65 + i29) * 31) + this.f128133y;
        w8 w8Var = this.f128134z;
        String str6 = null;
        if (w8Var != null) {
            bArr = w8Var.f();
        } else {
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        String a16 = w0.a(bArr);
        if (a16 != null) {
            str6 = a16;
        }
        int i67 = i66 * 31;
        if (str6 != null) {
            i36 = str6.hashCode();
        } else {
            i36 = 0;
        }
        int i68 = (i67 + i36) * 31;
        String str7 = this.A;
        if (str7 != null) {
            i37 = str7.hashCode();
        } else {
            i37 = 0;
        }
        int i69 = (((i68 + i37) * 31) + this.B) * 31;
        String str8 = this.C;
        if (str8 != null) {
            i38 = str8.hashCode();
        } else {
            i38 = 0;
        }
        int i75 = (i69 + i38) * 31;
        String str9 = this.D;
        if (str9 != null) {
            i46 = str9.hashCode();
        }
        return i75 + i46;
    }
}
