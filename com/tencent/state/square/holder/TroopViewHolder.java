package com.tencent.state.square.holder;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.SquareDebug;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.square.api.SummaryData;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.databinding.VasSquareItemTroopBinding;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.PAGLoader;
import com.tencent.state.square.resource.PAGLoaderOption;
import com.tencent.state.square.resource.PagPreloadManager;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.BubbleBgDrawable;
import com.tencent.state.view.SquareImageView;
import com.tencent.state.view.SquareTroopMessageBubble;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\u0017\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001[B\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0014J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0003J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0003J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0018\u00103\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0011H\u0014J \u00103\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0011H\u0014J\b\u00106\u001a\u000207H\u0016J\u001c\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0018\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0013H\u0002J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020AH\u0002J\u0012\u0010B\u001a\u00020\u001f2\b\u0010C\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010D\u001a\u00020\u001f2\b\u0010C\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010E\u001a\u00020\u001f2\b\u0010C\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010F\u001a\u00020\u001f2\b\u0010C\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0012\u0010H\u001a\u00020\u001f2\b\u0010I\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010J\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020K2\u0006\u00104\u001a\u00020\u0011H\u0016J\u0012\u0010L\u001a\u00020\u00132\b\u0010I\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u0013H\u0016J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020KH\u0002J\b\u0010P\u001a\u00020\u001fH\u0016J\u0010\u0010Q\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020KH\u0002J\u0010\u0010R\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010S\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010T\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010U\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010V\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0016J\u0010\u0010W\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u000e\u0010X\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020\u0011J\u0012\u0010Z\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020KH\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\\"}, d2 = {"Lcom/tencent/state/square/holder/TroopViewHolder;", "Lcom/tencent/state/map/MapPlayableViewHolder;", "Lcom/tencent/state/square/data/SquareTroopItem;", "Lcom/tencent/state/square/resource/IResourceCallback;", "Lcom/tencent/state/square/api/ISquarePagViewListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemTroopBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemTroopBinding;)V", "app", "Landroid/app/Application;", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemTroopBinding;", "currentStatus", "", "isPlayingPag", "", "landPagView", "Lcom/tencent/state/square/api/ISquarePagView;", "messageHandler", "com/tencent/state/square/holder/TroopViewHolder$messageHandler$1", "Lcom/tencent/state/square/holder/TroopViewHolder$messageHandler$1;", "reporter", "Lcom/tencent/state/square/IReporter;", "ringPagView", "summaryView", "Lcom/tencent/state/square/api/ISquareSummaryView;", "bindAvatar", "", "data", "bindAvatarImageShow", "bindBaseBubble", "bindDebugTips", "bindListeners", "bindOwnerAvatar", "bindTent", "bindTroopNick", "bindUnreadNum", "bindUnreadText", "bubbleHideAnimator", "bubbleShowAnimator", "view", "Landroid/view/View;", "calculateElevation", "", "location", "Lcom/tencent/state/map/Location;", "checkPrivacy", "doBind", "index", "event", "getPlayerView", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "getTroopBaseParams", "", "", "", "handleStatusChange", "loadHeadIcon", "uin", "isTroop", "obtainSummaryView", "Lcom/tencent/state/square/api/SummaryData;", "onAnimationCancel", "squarePagView", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onBindData", NodeProps.ON_CLICK, "v", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", NodeProps.ON_LONG_CLICK, "onMapMinimum", "isMin", "onMessageUpdate", "onRecycled", "onTroopPrivacyUpdate", "onTroopRingPagUpdate", "playLandPagAnim", "reportClickEvent", "reportTroopBubbleExp", "resizeAvatar", "resizeTent", "setBubbleVisible", NodeProps.VISIBLE, "transform", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TroopViewHolder extends MapPlayableViewHolder<SquareTroopItem> implements IResourceCallback, ISquarePagViewListener, View.OnClickListener, View.OnLongClickListener {
    private static final int LISTEN_TOGETHER = 6;
    private static final int PARTY_TOGETHER = 10;
    private static final String TAG = "TroopViewHolder";
    private static final int WATCH_TOGETHER = 7;
    private final Application app;
    private final IFaceDecoder avatarFaceDecoder;
    private final VasSquareItemTroopBinding binding;
    private int currentStatus;
    private boolean isPlayingPag;
    private ISquarePagView landPagView;
    private TroopViewHolder$messageHandler$1 messageHandler;
    private IReporter reporter;
    private ISquarePagView ringPagView;
    private ISquareSummaryView summaryView;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.tencent.state.square.holder.TroopViewHolder$messageHandler$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TroopViewHolder(VasSquareItemTroopBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        RelativeLayout mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        this.binding = binding;
        SquareBase squareBase = SquareBase.INSTANCE;
        this.app = squareBase.getApp();
        this.avatarFaceDecoder = Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.reporter = squareBase.getConfig().getReporter();
        this.messageHandler = new Handler() { // from class: com.tencent.state.square.holder.TroopViewHolder$messageHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (msg2.what != 0) {
                    return;
                }
                TroopViewHolder.this.bubbleHideAnimator();
            }
        };
    }

    private final void bindAvatarImageShow(SquareTroopItem data) {
        Boolean changeAvatarImageVisible = data.getExtra().getChangeAvatarImageVisible();
        if (changeAvatarImageVisible != null) {
            boolean booleanValue = changeAvatarImageVisible.booleanValue();
            this.binding.ownerAvatar.setImageViewVisibility(booleanValue);
            onItemCoverRecord(!booleanValue);
            data.getExtra().setChangeAvatarImageVisible(null);
        }
    }

    private final void bindBaseBubble(SquareTroopItem data) {
        BubbleBgDrawable bubbleBgDrawable = new BubbleBgDrawable(-1, ViewExtensionsKt.dip((Context) this.app, 10), 25.0f, null, false, 24, null);
        RelativeLayout relativeLayout = this.binding.baseBubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.baseBubble");
        relativeLayout.setBackground(bubbleBgDrawable);
        if (data.getLastMsg().getUnreadCount() > 0) {
            String lastMsg = data.getLastMsg().getLastMsg();
            if (!(lastMsg == null || lastMsg.length() == 0)) {
                obtainSummaryView(data.getLastMsg().getSummaryData());
                RelativeLayout relativeLayout2 = this.binding.baseBubble;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.baseBubble");
                bubbleShowAnimator(relativeLayout2);
                this.currentStatus = data.getLastMsg().getSummaryData().getStatus();
                return;
            }
        }
        RelativeLayout relativeLayout3 = this.binding.baseBubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.baseBubble");
        relativeLayout3.setVisibility(8);
    }

    private final void bindDebugTips(SquareTroopItem data) {
        Location location;
        Location location2;
        if (SquareDebug.INSTANCE.getEnableAvatarDebugInfo()) {
            TextView textView = this.binding.debugTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.debugTips");
            textView.setVisibility(0);
            TextView textView2 = this.binding.debugTips;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.debugTips");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("troop\nindex: ");
            sb5.append(getIndex());
            sb5.append("\nname: ");
            Integer num = null;
            sb5.append(data != null ? data.getTroopName() : null);
            sb5.append("\narea: ");
            sb5.append(((data == null || (location2 = data.getLocation()) == null) ? null : Integer.valueOf(location2.getArea())).intValue());
            sb5.append("\nrank: ");
            if (data != null && (location = data.getLocation()) != null) {
                num = Integer.valueOf(location.getRank());
            }
            sb5.append(num.intValue());
            textView2.setText(sb5.toString());
            return;
        }
        TextView textView3 = this.binding.debugTips;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.debugTips");
        textView3.setVisibility(8);
    }

    private final void bindListeners() {
        this.binding.troopTent.setOnClickListener(this);
        this.binding.baseBubble.setOnClickListener(this);
        this.binding.troopMessageBubble.setOnClickListener(this);
        this.binding.ownerAvatar.setOnClickListener(this);
        this.binding.troopTent.setOnLongClickListener(this);
        this.binding.baseBubble.setOnLongClickListener(this);
        this.binding.troopMessageBubble.setOnLongClickListener(this);
        this.binding.ownerAvatar.setOnLongClickListener(this);
    }

    private final void bindOwnerAvatar(SquareTroopItem data) {
        getRm().setAvatarResource(data, false, this);
    }

    private final void bindTent(final SquareTroopItem data) {
        SquareBaseKt.getSquareLog().i(TAG, "bindTent: " + data.getTentStaticResource());
        if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, data.getTentStaticResource(), false, 2, null)) {
            this.binding.troopTent.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.iba));
            return;
        }
        URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
        final WeakReference weakReference = new WeakReference(this.binding.troopTent);
        URLDrawable drawable = URLDrawable.getDrawable(data.getTentStaticResource(), urlDrawableOptions$default);
        drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.holder.TroopViewHolder$bindTent$$inlined$apply$lambda$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable p06, Throwable p16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "TroopViewHolder", "onLoadFailed " + data.getTentStaticResource(), null, 4, null);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable drawable2) {
                SquareImageView squareImageView = (SquareImageView) weakReference.get();
                if (squareImageView != null) {
                    squareImageView.setImageDrawable(drawable2);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable p06) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable p06, int p16) {
            }
        });
        this.binding.troopTent.setImageDrawable(drawable);
    }

    private final void bindTroopNick(SquareTroopItem data) {
        loadHeadIcon(data.getUin(), true);
        TextView textView = this.binding.troopNick;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.troopNick");
        textView.setText(data.getTroopName());
        reportTroopBubbleExp(data);
    }

    private final void bindUnreadNum(SquareTroopItem data) {
        String str;
        Drawable drawable;
        if (data.getLastMsg().getUnreadCount() > 0) {
            if (data.getLastMsg().getUnreadCount() <= 99) {
                str = String.valueOf(data.getLastMsg().getUnreadCount());
            } else {
                str = "99+";
            }
            TextView textView = this.binding.unreadNum;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.unreadNum");
            textView.setText(str);
            Application application = this.app;
            if (application != null) {
                drawable = application.getDrawable(!data.getExtra().getIsDisturb() ? R.drawable.gwf : R.drawable.gwe);
            } else {
                drawable = null;
            }
            TextView textView2 = this.binding.unreadNum;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.unreadNum");
            textView2.setBackground(drawable);
        }
    }

    private final void bindUnreadText(SquareTroopItem data) {
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        String string = itemView.getResources().getString(R.string.xhm, String.valueOf(data.getLastMsg().getUnreadCount()));
        Intrinsics.checkNotNullExpressionValue(string, "itemView.resources.getSt\u2026ount.toString()\n        )");
        TextView textView = this.binding.unreadText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.unreadText");
        textView.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bubbleHideAnimator() {
        new AlphaAnimation(1.0f, 0.0f);
        ViewPropertyAnimator animator = this.binding.troopMessageBubble.animate().alpha(0.0f);
        animator.setListener(new Animator.AnimatorListener() { // from class: com.tencent.state.square.holder.TroopViewHolder$bubbleHideAnimator$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                TroopViewHolder.this.getBinding().troopMessageBubble.clear();
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
        });
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.setDuration(120L);
        animator.start();
    }

    private final void checkPrivacy(SquareTroopItem data) {
        View view;
        View view2;
        if (data.getIsBaned()) {
            SquareTroopMessageBubble squareTroopMessageBubble = this.binding.troopMessageBubble;
            Intrinsics.checkNotNullExpressionValue(squareTroopMessageBubble, "binding.troopMessageBubble");
            squareTroopMessageBubble.setVisibility(8);
            TextView textView = this.binding.unreadNum;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.unreadNum");
            textView.setVisibility(8);
            ISquareSummaryView iSquareSummaryView = this.summaryView;
            if (iSquareSummaryView != null && (view2 = iSquareSummaryView.getView()) != null) {
                view2.setVisibility(8);
            }
            TextView textView2 = this.binding.unreadText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.unreadText");
            textView2.setVisibility(0);
            return;
        }
        SquareTroopMessageBubble squareTroopMessageBubble2 = this.binding.troopMessageBubble;
        Intrinsics.checkNotNullExpressionValue(squareTroopMessageBubble2, "binding.troopMessageBubble");
        squareTroopMessageBubble2.setVisibility(0);
        ISquareSummaryView iSquareSummaryView2 = this.summaryView;
        if (iSquareSummaryView2 != null && (view = iSquareSummaryView2.getView()) != null) {
            view.setVisibility(0);
        }
        TextView textView3 = this.binding.unreadText;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.unreadText");
        textView3.setVisibility(8);
        if (data.getLastMsg().getUnreadCount() > 0) {
            TextView textView4 = this.binding.unreadNum;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.unreadNum");
            textView4.setVisibility(0);
        }
    }

    private final Map<String, Object> getTroopBaseParams(SquareTroopItem data) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_other_user_qq", data.getUin());
        linkedHashMap.put(SquareReportConst.Key.KEY_HAS_UNREAD_MESSAGE, Integer.valueOf(data.getLastMsg().getUnreadCount() == 0 ? 0 : 1));
        linkedHashMap.put("zplan_unread_message_number", Integer.valueOf(data.getLastMsg().getUnreadCount()));
        return linkedHashMap;
    }

    private final void handleStatusChange(SquareTroopItem data) {
        String string;
        if (data.getLastMsg().getSummaryData().getStatus() == 0) {
            int i3 = this.currentStatus;
            if (i3 == 6) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                string = itemView.getResources().getString(R.string.xdb, data.getTroopName());
            } else if (i3 == 7) {
                View itemView2 = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                string = itemView2.getResources().getString(R.string.xdd, data.getTroopName());
            } else if (i3 != 10) {
                string = "";
            } else {
                View itemView3 = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
                string = itemView3.getResources().getString(R.string.xdc, data.getTroopName());
            }
            String str = string;
            Intrinsics.checkNotNullExpressionValue(str, "when (currentStatus) {\n \u2026 else -> \"\"\n            }");
            if (str.length() > 0) {
                ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                View itemView4 = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView4, "itemView");
                Context context = itemView4.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                ICommonUtils.DefaultImpls.showToast$default(commonUtils, context, str, 0, 4, (Object) null);
            }
        }
        this.currentStatus = data.getLastMsg().getSummaryData().getStatus();
    }

    private final void loadHeadIcon(String uin, boolean isTroop) {
        Bitmap bitmapFromCache = this.avatarFaceDecoder.getBitmapFromCache(uin, isTroop);
        if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
            this.binding.troopIcon.setImageBitmap(bitmapFromCache);
        } else {
            this.avatarFaceDecoder.setDecodeTaskCompletionListener(new IDecodeTaskCompletionListener() { // from class: com.tencent.state.square.holder.TroopViewHolder$loadHeadIcon$1
                @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
                public void onDecodeTaskCompleted(int remainingTasks, int type, String uin2, Bitmap avatar) {
                    if (avatar != null) {
                        TroopViewHolder.this.getBinding().troopIcon.setImageBitmap(avatar);
                    }
                }
            });
            this.avatarFaceDecoder.requestDecodeFace(uin, isTroop);
        }
    }

    private final void obtainSummaryView(SummaryData data) {
        ISquareSummaryView iSquareSummaryView;
        View view;
        View view2;
        View view3;
        if (this.summaryView == null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            this.summaryView = ICommonUtils.DefaultImpls.getSummaryView$default(commonUtils, context, null, 2, null);
        }
        ISquareSummaryView iSquareSummaryView2 = this.summaryView;
        if (iSquareSummaryView2 != null) {
            ISquareSummaryView.DefaultImpls.setSummaryData$default(iSquareSummaryView2, data, null, 2, null);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = ViewExtensionsKt.dip((Context) this.app, 8);
        ISquareSummaryView iSquareSummaryView3 = this.summaryView;
        if (iSquareSummaryView3 != null && (view3 = iSquareSummaryView3.getView()) != null) {
            view3.setVisibility(8);
        }
        ISquareSummaryView iSquareSummaryView4 = this.summaryView;
        ViewParent parent = (iSquareSummaryView4 == null || (view2 = iSquareSummaryView4.getView()) == null) ? null : view2.getParent();
        if ((parent instanceof ViewGroup) && (iSquareSummaryView = this.summaryView) != null && (view = iSquareSummaryView.getView()) != null) {
            ((ViewGroup) parent).removeView(view);
        }
        RelativeLayout relativeLayout = this.binding.summaryContainer;
        ISquareSummaryView iSquareSummaryView5 = this.summaryView;
        relativeLayout.addView(iSquareSummaryView5 != null ? iSquareSummaryView5.getView() : null, layoutParams);
    }

    private final void onBindData(SquareTroopItem data) {
        setLayoutParams(data.getItemViewLocation());
        resizeAvatar(data);
        resizeTent(data);
        bindTent(data);
        bindTroopNick(data);
        bindOwnerAvatar(data);
        bindListeners();
        onFirstScreenCompleted(data, getIndex());
    }

    private final void onMessageUpdate(MapItem data) {
        String str;
        if (data instanceof SquareTroopItem) {
            SquareTroopItem squareTroopItem = (SquareTroopItem) data;
            if (squareTroopItem.getLastMsg().getUnreadCount() <= 0) {
                this.binding.troopMessageBubble.clear();
                this.binding.summaryContainer.removeAllViews();
                RelativeLayout relativeLayout = this.binding.baseBubble;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.baseBubble");
                relativeLayout.setVisibility(8);
                this.summaryView = null;
                return;
            }
            removeMessages(0);
            sendEmptyMessageDelayed(0, 3500L);
            RelativeLayout relativeLayout2 = this.binding.baseBubble;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.baseBubble");
            relativeLayout2.setVisibility(0);
            if (this.summaryView != null) {
                SquareTroopMessageBubble squareTroopMessageBubble = this.binding.troopMessageBubble;
                Intrinsics.checkNotNullExpressionValue(squareTroopMessageBubble, "binding.troopMessageBubble");
                squareTroopMessageBubble.setVisibility(0);
                SquareTroopMessageBubble squareTroopMessageBubble2 = this.binding.troopMessageBubble;
                Intrinsics.checkNotNullExpressionValue(squareTroopMessageBubble2, "binding.troopMessageBubble");
                squareTroopMessageBubble2.setAlpha(1.0f);
                SquareTroopMessageBubble squareTroopMessageBubble3 = this.binding.troopMessageBubble;
                ISquareSummaryView iSquareSummaryView = this.summaryView;
                if (iSquareSummaryView == null || (str = iSquareSummaryView.getSummaryMsgText()) == null) {
                    str = "";
                }
                String str2 = str;
                ISquareSummaryView iSquareSummaryView2 = this.summaryView;
                SquareTroopMessageBubble.addNewMessage$default(squareTroopMessageBubble3, str2, iSquareSummaryView2 != null ? iSquareSummaryView2.getHasEmoji() : false, 0L, 4, null);
                ISquareSummaryView iSquareSummaryView3 = this.summaryView;
                if (iSquareSummaryView3 != null) {
                    ISquareSummaryView.DefaultImpls.setSummaryData$default(iSquareSummaryView3, squareTroopItem.getLastMsg().getSummaryData(), null, 2, null);
                }
            }
            if (this.summaryView == null) {
                bindBaseBubble(squareTroopItem);
            }
            handleStatusChange(squareTroopItem);
            bindUnreadNum(squareTroopItem);
            bindUnreadText(squareTroopItem);
            checkPrivacy(squareTroopItem);
        }
    }

    private final void onTroopPrivacyUpdate(MapItem data) {
        if (data instanceof SquareTroopItem) {
            checkPrivacy((SquareTroopItem) data);
        }
    }

    private final void onTroopRingPagUpdate(SquareTroopItem data) {
        String str = "[addRoles] onTroopRingPagUpdate, " + data.getUin() + ", " + data.getTroopName();
        if (!data.getExtra().getNeedRingAnim()) {
            SquareBaseKt.getSquareLog().i(TAG, str + ", notRing");
            return;
        }
        data.getExtra().setNeedRingAnim(false);
        if (this.ringPagView == null) {
            ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            ISquarePagView pagView = commonUtils.getPagView(context);
            this.ringPagView = pagView;
            if (pagView != null) {
                this.binding.troopRingPag.addView(pagView.getView(), new FrameLayout.LayoutParams(-1, -1));
                pagView.setPagViewListener(new SimpleSquarePagViewListener(str));
            }
        }
        ISquarePagView iSquarePagView = this.ringPagView;
        if (iSquarePagView != null) {
            PAGLoader.INSTANCE.playPAG(PagPreloadManager.TROOP_RING_PAG, PagPreloadManager.TROOP_RING_PAG_FILE_NAME, iSquarePagView, new PAGLoaderOption(2));
        }
    }

    private final void playLandPagAnim(SquareTroopItem data) {
        String str = "playTroopLandPagAnim, " + data.getUin() + ", " + data.getTroopName();
        if (!data.getExtra().getNeedLandAnim()) {
            SquareBaseKt.getSquareLog().i(TAG, "[addRoles] " + str + ", notLand");
            return;
        }
        data.getExtra().setNeedLandAnim(false);
        this.isPlayingPag = true;
        if (this.landPagView == null) {
            ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            ISquarePagView pagView = commonUtils.getPagView(context);
            this.landPagView = pagView;
            if (pagView != null) {
                this.binding.troopPag.addView(pagView.getView(), new FrameLayout.LayoutParams(-1, -1));
                pagView.setPagViewListener(this);
            }
        }
        ISquarePagView iSquarePagView = this.landPagView;
        if (iSquarePagView != null) {
            PAGLoader.INSTANCE.playPAG(PagPreloadManager.TROOP_LAND_PAG, PagPreloadManager.TROOP_PAG_FILE_NAME, iSquarePagView, new PAGLoaderOption(1));
        }
        FrameLayout frameLayout = this.binding.troopPag;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.troopPag");
        frameLayout.setVisibility(0);
    }

    private final void reportClickEvent(SquareTroopItem data) {
        Map<String, Object> mutableMapOf;
        IReporter iReporter = this.reporter;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_friend_or_group", 1), TuplesKt.to("zplan_other_user_qq", data.getUin()), TuplesKt.to("zplan_unread_message_number", Integer.valueOf(data.getLastMsg().getUnreadCount())), TuplesKt.to(SquareReportConst.Key.KEY_HANDLE_MESSAGE_METHOD, 7));
        iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_HANDLE_MESSAGE, mutableMapOf);
        IReporter iReporter2 = this.reporter;
        SquareImageView squareImageView = this.binding.troopIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.troopIcon");
        iReporter2.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_TROOP_ICON, getTroopBaseParams(data), false, false);
        IReporter iReporter3 = this.reporter;
        SquareImageView squareImageView2 = this.binding.troopIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.troopIcon");
        iReporter3.reportEvent("clck", squareImageView2, new LinkedHashMap());
    }

    private final void reportTroopBubbleExp(SquareTroopItem data) {
        IReporter iReporter = this.reporter;
        SquareImageView squareImageView = this.binding.troopIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.troopIcon");
        iReporter.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_TROOP_ICON, getTroopBaseParams(data), false, false);
        IReporter iReporter2 = this.reporter;
        SquareImageView squareImageView2 = this.binding.troopIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.troopIcon");
        iReporter2.reportEvent("imp", squareImageView2, new LinkedHashMap());
    }

    private final void resizeTent(SquareTroopItem data) {
        SquareImageView squareImageView = this.binding.troopTent;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.troopTent");
        ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
        if (layoutParams == null) {
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            layoutParams = new RelativeLayout.LayoutParams(itemView.getContext(), (AttributeSet) null);
        }
        layoutParams.width = data.getLocation().getWidth();
        layoutParams.height = data.getLocation().getHeight();
        SquareImageView squareImageView2 = this.binding.troopTent;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.troopTent");
        squareImageView2.setLayoutParams(layoutParams);
        FrameLayout frameLayout = this.binding.troopRingPag;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.troopRingPag");
        ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
        if (layoutParams2 == null) {
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            layoutParams2 = new FrameLayout.LayoutParams(itemView2.getContext(), (AttributeSet) null);
        }
        layoutParams2.width = data.getLocation().getWidth();
        layoutParams2.height = data.getLocation().getHeight();
        FrameLayout frameLayout2 = this.binding.troopRingPag;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.troopRingPag");
        frameLayout2.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void bindAvatar(SquareTroopItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.MapViewHolder
    public float calculateElevation(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
            return 0.0f;
        }
        return super.calculateElevation(location);
    }

    public final VasSquareItemTroopBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public SquareAvatarView getPlayerView() {
        SquareAvatarView squareAvatarView = this.binding.ownerAvatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.ownerAvatar");
        return squareAvatarView;
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationStart(ISquarePagView squarePagView) {
        SquareImageView squareImageView = this.binding.troopTent;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.troopTent");
        squareImageView.setVisibility(8);
        SquareAvatarView squareAvatarView = this.binding.ownerAvatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.ownerAvatar");
        squareAvatarView.setVisibility(8);
        RelativeLayout relativeLayout = this.binding.baseBubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.baseBubble");
        relativeLayout.setVisibility(8);
        SquareTroopMessageBubble squareTroopMessageBubble = this.binding.troopMessageBubble;
        Intrinsics.checkNotNullExpressionValue(squareTroopMessageBubble, "binding.troopMessageBubble");
        squareTroopMessageBubble.setVisibility(8);
        FrameLayout frameLayout = this.binding.troopPag;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.troopPag");
        frameLayout.setVisibility(0);
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationUpdate(ISquarePagView iSquarePagView) {
        ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.state.map.MapItem] */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        IMapViewListener listener;
        SquareTroopItem squareTroopItem = (SquareTroopItem) getData();
        if (squareTroopItem != null) {
            reportClickEvent(squareTroopItem);
        }
        MapItemController controller = getController();
        if (controller == null || (listener = controller.getListener()) == null) {
            return;
        }
        IMapViewListener.DefaultImpls.onItemClicked$default(listener, this, getIndex(), getData(), 6, null, 16, null);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onFirstFrame() {
        IResourceCallback.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        SquareTroopItem transform;
        Intrinsics.checkNotNullParameter(data, "data");
        MapItemController controller = getController();
        if ((controller != null && !controller.getIsWelcomeScaleAnimDone()) || isMapMinimum() || (transform = transform(data)) == null) {
            return;
        }
        bindBaseBubble(transform);
        bindUnreadNum(transform);
        bindUnreadText(transform);
        checkPrivacy(transform);
        bindDebugTips(transform);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v3) {
        IMapViewListener listener;
        MapItemController controller = getController();
        if (controller == null || (listener = controller.getListener()) == null) {
            return true;
        }
        listener.onItemLongClick(this, getIndex(), getData(), 6);
        return true;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayEnd() {
        IResourceCallback.DefaultImpls.onPlayEnd(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayError(int i3) {
        IResourceCallback.DefaultImpls.onPlayError(this, i3);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayStart() {
        IResourceCallback.DefaultImpls.onPlayStart(this);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordError(int i3, RecordRequest request, int i16) {
        Intrinsics.checkNotNullParameter(request, "request");
        IResourceCallback.DefaultImpls.onRecordError(this, i3, request, i16);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordStart(Resource resource, boolean z16) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        IResourceCallback.DefaultImpls.onRecordStart(this, resource, z16);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordSuccess(RecordRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        IResourceCallback.DefaultImpls.onRecordSuccess(this, request);
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder, com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        SquareBaseKt.getSquareLog().i(TAG, "onRecycled");
        removeMessages(0);
        this.binding.troopMessageBubble.destroy();
        this.binding.summaryContainer.removeAllViews();
        this.summaryView = null;
        super.onRecycled();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onRemovedListener() {
        IResourceCallback.DefaultImpls.onRemovedListener(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticFailed() {
        IResourceCallback.DefaultImpls.onStaticFailed(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticSuccess() {
        IResourceCallback.DefaultImpls.onStaticSuccess(this);
    }

    public final void setBubbleVisible(int visible) {
        RelativeLayout relativeLayout = this.binding.troopRootView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.troopRootView");
        relativeLayout.setVisibility(visible);
    }

    private final void bubbleShowAnimator(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 15.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(360L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.state.square.holder.TroopViewHolder$bubbleShowAnimator$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                view.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationEnd(ISquarePagView squarePagView) {
        this.isPlayingPag = false;
        SquareImageView squareImageView = this.binding.troopTent;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.troopTent");
        squareImageView.setVisibility(0);
        SquareAvatarView squareAvatarView = this.binding.ownerAvatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.ownerAvatar");
        squareAvatarView.setVisibility(0);
        RelativeLayout relativeLayout = this.binding.baseBubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.baseBubble");
        relativeLayout.setVisibility(0);
        SquareTroopMessageBubble squareTroopMessageBubble = this.binding.troopMessageBubble;
        Intrinsics.checkNotNullExpressionValue(squareTroopMessageBubble, "binding.troopMessageBubble");
        squareTroopMessageBubble.setVisibility(0);
        FrameLayout frameLayout = this.binding.troopPag;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.troopPag");
        frameLayout.setVisibility(8);
        SquareTroopItem squareTroopItem = (SquareTroopItem) getData();
        if (squareTroopItem != null) {
            onBindData(squareTroopItem);
        }
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void resizeAvatar(SquareTroopItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Resource userResource = data.getUserResource();
        if (userResource != null) {
            resizeAvatar(userResource.getShowSize().getWidth(), userResource.getShowSize().getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public SquareTroopItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof SquareTroopItem)) {
            data = null;
        }
        return (SquareTroopItem) data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(SquareTroopItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getExtra().getNeedLandAnim()) {
            playLandPagAnim(data);
        } else if (!this.isPlayingPag) {
            onBindData(data);
        }
        bindAvatarImageShow(data);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onMapMinimum(boolean isMin) {
        if (isMin) {
            stop(true);
            if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
                this.binding.ownerAvatar.setImageViewVisibility(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void doBind(SquareTroopItem data, int index, int event) {
        FilamentAvatarCoverUri filamentCoverUrl;
        Intrinsics.checkNotNullParameter(data, "data");
        super.doBind((TroopViewHolder) data, index, event);
        if (isMapMinimum()) {
            return;
        }
        if (event == 4) {
            onMessageUpdate(data);
            return;
        }
        if (event == 5) {
            onTroopPrivacyUpdate(data);
            return;
        }
        if (event == 10) {
            onTroopRingPagUpdate(data);
            return;
        }
        if (event == 29) {
            bindAvatarImageShow(data);
        } else {
            if (event != 30) {
                return;
            }
            Resource userResource = data.getUserResource();
            updateCover((userResource == null || (filamentCoverUrl = userResource.getFilamentCoverUrl()) == null) ? null : filamentCoverUrl.encode());
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationCancel(ISquarePagView squarePagView) {
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationRepeat(ISquarePagView squarePagView) {
    }
}
