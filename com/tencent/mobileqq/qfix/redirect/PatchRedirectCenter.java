package com.tencent.mobileqq.qfix.redirect;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.commonutils.classloader.SystemClassLoaderInjector;
import com.tencent.mobileqq.commonutils.zip.QZipFile;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;

@Keep
/* loaded from: classes16.dex */
public class PatchRedirectCenter {
    public static final int CODE_CONFIG_ERROR = 1;
    public static final int CODE_DEX_INJECT_ERROR = 3;
    public static final int CODE_INIT_PATCH_CLASS_ERROR = 2;
    public static final int CODE_SUCCESS = 0;
    private static final String CONFIG_FILE = "config.txt";
    private static final String PATCH_CLASS_SUFFIX = "$qfix_";
    private static final String REDIRECTOR_FIELD_NAME = "$redirector_";
    private static final String TAG = "PatchRedirectCenter";
    private static final String TRUE = "1";
    private static boolean applied;
    private static final List<String> injectedDexPath = new ArrayList();
    private static SparseArray<IPatchRedirector> redirectors = new SparseArray<>();

    public static synchronized int apply(Context context, String str, String str2) {
        String str3;
        String concat;
        SparseArray<IPatchRedirector> sparseArray;
        SparseArray<IPatchRedirector> sparseArray2;
        synchronized (PatchRedirectCenter.class) {
            List<String> list = injectedDexPath;
            if (!list.contains(str)) {
                if (!TextUtils.equals(SystemClassLoaderInjector.inject(context, str, null, false), "Success")) {
                    Log.e(TAG, "apply inject dex fail!");
                    return 3;
                }
                list.add(str);
                str3 = TAG;
                concat = "apply inject dex success. patchPath=".concat(String.valueOf(str));
            } else {
                str3 = TAG;
                concat = "apply dex already injected. patchPath=".concat(String.valueOf(str));
            }
            Log.i(str3, concat);
            int i3 = 1;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    applied = false;
                                    redirectors = loadPatchClasses(str2);
                                    applied = true;
                                    Log.i(TAG, "apply patch success!");
                                    return 0;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    if (!applied) {
                                        sparseArray2 = redirectors;
                                        sparseArray2.clear();
                                    }
                                    Log.e(TAG, "apply patch fail! ret=".concat(String.valueOf(i3)));
                                    return i3;
                                } catch (InstantiationException e17) {
                                    e17.printStackTrace();
                                    if (!applied) {
                                        sparseArray = redirectors;
                                        sparseArray.clear();
                                    }
                                    i3 = 2;
                                    Log.e(TAG, "apply patch fail! ret=".concat(String.valueOf(i3)));
                                    return i3;
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                                if (!applied) {
                                    sparseArray = redirectors;
                                    sparseArray.clear();
                                }
                                i3 = 2;
                                Log.e(TAG, "apply patch fail! ret=".concat(String.valueOf(i3)));
                                return i3;
                            }
                        } catch (IllegalAccessException e18) {
                            e18.printStackTrace();
                            if (!applied) {
                                sparseArray = redirectors;
                                sparseArray.clear();
                            }
                            i3 = 2;
                            Log.e(TAG, "apply patch fail! ret=".concat(String.valueOf(i3)));
                            return i3;
                        }
                    } catch (FileNotFoundException e19) {
                        e19.printStackTrace();
                        if (!applied) {
                            sparseArray2 = redirectors;
                            sparseArray2.clear();
                        }
                        Log.e(TAG, "apply patch fail! ret=".concat(String.valueOf(i3)));
                        return i3;
                    }
                } catch (ClassNotFoundException e26) {
                    e26.printStackTrace();
                    if (!applied) {
                        sparseArray = redirectors;
                        sparseArray.clear();
                    }
                    i3 = 2;
                    Log.e(TAG, "apply patch fail! ret=".concat(String.valueOf(i3)));
                    return i3;
                }
            } finally {
                if (!applied) {
                    redirectors.clear();
                }
            }
        }
    }

    public static void copy(InputStream inputStream, File file) {
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
                inputStream.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException e19) {
                        e19.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static IPatchRedirector fakeGetRedirector(int i3) {
        return null;
    }

    public static IPatchRedirector getRedirector(int i3) {
        if (applied) {
            return redirectors.get(i3);
        }
        return null;
    }

    @NonNull
    private static SparseArray<IPatchRedirector> loadPatchClasses(String str) {
        SparseArray<IPatchRedirector> sparseArray = new SparseArray<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split(" ");
                if (split.length < 3 || !"1".equals(split[2])) {
                    boolean z16 = true;
                    int parseInt = Integer.parseInt(split[1]);
                    if (parseInt != 0) {
                        Object newInstance = Class.forName(split[0]).newInstance();
                        if (split.length > 2) {
                            z16 = Boolean.parseBoolean(split[2]);
                        }
                        if (z16) {
                            sparseArray.put(parseInt, (IPatchRedirector) newInstance);
                        } else {
                            Log.d(TAG, "inject: ".concat(String.valueOf(newInstance)));
                            ReflectUtils.setStaticField(newInstance, split[0].substring(0, r2.length() - 6), REDIRECTOR_FIELD_NAME);
                        }
                        Log.d(TAG, "apply patch class: ".concat(readLine));
                    }
                }
            } else {
                return sparseArray;
            }
        }
    }

    public static void unApply() {
        applied = false;
        redirectors = new SparseArray<>();
        Log.i(TAG, "unApply patch success!");
    }

    public static void unzipConfig(String str, String str2) {
        QZipFile qZipFile = null;
        try {
            QZipFile qZipFile2 = new QZipFile(str);
            try {
                ZipEntry entry = qZipFile2.getEntry("config.txt");
                if (entry != null) {
                    Log.d(TAG, "pre-unzip patch config files..");
                    copy(qZipFile2.getInputStream(entry), new File(str2, "config.txt"));
                }
                try {
                    qZipFile2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            } catch (Throwable th5) {
                th = th5;
                qZipFile = qZipFile2;
                try {
                    th.printStackTrace();
                    if (qZipFile != null) {
                        try {
                            qZipFile.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (Throwable th6) {
                    if (qZipFile != null) {
                        try {
                            qZipFile.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static IPatchRedirector fakeGetRedirector(int i3, short s16) {
        return null;
    }

    public static IPatchRedirector getRedirector(int i3, short s16) {
        IPatchRedirector iPatchRedirector;
        if (applied && (iPatchRedirector = redirectors.get(i3)) != null && iPatchRedirector.hasPatch(s16)) {
            return iPatchRedirector;
        }
        return null;
    }
}
