package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumSettingFragment;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.WinkMemoryAlbumScrollHelper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkAlbumDataViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u0001:\u0002BCB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/part/MemoryAlbumPreviewPart;", "Lp53/b;", "", "O9", "J9", "", "isLoadFinished", "Q9", "", "size", "P9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "N9", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lia3/c;", "e", "Lia3/c;", "adapter", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "f", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/a;", h.F, "H9", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/a;", "memoryAlbumPreviewViewModel", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "i", "G9", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "albumDataViewModel", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "setting", BdhLogUtil.LogTag.Tag_Conn, "close", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "title", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/WinkMemoryAlbumScrollHelper;", "E", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/WinkMemoryAlbumScrollHelper;", "scrollHelper", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "reportHelper", "<init>", "()V", "G", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MemoryAlbumPreviewPart extends p53.b {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView close;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView title;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WinkMemoryAlbumScrollHelper scrollHelper;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a reportHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ia3.c adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy memoryAlbumPreviewViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy albumDataViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView setting;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/part/MemoryAlbumPreviewPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            w83.b bVar = w83.b.f445025a;
            if (!bVar.M() && !bVar.N()) {
                outRect.bottom = ImmersiveUtils.dpToPx(20.5f);
                return;
            }
            if (parent.getChildLayoutPosition(view) % 2 == 0) {
                outRect.top = ImmersiveUtils.dpToPx(6.0f);
                outRect.bottom = ImmersiveUtils.dpToPx(6.0f);
                outRect.left = ImmersiveUtils.dpToPx(20.0f);
                outRect.right = ImmersiveUtils.dpToPx(6.0f);
                return;
            }
            outRect.top = ImmersiveUtils.dpToPx(6.0f);
            outRect.bottom = ImmersiveUtils.dpToPx(6.0f);
            outRect.left = ImmersiveUtils.dpToPx(6.0f);
            outRect.right = ImmersiveUtils.dpToPx(20.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/part/MemoryAlbumPreviewPart$c", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {
        c() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            ia3.c cVar = MemoryAlbumPreviewPart.this.adapter;
            Intrinsics.checkNotNull(cVar);
            if (position != cVar.getItemCount() - 1) {
                return 1;
            }
            return 2;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/part/MemoryAlbumPreviewPart$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                e.f326265a.y();
            }
        }
    }

    public MemoryAlbumPreviewPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumPreviewPart$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                Fragment hostFragment = MemoryAlbumPreviewPart.this.getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                return new WinkMediaPickerNextStepHelper(q.e(hostFragment));
            }
        });
        this.nextStepHelper = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumPreviewPart$memoryAlbumPreviewViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a invoke() {
                return (com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a) MemoryAlbumPreviewPart.this.getViewModel(com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a.class);
            }
        });
        this.memoryAlbumPreviewViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAlbumDataViewModel>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumPreviewPart$albumDataViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAlbumDataViewModel invoke() {
                return (WinkAlbumDataViewModel) MemoryAlbumPreviewPart.this.getViewModel(WinkAlbumDataViewModel.class);
            }
        });
        this.albumDataViewModel = lazy3;
        this.reportHelper = new com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAlbumDataViewModel G9() {
        Object value = this.albumDataViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-albumDataViewModel>(...)");
        return (WinkAlbumDataViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a H9() {
        Object value = this.memoryAlbumPreviewViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-memoryAlbumPreviewViewModel>(...)");
        return (com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a) value;
    }

    private final WinkMediaPickerNextStepHelper I9() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    private final void J9() {
        LiveData<List<WinkAlbumItemWrapper>> S1 = G9().S1();
        Fragment hostFragment = getHostFragment();
        final Function1<List<? extends WinkAlbumItemWrapper>, Unit> function1 = new Function1<List<? extends WinkAlbumItemWrapper>, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumPreviewPart$initViewMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends WinkAlbumItemWrapper> list) {
                invoke2((List<WinkAlbumItemWrapper>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<WinkAlbumItemWrapper> it) {
                com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a H9;
                WinkAlbumDataViewModel G9;
                w53.b.a("MemoryAlbumPreviewPart", "initViewMode, preview data size:" + it.size());
                H9 = MemoryAlbumPreviewPart.this.H9();
                com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a.Q1(H9, false, 0, 2, null);
                ia3.c cVar = MemoryAlbumPreviewPart.this.adapter;
                if (cVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    cVar.j0(it);
                }
                MemoryAlbumPreviewPart memoryAlbumPreviewPart = MemoryAlbumPreviewPart.this;
                G9 = memoryAlbumPreviewPart.G9();
                memoryAlbumPreviewPart.Q9(Intrinsics.areEqual(G9.P1().getValue(), Boolean.TRUE));
                MemoryAlbumPreviewPart.this.P9(it.size());
            }
        };
        S1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemoryAlbumPreviewPart.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(MemoryAlbumPreviewPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getHostFragment().getParentFragmentManager().beginTransaction().replace(R.id.ckj, MemoryAlbumSettingFragment.INSTANCE.a(), "MemoryAlbumPreviewPart").addToBackStack("MemoryAlbumPreviewPart").hide(this$0.getHostFragment()).commit();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(MemoryAlbumPreviewPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkMemoryAlbumScrollHelper winkMemoryAlbumScrollHelper = this$0.scrollHelper;
        if (winkMemoryAlbumScrollHelper != null) {
            winkMemoryAlbumScrollHelper.e();
        }
        this$0.O9();
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O9() {
        if (getActivity().getIntent().getBooleanExtra(QQWinkConstants.WINK_AUTO_RELEASE_MEMORY_ALBUM_GENERATOR, false)) {
            v83.b.f441239a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(int size) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_amount", Integer.valueOf(size));
        VideoReport.reportEvent(WinkDaTongReportConstant.EventId.EV_XSJ_ABNORMAL_MEMORIES_COLLECTION, null, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(boolean isLoadFinished) {
        WinkMemoryAlbumScrollHelper winkMemoryAlbumScrollHelper = this.scrollHelper;
        if (winkMemoryAlbumScrollHelper != null) {
            winkMemoryAlbumScrollHelper.g(isLoadFinished);
        }
    }

    public final void N9() {
        J9();
        H9().R1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MemoryAlbumPreviewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        WinkMemoryAlbumScrollHelper winkMemoryAlbumScrollHelper = this.scrollHelper;
        if (winkMemoryAlbumScrollHelper != null) {
            winkMemoryAlbumScrollHelper.e();
        }
        O9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        int i3;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.reportHelper.a();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f166231z32);
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(15);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            ia3.c cVar = new ia3.c(activity, this.reportHelper);
            this.adapter = cVar;
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            cVar.i0(new ia3.d(activity2, I9(), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumPreviewPart$onInitView$1$1
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
                    com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a H9;
                    H9 = MemoryAlbumPreviewPart.this.H9();
                    H9.P1(true, R.string.ymp);
                }
            }, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumPreviewPart$onInitView$1$2
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
                    com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a H9;
                    H9 = MemoryAlbumPreviewPart.this.H9();
                    com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a.Q1(H9, false, 0, 2, null);
                }
            }, this.reportHelper));
            recyclerView2.setAdapter(this.adapter);
            Context context = getContext();
            w83.b bVar = w83.b.f445025a;
            if (!bVar.M() && !bVar.N()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, i3, 1, false);
            if (bVar.M() || bVar.N()) {
                gridLayoutManager.setSpanSizeLookup(new c());
            }
            recyclerView2.setLayoutManager(gridLayoutManager);
            recyclerView2.addItemDecoration(new b());
            recyclerView2.addOnScrollListener(new d());
        }
        View findViewById = rootView.findViewById(R.id.jq_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_tv)");
        TextView textView = (TextView) findViewById;
        this.title = textView;
        Intent intent = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(getContext().getText(R.string.f240237om));
        View findViewById2 = rootView.findViewById(R.id.f166233z34);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.memory_album_setting)");
        ImageView imageView = (ImageView) findViewById2;
        this.setting = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setting");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryAlbumPreviewPart.L9(MemoryAlbumPreviewPart.this, view);
            }
        });
        View findViewById3 = rootView.findViewById(R.id.z2v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.memory_album_close)");
        ImageView imageView2 = (ImageView) findViewById3;
        this.close = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryAlbumPreviewPart.M9(MemoryAlbumPreviewPart.this, view);
            }
        });
        TextView textView2 = this.title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView2 = null;
        }
        textView2.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        ImageView imageView3 = this.close;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.qui_chevron_left);
        ImageView imageView4 = this.setting;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setting");
            imageView4 = null;
        }
        imageView4.setImageResource(R.drawable.qui_setting);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            Activity activity3 = getActivity();
            if (activity3 != null) {
                intent = activity3.getIntent();
            }
            this.scrollHelper = new WinkMemoryAlbumScrollHelper(recyclerView3, intent);
        }
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }
}
