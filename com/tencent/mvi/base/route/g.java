package com.tencent.mvi.base.route;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface g {
    public static final IPatchRedirector $redirector_ = null;

    @Nullable
    Set<String> getSubscribeEventNames();

    @Nullable
    Set<String> getSubscribeEventRNames();
}
