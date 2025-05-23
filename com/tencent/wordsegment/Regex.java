package com.tencent.wordsegment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Regex {
    static IPatchRedirector $redirector_;
    Pattern _pattern;

    public Regex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean init(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            this._pattern = Pattern.compile(str);
        } catch (Exception unused) {
            this._pattern = null;
        }
        if (this._pattern == null) {
            return false;
        }
        return true;
    }

    public boolean match(String str) {
        Pattern pattern;
        Matcher matcher;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null || str.length() == 0 || (pattern = this._pattern) == null || (matcher = pattern.matcher(str)) == null || !matcher.find()) {
            return false;
        }
        return true;
    }
}
