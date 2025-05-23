package com.airbnb.lottie;

/* compiled from: P */
/* loaded from: classes.dex */
public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* compiled from: P */
    /* renamed from: com.airbnb.lottie.RenderMode$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode;

        static {
            int[] iArr = new int[RenderMode.values().length];
            $SwitchMap$com$airbnb$lottie$RenderMode = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean useSoftwareRendering(int i3, boolean z16, int i16) {
        int i17 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$RenderMode[ordinal()];
        if (i17 == 1) {
            return false;
        }
        if (i17 == 2) {
            return true;
        }
        if ((!z16 || i3 >= 28) && i16 <= 4 && i3 > 25) {
            return false;
        }
        return true;
    }
}
