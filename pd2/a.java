package pd2;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lpd2/a;", "", "Lcom/tencent/mobileqq/proavatar/merge/a;", "bitmapJointBuilder", "Landroid/graphics/Bitmap;", "a", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f425932a = new a();

    a() {
    }

    @Nullable
    public final Bitmap a(@NotNull com.tencent.mobileqq.proavatar.merge.a bitmapJointBuilder) {
        Intrinsics.checkNotNullParameter(bitmapJointBuilder, "bitmapJointBuilder");
        bitmapJointBuilder.i(bitmapJointBuilder.f().a(bitmapJointBuilder.g(), bitmapJointBuilder.e(), bitmapJointBuilder.d()));
        return bitmapJointBuilder.f().b(bitmapJointBuilder.g(), bitmapJointBuilder.b(), bitmapJointBuilder.h(), bitmapJointBuilder.c());
    }
}
