package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* compiled from: P */
/* loaded from: classes27.dex */
public class aw2ka {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Stack<Node> f382138a;

    /* renamed from: b, reason: collision with root package name */
    public Document f382139b;

    /* renamed from: c, reason: collision with root package name */
    public final DocumentBuilder f382140c;

    public aw2ka() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382140c = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.f382138a = new Stack<>();
        }
    }
}
