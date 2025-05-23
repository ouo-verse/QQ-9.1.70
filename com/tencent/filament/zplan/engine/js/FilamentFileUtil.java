package com.tencent.filament.zplan.engine.js;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.tencent.filament.zplanservice.util.b;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import dl0.c;
import dl0.j;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONObject;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0007J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002J&\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002J$\u0010\"\u001a\u00020!*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\u0002J\u000e\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010*\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002J\u001d\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\t\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010/\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0004\u0018\u0001038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentFileUtil;", "", "", "systemCacheDirectory", "", "pixels", "", "width", "height", "filePath", "", "writePixelsToPNG", "path", "Ljava/io/File;", "createFile", "randomString", "bytes", "bufferToHex", "", "bt", "Ljava/lang/StringBuffer;", "stringBuffer", "", "appendHexPair", "cleanFilamentResourceDir", "fileExistsAtPath", QzoneZipCacheHelper.DIR, WadlProxyConsts.PARAM_FILENAME, "fileExtension", "filePathInDir", "readFileContent", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap;", "toBitmap", "dirStr", "deleteDirectory", "file", "isDirectory", "deleteDirSafely", "deleteFileSafely", "filename", "pathAppend", "Lorg/json/JSONObject;", "readJsonFile", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "md5File", "IMAGE_COMPRESS_QUALITY", "I", "TAG", "Ljava/lang/String;", "Ldl0/c;", "fileUtilProxy", "Ldl0/c;", "", "hexDigits", "[C", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentFileUtil {
    private static final int IMAGE_COMPRESS_QUALITY = 100;
    private static final String TAG = "FilamentFileUtil";

    @NotNull
    public static final FilamentFileUtil INSTANCE = new FilamentFileUtil();
    private static final c fileUtilProxy = (c) fl0.a.f399763a.a(c.class);
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    FilamentFileUtil() {
    }

    private final void appendHexPair(byte bt5, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c16 = cArr[(bt5 & 240) >>> 4];
        char c17 = cArr[bt5 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }

    private final String bufferToHex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer(bytes.length * 2);
        for (byte b16 : bytes) {
            appendHexPair(b16, stringBuffer);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "stringBuffer.toString()");
        return stringBuffer2;
    }

    private final File createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static /* synthetic */ String filePathInDir$default(FilamentFileUtil filamentFileUtil, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return filamentFileUtil.filePathInDir(str, str2, str3);
    }

    private final String randomString() {
        return FilamentMD5Util.md5(String.valueOf(Math.random()));
    }

    @JvmStatic
    @NativeMethodProxy
    @NotNull
    public static final String systemCacheDirectory() {
        String b16;
        c cVar = fileUtilProxy;
        if (cVar == null || (b16 = cVar.b()) == null) {
            return "";
        }
        return b16;
    }

    public static /* synthetic */ Bitmap toBitmap$default(FilamentFileUtil filamentFileUtil, byte[] bArr, int i3, int i16, Bitmap.Config config, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return filamentFileUtil.toBitmap(bArr, i3, i16, config);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #6 {all -> 0x009e, blocks: (B:11:0x002b, B:13:0x0032, B:18:0x003e, B:27:0x0054, B:29:0x005f, B:31:0x0068, B:33:0x006e, B:35:0x0078, B:67:0x0074, B:68:0x0065), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054 A[Catch: all -> 0x009e, TRY_ENTER, TryCatch #6 {all -> 0x009e, blocks: (B:11:0x002b, B:13:0x0032, B:18:0x003e, B:27:0x0054, B:29:0x005f, B:31:0x0068, B:33:0x006e, B:35:0x0078, B:67:0x0074, B:68:0x0065), top: B:10:0x002b }] */
    @JvmStatic
    @NativeMethodProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean writePixelsToPNG(@Nullable byte[] pixels, int width, int height, @NotNull String filePath) {
        Bitmap bitmap;
        boolean z16;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (pixels == null || width == 0 || height == 0) {
            return false;
        }
        File file = new File(filePath);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                FilamentFileUtil filamentFileUtil = INSTANCE;
                bitmap = toBitmap$default(filamentFileUtil, pixels, width, height, null, 4, null);
                try {
                    String parent = file.getParent();
                    if (parent != null && parent.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            FLog.INSTANCE.e(TAG, "writePixelsToPNG parentPath isNullOrEmpty, return false.");
                            if (bitmap != null) {
                                try {
                                    bitmap.recycle();
                                } catch (Throwable th5) {
                                    FLog.INSTANCE.e(TAG, "writePixelsToPNG finally error.", th5);
                                }
                            }
                            return false;
                        }
                        File file2 = new File(parent);
                        if (!file2.exists() || !file2.isDirectory()) {
                            file2.mkdirs();
                        }
                        if (!file.exists() || !file.isFile()) {
                            file = filamentFileUtil.createFile(filePath);
                        }
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream2);
                            bufferedOutputStream2.flush();
                            bufferedOutputStream2.close();
                            bitmap.recycle();
                            return true;
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedOutputStream = bufferedOutputStream2;
                            try {
                                FLog.INSTANCE.e(TAG, "writePixelsToPNG error.", th);
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                if (bitmap == null) {
                                    return false;
                                }
                                bitmap.recycle();
                                return false;
                            } finally {
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                bitmap = null;
            }
        } catch (Throwable th9) {
            FLog.INSTANCE.e(TAG, "writePixelsToPNG finally error.", th9);
            return false;
        }
    }

    public final void cleanFilamentResourceDir() {
        c cVar = fileUtilProxy;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final boolean deleteDirSafely(@NotNull String dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String pathAppend = pathAppend(com.tencent.filament.zplanservice.util.c.b(dir), randomString());
        if (!new File(dir).renameTo(new File(pathAppend))) {
            FLog.INSTANCE.e(TAG, "deleteDirSafely. rename fail. dir:" + dir);
            return false;
        }
        deleteDirectory(pathAppend);
        return true;
    }

    public final void deleteDirectory(@Nullable String dirStr) {
        boolean z16;
        if (dirStr == null) {
            return;
        }
        File file = new File(dirStr);
        if (!file.exists()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int length = listFiles.length;
                for (int i3 = 0; i3 < length; i3++) {
                    File file2 = listFiles[i3];
                    Intrinsics.checkNotNullExpressionValue(file2, "childDirList[i]");
                    if (file2.isDirectory()) {
                        File file3 = listFiles[i3];
                        Intrinsics.checkNotNullExpressionValue(file3, "childDirList[i]");
                        deleteDirectory(file3.getAbsolutePath());
                    } else {
                        listFiles[i3].delete();
                    }
                }
            }
        }
        file.delete();
    }

    public final boolean deleteFileSafely(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(pathAppend(com.tencent.filament.zplanservice.util.c.b(filePath), randomString()));
        if (!new File(filePath).renameTo(file)) {
            FLog.INSTANCE.e(TAG, "deleteFileSafely. rename fail. filePath:" + filePath);
            return false;
        }
        file.delete();
        return true;
    }

    public final boolean fileExistsAtPath(@Nullable String path) {
        boolean z16;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return new File(path).exists();
    }

    @Nullable
    public final String filePathInDir(@Nullable String dir, @Nullable String fileName, @NotNull String fileExtension) {
        boolean z16;
        File[] listFiles;
        String str;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        boolean z17 = true;
        if (dir != null && dir.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (listFiles = new File(dir).listFiles()) != null) {
            if (listFiles.length != 0) {
                z17 = false;
            }
            if (!z17) {
                for (File it : listFiles) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String name = it.getName();
                    if (!Intrinsics.areEqual(name, ".") && !Intrinsics.areEqual(name, "..") && !Intrinsics.areEqual(name, "__MACOSX")) {
                        String path = it.getAbsolutePath();
                        if (it.isDirectory()) {
                            String filePathInDir = INSTANCE.filePathInDir(path, fileName, fileExtension);
                            if (filePathInDir != null) {
                                return filePathInDir;
                            }
                        } else {
                            Intrinsics.checkNotNullExpressionValue(path, "path");
                            StringBuilder sb5 = new StringBuilder();
                            if (fileName != null) {
                                str = fileName;
                            } else {
                                str = "";
                            }
                            sb5.append(str);
                            sb5.append('.');
                            sb5.append(fileExtension);
                            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, sb5.toString(), false, 2, null);
                            if (endsWith$default) {
                                return path;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final boolean isDirectory(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            return false;
        }
        return file.isDirectory();
    }

    @Nullable
    public final String md5File(@NotNull String filePath) {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        IOException iOException;
        FLog fLog;
        StringBuilder sb5;
        byte[] digest;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String str = null;
        try {
            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException e16) {
            FLog.INSTANCE.e(TAG, "md5File fail. MessageDigest.getInstance fail. filePath:" + filePath, e16);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            FLog.INSTANCE.e(TAG, "md5File fail. file not exist. filePath:" + filePath);
            return null;
        }
        if (file.length() == 0) {
            FLog.INSTANCE.e(TAG, "md5File fail. file length = 0. filePath:" + filePath);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                long length = file.length();
                byte[] bArr = new byte[4096];
                int read = fileInputStream.read(bArr);
                while (true) {
                    long j3 = read;
                    if (length <= 0 || j3 == -1) {
                        break;
                    }
                    if (j3 > length) {
                        j3 = length;
                    }
                    length -= j3;
                    messageDigest.update(ByteBuffer.wrap(bArr, 0, (int) j3));
                    read = fileInputStream.read(bArr);
                }
                fileInputStream.close();
                digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        try {
            str = bufferToHex(digest);
            try {
                fileInputStream.close();
            } catch (IOException e17) {
                iOException = e17;
                fLog = FLog.INSTANCE;
                sb5 = new StringBuilder();
                sb5.append("md5File fail. close inputStream fail. filePath:");
                sb5.append(filePath);
                fLog.e(TAG, sb5.toString(), iOException);
                return str;
            }
        } catch (Throwable th7) {
            th = th7;
            try {
                FLog.INSTANCE.i(TAG, "md5File fail. filePath:" + filePath + ". EXCEPTION: " + th);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        iOException = e18;
                        fLog = FLog.INSTANCE;
                        sb5 = new StringBuilder();
                        sb5.append("md5File fail. close inputStream fail. filePath:");
                        sb5.append(filePath);
                        fLog.e(TAG, sb5.toString(), iOException);
                        return str;
                    }
                }
                return str;
            } finally {
            }
        }
        return str;
    }

    @NotNull
    public final String pathAppend(@NotNull String dir, @NotNull String filename) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(filename, "filename");
        endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) dir, File.separatorChar, false, 2, (Object) null);
        if (endsWith$default) {
            return dir + filename;
        }
        return dir + File.separatorChar + filename;
    }

    @Nullable
    public final String readFileContent(@Nullable String path) {
        boolean z16;
        BufferedReader bufferedReader;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        try {
            Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            }
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return readText;
            } finally {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e(TAG, "readFileContent from:" + path + ", readText error", th5);
            return null;
        }
    }

    @Nullable
    public final Object readJsonFile(@NotNull final String str, @NotNull Continuation<? super JSONObject> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        j jVar = (j) fl0.a.f399763a.a(j.class);
        if (jVar == null) {
            FLog.INSTANCE.e(TAG, "threadPoolProxy is null. filePath: " + str);
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        }
        if (jVar != null) {
            j.a.a(jVar, new Runnable() { // from class: com.tencent.filament.zplan.engine.js.FilamentFileUtil$readJsonFile$$inlined$suspendCoroutine$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Continuation.this.resumeWith(Result.m476constructorimpl(new JSONObject(b.b(new File(str)))));
                    } catch (Exception e16) {
                        FLog.INSTANCE.e("FilamentFileUtil", "readJsonFile fail. filePath: " + str, e16);
                        Continuation.this.resumeWith(Result.m476constructorimpl(null));
                    }
                }
            }, 0L, 2, null);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @NotNull
    public final Bitmap toBitmap(@NotNull byte[] toBitmap, int i3, int i16, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(toBitmap, "$this$toBitmap");
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(toBitmap));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(widt\u2026fer.wrap(this))\n        }");
        return createBitmap;
    }
}
