package io4;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0019"}, d2 = {"Lio4/b;", "", "", PhotoCategorySummaryInfo.AVATAR_URL, "Landroid/widget/ImageView;", "imageView", "", "avatarSize", "", "i", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "b", "g", "gender", "Landroid/graphics/drawable/Drawable;", "d", "c", "sex", "e", "resId", "f", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f408106a = new b();

    b() {
    }

    private final URLDrawable.URLDrawableOptions b(int avatarSize, View view) {
        return com.tencent.timi.game.utils.d.f380295a.c(avatarSize, view, R.drawable.ovu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str, ImageView imageView, int i3) {
        f408106a.i(str, imageView, i3);
    }

    private final void i(String avatarUrl, ImageView imageView, int avatarSize) {
        com.tencent.timi.game.utils.d.f380295a.d(avatarUrl, imageView, b(avatarSize, imageView));
    }

    @Nullable
    public final Drawable c(@NotNull View view, @NotNull String gender) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(gender, "gender");
        if (Intrinsics.areEqual(gender, "\u7537")) {
            return f(R.drawable.ovt, view);
        }
        if (Intrinsics.areEqual(gender, "\u5973")) {
            return f(R.drawable.ovs, view);
        }
        return null;
    }

    @Nullable
    public final Drawable d(@NotNull View view, @NotNull String gender) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(gender, "gender");
        if (Intrinsics.areEqual(gender, "\u7537")) {
            return f(R.drawable.ovv, view);
        }
        if (Intrinsics.areEqual(gender, "\u5973")) {
            return f(R.drawable.ovw, view);
        }
        return null;
    }

    public final int e(@NotNull String sex) {
        Intrinsics.checkNotNullParameter(sex, "sex");
        if (Intrinsics.areEqual(sex, "\u7537")) {
            return Color.parseColor("#39b1f6");
        }
        if (Intrinsics.areEqual(sex, "\u5973")) {
            return Color.parseColor("#fc435d");
        }
        return Color.parseColor("#9c9ba6");
    }

    @Nullable
    public final Drawable f(int resId, @Nullable View view) {
        Resources resources;
        if (view != null && (resources = view.getResources()) != null) {
            return resources.getDrawable(resId);
        }
        return null;
    }

    public final void g(@Nullable final String avatarUrl, @Nullable final ImageView imageView, final int avatarSize) {
        if (avatarUrl != null && avatarUrl.length() != 0) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                i(avatarUrl, imageView, avatarSize);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: io4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.h(avatarUrl, imageView, avatarSize);
                    }
                });
            }
        }
    }
}
