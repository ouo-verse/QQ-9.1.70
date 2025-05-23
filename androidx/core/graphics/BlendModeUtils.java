package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes.dex */
class BlendModeUtils {

    /* compiled from: P */
    /* renamed from: androidx.core.graphics.BlendModeUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$core$graphics$BlendModeCompat;

        static {
            int[] iArr = new int[BlendModeCompat.values().length];
            $SwitchMap$androidx$core$graphics$BlendModeCompat = iArr;
            try {
                iArr[BlendModeCompat.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    BlendModeUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @RequiresApi(29)
    public static BlendMode obtainBlendModeFromCompat(@NonNull BlendModeCompat blendModeCompat) {
        BlendMode blendMode;
        BlendMode blendMode2;
        BlendMode blendMode3;
        BlendMode blendMode4;
        BlendMode blendMode5;
        BlendMode blendMode6;
        BlendMode blendMode7;
        BlendMode blendMode8;
        BlendMode blendMode9;
        BlendMode blendMode10;
        BlendMode blendMode11;
        BlendMode blendMode12;
        BlendMode blendMode13;
        BlendMode blendMode14;
        BlendMode blendMode15;
        BlendMode blendMode16;
        BlendMode blendMode17;
        BlendMode blendMode18;
        BlendMode blendMode19;
        BlendMode blendMode20;
        BlendMode blendMode21;
        BlendMode blendMode22;
        BlendMode blendMode23;
        BlendMode blendMode24;
        BlendMode blendMode25;
        BlendMode blendMode26;
        BlendMode blendMode27;
        BlendMode blendMode28;
        BlendMode blendMode29;
        switch (AnonymousClass1.$SwitchMap$androidx$core$graphics$BlendModeCompat[blendModeCompat.ordinal()]) {
            case 1:
                blendMode = BlendMode.CLEAR;
                return blendMode;
            case 2:
                blendMode2 = BlendMode.SRC;
                return blendMode2;
            case 3:
                blendMode3 = BlendMode.DST;
                return blendMode3;
            case 4:
                blendMode4 = BlendMode.SRC_OVER;
                return blendMode4;
            case 5:
                blendMode5 = BlendMode.DST_OVER;
                return blendMode5;
            case 6:
                blendMode6 = BlendMode.SRC_IN;
                return blendMode6;
            case 7:
                blendMode7 = BlendMode.DST_IN;
                return blendMode7;
            case 8:
                blendMode8 = BlendMode.SRC_OUT;
                return blendMode8;
            case 9:
                blendMode9 = BlendMode.DST_OUT;
                return blendMode9;
            case 10:
                blendMode10 = BlendMode.SRC_ATOP;
                return blendMode10;
            case 11:
                blendMode11 = BlendMode.DST_ATOP;
                return blendMode11;
            case 12:
                blendMode12 = BlendMode.XOR;
                return blendMode12;
            case 13:
                blendMode13 = BlendMode.PLUS;
                return blendMode13;
            case 14:
                blendMode14 = BlendMode.MODULATE;
                return blendMode14;
            case 15:
                blendMode15 = BlendMode.SCREEN;
                return blendMode15;
            case 16:
                blendMode16 = BlendMode.OVERLAY;
                return blendMode16;
            case 17:
                blendMode17 = BlendMode.DARKEN;
                return blendMode17;
            case 18:
                blendMode18 = BlendMode.LIGHTEN;
                return blendMode18;
            case 19:
                blendMode19 = BlendMode.COLOR_DODGE;
                return blendMode19;
            case 20:
                blendMode20 = BlendMode.COLOR_BURN;
                return blendMode20;
            case 21:
                blendMode21 = BlendMode.HARD_LIGHT;
                return blendMode21;
            case 22:
                blendMode22 = BlendMode.SOFT_LIGHT;
                return blendMode22;
            case 23:
                blendMode23 = BlendMode.DIFFERENCE;
                return blendMode23;
            case 24:
                blendMode24 = BlendMode.EXCLUSION;
                return blendMode24;
            case 25:
                blendMode25 = BlendMode.MULTIPLY;
                return blendMode25;
            case 26:
                blendMode26 = BlendMode.HUE;
                return blendMode26;
            case 27:
                blendMode27 = BlendMode.SATURATION;
                return blendMode27;
            case 28:
                blendMode28 = BlendMode.COLOR;
                return blendMode28;
            case 29:
                blendMode29 = BlendMode.LUMINOSITY;
                return blendMode29;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static PorterDuff.Mode obtainPorterDuffFromCompat(@Nullable BlendModeCompat blendModeCompat) {
        if (blendModeCompat == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$androidx$core$graphics$BlendModeCompat[blendModeCompat.ordinal()]) {
            case 1:
                return PorterDuff.Mode.CLEAR;
            case 2:
                return PorterDuff.Mode.SRC;
            case 3:
                return PorterDuff.Mode.DST;
            case 4:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.DST_OVER;
            case 6:
                return PorterDuff.Mode.SRC_IN;
            case 7:
                return PorterDuff.Mode.DST_IN;
            case 8:
                return PorterDuff.Mode.SRC_OUT;
            case 9:
                return PorterDuff.Mode.DST_OUT;
            case 10:
                return PorterDuff.Mode.SRC_ATOP;
            case 11:
                return PorterDuff.Mode.DST_ATOP;
            case 12:
                return PorterDuff.Mode.XOR;
            case 13:
                return PorterDuff.Mode.ADD;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.OVERLAY;
            case 17:
                return PorterDuff.Mode.DARKEN;
            case 18:
                return PorterDuff.Mode.LIGHTEN;
            default:
                return null;
        }
    }
}
