package org.jbox2d.profile;

/* loaded from: classes29.dex */
public abstract class BasicPerformanceTest {
    private final int iters;
    private final int numTests;
    protected final long[] times;

    public BasicPerformanceTest(int i3, int i16) {
        this.numTests = i3;
        this.iters = i16;
        this.times = new long[i3];
        for (int i17 = 0; i17 < i3; i17++) {
            this.times[i17] = 0;
        }
    }

    public int getFrames(int i3) {
        return 0;
    }

    public abstract String getTestName(int i3);

    public double getTestTime(int i3) {
        return (this.times[i3] * 1.0d) / 1000000.0d;
    }

    public void go() {
        for (int i3 = 0; i3 < this.iters; i3++) {
            println(((i3 * 100.0d) / this.iters) + "%");
            for (int i16 = 0; i16 < this.numTests; i16++) {
                long nanoTime = System.nanoTime();
                runTest(i16);
                long nanoTime2 = System.nanoTime();
                long[] jArr = this.times;
                jArr[i16] = jArr[i16] + (nanoTime2 - nanoTime);
            }
        }
        for (int i17 = 0; i17 < this.numTests; i17++) {
            long[] jArr2 = this.times;
            jArr2[i17] = jArr2[i17] / this.iters;
        }
        printResults();
    }

    public void printResults() {
        printf("%-20s%20s%20s\n", "Test Name", "Milliseconds Avg", "FPS (optional)");
        for (int i3 = 0; i3 < this.numTests; i3++) {
            double d16 = (this.times[i3] * 1.0d) / 1000000.0d;
            if (getFrames(i3) != 0) {
                printf("%-20s%20.4f%20.4f\n", getTestName(i3), Double.valueOf(d16), Double.valueOf((getFrames(i3) * 1000.0d) / d16));
            } else {
                printf("%-20s%20.4f\n", getTestName(i3), Double.valueOf(d16));
            }
        }
    }

    public void printf(String str, Object... objArr) {
        System.out.printf(str, objArr);
    }

    public void println(String str) {
        System.out.println(str);
    }

    public abstract void runTest(int i3);
}
