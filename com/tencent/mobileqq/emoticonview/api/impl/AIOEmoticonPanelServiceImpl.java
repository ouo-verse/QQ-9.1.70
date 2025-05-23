package com.tencent.mobileqq.emoticonview.api.impl;

import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class AIOEmoticonPanelServiceImpl implements IAIOEmoticonPanelService {
    static IPatchRedirector $redirector_;

    public AIOEmoticonPanelServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService
    public void destroyViewPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            EmoticonPanelViewBinder.destroyViewPool();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService
    public void removeStickerMask(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view instanceof EmoticonMainPanel) {
            EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) view;
            emoticonMainPanel.removeView(emoticonMainPanel.stickerMaskLayout);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService
    public void setOpenStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            EmoticonMainPanel.sOpenStartTime = j3;
        }
    }
}
