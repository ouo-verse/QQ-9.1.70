package com.tencent.mobileqq.wink.qzone.templatelibrary.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.WinkQZoneTemplateLibJumpHelper;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s93.c;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0016\u0010\u0014\u001a\b\u0018\u00010\u0012R\u00020\u00132\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J-\u0010#\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\b2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e2\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneTemplateLibDetailListPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initView", "", "show", "N9", "G9", "", "position", "J9", "initViewModel", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$c;", "detailPageData", "O9", "M9", "B1", "getCurrentPosition", "Ls93/c$b;", "Ls93/c;", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartPause", "onPartResume", "requestCode", "", "", "permissions", "", "grantResults", "I9", "(I[Ljava/lang/String;[I)V", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "templateRecyclerView", "e", "Landroid/view/View;", "skeletonViewContainer", "f", "Ls93/c;", "templateListAdapter", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", tl.h.F, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "templateViewModel", "Landroidx/recyclerview/widget/LinearLayoutManager;", "i", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/PagerSnapHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/PagerSnapHelper;", "pagerSnapHelper", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "D", "I", "currentSelectedPosition", "E", "Z", "isPlaying", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibDetailListPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibJumpHelper jumpHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentSelectedPosition = -1;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isPlaying = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView templateRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View skeletonViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s93.c templateListAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel templateViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private PagerSnapHelper pagerSnapHelper;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneTemplateLibDetailListPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            int currentPosition;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0 && WinkQZoneTemplateLibDetailListPart.this.currentSelectedPosition != (currentPosition = WinkQZoneTemplateLibDetailListPart.this.getCurrentPosition())) {
                WinkQZoneTemplateLibDetailListPart.this.J9(currentPosition);
                com.tencent.mobileqq.wink.report.e.f326265a.y();
            }
        }
    }

    private final void B1(final int position) {
        RecyclerView recyclerView = this.templateRecyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.k
                @Override // java.lang.Runnable
                public final void run() {
                    WinkQZoneTemplateLibDetailListPart.K9(WinkQZoneTemplateLibDetailListPart.this, position);
                }
            });
        }
    }

    private final c.b F9(int position) {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView recyclerView = this.templateRecyclerView;
        if (recyclerView != null) {
            viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
        } else {
            viewHolder = null;
        }
        return (c.b) viewHolder;
    }

    private final void G9() {
        this.templateRecyclerView = (RecyclerView) getPartRootView().findViewById(R.id.f124427jb);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.linearLayoutManager = linearLayoutManager;
        RecyclerView recyclerView = this.templateRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.pagerSnapHelper = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.templateRecyclerView);
        RecyclerView recyclerView2 = this.templateRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addOnScrollListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(WinkQZoneTemplateLibDetailListPart this$0, WinkQZoneTemplateLibViewModel.DetailPageData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.O9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(int position) {
        c.b F9;
        s93.c cVar = this.templateListAdapter;
        if (cVar != null) {
            cVar.o0(position);
        }
        int i3 = this.currentSelectedPosition;
        if (i3 != -1 && (F9 = F9(i3)) != null) {
            F9.z();
            F9.y();
            c.b.K(F9, false, false, 2, null);
        }
        this.currentSelectedPosition = position;
        c.b F92 = F9(position);
        if (F92 != null) {
            F92.B();
            F92.A();
            c.b.K(F92, true, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(final WinkQZoneTemplateLibDetailListPart this$0, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Ref.IntRef intRef = new Ref.IntRef();
        RecyclerView recyclerView = this$0.templateRecyclerView;
        Intrinsics.checkNotNull(recyclerView);
        final int paddingTop = recyclerView.getPaddingTop();
        LinearLayoutManager linearLayoutManager = this$0.linearLayoutManager;
        LinearLayoutManager linearLayoutManager2 = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager = null;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        LinearLayoutManager linearLayoutManager3 = this$0.linearLayoutManager;
        if (linearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager3 = null;
        }
        View findViewByPosition = linearLayoutManager3.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition != null) {
            RecyclerView recyclerView2 = this$0.templateRecyclerView;
            Intrinsics.checkNotNull(recyclerView2);
            intRef.element = ((recyclerView2.getHeight() - paddingTop) / 2) - (findViewByPosition.getHeight() / 2);
        }
        LinearLayoutManager linearLayoutManager4 = this$0.linearLayoutManager;
        if (linearLayoutManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
        } else {
            linearLayoutManager2 = linearLayoutManager4;
        }
        linearLayoutManager2.scrollToPositionWithOffset(i3, intRef.element);
        RecyclerView recyclerView3 = this$0.templateRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.post(new Runnable() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.l
                @Override // java.lang.Runnable
                public final void run() {
                    WinkQZoneTemplateLibDetailListPart.L9(WinkQZoneTemplateLibDetailListPart.this, i3, intRef, paddingTop);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(WinkQZoneTemplateLibDetailListPart this$0, int i3, Ref.IntRef offset, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(offset, "$offset");
        LinearLayoutManager linearLayoutManager = this$0.linearLayoutManager;
        LinearLayoutManager linearLayoutManager2 = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager = null;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(i3);
        if (findViewByPosition != null) {
            RecyclerView recyclerView = this$0.templateRecyclerView;
            Intrinsics.checkNotNull(recyclerView);
            offset.element = ((recyclerView.getHeight() - i16) / 2) - (findViewByPosition.getHeight() / 2);
            LinearLayoutManager linearLayoutManager3 = this$0.linearLayoutManager;
            if (linearLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            } else {
                linearLayoutManager2 = linearLayoutManager3;
            }
            linearLayoutManager2.scrollToPositionWithOffset(i3, offset.element);
        }
    }

    private final void M9(int position) {
        B1(position);
        J9(position);
    }

    private final void N9(boolean show) {
        QUIShimmerImageView qUIShimmerImageView = (QUIShimmerImageView) getPartRootView().findViewById(R.id.f124457je);
        QUIShimmerImageView qUIShimmerImageView2 = (QUIShimmerImageView) getPartRootView().findViewById(R.id.f124467jf);
        if (show) {
            if (qUIShimmerImageView != null) {
                qUIShimmerImageView.startShimming(null);
            }
            if (qUIShimmerImageView2 != null) {
                qUIShimmerImageView2.startShimming(null);
            }
            View view = this.skeletonViewContainer;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        if (qUIShimmerImageView != null) {
            qUIShimmerImageView.stopShimming(null);
        }
        if (qUIShimmerImageView2 != null) {
            qUIShimmerImageView2.stopShimming(null);
        }
        View view2 = this.skeletonViewContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void O9(WinkQZoneTemplateLibViewModel.DetailPageData detailPageData) {
        ArrayList<MetaMaterial> arrayList;
        boolean z16;
        MetaCategory currentMaterialCategory = detailPageData.getCurrentMaterialCategory();
        Integer num = null;
        if (currentMaterialCategory != null) {
            arrayList = currentMaterialCategory.materials;
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.g("WinkQZoneTemplateLibPreviewListPart", "updateTemplateRecyclerView currentMaterialCategory is empty");
            return;
        }
        N9(false);
        RecyclerView recyclerView = this.templateRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        s93.c cVar = new s93.c(arrayList, new Function1<MetaMaterial, Unit>() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.WinkQZoneTemplateLibDetailListPart$updateTemplateRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetaMaterial metaMaterial) {
                invoke2(metaMaterial);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MetaMaterial it) {
                WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper;
                Intrinsics.checkNotNullParameter(it, "it");
                winkQZoneTemplateLibJumpHelper = WinkQZoneTemplateLibDetailListPart.this.jumpHelper;
                if (winkQZoneTemplateLibJumpHelper != null) {
                    WinkQZoneTemplateLibJumpHelper.o(winkQZoneTemplateLibJumpHelper, WinkQZoneTemplateLibDetailListPart.this.getActivity(), it, null, "0", 4, null);
                }
            }
        });
        this.templateListAdapter = cVar;
        RecyclerView recyclerView2 = this.templateRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cVar);
        }
        RecyclerView recyclerView3 = this.templateRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setItemViewCacheSize(5);
        }
        ArrayList<MetaMaterial> arrayList2 = detailPageData.getCurrentMaterialCategory().materials;
        if (arrayList2 != null) {
            Iterator<MetaMaterial> it = arrayList2.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().f30533id, detailPageData.getTargetTemplateId())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            num = Integer.valueOf(i3);
        }
        if (num == null || num.intValue() < 0) {
            num = 0;
        }
        M9(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentPosition() {
        PagerSnapHelper pagerSnapHelper = this.pagerSnapHelper;
        LinearLayoutManager linearLayoutManager = null;
        if (pagerSnapHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerSnapHelper");
            pagerSnapHelper = null;
        }
        LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager2 = null;
        }
        View findSnapView = pagerSnapHelper.findSnapView(linearLayoutManager2);
        if (findSnapView != null) {
            LinearLayoutManager linearLayoutManager3 = this.linearLayoutManager;
            if (linearLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            } else {
                linearLayoutManager = linearLayoutManager3;
            }
            return linearLayoutManager.getPosition(findSnapView);
        }
        return -1;
    }

    private final void initView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.jumpHelper = new WinkQZoneTemplateLibJumpHelper(context, getHostFragment());
        this.skeletonViewContainer = getPartRootView().findViewById(R.id.f124477jg);
        N9(true);
        G9();
    }

    private final void initViewModel() {
        LiveData<WinkQZoneTemplateLibViewModel.DetailPageData> O1;
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = (WinkQZoneTemplateLibViewModel) getViewModel(WinkQZoneTemplateLibViewModel.class);
        this.templateViewModel = winkQZoneTemplateLibViewModel;
        if (winkQZoneTemplateLibViewModel != null && (O1 = winkQZoneTemplateLibViewModel.O1()) != null) {
            O1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkQZoneTemplateLibDetailListPart.H9(WinkQZoneTemplateLibDetailListPart.this, (WinkQZoneTemplateLibViewModel.DetailPageData) obj);
                }
            });
        }
    }

    public final void I9(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this.jumpHelper;
        if (winkQZoneTemplateLibJumpHelper != null) {
            winkQZoneTemplateLibJumpHelper.s(requestCode, permissions, grantResults);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initView();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        s93.c cVar = this.templateListAdapter;
        if (cVar != null) {
            cVar.release();
        }
        this.templateListAdapter = null;
        RecyclerView recyclerView = this.templateRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        c.b F9 = F9(this.currentSelectedPosition);
        if (F9 != null) {
            this.isPlaying = F9.w();
            F9.z();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        c.b F9;
        super.onPartResume(activity);
        if (this.isPlaying && (F9 = F9(this.currentSelectedPosition)) != null) {
            F9.B();
        }
    }
}
