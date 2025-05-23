package com.tencent.mobileqq.minicode;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes15.dex */
public class Utils {
    static IPatchRedirector $redirector_;

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkResIsOK(Context context, String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("checkResIsOK", "exception !!!!!!!!!!!!", e16);
        }
        try {
            String str3 = str + str2;
            if (!new File(str3).exists()) {
                copyFileFromAssets(context, str2, str3);
            }
        } catch (Exception e17) {
            Log.i("checkResIsOK", "exception !!!!!!!!!!!!", e17);
            e17.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005e A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #4 {Exception -> 0x005a, blocks: (B:39:0x0056, B:32:0x005e), top: B:38:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void copyFileFromAssets(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream open;
        InputStream inputStream = null;
        try {
            try {
                open = context.getAssets().open(str);
                try {
                    fileOutputStream = new FileOutputStream(new File(str2));
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        open.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                inputStream = open;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                inputStream = open;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e26) {
            e26.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
    
        if (r2 == null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readModelFile(String str) {
        FileInputStream fileInputStream;
        Exception e16;
        BufferedReader bufferedReader;
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e17) {
            fileInputStream = null;
            e16 = e17;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb5.append(readLine + '\n');
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileInputStream == null) {
                            try {
                                fileInputStream.close();
                                throw th;
                            } catch (IOException unused3) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e16 = e18;
                    e16.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e19) {
            e16 = e19;
            bufferedReader = null;
        } catch (Throwable th7) {
            th = th7;
            if (bufferedReader2 != null) {
            }
            if (fileInputStream == null) {
            }
        }
        try {
            fileInputStream.close();
        } catch (IOException unused5) {
            return sb5.toString();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0050 -> B:20:0x0068). Please report as a decompilation issue!!! */
    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        File file = new File(str);
        boolean z17 = false;
        try {
            File file2 = new File(str.substring(0, str.lastIndexOf("/")));
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } catch (Exception unused) {
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e16) {
                QLog.e("Utils", 1, "create new bitmap file exception ", e16);
            }
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        z17 = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                        bufferedOutputStream2.flush();
                        if (z16) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (Exception e17) {
                        e = e17;
                        bufferedOutputStream = bufferedOutputStream2;
                        QLog.e("Utils", 1, "saveBitmapToFile exception", e);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return z17;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e19) {
                e = e19;
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
        return z17;
    }
}
