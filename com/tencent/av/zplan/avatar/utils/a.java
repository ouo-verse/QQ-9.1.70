package com.tencent.av.zplan.avatar.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0007J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/av/zplan/avatar/utils/a;", "", "Landroid/content/Context;", "context", "", "assetFileName", "destFileName", "", "a", "assetsPath", "savePath", "", "b", "d", "e", WadlProxyConsts.PARAM_FILENAME, "Landroid/graphics/Bitmap;", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f77344a = new a();

    a() {
    }

    public final boolean a(@NotNull Context context, @Nullable String assetFileName, @Nullable String destFileName) {
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
                        Ref.IntRef intRef = new Ref.IntRef();
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            intRef.element = read;
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

    public final void b(@NotNull Context context, @NotNull String assetsPath, @NotNull String savePath) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetsPath, "assetsPath");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        try {
            String[] list = context.getAssets().list(assetsPath);
            if (list != null) {
                if (list.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    new File(savePath).mkdirs();
                    Iterator it = ArrayIteratorKt.iterator(list);
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        a(context, assetsPath + "/" + str, savePath + "/" + str);
                    }
                    return;
                }
            }
            Log.e("AssetsUtil", "copyFilesFromAssets no files should be copied");
        } catch (Exception e16) {
            Log.e("AssetsUtil", "copyFilesFromAssets error, " + e16);
        }
    }

    @Nullable
    public final Bitmap c(@NotNull Context context, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Bitmap bitmap = null;
        try {
            InputStream open = context.getResources().getAssets().open(fileName);
            Intrinsics.checkNotNullExpressionValue(open, "am.open(fileName)");
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }

    @NotNull
    public final String d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getFilesDir().getAbsolutePath() + File.separator + "qav_zplan_avatar_bg_v1";
    }

    public final boolean e() {
        boolean z16;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        String d16 = d(context);
        String str = File.separator;
        File file = new File(d16 + str + "bg_default.png");
        BaseApplication context2 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        File file2 = new File(d(context2) + str + "plane2.gltf");
        if (file.exists() && file2.exists()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("AssetsUtil", 1, "isBgDefaultResOk " + z16);
        return z16;
    }
}
