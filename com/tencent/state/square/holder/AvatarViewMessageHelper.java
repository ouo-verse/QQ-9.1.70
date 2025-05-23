package com.tencent.state.square.holder;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.MsgType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.PlayState;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.databinding.VasSquareItemAvatarBinding;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.view.ComposedAvatarView;
import com.tencent.state.view.SquareImageView;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010\u001d\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\nH\u0002J\u0006\u0010-\u001a\u00020\u001cJ\b\u0010.\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u0006\u00100\u001a\u00020\u0012J\u001c\u00101\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0002J\u0012\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00107\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00108\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00109\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u0010:\u001a\u00020\u001c2\b\u0010;\u001a\u0004\u0018\u00010*H\u0016J\u0006\u0010<\u001a\u00020\u001cJ\u000e\u0010=\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J \u0010?\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020EH\u0002J\u000e\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001J\u000e\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\nJ\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2 = {"Lcom/tencent/state/square/holder/AvatarViewMessageHelper;", "Landroid/view/View$OnClickListener;", "Landroid/animation/Animator$AnimatorListener;", "holder", "Lcom/tencent/state/square/holder/AvatarViewHolder;", "(Lcom/tencent/state/square/holder/AvatarViewHolder;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemAvatarBinding;", "clickProxy", "curMsgIndex", "", "getHolder", "()Lcom/tencent/state/square/holder/AvatarViewHolder;", "itemHeight", "", "lastMsg", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "playingAim", "", "previewItems", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/holder/MsgPreviewItem;", "Lkotlin/collections/ArrayList;", "pttPagView", "Lcom/tencent/state/square/api/ISquarePagView;", "reporter", "Lcom/tencent/state/square/IReporter;", "bindListener", "", "bindPreviewInfo", "msg", "bindReport", "bindUnreadCount", "unReadNum", "bindUnreadMsg", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "cancelAnim", QCircleLpReportDc05507.KEY_CLEAR, "from", "", "getContainerView", "Landroid/view/View;", "getUnreadCountString", "unReadCount", "hideMessageContent", "initMsgPreviewView", "initPttPagViewIfNeeded", "isContainerVisible", "isNewMsg", "nextItemIndex", "curIndex", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", NodeProps.ON_CLICK, "v", "onRecycled", "onUpdatePlayPttState", "playMsgAnimation", "reBindCurMsgInfo", "resetParams", "reportExposure", "reportPttBubbleEvent", "EventKey", "state", "Lcom/tencent/state/square/data/PlayState;", "setClickProxy", "listener", "setContainerVisibility", "visibility", "syncForbiddenNotifyStatus", "forbidden", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarViewMessageHelper implements View.OnClickListener, Animator.AnimatorListener {
    private static final long ANIM_DURATION = 250;
    private static final float ITEM_HEIGHT = 35.0f;
    private static final String TAG = "AvatarViewMessageHelper";
    private final VasSquareItemAvatarBinding binding;
    private View.OnClickListener clickProxy;
    private int curMsgIndex;
    private final AvatarViewHolder holder;
    private final float itemHeight;
    private SquareBaseMessageRecord lastMsg;
    private boolean playingAim;
    private ArrayList<MsgPreviewItem> previewItems;
    private ISquarePagView pttPagView;
    private final IReporter reporter;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PlayState.INIT.ordinal()] = 1;
            iArr[PlayState.PLAY.ordinal()] = 2;
        }
    }

    public AvatarViewMessageHelper(AvatarViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.holder = holder;
        VasSquareItemAvatarBinding binding = holder.getBinding();
        this.binding = binding;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        this.previewItems = new ArrayList<>();
        Intrinsics.checkNotNullExpressionValue(binding.getRoot(), "binding.root");
        this.itemHeight = ViewExtensionsKt.dip(r2.getContext(), ITEM_HEIGHT);
        initMsgPreviewView();
        bindListener();
        bindReport();
    }

    private final void bindListener() {
        this.binding.avatarPttMessage.setOnClickListener(this);
        this.binding.avatarMessage.setOnClickListener(this);
    }

    private final void bindPreviewInfo(SquareBaseMessageRecord lastMsg, SquareBaseMessageRecord msg2) {
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bindPreviewInfo: ");
            sb5.append(msg2 != null ? msg2.getUin() : null);
            sb5.append(", ");
            sb5.append(this.curMsgIndex);
            sb5.append(", ");
            sb5.append(this.playingAim);
            squareLog.d(TAG, sb5.toString());
        }
        if (msg2 != null) {
            if (this.playingAim) {
                reBindCurMsgInfo(msg2, false, QzoneWebMusicJsPlugin.EVENT_PLAYING);
                return;
            }
            if (lastMsg == null) {
                reBindCurMsgInfo(msg2, true, "direct");
                return;
            }
            if (!isContainerVisible()) {
                reBindCurMsgInfo(msg2, true, "unVisible");
            } else if (!isNewMsg(lastMsg, msg2)) {
                reBindCurMsgInfo(msg2, true, "notNew");
            } else {
                playMsgAnimation(msg2);
            }
        }
    }

    private final void bindReport() {
        IReporter iReporter = this.reporter;
        RelativeLayout relativeLayout = this.binding.avatarPttMessage;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarPttMessage");
        iReporter.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_VOICE_BUBBLE, new LinkedHashMap(), false, false);
        IReporter iReporter2 = this.reporter;
        LinearLayout linearLayout = this.binding.avatarMessage;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarMessage");
        iReporter2.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_MESSAGE_BUBBLE, new LinkedHashMap(), false, false);
    }

    private final void cancelAnim() {
        Iterator<T> it = this.previewItems.iterator();
        while (it.hasNext()) {
            ((MsgPreviewItem) it.next()).getContainer().animate().cancel();
        }
    }

    private final void clear(String from) {
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().d(TAG, "clear:" + from);
        }
        this.lastMsg = null;
        cancelAnim();
    }

    private final void initMsgPreviewView() {
        ArrayList<MsgPreviewItem> arrayList = this.previewItems;
        AvatarViewHolder avatarViewHolder = this.holder;
        FrameLayout frameLayout = this.binding.avatarMessagePreview1.avatarMessagePreviewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarMessagePre\u2026arMessagePreviewContainer");
        TextView textView = this.binding.avatarMessagePreview1.avatarMessagePreviewText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarMessagePre\u2026.avatarMessagePreviewText");
        FrameLayout frameLayout2 = this.binding.avatarMessagePreview1.avatarMessagePreviewSummary;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.avatarMessagePre\u2026atarMessagePreviewSummary");
        arrayList.add(new MsgPreviewItem(avatarViewHolder, frameLayout, textView, frameLayout2));
        ArrayList<MsgPreviewItem> arrayList2 = this.previewItems;
        AvatarViewHolder avatarViewHolder2 = this.holder;
        FrameLayout frameLayout3 = this.binding.avatarMessagePreview2.avatarMessagePreviewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.avatarMessagePre\u2026arMessagePreviewContainer");
        TextView textView2 = this.binding.avatarMessagePreview2.avatarMessagePreviewText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.avatarMessagePre\u2026.avatarMessagePreviewText");
        FrameLayout frameLayout4 = this.binding.avatarMessagePreview2.avatarMessagePreviewSummary;
        Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.avatarMessagePre\u2026atarMessagePreviewSummary");
        arrayList2.add(new MsgPreviewItem(avatarViewHolder2, frameLayout3, textView2, frameLayout4));
    }

    private final void initPttPagViewIfNeeded() {
        View view;
        View view2;
        if (this.pttPagView != null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Context context = root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        this.pttPagView = pagView;
        if (pagView != null) {
            pagView.setPagFile(R.raw.f131004);
        }
        ISquarePagView iSquarePagView = this.pttPagView;
        if (iSquarePagView != null && (view2 = iSquarePagView.getView()) != null) {
            view2.setVisibility(8);
        }
        ISquarePagView iSquarePagView2 = this.pttPagView;
        if (iSquarePagView2 == null || (view = iSquarePagView2.getView()) == null) {
            return;
        }
        this.binding.avatarPttMessage.addView(view, layoutParams);
    }

    private final void reBindCurMsgInfo(SquareBaseMessageRecord msg2, boolean resetParams, String from) {
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().d(TAG, "reBindCurMsgInfo, " + resetParams + ", " + from + ", " + this.curMsgIndex + ", " + this.playingAim);
        }
        MsgPreviewItem msgPreviewItem = this.previewItems.get(this.curMsgIndex);
        msgPreviewItem.bindMsg(msg2);
        msgPreviewItem.getContainer().setVisibility(0);
        if (resetParams) {
            cancelAnim();
            msgPreviewItem.getContainer().setTranslationY(0.0f);
            msgPreviewItem.getContainer().setAlpha(1.0f);
        }
    }

    private final void reportPttBubbleEvent(String EventKey, PlayState state) {
        Map<String, Object> mutableMapOf;
        IReporter iReporter = this.reporter;
        RelativeLayout relativeLayout = this.binding.avatarPttMessage;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarPttMessage");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_VOICE_STATE, Integer.valueOf(state.getType())));
        iReporter.reportEvent(EventKey, relativeLayout, mutableMapOf);
    }

    private final void syncForbiddenNotifyStatus(boolean forbidden) {
        RelativeLayout relativeLayout = this.binding.avatarPttMessage;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarPttMessage");
        relativeLayout.setSelected(!forbidden);
        SquareImageView squareImageView = this.binding.avatarMessageBottom;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatarMessageBottom");
        squareImageView.setSelected(!forbidden);
        LinearLayout linearLayout = this.binding.avatarMessageTop;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarMessageTop");
        linearLayout.setSelected(!forbidden);
        TextView textView = this.binding.avatarMessageUnreadCount;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarMessageUnreadCount");
        textView.setSelected(!forbidden);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindUnreadCount(final int unReadNum) {
        SquareAvatarItem squareAvatarItem;
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bindUnreadCount: ");
            AvatarViewHolder avatarViewHolder = this.holder;
            sb5.append((avatarViewHolder == null || (squareAvatarItem = (SquareAvatarItem) avatarViewHolder.getData()) == null) ? null : squareAvatarItem.getUin());
            sb5.append(", ");
            sb5.append(unReadNum);
            squareLog.d(TAG, sb5.toString());
        }
        String unreadCountString = getUnreadCountString(unReadNum);
        TextView textView = this.binding.avatarMessageUnreadCount;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarMessageUnreadCount");
        textView.setText(unreadCountString);
        TextView textView2 = this.binding.avatarMessageUnreadCount;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.avatarMessageUnreadCount");
        textView2.setVisibility(unReadNum > 0 ? 0 : 8);
        final SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) this.holder.getData();
        if (squareAvatarItem2 != null) {
            this.binding.composedAvatar.post(new Runnable() { // from class: com.tencent.state.square.holder.AvatarViewMessageHelper$bindUnreadCount$1
                @Override // java.lang.Runnable
                public final void run() {
                    VasSquareItemAvatarBinding vasSquareItemAvatarBinding;
                    boolean z16;
                    VasSquareItemAvatarBinding vasSquareItemAvatarBinding2;
                    vasSquareItemAvatarBinding = AvatarViewMessageHelper.this.binding;
                    ComposedAvatarView composedAvatarView = vasSquareItemAvatarBinding.composedAvatar;
                    int i3 = unReadNum;
                    boolean isMe = squareAvatarItem2.isMe();
                    boolean forbiddenNotify = squareAvatarItem2.getExtra().forbiddenNotify();
                    if (unReadNum > 0) {
                        vasSquareItemAvatarBinding2 = AvatarViewMessageHelper.this.binding;
                        RelativeLayout relativeLayout = vasSquareItemAvatarBinding2.avatarPttMessage;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarPttMessage");
                        if (relativeLayout.getVisibility() == 0) {
                            z16 = true;
                            composedAvatarView.bindUnreadInfo(i3, isMe, forbiddenNotify, z16);
                        }
                    }
                    z16 = false;
                    composedAvatarView.bindUnreadInfo(i3, isMe, forbiddenNotify, z16);
                }
            });
            if (unReadNum <= 0) {
                clear("unReadCount");
            }
        }
    }

    public final void bindUnreadMsg(SquareAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bindUnreadMsg: ");
            sb5.append(data.getUin());
            sb5.append(", ");
            SquareAvatarExtra extra = data.getExtra();
            sb5.append((extra != null ? Integer.valueOf(extra.unReadCount()) : null).intValue());
            sb5.append(", ");
            SquareAvatarExtra extra2 = data.getExtra();
            sb5.append(extra2 != null ? extra2.msgText() : null);
            sb5.append(", ");
            SquareAvatarExtra extra3 = data.getExtra();
            sb5.append(extra3 != null ? extra3.hightText() : null);
            squareLog.d(TAG, sb5.toString());
        }
        LinearLayout linearLayout = this.binding.avatarMessage;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarMessage");
        linearLayout.setVisibility(0);
        if (data.getExtra().hasUnreadPttMsg()) {
            RelativeLayout relativeLayout = this.binding.avatarPttMessage;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarPttMessage");
            relativeLayout.setVisibility(0);
        } else {
            RelativeLayout relativeLayout2 = this.binding.avatarPttMessage;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.avatarPttMessage");
            relativeLayout2.setVisibility(8);
        }
        bindPreviewInfo(this.lastMsg, data.getExtra().getLastUnReadMsg());
        this.lastMsg = data.getExtra().getLastUnReadMsg();
        syncForbiddenNotifyStatus(data.getExtra().forbiddenNotify());
        reportExposure(data);
    }

    public final View getContainerView() {
        RelativeLayout relativeLayout = this.binding.avatarMessageContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarMessageContainer");
        return relativeLayout;
    }

    public final AvatarViewHolder getHolder() {
        return this.holder;
    }

    public final void hideMessageContent() {
        LinearLayout linearLayout = this.binding.avatarMessage;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarMessage");
        linearLayout.setVisibility(8);
        RelativeLayout relativeLayout = this.binding.avatarPttMessage;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarPttMessage");
        relativeLayout.setVisibility(8);
    }

    public final boolean isContainerVisible() {
        RelativeLayout relativeLayout = this.binding.avatarMessageContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarMessageContainer");
        return relativeLayout.getVisibility() == 0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().d(TAG, "onAnimationEnd, " + this.playingAim + ", " + this.curMsgIndex);
        }
        int i3 = 0;
        for (Object obj : this.previewItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MsgPreviewItem msgPreviewItem = (MsgPreviewItem) obj;
            if (i3 == this.curMsgIndex) {
                msgPreviewItem.getContainer().setVisibility(0);
                msgPreviewItem.getContainer().setTranslationY(0.0f);
                msgPreviewItem.getContainer().setAlpha(1.0f);
            } else {
                msgPreviewItem.getContainer().setVisibility(8);
                msgPreviewItem.getContainer().setTranslationY(this.itemHeight);
                msgPreviewItem.getContainer().setAlpha(0.0f);
            }
            i3 = i16;
        }
        this.playingAim = false;
    }

    public final void onRecycled() {
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRecycled: ");
            SquareBaseMessageRecord squareBaseMessageRecord = this.lastMsg;
            sb5.append(squareBaseMessageRecord != null ? squareBaseMessageRecord.getUin() : null);
            sb5.append(", ");
            sb5.append(this.playingAim);
            squareLog.d(TAG, sb5.toString());
        }
        clear("recycled");
    }

    public final void onUpdatePlayPttState(SquareAvatarItem data) {
        View view;
        View view2;
        View view3;
        Intrinsics.checkNotNullParameter(data, "data");
        initPttPagViewIfNeeded();
        int i3 = WhenMappings.$EnumSwitchMapping$0[data.getExtra().getIsPlayingPtt().ordinal()];
        if (i3 == 1) {
            ISquarePagView iSquarePagView = this.pttPagView;
            if (iSquarePagView != null && (view = iSquarePagView.getView()) != null) {
                view.setVisibility(8);
            }
            if (Square.INSTANCE.getApplication() != null) {
                this.binding.avatarPttMessageIcon.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i8n));
            }
            SquareImageView squareImageView = this.binding.avatarPttMessageIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatarPttMessageIcon");
            squareImageView.setVisibility(0);
            return;
        }
        if (i3 != 2) {
            SquareImageView squareImageView2 = this.binding.avatarPttMessageIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.avatarPttMessageIcon");
            squareImageView2.setVisibility(8);
            ISquarePagView iSquarePagView2 = this.pttPagView;
            if (iSquarePagView2 != null && (view3 = iSquarePagView2.getView()) != null) {
                view3.setVisibility(0);
            }
            ISquarePagView iSquarePagView3 = this.pttPagView;
            if (iSquarePagView3 != null) {
                ISquarePagView.DefaultImpls.playPag$default(iSquarePagView3, 0, 1, null);
                return;
            }
            return;
        }
        ISquarePagView iSquarePagView4 = this.pttPagView;
        if (iSquarePagView4 != null && (view2 = iSquarePagView4.getView()) != null) {
            view2.setVisibility(8);
        }
        if (Square.INSTANCE.getApplication() != null) {
            this.binding.avatarPttMessageIcon.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i8o));
        }
        SquareImageView squareImageView3 = this.binding.avatarPttMessageIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.avatarPttMessageIcon");
        squareImageView3.setVisibility(0);
    }

    public final void setClickProxy(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.clickProxy = listener;
    }

    public final void setContainerVisibility(int visibility) {
        RelativeLayout relativeLayout = this.binding.avatarMessageContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarMessageContainer");
        relativeLayout.setVisibility(visibility);
    }

    private final void playMsgAnimation(SquareBaseMessageRecord msg2) {
        this.playingAim = true;
        MsgPreviewItem msgPreviewItem = this.previewItems.get(this.curMsgIndex);
        msgPreviewItem.getContainer().setTranslationY(0.0f);
        msgPreviewItem.getContainer().setAlpha(1.0f);
        msgPreviewItem.getContainer().setVisibility(0);
        msgPreviewItem.getContainer().animate().setListener(null).translationY(-this.itemHeight).alpha(0.0f).setDuration(250L).start();
        int nextItemIndex = nextItemIndex(this.curMsgIndex);
        this.curMsgIndex = nextItemIndex;
        MsgPreviewItem msgPreviewItem2 = this.previewItems.get(nextItemIndex);
        msgPreviewItem2.bindMsg(msg2);
        msgPreviewItem2.getContainer().setVisibility(0);
        msgPreviewItem2.getContainer().setAlpha(0.0f);
        msgPreviewItem2.getContainer().setTranslationY(this.itemHeight);
        msgPreviewItem2.getContainer().animate().setListener(this).translationY(0.0f).alpha(1.0f).setDuration(250L).start();
    }

    private final int nextItemIndex(int curIndex) {
        return (curIndex + 1) % this.previewItems.size();
    }

    private final void reportExposure(SquareAvatarItem data) {
        AvatarViewHolder avatarViewHolder = this.holder;
        String uin = data.getUin();
        int unReadCount = data.getExtra().unReadCount();
        MsgType messageType = data.getExtra().messageType();
        MsgType msgType = MsgType.PTT;
        avatarViewHolder.reportBubbleEvent("imp", uin, unReadCount, messageType == msgType, 0, this.binding.avatarMessage);
        AvatarViewHolder.reportBubbleEvent$default(this.holder, "imp", data.getUin(), data.getExtra().unReadCount(), data.getExtra().messageType() == msgType, 1, null, 32, null);
        reportPttBubbleEvent("imp", data.getExtra().getIsPlayingPtt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.pc6) {
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) this.holder.getData();
            if (squareAvatarItem != null) {
                this.holder.reportBubbleEvent("clck", squareAvatarItem.getUin(), squareAvatarItem.getExtra().unReadCount(), squareAvatarItem.getExtra().messageType() == MsgType.PTT, 0, this.binding.avatarMessage);
            }
            View.OnClickListener onClickListener = this.clickProxy;
            if (onClickListener != null) {
                onClickListener.onClick(v3);
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.pcj) {
            SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) this.holder.getData();
            if (squareAvatarItem2 != null) {
                reportPttBubbleEvent("clck", squareAvatarItem2.getExtra().getIsPlayingPtt());
            }
            View.OnClickListener onClickListener2 = this.clickProxy;
            if (onClickListener2 != null) {
                onClickListener2.onClick(v3);
            }
        }
    }

    private final boolean isNewMsg(SquareBaseMessageRecord lastMsg, SquareBaseMessageRecord msg2) {
        return (msg2 != null ? msg2.getUnreadCount() : 0) > (lastMsg != null ? lastMsg.getUnreadCount() : 0);
    }

    private final String getUnreadCountString(int unReadCount) {
        if (unReadCount <= 99) {
            return String.valueOf(unReadCount);
        }
        return "99+";
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
    }
}
