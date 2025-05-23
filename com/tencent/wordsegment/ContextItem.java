package com.tencent.wordsegment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ContextItem {
    static IPatchRedirector $redirector_;
    public int contextId;
    public String contextName;
    public boolean ignoreOldMeta;
    public int matchPosition;
    public int matchType;
    public ArrayList<SemanticItem> semantic;
    public int toUser;

    public ContextItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.semantic = new ArrayList<>();
        }
    }
}
