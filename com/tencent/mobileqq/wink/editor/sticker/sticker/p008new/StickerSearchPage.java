package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.StickerPanelContentAdapter;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.utils.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;
import tl.h;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u0012\b\u0010.\u001a\u0004\u0018\u00010+\u0012\u0006\u00101\u001a\u00020\n\u0012\u0006\u00103\u001a\u00020'\u0012<\b\u0002\u0010=\u001a6\u0012\u0013\u0012\u001105\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u000109\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0002\u0018\u000104\u00a2\u0006\u0004\bh\u0010iJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010)RH\u0010=\u001a6\u0012\u0013\u0012\u001105\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u000109\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0002\u0018\u0001048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010D\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010?\u001a\u0004\bC\u0010AR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010?\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010?\u001a\u0004\bL\u0010MR\u001b\u0010Q\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010?\u001a\u0004\bP\u0010HR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010?\u001a\u0004\bT\u0010UR\u001b\u0010Y\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010?\u001a\u0004\bX\u0010AR\u001b\u0010[\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010?\u001a\u0004\bZ\u0010AR\u001b\u0010_\u001a\u00020\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010?\u001a\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001b\u0010g\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010?\u001a\u0004\bd\u0010A\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerSearchPage;", "", "", "K", "", "open", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "r", "D", "Landroid/view/View;", "searchBarBg", "L", "I", "anim", "M", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/a;", "data", ReportConstant.COSTREPORT_PREFIX, "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "c", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "fragment", "Lcom/tencent/mobileqq/wink/editor/dr;", "d", "Lcom/tencent/mobileqq/wink/editor/dr;", "winkTavCutDelegate", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "e", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;", "f", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;", "stickerViewModel", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "g", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "winkEditPerformanceViewModel", h.F, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "i", "viewModel", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "j", "Lkotlin/jvm/functions/Function2;", "onItemClick", "k", "Lkotlin/Lazy;", "v", "()Landroid/view/View;", "l", "y", "searchClickArea", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/ImageView;", "searchIcon", "Landroid/widget/EditText;", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Landroid/widget/EditText;", "searchInput", "o", HippyTKDListViewAdapter.X, "searchClear", "Landroid/widget/TextView;", "p", "w", "()Landroid/widget/TextView;", "searchCancel", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, BdhLogUtil.LogTag.Tag_Conn, "topTabContainer", "B", "searchPage", "Landroid/support/v7/widget/RecyclerView;", "t", "()Landroid/support/v7/widget/RecyclerView;", "contentRv", "Landroid/support/v7/widget/GridLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "contentLayoutManager", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "u", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "contentAdapter", "loadingLayer", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;Lcom/tencent/mobileqq/wink/editor/dr;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;Landroid/view/View;Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;Lkotlin/jvm/functions/Function2;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StickerSearchPage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final CoroutineScope coroutineScope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WinkEditorFragment fragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final dr winkTavCutDelegate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorViewModel winkEditorViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorStickerViewModel stickerViewModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WinkEditPerformanceViewModel winkEditPerformanceViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorStickerViewModel viewModel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function2<Integer, MetaMaterial, Unit> onItemClick;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchBarBg;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchClickArea;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchIcon;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchInput;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchClear;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchCancel;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topTabContainer;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchPage;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentRv;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private GridLayoutManager contentLayoutManager;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private StickerPanelContentAdapter contentAdapter;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingLayer;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerSearchPage$a", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@Nullable RecyclerView recyclerView, int newState) {
            if (newState == 1) {
                j.f384247a.a(StickerSearchPage.this.A());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerSearchPage$b", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "", com.tencent.luggage.wxa.c8.c.G, "getSpanSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StickerListData f321835a;

        b(StickerListData stickerListData) {
            this.f321835a = stickerListData;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int pos) {
            int hashCode;
            String e16 = this.f321835a.e(pos);
            if (e16 != null && ((hashCode = e16.hashCode()) == -1848329470 ? e16.equals("sticker_search_empty_id") : hashCode == 404657443 ? e16.equals("search_load_more_id") : hashCode == 1958015498 && e16.equals("1000290"))) {
                return 12;
            }
            return 3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerSearchPage(@NotNull LifecycleOwner lifecycleOwner, @Nullable CoroutineScope coroutineScope, @Nullable WinkEditorFragment winkEditorFragment, @Nullable dr drVar, @NotNull WinkEditorViewModel winkEditorViewModel, @NotNull WinkEditorStickerViewModel stickerViewModel, @Nullable WinkEditPerformanceViewModel winkEditPerformanceViewModel, @NotNull View rootView, @NotNull WinkEditorStickerViewModel viewModel, @Nullable Function2<? super Integer, ? super MetaMaterial, Unit> function2) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "winkEditorViewModel");
        Intrinsics.checkNotNullParameter(stickerViewModel, "stickerViewModel");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.lifecycleOwner = lifecycleOwner;
        this.coroutineScope = coroutineScope;
        this.fragment = winkEditorFragment;
        this.winkTavCutDelegate = drVar;
        this.winkEditorViewModel = winkEditorViewModel;
        this.stickerViewModel = stickerViewModel;
        this.winkEditPerformanceViewModel = winkEditPerformanceViewModel;
        this.rootView = rootView;
        this.viewModel = viewModel;
        this.onItemClick = function2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$searchBarBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return view.findViewById(R.id.f80524bp);
            }
        });
        this.searchBarBg = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$searchClickArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return view.findViewById(R.id.f80564bt);
            }
        });
        this.searchClickArea = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$searchIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return (ImageView) view.findViewById(R.id.f80604bx);
            }
        });
        this.searchIcon = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$searchInput$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return (EditText) view.findViewById(R.id.f80614by);
            }
        });
        this.searchInput = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$searchClear$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return (ImageView) view.findViewById(R.id.f80554bs);
            }
        });
        this.searchClear = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$searchCancel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return (TextView) view.findViewById(R.id.f80544br);
            }
        });
        this.searchCancel = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$topTabContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return view.findViewById(R.id.f99665qe);
            }
        });
        this.topTabContainer = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$searchPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                view = StickerSearchPage.this.rootView;
                return LayoutInflater.from(view.getContext()).inflate(R.layout.f168934he0, (ViewGroup) null);
            }
        });
        this.searchPage = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$contentRv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                View B;
                B = StickerSearchPage.this.B();
                return (RecyclerView) B.findViewById(R.id.u7w);
            }
        });
        this.contentRv = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$loadingLayer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View B;
                View B2;
                B = StickerSearchPage.this.B();
                View findViewById = B.findViewById(R.id.ys8);
                B2 = StickerSearchPage.this.B();
                VasPagImageView vasPagImageView = (VasPagImageView) B2.findViewById(R.id.f219902i);
                vasPagImageView.api().build();
                IVasPagViewApi<PAGImageView> api = vasPagImageView.api();
                final StickerSearchPage stickerSearchPage = StickerSearchPage.this;
                api.postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$loadingLayer$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                        invoke2(pAGImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PAGImageView it) {
                        View B3;
                        Intrinsics.checkNotNullParameter(it, "it");
                        B3 = StickerSearchPage.this.B();
                        PAGFile Load = PagViewMonitor.Load(B3.getContext().getAssets(), "wink/pag/editor_loading_img_wezone.pag");
                        if (Load != null) {
                            it.setComposition(Load);
                            it.setRepeatCount(0);
                            it.play();
                        }
                    }
                });
                return findViewById;
            }
        });
        this.loadingLayer = lazy10;
        D();
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText A() {
        Object value = this.searchInput.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchInput>(...)");
        return (EditText) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View B() {
        Object value = this.searchPage.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchPage>(...)");
        return (View) value;
    }

    private final View C() {
        Object value = this.topTabContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-topTabContainer>(...)");
        return (View) value;
    }

    private final void D() {
        y().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerSearchPage.E(StickerSearchPage.this, view);
            }
        });
        x().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerSearchPage.F(StickerSearchPage.this, view);
            }
        });
        w().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerSearchPage.G(StickerSearchPage.this, view);
            }
        });
        A().setHintTextColor(A().getContext().getColor(R.color.alb));
        A().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.v
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean H;
                H = StickerSearchPage.H(StickerSearchPage.this, textView, i3, keyEvent);
                return H;
            }
        });
        A().addTextChangedListener(new c());
        M(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(StickerSearchPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewModel.w2();
        this$0.L(this$0.v());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(StickerSearchPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewModel.h2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(StickerSearchPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewModel.g2(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(StickerSearchPage this$0, TextView textView, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.contentAdapter == null) {
            return false;
        }
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
            return false;
        }
        this$0.viewModel.C2(textView.getText().toString());
        this$0.viewModel.E2(textView.getText().toString());
        StickerPanelContentAdapter stickerPanelContentAdapter = this$0.contentAdapter;
        if (stickerPanelContentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            stickerPanelContentAdapter = null;
        }
        stickerPanelContentAdapter.T0(this$0.viewModel.getCurrentText());
        this$0.viewModel.A2(true, textView.getText().toString());
        return true;
    }

    private final void I() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StickerSearchPage$initViewModel$1(this, null), 3, null);
        }
        LiveData<StickerListData> q26 = this.viewModel.q2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<StickerListData, Unit> function1 = new Function1<StickerListData, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StickerListData stickerListData) {
                invoke2(stickerListData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StickerListData it) {
                View u16;
                u16 = StickerSearchPage.this.u();
                u16.setVisibility(8);
                StickerSearchPage stickerSearchPage = StickerSearchPage.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                stickerSearchPage.s(it);
            }
        };
        q26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StickerSearchPage.J(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L(View searchBarBg) {
        e.k(e.f326265a, searchBarBg, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_SEARCH_BOX, WinkDTParamBuilder.buildElementParams(), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(boolean open, boolean anim) {
        int i3;
        int i16;
        int d16;
        int i17 = 0;
        if (anim) {
            ViewParent parent = v().getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setOrdering(0);
            autoTransition.setInterpolator((TimeInterpolator) new AccelerateDecelerateInterpolator());
            TransitionManager.beginDelayedTransition((ViewGroup) parent, autoTransition);
        }
        View C = C();
        int i18 = 8;
        if (open) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        C.setVisibility(i3);
        TextView w3 = w();
        if (open) {
            i18 = 0;
        }
        w3.setVisibility(i18);
        ViewGroup.LayoutParams layoutParams = v().getLayoutParams();
        if (!open) {
            i16 = ViewExKt.d(178);
        } else {
            i16 = 0;
        }
        layoutParams.width = i16;
        ViewGroup.LayoutParams layoutParams2 = A().getLayoutParams();
        if (!open) {
            i17 = -2;
        }
        layoutParams2.width = i17;
        ViewGroup.LayoutParams layoutParams3 = z().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (!open) {
            d16 = ViewExKt.d(-2);
        } else {
            d16 = ViewExKt.d(12);
        }
        marginLayoutParams.leftMargin = d16;
        y().setClickable(!open);
        A().setEnabled(open);
        if (open) {
            j.f384247a.b(A());
        } else {
            A().setText("");
            j.f384247a.a(A());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(StickerListData data) {
        StickerRvConfig a16;
        GridLayoutManager gridLayoutManager = null;
        if (this.contentAdapter == null) {
            StickerPanelContentAdapter.Companion companion = StickerPanelContentAdapter.INSTANCE;
            RecyclerView t16 = t();
            String str = data.getTabType().f30532id;
            Intrinsics.checkNotNullExpressionValue(str, "data.tabType.id");
            WinkEditorFragment winkEditorFragment = this.fragment;
            dr drVar = this.winkTavCutDelegate;
            Context context = t().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "contentRv.context");
            a16 = companion.a(t16, str, winkEditorFragment, drVar, context, this.winkEditorViewModel, this.viewModel.getCurrentText(), this.winkEditPerformanceViewModel, new Function0<WinkEditorViewModel.EditMode>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$fillData$config$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final WinkEditorViewModel.EditMode invoke() {
                    return WinkEditorViewModel.EditMode.Video;
                }
            }, (r29 & 512) != 0 ? null : new Function3<String, Integer, MetaMaterial, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$fillData$config$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(String str2, Integer num, MetaMaterial metaMaterial) {
                    invoke(str2, num.intValue(), metaMaterial);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String tabCateId, int i3, @NotNull MetaMaterial material) {
                    WinkEditorStickerViewModel winkEditorStickerViewModel;
                    Intrinsics.checkNotNullParameter(tabCateId, "tabCateId");
                    Intrinsics.checkNotNullParameter(material, "material");
                    winkEditorStickerViewModel = StickerSearchPage.this.stickerViewModel;
                    winkEditorStickerViewModel.r2(tabCateId, i3, material);
                }
            }, (r29 & 1024) != 0 ? null : new Function2<Integer, MetaMaterial, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$fillData$config$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MetaMaterial metaMaterial) {
                    invoke(num.intValue(), metaMaterial);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @Nullable MetaMaterial metaMaterial) {
                    Function2 function2;
                    function2 = StickerSearchPage.this.onItemClick;
                    if (function2 != null) {
                        function2.invoke(Integer.valueOf(i3), metaMaterial);
                    }
                }
            }, (r29 & 2048) != 0 ? null : null);
            this.contentLayoutManager = a16.getContentLayoutManager();
            StickerPanelContentAdapter contentAdapter = a16.getContentAdapter();
            this.contentAdapter = contentAdapter;
            if (contentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                contentAdapter = null;
            }
            contentAdapter.S0(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$fillData$2
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
                    WinkEditorStickerViewModel winkEditorStickerViewModel;
                    winkEditorStickerViewModel = StickerSearchPage.this.viewModel;
                    winkEditorStickerViewModel.D2();
                }
            });
            StickerPanelContentAdapter stickerPanelContentAdapter = this.contentAdapter;
            if (stickerPanelContentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                stickerPanelContentAdapter = null;
            }
            stickerPanelContentAdapter.R0(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$fillData$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    WinkEditorStickerViewModel winkEditorStickerViewModel;
                    WinkEditorStickerViewModel winkEditorStickerViewModel2;
                    WinkEditorStickerViewModel winkEditorStickerViewModel3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    StickerSearchPage.this.A().setText(it);
                    StickerSearchPage.this.A().setSelection(it.length());
                    winkEditorStickerViewModel = StickerSearchPage.this.viewModel;
                    winkEditorStickerViewModel.C2(it);
                    winkEditorStickerViewModel2 = StickerSearchPage.this.viewModel;
                    winkEditorStickerViewModel2.E2(it);
                    winkEditorStickerViewModel3 = StickerSearchPage.this.viewModel;
                    winkEditorStickerViewModel3.A2(false, it);
                }
            });
            t().addOnScrollListener(new a());
        }
        StickerPanelContentAdapter stickerPanelContentAdapter2 = this.contentAdapter;
        if (stickerPanelContentAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            stickerPanelContentAdapter2 = null;
        }
        stickerPanelContentAdapter2.Q0(data.j(), t());
        GridLayoutManager gridLayoutManager2 = this.contentLayoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayoutManager");
        } else {
            gridLayoutManager = gridLayoutManager2;
        }
        gridLayoutManager.setSpanSizeLookup(new b(data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView t() {
        Object value = this.contentRv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentRv>(...)");
        return (RecyclerView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View u() {
        Object value = this.loadingLayer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingLayer>(...)");
        return (View) value;
    }

    private final View v() {
        Object value = this.searchBarBg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchBarBg>(...)");
        return (View) value;
    }

    private final TextView w() {
        Object value = this.searchCancel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchCancel>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView x() {
        Object value = this.searchClear.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchClear>(...)");
        return (ImageView) value;
    }

    private final View y() {
        Object value = this.searchClickArea.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchClickArea>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView z() {
        Object value = this.searchIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchIcon>(...)");
        return (ImageView) value;
    }

    public final void K() {
        j.f384247a.a(A());
        this.viewModel.v2();
    }

    public final void r(boolean open, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (open) {
            container.addView(B());
        } else {
            container.removeView(B());
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerSearchPage$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            String str;
            boolean z16;
            int i3;
            if (s16 != null) {
                str = s16.toString();
            } else {
                str = null;
            }
            int i16 = 0;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            ImageView z17 = StickerSearchPage.this.z();
            if (z16) {
                i3 = R.drawable.f162059or0;
            } else {
                i3 = R.drawable.f162071os1;
            }
            z17.setImageResource(i3);
            ImageView x16 = StickerSearchPage.this.x();
            if (z16) {
                i16 = 8;
            }
            x16.setVisibility(i16);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
