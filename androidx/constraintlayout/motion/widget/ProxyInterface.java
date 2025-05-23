package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
interface ProxyInterface {
    int designAccess(int i3, String str, Object obj, float[] fArr, int i16, float[] fArr2, int i17);

    float getKeyFramePosition(Object obj, int i3, float f16, float f17);

    Object getKeyframeAtLocation(Object obj, float f16, float f17);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f16, float f17, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i3, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i3, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i3, int i16, float f16, float f17);

    void setToolPosition(float f16);
}
