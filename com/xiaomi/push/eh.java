package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes28.dex */
public class eh {

    /* renamed from: a, reason: collision with root package name */
    private XmlPullParser f388690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f388690a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc a(byte[] bArr, ep epVar) {
        this.f388690a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f388690a.next();
        int eventType = this.f388690a.getEventType();
        String name = this.f388690a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return fl.c(this.f388690a);
            }
            if (name.equals("iq")) {
                return fl.b(this.f388690a, epVar);
            }
            if (name.equals("presence")) {
                return fl.d(this.f388690a);
            }
            if (!this.f388690a.getName().equals("stream")) {
                if (!this.f388690a.getName().equals("error")) {
                    if (this.f388690a.getName().equals("warning")) {
                        this.f388690a.next();
                        this.f388690a.getName().equals("multi-login");
                        return null;
                    }
                    this.f388690a.getName().equals("bind");
                    return null;
                }
                throw new fi(fl.e(this.f388690a));
            }
            return null;
        }
        return null;
    }
}
