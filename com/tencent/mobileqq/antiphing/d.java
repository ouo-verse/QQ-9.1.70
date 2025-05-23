package com.tencent.mobileqq.antiphing;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
class d extends DefaultHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f194371a;

    /* renamed from: b, reason: collision with root package name */
    private int f194372b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f194372b = 0;
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f194372b;
    }

    public ArrayList<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f194371a;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i3, int i16) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("SAXForHandler", 4, "characters: " + cArr.toString());
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.d("SAXForHandler", 4, "endDocument");
            super.endDocument();
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3);
            return;
        }
        QLog.d("SAXForHandler", 4, "endElement uri:" + str + " localName:" + str2 + " qName:" + str3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d("SAXForHandler", 4, "startDocument");
        this.f194371a = null;
        this.f194371a = new ArrayList<>();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, attributes);
            return;
        }
        QLog.d("SAXForHandler", 4, "startElement: uri:" + str + " localName:" + str2 + " qName:" + str3);
        if (DownloadInfo.spKey_Config.equals(str2)) {
            while (i3 < attributes.getLength()) {
                this.f194372b = Integer.valueOf(attributes.getValue(i3)).intValue();
                QLog.d("SAXForHandler", 4, "startElement: localName:" + str2 + " value: " + this.f194372b);
                i3++;
            }
            return;
        }
        if ("Elem".equals(str2)) {
            while (i3 < attributes.getLength()) {
                String value = attributes.getValue(i3);
                QLog.d("SAXForHandler", 4, "startElement: localName:" + str2 + "name: " + attributes.getLocalName(i3) + " url: " + value);
                this.f194371a.add(value);
                i3++;
            }
        }
    }
}
