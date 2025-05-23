package com.tencent.state.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleColor;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareAvatarBubbleBinding;
import com.tencent.state.square.databinding.VasSquareAvatarBubbleSimpleBinding;
import com.tencent.state.square.like.IStickersChangedListener;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.utils.ColorFormatUtils;
import com.tencent.state.utils.ViewUtils;
import com.tencent.state.view.AvatarOnlineStatusSimpleBubble;
import com.tencent.state.view.ICommonBubbleMainContainer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002;<B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\b\u0010 \u001a\u00020\u0018H\u0002J\u0006\u0010!\u001a\u00020\u0012J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0016\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aJN\u0010&\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u0018J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u000207H\u0016J\u001a\u00108\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010:\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/tencent/state/view/AvatarOnlineStatusSimpleBubble;", "Landroid/widget/LinearLayout;", "Lcom/tencent/state/view/IAvatarBubble;", "Lcom/tencent/state/view/SimpleBubbleReadyListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarBubbleBinding;", ParseCommon.CONTAINER, "Lcom/tencent/state/view/AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer;", "isMe", "", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "reporter", "Lcom/tencent/state/square/IReporter;", "bindLocationInfo", "", "uin", "", "location", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "getData", "getSongPlayIcon", "Landroid/widget/ImageView;", "hideLocation", "isLocationVisible", "onBubbleStateChange", "ready", "reportLocation", "poiId", "setData", "status", c.B, "Lcom/tencent/state/square/data/Stickers;", "stickersChangedListener", "Lcom/tencent/state/square/like/IStickersChangedListener;", "relationType", "Lcom/tencent/state/square/data/RelationType;", "needShowAnimation", "isPoster", "locationInfo", "setElementEventListener", "listener", "Lcom/tencent/state/view/BubbleElementEventListener;", "showLocation", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updatePlayIcon", "songMid", VasPerfReportUtils.WHILE_UPDATE_ITEM, "AvatarSimpleBubbleContainer", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarOnlineStatusSimpleBubble extends LinearLayout implements IAvatarBubble, SimpleBubbleReadyListener {
    private static final float MIN_ALPHA = 0.0f;
    private static final String TAG = "AvatarOnlineStatusSimpleBubble";
    private final VasSquareAvatarBubbleBinding binding;
    private final AvatarSimpleBubbleContainer container;
    private boolean isMe;
    private OnlineStatus onlineStatus;
    private IReporter reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarOnlineStatusSimpleBubble(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareAvatarBubbleBinding inflate = VasSquareAvatarBubbleBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AvatarSimpleBubbleContainer avatarSimpleBubbleContainer = new AvatarSimpleBubbleContainer(this, context2);
        avatarSimpleBubbleContainer.setListener(this);
        Unit unit = Unit.INSTANCE;
        this.container = avatarSimpleBubbleContainer;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        setVisibility(8);
        inflate.onlineStatusAvatarBubbleMsg.addView(avatarSimpleBubbleContainer, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout relativeLayout = inflate.onlineStatusAvatarBubbleMain;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.onlineStatusAvatarBubbleMain");
        ViewExtensionsKt.updateLayoutParams(relativeLayout, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                int dip = com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 5.0f);
                updateLayoutParams.setMargins(dip, dip, dip, dip);
            }
        });
        LinearLayout linearLayout = inflate.onlineStatusAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.onlineStatusAvatarBubble");
        linearLayout.setMinimumWidth(com.tencent.state.square.common.ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 35));
    }

    private final void hideLocation() {
        LinearLayout linearLayout = this.binding.onlineLbsContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.onlineLbsContainer");
        linearLayout.setVisibility(8);
        RoundImageView roundImageView = this.binding.iconLbsEntrance;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.iconLbsEntrance");
        roundImageView.setVisibility(8);
        TextView textView = this.binding.lbsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.lbsTextView");
        textView.setVisibility(8);
    }

    private final void updateView(AvatarLocationInfo locationInfo) {
        OnlineStatus onlineStatus = this.onlineStatus;
        if (onlineStatus != null) {
            this.container.showView(onlineStatus, this.isMe, locationInfo);
        }
    }

    public final void bindLocationInfo(final String uin, final AvatarLocationInfo location) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(location, "location");
        if (location.getPoi().length() == 0) {
            hideLocation();
            return;
        }
        showLocation();
        TextView textView = this.binding.lbsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.lbsTextView");
        textView.setText(location.getPoi());
        this.binding.iconLbsEntrance.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble$bindLocationInfo$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding;
                Map<String, Object> mutableMapOf;
                IRouter router = Square.INSTANCE.getConfig().getRouter();
                Context context = AvatarOnlineStatusSimpleBubble.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                router.routeToMapPage(context, location.getLongitude(), location.getLatitude(), location.getPoi(), location.getPoiId(), location.getPoiAddress());
                IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
                vasSquareAvatarBubbleBinding = AvatarOnlineStatusSimpleBubble.this.binding;
                RoundImageView roundImageView = vasSquareAvatarBubbleBinding.iconLbsEntrance;
                Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.iconLbsEntrance");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", uin), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POI_ID, location.getPoiId()));
                reporter.reportEvent("clck", roundImageView, mutableMapOf);
            }
        });
    }

    @Override // com.tencent.state.view.IAvatarBubble
    /* renamed from: getData, reason: from getter */
    public OnlineStatus getOnlineStatus() {
        return this.onlineStatus;
    }

    public final ImageView getSongPlayIcon() {
        return this.container.getSongPlayIconView();
    }

    public final boolean isLocationVisible() {
        RoundImageView roundImageView = this.binding.iconLbsEntrance;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.iconLbsEntrance");
        return roundImageView.getVisibility() == 0;
    }

    @Override // com.tencent.state.view.IAvatarBubble
    /* renamed from: isMe, reason: from getter */
    public boolean getIsMe() {
        return this.isMe;
    }

    public final void reportLocation(String uin, String poiId) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", uin), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POI_ID, poiId), TuplesKt.to("pgid", SquareReportConst.PageId.INSTANCE.checkNearby()));
        IReporter iReporter = this.reporter;
        RoundImageView roundImageView = this.binding.iconLbsEntrance;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.iconLbsEntrance");
        iReporter.setElementInfo(roundImageView, SquareReportConst.ElementId.ELEMENT_ID_ZPLAN_AVATAR_LOCATION, mutableMapOf, false, false);
        IReporter iReporter2 = this.reporter;
        RoundImageView roundImageView2 = this.binding.iconLbsEntrance;
        Intrinsics.checkNotNullExpressionValue(roundImageView2, "binding.iconLbsEntrance");
        iReporter2.reportEvent("imp", roundImageView2, mutableMapOf);
    }

    @Override // com.tencent.state.view.IAvatarBubble
    public void setData(String uin, OnlineStatus status, Stickers stickers, IStickersChangedListener stickersChangedListener, RelationType relationType, boolean needShowAnimation, boolean isPoster, AvatarLocationInfo locationInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(relationType, "relationType");
        if (needShowAnimation && getVisibility() != 0) {
            AnimationUtils.INSTANCE.startAlphaAnimation(this, true, 400L, new AnimatorListenerAdapter() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble$setData$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    AvatarOnlineStatusSimpleBubble.this.setAlpha(0.0f);
                    AvatarOnlineStatusSimpleBubble.this.setVisibility(0);
                }
            });
        } else {
            setVisibility(0);
        }
        this.onlineStatus = status;
        this.isMe = CommonDataKt.isMe(Long.parseLong(uin));
        updateView(locationInfo);
    }

    public final void setElementEventListener(BubbleElementEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.container.setElementEventListener(listener);
    }

    public final void showLocation() {
        LinearLayout linearLayout = this.binding.onlineLbsContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.onlineLbsContainer");
        linearLayout.setVisibility(0);
        RoundImageView roundImageView = this.binding.iconLbsEntrance;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.iconLbsEntrance");
        roundImageView.setVisibility(0);
        TextView textView = this.binding.lbsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.lbsTextView");
        textView.setVisibility(0);
    }

    @Override // com.tencent.state.view.IAvatarBubble
    public void updateBubbleSkin(final SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.binding.onlineStatusAvatarBubble.post(new Runnable() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble$updateBubbleSkin$1
            @Override // java.lang.Runnable
            public final void run() {
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding;
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding2;
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding3;
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding4;
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding5;
                AvatarOnlineStatusSimpleBubble.AvatarSimpleBubbleContainer avatarSimpleBubbleContainer;
                if (SquareBubbleSkinKt.useDefault(bubbleInfo)) {
                    vasSquareAvatarBubbleBinding = AvatarOnlineStatusSimpleBubble.this.binding;
                    LinearLayout linearLayout = vasSquareAvatarBubbleBinding.onlineStatusAvatarBubble;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.onlineStatusAvatarBubble");
                    linearLayout.setBackground(AvatarOnlineStatusSimpleBubble.this.getContext().getDrawable(R.drawable.grh));
                    vasSquareAvatarBubbleBinding2 = AvatarOnlineStatusSimpleBubble.this.binding;
                    vasSquareAvatarBubbleBinding2.bubbleArrow.setImageDrawable(AvatarOnlineStatusSimpleBubble.this.getContext().getDrawable(R.drawable.gw9));
                    vasSquareAvatarBubbleBinding3 = AvatarOnlineStatusSimpleBubble.this.binding;
                    vasSquareAvatarBubbleBinding3.onlineStatusAvatarBubbleMain.setPadding(0, 0, 0, 0);
                    vasSquareAvatarBubbleBinding4 = AvatarOnlineStatusSimpleBubble.this.binding;
                    vasSquareAvatarBubbleBinding4.onlineLbsContainer.setPadding(0, 0, 0, 0);
                    vasSquareAvatarBubbleBinding5 = AvatarOnlineStatusSimpleBubble.this.binding;
                    vasSquareAvatarBubbleBinding5.iconLbsEntrance.setRadius(com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 9));
                } else {
                    final int dip = com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 8);
                    BubbleSkinDownloadManager bubbleSkinDownloadManager = BubbleSkinDownloadManager.INSTANCE;
                    Context context = AvatarOnlineStatusSimpleBubble.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    bubbleSkinDownloadManager.loadBubbleNinePatchDrawable(context, new Function1<Bitmap, Unit>() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble$updateBubbleSkin$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                            invoke2(bitmap);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Bitmap bitmap) {
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding6;
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding7;
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding8;
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding9;
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding10;
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            Context context2 = AvatarOnlineStatusSimpleBubble.this.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context2.getResources(), bubbleInfo.getBitmap(), bitmap.getNinePatchChunk(), null, null);
                            vasSquareAvatarBubbleBinding6 = AvatarOnlineStatusSimpleBubble.this.binding;
                            LinearLayout linearLayout2 = vasSquareAvatarBubbleBinding6.onlineStatusAvatarBubble;
                            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.onlineStatusAvatarBubble");
                            linearLayout2.setBackground(ninePatchDrawable);
                            ViewUtils viewUtils = ViewUtils.INSTANCE;
                            String arrow = bubbleInfo.getArrow();
                            vasSquareAvatarBubbleBinding7 = AvatarOnlineStatusSimpleBubble.this.binding;
                            SquareImageView squareImageView = vasSquareAvatarBubbleBinding7.bubbleArrow;
                            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubbleArrow");
                            viewUtils.loadImageDrawable(arrow, squareImageView);
                            vasSquareAvatarBubbleBinding8 = AvatarOnlineStatusSimpleBubble.this.binding;
                            RelativeLayout relativeLayout = vasSquareAvatarBubbleBinding8.onlineStatusAvatarBubbleMain;
                            int i3 = dip;
                            relativeLayout.setPadding(i3, 0, i3, 0);
                            vasSquareAvatarBubbleBinding9 = AvatarOnlineStatusSimpleBubble.this.binding;
                            vasSquareAvatarBubbleBinding9.onlineLbsContainer.setPadding(com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 7), com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 0.5f), 0, com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 0.5f));
                            vasSquareAvatarBubbleBinding10 = AvatarOnlineStatusSimpleBubble.this.binding;
                            vasSquareAvatarBubbleBinding10.iconLbsEntrance.setRadius(com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 6));
                        }
                    });
                }
                avatarSimpleBubbleContainer = AvatarOnlineStatusSimpleBubble.this.container;
                avatarSimpleBubbleContainer.updateBubbleSkin(bubbleInfo);
            }
        });
    }

    @Override // com.tencent.state.view.IAvatarBubble
    public void updatePlayIcon(String songMid, boolean isMe) {
        this.container.updatePlayIcon(songMid, isMe);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010-\u001a\u0004\u0018\u00010%H\u0016J\"\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0002J\"\u00106\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0002J \u00107\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105J\"\u00108\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u000e\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020=R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u0016\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006>"}, d2 = {"Lcom/tencent/state/view/AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer;", "Lcom/tencent/state/view/AvatarBubbleSongContainer;", "Lcom/tencent/state/view/ICommonBubbleMainContainer;", "context", "Landroid/content/Context;", "(Lcom/tencent/state/view/AvatarOnlineStatusSimpleBubble;Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Lcom/tencent/state/view/AvatarOnlineStatusSimpleBubble;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/state/view/AvatarOnlineStatusSimpleBubble;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarBubbleSimpleBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareAvatarBubbleSimpleBinding;", "listener", "Lcom/tencent/state/view/SimpleBubbleReadyListener;", "getListener", "()Lcom/tencent/state/view/SimpleBubbleReadyListener;", "setListener", "(Lcom/tencent/state/view/SimpleBubbleReadyListener;)V", "simpleSmallIcon", "Landroid/widget/ImageView;", "getSimpleSmallIcon", "()Landroid/widget/ImageView;", "simpleText", "Landroid/widget/TextView;", "getSimpleText", "()Landroid/widget/TextView;", "simpleTextContainer", "Landroid/widget/FrameLayout;", "getSimpleTextContainer", "()Landroid/widget/FrameLayout;", "songPlayIcon", "getSongPlayIcon", "songText", "Lcom/tencent/state/view/MarqueeTextView;", "getSongText", "()Lcom/tencent/state/view/MarqueeTextView;", "getCommonMainContainerView", "Landroid/view/View;", "getSimpleSmallIconView", "getSimpleTextView", "getSongPlayIconView", "getSongTextView", "showSongBubble", "", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "isMe", "", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "showTextBubble", "showView", "updateBubbleIcon", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class AvatarSimpleBubbleContainer extends AvatarBubbleSongContainer implements ICommonBubbleMainContainer {
        private final VasSquareAvatarBubbleSimpleBinding binding;
        private SimpleBubbleReadyListener listener;
        final /* synthetic */ AvatarOnlineStatusSimpleBubble this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AvatarSimpleBubbleContainer(AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = avatarOnlineStatusSimpleBubble;
            VasSquareAvatarBubbleSimpleBinding inflate = VasSquareAvatarBubbleSimpleBinding.inflate(LayoutInflater.from(getContext()), this);
            Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleSim\u2026ater.from(context), this)");
            this.binding = inflate;
        }

        private final ImageView getSimpleSmallIcon() {
            return (ImageView) this.binding.simpleTextContainer.findViewById(R.id.pcm);
        }

        private final TextView getSimpleText() {
            return (TextView) this.binding.simpleTextContainer.findViewById(R.id.pcn);
        }

        private final FrameLayout getSimpleTextContainer() {
            return (FrameLayout) this.binding.simpleTextContainer.findViewById(R.id.pcp);
        }

        private final ImageView getSongPlayIcon() {
            return (ImageView) this.binding.simpleSongContainer.findViewById(R.id.pbs);
        }

        private final MarqueeTextView getSongText() {
            return (MarqueeTextView) this.binding.simpleSongContainer.findViewById(R.id.pbt);
        }

        private final void showSongBubble(OnlineStatus status, boolean isMe, AvatarLocationInfo locationInfo) {
            String poi;
            LinearLayout linearLayout = this.binding.simpleSongContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.simpleSongContainer");
            linearLayout.setVisibility(0);
            if (!isMe) {
                if (locationInfo != null && (poi = locationInfo.getPoi()) != null) {
                    if (poi.length() > 0) {
                        MarqueeTextView songText = getSongText();
                        if (songText != null) {
                            songText.setMaxWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 15));
                        }
                    }
                }
                MarqueeTextView songText2 = getSongText();
                if (songText2 != null) {
                    songText2.setMaxWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 50));
                }
            }
            bindSongView(status, isMe);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void showTextBubble(OnlineStatus status, boolean isMe, AvatarLocationInfo locationInfo) {
            int i3;
            TextView simpleText;
            String mainText;
            String poi;
            FrameLayout frameLayout = this.binding.simpleTextContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.simpleTextContainer");
            frameLayout.setVisibility(0);
            TextView simpleText2 = getSimpleText();
            if (simpleText2 != null) {
                simpleText2.setMaxLines(2);
            }
            if (locationInfo != null && (poi = locationInfo.getPoi()) != null) {
                if (poi.length() > 0) {
                    i3 = 4;
                    simpleText = getSimpleText();
                    if (simpleText != null) {
                        simpleText.setMaxEms(i3);
                    }
                    mainText = getMainText(true, isMe, status, null);
                    FrameLayout frameLayout2 = (FrameLayout) this.binding.simpleTextContainer.findViewById(R.id.pco);
                    if (mainText.length() <= i3) {
                        if (frameLayout2 != null) {
                            frameLayout2.setPadding(0, 0, 0, 0);
                        }
                    } else if (frameLayout2 != null) {
                        frameLayout2.setPadding(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 3.0f), 0, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 3.0f), 0);
                    }
                    SquareBaseKt.getSquareThread().postOnSubThread(new AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1(this, status, isMe));
                }
            }
            i3 = 6;
            simpleText = getSimpleText();
            if (simpleText != null) {
            }
            mainText = getMainText(true, isMe, status, null);
            FrameLayout frameLayout22 = (FrameLayout) this.binding.simpleTextContainer.findViewById(R.id.pco);
            if (mainText.length() <= i3) {
            }
            SquareBaseKt.getSquareThread().postOnSubThread(new AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1(this, status, isMe));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateBubbleIcon(OnlineStatus status, boolean isMe, Drawable iconDrawable) {
            SimpleBubbleReadyListener simpleBubbleReadyListener;
            SimpleBubbleReadyListener simpleBubbleReadyListener2;
            if ((status.getCustomText().length() == 0) && !OnlineStatusBubbleViewHelperKt.isBatteryStatus(status)) {
                if (iconDrawable == null && (simpleBubbleReadyListener2 = this.listener) != null) {
                    simpleBubbleReadyListener2.onBubbleStateChange(false);
                }
                FrameLayout simpleTextContainer = getSimpleTextContainer();
                if (simpleTextContainer != null) {
                    simpleTextContainer.setVisibility(8);
                }
                TextView simpleText = getSimpleText();
                if (simpleText != null) {
                    simpleText.setVisibility(8);
                }
                ImageView simpleSmallIcon = getSimpleSmallIcon();
                if (simpleSmallIcon != null) {
                    simpleSmallIcon.setVisibility(8);
                }
                SquareImageView squareImageView = this.binding.avatarBubbleIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatarBubbleIcon");
                squareImageView.setVisibility(0);
                this.binding.avatarBubbleIcon.setImageDrawable(iconDrawable);
                return;
            }
            SquareImageView squareImageView2 = this.binding.avatarBubbleIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.avatarBubbleIcon");
            squareImageView2.setVisibility(8);
            if ((ICommonBubbleMainContainer.DefaultImpls.getMainText$default(this, false, isMe, status, null, 8, null).length() == 0) && iconDrawable == null && (simpleBubbleReadyListener = this.listener) != null) {
                simpleBubbleReadyListener.onBubbleStateChange(false);
            }
            ICommonBubbleMainContainer.DefaultImpls.bindSimpleView$default(this, false, status, isMe, iconDrawable, null, 16, null);
        }

        @Override // com.tencent.state.view.ICommonBubbleMainContainer
        public void bindSimpleView(boolean z16, OnlineStatus status, boolean z17, Drawable drawable, String str) {
            Intrinsics.checkNotNullParameter(status, "status");
            ICommonBubbleMainContainer.DefaultImpls.bindSimpleView(this, z16, status, z17, drawable, str);
        }

        public final VasSquareAvatarBubbleSimpleBinding getBinding() {
            return this.binding;
        }

        @Override // com.tencent.state.view.ICommonBubbleMainContainer
        public View getCommonMainContainerView() {
            return getSimpleTextContainer();
        }

        public final SimpleBubbleReadyListener getListener() {
            return this.listener;
        }

        @Override // com.tencent.state.view.ICommonBubbleMainContainer
        public String getMainText(boolean z16, boolean z17, OnlineStatus status, String str) {
            Intrinsics.checkNotNullParameter(status, "status");
            return ICommonBubbleMainContainer.DefaultImpls.getMainText(this, z16, z17, status, str);
        }

        @Override // com.tencent.state.view.ICommonBubbleMainContainer
        public ImageView getSimpleSmallIconView() {
            return getSimpleSmallIcon();
        }

        @Override // com.tencent.state.view.ICommonBubbleMainContainer
        public TextView getSimpleTextView() {
            return getSimpleText();
        }

        @Override // com.tencent.state.view.AvatarBubbleSongContainer
        public ImageView getSongPlayIconView() {
            return getSongPlayIcon();
        }

        @Override // com.tencent.state.view.AvatarBubbleSongContainer
        public MarqueeTextView getSongTextView() {
            return getSongText();
        }

        public final void setListener(SimpleBubbleReadyListener simpleBubbleReadyListener) {
            this.listener = simpleBubbleReadyListener;
        }

        @Override // com.tencent.state.view.ICommonBubbleMainContainer
        public void showSmallIcon(boolean z16, OnlineStatus status, boolean z17, Drawable drawable) {
            Intrinsics.checkNotNullParameter(status, "status");
            ICommonBubbleMainContainer.DefaultImpls.showSmallIcon(this, z16, status, z17, drawable);
        }

        public final void showView(OnlineStatus status, boolean isMe, AvatarLocationInfo locationInfo) {
            Intrinsics.checkNotNullParameter(status, "status");
            if (OnlineStatusBubbleViewHelper.INSTANCE.canShowSong(status)) {
                SquareImageView squareImageView = this.binding.avatarBubbleIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatarBubbleIcon");
                squareImageView.setVisibility(8);
                showSongBubble(status, isMe, locationInfo);
                ICommonBubbleMainContainer.DefaultImpls.showSmallIcon$default(this, false, status, isMe, null, 8, null);
                return;
            }
            LinearLayout linearLayout = this.binding.simpleSongContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.simpleSongContainer");
            linearLayout.setVisibility(8);
            showTextBubble(status, isMe, locationInfo);
        }

        public final void updateBubbleSkin(SquareBubbleInfo bubbleInfo) {
            Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
            if (SquareBubbleSkinKt.useDefault(bubbleInfo)) {
                TextView simpleText = getSimpleText();
                if (simpleText != null) {
                    simpleText.setTextColor(-16777216);
                }
                MarqueeTextView songText = getSongText();
                if (songText != null) {
                    songText.setTextColor(-16777216);
                    return;
                }
                return;
            }
            try {
                ColorFormatUtils colorFormatUtils = ColorFormatUtils.INSTANCE;
                SquareBubbleColor color = bubbleInfo.getColor();
                Integer parse = colorFormatUtils.parse(color != null ? color.getFontColor() : null);
                if (parse != null) {
                    int intValue = parse.intValue();
                    TextView simpleText2 = getSimpleText();
                    if (simpleText2 != null) {
                        simpleText2.setTextColor(intValue);
                    }
                    MarqueeTextView songText2 = getSongText();
                    if (songText2 != null) {
                        songText2.setTextColor(intValue);
                    }
                }
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), AvatarOnlineStatusSimpleBubble.TAG, String.valueOf(th5), null, 4, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AvatarSimpleBubbleContainer(AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble, Context context, AttributeSet attrs) {
            super(context, attrs);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            this.this$0 = avatarOnlineStatusSimpleBubble;
            VasSquareAvatarBubbleSimpleBinding inflate = VasSquareAvatarBubbleSimpleBinding.inflate(LayoutInflater.from(getContext()), this);
            Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleSim\u2026ater.from(context), this)");
            this.binding = inflate;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AvatarSimpleBubbleContainer(AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble, Context context, AttributeSet attrs, int i3) {
            super(context, attrs, i3);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            this.this$0 = avatarOnlineStatusSimpleBubble;
            VasSquareAvatarBubbleSimpleBinding inflate = VasSquareAvatarBubbleSimpleBinding.inflate(LayoutInflater.from(getContext()), this);
            Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleSim\u2026ater.from(context), this)");
            this.binding = inflate;
        }
    }

    @Override // com.tencent.state.view.SimpleBubbleReadyListener
    public void onBubbleStateChange(boolean ready) {
        setVisibility(ready ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarOnlineStatusSimpleBubble(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareAvatarBubbleBinding inflate = VasSquareAvatarBubbleBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AvatarSimpleBubbleContainer avatarSimpleBubbleContainer = new AvatarSimpleBubbleContainer(this, context2);
        avatarSimpleBubbleContainer.setListener(this);
        Unit unit = Unit.INSTANCE;
        this.container = avatarSimpleBubbleContainer;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        setVisibility(8);
        inflate.onlineStatusAvatarBubbleMsg.addView(avatarSimpleBubbleContainer, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout relativeLayout = inflate.onlineStatusAvatarBubbleMain;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.onlineStatusAvatarBubbleMain");
        ViewExtensionsKt.updateLayoutParams(relativeLayout, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                int dip = com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 5.0f);
                updateLayoutParams.setMargins(dip, dip, dip, dip);
            }
        });
        LinearLayout linearLayout = inflate.onlineStatusAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.onlineStatusAvatarBubble");
        linearLayout.setMinimumWidth(com.tencent.state.square.common.ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 35));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarOnlineStatusSimpleBubble(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareAvatarBubbleBinding inflate = VasSquareAvatarBubbleBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AvatarSimpleBubbleContainer avatarSimpleBubbleContainer = new AvatarSimpleBubbleContainer(this, context2);
        avatarSimpleBubbleContainer.setListener(this);
        Unit unit = Unit.INSTANCE;
        this.container = avatarSimpleBubbleContainer;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        setVisibility(8);
        inflate.onlineStatusAvatarBubbleMsg.addView(avatarSimpleBubbleContainer, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout relativeLayout = inflate.onlineStatusAvatarBubbleMain;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.onlineStatusAvatarBubbleMain");
        ViewExtensionsKt.updateLayoutParams(relativeLayout, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                int dip = com.tencent.state.square.common.ViewExtensionsKt.dip(AvatarOnlineStatusSimpleBubble.this.getContext(), 5.0f);
                updateLayoutParams.setMargins(dip, dip, dip, dip);
            }
        });
        LinearLayout linearLayout = inflate.onlineStatusAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.onlineStatusAvatarBubble");
        linearLayout.setMinimumWidth(com.tencent.state.square.common.ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 35));
    }
}
