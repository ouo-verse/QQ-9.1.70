package com.tencent.taveffect.utils;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RandomUtils {
    public static float randomFloat(float f16, float f17) {
        return ((((new Random().nextFloat() * f17) * 1000.0f) % (((f17 - f16) * 1000.0f) + 1.0f)) / 1000.0f) + f16;
    }

    public static int randomInt(int i3, int i16) {
        return (new Random().nextInt(i16) % ((i16 - i3) + 1)) + i3;
    }
}
