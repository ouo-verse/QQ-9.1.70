package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CdexHeaderItem {
    public static final int DEBUG_INFO_BASE = 124;
    public static final int DEBUG_INFO_OFFSETS_POS_OFFSET = 116;
    public static final int DEBUG_INFO_OFFSETS_TABLE_OFFSET = 120;
    public static final int FEATURE_FLAGS_OFFSET = 112;
    private static final byte[] MAGIC_VALUE = {99, 100, 101, 120, 0, 0, 0, 0};
    private static final int[] SUPPORTED_CDEX_VERSIONS = {1};

    public static void annotateCdexHeaderFields(@Nonnull AnnotatedBytes annotatedBytes, DexBuffer dexBuffer) {
        annotatedBytes.annotate(4, "feature_flags: 0x%x", Integer.valueOf(dexBuffer.readInt(annotatedBytes.getCursor())));
        annotatedBytes.annotate(4, "debug_info_offsets_pos: 0x%x", Integer.valueOf(dexBuffer.readInt(annotatedBytes.getCursor())));
        annotatedBytes.annotate(4, "debug_info_offsets_table_offset: 0x%x", Integer.valueOf(dexBuffer.readInt(annotatedBytes.getCursor())));
        annotatedBytes.annotate(4, "debug_info_base: 0x%x", Integer.valueOf(dexBuffer.readInt(annotatedBytes.getCursor())));
    }

    public static int getVersion(byte[] bArr, int i3) {
        if (!verifyMagic(bArr, i3)) {
            return -1;
        }
        return getVersionUnchecked(bArr, i3);
    }

    private static int getVersionUnchecked(byte[] bArr, int i3) {
        return ((bArr[i3 + 4] - 48) * 100) + ((bArr[i3 + 5] - 48) * 10) + (bArr[i3 + 6] - 48);
    }

    public static boolean isSupportedCdexVersion(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = SUPPORTED_CDEX_VERSIONS;
            if (i16 >= iArr.length) {
                return false;
            }
            if (iArr[i16] == i3) {
                return true;
            }
            i16++;
        }
    }

    public static boolean verifyMagic(byte[] bArr, int i3) {
        if (bArr.length - i3 < 8) {
            return false;
        }
        int i16 = 0;
        while (true) {
            if (i16 < 4) {
                if (bArr[i3 + i16] != MAGIC_VALUE[i16]) {
                    return false;
                }
                i16++;
            } else {
                for (int i17 = 4; i17 < 7; i17++) {
                    byte b16 = bArr[i3 + i17];
                    if (b16 < 48 || b16 > 57) {
                        return false;
                    }
                }
                if (bArr[i3 + 7] != MAGIC_VALUE[7]) {
                    return false;
                }
                return true;
            }
        }
    }
}
