package com.tencent.mobileqq.emoticonview.searchemo;

import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class SearchEmotionPanelBusinessParam extends BaseEmotionPanelBusinessParam {
    static IPatchRedirector $redirector_;
    public int defaultSelectTabIndex;
    public String searchWord;

    public SearchEmotionPanelBusinessParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
