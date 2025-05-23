package org.jbox2d.profile;

import org.jbox2d.common.Settings;

/* loaded from: classes29.dex */
public abstract class SettingsPerformanceTest extends BasicPerformanceTest {
    private static int NUM_TESTS = 8;

    public SettingsPerformanceTest(int i3) {
        super(NUM_TESTS, i3);
    }

    @Override // org.jbox2d.profile.BasicPerformanceTest
    public String getTestName(int i3) {
        switch (i3) {
            case 0:
                return "No optimizations";
            case 1:
                return "Fast abs";
            case 2:
                return "Fast atan2";
            case 3:
                return "Fast ceil";
            case 4:
                return "Fast floor";
            case 5:
                return "Fast round";
            case 6:
                return "Sincos lookup table";
            case 7:
                return "All optimizations on";
            default:
                return "";
        }
    }

    public abstract void runBenchmarkWorld();

    @Override // org.jbox2d.profile.BasicPerformanceTest
    public void runTest(int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27 = false;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Settings.FAST_ABS = z16;
        if (i3 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        Settings.FAST_ATAN2 = z17;
        if (i3 == 3) {
            z18 = true;
        } else {
            z18 = false;
        }
        Settings.FAST_CEIL = z18;
        if (i3 == 4) {
            z19 = true;
        } else {
            z19 = false;
        }
        Settings.FAST_FLOOR = z19;
        if (i3 == 5) {
            z26 = true;
        } else {
            z26 = false;
        }
        Settings.FAST_ROUND = z26;
        if (i3 == 6) {
            z27 = true;
        }
        Settings.SINCOS_LUT_ENABLED = z27;
        if (i3 == 7) {
            Settings.FAST_ABS = true;
            Settings.FAST_ATAN2 = true;
            Settings.FAST_CEIL = true;
            Settings.FAST_FLOOR = true;
            Settings.FAST_ROUND = true;
            Settings.SINCOS_LUT_ENABLED = true;
        }
        runBenchmarkWorld();
    }
}
