package com.tencent.state.square.holder;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.image.URLDrawable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.SquareDebug;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.library.calendar.CalendarGuideManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.service.ImageService;
import com.tencent.state.service.VasSquareBuildingBubbleService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.data.BuildingBubble;
import com.tencent.state.square.data.SquareAnchorEntrance;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.databinding.VasSquareEntranceBubbleBinding;
import com.tencent.state.square.databinding.VasSquareItemEntranceBinding;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.location.IMotionObserver;
import com.tencent.state.square.location.MotionObserver;
import com.tencent.state.square.location.MotionUpdateDialog;
import com.tencent.state.square.media.Size;
import com.tencent.state.square.resource.PAGLoader;
import com.tencent.state.square.resource.PAGLoaderOption;
import com.tencent.state.square.resource.PagPreloadManager;
import com.tencent.state.status.BannerInfo;
import com.tencent.state.status.PanelStatusTaskInfo;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.MotionBubbleView;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001?B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0014J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0014J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\u0012\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J/\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0010H\u0016J\b\u0010.\u001a\u00020\u0010H\u0016J\b\u0010/\u001a\u00020\u0010H\u0002J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\nH\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020$H\u0002J.\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u0002062\u0006\u00101\u001a\u00020\n2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0010\u0018\u000108H\u0002J\u0010\u00109\u001a\u00020\u00102\u0006\u00103\u001a\u00020$H\u0002J\u001c\u0010:\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020&H\u0014J\u0018\u0010>\u001a\u00020\u00102\u0006\u00105\u001a\u0002062\u0006\u00101\u001a\u00020\nH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/tencent/state/square/holder/SquareCommonEntranceViewHolder;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/square/data/SquareEntranceItem;", "Landroid/view/View$OnClickListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemEntranceBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemEntranceBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemEntranceBinding;", "bubbleAnchor", "Lcom/tencent/state/square/data/SquareAnchorEntrance;", "buildingPagView", "Lcom/tencent/state/square/api/ISquarePagView;", "needPlayBubbleAnim", "", "bindBubble", "", "bindDebugTips", "data", "bindImage", "bindImageView", "bindMotionBubble", "bindPagView", "convertToInt", "", "value", "", "doBind", "index", "event", "doBubbleConsume", "needJumpBubbleScheme", "doExtraBubbleConsume", "hideEntranceBubble", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "onMapZoomEnd", "zoomLevel", "scale", "isZoomIn", "doMinView", "(IFZLjava/lang/Boolean;)V", "onRecycled", "onVisible", "playPag", "requestDialogInfo", "anchor", "setTouchEvent", "view", "showDialog", "bannerInfo", "Lcom/tencent/state/status/BannerInfo;", "callback", "Lkotlin/Function1;", "startBubbleAnimation", "touchInRect", "e", "Landroid/view/MotionEvent;", "transform", "updateDialog", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class SquareCommonEntranceViewHolder extends MapViewHolder<SquareEntranceItem> implements View.OnClickListener {
    private static final long BUBBLE_DELAY = 5000;
    private static final String TAG = "SquareCommonEntranceViewHolder";
    private final VasSquareItemEntranceBinding binding;
    private SquareAnchorEntrance bubbleAnchor;
    private ISquarePagView buildingPagView;
    private boolean needPlayBubbleAnim;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SquareCommonEntranceViewHolder(VasSquareItemEntranceBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        FrameLayout mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        this.binding = binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindBubble() {
        BuildingBubble extraBubble;
        int i3;
        boolean isBlank;
        BuildingBubble buildingBubble;
        Object firstOrNull;
        List<BuildingBubble> bubbles;
        Object firstOrNull2;
        MotionBubbleView motionBubbleView = this.binding.motionBubbleView;
        Intrinsics.checkNotNullExpressionValue(motionBubbleView, "binding.motionBubbleView");
        if (motionBubbleView.getVisibility() == 0) {
            hideEntranceBubble();
            return;
        }
        SquareEntranceItem data = getData();
        if (data != null && (bubbles = data.getBubbles()) != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles);
            extraBubble = (BuildingBubble) firstOrNull2;
        }
        SquareEntranceItem data2 = getData();
        extraBubble = data2 != null ? data2.getExtraBubble() : null;
        if (extraBubble != null) {
            if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, extraBubble.getIcon(), false, 2, null)) {
                CircleBoarderImageView circleBoarderImageView = this.binding.entranceBubble.entranceBubbleIcon;
                Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.entranceBubble.entranceBubbleIcon");
                circleBoarderImageView.setVisibility(8);
                i3 = 12;
            } else {
                CircleBoarderImageView circleBoarderImageView2 = this.binding.entranceBubble.entranceBubbleIcon;
                Intrinsics.checkNotNullExpressionValue(circleBoarderImageView2, "binding.entranceBubble.entranceBubbleIcon");
                circleBoarderImageView2.setVisibility(0);
                final WeakReference weakReference = new WeakReference(this.binding.entranceBubble.entranceBubbleIcon);
                URLDrawable drawable = URLDrawable.getDrawable(extraBubble.getIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
                if (drawable != null) {
                    drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.holder.SquareCommonEntranceViewHolder$bindBubble$$inlined$apply$lambda$1
                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadSuccessed(URLDrawable p06) {
                            CircleBoarderImageView circleBoarderImageView3 = (CircleBoarderImageView) weakReference.get();
                            if (circleBoarderImageView3 != null) {
                                circleBoarderImageView3.setImageDrawable(p06);
                            }
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadCanceled(URLDrawable p06) {
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadFialed(URLDrawable p06, Throwable p16) {
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadProgressed(URLDrawable p06, int p16) {
                        }
                    });
                    drawable.startDownload();
                } else {
                    drawable = null;
                }
                this.binding.entranceBubble.entranceBubbleIcon.setImageDrawable(drawable);
                i3 = 10;
            }
            String content = extraBubble.getContent();
            isBlank = StringsKt__StringsJVMKt.isBlank(content);
            if (isBlank) {
                TextView textView = this.binding.entranceBubble.entranceBubbleText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.entranceBubble.entranceBubbleText");
                textView.setVisibility(8);
                SquareImageView squareImageView = this.binding.entranceBubble.entranceBubbleArrow;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.entranceBubble.entranceBubbleArrow");
                squareImageView.setVisibility(8);
            } else {
                if (content.length() > i3) {
                    StringBuilder sb5 = new StringBuilder();
                    String substring = content.substring(0, i3 - 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    sb5.append(substring);
                    sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    content = sb5.toString();
                }
                TextView textView2 = this.binding.entranceBubble.entranceBubbleText;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.entranceBubble.entranceBubbleText");
                textView2.setText(content);
                TextView textView3 = this.binding.entranceBubble.entranceBubbleText;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.entranceBubble.entranceBubbleText");
                textView3.setVisibility(0);
                SquareImageView squareImageView2 = this.binding.entranceBubble.entranceBubbleArrow;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.entranceBubble.entranceBubbleArrow");
                squareImageView2.setVisibility(0);
            }
            SquareEntranceItem data3 = getData();
            if (data3 != null) {
                List<BuildingBubble> bubbles2 = data3.getBubbles();
                if (bubbles2 != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles2);
                    buildingBubble = (BuildingBubble) firstOrNull;
                } else {
                    buildingBubble = null;
                }
                if (buildingBubble == null && data3.getExtraBubble() != null) {
                    VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = this.binding.entranceBubble;
                    Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "binding.entranceBubble");
                    LinearLayout mRv = vasSquareEntranceBubbleBinding.getMRv();
                    Intrinsics.checkNotNullExpressionValue(mRv, "binding.entranceBubble.root");
                    ViewGroup.LayoutParams layoutParams = mRv.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null);
                    if (layoutParams2 != null) {
                        int i16 = extraBubble.getOffset().y;
                        View itemView = this.itemView;
                        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                        layoutParams2.bottomMargin = i16 - ViewExtensionsKt.dip(itemView, 8);
                    }
                } else {
                    VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding2 = this.binding.entranceBubble;
                    Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding2, "binding.entranceBubble");
                    LinearLayout mRv2 = vasSquareEntranceBubbleBinding2.getMRv();
                    Intrinsics.checkNotNullExpressionValue(mRv2, "binding.entranceBubble.root");
                    ViewGroup.LayoutParams layoutParams3 = mRv2.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) (layoutParams3 instanceof RelativeLayout.LayoutParams ? layoutParams3 : null);
                    if (layoutParams4 != null) {
                        int i17 = data3.getBubbleCoordinate().y;
                        View itemView2 = this.itemView;
                        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                        layoutParams4.bottomMargin = i17 - ViewExtensionsKt.dip(itemView2, 8);
                    }
                }
            }
            VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding3 = this.binding.entranceBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding3, "binding.entranceBubble");
            LinearLayout mRv3 = vasSquareEntranceBubbleBinding3.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv3, "binding.entranceBubble.root");
            mRv3.setVisibility(0);
            VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding4 = this.binding.entranceBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding4, "binding.entranceBubble");
            vasSquareEntranceBubbleBinding4.getMRv().setOnClickListener(this);
            this.needPlayBubbleAnim = true;
            return;
        }
        hideEntranceBubble();
    }

    private final void bindDebugTips(SquareEntranceItem data) {
        Location location;
        Location location2;
        Integer num = null;
        if (SquareDebug.INSTANCE.getEnableAvatarDebugInfo()) {
            this.binding.hotClickArea.setBackgroundColor((int) 2164195328L);
            TextView textView = this.binding.debugTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.debugTips");
            textView.setVisibility(0);
            TextView textView2 = this.binding.debugTips;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.debugTips");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("entrance\nindex: ");
            sb5.append(getIndex());
            sb5.append("\nname: ");
            sb5.append(data != null ? data.getName() : null);
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
        View view = this.binding.hotClickArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hotClickArea");
        view.setBackground(null);
    }

    private final void bindImage(SquareEntranceItem data) {
        bindImageView(data);
        SquareImageView squareImageView = this.binding.entranceImage;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.entranceImage");
        squareImageView.getLayoutParams().width = data.getLocation().getWidth();
        SquareImageView squareImageView2 = this.binding.entranceImage;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.entranceImage");
        squareImageView2.getLayoutParams().height = data.getLocation().getHeight();
        View view = this.binding.hotClickArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hotClickArea");
        view.getLayoutParams().width = data.getLocation().getWidth() / 2;
        View view2 = this.binding.hotClickArea;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.hotClickArea");
        view2.getLayoutParams().height = data.getLocation().getHeight() / 2;
    }

    private final void bindImageView(SquareEntranceItem data) {
        ImageService.Companion companion;
        ImageLoader loader;
        String showUrl = data.getShowUrl();
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, showUrl, false, 2, null) && (loader = (companion = ImageService.INSTANCE).getLoader()) != null) {
            loader.displayImage(showUrl, new ImageViewAware(this.binding.entranceImage), companion.getUniqueImageOptions(showUrl), PlayerSourceHelper.INSTANCE.getShowSize(new Size(data.getLocation().getWidth(), data.getLocation().getHeight()), Float.valueOf(0.6f)), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindMotionBubble() {
        this.binding.motionBubbleView.setOnClickListener(null);
        MotionBubbleView motionBubbleView = this.binding.motionBubbleView;
        Intrinsics.checkNotNullExpressionValue(motionBubbleView, "binding.motionBubbleView");
        motionBubbleView.setVisibility(8);
        SquareAnchorEntrance bubbleInfo = this.binding.motionBubbleView.setBubbleInfo(getData());
        this.bubbleAnchor = bubbleInfo;
        if (bubbleInfo != null) {
            this.binding.motionBubbleView.setOnClickListener(this);
        }
    }

    private final void bindPagView() {
        if (this.buildingPagView == null) {
            ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            ISquarePagView pagView = commonUtils.getPagView(context);
            this.buildingPagView = pagView;
            if (pagView != null) {
                this.binding.buildingPag.removeAllViews();
                this.binding.buildingPag.addView(pagView.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private final int convertToInt(float value) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(value);
        return roundToInt;
    }

    private final void doBubbleConsume(final SquareEntranceItem data, final boolean needJumpBubbleScheme) {
        Object firstOrNull;
        Integer intOrNull;
        VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = this.binding.entranceBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "binding.entranceBubble");
        LinearLayout mRv = vasSquareEntranceBubbleBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.entranceBubble.root");
        mRv.setVisibility(8);
        List<BuildingBubble> bubbles = data.getBubbles();
        if (bubbles == null || bubbles.isEmpty()) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles);
        BuildingBubble buildingBubble = (BuildingBubble) firstOrNull;
        if (buildingBubble != null) {
            if (needJumpBubbleScheme) {
                IRouter router = Square.INSTANCE.getConfig().getRouter();
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                router.routeLink(context, buildingBubble.getLink());
            }
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(data.getUin());
            if (intOrNull != null) {
                VasSquareBuildingBubbleService.delBuildingBubbles$default(VasSquareBuildingBubbleService.INSTANCE, intOrNull.intValue(), buildingBubble.getBubbleType(), buildingBubble.getBubbleId(), 0, null, 16, null);
            }
        }
        CollectionsKt__MutableCollectionsKt.removeFirst(bubbles);
        this.itemView.postDelayed(new Runnable() { // from class: com.tencent.state.square.holder.SquareCommonEntranceViewHolder$doBubbleConsume$$inlined$let$lambda$1
            @Override // java.lang.Runnable
            public final void run() {
                SquareCommonEntranceViewHolder.this.bindBubble();
            }
        }, 5000L);
    }

    private final void doExtraBubbleConsume(SquareEntranceItem data) {
        VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = this.binding.entranceBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "binding.entranceBubble");
        LinearLayout mRv = vasSquareEntranceBubbleBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.entranceBubble.root");
        mRv.setVisibility(8);
        BuildingBubble extraBubble = data.getExtraBubble();
        if (extraBubble != null) {
            IRouter router = Square.INSTANCE.getConfig().getRouter();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            router.routeLink(context, extraBubble.getLink());
            CalendarGuideManager.INSTANCE.readEntranceMessage(extraBubble);
            data.setExtraBubble(null);
        }
    }

    private final void playPag() {
        bindPagView();
        FrameLayout frameLayout = this.binding.buildingPag;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.buildingPag");
        frameLayout.setVisibility(0);
        ISquarePagView iSquarePagView = this.buildingPagView;
        if (iSquarePagView != null) {
            PAGLoader.INSTANCE.playPAG(PagPreloadManager.BUILDING_CHANGE_PAG, PagPreloadManager.BUILDING_CHANGE_PAG_FILE_NAME, iSquarePagView, new PAGLoaderOption(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestDialogInfo(final SquareAnchorEntrance anchor) {
        SquareEntranceItem data;
        List<SquareAnchorEntrance> anchorEntry;
        IRouter router = Square.INSTANCE.getConfig().getRouter();
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        router.routeLink(context, anchor.getLink());
        if (anchor.getNeedUnlock()) {
            anchor.setNeedUnlock(false);
            if (this.bubbleAnchor != null && (data = getData()) != null && (anchorEntry = data.getAnchorEntry()) != null) {
                for (SquareAnchorEntrance squareAnchorEntrance : anchorEntry) {
                    if (squareAnchorEntrance.getAnchorBubble() != null) {
                        squareAnchorEntrance.setNeedUnlock(false);
                    }
                }
            }
            new MotionObserver().requestMotionUnlock(anchor.getStatus(), anchor.getRichStatus(), new IMotionObserver() { // from class: com.tencent.state.square.holder.SquareCommonEntranceViewHolder$requestDialogInfo$2
                @Override // com.tencent.state.square.location.IMotionObserver
                public void notification(PanelStatusTaskInfo taskInfo, boolean success) {
                    Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                    if (success) {
                        SquareCommonEntranceViewHolder.this.updateDialog(taskInfo.getBannerInfo(), anchor);
                    }
                }
            });
        }
    }

    private final void setTouchEvent(View view) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.holder.SquareCommonEntranceViewHolder$setTouchEvent$1
            private int downIndex = -1;
            private boolean result;

            public final int getDownIndex() {
                return this.downIndex;
            }

            public final boolean getResult() {
                return this.result;
            }

            public final void setDownIndex(int i3) {
                this.downIndex = i3;
            }

            public final void setResult(boolean z16) {
                this.result = z16;
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
            
                r5 = r4.this$0.touchInRect(r5, r6);
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View v3, MotionEvent event) {
                int i3;
                int i16;
                List<SquareAnchorEntrance> anchorEntry;
                if (event == null) {
                    return false;
                }
                int action = event.getAction();
                if (action == 0) {
                    i3 = SquareCommonEntranceViewHolder.this.touchInRect(v3, event);
                    this.downIndex = i3;
                    if (i3 != -1) {
                        this.result = true;
                    }
                } else if (action == 1) {
                    this.result = false;
                    if (this.downIndex != -1 && i16 != -1 && i16 == this.downIndex) {
                        this.result = true;
                        SquareEntranceItem data = SquareCommonEntranceViewHolder.this.getData();
                        if (data != null && (anchorEntry = data.getAnchorEntry()) != null) {
                            SquareCommonEntranceViewHolder.this.requestDialogInfo(anchorEntry.get(i16));
                        }
                    }
                }
                return this.result;
            }
        });
    }

    private final void showDialog(final BannerInfo bannerInfo, final SquareAnchorEntrance anchor, final Function1<? super Integer, Unit> callback) {
        SquareBaseKt.getSquareThread().postOnUiDelayed(1000L, new Function0<Unit>() { // from class: com.tencent.state.square.holder.SquareCommonEntranceViewHolder$showDialog$1
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
                View itemView = SquareCommonEntranceViewHolder.this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                new MotionUpdateDialog(context, bannerInfo, anchor, callback).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDialog(BannerInfo bannerInfo, final SquareAnchorEntrance anchor) {
        if (!GuideContext.INSTANCE.hasCheckedCreateRoleGuide()) {
            SquareBaseKt.getSquareLog().i(TAG, "updateDialog cancel by guide");
        } else {
            showDialog(bannerInfo, anchor, new Function1<Integer, Unit>() { // from class: com.tencent.state.square.holder.SquareCommonEntranceViewHolder$updateDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    MapItemController controller;
                    IMapViewListener listener;
                    if (i3 != 1) {
                        return;
                    }
                    controller = SquareCommonEntranceViewHolder.this.getController();
                    if (controller != null && (listener = controller.getListener()) != null) {
                        SquareCommonEntranceViewHolder squareCommonEntranceViewHolder = SquareCommonEntranceViewHolder.this;
                        listener.onItemClicked(squareCommonEntranceViewHolder, squareCommonEntranceViewHolder.getIndex(), SquareCommonEntranceViewHolder.this.getData(), 11, anchor);
                    }
                    SquareCommonEntranceViewHolder.this.bindMotionBubble();
                }
            });
        }
    }

    public final VasSquareItemEntranceBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View v3) {
        SquareAnchorEntrance squareAnchorEntrance;
        BuildingBubble buildingBubble;
        IMapViewListener listener;
        Object firstOrNull;
        IMapViewListener listener2;
        boolean z16;
        BuildingBubble buildingBubble2;
        List<BuildingBubble> bubbles;
        Object firstOrNull2;
        IMapViewListener listener3;
        Object firstOrNull3;
        boolean isBlank;
        SquareEntranceItem data = getData();
        if (data == null) {
            return;
        }
        BuildingBubble buildingBubble3 = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        View view = this.binding.hotClickArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hotClickArea");
        int id5 = view.getId();
        if (valueOf != null && valueOf.intValue() == id5) {
            if (data.getEntranceType() != 10) {
                SquareBaseKt.getSquareLog().d(TAG, "onSingleClicked link:" + data.getLink());
                String link = data.getLink().getLink();
                if (link != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(link);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            if (data.getLink().getLinkType() == 3 && !TextUtils.isEmpty(data.getLink().getLink())) {
                                ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                                View view2 = this.binding.hotClickArea;
                                Intrinsics.checkNotNullExpressionValue(view2, "binding.hotClickArea");
                                Context context = view2.getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "binding.hotClickArea.context");
                                ICommonUtils.DefaultImpls.showToast$default(commonUtils, context, data.getLink().getLink(), 0, 4, (Object) null);
                                return;
                            }
                            List<BuildingBubble> bubbles2 = data.getBubbles();
                            if (bubbles2 != null) {
                                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles2);
                                buildingBubble3 = (BuildingBubble) firstOrNull3;
                            }
                            if (buildingBubble3 == null && data.getExtraBubble() != null) {
                                BuildingBubble extraBubble = data.getExtraBubble();
                                doExtraBubbleConsume(data);
                                buildingBubble2 = extraBubble;
                            } else {
                                IRouter router = Square.INSTANCE.getConfig().getRouter();
                                View itemView = this.itemView;
                                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                                Context context2 = itemView.getContext();
                                Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                                router.routeLink(context2, data.getLink());
                                if (data.getEntranceType() == 3 && (bubbles = data.getBubbles()) != null) {
                                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles);
                                    BuildingBubble buildingBubble4 = (BuildingBubble) firstOrNull2;
                                    if (buildingBubble4 != null && buildingBubble4.getBubbleType() == 2) {
                                        doBubbleConsume(data, false);
                                    }
                                }
                                buildingBubble2 = buildingBubble3;
                            }
                            MapItemController controller = getController();
                            if (controller == null || (listener3 = controller.getListener()) == null) {
                                return;
                            }
                            listener3.onItemClicked(this, getIndex(), data, 10, buildingBubble2);
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            } else {
                MapItemController controller2 = getController();
                if (controller2 == null || (listener2 = controller2.getListener()) == null) {
                    return;
                }
                IMapViewListener.DefaultImpls.onItemClicked$default(listener2, this, getIndex(), data, 10, null, 16, null);
            }
        } else {
            VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = this.binding.entranceBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "binding.entranceBubble");
            LinearLayout mRv = vasSquareEntranceBubbleBinding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.entranceBubble.root");
            int id6 = mRv.getId();
            if (valueOf != null && valueOf.intValue() == id6) {
                List<BuildingBubble> bubbles3 = data.getBubbles();
                if (bubbles3 != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bubbles3);
                    buildingBubble = (BuildingBubble) firstOrNull;
                } else {
                    buildingBubble = null;
                }
                if (buildingBubble != null) {
                    doBubbleConsume$default(this, data, false, 2, null);
                } else if (data.getExtraBubble() != null) {
                    buildingBubble = data.getExtraBubble();
                    doExtraBubbleConsume(data);
                }
                BuildingBubble buildingBubble5 = buildingBubble;
                MapItemController controller3 = getController();
                if (controller3 == null || (listener = controller3.getListener()) == null) {
                    return;
                }
                listener.onItemClicked(this, getIndex(), data, 12, buildingBubble5);
                return;
            }
            MotionBubbleView motionBubbleView = this.binding.motionBubbleView;
            Intrinsics.checkNotNullExpressionValue(motionBubbleView, "binding.motionBubbleView");
            int id7 = motionBubbleView.getId();
            if (valueOf == null || valueOf.intValue() != id7 || (squareAnchorEntrance = this.bubbleAnchor) == null) {
                return;
            }
            requestDialogInfo(squareAnchorEntrance);
        }
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        SquareEntranceItem transform;
        Intrinsics.checkNotNullParameter(data, "data");
        MapItemController controller = getController();
        if ((controller != null && !controller.getIsWelcomeScaleAnimDone()) || isMapMinimum() || (transform = transform(data)) == null) {
            return;
        }
        bindImageView(transform);
        bindMotionBubble();
        bindBubble();
        bindDebugTips(transform);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onMapZoomEnd(int zoomLevel, float scale, boolean isZoomIn, Boolean doMinView) {
        super.onMapZoomEnd(zoomLevel, scale, isZoomIn, doMinView);
        SquareEntranceItem data = getData();
        if (data != null) {
            bindImageView(data);
        }
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        super.onRecycled();
        this.binding.entranceImage.setImageDrawable(null);
        this.binding.entranceBubble.entranceBubbleIcon.setImageDrawable(null);
        this.buildingPagView = null;
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onVisible() {
        super.onVisible();
        if (this.needPlayBubbleAnim) {
            this.needPlayBubbleAnim = false;
            VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = this.binding.entranceBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "binding.entranceBubble");
            vasSquareEntranceBubbleBinding.getMRv().post(new Runnable() { // from class: com.tencent.state.square.holder.SquareCommonEntranceViewHolder$onVisible$1
                @Override // java.lang.Runnable
                public final void run() {
                    SquareCommonEntranceViewHolder squareCommonEntranceViewHolder = SquareCommonEntranceViewHolder.this;
                    VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding2 = squareCommonEntranceViewHolder.getBinding().entranceBubble;
                    Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding2, "binding.entranceBubble");
                    LinearLayout mRv = vasSquareEntranceBubbleBinding2.getMRv();
                    Intrinsics.checkNotNullExpressionValue(mRv, "binding.entranceBubble.root");
                    squareCommonEntranceViewHolder.startBubbleAnimation(mRv);
                }
            });
        }
    }

    private final void hideEntranceBubble() {
        this.needPlayBubbleAnim = false;
        VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding = this.binding.entranceBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding, "binding.entranceBubble");
        LinearLayout mRv = vasSquareEntranceBubbleBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.entranceBubble.root");
        mRv.setVisibility(8);
        VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding2 = this.binding.entranceBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareEntranceBubbleBinding2, "binding.entranceBubble");
        vasSquareEntranceBubbleBinding2.getMRv().setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startBubbleAnimation(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", 0.0f, 65.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setRepeatCount(1);
        anim.setDuration(330L);
        anim.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public SquareEntranceItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof SquareEntranceItem)) {
            data = null;
        }
        return (SquareEntranceItem) data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(SquareEntranceItem data, int index) {
        List<SquareAnchorEntrance> anchorEntry;
        Intrinsics.checkNotNullParameter(data, "data");
        bindImage(data);
        TextView textView = this.binding.name;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.name");
        textView.setText(data.getName());
        this.binding.hotClickArea.setOnClickListener(this);
        onFirstScreenCompleted(data, index);
        SquareEntranceItem data2 = getData();
        if (!(data2 instanceof SquareEntranceItem)) {
            data2 = null;
        }
        SquareEntranceItem squareEntranceItem = data2;
        if (squareEntranceItem == null || (anchorEntry = squareEntranceItem.getAnchorEntry()) == null || anchorEntry.size() <= 0) {
            return;
        }
        View view = this.binding.hotClickArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hotClickArea");
        setTouchEvent(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int touchInRect(View v3, MotionEvent e16) {
        SquareEntranceItem data;
        int i3 = -1;
        if (v3 != null && e16 != null && (data = getData()) != null) {
            int i16 = 0;
            for (Object obj : data.getAnchorEntry()) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                SquareAnchorEntrance squareAnchorEntrance = (SquareAnchorEntrance) obj;
                if (squareAnchorEntrance.getLink().getLink().length() > 0) {
                    float width = v3.getWidth();
                    float height = v3.getHeight();
                    if (new Rect(convertToInt(squareAnchorEntrance.getAnchorLeft() * width), convertToInt(squareAnchorEntrance.getAnchorTop() * height), convertToInt(squareAnchorEntrance.getAnchorRight() * width), convertToInt(squareAnchorEntrance.getAnchorBottom() * height)).contains(convertToInt(e16.getX()), convertToInt(e16.getY()))) {
                        i3 = i16;
                    }
                }
                i16 = i17;
            }
        }
        return i3;
    }

    static /* synthetic */ void doBubbleConsume$default(SquareCommonEntranceViewHolder squareCommonEntranceViewHolder, SquareEntranceItem squareEntranceItem, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            squareCommonEntranceViewHolder.doBubbleConsume(squareEntranceItem, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doBubbleConsume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(SquareEntranceItem data, int index, int event) {
        Intrinsics.checkNotNullParameter(data, "data");
        setIndex(index);
        if (event == 17) {
            bindBubble();
        } else {
            if (event != 18) {
                return;
            }
            playPag();
            bindImage(data);
        }
    }
}
