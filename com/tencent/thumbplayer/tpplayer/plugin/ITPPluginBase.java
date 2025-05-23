package com.tencent.thumbplayer.tpplayer.plugin;

/* loaded from: classes26.dex */
public interface ITPPluginBase {
    void onAttach();

    void onDetach();

    void onEvent(int i3, int i16, int i17, String str, Object obj);
}
