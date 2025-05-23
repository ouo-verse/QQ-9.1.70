package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class PhotoCommentEmotionPanelBusinessParam extends BaseEmotionPanelBusinessParam {
    static IPatchRedirector $redirector_;
    public boolean showTitleLightColor;

    public PhotoCommentEmotionPanelBusinessParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
