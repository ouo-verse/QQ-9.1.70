package com.gcore.abase;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.gcore.abase.log.XLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SecurityStore {
    private static final String ALIAS = "GCloudCoreKeyChain";
    private static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    public static SecurityStore Instance = new SecurityStore();
    private static final String RSA = "RSA/ECB/PKCS1Padding";
    private static final String SP_NAME = "GCloudCoreSP";
    private Context mContext = null;
    private KeyPair mKeyPair = null;

    private KeyPair generateKeyPair(Context context, String str) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 3).setDigests(KeyPropertiesCompact.DIGEST_SHA256, KeyPropertiesCompact.DIGEST_SHA512).setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_RSA_PKCS1).setKeySize(4096).build());
        return keyPairGenerator.generateKeyPair();
    }

    public void getKeyPair() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias(ALIAS)) {
                generateKeyPair(this.mContext, ALIAS);
            }
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(ALIAS, null);
            if (privateKeyEntry != null) {
                this.mKeyPair = new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            XLog.w("KeyChain init failed exception: " + e16);
        }
    }

    public String getString(String str, String str2) {
        String string = this.mContext.getSharedPreferences(SP_NAME, 0).getString(str, str2);
        if (GCloudCore.Instance.getSolidConfigBool("GCloud.GCloudCore", "UseKeyStore", false) && this.mKeyPair == null) {
            getKeyPair();
        }
        if (this.mKeyPair != null) {
            try {
                Cipher cipher = Cipher.getInstance(RSA);
                cipher.init(2, this.mKeyPair.getPrivate());
                return new String(cipher.doFinal(Base64.decode(string, 0)), "UTF-8");
            } catch (Exception e16) {
                e16.printStackTrace();
                XLog.e("KeyChain setString exception:" + e16);
                return string;
            }
        }
        return string;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void setString(String str, String str2) {
        if (GCloudCore.Instance.getSolidConfigBool("GCloud.GCloudCore", "UseKeyStore", false) && this.mKeyPair == null) {
            getKeyPair();
        }
        if (this.mKeyPair != null) {
            try {
                Cipher cipher = Cipher.getInstance(RSA);
                cipher.init(1, this.mKeyPair.getPublic());
                str2 = Base64.encodeToString(cipher.doFinal(str2.getBytes("UTF-8")), 0);
            } catch (Exception e16) {
                e16.printStackTrace();
                XLog.e("KeyChain setString exception:" + e16);
            }
        }
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_NAME, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
