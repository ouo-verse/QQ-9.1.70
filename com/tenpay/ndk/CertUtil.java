package com.tenpay.ndk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncApi;
import java.io.File;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CertUtil {
    public static final String TAG = "CertUtil";
    private static CertUtil instance;
    private String cert_dir;
    private Context mContext;
    private String priv_dir;
    private String publ_dir;
    private String token_dir;
    private String qq_id = null;
    private String login_ip = null;
    private String svr_cert = null;
    private String cert_id = null;
    private String sig_raw_buf = null;
    private String plain_buf = null;
    private byte[] plain_buf2 = null;
    private String token = null;
    private byte[] token_buf = null;
    private int token_len = 0;
    private byte[] csr_buf = null;
    private byte[] sig_buf = null;
    private byte[] cipher_buf = null;
    private byte[] certid_buf = null;
    private String mac = null;
    private String imei = null;
    private String deskey = null;
    private EventListener eventListener = null;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface EventListener {
        void onEvent(int i3, String str);
    }

    CertUtil(Context context) {
        this.mContext = null;
        this.mContext = context.getApplicationContext();
        CftSoLoader.loadSo(context);
        init(context);
    }

    public static void addCert(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("qb_tenpay_pay_" + str, 0).edit();
        edit.putString("qpay_cid", str2);
        edit.commit();
    }

    private void checkDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
    }

    private boolean create_dir(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    QwLog.i("dir create failed, path = " + str);
                    return mkdirs;
                }
                return mkdirs;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean del_all_files(String str) {
        String[] list;
        File file;
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory() || (list = file2.list()) == null) {
            return false;
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < list.length; i3++) {
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                file = new File(str + list[i3]);
            } else {
                file = new File(str + str2 + list[i3]);
            }
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                del_all_files(str + str2 + list[i3]);
                del_dir(str + str2 + list[i3], true);
                z16 = true;
            }
        }
        return z16;
    }

    private void del_dir(String str, boolean z16) {
        try {
            del_all_files(str);
            if (z16) {
                new File(str).delete();
            }
        } catch (Exception e16) {
            QwLog.i("del_dir error=" + e16.getMessage());
        }
    }

    private native boolean encrypt();

    private native long expireTime();

    private native boolean genCertApplyCsr();

    private native boolean genQrcode();

    private String getCertDir() {
        return this.mContext.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
    }

    private native boolean getCertid();

    public static String getCid(Context context, String str) {
        return context.getSharedPreferences("qb_tenpay_pay_" + str, 0).getString("qpay_cid", null);
    }

    public static CertUtil getInstance(Context context) {
        CertUtil certUtil;
        synchronized (CftSoLoader.lock) {
            if (instance == null) {
                instance = new CertUtil(context);
            }
            certUtil = instance;
        }
        return certUtil;
    }

    private native boolean getToken();

    private native int getTokenCount();

    private String hexdigest(String str) {
        if (str == null) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = digest[i16];
                int i17 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    private native boolean importCert();

    private void init(Context context) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("-----init cert begin-----");
            try {
                this.imei = QFuncApi.getDeviceId(context);
            } catch (Exception unused) {
            }
            this.deskey = this.imei;
            QwLog.i("-----init cert end-----");
        }
    }

    private native boolean isCertExist();

    private boolean isNotEmptyDir(String str) {
        boolean z16;
        synchronized (CftSoLoader.lock) {
            QwLog.i("isNotEmptyDir " + str);
            File file = new File(str);
            if (file.exists() && file.isDirectory() && file.listFiles() != null) {
                z16 = true;
            }
            z16 = false;
        }
        return z16;
    }

    private boolean isValidDir(String str) {
        boolean z16;
        synchronized (CftSoLoader.lock) {
            QwLog.i("isValidDir " + str);
            File file = new File(str);
            QwLog.i("dir.exists() = " + file.exists());
            QwLog.i("dir.isDirectory() = " + file.isDirectory());
            if (file.exists() && file.isDirectory()) {
                z16 = true;
            }
            z16 = false;
        }
        return z16;
    }

    private void onNativeEvent(int i3, String str) {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onEvent(i3, str);
        }
    }

    public static void removeCert(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("qb_tenpay_pay_" + str, 0).edit();
        edit.putString("qpay_cid", "");
        edit.commit();
    }

    private void setAndCheckDir(String str) {
        String certDir = getCertDir();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(certDir);
        sb5.append("/");
        sb5.append(hexdigest(str + this.imei));
        String sb6 = sb5.toString();
        this.cert_dir = sb6 + "/cert";
        this.priv_dir = sb6 + "/priv";
        this.publ_dir = sb6 + "/publ";
        this.token_dir = sb6 + "/auth";
        checkDir(certDir);
        checkDir(this.token_dir);
    }

    private void setDir(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getCertDir());
        sb5.append("/");
        sb5.append(hexdigest(str + this.imei));
        String sb6 = sb5.toString();
        this.cert_dir = sb6 + "/cert";
        this.priv_dir = sb6 + "/priv";
        this.publ_dir = sb6 + "/publ";
        this.token_dir = sb6 + "/auth";
    }

    private native boolean setToken();

    private native boolean usrSig();

    private native boolean usrSig(byte[] bArr);

    public void clearAllCert() {
        synchronized (CftSoLoader.lock) {
            QwLog.i("clearAllCert() ");
            del_dir(getCertDir(), true);
        }
    }

    public void clearCert(String str) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("clearCert() ");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getCertDir());
            sb5.append("/");
            sb5.append(hexdigest(str + this.imei));
            del_dir(sb5.toString(), true);
        }
    }

    public void clearToken(String str) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("cleartoken() cid=" + str);
            if (TextUtils.isEmpty(str)) {
                QwLog.i("isNullOrEmpty");
            } else {
                setDir(str);
                del_dir(this.token_dir, true);
            }
        }
    }

    public String encrypt(String str, String str2) {
        byte[] bArr;
        synchronized (CftSoLoader.lock) {
            QwLog.i("encrypt() cid=" + str);
            QwLog.i("plainText=" + str2);
            String str3 = null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    this.cert_id = str;
                    this.plain_buf = str2;
                    this.cipher_buf = null;
                    if (encrypt() && (bArr = this.cipher_buf) != null) {
                        try {
                            str3 = new String(bArr, "UTF-8");
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    return str3;
                }
                QwLog.i("invalid dir");
                return null;
            }
            QwLog.i("isNullOrEmpty");
            return null;
        }
    }

    public String genUserSigNoEncode(String str, String str2) {
        boolean z16;
        byte[] bArr;
        if (!isCertExist(str)) {
            QwLog.i("error, local cert not exist!");
            return null;
        }
        synchronized (CftSoLoader.lock) {
            QwLog.i("cid = " + str + " raw_buf = " + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    this.cert_id = str;
                    this.sig_buf = null;
                    if (CftSoLoader.currentVersionName.equals(CftSoLoader.VERSION_1_2_6)) {
                        this.sig_raw_buf = str2;
                        z16 = usrSig();
                    } else if (CftSoLoader.isNewVersion(CftSoLoader.currentVersionName, CftSoLoader.VERSION_1_3_1)) {
                        z16 = usrSig(str2.getBytes());
                    } else {
                        z16 = false;
                    }
                    if (z16 && (bArr = this.sig_buf) != null) {
                        try {
                            return new String(bArr, "UTF-8");
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    QwLog.i("usr_sign error = " + getLastError());
                    return null;
                }
                QwLog.i("invalid dir");
                return null;
            }
            QwLog.i("isNullOrEmpty");
            return null;
        }
    }

    public String getCertApplyCSR(String str) {
        String str2;
        byte[] bArr;
        synchronized (CftSoLoader.lock) {
            QwLog.i("getCertApplyCSR uin=" + str);
            this.qq_id = str;
            str2 = null;
            this.csr_buf = null;
            if (genCertApplyCsr() && (bArr = this.csr_buf) != null) {
                try {
                    str2 = new String(bArr, "ASCII");
                } catch (Exception unused) {
                    return null;
                }
            }
            QwLog.i("getCertApplyCSR ret=\n" + str2);
        }
        return str2;
    }

    public String getImei() {
        return this.imei;
    }

    public native int getLastError();

    public String getToken(String str) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("gettoken() cid=" + str);
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                QwLog.i("isNullOrEmpty");
                return null;
            }
            setAndCheckDir(str);
            if (!isNotEmptyDir(this.token_dir)) {
                QwLog.i("invalid dir");
                return null;
            }
            this.cert_id = str;
            if (getToken() && this.token_buf != null) {
                QwLog.i("token_buf.length=" + this.token_buf.length);
                try {
                    str2 = new String(this.token_buf, "UTF-8");
                } catch (Exception unused) {
                    return null;
                }
            }
            QwLog.i("token=" + str2);
            return str2;
        }
    }

    public int getTokenCount(String str) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("getTokenCount() cid=" + str);
            if (TextUtils.isEmpty(str)) {
                QwLog.i("isNullOrEmpty");
                return 0;
            }
            setDir(str);
            this.cert_id = str;
            int tokenCount = getTokenCount();
            QwLog.i("getTokenCount() ret=" + tokenCount);
            return tokenCount;
        }
    }

    public native String getVersion();

    public boolean importCert(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("importCert cid = " + str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    this.cert_id = str;
                    this.svr_cert = new String(str2.getBytes(), "ASCII");
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                setAndCheckDir(str);
                del_dir(this.cert_dir, true);
                create_dir(this.cert_dir);
                del_dir(this.priv_dir, true);
                create_dir(this.priv_dir);
                del_dir(this.publ_dir, true);
                create_dir(this.publ_dir);
                boolean importCert = importCert();
                QwLog.i("ret = " + importCert);
                return importCert;
            }
            QwLog.i("cid isNullOrEmpty");
            return false;
        }
    }

    public boolean isCertExist(String str) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("isCertExist() cid=" + str);
            if (TextUtils.isEmpty(str)) {
                QwLog.i("cid isNullOrEmpty");
                return false;
            }
            setDir(str);
            if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                this.cert_id = str;
                return isCertExist();
            }
            QwLog.i("invalid dir, cert not exist");
            return false;
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public boolean setTokens(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            QwLog.i("setToken() cid=" + str);
            QwLog.i("tokens=" + str2);
            QwLog.i("tokens.length()=" + str2.length());
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                setAndCheckDir(str);
                if (!isValidDir(this.cert_dir)) {
                    QwLog.i("invalid dir");
                    return false;
                }
                if (!isValidDir(this.token_dir)) {
                    QwLog.i("invalid dir");
                    return false;
                }
                this.cert_id = str;
                this.token = str2;
                this.token_len = str2.length();
                boolean token = setToken();
                QwLog.i("ret=" + token);
                return token;
            }
            QwLog.i("isNullOrEmpty");
            return false;
        }
    }
}
