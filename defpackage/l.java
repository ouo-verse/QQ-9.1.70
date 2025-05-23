package defpackage;

import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f413536a = new l();

    public final String f(int i3) {
        int compare;
        int compare2;
        int compare3;
        int compare4;
        compare = Integer.compare(i3 ^ Integer.MIN_VALUE, UInt.m570constructorimpl(1048576) ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Integer.compare(i3 ^ Integer.MIN_VALUE, 1024 ^ Integer.MIN_VALUE);
            if (compare2 <= 0) {
                compare3 = Integer.compare(i3 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                if (compare3 > 0) {
                    compare4 = Integer.compare(i3 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                    if (compare4 > 0) {
                        return "B/s";
                    }
                }
                return "";
            }
            return "KB/s";
        }
        return "MB/s";
    }

    public final String g(int i3) {
        int compare;
        int compare2;
        int compare3;
        int compare4;
        compare = Integer.compare(i3 ^ Integer.MIN_VALUE, UInt.m570constructorimpl(1048576) ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Integer.compare(i3 ^ Integer.MIN_VALUE, 1024 ^ Integer.MIN_VALUE);
            if (compare2 <= 0) {
                compare3 = Integer.compare(i3 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                if (compare3 > 0) {
                    compare4 = Integer.compare(i3 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                    if (compare4 > 0) {
                        return UInt.m615toStringimpl(i3);
                    }
                }
                return "";
            }
            return h(((float) UnsignedKt.uintToDouble(i3)) / 1024);
        }
        float f16 = 1024;
        return h((((float) UnsignedKt.uintToDouble(i3)) / f16) / f16);
    }

    public final float d(long j3) {
        int compare;
        int compare2;
        compare = Long.compare(j3 ^ Long.MIN_VALUE, ULong.m648constructorimpl(1048576L) ^ Long.MIN_VALUE);
        if (compare < 0) {
            return 30.0f;
        }
        compare2 = Long.compare(j3 ^ Long.MIN_VALUE, ULong.m648constructorimpl(GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) ^ Long.MIN_VALUE);
        if (compare2 > 0) {
            return 60.0f;
        }
        return (((((float) UnsignedKt.ulongToDouble(j3)) - ((float) 1048576)) / 3.0408704E7f) * 30.0f) + 30;
    }

    public final String e(int i3) {
        int compare;
        int compare2;
        int compare3;
        if (UnsignedKt.ulongCompare(ULong.m648constructorimpl(i3 & 4294967295L), ULong.m648constructorimpl(1048576)) <= 0) {
            compare = Integer.compare(i3 ^ Integer.MIN_VALUE, 1024 ^ Integer.MIN_VALUE);
            if (compare <= 0) {
                compare2 = Integer.compare(i3 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                if (compare2 > 0) {
                    compare3 = Integer.compare(i3 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                    if (compare3 > 0) {
                        return ((Object) UInt.m615toStringimpl(i3)) + "B/s";
                    }
                    return "0B/s";
                }
                return "";
            }
            return h(((float) UnsignedKt.uintToDouble(i3)) / 1024) + "KB/s";
        }
        StringBuilder sb5 = new StringBuilder();
        float f16 = 1024;
        sb5.append(h((((float) UnsignedKt.uintToDouble(i3)) / f16) / f16));
        sb5.append("MB/s");
        return sb5.toString();
    }

    public final String h(float f16) {
        double pow = Math.pow(10.0d, 1);
        return String.valueOf(Math.rint(f16 * pow) / pow);
    }

    public final String a(long j3) {
        if (j3 > 3600) {
            return ((j3 + 3559) / 3600) + "\u5c0f\u65f6";
        }
        if (j3 > 60) {
            return ((j3 + 59) / 60) + "\u5206\u949f";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        sb5.append('\u79d2');
        return sb5.toString();
    }

    public final String c(long j3) {
        if (j3 > 1073741824) {
            return "GB";
        }
        if (j3 > 1048576) {
            return "MB";
        }
        if (j3 > 1024) {
            return "KB";
        }
        return "B";
    }

    public final String b(long j3) {
        if (j3 > 1073741824) {
            float f16 = 1024;
            return h(((((float) j3) / f16) / f16) / f16);
        }
        if (j3 > 1048576) {
            float f17 = 1024;
            return h((((float) j3) / f17) / f17);
        }
        if (j3 > 1024) {
            return h(((float) j3) / 1024);
        }
        return String.valueOf(j3);
    }
}
