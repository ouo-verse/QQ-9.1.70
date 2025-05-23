package com.gcloudsdk.apollo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloVoiceConfig {
    private static String VPbinName = "GCloudVoice/cldnn_spkvector.mnn";
    private static String VPbinPath = "/cldnn_spkvector.mnn";
    private static String VPbinSourcePath = null;
    private static String binName = "GCloudVoice/libwxvoiceembed.bin";
    private static String binPath = "/libwxvoiceembed.bin";
    private static String binSourcePath = null;
    private static final String cfgName = "GCloudVoice/config.json";
    private static String dafxBinName = "GCloudVoice/wave_dafx_data.bin";
    private static String dafxBinPath = "/wave_dafx_data.bin";
    private static String dafxBinSourcePath = null;
    private static String dyCfgPath = "/com.gcloudsdk.gcloud.gvoice/config/gvoice.cfg";
    private static Context mainContext = null;
    private static String nsBinName = "GCloudVoice/libgvoicensmodel.bin";
    private static String nsBinPath = "/libgvoicensmodel.bin";
    private static String nsBinSourcePath = null;
    private static String storageCfgPath = null;
    private static String tdBinName = "GCloudVoice/wave_3d_data.bin";
    private static String tdBinPath = "/wave_3d_data.bin";
    private static String tdBinSourcePath;

    public static String ConfigFromManifest(String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        String str2 = "invalied";
        if (str != null && str.trim().length() != 0) {
            try {
                applicationInfo = mainContext.getPackageManager().getApplicationInfo(mainContext.getPackageName(), 128);
            } catch (Exception e16) {
                ApolloVoiceLog.LogE("getApplicationInfo meets errors");
                e16.printStackTrace();
            }
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                str2 = bundle.getString(str);
                ApolloVoiceLog.LogI("configItem: " + str + " configValue: " + str2);
            }
            ApolloVoiceLog.LogE("appInfo or appInfo.metaData is null");
            return "invalied";
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Copy3DSourceToDest(String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            try {
                InputStream open = mainContext.getResources().getAssets().open(tdBinName);
                try {
                    tdBinSourcePath = str + tdBinPath;
                    File file = new File(tdBinSourcePath);
                    if (!file.exists() || file.length() == 0) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = open.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e16) {
                            e = e16;
                            inputStream = open;
                            try {
                                e.printStackTrace();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
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
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e26) {
                            e26.printStackTrace();
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (Exception e28) {
                e = e28;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void CopyDafxSourceToDest(String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            try {
                InputStream open = mainContext.getResources().getAssets().open(dafxBinName);
                try {
                    dafxBinSourcePath = str + dafxBinPath;
                    File file = new File(dafxBinSourcePath);
                    if (!file.exists() || file.length() == 0) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = open.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e16) {
                            e = e16;
                            inputStream = open;
                            try {
                                e.printStackTrace();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
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
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e26) {
                            e26.printStackTrace();
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (Exception e28) {
                e = e28;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0074 -> B:17:0x0077). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void CopyNsSourceToDest(String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            try {
                InputStream open = mainContext.getResources().getAssets().open(nsBinName);
                try {
                    nsBinSourcePath = str + nsBinPath;
                    fileOutputStream = new FileOutputStream(new File(nsBinSourcePath));
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = open.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileOutputStream.flush();
                        try {
                            open.close();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        fileOutputStream.close();
                    } catch (Exception e17) {
                        e = e17;
                        inputStream = open;
                        try {
                            e.printStackTrace();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e19) {
                                    e19.printStackTrace();
                                }
                            }
                            if (fileOutputStream == null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (Exception e26) {
                                    e26.printStackTrace();
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
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (Exception e28) {
                e = e28;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void CopySourceToDest(String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            try {
                InputStream open = mainContext.getResources().getAssets().open(binName);
                try {
                    binSourcePath = str + binPath;
                    File file = new File(binSourcePath);
                    if (!file.exists() || file.length() == 0) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = open.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e16) {
                            e = e16;
                            inputStream = open;
                            try {
                                e.printStackTrace();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
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
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e26) {
                            e26.printStackTrace();
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (Exception e28) {
                e = e28;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void CopyVPSourceToDest(String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            try {
                InputStream open = mainContext.getResources().getAssets().open(VPbinName);
                try {
                    VPbinSourcePath = str + VPbinPath;
                    File file = new File(VPbinSourcePath);
                    if (!file.exists() || file.length() == 0) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = open.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e16) {
                            e = e16;
                            inputStream = open;
                            try {
                                e.printStackTrace();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
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
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e26) {
                            e26.printStackTrace();
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (Exception e28) {
                e = e28;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
    }

    public static String DynamicCfgPath() {
        String str = "invalied";
        try {
            File filesDir = mainContext.getFilesDir();
            if (filesDir != null) {
                str = filesDir.toString() + dyCfgPath;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        ApolloVoiceLog.LogI("Read Dynamic: " + str);
        return str;
    }

    public static String Get3DSourcePath() {
        return tdBinSourcePath;
    }

    public static String GetDafxSourcePath() {
        return dafxBinSourcePath;
    }

    public static String GetNsSourcePath() {
        return nsBinSourcePath;
    }

    public static String GetSourcePath() {
        return binSourcePath;
    }

    public static String GetVPSourcePath() {
        return VPbinSourcePath;
    }

    public static boolean IsSDCardCfgExist() {
        return new File(storageCfgPath).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String JSONCfg(boolean z16) {
        Throwable th5;
        try {
            try {
                try {
                    if (z16 != 0) {
                        FileInputStream fileInputStream = new FileInputStream(storageCfgPath);
                        ApolloVoiceLog.LogI("Read config file from storage: " + storageCfgPath);
                        z16 = fileInputStream;
                    } else {
                        InputStream open = mainContext.getResources().getAssets().open(cfgName);
                        ApolloVoiceLog.LogI("Read config file from: GCloudVoice/config.json");
                        z16 = open;
                    }
                    int available = z16.available();
                    byte[] bArr = new byte[available];
                    int i3 = 0;
                    while (i3 < available) {
                        int read = z16.read(bArr, i3, available - i3);
                        if (read == -1) {
                            break;
                        }
                        i3 += read;
                    }
                    String str = new String(bArr, "UTF-8");
                    try {
                        z16.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    return str;
                } catch (Exception e17) {
                    e = e17;
                    z16 = 0;
                    e.printStackTrace();
                    if (z16 != 0) {
                    }
                    return null;
                } catch (Throwable th6) {
                    th5 = th6;
                    z16 = 0;
                    if (z16 != 0) {
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                if (z16 != 0) {
                    try {
                        z16.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (z16 != 0) {
                try {
                    z16.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public static void SetContext(Context context) {
        mainContext = context;
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            storageCfgPath = externalFilesDir.getAbsolutePath() + "/" + cfgName;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("storageCfgPath: ");
            sb5.append(storageCfgPath);
            ApolloVoiceLog.LogI(sb5.toString());
            return;
        }
        ApolloVoiceLog.LogI("getExternalFilesDir failed !!!");
    }
}
