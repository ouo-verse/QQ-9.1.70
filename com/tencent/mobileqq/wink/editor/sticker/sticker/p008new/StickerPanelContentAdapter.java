package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.editor.sticker.sticker.WinkApplyStickerMaterialTask;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.flow.a;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.videocut.utils.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\u00020\u0001:\u0001WBA\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010S\u001a\u00020R\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000100\u0012\u0016\b\u0002\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u000108\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J6\u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\r2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u001e\u0010#\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0006H\u0016J1\u0010+\u001a\u00020\u0004\"\b\b\u0000\u0010)*\u00020'2\u0006\u0010*\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\rR*\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R0\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010C\u001a\u0004\u0018\u00010@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020!0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "Lcom/tencent/mobileqq/wink/view/AbsWinkMaterialPanelContentAdapter;", "Landroid/support/v7/widget/RecyclerView;", "rv", "", "G0", "", "childAdapterPosition", "Lkotlin/Pair;", "", "J0", "Landroid/view/View;", "view", "", "currentText", "P0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "L0", "K0", "Landroid/widget/TextView;", "N0", "M0", "O0", "elementId", "", "", "extParams", "materialHashcode", "H0", "position", "I0", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "newData", "Q0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "T", "vh", HippyTKDListViewAdapter.X, "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "getItemViewType", "text", "T0", "Lkotlin/Function0;", "L", "Lkotlin/jvm/functions/Function0;", "getStickerLoadMoreCallback", "()Lkotlin/jvm/functions/Function0;", "S0", "(Lkotlin/jvm/functions/Function0;)V", "stickerLoadMoreCallback", "Lkotlin/Function1;", "M", "Lkotlin/jvm/functions/Function1;", "getHotWordClickCallback", "()Lkotlin/jvm/functions/Function1;", "R0", "(Lkotlin/jvm/functions/Function1;)V", "hotWordClickCallback", "Landroid/graphics/drawable/Drawable;", "N", "Landroid/graphics/drawable/Drawable;", "placeHolderDrawable", "Landroid/graphics/drawable/ColorDrawable;", "P", "Landroid/graphics/drawable/ColorDrawable;", "placeHolderDrawableEmpty", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/List;", "data", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/c;", "currentCategoryDecoration", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", ExifInterface.LATITUDE_SOUTH, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StickerPanelContentAdapter extends AbsWinkMaterialPanelContentAdapter {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String T = "";

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> stickerLoadMoreCallback;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> hotWordClickCallback;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private final Drawable placeHolderDrawable;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final ColorDrawable placeHolderDrawableEmpty;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final List<MetaCategory> data;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.sticker.sticker.c currentCategoryDecoration;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102Jd\u0010\u0014\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eH\u0002J\u00be\u0001\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\u001e\b\u0002\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b2\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001bR\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010!R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010(\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$a;", "", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "fragment", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutDelegate", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "winkEditPerformanceViewModel", "", "tabCateId", "Lkotlin/Function3;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "onStickerApplied", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "c", "Landroid/support/v7/widget/RecyclerView;", "contentRv", "currentText", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editModeSupplier", "Lkotlin/Function2;", "onItemClick", "onContentScrolled", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/q;", "a", "searchText", "Ljava/lang/String;", "getSearchText", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "TAG", "TYPE_EXPRESSION", "I", "TYPE_FAVOR", "TYPE_FAVOR_EMPTY", "TYPE_HOT_WORD_FLOW", "TYPE_MORE_STICKER", "TYPE_NORMAL", "TYPE_SEARCH_EMPTY", "TYPE_SMALL", "TYPE_SUPER", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPanelContentAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$a$b", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPanelContentAdapter$a$b */
        /* loaded from: classes21.dex */
        public static final class b extends RecyclerView.OnScrollListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<GridLayoutManager> f321801d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Function2<String, Integer, Unit> f321802e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f321803f;

            /* JADX WARN: Multi-variable type inference failed */
            b(Ref.ObjectRef<GridLayoutManager> objectRef, Function2<? super String, ? super Integer, Unit> function2, String str) {
                this.f321801d = objectRef;
                this.f321802e = function2;
                this.f321803f = str;
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState == 0) {
                    com.tencent.mobileqq.wink.report.e.f326265a.y();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (dy5 != 0) {
                    int findFirstVisibleItemPosition = this.f321801d.element.findFirstVisibleItemPosition();
                    Function2<String, Integer, Unit> function2 = this.f321802e;
                    if (function2 != null) {
                        function2.invoke(this.f321803f, Integer.valueOf(findFirstVisibleItemPosition));
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$a$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPanelContentAdapter$a$c */
        /* loaded from: classes21.dex */
        public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecyclerView f321804d;

            c(RecyclerView recyclerView) {
                this.f321804d = recyclerView;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                com.tencent.mobileqq.wink.report.e.f326265a.y();
                this.f321804d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }

        @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$a$d", "Lcom/tencent/mobileqq/wink/flow/a;", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "", "F1", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "g", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPanelContentAdapter$a$d */
        /* loaded from: classes21.dex */
        public static final class d extends a {
            final /* synthetic */ WinkEditPerformanceViewModel C;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function3<String, Integer, MetaMaterial, Unit> f321805d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f321806e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ WinkEditorFragment f321807f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ dr f321808h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Context f321809i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ WinkEditorViewModel f321810m;

            /* JADX WARN: Multi-variable type inference failed */
            d(Function3<? super String, ? super Integer, ? super MetaMaterial, Unit> function3, String str, WinkEditorFragment winkEditorFragment, dr drVar, Context context, WinkEditorViewModel winkEditorViewModel, WinkEditPerformanceViewModel winkEditPerformanceViewModel) {
                this.f321805d = function3;
                this.f321806e = str;
                this.f321807f = winkEditorFragment;
                this.f321808h = drVar;
                this.f321809i = context;
                this.f321810m = winkEditorViewModel;
                this.C = winkEditPerformanceViewModel;
            }

            @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
            public void F1(@Nullable ApplyMaterialTask.Status downloadStatus, int position, @NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
                Intrinsics.checkNotNullParameter(material, "material");
                Intrinsics.checkNotNullParameter(callback, "callback");
                if (m.W(material)) {
                    super.F1(downloadStatus, position, material, callback);
                } else if (Intrinsics.areEqual(m.J(material), "qq_emoticon_sticker")) {
                    l.I(material, callback);
                } else {
                    l.K(material, callback);
                }
            }

            @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
            public void g(int position, @NotNull MetaMaterial material) {
                Intrinsics.checkNotNullParameter(material, "material");
                Function3<String, Integer, MetaMaterial, Unit> function3 = this.f321805d;
                if (function3 != null) {
                    function3.invoke(this.f321806e, Integer.valueOf(position), material);
                }
                WinkApplyStickerMaterialTask.INSTANCE.a(material, this.f321807f, this.f321808h, this.f321809i, this.f321810m, this.C, 300);
            }

            @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
            public boolean z(int position, @NotNull MetaMaterial material) {
                Intrinsics.checkNotNullParameter(material, "material");
                return Intrinsics.areEqual(m.J(material), "qq_emoticon_sticker");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ApplyMaterialTask c(WinkEditorFragment fragment, dr tavCutDelegate, Context context, WinkEditorViewModel winkEditorViewModel, WinkEditPerformanceViewModel winkEditPerformanceViewModel, String tabCateId, Function3<? super String, ? super Integer, ? super MetaMaterial, Unit> onStickerApplied) {
            return new d(onStickerApplied, tabCateId, fragment, tavCutDelegate, context, winkEditorViewModel, winkEditPerformanceViewModel);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0, types: [T, com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter, com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPanelContentAdapter] */
        /* JADX WARN: Type inference failed for: r1v5, types: [android.support.v7.widget.GridLayoutManager, T] */
        @NotNull
        public final StickerRvConfig a(@NotNull RecyclerView contentRv, @NotNull String tabCateId, @Nullable WinkEditorFragment fragment, @Nullable dr tavCutDelegate, @NotNull Context context, @Nullable WinkEditorViewModel winkEditorViewModel, @NotNull String currentText, @Nullable WinkEditPerformanceViewModel winkEditPerformanceViewModel, @NotNull Function0<? extends WinkEditorViewModel.EditMode> editModeSupplier, @Nullable Function3<? super String, ? super Integer, ? super MetaMaterial, Unit> onStickerApplied, @Nullable Function2<? super Integer, ? super MetaMaterial, Unit> onItemClick, @Nullable Function2<? super String, ? super Integer, Unit> onContentScrolled) {
            Intrinsics.checkNotNullParameter(contentRv, "contentRv");
            Intrinsics.checkNotNullParameter(tabCateId, "tabCateId");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(currentText, "currentText");
            Intrinsics.checkNotNullParameter(editModeSupplier, "editModeSupplier");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ?? gridLayoutManager = new GridLayoutManager(context, 12);
            objectRef.element = gridLayoutManager;
            contentRv.setLayoutManager((RecyclerView.LayoutManager) gridLayoutManager);
            ?? stickerPanelContentAdapter = new StickerPanelContentAdapter(context, editModeSupplier.invoke(), null, null, 12, null);
            Companion companion = StickerPanelContentAdapter.INSTANCE;
            stickerPanelContentAdapter.S(companion.c(fragment, tavCutDelegate, context, winkEditorViewModel, winkEditPerformanceViewModel, tabCateId, onStickerApplied));
            stickerPanelContentAdapter.V(new C9036a(onItemClick));
            objectRef2.element = stickerPanelContentAdapter;
            contentRv.setAdapter((RecyclerView.Adapter) stickerPanelContentAdapter);
            companion.d(currentText);
            contentRv.addOnScrollListener(new b(objectRef, onContentScrolled, tabCateId));
            contentRv.getViewTreeObserver().addOnGlobalLayoutListener(new c(contentRv));
            return new StickerRvConfig((GridLayoutManager) objectRef.element, (StickerPanelContentAdapter) objectRef2.element);
        }

        public final void d(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            StickerPanelContentAdapter.T = str;
        }

        Companion() {
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$a$a", "Lcom/tencent/mobileqq/wink/view/AbsWinkMaterialPanelContentAdapter$d;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPanelContentAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9036a implements AbsWinkMaterialPanelContentAdapter.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function2<Integer, MetaMaterial, Unit> f321800a;

            /* JADX WARN: Multi-variable type inference failed */
            C9036a(Function2<? super Integer, ? super MetaMaterial, Unit> function2) {
                this.f321800a = function2;
            }

            @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.c
            public void b(int position, @Nullable MetaMaterial material) {
                Function2<Integer, MetaMaterial, Unit> function2 = this.f321800a;
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(position), material);
                }
            }

            @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.d
            public void a(int position, @Nullable MetaMaterial material) {
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Integer) ((Pair) t16).getFirst(), (Integer) ((Pair) t17).getFirst());
            return compareValues;
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$c", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/c;", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "childAdapterPosition", "", "c", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends com.tencent.mobileqq.wink.editor.sticker.sticker.c {
        c(Context context, List<MetaMaterial> list) {
            super(context, list);
            d(com.tencent.videocut.utils.e.f384236a.a(8.0f));
        }

        @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.c
        @Nullable
        public String c(@Nullable RecyclerView parent, int childAdapterPosition) {
            MetaCategory a16 = ac.a(StickerPanelContentAdapter.this.data, childAdapterPosition);
            Pair J0 = StickerPanelContentAdapter.this.J0(childAdapterPosition);
            if (J0 == null) {
                return null;
            }
            boolean booleanValue = ((Boolean) J0.component1()).booleanValue();
            boolean booleanValue2 = ((Boolean) J0.component2()).booleanValue();
            if (!booleanValue || !booleanValue2 || a16 == null) {
                return null;
            }
            return a16.name;
        }

        @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.c, android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
            Pair J0 = StickerPanelContentAdapter.this.J0(((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition());
            if (J0 == null) {
                return;
            }
            boolean booleanValue = ((Boolean) J0.component1()).booleanValue();
            boolean booleanValue2 = ((Boolean) J0.component2()).booleanValue();
            if (booleanValue && booleanValue2) {
                outRect.set(0, this.f321775e, 0, 0);
            } else if (booleanValue) {
                outRect.set(0, this.f321775e, 0, 0);
            } else {
                outRect.set(0, 0, 0, 0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$d", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.ViewHolder {
        d(FrameLayout frameLayout) {
            super(frameLayout);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$e", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends RecyclerView.ViewHolder {
        e(View view) {
            super(view);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$f", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends RecyclerView.ViewHolder {
        f(View view) {
            super(view);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$g", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g extends RecyclerView.ViewHolder {
        g(View view) {
            super(view);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter$h", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h extends RecyclerView.ViewHolder {
        h(View view) {
            super(view);
        }
    }

    public /* synthetic */ StickerPanelContentAdapter(Context context, WinkEditorViewModel.EditMode editMode, Function0 function0, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, editMode, (i3 & 4) != 0 ? null : function0, (i3 & 8) != 0 ? null : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(StickerPanelContentAdapter this$0, String s16, TextView chip, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(s16, "$s");
        Intrinsics.checkNotNullParameter(chip, "$chip");
        Function1<? super String, Unit> function1 = this$0.hotWordClickCallback;
        if (function1 != null) {
            function1.invoke(s16);
        }
        this$0.M0(chip);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(RecyclerView.ViewHolder vh5, final ConstraintLayout this_apply) {
        IntRange until;
        Sequence asSequence;
        Sequence map;
        List list;
        List sortedWith;
        int collectionSizeOrDefault;
        List list2;
        List<View> flatten;
        Intrinsics.checkNotNullParameter(vh5, "$vh");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Flow flow = (Flow) vh5.itemView.findViewById(R.id.f165245vc1);
        until = RangesKt___RangesKt.until(0, this_apply.getChildCount());
        asSequence = CollectionsKt___CollectionsKt.asSequence(until);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<Integer, View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPanelContentAdapter$bindHolder$7$1$childGroups$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final View invoke(int i3) {
                return ConstraintLayout.this.getChildAt(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ View invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : map) {
            Integer valueOf = Integer.valueOf(((View) obj).getBottom());
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        list = MapsKt___MapsKt.toList(linkedHashMap);
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new b());
        List list3 = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add((List) ((Pair) it.next()).getSecond());
        }
        list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        if (list2.size() > 2) {
            flatten = CollectionsKt__IterablesKt.flatten(list2.subList(2, list2.size()));
            for (View view : flatten) {
                if (view instanceof TextView) {
                    this_apply.removeView(view);
                }
            }
        }
        flow.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean C0(StickerPanelContentAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return Boolean.valueOf(!this$0.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(StickerPanelContentAdapter this$0, MetaMaterial material, RecyclerView.ViewHolder vh5, int i3, MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(vh5, "$vh");
        AbsWinkMaterialPanelContentAdapter.d dVar = this$0.H;
        if (dVar != null) {
            dVar.b(i3, metaMaterial);
        }
        this$0.F(i3, metaMaterial);
        if (Intrinsics.areEqual("1000291", com.tencent.mobileqq.wink.editor.c.o(material))) {
            View view = vh5.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
            this$0.K0(view, material);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(MetaMaterial material, StickerPanelContentAdapter this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.wink.editor.c.c1(material)) {
            this$0.F(i3, material);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(StickerPanelContentAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.stickerLoadMoreCallback;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G0(RecyclerView rv5) {
        RecyclerView.ItemDecoration itemDecoration = this.currentCategoryDecoration;
        if (itemDecoration != null) {
            rv5.removeItemDecoration(itemDecoration);
        }
        if (this.data.size() == 1 && !Intrinsics.areEqual(this.data.get(0).f30532id, "1000291")) {
            return;
        }
        c cVar = new c(rv5.getContext(), B());
        this.currentCategoryDecoration = cVar;
        rv5.addItemDecoration(cVar);
    }

    private final void H0(View view, String elementId, Map<String, ? extends Object> extParams, String materialHashcode) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementReuseIdentifier(view, materialHashcode);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        map.putAll(extParams);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        VideoReport.setElementParams(view, map);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private final Pair<Integer, Integer> I0(int position) {
        int itemViewType = getItemViewType(position);
        int i3 = 4;
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                if (itemViewType != 2 && itemViewType != 3 && (itemViewType == 4 || (itemViewType != 10 && (itemViewType == 20 || itemViewType == 30 || itemViewType == 40)))) {
                    i3 = 1;
                }
            } else {
                i3 = 6;
            }
        }
        return new Pair<>(Integer.valueOf(itemViewType), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Boolean, Boolean> J0(int childAdapterPosition) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        int d16 = ac.d(this.data, childAdapterPosition);
        MetaCategory a16 = ac.a(this.data, childAdapterPosition);
        if (a16 != null && d16 != -1) {
            String str = a16.name;
            boolean z18 = true;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        int intValue = I0(childAdapterPosition).component2().intValue();
                        if (d16 >= 0 && d16 < intValue) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (d16 % intValue != 0) {
                            z18 = false;
                        }
                        return TuplesKt.to(Boolean.valueOf(z17), Boolean.valueOf(z18));
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        w53.b.c("StickerPanelContentAdapter", "needDrawCategoryName invalid index: " + childAdapterPosition + " " + a16 + " " + d16);
        return null;
    }

    private final void K0(View view, MetaMaterial material) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, material.f30533id);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_CATEGORY, "\u70ed\u95e8\u8d34\u7eb8");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_XSJ_HOT_PASTE, params, null, 8, null);
    }

    private final void L0(View view, MetaMaterial material) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, material.f30533id);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_CATEGORY, "\u70ed\u95e8\u8d34\u7eb8");
        VideoReport.setElementParams(view, params);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_HOT_PASTE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    private final void M0(TextView view) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_query_text", view.getText());
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_HOT_KEYWORD, params, null, 8, null);
    }

    private final void N0(TextView view) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_query_text", view.getText());
        VideoReport.setElementParams(view, params);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_HOT_KEYWORD);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    private final void O0(View view, MetaMaterial material) {
        boolean z16;
        String str;
        HashMap hashMap = new HashMap();
        String str2 = material.f30533id;
        Intrinsics.checkNotNullExpressionValue(str2, "material.id");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, str2);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(material));
        if (!Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(material), "SEARCH_STICKER") && !Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(material), "SEARCH_EXPRESSION")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_FROM_SEARCH, str);
        H0(view, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_ITEM, hashMap, String.valueOf(material.hashCode()));
    }

    private final void P0(View view, String currentText) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_query_text", currentText);
        VideoReport.setElementParams(view, params);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_NO_SEARCH_RESULT_CARD);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(RecyclerView.ViewHolder vh5, final StickerPanelContentAdapter this$0) {
        Intrinsics.checkNotNullParameter(vh5, "$vh");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final TextView textView = (TextView) vh5.itemView.findViewById(R.id.f80584bv);
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.o
                @Override // java.lang.Runnable
                public final void run() {
                    StickerPanelContentAdapter.x0(StickerPanelContentAdapter.this, textView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(StickerPanelContentAdapter this$0, TextView it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.P0(it, T);
        com.tencent.mobileqq.wink.report.e.f326265a.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(final TextView chip, final StickerPanelContentAdapter this$0) {
        Intrinsics.checkNotNullParameter(chip, "$chip");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        chip.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.p
            @Override // java.lang.Runnable
            public final void run() {
                StickerPanelContentAdapter.z0(StickerPanelContentAdapter.this, chip);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(StickerPanelContentAdapter this$0, TextView chip) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chip, "$chip");
        this$0.N0(chip);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void Q0(@NotNull List<MetaCategory> newData, @NotNull RecyclerView rv5) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        Intrinsics.checkNotNullParameter(rv5, "rv");
        this.data.clear();
        this.data.addAll(newData);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = newData.iterator();
        while (it.hasNext()) {
            ArrayList<MetaMaterial> arrayList2 = ((MetaCategory) it.next()).materials;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "it.materials");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        Y(arrayList);
        G0(rv5);
        notifyDataSetChanged();
    }

    public final void R0(@Nullable Function1<? super String, Unit> function1) {
        this.hotWordClickCallback = function1;
    }

    public final void S0(@Nullable Function0<Unit> function0) {
        this.stickerLoadMoreCallback = function0;
    }

    public final void T0(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        T = text;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        String str;
        String b16 = ac.b(this.data, position);
        if (b16 == null) {
            return 0;
        }
        switch (b16.hashCode()) {
            case -1848329470:
                if (!b16.equals("sticker_search_empty_id")) {
                    return 0;
                }
                return 40;
            case -1703872986:
                if (!b16.equals("qq_small_sticker")) {
                    return 0;
                }
                return 1;
            case -1507237489:
                if (!b16.equals("SEARCH_EXPRESSION")) {
                    return 0;
                }
                return 10;
            case -1174112807:
                if (!b16.equals("qq_favorite_sticker")) {
                    return 0;
                }
                MetaMaterial e16 = ac.e(this.data, position);
                if (e16 != null) {
                    str = e16.f30533id;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "qq_favor_empty_id")) {
                    return 4;
                }
                return 2;
            case 314404230:
                b16.equals("SEARCH_STICKER");
                return 0;
            case 404657443:
                if (!b16.equals("search_load_more_id")) {
                    return 0;
                }
                return 30;
            case 1448635110:
                if (!b16.equals("100029")) {
                    return 0;
                }
                return 3;
            case 1958015498:
                if (!b16.equals("1000290")) {
                    return 0;
                }
                return 20;
            default:
                return 0;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1 && viewType != 2) {
                if (viewType != 3) {
                    if (viewType != 4) {
                        if (viewType != 10) {
                            if (viewType != 20) {
                                if (viewType != 30) {
                                    if (viewType == 40) {
                                        return new h(LayoutInflater.from(parent.getContext()).inflate(R.layout.hfb, parent, false));
                                    }
                                    throw new RuntimeException("unknown type");
                                }
                                return new f(LayoutInflater.from(parent.getContext()).inflate(R.layout.hfc, parent, false));
                            }
                            return new g(LayoutInflater.from(parent.getContext()).inflate(R.layout.hdy, parent, false));
                        }
                    } else {
                        return new e(LayoutInflater.from(parent.getContext()).inflate(R.layout.hf_, parent, false));
                    }
                }
            }
            d dVar = new d(new FrameLayout(parent.getContext()));
            dVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            View view = dVar.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).addView(imageView);
            return dVar;
        }
        ab.a aVar = new ab.a(LayoutInflater.from(parent.getContext()).inflate(R.layout.hfa, parent, false));
        aVar.g();
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0240, code lost:
    
        if (r13 != 10) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02ac  */
    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected <T extends RecyclerView.ViewHolder> void x(@NotNull final T vh5, final int position, @NotNull final MetaMaterial material) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        ApplyMaterialTask applyMaterialTask;
        int i19;
        String joinToString$default;
        List take;
        int collectionSizeOrDefault;
        int[] intArray;
        String take2;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        Intrinsics.checkNotNullParameter(material, "material");
        Pair<Integer, Integer> I0 = I0(position);
        int intValue = I0.component1().intValue();
        I0.component2().intValue();
        int d16 = ac.d(this.data, position);
        if (ac.a(this.data, position) != null && d16 != -1) {
            if (intValue != 0) {
                if (intValue != 1 && intValue != 2) {
                    if (intValue == 3) {
                        i3 = intValue;
                        z16 = false;
                    } else if (intValue != 10) {
                        if (intValue == 20) {
                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(m.v(material), null, null, null, 0, null, null, 63, null);
                            if (!Intrinsics.areEqual(vh5.itemView.getTag(), joinToString$default)) {
                                View view = vh5.itemView;
                                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                Flow flow = (Flow) vh5.itemView.findViewById(R.id.f165245vc1);
                                int childCount = constraintLayout.getChildCount();
                                while (childCount != 1) {
                                    View childAt = constraintLayout.getChildAt(0);
                                    if (childAt != flow) {
                                        constraintLayout.removeView(childAt);
                                    }
                                }
                                take = CollectionsKt___CollectionsKt.take(m.v(material), 24);
                                List list = take;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                Iterator it = list.iterator();
                                int i26 = 0;
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    int i27 = i26 + 1;
                                    if (i26 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final String str = (String) next;
                                    final TextView textView = new TextView(vh5.itemView.getContext());
                                    textView.setLayoutParams(new ConstraintLayout.LayoutParams(-2, ViewExKt.d(28)));
                                    take2 = StringsKt___StringsKt.take(str, 8);
                                    textView.setText(take2);
                                    textView.setPadding(ViewExKt.d(10), ViewExKt.d(0), ViewExKt.d(10), ViewExKt.d(0));
                                    textView.setGravity(17);
                                    textView.setId(View.generateViewId());
                                    textView.setTextColor(-1);
                                    textView.setBackground(ContextCompat.getDrawable(constraintLayout.getContext(), R.drawable.l5c));
                                    textView.setTextSize(14.0f);
                                    constraintLayout.addView(textView);
                                    constraintLayout.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.l
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            StickerPanelContentAdapter.y0(textView, this);
                                        }
                                    });
                                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.m
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view2) {
                                            StickerPanelContentAdapter.A0(StickerPanelContentAdapter.this, str, textView, view2);
                                        }
                                    });
                                    arrayList.add(Integer.valueOf(textView.getId()));
                                    i26 = i27;
                                    it = it;
                                    intValue = intValue;
                                }
                                i19 = intValue;
                                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
                                flow.setReferencedIds(intArray);
                                vh5.itemView.setTag(joinToString$default);
                                View view2 = vh5.itemView;
                                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                                final ConstraintLayout constraintLayout2 = (ConstraintLayout) view2;
                                constraintLayout2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.n
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        StickerPanelContentAdapter.B0(RecyclerView.ViewHolder.this, constraintLayout2);
                                    }
                                });
                                i16 = i19;
                                i17 = 1;
                                i18 = 2;
                                com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
                                int a16 = eVar.a(12.0f);
                                ViewGroup.LayoutParams layoutParams = vh5.itemView.getLayoutParams();
                                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                                if (i16 != 0) {
                                    if (i16 == i17) {
                                        int g16 = (o.g() - (a16 * i18)) / 6;
                                        int a17 = eVar.a(9.0f);
                                        vh5.itemView.setPadding(a17, a17, a17, a17);
                                        ((ViewGroup.MarginLayoutParams) layoutParams2).width = g16;
                                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = g16;
                                    } else if (i16 == i18) {
                                        int g17 = (o.g() - (a16 * i18)) / 4;
                                        int a18 = eVar.a(8.0f);
                                        vh5.itemView.setPadding(a18, a18, a18, a18);
                                        ((ViewGroup.MarginLayoutParams) layoutParams2).width = g17;
                                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = g17;
                                    } else if (i16 != 3) {
                                        if (i16 == 4) {
                                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = eVar.a(100.0f);
                                        }
                                    }
                                    ac.d(this.data, position);
                                    View view3 = vh5.itemView;
                                    Intrinsics.checkNotNullExpressionValue(view3, "vh.itemView");
                                    O0(view3, material);
                                    if (Intrinsics.areEqual("1000291", com.tencent.mobileqq.wink.editor.c.o(material))) {
                                        View view4 = vh5.itemView;
                                        Intrinsics.checkNotNullExpressionValue(view4, "vh.itemView");
                                        L0(view4, material);
                                    }
                                    com.tencent.mobileqq.wink.report.e.f326265a.y();
                                    return;
                                }
                                int g18 = (o.g() - (a16 * i18)) / 4;
                                int a19 = eVar.a(8.0f);
                                vh5.itemView.setPadding(a19, a19, a19, a19);
                                ((ViewGroup.MarginLayoutParams) layoutParams2).width = g18;
                                ((ViewGroup.MarginLayoutParams) layoutParams2).height = g18;
                                ac.d(this.data, position);
                                View view32 = vh5.itemView;
                                Intrinsics.checkNotNullExpressionValue(view32, "vh.itemView");
                                O0(view32, material);
                                if (Intrinsics.areEqual("1000291", com.tencent.mobileqq.wink.editor.c.o(material))) {
                                }
                                com.tencent.mobileqq.wink.report.e.f326265a.y();
                                return;
                            }
                        } else if (intValue == 30) {
                            vh5.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.j
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view5) {
                                    StickerPanelContentAdapter.F0(StickerPanelContentAdapter.this, view5);
                                }
                            });
                        } else if (intValue == 40) {
                            vh5.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.k
                                @Override // java.lang.Runnable
                                public final void run() {
                                    StickerPanelContentAdapter.w0(RecyclerView.ViewHolder.this, this);
                                }
                            });
                        }
                        i17 = 1;
                        i18 = 2;
                        i16 = intValue;
                        com.tencent.videocut.utils.e eVar2 = com.tencent.videocut.utils.e.f384236a;
                        int a162 = eVar2.a(12.0f);
                        ViewGroup.LayoutParams layoutParams3 = vh5.itemView.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                        RecyclerView.LayoutParams layoutParams22 = (RecyclerView.LayoutParams) layoutParams3;
                        if (i16 != 0) {
                        }
                        int g182 = (o.g() - (a162 * i18)) / 4;
                        int a192 = eVar2.a(8.0f);
                        vh5.itemView.setPadding(a192, a192, a192, a192);
                        ((ViewGroup.MarginLayoutParams) layoutParams22).width = g182;
                        ((ViewGroup.MarginLayoutParams) layoutParams22).height = g182;
                        ac.d(this.data, position);
                        View view322 = vh5.itemView;
                        Intrinsics.checkNotNullExpressionValue(view322, "vh.itemView");
                        O0(view322, material);
                        if (Intrinsics.areEqual("1000291", com.tencent.mobileqq.wink.editor.c.o(material))) {
                        }
                        com.tencent.mobileqq.wink.report.e.f326265a.y();
                        return;
                    }
                }
                i19 = intValue;
                View view5 = vh5.itemView;
                Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt2 = ((ViewGroup) view5).getChildAt(0);
                Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
                ViewUtilsKt.l((ImageView) childAt2, material.thumbUrl, material, WinkEditorViewModel.EditMode.Video, com.tencent.mobileqq.wink.editor.c.c1(material) ? this.placeHolderDrawableEmpty : this.placeHolderDrawable);
                vh5.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view6) {
                        StickerPanelContentAdapter.E0(MetaMaterial.this, this, position, view6);
                    }
                });
                i16 = i19;
                i17 = 1;
                i18 = 2;
                com.tencent.videocut.utils.e eVar22 = com.tencent.videocut.utils.e.f384236a;
                int a1622 = eVar22.a(12.0f);
                ViewGroup.LayoutParams layoutParams32 = vh5.itemView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams32, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                RecyclerView.LayoutParams layoutParams222 = (RecyclerView.LayoutParams) layoutParams32;
                if (i16 != 0) {
                }
                int g1822 = (o.g() - (a1622 * i18)) / 4;
                int a1922 = eVar22.a(8.0f);
                vh5.itemView.setPadding(a1922, a1922, a1922, a1922);
                ((ViewGroup.MarginLayoutParams) layoutParams222).width = g1822;
                ((ViewGroup.MarginLayoutParams) layoutParams222).height = g1822;
                ac.d(this.data, position);
                View view3222 = vh5.itemView;
                Intrinsics.checkNotNullExpressionValue(view3222, "vh.itemView");
                O0(view3222, material);
                if (Intrinsics.areEqual("1000291", com.tencent.mobileqq.wink.editor.c.o(material))) {
                }
                com.tencent.mobileqq.wink.report.e.f326265a.y();
                return;
            }
            z16 = false;
            i3 = intValue;
            ab.a aVar = (ab.a) vh5;
            i16 = i3;
            i17 = 1;
            i18 = 2;
            aVar.f(material, position, D(), this.F, (i16 == 1 || i16 == 2 || ((applyMaterialTask = this.G) != null && applyMaterialTask.z(position, material))) ? true : z16, new Supplier() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.g
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Boolean C0;
                    C0 = StickerPanelContentAdapter.C0(StickerPanelContentAdapter.this);
                    return C0;
                }
            }, new AbsWinkMaterialPanelContentAdapter.c() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.h
                @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.c
                public final void b(int i28, MetaMaterial metaMaterial) {
                    StickerPanelContentAdapter.D0(StickerPanelContentAdapter.this, material, vh5, i28, metaMaterial);
                }
            });
            aVar.f326924f.setVisibility(8);
            com.tencent.videocut.utils.e eVar222 = com.tencent.videocut.utils.e.f384236a;
            int a16222 = eVar222.a(12.0f);
            ViewGroup.LayoutParams layoutParams322 = vh5.itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams322, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams layoutParams2222 = (RecyclerView.LayoutParams) layoutParams322;
            if (i16 != 0) {
            }
            int g18222 = (o.g() - (a16222 * i18)) / 4;
            int a19222 = eVar222.a(8.0f);
            vh5.itemView.setPadding(a19222, a19222, a19222, a19222);
            ((ViewGroup.MarginLayoutParams) layoutParams2222).width = g18222;
            ((ViewGroup.MarginLayoutParams) layoutParams2222).height = g18222;
            ac.d(this.data, position);
            View view32222 = vh5.itemView;
            Intrinsics.checkNotNullExpressionValue(view32222, "vh.itemView");
            O0(view32222, material);
            if (Intrinsics.areEqual("1000291", com.tencent.mobileqq.wink.editor.c.o(material))) {
            }
            com.tencent.mobileqq.wink.report.e.f326265a.y();
            return;
        }
        w53.b.c("StickerPanelContentAdapter", "invalid index: " + position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPanelContentAdapter(@NotNull Context context, @NotNull WinkEditorViewModel.EditMode editMode, @Nullable Function0<Unit> function0, @Nullable Function1<? super String, Unit> function1) {
        super(context, editMode);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        this.stickerLoadMoreCallback = function0;
        this.hotWordClickCallback = function1;
        Z(false);
        U(true);
        this.placeHolderDrawable = ContextCompat.getDrawable(context, R.drawable.f162009l51);
        this.placeHolderDrawableEmpty = new ColorDrawable(0);
        this.data = new ArrayList();
    }
}
