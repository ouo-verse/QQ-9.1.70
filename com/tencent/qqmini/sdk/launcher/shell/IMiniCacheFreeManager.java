package com.tencent.qqmini.sdk.launcher.shell;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniCacheFreeManager {
    void freeCache();

    void freeCache(String str, MiniAppInfo miniAppInfo, boolean z16);
}
