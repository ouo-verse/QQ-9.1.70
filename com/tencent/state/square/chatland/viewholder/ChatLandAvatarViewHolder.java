package com.tencent.state.square.chatland.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.SquareRuntime;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.holder.ViewHolderExtensionsKt;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.chatland.data.ChatLandAvatarExtra;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.view.ChatLandSpeakBubbleView;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.databinding.VasSquareItemChatLandAvatarBinding;
import com.tencent.state.square.resource.IBaseResourceManager;
import com.tencent.state.square.resource.IResourceManager;
import com.tencent.state.square.resource.PagPreloadManager;
import com.tencent.state.template.data.InterReceiverInfo;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.InterSenderInfo;
import com.tencent.state.template.data.PKResult;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import com.tencent.state.template.push.BubbleMessage;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.SquarePagViewUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.AvatarOnlineStatusSimpleBubble;
import com.tencent.state.view.IAvatarBubble;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001]B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0014J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0003J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0003J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0016\u0010(\u001a\u00020\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190*H\u0002J\u0018\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-H\u0014J \u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0014J\b\u0010/\u001a\u00020\u0019H\u0002J\u0018\u00100\u001a\u00020\u00192\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010*J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u00020-H\u0002J\u001e\u00106\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000208072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u00109\u001a\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190*H\u0002J\b\u0010<\u001a\u00020\u0019H\u0002J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010>\u001a\u00020\u0019H\u0016J\u0012\u0010?\u001a\u00020\u00192\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J,\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u0001032\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u00020\u00192\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0018\u0010I\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020J2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\u0019H\u0016J\b\u0010O\u001a\u00020MH\u0016J\u0010\u0010P\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010Q\u001a\u00020\u0019H\u0016J\u0010\u0010R\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010S\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020MH\u0016J*\u0010W\u001a\u00020\u00192\u0006\u0010X\u001a\u00020A2\u0006\u0010Y\u001a\u00020M2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010*H\u0002J\u0006\u0010Z\u001a\u00020\u0019J\u0012\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020JH\u0014J\u0010\u0010\\\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006^"}, d2 = {"Lcom/tencent/state/square/chatland/viewholder/ChatLandAvatarViewHolder;", "Lcom/tencent/state/map/MapPlayableViewHolder;", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "Landroid/view/View$OnClickListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemChatLandAvatarBinding;", HippyNestedScrollComponent.PRIORITY_PARENT, "Ljava/lang/ref/WeakReference;", "Landroid/widget/FrameLayout;", "(Lcom/tencent/state/square/databinding/VasSquareItemChatLandAvatarBinding;Ljava/lang/ref/WeakReference;)V", "avatarGestureDetector", "Landroid/view/GestureDetector;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemChatLandAvatarBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "currentData", "faceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getParent", "()Ljava/lang/ref/WeakReference;", "ringPagView", "Lcom/tencent/state/square/api/ISquarePagView;", "adjustAvatarLocation", "", "data", "adjustBubbleLayout", "bindAvatar", "bindAvatarImageShow", "bindBubble", "bindListeners", "bindNickName", "bindPKResult", "bindRingAnim", "bindSpeakBubble", "calculateElevation", "", "location", "Lcom/tencent/state/map/Location;", "checkOpenDetail", "reportCb", "Lkotlin/Function0;", "doBind", "index", "", "event", "extraItemHide", "fadeIn", "animationEnd", "getAvatarType", "", "getBubbleType", "getInteractionType", "getPKElementInfo", "", "", "getPlayerView", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "handlePKResult", "hideSpeakBubble", "initReport", "onBackFromDetail", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onDecodeTaskCompleted", "remainingTasks", "type", "uin", "avatar", "Landroid/graphics/Bitmap;", "onDoubleClick", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "onMapMinimum", "isMin", "", "onRecycled", "onScaleToDetail", "onUpdateStatus", "onVisible", "resizeAvatar", "setAvatarBubbleData", "setBubbleSkin", "setRepeat", "repeat", "startAlphaAnimation", "view", ViewStickEventHelper.IS_SHOW, "stopRingAnim", "transform", "updateResource", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandAvatarViewHolder extends MapPlayableViewHolder<ChatLandAvatarItem> implements IDecodeTaskCompletionListener, View.OnClickListener {
    private static final long ALPHA_ANIM_DURATION = 400;
    private static final float ALPHA_MAX = 1.0f;
    private static final float ALPHA_MIN = 0.0f;
    private static final int ENTER_ANIM_PLAY_EXPIRE_TIME_MS = 500;
    private static final String TAG = "ChatLandAvatarViewHolder";
    private final GestureDetector avatarGestureDetector;
    private final VasSquareItemChatLandAvatarBinding binding;
    private final FastClickUtils clickUtils;
    private ChatLandAvatarItem currentData;
    private IFaceDecoder faceDecoder;
    private final WeakReference<FrameLayout> parent;
    private ISquarePagView ringPagView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PKResult.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PKResult.SUPPORT.ordinal()] = 1;
            iArr[PKResult.OPPOSE.ordinal()] = 2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatLandAvatarViewHolder(VasSquareItemChatLandAvatarBinding binding, WeakReference<FrameLayout> parent) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(parent, "parent");
        RelativeLayout mContainer = binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        this.binding = binding;
        this.parent = parent;
        this.clickUtils = new FastClickUtils(800L);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        this.avatarGestureDetector = new GestureDetector(itemView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$avatarGestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e16) {
                ChatLandAvatarViewHolder chatLandAvatarViewHolder = ChatLandAvatarViewHolder.this;
                chatLandAvatarViewHolder.onDoubleClick(chatLandAvatarViewHolder.getBinding().hitArea);
                return super.onDoubleTap(e16);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e16) {
                super.onLongPress(e16);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e16) {
                ChatLandAvatarViewHolder chatLandAvatarViewHolder = ChatLandAvatarViewHolder.this;
                chatLandAvatarViewHolder.onClick(chatLandAvatarViewHolder.getBinding().hitArea);
                return super.onSingleTapConfirmed(e16);
            }
        });
    }

    private final void adjustAvatarLocation(ChatLandAvatarItem data) {
        final Location location = data.getLocation();
        SquareAvatarView squareAvatarView = this.binding.avatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.avatar");
        ViewExtensionsKt.updateLayoutParams(squareAvatarView, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$adjustAvatarLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                receiver.width = Location.this.getWidth();
                receiver.height = Location.this.getHeight();
            }
        });
    }

    private final void adjustBubbleLayout(ChatLandAvatarItem data) {
        Point bubbleCoordinate;
        Resource userResource = data.getUserResource();
        if (userResource == null || (bubbleCoordinate = userResource.getBubbleCoordinate()) == null) {
            return;
        }
        FrameLayout frameLayout = this.binding.bubbleContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bubbleContainer");
        frameLayout.setTranslationY(-bubbleCoordinate.y);
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
        ViewExtensionsKt.updatePadding$default(avatarOnlineStatusSimpleBubble, bubbleCoordinate.x, 0, 0, 0, 14, null);
        ChatLandSpeakBubbleView chatLandSpeakBubbleView = this.binding.chatLandSpeakBubble;
        Intrinsics.checkNotNullExpressionValue(chatLandSpeakBubbleView, "binding.chatLandSpeakBubble");
        ViewExtensionsKt.updatePadding$default(chatLandSpeakBubbleView, bubbleCoordinate.x, 0, 0, 0, 14, null);
    }

    private final void bindAvatarImageShow(ChatLandAvatarItem data) {
        Boolean changeAvatarImageVisible;
        Object extra = data.getExtra();
        if (!(extra instanceof ChatLandAvatarExtra)) {
            extra = null;
        }
        ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) extra;
        if (chatLandAvatarExtra == null || (changeAvatarImageVisible = chatLandAvatarExtra.getChangeAvatarImageVisible()) == null) {
            return;
        }
        boolean booleanValue = changeAvatarImageVisible.booleanValue();
        this.binding.avatar.setImageViewVisibility(booleanValue);
        onItemCoverRecord(!booleanValue);
        ((ChatLandAvatarExtra) data.getExtra()).setChangeAvatarImageVisible(null);
    }

    public final void bindBubble(ChatLandAvatarItem data) {
        String customText;
        boolean isBlank;
        boolean isBlank2;
        BubbleMessage speakBubble;
        SitDownInfo sitDown = data.getUser().getSitDown();
        OnlineStatus onlineStatus = sitDown != null ? sitDown.getOnlineStatus() : null;
        Object extra = data.getExtra();
        ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) (extra instanceof ChatLandAvatarExtra ? extra : null);
        boolean z16 = (chatLandAvatarExtra == null || (speakBubble = chatLandAvatarExtra.getSpeakBubble()) == null || !speakBubble.getCanShow()) ? false : true;
        if (onlineStatus != null && !data.ingInteraction()) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(onlineStatus.getCustomText());
            if (!isBlank2 && !z16) {
                AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
                Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
                ViewExtensionsKt.setVisibility(avatarOnlineStatusSimpleBubble, true);
                setBubbleSkin(data);
                setAvatarBubbleData(data);
                return;
            }
        }
        SquareBubbleInfo bubbleSkin = data.getUser().getBubbleSkin();
        if (bubbleSkin != null && !SquareBubbleSkinKt.isDefault(bubbleSkin) && onlineStatus != null && (customText = onlineStatus.getCustomText()) != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(customText);
            if (!isBlank) {
                setBubbleSkin(data);
                setAvatarBubbleData(data);
                AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble2 = this.binding.squareAvatarBubble;
                Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble2, "binding.squareAvatarBubble");
                ViewExtensionsKt.setVisibility(avatarOnlineStatusSimpleBubble2, true);
                return;
            }
        }
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble3 = this.binding.squareAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble3, "binding.squareAvatarBubble");
        ViewExtensionsKt.setVisibility(avatarOnlineStatusSimpleBubble3, false);
    }

    private final void bindListeners() {
        this.binding.hitArea.setOnClickListener(this);
        this.binding.squareAvatarBubble.setOnClickListener(this);
        this.binding.pkResultArea.setOnClickListener(this);
        this.binding.hitArea.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$bindListeners$1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                GestureDetector gestureDetector;
                gestureDetector = ChatLandAvatarViewHolder.this.avatarGestureDetector;
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    private final void bindNickName(ChatLandAvatarItem data) {
        InterReceiverInfo receiverInfo;
        UserCommon profile;
        String friendRemarkName;
        String str;
        InterReceiverInfo receiverInfo2;
        UserCommon profile2;
        InterSenderInfo senderInfo;
        UserCommon profile3;
        if (data.ingInteraction()) {
            FrameLayout frameLayout = this.binding.avatarNameContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarNameContainer");
            ViewExtensionsKt.setVisibility(frameLayout, false);
            LinearLayout linearLayout = this.binding.avatarNameInteractionContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarNameInteractionContainer");
            ViewExtensionsKt.setVisibility(linearLayout, true);
            TextView textView = this.binding.firstName;
            TextPaint paint = textView.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            paint.setFakeBoldText(data.isMe());
            textView.setTextSize(data.isMe() ? 14.0f : 12.0f);
            String str2 = null;
            if (data.getUser().isSend()) {
                InterResourceInfo interaction = data.getUser().getInteraction();
                if (interaction != null && (senderInfo = interaction.getSenderInfo()) != null && (profile3 = senderInfo.getProfile()) != null) {
                    friendRemarkName = profile3.getFriendRemarkName();
                }
                friendRemarkName = null;
            } else {
                InterResourceInfo interaction2 = data.getUser().getInteraction();
                if (interaction2 != null && (receiverInfo = interaction2.getReceiverInfo()) != null && (profile = receiverInfo.getProfile()) != null) {
                    friendRemarkName = profile.getFriendRemarkName();
                }
                friendRemarkName = null;
            }
            textView.setText(friendRemarkName);
            TextView textView2 = this.binding.secondName;
            TextPaint paint2 = textView2.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint2, "paint");
            paint2.setFakeBoldText(data.isMe());
            textView2.setTextSize(data.isMe() ? 14.0f : 12.0f);
            if (data.getUser().isSend()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append('+');
                InterResourceInfo interaction3 = data.getUser().getInteraction();
                if (interaction3 != null && (receiverInfo2 = interaction3.getReceiverInfo()) != null && (profile2 = receiverInfo2.getProfile()) != null) {
                    str2 = profile2.getFriendRemarkName();
                }
                sb5.append(str2);
                str = sb5.toString();
            } else {
                str = "\u7684\u5360\u5ea7\u5c0f\u732b";
            }
            textView2.setText(str);
            return;
        }
        FrameLayout frameLayout2 = this.binding.avatarNameContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.avatarNameContainer");
        ViewExtensionsKt.setVisibility(frameLayout2, true);
        LinearLayout linearLayout2 = this.binding.avatarNameInteractionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.avatarNameInteractionContainer");
        ViewExtensionsKt.setVisibility(linearLayout2, false);
        TextView textView3 = this.binding.avatarName;
        TextPaint paint3 = textView3.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint3, "paint");
        paint3.setFakeBoldText(data.isMe());
        textView3.setTextSize(data.isMe() ? 14.0f : 12.0f);
        textView3.setText(SquareBaseKt.getSquareCommon().getFriendRemarkName(data.getUin(), data.getName()));
    }

    private final void bindPKResult(ChatLandAvatarItem data) {
        if (data.getPkOptionMap().isEmpty()) {
            LinearLayout linearLayout = this.binding.pkResultArea;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultArea");
            ViewExtensionsKt.setVisibility(linearLayout, false);
            return;
        }
        SquareImageView squareImageView = this.binding.arrow;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.arrow");
        ViewExtensionsKt.setVisibility(squareImageView, data.isMe());
        SitDownInfo sitDown = data.getUser().getSitDown();
        PKResult pkResult = sitDown != null ? sitDown.getPkResult() : null;
        if (pkResult != null) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[pkResult.ordinal()];
            if (i3 == 1) {
                LinearLayout linearLayout2 = this.binding.pkResultArea;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.pkResultArea");
                ViewExtensionsKt.setVisibility(linearLayout2, true);
                LinearLayout linearLayout3 = this.binding.pkResultArea;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pkResultArea");
                linearLayout3.setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.i7c));
                TextView textView = this.binding.pkResultTitle;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.pkResultTitle");
                textView.setText(data.getPkOptionMap().get(PKResult.SUPPORT));
                return;
            }
            if (i3 == 2) {
                LinearLayout linearLayout4 = this.binding.pkResultArea;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.pkResultArea");
                ViewExtensionsKt.setVisibility(linearLayout4, true);
                LinearLayout linearLayout5 = this.binding.pkResultArea;
                Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.pkResultArea");
                linearLayout5.setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.i7b));
                TextView textView2 = this.binding.pkResultTitle;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkResultTitle");
                textView2.setText(data.getPkOptionMap().get(PKResult.OPPOSE));
                return;
            }
        }
        LinearLayout linearLayout6 = this.binding.pkResultArea;
        Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.pkResultArea");
        ViewExtensionsKt.setVisibility(linearLayout6, data.isMe());
        if (data.isMe()) {
            LinearLayout linearLayout7 = this.binding.pkResultArea;
            Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.pkResultArea");
            linearLayout7.setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.i7d));
            this.binding.pkResultTitle.setText(R.string.xx6);
        }
    }

    private final void bindRingAnim(final ChatLandAvatarItem data) {
        Object extra = data.getExtra();
        if (!(extra instanceof ChatLandAvatarExtra)) {
            extra = null;
        }
        ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) extra;
        if (chatLandAvatarExtra != null) {
            if (!chatLandAvatarExtra.getNeedRingPagAnim()) {
                stopRingAnim();
                return;
            }
            chatLandAvatarExtra.setNeedRingPagAnim(false);
            long currentTimeMillis = System.currentTimeMillis();
            SitDownInfo sitDown = data.getUser().getSitDown();
            long createdAt = currentTimeMillis - (sitDown != null ? sitDown.getCreatedAt() : 0L);
            boolean z16 = createdAt > ((long) 500);
            String str = "[addRoles] bindRingAnim, " + data.getUin() + ", " + data.getName();
            SquareBaseKt.getSquareLog().i(TAG, str + ", needRing expired=" + z16 + '(' + createdAt + ')');
            if (z16) {
                return;
            }
            if (this.ringPagView == null) {
                ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                ISquarePagView pagImageView = commonUtils.getPagImageView(context);
                this.ringPagView = pagImageView;
                if (pagImageView != null) {
                    Rect itemViewLocation = data.getItemViewLocation();
                    FrameLayout frameLayout = this.parent.get();
                    if (frameLayout != null) {
                        View view = pagImageView.getView();
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(itemViewLocation.width(), itemViewLocation.height());
                        layoutParams.leftMargin = itemViewLocation.left;
                        int i3 = itemViewLocation.top;
                        FrameLayout frameLayout2 = this.parent.get();
                        layoutParams.topMargin = i3 + (frameLayout2 != null ? ViewExtensionsKt.dip((View) frameLayout2, 42) : 0);
                        Unit unit = Unit.INSTANCE;
                        frameLayout.addView(view, layoutParams);
                    }
                    ISquarePagView iSquarePagView = this.ringPagView;
                    if (iSquarePagView != null) {
                        iSquarePagView.setPagViewListener(new ISquarePagViewListener() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$bindRingAnim$$inlined$let$lambda$1
                            @Override // com.tencent.state.square.api.ISquarePagViewListener
                            public void onAnimationCancel(ISquarePagView squarePagView) {
                                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$bindRingAnim$$inlined$let$lambda$1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        ChatLandAvatarViewHolder.this.stopRingAnim();
                                    }
                                });
                            }

                            @Override // com.tencent.state.square.api.ISquarePagViewListener
                            public void onAnimationEnd(ISquarePagView squarePagView) {
                                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$bindRingAnim$$inlined$let$lambda$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        ChatLandAvatarViewHolder.this.stopRingAnim();
                                    }
                                });
                            }

                            @Override // com.tencent.state.square.api.ISquarePagViewListener
                            public void onAnimationRepeat(ISquarePagView iSquarePagView2) {
                                ISquarePagViewListener.DefaultImpls.onAnimationRepeat(this, iSquarePagView2);
                            }

                            @Override // com.tencent.state.square.api.ISquarePagViewListener
                            public void onAnimationStart(ISquarePagView iSquarePagView2) {
                                ISquarePagViewListener.DefaultImpls.onAnimationStart(this, iSquarePagView2);
                            }

                            @Override // com.tencent.state.square.api.ISquarePagViewListener
                            public void onAnimationUpdate(ISquarePagView iSquarePagView2) {
                                ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView2);
                            }
                        });
                    }
                }
            }
            ISquarePagView iSquarePagView2 = this.ringPagView;
            if (iSquarePagView2 != null) {
                SquareBubbleInfo focusAnimationSkin = data.getUser().getFocusAnimationSkin();
                String skinLink = focusAnimationSkin != null ? focusAnimationSkin.getSkinLink() : null;
                if (skinLink == null || skinLink.length() == 0) {
                    skinLink = PagPreloadManager.AVATAR_RING_PAG;
                }
                SquarePagViewUtils.INSTANCE.playUrl(iSquarePagView2, skinLink, 1, null);
            }
        }
    }

    private final void bindSpeakBubble(final ChatLandAvatarItem data) {
        BubbleMessage speakBubble;
        Object extra = data.getExtra();
        if (!(extra instanceof ChatLandAvatarExtra)) {
            extra = null;
        }
        ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) extra;
        if (chatLandAvatarExtra == null || (speakBubble = chatLandAvatarExtra.getSpeakBubble()) == null) {
            return;
        }
        this.binding.chatLandSpeakBubble.initView(speakBubble, data.getUser().getBubbleSkin(), new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$bindSpeakBubble$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = ChatLandAvatarViewHolder.this.getBinding().squareAvatarBubble;
                Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
                ViewExtensionsKt.setVisibility(avatarOnlineStatusSimpleBubble, false);
            }
        }, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$bindSpeakBubble$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((ChatLandAvatarExtra) data.getExtra()).setSpeakBubble(null);
                ChatLandAvatarViewHolder.this.bindBubble(data);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.tencent.state.map.MapItem] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.state.map.MapItem] */
    private final void checkOpenDetail(Function0<Unit> reportCb) {
        ChatLandAvatarItem chatLandAvatarItem;
        IMapViewListener listener;
        ChatLandAvatarItem chatLandAvatarItem2;
        User user;
        IMapViewListener listener2;
        String uin;
        User user2;
        ChatLandAvatarItem chatLandAvatarItem3 = (ChatLandAvatarItem) getData();
        if ((chatLandAvatarItem3 != null && (user2 = chatLandAvatarItem3.getUser()) != null && user2.isReceiver()) || ((chatLandAvatarItem = (ChatLandAvatarItem) getData()) != null && chatLandAvatarItem.isMe() && ((chatLandAvatarItem2 = (ChatLandAvatarItem) getData()) == null || (user = chatLandAvatarItem2.getUser()) == null || !user.isSend()))) {
            if (this.clickUtils.isFastDoubleClick()) {
                return;
            }
            if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                ChatLandAvatarItem chatLandAvatarItem4 = (ChatLandAvatarItem) getData();
                if (chatLandAvatarItem4 != null && (uin = chatLandAvatarItem4.getUin()) != null) {
                    IRouter router = Square.INSTANCE.getConfig().getRouter();
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Context context = itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    router.routeToNearbyDetailPage(context, uin);
                }
            } else {
                MapItemController controller = getController();
                if (controller != null && (listener2 = controller.getListener()) != null) {
                    IMapViewListener.DefaultImpls.onItemClicked$default(listener2, this, getIndex(), getData(), 19, null, 16, null);
                }
            }
        } else {
            MapItemController controller2 = getController();
            if (controller2 != null && (listener = controller2.getListener()) != null) {
                IMapViewListener.DefaultImpls.onItemClicked$default(listener, this, getIndex(), getData(), 18, null, 16, null);
            }
        }
        reportCb.invoke();
    }

    private final void extraItemHide() {
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
        ViewExtensionsKt.setVisibility(avatarOnlineStatusSimpleBubble, false);
        FrameLayout frameLayout = this.binding.avatarNameContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarNameContainer");
        ViewExtensionsKt.setVisibility(frameLayout, false);
        LinearLayout linearLayout = this.binding.pkResultArea;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultArea");
        ViewExtensionsKt.setVisibility(linearLayout, false);
        this.binding.chatLandSpeakBubble.resetView();
    }

    public final String getAvatarType() {
        Resource userResource;
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem == null || (userResource = chatLandAvatarItem.getUserResource()) == null || !userResource.canPlay()) {
            return "bottom_up_image";
        }
        if (userResource.getIsDefault()) {
            return "zero_image";
        }
        return "user_image";
    }

    public final String getBubbleType() {
        User user;
        SitDownInfo sitDown;
        OnlineStatus onlineStatus;
        String customText;
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem != null && (user = chatLandAvatarItem.getUser()) != null && (sitDown = user.getSitDown()) != null && (onlineStatus = sitDown.getOnlineStatus()) != null && (customText = onlineStatus.getCustomText()) != null) {
            if (customText.length() == 0) {
                return "non_words";
            }
        }
        return "custom_words";
    }

    public final int getInteractionType() {
        User user;
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem == null || (user = chatLandAvatarItem.getUser()) == null) {
            return 0;
        }
        if (user.isSend()) {
            return 2;
        }
        return user.isReceiver() ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.tencent.state.map.MapItem] */
    private final void handlePKResult(Function0<Unit> reportCb) {
        IMapViewListener listener;
        if (this.clickUtils.isFastDoubleClick()) {
            return;
        }
        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) getData();
        if (chatLandAvatarItem == null || chatLandAvatarItem.isMe()) {
            MapItemController controller = getController();
            if (controller != null && (listener = controller.getListener()) != null) {
                IMapViewListener.DefaultImpls.onItemClicked$default(listener, this, getIndex(), getData(), 21, null, 16, null);
            }
            reportCb.invoke();
        }
    }

    private final void hideSpeakBubble() {
        SquareBubbleInfo bubbleSkin;
        SitDownInfo sitDown;
        OnlineStatus onlineStatus;
        String customText;
        boolean isBlank;
        this.binding.chatLandSpeakBubble.resetView();
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem == null || (bubbleSkin = chatLandAvatarItem.getUser().getBubbleSkin()) == null || SquareBubbleSkinKt.isDefault(bubbleSkin) || (sitDown = chatLandAvatarItem.getUser().getSitDown()) == null || (onlineStatus = sitDown.getOnlineStatus()) == null || (customText = onlineStatus.getCustomText()) == null) {
            return;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(customText);
        if (!isBlank) {
            setBubbleSkin(chatLandAvatarItem);
            setAvatarBubbleData(chatLandAvatarItem);
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
            ViewExtensionsKt.setVisibility(avatarOnlineStatusSimpleBubble, true);
        }
    }

    public final void onDoubleClick(View v3) {
        MapItemController controller;
        IMapViewListener listener;
        if (this.clickUtils.isFastDoubleClick() || (controller = getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        listener.onDoubleClick(this, getIndex(), getData(), 18);
    }

    private final void onUpdateStatus(ChatLandAvatarItem data) {
        FilamentAvatarCoverUri filamentCoverUrl;
        bindBubble(data);
        updateResource(data);
        Resource userResource = data.getUserResource();
        updateCover((userResource == null || (filamentCoverUrl = userResource.getFilamentCoverUrl()) == null) ? null : filamentCoverUrl.encode());
    }

    private final void setAvatarBubbleData(ChatLandAvatarItem data) {
        OnlineStatus onlineStatus;
        OnlineStatus copy;
        SitDownInfo sitDown = data.getUser().getSitDown();
        if (sitDown == null || (onlineStatus = sitDown.getOnlineStatus()) == null) {
            return;
        }
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
        String uin = data.getUin();
        SpecialStatus extraData = onlineStatus.getExtraData();
        copy = onlineStatus.copy((r22 & 1) != 0 ? onlineStatus.id : 0, (r22 & 2) != 0 ? onlineStatus.topStatusId : 0, (r22 & 4) != 0 ? onlineStatus.richStatus : 0, (r22 & 8) != 0 ? onlineStatus.title : null, (r22 & 16) != 0 ? onlineStatus.icon : null, (r22 & 32) != 0 ? onlineStatus.bigIcon : null, (r22 & 64) != 0 ? onlineStatus.extraData : extraData != null ? SpecialStatus.copy$default(extraData, null, null, null, null, null, 15, null) : null, (r22 & 128) != 0 ? onlineStatus.customText : null, (r22 & 256) != 0 ? onlineStatus.publishTimeTips : null, (r22 & 512) != 0 ? onlineStatus.panelPreviewIcon : null);
        RelationType relationType = data.getUser().getRelationType();
        if (relationType == null) {
            relationType = RelationType.STRANGER;
        }
        IAvatarBubble.DefaultImpls.setData$default(avatarOnlineStatusSimpleBubble, uin, copy, null, null, relationType, false, false, null, 128, null);
    }

    private final void setBubbleSkin(final ChatLandAvatarItem data) {
        SquareBubbleInfo bubbleSkin = data.getUser().getBubbleSkin();
        if (bubbleSkin != null) {
            if (SquareBubbleSkinKt.isReady(bubbleSkin)) {
                this.binding.squareAvatarBubble.updateBubbleSkin(data.getUser().getBubbleSkin());
            } else {
                BubbleSkinDownloadManager.INSTANCE.getBubbleSkinBitmap(data.getUser().getBubbleSkin().getSkinLink(), new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$setBubbleSkin$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                        data.getUser().getBubbleSkin().setBitmap(bitmap);
                        ChatLandAvatarViewHolder.this.getBinding().squareAvatarBubble.updateBubbleSkin(data.getUser().getBubbleSkin());
                    }
                });
            }
        }
    }

    private final void startAlphaAnimation(View view, boolean r85, final Function0<Unit> animationEnd) {
        try {
            Object tag = view.getTag();
            if (!(tag instanceof AlphaAnimation)) {
                tag = null;
            }
            AlphaAnimation alphaAnimation = (AlphaAnimation) tag;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(r85 ? 0.0f : 1.0f, r85 ? 1.0f : 0.0f);
            alphaAnimation2.setDuration(400L);
            view.startAnimation(alphaAnimation2);
            alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$startAlphaAnimation$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Function0 function0 = Function0.this;
                    if (function0 != null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            view.setTag(alphaAnimation2);
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "startAlphaAnimation failed " + th5, null, 4, null);
            if (animationEnd != null) {
                animationEnd.invoke();
            }
        }
    }

    private final void updateResource(ChatLandAvatarItem data) {
        IBaseResourceManager.DefaultImpls.showAvatar$default(getRm(), data, data.getUserResource(), null, 4, null);
        this.binding.avatar.setVideoViewVisibility(false);
        Resource userResource = data.getUserResource();
        if (userResource != null && userResource.canPlay()) {
            IBaseResourceManager.DefaultImpls.playAvatar$default(getRm(), data, data.getUserResource(), new IAvatarAnimListener() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$updateResource$2
                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onFirstFrame() {
                    ChatLandAvatarViewHolder.this.getBinding().avatar.setVideoViewVisibility(true);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayEnd() {
                    IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayError(int i3) {
                    IAvatarAnimListener.DefaultImpls.onPlayError(this, i3);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayStart() {
                    IAvatarAnimListener.DefaultImpls.onPlayStart(this);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onRemovedListener() {
                    IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onStaticFailed() {
                    IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onStaticSuccess() {
                    IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
                }
            }, 0L, false, 8, null);
        } else {
            this.binding.avatar.setImageViewVisibility(true);
        }
        adjustBubbleLayout(data);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public float calculateElevation(Location location) {
        User user;
        Intrinsics.checkNotNullParameter(location, "location");
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem == null || (user = chatLandAvatarItem.getUser()) == null || !user.isReceiver()) {
            return super.calculateElevation(location);
        }
        return 0.0f;
    }

    public final void fadeIn(Function0<Unit> animationEnd) {
        RelativeLayout mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        startAlphaAnimation(mContainer, true, animationEnd);
    }

    public final VasSquareItemChatLandAvatarBinding getBinding() {
        return this.binding;
    }

    public final WeakReference<FrameLayout> getParent() {
        return this.parent;
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public SquareAvatarView getPlayerView() {
        SquareAvatarView squareAvatarView = this.binding.avatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.avatar");
        return squareAvatarView;
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onBackFromDetail() {
        super.onBackFromDetail();
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem != null && chatLandAvatarItem.ingInteraction()) {
            LinearLayout linearLayout = this.binding.avatarNameInteractionContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarNameInteractionContainer");
            ViewExtensionsKt.setVisibility(linearLayout, true);
            ChatLandAvatarItem chatLandAvatarItem2 = this.currentData;
            if (chatLandAvatarItem2 != null) {
                bindPKResult(chatLandAvatarItem2);
                return;
            }
            return;
        }
        FrameLayout frameLayout = this.binding.avatarNameContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarNameContainer");
        ViewExtensionsKt.setVisibility(frameLayout, true);
        ChatLandAvatarItem chatLandAvatarItem3 = this.currentData;
        if (chatLandAvatarItem3 != null) {
            bindBubble(chatLandAvatarItem3);
            bindSpeakBubble(chatLandAvatarItem3);
            bindPKResult(chatLandAvatarItem3);
        }
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!SquareRuntime.INSTANCE.hasNearbyMark()) {
            MapItemController controller = getController();
            if (controller != null && !controller.getIsWelcomeScaleAnimDone()) {
                return;
            }
            if (isMapMinimum()) {
                onMapMinimum(true);
                return;
            }
        }
        ChatLandAvatarItem transform = transform(data);
        if (transform != null) {
            bindBubble(transform);
            initReport(transform);
            bindSpeakBubble(transform);
            bindPKResult(transform);
            bindAvatarImageShow(transform);
        }
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onMapMinimum(boolean isMin) {
        if (isMin) {
            stop(true);
            if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
                this.binding.avatar.setImageViewVisibility(true);
            }
            ChatLandAvatarItem chatLandAvatarItem = this.currentData;
            if (chatLandAvatarItem != null && chatLandAvatarItem.ingInteraction()) {
                LinearLayout linearLayout = this.binding.pkResultArea;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultArea");
                ViewExtensionsKt.setVisibility(linearLayout, false);
                LinearLayout linearLayout2 = this.binding.avatarNameInteractionContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.avatarNameInteractionContainer");
                ViewExtensionsKt.setVisibility(linearLayout2, false);
                return;
            }
            extraItemHide();
            return;
        }
        ChatLandAvatarItem chatLandAvatarItem2 = this.currentData;
        if (chatLandAvatarItem2 != null && chatLandAvatarItem2.ingInteraction()) {
            LinearLayout linearLayout3 = this.binding.avatarNameInteractionContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.avatarNameInteractionContainer");
            ViewExtensionsKt.setVisibility(linearLayout3, true);
            ChatLandAvatarItem chatLandAvatarItem3 = this.currentData;
            if (chatLandAvatarItem3 != null) {
                bindPKResult(chatLandAvatarItem3);
                return;
            }
            return;
        }
        FrameLayout frameLayout = this.binding.avatarNameContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarNameContainer");
        ViewExtensionsKt.setVisibility(frameLayout, true);
        ChatLandAvatarItem chatLandAvatarItem4 = this.currentData;
        if (chatLandAvatarItem4 != null) {
            bindBubble(chatLandAvatarItem4);
            bindSpeakBubble(chatLandAvatarItem4);
            bindPKResult(chatLandAvatarItem4);
        }
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder, com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        this.binding.avatar.setStaticSource(null, true);
        LinearLayout linearLayout = this.binding.avatarNameInteractionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarNameInteractionContainer");
        ViewExtensionsKt.setVisibility(linearLayout, false);
        extraItemHide();
        IFaceDecoder iFaceDecoder = this.faceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destroy();
        }
        this.faceDecoder = null;
        super.onRecycled();
    }

    @Override // com.tencent.state.map.MapViewHolder
    public boolean onScaleToDetail() {
        boolean onScaleToDetail = super.onScaleToDetail();
        if (onScaleToDetail) {
            if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
                this.binding.avatar.setImageViewVisibility(true);
            }
            MapItemController controller = getController();
            if (controller != null) {
                controller.setItemAlpha(0.0f);
            }
            ChatLandAvatarItem chatLandAvatarItem = this.currentData;
            if (chatLandAvatarItem != null && chatLandAvatarItem.ingInteraction()) {
                LinearLayout linearLayout = this.binding.pkResultArea;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultArea");
                ViewExtensionsKt.setVisibility(linearLayout, false);
                LinearLayout linearLayout2 = this.binding.avatarNameInteractionContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.avatarNameInteractionContainer");
                ViewExtensionsKt.setVisibility(linearLayout2, false);
            } else {
                extraItemHide();
            }
        }
        return onScaleToDetail;
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onVisible() {
        super.onVisible();
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem != null) {
            bindRingAnim(chatLandAvatarItem);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void setRepeat(boolean repeat) {
        User user;
        SitDownInfo sitDown;
        Location location;
        ChatLandAvatarItem chatLandAvatarItem = this.currentData;
        if (chatLandAvatarItem != null && (user = chatLandAvatarItem.getUser()) != null && (sitDown = user.getSitDown()) != null && sitDown.getIsFlexTable()) {
            setLocationRepeat(repeat);
            ChatLandAvatarItem chatLandAvatarItem2 = (ChatLandAvatarItem) getData();
            if (chatLandAvatarItem2 == null || (location = chatLandAvatarItem2.getLocation()) == null) {
                return;
            }
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            itemView.setElevation(calculateElevation(location));
            return;
        }
        setLocationRepeat(false);
    }

    public final void stopRingAnim() {
        FrameLayout frameLayout;
        ISquarePagView iSquarePagView = this.ringPagView;
        if (iSquarePagView != null) {
            iSquarePagView.stop();
        }
        ISquarePagView iSquarePagView2 = this.ringPagView;
        if (iSquarePagView2 != null && (frameLayout = this.parent.get()) != null) {
            frameLayout.removeView(iSquarePagView2.getView());
        }
        this.ringPagView = null;
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void bindAvatar(ChatLandAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.avatar.setData(data);
        IResourceManager.DefaultImpls.setAvatarResource$default(getRm(), data, (SquareSwitchUtils.INSTANCE.enableFilamentIndex() || data.getUser().isReceiver()) ? false : true, null, 4, null);
        if (data.getUser().isReceiver()) {
            setRepeat(true);
        }
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void resizeAvatar(ChatLandAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        adjustAvatarLocation(data);
        View view = this.binding.hitArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hitArea");
        ViewHolderExtensionsKt.adjustHitAreaLocation(view, data);
        adjustBubbleLayout(data);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public ChatLandAvatarItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof ChatLandAvatarItem)) {
            data = null;
        }
        return (ChatLandAvatarItem) data;
    }

    public final Map<String, Object> getPKElementInfo(ChatLandAvatarItem data) {
        String str;
        String str2;
        Map<String, Object> mutableMapOf;
        User user;
        SitDownInfo sitDown;
        User user2;
        User user3;
        SitDownInfo sitDown2;
        if (((data == null || (user3 = data.getUser()) == null || (sitDown2 = user3.getSitDown()) == null) ? null : sitDown2.getPkResult()) == PKResult.SUPPORT) {
            str = "red";
        } else {
            str = "blue";
        }
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LABEL_TYPE, str);
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HOST_GUEST_TYPE, Integer.valueOf((data == null || !data.isMe()) ? 1 : 0));
        Object obj = "";
        if (data == null || (user2 = data.getUser()) == null || (str2 = user2.getUin()) == null) {
            str2 = "";
        }
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str2);
        if (data != null && (user = data.getUser()) != null && (sitDown = user.getSitDown()) != null) {
            obj = Long.valueOf(sitDown.getRoomId());
        }
        pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_IS_ROOM_ID, obj);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final void initReport(final ChatLandAvatarItem data) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        SitDownInfo sitDown = data.getUser().getSitDown();
        long tableId = sitDown != null ? sitDown.getTableId() : 0L;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View view = this.binding.hitArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hitArea");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_TABLE_ID, Long.valueOf(tableId)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(data.getAppId())));
        squareReporter.setElementInfo(view, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_AVATAR_ICON, mutableMapOf, false, false);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_TABLE_ID, Long.valueOf(tableId)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(data.getAppId())));
        squareReporter2.setElementInfo(avatarOnlineStatusSimpleBubble, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_AVATAR_BUBBLE, mutableMapOf2, false, false);
        final Map<String, Object> pKElementInfo = getPKElementInfo(data);
        IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = this.binding.pkResultArea;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultArea");
        squareReporter3.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_PK_LABEL, pKElementInfo, false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$initReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String avatarType;
                int interactionType;
                Map<String, Object> mutableMapOf3;
                String bubbleType;
                Map<String, Object> mutableMapOf4;
                IReporter squareReporter4 = SquareBaseKt.getSquareReporter();
                View view2 = ChatLandAvatarViewHolder.this.getBinding().hitArea;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.hitArea");
                Pair[] pairArr = new Pair[3];
                avatarType = ChatLandAvatarViewHolder.this.getAvatarType();
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_TYPE, avatarType);
                interactionType = ChatLandAvatarViewHolder.this.getInteractionType();
                pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_CLCK_USER_TYPE, Integer.valueOf(interactionType));
                String uin = data.getUin();
                if (uin == null) {
                    uin = "";
                }
                pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_SQUARE_AVATAR_UIN, uin);
                mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(pairArr);
                squareReporter4.reportEvent("imp", view2, mutableMapOf3);
                AvatarOnlineStatusSimpleBubble it = ChatLandAvatarViewHolder.this.getBinding().squareAvatarBubble;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.getVisibility() == 0) {
                    IReporter squareReporter5 = SquareBaseKt.getSquareReporter();
                    bubbleType = ChatLandAvatarViewHolder.this.getBubbleType();
                    mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUBBLE_TYPE, bubbleType));
                    squareReporter5.reportEvent("imp", it, mutableMapOf4);
                }
                LinearLayout it5 = ChatLandAvatarViewHolder.this.getBinding().pkResultArea;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                if (it5.getVisibility() == 0) {
                    SquareBaseKt.getSquareReporter().reportEvent("imp", it5, pKElementInfo);
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.pzs) {
            checkOpenDetail(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$onClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String avatarType;
                    int interactionType;
                    String str;
                    Map<String, Object> mutableMapOf;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    View view2 = ChatLandAvatarViewHolder.this.getBinding().hitArea;
                    Intrinsics.checkNotNullExpressionValue(view2, "binding.hitArea");
                    Pair[] pairArr = new Pair[3];
                    avatarType = ChatLandAvatarViewHolder.this.getAvatarType();
                    pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_TYPE, avatarType);
                    interactionType = ChatLandAvatarViewHolder.this.getInteractionType();
                    pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_CLCK_USER_TYPE, Integer.valueOf(interactionType));
                    ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) ChatLandAvatarViewHolder.this.getData();
                    if (chatLandAvatarItem == null || (str = chatLandAvatarItem.getUin()) == null) {
                        str = "";
                    }
                    pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_SQUARE_AVATAR_UIN, str);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    squareReporter.reportEvent("clck", view2, mutableMapOf);
                }
            });
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.qmx) {
            checkOpenDetail(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$onClick$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String bubbleType;
                    Map<String, Object> mutableMapOf;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = ChatLandAvatarViewHolder.this.getBinding().squareAvatarBubble;
                    Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
                    bubbleType = ChatLandAvatarViewHolder.this.getBubbleType();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUBBLE_TYPE, bubbleType));
                    squareReporter.reportEvent("clck", avatarOnlineStatusSimpleBubble, mutableMapOf);
                }
            });
        } else if (valueOf != null && valueOf.intValue() == R.id.qcr) {
            handlePKResult(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder$onClick$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Map<String, Object> pKElementInfo;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    LinearLayout linearLayout = ChatLandAvatarViewHolder.this.getBinding().pkResultArea;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultArea");
                    ChatLandAvatarViewHolder chatLandAvatarViewHolder = ChatLandAvatarViewHolder.this;
                    pKElementInfo = chatLandAvatarViewHolder.getPKElementInfo((ChatLandAvatarItem) chatLandAvatarViewHolder.getData());
                    squareReporter.reportEvent("clck", linearLayout, pKElementInfo);
                }
            });
        }
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(ChatLandAvatarItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onBindViewHolder: index=");
        sb5.append(index);
        sb5.append(", data=");
        sb5.append(data.getUin());
        sb5.append("- ");
        SitDownInfo sitDown = data.getUser().getSitDown();
        sb5.append(sitDown != null ? Long.valueOf(sitDown.getTableId()) : null);
        sb5.append(" - ");
        sb5.append(data.getLocation());
        squareLog.i(TAG, sb5.toString());
        this.currentData = data;
        bindAvatar(data);
        bindNickName(data);
        resizeAvatar(data);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        MapItemController controller = getController();
        itemView.setAlpha(controller != null ? controller.getItemAlpha() : 1.0f);
        bindListeners();
        onFirstScreenCompleted(data, index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fadeIn$default(ChatLandAvatarViewHolder chatLandAvatarViewHolder, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        chatLandAvatarViewHolder.fadeIn(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void startAlphaAnimation$default(ChatLandAvatarViewHolder chatLandAvatarViewHolder, View view, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        chatLandAvatarViewHolder.startAlphaAnimation(view, z16, function0);
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void doBind(ChatLandAvatarItem data, int index, int event) {
        FilamentAvatarCoverUri filamentCoverUrl;
        Intrinsics.checkNotNullParameter(data, "data");
        super.doBind((ChatLandAvatarViewHolder) data, index, event);
        this.currentData = data;
        if (!isMapMinimum() || SquareRuntime.INSTANCE.hasNearbyMark()) {
            if (event == 2) {
                onUpdateStatus(data);
                return;
            }
            if (event != 26) {
                switch (event) {
                    case 28:
                        bindSpeakBubble(data);
                        return;
                    case 29:
                        bindAvatarImageShow(data);
                        return;
                    case 30:
                        Resource userResource = data.getUserResource();
                        updateCover((userResource == null || (filamentCoverUrl = userResource.getFilamentCoverUrl()) == null) ? null : filamentCoverUrl.encode());
                        return;
                    case 31:
                        hideSpeakBubble();
                        return;
                    case 32:
                        stopRingAnim();
                        return;
                    default:
                        return;
                }
            }
            bindBubble(data);
        }
    }

    @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
    }
}
