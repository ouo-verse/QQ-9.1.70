package com.tencent.util;

import android.content.Context;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ZipUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int BUFFER = 4096;

    public ZipUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void unzip4Asset(Context context, String str, String str2) throws RuntimeException {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        QZipInputStream qZipInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        QZipInputStream qZipInputStream2 = null;
        try {
            try {
                File[] listFiles = new File(str2).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
                QZipInputStream qZipInputStream3 = new QZipInputStream(new BufferedInputStream(context.getAssets().open(str)));
                BufferedOutputStream bufferedOutputStream = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = qZipInputStream3.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            String name = nextEntry.getName();
                            if (name != null && name.contains("../")) {
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                            } else {
                                File file2 = new File(str2 + name);
                                File file3 = new File(file2.getParent());
                                if (!file3.exists()) {
                                    file3.mkdirs();
                                }
                                fileOutputStream = new FileOutputStream(file2);
                                try {
                                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream, 4096);
                                    while (true) {
                                        try {
                                            int read = qZipInputStream3.read(bArr, 0, 4096);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                bufferedOutputStream2.write(bArr, 0, read);
                                            }
                                        } catch (Exception unused2) {
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (IOException unused3) {
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        } catch (Throwable th5) {
                                            fileOutputStream2 = fileOutputStream;
                                            th = th5;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (IOException unused4) {
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                    throw th;
                                                } catch (IOException unused5) {
                                                    throw th;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    bufferedOutputStream2.flush();
                                    fileOutputStream.flush();
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (IOException unused6) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused7) {
                                    }
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Exception unused8) {
                                } catch (Throwable th6) {
                                    fileOutputStream2 = fileOutputStream;
                                    th = th6;
                                }
                            }
                        } catch (Exception unused9) {
                            fileOutputStream = null;
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Exception unused10) {
                        qZipInputStream2 = qZipInputStream3;
                        if (qZipInputStream2 != null) {
                            qZipInputStream2.close();
                        }
                        return;
                    } catch (Throwable th8) {
                        th = th8;
                        qZipInputStream = qZipInputStream3;
                        if (qZipInputStream != null) {
                            try {
                                qZipInputStream.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                qZipInputStream3.close();
            } catch (Exception unused11) {
            } catch (Throwable th9) {
                th = th9;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }
}
