package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fk {

    /* renamed from: c, reason: collision with root package name */
    private static fk f388879c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f388880a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Object> f388881b = new ConcurrentHashMap();

    fk() {
        d();
    }

    public static synchronized fk a() {
        fk fkVar;
        synchronized (fk.class) {
            if (f388879c == null) {
                f388879c = new fk();
            }
            fkVar = f388879c;
        }
        return fkVar;
    }

    private String c(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<");
        sb5.append(str);
        sb5.append("/>");
        if (str != null) {
            sb5.append("<");
            sb5.append(str2);
            sb5.append("/>");
        }
        return sb5.toString();
    }

    private ClassLoader[] f() {
        ClassLoader[] classLoaderArr = {fk.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            ClassLoader classLoader = classLoaderArr[i3];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public Object b(String str, String str2) {
        return this.f388880a.get(c(str, str2));
    }

    protected void d() {
        InputStream inputStream;
        XmlPullParser newPullParser;
        int eventType;
        try {
            for (ClassLoader classLoader : f()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    try {
                        inputStream = resources.nextElement().openStream();
                        try {
                            newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            eventType = newPullParser.getEventType();
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                    }
                    do {
                        if (eventType == 2) {
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText3 = newPullParser.nextText();
                                String c16 = c(nextText, nextText2);
                                if (!this.f388881b.containsKey(c16)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (fg.class.isAssignableFrom(cls)) {
                                            this.f388881b.put(c16, cls.newInstance());
                                        } else if (fa.class.isAssignableFrom(cls)) {
                                            this.f388881b.put(c16, cls);
                                        }
                                    } catch (ClassNotFoundException e16) {
                                        e16.printStackTrace();
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText4 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText5 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText6 = newPullParser.nextText();
                                String c17 = c(nextText4, nextText5);
                                if (!this.f388880a.containsKey(c17)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (fj.class.isAssignableFrom(cls2)) {
                                            this.f388880a.put(c17, cls2.newInstance());
                                        } else if (fd.class.isAssignableFrom(cls2)) {
                                            this.f388880a.put(c17, cls2);
                                        }
                                    } catch (ClassNotFoundException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                            }
                            th = th5;
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                        eventType = newPullParser.next();
                    } while (eventType != 1);
                    inputStream.close();
                }
            }
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    public void e(String str, String str2, Object obj) {
        if (!(obj instanceof fj) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f388880a.put(c(str, str2), obj);
    }
}
