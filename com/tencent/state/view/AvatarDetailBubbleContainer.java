package com.tencent.state.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.Square;
import com.tencent.state.square.bubblesetting.SquareBubbleColor;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareAvatarBubbleDetailBinding;
import com.tencent.state.square.databinding.VasSquareItemBubbleEditableMainContainerBinding;
import com.tencent.state.square.like.CheckLikedResult;
import com.tencent.state.square.like.IStickersChangedListener;
import com.tencent.state.square.like.OperateLikePanel;
import com.tencent.state.utils.ColorFormatUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(H\u0002J$\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(H\u0002J\u0006\u0010,\u001a\u00020$J\u0006\u0010-\u001a\u00020$J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\n\u00102\u001a\u0004\u0018\u00010\nH\u0016J\n\u00103\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u00104\u001a\u0002012\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u0004\u0018\u00010/J>\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020/2\b\u0010+\u001a\u0004\u0018\u00010&2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010)\u001a\u00020(J>\u0010@\u001a\u00020$2\u0006\u00109\u001a\u00020/2\b\u0010+\u001a\u0004\u0018\u00010&2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010)\u001a\u00020(J\b\u0010A\u001a\u00020$H\u0014J\u0018\u0010B\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(J\u000e\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u000201J\u0018\u0010E\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(J \u0010F\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(J\"\u0010G\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\b\u0010H\u001a\u0004\u0018\u00010/2\u0006\u0010I\u001a\u00020(J\u0018\u0010J\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020MR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006N"}, d2 = {"Lcom/tencent/state/view/AvatarDetailBubbleContainer;", "Lcom/tencent/state/view/AvatarBubbleSongContainer;", "context", "Landroid/content/Context;", "associatedBubble", "Lcom/tencent/state/view/IAvatarBubble;", "(Landroid/content/Context;Lcom/tencent/state/view/IAvatarBubble;)V", "getAssociatedBubble", "()Lcom/tencent/state/view/IAvatarBubble;", "avatarBubbleSongPlayIcon", "Landroid/widget/ImageView;", "getAvatarBubbleSongPlayIcon", "()Landroid/widget/ImageView;", "avatarBubbleSongText", "Lcom/tencent/state/view/MarqueeTextView;", "getAvatarBubbleSongText", "()Lcom/tencent/state/view/MarqueeTextView;", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarBubbleDetailBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareAvatarBubbleDetailBinding;", "customLikedResult", "Lcom/tencent/state/square/like/CheckLikedResult;", "mainContainer", "Landroid/view/View;", "getMainContainer", "()Landroid/view/View;", "setMainContainer", "(Landroid/view/View;)V", "operateLikePanel", "Lcom/tencent/state/square/like/OperateLikePanel;", "getOperateLikePanel", "()Lcom/tencent/state/square/like/OperateLikePanel;", "setOperateLikePanel", "(Lcom/tencent/state/square/like/OperateLikePanel;)V", "bindPublishTitleView", "", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "isMe", "", "isPoster", "bindTopGroup", "onlineStatus", "clearText", "doClick", "formatLikeUnreadNum", "", "count", "", "getSongPlayIconView", "getSongTextView", "getTextViewWidth", "textView", "Landroid/widget/TextView;", "getTrulyText", "initOperateLikePanelForGuest", "uin", c.B, "Lcom/tencent/state/square/data/Stickers;", "stickersChangedListener", "Lcom/tencent/state/square/like/IStickersChangedListener;", "relationType", "Lcom/tencent/state/square/data/RelationType;", "initView", NodeProps.ON_DETACHED_FROM_WINDOW, "onStatusChange", "playLikeAnimation", "likeType", "showChangeStatusView", "showCommonView", "showEditedView", "draftText", "needIcon", "showSongBubble", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarDetailBubbleContainer extends AvatarBubbleSongContainer {
    private final IAvatarBubble associatedBubble;
    private final VasSquareAvatarBubbleDetailBinding binding;
    private CheckLikedResult customLikedResult;
    private View mainContainer;
    private OperateLikePanel operateLikePanel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarDetailBubbleContainer(Context context, IAvatarBubble associatedBubble) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(associatedBubble, "associatedBubble");
        this.associatedBubble = associatedBubble;
        VasSquareAvatarBubbleDetailBinding inflate = VasSquareAvatarBubbleDetailBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleDet\u2026ater.from(context), this)");
        this.binding = inflate;
        setOrientation(1);
    }

    private final void bindPublishTitleView(OnlineStatus status, boolean isMe, boolean isPoster) {
        if (isPoster) {
            LinearLayout linearLayout = this.binding.customPublishTitleView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customPublishTitleView");
            linearLayout.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = this.binding.customPublishTitleView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.customPublishTitleView");
            linearLayout2.setVisibility(0);
        }
        TextView textView = this.binding.customPublishTitleNow;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.customPublishTitleNow");
        textView.setVisibility(0);
        String publishTimeTips = status != null ? status.getPublishTimeTips() : null;
        if (publishTimeTips == null || publishTimeTips.length() == 0) {
            return;
        }
        TextView textView2 = this.binding.customPublishTimeText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.customPublishTimeText");
        textView2.setVisibility(0);
        TextView textView3 = this.binding.customPublishTimeText;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.customPublishTimeText");
        textView3.setText(status != null ? status.getPublishTimeTips() : null);
    }

    private final void bindTopGroup(OnlineStatus onlineStatus, boolean isMe, boolean isPoster) {
        bindPublishTitleView(onlineStatus, isMe, isPoster);
    }

    private final ImageView getAvatarBubbleSongPlayIcon() {
        return (ImageView) this.binding.bubbleHeaderSongContainer.findViewById(R.id.pbs);
    }

    private final MarqueeTextView getAvatarBubbleSongText() {
        return (MarqueeTextView) this.binding.bubbleHeaderSongContainer.findViewById(R.id.pbt);
    }

    private final void showSongBubble(OnlineStatus status, boolean isMe) {
        LinearLayout linearLayout = this.binding.bubbleHeaderSongContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bubbleHeaderSongContainer");
        linearLayout.setVisibility(0);
        MarqueeTextView avatarBubbleSongText = getAvatarBubbleSongText();
        if (avatarBubbleSongText != null) {
            avatarBubbleSongText.setTextSize(10.0f);
        }
        bindSongView(status, isMe);
    }

    public final void clearText() {
        KeyEvent.Callback callback = this.mainContainer;
        if (!(callback instanceof IDetailBubbleMainContainer)) {
            callback = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) callback;
        if (iDetailBubbleMainContainer != null) {
            iDetailBubbleMainContainer.clearText();
        }
    }

    public final void doClick() {
        VasSquareItemBubbleEditableMainContainerBinding binding;
        EditText editText;
        View view = this.mainContainer;
        if (!(view instanceof EditableBubbleMainContainer)) {
            view = null;
        }
        EditableBubbleMainContainer editableBubbleMainContainer = (EditableBubbleMainContainer) view;
        if (editableBubbleMainContainer == null || (binding = editableBubbleMainContainer.getBinding()) == null || (editText = binding.bubbleEditText) == null) {
            return;
        }
        editText.requestFocus();
        editText.performClick();
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
    }

    public final IAvatarBubble getAssociatedBubble() {
        return this.associatedBubble;
    }

    public final VasSquareAvatarBubbleDetailBinding getBinding() {
        return this.binding;
    }

    public final View getMainContainer() {
        return this.mainContainer;
    }

    public final OperateLikePanel getOperateLikePanel() {
        return this.operateLikePanel;
    }

    @Override // com.tencent.state.view.AvatarBubbleSongContainer
    public ImageView getSongPlayIconView() {
        return getAvatarBubbleSongPlayIcon();
    }

    @Override // com.tencent.state.view.AvatarBubbleSongContainer
    public MarqueeTextView getSongTextView() {
        return getAvatarBubbleSongText();
    }

    public final String getTrulyText() {
        KeyEvent.Callback callback = this.mainContainer;
        if (!(callback instanceof IDetailBubbleMainContainer)) {
            callback = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) callback;
        if (iDetailBubbleMainContainer != null) {
            return iDetailBubbleMainContainer.getShowText();
        }
        return null;
    }

    public final void initOperateLikePanelForGuest(String uin, OnlineStatus onlineStatus, Stickers stickers, IStickersChangedListener stickersChangedListener, RelationType relationType, boolean isPoster) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(relationType, "relationType");
        View view = this.operateLikePanel;
        if (view != null) {
            removeView(view);
            this.operateLikePanel = null;
        }
        if (relationType == RelationType.SELF || isPoster) {
            return;
        }
        boolean z16 = relationType != RelationType.STRANGER;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        OperateLikePanel operateLikePanel = new OperateLikePanel(context, null, uin, z16, stickers, stickersChangedListener);
        this.operateLikePanel = operateLikePanel;
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setPadding(0, 0, 0, ViewExtensionsKt.dip(getContext(), 8));
        Unit unit = Unit.INSTANCE;
        addView(operateLikePanel, layoutParams);
    }

    public final void initView(String uin, OnlineStatus onlineStatus, Stickers stickers, IStickersChangedListener stickersChangedListener, RelationType relationType, boolean isPoster) {
        View commonBubbleMainContainer;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(relationType, "relationType");
        View view = this.mainContainer;
        if (view != null) {
            removeView(view);
            this.mainContainer = null;
        }
        if (relationType == RelationType.SELF) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            commonBubbleMainContainer = new EditableBubbleMainContainer(context);
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            commonBubbleMainContainer = new CommonBubbleMainContainer(context2);
        }
        this.mainContainer = commonBubbleMainContainer;
        LinearLayout.LayoutParams addViewLayoutParams = ((IDetailBubbleMainContainer) commonBubbleMainContainer).getAddViewLayoutParams();
        int dip = ViewExtensionsKt.dip(getContext(), 8);
        addViewLayoutParams.setMargins(dip, dip, dip, dip);
        Unit unit = Unit.INSTANCE;
        addView(commonBubbleMainContainer, addViewLayoutParams);
        View view2 = this.mainContainer;
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) (view2 instanceof IDetailBubbleMainContainer ? view2 : null);
        if (iDetailBubbleMainContainer != null) {
            iDetailBubbleMainContainer.init(onlineStatus);
        }
        initOperateLikePanelForGuest(uin, onlineStatus, stickers, stickersChangedListener, relationType, isPoster);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void playLikeAnimation(int likeType) {
        OperateLikePanel operateLikePanel = this.operateLikePanel;
        if (operateLikePanel != null) {
            operateLikePanel.setSelectLikeType(likeType, true, false);
        }
    }

    public final void setMainContainer(View view) {
        this.mainContainer = view;
    }

    public final void setOperateLikePanel(OperateLikePanel operateLikePanel) {
        this.operateLikePanel = operateLikePanel;
    }

    public final void showChangeStatusView(OnlineStatus onlineStatus, boolean isMe) {
        setMinimumWidth(ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 40));
        KeyEvent.Callback callback = this.mainContainer;
        if (!(callback instanceof IDetailBubbleMainContainer)) {
            callback = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) callback;
        if (iDetailBubbleMainContainer != null) {
            iDetailBubbleMainContainer.showChangeStatusView(onlineStatus);
        }
        LinearLayout linearLayout = this.binding.bubbleHeaderSongContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bubbleHeaderSongContainer");
        linearLayout.setVisibility(8);
        KeyEvent.Callback callback2 = this.mainContainer;
        if (!(callback2 instanceof IDetailBubbleMainContainer)) {
            callback2 = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer2 = (IDetailBubbleMainContainer) callback2;
        String showText = iDetailBubbleMainContainer2 != null ? iDetailBubbleMainContainer2.getShowText() : null;
        if (showText == null || showText.length() == 0) {
            LinearLayout linearLayout2 = this.binding.customPublishTitleView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.customPublishTitleView");
            linearLayout2.setVisibility(8);
            return;
        }
        bindTopGroup$default(this, onlineStatus, isMe, false, 4, null);
    }

    public final void showCommonView(OnlineStatus onlineStatus, boolean isMe, boolean isPoster) {
        setMinimumWidth(ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 142));
        KeyEvent.Callback callback = this.mainContainer;
        if (!(callback instanceof IDetailBubbleMainContainer)) {
            callback = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) callback;
        if (iDetailBubbleMainContainer != null) {
            iDetailBubbleMainContainer.showCommonView(onlineStatus);
        }
        if (onlineStatus != null) {
            if (OnlineStatusBubbleViewHelper.INSTANCE.canShowSong(onlineStatus)) {
                showSongBubble(onlineStatus, isMe);
            } else {
                LinearLayout linearLayout = this.binding.bubbleHeaderSongContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bubbleHeaderSongContainer");
                linearLayout.setVisibility(8);
            }
        }
        bindTopGroup(onlineStatus, isMe, isPoster);
    }

    public final void showEditedView(OnlineStatus onlineStatus, String draftText, boolean needIcon) {
        setMinimumWidth(ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 40));
        KeyEvent.Callback callback = this.mainContainer;
        if (!(callback instanceof IDetailBubbleMainContainer)) {
            callback = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) callback;
        if (iDetailBubbleMainContainer != null) {
            iDetailBubbleMainContainer.showEditedView(onlineStatus, draftText, needIcon);
        }
        LinearLayout linearLayout = this.binding.customPublishTitleView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customPublishTitleView");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.binding.bubbleHeaderSongContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bubbleHeaderSongContainer");
        linearLayout2.setVisibility(8);
    }

    private final int getTextViewWidth(TextView textView) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        textView.measure(makeMeasureSpec, makeMeasureSpec);
        return textView.getMeasuredWidth();
    }

    private final String formatLikeUnreadNum(int count) {
        if (count > 99) {
            return "99+";
        }
        return String.valueOf(count);
    }

    public final void updateBubbleSkin(SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        if (SquareBubbleSkinKt.useDefault(bubbleInfo)) {
            ColorFormatUtils colorFormatUtils = ColorFormatUtils.INSTANCE;
            Integer parse = colorFormatUtils.parse("#888888");
            if (parse != null) {
                int intValue = parse.intValue();
                this.binding.customPublishTimeText.setTextColor(intValue);
                this.binding.customPublishTitleNow.setTextColor(intValue);
            }
            MarqueeTextView songTextView = getSongTextView();
            if (songTextView != null) {
                songTextView.setTextColor(-16777216);
            }
            LinearLayout linearLayout = this.binding.bubbleHeaderSongContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bubbleHeaderSongContainer");
            Drawable background = linearLayout.getBackground();
            GradientDrawable gradientDrawable = (GradientDrawable) (!(background instanceof GradientDrawable) ? null : background);
            if (gradientDrawable != null) {
                Integer parse2 = colorFormatUtils.parse("#FAFAFA");
                if (parse2 == null) {
                    return;
                }
                gradientDrawable.setColor(parse2.intValue());
                float dip = ViewExtensionsKt.dip(getContext(), 9);
                gradientDrawable.setCornerRadii(new float[]{dip, dip, dip, dip, 0.0f, 0.0f, 0.0f, 0.0f});
            }
        } else {
            ColorFormatUtils colorFormatUtils2 = ColorFormatUtils.INSTANCE;
            SquareBubbleColor color = bubbleInfo.getColor();
            Integer parse3 = colorFormatUtils2.parse(color != null ? color.getAssistColor() : null);
            if (parse3 == null) {
                return;
            }
            int intValue2 = parse3.intValue();
            this.binding.customPublishTimeText.setTextColor(intValue2);
            this.binding.customPublishTitleNow.setTextColor(intValue2);
            KeyEvent.Callback callback = this.mainContainer;
            if (!(callback instanceof IDetailBubbleMainContainer)) {
                callback = null;
            }
            IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) callback;
            if (iDetailBubbleMainContainer != null) {
                iDetailBubbleMainContainer.updateBubbleSkin(bubbleInfo);
            }
            MarqueeTextView songTextView2 = getSongTextView();
            if (songTextView2 != null) {
                songTextView2.setTextColor(intValue2);
            }
            LinearLayout linearLayout2 = this.binding.bubbleHeaderSongContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bubbleHeaderSongContainer");
            Drawable background2 = linearLayout2.getBackground();
            if (!(background2 instanceof GradientDrawable)) {
                background2 = null;
            }
            GradientDrawable gradientDrawable2 = (GradientDrawable) background2;
            if (gradientDrawable2 != null) {
                SquareBubbleColor color2 = bubbleInfo.getColor();
                Integer parse4 = colorFormatUtils2.parse(color2 != null ? color2.getListenMusicColor() : null);
                if (parse4 == null) {
                    return;
                }
                gradientDrawable2.setColor(parse4.intValue());
                float dip2 = ViewExtensionsKt.dip(getContext(), 6);
                gradientDrawable2.setCornerRadii(new float[]{dip2, dip2, dip2, dip2, 0.0f, 0.0f, 0.0f, 0.0f});
            }
        }
        OperateLikePanel operateLikePanel = this.operateLikePanel;
        if (operateLikePanel != null) {
            operateLikePanel.updateBubbleSkin(bubbleInfo);
        }
    }

    static /* synthetic */ void bindPublishTitleView$default(AvatarDetailBubbleContainer avatarDetailBubbleContainer, OnlineStatus onlineStatus, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        avatarDetailBubbleContainer.bindPublishTitleView(onlineStatus, z16, z17);
    }

    static /* synthetic */ void bindTopGroup$default(AvatarDetailBubbleContainer avatarDetailBubbleContainer, OnlineStatus onlineStatus, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        avatarDetailBubbleContainer.bindTopGroup(onlineStatus, z16, z17);
    }

    public static /* synthetic */ void initOperateLikePanelForGuest$default(AvatarDetailBubbleContainer avatarDetailBubbleContainer, String str, OnlineStatus onlineStatus, Stickers stickers, IStickersChangedListener iStickersChangedListener, RelationType relationType, boolean z16, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z16 = false;
        }
        avatarDetailBubbleContainer.initOperateLikePanelForGuest(str, onlineStatus, stickers, iStickersChangedListener, relationType, z16);
    }

    public static /* synthetic */ void initView$default(AvatarDetailBubbleContainer avatarDetailBubbleContainer, String str, OnlineStatus onlineStatus, Stickers stickers, IStickersChangedListener iStickersChangedListener, RelationType relationType, boolean z16, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z16 = false;
        }
        avatarDetailBubbleContainer.initView(str, onlineStatus, stickers, iStickersChangedListener, relationType, z16);
    }

    public final void onStatusChange(OnlineStatus onlineStatus, boolean isMe) {
    }
}
