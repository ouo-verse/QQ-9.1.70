package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyDecryptedResult;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodVinfoDecryptor {
    private static final Pattern ENCRYPTED_VINFO_CONTENT_PATTERN = Pattern.compile("(?<=<anc>).*(?=</anc>)");

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DecryptException extends Exception {
        public DecryptException(String str) {
            super(str);
        }
    }

    public static String decryptVinfo(String str) throws DecryptException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = ENCRYPTED_VINFO_CONTENT_PATTERN.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        TVKCKeyDecryptedResult decryptCKeyServerResponse = TVKCKeyGenerator.decryptCKeyServerResponse(str.substring(matcher.start(), matcher.end()));
        if (decryptCKeyServerResponse != null && decryptCKeyServerResponse.getRetCode() == 0 && decryptCKeyServerResponse.getData() != null && decryptCKeyServerResponse.getData().length != 0) {
            return new String(decryptCKeyServerResponse.getData(), StandardCharsets.UTF_8);
        }
        throw new DecryptException("Invalid decrypted result");
    }
}
