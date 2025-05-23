package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/e;", "", "Landroid/widget/ImageView;", "imageView", "", "imgUrl", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f217491a = new e();

    e() {
    }

    public static /* synthetic */ void b(e eVar, ImageView imageView, String str, Drawable drawable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = null;
        }
        eVar.a(imageView, str, drawable);
    }

    public final void a(@NotNull ImageView imageView, @Nullable String imgUrl, @Nullable Drawable defaultDrawable) {
        String str;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (Intrinsics.areEqual(imageView.getTag(), imgUrl)) {
            Logger.f235387a.d().d("MiscUtil", 1, "updateGuildIcon hitTheSameAvatarUrl\uff0c noNeedUpdate. " + imgUrl);
            return;
        }
        if (URLUtil.isValidUrl(imgUrl)) {
            imageView.setVisibility(0);
            if (imgUrl == null) {
                str = "";
            } else {
                str = imgUrl;
            }
            v.l(str, imageView, null, 4, null);
            imageView.setTag(imgUrl);
            return;
        }
        Logger.f235387a.d().d("MiscUtil", 1, "updateGuildIcon url invalid. " + imgUrl);
        if (defaultDrawable != null) {
            imageView.setImageDrawable(defaultDrawable);
        } else {
            imageView.setVisibility(8);
        }
    }
}
