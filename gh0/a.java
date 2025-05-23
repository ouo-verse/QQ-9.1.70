package gh0;

import android.graphics.Bitmap;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lgh0/a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "filePath", "", "c", "Ljava/io/File;", QzoneZipCacheHelper.DIR, "b", "a", "Ljava/lang/String;", "SDCARD_ROOT", "()Ljava/lang/String;", "SDCARD_IMG_SAVE", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String SDCARD_ROOT;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String SDCARD_IMG_SAVE;

    /* renamed from: c, reason: collision with root package name */
    public static final a f402039c = new a();

    static {
        File externalCacheDir = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getExternalApplicationContext().getExternalCacheDir();
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        SDCARD_ROOT = absolutePath;
        SDCARD_IMG_SAVE = absolutePath + "/Tencent/QQ_Images/";
    }

    a() {
    }

    public final String a() {
        return SDCARD_IMG_SAVE;
    }

    public final boolean b(File dir) {
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.canWrite();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r3.exists() != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        r3.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
    
        if (r3.exists() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        if (r3.exists() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        if (r3.exists() == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(Bitmap bitmap, String filePath) {
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        boolean z16 = false;
        if (parentFile == null) {
            return false;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 8192);
                try {
                    z16 = bitmap.compress(Bitmap.CompressFormat.JPEG, 75, bufferedOutputStream2);
                    bufferedOutputStream2.close();
                    if (!z16) {
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    cg0.a.a("FileUtils", "saveBitmap", "saveAsCacheImage err" + e);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (IllegalStateException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    cg0.a.a("FileUtils", "saveBitmap", "saveAsCacheImage err" + e);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                    cg0.a.a("FileUtils", "saveBitmap", "saveAsCacheImage err" + e);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
            } catch (IllegalStateException e26) {
                e = e26;
            } catch (OutOfMemoryError e27) {
                e = e27;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
