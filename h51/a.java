package h51;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0015"}, d2 = {"Lh51/a;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "a", "Ljava/io/File;", "iconFile", MimeHelper.IMAGE_SUBTYPE_BITMAP, "d", "Landroid/content/Context;", "context", "", "packageName", "c", "Landroid/content/pm/PackageInfo;", "packageInfo", "b", "e", "<init>", "()V", "MiniBoxBusiness_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f404332a = new a();

    a() {
    }

    private final Bitmap a(Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        drawable.draw(new Canvas(bitmap));
        Intrinsics.checkExpressionValueIsNotNull(bitmap, "bitmap");
        return bitmap;
    }

    private final String b(PackageInfo packageInfo) {
        String replace$default;
        StringBuilder sb5 = new StringBuilder();
        String str = packageInfo.packageName;
        Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.packageName");
        replace$default = StringsKt__StringsJVMKt.replace$default(str, ".", "_", false, 4, (Object) null);
        sb5.append(replace$default);
        sb5.append(util.base64_pad_url);
        sb5.append(packageInfo.versionCode);
        sb5.append(".png");
        return sb5.toString();
    }

    private final File c(Context context, String packageName) {
        File file = new File(context.getFilesDir(), "minibox/app/install/" + packageName + "/miniboxappicon");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0031: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:50), block:B:16:0x0031 */
    private final File d(File iconFile, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                iconFile.delete();
                iconFile.createNewFile();
                fileOutputStream = new FileOutputStream(iconFile);
            } catch (IOException e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                m51.a.a(closeable2);
                throw th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                m51.a.a(fileOutputStream);
                return iconFile;
            } catch (IOException e17) {
                e = e17;
                iconFile.deleteOnExit();
                LogUtils.e("ImageUtil", "[saveBitmap] exception.", e);
                m51.a.a(fileOutputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            m51.a.a(closeable2);
            throw th;
        }
    }

    @Nullable
    public final String e(@NotNull Context context, @NotNull PackageInfo packageInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(packageInfo, "packageInfo");
        String b16 = b(packageInfo);
        String str = packageInfo.packageName;
        Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.packageName");
        File file = new File(c(context, str), b16);
        if (file.exists() && file.length() > 0) {
            return file.getAbsolutePath();
        }
        Drawable drawable = packageInfo.applicationInfo.loadIcon(context.getPackageManager());
        Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
        File d16 = d(file, a(drawable));
        if (d16 != null) {
            return d16.getAbsolutePath();
        }
        return null;
    }
}
