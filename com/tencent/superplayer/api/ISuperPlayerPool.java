package com.tencent.superplayer.api;

import java.util.Map;

/* loaded from: classes26.dex */
public interface ISuperPlayerPool {
    ISuperPlayer get(String str);

    Map<String, ISuperPlayer> getAllPlayer();

    void put(ISuperPlayer iSuperPlayer);

    boolean remove(ISuperPlayer iSuperPlayer);

    int size();
}
