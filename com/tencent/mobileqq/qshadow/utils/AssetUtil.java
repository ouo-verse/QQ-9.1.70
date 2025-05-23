package com.tencent.mobileqq.qshadow.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AssetUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String SEPARATOR;
    private static final String TAG = "FileHelper";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            SEPARATOR = File.separator;
        }
    }

    AssetUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void copyFilesFromAssets(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        String substring = str.substring(str.lastIndexOf(File.separator));
        AssetManager assets = context.getAssets();
        try {
            File file = new File(str2);
            if (!file.exists() && !file.mkdirs()) {
                Log.i(TAG, "create file error! file: " + file.getAbsolutePath());
            }
            readInputStream(str2 + SEPARATOR + substring, assets.open(str));
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public static boolean isFileExists(Context context, String str) {
        try {
            context.getAssets().open(str).close();
            return true;
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void readInputStream(String str, InputStream inputStream) {
        Throwable th5;
        FileOutputStream fileOutputStream;
        IOException e16;
        FileNotFoundException e17;
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    file.delete();
                    if (!file.exists()) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (FileNotFoundException e18) {
                            e17 = e18;
                            e17.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return;
                        } catch (IOException e26) {
                            e16 = e26;
                            e16.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e29) {
                    fileOutputStream = null;
                    e17 = e29;
                } catch (IOException e36) {
                    fileOutputStream = null;
                    e16 = e36;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    if (inputStream == null) {
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e37) {
                        e37.printStackTrace();
                    }
                }
                if (inputStream == null) {
                    try {
                        inputStream.close();
                        throw th5;
                    } catch (IOException e38) {
                        e38.printStackTrace();
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (IOException e39) {
            e39.printStackTrace();
        }
    }
}
