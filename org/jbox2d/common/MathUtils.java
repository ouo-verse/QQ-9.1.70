package org.jbox2d.common;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MathUtils extends PlatformMathUtils {
    public static final float DEG2RAD = 0.017453292f;
    public static final float HALF_PI = 1.5707964f;
    public static final float INV_PI = 0.31830987f;
    public static final float PI = 3.1415927f;
    public static final float QUARTER_PI = 0.7853982f;
    public static final float RAD2DEG = 57.295776f;
    public static final float THREE_HALVES_PI = 4.712389f;
    public static final float TWOPI = 6.2831855f;
    public static final float[] sinLUT = new float[Settings.SINCOS_LUT_LENGTH];

    static {
        for (int i3 = 0; i3 < Settings.SINCOS_LUT_LENGTH; i3++) {
            sinLUT[i3] = (float) Math.sin(i3 * 1.1E-4f);
        }
    }

    public static final int abs(int i3) {
        int i16 = i3 >> 31;
        return (i3 ^ i16) - i16;
    }

    public static final float atan2(float f16, float f17) {
        if (Settings.FAST_ATAN2) {
            return fastAtan2(f16, f17);
        }
        return (float) StrictMath.atan2(f16, f17);
    }

    public static final int ceil(float f16) {
        if (Settings.FAST_CEIL) {
            int i3 = (int) f16;
            if (f16 > 0.0f && f16 != i3) {
                return i3 + 1;
            }
            return i3;
        }
        return (int) Math.ceil(f16);
    }

    public static final int ceilPowerOf2(int i3) {
        int i16 = 1;
        while (i16 < i3) {
            i16 <<= 1;
        }
        return i16;
    }

    public static final float clamp(float f16, float f17, float f18) {
        return max(f17, min(f16, f18));
    }

    public static final void clampToOut(Vec2 vec2, Vec2 vec22, Vec2 vec23, Vec2 vec24) {
        float f16 = vec2.f423649x;
        float f17 = vec23.f423649x;
        if (f16 >= f17) {
            f16 = f17;
        }
        vec24.f423649x = f16;
        float f18 = vec2.f423650y;
        float f19 = vec23.f423650y;
        if (f18 >= f19) {
            f18 = f19;
        }
        vec24.f423650y = f18;
        float f26 = vec22.f423649x;
        if (f26 > f16) {
            f16 = f26;
        }
        vec24.f423649x = f16;
        float f27 = vec22.f423650y;
        if (f27 > f18) {
            f18 = f27;
        }
        vec24.f423650y = f18;
    }

    public static final float cos(float f16) {
        if (Settings.SINCOS_LUT_ENABLED) {
            return sinLUT(1.5707964f - f16);
        }
        return (float) StrictMath.cos(f16);
    }

    public static final float distance(Vec2 vec2, Vec2 vec22) {
        return sqrt(distanceSquared(vec2, vec22));
    }

    public static final float distanceSquared(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x - vec22.f423649x;
        float f17 = vec2.f423650y - vec22.f423650y;
        return (f16 * f16) + (f17 * f17);
    }

    public static final float fastAtan2(float f16, float f17) {
        if (f17 == 0.0f) {
            if (f16 > 0.0f) {
                return 1.5707964f;
            }
            if (f16 == 0.0f) {
                return 0.0f;
            }
            return -1.5707964f;
        }
        float f18 = f16 / f17;
        if (abs(f18) < 1.0f) {
            float f19 = f18 / (((0.28f * f18) * f18) + 1.0f);
            if (f17 < 0.0f) {
                if (f16 < 0.0f) {
                    return f19 - 3.1415927f;
                }
                return f19 + 3.1415927f;
            }
            return f19;
        }
        float f26 = 1.5707964f - (f18 / ((f18 * f18) + 0.28f));
        if (f16 < 0.0f) {
            return f26 - 3.1415927f;
        }
        return f26;
    }

    public static final int floor(float f16) {
        if (Settings.FAST_FLOOR) {
            int i3 = (int) f16;
            if (f16 < 0.0f && f16 != i3) {
                return i3 - 1;
            }
            return i3;
        }
        return (int) Math.floor(f16);
    }

    public static final boolean isPowerOfTwo(int i3) {
        if (i3 > 0 && (i3 & (i3 - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static final float map(float f16, float f17, float f18, float f19, float f26) {
        return f19 + (((f16 - f17) / (f18 - f17)) * (f26 - f19));
    }

    public static final float max(float f16, float f17) {
        return f16 > f17 ? f16 : f17;
    }

    public static final float min(float f16, float f17) {
        return f16 < f17 ? f16 : f17;
    }

    public static final int nextPowerOfTwo(int i3) {
        int i16 = i3 | (i3 >> 1);
        int i17 = i16 | (i16 >> 2);
        int i18 = i17 | (i17 >> 4);
        int i19 = i18 | (i18 >> 8);
        return (i19 | (i19 >> 16)) + 1;
    }

    public static final float randomFloat(float f16, float f17) {
        return (((float) Math.random()) * (f17 - f16)) + f16;
    }

    public static final float reduceAngle(float f16) {
        float f17 = f16 % 6.2831855f;
        if (abs(f17) > 3.1415927f) {
            f17 -= 6.2831855f;
        }
        if (abs(f17) > 1.5707964f) {
            return 3.1415927f - f17;
        }
        return f17;
    }

    public static final int round(float f16) {
        if (Settings.FAST_ROUND) {
            return floor(f16 + 0.5f);
        }
        return StrictMath.round(f16);
    }

    public static final float sin(float f16) {
        if (Settings.SINCOS_LUT_ENABLED) {
            return sinLUT(f16);
        }
        return (float) StrictMath.sin(f16);
    }

    public static final float sinLUT(float f16) {
        float f17;
        float f18;
        float f19 = f16 % 6.2831855f;
        if (f19 < 0.0f) {
            f19 += 6.2831855f;
        }
        if (Settings.SINCOS_LUT_LERP) {
            float f26 = f19 / 1.1E-4f;
            int i3 = (int) f26;
            if (i3 != 0) {
                f26 %= i3;
            }
            if (i3 == Settings.SINCOS_LUT_LENGTH - 1) {
                float[] fArr = sinLUT;
                f17 = (1.0f - f26) * fArr[i3];
                f18 = fArr[0];
            } else {
                float[] fArr2 = sinLUT;
                f17 = (1.0f - f26) * fArr2[i3];
                f18 = fArr2[i3 + 1];
            }
            return f17 + (f26 * f18);
        }
        return sinLUT[round(f19 / 1.1E-4f) % Settings.SINCOS_LUT_LENGTH];
    }

    public static final float sqrt(float f16) {
        return (float) StrictMath.sqrt(f16);
    }

    public static final float abs(float f16) {
        if (Settings.FAST_ABS) {
            return f16 > 0.0f ? f16 : -f16;
        }
        return Math.abs(f16);
    }

    public static final Vec2 clamp(Vec2 vec2, Vec2 vec22, Vec2 vec23) {
        Vec2 vec24 = new Vec2();
        float f16 = vec2.f423649x;
        float f17 = vec23.f423649x;
        if (f16 >= f17) {
            f16 = f17;
        }
        vec24.f423649x = f16;
        float f18 = vec2.f423650y;
        float f19 = vec23.f423650y;
        if (f18 >= f19) {
            f18 = f19;
        }
        vec24.f423650y = f18;
        float f26 = vec22.f423649x;
        if (f26 > f16) {
            f16 = f26;
        }
        vec24.f423649x = f16;
        float f27 = vec22.f423650y;
        if (f27 > f18) {
            f18 = f27;
        }
        vec24.f423650y = f18;
        return vec24;
    }

    public static final int max(int i3, int i16) {
        return i3 > i16 ? i3 : i16;
    }

    public static final int min(int i3, int i16) {
        return i3 < i16 ? i3 : i16;
    }

    public static final float randomFloat(Random random, float f16, float f17) {
        return (random.nextFloat() * (f17 - f16)) + f16;
    }
}
