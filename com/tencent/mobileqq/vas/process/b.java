package com.tencent.mobileqq.vas.process;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.view.RollingTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/process/b;", "Lcom/tencent/qqnt/chats/inject/unread/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/view/RollingTextView;", "view", "", "b", "Landroid/widget/ImageView;", "summaryRightView", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends com.tencent.qqnt.chats.inject.unread.a {
    private final void b(g item, RollingTextView view) {
        Drawable drawable;
        if (item.y().p()) {
            Function2<Integer, Long, Drawable> h16 = item.y().h();
            Integer num = null;
            if (h16 != null) {
                drawable = h16.invoke(Integer.valueOf(item.y().g()), Long.valueOf(item.x().b()));
            } else {
                drawable = null;
            }
            IBubbleManager.BubbleTextInfo bubbleTextInfo = ((IBubbleManager) QRoute.api(IBubbleManager.class)).getBubbleTextInfo(String.valueOf(item.y().g()));
            if (bubbleTextInfo != null) {
                num = Integer.valueOf(bubbleTextInfo.getColor());
            }
            view.updateCustomStyle(num, drawable);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.unread.a
    public void a(@NotNull g item, @NotNull RollingTextView view, @NotNull ImageView summaryRightView) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(summaryRightView, "summaryRightView");
        if (item.o() != 1) {
            return;
        }
        if (SimpleUIUtil.isNowSimpleMode()) {
            b(item, view);
            return;
        }
        if (item.y().n()) {
            Function2<Integer, Long, Drawable> d16 = item.y().d();
            if (d16 != null) {
                drawable = d16.invoke(Integer.valueOf(item.y().b()), Long.valueOf(item.x().b()));
            } else {
                drawable = null;
            }
            view.updateCustomStyle(null, drawable);
            return;
        }
        b(item, view);
    }
}
