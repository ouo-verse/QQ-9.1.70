package com.tencent.rdelivery.reshub.asset;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.rdelivery.reshub.core.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import jz3.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002\u001a\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n\u001a\u001a\u0010\u0011\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002\u001a\u001a\u0010\u0012\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Landroid/content/Context;", "context", "", "name", "Ljava/io/File;", "outFile", "", "c", "path", "e", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "d", "Landroid/content/res/AssetManager;", "srcName", "dstName", "", "b", "a", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {
    public static final boolean a(@NotNull AssetManager copyAssetFile, @NotNull String srcName, @NotNull String dstName) {
        Intrinsics.checkParameterIsNotNull(copyAssetFile, "$this$copyAssetFile");
        Intrinsics.checkParameterIsNotNull(srcName, "srcName");
        Intrinsics.checkParameterIsNotNull(dstName, "dstName");
        try {
            InputStream open = copyAssetFile.open(srcName);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(dstName));
                try {
                    byte[] bArr = new byte[32768];
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int read = open.read(bArr);
                        intRef.element = read;
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            CloseableKt.closeFinally(fileOutputStream, null);
                            CloseableKt.closeFinally(open, null);
                            return true;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e16) {
            d.d("PresetResAsset", "copyAssetFile (" + srcName + " -> " + dstName + ") Exception: " + e16.getMessage(), e16);
            return false;
        }
    }

    public static final boolean b(@NotNull AssetManager copyAssetFolder, @NotNull String srcName, @NotNull String dstName) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(copyAssetFolder, "$this$copyAssetFolder");
        Intrinsics.checkParameterIsNotNull(srcName, "srcName");
        Intrinsics.checkParameterIsNotNull(dstName, "dstName");
        try {
            String[] list = copyAssetFolder.list(srcName);
            if (list == null) {
                return false;
            }
            Intrinsics.checkExpressionValueIsNotNull(list, "this.list(srcName) ?: return false");
            if (list.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return a(copyAssetFolder, srcName, dstName);
            }
            boolean mkdirs = new File(dstName).mkdirs();
            for (String str : list) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(srcName);
                String str2 = File.separator;
                sb5.append(str2.toString());
                sb5.append(str);
                mkdirs &= b(copyAssetFolder, sb5.toString(), dstName + str2.toString() + str);
            }
            return mkdirs;
        } catch (IOException e16) {
            d.d("PresetResAsset", "copyAssetFolder (" + srcName + " -> " + dstName + ") Exception: " + e16.getMessage(), e16);
            return false;
        }
    }

    public static final void c(@NotNull Context context, @NotNull String name, @NotNull File outFile) throws IOException {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(outFile, "outFile");
        InputStream open = context.getAssets().open(name);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            try {
                byte[] bArr = new byte[32768];
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int read = open.read(bArr);
                    intRef.element = read;
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(open, null);
                        return;
                    }
                }
            } finally {
            }
        } finally {
        }
    }

    @NotNull
    public static final String d(@NotNull com.tencent.rdelivery.reshub.core.a appInfo) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        return j.L.x().b(appInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String e(@NotNull Context context, @NotNull String path) {
        Object m476constructorimpl;
        String str;
        Throwable m479exceptionOrNullimpl;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(path, "path");
        String str2 = "";
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream open = context.getAssets().open(path);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[32768];
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int read = open.read(bArr);
                    intRef.element = read;
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteArrayOutputStream.toByteArray()");
                str = new String(byteArray, Charsets.UTF_8);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                Unit unit = Unit.INSTANCE;
                try {
                    CloseableKt.closeFinally(open, null);
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th6) {
                    th = th6;
                    str2 = str;
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                    str = str2;
                    m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                    }
                    return str;
                }
            } catch (Throwable th7) {
                th = th7;
                str2 = str;
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
        m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            if (m479exceptionOrNullimpl instanceof FileNotFoundException) {
                d.i("PresetResAsset", "No PresetRes Config File in Asset.");
            } else {
                d.d("PresetResAsset", "Read PresetRes Config From Asset Exception: " + m479exceptionOrNullimpl.getMessage(), m479exceptionOrNullimpl);
            }
        }
        return str;
    }
}
