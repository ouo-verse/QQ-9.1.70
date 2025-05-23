package com.tencent.luggage.wxa.tg;

import android.text.TextUtils;
import com.tencent.oskplayer.util.PassOnVideoType;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements i {
    @Override // com.tencent.luggage.wxa.tg.i
    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("video") || lowerCase.startsWith("audio")) {
                return true;
            }
            for (String str2 : com.tencent.luggage.wxa.og.a.a().g()) {
                if (!TextUtils.isEmpty(str2) && lowerCase.startsWith(str2.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }
        h.a(5, PassOnVideoType.TAG, "contentType is null");
        return false;
    }

    @Override // com.tencent.luggage.wxa.tg.i
    public boolean a(byte[] bArr) {
        return !h.a(bArr);
    }
}
