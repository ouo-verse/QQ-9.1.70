package com.xiaomi.push;

import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ev {

    /* renamed from: a, reason: collision with root package name */
    private static int f388787a = 5000;

    /* renamed from: b, reason: collision with root package name */
    private static int f388788b = 330000;

    /* renamed from: c, reason: collision with root package name */
    private static int f388789c = 600000;

    /* renamed from: d, reason: collision with root package name */
    private static Vector<String> f388790d = new Vector<>();

    static {
        try {
            for (ClassLoader classLoader : e()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = resources.nextElement().openStream();
                            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals(PushClientConstants.TAG_CLASS_NAME)) {
                                        d(newPullParser);
                                    } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                        f388787a = b(newPullParser, f388787a);
                                    } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                        f388788b = b(newPullParser, f388788b);
                                    } else if (newPullParser.getName().equals("mechName")) {
                                        f388790d.add(newPullParser.nextText());
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th5) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                        throw th5;
                    }
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    ev() {
    }

    public static int a() {
        return f388788b;
    }

    private static int b(XmlPullParser xmlPullParser, int i3) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return i3;
        }
    }

    public static String c() {
        return "3.1.0";
    }

    private static void d(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException unused) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    private static ClassLoader[] e() {
        ClassLoader[] classLoaderArr = {ev.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            ClassLoader classLoader = classLoaderArr[i3];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public static int f() {
        return f388789c;
    }
}
