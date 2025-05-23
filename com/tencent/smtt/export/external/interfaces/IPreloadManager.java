package com.tencent.smtt.export.external.interfaces;

import java.util.Map;

/* loaded from: classes22.dex */
public interface IPreloadManager {

    /* loaded from: classes22.dex */
    public interface IPreloadListener {
        void didFinish(boolean z16, String str);
    }

    void cancelPreload(String str);

    boolean isInCache(String str);

    void pause();

    void requestPreload(String str, IPreloadListener iPreloadListener);

    void requestPreload(String str, Map<String, String> map, IPreloadListener iPreloadListener);

    void resume();
}
