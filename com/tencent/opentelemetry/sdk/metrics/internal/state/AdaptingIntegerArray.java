package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AdaptingIntegerArray {
    static IPatchRedirector $redirector_;

    @Nullable
    private byte[] byteBacking;
    private ArrayCellSize cellSize;

    @Nullable
    private int[] intBacking;

    @Nullable
    private long[] longBacking;

    @Nullable
    private short[] shortBacking;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.state.AdaptingIntegerArray$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25675);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ArrayCellSize.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize = iArr;
            try {
                iArr[ArrayCellSize.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class ArrayCellSize {
        private static final /* synthetic */ ArrayCellSize[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ArrayCellSize BYTE;
        public static final ArrayCellSize INT;
        public static final ArrayCellSize LONG;
        public static final ArrayCellSize SHORT;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25679);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ArrayCellSize arrayCellSize = new ArrayCellSize("BYTE", 0);
            BYTE = arrayCellSize;
            ArrayCellSize arrayCellSize2 = new ArrayCellSize("SHORT", 1);
            SHORT = arrayCellSize2;
            ArrayCellSize arrayCellSize3 = new ArrayCellSize("INT", 2);
            INT = arrayCellSize3;
            ArrayCellSize arrayCellSize4 = new ArrayCellSize("LONG", 3);
            LONG = arrayCellSize4;
            $VALUES = new ArrayCellSize[]{arrayCellSize, arrayCellSize2, arrayCellSize3, arrayCellSize4};
        }

        ArrayCellSize(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ArrayCellSize valueOf(String str) {
            return (ArrayCellSize) Enum.valueOf(ArrayCellSize.class, str);
        }

        public static ArrayCellSize[] values() {
            return (ArrayCellSize[]) $VALUES.clone();
        }
    }

    public AdaptingIntegerArray(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.cellSize = ArrayCellSize.BYTE;
            this.byteBacking = new byte[i3];
        }
    }

    private void resizeToInt() {
        int[] iArr = new int[this.shortBacking.length];
        int i3 = 0;
        while (true) {
            short[] sArr = this.shortBacking;
            if (i3 < sArr.length) {
                iArr[i3] = sArr[i3];
                i3++;
            } else {
                this.cellSize = ArrayCellSize.INT;
                this.intBacking = iArr;
                this.shortBacking = null;
                return;
            }
        }
    }

    private void resizeToLong() {
        long[] jArr = new long[this.intBacking.length];
        int i3 = 0;
        while (true) {
            if (i3 < this.intBacking.length) {
                jArr[i3] = r2[i3];
                i3++;
            } else {
                this.cellSize = ArrayCellSize.LONG;
                this.longBacking = jArr;
                this.intBacking = null;
                return;
            }
        }
    }

    private void resizeToShort() {
        short[] sArr = new short[this.byteBacking.length];
        int i3 = 0;
        while (true) {
            if (i3 < this.byteBacking.length) {
                sArr[i3] = r2[i3];
                i3++;
            } else {
                this.cellSize = ArrayCellSize.SHORT;
                this.shortBacking = sArr;
                this.byteBacking = null;
                return;
            }
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        Arrays.fill(this.longBacking, 0L);
                        return;
                    }
                    return;
                }
                Arrays.fill(this.intBacking, 0);
                return;
            }
            Arrays.fill(this.shortBacking, (short) 0);
            return;
        }
        Arrays.fill(this.byteBacking, (byte) 0);
    }

    public AdaptingIntegerArray copy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AdaptingIntegerArray) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AdaptingIntegerArray(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long get(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        int i17 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 4) {
                        return 0L;
                    }
                    return this.longBacking[i3];
                }
                i16 = this.intBacking[i3];
            } else {
                i16 = this.shortBacking[i3];
            }
        } else {
            i16 = this.byteBacking[i3];
        }
        return i16;
    }

    public void increment(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        int i16 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        return;
                    }
                    long[] jArr = this.longBacking;
                    jArr[i3] = jArr[i3] + j3;
                    return;
                }
                int[] iArr = this.intBacking;
                long j16 = iArr[i3] + j3;
                if (j16 > TTL.MAX_VALUE) {
                    resizeToLong();
                    increment(i3, j3);
                    return;
                } else {
                    iArr[i3] = (int) j16;
                    return;
                }
            }
            short[] sArr = this.shortBacking;
            long j17 = sArr[i3] + j3;
            if (j17 > 32767) {
                resizeToInt();
                increment(i3, j3);
                return;
            } else {
                sArr[i3] = (short) j17;
                return;
            }
        }
        byte[] bArr = this.byteBacking;
        long j18 = bArr[i3] + j3;
        if (j18 > 127) {
            resizeToShort();
            increment(i3, j3);
        } else {
            bArr[i3] = (byte) j18;
        }
    }

    public int length() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return 0;
                    }
                    return this.longBacking.length;
                }
                return this.intBacking.length;
            }
            return this.shortBacking.length;
        }
        return this.byteBacking.length;
    }

    AdaptingIntegerArray(AdaptingIntegerArray adaptingIntegerArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) adaptingIntegerArray);
            return;
        }
        ArrayCellSize arrayCellSize = adaptingIntegerArray.cellSize;
        this.cellSize = arrayCellSize;
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[arrayCellSize.ordinal()];
        if (i3 == 1) {
            byte[] bArr = adaptingIntegerArray.byteBacking;
            this.byteBacking = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        if (i3 == 2) {
            short[] sArr = adaptingIntegerArray.shortBacking;
            this.shortBacking = Arrays.copyOf(sArr, sArr.length);
        } else if (i3 == 3) {
            int[] iArr = adaptingIntegerArray.intBacking;
            this.intBacking = Arrays.copyOf(iArr, iArr.length);
        } else {
            if (i3 != 4) {
                return;
            }
            long[] jArr = adaptingIntegerArray.longBacking;
            this.longBacking = Arrays.copyOf(jArr, jArr.length);
        }
    }
}
