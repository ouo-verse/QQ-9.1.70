package com.tencent.youtu.sdkkitframework.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileUtils {
    static IPatchRedirector $redirector_ = null;
    private static String TAG = "FileUtils";
    private static Map<String, String> mLoadedLibrary;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16078);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mLoadedLibrary = new HashMap();
        }
    }

    FileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        throw new AssertionError();
    }

    public static boolean copyAsset(AssetManager assetManager, String str, String str2) {
        try {
            InputStream open = assetManager.open(str);
            new File(str2).createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            copyFile(open, fileOutputStream);
            open.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static File createFile(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(str3);
        File file = new File(sb5.toString());
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        File file2 = new File(file.getPath() + str3 + str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return file2;
    }

    public static void loadLibrary(String str) {
        if (mLoadedLibrary.get(str) == null) {
            YtLogger.i(TAG, "[YTUtils.loadLibrary] " + System.getProperty("java.library.path"));
            System.loadLibrary(str);
            mLoadedLibrary.put(str, "loaded");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static StringBuilder readAssetFile(Context context, String str) {
        IOException e16;
        Throwable th5;
        StringBuilder sb5 = new StringBuilder("");
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(str)));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (!sb5.toString().equals("")) {
                            sb5.append("\r\n");
                        }
                        sb5.append(readLine);
                    } else {
                        try {
                            bufferedReader2.close();
                            return sb5;
                        } catch (IOException e17) {
                            throw new RuntimeException("IOException occurred. ", e17);
                        }
                    }
                } catch (IOException e18) {
                    e16 = e18;
                    bufferedReader = bufferedReader2;
                    try {
                        throw new RuntimeException("IOException occurred. ", e16);
                    } catch (Throwable th6) {
                        th5 = th6;
                        th = th5;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e19) {
                                throw new RuntimeException("IOException occurred. ", e19);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    bufferedReader = bufferedReader2;
                    th = th5;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e26) {
            e16 = e26;
        } catch (Throwable th8) {
            th = th8;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static StringBuilder readFile(String str) {
        File file = new File(str);
        StringBuilder sb5 = new StringBuilder("");
        BufferedReader bufferedReader = null;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (!sb5.toString().equals("")) {
                                sb5.append("\r\n");
                            }
                            sb5.append(readLine);
                        } else {
                            try {
                                bufferedReader2.close();
                                return sb5;
                            } catch (IOException e16) {
                                throw new RuntimeException("IOException occurred. ", e16);
                            }
                        }
                    } catch (IOException e17) {
                        e = e17;
                        throw new RuntimeException("IOException occurred. ", e);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                throw new RuntimeException("IOException occurred. ", e18);
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void writeFile(File file, String str) {
        PrintWriter printWriter = null;
        try {
            try {
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                try {
                    printWriter2.println(str);
                    printWriter2.flush();
                    printWriter2.close();
                } catch (Exception e16) {
                    e = e16;
                    printWriter = printWriter2;
                    e.printStackTrace();
                    if (printWriter != null) {
                        printWriter.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
