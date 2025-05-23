package com.tencent.qqlive.module.videoreport.sample;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleMutex {
    private static int sCurEidSampleMode;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface EidSampleMode {
        public static final int EID_SAME_RATE = 1;
        public static final int EID_SEPARATELY_RATE = 2;
    }

    public static int curEidSampleMode() {
        return sCurEidSampleMode;
    }

    public static synchronized void setEidSampleMode(int i3) {
        synchronized (SampleMutex.class) {
            if (i3 != 1 && i3 != 2) {
                throw new UnsupportedOperationException("eid sample mode set error");
            }
            int i16 = sCurEidSampleMode;
            if (i16 == 1) {
                if (i3 == 2) {
                    throw new UnsupportedOperationException("already set separately rate");
                }
            } else if (i16 == 2) {
                if (i3 == 1) {
                    throw new UnsupportedOperationException("already set same rate");
                }
            } else {
                sCurEidSampleMode = i3;
            }
        }
    }
}
