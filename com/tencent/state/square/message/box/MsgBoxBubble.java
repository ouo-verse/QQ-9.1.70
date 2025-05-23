package com.tencent.state.square.message.box;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.databinding.VasSquareMsgBoxBubbleBinding;
import com.tencent.state.square.message.box.IMsgBoxViewDirector;
import com.tencent.state.square.resource.ISquareViewBridge;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.view.CircleBoarderImageView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0016J\u0016\u0010#\u001a\u00020!2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020\nH\u0016J\u0012\u0010+\u001a\u00020!2\b\b\u0002\u0010,\u001a\u00020\nH\u0002J\u0018\u0010-\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0016J\b\u00101\u001a\u00020!H\u0016J\u0018\u00102\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020/H\u0016J\u0018\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u001c\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\u00142\b\u0010:\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010;\u001a\u00020!H\u0002J\u000e\u0010<\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0014J*\u0010=\u001a\u00020!2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020/H\u0016J\b\u0010C\u001a\u00020!H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxBubble;", "Landroid/widget/PopupWindow;", "Lcom/tencent/state/square/message/box/IMsgBoxLifeCycle;", "Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;)V", "animateDistance", "", "animating", "", "autoDismissRunnable", "Ljava/lang/Runnable;", "avatarIcons", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/message/box/MsgBoxBubbleAvatarInfo;", "Lkotlin/collections/ArrayList;", "binding", "Lcom/tencent/state/square/databinding/VasSquareMsgBoxBubbleBinding;", "curMsgData", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "destroyed", NodeProps.ENABLED, "faceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "lastMsgData", "reporter", "Lcom/tencent/state/square/IReporter;", "uiHandler", "Landroid/os/Handler;", "canShowBubble", "data", "clearAvatarAnimation", "", "destroy", "enable", "flag", "Lcom/tencent/state/square/message/box/MsgBoxOperateFlag;", "initData", "initListener", "initReport", "initView", "isDestroy", "onAvatarAnimationEnd", "normalEnd", "onDataInsert", "index", "", "onDataRemove", "onDataSetChange", "onDataUpdate", "onNewMessageCome", "onTotalUnreadNumChange", "unreadNum", "refreshAvatar", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "refreshUI", "oldData", "newData", "resetIconState", "setDataAndShowIfNeeded", "showAsDropDown", "anchor", "Landroid/view/View;", "xoff", "yoff", LayoutAttrDefine.Gravity.Gravity, "startAvatarAnimation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxBubble extends PopupWindow implements IMsgBoxLifeCycle, IMsgBoxDataObserver {
    private static final long ANIMATION_DURATION = 180;
    private static final long BUBBLE_STAY_DURATION = 4000;
    private static final String TAG = "SquareMsgBoxBubble";
    private final float animateDistance;
    private boolean animating;
    private Runnable autoDismissRunnable;
    private final ArrayList<MsgBoxBubbleAvatarInfo> avatarIcons;
    private final VasSquareMsgBoxBubbleBinding binding;
    private SquareBaseMessageRecord curMsgData;
    private boolean destroyed;
    private boolean enabled;
    private final IFaceDecoder faceDecoder;
    private SquareBaseMessageRecord lastMsgData;
    private final MsgBoxContext msgBoxContext;
    private final IReporter reporter;
    private final Handler uiHandler;

    public MsgBoxBubble(MsgBoxContext msgBoxContext) {
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        this.msgBoxContext = msgBoxContext;
        this.enabled = true;
        VasSquareMsgBoxBubbleBinding inflate = VasSquareMsgBoxBubbleBinding.inflate(LayoutInflater.from(msgBoxContext.getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMsgBoxBubbleBin\u2026(msgBoxContext.activity))");
        this.binding = inflate;
        Square square = Square.INSTANCE;
        this.faceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.autoDismissRunnable = new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxBubble$autoDismissRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                MsgBoxContext msgBoxContext2;
                if (SquareBaseKt.getSquareLog().isColorLevel()) {
                    SquareBaseKt.getSquareLog().d("SquareMsgBoxBubble", "MsgBoxBubble autoDismiss");
                }
                if (MsgBoxBubble.this.getDestroyed()) {
                    return;
                }
                msgBoxContext2 = MsgBoxBubble.this.msgBoxContext;
                msgBoxContext2.getMsgBoxManager().hideNewMsgBubble(MsgBoxOperateFlag.BUBBLE_AUTO_DISMISS);
            }
        };
        this.avatarIcons = new ArrayList<>();
        this.animateDistance = ViewExtensionsKt.dip((Context) msgBoxContext.getActivity(), 20.0f);
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.reporter = square.getConfig().getReporter();
        initView();
        initData();
        initListener();
        initReport();
    }

    private final boolean canShowBubble(SquareBaseMessageRecord data) {
        if (!this.enabled || !data.isValidRecord() || data.getForbiddenNotify() || data.isTroop() || !this.msgBoxContext.getMsgBoxManager().isInMainSquare()) {
            return false;
        }
        IMapItemViewManager screenViewManager = this.msgBoxContext.getManagerProxy().getScreenViewManager();
        return screenViewManager == null || !screenViewManager.isMostInScreen(data.getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearAvatarAnimation() {
        if (this.animating) {
            onAvatarAnimationEnd(false);
        }
    }

    private final void initData() {
        this.msgBoxContext.getMsgBoxManager().addMsgBoxDataObserver(this);
    }

    private final void initListener() {
        this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.message.box.MsgBoxBubble$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgBoxContext msgBoxContext;
                IReporter iReporter;
                VasSquareMsgBoxBubbleBinding vasSquareMsgBoxBubbleBinding;
                msgBoxContext = MsgBoxBubble.this.msgBoxContext;
                msgBoxContext.getMsgBoxManager().showMsgListPanel(MsgBoxOperateFlag.CLICK_MSG_BUBBLE);
                iReporter = MsgBoxBubble.this.reporter;
                if (iReporter != null) {
                    vasSquareMsgBoxBubbleBinding = MsgBoxBubble.this.binding;
                    TextView textView = vasSquareMsgBoxBubbleBinding.vasSquareMsgBoxBubbleTips;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareMsgBoxBubbleTips");
                    iReporter.reportEvent("clck", textView, new LinkedHashMap());
                }
            }
        });
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.state.square.message.box.MsgBoxBubble$initListener$2
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                Handler handler;
                Runnable runnable;
                MsgBoxBubble.this.lastMsgData = null;
                MsgBoxBubble.this.curMsgData = null;
                handler = MsgBoxBubble.this.uiHandler;
                runnable = MsgBoxBubble.this.autoDismissRunnable;
                handler.removeCallbacks(runnable);
                MsgBoxBubble.this.clearAvatarAnimation();
            }
        });
    }

    private final void initReport() {
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            RelativeLayout mRv = this.binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
            RelativeLayout mRv2 = this.binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv2, "binding.root");
            String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            View contentView = getContentView();
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(contentView.getContext()));
            Unit unit = Unit.INSTANCE;
            iReporter.setPageInfo(mRv, mRv2, checkNearby, linkedHashMap);
        }
        IReporter iReporter2 = this.reporter;
        if (iReporter2 != null) {
            TextView textView = this.binding.vasSquareMsgBoxBubbleTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareMsgBoxBubbleTips");
            iReporter2.setElementInfo(textView, SquareReportConst.ElementId.ELEMENT_ID_MSG_BOX_BUBBLE_TIPS, new LinkedHashMap(), false, false);
        }
    }

    private final void initView() {
        setWidth(ViewExtensionsKt.dip((Context) this.msgBoxContext.getActivity(), 115.0f));
        setHeight(ViewExtensionsKt.dip((Context) this.msgBoxContext.getActivity(), 46.0f));
        setOutsideTouchable(false);
        setFocusable(false);
        setContentView(this.binding.getMRv());
        ArrayList<MsgBoxBubbleAvatarInfo> arrayList = this.avatarIcons;
        MsgBoxBubbleAvatarInfo msgBoxBubbleAvatarInfo = new MsgBoxBubbleAvatarInfo();
        msgBoxBubbleAvatarInfo.setIconView(this.binding.vasSquareMsgBoxBubbleAvatar1);
        Unit unit = Unit.INSTANCE;
        arrayList.add(msgBoxBubbleAvatarInfo);
        ArrayList<MsgBoxBubbleAvatarInfo> arrayList2 = this.avatarIcons;
        MsgBoxBubbleAvatarInfo msgBoxBubbleAvatarInfo2 = new MsgBoxBubbleAvatarInfo();
        msgBoxBubbleAvatarInfo2.setIconView(this.binding.vasSquareMsgBoxBubbleAvatar2);
        arrayList2.add(msgBoxBubbleAvatarInfo2);
    }

    private final void onAvatarAnimationEnd(boolean normalEnd) {
        CircleBoarderImageView iconView;
        ViewPropertyAnimator animate;
        MsgBoxBubbleAvatarInfo remove = this.avatarIcons.remove(0);
        Intrinsics.checkNotNullExpressionValue(remove, "avatarIcons.removeAt(0)");
        this.avatarIcons.add(remove);
        for (MsgBoxBubbleAvatarInfo msgBoxBubbleAvatarInfo : this.avatarIcons) {
            if (!normalEnd && (iconView = msgBoxBubbleAvatarInfo.getIconView()) != null && (animate = iconView.animate()) != null) {
                animate.cancel();
            }
        }
        resetIconState();
        this.animating = false;
    }

    private final void refreshAvatar(final MsgBoxBubbleAvatarInfo item, final SquareBaseMessageRecord data) {
        item.setMsgData(data);
        CircleBoarderImageView iconView = item.getIconView();
        if (iconView != null) {
            FaceUtils.INSTANCE.loadHeadIcon(this.faceDecoder, iconView, data.getUin(), data.isTroop(), new Function1<String, Boolean>() { // from class: com.tencent.state.square.message.box.MsgBoxBubble$refreshAvatar$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                    return Boolean.valueOf(invoke2(str));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(String str) {
                    SquareBaseMessageRecord msgData = item.getMsgData();
                    return TextUtils.equals(msgData != null ? msgData.getUin() : null, str);
                }
            });
        }
    }

    private final void resetIconState() {
        CircleBoarderImageView iconView = this.avatarIcons.get(0).getIconView();
        if (iconView != null) {
            iconView.setTranslationX(0.0f);
            iconView.setAlpha(1.0f);
            iconView.setVisibility(0);
        }
        CircleBoarderImageView iconView2 = this.avatarIcons.get(1).getIconView();
        if (iconView2 != null) {
            iconView2.setTranslationX(this.animateDistance);
            iconView2.setAlpha(0.0f);
            iconView2.setVisibility(4);
        }
    }

    public final void enable(boolean enable, MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.enabled = enable;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    /* renamed from: isDestroy, reason: from getter */
    public boolean getDestroyed() {
        return this.destroyed;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataInsert(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataRemove(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataUpdate(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onNewMessageCome(SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IMsgBoxViewDirector.DefaultImpls.showNewMsgBubble$default(this.msgBoxContext.getMsgBoxManager(), data, null, 2, null);
    }

    public final void setDataAndShowIfNeeded(SquareBaseMessageRecord data) {
        View squareMsgBoxIcon;
        Intrinsics.checkNotNullParameter(data, "data");
        if (canShowBubble(data)) {
            this.uiHandler.removeCallbacks(this.autoDismissRunnable);
            this.lastMsgData = this.curMsgData;
            this.curMsgData = data;
            if (!isShowing()) {
                ISquareViewBridge viewBridge = this.msgBoxContext.getManagerProxy().getViewBridge();
                if (viewBridge == null || (squareMsgBoxIcon = viewBridge.getSquareMsgBoxIcon()) == null) {
                    return;
                } else {
                    showAsDropDown(squareMsgBoxIcon, -ViewExtensionsKt.dip((Context) this.msgBoxContext.getActivity(), 80.0f), 0, 1);
                }
            }
            refreshUI(this.lastMsgData, this.curMsgData);
            this.uiHandler.postDelayed(this.autoDismissRunnable, 4000L);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        if (getDestroyed() || this.msgBoxContext.getActivity().isFinishing() || this.msgBoxContext.getActivity().isDestroyed()) {
            return;
        }
        resetIconState();
        super.showAsDropDown(anchor, xoff, yoff, gravity);
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            TextView textView = this.binding.vasSquareMsgBoxBubbleTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareMsgBoxBubbleTips");
            iReporter.reportEvent("imp", textView, new LinkedHashMap());
        }
    }

    private final void startAvatarAnimation() {
        this.animating = true;
        CircleBoarderImageView iconView = this.avatarIcons.get(0).getIconView();
        if (iconView != null) {
            iconView.setTranslationX(0.0f);
            iconView.setAlpha(1.0f);
            iconView.setVisibility(0);
            iconView.animate().alpha(0.0f).translationX(-this.animateDistance).setDuration(ANIMATION_DURATION).setListener(null).start();
        }
        CircleBoarderImageView iconView2 = this.avatarIcons.get(1).getIconView();
        if (iconView2 != null) {
            iconView2.setTranslationX(this.animateDistance);
            iconView2.setAlpha(0.0f);
            iconView2.setVisibility(0);
            iconView2.animate().translationX(0.0f).alpha(1.0f).setDuration(ANIMATION_DURATION).setListener(new Animator.AnimatorListener() { // from class: com.tencent.state.square.message.box.MsgBoxBubble$startAvatarAnimation$$inlined$let$lambda$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    MsgBoxBubble.onAvatarAnimationEnd$default(MsgBoxBubble.this, false, 1, null);
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
            }).start();
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    public void destroy() {
        this.destroyed = true;
        dismiss();
        this.uiHandler.removeCallbacks(this.autoDismissRunnable);
        this.msgBoxContext.getMsgBoxManager().removeMsgBoxDataObserver(this);
    }

    private final void refreshUI(SquareBaseMessageRecord oldData, SquareBaseMessageRecord newData) {
        if (newData != null) {
            if (this.animating) {
                MsgBoxBubbleAvatarInfo msgBoxBubbleAvatarInfo = this.avatarIcons.get(1);
                Intrinsics.checkNotNullExpressionValue(msgBoxBubbleAvatarInfo, "avatarIcons[1]");
                refreshAvatar(msgBoxBubbleAvatarInfo, newData);
            } else {
                if (oldData != null && !TextUtils.equals(oldData.getUin(), newData.getUin())) {
                    MsgBoxBubbleAvatarInfo msgBoxBubbleAvatarInfo2 = this.avatarIcons.get(1);
                    Intrinsics.checkNotNullExpressionValue(msgBoxBubbleAvatarInfo2, "avatarIcons[1]");
                    refreshAvatar(msgBoxBubbleAvatarInfo2, newData);
                    startAvatarAnimation();
                    return;
                }
                MsgBoxBubbleAvatarInfo msgBoxBubbleAvatarInfo3 = this.avatarIcons.get(0);
                Intrinsics.checkNotNullExpressionValue(msgBoxBubbleAvatarInfo3, "avatarIcons[0]");
                refreshAvatar(msgBoxBubbleAvatarInfo3, newData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void onAvatarAnimationEnd$default(MsgBoxBubble msgBoxBubble, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        msgBoxBubble.onAvatarAnimationEnd(z16);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataSetChange() {
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onTotalUnreadNumChange(int unreadNum) {
    }
}
