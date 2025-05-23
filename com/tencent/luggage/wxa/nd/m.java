package com.tencent.luggage.wxa.nd;

import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public XmlPullParser f135709a = Xml.newPullParser();

    public static m a() {
        return new m();
    }

    public com.tencent.luggage.wxa.pd.b b(String str) {
        com.tencent.luggage.wxa.pd.b bVar = null;
        if (str == null) {
            return null;
        }
        if (str.startsWith("NOTIFY") || str.startsWith("HTTP")) {
            bVar = new com.tencent.luggage.wxa.pd.b();
            String[] split = str.split("\r\n");
            if (split.length > 0) {
                String[] split2 = split[0].split(" ");
                if (split2[0].startsWith("HTTP")) {
                    bVar.a("VERSION", split2[0]);
                    bVar.a("RESPONSE_CODE", split2[1]);
                    bVar.a("RESPONSE_DESCRIPTION", split2[2]);
                } else {
                    bVar.a("METHOD", split2[0]);
                    bVar.a(AEEditorConstants.PATH, split2[1]);
                    bVar.a("VERSION", split2[2]);
                }
            }
            for (int i3 = 1; i3 < split.length; i3++) {
                String str2 = split[i3];
                int indexOf = str2.indexOf(":");
                bVar.a(str2.substring(0, indexOf).toUpperCase(), str2.substring(indexOf + 1, str2.length()).trim());
            }
        }
        return bVar;
    }

    public HashMap a(InputStream inputStream) {
        HashMap hashMap = new HashMap();
        try {
            this.f135709a.setInput(inputStream, "utf-8");
            this.f135709a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            int eventType = this.f135709a.getEventType();
            while (eventType != 1) {
                String name = this.f135709a.getName();
                if (name == null) {
                    eventType = this.f135709a.next();
                } else {
                    if (eventType == 2) {
                        com.tencent.luggage.wxa.pd.a aVar = new com.tencent.luggage.wxa.pd.a();
                        int attributeCount = this.f135709a.getAttributeCount();
                        for (int i3 = 0; i3 < attributeCount; i3++) {
                            String attributeName = this.f135709a.getAttributeName(i3);
                            String attributeValue = this.f135709a.getAttributeValue(i3);
                            aVar.a(attributeName, attributeValue);
                            Log.d("UpnpParser", "attrName=" + attributeName + ", attrVal=" + attributeValue);
                        }
                        int next = this.f135709a.next();
                        if (next == 2) {
                            hashMap.put(name, aVar);
                            eventType = next;
                        } else if (next == 4) {
                            String trim = this.f135709a.getText().trim();
                            aVar.b(trim);
                            hashMap.put(name, aVar);
                            Log.d("UpnpParser", "name=" + name + ", value=" + trim);
                        } else if (next == 3) {
                            hashMap.put(name, aVar);
                        }
                    }
                    eventType = this.f135709a.next();
                }
            }
        } catch (IOException | XmlPullParserException e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public com.tencent.luggage.wxa.md.b b(InputStream inputStream) {
        com.tencent.luggage.wxa.md.b bVar;
        synchronized (m.class) {
            com.tencent.luggage.wxa.md.b bVar2 = null;
            try {
                this.f135709a.setInput(inputStream, "utf-8");
                int eventType = this.f135709a.getEventType();
                bVar = new com.tencent.luggage.wxa.md.b();
                com.tencent.luggage.wxa.md.f fVar = null;
                while (eventType != 1) {
                    if (eventType == 2) {
                        String name = this.f135709a.getName();
                        if ("major".equalsIgnoreCase(name)) {
                            String nextText = this.f135709a.nextText();
                            if (!TextUtils.isEmpty(nextText)) {
                                bVar.f134424d = Integer.parseInt(nextText);
                            }
                        } else if ("minor".equalsIgnoreCase(name)) {
                            String nextText2 = this.f135709a.nextText();
                            if (!TextUtils.isEmpty(nextText2)) {
                                bVar.f134425e = Integer.parseInt(nextText2);
                            }
                        } else if ("deviceType".equalsIgnoreCase(name)) {
                            bVar.f134426f = this.f135709a.nextText();
                        } else if ("friendlyName".equalsIgnoreCase(name)) {
                            bVar.f134427g = this.f135709a.nextText();
                        } else if ("UDN".equalsIgnoreCase(name)) {
                            bVar.f134430j = this.f135709a.nextText();
                        } else if ("manufacturer".equalsIgnoreCase(name)) {
                            bVar.f134428h = this.f135709a.nextText();
                        } else if ("service".equalsIgnoreCase(name)) {
                            fVar = new com.tencent.luggage.wxa.md.f();
                        } else if ("serviceType".equalsIgnoreCase(name)) {
                            if (fVar != null) {
                                fVar.f134459a = this.f135709a.nextText();
                            }
                        } else if ("serviceId".equalsIgnoreCase(name)) {
                            if (fVar != null) {
                                fVar.f134460b = this.f135709a.nextText();
                            }
                        } else if ("controlURL".equalsIgnoreCase(name)) {
                            if (fVar != null) {
                                fVar.f134462d = this.f135709a.nextText();
                            }
                        } else if ("eventSubURL".equalsIgnoreCase(name)) {
                            if (fVar != null) {
                                fVar.f134463e = this.f135709a.nextText();
                            }
                        } else if ("SCPDURL".equalsIgnoreCase(name) && fVar != null) {
                            fVar.f134461c = this.f135709a.nextText();
                        }
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        try {
                            if ("service".equalsIgnoreCase(this.f135709a.getName()) && fVar != null) {
                                bVar.f134432l.add(fVar);
                                fVar = null;
                            }
                        } catch (IOException | XmlPullParserException e16) {
                            e = e16;
                            bVar2 = bVar;
                            e.printStackTrace();
                            bVar = bVar2;
                            return bVar;
                        }
                    }
                    eventType = this.f135709a.next();
                }
            } catch (IOException e17) {
                e = e17;
            } catch (XmlPullParserException e18) {
                e = e18;
            }
        }
        return bVar;
    }

    public HashMap a(String str) {
        return a(new ByteArrayInputStream(str.getBytes()));
    }
}
