package com.tencent.youtu.sdkkitframework.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.mcssdk.a.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtSDKKitFrameworkTool {
    static IPatchRedirector $redirector_ = null;
    private static char[] hexDigits = null;
    private static String huiYanVersion = "";
    private final String MD5_FILE_NAME;
    private final String TAG;
    private final Map<String, String> moduleFileMd5Map;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ModelValidityCode {
        private static final /* synthetic */ ModelValidityCode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ModelValidityCode CREATE_MD5_ERROR;
        public static final ModelValidityCode MODEL_FILE_MISS;
        public static final ModelValidityCode NOT_FOUND_MODEL_DIR;
        public static final ModelValidityCode NOT_FOUND_MODEL_MD5;
        public static final ModelValidityCode READ_MD5_ERROR;
        public static final ModelValidityCode TARGET_MD5_NOT_FOUND;
        public static final ModelValidityCode VALIDITY_ERROR;
        public static final ModelValidityCode VALIDITY_OK;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21421);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ModelValidityCode modelValidityCode = new ModelValidityCode("VALIDITY_OK", 0);
            VALIDITY_OK = modelValidityCode;
            ModelValidityCode modelValidityCode2 = new ModelValidityCode("NOT_FOUND_MODEL_DIR", 1);
            NOT_FOUND_MODEL_DIR = modelValidityCode2;
            ModelValidityCode modelValidityCode3 = new ModelValidityCode("NOT_FOUND_MODEL_MD5", 2);
            NOT_FOUND_MODEL_MD5 = modelValidityCode3;
            ModelValidityCode modelValidityCode4 = new ModelValidityCode("READ_MD5_ERROR", 3);
            READ_MD5_ERROR = modelValidityCode4;
            ModelValidityCode modelValidityCode5 = new ModelValidityCode("VALIDITY_ERROR", 4);
            VALIDITY_ERROR = modelValidityCode5;
            ModelValidityCode modelValidityCode6 = new ModelValidityCode("TARGET_MD5_NOT_FOUND", 5);
            TARGET_MD5_NOT_FOUND = modelValidityCode6;
            ModelValidityCode modelValidityCode7 = new ModelValidityCode("CREATE_MD5_ERROR", 6);
            CREATE_MD5_ERROR = modelValidityCode7;
            ModelValidityCode modelValidityCode8 = new ModelValidityCode("MODEL_FILE_MISS", 7);
            MODEL_FILE_MISS = modelValidityCode8;
            $VALUES = new ModelValidityCode[]{modelValidityCode, modelValidityCode2, modelValidityCode3, modelValidityCode4, modelValidityCode5, modelValidityCode6, modelValidityCode7, modelValidityCode8};
        }

        ModelValidityCode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ModelValidityCode valueOf(String str) {
            return (ModelValidityCode) Enum.valueOf(ModelValidityCode.class, str);
        }

        public static ModelValidityCode[] values() {
            return (ModelValidityCode[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16451);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        }
    }

    public YtSDKKitFrameworkTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.MD5_FILE_NAME = "files_md5";
        this.moduleFileMd5Map = new ConcurrentHashMap();
        this.TAG = YtSDKKitFrameworkTool.class.getSimpleName();
    }

    private String bytesToHexString(byte[] bArr) {
        if (bArr != null && bArr.length == 16) {
            char[] cArr = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = bArr[i16];
                int i17 = i3 + 1;
                char[] cArr2 = hexDigits;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr[i17] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.tencent.youtu.sdkkitframework.framework.YtSDKKitFrameworkTool] */
    private String getFileMD5(File file) {
        String str = "";
        if (file != null && file.exists() && file.length() > 0) {
            ?? r26 = 0;
            r26 = 0;
            r26 = 0;
            r26 = 0;
            try {
                try {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            str = getInputStreamMd5(bufferedInputStream);
                            bufferedInputStream.close();
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            r26 = bufferedInputStream;
                            e.printStackTrace();
                            YtLogger.e(this.TAG, "get file  md5 error ", e);
                            if (r26 != 0) {
                                r26.close();
                                r26 = r26;
                            }
                            return str;
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            r26 = bufferedInputStream;
                            YtLogger.e(this.TAG, "get file  md5 error oom", e);
                            if (r26 != 0) {
                                r26.close();
                                r26 = r26;
                            }
                            return str;
                        } catch (Throwable th5) {
                            th = th5;
                            r26 = bufferedInputStream;
                            if (r26 != 0) {
                                try {
                                    r26.close();
                                } catch (IOException e18) {
                                    YtLogger.e(this.TAG, "get file  md5 close io error:", e18);
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e19) {
                        e = e19;
                    } catch (OutOfMemoryError e26) {
                        e = e26;
                    }
                } catch (IOException e27) {
                    r26 = this.TAG;
                    YtLogger.e(r26, "get file  md5 close io error:", e27);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return str;
    }

    public static native String getFrameworkVersion();

    private String getInputStreamMd5(InputStream inputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            byte[] bArr = new byte[b.f36117k];
            int i3 = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, b.f36117k);
                if (read == -1) {
                    break;
                }
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                    i3 += read;
                }
            }
            if (i3 == 0) {
                return "";
            }
            return bytesToHexString(messageDigest.digest());
        } catch (IOException e16) {
            e16.printStackTrace();
            YtLogger.e(this.TAG, "get input stream  md5 error ", e16);
            return "";
        } catch (NoSuchAlgorithmException e17) {
            e17.printStackTrace();
            YtLogger.e(this.TAG, "get input stream  md5 error ", e17);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        return -3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        com.tencent.youtu.sdkkitframework.common.YtLogger.e(r9.TAG, "get modle md5 to map close io  error:", r10);
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        com.tencent.youtu.sdkkitframework.common.YtLogger.e(r9.TAG, "get modle md5 to map close io error:", r10);
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getModleMd5ToMap(File file) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file));
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                String[] split = readLine.split(":");
                                if (split.length < 2) {
                                    try {
                                        bufferedReader2.close();
                                        try {
                                            inputStreamReader.close();
                                            return -2;
                                        } catch (IOException e16) {
                                            YtLogger.e(this.TAG, "get modle md5 to map close io  error:", e16);
                                            e16.printStackTrace();
                                            return -1;
                                        }
                                    } catch (IOException e17) {
                                        YtLogger.e(this.TAG, "get modle md5 to map close io error:", e17);
                                        e17.printStackTrace();
                                        return -1;
                                    }
                                }
                                if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                    this.moduleFileMd5Map.put(split[0].trim(), split[1].trim());
                                }
                            } else {
                                try {
                                    bufferedReader2.close();
                                    try {
                                        inputStreamReader.close();
                                        return 0;
                                    } catch (IOException e18) {
                                        YtLogger.e(this.TAG, "get modle md5 to map close io  error:", e18);
                                        e18.printStackTrace();
                                        return -1;
                                    }
                                } catch (IOException e19) {
                                    YtLogger.e(this.TAG, "get modle md5 to map close io error:", e19);
                                    e19.printStackTrace();
                                    return -1;
                                }
                            }
                        } catch (Exception e26) {
                            bufferedReader = bufferedReader2;
                            e = e26;
                            YtLogger.e(this.TAG, "get modle md5 to map error:", e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e27) {
                                    YtLogger.e(this.TAG, "get modle md5 to map close io error:", e27);
                                    e27.printStackTrace();
                                    return -1;
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e28) {
                                    YtLogger.e(this.TAG, "get modle md5 to map close io  error:", e28);
                                    e28.printStackTrace();
                                }
                            }
                            return -1;
                        } catch (Throwable th5) {
                            bufferedReader = bufferedReader2;
                            th = th5;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e29) {
                                    YtLogger.e(this.TAG, "get modle md5 to map close io error:", e29);
                                    e29.printStackTrace();
                                    return -1;
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e36) {
                                    YtLogger.e(this.TAG, "get modle md5 to map close io  error:", e36);
                                    e36.printStackTrace();
                                    return -1;
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e37) {
                e = e37;
            }
        } catch (Exception e38) {
            e = e38;
            inputStreamReader = null;
        } catch (Throwable th7) {
            th = th7;
            inputStreamReader = null;
        }
    }

    public static synchronized void openBuglyShared(Context context) {
        synchronized (YtSDKKitFrameworkTool.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
            String frameworkVersion = getFrameworkVersion();
            if (!TextUtils.isEmpty(huiYanVersion)) {
                frameworkVersion = frameworkVersion + "_" + huiYanVersion;
            }
            edit.putString("63a0c81546", frameworkVersion);
            edit.commit();
        }
    }

    public static native YTImageData rotateYUVImage(byte[] bArr, int i3, int i16, int i17);

    private void searchFiles(File file, List<String> list) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    searchFiles(file2, list);
                } else {
                    String path = file2.getPath();
                    if (!file2.getName().equalsIgnoreCase("files_md5")) {
                        list.add(path);
                    }
                }
            }
            return;
        }
        YtLogger.e(this.TAG, "dir is empty", null);
    }

    public static void setHuiYanVersion(String str) {
        huiYanVersion = str;
    }

    private int traverseFolder(File file) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        searchFiles(file, copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() == 0) {
            YtLogger.e(this.TAG, "dir is empty", null);
            return -1;
        }
        String name = file.getName();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String substring = str.substring(str.indexOf(name) + name.length() + 1);
            if (this.moduleFileMd5Map.containsKey(substring)) {
                String fileMD5 = getFileMD5(new File(str));
                if (TextUtils.isEmpty(fileMD5)) {
                    YtLogger.e(this.TAG, "create md5 by file is error,md5 is null", null);
                    return -4;
                }
                if (!fileMD5.equalsIgnoreCase(this.moduleFileMd5Map.get(substring))) {
                    YtLogger.e(this.TAG, "md5 validity by dir error,file name is " + substring + "   target md5 is " + this.moduleFileMd5Map.get(substring) + " cur md5 is " + fileMD5, null);
                    return -2;
                }
                this.moduleFileMd5Map.remove(substring);
            } else {
                YtLogger.e(this.TAG, "the file name not found md5 with md5 map\uff1a" + substring, null);
                return -3;
            }
        }
        if (this.moduleFileMd5Map.size() != 0) {
            for (String str2 : this.moduleFileMd5Map.keySet()) {
                YtLogger.e(this.TAG, "module file miss:" + str2 + " md5:" + this.moduleFileMd5Map.get(str2), null);
            }
            return -5;
        }
        return 0;
    }

    public static native YTImageData yuv2bgrImge(byte[] bArr, int i3, int i16, int i17);

    public static native YTImageData yuvRotateAnd2bgrImge(byte[] bArr, int i3, int i16, int i17, int i18);

    public ModelValidityCode md5ValidityByDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ModelValidityCode) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        YtLogger.i(this.TAG, "module path :" + str);
        File file = new File(str);
        if (!file.exists()) {
            String str2 = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode = ModelValidityCode.NOT_FOUND_MODEL_DIR;
            sb5.append(modelValidityCode.name());
            YtLogger.e(str2, sb5.toString(), null);
            return modelValidityCode;
        }
        File file2 = new File(str + "files_md5");
        if (!file2.exists()) {
            String str3 = this.TAG;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode2 = ModelValidityCode.NOT_FOUND_MODEL_MD5;
            sb6.append(modelValidityCode2.name());
            YtLogger.e(str3, sb6.toString(), null);
            return modelValidityCode2;
        }
        if (getModleMd5ToMap(file2) != 0) {
            String str4 = this.TAG;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode3 = ModelValidityCode.READ_MD5_ERROR;
            sb7.append(modelValidityCode3.name());
            YtLogger.e(str4, sb7.toString(), null);
            return modelValidityCode3;
        }
        int traverseFolder = traverseFolder(file);
        if (traverseFolder == -1) {
            String str5 = this.TAG;
            StringBuilder sb8 = new StringBuilder();
            sb8.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode4 = ModelValidityCode.NOT_FOUND_MODEL_DIR;
            sb8.append(modelValidityCode4.name());
            YtLogger.e(str5, sb8.toString(), null);
            return modelValidityCode4;
        }
        if (traverseFolder == -2) {
            String str6 = this.TAG;
            StringBuilder sb9 = new StringBuilder();
            sb9.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode5 = ModelValidityCode.VALIDITY_ERROR;
            sb9.append(modelValidityCode5.name());
            YtLogger.e(str6, sb9.toString(), null);
            return modelValidityCode5;
        }
        if (traverseFolder == -3) {
            String str7 = this.TAG;
            StringBuilder sb10 = new StringBuilder();
            sb10.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode6 = ModelValidityCode.TARGET_MD5_NOT_FOUND;
            sb10.append(modelValidityCode6.name());
            YtLogger.e(str7, sb10.toString(), null);
            return modelValidityCode6;
        }
        if (traverseFolder == -4) {
            String str8 = this.TAG;
            StringBuilder sb11 = new StringBuilder();
            sb11.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode7 = ModelValidityCode.CREATE_MD5_ERROR;
            sb11.append(modelValidityCode7.name());
            YtLogger.e(str8, sb11.toString(), null);
            return modelValidityCode7;
        }
        if (traverseFolder == -5) {
            String str9 = this.TAG;
            StringBuilder sb12 = new StringBuilder();
            sb12.append("md5 validity by dir error:");
            ModelValidityCode modelValidityCode8 = ModelValidityCode.MODEL_FILE_MISS;
            sb12.append(modelValidityCode8.name());
            YtLogger.e(str9, sb12.toString(), null);
            return modelValidityCode8;
        }
        YtLogger.d(this.TAG, "md5 validity by dir ok");
        return ModelValidityCode.VALIDITY_OK;
    }
}
