package com.qzone.proxy.feedcomponent.model;

import android.util.Xml;
import com.tencent.ams.adcore.mma.api.Global;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes39.dex */
public class q {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f50416a;

        /* renamed from: b, reason: collision with root package name */
        public int f50417b;

        /* renamed from: c, reason: collision with root package name */
        public String f50418c;

        /* renamed from: d, reason: collision with root package name */
        public List<String> f50419d;

        public a() {
        }

        public void a(String str) {
            if (this.f50419d == null) {
                this.f50419d = new ArrayList();
            }
            this.f50419d.add(str);
        }

        public long b() {
            return this.f50416a;
        }

        public String c() {
            return this.f50418c;
        }

        public List<String> d() {
            return this.f50419d;
        }

        public void e(int i3) {
            this.f50417b = i3;
        }

        public void f(long j3) {
            this.f50416a = j3;
        }

        public void g(String str) {
            this.f50418c = str;
        }
    }

    public List<a> a(InputStream inputStream) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        ArrayList arrayList = null;
        a aVar = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 0) {
                arrayList = new ArrayList();
            } else if (eventType != 2) {
                if (eventType == 3 && newPullParser.getName().equals("CLIPINFO") && arrayList != null) {
                    arrayList.add(aVar);
                    aVar = null;
                }
            } else if (newPullParser.getName().equals("CLIPINFO")) {
                aVar = new a();
            } else if (newPullParser.getName().equals("DURATION")) {
                newPullParser.next();
                long longValue = Long.valueOf(newPullParser.getText(), 10).longValue() / 1000;
                if (aVar != null) {
                    aVar.f(longValue);
                }
            } else if (newPullParser.getName().equals("CLIPSIZE")) {
                newPullParser.next();
                if (aVar != null) {
                    aVar.e(Integer.valueOf(newPullParser.getText(), 10).intValue());
                }
            } else if (newPullParser.getName().equals(Global.TRACKING_URL)) {
                newPullParser.next();
                if (aVar != null) {
                    aVar.g(newPullParser.getText());
                }
            } else if (newPullParser.getName().equals("URLPARAM")) {
                newPullParser.next();
                if (aVar != null) {
                    aVar.a(newPullParser.getText());
                }
            }
        }
        return arrayList;
    }
}
