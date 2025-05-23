package com.tenpay.ndk;

import android.content.Context;

/* loaded from: classes27.dex */
public class PassWdEncUtil {
    private String buss_info;
    private byte[] enc_passwd;
    private byte[] raw_passwd;
    private String server_time_stamp = "0";
    private int time_stamp;

    public PassWdEncUtil(Context context) {
        CftSoLoader.loadSo(context);
    }

    private native boolean encryptInfo(byte b16, byte[] bArr, int i3);

    private native boolean encryptPasswd(byte b16, byte[] bArr);

    private native boolean encryptPasswd1(byte b16, byte[] bArr);

    private boolean encryptPasswd1(String str, String str2) {
        boolean encryptPasswd1;
        synchronized (CftSoLoader.lock) {
            setTimeStamp(str2);
            encryptPasswd1 = encryptPasswd1(str);
        }
        return encryptPasswd1;
    }

    private boolean encryptPasswd2(String str) {
        synchronized (CftSoLoader.lock) {
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptPasswd2(bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private native boolean encryptPasswd2(byte[] bArr);

    private boolean encryptPasswd3(String str) {
        synchronized (CftSoLoader.lock) {
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptPasswd3(bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private native boolean encryptPasswd3(byte[] bArr);

    private native boolean encryptPasswdWithRsa(byte b16, byte[] bArr, int i3);

    public boolean encryptInfo(String str, String str2, int i3) {
        synchronized (CftSoLoader.lock) {
            if (i3 > 1 || i3 < 0) {
                return false;
            }
            setTimeStamp(str2);
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptInfo((byte) 2, bytes, i3);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public boolean encryptPasswd(String str, String str2) {
        boolean encryptPasswd;
        synchronized (CftSoLoader.lock) {
            setTimeStamp(str2);
            encryptPasswd = encryptPasswd(str);
        }
        return encryptPasswd;
    }

    public boolean encryptPasswdWithMacNew(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            setTimeStamp(str2);
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptPasswd((byte) 5, bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public boolean encryptPasswdWithNoMacNew(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            setTimeStamp(str2);
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptPasswd1((byte) 5, bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public boolean encryptPasswdWithRsa(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            setTimeStamp(str2);
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptPasswdWithRsa((byte) 5, bytes, 1);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public String getEncryptPasswd() {
        byte[] bArr;
        synchronized (CftSoLoader.lock) {
            if (CftSoLoader.currentVersionName.equals(CftSoLoader.VERSION_1_2_6)) {
                byte[] bArr2 = this.enc_passwd;
                if (bArr2 == null) {
                    return null;
                }
                try {
                    int length = bArr2.length / 2;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr2, length, bArr3, 0, length);
                    return new String(bArr3, "ASCII");
                } catch (Exception unused) {
                    return null;
                }
            }
            if (!CftSoLoader.isNewVersion(CftSoLoader.currentVersionName, CftSoLoader.VERSION_1_3_1) || (bArr = this.enc_passwd) == null) {
                return null;
            }
            return new String(bArr);
        }
    }

    public String getRSA2048Res() {
        synchronized (CftSoLoader.lock) {
            byte[] bArr = this.enc_passwd;
            if (bArr == null) {
                return null;
            }
            try {
                return new String(bArr, "ASCII");
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public String getTimeStamp() {
        String valueOf;
        synchronized (CftSoLoader.lock) {
            valueOf = String.valueOf(this.time_stamp);
        }
        return valueOf;
    }

    public void setBussInfo(String str) {
        synchronized (CftSoLoader.lock) {
            this.buss_info = str;
        }
    }

    public void setTimeStamp(String str) {
        this.server_time_stamp = str;
    }

    private boolean encryptPasswd1(String str) {
        synchronized (CftSoLoader.lock) {
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptPasswd1((byte) 2, bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public boolean encryptPasswd(String str) {
        synchronized (CftSoLoader.lock) {
            this.time_stamp = 0;
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_passwd = bytes;
                return encryptPasswd((byte) 2, bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private boolean encryptPasswd3(String str, String str2) {
        boolean encryptPasswd3;
        synchronized (CftSoLoader.lock) {
            setTimeStamp(str2);
            encryptPasswd3 = encryptPasswd3(str);
        }
        return encryptPasswd3;
    }
}
