package com.xiaomi.push;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.xiaomi.push.fa;
import com.xiaomi.push.ff;
import com.xiaomi.push.fq;
import com.xiaomi.push.service.am;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fl {

    /* renamed from: a, reason: collision with root package name */
    private static XmlPullParser f388882a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a extends fa {
        a() {
        }

        @Override // com.xiaomi.push.fa
        public String B() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class b extends fa {
        b() {
        }

        @Override // com.xiaomi.push.fa
        public String B() {
            return null;
        }
    }

    public static ez a(String str, String str2, XmlPullParser xmlPullParser) {
        Object b16 = fk.a().b("all", "xm:chat");
        if (b16 != null && (b16 instanceof com.xiaomi.push.service.ao)) {
            return ((com.xiaomi.push.service.ao) b16).c(xmlPullParser);
        }
        return null;
    }

    public static fa b(XmlPullParser xmlPullParser, ep epVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fa.a a16 = fa.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z16 = false;
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fa faVar = null;
        ff ffVar = null;
        while (!z16) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    ffVar = f(xmlPullParser);
                } else {
                    faVar = new fa();
                    faVar.h(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z16 = true;
            }
        }
        if (faVar == null) {
            if (fa.a.f388799b != a16 && fa.a.f388800c != a16) {
                faVar = new b();
            } else {
                a aVar = new a();
                aVar.n(attributeValue);
                aVar.r(attributeValue3);
                aVar.t(attributeValue2);
                aVar.z(fa.a.f388802e);
                aVar.p(attributeValue4);
                aVar.i(new ff(ff.a.f388842f));
                epVar.l(aVar);
                jz4.c.B("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        faVar.n(attributeValue);
        faVar.r(attributeValue2);
        faVar.p(attributeValue4);
        faVar.t(attributeValue3);
        faVar.z(a16);
        faVar.i(ffVar);
        faVar.A(hashMap);
        return faVar;
    }

    public static fc c(XmlPullParser xmlPullParser) {
        String str;
        boolean z16;
        boolean z17 = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", ReportConstant.COSTREPORT_PREFIX))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            am.b b16 = com.xiaomi.push.service.am.c().b(attributeValue, attributeValue4);
            if (b16 == null) {
                b16 = com.xiaomi.push.service.am.c().b(attributeValue, attributeValue3);
            }
            if (b16 != null) {
                fc fcVar = null;
                while (!z17) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (ReportConstant.COSTREPORT_PREFIX.equals(xmlPullParser.getName())) {
                            if (xmlPullParser.next() == 4) {
                                String text = xmlPullParser.getText();
                                if (!"5".equals(attributeValue) && !"6".equals(attributeValue)) {
                                    h(com.xiaomi.push.service.aa.h(com.xiaomi.push.service.aa.g(b16.f389613i, attributeValue2), text));
                                    f388882a.next();
                                    fcVar = c(f388882a);
                                } else {
                                    fb fbVar = new fb();
                                    fbVar.p(attributeValue);
                                    fbVar.D(true);
                                    fbVar.t(attributeValue3);
                                    fbVar.r(attributeValue4);
                                    fbVar.n(attributeValue2);
                                    fbVar.L(attributeValue5);
                                    ez ezVar = new ez(ReportConstant.COSTREPORT_PREFIX, null, null, null);
                                    ezVar.g(text);
                                    fbVar.h(ezVar);
                                    return fbVar;
                                }
                            } else {
                                throw new fi("error while receiving a encrypted message with wrong format");
                            }
                        } else {
                            throw new fi("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z17 = true;
                    }
                }
                if (fcVar != null) {
                    return fcVar;
                }
                throw new fi("error while receiving a encrypted message with wrong format");
            }
            throw new fi("the channel id is wrong while receiving a encrypted message");
        }
        fb fbVar2 = new fb();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        fbVar2.n(attributeValue6);
        fbVar2.r(xmlPullParser.getAttributeValue("", "to"));
        fbVar2.t(xmlPullParser.getAttributeValue("", "from"));
        fbVar2.p(xmlPullParser.getAttributeValue("", "chid"));
        fbVar2.y(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                fbVar2.C(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fbVar2.F(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fbVar2.H(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                fbVar2.J(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true")) {
            z16 = true;
        } else {
            z16 = false;
        }
        fbVar2.A(z16);
        fbVar2.L(xmlPullParser.getAttributeValue("", "type"));
        String i3 = i(xmlPullParser);
        if (i3 != null && !"".equals(i3.trim())) {
            fbVar2.R(i3);
        } else {
            fc.x();
        }
        while (!z17) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    i(xmlPullParser);
                    fbVar2.N(g(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String g16 = g(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        fbVar2.z(g16, attributeValue11);
                    } else {
                        fbVar2.P(g16);
                    }
                } else if (name.equals(MosaicConstants$JsProperty.PROP_THREAD)) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fbVar2.i(f(xmlPullParser));
                } else {
                    fbVar2.h(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z17 = true;
            }
        }
        fbVar2.Q(str2);
        return fbVar2;
    }

    public static fq d(XmlPullParser xmlPullParser) {
        fq.b bVar = fq.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = fq.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        fq fqVar = new fq(bVar);
        fqVar.r(xmlPullParser.getAttributeValue("", "to"));
        fqVar.t(xmlPullParser.getAttributeValue("", "from"));
        fqVar.p(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fqVar.n(attributeValue2);
        boolean z16 = false;
        while (!z16) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fqVar.B(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        fqVar.y(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fqVar.y(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fqVar.z(fq.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    fqVar.i(f(xmlPullParser));
                } else {
                    fqVar.h(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z16 = true;
            }
        }
        return fqVar;
    }

    public static fe e(XmlPullParser xmlPullParser) {
        fe feVar = null;
        boolean z16 = false;
        while (!z16) {
            int next = xmlPullParser.next();
            if (next == 2) {
                feVar = new fe(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z16 = true;
            }
        }
        return feVar;
    }

    public static ff f(XmlPullParser xmlPullParser) {
        String str;
        ArrayList arrayList = new ArrayList();
        String str2 = "-1";
        boolean z16 = false;
        String str3 = null;
        String str4 = null;
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            if (xmlPullParser.getAttributeName(i3).equals("code")) {
                str2 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i3).equals("type")) {
                str4 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i3).equals("reason")) {
                str3 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str5 = null;
        String str6 = null;
        while (!z16) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str6 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str5 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z16 = true;
                }
            } else if (next == 4) {
                str6 = xmlPullParser.getText();
            }
        }
        if (str4 == null) {
            str = "cancel";
        } else {
            str = str4;
        }
        return new ff(Integer.parseInt(str2), str, str3, str5, str6, arrayList);
    }

    private static String g(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static void h(byte[] bArr) {
        if (f388882a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f388882a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e16) {
                e16.printStackTrace();
            }
        }
        f388882a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    private static String i(XmlPullParser xmlPullParser) {
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i3)))) {
                return xmlPullParser.getAttributeValue(i3);
            }
        }
        return null;
    }
}
