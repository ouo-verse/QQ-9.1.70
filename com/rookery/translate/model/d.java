package com.rookery.translate.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f61218a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes("UTF-8"));
            return b(messageDigest.digest());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        } catch (NoSuchAlgorithmException unused2) {
            throw new AssertionError();
        }
    }

    static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        int i3 = 0;
        for (byte b16 : bArr) {
            int i16 = i3 + 1;
            char[] cArr2 = f61218a;
            cArr[i3] = cArr2[(b16 >>> 4) & 15];
            i3 = i16 + 1;
            cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }

    @TargetApi(8)
    public static File c(Context context) {
        return context.getExternalCacheDir();
    }

    @TargetApi(9)
    public static boolean d() {
        return Environment.isExternalStorageRemovable();
    }

    public static String e(String str, String str2, long j3) {
        return str + "[@]" + str2 + "[id:]" + j3;
    }

    public static String f(String str, String str2) {
        return str + "{@}" + str2;
    }
}
