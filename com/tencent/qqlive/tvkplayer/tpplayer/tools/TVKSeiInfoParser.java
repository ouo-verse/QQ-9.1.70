package com.tencent.qqlive.tvkplayer.tpplayer.tools;

import com.tencent.qqlive.tvkplayer.api.TVKSeiInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes23.dex */
public class TVKSeiInfoParser {
    private static final String TAG = "TVKSeiInfoParser";
    private static final int UUID_LENGTH = 16;

    public static String getUserDataUnregisteredPayloadContent(TVKSeiInfo tVKSeiInfo) {
        byte[] bArr;
        if (tVKSeiInfo != null && tVKSeiInfo.seiType == 5 && (bArr = tVKSeiInfo.seiData) != null && bArr.length >= 16) {
            try {
                return new String(Arrays.copyOfRange(bArr, 16, bArr.length), StandardCharsets.UTF_8);
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | NullPointerException e16) {
                TVKLogUtil.e(TAG, e16, "[getPayloadContent] exception encountered:");
            }
        }
        return "";
    }
}
