package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ISmallEmoticonInfoService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SmallEmoticonInfoServiceImpl implements ISmallEmoticonInfoService {
    static IPatchRedirector $redirector_;

    public SmallEmoticonInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.ISmallEmoticonInfoService
    public ISmallEmoticonInfo createSmallEmoticonInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ISmallEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return new SmallEmoticonInfo(str);
    }
}
