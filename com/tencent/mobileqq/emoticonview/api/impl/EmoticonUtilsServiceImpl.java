package com.tencent.mobileqq.emoticonview.api.impl;

import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emoticonview.EmoticonReportDtHelper;
import com.tencent.mobileqq.emoticonview.api.IEmoticonUtilsService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonUtilsServiceImpl implements IEmoticonUtilsService {
    static IPatchRedirector $redirector_;

    public EmoticonUtilsServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonUtilsService
    public void bindStickersRecommendBar(View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) str);
        } else {
            EmoticonReportDtHelper.bindStickersRecommendBar(view, str);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonUtilsService
    public void setNeedSwitchToHotPicTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            EmoticonPanelHotPicSearchHelper.setNeedSwitchToTab(true);
        }
    }
}
