package com.tencent.mobileqq.text.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.GrabParams;

/* loaded from: classes18.dex */
public interface ISpanProcessor {
    public static final IPatchRedirector $redirector_ = null;

    void doGrab(GrabParams grabParams, ISpanCallback iSpanCallback);

    int doPlain(Object obj, int i3, int i16, int i17, StringBuffer stringBuffer);

    boolean matchGrab(int i3);

    boolean matchPlain(Object obj);

    void setBizSrc(String str, Object[] objArr);
}
