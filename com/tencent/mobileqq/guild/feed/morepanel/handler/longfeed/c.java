package com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.guild.config.GuildFeedShareConfigParser;
import com.tencent.mobileqq.guild.util.bi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import x12.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0003H\u0000\u001a\b\u0010\b\u001a\u00020\u0007H\u0000\u00a8\u0006\t"}, d2 = {"Lx12/n;", "", "c", "Landroid/view/View;", "b", "Landroid/graphics/Bitmap;", "a", "", "d", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    @NotNull
    public static final Bitmap a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    public static final void b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.measure(d(), d());
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static final void c(@NotNull n nVar) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(nVar, "<this>");
        FrameLayout root = nVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        b(root);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(GuildFeedShareConfigParser.INSTANCE.getConfig().getFeedSharePicMaxHeight(), 594);
        int i3 = coerceAtLeast - 406;
        if (nVar.f446963b.getMeasuredHeight() > bi.b(i3)) {
            ViewGroup.LayoutParams layoutParams = nVar.f446963b.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.height = bi.b(i3);
            nVar.f446963b.setLayoutParams(layoutParams);
            TextView guildFeedShowAllTip = nVar.f446968g;
            Intrinsics.checkNotNullExpressionValue(guildFeedShowAllTip, "guildFeedShowAllTip");
            guildFeedShowAllTip.setVisibility(0);
            View guildFeedShowAllTipShadow1 = nVar.f446969h;
            Intrinsics.checkNotNullExpressionValue(guildFeedShowAllTipShadow1, "guildFeedShowAllTipShadow1");
            guildFeedShowAllTipShadow1.setVisibility(0);
            View guildFeedShowAllTipShadow2 = nVar.f446970i;
            Intrinsics.checkNotNullExpressionValue(guildFeedShowAllTipShadow2, "guildFeedShowAllTipShadow2");
            guildFeedShowAllTipShadow2.setVisibility(0);
            FrameLayout root2 = nVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "root");
            b(root2);
            return;
        }
        TextView guildFeedShowAllTip2 = nVar.f446968g;
        Intrinsics.checkNotNullExpressionValue(guildFeedShowAllTip2, "guildFeedShowAllTip");
        guildFeedShowAllTip2.setVisibility(8);
        View guildFeedShowAllTipShadow12 = nVar.f446969h;
        Intrinsics.checkNotNullExpressionValue(guildFeedShowAllTipShadow12, "guildFeedShowAllTipShadow1");
        guildFeedShowAllTipShadow12.setVisibility(8);
        View guildFeedShowAllTipShadow22 = nVar.f446970i;
        Intrinsics.checkNotNullExpressionValue(guildFeedShowAllTipShadow22, "guildFeedShowAllTipShadow2");
        guildFeedShowAllTipShadow22.setVisibility(8);
    }

    public static final int d() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }
}
