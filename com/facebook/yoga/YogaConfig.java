package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class YogaConfig {
    public static int SPACING_TYPE = 1;

    public abstract YogaLogger getLogger();

    abstract long getNativePointer();

    public abstract void setExperimentalFeatureEnabled(YogaExperimentalFeature yogaExperimentalFeature, boolean z16);

    public abstract void setLogger(YogaLogger yogaLogger);

    public abstract void setPointScaleFactor(float f16);

    public abstract void setPrintTreeFlag(boolean z16);

    public abstract void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean z16);

    public abstract void setUseLegacyStretchBehaviour(boolean z16);

    public abstract void setUseWebDefaults(boolean z16);
}
