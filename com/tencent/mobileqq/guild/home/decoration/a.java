package com.tencent.mobileqq.guild.home.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cp1.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/decoration/a;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", PM.CANVAS, "d", "", "e", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "coverColors", "f", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDraw", "Landroid/view/View;", "Landroid/view/View;", "headerViewInList", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "coverBelow", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "Landroid/graphics/Paint;", h.F, "Landroid/graphics/Paint;", "paint", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View headerViewInList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildHomeCoverBelowList coverBelow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHomeCoverColors coverColors;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    public a(@NotNull View headerViewInList, @NotNull GuildHomeCoverBelowList coverBelow) {
        Intrinsics.checkNotNullParameter(headerViewInList, "headerViewInList");
        Intrinsics.checkNotNullParameter(coverBelow, "coverBelow");
        this.headerViewInList = headerViewInList;
        this.coverBelow = coverBelow;
        this.paint = new Paint();
    }

    private final void c(Canvas c16, RecyclerView parent) {
        if (parent.getBottom() > this.headerViewInList.getBottom()) {
            d(c16, parent);
        }
    }

    private final void d(Canvas canvas, RecyclerView parent) {
        GuildHomeCoverColors guildHomeCoverColors = this.coverColors;
        if (guildHomeCoverColors == null) {
            return;
        }
        canvas.save();
        this.paint.setColor(guildHomeCoverColors.getMainColor());
        canvas.drawRect(0.0f, e(parent), parent.getWidth(), parent.getBottom(), this.paint);
        canvas.restore();
    }

    private final int e(RecyclerView parent) {
        int coerceAtLeast;
        int[] iArr = {0, 0};
        int[] iArr2 = {0, 0};
        this.headerViewInList.getLocationOnScreen(iArr);
        this.coverBelow.getLocationOnScreen(iArr2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((iArr[1] + this.headerViewInList.getMeasuredHeight()) - (iArr2[1] + this.coverBelow.getMeasuredHeight()), 0);
        if (coerceAtLeast > 0) {
            Logger.f235387a.d().e("GuildFeedsHomeHeaderBgDecoration", 1, "getRectBgTop gapOffset " + coerceAtLeast + " parent t:" + parent.getTop() + " b:" + parent.getBottom() + "  cover t:" + this.coverBelow.getTop() + " b:" + this.coverBelow.getBottom() + " coverPos:" + iArr2[0] + " " + iArr2[1] + " h:" + this.coverBelow.getMeasuredHeight() + " header t:" + this.headerViewInList.getTop() + " b:" + this.headerViewInList.getBottom() + " headerPos:" + iArr[0] + " " + iArr[1] + " h:" + this.headerViewInList.getMeasuredHeight() + " ");
        }
        return (this.headerViewInList.getBottom() - coerceAtLeast) - c.f391536a.e();
    }

    public final void f(@NotNull GuildHomeCoverColors coverColors) {
        Intrinsics.checkNotNullParameter(coverColors, "coverColors");
        this.coverColors = coverColors;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(c16, parent, state);
        c(c16, parent);
    }
}
