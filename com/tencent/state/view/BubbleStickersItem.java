package com.tencent.state.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.data.StickerItem;
import com.tencent.state.square.data.StickerType;
import com.tencent.state.square.databinding.VasSquareBubbleStickerBannerItemBinding;
import com.tencent.state.square.like.LikeData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/view/BubbleStickersItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "isMe", "", "like", "Lcom/tencent/state/square/data/StickerItem;", "mLikeIconWidth", "", "mLikeGap", "mLikeBgMeWidth", "mLikeBgUnreadWidth", "(Landroid/content/Context;ZLcom/tencent/state/square/data/StickerItem;FFFF)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareBubbleStickerBannerItemBinding;", "()Z", "getLike", "()Lcom/tencent/state/square/data/StickerItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleStickersItem extends FrameLayout {
    private final VasSquareBubbleStickerBannerItemBinding binding;
    private final boolean isMe;
    private final StickerItem like;
    private float mLikeBgMeWidth;
    private float mLikeBgUnreadWidth;
    private float mLikeGap;
    private float mLikeIconWidth;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StickerType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[StickerType.Like.ordinal()] = 1;
            iArr[StickerType.Interact.ordinal()] = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleStickersItem(Context context, boolean z16, StickerItem like, float f16, float f17, float f18, float f19) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(like, "like");
        this.isMe = z16;
        this.like = like;
        this.mLikeIconWidth = f16;
        this.mLikeGap = f17;
        this.mLikeBgMeWidth = f18;
        this.mLikeBgUnreadWidth = f19;
        VasSquareBubbleStickerBannerItemBinding inflate = VasSquareBubbleStickerBannerItemBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareBubbleStickerBa\u2026ater.from(context), this)");
        this.binding = inflate;
        setClipChildren(false);
        setClipToPadding(false);
        if (z16 && !like.getReaded()) {
            SquareImageView squareImageView = inflate.likeBgUnread;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.likeBgUnread");
            squareImageView.setVisibility(0);
        }
        if (!z16 && like.isMe()) {
            SquareImageView squareImageView2 = inflate.likeBgMe;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.likeBgMe");
            squareImageView2.setVisibility(0);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[like.getType().ordinal()];
        if (i3 == 1) {
            inflate.likeIcon.setImageResource(LikeData.INSTANCE.getIconFromType(like.getLikeType()));
        } else if (i3 == 2) {
            SquareImageView squareImageView3 = inflate.likeIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.likeIcon");
            ViewExtensionsKt.setUri(squareImageView3, like.getIcon());
        }
        FrameLayout frameLayout = inflate.likeItem;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.likeItem");
        ViewExtensionsKt.updateLayoutParams(frameLayout, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.BubbleStickersItem.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = (int) BubbleStickersItem.this.mLikeIconWidth;
                receiver.height = (int) BubbleStickersItem.this.mLikeIconWidth;
                receiver.setMarginEnd((int) BubbleStickersItem.this.mLikeGap);
            }
        });
        SquareImageView squareImageView4 = inflate.likeBgMe;
        Intrinsics.checkNotNullExpressionValue(squareImageView4, "binding.likeBgMe");
        ViewExtensionsKt.updateLayoutParams(squareImageView4, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.BubbleStickersItem.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = (int) BubbleStickersItem.this.mLikeBgMeWidth;
                receiver.height = (int) BubbleStickersItem.this.mLikeBgMeWidth;
            }
        });
        SquareImageView squareImageView5 = inflate.likeBgUnread;
        Intrinsics.checkNotNullExpressionValue(squareImageView5, "binding.likeBgUnread");
        ViewExtensionsKt.updateLayoutParams(squareImageView5, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.BubbleStickersItem.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = (int) BubbleStickersItem.this.mLikeBgUnreadWidth;
                receiver.height = (int) BubbleStickersItem.this.mLikeBgUnreadWidth;
            }
        });
        SquareImageView squareImageView6 = inflate.likeIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView6, "binding.likeIcon");
        ViewExtensionsKt.updateLayoutParams(squareImageView6, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.BubbleStickersItem.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = (int) BubbleStickersItem.this.mLikeIconWidth;
                receiver.height = (int) BubbleStickersItem.this.mLikeIconWidth;
            }
        });
    }

    public final StickerItem getLike() {
        return this.like;
    }

    /* renamed from: isMe, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }
}
