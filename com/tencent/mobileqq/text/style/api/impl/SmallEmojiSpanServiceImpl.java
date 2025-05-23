package com.tencent.mobileqq.text.style.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
import com.tencent.mobileqq.text.style.a;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SmallEmojiSpanServiceImpl implements ISmallEmojiSpanService {
    static IPatchRedirector $redirector_;

    public SmallEmojiSpanServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService
    public ISmallEmojiSpan createSmallEmojiSpan(char[] cArr, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? createSmallEmojiSpan(cArr, i3, z16, z17, false) : (ISmallEmojiSpan) iPatchRedirector.redirect((short) 2, this, cArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    @Override // com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService
    public ISmallEmojiSpan createSmallEmojiSpan(char[] cArr, int i3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ISmallEmojiSpan) iPatchRedirector.redirect((short) 3, this, cArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        if (z18) {
            return new a(cArr, i3, z16, z17);
        }
        return new SmallEmojiSpan(cArr, i3, z16, z17);
    }
}
