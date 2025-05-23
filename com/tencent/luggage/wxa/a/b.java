package com.tencent.luggage.wxa.a;

import android.util.Log;
import com.tencent.luggage.wxa.a.h;
import com.tencent.luggage.wxa.a.l;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public f f120395a;

    /* renamed from: b, reason: collision with root package name */
    public u f120396b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f120397c = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120398a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f120399b;

        static {
            int[] iArr = new int[j.values().length];
            f120399b = iArr;
            try {
                iArr[j.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f120399b[j.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f120399b[j.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f120399b[j.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f120399b[j.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f120399b[j.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f120399b[j.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f120399b[j.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f120399b[j.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f120399b[j.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f120399b[j.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f120399b[j.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f120399b[j.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f120399b[j.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f120399b[j.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f120399b[j.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f120399b[j.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f120399b[j.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f120399b[j.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f120399b[j.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f120399b[j.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f120399b[j.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f120399b[j.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f120399b[j.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[c.values().length];
            f120398a = iArr2;
            try {
                iArr2[c.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f120398a[c.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f120398a[c.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C5977b {

        /* renamed from: a, reason: collision with root package name */
        public final String f120400a;

        /* renamed from: b, reason: collision with root package name */
        public final c f120401b;

        /* renamed from: c, reason: collision with root package name */
        public final String f120402c;

        public C5977b(String str, c cVar, String str2) {
            this.f120400a = str;
            this.f120401b = cVar;
            this.f120402c = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends l.i {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f120408a;

            /* renamed from: b, reason: collision with root package name */
            public int f120409b;

            public a(int i3, int i16) {
                this.f120408a = i3;
                this.f120409b = i16;
            }
        }

        public d(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public String A() {
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            if (!a("url(")) {
                return null;
            }
            q();
            String t16 = t();
            if (t16 == null) {
                t16 = w();
            }
            if (t16 == null) {
                this.f120830b = i3;
                return null;
            }
            q();
            if (!c() && !a(")")) {
                this.f120830b = i3;
                return null;
            }
            return t16;
        }

        public final int B() {
            int i3;
            if (c()) {
                return this.f120830b;
            }
            int i16 = this.f120830b;
            int charAt = this.f120829a.charAt(i16);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int a16 = a();
                while (true) {
                    if ((a16 < 65 || a16 > 90) && ((a16 < 97 || a16 > 122) && !((a16 >= 48 && a16 <= 57) || a16 == 45 || a16 == 95))) {
                        break;
                    }
                    a16 = a();
                }
                i3 = this.f120830b;
            } else {
                i3 = i16;
            }
            this.f120830b = i16;
            return i3;
        }

        public final int c(int i3) {
            if (i3 >= 48 && i3 <= 57) {
                return i3 - 48;
            }
            int i16 = 65;
            if (i3 < 65 || i3 > 70) {
                i16 = 97;
                if (i3 < 97 || i3 > 102) {
                    return -1;
                }
            }
            return (i3 - i16) + 10;
        }

        public final a r() {
            int i3;
            com.tencent.luggage.wxa.a.d dVar;
            int b16;
            a aVar;
            if (c()) {
                return null;
            }
            int i16 = this.f120830b;
            if (!a('(')) {
                return null;
            }
            q();
            int i17 = 1;
            if (a("odd")) {
                aVar = new a(2, 1);
            } else {
                int i18 = 0;
                if (a("even")) {
                    aVar = new a(2, 0);
                } else {
                    if (!a('+') && a('-')) {
                        i3 = -1;
                    } else {
                        i3 = 1;
                    }
                    com.tencent.luggage.wxa.a.d a16 = com.tencent.luggage.wxa.a.d.a(this.f120829a, this.f120830b, this.f120831c, false);
                    if (a16 != null) {
                        this.f120830b = a16.a();
                    }
                    if (!a('n') && !a('N')) {
                        dVar = a16;
                        a16 = null;
                    } else {
                        if (a16 == null) {
                            a16 = new com.tencent.luggage.wxa.a.d(1L, this.f120830b);
                        }
                        q();
                        boolean a17 = a('+');
                        if (!a17 && (a17 = a('-'))) {
                            i17 = -1;
                        }
                        if (a17) {
                            q();
                            dVar = com.tencent.luggage.wxa.a.d.a(this.f120829a, this.f120830b, this.f120831c, false);
                            if (dVar != null) {
                                this.f120830b = dVar.a();
                            } else {
                                this.f120830b = i16;
                                return null;
                            }
                        } else {
                            dVar = null;
                        }
                        int i19 = i17;
                        i17 = i3;
                        i3 = i19;
                    }
                    if (a16 == null) {
                        b16 = 0;
                    } else {
                        b16 = i17 * a16.b();
                    }
                    if (dVar != null) {
                        i18 = i3 * dVar.b();
                    }
                    aVar = new a(b16, i18);
                }
            }
            q();
            if (a(')')) {
                return aVar;
            }
            this.f120830b = i16;
            return null;
        }

        public final String s() {
            if (c()) {
                return null;
            }
            String j3 = j();
            if (j3 != null) {
                return j3;
            }
            return v();
        }

        public String t() {
            int c16;
            if (c()) {
                return null;
            }
            char charAt = this.f120829a.charAt(this.f120830b);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            this.f120830b++;
            int intValue = e().intValue();
            while (intValue != -1 && intValue != charAt) {
                if (intValue == 92) {
                    intValue = e().intValue();
                    if (intValue != -1) {
                        if (intValue != 10 && intValue != 13 && intValue != 12) {
                            int c17 = c(intValue);
                            if (c17 != -1) {
                                for (int i3 = 1; i3 <= 5 && (c16 = c((intValue = e().intValue()))) != -1; i3++) {
                                    c17 = (c17 * 16) + c16;
                                }
                                sb5.append((char) c17);
                            }
                        } else {
                            intValue = e().intValue();
                        }
                    }
                }
                sb5.append((char) intValue);
                intValue = e().intValue();
            }
            return sb5.toString();
        }

        public final List u() {
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            if (!a('(')) {
                return null;
            }
            q();
            ArrayList arrayList = null;
            do {
                String v3 = v();
                if (v3 == null) {
                    this.f120830b = i3;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(v3);
                q();
            } while (p());
            if (a(')')) {
                return arrayList;
            }
            this.f120830b = i3;
            return null;
        }

        public String v() {
            int B = B();
            int i3 = this.f120830b;
            if (B == i3) {
                return null;
            }
            String substring = this.f120829a.substring(i3, B);
            this.f120830b = B;
            return substring;
        }

        public String w() {
            char charAt;
            int c16;
            StringBuilder sb5 = new StringBuilder();
            while (!c() && (charAt = this.f120829a.charAt(this.f120830b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !b((int) charAt) && !Character.isISOControl((int) charAt)) {
                this.f120830b++;
                if (charAt == '\\') {
                    if (!c()) {
                        String str = this.f120829a;
                        int i3 = this.f120830b;
                        this.f120830b = i3 + 1;
                        charAt = str.charAt(i3);
                        if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                            int c17 = c((int) charAt);
                            if (c17 != -1) {
                                for (int i16 = 1; i16 <= 5 && !c() && (c16 = c((int) this.f120829a.charAt(this.f120830b))) != -1; i16++) {
                                    this.f120830b++;
                                    c17 = (c17 * 16) + c16;
                                }
                                sb5.append((char) c17);
                            }
                        }
                    }
                }
                sb5.append(charAt);
            }
            if (sb5.length() == 0) {
                return null;
            }
            return sb5.toString();
        }

        public String x() {
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            int charAt = this.f120829a.charAt(i3);
            int i16 = i3;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !a(charAt)) {
                if (!b(charAt)) {
                    i16 = this.f120830b + 1;
                }
                charAt = a();
            }
            if (this.f120830b > i3) {
                return this.f120829a.substring(i3, i16);
            }
            this.f120830b = i3;
            return null;
        }

        public final List y() {
            List list;
            List list2;
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            if (!a('(')) {
                return null;
            }
            q();
            List z16 = z();
            if (z16 == null) {
                this.f120830b = i3;
                return null;
            }
            if (!a(')')) {
                this.f120830b = i3;
                return null;
            }
            Iterator it = z16.iterator();
            while (it.hasNext() && (list = ((s) it.next()).f120453a) != null) {
                Iterator it5 = list.iterator();
                while (it5.hasNext() && (list2 = ((t) it5.next()).f120458d) != null) {
                    Iterator it6 = list2.iterator();
                    while (it6.hasNext()) {
                        if (((g) it6.next()) instanceof k) {
                            return null;
                        }
                    }
                }
            }
            return z16;
        }

        public final List z() {
            a aVar = null;
            if (c()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            s sVar = new s(aVar);
            while (!c() && a(sVar)) {
                if (p()) {
                    arrayList.add(sVar);
                    sVar = new s(aVar);
                }
            }
            if (!sVar.d()) {
                arrayList.add(sVar);
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(s sVar) {
            e eVar;
            t tVar;
            c cVar;
            String str;
            if (c()) {
                return false;
            }
            int i3 = this.f120830b;
            if (!sVar.d()) {
                if (a(Typography.greater)) {
                    eVar = e.CHILD;
                    q();
                } else if (a('+')) {
                    eVar = e.FOLLOWS;
                    q();
                }
                if (!a('*')) {
                    tVar = new t(eVar, null);
                } else {
                    String v3 = v();
                    if (v3 != null) {
                        t tVar2 = new t(eVar, v3);
                        sVar.b();
                        tVar = tVar2;
                    } else {
                        tVar = null;
                    }
                }
                while (!c()) {
                    if (a('.')) {
                        if (tVar == null) {
                            tVar = new t(eVar, null);
                        }
                        String v16 = v();
                        if (v16 != null) {
                            tVar.a(Constants.Service.CLASS, c.EQUALS, v16);
                            sVar.a();
                        } else {
                            throw new com.tencent.luggage.wxa.a.a("Invalid \".class\" simpleSelectors");
                        }
                    } else if (a('#')) {
                        if (tVar == null) {
                            tVar = new t(eVar, null);
                        }
                        String v17 = v();
                        if (v17 != null) {
                            tVar.a("id", c.EQUALS, v17);
                            sVar.c();
                        } else {
                            throw new com.tencent.luggage.wxa.a.a("Invalid \"#id\" simpleSelectors");
                        }
                    } else if (a('[')) {
                        if (tVar == null) {
                            tVar = new t(eVar, null);
                        }
                        q();
                        String v18 = v();
                        if (v18 != null) {
                            q();
                            if (a('=')) {
                                cVar = c.EQUALS;
                            } else if (a("~=")) {
                                cVar = c.INCLUDES;
                            } else {
                                cVar = a("|=") ? c.DASHMATCH : null;
                            }
                            if (cVar != null) {
                                q();
                                str = s();
                                if (str != null) {
                                    q();
                                } else {
                                    throw new com.tencent.luggage.wxa.a.a("Invalid attribute simpleSelectors");
                                }
                            } else {
                                str = null;
                            }
                            if (a(']')) {
                                if (cVar == null) {
                                    cVar = c.EXISTS;
                                }
                                tVar.a(v18, cVar, str);
                                sVar.a();
                            } else {
                                throw new com.tencent.luggage.wxa.a.a("Invalid attribute simpleSelectors");
                            }
                        } else {
                            throw new com.tencent.luggage.wxa.a.a("Invalid attribute simpleSelectors");
                        }
                    } else {
                        if (!a(':')) {
                            break;
                        }
                        if (tVar == null) {
                            tVar = new t(eVar, null);
                        }
                        a(sVar, tVar);
                    }
                }
                if (tVar == null) {
                    sVar.a(tVar);
                    return true;
                }
                this.f120830b = i3;
                return false;
            }
            eVar = null;
            if (!a('*')) {
            }
            while (!c()) {
            }
            if (tVar == null) {
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        public final void a(s sVar, t tVar) {
            g hVar;
            h hVar2;
            String v3 = v();
            if (v3 != null) {
                j a16 = j.a(v3);
                a aVar = null;
                switch (a.f120399b[a16.ordinal()]) {
                    case 1:
                        hVar = new h(0, 1, true, false, null);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 2:
                        hVar = new h(0, 1, false, false, null);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 3:
                        hVar = new m(false, null);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 4:
                        hVar = new h(0, 1, true, true, tVar.f120456b);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 5:
                        hVar = new h(0, 1, false, true, tVar.f120456b);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 6:
                        hVar = new m(true, tVar.f120456b);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 7:
                        hVar = new n(aVar);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 8:
                        hVar = new i(aVar);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        boolean z16 = a16 == j.nth_child || a16 == j.nth_of_type;
                        boolean z17 = a16 == j.nth_of_type || a16 == j.nth_last_of_type;
                        a r16 = r();
                        if (r16 != null) {
                            h hVar3 = new h(r16.f120408a, r16.f120409b, z16, z17, tVar.f120456b);
                            sVar.a();
                            hVar2 = hVar3;
                            hVar = hVar2;
                            tVar.a(hVar);
                            return;
                        }
                        throw new com.tencent.luggage.wxa.a.a("Invalid or missing parameter section for pseudo class: " + v3);
                    case 13:
                        List y16 = y();
                        if (y16 != null) {
                            k kVar = new k(y16);
                            sVar.f120454b = kVar.a();
                            hVar2 = kVar;
                            hVar = hVar2;
                            tVar.a(hVar);
                            return;
                        }
                        throw new com.tencent.luggage.wxa.a.a("Invalid or missing parameter section for pseudo class: " + v3);
                    case 14:
                        hVar = new o(aVar);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 15:
                        u();
                        hVar = new l(v3);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        hVar = new l(v3);
                        sVar.a();
                        tVar.a(hVar);
                        return;
                    default:
                        throw new com.tencent.luggage.wxa.a.a("Unsupported pseudo class: " + v3);
                }
            }
            throw new com.tencent.luggage.wxa.a.a("Invalid pseudo class");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum e {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum f {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
        boolean a(q qVar, h.m0 m0Var);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class h implements g {

        /* renamed from: a, reason: collision with root package name */
        public int f120426a;

        /* renamed from: b, reason: collision with root package name */
        public int f120427b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f120428c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f120429d;

        /* renamed from: e, reason: collision with root package name */
        public String f120430e;

        public h(int i3, int i16, boolean z16, boolean z17, String str) {
            this.f120426a = i3;
            this.f120427b = i16;
            this.f120428c = z16;
            this.f120429d = z17;
            this.f120430e = str;
        }

        @Override // com.tencent.luggage.wxa.a.b.g
        public boolean a(q qVar, h.m0 m0Var) {
            String str;
            int i3;
            int i16;
            int i17;
            if (this.f120429d && this.f120430e == null) {
                str = m0Var.g();
            } else {
                str = this.f120430e;
            }
            h.k0 k0Var = m0Var.f120649b;
            if (k0Var != null) {
                Iterator it = k0Var.getChildren().iterator();
                i3 = 0;
                i16 = 0;
                while (it.hasNext()) {
                    h.m0 m0Var2 = (h.m0) ((h.o0) it.next());
                    if (m0Var2 == m0Var) {
                        i3 = i16;
                    }
                    if (str == null || m0Var2.g().equals(str)) {
                        i16++;
                    }
                }
            } else {
                i3 = 0;
                i16 = 1;
            }
            if (this.f120428c) {
                i17 = i3 + 1;
            } else {
                i17 = i16 - i3;
            }
            int i18 = this.f120426a;
            if (i18 == 0) {
                if (i17 != this.f120427b) {
                    return false;
                }
                return true;
            }
            int i19 = i17 - this.f120427b;
            if (i19 % i18 != 0) {
                return false;
            }
            if (Integer.signum(i19) != 0 && Integer.signum(i17 - this.f120427b) != Integer.signum(this.f120426a)) {
                return false;
            }
            return true;
        }

        public String toString() {
            String str;
            if (this.f120428c) {
                str = "";
            } else {
                str = "last-";
            }
            if (this.f120429d) {
                return String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f120426a), Integer.valueOf(this.f120427b), this.f120430e);
            }
            return String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.f120426a), Integer.valueOf(this.f120427b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class i implements g {
        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.luggage.wxa.a.b.g
        public boolean a(q qVar, h.m0 m0Var) {
            if (!(m0Var instanceof h.k0) || ((h.k0) m0Var).getChildren().size() == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return GlobalUtil.DEF_STRING;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum j {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        public static final Map O = new HashMap();

        static {
            for (j jVar : values()) {
                if (jVar != UNSUPPORTED) {
                    O.put(jVar.name().replace(util.base64_pad_url, '-'), jVar);
                }
            }
        }

        public static j a(String str) {
            j jVar = (j) O.get(str);
            return jVar != null ? jVar : UNSUPPORTED;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class l implements g {

        /* renamed from: a, reason: collision with root package name */
        public String f120445a;

        public l(String str) {
            this.f120445a = str;
        }

        @Override // com.tencent.luggage.wxa.a.b.g
        public boolean a(q qVar, h.m0 m0Var) {
            return false;
        }

        public String toString() {
            return this.f120445a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class m implements g {

        /* renamed from: a, reason: collision with root package name */
        public boolean f120446a;

        /* renamed from: b, reason: collision with root package name */
        public String f120447b;

        public m(boolean z16, String str) {
            this.f120446a = z16;
            this.f120447b = str;
        }

        @Override // com.tencent.luggage.wxa.a.b.g
        public boolean a(q qVar, h.m0 m0Var) {
            String str;
            int i3;
            if (this.f120446a && this.f120447b == null) {
                str = m0Var.g();
            } else {
                str = this.f120447b;
            }
            h.k0 k0Var = m0Var.f120649b;
            if (k0Var != null) {
                Iterator it = k0Var.getChildren().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    h.m0 m0Var2 = (h.m0) ((h.o0) it.next());
                    if (str == null || m0Var2.g().equals(str)) {
                        i3++;
                    }
                }
            } else {
                i3 = 1;
            }
            if (i3 != 1) {
                return false;
            }
            return true;
        }

        public String toString() {
            if (this.f120446a) {
                return String.format("only-of-type <%s>", this.f120447b);
            }
            return String.format("only-child", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class n implements g {
        public n() {
        }

        public /* synthetic */ n(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.a.b.g
        public boolean a(q qVar, h.m0 m0Var) {
            if (m0Var.f120649b == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "root";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class o implements g {
        public o() {
        }

        public /* synthetic */ o(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.a.b.g
        public boolean a(q qVar, h.m0 m0Var) {
            if (qVar == null || m0Var != qVar.f120451a) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "target";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class p {

        /* renamed from: a, reason: collision with root package name */
        public s f120448a;

        /* renamed from: b, reason: collision with root package name */
        public h.f0 f120449b;

        /* renamed from: c, reason: collision with root package name */
        public u f120450c;

        public p(s sVar, h.f0 f0Var, u uVar) {
            this.f120448a = sVar;
            this.f120449b = f0Var;
            this.f120450c = uVar;
        }

        public String toString() {
            return String.valueOf(this.f120448a) + " {...} (src=" + this.f120450c + ")";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class q {

        /* renamed from: a, reason: collision with root package name */
        public h.m0 f120451a;

        public String toString() {
            h.m0 m0Var = this.f120451a;
            if (m0Var != null) {
                return String.format("<%s id=\"%s\">", m0Var.g(), this.f120451a.f120638c);
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum u {
        Document,
        RenderOptions
    }

    public b(f fVar, u uVar) {
        this.f120395a = fVar;
        this.f120396b = uVar;
    }

    public static List b(d dVar) {
        String m3;
        ArrayList arrayList = new ArrayList();
        while (!dVar.c() && (m3 = dVar.m()) != null) {
            try {
                arrayList.add(f.valueOf(m3));
            } catch (IllegalArgumentException unused) {
            }
            if (!dVar.p()) {
                break;
            }
        }
        return arrayList;
    }

    public r a(String str) {
        d dVar = new d(str);
        dVar.q();
        return c(dVar);
    }

    public final r c(d dVar) {
        r rVar = new r();
        while (!dVar.c()) {
            try {
                if (!dVar.a("<!--") && !dVar.a("-->")) {
                    if (dVar.a('@')) {
                        a(rVar, dVar);
                    } else if (!b(rVar, dVar)) {
                        break;
                    }
                }
            } catch (com.tencent.luggage.wxa.a.a e16) {
                Log.e("CSSParser", "CSS parser terminated early due to error: " + e16.getMessage());
            }
        }
        return rVar;
    }

    public final void d(d dVar) {
        int i3 = 0;
        while (!dVar.c()) {
            int intValue = dVar.e().intValue();
            if (intValue == 59 && i3 == 0) {
                return;
            }
            if (intValue == 123) {
                i3++;
            } else if (intValue == 125 && i3 > 0 && i3 - 1 == 0) {
                return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class k implements g {

        /* renamed from: a, reason: collision with root package name */
        public List f120444a;

        public k(List list) {
            this.f120444a = list;
        }

        @Override // com.tencent.luggage.wxa.a.b.g
        public boolean a(q qVar, h.m0 m0Var) {
            Iterator it = this.f120444a.iterator();
            while (it.hasNext()) {
                if (b.a(qVar, (s) it.next(), m0Var)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return "not(" + this.f120444a + ")";
        }

        public int a() {
            Iterator it = this.f120444a.iterator();
            int i3 = Integer.MIN_VALUE;
            while (it.hasNext()) {
                int i16 = ((s) it.next()).f120454b;
                if (i16 > i3) {
                    i3 = i16;
                }
            }
            return i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class s {

        /* renamed from: a, reason: collision with root package name */
        public List f120453a;

        /* renamed from: b, reason: collision with root package name */
        public int f120454b;

        public s() {
            this.f120453a = null;
            this.f120454b = 0;
        }

        public void a(t tVar) {
            if (this.f120453a == null) {
                this.f120453a = new ArrayList();
            }
            this.f120453a.add(tVar);
        }

        public void b() {
            this.f120454b++;
        }

        public void c() {
            this.f120454b += 1000000;
        }

        public boolean d() {
            List list = this.f120453a;
            if (list != null && !list.isEmpty()) {
                return false;
            }
            return true;
        }

        public int e() {
            List list = this.f120453a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            Iterator it = this.f120453a.iterator();
            while (it.hasNext()) {
                sb5.append((t) it.next());
                sb5.append(TokenParser.SP);
            }
            sb5.append('[');
            sb5.append(this.f120454b);
            sb5.append(']');
            return sb5.toString();
        }

        public /* synthetic */ s(a aVar) {
            this();
        }

        public t a(int i3) {
            return (t) this.f120453a.get(i3);
        }

        public void a() {
            this.f120454b += 1000;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class t {

        /* renamed from: a, reason: collision with root package name */
        public e f120455a;

        /* renamed from: b, reason: collision with root package name */
        public String f120456b;

        /* renamed from: c, reason: collision with root package name */
        public List f120457c = null;

        /* renamed from: d, reason: collision with root package name */
        public List f120458d = null;

        public t(e eVar, String str) {
            this.f120455a = null;
            this.f120456b = null;
            this.f120455a = eVar == null ? e.DESCENDANT : eVar;
            this.f120456b = str;
        }

        public void a(String str, c cVar, String str2) {
            if (this.f120457c == null) {
                this.f120457c = new ArrayList();
            }
            this.f120457c.add(new C5977b(str, cVar, str2));
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            e eVar = this.f120455a;
            if (eVar == e.CHILD) {
                sb5.append("> ");
            } else if (eVar == e.FOLLOWS) {
                sb5.append("+ ");
            }
            String str = this.f120456b;
            if (str == null) {
                str = "*";
            }
            sb5.append(str);
            List<C5977b> list = this.f120457c;
            if (list != null) {
                for (C5977b c5977b : list) {
                    sb5.append('[');
                    sb5.append(c5977b.f120400a);
                    int i3 = a.f120398a[c5977b.f120401b.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                sb5.append("|=");
                                sb5.append(c5977b.f120402c);
                            }
                        } else {
                            sb5.append("~=");
                            sb5.append(c5977b.f120402c);
                        }
                    } else {
                        sb5.append('=');
                        sb5.append(c5977b.f120402c);
                    }
                    sb5.append(']');
                }
            }
            List<g> list2 = this.f120458d;
            if (list2 != null) {
                for (g gVar : list2) {
                    sb5.append(':');
                    sb5.append(gVar);
                }
            }
            return sb5.toString();
        }

        public void a(g gVar) {
            if (this.f120458d == null) {
                this.f120458d = new ArrayList();
            }
            this.f120458d.add(gVar);
        }
    }

    public static boolean a(String str, f fVar) {
        d dVar = new d(str);
        dVar.q();
        return a(b(dVar), fVar);
    }

    public final boolean b(r rVar, d dVar) {
        List z16 = dVar.z();
        if (z16 == null || z16.isEmpty()) {
            return false;
        }
        if (dVar.a('{')) {
            dVar.q();
            h.f0 a16 = a(dVar);
            dVar.q();
            Iterator it = z16.iterator();
            while (it.hasNext()) {
                rVar.a(new p((s) it.next(), a16, this.f120396b));
            }
            return true;
        }
        throw new com.tencent.luggage.wxa.a.a("Malformed rule block: expected '{'");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class r {

        /* renamed from: a, reason: collision with root package name */
        public List f120452a = null;

        public void a(p pVar) {
            if (this.f120452a == null) {
                this.f120452a = new ArrayList();
            }
            for (int i3 = 0; i3 < this.f120452a.size(); i3++) {
                if (((p) this.f120452a.get(i3)).f120448a.f120454b > pVar.f120448a.f120454b) {
                    this.f120452a.add(i3, pVar);
                    return;
                }
            }
            this.f120452a.add(pVar);
        }

        public boolean b() {
            List list = this.f120452a;
            if (list != null && !list.isEmpty()) {
                return false;
            }
            return true;
        }

        public int c() {
            List list = this.f120452a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.f120452a == null) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator it = this.f120452a.iterator();
            while (it.hasNext()) {
                sb5.append(((p) it.next()).toString());
                sb5.append('\n');
            }
            return sb5.toString();
        }

        public void a(r rVar) {
            if (rVar.f120452a == null) {
                return;
            }
            if (this.f120452a == null) {
                this.f120452a = new ArrayList(rVar.f120452a.size());
            }
            Iterator it = rVar.f120452a.iterator();
            while (it.hasNext()) {
                a((p) it.next());
            }
        }

        public List a() {
            return this.f120452a;
        }

        public void a(u uVar) {
            List list = this.f120452a;
            if (list == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((p) it.next()).f120450c == uVar) {
                    it.remove();
                }
            }
        }
    }

    public static void a(String str, Object... objArr) {
        Log.w("CSSParser", String.format(str, objArr));
    }

    public static boolean a(List list, f fVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (fVar2 == f.all || fVar2 == fVar) {
                return true;
            }
        }
        return false;
    }

    public final void a(r rVar, d dVar) {
        String v3 = dVar.v();
        dVar.q();
        if (v3 != null) {
            if (!this.f120397c && v3.equals(QAdVrReportParams.ParamKey.MEDIA)) {
                List b16 = b(dVar);
                if (dVar.a('{')) {
                    dVar.q();
                    if (a(b16, this.f120395a)) {
                        this.f120397c = true;
                        rVar.a(c(dVar));
                        this.f120397c = false;
                    } else {
                        c(dVar);
                    }
                    if (!dVar.c() && !dVar.a('}')) {
                        throw new com.tencent.luggage.wxa.a.a("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new com.tencent.luggage.wxa.a.a("Invalid @media rule: missing rule set");
                }
            } else if (!this.f120397c && v3.equals("import")) {
                String A = dVar.A();
                if (A == null) {
                    A = dVar.t();
                }
                if (A != null) {
                    dVar.q();
                    b(dVar);
                    if (!dVar.c() && !dVar.a(';')) {
                        throw new com.tencent.luggage.wxa.a.a("Invalid @media rule: expected '}' at end of rule set");
                    }
                    com.tencent.luggage.wxa.a.h.e();
                } else {
                    throw new com.tencent.luggage.wxa.a.a("Invalid @import rule: expected string or url()");
                }
            } else {
                a("Ignoring @%s rule", v3);
                d(dVar);
            }
            dVar.q();
            return;
        }
        throw new com.tencent.luggage.wxa.a.a("Invalid '@' rule");
    }

    public static List b(String str) {
        d dVar = new d(str);
        ArrayList arrayList = null;
        while (!dVar.c()) {
            String k3 = dVar.k();
            if (k3 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(k3);
                dVar.q();
            }
        }
        return arrayList;
    }

    public final h.f0 a(d dVar) {
        h.f0 f0Var = new h.f0();
        do {
            String v3 = dVar.v();
            dVar.q();
            if (dVar.a(':')) {
                dVar.q();
                String x16 = dVar.x();
                if (x16 != null) {
                    dVar.q();
                    if (dVar.a('!')) {
                        dVar.q();
                        if (dVar.a("important")) {
                            dVar.q();
                        } else {
                            throw new com.tencent.luggage.wxa.a.a("Malformed rule set: found unexpected '!'");
                        }
                    }
                    dVar.a(';');
                    com.tencent.luggage.wxa.a.l.a(f0Var, v3, x16);
                    dVar.q();
                    if (dVar.c()) {
                        break;
                    }
                } else {
                    throw new com.tencent.luggage.wxa.a.a("Expected property value");
                }
            } else {
                throw new com.tencent.luggage.wxa.a.a("Expected ':'");
            }
        } while (!dVar.a('}'));
        return f0Var;
    }

    public static boolean a(q qVar, s sVar, h.m0 m0Var) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = m0Var.f120649b; obj != null; obj = ((h.o0) obj).f120649b) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        if (sVar.e() == 1) {
            return a(qVar, sVar.a(0), arrayList, size, m0Var);
        }
        return a(qVar, sVar, sVar.e() - 1, arrayList, size, m0Var);
    }

    public static boolean a(q qVar, s sVar, int i3, List list, int i16, h.m0 m0Var) {
        t a16 = sVar.a(i3);
        if (!a(qVar, a16, list, i16, m0Var)) {
            return false;
        }
        e eVar = a16.f120455a;
        if (eVar == e.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i16 >= 0) {
                if (a(qVar, sVar, i3 - 1, list, i16)) {
                    return true;
                }
                i16--;
            }
            return false;
        }
        if (eVar == e.CHILD) {
            return a(qVar, sVar, i3 - 1, list, i16);
        }
        int a17 = a(list, i16, m0Var);
        if (a17 <= 0) {
            return false;
        }
        return a(qVar, sVar, i3 - 1, list, i16, (h.m0) m0Var.f120649b.getChildren().get(a17 - 1));
    }

    public static boolean a(q qVar, s sVar, int i3, List list, int i16) {
        t a16 = sVar.a(i3);
        h.m0 m0Var = (h.m0) list.get(i16);
        if (!a(qVar, a16, list, i16, m0Var)) {
            return false;
        }
        e eVar = a16.f120455a;
        if (eVar == e.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i16 > 0) {
                i16--;
                if (a(qVar, sVar, i3 - 1, list, i16)) {
                    return true;
                }
            }
            return false;
        }
        if (eVar == e.CHILD) {
            return a(qVar, sVar, i3 - 1, list, i16 - 1);
        }
        int a17 = a(list, i16, m0Var);
        if (a17 <= 0) {
            return false;
        }
        return a(qVar, sVar, i3 - 1, list, i16, (h.m0) m0Var.f120649b.getChildren().get(a17 - 1));
    }

    public static int a(List list, int i3, h.m0 m0Var) {
        int i16 = 0;
        if (i3 < 0) {
            return 0;
        }
        Object obj = list.get(i3);
        h.k0 k0Var = m0Var.f120649b;
        if (obj != k0Var) {
            return -1;
        }
        Iterator it = k0Var.getChildren().iterator();
        while (it.hasNext()) {
            if (((h.o0) it.next()) == m0Var) {
                return i16;
            }
            i16++;
        }
        return -1;
    }

    public static boolean a(q qVar, t tVar, List list, int i3, h.m0 m0Var) {
        List list2;
        String str = tVar.f120456b;
        if (str != null && !str.equals(m0Var.g().toLowerCase(Locale.US))) {
            return false;
        }
        List<C5977b> list3 = tVar.f120457c;
        if (list3 != null) {
            for (C5977b c5977b : list3) {
                String str2 = c5977b.f120400a;
                str2.hashCode();
                if (!str2.equals("id")) {
                    if (!str2.equals(Constants.Service.CLASS) || (list2 = m0Var.f120642g) == null || !list2.contains(c5977b.f120402c)) {
                        return false;
                    }
                } else if (!c5977b.f120402c.equals(m0Var.f120638c)) {
                    return false;
                }
            }
        }
        List list4 = tVar.f120458d;
        if (list4 == null) {
            return true;
        }
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).a(qVar, m0Var)) {
                return false;
            }
        }
        return true;
    }
}
