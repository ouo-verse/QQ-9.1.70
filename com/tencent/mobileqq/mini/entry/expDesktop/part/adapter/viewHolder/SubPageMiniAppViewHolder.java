package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDesktopSubPageGridItemDecoration;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDesktopSubPageRvAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragHelper;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemTouchForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpItemCallback;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.delegate.SubPageMiniAppRvHorizontalDelegatesManager;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpItemClickLaunchUtils;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J6\u0010%\u001a\u00020&2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0018\u0010-\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00103\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H\u0002J\b\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020&H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/SubPageMiniAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mDragListener", "Landroid/view/View$OnDragListener;", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "getMExpoReportHelper", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "mHostScene", "", "mLocationFromPosition", "", "mLocationTime", "", "mLocationToPosition", "mMiniAppExpDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "getMMiniAppExpDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "mMiniAppExpDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppItems", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "mModuleType", "mSubInnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mSubRvAdapter", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mSubRvItemListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpInnerRvItemTouchForDragListener;", "mVia", "bindView", "", "miniAppItems", "via", "hostScene", "moduleType", "getHostScene", "fromPosition", "myMiniAppSubPageDragDrop", "event", "Landroid/view/DragEvent;", "myMiniAppSubPageDragListener", "", "view", "myMiniAppSubPageDragLocation", "setDragListener", "setSubRvOnItemListener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SubPageMiniAppViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "SubPageMiniAppViewHolder";
    private View.OnDragListener mDragListener;
    private final MiniExpValidExpoReportHelper mExpoReportHelper;
    private String mHostScene;
    private int mLocationFromPosition;
    private long mLocationTime;
    private int mLocationToPosition;

    /* renamed from: mMiniAppExpDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppExpDesktopViewModel;
    private ArrayList<DesktopAppInfo> mMiniAppItems;
    private int mModuleType;
    private RecyclerView mSubInnerRv;
    private AsyncListDifferDelegationAdapter<DesktopItemInfo> mSubRvAdapter;
    private MiniAppExpInnerRvItemTouchForDragListener mSubRvItemListener;
    private String mVia;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPageMiniAppViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppExpDesktopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.SubPageMiniAppViewHolder$mMiniAppExpDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppExpDesktopViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(itemView);
                MiniAppExpDesktopViewModel miniAppExpDesktopViewModel = viewModelStoreOwner != null ? (MiniAppExpDesktopViewModel) new ViewModelProvider(viewModelStoreOwner).get(MiniAppExpDesktopViewModel.class) : null;
                if (miniAppExpDesktopViewModel != null) {
                    Context context = itemView.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    miniAppExpDesktopViewModel.setContextHashCode(((Activity) context).hashCode());
                }
                return miniAppExpDesktopViewModel;
            }
        });
        this.mMiniAppExpDesktopViewModel = lazy;
        this.mMiniAppItems = new ArrayList<>();
        this.mVia = "";
        this.mHostScene = "";
        this.mExpoReportHelper = new MiniExpValidExpoReportHelper("subPageMiniAppViewHolder");
        this.mLocationToPosition = -1;
        this.mLocationFromPosition = -1;
        this.mModuleType = 1;
        View findViewById = itemView.findViewById(R.id.rht);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026_sub_inner_recycler_view)");
        this.mSubInnerRv = (RecyclerView) findViewById;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), 4);
        gridLayoutManager.setOrientation(1);
        this.mSubInnerRv.setLayoutManager(gridLayoutManager);
        this.mSubInnerRv.setItemAnimator(null);
        this.mSubInnerRv.addItemDecoration(new MiniAppExpDesktopSubPageGridItemDecoration());
        MiniAppExpDesktopSubPageRvAdapter miniAppExpDesktopSubPageRvAdapter = new MiniAppExpDesktopSubPageRvAdapter(new MiniAppExpItemCallback(), new SubPageMiniAppRvHorizontalDelegatesManager()) { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.SubPageMiniAppViewHolder.1
            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                String str;
                Map<String, String> mutableMapOf;
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewAttachedToWindow(holder);
                if (!SubPageMiniAppViewHolder.this.mMiniAppItems.isEmpty()) {
                    int positionInfoByViewHolder = SubPageMiniAppViewHolder.this.getMExpoReportHelper().getPositionInfoByViewHolder(SubPageMiniAppViewHolder.this.mMiniAppItems, holder);
                    if (SubPageMiniAppViewHolder.this.mModuleType == 1) {
                        str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2;
                    } else {
                        str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_PERSONAL_LEVEL2;
                    }
                    MiniExpValidExpoReportHelper mExpoReportHelper = SubPageMiniAppViewHolder.this.getMExpoReportHelper();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", SubPageMiniAppViewHolder.this.mVia), TuplesKt.to("position", String.valueOf(positionInfoByViewHolder)), TuplesKt.to("module", str), TuplesKt.to("page_id", str), TuplesKt.to("host_scene", SubPageMiniAppViewHolder.this.getHostScene(positionInfoByViewHolder)));
                    mExpoReportHelper.sendMiniAppExpoReport(holder, mutableMapOf);
                }
            }

            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewDetachedFromWindow(holder);
                MiniExpValidExpoReportHelper mExpoReportHelper = SubPageMiniAppViewHolder.this.getMExpoReportHelper();
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                mExpoReportHelper.cancelMiniAppExpoReport(holder, (DesktopItemInfo) tag);
            }
        };
        this.mSubRvAdapter = miniAppExpDesktopSubPageRvAdapter;
        this.mSubInnerRv.setAdapter(miniAppExpDesktopSubPageRvAdapter);
        setSubRvOnItemListener();
        setDragListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppExpDesktopViewModel getMMiniAppExpDesktopViewModel() {
        return (MiniAppExpDesktopViewModel) this.mMiniAppExpDesktopViewModel.getValue();
    }

    private final void myMiniAppSubPageDragDrop(View itemView, DragEvent event) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        View findChildViewUnder = this.mSubInnerRv.findChildViewUnder(event.getX(), event.getY());
        if (findChildViewUnder != null && this.mSubInnerRv.getChildViewHolder(findChildViewUnder) != null) {
            Object localState = event.getLocalState();
            Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
            int fromPosition = ((MiniAppExpDragData) localState).getFromPosition();
            int adapterPosition = this.mSubInnerRv.getChildViewHolder(findChildViewUnder).getAdapterPosition();
            if (fromPosition >= 0 && fromPosition < this.mMiniAppItems.size() && adapterPosition >= 0 && adapterPosition < this.mMiniAppItems.size() && (lifecycleOwner = ViewTreeLifecycleOwner.get(itemView)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new SubPageMiniAppViewHolder$myMiniAppSubPageDragDrop$1(this, fromPosition, adapterPosition, null), 3, null);
            }
            QLog.i(TAG, 1, "actionDrop fromPosition" + fromPosition + " toPosition:" + adapterPosition);
            return;
        }
        QLog.i(TAG, 1, "view == null or holder == null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean myMiniAppSubPageDragListener(View view, DragEvent event) {
        switch (event.getAction()) {
            case 1:
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
                if (((MiniAppExpDragData) localState).getStartRv().getId() != R.id.rht) {
                    return false;
                }
                this.mLocationTime = System.currentTimeMillis();
                return true;
            case 2:
                myMiniAppSubPageDragLocation(view, event);
                return true;
            case 3:
                myMiniAppSubPageDragDrop(view, event);
                return true;
            case 4:
                this.mLocationToPosition = -1;
                this.mLocationFromPosition = -1;
                return true;
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    private final void myMiniAppSubPageDragLocation(View itemView, DragEvent event) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (System.currentTimeMillis() - this.mLocationTime <= 1000) {
            QLog.i(TAG, 1, "myMiniAppSubPageDragLocation 800ms interval!");
            return;
        }
        View findChildViewUnder = this.mSubInnerRv.findChildViewUnder(event.getX(), event.getY());
        if (findChildViewUnder != null && this.mSubInnerRv.getChildViewHolder(findChildViewUnder) != null) {
            Object localState = event.getLocalState();
            Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
            int fromPosition = ((MiniAppExpDragData) localState).getFromPosition();
            RecyclerView.ViewHolder childViewHolder = this.mSubInnerRv.getChildViewHolder(findChildViewUnder);
            Intrinsics.checkNotNull(childViewHolder);
            int adapterPosition = childViewHolder.getAdapterPosition();
            if (fromPosition >= 0 && fromPosition < this.mMiniAppItems.size() && adapterPosition >= 0 && adapterPosition < this.mMiniAppItems.size() && (lifecycleOwner = ViewTreeLifecycleOwner.get(itemView)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new SubPageMiniAppViewHolder$myMiniAppSubPageDragLocation$1(this, fromPosition, adapterPosition, null), 3, null);
            }
            QLog.i(TAG, 1, "holder.adapterPosition" + fromPosition + " dragData.fromPosition\uff1a" + adapterPosition);
            this.mLocationTime = System.currentTimeMillis();
            return;
        }
        QLog.i(TAG, 1, "view == null or holder == null!");
    }

    private final void setDragListener() {
        if (this.mDragListener == null) {
            View.OnDragListener onDragListener = new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.SubPageMiniAppViewHolder$setDragListener$1
                @Override // android.view.View.OnDragListener
                public boolean onDrag(View view, DragEvent event) {
                    boolean myMiniAppSubPageDragListener;
                    if (view != null && event != null && event.getLocalState() != null && (event.getLocalState() instanceof MiniAppExpDragData)) {
                        if (SubPageMiniAppViewHolder.this.mModuleType != 3) {
                            return false;
                        }
                        myMiniAppSubPageDragListener = SubPageMiniAppViewHolder.this.myMiniAppSubPageDragListener(view, event);
                        return myMiniAppSubPageDragListener;
                    }
                    QLog.i("SubPageMiniAppViewHolder", 1, "view\u3001event\u3001event.localState is null or event.localState is not MiniAppExpDragData!");
                    return false;
                }
            };
            this.mDragListener = onDragListener;
            RecyclerView recyclerView = this.mSubInnerRv;
            Intrinsics.checkNotNull(onDragListener);
            recyclerView.setOnDragListener(onDragListener);
            QLog.i(TAG, 1, "setDragListenerForSubRv setOnDragListener!");
        }
    }

    private final void setSubRvOnItemListener() {
        if (this.mSubRvItemListener == null) {
            MiniAppExpInnerRvItemTouchForDragListener miniAppExpInnerRvItemTouchForDragListener = new MiniAppExpInnerRvItemTouchForDragListener(this.mSubInnerRv, new MiniAppExpInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.SubPageMiniAppViewHolder$setSubRvOnItemListener$1
                @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
                public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                    AsyncListDifferDelegationAdapter asyncListDifferDelegationAdapter;
                    AsyncListDifferDelegationAdapter asyncListDifferDelegationAdapter2;
                    AsyncListDifferDelegationAdapter asyncListDifferDelegationAdapter3;
                    List items;
                    List items2;
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i("SubPageMiniAppViewHolder", 2, "mSubLayoutRv, onItemLongClick!");
                    asyncListDifferDelegationAdapter = SubPageMiniAppViewHolder.this.mSubRvAdapter;
                    DesktopItemInfo desktopItemInfo = null;
                    if ((asyncListDifferDelegationAdapter != null ? asyncListDifferDelegationAdapter.getItems() : null) != null && fromPosition >= 0) {
                        asyncListDifferDelegationAdapter2 = SubPageMiniAppViewHolder.this.mSubRvAdapter;
                        if (fromPosition < ((asyncListDifferDelegationAdapter2 == null || (items2 = asyncListDifferDelegationAdapter2.getItems()) == null) ? 0 : items2.size())) {
                            asyncListDifferDelegationAdapter3 = SubPageMiniAppViewHolder.this.mSubRvAdapter;
                            if (asyncListDifferDelegationAdapter3 != null && (items = asyncListDifferDelegationAdapter3.getItems()) != null) {
                                desktopItemInfo = (DesktopItemInfo) items.get(fromPosition);
                            }
                            if (!(desktopItemInfo instanceof DesktopAppInfo)) {
                                QLog.i("SubPageMiniAppViewHolder", 1, "onItemLongClick desktopInfo:" + desktopItemInfo + " is invalid!");
                                return;
                            }
                            MiniAppExpDragHelper.INSTANCE.startDrag(rv5, vh5, fromPosition, (DesktopAppInfo) desktopItemInfo, rawX, rawY);
                            return;
                        }
                    }
                    QLog.i("SubPageMiniAppViewHolder", 1, "onItemLongClick fromPosition:" + fromPosition + " is invalid!");
                }

                @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
                public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                    String str;
                    String str2;
                    Map<String, String> mutableMapOf;
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i("SubPageMiniAppViewHolder", 1, "mSubLayoutRv, onItemClick");
                    if (fromPosition >= 0 && fromPosition < SubPageMiniAppViewHolder.this.mMiniAppItems.size()) {
                        ((DesktopAppInfo) SubPageMiniAppViewHolder.this.mMiniAppItems.get(fromPosition)).mMiniAppInfo.via = SubPageMiniAppViewHolder.this.mVia;
                        Object obj = SubPageMiniAppViewHolder.this.mMiniAppItems.get(fromPosition);
                        Intrinsics.checkNotNullExpressionValue(obj, "mMiniAppItems[fromPosition]");
                        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) obj;
                        if (desktopAppInfo.mModuleType == 1) {
                            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2;
                        } else {
                            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_PERSONAL_LEVEL2;
                        }
                        Pair[] pairArr = new Pair[6];
                        pairArr[0] = TuplesKt.to("applet_appid", desktopAppInfo.mMiniAppInfo.appId);
                        pairArr[1] = TuplesKt.to("applet_type", String.valueOf(desktopAppInfo.mMiniAppInfo.engineType));
                        pairArr[2] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, str);
                        pairArr[3] = TuplesKt.to("host_scene", SubPageMiniAppViewHolder.this.getHostScene(fromPosition));
                        if (desktopAppInfo.mMiniAppInfo.isWxMiniApp()) {
                            str2 = "2";
                        } else {
                            str2 = "1";
                        }
                        pairArr[4] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APP_SOURCE, str2);
                        pairArr[5] = TuplesKt.to("pgid", str);
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                        MiniAppExpItemClickLaunchUtils miniAppExpItemClickLaunchUtils = MiniAppExpItemClickLaunchUtils.INSTANCE;
                        Context context = rv5.getContext();
                        Activity activity = context instanceof Activity ? (Activity) context : null;
                        Intrinsics.checkNotNull(activity);
                        Object obj2 = SubPageMiniAppViewHolder.this.mMiniAppItems.get(fromPosition);
                        Intrinsics.checkNotNullExpressionValue(obj2, "mMiniAppItems[fromPosition]");
                        DesktopAppInfo desktopAppInfo2 = (DesktopAppInfo) obj2;
                        int i3 = fromPosition + 1;
                        miniAppExpItemClickLaunchUtils.startMiniApp(activity, desktopAppInfo2, i3, mutableMapOf, true);
                        Object obj3 = SubPageMiniAppViewHolder.this.mMiniAppItems.get(fromPosition);
                        DesktopAppInfo desktopAppInfo3 = obj3 instanceof DesktopAppInfo ? (DesktopAppInfo) obj3 : null;
                        if (desktopAppInfo3 != null) {
                            SubPageMiniAppViewHolder subPageMiniAppViewHolder = SubPageMiniAppViewHolder.this;
                            desktopAppInfo3.mMiniAppInfo.hostScene = subPageMiniAppViewHolder.getHostScene(fromPosition);
                            if (desktopAppInfo3.mMiniAppInfo.isWxMiniApp()) {
                                desktopAppInfo3.mMiniAppInfo.via = "";
                            } else {
                                desktopAppInfo3.mMiniAppInfo.hostScene = "";
                            }
                            MiniAppExpDesktop04239ReportHelper.reportWithAppInfo$default(MiniAppExpDesktop04239ReportHelper.INSTANCE, desktopAppInfo3.mMiniAppInfo, subPageMiniAppViewHolder.mVia, "pg_click", null, null, null, null, String.valueOf(i3), 120, null);
                            return;
                        }
                        return;
                    }
                    QLog.i("SubPageMiniAppViewHolder", 2, "onItemClick fromPosition:" + fromPosition + "is invalid!");
                }
            });
            this.mSubRvItemListener = miniAppExpInnerRvItemTouchForDragListener;
            this.mSubInnerRv.addOnItemTouchListener(miniAppExpInnerRvItemTouchForDragListener);
        }
    }

    public final void bindView(ArrayList<DesktopAppInfo> miniAppItems, String via, String hostScene, int moduleType) {
        Intrinsics.checkNotNullParameter(miniAppItems, "miniAppItems");
        Intrinsics.checkNotNullParameter(via, "via");
        Intrinsics.checkNotNullParameter(hostScene, "hostScene");
        this.mVia = via;
        this.mHostScene = hostScene;
        this.mMiniAppItems = miniAppItems;
        this.mModuleType = moduleType;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mMiniAppItems);
        AsyncListDifferDelegationAdapter<DesktopItemInfo> asyncListDifferDelegationAdapter = this.mSubRvAdapter;
        Intrinsics.checkNotNull(asyncListDifferDelegationAdapter);
        asyncListDifferDelegationAdapter.setItems(arrayList);
        AsyncListDifferDelegationAdapter<DesktopItemInfo> asyncListDifferDelegationAdapter2 = this.mSubRvAdapter;
        if (asyncListDifferDelegationAdapter2 != null) {
            asyncListDifferDelegationAdapter2.notifyDataSetChanged();
        }
    }

    public final MiniExpValidExpoReportHelper getMExpoReportHelper() {
        return this.mExpoReportHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getHostScene(int fromPosition) {
        String valueOf;
        if (fromPosition < 9) {
            valueOf = "0" + (fromPosition + 1);
        } else {
            valueOf = String.valueOf(fromPosition + 1);
        }
        return this.mHostScene + valueOf;
    }
}
