package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.SliderView;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.videocut.utils.o;
import e63.EffectMaskLocation;
import g63.CommonConfig;
import g63.LayoutConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0004hlo{\u0018\u0000 \u008f\u00012\u00020\u00012\u00020\u0002:\u0004\u0090\u0001\u0091\u0001B.\b\u0007\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u0012\f\b\u0002\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u0001\u0012\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u0011\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0003J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002JP\u0010 \u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0003\u0010\u001b\u001a\u00020\u00112\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH\u0007J\u0010\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020\u0003J\u0018\u0010'\u001a\u00020\u00032\u0010\u0010&\u001a\f\u0012\u0004\u0012\u00020\u00170$j\u0002`%J\u000e\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0011J\u000e\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*J\u000e\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0019J\u000e\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0019J\b\u00101\u001a\u00020\u0003H\u0014J\u0014\u00104\u001a\u00020\u00032\n\u00103\u001a\u0006\u0012\u0002\b\u000302H\u0016J\u0010\u00107\u001a\u00020\t2\u0006\u00106\u001a\u000205H\u0016R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR$\u0010T\u001a\u0012\u0012\u0004\u0012\u00020\u00070$j\b\u0012\u0004\u0012\u00020\u0007`Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR$\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010SR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001b\u0010_\u001a\u00020\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010]\u001a\u0004\bR\u0010^R\u001b\u0010b\u001a\u00020`8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010]\u001a\u0004\bJ\u0010aR\u001b\u0010c\u001a\u00020`8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010]\u001a\u0004\bN\u0010aR\u001b\u0010f\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010]\u001a\u0004\bZ\u0010eR\u001b\u0010g\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010]\u001a\u0004\bX\u0010eR\u0014\u0010j\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010VR\u0014\u0010n\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010mR\u0014\u0010q\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010pR\u0018\u0010s\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010rR\u001b\u0010v\u001a\u00020t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010]\u001a\u0004\bU\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010+\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}R&\u0010\u0083\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b~\u0010\u0013\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u00109R\u0017\u0010\u0087\u0001\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0080\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer;", "Landroid/widget/FrameLayout;", "Lf63/b;", "", "L", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Le63/a;", "effectMaskLocation", "", "isMaskingData", "T", NodeProps.VISIBLE, "N", BdhLogUtil.LogTag.Tag_Req, "targetMaskLocation", "M", "", "I", "J", "isRightDirection", "isRightSlider", "O", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "appliedEffect", "", "position", "color", "Lkotlin/Function0;", "curPositionSupplier", "Lkotlin/Function2;", "onReachEnd", "P", "endMs", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "y", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectTimeline;", "effectTimeline", ExifInterface.LATITUDE_SOUTH, "width", "K", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$b;", "listener", "setEffectMaskContainerOp", "appliedEffectId", "w", "curPlayTimeUs", HippyTKDListViewAdapter.X, NodeProps.ON_DETACHED_FROM_WINDOW, "Lf63/a;", "controller", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/MotionEvent;", "event", "onTouchEvent", "d", "Z", "masking", "e", "editing", "f", "isSliderScrollingRight", h.F, "isSliderScrollingLeft", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "sliderHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/a;", "effectMaskController", "Landroid/graphics/Paint;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "D", "Landroid/graphics/Rect;", "drawRect", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "maskLocations", UserInfo.SEX_FEMALE, "Le63/a;", "maskingLocation", "G", "maskLocationViews", "H", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskView;", "maskingLocationView", "Lkotlin/Lazy;", "()Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "leftSliderView", "rightSliderView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "sliderTopBorderView", "sliderBottomBorderView", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$c;", "effectMaskViewClickListener", "selectedItem", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$d;", "leftSliderListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$g", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$g;", "rightSliderListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$b;", "effectMaskContainerOp", "Landroid/view/GestureDetector;", "()Landroid/view/GestureDetector;", "scrollGestureDetector", "Landroid/view/GestureDetector$OnGestureListener;", "U", "Landroid/view/GestureDetector$OnGestureListener;", "onScrollGestureListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$e", "V", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$e;", "W", "B", "()J", "setDurationUs", "(J)V", "durationUs", "a0", "isInUserScroll", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "duration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c0", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class EffectMaskContainer extends FrameLayout implements f63.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Rect drawRect;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<EffectMaskLocation> maskLocations;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final EffectMaskLocation maskingLocation;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<EffectMaskView> maskLocationViews;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private EffectMaskView maskingLocationView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftSliderView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy rightSliderView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy sliderTopBorderView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy sliderBottomBorderView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final c effectMaskViewClickListener;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private EffectMaskLocation selectedItem;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final d leftSliderListener;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final g rightSliderListener;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private b effectMaskContainerOp;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy scrollGestureDetector;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final GestureDetector.OnGestureListener onScrollGestureListener;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final e listener;

    /* renamed from: W, reason: from kotlin metadata */
    private long durationUs;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isInUserScroll;

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319411b0;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean masking;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean editing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isSliderScrollingRight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSliderScrollingLeft;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler sliderHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a effectMaskController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$b;", "", "Le63/a;", "effectData", "", "b", "", "isLeftSlider", "c", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@Nullable EffectMaskLocation effectData, boolean isLeftSlider);

        void b(@Nullable EffectMaskLocation effectData);

        void c(@Nullable EffectMaskLocation effectData, boolean isLeftSlider);

        void d(@Nullable EffectMaskLocation effectData, boolean isLeftSlider);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskView$a;", "Le63/a;", "effectData", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements EffectMaskView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskView.a
        public void a(@Nullable EffectMaskLocation effectData) {
            b bVar = EffectMaskContainer.this.effectMaskContainerOp;
            if (bVar != null) {
                bVar.b(effectData);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$d", "Lk63/a;", "", "rawX", "", "b", "a", "Landroid/view/MotionEvent;", "event", "moveX", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements k63.a {
        d() {
        }

        @Override // k63.a
        public void a() {
            b bVar;
            if (EffectMaskContainer.this.effectMaskController == null) {
                return;
            }
            EffectMaskContainer.this.getParent().requestDisallowInterceptTouchEvent(false);
            EffectMaskContainer.this.editing = false;
            EffectMaskContainer.this.isSliderScrollingLeft = false;
            EffectMaskContainer.this.isSliderScrollingRight = false;
            EffectMaskContainer.this.sliderHandler.removeCallbacksAndMessages(null);
            EffectMaskLocation effectMaskLocation = EffectMaskContainer.this.selectedItem;
            if (effectMaskLocation != null && (bVar = EffectMaskContainer.this.effectMaskContainerOp) != null) {
                bVar.a(effectMaskLocation, true);
            }
        }

        @Override // k63.a
        public void b(float rawX) {
            b bVar;
            EffectMaskContainer.this.editing = true;
            EffectMaskContainer.this.getParent().requestDisallowInterceptTouchEvent(true);
            EffectMaskLocation effectMaskLocation = EffectMaskContainer.this.selectedItem;
            if (effectMaskLocation != null && (bVar = EffectMaskContainer.this.effectMaskContainerOp) != null) {
                bVar.c(effectMaskLocation, true);
            }
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            EffectMaskLocation effectMaskLocation;
            long coerceAtLeast;
            long coerceIn;
            Intrinsics.checkNotNullParameter(event, "event");
            a aVar = EffectMaskContainer.this.effectMaskController;
            if (aVar != null && (effectMaskLocation = EffectMaskContainer.this.selectedItem) != null) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(aVar.m().x(EffectMaskContainer.this.D().getX() - (event.getRawX() + EffectMaskContainer.this.getScrollX())), 33333L);
                long endTimeUs = aVar.m().getEndTimeUs();
                coerceIn = RangesKt___RangesKt.coerceIn(effectMaskLocation.getStopPositionMs() - (coerceAtLeast / 1000), 0L, effectMaskLocation.getStopPositionMs());
                effectMaskLocation.o(coerceIn);
                b bVar = EffectMaskContainer.this.effectMaskContainerOp;
                if (bVar != null) {
                    bVar.d(effectMaskLocation, true);
                }
                EffectMaskContainer.this.L();
                int dip2px = ViewUtils.dip2px(50.0f);
                int g16 = o.g() - ViewUtils.dip2px(50.0f);
                if (event.getRawX() < dip2px) {
                    EffectMaskContainer.this.O(true, false);
                    return;
                }
                if (event.getRawX() > g16) {
                    EffectMaskContainer.this.O(false, false);
                    return;
                }
                if ((EffectMaskContainer.this.isSliderScrollingLeft && o.g() - event.getRawX() > ViewUtils.dip2px(50.0f)) || ((EffectMaskContainer.this.isSliderScrollingRight && event.getRawX() > ViewUtils.dip2px(50.0f)) || effectMaskLocation.getStartPositionMs() <= 0 || effectMaskLocation.getStopPositionMs() >= endTimeUs)) {
                    EffectMaskContainer.this.isSliderScrollingLeft = false;
                    EffectMaskContainer.this.isSliderScrollingRight = false;
                    EffectMaskContainer.this.sliderHandler.removeCallbacksAndMessages(null);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$e", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "", "xPos", "", "b", "", "cancel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements FlingHelper.a {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void a(int xPos, boolean cancel) {
            PanelEventHandler k3;
            EffectMaskContainer.this.isInUserScroll = false;
            a aVar = EffectMaskContainer.this.effectMaskController;
            if (aVar != null && (k3 = aVar.k()) != null) {
                k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d(cancel));
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void b(int xPos) {
            a aVar = EffectMaskContainer.this.effectMaskController;
            if (aVar != null) {
                aVar.r(xPos);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$f", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "e1", "e2", "", "velocityX", "velocityY", "onFling", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "onSingleTapUp", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends GestureDetector.SimpleOnGestureListener {
        f() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent e16) {
            PanelEventHandler k3;
            FlingHelper i3;
            a aVar = EffectMaskContainer.this.effectMaskController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.g();
            }
            a aVar2 = EffectMaskContainer.this.effectMaskController;
            if (aVar2 != null && (k3 = aVar2.k()) != null) {
                k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e());
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            FlingHelper i3;
            a aVar = EffectMaskContainer.this.effectMaskController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.f(-((int) velocityX), EffectMaskContainer.this.getScrollX(), EffectMaskContainer.this.I(), EffectMaskContainer.this.listener);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
            FlingHelper i3;
            a aVar = EffectMaskContainer.this.effectMaskController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.g();
            }
            int scrollX = EffectMaskContainer.this.getScrollX() + ((int) distanceX);
            if (scrollX < 0) {
                scrollX = 0;
            } else if (scrollX > EffectMaskContainer.this.I()) {
                scrollX = EffectMaskContainer.this.I();
            }
            a aVar2 = EffectMaskContainer.this.effectMaskController;
            if (aVar2 != null) {
                aVar2.r(scrollX);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            Iterator it = EffectMaskContainer.this.maskLocationViews.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (((EffectMaskView) it.next()).c(e16)) {
                    z16 = true;
                }
            }
            if (!z16) {
                EffectMaskContainer.this.w(-1L);
                return true;
            }
            return z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$g", "Lk63/a;", "", "rawX", "", "b", "a", "Landroid/view/MotionEvent;", "event", "moveX", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements k63.a {
        g() {
        }

        @Override // k63.a
        public void a() {
            b bVar;
            if (EffectMaskContainer.this.effectMaskController == null) {
                return;
            }
            EffectMaskContainer.this.getParent().requestDisallowInterceptTouchEvent(false);
            EffectMaskContainer.this.editing = false;
            EffectMaskContainer.this.isSliderScrollingLeft = false;
            EffectMaskContainer.this.isSliderScrollingRight = false;
            EffectMaskContainer.this.sliderHandler.removeCallbacksAndMessages(null);
            EffectMaskLocation effectMaskLocation = EffectMaskContainer.this.selectedItem;
            if (effectMaskLocation != null && (bVar = EffectMaskContainer.this.effectMaskContainerOp) != null) {
                bVar.a(effectMaskLocation, false);
            }
        }

        @Override // k63.a
        public void b(float rawX) {
            b bVar;
            EffectMaskContainer.this.editing = true;
            EffectMaskContainer.this.getParent().requestDisallowInterceptTouchEvent(true);
            EffectMaskLocation effectMaskLocation = EffectMaskContainer.this.selectedItem;
            if (effectMaskLocation != null && (bVar = EffectMaskContainer.this.effectMaskContainerOp) != null) {
                bVar.c(effectMaskLocation, true);
            }
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            EffectMaskLocation effectMaskLocation;
            long coerceAtLeast;
            long coerceIn;
            Intrinsics.checkNotNullParameter(event, "event");
            a aVar = EffectMaskContainer.this.effectMaskController;
            if (aVar != null && (effectMaskLocation = EffectMaskContainer.this.selectedItem) != null) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(aVar.m().x(((event.getRawX() + EffectMaskContainer.this.getScrollX()) - EffectMaskContainer.this.C().getX()) - EffectMaskContainer.this.C().getWidth()), 33333L);
                long endTimeUs = aVar.m().getEndTimeUs();
                long j3 = 1000;
                coerceIn = RangesKt___RangesKt.coerceIn(effectMaskLocation.getStartPositionMs() + (coerceAtLeast / j3), effectMaskLocation.getStartPositionMs(), endTimeUs / j3);
                effectMaskLocation.p(coerceIn);
                b bVar = EffectMaskContainer.this.effectMaskContainerOp;
                if (bVar != null) {
                    bVar.d(effectMaskLocation, false);
                }
                EffectMaskContainer.this.L();
                int dip2px = ViewUtils.dip2px(50.0f);
                int g16 = o.g() - ViewUtils.dip2px(50.0f);
                if (event.getRawX() < dip2px) {
                    EffectMaskContainer.this.O(true, true);
                    return;
                }
                if (event.getRawX() > g16) {
                    EffectMaskContainer.this.O(false, true);
                    return;
                }
                if ((EffectMaskContainer.this.isSliderScrollingLeft && o.g() - event.getRawX() > ViewUtils.dip2px(50.0f)) || ((EffectMaskContainer.this.isSliderScrollingRight && event.getRawX() > ViewUtils.dip2px(50.0f)) || effectMaskLocation.getStartPositionMs() <= 0 || effectMaskLocation.getStopPositionMs() >= endTimeUs)) {
                    EffectMaskContainer.this.isSliderScrollingLeft = false;
                    EffectMaskContainer.this.isSliderScrollingRight = false;
                    EffectMaskContainer.this.sliderHandler.removeCallbacksAndMessages(null);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EffectMaskContainer(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long A() {
        return this.durationUs / 1000;
    }

    private final FrameLayout E() {
        return (FrameLayout) this.rootView.getValue();
    }

    private final GestureDetector F() {
        return (GestureDetector) this.scrollGestureDetector.getValue();
    }

    private final ImageView G() {
        return (ImageView) this.sliderBottomBorderView.getValue();
    }

    private final ImageView H() {
        return (ImageView) this.sliderTopBorderView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int I() {
        i63.b m3;
        a aVar = this.effectMaskController;
        if (aVar != null && (m3 = aVar.m()) != null) {
            return m3.d();
        }
        return 0;
    }

    @ColorInt
    private final int J() {
        Random.Companion companion = Random.INSTANCE;
        return Color.argb(128, companion.nextInt(256), companion.nextInt(256), companion.nextInt(256));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L() {
        boolean z16;
        EffectMaskView z17;
        int lastIndex;
        List<EffectMaskView> list;
        ArrayList<EffectMaskView> arrayList = this.maskLocationViews;
        boolean z18 = true;
        int i3 = 0;
        if (arrayList.size() > this.maskLocations.size() && this.maskLocations.size() >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        EffectMaskLocation effectMaskLocation = null;
        if (!z16) {
            arrayList = null;
        }
        if (arrayList != null) {
            List<EffectMaskView> subList = arrayList.subList(this.maskLocations.size(), this.maskLocationViews.size());
            Intrinsics.checkNotNullExpressionValue(subList, "subList(maskLocations.si\u2026, maskLocationViews.size)");
            list = CollectionsKt___CollectionsKt.toList(subList);
            for (EffectMaskView effectMaskView : list) {
                this.maskLocationViews.remove(effectMaskView);
                E().removeView(effectMaskView);
            }
        }
        Pair pair = null;
        int i16 = 0;
        for (Object obj : this.maskLocations) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            EffectMaskLocation effectMaskLocation2 = (EffectMaskLocation) obj;
            ArrayList<EffectMaskView> arrayList2 = this.maskLocationViews;
            if (i16 >= 0) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList2);
                if (i16 <= lastIndex) {
                    z17 = arrayList2.get(i16);
                    EffectMaskView effectMaskView2 = z17;
                    effectMaskView2.b(effectMaskLocation2);
                    if (!effectMaskLocation2.getSelected()) {
                        pair = new Pair(effectMaskLocation2, effectMaskView2);
                    }
                    i16 = i17;
                }
            }
            z17 = z();
            this.maskLocationViews.add(z17);
            EffectMaskView effectMaskView22 = z17;
            effectMaskView22.b(effectMaskLocation2);
            if (!effectMaskLocation2.getSelected()) {
            }
            i16 = i17;
        }
        if (this.masking && this.maskingLocation.i()) {
            EffectMaskView effectMaskView3 = this.maskingLocationView;
            if (effectMaskView3 == null) {
                effectMaskView3 = z();
                this.maskingLocationView = effectMaskView3;
            }
            effectMaskView3.b(this.maskingLocation);
        }
        if (pair != null) {
            T((EffectMaskLocation) pair.getFirst(), false);
            ((EffectMaskView) pair.getSecond()).bringToFront();
        }
        if (pair != null) {
            effectMaskLocation = (EffectMaskLocation) pair.getFirst();
        }
        this.selectedItem = effectMaskLocation;
        if (pair == null) {
            z18 = false;
        }
        N(z18);
        a aVar = this.effectMaskController;
        if (aVar != null) {
            i3 = aVar.j();
        }
        K(i3);
        invalidate();
    }

    private final void M(EffectMaskLocation targetMaskLocation) {
        ArrayList arrayList = new ArrayList();
        for (EffectMaskLocation effectMaskLocation : this.maskLocations) {
            if (effectMaskLocation.getStartPositionMs() <= targetMaskLocation.getStartPositionMs() && effectMaskLocation.getStopPositionMs() > targetMaskLocation.getStartPositionMs() && effectMaskLocation.getStopPositionMs() < targetMaskLocation.getStopPositionMs()) {
                arrayList.add(EffectMaskLocation.b(effectMaskLocation, effectMaskLocation.getStartPositionMs(), targetMaskLocation.getStartPositionMs(), 0, null, 12, null));
            } else if (effectMaskLocation.getStartPositionMs() >= targetMaskLocation.getStartPositionMs() && effectMaskLocation.getStartPositionMs() < targetMaskLocation.getStopPositionMs() && effectMaskLocation.getStopPositionMs() > targetMaskLocation.getStopPositionMs()) {
                arrayList.add(EffectMaskLocation.b(effectMaskLocation, targetMaskLocation.getStopPositionMs(), effectMaskLocation.getStopPositionMs(), 0, null, 12, null));
            } else if (effectMaskLocation.getStartPositionMs() < targetMaskLocation.getStartPositionMs() && effectMaskLocation.getStopPositionMs() > targetMaskLocation.getStopPositionMs()) {
                arrayList.add(EffectMaskLocation.b(effectMaskLocation, effectMaskLocation.getStartPositionMs(), targetMaskLocation.getStartPositionMs(), 0, null, 12, null));
                arrayList.add(EffectMaskLocation.b(effectMaskLocation, targetMaskLocation.getStopPositionMs(), effectMaskLocation.getStopPositionMs(), 0, null, 12, null));
            } else if (effectMaskLocation.getStartPositionMs() <= targetMaskLocation.getStartPositionMs() || effectMaskLocation.getStopPositionMs() >= targetMaskLocation.getStopPositionMs()) {
                if (effectMaskLocation.getStartPositionMs() != targetMaskLocation.getStartPositionMs() || effectMaskLocation.getStopPositionMs() != targetMaskLocation.getStopPositionMs()) {
                    arrayList.add(effectMaskLocation);
                }
            }
        }
        this.maskLocations.clear();
        this.maskLocations.addAll(arrayList);
    }

    private final void N(boolean visible) {
        int i3;
        int i16;
        int i17;
        SliderView C = C();
        int i18 = 0;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        C.setVisibility(i3);
        SliderView D = D();
        if (visible) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        D.setVisibility(i16);
        ImageView H = H();
        if (visible) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        H.setVisibility(i17);
        ImageView G = G();
        if (!visible) {
            i18 = 8;
        }
        G.setVisibility(i18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(final boolean isRightDirection, final boolean isRightSlider) {
        if (isRightDirection && this.isSliderScrollingRight) {
            return;
        }
        if (!isRightDirection && this.isSliderScrollingLeft) {
            return;
        }
        this.sliderHandler.removeCallbacksAndMessages(null);
        this.isSliderScrollingRight = isRightDirection;
        this.isSliderScrollingLeft = !isRightDirection;
        this.sliderHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$slideTriggerScroll$runnable$1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private int count;

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                int i3;
                int i16;
                boolean z17;
                boolean z18;
                long coerceIn;
                long coerceIn2;
                a aVar = EffectMaskContainer.this.effectMaskController;
                if (aVar != null) {
                    z16 = EffectMaskContainer.this.editing;
                    if (!z16) {
                        return;
                    }
                    if (isRightDirection) {
                        i3 = -15;
                    } else {
                        i3 = 15;
                    }
                    long x16 = aVar.m().x(15);
                    if (isRightDirection) {
                        x16 = -x16;
                    }
                    EffectMaskLocation effectMaskLocation = EffectMaskContainer.this.selectedItem;
                    if (effectMaskLocation != null) {
                        boolean z19 = isRightSlider;
                        long endTimeUs = aVar.m().getEndTimeUs();
                        if (z19) {
                            i16 = i3;
                            long j3 = 1000;
                            long stopPositionMs = effectMaskLocation.getStopPositionMs() + (x16 / j3);
                            if (stopPositionMs > effectMaskLocation.getStartPositionMs() && stopPositionMs < endTimeUs / j3) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            coerceIn2 = RangesKt___RangesKt.coerceIn(stopPositionMs, effectMaskLocation.getStartPositionMs(), endTimeUs / j3);
                            effectMaskLocation.p(coerceIn2);
                        } else {
                            i16 = i3;
                            long startPositionMs = effectMaskLocation.getStartPositionMs() + (x16 / 1000);
                            if (startPositionMs > 0 && startPositionMs < effectMaskLocation.getStopPositionMs()) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            coerceIn = RangesKt___RangesKt.coerceIn(startPositionMs, 0L, effectMaskLocation.getStopPositionMs());
                            effectMaskLocation.o(coerceIn);
                            z17 = z18;
                        }
                    } else {
                        i16 = i3;
                        z17 = true;
                    }
                    EffectMaskContainer.b bVar = EffectMaskContainer.this.effectMaskContainerOp;
                    if (bVar != null) {
                        bVar.d(EffectMaskContainer.this.selectedItem, !isRightSlider);
                    }
                    EffectMaskContainer.this.L();
                    a aVar2 = EffectMaskContainer.this.effectMaskController;
                    if (aVar2 != null) {
                        aVar2.r(EffectMaskContainer.this.getScrollX() + i16);
                    }
                    if (z17) {
                        EffectMaskContainer.this.sliderHandler.postDelayed(this, Math.max(0L, 50 - this.count));
                    }
                    this.count++;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        if (this.masking && this.maskingLocation.i()) {
            M(this.maskingLocation);
        }
    }

    private final void T(EffectMaskLocation effectMaskLocation, boolean isMaskingData) {
        int i3;
        int i16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        int i17;
        i63.b m3;
        i63.b m16;
        CommonConfig h16;
        LayoutConfig layoutConfig;
        a aVar = this.effectMaskController;
        int i18 = 0;
        if (aVar != null && (h16 = aVar.h()) != null && (layoutConfig = h16.getLayoutConfig()) != null) {
            i3 = layoutConfig.getPanelStartOffset();
        } else {
            i3 = 0;
        }
        a aVar2 = this.effectMaskController;
        if (aVar2 != null && (m16 = aVar2.m()) != null) {
            i16 = m16.y(effectMaskLocation.getStartPositionMs() * 1000);
        } else {
            i16 = 0;
        }
        a aVar3 = this.effectMaskController;
        if (aVar3 != null && (m3 = aVar3.m()) != null) {
            i18 = m3.y(effectMaskLocation.getStopPositionMs() * 1000);
        }
        SliderView C = C();
        ViewGroup.LayoutParams layoutParams = C().getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams5 = null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart((i3 + i16) - C().getWidth());
        } else {
            marginLayoutParams = null;
        }
        C.setLayoutParams(marginLayoutParams);
        SliderView D = D();
        ViewGroup.LayoutParams layoutParams2 = D().getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        } else {
            marginLayoutParams2 = null;
        }
        if (marginLayoutParams2 != null) {
            if (isMaskingData) {
                i17 = getScrollX() + i3;
            } else {
                i17 = i3 + i18;
            }
            marginLayoutParams2.setMarginStart(i17);
        } else {
            marginLayoutParams2 = null;
        }
        D.setLayoutParams(marginLayoutParams2);
        ImageView H = H();
        ViewGroup.LayoutParams layoutParams3 = H().getLayoutParams();
        if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
        } else {
            marginLayoutParams3 = null;
        }
        if (marginLayoutParams3 != null) {
            marginLayoutParams3.setMarginStart(i3 + i16);
            marginLayoutParams3.width = i18 - i16;
        } else {
            marginLayoutParams3 = null;
        }
        H.setLayoutParams(marginLayoutParams3);
        ImageView G = G();
        ViewGroup.LayoutParams layoutParams4 = G().getLayoutParams();
        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
        } else {
            marginLayoutParams4 = null;
        }
        if (marginLayoutParams4 != null) {
            marginLayoutParams4.setMarginStart(i3 + i16);
            marginLayoutParams4.width = i18 - i16;
            marginLayoutParams5 = marginLayoutParams4;
        }
        G.setLayoutParams(marginLayoutParams5);
    }

    private final EffectMaskView z() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EffectMaskView effectMaskView = new EffectMaskView(context, null, 0, 6, null);
        effectMaskView.a(this.effectMaskController);
        effectMaskView.setEffectMaskViewClickListener(this.effectMaskViewClickListener);
        E().addView(effectMaskView, new FrameLayout.LayoutParams(-2, -1));
        return effectMaskView;
    }

    /* renamed from: B, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    @NotNull
    public final SliderView C() {
        return (SliderView) this.leftSliderView.getValue();
    }

    @NotNull
    public final SliderView D() {
        return (SliderView) this.rightSliderView.getValue();
    }

    public final void K(int width) {
        ViewGroup.LayoutParams layoutParams = E().getLayoutParams();
        layoutParams.width = width;
        E().setLayoutParams(layoutParams);
    }

    @ColorInt
    public final int P(@NotNull EffectStatusManager.AppliedEffect appliedEffect, long position, @ColorInt int color, @Nullable final Function0<Long> curPositionSupplier, @Nullable final Function2<? super EffectMaskContainer, ? super Long, Unit> onReachEnd) {
        Intrinsics.checkNotNullParameter(appliedEffect, "appliedEffect");
        if (color == Integer.MAX_VALUE) {
            color = J();
        }
        this.masking = true;
        this.maskingLocation.l(color);
        this.maskingLocation.o(position);
        this.maskingLocation.m(SystemClock.elapsedRealtime());
        this.maskingLocation.k(appliedEffect);
        postOnAnimation(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$startColorMask$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                EffectMaskLocation effectMaskLocation;
                long longValue;
                EffectMaskLocation effectMaskLocation2;
                long A;
                EffectMaskLocation effectMaskLocation3;
                long A2;
                EffectMaskLocation effectMaskLocation4;
                EffectMaskLocation effectMaskLocation5;
                z16 = EffectMaskContainer.this.masking;
                if (z16) {
                    effectMaskLocation = EffectMaskContainer.this.maskingLocation;
                    Function0<Long> function0 = curPositionSupplier;
                    if (function0 == null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        effectMaskLocation4 = EffectMaskContainer.this.maskingLocation;
                        long realTimeOffset = elapsedRealtime - effectMaskLocation4.getRealTimeOffset();
                        effectMaskLocation5 = EffectMaskContainer.this.maskingLocation;
                        longValue = realTimeOffset + effectMaskLocation5.getStartPositionMs();
                    } else {
                        longValue = function0.invoke().longValue();
                    }
                    effectMaskLocation.p(longValue);
                    effectMaskLocation2 = EffectMaskContainer.this.maskingLocation;
                    long stopPositionMs = effectMaskLocation2.getStopPositionMs();
                    A = EffectMaskContainer.this.A();
                    if (stopPositionMs >= A) {
                        effectMaskLocation3 = EffectMaskContainer.this.maskingLocation;
                        A2 = EffectMaskContainer.this.A();
                        effectMaskLocation3.p(A2);
                        EffectMaskContainer.this.R();
                        EffectMaskContainer.this.L();
                        Function2<EffectMaskContainer, Long, Unit> function2 = onReachEnd;
                        if (function2 != null) {
                            EffectMaskContainer effectMaskContainer = EffectMaskContainer.this;
                            function2.invoke(effectMaskContainer, Long.valueOf(effectMaskContainer.getDurationUs()));
                            return;
                        }
                        return;
                    }
                    EffectMaskContainer.this.R();
                    EffectMaskContainer.this.L();
                    EffectMaskContainer.this.postOnAnimation(this);
                }
            }
        });
        L();
        return color;
    }

    public final void Q(long endMs) {
        if (!this.masking) {
            return;
        }
        this.masking = false;
        if (endMs != 0) {
            this.maskingLocation.p(endMs);
        }
        this.maskLocations.add(EffectMaskLocation.b(this.maskingLocation, 0L, 0L, 0, null, 15, null));
        this.maskingLocation.j();
        EffectMaskView effectMaskView = this.maskingLocationView;
        if (effectMaskView != null) {
            this.maskLocationViews.add(effectMaskView);
        }
        this.maskingLocationView = null;
        L();
    }

    public final void S(@NotNull ArrayList<EffectStatusManager.AppliedEffect> effectTimeline) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(effectTimeline, "effectTimeline");
        this.maskLocations.clear();
        ArrayList<EffectMaskLocation> arrayList = this.maskLocations;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(effectTimeline, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (EffectStatusManager.AppliedEffect appliedEffect : effectTimeline) {
            long j3 = 1000;
            arrayList2.add(new EffectMaskLocation(appliedEffect.getStartOffsetUs() / j3, (appliedEffect.getStartOffsetUs() + appliedEffect.getDurationUs()) / j3, appliedEffect.getColor(), appliedEffect));
        }
        arrayList.addAll(arrayList2);
        L();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.masking = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        PanelEventHandler k3;
        PanelEventHandler k16;
        FlingHelper i3;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onTouchEvent = F().onTouchEvent(event);
        int action = event.getAction();
        boolean z16 = true;
        if (action != 0) {
            if (action == 1 || action == 3) {
                a aVar = this.effectMaskController;
                if (aVar == null || (i3 = aVar.i()) == null || !i3.d()) {
                    z16 = false;
                }
                if (!z16) {
                    this.isInUserScroll = false;
                    a aVar2 = this.effectMaskController;
                    if (aVar2 != null && (k16 = aVar2.k()) != null) {
                        k16.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d(false));
                    }
                }
            }
        } else {
            this.isInUserScroll = true;
            a aVar3 = this.effectMaskController;
            if (aVar3 != null && (k3 = aVar3.k()) != null) {
                k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e());
            }
        }
        return onTouchEvent;
    }

    @Override // f63.b
    public void s(@NotNull f63.a<?> controller) {
        a aVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (controller instanceof a) {
            aVar = (a) controller;
        } else {
            aVar = null;
        }
        this.effectMaskController = aVar;
    }

    public final void setDurationUs(long j3) {
        this.durationUs = j3;
    }

    public final void setEffectMaskContainerOp(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.effectMaskContainerOp = listener;
    }

    public final void w(long appliedEffectId) {
        boolean z16;
        if (!this.masking && !this.editing) {
            for (EffectMaskLocation effectMaskLocation : this.maskLocations) {
                if (effectMaskLocation.i() && effectMaskLocation.getAppliedEffect().getId() == appliedEffectId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                effectMaskLocation.n(z16);
            }
            L();
        }
    }

    public final void x(long curPlayTimeUs) {
        if (!this.masking && !this.editing) {
            long j3 = curPlayTimeUs / 1000;
            for (EffectMaskLocation effectMaskLocation : this.maskLocations) {
                if (!effectMaskLocation.i() || effectMaskLocation.getStartPositionMs() > j3 || effectMaskLocation.getStopPositionMs() < j3) {
                    effectMaskLocation.n(false);
                }
            }
            L();
        }
    }

    public final void y() {
        this.maskingLocation.j();
        this.maskLocations.clear();
        L();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EffectMaskContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EffectMaskContainer(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f319411b0 = new LinkedHashMap();
        this.sliderHandler = new Handler();
        this.paint = new Paint();
        this.drawRect = new Rect();
        this.maskLocations = new ArrayList<>();
        this.maskingLocation = new EffectMaskLocation(-1L, -1L, -16777216, EffectStatusManager.AppliedEffect.INSTANCE.b());
        this.maskLocationViews = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$rootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                return new FrameLayout(context);
            }
        });
        this.rootView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SliderView>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$leftSliderView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SliderView invoke() {
                SliderView sliderView = new SliderView(context, null, 0, 6, null);
                sliderView.setImageResource(R.drawable.onw);
                sliderView.setBackgroundColor(0);
                sliderView.setScaleType(ImageView.ScaleType.FIT_XY);
                return sliderView;
            }
        });
        this.leftSliderView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SliderView>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$rightSliderView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SliderView invoke() {
                SliderView sliderView = new SliderView(context, null, 0, 6, null);
                sliderView.setImageResource(R.drawable.onx);
                sliderView.setBackgroundColor(0);
                sliderView.setScaleType(ImageView.ScaleType.FIT_XY);
                return sliderView;
            }
        });
        this.rightSliderView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$sliderTopBorderView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                ImageView imageView = new ImageView(context);
                Context context2 = context;
                imageView.setPivotX(0.0f);
                imageView.setBackgroundColor(context2.getColor(R.color.f157866ck4));
                return imageView;
            }
        });
        this.sliderTopBorderView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$sliderBottomBorderView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                ImageView imageView = new ImageView(context);
                Context context2 = context;
                imageView.setId(imageView.getId());
                imageView.setPivotX(0.0f);
                imageView.setBackgroundColor(context2.getColor(R.color.f157866ck4));
                return imageView;
            }
        });
        this.sliderBottomBorderView = lazy5;
        this.effectMaskViewClickListener = new c();
        d dVar = new d();
        this.leftSliderListener = dVar;
        g gVar = new g();
        this.rightSliderListener = gVar;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer$scrollGestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                GestureDetector.OnGestureListener onGestureListener;
                Context context2 = context;
                onGestureListener = this.onScrollGestureListener;
                return new GestureDetector(context2, onGestureListener);
            }
        });
        this.scrollGestureDetector = lazy6;
        this.onScrollGestureListener = new f();
        this.listener = new e();
        FrameLayout E = E();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ViewUtils.dip2px(2.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(2.0f);
        Unit unit = Unit.INSTANCE;
        addView(E, layoutParams);
        addView(C(), new FrameLayout.LayoutParams(ViewUtils.dip2px(14.0f), -1));
        C().setSliderListener(dVar);
        addView(D(), new FrameLayout.LayoutParams(ViewUtils.dip2px(14.0f), -1));
        D().setSliderListener(gVar);
        ImageView H = H();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, ViewUtils.dip2px(2.0f));
        layoutParams2.gravity = 48;
        addView(H, layoutParams2);
        ImageView G = G();
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, ViewUtils.dip2px(2.0f));
        layoutParams3.gravity = 80;
        addView(G, layoutParams3);
        N(false);
    }

    public /* synthetic */ EffectMaskContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
