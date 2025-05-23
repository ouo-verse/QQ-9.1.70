package com.tencent.mobileqq.aio.title;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.ams.dsdk.core.DKConfiguration;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J*\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J(\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\f0\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/title/ac;", "", "", "c", "", "d", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/widget/ImageView;", "view", "", "iconUrl", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "f", "Landroid/content/Context;", "context", "defaultIconDrawable", "Lkotlin/Pair;", "b", "a", "e", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface ac {
    void a();

    @NotNull
    Pair<String, Drawable> b(@Nullable Context context, @NotNull Drawable defaultIconDrawable);

    boolean c();

    float d();

    void e();

    void f(@Nullable Resources resources, @NotNull ImageView view, @NotNull String iconUrl, @NotNull Drawable iconDrawable);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a {
        public static void a(@NotNull ac acVar) {
        }

        public static void b(@NotNull ac acVar) {
        }
    }
}
