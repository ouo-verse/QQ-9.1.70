package fk4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lfk4/a;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/drawable/NinePatchDrawable;", "a", "", "b", "[B", "chunk", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f399760a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final byte[] chunk = {1, 2, 2, 3, 32, 0, 0, 0, 40, 0, 0, 0, 24, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, 24, 0, 0, 0, 56, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 71, 1, 0, 0, 0};

    a() {
    }

    @Nullable
    public final NinePatchDrawable a(@NotNull Context context, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (bitmap == null) {
            return null;
        }
        try {
            bitmap.setDensity(320);
            return new NinePatchDrawable(context.getResources(), bitmap, chunk, new Rect(), "");
        } catch (Throwable th5) {
            AegisLogger.INSTANCE.e("unknown|NinePatchUtil", "createNinePatchDrawable", "error", th5);
            return null;
        }
    }
}
