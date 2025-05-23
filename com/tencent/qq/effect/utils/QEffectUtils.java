package com.tencent.qq.effect.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.engine.QEffectType;
import com.tencent.qq.effect.sensor.SensorParams;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QEffectUtils {
    static IPatchRedirector $redirector_;

    public QEffectUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean fileIsExists(String str) {
        try {
            if (!new File(str).exists()) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0078 A[Catch: IOException -> 0x0074, TRY_LEAVE, TryCatch #3 {IOException -> 0x0074, blocks: (B:42:0x0070, B:35:0x0078), top: B:41:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAssetsFiles(Context context, String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        byte[] bArr;
        String str2 = context.getFilesDir() + "/" + str;
        if (!fileIsExists(str2)) {
            InputStream inputStream2 = null;
            try {
                inputStream = context.getAssets().open(str);
                try {
                    bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    fileOutputStream = context.openFileOutput(str, 0);
                } catch (IOException e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    try {
                        inputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
                e.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                        return null;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            }
        }
        return str2;
    }

    public static int getFileLoadType(String str) {
        if (isEmpty(str)) {
            return 0;
        }
        if (!str.contains("http://") && !str.contains("https://")) {
            return 1;
        }
        return 2;
    }

    public static String getFileType(String str) {
        if (str.contains(QEffectType.APNG_TAG)) {
            return QEffectType.APNG_TAG;
        }
        if (str.contains(QEffectType.VIDEO_ALPHA_TAG)) {
            return QEffectType.VIDEO_ALPHA_TAG;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static float getMaxValue(int i3, int i16, int i17, int[] iArr, boolean z16) {
        if (z16) {
            iArr[0] = i16 - i3;
        } else if (Math.abs(i16 - iArr[0]) > i17) {
            if (i16 - iArr[0] < 0) {
                iArr[0] = i16 + i17;
                i3 = -i17;
            } else {
                iArr[0] = i16 - i17;
                i3 = i17;
            }
        } else {
            i3 = i16 - iArr[0];
        }
        return i3;
    }

    public static File getRealFileName(String str, String str2) {
        String[] split = str2.split("/");
        File file = new File(str);
        if (split.length > 1) {
            int i3 = 0;
            while (i3 < split.length - 1) {
                String str3 = split[i3];
                try {
                    str3 = new String(str3.getBytes("8859_1"), "GB2312");
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
                i3++;
                file = new File(file, str3);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            String str4 = split[split.length - 1];
            try {
                str4 = new String(str4.getBytes("8859_1"), "GB2312");
            } catch (UnsupportedEncodingException e17) {
                e17.printStackTrace();
            }
            return new File(file, str4);
        }
        return new File(file, str2);
    }

    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static String loadShaderFile(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                File file = new File(str);
                if (!file.isDirectory() && file.exists()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        StringBuilder sb5 = new StringBuilder();
                        try {
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e16) {
                                            Log.e("loadShaderFile", "instream.close error=" + e16.toString());
                                        }
                                    }
                                }
                                fileInputStream.close();
                                return sb5.toString();
                            } catch (Throwable th5) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e17) {
                                    Log.e("loadShaderFile", "instream.close error=" + e17.toString());
                                }
                                throw th5;
                            }
                        } catch (IOException e18) {
                            Log.e("loadShaderFile", "read file buffer error=" + e18.toString());
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                Log.e("loadShaderFile", "instream.close error=" + e19.toString());
                            }
                            return null;
                        }
                    } catch (FileNotFoundException e26) {
                        Log.e("loadShaderFile", "new FileInputStream error=" + e26.toString());
                        return null;
                    }
                }
                Log.e("loadShaderFile", "file.isDirectory()=" + file.isDirectory() + ", file.exists()=" + file.exists());
                return null;
            } catch (NullPointerException e27) {
                Log.e("loadShaderFile", "new File error=" + e27.toString());
            }
        }
        return null;
    }

    public static String readFile(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (IOException e16) {
                        e = e16;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        return stringBuffer.toString();
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (IOException e19) {
                e = e19;
            }
            return stringBuffer.toString();
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void upZipFile(File file, String str) throws IOException {
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        byte[] bArr = new byte[1024];
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName() != null && !nextElement.getName().contains("../")) {
                if (nextElement.isDirectory()) {
                    new File(new String((str + nextElement.getName()).getBytes("8859_1"), "GB2312")).mkdir();
                } else if (!getRealFileName(str, nextElement.getName()).exists()) {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getRealFileName(str, nextElement.getName())));
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                }
            }
        }
        zipFile.close();
    }

    public static void updateGravityData(View view, float[] fArr, SensorParams sensorParams, boolean z16) {
        if (sensorParams != null) {
            float f16 = fArr[0] * sensorParams.layerOffsetX;
            float f17 = sensorParams.speed;
            int i3 = (int) (f16 * f17);
            int i16 = (int) (fArr[1] * sensorParams.layerOffsetY * f17);
            if (!sensorParams.isInit) {
                sensorParams.isInit = true;
                sensorParams.offsetX[0] = i3;
                sensorParams.offsetY[0] = i16;
            } else {
                view.setTranslationX(getMaxValue((int) view.getTranslationX(), i3, Math.abs(sensorParams.layerOffsetX), sensorParams.offsetX, z16));
                view.setTranslationY(getMaxValue((int) view.getTranslationY(), i16, Math.abs(sensorParams.layerOffsetY), sensorParams.offsetY, z16));
            }
        }
    }
}
