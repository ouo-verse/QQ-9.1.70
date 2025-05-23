package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.DragModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.DragViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.EffectTimelineView;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.SliderView;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj2.CommonConfig;

/* compiled from: P */
@RequiresApi(17)
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001[\b\u0007\u0018\u0000 p2\u00020\u0001:\u0002qrB/\b\u0007\u0012\u0006\u0010h\u001a\u00020g\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010i\u0012\b\b\u0002\u0010k\u001a\u00020\u0002\u0012\u0006\u0010m\u001a\u00020l\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!J\b\u0010$\u001a\u00020\u0002H\u0016J\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0002J\u0006\u0010'\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010+\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00100R\u0018\u0010B\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00100R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bP\u0010QR\"\u0010W\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020T0S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010a\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010d\u001a\u00020T8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020T8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\be\u0010c\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/EffectTimelineView;", "", "l", "p", "g", "r", "singleBitmapWidthPx", "", "setSingleBitmapWidth", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/p;", "videoTrackModel", "", "isLast", "Lqj2/a;", SkinConstants.TintConstant.KEY_COMMON_CONFIG, "N1", "", "K1", "radius", "setCornerRadius", "selected", "setSelected", "id", "Landroid/view/ViewGroup;", "G0", "fromUser", "L1", "(Z)V", "M1", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "provider", "setThumbnailProvider", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "selectListener", "setSelectListener", "t", "visibility", "setBlackMaskViewVisibility", Constants.BASE_IN_PLUGIN_ID, "R1", "S1", "T1", "O1", "I1", "F1", "Q1", "W", "I", "screenWidth", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "a0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "bevelView", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/RoundFrameLayout;", "b0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/RoundFrameLayout;", ParseCommon.CONTAINER, "Landroid/view/View;", "c0", "Landroid/view/View;", "blackMaskView", "d0", "bitmapWidth", "e0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/p;", "initialTrackModel", "f0", "cornerRadius", "g0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "h0", "Lqj2/a;", DownloadInfo.spKey_Config, "i0", "Z", "Ljava/text/SimpleDateFormat;", "j0", "Ljava/text/SimpleDateFormat;", "simpleDateFormat", "k0", "Ljava/lang/String;", "RATIO_FORMAT", "Lkotlin/Pair;", "", "l0", "Lkotlin/Pair;", "lastDownPoint", "m0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$c", "n0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$c;", "videoThumbProvider", "L0", "()I", "contentPadding", "J1", "()F", "startClipPosition", Constants.APK_CERTIFICATE, "endClipPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;", "dragModel", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;)V", "o0", "a", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor", "ClickableViewAccessibility"})
/* loaded from: classes17.dex */
public final class VideoTrackTimelineView extends EffectTimelineView {

    /* renamed from: W, reason: from kotlin metadata */
    private int screenWidth;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PlayTrackExpandWidthView bevelView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundFrameLayout container;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View blackMaskView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int bitmapWidth;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VideoTrackModel initialTrackModel;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int cornerRadius;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b selectListener;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonConfig config;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isLast;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat simpleDateFormat;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String RATIO_FORMAT;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Float, Float> lastDownPoint;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d thumbnailProvider;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c videoThumbProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "", "", "id", "", "selectedStatus", "", "isClickStartClipRegion", "isClickEndClipRegion", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "view", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull String id5, int selectedStatus, boolean isClickStartClipRegion, boolean isClickEndClipRegion, @NotNull VideoTrackTimelineView view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/e;", "", "offset", "", "tag", "Landroid/graphics/Bitmap;", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements e {
        c() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.e
        @Nullable
        public Bitmap a(int offset, @Nullable Object tag) {
            VideoTrackModel videoTrackModel = VideoTrackTimelineView.this.initialTrackModel;
            if (videoTrackModel != null) {
                if (VideoTrackTimelineView.this.getInnerScaleCalculator() == null) {
                    return VideoTrackTimelineView.this.thumbnailProvider.a();
                }
                return VideoTrackTimelineView.this.thumbnailProvider.getBitmapByTime(((float) r0.t(offset)) / videoTrackModel.getSourceData().getTimeData().a(), videoTrackModel.getUuid(), videoTrackModel.getPath());
            }
            return VideoTrackTimelineView.this.thumbnailProvider.a();
        }
    }

    public /* synthetic */ VideoTrackTimelineView(Context context, AttributeSet attributeSet, int i3, DragModel dragModel, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, dragModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(VideoTrackTimelineView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setSliderViewVisibility(0);
    }

    private final void F1(boolean selected) {
        setSelected(selected);
        this.bevelView.setSelected(selected);
        M1();
    }

    private final float G1() {
        if (this.initialTrackModel != null) {
            return r0.getEndClipWidth();
        }
        return 0.0f;
    }

    private final int I1() {
        DrawData drawData;
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null && (drawData = videoTrackModel.getDrawData()) != null) {
            return drawData.getSelectStatus();
        }
        return -1;
    }

    private final float J1() {
        if (this.initialTrackModel != null) {
            return r0.getStartClipWidth();
        }
        return 0.0f;
    }

    private final void O1(VideoTrackModel videoTrackModel, boolean isLast, CommonConfig commonConfig) {
        int a16;
        if (Intrinsics.areEqual(this.initialTrackModel, videoTrackModel) && this.isLast == isLast && Intrinsics.areEqual(this.config, commonConfig)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (isLast) {
            a16 = 0;
        } else {
            a16 = com.tencent.videocut.utils.e.f384236a.a(commonConfig.getVideoTrackConfig().getVideoTrackMargin());
        }
        layoutParams.width = ((videoTrackModel.getWidth() + U0()) + U0()) - a16;
        if (!getIsFixedLayout()) {
            layoutParams.leftMargin = videoTrackModel.getLeftMargin();
        }
        setLayoutParams(layoutParams);
        this.bevelView.setMaxLeftBorderWidth(videoTrackModel.getLeftOffset());
        M1();
    }

    private final void Q1(VideoTrackModel videoTrackModel) {
        int i3;
        int i16;
        if (videoTrackModel.getSourceData().getTimeData().getTimelineStartTimeUs() + videoTrackModel.getSourceData().getTimeData().getTimelineDurationUs() <= 300000000) {
            return;
        }
        long max = Math.max(0L, 300000000 - videoTrackModel.getSourceData().getTimeData().getTimelineStartTimeUs());
        long timelineDurationUs = videoTrackModel.getSourceData().getTimeData().getTimelineDurationUs() - max;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        rj2.a innerScaleCalculator = getInnerScaleCalculator();
        if (innerScaleCalculator != null) {
            i3 = innerScaleCalculator.u(max);
        } else {
            i3 = 0;
        }
        layoutParams.leftMargin = i3;
        rj2.a innerScaleCalculator2 = getInnerScaleCalculator();
        if (innerScaleCalculator2 != null) {
            i16 = innerScaleCalculator2.u(timelineDurationUs);
        } else {
            i16 = 0;
        }
        layoutParams.width = i16;
        this.blackMaskView.setLayoutParams(layoutParams);
        this.blackMaskView.setVisibility(0);
    }

    private final void R1(VideoTrackModel videoTrackModel) {
        DrawData drawData;
        int selectStatus = videoTrackModel.getDrawData().getSelectStatus();
        VideoTrackModel videoTrackModel2 = this.initialTrackModel;
        boolean z16 = false;
        if (videoTrackModel2 != null && (drawData = videoTrackModel2.getDrawData()) != null && selectStatus == drawData.getSelectStatus()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        S1(videoTrackModel);
    }

    private final void S1(VideoTrackModel videoTrackModel) {
        int selectStatus = videoTrackModel.getDrawData().getSelectStatus();
        if (selectStatus != -1) {
            if (selectStatus == 1) {
                F1(true);
                return;
            }
            return;
        }
        F1(false);
    }

    private final void T1(VideoTrackModel videoTrackModel) {
        boolean z16;
        float startClipWidth = videoTrackModel.getStartClipWidth();
        float endClipWidth = videoTrackModel.getEndClipWidth();
        boolean z17 = true;
        if (startClipWidth == J1()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (endClipWidth != G1()) {
                z17 = false;
            }
            if (z17) {
                return;
            }
        }
        this.bevelView.setEndClipWidth(endClipWidth);
        this.bevelView.setStartClipWidth(startClipWidth);
        this.bevelView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(VideoTrackTimelineView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L1(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z1(VideoTrackTimelineView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getActionMasked() == 0) {
            this$0.lastDownPoint = TuplesKt.to(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
            return false;
        }
        return false;
    }

    public final void D1() {
        SliderView leftSliderView = getLeftSliderView();
        if (leftSliderView == null) {
            return;
        }
        leftSliderView.getLocationOnScreen(new int[2]);
        f(r1[0] + 1);
        W0(r1[0]);
        i(true);
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.s
            @Override // java.lang.Runnable
            public final void run() {
                VideoTrackTimelineView.E1(VideoTrackTimelineView.this);
            }
        }, 300L);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView
    @NotNull
    protected ViewGroup G0(int id5) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h1v, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        viewGroup.setId(id5);
        return viewGroup;
    }

    @NotNull
    public final String K1() {
        String uuid;
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel == null || (uuid = videoTrackModel.getUuid()) == null) {
            return "";
        }
        return uuid;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView
    protected int L0() {
        return 0;
    }

    public final void L1(boolean fromUser) {
        if (fromUser) {
            b bVar = this.selectListener;
            if (bVar != null) {
                bVar.a(K1(), I1(), this.bevelView.i(this.lastDownPoint.getFirst().floatValue(), this.lastDownPoint.getSecond().floatValue()), this.bevelView.h(this.lastDownPoint.getFirst().floatValue(), this.lastDownPoint.getSecond().floatValue()), this);
                return;
            }
            return;
        }
        b bVar2 = this.selectListener;
        if (bVar2 != null) {
            bVar2.a(K1(), I1(), false, false, this);
        }
    }

    public final void M1() {
        this.bevelView.postInvalidate();
    }

    public final void N1(@NotNull VideoTrackModel videoTrackModel, boolean isLast, @Nullable CommonConfig commonConfig) {
        CommonConfig commonConfig2;
        VideoTrackModel a16;
        Intrinsics.checkNotNullParameter(videoTrackModel, "videoTrackModel");
        if (commonConfig == null) {
            commonConfig2 = new CommonConfig(null, null, null, null, 15, null);
        } else {
            commonConfig2 = commonConfig;
        }
        O1(videoTrackModel, isLast, commonConfig2);
        T1(videoTrackModel);
        R1(videoTrackModel);
        Q1(videoTrackModel);
        setDragViewModel(DragViewModel.b(getDragViewModel(), null, videoTrackModel.getLeftMargin(), videoTrackModel.e(), 0L, 0, videoTrackModel.getUuid(), null, 73, null));
        a16 = videoTrackModel.a((r32 & 1) != 0 ? videoTrackModel.uuid : null, (r32 & 2) != 0 ? videoTrackModel.type : 0, (r32 & 4) != 0 ? videoTrackModel.path : null, (r32 & 8) != 0 ? videoTrackModel.leftMargin : 0, (r32 & 16) != 0 ? videoTrackModel.leftOffset : 0, (r32 & 32) != 0 ? videoTrackModel.minLeftMargin : 0, (r32 & 64) != 0 ? videoTrackModel.width : 0, (r32 & 128) != 0 ? videoTrackModel.maxWidth : 0, (r32 & 256) != 0 ? videoTrackModel.startClipWidth : 0, (r32 & 512) != 0 ? videoTrackModel.endClipWidth : 0, (r32 & 1024) != 0 ? videoTrackModel.duration : 0L, (r32 & 2048) != 0 ? videoTrackModel.minWidth : 0, (r32 & 4096) != 0 ? videoTrackModel.sourceData : null, (r32 & 8192) != 0 ? videoTrackModel.drawData : null);
        this.initialTrackModel = a16;
        this.isLast = isLast;
        this.config = commonConfig;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int g() {
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null) {
            return videoTrackModel.getMinLeftMargin();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int l() {
        return super.U0();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int p() {
        return super.U0();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int r() {
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null) {
            return videoTrackModel.getMaxWidth() + videoTrackModel.getLeftMargin();
        }
        return 0;
    }

    public final void setBlackMaskViewVisibility(int visibility) {
        this.blackMaskView.setVisibility(visibility);
    }

    public final void setCornerRadius(int radius) {
        this.cornerRadius = radius;
    }

    public final void setSelectListener(@NotNull b selectListener) {
        Intrinsics.checkNotNullParameter(selectListener, "selectListener");
        this.selectListener = selectListener;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView, android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        this.container.setRadius(com.tencent.videocut.utils.e.f384236a.a(0.0f));
    }

    public final void setSingleBitmapWidth(int singleBitmapWidthPx) {
        this.bitmapWidth = singleBitmapWidthPx;
        this.bevelView.setSingleBitmapWidth(singleBitmapWidthPx);
    }

    public final void setThumbnailProvider(@NotNull d provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.thumbnailProvider = provider;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int t() {
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null) {
            return videoTrackModel.getMinWidth();
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackTimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull DragModel dragModel) {
        super(context, attributeSet, i3, dragModel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dragModel, "dragModel");
        this.simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.US);
        this.RATIO_FORMAT = "%.1f";
        Float valueOf = Float.valueOf(0.0f);
        this.lastDownPoint = TuplesKt.to(valueOf, valueOf);
        this.thumbnailProvider = new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.c();
        c cVar = new c();
        this.videoThumbProvider = cVar;
        this.screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        ViewGroup contentView = getContentView();
        contentView = contentView == null ? G0(View.generateViewId()) : contentView;
        RoundFrameLayout container = (RoundFrameLayout) contentView.findViewById(R.id.content);
        PlayTrackExpandWidthView playTrackExpandWidthView = new PlayTrackExpandWidthView(context, null, 0, 6, null);
        playTrackExpandWidthView.setId(View.generateViewId());
        playTrackExpandWidthView.setSingleBitmapWidth(this.bitmapWidth);
        playTrackExpandWidthView.setThumbProvider(cVar);
        container.addView(playTrackExpandWidthView, new ViewGroup.LayoutParams(-1, -1));
        View view = new View(getContext());
        this.blackMaskView = view;
        view.setBackgroundResource(R.color.bdo);
        view.setVisibility(8);
        container.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bevelView = playTrackExpandWidthView;
        Intrinsics.checkNotNullExpressionValue(container, "container");
        this.container = container;
        contentView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoTrackTimelineView.y1(VideoTrackTimelineView.this, view2);
            }
        });
        contentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.r
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean z16;
                z16 = VideoTrackTimelineView.z1(VideoTrackTimelineView.this, view2, motionEvent);
                return z16;
            }
        });
    }
}
