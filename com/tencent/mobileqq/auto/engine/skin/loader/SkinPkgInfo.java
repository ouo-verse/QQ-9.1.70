package com.tencent.mobileqq.auto.engine.skin.loader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes11.dex */
public class SkinPkgInfo {
    static IPatchRedirector $redirector_;
    private List<String> mPrefixName;
    private String mSkinName;

    /* JADX INFO: Access modifiers changed from: protected */
    public SkinPkgInfo(String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) list);
        } else {
            this.mSkinName = str;
            this.mPrefixName = list;
        }
    }

    public List<String> getPrefixName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mPrefixName;
    }

    public String getSkinName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mSkinName;
    }
}
