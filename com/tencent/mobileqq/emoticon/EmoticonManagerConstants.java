package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonManagerConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String KEYWORD_EMOTICON_DEFAULT_EPID = "NONE";
    public static final long KEYWORD_REQ_MAX_INTERVAL = 86400000;
    public static final int MAX_KEYWORD_EXPOSE_NUM = 3;
    public static final int MAX_SHOW_KEYWORD_NUM = 9;
    public static final int MIN_SHOW_KEYWORD_NUM = 5;
    public static final String RECOMMEND_EXPOSE_COUNT_SP_FILE_ = "recommendExposeCountSp_";
    public static int RECOMMEND_EXPOSE_MAX = 0;
    public static final String RECOMMEND_FIX_EXPOSE_COUNT_SP_FILE_ = "recommendFixExposeCountSp_";
    public static int RECOMMEND_SHOW_NUM_MAX;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            RECOMMEND_EXPOSE_MAX = 3;
            RECOMMEND_SHOW_NUM_MAX = 6;
        }
    }

    public EmoticonManagerConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
