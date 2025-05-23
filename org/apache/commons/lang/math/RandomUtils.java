package org.apache.commons.lang.math;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RandomUtils {
    public static final Random JVM_RANDOM = new JVMRandom();

    public static boolean nextBoolean() {
        return nextBoolean(JVM_RANDOM);
    }

    public static double nextDouble() {
        return nextDouble(JVM_RANDOM);
    }

    public static float nextFloat() {
        return nextFloat(JVM_RANDOM);
    }

    public static int nextInt() {
        return nextInt(JVM_RANDOM);
    }

    public static long nextLong() {
        return nextLong(JVM_RANDOM);
    }

    public static boolean nextBoolean(Random random) {
        return random.nextBoolean();
    }

    public static double nextDouble(Random random) {
        return random.nextDouble();
    }

    public static float nextFloat(Random random) {
        return random.nextFloat();
    }

    public static int nextInt(Random random) {
        return random.nextInt();
    }

    public static long nextLong(Random random) {
        return random.nextLong();
    }

    public static int nextInt(int i3) {
        return nextInt(JVM_RANDOM, i3);
    }

    public static int nextInt(Random random, int i3) {
        return random.nextInt(i3);
    }
}
