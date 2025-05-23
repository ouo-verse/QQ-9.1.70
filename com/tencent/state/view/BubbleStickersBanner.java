package com.tencent.state.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.LikeNum;
import com.tencent.state.square.data.StickerItem;
import com.tencent.state.square.data.StickerType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareBubbleStickersBannerBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B-\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0006\u0010 \u001a\u00020\u001cJ\b\u0010!\u001a\u00020\u001cH\u0014J\b\u0010\"\u001a\u00020\u001cH\u0014J\b\u0010#\u001a\u00020\u001cH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/view/BubbleStickersBanner;", "Landroid/widget/FrameLayout;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareBubbleStickersBannerBinding;", "isManualHide", "", "isMe", "mLikeBgMeWidth", "", "mLikeBgUnreadWidth", "mLikeEllipsisLeftMargin", "mLikeEllipsisWidth", "mLikeGap", "mLikeIconWidth", "mMinWidth", "preWidth", "stickerInfo", "Lcom/tencent/state/square/data/Stickers;", "bindData", "", "calcLayout", "Lkotlin/Pair;", c.E, "hide", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onGlobalLayout", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleStickersBanner extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final String TAG = "BubbleStickersBanner";
    private final VasSquareBubbleStickersBannerBinding binding;
    private boolean isManualHide;
    private boolean isMe;
    private float mLikeBgMeWidth;
    private float mLikeBgUnreadWidth;
    private float mLikeEllipsisLeftMargin;
    private float mLikeEllipsisWidth;
    private float mLikeGap;
    private float mLikeIconWidth;
    private float mMinWidth;
    private int preWidth;
    private Stickers stickerInfo;

    public BubbleStickersBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    private final Pair<Integer, Boolean> calcLayout(int len) {
        float max = Math.max(getWidth(), this.mMinWidth);
        float f16 = this.mLikeGap;
        float f17 = this.mLikeIconWidth;
        if (len <= ((int) ((max + f16) / (f17 + f16)))) {
            return new Pair<>(Integer.valueOf(len), Boolean.FALSE);
        }
        return new Pair<>(Integer.valueOf((int) ((max - this.mLikeEllipsisWidth) / (f17 + f16))), Boolean.TRUE);
    }

    public final synchronized void bindData(Stickers stickerInfo, boolean isMe) {
        int i3;
        List emptyList;
        List<StickerItem> items;
        List<LikeNum> likeNums;
        this.stickerInfo = stickerInfo;
        this.isMe = isMe;
        this.isManualHide = false;
        if (stickerInfo == null || (likeNums = stickerInfo.getLikeNums()) == null) {
            i3 = 0;
        } else {
            Iterator<T> it = likeNums.iterator();
            i3 = 0;
            while (it.hasNext()) {
                i3 += ((LikeNum) it.next()).getNum();
            }
        }
        if (stickerInfo == null || (items = stickerInfo.getItems()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            for (Object obj : items) {
                if (((StickerItem) obj).getType() != StickerType.Interact) {
                    emptyList.add(obj);
                }
            }
        }
        this.binding.likeContainer.removeAllViews();
        if (i3 == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Pair<Integer, Boolean> calcLayout = calcLayout(i3);
        int intValue = calcLayout.component1().intValue();
        boolean booleanValue = calcLayout.component2().booleanValue();
        SquareBaseKt.getSquareLog().d(TAG, "\u53ef\u89c1\u70b9\u8d5e " + intValue + TokenParser.SP + booleanValue);
        if (intValue >= emptyList.size()) {
            booleanValue = false;
        }
        int min = Math.min(intValue, emptyList.size());
        for (int i16 = 0; i16 < min; i16++) {
            StickerItem stickerItem = (StickerItem) emptyList.get(i16);
            if (stickerItem != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.binding.likeContainer.addView(new BubbleStickersItem(context, isMe, stickerItem, this.mLikeIconWidth, this.mLikeGap, this.mLikeBgMeWidth, this.mLikeBgUnreadWidth));
            }
        }
        if (booleanValue) {
            SquareImageView squareImageView = new SquareImageView(getContext());
            squareImageView.setImageResource(R.drawable.ib_);
            squareImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            float f16 = this.mLikeEllipsisWidth;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) f16, (int) f16);
            layoutParams.setMarginStart((int) this.mLikeEllipsisLeftMargin);
            Unit unit = Unit.INSTANCE;
            squareImageView.setLayoutParams(layoutParams);
            this.binding.likeContainer.addView(squareImageView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "this.binding.root");
        root.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "this.binding.root");
        root.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.isManualHide || this.preWidth == getWidth()) {
            return;
        }
        SquareBaseKt.getSquareLog().d(TAG, "\u5e03\u5c40\u5bbd\u5ea6\u53d8\u5316 " + this.preWidth + " => " + getWidth());
        this.preWidth = getWidth();
        bindData(this.stickerInfo, this.isMe);
    }

    public BubbleStickersBanner(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
    }

    public final void hide() {
        this.isManualHide = true;
        setVisibility(8);
    }

    public /* synthetic */ BubbleStickersBanner(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleStickersBanner(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareBubbleStickersBannerBinding inflate = VasSquareBubbleStickersBannerBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareBubbleStickersB\u2026ater.from(context), this)");
        this.binding = inflate;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.state.square.R.styleable.BubbleStickersBanner);
        this.mLikeGap = obtainStyledAttributes.getDimension(com.tencent.state.square.R.styleable.BubbleStickersBanner_bsb_item_gap, this.mLikeGap);
        this.mLikeEllipsisWidth = obtainStyledAttributes.getDimension(com.tencent.state.square.R.styleable.BubbleStickersBanner_bsb_ellipsis_width, this.mLikeEllipsisWidth);
        this.mLikeIconWidth = obtainStyledAttributes.getDimension(com.tencent.state.square.R.styleable.BubbleStickersBanner_bsb_item_width, this.mLikeIconWidth);
        this.mMinWidth = obtainStyledAttributes.getDimension(com.tencent.state.square.R.styleable.BubbleStickersBanner_bsb_min_width, this.mMinWidth);
        this.mLikeEllipsisLeftMargin = obtainStyledAttributes.getDimension(com.tencent.state.square.R.styleable.BubbleStickersBanner_bsb_ellipsis_left_margin, this.mLikeEllipsisLeftMargin);
        this.mLikeBgMeWidth = obtainStyledAttributes.getDimension(com.tencent.state.square.R.styleable.BubbleStickersBanner_bsb_item_bg_me_width, this.mLikeBgMeWidth);
        this.mLikeBgUnreadWidth = obtainStyledAttributes.getDimension(com.tencent.state.square.R.styleable.BubbleStickersBanner_bsb_item_bg_unread_width, this.mLikeBgUnreadWidth);
        obtainStyledAttributes.recycle();
    }
}
