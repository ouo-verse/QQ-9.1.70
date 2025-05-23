package com.tencent.icgame.game.gift.impl.timi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftLayerView;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uu0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0010\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftLayerView;", "Landroid/widget/FrameLayout;", "", "giftLayerHeight", "giftBannerViewHolderHeight", "giftBannerContainerHeight", "giftPanelHeight", "", "e", "Landroid/view/View;", "giftBannerViewHolder", "setGiftBannerViewHolder", "giftPanelView", "setGiftPanelView", "d", "Landroid/widget/FrameLayout;", "giftFullScreenEffectContainer", "giftBannerContainer", "f", "I", h.F, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TimiGiftLayerView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout giftFullScreenEffectContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout giftBannerContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int giftLayerHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int giftBannerViewHolderHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int giftBannerContainerHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int giftPanelHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGiftLayerView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TimiGiftLayerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e(this$0.giftLayerHeight, this$0.giftBannerViewHolderHeight, this$0.giftBannerContainerHeight, 0);
    }

    private final void e(int giftLayerHeight, int giftBannerViewHolderHeight, int giftBannerContainerHeight, int giftPanelHeight) {
        if (this.giftLayerHeight == giftLayerHeight && this.giftBannerViewHolderHeight == giftBannerViewHolderHeight && this.giftBannerContainerHeight == giftBannerContainerHeight && this.giftPanelHeight == giftPanelHeight) {
            return;
        }
        g.d("ICGameGiftLayerView", "adjustGiftBanner# giftLayerHeight: " + giftLayerHeight + " giftBannerViewHolderHeight\uff1a " + giftBannerViewHolderHeight + " giftBannerContainerHeight: " + giftBannerContainerHeight + " giftPanelHeight: " + giftPanelHeight);
        this.giftLayerHeight = giftLayerHeight;
        this.giftBannerViewHolderHeight = giftBannerViewHolderHeight;
        this.giftBannerContainerHeight = giftBannerContainerHeight;
        this.giftPanelHeight = giftPanelHeight;
        int i3 = giftLayerHeight - giftBannerViewHolderHeight;
        int i16 = giftLayerHeight - giftPanelHeight;
        if (giftPanelHeight == 0) {
            this.giftBannerContainer.setTranslationY(i3);
            return;
        }
        if (giftBannerContainerHeight > 0 && giftPanelHeight > 0) {
            if (i16 - i3 < giftBannerContainerHeight) {
                this.giftBannerContainer.setTranslationY(i16 - giftBannerContainerHeight);
            } else {
                this.giftBannerContainer.setTranslationY(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TimiGiftLayerView this$0, View giftBannerViewHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(giftBannerViewHolder, "$giftBannerViewHolder");
        this$0.e(this$0.getHeight(), giftBannerViewHolder.getHeight(), this$0.giftBannerContainerHeight, this$0.giftPanelHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TimiGiftLayerView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e(this$0.giftLayerHeight, this$0.giftBannerViewHolderHeight, this$0.giftBannerContainerHeight, view.getHeight());
    }

    public static /* synthetic */ void setGiftPanelView$default(TimiGiftLayerView timiGiftLayerView, View view, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = null;
        }
        timiGiftLayerView.setGiftPanelView(view);
    }

    public final void setGiftBannerViewHolder(@NotNull final View giftBannerViewHolder) {
        Intrinsics.checkNotNullParameter(giftBannerViewHolder, "giftBannerViewHolder");
        giftBannerViewHolder.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: av0.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                TimiGiftLayerView.f(TimiGiftLayerView.this, giftBannerViewHolder);
            }
        });
    }

    public final void setGiftPanelView(@Nullable final View giftPanelView) {
        if (giftPanelView == null) {
            e(this.giftLayerHeight, this.giftBannerViewHolderHeight, this.giftBannerContainerHeight, 0);
        } else {
            giftPanelView.post(new Runnable() { // from class: av0.d
                @Override // java.lang.Runnable
                public final void run() {
                    TimiGiftLayerView.g(TimiGiftLayerView.this, giftPanelView);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGiftLayerView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TimiGiftLayerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGiftLayerView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.giftFullScreenEffectContainer = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.giftBannerContainer = frameLayout2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        Unit unit = Unit.INSTANCE;
        addView(frameLayout2, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, a.b(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID));
        layoutParams2.gravity = 80;
        addView(frameLayout, layoutParams2);
        post(new Runnable() { // from class: av0.c
            @Override // java.lang.Runnable
            public final void run() {
                TimiGiftLayerView.d(TimiGiftLayerView.this);
            }
        });
    }
}
