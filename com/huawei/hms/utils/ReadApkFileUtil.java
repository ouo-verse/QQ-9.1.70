package com.huawei.hms.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* renamed from: a, reason: collision with root package name */
    private static final String f37707a = "ReadApkFileUtil";

    /* renamed from: c, reason: collision with root package name */
    private static String f37709c;

    /* renamed from: d, reason: collision with root package name */
    private static String f37710d;

    /* renamed from: e, reason: collision with root package name */
    private static String f37711e;

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f37708b = Pattern.compile("\\s*|\t|\r|\n");

    /* renamed from: f, reason: collision with root package name */
    private static String f37712f = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f37713g = null;

    private static byte[] a(ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    @TargetApi(19)
    private static void b(byte[] bArr) {
        Throwable th5;
        BufferedReader bufferedReader;
        ?? r26;
        InputStream inputStream;
        InputStream inputStream2;
        if (bArr == null) {
            HMSLog.e(f37707a, "manifest is null\uff01");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        f37709c = null;
        f37710d = null;
        f37711e = null;
        try {
            r26 = new ByteArrayInputStream(bArr);
        } catch (Exception unused) {
            r26 = 0;
        } catch (Throwable th6) {
            th5 = th6;
            bufferedReader = null;
            r26 = bufferedReader2;
            bufferedReader2 = bufferedReader;
            inputStream = r26;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly((Reader) bufferedReader2);
            throw th5;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader((InputStream) r26, StandardCharsets.UTF_8));
        } catch (Exception unused2) {
        } catch (Throwable th7) {
            th5 = th7;
            inputStream = r26;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly((Reader) bufferedReader2);
            throw th5;
        }
        try {
            String a16 = a(bufferedReader);
            while (a16 != null) {
                if (a16.length() != 0) {
                    if (a16.startsWith("ApkHash:")) {
                        f37712f = a(a16.substring(a16.indexOf(":") + 1));
                    }
                    if (a16.startsWith(KEY_SIGNATURE)) {
                        f37709c = a(a16.substring(a16.indexOf(":") + 1));
                        a16 = a(bufferedReader);
                    } else if (a16.startsWith(KEY_SIGNATURE2)) {
                        f37710d = a(a16.substring(a16.indexOf(":") + 1));
                        a16 = a(bufferedReader);
                    } else if (a16.startsWith(KEY_SIGNATURE3)) {
                        f37711e = a(a16.substring(a16.indexOf(":") + 1));
                        a16 = a(bufferedReader);
                    } else {
                        stringBuffer.append(a16);
                        stringBuffer.append("\r\n");
                    }
                }
                a16 = a(bufferedReader);
            }
            f37713g = stringBuffer.toString();
            inputStream2 = r26;
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            try {
                HMSLog.e(f37707a, "loadApkCert Exception!");
                bufferedReader = bufferedReader2;
                inputStream2 = r26;
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly((Reader) bufferedReader);
            } catch (Throwable th8) {
                th5 = th8;
                bufferedReader = bufferedReader2;
                bufferedReader2 = r26;
                r26 = bufferedReader2;
                bufferedReader2 = bufferedReader;
                inputStream = r26;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((Reader) bufferedReader2);
                throw th5;
            }
        } catch (Throwable th9) {
            th5 = th9;
            bufferedReader2 = bufferedReader;
            inputStream = r26;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly((Reader) bufferedReader2);
            throw th5;
        }
        IOUtils.closeQuietly(inputStream2);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            cArr2[i17] = cArr[i16 >>> 4];
            cArr2[i17 + 1] = cArr[i16 & 15];
        }
        return String.valueOf(cArr2);
    }

    private static boolean c() {
        try {
        } catch (Exception e16) {
            HMSLog.i(f37707a, "verifyMDMSignatureV3 MDM verify Exception!:" + e16.getMessage());
        }
        if (a(Base64.decode(EMUI11_PK, 0), a(f37713g, KeyPropertiesCompact.DIGEST_SHA384), b(f37711e), "SHA384withRSA")) {
            HMSLog.i(f37707a, "verifyMDMSignatureV3 verify successful!");
            return true;
        }
        HMSLog.i(f37707a, "verifyMDMSignatureV3 verify failure!");
        return false;
    }

    public static boolean checkSignature() {
        if (f37711e != null) {
            return c();
        }
        if (f37710d != null) {
            return b();
        }
        if (f37709c != null) {
            return a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e(f37707a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(19)
    public static boolean isCertFound(String str) {
        ZipFile zipFile;
        boolean z16;
        boolean z17 = false;
        ZipFile zipFile2 = null;
        ZipFile zipFile3 = null;
        ZipFile zipFile4 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    if (zipFile.getEntry("META-INF/HUAWEI.CER") != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        b(a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e16) {
                        String str2 = f37707a;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("zipFile.close Exception!");
                        sb5.append(e16.getMessage());
                        HMSLog.e(str2, sb5.toString());
                        zipFile3 = sb5;
                    }
                    z17 = z16;
                    zipFile2 = zipFile3;
                } catch (Exception e17) {
                    e = e17;
                    zipFile4 = zipFile;
                    HMSLog.e(f37707a, "isCertFound Exception!" + e.getMessage());
                    zipFile2 = zipFile4;
                    if (zipFile4 != null) {
                        try {
                            zipFile4.close();
                            zipFile2 = zipFile4;
                        } catch (IOException e18) {
                            String str3 = f37707a;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("zipFile.close Exception!");
                            sb6.append(e18.getMessage());
                            HMSLog.e(str3, sb6.toString());
                            zipFile2 = sb6;
                        }
                    }
                    return z17;
                } catch (Throwable th5) {
                    th = th5;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e19) {
                            HMSLog.e(f37707a, "zipFile.close Exception!" + e19.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
            return z17;
        } catch (Throwable th6) {
            th = th6;
            zipFile = zipFile2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean verifyApkHash(String str) {
        ZipFile zipFile;
        String str2 = null;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    byte[] a16 = a(zipFile);
                    ArrayList<String> a17 = a(a16);
                    if (a17 != null) {
                        a16 = a(a17);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
                    messageDigest.update(a16);
                    String bytesToString = bytesToString(messageDigest.digest());
                    String str3 = f37712f;
                    if (str3 != null) {
                        if (str3.equals(bytesToString)) {
                            try {
                                zipFile.close();
                                return true;
                            } catch (Exception e16) {
                                HMSLog.i(f37707a, "close stream Exception!" + e16.getMessage());
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e17) {
                        HMSLog.i(f37707a, "close stream Exception!" + e17.getMessage());
                        return false;
                    }
                } catch (Exception e18) {
                    e = e18;
                    zipFile2 = zipFile;
                    HMSLog.i(f37707a, "verifyApkHash Exception!" + e.getMessage());
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                            return false;
                        } catch (Exception e19) {
                            str2 = f37707a;
                            HMSLog.i(str2, "close stream Exception!" + e19.getMessage());
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e26) {
                            HMSLog.i(f37707a, "close stream Exception!" + e26.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e27) {
                e = e27;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    private static byte[] a(ZipFile zipFile, String str) {
        Throwable th5;
        InputStream inputStream;
        Exception e16;
        Throwable th6;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r46;
        OutputStream outputStream;
        OutputStream outputStream2;
        ZipEntry entry = zipFile.getEntry(str);
        OutputStream outputStream3 = null;
        if (entry == null) {
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(entry);
            if (inputStream == null) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Exception e17) {
                e16 = e17;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                r46 = byteArrayOutputStream;
                try {
                    HMSLog.i(f37707a, "getManifestBytes Exception!" + e16.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r46);
                    return null;
                } catch (Throwable th7) {
                    th6 = th7;
                    outputStream2 = r46;
                    bufferedInputStream = bufferedInputStream;
                    outputStream = outputStream2;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th6;
                }
            } catch (Throwable th8) {
                th5 = th8;
                th6 = th5;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th6;
            }
            try {
                byte[] bArr = new byte[4096];
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    r46 = new BufferedOutputStream(byteArrayOutputStream);
                } catch (Exception e18) {
                    e16 = e18;
                    r46 = 0;
                } catch (Throwable th9) {
                    th6 = th9;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th6;
                }
                try {
                    for (int read = bufferedInputStream.read(bArr, 0, 4096); read > 0; read = bufferedInputStream.read(bArr, 0, 4096)) {
                        r46.write(bArr, 0, read);
                    }
                    r46.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r46);
                    return byteArray;
                } catch (Exception e19) {
                    e16 = e19;
                    HMSLog.i(f37707a, "getManifestBytes Exception!" + e16.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r46);
                    return null;
                } catch (Throwable th10) {
                    th6 = th10;
                    outputStream = r46;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th6;
                }
            } catch (Exception e26) {
                e16 = e26;
                byteArrayOutputStream = null;
                r46 = byteArrayOutputStream;
                HMSLog.i(f37707a, "getManifestBytes Exception!" + e16.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((OutputStream) r46);
                return null;
            } catch (Throwable th11) {
                th6 = th11;
                byteArrayOutputStream = null;
                outputStream2 = null;
                bufferedInputStream = bufferedInputStream;
                outputStream = outputStream2;
                outputStream3 = outputStream;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th6;
            }
        } catch (Exception e27) {
            e16 = e27;
            inputStream = null;
        } catch (Throwable th12) {
            th5 = th12;
            inputStream = null;
        }
    }

    @TargetApi(19)
    private static ArrayList<String> a(byte[] bArr) {
        if (bArr == null) {
            HMSLog.e(f37707a, "manifest is null\uff01");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            HMSLog.e(f37707a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    private static boolean b() {
        try {
        } catch (Exception e16) {
            HMSLog.i(f37707a, "verifyMDMSignatureV2 MDM verify Exception!:" + e16.getMessage());
        }
        if (a(Base64.decode(EMUI10_PK, 0), a(f37713g, KeyPropertiesCompact.DIGEST_SHA256), b(f37710d), SignUtils.SIGNATURE_SHA256withRSA)) {
            HMSLog.i(f37707a, "verifyMDMSignatureV2 verify successful!");
            return true;
        }
        HMSLog.i(f37707a, "verifyMDMSignatureV2 verify failure!");
        return false;
    }

    @TargetApi(19)
    private static byte[] a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    String str = arrayList.get(i3);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write("\r\n", 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e16) {
                HMSLog.i(f37707a, "getManifestBytesbySorted Exception!" + e16.getMessage());
            }
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th5) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th5;
        }
    }

    private static byte[] b(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i3 = length / 2;
        } else {
            i3 = (length / 2) + 1;
        }
        byte[] bArr = new byte[i3];
        for (int i16 = 0; i16 < length; i16 += 2) {
            int i17 = i16 + 1;
            if (i17 < length) {
                bArr[i16 / 2] = (byte) ((Character.digit(str.charAt(i16), 16) << 4) + Character.digit(str.charAt(i17), 16));
            } else {
                bArr[i16 / 2] = (byte) (Character.digit(str.charAt(i16), 16) << 4);
            }
        }
        return bArr;
    }

    private static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String a16 = a(bufferedReader);
        boolean z16 = false;
        while (a16 != null) {
            if (a16.equals("Name: META-INF/HUAWEI.CER")) {
                String a17 = a(bufferedReader);
                while (true) {
                    if (a17 == null) {
                        break;
                    }
                    if (a17.startsWith("Name:")) {
                        a16 = a17;
                        break;
                    }
                    a17 = a(bufferedReader);
                }
                z16 = true;
            }
            if (a16.length() != 0) {
                arrayList.add(a16);
            }
            a16 = a(bufferedReader);
        }
        return z16;
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        int read;
        if (bufferedReader == null || (read = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(10);
        while (read != -1) {
            char c16 = (char) read;
            if (c16 == '\n') {
                break;
            }
            if (sb5.length() < 4096) {
                sb5.append(c16);
                read = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String sb6 = sb5.toString();
        return (sb6.isEmpty() || !sb6.endsWith("\r")) ? sb6 : sb6.substring(0, sb6.length() - 1);
    }

    private static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f37713g, KeyPropertiesCompact.DIGEST_SHA256), b(f37709c), SignUtils.SIGNATURE_SHA256withRSA)) {
                HMSLog.i(f37707a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f37707a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e16) {
            HMSLog.i(f37707a, "verifyMDMSignatureV1 MDM verify Exception!:" + e16.getMessage());
            return false;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    @TargetApi(19)
    private static byte[] a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    private static String a(String str) {
        return str != null ? f37708b.matcher(str).replaceAll("") : "";
    }
}
