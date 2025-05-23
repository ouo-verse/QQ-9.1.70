package org.jf.dexlib2.dexbacked.raw;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import org.jf.dexlib2.dexbacked.DexBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OdexHeaderItem {
    public static final int AUX_LENGTH_OFFSET = 28;
    public static final int AUX_OFFSET = 24;
    public static final int DEPENDENCIES_LENGTH_OFFSET = 20;
    public static final int DEPENDENCIES_OFFSET = 16;
    public static final int DEX_LENGTH_OFFSET = 12;
    public static final int DEX_OFFSET = 8;
    public static final int FLAGS_OFFSET = 32;
    public static final int ITEM_SIZE = 40;
    public static final int MAGIC_LENGTH = 8;
    public static final int MAGIC_OFFSET = 0;
    private static final byte[] MAGIC_VALUE = {100, 101, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, 10, 0, 0, 0, 0};
    private static final int[] SUPPORTED_ODEX_VERSIONS = {35, 36};

    public static int getDependenciesOffset(byte[] bArr) {
        return new DexBuffer(bArr).readSmallUint(16);
    }

    public static int getDexOffset(byte[] bArr) {
        return new DexBuffer(bArr).readSmallUint(8);
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

    public static boolean isSupportedOdexVersion(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = SUPPORTED_ODEX_VERSIONS;
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
