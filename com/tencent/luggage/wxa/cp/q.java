package com.tencent.luggage.wxa.cp;

import android.os.Bundle;
import android.util.Printer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q {

    /* renamed from: g, reason: collision with root package name */
    public static final Comparator f123819g = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Map f123820a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f123821b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f123822c;

    /* renamed from: d, reason: collision with root package name */
    public final SortedMap f123823d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f123824e;

    /* renamed from: f, reason: collision with root package name */
    public u f123825f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            return gVar.f123752a.compareTo(gVar2.f123752a);
        }
    }

    public q() {
        this.f123820a = new LinkedHashMap();
        this.f123821b = new LinkedHashMap();
        this.f123822c = new LinkedHashMap();
        this.f123823d = new TreeMap(f123819g);
        this.f123824e = new LinkedHashMap();
        this.f123825f = null;
    }

    public static void a(Map map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            if (entry.getValue() == null) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.f123820a.equals(qVar.f123820a) || !this.f123821b.equals(qVar.f123821b) || !this.f123822c.equals(qVar.f123822c) || !this.f123823d.equals(qVar.f123823d) || !this.f123824e.equals(qVar.f123824e) || !c0.a(this.f123825f, qVar.f123825f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return c0.a(this.f123820a, this.f123821b, this.f123822c, this.f123823d, this.f123824e, this.f123825f);
    }

    public q a(q qVar) {
        a(this.f123820a, qVar.f123820a);
        a(this.f123821b, qVar.f123821b);
        a(this.f123822c, qVar.f123822c);
        a(this.f123823d, qVar.f123823d);
        a(this.f123824e, qVar.f123824e);
        u uVar = qVar.f123825f;
        if (uVar != null) {
            this.f123825f = uVar;
        }
        return this;
    }

    public q(q qVar) {
        this.f123820a = new LinkedHashMap(qVar.f123820a);
        this.f123821b = new LinkedHashMap(qVar.f123821b);
        this.f123822c = new LinkedHashMap(qVar.f123822c);
        this.f123823d = new TreeMap(qVar.f123823d);
        this.f123824e = new LinkedHashMap(qVar.f123824e);
        this.f123825f = qVar.f123825f;
    }

    public static void a(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            entry.setValue(new u((u) entry.getValue()));
        }
    }

    public q a() {
        q qVar = new q(this);
        a(qVar.f123820a);
        a(qVar.f123821b);
        a(qVar.f123822c);
        return qVar;
    }

    public static q a(Bundle bundle) {
        q qVar = new q();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("sl");
        Bundle bundle2 = bundle.getBundle("sm");
        if (parcelableArrayList != null && bundle2 != null) {
            for (String str : bundle2.keySet()) {
                int i3 = bundle2.getInt(str);
                if (i3 >= 0 && i3 < parcelableArrayList.size()) {
                    qVar.f123820a.put(str, new u((s) parcelableArrayList.get(i3)));
                }
            }
        }
        Bundle bundle3 = bundle.getBundle("fs");
        if (bundle3 != null) {
            bundle3.setClassLoader(bundle.getClassLoader());
            for (String str2 : bundle3.keySet()) {
                qVar.f123821b.put(str2, new u((k) bundle3.getParcelable(str2)));
            }
        }
        Bundle bundle4 = bundle.getBundle("mfs");
        if (bundle4 != null) {
            bundle4.setClassLoader(bundle.getClassLoader());
            for (String str3 : bundle4.keySet()) {
                qVar.f123822c.put(str3, new u((k) bundle4.getParcelable(str3)));
            }
        }
        Bundle bundle5 = bundle.getBundle("mp");
        if (bundle5 != null) {
            bundle5.setClassLoader(bundle.getClassLoader());
            for (String str4 : bundle5.keySet()) {
                qVar.f123823d.put(new g(str4), bundle5.getString(str4));
            }
        }
        Bundle bundle6 = bundle.getBundle(MosaicConstants$JsProperty.PROP_ENV);
        Map map = qVar.f123824e;
        if (bundle6 != null) {
            for (String str5 : bundle6.keySet()) {
                String[] stringArray = bundle6.getStringArray(str5);
                if (stringArray != null && stringArray.length != 0) {
                    if (stringArray.length == 1) {
                        map.put(str5, stringArray[0]);
                    } else {
                        map.put(str5, stringArray);
                    }
                }
            }
        }
        k kVar = (k) bundle.getParcelable("root");
        qVar.f123825f = kVar == null ? null : new u(kVar);
        return qVar;
    }

    public static void a(Printer printer, Map map) {
        StringBuilder sb5 = new StringBuilder(256);
        for (Map.Entry entry : map.entrySet()) {
            sb5.setLength(0);
            sb5.append("  ");
            sb5.append(entry.getKey());
            sb5.append(" => ");
            Object value = entry.getValue();
            if (value == null) {
                sb5.append("(deleted)\n");
            } else if (value.getClass().isArray()) {
                sb5.append(Arrays.toString((Object[]) value));
            } else {
                sb5.append(entry.getValue());
            }
            printer.println(sb5.toString());
        }
    }

    public void a(Printer printer) {
        if (!this.f123820a.isEmpty()) {
            printer.println("[Scheme]");
            a(printer, this.f123820a);
        }
        if (!this.f123821b.isEmpty()) {
            printer.println("[FileSystems]");
            a(printer, this.f123821b);
        }
        if (!this.f123822c.isEmpty()) {
            printer.println("[Maintenance-only]");
            a(printer, this.f123822c);
        }
        if (!this.f123823d.isEmpty()) {
            printer.println("[Mount points]");
            a(printer, this.f123823d);
        }
        if (!this.f123824e.isEmpty()) {
            printer.println("[Environment]");
            a(printer, this.f123824e);
        }
        if (this.f123825f != null) {
            printer.println("[Root] " + this.f123825f);
        }
    }
}
