package com.tencent.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionMenuItem {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_WARN = 2;
    public int action;
    public String content;
    public HashMap<String, Object> tag;
    public int type;
    public int viewid;
    public int visibility;

    public ActionMenuItem(String str, int i3, int i16) {
        this(0, str, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public Object getTag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return this.tag.get(str);
    }

    public void setTag(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, obj);
        } else {
            this.tag.put(str, obj);
        }
    }

    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.visibility = i3;
        }
    }

    public ActionMenuItem(int i3, String str, int i16, int i17) {
        this(i3, str, i16, i17, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public ActionMenuItem(int i3, String str, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.type = 1;
        this.tag = new HashMap<>();
        this.viewid = i3;
        this.content = str;
        this.action = i16;
        this.visibility = i17;
        this.type = i18;
    }
}
