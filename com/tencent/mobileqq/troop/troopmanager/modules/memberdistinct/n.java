package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/widget/ImageView;", "", "url", "", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class n {
    public static final void a(@NotNull ImageView imageView, @NotNull String url) {
        boolean z16;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mRequestWidth = imageView.getWidth();
        obtain.mRequestHeight = imageView.getHeight();
        imageView.setImageDrawable(URLDrawable.getDrawable(url, obtain));
    }
}
