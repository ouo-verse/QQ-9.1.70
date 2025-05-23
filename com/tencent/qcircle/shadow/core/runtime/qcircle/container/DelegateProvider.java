package com.tencent.qcircle.shadow.core.runtime.qcircle.container;

import com.tencent.qcircle.shadow.core.runtime.UriParseDelegate;

/* loaded from: classes22.dex */
public interface DelegateProvider {
    public static final String LOADER_VERSION_KEY = "LOADER_VERSION";
    public static final String PROCESS_ID_KEY = "PROCESS_ID_KEY";

    HostActivityDelegate getHostActivityDelegate(Class<? extends HostActivityDelegator> cls);

    UriParseDelegate getUriParseDelegate();
}
