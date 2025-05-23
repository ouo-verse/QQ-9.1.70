package org.jbox2d.common;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Settings {
    public static int CONTACT_STACK_INIT_SIZE = 10;
    public static final float EPSILON = 1.1920929E-7f;
    public static boolean FAST_ABS = true;
    public static boolean FAST_ATAN2 = true;
    public static boolean FAST_CEIL = true;
    public static boolean FAST_FLOOR = true;
    public static boolean FAST_ROUND = true;
    public static final float PI = 3.1415927f;
    public static boolean SINCOS_LUT_ENABLED = true;
    public static final float SINCOS_LUT_PRECISION = 1.1E-4f;
    public static final float aabbExtension = 0.1f;
    public static final float aabbMultiplier = 2.0f;
    public static final float angularSleepTolerance = 0.03490659f;
    public static final float angularSlop = 0.03490659f;
    public static final float baumgarte = 0.2f;
    public static final float linearSleepTolerance = 0.01f;
    public static final float linearSlop = 0.005f;
    public static final float maxAngularCorrection = 0.13962635f;
    public static final float maxLinearCorrection = 0.2f;
    public static final int maxManifoldPoints = 2;
    public static final int maxPolygonVertices = 8;
    public static final float maxRotation = 1.5707964f;
    public static final int maxSubSteps = 8;
    public static final int maxTOIContacts = 32;
    public static final float maxTranslation = 2.0f;
    public static final float maxTranslationSquared = 4.0f;
    public static final float polygonRadius = 0.01f;
    public static final float timeToSleep = 0.5f;
    public static final float toiBaugarte = 0.75f;
    public static final float velocityThreshold = 1.0f;
    public static final int SINCOS_LUT_LENGTH = (int) Math.ceil(57119.86598277577d);
    public static boolean SINCOS_LUT_LERP = false;
    public static float maxRotationSquared = 2.4674013f;

    public static final float mixFriction(float f16, float f17) {
        return MathUtils.sqrt(f16 * f17);
    }

    public static final float mixRestitution(float f16, float f17) {
        if (f16 <= f17) {
            return f17;
        }
        return f16;
    }
}
