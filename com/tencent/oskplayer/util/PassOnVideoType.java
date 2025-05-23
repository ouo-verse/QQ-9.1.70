package com.tencent.oskplayer.util;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;

/* loaded from: classes22.dex */
public class PassOnVideoType implements Predicate<String> {
    public static final String TAG = "PassOnVideoType";

    @Override // com.tencent.oskplayer.util.Predicate
    public boolean evaluate(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            for (String str2 : PlayerConfig.g().getContentTypeList()) {
                if (!TextUtils.isEmpty(str2) && (lowerCase.startsWith(str2.toLowerCase()) || lowerCase.startsWith("video") || lowerCase.startsWith("audio"))) {
                    return true;
                }
            }
            return false;
        }
        PlayerUtils.log(5, TAG, "contentType is null");
        return false;
    }

    @Override // com.tencent.oskplayer.util.Predicate
    public boolean evaluate(byte[] bArr) {
        return !PlayerUtils.isContentHtml(bArr);
    }
}
