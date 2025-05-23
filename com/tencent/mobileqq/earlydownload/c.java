package com.tencent.mobileqq.earlydownload;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends DefaultHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f203912a;

    /* renamed from: b, reason: collision with root package name */
    private XmlData f203913b;

    /* renamed from: c, reason: collision with root package name */
    private Class<? extends XmlData> f203914c;

    public c(Class<? extends XmlData> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls);
        } else {
            this.f203914c = cls;
        }
    }

    public XmlData a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (XmlData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f203913b;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i3, int i16) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f203912a.append(cArr, i3, i16);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f203912a = null;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3);
            return;
        }
        if (this.f203913b == null) {
            if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "endElement() return. data is null.");
                return;
            }
            return;
        }
        if (this.f203914c.getSimpleName().equals(str2)) {
            return;
        }
        Field a16 = a.a(this.f203914c, str2);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "endElement() return.can't find 'Field:" + str2);
                return;
            }
            return;
        }
        if (!a16.isAccessible()) {
            a16.setAccessible(true);
        }
        String sb5 = this.f203912a.toString();
        try {
            Class<?> type = a16.getType();
            if (type == String.class) {
                a16.set(this.f203913b, sb5);
                return;
            }
            if (type == Long.TYPE) {
                a16.setLong(this.f203913b, Long.parseLong(sb5));
                return;
            }
            if (type == Double.TYPE) {
                a16.setDouble(this.f203913b, Double.parseDouble(sb5));
                return;
            }
            if (type == Integer.TYPE) {
                a16.setInt(this.f203913b, Integer.parseInt(sb5));
                return;
            }
            if (type == Float.TYPE) {
                a16.setFloat(this.f203913b, Float.parseFloat(sb5));
                return;
            }
            if (type == Short.TYPE) {
                a16.setShort(this.f203913b, Short.parseShort(sb5));
                return;
            }
            if (type == Byte.TYPE) {
                a16.setByte(this.f203913b, Byte.parseByte(sb5));
                return;
            }
            if (type == Boolean.TYPE) {
                a16.setBoolean(this.f203913b, Boolean.parseBoolean(sb5));
            } else if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "endElement() return. Type:" + type.toString() + " is NOT SUPPORT!");
            }
        } catch (IllegalAccessException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "endElement() throws exception:" + e16.getMessage());
            }
        } catch (NumberFormatException e17) {
            if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "endElement() throws exception:" + e17.getMessage());
            }
        } catch (IllegalArgumentException e18) {
            if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "endElement() throws exception:" + e18.getMessage());
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f203912a = new StringBuilder();
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, attributes);
            return;
        }
        this.f203912a.setLength(0);
        if (this.f203914c.getSimpleName().equals(str2)) {
            try {
                this.f203913b = this.f203914c.newInstance();
            } catch (IllegalAccessException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EarlyDown", 2, "startElement() throw exceptin:" + e16.getMessage());
                }
            } catch (InstantiationException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("EarlyDown", 2, "startElement() throw exceptin:" + e17.getMessage());
                }
            }
        }
    }
}
