package com.tencent.mobileqq.transfile.filebrowser;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FileUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int FILE_COPY_RET_ILLEGEL_PARAMETER = 1;
    public static final int FILE_COPY_RET_IOEXCEPTION = 3;
    public static final int FILE_COPY_RET_OK = 0;
    public static final int FILE_COPY_RET_SOURCE_NOT_ESIXTED = 2;
    static final String TAG = "FileUtils";

    public FileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0045 A[Catch: Exception -> 0x0048, TRY_LEAVE, TryCatch #1 {Exception -> 0x0048, blocks: (B:38:0x0040, B:31:0x0045), top: B:37:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            if (!com.tencent.mobileqq.utils.FileUtils.fileExists(str)) {
                return 2;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read > 0) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileInputStream2.close();
                                try {
                                    fileOutputStream.close();
                                    return 0;
                                } catch (IOException unused) {
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception unused2) {
                                            return 3;
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        fileOutputStream.close();
                                        return 3;
                                    }
                                    return 3;
                                }
                            }
                        }
                    } catch (IOException unused3) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                    }
                } catch (IOException unused4) {
                    fileOutputStream = null;
                }
            } catch (IOException unused5) {
                fileOutputStream = null;
            }
        } else {
            return 1;
        }
    }
}
