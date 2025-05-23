package com.tencent.mobileqq.activity.contact.phonecontact;

import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f181294a;

    /* renamed from: b, reason: collision with root package name */
    public String f181295b;

    /* renamed from: c, reason: collision with root package name */
    public int f181296c;

    /* renamed from: d, reason: collision with root package name */
    public int f181297d;

    /* renamed from: e, reason: collision with root package name */
    public int f181298e;

    /* renamed from: f, reason: collision with root package name */
    public int f181299f;

    /* renamed from: g, reason: collision with root package name */
    public int f181300g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f181301h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f181302i;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f181302i = true;
        }
    }

    public static a a(String str) throws XmlPullParserException, IOException {
        if (!TextUtils.isEmpty(str)) {
            a aVar = new a();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int i3 = 0; i3 != 1; i3 = newPullParser.next()) {
                if (i3 == 2 && newPullParser.getName().equalsIgnoreCase("banner")) {
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i16 = 0; i16 < attributeCount; i16++) {
                        String attributeName = newPullParser.getAttributeName(i16);
                        if ("text".equals(attributeName)) {
                            aVar.f181295b = newPullParser.getAttributeValue(i16);
                        } else if ("url".equals(attributeName)) {
                            aVar.f181294a = newPullParser.getAttributeValue(i16);
                        } else if ("dayNum".equals(attributeName)) {
                            aVar.f181296c = Integer.valueOf(newPullParser.getAttributeValue(i16)).intValue();
                        } else if ("dayIntervalNum".equals(attributeName)) {
                            aVar.f181297d = Integer.valueOf(newPullParser.getAttributeValue(i16)).intValue();
                        } else if ("totalNum".equals(attributeName)) {
                            aVar.f181298e = Integer.valueOf(newPullParser.getAttributeValue(i16)).intValue();
                        } else if ("loginNum".equals(attributeName)) {
                            aVar.f181300g = Integer.valueOf(newPullParser.getAttributeValue(i16)).intValue();
                        } else if ("banner".equals(attributeName)) {
                            aVar.f181301h = "1".equals(newPullParser.getAttributeValue(i16));
                        } else if ("setEntry".equals(attributeName)) {
                            aVar.f181302i = "1".equals(newPullParser.getAttributeValue(i16));
                        }
                    }
                }
            }
            return aVar;
        }
        return null;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MobileUnityBannerData [url=" + this.f181294a + ", text=" + this.f181295b + ", dayNum=" + this.f181296c + ", dayIntervalNum=" + this.f181297d + ", totalNum=" + this.f181298e + ", loginNum = " + this.f181300g + ", version=" + this.f181299f + "]";
    }
}
