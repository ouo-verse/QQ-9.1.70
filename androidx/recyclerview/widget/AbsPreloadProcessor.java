package androidx.recyclerview.widget;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWPreloadExecutor;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.richframework.preload.activity.ArgusPreloadManager;
import com.tencent.webbundle.sdk.WebBundleConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u0016J,\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u001c\u0010\u001d\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H&J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H&J(\u0010'\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010%\u001a\u0004\u0018\u00010&J>\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Landroidx/recyclerview/widget/AbsPreloadProcessor;", "", "()V", "allHistoryViewHolderData", "", "", "Landroidx/recyclerview/widget/ViewHolderData;", "lastHandlePosition", "getLastHandlePosition", "()I", "setLastHandlePosition", "(I)V", "lastHandleRecyclerView", "getLastHandleRecyclerView", "setLastHandleRecyclerView", "layoutIdCache", "getHistoryViewHolderData", "attachHolders", "Ljava/util/LinkedHashSet;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/collections/LinkedHashSet;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutIdWithViewTypeWithSection", "viewType", "targetDelegationAdapters", "", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "recyclerViewHashCode", "getTargetAdapters", "recyclerView", "isTargetProcess", "", "preloadAfterScrolled", "", "preloadConfig", "Landroidx/recyclerview/widget/ItemPreloadConfig;", "historyInfo", "Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", WebBundleConstants.EVENT_TYPE_OF_PRELOAD_VIEW, "requireItemType", "Landroid/util/SparseIntArray;", "recyclerCount", "tryCreateViewHolderWithViewType", "itemType", "mustCreateCount", "PreloadTask", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public abstract class AbsPreloadProcessor {
    private int lastHandleRecyclerView;
    private final Map<Integer, Integer> layoutIdCache = new LinkedHashMap();
    private final Map<Integer, Map<Integer, ViewHolderData>> allHistoryViewHolderData = new LinkedHashMap();
    private int lastHandlePosition = Integer.MIN_VALUE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Landroidx/recyclerview/widget/AbsPreloadProcessor$PreloadTask;", "Ljava/lang/Runnable;", "itemType", "", "viewWrf", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "mustCreateCount", "historyPreloadRequest", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "layoutId", "historyInfo", "Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", "(ILjava/lang/ref/WeakReference;ILcom/tencent/biz/richframework/layoutinflater/PreloadRequest;ILandroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;)V", "getHistoryInfo", "()Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", "getHistoryPreloadRequest", "()Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "getItemType", "()I", "getLayoutId", "getMustCreateCount", "getViewWrf", "()Ljava/lang/ref/WeakReference;", TencentLocation.RUN_MODE, "", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public static final class PreloadTask implements Runnable {

        @Nullable
        private final RecyclerViewInflateHistoryInfo historyInfo;

        @Nullable
        private final PreloadRequest historyPreloadRequest;
        private final int itemType;
        private final int layoutId;
        private final int mustCreateCount;

        @NotNull
        private final WeakReference<RecyclerView> viewWrf;

        public PreloadTask(int i3, @NotNull WeakReference<RecyclerView> viewWrf, int i16, @Nullable PreloadRequest preloadRequest, int i17, @Nullable RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo) {
            Intrinsics.checkNotNullParameter(viewWrf, "viewWrf");
            this.itemType = i3;
            this.viewWrf = viewWrf;
            this.mustCreateCount = i16;
            this.historyPreloadRequest = preloadRequest;
            this.layoutId = i17;
            this.historyInfo = recyclerViewInflateHistoryInfo;
        }

        @Nullable
        public final RecyclerViewInflateHistoryInfo getHistoryInfo() {
            return this.historyInfo;
        }

        @Nullable
        public final PreloadRequest getHistoryPreloadRequest() {
            return this.historyPreloadRequest;
        }

        public final int getItemType() {
            return this.itemType;
        }

        public final int getLayoutId() {
            return this.layoutId;
        }

        public final int getMustCreateCount() {
            return this.mustCreateCount;
        }

        @NotNull
        public final WeakReference<RecyclerView> getViewWrf() {
            return this.viewWrf;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo;
            Map<PreloadRequest, Integer> map;
            String str;
            RecyclerView recyclerView = this.viewWrf.get();
            if (recyclerView != null) {
                Intrinsics.checkNotNullExpressionValue(recyclerView, "viewWrf.get() ?: return");
                PreloadRequest preloadRequest = this.historyPreloadRequest;
                if (preloadRequest == null) {
                    int i3 = this.layoutId;
                    String name = recyclerView.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "view.javaClass.name");
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        str = layoutManager.getClass().getName();
                    } else {
                        str = "";
                    }
                    preloadRequest = new PreloadRequest(i3, name, str);
                }
                RFWLayoutPreLoader layoutPreLoader = ArgusPreloadManager.INSTANCE.getLayoutPreLoader();
                Context context = recyclerView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                int fillPreloadView = layoutPreLoader.fillPreloadView(context, preloadRequest, this.mustCreateCount);
                if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                    RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "itemLayoutId:" + getLayoutId() + " parentViewClassName:" + preloadRequest.getParentViewClassName() + " layoutManager:" + preloadRequest.getItemLayoutManager() + "mustCreateCount:" + getMustCreateCount() + " needPreloadCount:" + fillPreloadView);
                }
                if (fillPreloadView > 0 && (recyclerViewInflateHistoryInfo = this.historyInfo) != null && (map = recyclerViewInflateHistoryInfo.getViewTypeSubLayoutInfo().get(Integer.valueOf(this.itemType))) != null) {
                    for (Map.Entry<PreloadRequest, Integer> entry : map.entrySet()) {
                        if (entry.getKey().getResId() != 0) {
                            RFWLayoutPreLoader layoutPreLoader2 = ArgusPreloadManager.INSTANCE.getLayoutPreLoader();
                            Context context2 = recyclerView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                            int fillPreloadView2 = layoutPreLoader2.fillPreloadView(context2, entry.getKey(), entry.getValue().intValue() * fillPreloadView);
                            if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "itemType:" + getItemType() + " need create subLayout: " + entry.getKey() + " allRequireCount: " + (entry.getValue().intValue() * fillPreloadView) + " finalPreloadCount: " + fillPreloadView2);
                            }
                        }
                    }
                }
            }
        }

        public /* synthetic */ PreloadTask(int i3, WeakReference weakReference, int i16, PreloadRequest preloadRequest, int i17, RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, weakReference, i16, (i18 & 8) != 0 ? null : preloadRequest, i17, recyclerViewInflateHistoryInfo);
        }
    }

    private final int getLayoutIdWithViewTypeWithSection(int viewType, List<? extends AsyncListDifferDelegationAdapter<?>> targetDelegationAdapters, int recyclerViewHashCode) {
        int i3 = recyclerViewHashCode + viewType;
        Integer num = this.layoutIdCache.get(Integer.valueOf(i3));
        if (num instanceof Integer) {
            return num.intValue();
        }
        if (targetDelegationAdapters != null) {
            Iterator<T> it = targetDelegationAdapters.iterator();
            while (it.hasNext()) {
                AdapterDelegate delegateForViewType = ((AsyncListDifferDelegationAdapter) it.next()).getDelegatesManager().getDelegateForViewType(viewType);
                if (!(delegateForViewType instanceof AbsItemAdapterDelegate)) {
                    delegateForViewType = null;
                }
                AbsItemAdapterDelegate absItemAdapterDelegate = (AbsItemAdapterDelegate) delegateForViewType;
                if (absItemAdapterDelegate != null) {
                    int layoutId = absItemAdapterDelegate.getLayoutId();
                    this.layoutIdCache.put(Integer.valueOf(i3), Integer.valueOf(layoutId));
                    return layoutId;
                }
            }
        }
        this.layoutIdCache.put(Integer.valueOf(i3), 0);
        return 0;
    }

    private final List<AsyncListDifferDelegationAdapter<?>> getTargetAdapters(RecyclerView recyclerView) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        List<AsyncListDifferDelegationAdapter<?>> filterIsInstance;
        List<AsyncListDifferDelegationAdapter<?>> listOf;
        if (recyclerView.getAdapter() instanceof AsyncListDifferDelegationAdapter) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf((AsyncListDifferDelegationAdapter) adapter);
                return listOf;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter<*>");
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        if (!(adapter2 instanceof RFWConcatAdapter)) {
            adapter2 = null;
        }
        RFWConcatAdapter rFWConcatAdapter = (RFWConcatAdapter) adapter2;
        if (rFWConcatAdapter != null && (adapters = rFWConcatAdapter.getAdapters()) != null) {
            filterIsInstance = CollectionsKt___CollectionsJvmKt.filterIsInstance(adapters, AsyncListDifferDelegationAdapter.class);
            return filterIsInstance;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void tryCreateViewHolderWithViewType(int itemType, RecyclerView view, int mustCreateCount, List<? extends AsyncListDifferDelegationAdapter<?>> targetDelegationAdapters, RecyclerViewInflateHistoryInfo historyInfo) {
        PreloadRequest preloadRequest;
        int i3;
        int i16;
        if (historyInfo != null) {
            preloadRequest = historyInfo.getViewTypeToResLayoutId().get(Integer.valueOf(itemType));
            if (preloadRequest != null) {
                i3 = preloadRequest.getResId();
                PreloadRequest preloadRequest2 = preloadRequest;
                if (i3 != 0 && ItemPreloadConfigManager.INSTANCE.getPreloadConfig().getUseSection()) {
                    i16 = getLayoutIdWithViewTypeWithSection(itemType, targetDelegationAdapters, view.hashCode());
                } else {
                    i16 = i3;
                }
                if (i16 == 0 && view.getLayoutManager() != null) {
                    RFWPreloadExecutor.INSTANCE.execute(new PreloadTask(itemType, new WeakReference(view), mustCreateCount, preloadRequest2, i16, historyInfo));
                    return;
                }
                if (!ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                    RFWLog.e(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "tryCreateViewHolderWithViewType failed, itemType:" + itemType + " but layoutId:" + i16 + " manager:" + view.getLayoutManager());
                    return;
                }
                return;
            }
        } else {
            preloadRequest = null;
        }
        i3 = 0;
        PreloadRequest preloadRequest22 = preloadRequest;
        if (i3 != 0) {
        }
        i16 = i3;
        if (i16 == 0) {
        }
        if (!ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
        }
    }

    @NotNull
    public final Map<Integer, ViewHolderData> getHistoryViewHolderData(@NotNull LinkedHashSet<RecyclerView.ViewHolder> attachHolders, @NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(attachHolders, "attachHolders");
        Intrinsics.checkNotNullParameter(view, "view");
        Map<Integer, Map<Integer, ViewHolderData>> map = this.allHistoryViewHolderData;
        Integer valueOf = Integer.valueOf(view.hashCode());
        Map<Integer, ViewHolderData> map2 = map.get(valueOf);
        if (map2 == null) {
            map2 = new LinkedHashMap<>();
            for (RecyclerView.ViewHolder viewHolder : attachHolders) {
                View view2 = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "attachHolder.itemView");
                int height = view2.getHeight();
                Integer valueOf2 = Integer.valueOf(viewHolder.getItemViewType());
                ViewHolderData viewHolderData = map2.get(valueOf2);
                if (viewHolderData == null) {
                    viewHolderData = new ViewHolderData(0, 0);
                    map2.put(valueOf2, viewHolderData);
                }
                viewHolderData.add(height);
            }
            map.put(valueOf, map2);
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getLastHandlePosition() {
        return this.lastHandlePosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getLastHandleRecyclerView() {
        return this.lastHandleRecyclerView;
    }

    public abstract boolean isTargetProcess(@NotNull RecyclerView view);

    public abstract void preloadAfterScrolled(@NotNull RecyclerView view, @NotNull ItemPreloadConfig preloadConfig, @Nullable RecyclerViewInflateHistoryInfo historyInfo);

    public final void preloadView(@NotNull RecyclerView view, @NotNull SparseIntArray requireItemType, @NotNull SparseIntArray recyclerCount, @Nullable RecyclerViewInflateHistoryInfo historyInfo) {
        int i3;
        ArrayList<RecyclerView.ViewHolder> arrayList;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(requireItemType, "requireItemType");
        Intrinsics.checkNotNullParameter(recyclerCount, "recyclerCount");
        SparseArray<RecyclerView.RecycledViewPool.ScrapData> sparseArray = view.getRecycledViewPool().mScrap;
        List<AsyncListDifferDelegationAdapter<?>> targetAdapters = getTargetAdapters(view);
        int size = requireItemType.size();
        for (int i16 = 0; i16 < size; i16++) {
            int keyAt = requireItemType.keyAt(i16);
            final int valueAt = requireItemType.valueAt(i16);
            final RecyclerView.RecycledViewPool.ScrapData scrapData = sparseArray.get(keyAt);
            int i17 = valueAt - recyclerCount.get(keyAt, 0);
            if (scrapData != null && (arrayList = scrapData.mScrapHeap) != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            int i18 = i17 - i3;
            if (i18 > 0) {
                if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                    RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "compare recyclerScrap, must create type:" + keyAt + " requireCount:" + valueAt + " mustCreateCount:" + i18);
                }
                tryCreateViewHolderWithViewType(keyAt, view, i18, targetAdapters, historyInfo);
            } else if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "no need create type:" + keyAt);
            }
            view.post(new Runnable() { // from class: androidx.recyclerview.widget.AbsPreloadProcessor$preloadView$3
                @Override // java.lang.Runnable
                public final void run() {
                    int i19;
                    RecyclerView.RecycledViewPool.ScrapData scrapData2 = RecyclerView.RecycledViewPool.ScrapData.this;
                    if (scrapData2 != null && (i19 = valueAt) > scrapData2.mMaxScrap) {
                        scrapData2.mMaxScrap = i19;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setLastHandlePosition(int i3) {
        this.lastHandlePosition = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setLastHandleRecyclerView(int i3) {
        this.lastHandleRecyclerView = i3;
    }
}
