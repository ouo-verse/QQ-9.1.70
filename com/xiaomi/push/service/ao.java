package com.xiaomi.push.service;

import com.xiaomi.push.ez;
import com.xiaomi.push.fj;
import com.xiaomi.push.fk;
import com.xiaomi.push.fm;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ao implements fj {
    public static ez a(XmlPullParser xmlPullParser) {
        String[] strArr;
        String[] strArr2;
        String str;
        ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
                strArr3[i3] = xmlPullParser.getAttributeName(i3);
                strArr4[i3] = fm.e(xmlPullParser.getAttributeValue(i3));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next != 3) {
                if (next == 4) {
                    str = xmlPullParser.getText().trim();
                } else if (next == 2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    ez a16 = a(xmlPullParser);
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                }
            } else {
                return new ez(name, namespace, strArr, strArr2, str, arrayList);
            }
        }
    }

    public void b() {
        fk.a().e("all", "xm:chat", this);
    }

    public ez c(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }
}
