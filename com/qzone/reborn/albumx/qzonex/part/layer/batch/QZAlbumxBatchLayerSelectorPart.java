package com.qzone.reborn.albumx.qzonex.part.layer.batch;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.util.r;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/batch/QZAlbumxBatchLayerSelectorPart;", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "", "Q9", "K9", "initData", "", "it", "M9", "(Ljava/lang/Integer;)V", "Loc/b;", "L9", "selectedIndex", "batchLayerViewModel", "S9", "R9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/os/Bundle;", "data", "initIntentData", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "rvSelectedMedia", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "i", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lva/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lva/a;", "batchSelectedListAdapter", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Runnable;", "scrollRunnable", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxBatchLayerSelectorPart extends com.qzone.reborn.albumx.common.layer.part.i<QZAlbumxLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private Runnable scrollRunnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rvSelectedMedia;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private va.a batchSelectedListAdapter;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/layer/batch/QZAlbumxBatchLayerSelectorPart$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.left = r.f59560a.e(7);
            }
        }
    }

    private final void K9() {
        va.a aVar = new va.a();
        this.batchSelectedListAdapter = aVar;
        aVar.setHasStableIds(true);
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.batchSelectedListAdapter});
        this.concatAdapter = rFWConcatAdapter;
        RecyclerView recyclerView = this.rvSelectedMedia;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final oc.b L9() {
        return (oc.b) getViewModel(oc.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9() {
        RecyclerView recyclerView = this.rvSelectedMedia;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(true);
        }
        RecyclerView recyclerView2 = this.rvSelectedMedia;
        if (recyclerView2 != null) {
            recyclerView2.setOverScrollMode(2);
        }
        RecyclerView recyclerView3 = this.rvSelectedMedia;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(null);
        }
        RecyclerView recyclerView4 = this.rvSelectedMedia;
        if (recyclerView4 != null) {
            recyclerView4.addItemDecoration(new a());
        }
        RecyclerView recyclerView5 = this.rvSelectedMedia;
        if (recyclerView5 == null) {
            return;
        }
        recyclerView5.setLayoutManager(new SafeLinearLayoutManager(getContext(), 0, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(final int selectedIndex) {
        if (this.scrollRunnable != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.scrollRunnable;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.removeCallbacks(runnable);
        }
        this.scrollRunnable = new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerSelectorPart$scrollToIndex$1
            /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
            
                r1 = r2.rvSelectedMedia;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                va.a aVar;
                List<QZAlbumxBatchLayerSelectedMediaInfoBean> items;
                RecyclerView recyclerView;
                int i3 = selectedIndex - 1;
                aVar = this.batchSelectedListAdapter;
                if (aVar == null || (items = aVar.getItems()) == null) {
                    return;
                }
                if (!(i3 >= 0 && i3 < items.size()) || recyclerView == null) {
                    return;
                }
                recyclerView.scrollToPosition(i3);
            }
        };
        Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable2 = this.scrollRunnable;
        Intrinsics.checkNotNull(runnable2);
        uIHandlerV22.postDelayed(runnable2, 100L);
    }

    private final void S9(int selectedIndex, oc.b batchLayerViewModel) {
        ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> Z1;
        va.a aVar = this.batchSelectedListAdapter;
        if (aVar == null) {
            return;
        }
        if (selectedIndex > 0) {
            int i3 = selectedIndex - 1;
            if (!ArrayUtils.isOutOfArrayIndex(i3, batchLayerViewModel.P1())) {
                Z1 = batchLayerViewModel.Z1(batchLayerViewModel.P1().get(i3));
                aVar.setItems(Z1);
            }
        }
        Z1 = batchLayerViewModel.Z1(null);
        aVar.setItems(Z1);
    }

    private final void initData() {
        final oc.b L9 = L9();
        if (L9 != null) {
            MutableLiveData<Unit> Q1 = L9.Q1();
            if (Q1 != null) {
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                final Function1<Unit, Unit> function1 = new Function1<Unit, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerSelectorPart$initData$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                        invoke2(unit);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Unit unit) {
                        RecyclerView recyclerView;
                        va.a aVar;
                        RecyclerView recyclerView2;
                        if (oc.b.this.P1().size() > 0) {
                            recyclerView2 = this.rvSelectedMedia;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(0);
                            }
                        } else {
                            recyclerView = this.rvSelectedMedia;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(8);
                            }
                        }
                        aVar = this.batchSelectedListAdapter;
                        if (aVar != null) {
                            aVar.setItems(new ArrayList(oc.b.this.P1()));
                        }
                        this.R9(oc.b.this.W1(this.mCurrentSelectedItem));
                    }
                };
                Q1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.j
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QZAlbumxBatchLayerSelectorPart.N9(Function1.this, obj);
                    }
                });
            }
            MutableLiveData<QZAlbumxBatchLayerSelectedMediaInfoBean> O1 = L9.O1();
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<QZAlbumxBatchLayerSelectedMediaInfoBean, Unit> function12 = new Function1<QZAlbumxBatchLayerSelectedMediaInfoBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerSelectorPart$initData$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean) {
                    invoke2(qZAlbumxBatchLayerSelectedMediaInfoBean);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(QZAlbumxBatchLayerSelectedMediaInfoBean it) {
                    oc.b bVar = oc.b.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    bVar.X1(it, this.getMLayerViewModel());
                }
            };
            O1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxBatchLayerSelectorPart.O9(Function1.this, obj);
                }
            });
            MutableLiveData<Integer> M1 = L9.M1();
            LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerSelectorPart$initData$1$3
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
                    QZAlbumxBatchLayerSelectorPart.this.M9(num);
                }
            };
            M1.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxBatchLayerSelectorPart.P9(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxBatchLayerSelectorPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        Object a16 = com.qzone.reborn.feedx.util.m.a("extra_key_parcelable_selected_list_for_jump_batch_layer");
        ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> arrayList = a16 instanceof ArrayList ? (ArrayList) a16 : null;
        oc.b L9 = L9();
        if (L9 != null) {
            L9.S1(arrayList);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.rvSelectedMedia = rootView != null ? (RecyclerView) rootView.findViewById(R.id.nf_) : null;
        Q9();
        K9();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        String tag = getTAG();
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        QLog.d(tag, 4, "all layer item size:" + (richMediaDataList != null ? Integer.valueOf(richMediaDataList.size()) : null));
        oc.b L9 = L9();
        if (L9 == null) {
            return;
        }
        int W1 = L9.W1(layerState.getSelectedItemMedia());
        S9(W1, L9);
        R9(W1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(Integer it) {
        oc.b L9;
        if (it == null) {
            return;
        }
        if (it.intValue() == 1) {
            RecyclerView recyclerView = this.rvSelectedMedia;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        if (it.intValue() != 2 || (L9 = L9()) == null) {
            return;
        }
        if (L9.P1().size() > 0) {
            RecyclerView recyclerView2 = this.rvSelectedMedia;
            if (recyclerView2 == null) {
                return;
            }
            recyclerView2.setVisibility(0);
            return;
        }
        RecyclerView recyclerView3 = this.rvSelectedMedia;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setVisibility(8);
    }
}
