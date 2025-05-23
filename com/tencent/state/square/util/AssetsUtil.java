package com.tencent.state.square.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/util/AssetsUtil;", "", "()V", "TAG", "", "copyAssetDirsToSdcard", "", "context", "Landroid/content/Context;", "assetDir", "destDir", "copyAssetToFile", "assetFileName", "destFileName", "copyFilesFromAssets", "", "assetsPath", "savePath", "getAssetsFileData", "filePath", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class AssetsUtil {

    @NotNull
    public static final AssetsUtil INSTANCE = new AssetsUtil();

    @NotNull
    public static final String TAG = "AssetsUtil";

    AssetsUtil() {
    }

    public final boolean copyAssetDirsToSdcard(@Nullable Context context, @NotNull String assetDir, @NotNull String destDir) {
        Intrinsics.checkNotNullParameter(assetDir, "assetDir");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        if (context != null && !TextUtils.isEmpty(assetDir) && !TextUtils.isEmpty(destDir)) {
            try {
                AssetManager assets = context.getAssets();
                String[] list = assets.list(assetDir);
                Intrinsics.checkNotNull(list);
                for (String str : list) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(assetDir);
                    String str2 = File.separator;
                    sb5.append(str2);
                    sb5.append(str);
                    String sb6 = sb5.toString();
                    String str3 = destDir + str2 + str;
                    String[] list2 = assets.list(sb6);
                    Intrinsics.checkNotNull(list2);
                    if (list2.length == 0) {
                        copyAssetToFile(context, sb6, str3);
                    } else {
                        File file = new File(destDir + str2 + str);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        copyAssetDirsToSdcard(context, sb6, str3);
                    }
                }
                return true;
            } catch (IOException e16) {
                Log.e("AssetsUtil", "copyAssetDirsToSdcard error, " + e16);
            }
        }
        return false;
    }

    public final boolean copyAssetToFile(@NotNull Context context, @Nullable String assetFileName, @Nullable String destFileName) {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        BufferedInputStream bufferedInputStream = null;
        try {
            fileOutputStream = new FileOutputStream(destFileName);
            try {
                try {
                    AssetManager assets = context.getAssets();
                    Intrinsics.checkNotNull(assetFileName);
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(assets.open(assetFileName));
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e16) {
                                    Log.e("AssetsUtil", "copyAssetToFile error, " + e16);
                                }
                            }
                        }
                        bufferedInputStream2.close();
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (IOException e17) {
                            Log.e("AssetsUtil", "copyAssetToFile error, " + e17);
                            return true;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        bufferedInputStream = bufferedInputStream2;
                        Log.e("AssetsUtil", "copyAssetToFile error, " + e);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e19) {
                                Log.e("AssetsUtil", "copyAssetToFile error, " + e19);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                Log.e("AssetsUtil", "copyAssetToFile error, " + e26);
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e27) {
                                Log.e("AssetsUtil", "copyAssetToFile error, " + e27);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e28) {
                                Log.e("AssetsUtil", "copyAssetToFile error, " + e28);
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e29) {
                e = e29;
            }
        } catch (IOException e36) {
            e = e36;
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    public final void copyFilesFromAssets(@NotNull Context context, @NotNull String assetsPath, @NotNull String savePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetsPath, "assetsPath");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        try {
            String[] list = context.getAssets().list(assetsPath);
            Intrinsics.checkNotNull(list);
            if (list.length > 0) {
                new File(savePath).mkdirs();
                for (String str : list) {
                    copyFilesFromAssets(context, assetsPath + '/' + str, savePath + '/' + str);
                }
            }
            InputStream open = context.getAssets().open(assetsPath);
            Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(assetsPath)");
            FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath));
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
        } catch (Exception e16) {
            Log.e("AssetsUtil", "copyFilesFromAssets error, " + e16);
        }
    }

    @Nullable
    public final String getAssetsFileData(@NotNull Context context, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            InputStream open = context.getAssets().open(filePath);
            Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(filePath)");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, Charsets.UTF_8);
        } catch (IOException e16) {
            Log.e("AssetsUtil", "getAssetsFileData error, " + e16);
            return null;
        }
    }
}
