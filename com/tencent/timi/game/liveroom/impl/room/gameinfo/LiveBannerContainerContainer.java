package com.tencent.timi.game.liveroom.impl.room.gameinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kf4.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nf4.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/LiveBannerContainerContainer;", "Landroid/widget/FrameLayout;", "Lnf4/c;", "Lnf4/c$a;", "bannerState", "", "setBannerStatusListener", "", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/view/View;", "getView", "Lkf4/a;", "guildInfo", "setGuildInfo", "d", "Lnf4/c$a;", "Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/LiveBannerView;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/LiveBannerView;", "liveBannerView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveBannerContainerContainer extends FrameLayout implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c.a bannerState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LiveBannerView liveBannerView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveBannerContainerContainer(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
    }

    @Override // nf4.c
    public void setBannerStatusListener(@Nullable c.a bannerState) {
        this.bannerState = bannerState;
        this.liveBannerView.setBannerState(bannerState);
    }

    public final void setGuildInfo(@Nullable a guildInfo) {
        this.liveBannerView.setCurGuildInfo(guildInfo);
    }

    public /* synthetic */ LiveBannerContainerContainer(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveBannerContainerContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LiveBannerView liveBannerView = new LiveBannerView(context, null, 2, null);
        this.liveBannerView = liveBannerView;
        liveBannerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.liveBannerView.setVisibility(8);
        addView(this.liveBannerView);
    }

    @Override // nf4.c
    @NotNull
    public View getView() {
        return this;
    }
}
