package com.tencent.qqnt.chats.biz.guild;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/i;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Landroid/content/res/Resources;", "res", "Landroid/graphics/drawable/Drawable;", "drawable", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "a", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class i extends com.tencent.qqnt.chats.inject.title.a {
    private final Drawable b(Resources res, Drawable drawable) {
        if (drawable == null) {
            return drawable;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth != 0 && intrinsicHeight != 0) {
            int i3 = (int) ((20 * res.getDisplayMetrics().density) + 0.5f);
            drawable.setBounds(0, 0, (intrinsicWidth * i3) / intrinsicHeight, i3);
        }
        return drawable;
    }

    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull SingleLineTextView view) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 16) {
            return;
        }
        Integer d16 = item.w().d();
        if (d16 != null) {
            drawable = view.getContext().getDrawable(d16.intValue());
        } else {
            drawable = null;
        }
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        b(resources, drawable);
        view.setCompoundDrawables(null, drawable);
    }
}
