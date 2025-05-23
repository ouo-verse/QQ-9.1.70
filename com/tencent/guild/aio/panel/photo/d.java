package com.tencent.guild.aio.panel.photo;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.panel.photo.c;
import com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001.B#\u0012\u0006\u0010+\u001a\u00020&\u0012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\t0,\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016JJ\u0010\u0014\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JR\u0010\u0017\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0006H\u0016J \u0010%\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004H\u0016R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R#\u00102\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\t0,8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/d;", "Lcom/tencent/guild/aio/panel/photo/widget/ItemSwipeSendDecoration$c;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "e", "direction", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/Canvas;", "c", "", "dX", "dY", "initialTouchY", "actionState", "", "isCurrentlyActive", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "animationType", "fraction", DomainData.DOMAIN_NAME, "i", "initialTouchX", "f", "animateDx", "animateDy", "", "d", "mDy", "height", tl.h.F, "mInitialTouchX", "mRecyclerView", "prevSelected", "g", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter;", "a", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter;", "getRvAdapter", "()Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter;", "rvAdapter", "Lkotlin/Function1;", "Lol3/b;", "b", "Lkotlin/jvm/functions/Function1;", "getSendIntent", "()Lkotlin/jvm/functions/Function1;", "sendIntent", "Z", "swipedEnable", "<init>", "(Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter;Lkotlin/jvm/functions/Function1;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends ItemSwipeSendDecoration.c {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f112090e = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildPhotoPanelAdapter rvAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<ol3.b, Unit> sendIntent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean swipedEnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/panel/photo/d$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 20.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull GuildPhotoPanelAdapter rvAdapter, @NotNull Function1<? super ol3.b, Unit> sendIntent) {
        Intrinsics.checkNotNullParameter(rvAdapter, "rvAdapter");
        Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
        this.rvAdapter = rvAdapter;
        this.sendIntent = sendIntent;
        this.swipedEnable = true;
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public long d(@NotNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        return 300L;
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public int e(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemSwipeSendDecoration.c.k(0, 1);
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public float f(float initialTouchX, float initialTouchY, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return initialTouchY / viewHolder.itemView.getHeight();
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public float g(float mInitialTouchX, @NotNull RecyclerView mRecyclerView, @NotNull RecyclerView.ViewHolder prevSelected) {
        Intrinsics.checkNotNullParameter(mRecyclerView, "mRecyclerView");
        Intrinsics.checkNotNullParameter(prevSelected, "prevSelected");
        return -prevSelected.itemView.getX();
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public float h(float mDy, int height) {
        return Math.signum(mDy) * height;
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    /* renamed from: i, reason: from getter */
    public boolean getSwipedEnable() {
        return this.swipedEnable;
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public void m(@NotNull Canvas c16, @NotNull RecyclerView recyclerView, @Nullable RecyclerView.ViewHolder viewHolder, float dX, float dY, float initialTouchY, int actionState, boolean isCurrentlyActive) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.sendIntent.invoke(new c.b(isCurrentlyActive, Math.abs(dY) / initialTouchY));
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public void n(@Nullable Canvas c16, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, int animationType, float fraction, boolean isCurrentlyActive) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.n(c16, recyclerView, viewHolder, dX, dY, actionState, animationType, fraction, isCurrentlyActive);
        if (animationType == 2) {
            this.swipedEnable = false;
            View view = viewHolder.itemView;
            double d16 = 1;
            double d17 = fraction;
            view.setAlpha((float) (d16 - (0.5d * d17)));
            float f16 = (float) (d16 - (d17 * 0.3d));
            view.setScaleX(f16);
            view.setScaleY(f16);
            view.setClipToOutline(true);
            view.setOutlineProvider(f112090e);
        }
    }

    @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public void q(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.sendIntent.invoke(new c.i(((h) viewHolder).s()));
        GuildPhotoPanelAdapter guildPhotoPanelAdapter = this.rvAdapter;
        if (guildPhotoPanelAdapter != null) {
            guildPhotoPanelAdapter.notifyDataSetChanged();
        }
        this.swipedEnable = true;
    }
}
