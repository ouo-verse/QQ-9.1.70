package com.tencent.shadow.core.runtime.container;

/* loaded from: classes25.dex */
public interface DelegateProvider {
    public static final String LOADER_VERSION_KEY = "LOADER_VERSION";
    public static final String PROCESS_ID_KEY = "PROCESS_ID_KEY";

    HostActivityDelegate getHostActivityDelegate(Class<? extends HostActivityDelegator> cls);
}
