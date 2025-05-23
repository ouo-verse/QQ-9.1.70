package com.tencent.gamematrix.gmcg.base.utils;

import android.text.TextUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGMD5Util {
    public static String fileMD5(File file) {
        FileInputStream fileInputStream;
        DigestInputStream digestInputStream = null;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            fileInputStream = new FileInputStream(file);
            try {
                DigestInputStream digestInputStream2 = new DigestInputStream(fileInputStream, messageDigest);
                try {
                    do {
                    } while (digestInputStream2.read(new byte[262144]) > 0);
                    String replace = String.format("%32s", new BigInteger(1, digestInputStream2.getMessageDigest().digest()).toString(16)).replace(TokenParser.SP, '0');
                    try {
                        digestInputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return replace;
                } catch (FileNotFoundException unused3) {
                    digestInputStream = digestInputStream2;
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return "";
                } catch (IOException unused6) {
                    digestInputStream = digestInputStream2;
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused8) {
                        }
                    }
                    return "";
                } catch (NoSuchAlgorithmException unused9) {
                    digestInputStream = digestInputStream2;
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (Exception unused10) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused11) {
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    digestInputStream = digestInputStream2;
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (Exception unused12) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Exception unused13) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused14) {
            } catch (IOException unused15) {
            } catch (NoSuchAlgorithmException unused16) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (FileNotFoundException unused17) {
            fileInputStream = null;
        } catch (IOException unused18) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException unused19) {
            fileInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
    }

    public static String fileMd5(String str) {
        return fileMD5(new File(str));
    }

    public static String stringMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return String.format("%32s", new BigInteger(1, MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes())).toString(16)).replace(TokenParser.SP, '0');
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
