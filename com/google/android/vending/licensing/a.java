package com.google.android.vending.licensing;

import com.google.android.vending.licensing.util.Base64DecoderException;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements g {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f34625c = {RegisterType.UNINIT_REF, 74, 71, -80, 32, 101, -47, 72, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -14, 0, -29, 70, 65, -12, 74};

    /* renamed from: a, reason: collision with root package name */
    private Cipher f34626a;

    /* renamed from: b, reason: collision with root package name */
    private Cipher f34627b;

    public a(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC").generateSecret(new PBEKeySpec((str + str2).toCharArray(), bArr, 1024, 256)).getEncoded(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f34626a = cipher;
            byte[] bArr2 = f34625c;
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f34627b = cipher2;
            cipher2.init(2, secretKeySpec, new IvParameterSpec(bArr2));
        } catch (GeneralSecurityException e16) {
            throw new RuntimeException("Invalid environment", e16);
        }
    }

    @Override // com.google.android.vending.licensing.g
    public String a(String str, String str2) throws ValidationException {
        if (str == null) {
            return null;
        }
        try {
            String str3 = new String(this.f34627b.doFinal(o1.a.a(str)), "UTF-8");
            if (str3.indexOf("com.google.android.vending.licensing.AESObfuscator-1|" + str2) == 0) {
                return str3.substring(53 + str2.length(), str3.length());
            }
            throw new ValidationException("Header not found (invalid data or key):" + str);
        } catch (Base64DecoderException e16) {
            throw new ValidationException(e16.getMessage() + ":" + str);
        } catch (UnsupportedEncodingException e17) {
            throw new RuntimeException("Invalid environment", e17);
        } catch (BadPaddingException e18) {
            throw new ValidationException(e18.getMessage() + ":" + str);
        } catch (IllegalBlockSizeException e19) {
            throw new ValidationException(e19.getMessage() + ":" + str);
        }
    }

    @Override // com.google.android.vending.licensing.g
    public String b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return o1.a.g(this.f34626a.doFinal(("com.google.android.vending.licensing.AESObfuscator-1|" + str2 + str).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("Invalid environment", e16);
        } catch (GeneralSecurityException e17) {
            throw new RuntimeException("Invalid environment", e17);
        }
    }
}
