package ao;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.repair.viewmodel.i;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\r\u001a\u00020\u00032\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tH\u0002J\u001e\u0010\u000e\u001a\u00020\u00032\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u001c\u0010\u0011\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lao/c;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "E9", "initViewModel", "", "hasMore", "M9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lwn/d;", "listUIStateData", "F9", "G9", "I9", "K9", "L9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "onLoadMoreEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "e", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lvn/a;", "f", "Lvn/a;", "taskAdapter", "Lcom/qzone/reborn/feedx/block/aa;", h.F, "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lcom/qzone/reborn/repair/viewmodel/i;", "i", "Lcom/qzone/reborn/repair/viewmodel/i;", "taskListViewModel", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "tvDescText", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends k implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView tvDescText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private vn.a taskAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private i taskListViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView blankView;

    private final void E9() {
        vn.a aVar = new vn.a();
        this.taskAdapter = aVar;
        aVar.setHasStableIds(true);
        aa aaVar = new aa();
        this.loadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        aa aaVar2 = this.loadMoreAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.f169566wb0)).f(HardCodeUtil.qqStr(R.string.v3z)));
        aa aaVar3 = this.loadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar3 = null;
        }
        aaVar3.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        vn.a aVar2 = this.taskAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
            aVar2 = null;
        }
        adapterArr[0] = aVar2;
        aa aaVar4 = this.loadMoreAdapter;
        if (aaVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar4 = null;
        }
        adapterArr[1] = aaVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void I9() {
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.y(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(c this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9(uIStateData);
    }

    private final void K9() {
        I9();
        RecyclerView recyclerView = this.recyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        TextView textView = this.tvDescText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescText");
            textView = null;
        }
        textView.setVisibility(8);
        QZoneBlankStateView qZoneBlankStateView2 = this.blankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    private final void L9(UIStateData<List<wn.d>> listUIStateData) {
        I9();
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        TextView textView = this.tvDescText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescText");
            textView = null;
        }
        textView.setVisibility(8);
        QZoneBlankStateView qZoneBlankStateView2 = this.blankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.showErrorView();
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026istViewModel::class.java)");
        i iVar = (i) viewModel;
        this.taskListViewModel = iVar;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskListViewModel");
            iVar = null;
        }
        iVar.R1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: ao.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.J9(c.this, (UIStateData) obj);
            }
        });
        i iVar3 = this.taskListViewModel;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskListViewModel");
        } else {
            iVar2 = iVar3;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iVar2.U1(context, false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePhotoRepairTaskListBodyPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.nfd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_task_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        View findViewById2 = rootView.findViewById(R.id.mhx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.photo_repair_blank_view)");
        this.blankView = (QZoneBlankStateView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.nip);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_desc_text)");
        this.tvDescText = (TextView) findViewById3;
        E9();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        M9(hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        i iVar = this.taskListViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskListViewModel");
            iVar = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iVar.U1(context, true);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        i iVar = this.taskListViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskListViewModel");
            iVar = null;
        }
        iVar.L1();
    }

    private final void M9(boolean hasMore) {
        if (hasMore) {
            return;
        }
        aa aaVar = this.loadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar = null;
        }
        aa.b l06 = aaVar.l0();
        if (l06 != null) {
            l06.itemView.setVisibility(8);
            View findViewById = l06.itemView.findViewById(R.id.m1c);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    private final void F9(UIStateData<List<wn.d>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            K9();
        } else if (state == 2 || state == 3) {
            G9(listUIStateData);
        } else if (state == 4) {
            L9(listUIStateData);
        }
        aa aaVar = this.loadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar = null;
        }
        aaVar.setLoadState(false, !listUIStateData.getIsFinish());
        M9(!listUIStateData.getIsFinish());
    }

    private final void G9(UIStateData<List<wn.d>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e("QZonePhotoRepairTaskListBodyPart", 1, "ui state data is null");
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        vn.a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        TextView textView = this.tvDescText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescText");
            textView = null;
        }
        textView.setVisibility(0);
        vn.a aVar2 = this.taskAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
        } else {
            aVar = aVar2;
        }
        aVar.setItems(new ArrayList(listUIStateData.getData()));
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: ao.b
            @Override // java.lang.Runnable
            public final void run() {
                c.H9(c.this);
            }
        }, 100L);
    }
}
