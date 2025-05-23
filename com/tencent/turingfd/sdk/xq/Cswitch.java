package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.switch, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cswitch {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Stack<Node> f383437a;

    /* renamed from: b, reason: collision with root package name */
    public Document f383438b;

    /* renamed from: c, reason: collision with root package name */
    public final DocumentBuilder f383439c;

    public Cswitch() throws ParserConfigurationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383439c = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.f383437a = new Stack<>();
        }
    }
}
