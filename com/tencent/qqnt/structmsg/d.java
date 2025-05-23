package com.tencent.qqnt.structmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d extends DefaultHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Stack<c> f362300a;

    /* renamed from: b, reason: collision with root package name */
    c f362301b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f362302c;

    /* renamed from: d, reason: collision with root package name */
    private String f362303d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f362304e;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f362300a = new Stack<>();
            this.f362302c = false;
        }
    }

    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new a(this.f362301b);
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f362304e = z16;
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f362303d = str;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i3, int i16) throws SAXException {
        c peek;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.characters(cArr, i3, i16);
        String str = new String(cArr, i3, i16);
        if (!this.f362300a.isEmpty() && (peek = this.f362300a.peek()) != null) {
            String str2 = peek.f362294a;
            if (str2 != null) {
                str = str2.concat(str);
            }
            peek.f362294a = str;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.endDocument();
        this.f362300a.clear();
        this.f362300a = null;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3);
            return;
        }
        super.endElement(str, str2, str3);
        if (!this.f362300a.isEmpty()) {
            c pop = this.f362300a.pop();
            if (this.f362300a.isEmpty()) {
                this.f362301b = pop;
            }
            if (this.f362302c) {
                if (pop != null && !"".equals(pop.f362294a)) {
                    pop.f362299f = 3;
                }
                this.f362302c = false;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        c peek;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, attributes);
            return;
        }
        super.startElement(str, str2, str3, attributes);
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            hashMap.put(attributes.getLocalName(i3), attributes.getValue(i3));
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("StructMsgParserHandler", 4, "StructMsgParserHandler startElement uri = " + str + ", localName = " + str2 + ", qName = " + str3 + ", map = " + hashMap);
        }
        c cVar = new c(str2, hashMap);
        if (!this.f362300a.isEmpty() && (peek = this.f362300a.peek()) != null) {
            cVar.f362298e = peek;
            peek.a(cVar);
        }
        this.f362300a.push(cVar);
        this.f362302c = true;
    }
}
