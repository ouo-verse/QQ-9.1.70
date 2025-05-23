package com.gcore.abase.hotfix;

import android.content.Context;
import android.util.Log;
import com.gcore.abase.utils.FileUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PatchManager {
    private static final String PATCH_FILE_NAME = "patch.zip";
    private static final String PATCH_INFO_FILE_NAME = "patch_info.json";
    private static final String PATCH_LIB_DIR_NAME = "lib";
    private static final String PATCH_ROOT_DIR_NAME = "GCloudPatch";
    private static final String TAG = "ABase.PatchManager";
    private static Map<String, List<SoInfo>> sPatchSoInfos = new ConcurrentHashMap();

    public static boolean copyPatch(Context context, String str, File file) {
        File file2 = new File(getPatchRootPath(context));
        if (!file2.exists() && !file2.mkdir()) {
            Log.e(TAG, "mkdir " + file2.getAbsolutePath() + "failed!");
            return false;
        }
        File file3 = new File(getPatchSDKPath(context, str));
        if (!file3.exists() && !file3.mkdir()) {
            Log.e(TAG, "mkdir " + file3.getAbsolutePath() + "failed!");
            return false;
        }
        try {
            FileUtils.copyFileUsingStream(file, new File(getPatchFilePath(context, str)));
            Log.i(TAG, " delete originalFile success!");
            return true;
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean excractSo(Context context, String str, List<SoInfo> list) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        File file = new File(getPatchLibPath(context, str));
        if (!file.exists() && !file.mkdir()) {
            Log.e(TAG, "mkdir " + file.getAbsolutePath() + "failed!");
            return false;
        }
        ZipFile zipFile = null;
        InputStream inputStream2 = null;
        zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(getPatchFilePath(context, str));
            FileOutputStream fileOutputStream2 = null;
            int i3 = 0;
            while (i3 < list.size()) {
                try {
                    String str2 = list.get(i3).name;
                    File file2 = new File(file.getAbsolutePath() + "/" + str2);
                    ZipEntry entry = zipFile2.getEntry(str2);
                    if (entry == null) {
                        Log.e(TAG, "file" + str2 + " not exist in patch file!");
                        zipFile2.close();
                        try {
                            zipFile2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        FileUtils.closeQuietly(inputStream2);
                        FileUtils.closeQuietly(fileOutputStream2);
                        return false;
                    }
                    inputStream2 = zipFile2.getInputStream(entry);
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read > 0) {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        i3++;
                        fileOutputStream2 = fileOutputStream;
                    } catch (IOException e17) {
                        e = e17;
                        inputStream = inputStream2;
                        zipFile = zipFile2;
                        try {
                            e.printStackTrace();
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            FileUtils.closeQuietly(inputStream);
                            FileUtils.closeQuietly(fileOutputStream);
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                }
                            }
                            FileUtils.closeQuietly(inputStream);
                            FileUtils.closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = inputStream2;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                        }
                        FileUtils.closeQuietly(inputStream);
                        FileUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e26) {
                    e = e26;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = fileOutputStream2;
                }
            }
            try {
                zipFile2.close();
            } catch (IOException e27) {
                e27.printStackTrace();
            }
            FileUtils.closeQuietly(inputStream2);
            FileUtils.closeQuietly(fileOutputStream2);
            return true;
        } catch (IOException e28) {
            e = e28;
            inputStream = null;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            fileOutputStream = null;
        }
    }

    public static String getPatchFilePath(Context context, String str) {
        return getPatchSDKPath(context, str) + "/" + PATCH_FILE_NAME;
    }

    public static String getPatchInfoFilePath(Context context, String str) {
        return getPatchSDKPath(context, str) + "/" + PATCH_INFO_FILE_NAME;
    }

    public static String getPatchLibPath(Context context, String str) {
        return getPatchSDKPath(context, str) + "/lib";
    }

    public static String getPatchRootPath(Context context) {
        return context.getFilesDir() + "/" + PATCH_ROOT_DIR_NAME;
    }

    public static String getPatchSDKPath(Context context, String str) {
        return getPatchRootPath(context) + "/" + str;
    }

    public static List<SoInfo> getPatchSoInfos(String str) {
        return sPatchSoInfos.get(str);
    }

    public static int getSDKPatchVersion(Context context, String str, String str2) {
        File file = new File(getPatchInfoFilePath(context, str));
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file));
                String string = jSONObject.getString(HianalyticsBaseData.SDK_NAME);
                String string2 = jSONObject.getString("sdk_version");
                if (str.equals(string) && str2.equals(string2)) {
                    return jSONObject.getInt("patch_version");
                }
                return 0;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static void setPatchSoInfos(String str, List<SoInfo> list) {
        sPatchSoInfos.put(str, list);
    }

    public static void updateSDKPatchVersion(Context context, PatchInfo patchInfo) {
        FileWriter fileWriter = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(HianalyticsBaseData.SDK_NAME, patchInfo.sdkName);
                jSONObject.put("sdk_version", patchInfo.sdkVersion);
                jSONObject.put("patch_version", patchInfo.patchVersion);
                String jSONObject2 = jSONObject.toString();
                FileWriter fileWriter2 = new FileWriter(getPatchInfoFilePath(context, patchInfo.sdkName));
                try {
                    fileWriter2.write(jSONObject2);
                    FileUtils.closeQuietly(fileWriter2);
                } catch (IOException e16) {
                    e = e16;
                    fileWriter = fileWriter2;
                    e.printStackTrace();
                    FileUtils.closeQuietly(fileWriter);
                } catch (JSONException e17) {
                    e = e17;
                    fileWriter = fileWriter2;
                    e.printStackTrace();
                    FileUtils.closeQuietly(fileWriter);
                } catch (Throwable th5) {
                    th = th5;
                    fileWriter = fileWriter2;
                    FileUtils.closeQuietly(fileWriter);
                    throw th;
                }
            } catch (IOException e18) {
                e = e18;
            } catch (JSONException e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
