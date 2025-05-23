package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0012\u001a\u00020\u0007R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010 \u00a8\u0006-"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftLayerView;", "Landroid/widget/FrameLayout;", "", "giftLayerHeight", "giftBannerViewHolderHeight", "giftBannerContainerHeight", "giftPanelHeight", "", "f", "i", "Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "provider", "j", "Landroid/view/View;", "giftBannerViewHolder", "setGiftBannerViewHolder", "giftPanelView", "setGiftPanelView", "g", "d", "Landroid/widget/FrameLayout;", "giftFullScreenEffectContainer", "e", "giftBannerContainer", "", "Z", "isGiftBannerAdded", tl.h.F, "isGiftEffectAdded", "Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "giftSdkProvider", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", BdhLogUtil.LogTag.Tag_Conn, "D", "E", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiGiftLayerView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int giftBannerViewHolderHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int giftBannerContainerHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private int giftPanelHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout giftFullScreenEffectContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout giftBannerContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isGiftBannerAdded;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isGiftEffectAdded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GiftSdkProvider giftSdkProvider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int giftLayerHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGiftLayerView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TimiGiftLayerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f(this$0.giftLayerHeight, this$0.giftBannerViewHolderHeight, this$0.giftBannerContainerHeight, 0);
    }

    private final void f(int giftLayerHeight, int giftBannerViewHolderHeight, int giftBannerContainerHeight, int giftPanelHeight) {
        if (this.giftLayerHeight == giftLayerHeight && this.giftBannerViewHolderHeight == giftBannerViewHolderHeight && this.giftBannerContainerHeight == giftBannerContainerHeight && this.giftPanelHeight == giftPanelHeight) {
            return;
        }
        com.tencent.timi.game.utils.l.e("TimiGiftLayerView", "adjustGiftBanner# giftLayerHeight: " + giftLayerHeight + " giftBannerViewHolderHeight\uff1a " + giftBannerViewHolderHeight + " giftBannerContainerHeight: " + giftBannerContainerHeight + " giftPanelHeight: " + giftPanelHeight);
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
    public static final void h(TimiGiftLayerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f(this$0.giftLayerHeight, this$0.giftBannerViewHolderHeight, this$0.giftBannerContainer.getHeight(), this$0.giftPanelHeight);
    }

    private final void i() {
        GiftSdkProvider giftSdkProvider;
        if (!this.isGiftEffectAdded && (giftSdkProvider = this.giftSdkProvider) != null) {
            this.isGiftEffectAdded = true;
            this.giftFullScreenEffectContainer.addView(giftSdkProvider.e().k(), new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TimiGiftLayerView this$0, View giftBannerViewHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(giftBannerViewHolder, "$giftBannerViewHolder");
        this$0.f(this$0.getHeight(), giftBannerViewHolder.getHeight(), this$0.giftBannerContainerHeight, this$0.giftPanelHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(TimiGiftLayerView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f(this$0.giftLayerHeight, this$0.giftBannerViewHolderHeight, this$0.giftBannerContainerHeight, view.getHeight());
    }

    public static /* synthetic */ void setGiftPanelView$default(TimiGiftLayerView timiGiftLayerView, View view, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = null;
        }
        timiGiftLayerView.setGiftPanelView(view);
    }

    public final void g() {
        if (this.isGiftBannerAdded) {
            return;
        }
        GiftSdkProvider giftSdkProvider = this.giftSdkProvider;
        if (giftSdkProvider != null) {
            this.isGiftBannerAdded = true;
            this.giftBannerContainer.addView(giftSdkProvider.e().b(), new FrameLayout.LayoutParams(-1, -2));
        }
        this.giftBannerContainer.post(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.l
            @Override // java.lang.Runnable
            public final void run() {
                TimiGiftLayerView.h(TimiGiftLayerView.this);
            }
        });
    }

    public final void j(@Nullable GiftSdkProvider provider) {
        this.giftSdkProvider = provider;
        g();
        i();
    }

    public final void setGiftBannerViewHolder(@NotNull final View giftBannerViewHolder) {
        Intrinsics.checkNotNullParameter(giftBannerViewHolder, "giftBannerViewHolder");
        giftBannerViewHolder.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.timi.game.gift.impl.timi.k
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                TimiGiftLayerView.k(TimiGiftLayerView.this, giftBannerViewHolder);
            }
        });
    }

    public final void setGiftPanelView(@Nullable final View giftPanelView) {
        if (giftPanelView == null) {
            f(this.giftLayerHeight, this.giftBannerViewHolderHeight, this.giftBannerContainerHeight, 0);
        } else {
            giftPanelView.post(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.i
                @Override // java.lang.Runnable
                public final void run() {
                    TimiGiftLayerView.l(TimiGiftLayerView.this, giftPanelView);
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
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, fh4.b.b(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID));
        layoutParams2.gravity = 80;
        addView(frameLayout, layoutParams2);
        post(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.j
            @Override // java.lang.Runnable
            public final void run() {
                TimiGiftLayerView.e(TimiGiftLayerView.this);
            }
        });
    }
}
