package e03;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0004R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Le03/a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "key", "", "c", "a", "filePath", "b", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/ConcurrentHashMap;", "bitmapCache", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f395321a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = IBubbleManager.INSTANCE.b() + "BitmapWeakCache";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, WeakReference<Bitmap>> bitmapCache = new ConcurrentHashMap<>();

    a() {
    }

    private final Bitmap a(String key) {
        WeakReference<Bitmap> weakReference = bitmapCache.get(key);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final void c(Bitmap bitmap, String key) {
        bitmapCache.put(key, new WeakReference<>(bitmap));
    }

    @Nullable
    public final Bitmap b(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            Bitmap a16 = a(filePath);
            if (a16 != null && !a16.isRecycled()) {
                return a16;
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(filePath);
            if (decodeFile != null) {
                f395321a.c(decodeFile, filePath);
                return decodeFile;
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "getBitmapFormFilePath e = " + th5);
            return null;
        }
    }
}
