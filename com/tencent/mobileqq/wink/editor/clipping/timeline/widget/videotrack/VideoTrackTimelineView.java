package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragViewModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView;
import com.tencent.mobileqq.wink.editor.smartclip.TimeLineBorderView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.videocut.utils.r;
import g63.CommonConfig;
import g63.VideoTrackConfig;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001v\b\u0007\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008d\u0001\u008e\u0001BC\b\u0007\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\f\b\u0002\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001\u0012\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u0011\u0012\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001\u0012\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u0011\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u001cJ(\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0011H\u0014J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u000e\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.J\u0010\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101J\u0006\u00104\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0011J\b\u00107\u001a\u00020\u0011H\u0016R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0014\u0010K\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010FR\u0016\u0010N\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010MR\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0016\u0010_\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010MR\u0014\u0010b\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010ZR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010ZR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010k\u001a\u00020\u001f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010m\u001a\u00020\u001f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bl\u0010jR\"\u0010r\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020o0n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010|\u001a\u00020o8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bz\u0010{R\u0014\u0010~\u001a\u00020o8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b}\u0010{R\u0016\u0010\u0081\u0001\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/EffectTimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/n;", "videoTrackModel", "", "Q1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/g;", "A1", "N1", "O1", "S1", "", "isFirst", "isLast", "Lg63/a;", SkinConstants.TintConstant.KEY_COMMON_CONFIG, "L1", "", Constants.BASE_IN_PLUGIN_ID, "selected", "z1", "M1", "l", "p", "g", "r", "singleBitmapWidthPx", "setSingleBitmapWidth", "Landroid/widget/FrameLayout;", "C1", "J1", "", "F1", "radius", "setCornerRadius", "setSelected", "id", "Landroid/view/ViewGroup;", "G0", "fromUser", Constants.APK_CERTIFICATE, "(Z)V", "I1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "provider", "setThumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "selectListener", "setSelectListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/c;", "listener", "setDrawBitmapListener", "R1", "offset", "K1", "t", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "W", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "bevelView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/RoundFrameLayout;", "a0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/RoundFrameLayout;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TopTagViewContainerView;", "b0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TopTagViewContainerView;", "tagContainer", "Landroid/view/View;", "c0", "Landroid/view/View;", "redMaskView", "d0", "beginMaskView", "e0", "endMaskView", "f0", "I", "bitmapWidth", "g0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/n;", "initialTrackModel", "h0", "cornerRadius", "i0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "j0", "Lg63/a;", DownloadInfo.spKey_Config, "k0", "Z", "needHideTag", "l0", "needMaskView", "m0", "scrollOffset", "n0", "Landroid/widget/FrameLayout;", "extraContainer", "o0", "p0", "Ljava/text/SimpleDateFormat;", "q0", "Ljava/text/SimpleDateFormat;", "simpleDateFormat", "r0", "Ljava/lang/String;", "RATIO_FORMAT", "s0", "RATIO_FORMAT_TWO_BIT_INTEGER", "Lkotlin/Pair;", "", "t0", "Lkotlin/Pair;", "lastDownPoint", "u0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$c", "v0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$c;", "videoThumbProvider", "E1", "()F", "startClipPosition", "B1", "endClipPosition", "L0", "()I", "contentPadding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/f;", "dragModel", "selectedStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/f;I)V", "x0", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor", "ClickableViewAccessibility"})
/* loaded from: classes21.dex */
public final class VideoTrackTimelineView extends EffectTimelineView {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final PlayTrackExpandWidthView bevelView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundFrameLayout container;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TopTagViewContainerView tagContainer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View redMaskView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View beginMaskView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View endMaskView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int bitmapWidth;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VideoTrackModel initialTrackModel;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int cornerRadius;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b selectListener;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonConfig config;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean needHideTag;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean needMaskView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private int scrollOffset;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout extraContainer;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean isLast;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirst;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat simpleDateFormat;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String RATIO_FORMAT;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String RATIO_FORMAT_TWO_BIT_INTEGER;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Float, Float> lastDownPoint;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d thumbnailProvider;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c videoThumbProvider;

    /* renamed from: w0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319593w0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "", "", "id", "", "selectedStatus", "", "isClickStartClipRegion", "isClickEndClipRegion", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "view", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@NotNull String id5, int selectedStatus, boolean isClickStartClipRegion, boolean isClickEndClipRegion, @NotNull VideoTrackTimelineView view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/e;", "", "offset", "", "tag", "Landroid/graphics/Bitmap;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements e {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.e
        @Nullable
        public Bitmap a(int offset, @Nullable Object tag) {
            VideoTrackModel videoTrackModel = VideoTrackTimelineView.this.initialTrackModel;
            if (videoTrackModel != null) {
                if (VideoTrackTimelineView.this.getInnerScaleCalculator() == null) {
                    return VideoTrackTimelineView.this.thumbnailProvider.getDefaultBitmap();
                }
                return VideoTrackTimelineView.this.thumbnailProvider.getBitmapByTime(((float) r0.x(offset)) / videoTrackModel.getSourceData().getTimeData().e(), videoTrackModel.getUuid(), videoTrackModel.getPath());
            }
            return VideoTrackTimelineView.this.thumbnailProvider.getDefaultBitmap();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackTimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull DragModel dragModel, int i16) {
        super(context, attributeSet, i3, dragModel, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dragModel, "dragModel");
        this.f319593w0 = new LinkedHashMap();
        this.simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.US);
        this.RATIO_FORMAT = "%.1f";
        this.RATIO_FORMAT_TWO_BIT_INTEGER = "%02d";
        Float valueOf = Float.valueOf(0.0f);
        this.lastDownPoint = TuplesKt.to(valueOf, valueOf);
        this.thumbnailProvider = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.c();
        c cVar = new c();
        this.videoThumbProvider = cVar;
        ViewGroup contentView = getContentView();
        contentView = contentView == null ? G0(View.generateViewId()) : contentView;
        RoundFrameLayout container = (RoundFrameLayout) contentView.findViewById(R.id.content);
        PlayTrackExpandWidthView playTrackExpandWidthView = new PlayTrackExpandWidthView(context, null, 0, 6, null);
        playTrackExpandWidthView.setId(View.generateViewId());
        playTrackExpandWidthView.setBackgroundColor(-16777216);
        playTrackExpandWidthView.setSingleBitmapWidth(this.bitmapWidth);
        playTrackExpandWidthView.setThumbProvider(cVar);
        container.addView(playTrackExpandWidthView, new ViewGroup.LayoutParams(-1, -1));
        TopTagViewContainerView topTagViewContainerView = new TopTagViewContainerView(context, null, 0, 6, null);
        contentView.addView(topTagViewContainerView, new ConstraintLayout.LayoutParams(-2, -1));
        FrameLayout frameLayout = new FrameLayout(context);
        this.extraContainer = frameLayout;
        contentView.addView(frameLayout, new ConstraintLayout.LayoutParams(-1, -1));
        View view = new View(getContext());
        view.setBackgroundResource(R.color.bdp);
        view.setVisibility(4);
        container.addView(view, new ViewGroup.LayoutParams(-1, -1));
        View view2 = new View(getContext());
        view2.setBackgroundResource(R.color.bdr);
        view2.setVisibility(4);
        container.addView(view2, new ViewGroup.LayoutParams(-1, -1));
        View view3 = new View(getContext());
        view3.setBackgroundResource(R.color.bdr);
        view3.setVisibility(4);
        container.addView(view3, new ViewGroup.LayoutParams(-1, -1));
        this.bevelView = playTrackExpandWidthView;
        Intrinsics.checkNotNullExpressionValue(container, "container");
        this.container = container;
        this.tagContainer = topTagViewContainerView;
        this.redMaskView = view;
        this.beginMaskView = view2;
        this.endMaskView = view3;
        contentView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                VideoTrackTimelineView.u1(VideoTrackTimelineView.this, view4);
            }
        });
        contentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                boolean v16;
                v16 = VideoTrackTimelineView.v1(VideoTrackTimelineView.this, view4, motionEvent);
                return v16;
            }
        });
    }

    private final TagData A1(VideoTrackModel videoTrackModel) {
        String str;
        r rVar = r.f384266a;
        float f16 = 1000;
        if (((float) rVar.d(videoTrackModel.getDuration())) / f16 < 60.0f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.RATIO_FORMAT, Arrays.copyOf(new Object[]{Float.valueOf(((float) rVar.d(videoTrackModel.getDuration())) / f16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            str = format + ReportConstant.COSTREPORT_PREFIX;
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            long j3 = 1000;
            long j16 = 60;
            String format2 = String.format(this.RATIO_FORMAT_TWO_BIT_INTEGER, Arrays.copyOf(new Object[]{Long.valueOf((rVar.d(videoTrackModel.getDuration()) / j3) / j16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            String format3 = String.format(this.RATIO_FORMAT_TWO_BIT_INTEGER, Arrays.copyOf(new Object[]{Long.valueOf((rVar.d(videoTrackModel.getDuration()) / j3) % j16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            str = format2 + ":" + format3;
        }
        String str2 = str;
        long duration = videoTrackModel.getDuration() - videoTrackModel.getSourceData().getTimeData().getSourceDurationUs();
        if (videoTrackModel.getType() == 1) {
            com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
            return new TagData(str2, 0, eVar.a(2.0f), R.drawable.nq7, new Rect(0, 0, eVar.a(9.0f), eVar.a(9.0f)), 0, null, false, 0, 0, 0, 2018, null);
        }
        if (Math.abs(duration) >= JsonGrayBusiId.UI_RESERVE_100000_110000 && duration <= 0) {
            com.tencent.videocut.utils.e eVar2 = com.tencent.videocut.utils.e.f384236a;
            return new TagData(str2, 0, eVar2.a(2.0f), R.drawable.opr, new Rect(0, 0, eVar2.a(9.0f), eVar2.a(9.0f)), 0, null, false, 0, 0, 0, 2018, null);
        }
        return new TagData(str2, 0, 0, 0, null, 0, null, false, 0, 0, 0, 2046, null);
    }

    private final float B1() {
        if (this.initialTrackModel != null) {
            return r0.getEndClipWidth();
        }
        return 0.0f;
    }

    private final int D1() {
        DrawData drawData;
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null && (drawData = videoTrackModel.getDrawData()) != null) {
            return drawData.getSelectStatus();
        }
        return -1;
    }

    private final float E1() {
        if (this.initialTrackModel != null) {
            return r0.getStartClipWidth();
        }
        return 0.0f;
    }

    private final void L1(VideoTrackModel videoTrackModel, boolean isFirst, boolean isLast, CommonConfig commonConfig) {
        int a16;
        int coerceAtLeast;
        if (Intrinsics.areEqual(this.initialTrackModel, videoTrackModel) && this.isLast == isLast && this.isFirst == isFirst && Intrinsics.areEqual(this.config, commonConfig)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        int i3 = 0;
        if (isLast) {
            a16 = 0;
        } else {
            a16 = com.tencent.videocut.utils.e.f384236a.a(commonConfig.getVideoTrackConfig().getVideoTrackMargin());
        }
        layoutParams.width = ((videoTrackModel.getWidth() + T0()) + T0()) - a16;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((videoTrackModel.getLeftMargin() + commonConfig.getLayoutConfig().getPanelStartOffset()) - T0(), 0);
        layoutParams.leftMargin = coerceAtLeast;
        setLayoutParams(layoutParams);
        this.bevelView.setMaxLeftBorderWidth(videoTrackModel.getLeftOffset());
        TopTagViewContainerView topTagViewContainerView = this.tagContainer;
        if (!commonConfig.getVideoTrackConfig().getShowTopDurationTag()) {
            i3 = 8;
        }
        topTagViewContainerView.setVisibility(i3);
        I1();
    }

    private final void M1(VideoTrackModel videoTrackModel) {
        int i3;
        int i16;
        long b16 = WinkConfig.f317649a.b();
        if (videoTrackModel.getSourceData().getTimeData().getTimelineStartTimeUs() + videoTrackModel.getSourceData().getTimeData().getTimelineDurationUs() <= b16) {
            this.redMaskView.setVisibility(8);
            return;
        }
        long max = Math.max(0L, b16 - videoTrackModel.getSourceData().getTimeData().getTimelineStartTimeUs());
        long timelineDurationUs = videoTrackModel.getSourceData().getTimeData().getTimelineDurationUs() - max;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        i63.b innerScaleCalculator = getInnerScaleCalculator();
        if (innerScaleCalculator != null) {
            i3 = innerScaleCalculator.y(max);
        } else {
            i3 = 0;
        }
        layoutParams.leftMargin = i3;
        i63.b innerScaleCalculator2 = getInnerScaleCalculator();
        if (innerScaleCalculator2 != null) {
            i16 = innerScaleCalculator2.y(timelineDurationUs);
        } else {
            i16 = 0;
        }
        layoutParams.width = i16;
        this.redMaskView.setLayoutParams(layoutParams);
        this.redMaskView.setVisibility(0);
    }

    private final void N1(VideoTrackModel videoTrackModel) {
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
        O1(videoTrackModel);
    }

    private final void O1(VideoTrackModel videoTrackModel) {
        int selectStatus = videoTrackModel.getDrawData().getSelectStatus();
        if (selectStatus != -1) {
            if (selectStatus == 1) {
                z1(true);
                return;
            }
            return;
        }
        z1(false);
    }

    private final void Q1(VideoTrackModel videoTrackModel) {
        List<TagData> mutableList;
        if (!this.needHideTag) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) videoTrackModel.getDrawData().b());
            if (videoTrackModel.getDrawData().getIsShowDurationText()) {
                mutableList.add(0, A1(videoTrackModel));
            }
            this.tagContainer.c(mutableList);
        }
    }

    private final void S1(VideoTrackModel videoTrackModel) {
        boolean z16;
        float startClipWidth = videoTrackModel.getStartClipWidth();
        float endClipWidth = videoTrackModel.getEndClipWidth();
        boolean z17 = true;
        if (startClipWidth == E1()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (endClipWidth != B1()) {
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
    public static final void u1(VideoTrackTimelineView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G1(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v1(VideoTrackTimelineView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getActionMasked() == 0) {
            this$0.lastDownPoint = TuplesKt.to(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
            return false;
        }
        return false;
    }

    private final void z1(boolean selected) {
        setSelected(selected);
        this.bevelView.setSelected(selected);
        I1();
    }

    @NotNull
    /* renamed from: C1, reason: from getter */
    public final FrameLayout getExtraContainer() {
        return this.extraContainer;
    }

    @NotNull
    public final String F1() {
        String uuid;
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel == null || (uuid = videoTrackModel.getUuid()) == null) {
            return "";
        }
        return uuid;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView
    @NotNull
    protected ViewGroup G0(int id5) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168942hf3, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        viewGroup.setId(id5);
        return viewGroup;
    }

    public final void G1(boolean fromUser) {
        if (fromUser) {
            b bVar = this.selectListener;
            if (bVar != null) {
                bVar.a(F1(), D1(), this.bevelView.j(this.lastDownPoint.getFirst().floatValue(), this.lastDownPoint.getSecond().floatValue()), this.bevelView.i(this.lastDownPoint.getFirst().floatValue(), this.lastDownPoint.getSecond().floatValue()), this);
                return;
            }
            return;
        }
        b bVar2 = this.selectListener;
        if (bVar2 != null) {
            bVar2.a(F1(), D1(), false, false, this);
        }
    }

    public final void I1() {
        this.bevelView.postInvalidate();
    }

    public final void J1(@NotNull VideoTrackModel videoTrackModel, boolean isFirst, boolean isLast, @Nullable CommonConfig commonConfig) {
        CommonConfig commonConfig2;
        VideoTrackModel a16;
        int i3;
        Intrinsics.checkNotNullParameter(videoTrackModel, "videoTrackModel");
        if (commonConfig == null) {
            commonConfig2 = new CommonConfig(null, null, null, null, 15, null);
        } else {
            commonConfig2 = commonConfig;
        }
        L1(videoTrackModel, isFirst, isLast, commonConfig2);
        this.isLast = isLast;
        this.isFirst = isFirst;
        this.config = commonConfig;
        Q1(videoTrackModel);
        S1(videoTrackModel);
        N1(videoTrackModel);
        M1(videoTrackModel);
        QLog.d("VideoRackTimelineView", 4, "start position = " + videoTrackModel.getLeftMargin());
        setDragViewModel(DragViewModel.b(getDragViewModel(), null, videoTrackModel.getLeftMargin(), videoTrackModel.f(), 0L, 0, videoTrackModel.getUuid(), null, 73, null));
        a16 = videoTrackModel.a((r32 & 1) != 0 ? videoTrackModel.uuid : null, (r32 & 2) != 0 ? videoTrackModel.type : 0, (r32 & 4) != 0 ? videoTrackModel.path : null, (r32 & 8) != 0 ? videoTrackModel.leftMargin : 0, (r32 & 16) != 0 ? videoTrackModel.leftOffset : 0, (r32 & 32) != 0 ? videoTrackModel.minLeftMargin : 0, (r32 & 64) != 0 ? videoTrackModel.width : 0, (r32 & 128) != 0 ? videoTrackModel.maxWidth : 0, (r32 & 256) != 0 ? videoTrackModel.startClipWidth : 0, (r32 & 512) != 0 ? videoTrackModel.endClipWidth : 0, (r32 & 1024) != 0 ? videoTrackModel.duration : 0L, (r32 & 2048) != 0 ? videoTrackModel.minWidth : 0, (r32 & 4096) != 0 ? videoTrackModel.sourceData : null, (r32 & 8192) != 0 ? videoTrackModel.drawData : null);
        this.initialTrackModel = a16;
        K1(this.scrollOffset);
        FrameLayout frameLayout = this.extraContainer;
        if (commonConfig2.getVideoTrackConfig().getNeedShowExtraContainer()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    public final void K1(int offset) {
        int coerceAtLeast;
        long j3;
        int i3;
        int coerceAtLeast2;
        VariableClipModel sourceData;
        TimeData timeData;
        if (!this.needMaskView) {
            return;
        }
        this.scrollOffset = offset;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = 0;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(offset, 0);
        layoutParams.width = coerceAtLeast;
        this.beginMaskView.setLayoutParams(layoutParams);
        this.beginMaskView.setVisibility(0);
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null && (sourceData = videoTrackModel.getSourceData()) != null && (timeData = sourceData.getTimeData()) != null) {
            j3 = timeData.getSourceDurationUs();
        } else {
            j3 = 0;
        }
        long j16 = j3 - 0;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.leftMargin = Utils.n(TimeLineBorderView.f321470f, getResources()) + offset;
        i63.b innerScaleCalculator = getInnerScaleCalculator();
        if (innerScaleCalculator != null) {
            i3 = innerScaleCalculator.y(j16);
        } else {
            i3 = 0;
        }
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i3 - layoutParams.leftMargin, 0);
        layoutParams2.width = coerceAtLeast2;
        this.endMaskView.setLayoutParams(layoutParams2);
        this.endMaskView.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView
    protected int L0() {
        return 0;
    }

    public final void R1() {
        int coerceAtLeast;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i3 = 0;
        int T0 = iArr[0] + T0();
        if (T0 < 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((getWidth() - (T0() * 2)) - this.tagContainer.getWidth(), 0);
            i3 = RangesKt___RangesKt.coerceAtMost((-T0) + 2, coerceAtLeast);
        }
        TopTagViewContainerView topTagViewContainerView = this.tagContainer;
        ViewGroup.LayoutParams layoutParams = topTagViewContainerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(i3);
        topTagViewContainerView.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int g() {
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null) {
            return videoTrackModel.getMinLeftMargin();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int l() {
        return super.T0();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int p() {
        return super.T0();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int r() {
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null) {
            return videoTrackModel.getMaxWidth() + videoTrackModel.getLeftMargin();
        }
        return 0;
    }

    public final void setCornerRadius(int radius) {
        this.cornerRadius = radius;
    }

    public final void setDrawBitmapListener(@Nullable com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c listener) {
        this.bevelView.setDrawBitmapListener(listener);
    }

    public final void setSelectListener(@NotNull b selectListener) {
        Intrinsics.checkNotNullParameter(selectListener, "selectListener");
        this.selectListener = selectListener;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView, android.view.View
    public void setSelected(boolean selected) {
        boolean z16;
        int a16;
        int a17;
        int a18;
        VideoTrackConfig videoTrackConfig;
        super.setSelected(selected);
        CommonConfig commonConfig = this.config;
        if (commonConfig != null && (videoTrackConfig = commonConfig.getVideoTrackConfig()) != null) {
            z16 = videoTrackConfig.getNeedRoundCorner();
        } else {
            z16 = true;
        }
        RoundFrameLayout roundFrameLayout = this.container;
        int i3 = 0;
        if (!this.isFirst && !z16) {
            a16 = 0;
        } else {
            a16 = com.tencent.videocut.utils.e.f384236a.a(4.0f);
        }
        if (!this.isFirst && !z16) {
            a17 = 0;
        } else {
            a17 = com.tencent.videocut.utils.e.f384236a.a(4.0f);
        }
        if (!this.isLast && !z16) {
            a18 = 0;
        } else {
            a18 = com.tencent.videocut.utils.e.f384236a.a(4.0f);
        }
        if (this.isLast || z16) {
            i3 = com.tencent.videocut.utils.e.f384236a.a(4.0f);
        }
        roundFrameLayout.setRadius(a16, a17, a18, i3);
    }

    public final void setSingleBitmapWidth(int singleBitmapWidthPx) {
        this.bitmapWidth = singleBitmapWidthPx;
        this.bevelView.setSingleBitmapWidth(singleBitmapWidthPx);
    }

    public final void setThumbnailProvider(@NotNull d provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.thumbnailProvider = provider;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int t() {
        VideoTrackModel videoTrackModel = this.initialTrackModel;
        if (videoTrackModel != null) {
            return videoTrackModel.getMinWidth();
        }
        return 0;
    }

    public /* synthetic */ VideoTrackTimelineView(Context context, AttributeSet attributeSet, int i3, DragModel dragModel, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, dragModel, (i17 & 16) != 0 ? 0 : i16);
    }
}
