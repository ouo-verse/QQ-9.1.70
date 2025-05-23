package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UtfEncodingKt {
    @NotNull
    public static final byte[] stringsToBytes(@NotNull String[] strings) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        int i3 = 0;
        for (String str : strings) {
            i3 += str.length();
        }
        byte[] bArr = new byte[i3];
        int i16 = 0;
        for (String str2 : strings) {
            int length = str2.length();
            int i17 = 0;
            while (i17 < length) {
                bArr[i16] = (byte) str2.charAt(i17);
                i17++;
                i16++;
            }
        }
        return bArr;
    }
}
