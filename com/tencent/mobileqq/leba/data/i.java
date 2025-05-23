package com.tencent.mobileqq.leba.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/leba/data/i;", "", "Lorg/xmlpull/v1/XmlPullParser;", "", "a", "", "b", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f240423a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17707);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f240423a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String text;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) xmlPullParser);
        }
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        int next = xmlPullParser.next();
        if (next == 4) {
            text = xmlPullParser.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
        } else {
            text = "";
        }
        if (next != 3) {
            xmlPullParser.nextTag();
        }
        return text;
    }

    public final void b(@NotNull XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xmlPullParser);
            return;
        }
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        if (xmlPullParser.getEventType() == 2) {
            int i3 = 1;
            while (i3 != 0) {
                int next = xmlPullParser.next();
                if (next != 2) {
                    if (next == 3) {
                        i3--;
                    }
                } else {
                    i3++;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }
}
