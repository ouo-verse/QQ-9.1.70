package com.tencent.mobileqq.msf.core.x;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
class s extends DefaultHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f250436a;

    /* renamed from: b, reason: collision with root package name */
    Map<String, String> f250437b;

    /* renamed from: c, reason: collision with root package name */
    String f250438c;

    public s(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) map);
            return;
        }
        this.f250436a = null;
        this.f250438c = str;
        this.f250437b = map;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i3, int i16) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f250436a != null) {
            String str = new String(cArr, i3, i16);
            this.f250437b.put(this.f250438c + this.f250436a, str);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3);
        } else {
            this.f250436a = null;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, attributes);
        } else {
            this.f250436a = str2;
        }
    }
}
