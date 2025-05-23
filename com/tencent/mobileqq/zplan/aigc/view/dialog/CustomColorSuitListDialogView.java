package com.tencent.mobileqq.zplan.aigc.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import be3.q;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.utils.aa;
import fi3.cc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001HBa\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00020\u001c\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020#\u0012\u0006\u0010-\u001a\u00020(\u0012\b\u00103\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u00103\u001a\u0004\u0018\u00010.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/dialog/CustomColorSuitListDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/BaseSubPanelDialogView;", "", "j0", "t0", BdhLogUtil.LogTag.Tag_Conn, "r0", "s0", "Landroidx/recyclerview/widget/RecyclerView;", "h0", "Landroid/widget/ImageView;", "f0", "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "g0", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", UserInfo.SEX_FEMALE, "", "w", "", "P", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Lkotlin/Function1;", "Lzv4/c;", "E", "Lkotlin/jvm/functions/Function1;", "getOnSuitCardClick", "()Lkotlin/jvm/functions/Function1;", "onSuitCardClick", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnHintIconClick", "()Lkotlin/jvm/functions/Function0;", "onHintIconClick", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "G", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "i0", "()Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "vm", "Lzd3/a;", "H", "Lzd3/a;", "e0", "()Lzd3/a;", "dtReporter", "Lfi3/cc;", "I", "Lfi3/cc;", "mBinding", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "J", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mLayoutManager", "", "K", "[I", "mLastVisiblePositions", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;Lzd3/a;)V", "L", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CustomColorSuitListDialogView extends BaseSubPanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: E, reason: from kotlin metadata */
    private final Function1<zv4.c, Unit> onSuitCardClick;

    /* renamed from: F, reason: from kotlin metadata */
    private final Function0<Unit> onHintIconClick;

    /* renamed from: G, reason: from kotlin metadata */
    private final SuitCustomColorVewModel vm;

    /* renamed from: H, reason: from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: I, reason: from kotlin metadata */
    private cc mBinding;

    /* renamed from: J, reason: from kotlin metadata */
    private StaggeredGridLayoutManager mLayoutManager;

    /* renamed from: K, reason: from kotlin metadata */
    private int[] mLastVisiblePositions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/view/dialog/CustomColorSuitListDialogView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            zd3.a dtReporter;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0 || (dtReporter = CustomColorSuitListDialogView.this.getDtReporter()) == null) {
                return;
            }
            dtReporter.B(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            boolean contains;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            StaggeredGridLayoutManager staggeredGridLayoutManager = CustomColorSuitListDialogView.this.mLayoutManager;
            if (staggeredGridLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                staggeredGridLayoutManager = null;
            }
            int[] lastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = CustomColorSuitListDialogView.this.mLayoutManager;
            if (staggeredGridLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                staggeredGridLayoutManager2 = null;
            }
            int itemCount = staggeredGridLayoutManager2.getItemCount();
            QLog.i("CustomColorSuitListDialogView", 1, "total itemCount: " + itemCount);
            Intrinsics.checkNotNullExpressionValue(lastVisibleItemPositions, "lastVisibleItemPositions");
            contains = ArraysKt___ArraysKt.contains(lastVisibleItemPositions, itemCount + (-3));
            if (contains && !Arrays.equals(CustomColorSuitListDialogView.this.mLastVisiblePositions, lastVisibleItemPositions)) {
                QLog.d("CustomColorSuitListDialogView", 2, "dataList:  scrolled to end");
                if (!j74.b.f409622a.b()) {
                    Integer value = CustomColorSuitListDialogView.this.getVm().T2().getValue();
                    int ordinal = SuitCustomColorVewModel.FetchSuitListStatus.FINISH.ordinal();
                    if (value == null || value.intValue() != ordinal) {
                        CustomColorSuitListDialogView.this.r0();
                        SuitCustomColorVewModel.w2(CustomColorSuitListDialogView.this.getVm(), 0, 1, null);
                    }
                } else {
                    Integer value2 = CustomColorSuitListDialogView.this.getVm().U2().getValue();
                    SuitCustomColorVewModel.FetchSuitListStatus fetchSuitListStatus = SuitCustomColorVewModel.FetchSuitListStatus.FINISH;
                    int ordinal2 = fetchSuitListStatus.ordinal();
                    if (value2 == null || value2.intValue() != ordinal2) {
                        CustomColorSuitListDialogView.this.r0();
                        SuitCustomColorVewModel.y2(CustomColorSuitListDialogView.this.getVm(), 0, 1, null);
                    } else {
                        Integer value3 = CustomColorSuitListDialogView.this.getVm().V2().getValue();
                        int ordinal3 = fetchSuitListStatus.ordinal();
                        if (value3 == null || value3.intValue() != ordinal3) {
                            CustomColorSuitListDialogView.this.r0();
                            SuitCustomColorVewModel.A2(CustomColorSuitListDialogView.this.getVm(), 0, 1, null);
                        } else {
                            Integer value4 = CustomColorSuitListDialogView.this.getVm().W2().getValue();
                            int ordinal4 = fetchSuitListStatus.ordinal();
                            if (value4 == null || value4.intValue() != ordinal4) {
                                CustomColorSuitListDialogView.this.r0();
                                SuitCustomColorVewModel.C2(CustomColorSuitListDialogView.this.getVm(), 0, 1, null);
                            }
                        }
                    }
                }
            }
            CustomColorSuitListDialogView.this.mLastVisiblePositions = lastVisibleItemPositions;
        }
    }

    public /* synthetic */ CustomColorSuitListDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, Function1 function1, Function0 function0, SuitCustomColorVewModel suitCustomColorVewModel, zd3.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar, function1, function0, suitCustomColorVewModel, aVar);
    }

    private final void C() {
        h0().setAdapter(new q(new ArrayList(), this.onSuitCardClick, this.dtReporter));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        this.mLayoutManager = staggeredGridLayoutManager;
        staggeredGridLayoutManager.setGapStrategy(2);
        RecyclerView h06 = h0();
        StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.mLayoutManager;
        if (staggeredGridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            staggeredGridLayoutManager2 = null;
        }
        h06.setLayoutManager(staggeredGridLayoutManager2);
        h0().addOnScrollListener(new b());
        aa.d(f0(), new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomColorSuitListDialogView.q0(CustomColorSuitListDialogView.this, view);
            }
        });
        if (NetworkUtil.isNetworkAvailable()) {
            r0();
        }
    }

    private final ImageView f0() {
        cc ccVar = this.mBinding;
        if (ccVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            ccVar = null;
        }
        ImageView imageView = ccVar.f399232b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.hintIcon");
        return imageView;
    }

    private final NativePanelLoadingIgv g0() {
        cc ccVar = this.mBinding;
        if (ccVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            ccVar = null;
        }
        NativePanelLoadingIgv nativePanelLoadingIgv = ccVar.f399235e;
        Intrinsics.checkNotNullExpressionValue(nativePanelLoadingIgv, "mBinding.loadingCircleView");
        return nativePanelLoadingIgv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView h0() {
        cc ccVar = this.mBinding;
        if (ccVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            ccVar = null;
        }
        RecyclerView recyclerView = ccVar.f399237g;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBinding.ugcSuitList");
        return recyclerView;
    }

    private final void j0() {
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            LiveData<List<zv4.c>> d36 = this.vm.d3();
            final Function1<List<zv4.c>, Unit> function1 = new Function1<List<zv4.c>, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.CustomColorSuitListDialogView$initData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<zv4.c> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<zv4.c> list) {
                    CustomColorSuitListDialogView.this.t0();
                }
            };
            d36.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CustomColorSuitListDialogView.k0(Function1.this, obj);
                }
            });
            if (!j74.b.f409622a.b()) {
                LiveData<Integer> T2 = this.vm.T2();
                final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.CustomColorSuitListDialogView$initData$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer num) {
                        CustomColorSuitListDialogView.this.s0();
                    }
                };
                T2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.f
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CustomColorSuitListDialogView.l0(Function1.this, obj);
                    }
                });
            } else {
                LiveData<Integer> U2 = this.vm.U2();
                final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.CustomColorSuitListDialogView$initData$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer num) {
                        CustomColorSuitListDialogView.this.s0();
                        int ordinal = SuitCustomColorVewModel.FetchSuitListStatus.Exception.ordinal();
                        if (num != null && num.intValue() == ordinal) {
                            QLog.i("CustomColorSuitListDialogView", 1, "vm.fetchStatusC0 exception: " + num);
                        }
                    }
                };
                U2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.g
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CustomColorSuitListDialogView.m0(Function1.this, obj);
                    }
                });
                LiveData<Integer> V2 = this.vm.V2();
                final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.CustomColorSuitListDialogView$initData$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer num) {
                        CustomColorSuitListDialogView.this.s0();
                        int ordinal = SuitCustomColorVewModel.FetchSuitListStatus.Exception.ordinal();
                        if (num != null && num.intValue() == ordinal) {
                            QLog.i("CustomColorSuitListDialogView", 1, "vm.fetchStatusC1 exception: " + num);
                        }
                    }
                };
                V2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.h
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CustomColorSuitListDialogView.n0(Function1.this, obj);
                    }
                });
                LiveData<Integer> W2 = this.vm.W2();
                final Function1<Integer, Unit> function15 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.CustomColorSuitListDialogView$initData$1$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer num) {
                        RecyclerView h06;
                        CustomColorSuitListDialogView.this.s0();
                        int ordinal = SuitCustomColorVewModel.FetchSuitListStatus.FINISH.ordinal();
                        if (num != null && num.intValue() == ordinal) {
                            QLog.i("CustomColorSuitListDialogView", 1, "vm.fetchStatusC2 finished: " + num);
                            h06 = CustomColorSuitListDialogView.this.h0();
                            RecyclerView.Adapter adapter = h06.getAdapter();
                            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.UGCCustomColorSuitAdapter");
                            QLog.i("CustomColorSuitListDialogView", 1, "dataList size: " + ((q) adapter).getData().size());
                        }
                    }
                };
                W2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.i
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CustomColorSuitListDialogView.o0(Function1.this, obj);
                    }
                });
            }
            MutableLiveData<Boolean> a36 = this.vm.a3();
            final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.CustomColorSuitListDialogView$initData$1$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    if (!bool.booleanValue()) {
                        CustomColorSuitListDialogView.this.s0();
                    } else {
                        CustomColorSuitListDialogView.this.t0();
                    }
                }
            };
            a36.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CustomColorSuitListDialogView.p0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(CustomColorSuitListDialogView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onHintIconClick.invoke();
        zd3.a aVar = this$0.dtReporter;
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zd3.a.v(aVar, it, "em_zplan_alert_btn", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        g0().f();
        g0().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        g0().g();
        g0().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        if (!Intrinsics.areEqual(this.vm.a3().getValue(), Boolean.TRUE) || this.vm.d3().getValue() == null) {
            return;
        }
        Intrinsics.checkNotNull(this.vm.d3().getValue());
        if (!r0.isEmpty()) {
            s0();
            RecyclerView.Adapter adapter = h0().getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.UGCCustomColorSuitAdapter");
            List<zv4.c> value = this.vm.d3().getValue();
            Intrinsics.checkNotNull(value);
            ((q) adapter).addData(value);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean F() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView
    public int P() {
        return 2;
    }

    /* renamed from: e0, reason: from getter */
    public final zd3.a getDtReporter() {
        return this.dtReporter;
    }

    /* renamed from: i0, reason: from getter */
    public final SuitCustomColorVewModel getVm() {
        return this.vm;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        cc g16 = cc.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.mBinding = g16;
        C();
        j0();
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public Object w() {
        cc ccVar = this.mBinding;
        if (ccVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            ccVar = null;
        }
        return ccVar.getRoot();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CustomColorSuitListDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel, Function1<? super zv4.c, Unit> onSuitCardClick, Function0<Unit> onHintIconClick, SuitCustomColorVewModel vm5, zd3.a aVar) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(onSuitCardClick, "onSuitCardClick");
        Intrinsics.checkNotNullParameter(onHintIconClick, "onHintIconClick");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.channel = channel;
        this.onSuitCardClick = onSuitCardClick;
        this.onHintIconClick = onHintIconClick;
        this.vm = vm5;
        this.dtReporter = aVar;
        this.mLastVisiblePositions = new int[3];
    }
}
