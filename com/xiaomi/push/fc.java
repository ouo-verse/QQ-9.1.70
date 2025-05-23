package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class fc {

    /* renamed from: k, reason: collision with root package name */
    protected static final String f388816k = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: l, reason: collision with root package name */
    private static String f388817l = null;

    /* renamed from: m, reason: collision with root package name */
    public static final DateFormat f388818m;

    /* renamed from: n, reason: collision with root package name */
    private static String f388819n;

    /* renamed from: o, reason: collision with root package name */
    private static long f388820o;

    /* renamed from: a, reason: collision with root package name */
    private String f388821a;

    /* renamed from: b, reason: collision with root package name */
    private String f388822b;

    /* renamed from: c, reason: collision with root package name */
    private String f388823c;

    /* renamed from: d, reason: collision with root package name */
    private String f388824d;

    /* renamed from: e, reason: collision with root package name */
    private String f388825e;

    /* renamed from: f, reason: collision with root package name */
    private String f388826f;

    /* renamed from: g, reason: collision with root package name */
    private List<ez> f388827g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Object> f388828h;

    /* renamed from: i, reason: collision with root package name */
    private ff f388829i;

    /* renamed from: j, reason: collision with root package name */
    public long f388830j;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f388818m = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        f388819n = fm.a(5) + "-";
        f388820o = 0L;
    }

    public fc() {
        this.f388821a = f388817l;
        this.f388822b = null;
        this.f388823c = null;
        this.f388824d = null;
        this.f388825e = null;
        this.f388826f = null;
        this.f388827g = new CopyOnWriteArrayList();
        this.f388828h = new HashMap();
        this.f388829i = null;
    }

    public static synchronized String k() {
        String sb5;
        synchronized (fc.class) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(f388819n);
            long j3 = f388820o;
            f388820o = 1 + j3;
            sb6.append(Long.toString(j3));
            sb5 = sb6.toString();
        }
        return sb5;
    }

    public static String x() {
        return f388816k;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f388821a)) {
            bundle.putString("ext_ns", this.f388821a);
        }
        if (!TextUtils.isEmpty(this.f388824d)) {
            bundle.putString("ext_from", this.f388824d);
        }
        if (!TextUtils.isEmpty(this.f388823c)) {
            bundle.putString("ext_to", this.f388823c);
        }
        if (!TextUtils.isEmpty(this.f388822b)) {
            bundle.putString("ext_pkt_id", this.f388822b);
        }
        if (!TextUtils.isEmpty(this.f388825e)) {
            bundle.putString("ext_chid", this.f388825e);
        }
        ff ffVar = this.f388829i;
        if (ffVar != null) {
            bundle.putBundle("ext_ERROR", ffVar.a());
        }
        List<ez> list = this.f388827g;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<ez> it = this.f388827g.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Bundle a16 = it.next().a();
                if (a16 != null) {
                    bundleArr[i3] = a16;
                    i3++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public ez b(String str) {
        return c(str, null);
    }

    public ez c(String str, String str2) {
        for (ez ezVar : this.f388827g) {
            if (str2 == null || str2.equals(ezVar.j())) {
                if (str.equals(ezVar.e())) {
                    return ezVar;
                }
            }
        }
        return null;
    }

    public ff d() {
        return this.f388829i;
    }

    public synchronized Object e(String str) {
        Map<String, Object> map = this.f388828h;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fc fcVar = (fc) obj;
        ff ffVar = this.f388829i;
        if (ffVar == null ? fcVar.f388829i != null : !ffVar.equals(fcVar.f388829i)) {
            return false;
        }
        String str = this.f388824d;
        if (str == null ? fcVar.f388824d != null : !str.equals(fcVar.f388824d)) {
            return false;
        }
        if (!this.f388827g.equals(fcVar.f388827g)) {
            return false;
        }
        String str2 = this.f388822b;
        if (str2 == null ? fcVar.f388822b != null : !str2.equals(fcVar.f388822b)) {
            return false;
        }
        String str3 = this.f388825e;
        if (str3 == null ? fcVar.f388825e != null : !str3.equals(fcVar.f388825e)) {
            return false;
        }
        Map<String, Object> map = this.f388828h;
        if (map == null ? fcVar.f388828h != null : !map.equals(fcVar.f388828h)) {
            return false;
        }
        String str4 = this.f388823c;
        if (str4 == null ? fcVar.f388823c != null : !str4.equals(fcVar.f388823c)) {
            return false;
        }
        String str5 = this.f388821a;
        String str6 = fcVar.f388821a;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public abstract String f();

    public synchronized Collection<ez> g() {
        if (this.f388827g == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f388827g));
    }

    public void h(ez ezVar) {
        this.f388827g.add(ezVar);
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.f388821a;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        String str2 = this.f388822b;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str3 = this.f388823c;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        String str4 = this.f388824d;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        String str5 = this.f388825e;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int hashCode = (((((i36 + i19) * 31) + this.f388827g.hashCode()) * 31) + this.f388828h.hashCode()) * 31;
        ff ffVar = this.f388829i;
        if (ffVar != null) {
            i26 = ffVar.hashCode();
        }
        return hashCode + i26;
    }

    public void i(ff ffVar) {
        this.f388829i = ffVar;
    }

    public synchronized Collection<String> j() {
        if (this.f388828h == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f388828h.keySet()));
    }

    public String l() {
        if ("ID_NOT_AVAILABLE".equals(this.f388822b)) {
            return null;
        }
        if (this.f388822b == null) {
            this.f388822b = k();
        }
        return this.f388822b;
    }

    public String m() {
        return this.f388825e;
    }

    public void n(String str) {
        this.f388822b = str;
    }

    public String o() {
        return this.f388823c;
    }

    public void p(String str) {
        this.f388825e = str;
    }

    public String q() {
        return this.f388824d;
    }

    public void r(String str) {
        this.f388823c = str;
    }

    public String s() {
        return this.f388826f;
    }

    public void t(String str) {
        this.f388824d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(8:40|41|42|43|44|(4:45|46|48|49)|51|52) */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String u() {
        StringBuilder sb5;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e16;
        sb5 = new StringBuilder();
        Iterator<ez> it = g().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().d());
        }
        Map<String, Object> map = this.f388828h;
        if (map != null && !map.isEmpty()) {
            sb5.append(aa.g("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
            for (String str : j()) {
                Object e17 = e(str);
                sb5.append("<property>");
                sb5.append("<name>");
                sb5.append(fm.b(str));
                sb5.append("</name>");
                sb5.append("<value type=\"");
                if (e17 instanceof Integer) {
                    sb5.append("integer\">");
                    sb5.append(e17);
                    sb5.append("</value>");
                } else if (e17 instanceof Long) {
                    sb5.append("long\">");
                    sb5.append(e17);
                    sb5.append("</value>");
                } else if (e17 instanceof Float) {
                    sb5.append("float\">");
                    sb5.append(e17);
                    sb5.append("</value>");
                } else if (e17 instanceof Double) {
                    sb5.append("double\">");
                    sb5.append(e17);
                    sb5.append("</value>");
                } else if (e17 instanceof Boolean) {
                    sb5.append("boolean\">");
                    sb5.append(e17);
                    sb5.append("</value>");
                } else if (e17 instanceof String) {
                    sb5.append("string\">");
                    sb5.append(fm.b((String) e17));
                    sb5.append("</value>");
                } else {
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Exception e18) {
                        e = e18;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream = null;
                    }
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    } catch (Exception e19) {
                        e = e19;
                        objectOutputStream = null;
                        e16 = e;
                        e16.printStackTrace();
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream == null) {
                        }
                        byteArrayOutputStream.close();
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    try {
                        try {
                            objectOutputStream.writeObject(e17);
                            sb5.append("java-object\">");
                            sb5.append(fm.d(byteArrayOutputStream.toByteArray()));
                            sb5.append("</value>");
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused) {
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused3) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e26) {
                        e16 = e26;
                        e16.printStackTrace();
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (byteArrayOutputStream == null) {
                            sb5.append("</property>");
                        }
                        byteArrayOutputStream.close();
                    }
                    byteArrayOutputStream.close();
                }
                sb5.append("</property>");
            }
            sb5.append("</properties>");
        }
        return sb5.toString();
    }

    public void v(String str) {
        this.f388826f = str;
    }

    public String w() {
        return this.f388821a;
    }

    public fc(Bundle bundle) {
        this.f388821a = f388817l;
        this.f388822b = null;
        this.f388823c = null;
        this.f388824d = null;
        this.f388825e = null;
        this.f388826f = null;
        this.f388827g = new CopyOnWriteArrayList();
        this.f388828h = new HashMap();
        this.f388829i = null;
        this.f388823c = bundle.getString("ext_to");
        this.f388824d = bundle.getString("ext_from");
        this.f388825e = bundle.getString("ext_chid");
        this.f388822b = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f388827g = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                ez c16 = ez.c((Bundle) parcelable);
                if (c16 != null) {
                    this.f388827g.add(c16);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f388829i = new ff(bundle2);
        }
    }
}
