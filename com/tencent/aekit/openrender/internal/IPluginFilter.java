package com.tencent.aekit.openrender.internal;

/* loaded from: classes3.dex */
public interface IPluginFilter extends AEFilterI {
    public static final String AI_ATTRIBUTE_DATA = "AI_ATTRIBUTE_DATA";

    void apply();

    void clear();

    void reset();

    void updateParams(String str, Object obj);

    void updateVideoSize(int i3, int i16, double d16);
}
