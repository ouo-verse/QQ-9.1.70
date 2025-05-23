package com.tencent.mobileqq.shortvideo.util;

import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    public static void a(int[] iArr, byte[] bArr, int i3, int i16) {
        int i17 = i3 * i16;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < i16; i27++) {
            int i28 = ((i27 >> 1) * i3) / 2;
            int i29 = i17 + i28;
            int i36 = ((i17 * 5) / 4) + i28;
            int i37 = 0;
            while (i37 < i3) {
                int i38 = (bArr[i26] & 255) - 16;
                if (i38 < 0) {
                    i38 = 0;
                }
                if ((i37 & 1) == 0) {
                    int i39 = (bArr[i29] & 255) - 128;
                    i29++;
                    i18 = i39;
                    i19 = (bArr[i36] & 255) - 128;
                    i36++;
                }
                int i46 = i38 * QzoneCoverConst.MSG_COVER_INVALIDATE;
                int i47 = (i19 * 1634) + i46;
                int i48 = (i46 - (i19 * 833)) - (i18 * 400);
                int i49 = i46 + (i18 * 2066);
                if (i47 < 0) {
                    i47 = 0;
                } else if (i47 > 262143) {
                    i47 = 262143;
                }
                if (i48 < 0) {
                    i48 = 0;
                } else if (i48 > 262143) {
                    i48 = 262143;
                }
                if (i49 < 0) {
                    i49 = 0;
                } else if (i49 > 262143) {
                    i49 = 262143;
                }
                iArr[i26] = ((i49 >> 10) & 255) | ((i47 << 6) & ITVKAsset.VOD_ASSET_MASK_BIT) | (-16777216) | ((i48 >> 2) & 65280);
                i37++;
                i26++;
            }
        }
    }
}
