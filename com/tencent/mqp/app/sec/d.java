package com.tencent.mqp.app.sec;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d implements a {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(Document document, Bundle bundle) {
        NodeList elementsByTagName = document.getElementsByTagName("ModifyPwdUrls");
        Bundle bundle2 = new Bundle();
        if (elementsByTagName != null && elementsByTagName.getLength() >= 1) {
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item = childNodes.item(i3);
                if (item instanceof Element) {
                    Element element = (Element) item;
                    String attribute = element.getAttribute("Name");
                    String attribute2 = element.getAttribute("Url");
                    if (attribute != null && attribute2 != null && !attribute.equals("") && !attribute2.equals("")) {
                        bundle2.putString(attribute, attribute2);
                    }
                }
            }
            bundle.putBundle("ModifyPwdUrls", bundle2);
        }
    }

    @Override // com.tencent.mqp.app.sec.a
    public b a(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(str));
            Element documentElement = parse.getDocumentElement();
            Bundle bundle = new Bundle();
            try {
                i3 = Integer.parseInt(documentElement.getAttribute("Version"));
            } catch (Throwable th5) {
                th5.printStackTrace();
                i3 = -1;
            }
            bundle.putInt("version", i3);
            b(parse, bundle);
            return new c(bundle);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
