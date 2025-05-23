package com.tencent.mobileqq.search.searchdetail.util;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.search.searchdetail.content.template.u;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "Landroid/widget/ImageView;", "imageView", "", "b", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {
    public static final boolean b(@NotNull final SearchIcon searchIcon, @NotNull final ImageView imageView) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(searchIcon, "<this>");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        String iconToken = searchIcon.iconToken;
        Intrinsics.checkNotNullExpressionValue(iconToken, "iconToken");
        isBlank = StringsKt__StringsJVMKt.isBlank(iconToken);
        if (!isBlank) {
            int identifier = imageView.getContext().getResources().getIdentifier("qui_" + searchIcon.iconToken, "drawable", imageView.getContext().getPackageName());
            int identifier2 = imageView.getContext().getResources().getIdentifier("qui_common_" + searchIcon.iconColorToken, "color", imageView.getContext().getPackageName());
            if (identifier != 0) {
                GuildUIUtils.d(imageView, identifier, Integer.valueOf(identifier2));
            }
            return true;
        }
        String iconLink = searchIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(iconLink, "iconLink");
        isBlank2 = StringsKt__StringsJVMKt.isBlank(iconLink);
        if (!isBlank2) {
            imageView.setImageDrawable(URLDrawable.getDrawable(searchIcon.iconLink, URLDrawable.URLDrawableOptions.obtain()));
            String iconLink2 = searchIcon.iconLink;
            Intrinsics.checkNotNullExpressionValue(iconLink2, "iconLink");
            u.b(imageView, iconLink2, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.search.searchdetail.util.d
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    e.c(SearchIcon.this, imageView, loadState, option);
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SearchIcon this_loadImageInto, ImageView imageView, LoadState loadState, Option option) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this_loadImageInto, "$this_loadImageInto");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        if (loadState == LoadState.STATE_SUCCESS) {
            String iconColorToken = this_loadImageInto.iconColorToken;
            Intrinsics.checkNotNullExpressionValue(iconColorToken, "iconColorToken");
            if (iconColorToken.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int identifier = imageView.getContext().getResources().getIdentifier("qui_common_" + this_loadImageInto.iconColorToken, "color", imageView.getContext().getPackageName());
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(imageView.getContext().getResources().getColor(identifier), PorterDuff.Mode.SRC_IN));
                }
            }
        }
    }
}
