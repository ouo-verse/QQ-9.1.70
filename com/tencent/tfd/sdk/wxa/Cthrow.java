package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.throw, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cthrow {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Stack<Node> f375839a;

    /* renamed from: b, reason: collision with root package name */
    public Document f375840b;

    /* renamed from: c, reason: collision with root package name */
    public final DocumentBuilder f375841c;

    public Cthrow() throws ParserConfigurationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f375841c = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.f375839a = new Stack<>();
        }
    }
}
