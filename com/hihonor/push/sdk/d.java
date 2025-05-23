package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile h1 f36362a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f36363b = new d();

    public final void a(Context context) {
        if (f36362a == null) {
            f36362a = new h1(context, "push");
        }
    }

    public synchronized String b(Context context) {
        String str;
        boolean z16;
        String str2;
        String str3;
        a(context);
        str = "";
        SharedPreferences sharedPreferences = f36362a.f36393a;
        boolean z17 = true;
        if (sharedPreferences != null && sharedPreferences.contains("key_push_token")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            SharedPreferences sharedPreferences2 = f36362a.f36393a;
            if (sharedPreferences2 == null || !sharedPreferences2.contains("key_aes_gcm")) {
                z17 = false;
            }
            if (z17) {
                SharedPreferences sharedPreferences3 = f36362a.f36393a;
                if (sharedPreferences3 != null) {
                    str2 = sharedPreferences3.getString("key_push_token", "");
                } else {
                    str2 = "";
                }
                SharedPreferences sharedPreferences4 = f36362a.f36393a;
                if (sharedPreferences4 != null) {
                    str3 = sharedPreferences4.getString("key_aes_gcm", "");
                } else {
                    str3 = "";
                }
                byte[] decode = Base64.decode(str3, 0);
                String str4 = "";
                if (!TextUtils.isEmpty(str2) && decode != null && decode.length >= 16) {
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, KeyPropertiesCompact.KEY_ALGORITHM_AES);
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        String substring = str2.substring(0, 24);
                        String substring2 = str2.substring(24);
                        if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2)) {
                            cipher.init(2, secretKeySpec, new GCMParameterSpec(128, b.a(substring)));
                            str4 = new String(cipher.doFinal(b.a(substring2)), StandardCharsets.UTF_8);
                        }
                    } catch (Exception e16) {
                        e16.getMessage();
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                    str = str4;
                } else {
                    f36362a.a("key_aes_gcm");
                    f36362a.a("key_push_token");
                }
            } else {
                f36362a.a("key_push_token");
            }
        }
        return str;
    }

    public synchronized void a(Context context, String str) {
        byte[] bArr;
        byte[] bArr2;
        a(context);
        if (TextUtils.isEmpty(str)) {
            f36362a.a("key_push_token");
        } else {
            String a16 = b.a(context, context.getPackageName());
            byte[] a17 = b.a("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");
            byte[] a18 = b.a(a16);
            try {
                bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
            } catch (Exception unused) {
                bArr = new byte[0];
            }
            String encodeToString = Base64.encodeToString(b.a(b.a(b.a(b.a(a17, -4), a18), 6), bArr), 0);
            boolean a19 = f36362a.a("key_aes_gcm", encodeToString);
            byte[] decode = Base64.decode(encodeToString, 0);
            String str2 = "";
            if (!TextUtils.isEmpty(str) && decode != null && decode.length >= 16) {
                try {
                    try {
                        bArr2 = new byte[12];
                        new SecureRandom().nextBytes(bArr2);
                    } catch (GeneralSecurityException e16) {
                        e16.getMessage();
                    }
                } catch (Exception unused2) {
                    bArr2 = new byte[0];
                }
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                SecretKeySpec secretKeySpec = new SecretKeySpec(decode, KeyPropertiesCompact.KEY_ALGORITHM_AES);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr2));
                byte[] doFinal = cipher.doFinal(bytes);
                if (doFinal != null && doFinal.length != 0) {
                    str2 = b.a(bArr2) + b.a(doFinal);
                }
            }
            if (a19 && !TextUtils.isEmpty(str2)) {
                f36362a.a("key_push_token", str2);
            }
        }
    }
}
