package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e implements g {

    /* renamed from: a, reason: collision with root package name */
    private final d f36494a;

    /* renamed from: b, reason: collision with root package name */
    private SecretKey f36495b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f36494a = dVar;
        a();
    }

    static String b(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            if (!matcher.find()) {
                return "";
            }
            return matcher.group(1);
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
            Log.e("ExclamationMark", "getRawString exception");
            return "";
        }
    }

    @Override // com.huawei.agconnect.config.impl.g
    public String a(String str, String str2) {
        String str3;
        if (this.f36495b == null) {
            str3 = "mKey is null, return default value";
        } else {
            if (!a(str)) {
                return str2;
            }
            try {
                return new String(i.a(this.f36495b, Hex.decodeHexString(b(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
                str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
            }
        }
        Log.e("ExclamationMark", str3);
        return str2;
    }

    private SecretKey a() {
        try {
            String a16 = this.f36494a.a("/code/code1", null);
            String a17 = this.f36494a.a("/code/code2", null);
            String a18 = this.f36494a.a("/code/code3", null);
            String a19 = this.f36494a.a("/code/code4", null);
            if (a16 != null && a17 != null && a18 != null && a19 != null) {
                this.f36495b = i.a(Hex.decodeHexString(a16), Hex.decodeHexString(a17), Hex.decodeHexString(a18), Hex.decodeHexString(a19), 10000);
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("ExclamationMark", "Exception when reading the 'K&I' for 'Config'.");
            this.f36495b = null;
        }
        return this.f36495b;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }
}
