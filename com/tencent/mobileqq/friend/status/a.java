package com.tencent.mobileqq.friend.status;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static a f211727b;

    /* renamed from: a, reason: collision with root package name */
    HashMap<Integer, Integer> f211728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.friend.status.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7637a extends DefaultHandler {
        static IPatchRedirector $redirector_;

        C7637a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, str2, str3);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i3, int i16) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) locator);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void skippedEntity(String str) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
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
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, str3, attributes);
                return;
            }
            if (str3.equals(DownloadInfo.spKey_Config)) {
                a.this.f211728a.clear();
            } else if (str3.equals("value")) {
                try {
                    a.this.f211728a.put(Integer.valueOf(Integer.parseInt(attributes.getValue("termType"))), Integer.valueOf(Integer.parseInt(attributes.getValue("icon"))));
                } catch (Exception unused) {
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
            }
        }
    }

    a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f211728a = new HashMap<>();
            e(context);
        }
    }

    public static a c() {
        synchronized ("online_status_icon_config.xml") {
            if (f211727b == null) {
                f211727b = new a(BaseApplication.getContext());
            }
        }
        return f211727b;
    }

    private void e(Context context) {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(context.getAssets().open("online_status_icon_config.xml"), new C7637a());
        } catch (Exception unused) {
        }
    }

    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        return b(i3, 1);
    }

    public int b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        Integer num = this.f211728a.get(Integer.valueOf(i3));
        if (num == null) {
            return i16;
        }
        return num.intValue();
    }

    public boolean d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        int a16 = a(i3);
        if (a16 != 3 && a16 != 2) {
            return false;
        }
        return true;
    }
}
