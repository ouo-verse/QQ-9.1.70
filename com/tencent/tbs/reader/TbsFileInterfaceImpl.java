package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.reader.external.ITbsReaderAtom;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import re4.b;
import re4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TbsFileInterfaceImpl {
    public static final int FILE_COMPONENT_VERSION = 5070080;
    public static int FILE_READER_WINDOW_TYPE_DEFAULT = 0;
    public static int FILE_READER_WINDOW_TYPE_VIEW = 2;
    private static final String TAG = "TbsFileInterfaceImpl";
    public static boolean USE_INNER_PLUGIN = false;
    private static volatile TbsFileInterfaceImpl instance = null;
    public static boolean pluginCopy = false;
    TbsReaderManager mReaderManager;

    TbsFileInterfaceImpl() {
        this.mReaderManager = null;
        this.mReaderManager = new TbsReaderManager();
    }

    public static boolean canOpenFileExt(String str) {
        return ReaderEngine.getInstance().isSupportExt(3, str);
    }

    public static void cleanAllFileRecord(Context context) {
        ReaderEngine.getInstance().cleanAllFileRecord(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyAssetToFile(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                File file = new File(str2);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    open.close();
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e17) {
                        e17.printStackTrace();
                        return true;
                    }
                } catch (IOException e18) {
                    e = e18;
                    inputStream = open;
                    try {
                        b.c(TAG, "copyAssetToFile: ", e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e28) {
                                e28.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = open;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } catch (IOException e29) {
                e = e29;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (IOException e36) {
            e = e36;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public static boolean fileEnginePreCheck(Context context) {
        return ReaderEngine.getInstance().fileEnginePreCheck(context);
    }

    public static boolean fileEnginePreLoad(Context context, TBSOneCallback tBSOneCallback, boolean z16) {
        return ReaderEngine.getInstance().fileEnginePreLoad(context, tBSOneCallback, z16);
    }

    public static TbsFileInterfaceImpl getInstance() {
        if (instance == null) {
            synchronized (TbsFileInterfaceImpl.class) {
                if (instance == null) {
                    instance = new TbsFileInterfaceImpl();
                }
            }
        }
        return instance;
    }

    public static String getLicenseToken() {
        return ReaderEngine.getInstance().getLicenseToken();
    }

    public static int getVersionCode() {
        return ReaderEngine.getInstance().getVersionCode();
    }

    public static String getVersionName() {
        return ReaderEngine.getInstance().getVersionName();
    }

    public static int initEngine(Context context) {
        b.d(TAG, "initEngine: USE_INNER_PLUGIN=" + USE_INNER_PLUGIN);
        if (USE_INNER_PLUGIN && !pluginCopy) {
            File file = new File(context.getDir("tbs", 0), "home/default/components/file/5070080/file_dex.jar");
            File file2 = new File(context.getDir("tbs", 0), "home/default/components/file/5070080/flag_no_inner.txt");
            if (file.exists() && !file2.exists()) {
                b.d(TAG, "initEngine: \u63d2\u4ef6jar\u5b58\u5728\uff0c\u5c1d\u8bd5\u4f7f\u7528\u672c\u5730asset\u8d44\u6e90");
                boolean copyAssetToFile = copyAssetToFile(context, "file_dex.jar", file.getAbsolutePath());
                pluginCopy = true;
                b.d(TAG, "initEngine: \u4f7f\u7528\u5185\u7f6ecomponents \u7ed3\u679c" + copyAssetToFile);
                b.d(TAG, "initEngine: \u4f7f\u7528\u5185\u7f6ecomponents resource \u7ed3\u679c" + copyAssetToFile(context, "file_resource.apk", new File(context.getDir("tbs", 0), "home/default/components/file/5070080/file_resource.apk").getAbsolutePath()));
            } else {
                b.d(TAG, "initEngine: \u63d2\u4ef6jar\u4e0d\u5b58\u5728\uff0c\u8d70\u7ebf\u4e0a\u63d2\u4ef6\u52a0\u8f7d flagExist:" + file2.exists());
            }
        }
        return ReaderEngine.getInstance().initReaderEntry(context);
    }

    public static void initEngineAsync(Context context, ITbsReaderCallback iTbsReaderCallback) {
        ReaderEngine.getInstance().initReaderEntryAsync(context, iTbsReaderCallback);
    }

    public static boolean isEngineLoaded() {
        return ReaderEngine.getInstance().isEngineLoaded();
    }

    public static boolean isLicenseUpdateNeeded() {
        return ReaderEngine.getInstance().isLicenseUpdateNeeded();
    }

    public static void loadLibsInNativeLibraryDir(Context context, LinkedHashSet<String> linkedHashSet) {
        ReaderEngine.getInstance().loadLibsInNativeLibraryDir(context, linkedHashSet);
    }

    public static void saveLicense(String str) {
        ReaderEngine.getInstance().saveLicense(str);
    }

    public static void setConfigSetting(String str, Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, obj);
        ReaderEngine.getInstance().setConfigSetting(linkedHashMap);
    }

    public static void setInstallPolicy(String str) {
        ReaderEngine.getInstance().setInstallPolicy(str);
    }

    public static void setLicense(String str) {
        setConfigSetting("license", str);
    }

    public static void setLicenseKey(String str) {
        setConfigSetting("license_key", str);
    }

    public static void setLoggingHandler(Context context, c cVar) {
        ReaderEngine.getInstance().setLoggingHandler(context, cVar);
    }

    public static void setPrivateLicenseKey(String str) {
        setConfigSetting("private_license_key", str);
    }

    public static void setProviderSetting(String str) {
        setConfigSetting("provider_classname", str);
    }

    public void closeFileReader() {
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager != null) {
            tbsReaderManager.destroy();
        }
    }

    public ITbsReaderAtom createAtom(int i3) {
        if (this.mReaderManager.getTbsReader() != null) {
            return (ITbsReaderAtom) this.mReaderManager.getTbsReader().createAtom(i3);
        }
        return null;
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager != null) {
            tbsReaderManager.doAction(num, obj, obj2);
        }
    }

    public TbsReaderManager getReaderManager() {
        return this.mReaderManager;
    }

    public void gotoPosition(Bundle bundle) {
        int i3 = bundle.getInt("progress", -1);
        int i16 = bundle.getInt("page", -1);
        Bundle bundle2 = new Bundle();
        if (i3 != -1) {
            bundle2.putInt("progress", i3);
            bundle2.putBoolean("jumppage", true);
        } else if (i16 != -1) {
            bundle2.putInt("page", i16);
        }
        doCommand(307, bundle2, null);
    }

    public boolean initReader(Context context, ITbsReaderCallback iTbsReaderCallback) {
        return this.mReaderManager.initReader(context, iTbsReaderCallback);
    }

    public void onSizeChanged(int i3, int i16) {
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager != null) {
            tbsReaderManager.onSizeChanged(Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public int openFileReader(Context context, Bundle bundle, ITbsReaderCallback iTbsReaderCallback, FrameLayout frameLayout) {
        if (initReader(context, iTbsReaderCallback)) {
            return this.mReaderManager.openFileReader(context, bundle, iTbsReaderCallback, frameLayout);
        }
        return -1;
    }

    public int openToolPage(Context context, Bundle bundle, ITbsReaderCallback iTbsReaderCallback, FrameLayout frameLayout) {
        return 0;
    }

    public void pluginPreLoad(Context context, String str) {
        this.mReaderManager.getPluginPre(context).downloadPlugin(context, str);
    }

    public void setReaderManager(TbsReaderManager tbsReaderManager) {
        this.mReaderManager = tbsReaderManager;
        if (tbsReaderManager == null) {
            this.mReaderManager = new TbsReaderManager();
        }
    }

    public static void setLoggingHandler(Context context, c cVar, re4.a aVar) {
        ReaderEngine.getInstance().setLoggingHandler(context, cVar, aVar);
    }
}
