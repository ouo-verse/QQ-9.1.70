package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.AnimListener;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.databinding.ZtpSquareChatLandPkItemBinding;
import com.tencent.state.square.databinding.ZtpSquareChatLandPkPanelBinding;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.SquarePagFileUtils;
import com.tencent.state.view.SquareImageView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0007R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandPKPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareChatLandPkPanelBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/ZtpSquareChatLandPkPanelBinding;", "<set-?>", "", "isAnimating", "()Z", "isPAGAnimating", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "handleClickItems", "event", "Landroid/view/MotionEvent;", "hide", "", "onTouchEvent", "playPAGOnce", "path", "", "playPAGWithURL", "url", "setupPAGView", "show", "updatePAGViewLayoutParam", "id", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandPKPanel extends FrameLayout {
    private static final String AGREE_BACKGROUND_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_agree.png";
    private static final String AGREE_WATERMARK_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_agree_watermark.png";
    private static final long ANIM_TIME = 100;
    private static final String CHECK_ICON_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_check_icon.png";
    private static final String DISAGREE_BACKGROUND_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_disagree.png";
    private static final String DISAGREE_WATERMARK_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_disagree_watermark.png";
    public static final String PARTICLE_PAG_OPPOSE_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_particle_blue.pag";
    public static final String PARTICLE_PAG_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_particle.pag";
    private static final String TAG = "ChatLandPKPanel";
    private static final String TOPIC_ICON_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_pk_topic_icon.png";
    private final ZtpSquareChatLandPkPanelBinding binding;
    private boolean isAnimating;
    private boolean isPAGAnimating;
    private ISquarePagView pagView;

    public ChatLandPKPanel(Context context) {
        this(context, null, 0, 6, null);
    }

    private final boolean handleClickItems(MotionEvent event) {
        List<View> listOf;
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding = this.binding.supportItem;
        Intrinsics.checkNotNullExpressionValue(ztpSquareChatLandPkItemBinding, "binding.supportItem");
        RelativeLayout root = ztpSquareChatLandPkItemBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.supportItem.root");
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding2 = this.binding.opposeItem;
        Intrinsics.checkNotNullExpressionValue(ztpSquareChatLandPkItemBinding2, "binding.opposeItem");
        RelativeLayout root2 = ztpSquareChatLandPkItemBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.opposeItem.root");
        SquareImageView squareImageView = this.binding.closeBtn;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.closeBtn");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{root, root2, squareImageView});
        for (View view : listOf) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            if (rect.contains(rawX, rawY)) {
                view.performClick();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playPAGOnce(String path) {
        ISquarePagView iSquarePagView = this.pagView;
        if (iSquarePagView != null) {
            iSquarePagView.setPagFile(path);
        }
        ISquarePagView iSquarePagView2 = this.pagView;
        if (iSquarePagView2 != null) {
            iSquarePagView2.preparePagRuntime(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandPKPanel$playPAGOnce$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x001e, code lost:
                
                    r4 = r3.this$0.pagView;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(boolean z16) {
                    ISquarePagView iSquarePagView3;
                    SquareBaseKt.getSquareLog().d("ChatLandPKPanel", "ready:" + z16);
                    if (!z16 || iSquarePagView3 == null) {
                        return;
                    }
                    iSquarePagView3.playPag(1);
                }
            });
        }
    }

    private final void setupPAGView() {
        if (this.pagView != null) {
            return;
        }
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        if (pagView != null) {
            this.pagView = pagView;
            pagView.setPagViewListener(new ISquarePagViewListener() { // from class: com.tencent.state.square.chatland.view.ChatLandPKPanel$setupPAGView$1
                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationCancel(ISquarePagView squarePagView) {
                    ChatLandPKPanel.this.hide();
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationEnd(ISquarePagView squarePagView) {
                    ChatLandPKPanel.this.hide();
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationUpdate(ISquarePagView iSquarePagView) {
                    ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView);
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationRepeat(ISquarePagView squarePagView) {
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationStart(ISquarePagView squarePagView) {
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewExtensionsKt.dip(getContext(), 180), ViewExtensionsKt.dip(getContext(), 134));
            layoutParams.addRule(20);
            layoutParams.addRule(12);
            layoutParams.setMarginStart(ViewExtensionsKt.dip(getContext(), 8));
            layoutParams.bottomMargin = ViewExtensionsKt.dip(getContext(), -24);
            RelativeLayout relativeLayout = this.binding.panelContainer;
            ISquarePagView iSquarePagView = this.pagView;
            relativeLayout.addView(iSquarePagView != null ? iSquarePagView.getView() : null, layoutParams);
        }
    }

    public final ZtpSquareChatLandPkPanelBinding getBinding() {
        return this.binding;
    }

    /* renamed from: isAnimating, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    /* renamed from: isPAGAnimating, reason: from getter */
    public final boolean getIsPAGAnimating() {
        return this.isPAGAnimating;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1 && handleClickItems(event)) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    public final void playPAGWithURL(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.isPAGAnimating = true;
        SquarePagFileUtils.INSTANCE.downloadPagFile(url, new ChatLandPKPanel$playPAGWithURL$1(this, url));
    }

    public final void show() {
        if (this.isAnimating) {
            return;
        }
        com.tencent.state.ViewExtensionsKt.setVisibility(this, true);
        this.isAnimating = true;
        com.tencent.state.ViewExtensionsKt.viewAnimate(this).duration(100L).translate(0, 0, -ViewExtensionsKt.dip(getContext(), 150), 0).listener(new AnimListener() { // from class: com.tencent.state.square.chatland.view.ChatLandPKPanel$show$1
            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ChatLandPKPanel.this.isAnimating = false;
            }

            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                AnimListener.DefaultImpls.onAnimationRepeat(this, animation);
            }

            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AnimListener.DefaultImpls.onAnimationStart(this, animation);
            }
        }).start();
    }

    public final void updatePAGViewLayoutParam(final int id5) {
        View view;
        ISquarePagView iSquarePagView = this.pagView;
        if (iSquarePagView == null || (view = iSquarePagView.getView()) == null) {
            return;
        }
        com.tencent.state.ViewExtensionsKt.updateLayoutParams(view, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandPKPanel$updatePAGViewLayoutParam$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.removeRule(20);
                receiver.removeRule(21);
                if (id5 == R.id.qox) {
                    receiver.addRule(20);
                    receiver.setMarginStart(ViewExtensionsKt.dip(ChatLandPKPanel.this.getContext(), 8));
                } else {
                    receiver.addRule(21);
                    receiver.setMarginEnd(ViewExtensionsKt.dip(ChatLandPKPanel.this.getContext(), 8));
                }
            }
        });
    }

    public ChatLandPKPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void hide() {
        this.isPAGAnimating = false;
        if (this.isAnimating || !com.tencent.state.ViewExtensionsKt.isVisible(this)) {
            return;
        }
        this.isAnimating = true;
        com.tencent.state.ViewExtensionsKt.viewAnimate(this).duration(100L).translate(0, 0, 0, -ViewExtensionsKt.dip(getContext(), 150)).listener(new AnimListener() { // from class: com.tencent.state.square.chatland.view.ChatLandPKPanel$hide$1
            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ChatLandPKPanel.this.isAnimating = false;
                com.tencent.state.ViewExtensionsKt.setVisibility(ChatLandPKPanel.this, false);
            }

            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                AnimListener.DefaultImpls.onAnimationRepeat(this, animation);
            }

            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AnimListener.DefaultImpls.onAnimationStart(this, animation);
            }
        }).start();
    }

    public /* synthetic */ ChatLandPKPanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandPKPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        ZtpSquareChatLandPkPanelBinding inflate = ZtpSquareChatLandPkPanelBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "ZtpSquareChatLandPkPanel\u2026ater.from(context), this)");
        this.binding = inflate;
        SquareImageView squareImageView = inflate.supportItem.chooseBackground;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.supportItem.chooseBackground");
        DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
        squareImageView.setBackground(drawableUtil.getDrawable(R.drawable.i7_));
        SquareImageView squareImageView2 = inflate.opposeItem.chooseBackground;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.opposeItem.chooseBackground");
        squareImageView2.setBackground(drawableUtil.getDrawable(R.drawable.i7a));
        SquareImageView squareImageView3 = inflate.pkTopicIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.pkTopicIcon");
        com.tencent.state.ViewExtensionsKt.setUri(squareImageView3, TOPIC_ICON_URL);
        SquareImageView squareImageView4 = inflate.supportItem.chooseSelectedIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView4, "binding.supportItem.chooseSelectedIcon");
        com.tencent.state.ViewExtensionsKt.setUri(squareImageView4, CHECK_ICON_URL);
        SquareImageView squareImageView5 = inflate.opposeItem.chooseSelectedIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView5, "binding.opposeItem.chooseSelectedIcon");
        com.tencent.state.ViewExtensionsKt.setUri(squareImageView5, CHECK_ICON_URL);
        SquareImageView squareImageView6 = inflate.supportItem.chooseWatermark;
        Intrinsics.checkNotNullExpressionValue(squareImageView6, "binding.supportItem.chooseWatermark");
        com.tencent.state.ViewExtensionsKt.setUri(squareImageView6, AGREE_WATERMARK_URL);
        SquareImageView squareImageView7 = inflate.opposeItem.chooseWatermark;
        Intrinsics.checkNotNullExpressionValue(squareImageView7, "binding.opposeItem.chooseWatermark");
        com.tencent.state.ViewExtensionsKt.setUri(squareImageView7, DISAGREE_WATERMARK_URL);
        setupPAGView();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        View root2 = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(context)));
        squareReporter.setPageInfo(root, root2, checkNearby, mutableMapOf);
    }
}
