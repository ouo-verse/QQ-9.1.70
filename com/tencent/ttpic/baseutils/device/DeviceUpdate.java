package com.tencent.ttpic.baseutils.device;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DeviceUpdate {
    private static final String CHARSET_UTF8 = "UTF-8";
    private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
    private static final String TAG = "DeviceUpdate";

    private static HttpURLConnection buildConnection(String str, int i3) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(i3);
        httpURLConnection.setReadTimeout(i3);
        return httpURLConnection;
    }

    public static String checkConfigVersion(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("PackageName", str2);
        hashMap.put("camCoreVersion", str3);
        hashMap.put("AppId", str4);
        hashMap.put("AppVersion", str5);
        try {
            return post(str, hashMap);
        } catch (Exception e16) {
            LogUtils.d(TAG, "checkConfigVersion Exception! e = " + e16);
            return null;
        }
    }

    public static String get(String str) throws IOException {
        return get(str, 10000);
    }

    private static String getResponse(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuilder sb5 = new StringBuilder();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    sb5.append(new String(bArr, 0, read));
                } else {
                    inputStream.close();
                    return sb5.toString();
                }
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x009e A[Catch: IOException -> 0x00a7, TryCatch #0 {IOException -> 0x00a7, blocks: (B:3:0x0009, B:5:0x002a, B:6:0x0033, B:21:0x0060, B:28:0x008a, B:30:0x008f, B:32:0x0094, B:37:0x0099, B:39:0x009e, B:41:0x00a3, B:42:0x00a6), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3 A[Catch: IOException -> 0x00a7, TryCatch #0 {IOException -> 0x00a7, blocks: (B:3:0x0009, B:5:0x002a, B:6:0x0033, B:21:0x0060, B:28:0x008a, B:30:0x008f, B:32:0x0094, B:37:0x0099, B:39:0x009e, B:41:0x00a3, B:42:0x00a6), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean httpDownloadFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th5;
        InputStream inputStream;
        Exception e16;
        String str3 = TAG;
        LogUtils.d(str3, "downloadFile");
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            File file = new File(str2);
            if (file.exists()) {
                LogUtils.d(str3, "downloadFile file already exist");
                file.delete();
            }
            LogUtils.d(str3, "downloadFile file not exist, do new file first");
            file.createNewFile();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e17) {
                    fileOutputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    fileOutputStream = null;
                    th5 = th6;
                    httpURLConnection.disconnect();
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                fileOutputStream = null;
                e16 = e18;
                inputStream = null;
            } catch (Throwable th7) {
                fileOutputStream = null;
                th5 = th7;
                inputStream = null;
            }
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            LogUtils.d(TAG, "downloadFile file finish, return true");
                            httpURLConnection.disconnect();
                            inputStream.close();
                            fileOutputStream.close();
                            return true;
                        }
                    }
                } catch (Throwable th8) {
                    th5 = th8;
                    httpURLConnection.disconnect();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th5;
                }
            } catch (Exception e19) {
                e16 = e19;
                LogUtils.d(TAG, "downloadFile getInputStream or FileOutputStream fail");
                LogUtils.e(e16);
                httpURLConnection.disconnect();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream == null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            }
        } catch (IOException e26) {
            LogUtils.e(e26);
            return false;
        }
    }

    public static String post(String str, HashMap<String, String> hashMap) throws IOException {
        return post(str, hashMap, 10000);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:166:0x0158 -> B:162:0x0165). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:178:0x0119 -> B:126:0x016f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String unZip(String str, String str2) {
        FileInputStream fileInputStream;
        BufferedOutputStream bufferedOutputStream;
        Exception e16;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (FileNotFoundException e17) {
            LogUtils.e(e17);
            fileInputStream = null;
        }
        String str3 = "";
        if (fileInputStream != null) {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            BufferedOutputStream bufferedOutputStream2 = null;
            while (true) {
                try {
                    try {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                String name = nextEntry.getName();
                                if (!name.contains("../")) {
                                    File file = new File(str2 + name);
                                    String parent = file.getParent();
                                    if (parent != null) {
                                        File file2 = new File(parent);
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                        try {
                                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                            try {
                                                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream2, 4096);
                                                try {
                                                    byte[] bArr = new byte[4096];
                                                    while (true) {
                                                        int read = zipInputStream.read(bArr, 0, 4096);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        bufferedOutputStream3.write(bArr, 0, read);
                                                    }
                                                    bufferedOutputStream3.flush();
                                                    str3 = file.getAbsolutePath();
                                                    try {
                                                        try {
                                                            bufferedOutputStream3.close();
                                                        } catch (Exception e18) {
                                                            LogUtils.e(e18);
                                                            try {
                                                                fileOutputStream2.close();
                                                            } catch (Exception e19) {
                                                                e = e19;
                                                                LogUtils.e(e);
                                                                bufferedOutputStream2 = bufferedOutputStream3;
                                                                fileOutputStream = fileOutputStream2;
                                                            }
                                                        }
                                                        try {
                                                            fileOutputStream2.close();
                                                        } catch (Exception e26) {
                                                            e = e26;
                                                            LogUtils.e(e);
                                                            bufferedOutputStream2 = bufferedOutputStream3;
                                                            fileOutputStream = fileOutputStream2;
                                                        }
                                                        bufferedOutputStream2 = bufferedOutputStream3;
                                                        fileOutputStream = fileOutputStream2;
                                                    } catch (Throwable th5) {
                                                        try {
                                                            fileOutputStream2.close();
                                                        } catch (Exception e27) {
                                                            LogUtils.e(e27);
                                                        }
                                                        throw th5;
                                                    }
                                                } catch (Exception e28) {
                                                    e16 = e28;
                                                    bufferedOutputStream = bufferedOutputStream3;
                                                    fileOutputStream = fileOutputStream2;
                                                    try {
                                                        LogUtils.e(e16);
                                                        if (bufferedOutputStream != null) {
                                                            try {
                                                                try {
                                                                    bufferedOutputStream.close();
                                                                } catch (Exception e29) {
                                                                    LogUtils.e(e29);
                                                                    if (fileOutputStream != null) {
                                                                        try {
                                                                            fileOutputStream.close();
                                                                        } catch (Exception e36) {
                                                                            e = e36;
                                                                            LogUtils.e(e);
                                                                            bufferedOutputStream2 = bufferedOutputStream;
                                                                        }
                                                                    }
                                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                                }
                                                            } finally {
                                                            }
                                                        }
                                                        if (fileOutputStream != null) {
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (Exception e37) {
                                                                e = e37;
                                                                LogUtils.e(e);
                                                                bufferedOutputStream2 = bufferedOutputStream;
                                                            }
                                                        }
                                                        bufferedOutputStream2 = bufferedOutputStream;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        bufferedOutputStream2 = bufferedOutputStream;
                                                        if (bufferedOutputStream2 != null) {
                                                            try {
                                                                try {
                                                                    bufferedOutputStream2.close();
                                                                } finally {
                                                                }
                                                            } catch (Exception e38) {
                                                                LogUtils.e(e38);
                                                                if (fileOutputStream != null) {
                                                                    try {
                                                                        fileOutputStream.close();
                                                                    } catch (Exception e39) {
                                                                        e = e39;
                                                                        LogUtils.e(e);
                                                                        throw th;
                                                                    }
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        if (fileOutputStream != null) {
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (Exception e46) {
                                                                e = e46;
                                                                LogUtils.e(e);
                                                                throw th;
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    bufferedOutputStream2 = bufferedOutputStream3;
                                                    fileOutputStream = fileOutputStream2;
                                                    if (bufferedOutputStream2 != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Exception e47) {
                                                BufferedOutputStream bufferedOutputStream4 = bufferedOutputStream2;
                                                e16 = e47;
                                                fileOutputStream = fileOutputStream2;
                                                bufferedOutputStream = bufferedOutputStream4;
                                            } catch (Throwable th8) {
                                                th = th8;
                                            }
                                        } catch (Exception e48) {
                                            bufferedOutputStream = bufferedOutputStream2;
                                            e16 = e48;
                                        } catch (Throwable th9) {
                                            th = th9;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                try {
                                    try {
                                        break;
                                    } catch (Throwable th10) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e49) {
                                            LogUtils.e(e49);
                                        }
                                        throw th10;
                                    }
                                } catch (IOException e56) {
                                    LogUtils.e(e56);
                                    fileInputStream.close();
                                }
                            }
                        } catch (IOException e57) {
                            LogUtils.e(e57);
                        }
                    } catch (Exception e58) {
                        LogUtils.e(e58);
                        try {
                            try {
                                zipInputStream.close();
                                fileInputStream.close();
                            } catch (Throwable th11) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e59) {
                                    LogUtils.e(e59);
                                }
                                throw th11;
                            }
                        } catch (IOException e65) {
                            LogUtils.e(e65);
                            fileInputStream.close();
                        }
                    }
                } catch (Throwable th12) {
                    try {
                        try {
                            try {
                                zipInputStream.close();
                                fileInputStream.close();
                            } catch (IOException e66) {
                                LogUtils.e(e66);
                                fileInputStream.close();
                            }
                        } catch (IOException e67) {
                            LogUtils.e(e67);
                        }
                        throw th12;
                    } catch (Throwable th13) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e68) {
                            LogUtils.e(e68);
                        }
                        throw th13;
                    }
                }
            }
            zipInputStream.close();
            fileInputStream.close();
        }
        return str3;
    }

    public static String get(String str, int i3) throws IOException {
        HttpURLConnection buildConnection = buildConnection(str, i3);
        buildConnection.setRequestMethod("GET");
        return getResponse(buildConnection);
    }

    public static String post(String str, HashMap<String, String> hashMap, int i3) throws IOException {
        HttpURLConnection buildConnection = buildConnection(str, i3);
        buildConnection.setRequestMethod("POST");
        if (hashMap != null && !hashMap.isEmpty()) {
            OutputStream outputStream = buildConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            StringBuilder sb5 = new StringBuilder("");
            for (String str2 : hashMap.keySet()) {
                if (sb5.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) > 0) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb5.append(URLEncoder.encode(str2, "UTF-8"));
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(URLEncoder.encode(hashMap.get(str2), "UTF-8"));
            }
            bufferedWriter.write(sb5.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        return getResponse(buildConnection);
    }
}
