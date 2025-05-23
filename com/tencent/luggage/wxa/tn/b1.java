package com.tencent.luggage.wxa.tn;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b1 {

    /* renamed from: a, reason: collision with root package name */
    public static final x f141537a = new x(100);

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal f141538b = new ThreadLocal();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public XmlPullParser f141539a;

        /* renamed from: b, reason: collision with root package name */
        public String f141540b;

        /* renamed from: c, reason: collision with root package name */
        public StringBuilder f141541c = new StringBuilder();

        /* renamed from: d, reason: collision with root package name */
        public Map f141542d;

        /* renamed from: e, reason: collision with root package name */
        public Map f141543e;

        public a(String str, String str2, String str3) {
            this.f141540b = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) b1.f141538b.get();
            this.f141539a = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal threadLocal = b1.f141538b;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.f141539a = newPullParser;
                threadLocal.set(newPullParser);
            }
            this.f141539a.setInput(new StringReader(str));
            this.f141543e = new HashMap();
            this.f141542d = new HashMap();
        }

        public final void a() {
            String text = this.f141539a.getText();
            if (text != null) {
                this.f141542d.put(this.f141541c.toString(), text);
            }
        }

        public final void b() {
            StringBuilder sb5 = this.f141541c;
            this.f141541c = sb5.delete(sb5.lastIndexOf("."), this.f141541c.length());
        }

        public final void c() {
            StringBuilder sb5 = this.f141541c;
            sb5.append('.');
            sb5.append(this.f141539a.getName());
            String sb6 = this.f141541c.toString();
            int hashCode = sb6.hashCode();
            Integer num = (Integer) this.f141543e.get(Integer.valueOf(hashCode));
            if (num != null) {
                Integer valueOf = Integer.valueOf(num.intValue() + 1);
                this.f141541c.append(valueOf);
                this.f141543e.put(Integer.valueOf(hashCode), valueOf);
                sb6 = sb6 + valueOf;
            } else {
                this.f141543e.put(Integer.valueOf(hashCode), 0);
            }
            this.f141542d.put(sb6, "");
            for (int i3 = 0; i3 < this.f141539a.getAttributeCount(); i3++) {
                this.f141542d.put(sb6 + ".$" + this.f141539a.getAttributeName(i3), this.f141539a.getAttributeValue(i3));
            }
        }

        public Map d() {
            int eventType = this.f141539a.getEventType();
            while (eventType != 1) {
                eventType = this.f141539a.next();
                if (eventType == 2) {
                    c();
                } else if (eventType == 4) {
                    a();
                } else if (eventType == 3) {
                    b();
                    if (this.f141541c.length() == 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            return this.f141542d;
        }
    }

    public static Map a(String str, String str2, String str3) {
        int indexOf;
        if (str == null) {
            indexOf = -1;
        } else {
            indexOf = str.indexOf("<" + str2);
        }
        if (indexOf < 0) {
            return null;
        }
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        String str4 = str + "_" + str2;
        x xVar = f141537a;
        if (xVar.a(str4)) {
            return (Map) xVar.get(str4);
        }
        try {
            Map d16 = new a(str, str2, str3).d();
            xVar.put(str4, d16);
            return d16;
        } catch (Exception e16) {
            w.a("MicroMsg.SDK.XmlParser", e16, "[ %s ]", str);
            return null;
        }
    }
}
