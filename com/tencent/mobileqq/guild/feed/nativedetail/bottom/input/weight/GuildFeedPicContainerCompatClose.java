package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight.GuildFeedPicContainerCompatClose;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedPicContainerCompatClose;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "view", "", "extraPadding", "", "b", "onFinishInflate", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPicContainerCompatClose extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPicContainerCompatClose(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(final View view, final int extraPadding) {
        final View view2;
        Object parent = view.getParent();
        if (parent instanceof View) {
            view2 = (View) parent;
        } else {
            view2 = null;
        }
        if (view2 != null) {
            QLog.i("GuildFeedPicContainerCompatClose", 1, "expandViewTouchArea extraPadding=" + extraPadding);
            view2.post(new Runnable() { // from class: zk1.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedPicContainerCompatClose.c(view, extraPadding, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view, int i3, View view2) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i3;
        rect.left -= i3;
        rect.right += i3;
        rect.bottom += i3;
        view2.setTouchDelegate(new TouchDelegate(rect, view));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.u2e);
        if (findViewById != null) {
            b(findViewById, c.b(3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPicContainerCompatClose(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
