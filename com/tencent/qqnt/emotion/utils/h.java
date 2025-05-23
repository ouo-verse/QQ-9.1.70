package com.tencent.qqnt.emotion.utils;

import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f356687a;

    /* renamed from: b, reason: collision with root package name */
    private static String f356688b;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Component/emotionpanel/Inject_AppSetting.yml", version = 1)
    static com.tencent.mobileqq.inject.b f356689c;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f356690d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f356690d = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        f356687a = b() + "/Tencent/MobileNT/";
    }

    static void a() {
        if (f356689c == null) {
            c();
        }
    }

    public static final String b() {
        File externalCacheDir;
        if (f356688b == null && (externalCacheDir = BaseApplication.getContext().getExternalCacheDir()) != null) {
            f356688b = externalCacheDir.getParent();
        }
        return f356688b;
    }

    @QAutoInitMethod
    static void c() {
        f356689c = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f356690d);
    }

    public static String d(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (Exception e16) {
            QLog.e("EmotionFileUtil", 2, XWalkReaderBasePlugin.READ_METHOD_NAME, e16);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        com.tencent.qphone.base.util.QLog.e("EmotionFileUtil", 2, "readFileContent", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        byte[] buf;
        String str = null;
        try {
            a();
            if (f356689c.isDebugVersion() && file.length() >= TTL.MAX_VALUE) {
                throw new IOException("readFileContent file too large");
            }
            int length = (int) file.length();
            byteArrayOutputStream = new ByteArrayOutputStream(length);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable unused) {
                bufferedInputStream = null;
            }
            try {
                try {
                    buf = ByteArrayPool.getGenericInstance().getBuf(12288);
                } catch (OutOfMemoryError unused2) {
                    buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                }
                int i3 = 0;
                while (i3 < length) {
                    int read = bufferedInputStream.read(buf);
                    byteArrayOutputStream.write(buf, 0, read);
                    i3 += read;
                }
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                str = byteArrayOutputStream.toString("utf-8");
                try {
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                } catch (IOException e16) {
                    e = e16;
                }
            } catch (Throwable unused3) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                    }
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return str;
            }
        } catch (Throwable unused4) {
            byteArrayOutputStream = null;
            bufferedInputStream = null;
        }
        return str;
    }

    public static String f(String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = BaseApplication.getContext().getAssets().open(str);
                String d16 = d(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return d16;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("EmotionFileUtil", 2, "readStringFromAsset", e16);
                            return d16;
                        }
                        return d16;
                    }
                }
                return d16;
            } catch (IOException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("EmotionFileUtil", 2, "readStringFromAsset", e17);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            QLog.e("EmotionFileUtil", 2, "readStringFromAsset", e18);
                        }
                    }
                }
                return "";
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e("EmotionFileUtil", 2, "readStringFromAsset", e19);
                    }
                }
            }
            throw th5;
        }
    }
}
