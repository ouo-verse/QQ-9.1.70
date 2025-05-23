package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmojiConstants;
import com.tencent.mobileqq.data.EmoticonType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class EmoticonViewBinder implements EmoticonType {
    static IPatchRedirector $redirector_ = null;
    public static final int COLUMNNUM_SYSTEM_AND_EMOJI;
    public static final int TYPE_ENTRANCE_EMOTICON_SETTING = 101;
    public static final int TYPE_ENTRANCE_SECOND_TAB = 100;
    public static final int TYPE_TKD_COMMENT_END = 1100;
    public static final int TYPE_TKD_COMMENT_START = 1000;
    public int type;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            COLUMNNUM_SYSTEM_AND_EMOJI = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;
        }
    }

    public EmoticonViewBinder(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.type = i3;
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public int getPanelPageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }
}
