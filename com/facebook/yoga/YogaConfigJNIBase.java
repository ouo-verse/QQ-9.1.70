package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class YogaConfigJNIBase extends YogaConfig {
    private YogaLogger mLogger;
    long mNativePointer;

    YogaConfigJNIBase(long j3) {
        if (j3 != 0) {
            this.mNativePointer = j3;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    @Override // com.facebook.yoga.YogaConfig
    public YogaLogger getLogger() {
        return this.mLogger;
    }

    @Override // com.facebook.yoga.YogaConfig
    long getNativePointer() {
        return this.mNativePointer;
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setExperimentalFeatureEnabled(YogaExperimentalFeature yogaExperimentalFeature, boolean z16) {
        YogaNative.jni_YGConfigSetExperimentalFeatureEnabledJNI(this.mNativePointer, yogaExperimentalFeature.intValue(), z16);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setLogger(YogaLogger yogaLogger) {
        this.mLogger = yogaLogger;
        YogaNative.jni_YGConfigSetLoggerJNI(this.mNativePointer, yogaLogger);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setPointScaleFactor(float f16) {
        YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setPrintTreeFlag(boolean z16) {
        YogaNative.jni_YGConfigSetPrintTreeFlagJNI(this.mNativePointer, z16);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean z16) {
        YogaNative.jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviourJNI(this.mNativePointer, z16);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setUseLegacyStretchBehaviour(boolean z16) {
        YogaNative.jni_YGConfigSetUseLegacyStretchBehaviourJNI(this.mNativePointer, z16);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setUseWebDefaults(boolean z16) {
        YogaNative.jni_YGConfigSetUseWebDefaultsJNI(this.mNativePointer, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YogaConfigJNIBase() {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    YogaConfigJNIBase(boolean z16) {
        this(YogaNative.jni_YGConfigNewJNI());
    }
}
