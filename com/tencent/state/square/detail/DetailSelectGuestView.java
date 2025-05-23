package com.tencent.state.square.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasMultiMotionService;
import com.tencent.state.service.VasSquareQZoneService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareSummaryViewConfig;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.MapResourceType;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareDatailMultiOperatorBinding;
import com.tencent.state.square.databinding.VasSquareDetailGuestViewBinding;
import com.tencent.state.square.detail.DetailCommonView;
import com.tencent.state.square.detail.event.DetailGuestAddToSquareEvent;
import com.tencent.state.square.detail.event.DetailGuestUpdateStickersEvent;
import com.tencent.state.square.feeds.SquareQZoneFeedsManager;
import com.tencent.state.square.like.IStickersChangedListener;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.SquareEndInviteDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001sB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nB\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\b\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020#H\u0002J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u000fH\u0002J\u0010\u00106\u001a\u0002072\u0006\u0010*\u001a\u00020\u000fH\u0002J\b\u00108\u001a\u00020#H\u0002J+\u00109\u001a\u00020#2!\u0010:\u001a\u001d\u0012\u0013\u0012\u001107\u00a2\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020#0;H\u0002J\b\u0010?\u001a\u00020#H\u0002J\u0018\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\fH\u0002J\u0010\u0010D\u001a\u00020#2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010E\u001a\u00020#H\u0002J\u0006\u0010F\u001a\u00020#J\u0006\u0010G\u001a\u00020#J\b\u0010H\u001a\u00020IH\u0016J\n\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010L\u001a\u00020\u000f2\b\u0010M\u001a\u0004\u0018\u00010\u0017H\u0002J\n\u0010N\u001a\u0004\u0018\u00010OH\u0002J\b\u0010P\u001a\u00020BH\u0016J\b\u0010Q\u001a\u00020#H\u0002J\u001e\u0010R\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010T\u001a\u00020#H\u0016J\u001a\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020\u000f2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020#H\u0016J\u0010\u0010Y\u001a\u00020#2\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020#H\u0016J\u0010\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020\u0015H\u0016J\b\u0010_\u001a\u000207H\u0016J\b\u0010`\u001a\u00020#H\u0016J\u0010\u0010a\u001a\u00020#2\u0006\u0010Z\u001a\u00020[H\u0016J\u0018\u0010b\u001a\u00020#2\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020#2\u0006\u0010f\u001a\u00020\fH\u0016J\u001a\u0010g\u001a\u00020#2\b\u0010h\u001a\u0004\u0018\u00010i2\b\b\u0002\u0010j\u001a\u000207J\u0010\u0010k\u001a\u00020#2\u0006\u0010l\u001a\u000207H\u0002J\b\u0010m\u001a\u00020#H\u0002J\u0010\u0010n\u001a\u00020#2\u0006\u0010o\u001a\u00020pH\u0016J\b\u0010q\u001a\u00020#H\u0002J\u0010\u0010r\u001a\u00020#2\u0006\u0010S\u001a\u00020\u0017H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006t"}, d2 = {"Lcom/tencent/state/square/detail/DetailSelectGuestView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/square/detail/IDetailParentView;", "Lcom/tencent/state/square/detail/DetailCommonView$CommonListener;", "Lcom/tencent/state/square/like/IStickersChangedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "billNum", "", "binding", "Lcom/tencent/state/square/databinding/VasSquareDetailGuestViewBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "currentMultiMotion", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "currentSquareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "entranceSource", "Lcom/tencent/state/square/detail/EntranceSource;", "inviteStatus", "reporter", "Lcom/tencent/state/square/IReporter;", "socialStatusListener", "Lcom/tencent/state/square/detail/DetailGuestListener;", "summaryView", "Lcom/tencent/state/square/api/ISquareSummaryView;", "unreadNum", "adjustBottomViewWidth", "", "adjustLayoutParams", "bindAddFriendButton", "bindAddSquareButton", "bindBottomContainer", "bindBubbleView", "bindBuySameButton", "myUin", "bindChatView", "bindCommonView", "bindElement", "bindLocationView", "bindMultiMotionView", "bindOperatorView", "bindQZoneButton", "bindQZoneReddot", "bindSettingView", "bindSmallHomeButton", "customUin", "canShowBuySame", "", "checkAndShowTargetOperatorContainer", "checkQZoneRedDot", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "needShow", "clickBuySame", "clickChatView", "view", "Landroid/view/View;", "type", "clickJumpToQZone", "clickSmallHome", "destroy", "endMotionClick", "getCommonView", "Lcom/tencent/state/square/detail/DetailCommonView;", "getCurrentMapPlayableSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "getGenderString", "squareItem", "getRealAvatarLocation", "Lcom/tencent/state/map/Location;", "getView", "initClickListener", "initView", "data", "onBackEvent", "onDecodeComplete", "uin", "avatar", "Landroid/graphics/Bitmap;", "onDoubleClickEvent", "e", "Landroid/view/MotionEvent;", "onEnterScaleAnimEnd", "onInviteStateChanged", "state", "onIsEditEnter", "onMenuClick", "onSingleClickEvent", "onStickersChanged", c.B, "Lcom/tencent/state/square/data/Stickers;", "playLikeAnimation", "likeType", "setUnReadView", "message", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "isFirst", "showQZoneRedDot", "hasReddot", "updateBubbleLocation", "updateBubbleView", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "updatePaiYiPaiView", "updatePlayState", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectGuestView extends FrameLayout implements IDetailParentView, DetailCommonView.CommonListener, IStickersChangedListener {
    private static final int CHAT_VIEW_COMMON_MARGIN = 32;
    private static final int CHAT_VIEW_LIMIT_MARGIN = 28;
    private static final int CUSTOM_VIEW_COMMON_MARGIN = 58;
    private static final int CUSTOM_VIEW_LIMIT_MARGIN = 38;
    private static final String MAX_COUNT_TEXT = "99+";
    private static final String TAG = "DetailSelectGuestView";
    private String billNum;
    private final VasSquareDetailGuestViewBinding binding;
    private final FastClickUtils clickUtils;
    private SquareMultiMotionDetailData currentMultiMotion;
    private SquareAvatarItem currentSquareItem;
    private EntranceSource entranceSource;
    private int inviteStatus;
    private final IReporter reporter;
    private DetailGuestListener socialStatusListener;
    private ISquareSummaryView summaryView;
    private int unreadNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSelectGuestView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareDetailGuestViewBinding inflate = VasSquareDetailGuestViewBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailGuestView\u2026ater.from(context), this)");
        this.binding = inflate;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        this.inviteStatus = -1;
        this.clickUtils = new FastClickUtils(800L);
        initClickListener();
    }

    private final void adjustBottomViewWidth() {
        TextView textView = this.binding.customNewMessageTips;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.customNewMessageTips");
        ViewExtensionsKt.updateLayoutParams(textView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$adjustBottomViewWidth$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = 0;
                receiver.weight = 1.0f;
            }
        });
        FrameLayout frameLayout = this.binding.customAddSquareContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customAddSquareContainer");
        ViewExtensionsKt.updateLayoutParams(frameLayout, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$adjustBottomViewWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams receiver) {
                VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                vasSquareDetailGuestViewBinding = DetailSelectGuestView.this.binding;
                TextView textView2 = vasSquareDetailGuestViewBinding.customNewMessageTips;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.customNewMessageTips");
                if (textView2.getVisibility() == 0) {
                    receiver.width = -2;
                    receiver.weight = 0.0f;
                } else {
                    receiver.width = 0;
                    receiver.weight = 1.0f;
                }
            }
        });
        FrameLayout frameLayout2 = this.binding.customAddFriendContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.customAddFriendContainer");
        ViewExtensionsKt.updateLayoutParams(frameLayout2, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$adjustBottomViewWidth$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams receiver) {
                VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                vasSquareDetailGuestViewBinding = DetailSelectGuestView.this.binding;
                TextView textView2 = vasSquareDetailGuestViewBinding.customNewMessageTips;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.customNewMessageTips");
                if (textView2.getVisibility() == 0) {
                    receiver.width = -2;
                    receiver.weight = 0.0f;
                } else {
                    receiver.width = 0;
                    receiver.weight = 1.0f;
                }
            }
        });
    }

    public final void adjustLayoutParams() {
        Resources resources;
        DisplayMetrics displayMetrics;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        final int i3 = displayMetrics.heightPixels <= 1600 ? 28 : 32;
        LinearLayout linearLayout = this.binding.customBottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customBottomContainer");
        ViewExtensionsKt.updateLayoutParams(linearLayout, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$adjustLayoutParams$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                receiver.bottomMargin = i3;
            }
        });
    }

    private final void bindAddFriendButton() {
        if (UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_ADD_FRIEND_BUTTON, this.entranceSource, this.currentSquareItem, null, false, 24, null)) {
            FrameLayout frameLayout = this.binding.customAddFriendContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customAddFriendContainer");
            frameLayout.setVisibility(0);
        } else {
            FrameLayout frameLayout2 = this.binding.customAddFriendContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.customAddFriendContainer");
            frameLayout2.setVisibility(8);
        }
        FrameLayout frameLayout3 = this.binding.customAddFriendContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.customAddFriendContainer");
        if (frameLayout3.getVisibility() == 0) {
            IReporter iReporter = this.reporter;
            FrameLayout frameLayout4 = this.binding.customAddFriendContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.customAddFriendContainer");
            iReporter.reportEvent("imp", frameLayout4, new LinkedHashMap());
        }
    }

    private final void bindAddSquareButton() {
        if (UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_ADD_SQUARE_BUTTON, this.entranceSource, this.currentSquareItem, null, false, 24, null)) {
            FrameLayout frameLayout = this.binding.customAddSquareContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customAddSquareContainer");
            frameLayout.setVisibility(0);
        } else {
            FrameLayout frameLayout2 = this.binding.customAddSquareContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.customAddSquareContainer");
            frameLayout2.setVisibility(8);
        }
        FrameLayout frameLayout3 = this.binding.customAddSquareContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.customAddSquareContainer");
        if (frameLayout3.getVisibility() == 0) {
            IReporter iReporter = this.reporter;
            FrameLayout frameLayout4 = this.binding.customAddSquareContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.customAddSquareContainer");
            iReporter.reportEvent("imp", frameLayout4, new LinkedHashMap());
        }
    }

    public final void bindBottomContainer() {
        bindChatView();
        bindAddSquareButton();
        bindAddFriendButton();
        adjustBottomViewWidth();
    }

    public final void bindBubbleView() {
        SquareAvatarItem squareAvatarItem;
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        updateBubbleLocation();
        RelativeLayout relativeLayout = this.binding.avatarLocationView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarLocationView");
        relativeLayout.setVisibility(0);
        VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding = this.binding;
        DetailCommonView detailCommonView = vasSquareDetailGuestViewBinding.commonView;
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = vasSquareDetailGuestViewBinding.avatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusDetailBubble, "binding.avatarBubble");
        detailCommonView.initBubbleView(avatarOnlineStatusDetailBubble, false, this);
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble2 = this.binding.avatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusDetailBubble2, "binding.avatarBubble");
        if (avatarOnlineStatusDetailBubble2.getVisibility() != 0 || (squareAvatarItem = this.currentSquareItem) == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null) {
            return;
        }
        updateBubbleView(onlineStatus);
    }

    private final void bindBuySameButton(String myUin) {
        if (canShowBuySame(myUin)) {
            this.binding.operatorContainer.operatorEnterDressMallText.setText(R.string.f169736xb1);
            RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterDressMallContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026orEnterDressMallContainer");
            relativeLayout.setVisibility(0);
            IReporter iReporter = this.reporter;
            RelativeLayout relativeLayout2 = this.binding.operatorContainer.operatorEnterDressMallContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContaine\u2026orEnterDressMallContainer");
            iReporter.reportEvent("imp", relativeLayout2, new LinkedHashMap());
        } else {
            RelativeLayout relativeLayout3 = this.binding.operatorContainer.operatorEnterDressMallContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContaine\u2026orEnterDressMallContainer");
            relativeLayout3.setVisibility(8);
        }
        checkAndShowTargetOperatorContainer();
    }

    private final void bindChatView() {
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_AIO_INFO, this.entranceSource, this.currentSquareItem, null, false, 24, null)) {
            TextView textView = this.binding.customNewMessageTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.customNewMessageTips");
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = this.binding.customNewMessageTips;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.customNewMessageTips");
        textView2.setVisibility(0);
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null) {
            TextView textView3 = this.binding.customNewMessageTips;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.customNewMessageTips");
            textView3.setText(getResources().getString(R.string.xdq, getGenderString(squareAvatarItem)));
        }
    }

    private final void bindCommonView() {
        DetailGuestListener detailGuestListener = this.socialStatusListener;
        if (detailGuestListener != null) {
            this.binding.commonView.initView(this.currentSquareItem, this.entranceSource, detailGuestListener, this);
        }
    }

    private final void bindElement() {
        IReporter iReporter = this.reporter;
        RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterSmallHomeContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
        iReporter.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_SMALL_HOME, new LinkedHashMap(), false, false);
        IReporter iReporter2 = this.reporter;
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = this.binding.avatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusDetailBubble, "binding.avatarBubble");
        iReporter2.setElementInfo(avatarOnlineStatusDetailBubble, SquareReportConst.ElementId.ELEMENT_ID_STATE_BUBBLE, new LinkedHashMap(), false, false);
        IReporter iReporter3 = this.reporter;
        RelativeLayout relativeLayout2 = this.binding.operatorContainer.operatorEnterDressMallContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContaine\u2026orEnterDressMallContainer");
        iReporter3.setElementInfo(relativeLayout2, SquareReportConst.ElementId.ELEMENT_ID_SMAE_STYLE, new LinkedHashMap(), false, false);
        IReporter iReporter4 = this.reporter;
        TextView textView = this.binding.customNewMessageTips;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.customNewMessageTips");
        iReporter4.setElementInfo(textView, SquareReportConst.ElementId.ELEMENT_ID_CHAT, new LinkedHashMap(), false, false);
        IReporter iReporter5 = this.reporter;
        LinearLayout linearLayout = this.binding.customChatBubbleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customChatBubbleContainer");
        iReporter5.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_BUBBLE, new LinkedHashMap(), false, false);
        this.reporter.setElementInfo(this.binding.commonView.getMultiTitle(), "em_zplan_double_pose_end_btn", new LinkedHashMap(), false, false);
        IReporter iReporter6 = this.reporter;
        RelativeLayout relativeLayout3 = this.binding.operatorContainer.operatorEnterQzoneContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
        iReporter6.setElementInfo(relativeLayout3, SquareReportConst.ElementId.ELEMENT_ID_SPACE_ENTRANCE, new LinkedHashMap(), false, false);
        IReporter iReporter7 = this.reporter;
        RelativeLayout relativeLayout4 = this.binding.operatorContainer.singleOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.operatorContainer.singleOperatorContainer");
        iReporter7.setElementInfo(relativeLayout4, SquareReportConst.ElementId.ELEMENT_ID_SPACE_ENTRANCE, new LinkedHashMap(), false, false);
        this.reporter.setElementInfo(this.binding.commonView.getSetting(), SquareReportConst.ElementId.ELEMENT_ID_SETTING, new LinkedHashMap(), false, true);
        IReporter iReporter8 = this.reporter;
        FrameLayout frameLayout = this.binding.customAddSquareContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customAddSquareContainer");
        iReporter8.setElementInfo(frameLayout, SquareReportConst.ElementId.ELEMENT_ID_ADD_TO_SQUARE, new LinkedHashMap(), false, false);
        IReporter iReporter9 = this.reporter;
        FrameLayout frameLayout2 = this.binding.customAddFriendContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.customAddFriendContainer");
        iReporter9.setElementInfo(frameLayout2, SquareReportConst.ElementId.ELEMENT_ID_ADD_FRIEND, new LinkedHashMap(), false, false);
    }

    private final void bindLocationView() {
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        AvatarLocationInfo locationInfo = squareAvatarItem != null ? squareAvatarItem.getLocationInfo() : null;
        if (locationInfo != null) {
            DetailCommonView detailCommonView = this.binding.commonView;
            detailCommonView.updateLocationView(locationInfo, detailCommonView.getMultiTitleContainer().getVisibility() == 0);
        }
    }

    public final void bindMultiMotionView() {
        this.binding.commonView.getMultiParent().setVisibility(0);
    }

    public final void bindOperatorView() {
        String uin;
        String currentAccountUin = Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin();
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem == null || (uin = squareAvatarItem.getUin()) == null) {
            return;
        }
        bindBuySameButton(currentAccountUin);
        bindSmallHomeButton(uin);
        bindQZoneButton();
    }

    private final void bindQZoneButton() {
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_QZONE_BUTTON, this.entranceSource, this.currentSquareItem, null, false, 24, null)) {
            RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterQzoneContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
            relativeLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = this.binding.operatorContainer.singleOperatorContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContainer.singleOperatorContainer");
            relativeLayout2.setVisibility(8);
        } else {
            LinearLayout linearLayout = this.binding.operatorContainer.multiOperatorContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.operatorContainer.multiOperatorContainer");
            if (linearLayout.getVisibility() == 0) {
                RelativeLayout relativeLayout3 = this.binding.operatorContainer.operatorEnterQzoneContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
                relativeLayout3.setVisibility(0);
                RelativeLayout relativeLayout4 = this.binding.operatorContainer.singleOperatorContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.operatorContainer.singleOperatorContainer");
                relativeLayout4.setVisibility(8);
                IReporter iReporter = this.reporter;
                RelativeLayout relativeLayout5 = this.binding.operatorContainer.operatorEnterQzoneContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout5, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
                iReporter.reportEvent("imp", relativeLayout5, new LinkedHashMap());
            } else {
                RelativeLayout relativeLayout6 = this.binding.operatorContainer.operatorEnterQzoneContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout6, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
                relativeLayout6.setVisibility(8);
                RelativeLayout relativeLayout7 = this.binding.operatorContainer.singleOperatorContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout7, "binding.operatorContainer.singleOperatorContainer");
                relativeLayout7.setVisibility(0);
                IReporter iReporter2 = this.reporter;
                RelativeLayout relativeLayout8 = this.binding.operatorContainer.singleOperatorContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout8, "binding.operatorContainer.singleOperatorContainer");
                iReporter2.reportEvent("imp", relativeLayout8, new LinkedHashMap());
            }
        }
        bindQZoneReddot();
        checkAndShowTargetOperatorContainer();
    }

    private final void bindQZoneReddot() {
        QZoneFeedsInfo feedInfo;
        RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterQzoneContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
        if (relativeLayout.getVisibility() != 0) {
            RelativeLayout relativeLayout2 = this.binding.operatorContainer.singleOperatorContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContainer.singleOperatorContainer");
            if (relativeLayout2.getVisibility() != 0) {
                return;
            }
        }
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        showQZoneRedDot((squareAvatarItem == null || (feedInfo = squareAvatarItem.getFeedInfo()) == null) ? false : feedInfo.getHasNew());
        checkQZoneRedDot(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$bindQZoneReddot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                DetailSelectGuestView.this.showQZoneRedDot(z16);
            }
        });
    }

    private final void bindSettingView() {
        this.binding.commonView.getSetting().setVisibility(UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_MORE_BUTTON, this.entranceSource, this.currentSquareItem, null, false, 24, null) ? 0 : 4);
    }

    private final void bindSmallHomeButton(String customUin) {
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_SMALL_HOME_BUTTON, this.entranceSource, this.currentSquareItem, null, false, 24, null)) {
            RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterSmallHomeContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
            relativeLayout.setVisibility(8);
        } else {
            Square.INSTANCE.getConfig().getCommonUtils().shouldShowSmallHomeEntry(customUin, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$bindSmallHomeButton$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding;
                    VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding2;
                    VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding3;
                    IReporter iReporter;
                    VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding4;
                    if (z16) {
                        vasSquareDetailGuestViewBinding2 = DetailSelectGuestView.this.binding;
                        vasSquareDetailGuestViewBinding2.operatorContainer.operatorEnterSmallHomeText.setText(R.string.xbh);
                        vasSquareDetailGuestViewBinding3 = DetailSelectGuestView.this.binding;
                        RelativeLayout relativeLayout2 = vasSquareDetailGuestViewBinding3.operatorContainer.operatorEnterSmallHomeContainer;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
                        relativeLayout2.setVisibility(0);
                        iReporter = DetailSelectGuestView.this.reporter;
                        vasSquareDetailGuestViewBinding4 = DetailSelectGuestView.this.binding;
                        RelativeLayout relativeLayout3 = vasSquareDetailGuestViewBinding4.operatorContainer.operatorEnterSmallHomeContainer;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
                        iReporter.reportEvent("imp", relativeLayout3, new LinkedHashMap());
                    } else {
                        vasSquareDetailGuestViewBinding = DetailSelectGuestView.this.binding;
                        RelativeLayout relativeLayout4 = vasSquareDetailGuestViewBinding.operatorContainer.operatorEnterSmallHomeContainer;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
                        relativeLayout4.setVisibility(8);
                    }
                    DetailSelectGuestView.this.checkAndShowTargetOperatorContainer();
                }
            });
        }
        checkAndShowTargetOperatorContainer();
    }

    private final boolean canShowBuySame(String myUin) {
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_BUY_SAME_BUTTON, this.entranceSource, this.currentSquareItem, null, false, 24, null) || !Square.INSTANCE.getConfig().getCommonUtils().checkZplanAccessible(myUin)) {
            return false;
        }
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        String dressKey = squareAvatarItem != null ? squareAvatarItem.getDressKey() : null;
        return !(dressKey == null || dressKey.length() == 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkAndShowTargetOperatorContainer() {
        LinearLayout linearLayout;
        RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterQzoneContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
        if (relativeLayout.getVisibility() != 0) {
            RelativeLayout relativeLayout2 = this.binding.operatorContainer.operatorEnterDressMallContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContaine\u2026orEnterDressMallContainer");
            if (relativeLayout2.getVisibility() != 0) {
                LinearLayout linearLayout2 = this.binding.operatorContainer.multiOperatorContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.operatorContainer.multiOperatorContainer");
                linearLayout2.setVisibility(8);
                linearLayout = this.binding.operatorContainer.multiOperatorContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.operatorContainer.multiOperatorContainer");
                if (linearLayout.getVisibility() != 0) {
                    RelativeLayout relativeLayout3 = this.binding.operatorContainer.singleOperatorContainer;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContainer.singleOperatorContainer");
                    if (relativeLayout3.getVisibility() != 0) {
                        VasSquareDatailMultiOperatorBinding vasSquareDatailMultiOperatorBinding = this.binding.operatorContainer;
                        Intrinsics.checkNotNullExpressionValue(vasSquareDatailMultiOperatorBinding, "binding.operatorContainer");
                        FrameLayout mRv = vasSquareDatailMultiOperatorBinding.getMRv();
                        Intrinsics.checkNotNullExpressionValue(mRv, "binding.operatorContainer.root");
                        mRv.setVisibility(8);
                        FrameLayout frameLayout = this.binding.customView;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customView");
                        frameLayout.setVisibility(8);
                        return;
                    }
                }
                VasSquareDatailMultiOperatorBinding vasSquareDatailMultiOperatorBinding2 = this.binding.operatorContainer;
                Intrinsics.checkNotNullExpressionValue(vasSquareDatailMultiOperatorBinding2, "binding.operatorContainer");
                FrameLayout mRv2 = vasSquareDatailMultiOperatorBinding2.getMRv();
                Intrinsics.checkNotNullExpressionValue(mRv2, "binding.operatorContainer.root");
                mRv2.setVisibility(0);
                FrameLayout frameLayout2 = this.binding.customView;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.customView");
                frameLayout2.setVisibility(0);
            }
        }
        LinearLayout linearLayout3 = this.binding.operatorContainer.multiOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.operatorContainer.multiOperatorContainer");
        linearLayout3.setVisibility(0);
        RelativeLayout relativeLayout4 = this.binding.operatorContainer.singleOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.operatorContainer.singleOperatorContainer");
        boolean z16 = relativeLayout4.getVisibility() == 0;
        RelativeLayout relativeLayout5 = this.binding.operatorContainer.singleOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout5, "binding.operatorContainer.singleOperatorContainer");
        relativeLayout5.setVisibility(8);
        if (z16) {
            bindQZoneButton();
        }
        linearLayout = this.binding.operatorContainer.multiOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.operatorContainer.multiOperatorContainer");
        if (linearLayout.getVisibility() != 0) {
        }
        VasSquareDatailMultiOperatorBinding vasSquareDatailMultiOperatorBinding22 = this.binding.operatorContainer;
        Intrinsics.checkNotNullExpressionValue(vasSquareDatailMultiOperatorBinding22, "binding.operatorContainer");
        FrameLayout mRv22 = vasSquareDatailMultiOperatorBinding22.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv22, "binding.operatorContainer.root");
        mRv22.setVisibility(0);
        FrameLayout frameLayout22 = this.binding.customView;
        Intrinsics.checkNotNullExpressionValue(frameLayout22, "binding.customView");
        frameLayout22.setVisibility(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void checkQZoneRedDot(final Function1<? super Boolean, Unit> callback) {
        QZoneFeedsInfo feedInfo;
        Long longOrNull;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null && (r0 = squareAvatarItem.getUin()) != null && longOrNull != null) {
            final long longValue = longOrNull.longValue();
            VasSquareQZoneService.INSTANCE.queryQZoneRedDot(longValue, new ResultCallback<QZoneFeedsInfo>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$checkQZoneRedDot$$inlined$let$lambda$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(final QZoneFeedsInfo result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$checkQZoneRedDot$$inlined$let$lambda$1.1
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
                            SquareAvatarItem squareAvatarItem2;
                            QZoneFeedsInfo feedInfo2;
                            SquareAvatarItem squareAvatarItem3;
                            DetailGuestListener detailGuestListener;
                            if (result.getHasNew()) {
                                squareAvatarItem3 = this.currentSquareItem;
                                if (squareAvatarItem3 != null) {
                                    squareAvatarItem3.setFeedInfo(result);
                                }
                                callback.invoke(Boolean.valueOf(result.getHasNew()));
                                detailGuestListener = this.socialStatusListener;
                                if (detailGuestListener != null) {
                                    detailGuestListener.updateQZoneFeeds(String.valueOf(longValue), result);
                                    return;
                                }
                                return;
                            }
                            DetailSelectGuestView$checkQZoneRedDot$$inlined$let$lambda$1 detailSelectGuestView$checkQZoneRedDot$$inlined$let$lambda$1 = DetailSelectGuestView$checkQZoneRedDot$$inlined$let$lambda$1.this;
                            Function1 function1 = callback;
                            squareAvatarItem2 = this.currentSquareItem;
                            function1.invoke(Boolean.valueOf((squareAvatarItem2 == null || (feedInfo2 = squareAvatarItem2.getFeedInfo()) == null) ? false : feedInfo2.getHasNew()));
                        }
                    });
                }
            });
        } else {
            SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
            callback.invoke(Boolean.valueOf((squareAvatarItem2 == null || (feedInfo = squareAvatarItem2.getFeedInfo()) == null) ? false : feedInfo.getHasNew()));
        }
    }

    public final void clickBuySame() {
        IReporter iReporter = this.reporter;
        RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterDressMallContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026orEnterDressMallContainer");
        iReporter.reportEvent("clck", relativeLayout, new LinkedHashMap());
        DetailGuestListener detailGuestListener = this.socialStatusListener;
        if (detailGuestListener != null) {
            detailGuestListener.goToMall();
        }
    }

    public final void clickChatView(View view, int type) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null) {
            IReporter iReporter = this.reporter;
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_friend_or_group", 0), TuplesKt.to("zplan_other_user_qq", squareAvatarItem.getUin()), TuplesKt.to("zplan_unread_message_number", Integer.valueOf(squareAvatarItem.getExtra().unReadCount())), TuplesKt.to(SquareReportConst.Key.KEY_HANDLE_MESSAGE_METHOD, Integer.valueOf(type)));
            iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_HANDLE_MESSAGE, mutableMapOf2);
        }
        IReporter iReporter2 = this.reporter;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_HAS_UNREAD_MESSAGE, Integer.valueOf(this.unreadNum == 0 ? 0 : 1));
        pairArr[1] = TuplesKt.to("zplan_unread_message_number", Integer.valueOf(this.unreadNum));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iReporter2.reportEvent("clck", view, mutableMapOf);
        DetailGuestListener detailGuestListener = this.socialStatusListener;
        if (detailGuestListener != null) {
            detailGuestListener.goToMiniAioChat(this.currentSquareItem);
        }
    }

    public final void clickJumpToQZone(View view) {
        boolean doJumpToQZone;
        Map<String, Object> mutableMapOf;
        String uin;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null) {
            SquareQZoneFeedsManager squareQZoneFeedsManager = SquareQZoneFeedsManager.INSTANCE;
            Long l3 = null;
            String qZoneHomePageUrl = squareQZoneFeedsManager.getQZoneHomePageUrl(squareAvatarItem != null ? squareAvatarItem.getUin() : null, SquareBase.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin());
            boolean hasNew = squareAvatarItem.getFeedInfo().getHasNew();
            View mRv = this.binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
            Context context = mRv.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
            if (squareAvatarItem2 != null && (uin = squareAvatarItem2.getUin()) != null) {
                l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
            }
            doJumpToQZone = squareQZoneFeedsManager.doJumpToQZone(context, l3, qZoneHomePageUrl, 2, (r17 & 16) != 0 ? "" : squareAvatarItem.getFeedInfo().getId(), (r17 & 32) != 0, (r17 & 64) != 0 ? true : hasNew);
            if (doJumpToQZone) {
                View view2 = this.binding.operatorContainer.operatorEnterQzoneRedDot;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.operatorContainer.operatorEnterQzoneRedDot");
                view2.setVisibility(8);
                View view3 = this.binding.operatorContainer.singleOperatorQzoneRedDot;
                Intrinsics.checkNotNullExpressionValue(view3, "binding.operatorContaine\u2026singleOperatorQzoneRedDot");
                view3.setVisibility(8);
                squareAvatarItem.getFeedInfo().setHasNew(false);
                DetailGuestListener detailGuestListener = this.socialStatusListener;
                if (detailGuestListener != null) {
                    detailGuestListener.updateQZoneFeeds(squareAvatarItem.getUin(), squareAvatarItem.getFeedInfo());
                }
            }
            IReporter iReporter = this.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_RED_DOT, Integer.valueOf(hasNew ? 1 : 0)));
            iReporter.reportEvent("clck", view, mutableMapOf);
        }
    }

    public final void clickSmallHome() {
        IReporter iReporter = this.reporter;
        RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterSmallHomeContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
        iReporter.reportEvent("clck", relativeLayout, new LinkedHashMap());
        DetailGuestListener detailGuestListener = this.socialStatusListener;
        if (detailGuestListener != null) {
            detailGuestListener.goToSmallHome();
        }
    }

    private final Location getRealAvatarLocation() {
        return this.binding.commonView.getAvatarLocation();
    }

    private final void initClickListener() {
        this.binding.operatorContainer.operatorEnterDressMallContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailSelectGuestView.this.clickBuySame();
            }
        });
        this.binding.operatorContainer.operatorEnterSmallHomeContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailSelectGuestView.this.clickSmallHome();
            }
        });
        this.binding.operatorContainer.operatorEnterQzoneContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                DetailSelectGuestView detailSelectGuestView = DetailSelectGuestView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailSelectGuestView.clickJumpToQZone(it);
            }
        });
        this.binding.operatorContainer.singleOperatorContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                DetailSelectGuestView detailSelectGuestView = DetailSelectGuestView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailSelectGuestView.clickJumpToQZone(it);
            }
        });
        this.binding.customNewMessageTips.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                DetailSelectGuestView detailSelectGuestView = DetailSelectGuestView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailSelectGuestView.clickChatView(it, 4);
            }
        });
        this.binding.customChatBubbleContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                DetailSelectGuestView detailSelectGuestView = DetailSelectGuestView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailSelectGuestView.clickChatView(it, 6);
            }
        });
        this.binding.commonView.getMultiTitle().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailSelectGuestView.this.endMotionClick();
            }
        });
        this.binding.customAddSquareContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareAvatarItem squareAvatarItem;
                IReporter iReporter;
                VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding;
                EntranceSource entranceSource;
                EntranceSource entranceSource2;
                MainScene mainScene;
                squareAvatarItem = DetailSelectGuestView.this.currentSquareItem;
                if (squareAvatarItem != null) {
                    entranceSource = DetailSelectGuestView.this.entranceSource;
                    boolean z16 = entranceSource != null && entranceSource.fromSquare();
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    boolean isGenderMale = squareAvatarItem.getIsGenderMale();
                    int unitType = squareAvatarItem.getUnitType();
                    entranceSource2 = DetailSelectGuestView.this.entranceSource;
                    if (entranceSource2 == null || (mainScene = entranceSource2.getMain()) == null) {
                        mainScene = MainScene.UNKNOWN;
                    }
                    simpleEventBus.dispatchEvent(new DetailGuestAddToSquareEvent(squareAvatarItem, isGenderMale, unitType, mainScene, z16));
                }
                iReporter = DetailSelectGuestView.this.reporter;
                vasSquareDetailGuestViewBinding = DetailSelectGuestView.this.binding;
                FrameLayout frameLayout = vasSquareDetailGuestViewBinding.customAddSquareContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customAddSquareContainer");
                iReporter.reportEvent("clck", frameLayout, new LinkedHashMap());
            }
        });
        this.binding.customAddFriendContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initClickListener$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                SquareAvatarItem squareAvatarItem;
                IReporter iReporter;
                VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding;
                squareAvatarItem = DetailSelectGuestView.this.currentSquareItem;
                if (squareAvatarItem != null) {
                    IRouter router = Square.INSTANCE.getConfig().getRouter();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Context context = it.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "it.context");
                    router.routeToAddFriend(context, squareAvatarItem.getUin(), squareAvatarItem.getNickName());
                }
                iReporter = DetailSelectGuestView.this.reporter;
                vasSquareDetailGuestViewBinding = DetailSelectGuestView.this.binding;
                FrameLayout frameLayout = vasSquareDetailGuestViewBinding.customAddFriendContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customAddFriendContainer");
                iReporter.reportEvent("clck", frameLayout, new LinkedHashMap());
            }
        });
    }

    public final void showQZoneRedDot(boolean hasReddot) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        View view = this.binding.operatorContainer.operatorEnterQzoneRedDot;
        Intrinsics.checkNotNullExpressionValue(view, "binding.operatorContainer.operatorEnterQzoneRedDot");
        view.setVisibility(hasReddot ? 0 : 8);
        View view2 = this.binding.operatorContainer.singleOperatorQzoneRedDot;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.operatorContaine\u2026singleOperatorQzoneRedDot");
        view2.setVisibility(hasReddot ? 0 : 8);
        RelativeLayout relativeLayout = this.binding.operatorContainer.singleOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContainer.singleOperatorContainer");
        if (relativeLayout.getVisibility() == 0) {
            IReporter iReporter = this.reporter;
            RelativeLayout relativeLayout2 = this.binding.operatorContainer.singleOperatorContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContainer.singleOperatorContainer");
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_RED_DOT, Integer.valueOf(hasReddot ? 1 : 0)));
            iReporter.reportEvent("imp", relativeLayout2, mutableMapOf2);
        }
        RelativeLayout relativeLayout3 = this.binding.operatorContainer.operatorEnterQzoneContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
        if (relativeLayout3.getVisibility() == 0) {
            IReporter iReporter2 = this.reporter;
            RelativeLayout relativeLayout4 = this.binding.operatorContainer.operatorEnterQzoneContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_RED_DOT, Integer.valueOf(hasReddot ? 1 : 0)));
            iReporter2.reportEvent("imp", relativeLayout4, mutableMapOf);
        }
    }

    private final void updateBubbleLocation() {
        Resources resources;
        DisplayMetrics displayMetrics;
        Location realAvatarLocation = getRealAvatarLocation();
        if (realAvatarLocation != null) {
            RelativeLayout relativeLayout = this.binding.avatarLocationView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarLocationView");
            float y16 = realAvatarLocation.getY();
            Intrinsics.checkNotNullExpressionValue(this.binding.avatarLocationView, "binding.avatarLocationView");
            relativeLayout.setY((y16 - r4.getHeight()) + ViewExtensionsKt.dip((View) this, 8));
            this.binding.commonView.getMultiParent().setY(realAvatarLocation.getY() + realAvatarLocation.getHeight());
            Context context = getContext();
            int i3 = 58;
            if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null && displayMetrics.heightPixels <= 1600) {
                i3 = 38;
            }
            FrameLayout frameLayout = this.binding.customView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customView");
            frameLayout.setY(realAvatarLocation.getY() + realAvatarLocation.getHeight() + ViewExtensionsKt.dip((View) this, i3));
        }
    }

    public final void updatePaiYiPaiView() {
        SquareAvatarItem squareAvatarItem;
        if (getRealAvatarLocation() == null || (squareAvatarItem = this.currentSquareItem) == null || squareAvatarItem.isMe()) {
            return;
        }
        LinearLayout linearLayout = this.binding.customDoubleClickView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customDoubleClickView");
        linearLayout.setY(r0.getY() + r0.getHeight() + com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 18));
        LinearLayout linearLayout2 = this.binding.customDoubleClickView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.customDoubleClickView");
        linearLayout2.setVisibility(0);
        SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
        if (squareAvatarItem2 != null) {
            TextView textView = this.binding.paiYiPaiTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.paiYiPaiTips");
            textView.setText(getResources().getString(R.string.xe8, getGenderString(squareAvatarItem2)));
        }
    }

    public final void destroy() {
        this.binding.commonView.destroy();
    }

    public final void endMotionClick() {
        final Context context;
        SquareMultiMotionDetailData squareMultiMotionDetailData = this.currentMultiMotion;
        if (squareMultiMotionDetailData == null || !squareMultiMotionDetailData.isMeReceiver() || (context = getContext()) == null) {
            return;
        }
        this.reporter.reportEvent("clck", this.binding.commonView.getMultiTitle(), new LinkedHashMap());
        SquareEndInviteDialog squareEndInviteDialog = new SquareEndInviteDialog(context, false, 0, 0, 0, null, null, 126, null);
        squareEndInviteDialog.setPositiveCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$endMotionClick$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                String str;
                int i3 = z16 ? 2 : 1;
                VasMultiMotionService vasMultiMotionService = VasMultiMotionService.INSTANCE;
                str = this.billNum;
                if (str == null) {
                    str = "";
                }
                vasMultiMotionService.endInvite(str, i3, new ResultCallback<Resource>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$endMotionClick$$inlined$let$lambda$1.1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i16, String str2) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i16, str2);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i16, String str2, String str3) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i16, str2, str3);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
                    
                        r0 = r2.socialStatusListener;
                     */
                    @Override // com.tencent.state.service.ResultCallback
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onResultSuccess(Resource result) {
                        VasSquareDetailGuestViewBinding vasSquareDetailGuestViewBinding;
                        SquareAvatarItem squareAvatarItem;
                        DetailGuestListener detailGuestListener;
                        SquareAvatarExtra extra;
                        Square.INSTANCE.getConfig().getCommonUtils().showToast(context, "\u5df2\u7ed3\u675f\u5bf9\u65b9\u7684\u53cc\u4eba\u72b6\u6001", 2);
                        vasSquareDetailGuestViewBinding = this.binding;
                        vasSquareDetailGuestViewBinding.commonView.getMultiTitleContainer().setVisibility(8);
                        squareAvatarItem = this.currentSquareItem;
                        if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null) {
                            extra.setMultiMotion(false);
                        }
                        if (result == null || detailGuestListener == null) {
                            return;
                        }
                        detailGuestListener.resetTargetAvatar(result);
                    }
                });
            }
        });
        squareEndInviteDialog.setNegativeCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$endMotionClick$1$2
            public final void invoke(boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
        squareEndInviteDialog.show();
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public DetailCommonView getCommonView() {
        DetailCommonView detailCommonView = this.binding.commonView;
        Intrinsics.checkNotNullExpressionValue(detailCommonView, "binding.commonView");
        return detailCommonView;
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public MapPlayableSource getCurrentMapPlayableSource() {
        Resource stateResource;
        Resource stateResource2;
        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            SquareAvatarItem squareAvatarItem = this.currentSquareItem;
            if (squareAvatarItem == null || (stateResource2 = SquareResourceManagerKt.getStateResource(squareAvatarItem)) == null) {
                return null;
            }
            return SquareItemKt.toMapPlayableSource(stateResource2, MapResourceType.Filament, squareAvatarItem.getUin(), Integer.valueOf(squareAvatarItem.getDefaultResourceId()));
        }
        SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
        if (squareAvatarItem2 == null || (stateResource = SquareResourceManagerKt.getStateResource(squareAvatarItem2)) == null) {
            return null;
        }
        SquareAvatarItem squareAvatarItem3 = this.currentSquareItem;
        return SquareItemKt.toMapPlayableSource(stateResource, squareAvatarItem3 != null ? Integer.valueOf(squareAvatarItem3.getDefaultResourceId()) : null);
    }

    public final void initView(EntranceSource entranceSource, SquareAvatarItem data, DetailGuestListener socialStatusListener) {
        Intrinsics.checkNotNullParameter(entranceSource, "entranceSource");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(socialStatusListener, "socialStatusListener");
        this.currentSquareItem = data;
        this.entranceSource = entranceSource;
        this.socialStatusListener = socialStatusListener;
        bindElement();
        bindCommonView();
        bindSettingView();
        Square.INSTANCE.getConfig().getThreadManager().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestView$initView$1
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
                DetailSelectGuestView.this.adjustLayoutParams();
                DetailSelectGuestView.this.updatePaiYiPaiView();
                DetailSelectGuestView.this.bindOperatorView();
                DetailSelectGuestView.this.bindBubbleView();
                DetailSelectGuestView.this.bindMultiMotionView();
                DetailSelectGuestView.this.bindBottomContainer();
            }
        });
        setVisibility(0);
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onBackEvent() {
        DetailGuestListener detailGuestListener = this.socialStatusListener;
        if (detailGuestListener != null) {
            detailGuestListener.onBackClick();
        }
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onDecodeComplete(String uin, Bitmap avatar) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onDoubleClickEvent(MotionEvent e16) {
        DetailGuestListener detailGuestListener;
        DetailGuestListener detailGuestListener2;
        Intrinsics.checkNotNullParameter(e16, "e");
        DetailCommonView.CommonListener.DefaultImpls.onDoubleClickEvent(this, e16);
        if (this.clickUtils.isFastDoubleClick() || (detailGuestListener = this.socialStatusListener) == null || !detailGuestListener.isClickAvatar(e16, false) || (detailGuestListener2 = this.socialStatusListener) == null) {
            return;
        }
        detailGuestListener2.goToInteraction();
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onEnterScaleAnimEnd() {
        DetailGuestListener detailGuestListener = this.socialStatusListener;
        if (detailGuestListener != null) {
            detailGuestListener.hideSquareAvatar();
        }
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void onInviteStateChanged(SquareMultiMotionDetailData state) {
        SquareAvatarExtra extra;
        String senderNick;
        Long longOrNull;
        SquareAvatarExtra extra2;
        SquareAvatarExtra extra3;
        Intrinsics.checkNotNullParameter(state, "state");
        this.currentMultiMotion = state;
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_MULTI_MOTION_INFO, this.entranceSource, this.currentSquareItem, null, false, 24, null)) {
            this.binding.commonView.getMultiTitleContainer().setVisibility(8);
            bindLocationView();
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "onInviteStateChanged: currentStatus=" + this.inviteStatus + ", state=" + state);
        if (state.getInviteStatus() != this.inviteStatus) {
            this.inviteStatus = state.getInviteStatus();
            this.billNum = state.getBillNum();
            if (state.isInviteSuccess()) {
                SquareAvatarItem squareAvatarItem = this.currentSquareItem;
                Integer onlineStatusId = squareAvatarItem != null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem) : null;
                int id5 = state.getStatusInfo().getId();
                if (onlineStatusId != null && onlineStatusId.intValue() == id5) {
                    SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
                    String uin = squareAvatarItem2 != null ? squareAvatarItem2.getUin() : null;
                    if (Intrinsics.areEqual(uin, String.valueOf(state.getSender().f443328a))) {
                        senderNick = state.getReceiverNick();
                    } else {
                        senderNick = Intrinsics.areEqual(uin, String.valueOf(state.getReceiver().f443328a)) ? state.getSenderNick() : null;
                    }
                    if (senderNick == null) {
                        this.binding.commonView.getMultiTitleContainer().setVisibility(8);
                    } else {
                        this.binding.commonView.getMultiTitleContainer().setVisibility(0);
                        if (senderNick.length() > 8) {
                            StringBuilder sb5 = new StringBuilder();
                            String substring = senderNick.substring(0, 8);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                            sb5.append(substring);
                            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                            senderNick = sb5.toString();
                        }
                        String genderString = getGenderString(this.currentSquareItem);
                        this.binding.commonView.getMultiTitle().setText(genderString + "\u548c " + senderNick + " \u7684\u53cc\u4ebaPOSE");
                        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin());
                        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
                        if (longValue != state.getSender().f443328a && longValue != state.getReceiver().f443328a) {
                            SquareAvatarItem squareAvatarItem3 = this.currentSquareItem;
                            if (squareAvatarItem3 != null && (extra3 = squareAvatarItem3.getExtra()) != null) {
                                extra3.setMultiMotion(false);
                            }
                            this.binding.commonView.getMultiTitle().setCompoundDrawables(null, null, null, null);
                        } else {
                            SquareAvatarItem squareAvatarItem4 = this.currentSquareItem;
                            if (squareAvatarItem4 != null && (extra2 = squareAvatarItem4.getExtra()) != null) {
                                extra2.setMultiMotion(true);
                            }
                            Drawable drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.i9m);
                            if (drawable != null) {
                                drawable.setBounds(0, 0, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 18), com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 18));
                            }
                            this.binding.commonView.getMultiTitle().setCompoundDrawables(null, null, drawable, null);
                            this.binding.commonView.getMultiTitle().setCompoundDrawablePadding(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 4));
                        }
                        this.reporter.reportEvent("imp", this.binding.commonView.getMultiTitle(), new LinkedHashMap());
                    }
                    bindLocationView();
                }
            }
            SquareAvatarItem squareAvatarItem5 = this.currentSquareItem;
            if (squareAvatarItem5 != null && (extra = squareAvatarItem5.getExtra()) != null) {
                extra.setMultiMotion(false);
            }
            this.binding.commonView.getMultiTitleContainer().setVisibility(8);
            bindLocationView();
        }
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    /* renamed from: onIsEditEnter */
    public boolean getIsEditorPage() {
        return false;
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void onMenuClick() {
        this.reporter.reportEvent("clck", this.binding.commonView.getSetting(), new LinkedHashMap());
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onSingleClickEvent(MotionEvent e16) {
        DetailGuestListener detailGuestListener;
        Intrinsics.checkNotNullParameter(e16, "e");
        if (this.binding.commonView.isClickAvatar(e16, false) || (detailGuestListener = this.socialStatusListener) == null) {
            return;
        }
        detailGuestListener.onBackClick();
    }

    @Override // com.tencent.state.square.like.IStickersChangedListener
    public void onStickersChanged(String uin, Stickers r46) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(r46, "stickers");
        SimpleEventBus.getInstance().dispatchEvent(new DetailGuestUpdateStickersEvent(uin, r46));
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void playLikeAnimation(int likeType) {
        this.binding.avatarBubble.playLikeAnimation(likeType);
    }

    public final void setUnReadView(SquareBaseMessageRecord message, boolean isFirst) {
        Map<String, Object> mutableMapOf;
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_AIO_INFO, this.entranceSource, this.currentSquareItem, null, false, 24, null)) {
            LinearLayout linearLayout = this.binding.customChatBubbleContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customChatBubbleContainer");
            linearLayout.setVisibility(8);
            return;
        }
        if (message != null && message.getUnreadCount() != 0 && !message.getForbiddenNotify()) {
            if (this.summaryView == null) {
                ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ISquareSummaryView summaryView = commonUtils.getSummaryView(context, new SquareSummaryViewConfig(13.0f, Color.parseColor("#000000")));
                this.summaryView = summaryView;
                this.binding.customChatBubble.addView(summaryView != null ? summaryView.getView() : null, 0);
            }
            ISquareSummaryView iSquareSummaryView = this.summaryView;
            if (iSquareSummaryView != null) {
                ISquareSummaryView.DefaultImpls.setSummaryData$default(iSquareSummaryView, message.getSummaryData(), null, 2, null);
            }
            LinearLayout linearLayout2 = this.binding.customChatBubbleContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.customChatBubbleContainer");
            if (linearLayout2.getVisibility() != 0) {
                LinearLayout linearLayout3 = this.binding.customChatBubbleContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.customChatBubbleContainer");
                linearLayout3.setVisibility(0);
                IReporter iReporter = this.reporter;
                LinearLayout linearLayout4 = this.binding.customChatBubble;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.customChatBubble");
                iReporter.reportEvent("imp", linearLayout4, new LinkedHashMap());
            }
            this.unreadNum = message.getUnreadCount();
            if (message.getUnreadCount() > 99) {
                TextView textView = this.binding.customNewMessageRedPoint;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.customNewMessageRedPoint");
                textView.setText(MAX_COUNT_TEXT);
            } else {
                TextView textView2 = this.binding.customNewMessageRedPoint;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.customNewMessageRedPoint");
                textView2.setText(String.valueOf(message.getUnreadCount()));
            }
        } else {
            LinearLayout linearLayout5 = this.binding.customChatBubbleContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.customChatBubbleContainer");
            linearLayout5.setVisibility(8);
            this.unreadNum = 0;
        }
        if (isFirst) {
            IReporter iReporter2 = this.reporter;
            LinearLayout linearLayout6 = this.binding.customChatBubbleContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.customChatBubbleContainer");
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_HAS_UNREAD_MESSAGE, Integer.valueOf(this.unreadNum == 0 ? 0 : 1));
            pairArr[1] = TuplesKt.to("zplan_unread_message_number", Integer.valueOf(this.unreadNum));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            iReporter2.reportEvent("imp", linearLayout6, mutableMapOf);
        }
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void updateBubbleView(OnlineStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        AvatarOnlineStatusDetailBubble.showCommonView$default(this.binding.avatarBubble, status, false, 2, null);
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void updatePlayState(SquareAvatarItem data) {
        SpecialStatus extraData;
        SongInfo songInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = this.binding.avatarBubble;
        OnlineStatus onlineStatus = data.getExtra().getOnlineStatus();
        avatarOnlineStatusDetailBubble.updatePlayIcon((onlineStatus == null || (extraData = onlineStatus.getExtraData()) == null || (songInfo = extraData.getSongInfo()) == null) ? null : songInfo.getSongId(), data.isMe());
    }

    private final String getGenderString(SquareAvatarItem squareItem) {
        if (squareItem != null && !squareItem.getIsGenderMale()) {
            return "\u5979";
        }
        return "\u4ed6";
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onDoubleClickEvent() {
        DetailGuestListener detailGuestListener;
        if (this.clickUtils.isFastDoubleClick() || (detailGuestListener = this.socialStatusListener) == null) {
            return;
        }
        detailGuestListener.goToInteraction();
    }

    public static /* synthetic */ void setUnReadView$default(DetailSelectGuestView detailSelectGuestView, SquareBaseMessageRecord squareBaseMessageRecord, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        detailSelectGuestView.setUnReadView(squareBaseMessageRecord, z16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSelectGuestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareDetailGuestViewBinding inflate = VasSquareDetailGuestViewBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailGuestView\u2026ater.from(context), this)");
        this.binding = inflate;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        this.inviteStatus = -1;
        this.clickUtils = new FastClickUtils(800L);
        initClickListener();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSelectGuestView(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareDetailGuestViewBinding inflate = VasSquareDetailGuestViewBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailGuestView\u2026ater.from(context), this)");
        this.binding = inflate;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        this.inviteStatus = -1;
        this.clickUtils = new FastClickUtils(800L);
        initClickListener();
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public View getView() {
        return this;
    }
}
