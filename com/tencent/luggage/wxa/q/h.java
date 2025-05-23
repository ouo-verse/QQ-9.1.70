package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.a0.a;
import com.tencent.luggage.wxa.c0.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static final g.a f137751c = new a();

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f137752d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f137753a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f137754b = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements g.a {
        @Override // com.tencent.luggage.wxa.c0.g.a
        public boolean a(int i3, int i16, int i17, int i18, int i19) {
            if (i16 == 67 && i17 == 79 && i18 == 77 && (i19 == 77 || i3 == 2)) {
                return true;
            }
            return false;
        }
    }

    public boolean a(int i3) {
        int i16 = i3 >> 12;
        int i17 = i3 & 4095;
        if (i16 <= 0 && i17 <= 0) {
            return false;
        }
        this.f137753a = i16;
        this.f137754b = i17;
        return true;
    }

    public boolean a(com.tencent.luggage.wxa.a0.a aVar) {
        for (int i3 = 0; i3 < aVar.a(); i3++) {
            a.b a16 = aVar.a(i3);
            if (a16 instanceof com.tencent.luggage.wxa.c0.e) {
                com.tencent.luggage.wxa.c0.e eVar = (com.tencent.luggage.wxa.c0.e) a16;
                if (a(eVar.f123179c, eVar.f123180d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f137752d.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.f137753a = parseInt;
                    this.f137754b = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public boolean a() {
        return (this.f137753a == -1 || this.f137754b == -1) ? false : true;
    }
}
