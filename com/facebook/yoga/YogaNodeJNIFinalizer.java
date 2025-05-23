package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public class YogaNodeJNIFinalizer extends YogaNodeJNIBase {
    public YogaNodeJNIFinalizer() {
    }

    protected void finalize() throws Throwable {
        try {
            freeNatives();
        } finally {
            super.finalize();
        }
    }

    public void freeNatives() {
        long j3 = this.mNativePointer;
        if (j3 != 0) {
            this.mNativePointer = 0L;
            YogaNative.jni_YGNodeFreeJNI(j3);
        }
    }

    public YogaNodeJNIFinalizer(YogaConfig yogaConfig) {
        super(yogaConfig);
    }
}
