package com.tencent.state.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareAvatarBubbleBinding;
import com.tencent.state.square.like.IStickersChangedListener;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\nJN\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u000e\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00152\u0006\u0010-\u001a\u000200J\u000e\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u001dJ\u0006\u00103\u001a\u00020\u0015J\u001a\u00104\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010)\u001a\u00020\u001dJ\u001c\u00105\u001a\u00020\u00152\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u00107\u001a\u00020\u001dJ\u0010\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:H\u0016J\u001a\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010=\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lcom/tencent/state/view/AvatarOnlineStatusDetailBubble;", "Landroid/widget/LinearLayout;", "Lcom/tencent/state/view/IAvatarBubble;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarBubbleBinding;", ParseCommon.CONTAINER, "Lcom/tencent/state/view/AvatarDetailBubbleContainer;", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "relationType", "Lcom/tencent/state/square/data/RelationType;", "clearText", "", "getData", "getMainContainer", "Landroid/view/View;", "getTextString", "", "getTrulyText", "isMe", "", "onStatusChange", "playLikeAnimation", "likeType", "setData", "uin", "status", c.B, "Lcom/tencent/state/square/data/Stickers;", "stickersChangedListener", "Lcom/tencent/state/square/like/IStickersChangedListener;", "needShowAnimation", "isPoster", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "setEditListener", "listener", "Lcom/tencent/state/view/BubbleEditListener;", "setElementEventListener", "Lcom/tencent/state/view/BubbleElementEventListener;", "setFocus", NodeProps.FOCUSABLE, "showChangeStatusView", "showCommonView", "showEditedView", "draftText", "needIcon", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updatePlayIcon", "songMid", "updateStatusIcon", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarOnlineStatusDetailBubble extends LinearLayout implements IAvatarBubble {
    private static final String TAG = "AvatarOnlineStatusDetailBubble";
    private final VasSquareAvatarBubbleBinding binding;
    private final AvatarDetailBubbleContainer container;
    private OnlineStatus onlineStatus;
    private RelationType relationType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarOnlineStatusDetailBubble(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareAvatarBubbleBinding inflate = VasSquareAvatarBubbleBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AvatarDetailBubbleContainer avatarDetailBubbleContainer = new AvatarDetailBubbleContainer(context2, this);
        this.container = avatarDetailBubbleContainer;
        this.relationType = RelationType.FRIEND;
        setVisibility(8);
        inflate.onlineStatusAvatarBubbleMsg.addView(avatarDetailBubbleContainer, new LinearLayout.LayoutParams(-2, -2));
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.AvatarOnlineStatusDetailBubble.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (AvatarOnlineStatusDetailBubble.this.relationType == RelationType.SELF) {
                    AvatarOnlineStatusDetailBubble.this.container.doClick();
                }
            }
        });
    }

    public final void clearText() {
        this.container.clearText();
    }

    @Override // com.tencent.state.view.IAvatarBubble
    /* renamed from: getData, reason: from getter */
    public OnlineStatus getOnlineStatus() {
        return this.onlineStatus;
    }

    public final View getMainContainer() {
        return this.container.getMainContainer();
    }

    public final String getTextString() {
        KeyEvent.Callback mainContainer = this.container.getMainContainer();
        if (!(mainContainer instanceof IDetailBubbleMainContainer)) {
            mainContainer = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) mainContainer;
        if (iDetailBubbleMainContainer != null) {
            return iDetailBubbleMainContainer.getTextString();
        }
        return null;
    }

    public final String getTrulyText() {
        return this.container.getTrulyText();
    }

    @Override // com.tencent.state.view.IAvatarBubble
    /* renamed from: isMe */
    public boolean getIsMe() {
        return this.relationType == RelationType.SELF;
    }

    public final void onStatusChange(OnlineStatus onlineStatus, boolean isMe) {
        this.container.onStatusChange(onlineStatus, isMe);
    }

    public final void playLikeAnimation(int likeType) {
        this.container.playLikeAnimation(likeType);
    }

    @Override // com.tencent.state.view.IAvatarBubble
    public void setData(String uin, OnlineStatus status, Stickers stickers, IStickersChangedListener stickersChangedListener, RelationType relationType, boolean needShowAnimation, boolean isPoster, AvatarLocationInfo locationInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(relationType, "relationType");
        this.relationType = relationType;
        this.onlineStatus = status;
        this.container.initView(uin, status, stickers, stickersChangedListener, relationType, isPoster);
        setVisibility(0);
    }

    public final void setEditListener(BubbleEditListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        View mainContainer = this.container.getMainContainer();
        if (!(mainContainer instanceof EditableBubbleMainContainer)) {
            mainContainer = null;
        }
        EditableBubbleMainContainer editableBubbleMainContainer = (EditableBubbleMainContainer) mainContainer;
        if (editableBubbleMainContainer != null) {
            editableBubbleMainContainer.setBubbleEditListener(listener);
        }
    }

    public final void setElementEventListener(BubbleElementEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.container.setElementEventListener(listener);
    }

    public final void setFocus(boolean focusable) {
        KeyEvent.Callback mainContainer = this.container.getMainContainer();
        if (!(mainContainer instanceof IDetailBubbleMainContainer)) {
            mainContainer = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) mainContainer;
        if (iDetailBubbleMainContainer != null) {
            iDetailBubbleMainContainer.setFocus(focusable);
        }
    }

    public final void showChangeStatusView() {
        this.container.showChangeStatusView(this.onlineStatus, this.relationType == RelationType.SELF);
    }

    public final void showCommonView(OnlineStatus onlineStatus, boolean isPoster) {
        this.container.showCommonView(onlineStatus, this.relationType == RelationType.SELF, isPoster);
    }

    public final void showEditedView(String draftText, boolean needIcon) {
        this.container.showEditedView(this.onlineStatus, draftText, needIcon);
    }

    @Override // com.tencent.state.view.IAvatarBubble
    public void updateBubbleSkin(final SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.binding.onlineStatusAvatarBubble.post(new Runnable() { // from class: com.tencent.state.view.AvatarOnlineStatusDetailBubble$updateBubbleSkin$1
            @Override // java.lang.Runnable
            public final void run() {
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding;
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding2;
                VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding3;
                if (SquareBubbleSkinKt.useDefault(bubbleInfo)) {
                    vasSquareAvatarBubbleBinding = AvatarOnlineStatusDetailBubble.this.binding;
                    LinearLayout linearLayout = vasSquareAvatarBubbleBinding.onlineStatusAvatarBubble;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.onlineStatusAvatarBubble");
                    DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
                    linearLayout.setBackground(drawableUtil.getDrawable(R.drawable.grh));
                    vasSquareAvatarBubbleBinding2 = AvatarOnlineStatusDetailBubble.this.binding;
                    vasSquareAvatarBubbleBinding2.bubbleArrow.setImageDrawable(drawableUtil.getDrawable(R.drawable.i8u));
                    vasSquareAvatarBubbleBinding3 = AvatarOnlineStatusDetailBubble.this.binding;
                    vasSquareAvatarBubbleBinding3.onlineStatusAvatarBubbleMain.setPadding(0, 0, 0, 0);
                } else {
                    final int dip = ViewExtensionsKt.dip(AvatarOnlineStatusDetailBubble.this.getContext(), 1);
                    final int dip2 = ViewExtensionsKt.dip(AvatarOnlineStatusDetailBubble.this.getContext(), 8) - dip;
                    BubbleSkinDownloadManager bubbleSkinDownloadManager = BubbleSkinDownloadManager.INSTANCE;
                    Context context = AvatarOnlineStatusDetailBubble.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    bubbleSkinDownloadManager.loadBubbleNinePatchDrawable(context, new Function1<Bitmap, Unit>() { // from class: com.tencent.state.view.AvatarOnlineStatusDetailBubble$updateBubbleSkin$1.1
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
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding4;
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding5;
                            VasSquareAvatarBubbleBinding vasSquareAvatarBubbleBinding6;
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            Context context2 = AvatarOnlineStatusDetailBubble.this.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context2.getResources(), bubbleInfo.getBitmap(), bitmap.getNinePatchChunk(), null, null);
                            vasSquareAvatarBubbleBinding4 = AvatarOnlineStatusDetailBubble.this.binding;
                            LinearLayout linearLayout2 = vasSquareAvatarBubbleBinding4.onlineStatusAvatarBubble;
                            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.onlineStatusAvatarBubble");
                            linearLayout2.setBackground(ninePatchDrawable);
                            ViewUtils viewUtils = ViewUtils.INSTANCE;
                            String arrow = bubbleInfo.getArrow();
                            vasSquareAvatarBubbleBinding5 = AvatarOnlineStatusDetailBubble.this.binding;
                            SquareImageView squareImageView = vasSquareAvatarBubbleBinding5.bubbleArrow;
                            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubbleArrow");
                            viewUtils.loadImageDrawable(arrow, squareImageView);
                            vasSquareAvatarBubbleBinding6 = AvatarOnlineStatusDetailBubble.this.binding;
                            RelativeLayout relativeLayout = vasSquareAvatarBubbleBinding6.onlineStatusAvatarBubbleMain;
                            int i3 = dip2;
                            relativeLayout.setPadding(i3, dip, i3, 0);
                        }
                    });
                }
                AvatarOnlineStatusDetailBubble.this.container.updateBubbleSkin(bubbleInfo);
            }
        });
    }

    @Override // com.tencent.state.view.IAvatarBubble
    public void updatePlayIcon(String songMid, boolean isMe) {
        this.container.updatePlayIcon(songMid, isMe);
    }

    public final void updateStatusIcon(OnlineStatus onlineStatus) {
        Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        KeyEvent.Callback mainContainer = this.container.getMainContainer();
        if (!(mainContainer instanceof IDetailBubbleMainContainer)) {
            mainContainer = null;
        }
        IDetailBubbleMainContainer iDetailBubbleMainContainer = (IDetailBubbleMainContainer) mainContainer;
        if (iDetailBubbleMainContainer != null) {
            iDetailBubbleMainContainer.updateStatusIcon(onlineStatus);
        }
    }

    public static /* synthetic */ void showCommonView$default(AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble, OnlineStatus onlineStatus, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        avatarOnlineStatusDetailBubble.showCommonView(onlineStatus, z16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarOnlineStatusDetailBubble(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareAvatarBubbleBinding inflate = VasSquareAvatarBubbleBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AvatarDetailBubbleContainer avatarDetailBubbleContainer = new AvatarDetailBubbleContainer(context2, this);
        this.container = avatarDetailBubbleContainer;
        this.relationType = RelationType.FRIEND;
        setVisibility(8);
        inflate.onlineStatusAvatarBubbleMsg.addView(avatarDetailBubbleContainer, new LinearLayout.LayoutParams(-2, -2));
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.AvatarOnlineStatusDetailBubble.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (AvatarOnlineStatusDetailBubble.this.relationType == RelationType.SELF) {
                    AvatarOnlineStatusDetailBubble.this.container.doClick();
                }
            }
        });
    }

    public static /* synthetic */ void showEditedView$default(AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        avatarOnlineStatusDetailBubble.showEditedView(str, z16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarOnlineStatusDetailBubble(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareAvatarBubbleBinding inflate = VasSquareAvatarBubbleBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarBubbleBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AvatarDetailBubbleContainer avatarDetailBubbleContainer = new AvatarDetailBubbleContainer(context2, this);
        this.container = avatarDetailBubbleContainer;
        this.relationType = RelationType.FRIEND;
        setVisibility(8);
        inflate.onlineStatusAvatarBubbleMsg.addView(avatarDetailBubbleContainer, new LinearLayout.LayoutParams(-2, -2));
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.AvatarOnlineStatusDetailBubble.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (AvatarOnlineStatusDetailBubble.this.relationType == RelationType.SELF) {
                    AvatarOnlineStatusDetailBubble.this.container.doClick();
                }
            }
        });
    }
}
