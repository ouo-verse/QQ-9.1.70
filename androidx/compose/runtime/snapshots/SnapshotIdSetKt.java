package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u00a8\u0006\u0007"}, d2 = {"lowestBitOf", "", "bits", "", "binarySearch", "", "value", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotIdSetKt {
    public static final int binarySearch(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length - 1;
        int i16 = 0;
        while (i16 <= length) {
            int i17 = (i16 + length) >>> 1;
            int i18 = iArr[i17];
            if (i3 > i18) {
                i16 = i17 + 1;
            } else {
                if (i3 >= i18) {
                    return i17;
                }
                length = i17 - 1;
            }
        }
        return -(i16 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int lowestBitOf(long j3) {
        int i3;
        if ((4294967295L & j3) == 0) {
            i3 = 32;
            j3 >>= 32;
        } else {
            i3 = 0;
        }
        if ((WebSocketProtocol.PAYLOAD_SHORT_MAX & j3) == 0) {
            i3 += 16;
            j3 >>= 16;
        }
        if ((255 & j3) == 0) {
            i3 += 8;
            j3 >>= 8;
        }
        if ((15 & j3) == 0) {
            i3 += 4;
            j3 >>= 4;
        }
        if ((1 & j3) != 0) {
            return i3;
        }
        if ((2 & j3) != 0) {
            return i3 + 1;
        }
        if ((4 & j3) != 0) {
            return i3 + 2;
        }
        if ((j3 & 8) != 0) {
            return i3 + 3;
        }
        return -1;
    }
}
