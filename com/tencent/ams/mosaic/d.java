package com.tencent.ams.mosaic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface d {
    public static final IPatchRedirector $redirector_ = null;

    com.tencent.ams.mosaic.jsengine.a getJSEngine();

    int getRootViewHeight();

    int getRootViewWidth();

    k getTemplate();

    boolean isRequiredTemplate();
}
