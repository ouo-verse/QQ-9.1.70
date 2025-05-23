package com.tencent.wordsegment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ContextAnalyze {
    static IPatchRedirector $redirector_;

    public ContextAnalyze() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final native boolean clear(String str);

    public static final native String descParser(String str, ArrayList<SemanticItem> arrayList);

    public static final native boolean parse(String str, long j3, boolean z16, boolean z17, String str2, ArrayList<ContextItem> arrayList, ArrayList<ContextItem> arrayList2);
}
