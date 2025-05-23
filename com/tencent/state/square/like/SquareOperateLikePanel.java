package com.tencent.state.square.like;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.StickerItem;
import com.tencent.state.square.data.StickerType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.view.SquareImageView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0011J\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001aJ\u0006\u0010)\u001a\u00020\u001aJ\u0019\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020%H\u0002J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010,H\u0016J\"\u00101\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001a2\b\b\u0002\u00102\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020%R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0001`\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00066"}, d2 = {"Lcom/tencent/state/square/like/SquareOperateLikePanel;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "uin", "", "operateLikeEnabled", "", c.B, "Lcom/tencent/state/square/data/Stickers;", "callback", "Lcom/tencent/state/square/like/IStickersChangedListener;", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/String;ZLcom/tencent/state/square/data/Stickers;Lcom/tencent/state/square/like/IStickersChangedListener;)V", "avatarContainer", "Landroid/widget/RelativeLayout;", "getCallback", "()Lcom/tencent/state/square/like/IStickersChangedListener;", "controller", "Lcom/tencent/state/square/like/SquareOperateLikeController;", "currentResult", "Lcom/tencent/state/square/like/CheckLikedResult;", "iconMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "pagViewContainer", "Landroid/widget/FrameLayout;", "getStickers", "()Lcom/tencent/state/square/data/Stickers;", "getUin", "()Ljava/lang/String;", "bindComposedAvatarContainer", "", ParseCommon.CONTAINER, "cancelLikeType", "likeType", "getCurrentSelectedType", "getLikeType", "view", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Integer;", "initClickListener", NodeProps.ON_CLICK, "v", "setSelectLikeType", QZoneJsConstants.METHOD_PLAY, "phoneShake", VasPerfReportUtils.WHILE_UPDATE_ITEM, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOperateLikePanel extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "SquareOperateLikePanel";
    private RelativeLayout avatarContainer;
    private final IStickersChangedListener callback;
    private final SquareOperateLikeController controller;
    private CheckLikedResult currentResult;
    private HashMap<Integer, LinearLayout> iconMap;
    private final boolean operateLikeEnabled;
    private ISquarePagView pagView;
    private FrameLayout pagViewContainer;
    private final Stickers stickers;
    private final String uin;

    public /* synthetic */ SquareOperateLikePanel(Context context, AttributeSet attributeSet, String str, boolean z16, Stickers stickers, IStickersChangedListener iStickersChangedListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, str, (i3 & 8) != 0 ? true : z16, stickers, iStickersChangedListener);
    }

    private final void initClickListener() {
        Iterator<Map.Entry<Integer, LinearLayout>> it = this.iconMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setOnClickListener(this);
        }
    }

    public final void bindComposedAvatarContainer(RelativeLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.avatarContainer = container;
        if (container != null) {
            if (this.pagViewContainer == null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                this.pagViewContainer = frameLayout;
                frameLayout.setClickable(false);
                FrameLayout frameLayout2 = this.pagViewContainer;
                if (frameLayout2 != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    Unit unit = Unit.INSTANCE;
                    frameLayout2.setLayoutParams(layoutParams);
                }
                container.addView(this.pagViewContainer);
                FrameLayout frameLayout3 = this.pagViewContainer;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(8);
                }
            }
            if (this.pagView == null) {
                ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ISquarePagView pagView = commonUtils.getPagView(context);
                this.pagView = pagView;
                if (pagView != null) {
                    FrameLayout frameLayout4 = this.pagViewContainer;
                    if (frameLayout4 != null) {
                        View view = pagView.getView();
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                        layoutParams2.setMargins(0, ViewExtensionsKt.dip(getContext(), 70), 0, 0);
                        Unit unit2 = Unit.INSTANCE;
                        frameLayout4.addView(view, layoutParams2);
                    }
                    pagView.setPagViewListener(new ISquarePagViewListener() { // from class: com.tencent.state.square.like.SquareOperateLikePanel$bindComposedAvatarContainer$$inlined$let$lambda$1
                        @Override // com.tencent.state.square.api.ISquarePagViewListener
                        public void onAnimationCancel(ISquarePagView iSquarePagView) {
                            ISquarePagViewListener.DefaultImpls.onAnimationCancel(this, iSquarePagView);
                        }

                        @Override // com.tencent.state.square.api.ISquarePagViewListener
                        public void onAnimationEnd(ISquarePagView squarePagView) {
                            FrameLayout frameLayout5;
                            frameLayout5 = SquareOperateLikePanel.this.pagViewContainer;
                            if (frameLayout5 != null) {
                                frameLayout5.setVisibility(8);
                            }
                        }

                        @Override // com.tencent.state.square.api.ISquarePagViewListener
                        public void onAnimationRepeat(ISquarePagView iSquarePagView) {
                            ISquarePagViewListener.DefaultImpls.onAnimationRepeat(this, iSquarePagView);
                        }

                        @Override // com.tencent.state.square.api.ISquarePagViewListener
                        public void onAnimationStart(ISquarePagView squarePagView) {
                            FrameLayout frameLayout5;
                            frameLayout5 = SquareOperateLikePanel.this.pagViewContainer;
                            if (frameLayout5 != null) {
                                frameLayout5.setVisibility(0);
                            }
                        }

                        @Override // com.tencent.state.square.api.ISquarePagViewListener
                        public void onAnimationUpdate(ISquarePagView iSquarePagView) {
                            ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView);
                        }
                    });
                }
            }
        }
    }

    public final IStickersChangedListener getCallback() {
        return this.callback;
    }

    public final int getCurrentSelectedType() {
        for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
            if (entry.getValue().isSelected()) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    public final Stickers getStickers() {
        return this.stickers;
    }

    public final String getUin() {
        return this.uin;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateView() {
        boolean z16;
        List<StickerItem> items;
        Object obj;
        Stickers stickers = this.stickers;
        if (stickers != null && (items = stickers.getItems()) != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                z16 = true;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                StickerItem stickerItem = (StickerItem) obj;
                if (stickerItem.getType() == StickerType.Like && stickerItem.isMe()) {
                    break;
                }
            }
            StickerItem stickerItem2 = (StickerItem) obj;
            if (stickerItem2 != null) {
                setSelectLikeType$default(this, stickerItem2.getLikeType(), false, false, 6, null);
                if (z16) {
                    cancelLikeType(StickerType.Like.ordinal());
                    LinearLayout heartContainer = (LinearLayout) findViewById(R.id.pz6);
                    Intrinsics.checkNotNullExpressionValue(heartContainer, "heartContainer");
                    heartContainer.setVisibility(0);
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareOperateLikePanel(Context context, AttributeSet attributeSet, String uin, boolean z16, Stickers stickers, IStickersChangedListener iStickersChangedListener) {
        super(context, attributeSet);
        Long longOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.operateLikeEnabled = z16;
        this.stickers = stickers;
        this.callback = iStickersChangedListener;
        this.iconMap = new HashMap<>();
        SquareOperateLikeController squareOperateLikeController = new SquareOperateLikeController(this);
        this.controller = squareOperateLikeController;
        LayoutInflater.from(context).inflate(R.layout.d6u, (ViewGroup) this, true);
        AbstractMap abstractMap = this.iconMap;
        View findViewById = findViewById(R.id.pz6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.heart)");
        abstractMap.put(1, findViewById);
        View findViewById2 = findViewById(R.id.q5c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<SquareImageView>(R.id.like_selected)");
        ((SquareImageView) findViewById2).setVisibility(8);
        initClickListener();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        squareOperateLikeController.initData(longOrNull != null ? longOrNull.longValue() : -1L);
        updateView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Map<String, Object> mutableMapOf;
        if (v3 != null) {
            if (!this.operateLikeEnabled) {
                ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ICommonUtils.DefaultImpls.showToast$default(commonUtils, context, "\u6210\u4e3a\u597d\u53cb\u540e\u624d\u80fd\u70b9\u8d5e\u54e6", 0, 4, (Object) null);
                return;
            }
            Integer likeType = getLikeType(v3);
            if (likeType != null) {
                int intValue = likeType.intValue();
                boolean isSelected = v3.isSelected();
                this.controller.onItemClick(v3, intValue);
                IReporter reporter = Square.INSTANCE.getConfig().getReporter();
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.to("zplan_action_type", "click");
                pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_CUSTOMER_LIKE_TYPE, Integer.valueOf(intValue));
                pairArr[2] = TuplesKt.to("zplan_button_display_type", Integer.valueOf(!isSelected ? 1 : 0));
                pairArr[3] = TuplesKt.to("zplan_other_user_qq", this.uin);
                CheckLikedResult checkLikedResult = this.currentResult;
                pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LIKE_NUM, Integer.valueOf(checkLikedResult != null ? checkLikedResult.getLocalLikedCount() : 0));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_CUSTOMER_LIKE_ICON, mutableMapOf);
            }
        }
    }

    private final Integer getLikeType(View view) {
        if (view != null) {
            for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
                if (Intrinsics.areEqual(entry.getValue(), view)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public final void cancelLikeType(int likeType) {
        if (likeType == -1) {
            return;
        }
        for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
            if (entry.getKey().intValue() == StickerType.Like.ordinal() && entry.getValue().isSelected()) {
                entry.getValue().setSelected(false);
                View findViewById = findViewById(R.id.q5c);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<SquareImageView>(R.id.like_selected)");
                ((SquareImageView) findViewById).setVisibility(8);
            }
        }
    }

    public final void setSelectLikeType(int likeType, boolean playAnimation, boolean phoneShake) {
        if (likeType == -1) {
            return;
        }
        Iterator<Map.Entry<Integer, LinearLayout>> it = this.iconMap.entrySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, LinearLayout> next = it.next();
            LinearLayout value = next.getValue();
            if (StickerType.Like.ordinal() != next.getKey().intValue()) {
                z16 = false;
            }
            value.setSelected(z16);
        }
        if (playAnimation) {
            for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
                if (entry.getValue().isSelected() && StickerType.Like.ordinal() == entry.getKey().intValue()) {
                    final SquareImageView likeSelectedView = (SquareImageView) findViewById(R.id.q5c);
                    Intrinsics.checkNotNullExpressionValue(likeSelectedView, "likeSelectedView");
                    likeSelectedView.setVisibility(0);
                    final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pz6);
                    ValueAnimator firstAnimator = ValueAnimator.ofFloat(0.0f, 1.3f);
                    Intrinsics.checkNotNullExpressionValue(firstAnimator, "firstAnimator");
                    firstAnimator.setDuration(230L);
                    ValueAnimator secondAnimator = ValueAnimator.ofFloat(1.3f, 1.0f);
                    Intrinsics.checkNotNullExpressionValue(secondAnimator, "secondAnimator");
                    secondAnimator.setDuration(230L);
                    PathInterpolator pathInterpolator = new PathInterpolator(0.34f, 0.0f, 0.66f, 1.0f);
                    firstAnimator.setInterpolator(pathInterpolator);
                    secondAnimator.setInterpolator(pathInterpolator);
                    ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.square.like.SquareOperateLikePanel$setSelectLikeType$2$updateListener$1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
                            Object animatedValue = valueAnimator.getAnimatedValue();
                            if (animatedValue != null) {
                                float floatValue = ((Float) animatedValue).floatValue();
                                SquareImageView likeSelectedView2 = SquareImageView.this;
                                Intrinsics.checkNotNullExpressionValue(likeSelectedView2, "likeSelectedView");
                                likeSelectedView2.setScaleX(floatValue);
                                SquareImageView likeSelectedView3 = SquareImageView.this;
                                Intrinsics.checkNotNullExpressionValue(likeSelectedView3, "likeSelectedView");
                                likeSelectedView3.setScaleY(floatValue);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                        }
                    };
                    firstAnimator.addUpdateListener(animatorUpdateListener);
                    secondAnimator.addUpdateListener(animatorUpdateListener);
                    ValueAnimator translationAnimator = ValueAnimator.ofFloat(0.0f, -156.0f);
                    Intrinsics.checkNotNullExpressionValue(translationAnimator, "translationAnimator");
                    translationAnimator.setDuration(460L);
                    translationAnimator.setInterpolator(new PathInterpolator(0.34f, 0.0f, 0.0f, 1.0f));
                    translationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.square.like.SquareOperateLikePanel$setSelectLikeType$2$1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
                            Object animatedValue = valueAnimator.getAnimatedValue();
                            if (animatedValue != null) {
                                float floatValue = ((Float) animatedValue).floatValue();
                                LinearLayout heartContainer = linearLayout;
                                Intrinsics.checkNotNullExpressionValue(heartContainer, "heartContainer");
                                heartContainer.setTranslationX(floatValue);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                        }
                    });
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playSequentially(translationAnimator);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.state.square.like.SquareOperateLikePanel$setSelectLikeType$2$2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            LinearLayout heartContainer = linearLayout;
                            Intrinsics.checkNotNullExpressionValue(heartContainer, "heartContainer");
                            heartContainer.setVisibility(8);
                            LinearLayout heartContainer2 = linearLayout;
                            Intrinsics.checkNotNullExpressionValue(heartContainer2, "heartContainer");
                            heartContainer2.setTranslationX(0.0f);
                        }
                    });
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playSequentially(firstAnimator, secondAnimator);
                    animatorSet2.addListener(new SquareOperateLikePanel$setSelectLikeType$2$3(linearLayout, animatorSet));
                    animatorSet2.start();
                } else {
                    View findViewById = findViewById(R.id.q5c);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<SquareImageView>(R.id.like_selected)");
                    ((SquareImageView) findViewById).setVisibility(8);
                }
            }
            postDelayed(new SquareOperateLikePanel$setSelectLikeType$3(this, likeType), 230L);
        }
        if (phoneShake) {
            Square.INSTANCE.getConfig().getCommonUtils().phoneVibrate(1, 100L);
        }
    }

    public static /* synthetic */ void setSelectLikeType$default(SquareOperateLikePanel squareOperateLikePanel, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            z17 = false;
        }
        squareOperateLikePanel.setSelectLikeType(i3, z16, z17);
    }
}
