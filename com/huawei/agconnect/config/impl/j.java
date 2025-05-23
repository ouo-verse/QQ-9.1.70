package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes2.dex */
class j implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f36498a;

    /* renamed from: b, reason: collision with root package name */
    private final String f36499b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, String str) {
        this.f36498a = context;
        this.f36499b = str;
    }

    private static String a(String str) {
        try {
            return "agc_" + Hex.encodeHexString(a(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    @Override // com.huawei.agconnect.config.impl.d
    public String a(String str, String str2) {
        int identifier;
        String a16 = a(str);
        if (TextUtils.isEmpty(a16) || (identifier = this.f36498a.getResources().getIdentifier(a16, HippyControllerProps.STRING, this.f36499b)) == 0) {
            return str2;
        }
        try {
            return this.f36498a.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return str2;
        }
    }

    private static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(bArr);
    }
}
