package com.tencent.tbs.one;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TBSOneEventEmitter {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum UnloadedBehavior {
        IGNORE,
        LOAD,
        INSTALL
    }

    void emit(UnloadedBehavior unloadedBehavior, String str, String str2, String str3, Map<String, Object> map);

    void emit(String str, Map<String, Object> map);
}
