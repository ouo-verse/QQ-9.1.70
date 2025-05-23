package com.tencent.mobileqq.app;

import android.app.Application;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes11.dex */
public class InjectUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String SUCCESS = "Success";
    private static final String TAG = "DexLoadOat";

    public InjectUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j3 += read;
            } else {
                return j3;
            }
        }
    }

    private static String extractMd5File(Application application, String str) {
        String str2;
        FileOutputStream fileOutputStream;
        Throwable th5;
        InputStream inputStream;
        File filesDir = application.getFilesDir();
        if (filesDir != null) {
            str2 = filesDir.getAbsolutePath();
        } else {
            str2 = SoLoadCore.APP_ROOT;
        }
        File file = new File(str2, str);
        try {
            inputStream = application.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    copy(inputStream, fileOutputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e("DexLoad", 2, file + " extract fails with ", th5);
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileOutputStream == null) {
                            return "Success";
                        }
                        fileOutputStream.close();
                    } finally {
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                fileOutputStream = null;
            }
        } catch (Throwable th8) {
            fileOutputStream = null;
            th5 = th8;
            inputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused3) {
            return "Success";
        }
    }

    public static String getStartupClassName(int i3) {
        String valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Foo");
        if (i3 == 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(i3 + 1);
        }
        sb5.append(valueOf);
        return sb5.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        new java.io.File(r9.getFilesDir(), r6).delete();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized String injectExtraDexManual(Application application, boolean z16) {
        String str;
        String str2;
        String str3;
        synchronized (InjectUtils.class) {
            str = "Success";
            String[] strArr = DexReleasor.sExtraDexes;
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    break;
                }
                String str4 = strArr[i3];
                String startupClassName = getStartupClassName(i3);
                str2 = strArr[i3] + ".MD5";
                if (!SoLoadCore.isLibExtracted(application.getApplicationContext(), DexReleasor.sExtraJarDexes[i3], str2)) {
                    str = null;
                    if (z16) {
                        break;
                    }
                    if (SoLoadCore.releaseDexFromApk(application.getApplicationContext(), str4)) {
                        str = extractMd5File(application, str2);
                    }
                }
                if ("Success".equals(str)) {
                    File filesDir = application.getFilesDir();
                    if (filesDir != null) {
                        str3 = filesDir.getAbsolutePath();
                    } else {
                        str3 = SoLoadCore.APP_ROOT;
                    }
                    str = dd.g(application, new File(str3, DexReleasor.sExtraJarDexes[i3]).getAbsolutePath(), startupClassName, true);
                }
                QLog.e(TAG, 1, str);
                if ("Success".equals(str)) {
                    i3++;
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return str;
        try {
            new File(application.getFilesDir(), str2).delete();
        } catch (Exception unused2) {
        }
    }

    public static synchronized String injectExtraDexes(Application application, boolean z16) {
        synchronized (InjectUtils.class) {
        }
        return "Success";
    }
}
