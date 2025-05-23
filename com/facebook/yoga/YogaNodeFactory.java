package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class YogaNodeFactory {
    public static YogaNode create() {
        return new YogaNodeJNIFinalizer();
    }

    public static YogaNode create(YogaConfig yogaConfig) {
        return new YogaNodeJNIFinalizer(yogaConfig);
    }
}
