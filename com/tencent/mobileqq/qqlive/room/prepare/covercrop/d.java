package com.tencent.mobileqq.qqlive.room.prepare.covercrop;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0018\u001a\u00020\u0017R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/covercrop/d;", "", "", "bitmapHashCode", "Landroid/graphics/Bitmap;", "photoBitmap", "", "targetPath", "Lcom/tencent/mobileqq/qqlive/data/upload/QQLiveUploadBitmapResult;", "e", MimeHelper.IMAGE_SUBTYPE_BITMAP, "g", "filePath", "Ljava/io/File;", "b", "taskHashCode", "msg", "c", "hashCode", "Lcom/tencent/mobileqq/qqlive/data/upload/QQLiveUploadBitmapParams;", "params", "d", "f", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "doingTask", "Ljava/io/File;", "appCacheFile", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "sdkImpl", "<init>", "(Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, QQLiveUploadBitmapParams> doingTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private File appCacheFile;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/covercrop/d$a;", "", "", "COMPRESS_QUALITY", "I", "DEFAULT_FAIL_TASKHASHCODE", "DEFAULT_SUCCESS_CODE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.covercrop.d$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36081);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull IQQLiveSDK sdkImpl) {
        File file;
        Intrinsics.checkNotNullParameter(sdkImpl, "sdkImpl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sdkImpl);
            return;
        }
        this.doingTask = new ConcurrentHashMap<>();
        try {
            file = sdkImpl.getAppRuntime().getApp().getCacheDir();
        } catch (Throwable th5) {
            AegisLogger.INSTANCE.e("Open_Live|UploadBitmapTask", "init", "getCacheDir error, ", th5);
            file = null;
        }
        this.appCacheFile = file;
    }

    private final File b(String filePath) {
        int lastIndexOf$default;
        if (filePath == null) {
            QLog.i("Open_Live|UploadBitmapTask", 1, "createNewFile but filepath is null");
            return null;
        }
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filePath, '/', 0, false, 6, (Object) null);
                if (lastIndexOf$default > 0 && lastIndexOf$default < filePath.length() - 1) {
                    String substring = filePath.substring(0, lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    File file2 = new File(substring);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                }
            } else {
                file.delete();
            }
            file.createNewFile();
            return file;
        } catch (IOException e16) {
            QLog.e("Open_Live|UploadBitmapTask", 1, "createNewFile IOException " + e16);
            return null;
        }
    }

    private final QQLiveUploadBitmapResult c(int taskHashCode, String msg2) {
        if (taskHashCode != -1) {
            this.doingTask.remove(Integer.valueOf(taskHashCode));
        }
        return new QQLiveUploadBitmapResult(QQLiveError.UPLOAD_BITMAP_FAILED, false, msg2);
    }

    private final String d(int hashCode, QQLiveUploadBitmapParams params) {
        if (this.appCacheFile == null) {
            return null;
        }
        return new File(this.appCacheFile, "qqlive_" + hashCode + "_" + params.format + ".jpg").getAbsolutePath();
    }

    private final QQLiveUploadBitmapResult e(int bitmapHashCode, Bitmap photoBitmap, String targetPath) {
        String g16;
        if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
            g16 = "sdcardfull";
        } else {
            g16 = g(photoBitmap, targetPath);
        }
        if (!Intrinsics.areEqual("oom", g16) && g16 != null) {
            if (Intrinsics.areEqual("sdcardfull", g16)) {
                return c(bitmapHashCode, "store failed:SD\u5361\u7a7a\u95f4\u4e0d\u8db3");
            }
            QQLiveUploadBitmapResult qQLiveUploadBitmapResult = new QQLiveUploadBitmapResult(0, true, "");
            qQLiveUploadBitmapResult.url = targetPath;
            return qQLiveUploadBitmapResult;
        }
        return c(bitmapHashCode, "store failed:\u5185\u5b58\u4e0d\u8db3");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x003a, code lost:
    
        r7 = "file is null";
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String g(Bitmap bitmap, String targetPath) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bitmap == null) {
            QLog.i("Open_Live|UploadBitmapTask", 1, "storeImageToFile but bitmap is null");
            return null;
        }
        File file = new File(targetPath);
        try {
            if (!file.exists()) {
                file = b(targetPath);
            }
            if (file != null && file.exists()) {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                        fileOutputStream.close();
                        return targetPath;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (IOException e16) {
                    e = e16;
                    QLog.e("Open_Live|UploadBitmapTask", 1, "storeImageToFile IOException, ", e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                }
            }
            String str = "file not exists";
            QLog.i("Open_Live|UploadBitmapTask", 1, "storeImageToFile but " + str);
            return null;
        } catch (IOException e17) {
            e = e17;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.doingTask.clear();
            this.appCacheFile = null;
        }
    }

    @Nullable
    public final QQLiveUploadBitmapResult f(@Nullable Bitmap bitmap, @Nullable QQLiveUploadBitmapParams params) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQLiveUploadBitmapResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap, (Object) params);
        }
        if (bitmap != null && params != null) {
            String str = params.roomId;
            boolean z17 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str2 = params.format;
                if (str2 == null || str2.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    int hashCode = bitmap.hashCode();
                    QQLiveUploadBitmapParams qQLiveUploadBitmapParams = this.doingTask.get(Integer.valueOf(hashCode));
                    if (qQLiveUploadBitmapParams != null && Intrinsics.areEqual(qQLiveUploadBitmapParams, params)) {
                        return c(-1, "already uploading...");
                    }
                    String d16 = d(hashCode, params);
                    if (d16 == null) {
                        return c(-1, "targetPath is null or empty:" + d16);
                    }
                    this.doingTask.put(Integer.valueOf(hashCode), params);
                    return e(hashCode, bitmap, d16);
                }
            }
            return c(-1, "params invalid");
        }
        return c(-1, "check param null");
    }
}
