package com.tencent.state.status;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RecordResourceInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SingleResourceInfo;
import com.tencent.state.square.databinding.VasSquareDetailMeMultiActionItemBinding;
import com.tencent.state.square.mmkv.IMMKV;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001<B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\b\u0010!\u001a\u00020\u0017H\u0002J\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u0017J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0017H\u0002J\u0012\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0006\u0010,\u001a\u00020\u001cJ\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0017H\u0016J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0017H\u0016J\"\u00104\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00172\u0006\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u00107\u001a\u00020\u0017J\u0015\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010:J\u0014\u0010;\u001a\u00020\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelHolder;", "Lcom/tencent/state/status/ISquareOnlineStatusMultiActionPanelListener;", "context", "Landroid/content/Context;", "panelView", "Landroidx/recyclerview/widget/RecyclerView;", "reportDependency", "Lcom/tencent/state/status/IReportDependency;", "mmkv", "Lcom/tencent/state/square/mmkv/IMMKV;", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/state/status/IReportDependency;Lcom/tencent/state/square/mmkv/IMMKV;)V", "changedListener", "Lcom/tencent/state/status/ISelectedChangedListener;", "getChangedListener", "()Lcom/tencent/state/status/ISelectedChangedListener;", "setChangedListener", "(Lcom/tencent/state/status/ISelectedChangedListener;)V", "dataList", "", "Lcom/tencent/state/square/data/BaseResourceInfo;", "defaultActionId", "", "Ljava/lang/Integer;", "scrollListener", "Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelAdapter$OnScrollListener;", "checkAndRefreshSelectedState", "", "targetIndex", QCircleLpReportDc05507.KEY_CLEAR, "", "clearActionId", "defaultActionIndex", "getCurSelectedIndex", "getDefaultPickIndex", "getItemCount", "getOnlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "getYOffset", "index", "isDefaultActionId", "data", "Lcom/tencent/state/square/data/SingleResourceInfo;", "isEmpty", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onItemClick", "status", "resourceInfo", "resetSelectedItemToPicked", "setActionId", "actionId", "(Ljava/lang/Integer;)V", "setData", "OnScrollListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusMultiActionPanelAdapter extends RecyclerView.Adapter<SquareOnlineStatusMultiActionPanelHolder> implements ISquareOnlineStatusMultiActionPanelListener {
    private ISelectedChangedListener changedListener;
    private final Context context;
    private List<? extends BaseResourceInfo> dataList;
    private Integer defaultActionId;
    private final IMMKV mmkv;
    private final RecyclerView panelView;
    private final IReportDependency reportDependency;
    private OnScrollListener scrollListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelAdapter$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onIdle", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "(Lkotlin/jvm/functions/Function1;)V", "currentDy", "getCurrentDy", "()I", "setCurrentDy", "(I)V", "getOnIdle", "()Lkotlin/jvm/functions/Function1;", "getIndexWithDy", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class OnScrollListener extends RecyclerView.OnScrollListener {
        private int currentDy;
        private final Function1<Integer, Unit> onIdle;

        /* JADX WARN: Multi-variable type inference failed */
        public OnScrollListener(Function1<? super Integer, Unit> onIdle) {
            Intrinsics.checkNotNullParameter(onIdle, "onIdle");
            this.onIdle = onIdle;
        }

        private final int getIndexWithDy() {
            int roundToInt;
            roundToInt = MathKt__MathJVMKt.roundToInt(this.currentDy / ViewExtensionsKt.dip((Context) SquareBase.INSTANCE.getApp(), 54));
            return roundToInt;
        }

        public final int getCurrentDy() {
            return this.currentDy;
        }

        public final Function1<Integer, Unit> getOnIdle() {
            return this.onIdle;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0) {
                return;
            }
            this.onIdle.invoke(Integer.valueOf(getIndexWithDy()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.currentDy += dy5;
        }

        public final void setCurrentDy(int i3) {
            this.currentDy = i3;
        }
    }

    public /* synthetic */ SquareOnlineStatusMultiActionPanelAdapter(Context context, RecyclerView recyclerView, IReportDependency iReportDependency, IMMKV immkv, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, recyclerView, (i3 & 4) != 0 ? null : iReportDependency, (i3 & 8) != 0 ? SquareBaseKt.getSquareMMKV() : immkv);
    }

    private final boolean checkAndRefreshSelectedState(int targetIndex) {
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            BaseResourceInfo baseResourceInfo = (BaseResourceInfo) obj;
            if (i3 == targetIndex) {
                baseResourceInfo.setSelected(true);
                notifyItemChanged(i3);
            } else if (baseResourceInfo.getHasSelected()) {
                baseResourceInfo.setSelected(false);
                notifyItemChanged(i3);
                z16 = true;
            } else if (baseResourceInfo.getHasPick()) {
                notifyItemChanged(i3);
            }
            i3 = i16;
        }
        return z16;
    }

    private final int defaultActionIndex() {
        Integer num = this.defaultActionId;
        int i3 = -1;
        if (num != null) {
            num.intValue();
            List<? extends BaseResourceInfo> list = this.dataList;
            Iterator<? extends BaseResourceInfo> it = list.iterator();
            int i16 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i16 = -1;
                    break;
                }
                if (it.next().getHasPick()) {
                    break;
                }
                i16++;
            }
            Iterator<? extends BaseResourceInfo> it5 = list.iterator();
            int i17 = 0;
            while (true) {
                if (!it5.hasNext()) {
                    i17 = -1;
                    break;
                }
                if (it5.next().getHasSelected()) {
                    break;
                }
                i17++;
            }
            if (i16 != i17) {
                return i17;
            }
            int i18 = 0;
            for (Object obj : list) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                BaseResourceInfo baseResourceInfo = (BaseResourceInfo) obj;
                baseResourceInfo.setSelected(false);
                if (isDefaultActionId((SingleResourceInfo) (!(baseResourceInfo instanceof SingleResourceInfo) ? null : baseResourceInfo))) {
                    baseResourceInfo.setSelected(true);
                    i3 = i18;
                }
                i18 = i19;
            }
            clearActionId();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getYOffset(int index) {
        int dip = index * ViewExtensionsKt.dip(this.context, 54);
        OnScrollListener onScrollListener = this.scrollListener;
        return dip - (onScrollListener != null ? onScrollListener.getCurrentDy() : 0);
    }

    private final boolean isDefaultActionId(SingleResourceInfo data) {
        Resource resource;
        Integer num = this.defaultActionId;
        if (num != null) {
            num.intValue();
            if (data != null) {
                Integer num2 = this.defaultActionId;
                RecordResourceInfo resource2 = data.getResource();
                return Intrinsics.areEqual(num2, (resource2 == null || (resource = resource2.getResource()) == null) ? null : Integer.valueOf(resource.getActionId()));
            }
        }
        return false;
    }

    public final void clear() {
        List<? extends BaseResourceInfo> emptyList;
        OnScrollListener onScrollListener = this.scrollListener;
        if (onScrollListener != null) {
            this.panelView.scrollBy(0, -onScrollListener.getCurrentDy());
            this.panelView.removeOnScrollListener(onScrollListener);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.dataList = emptyList;
        this.scrollListener = null;
        this.panelView.post(new Runnable() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelAdapter$clear$2
            @Override // java.lang.Runnable
            public final void run() {
                SquareOnlineStatusMultiActionPanelAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public final ISelectedChangedListener getChangedListener() {
        return this.changedListener;
    }

    public final int getCurSelectedIndex() {
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((BaseResourceInfo) obj).getHasSelected()) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    public final int getDefaultPickIndex() {
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((BaseResourceInfo) obj).getHasPick()) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final OnlineStatus getOnlineStatus() {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataList);
        BaseResourceInfo baseResourceInfo = (BaseResourceInfo) firstOrNull;
        if (baseResourceInfo != null) {
            return baseResourceInfo.getStatus();
        }
        return null;
    }

    public final boolean isEmpty() {
        return this.dataList.isEmpty();
    }

    @Override // com.tencent.state.status.ISquareOnlineStatusMultiActionPanelListener
    public void onItemClick(final int index, OnlineStatus status, BaseResourceInfo resourceInfo) {
        ISelectedChangedListener iSelectedChangedListener;
        String redDotId;
        Intrinsics.checkNotNullParameter(status, "status");
        if (resourceInfo != null && (redDotId = resourceInfo.getRedDotId()) != null) {
            if (redDotId.length() > 0) {
                IMMKV.DefaultImpls.encodeBool$default(this.mmkv, SKey.DetailMe.KEY_ONLINE_STATUS_MULTI_ACTION_ITEM_REDDOT, true, resourceInfo.getRedDotId(), false, 8, null);
            }
        }
        this.panelView.post(new Runnable() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelAdapter$onItemClick$1
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView recyclerView;
                int yOffset;
                recyclerView = SquareOnlineStatusMultiActionPanelAdapter.this.panelView;
                yOffset = SquareOnlineStatusMultiActionPanelAdapter.this.getYOffset(index);
                recyclerView.scrollBy(0, yOffset);
            }
        });
        if (!checkAndRefreshSelectedState(index) || (iSelectedChangedListener = this.changedListener) == null) {
            return;
        }
        iSelectedChangedListener.onSelectChanged(status, resourceInfo);
    }

    public final int resetSelectedItemToPicked() {
        Object firstOrNull;
        List<? extends BaseResourceInfo> list = this.dataList;
        if (list.isEmpty()) {
            return -1;
        }
        int defaultActionIndex = defaultActionIndex();
        Iterator<? extends BaseResourceInfo> it = list.iterator();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                i16 = -1;
                break;
            }
            if (it.next().getHasPick()) {
                break;
            }
            i16++;
        }
        Iterator<? extends BaseResourceInfo> it5 = list.iterator();
        int i17 = 0;
        while (true) {
            if (!it5.hasNext()) {
                i17 = -1;
                break;
            }
            if (it5.next().getHasSelected()) {
                break;
            }
            i17++;
        }
        if (defaultActionIndex == -1 || i16 == i17) {
            if (i16 != -1 || i17 != -1) {
                return i16 != i17 ? i17 : i16;
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            BaseResourceInfo baseResourceInfo = (BaseResourceInfo) firstOrNull;
            if (baseResourceInfo == null) {
                return 0;
            }
            baseResourceInfo.setSelected(true);
            return 0;
        }
        for (Object obj : list) {
            int i18 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            BaseResourceInfo baseResourceInfo2 = (BaseResourceInfo) obj;
            baseResourceInfo2.setSelected(baseResourceInfo2.getHasPick());
            if (isDefaultActionId((SingleResourceInfo) (!(baseResourceInfo2 instanceof SingleResourceInfo) ? null : baseResourceInfo2))) {
                baseResourceInfo2.setSelected(true);
            }
            i3 = i18;
        }
        return defaultActionIndex;
    }

    public final void setActionId(Integer actionId) {
        this.defaultActionId = actionId;
    }

    public final void setChangedListener(ISelectedChangedListener iSelectedChangedListener) {
        this.changedListener = iSelectedChangedListener;
    }

    public final void setData(List<? extends BaseResourceInfo> data) {
        int i3;
        Object orNull;
        Intrinsics.checkNotNullParameter(data, "data");
        int i16 = 0;
        if (Intrinsics.areEqual(this.dataList, data) && this.dataList.size() == data.size()) {
            Iterator<? extends BaseResourceInfo> it = data.iterator();
            int i17 = 0;
            while (true) {
                i3 = -1;
                if (!it.hasNext()) {
                    i17 = -1;
                    break;
                } else if (it.next().getHasPick()) {
                    break;
                } else {
                    i17++;
                }
            }
            Iterator<? extends BaseResourceInfo> it5 = data.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (it5.next().getHasSelected()) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
            if (i17 != i3) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, i3);
                BaseResourceInfo baseResourceInfo = (BaseResourceInfo) orNull;
                if (baseResourceInfo != null) {
                    onItemClick(i3, baseResourceInfo.getStatus(), baseResourceInfo);
                    return;
                }
                return;
            }
            return;
        }
        OnScrollListener onScrollListener = this.scrollListener;
        if (onScrollListener != null) {
            this.panelView.scrollBy(0, -onScrollListener.getCurrentDy());
            this.panelView.removeOnScrollListener(onScrollListener);
        }
        OnScrollListener onScrollListener2 = new OnScrollListener(new Function1<Integer, Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelAdapter$setData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i18) {
                List list;
                Object orNull2;
                list = SquareOnlineStatusMultiActionPanelAdapter.this.dataList;
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(list, i18);
                BaseResourceInfo baseResourceInfo2 = (BaseResourceInfo) orNull2;
                if (baseResourceInfo2 != null) {
                    SquareOnlineStatusMultiActionPanelAdapter.this.onItemClick(i18, baseResourceInfo2.getStatus(), baseResourceInfo2);
                }
            }
        });
        this.scrollListener = onScrollListener2;
        this.panelView.addOnScrollListener(onScrollListener2);
        this.dataList = data;
        this.panelView.post(new Runnable() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelAdapter$setData$5
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView recyclerView;
                int yOffset;
                int resetSelectedItemToPicked = SquareOnlineStatusMultiActionPanelAdapter.this.resetSelectedItemToPicked();
                SquareOnlineStatusMultiActionPanelAdapter.this.notifyDataSetChanged();
                if (resetSelectedItemToPicked != -1) {
                    recyclerView = SquareOnlineStatusMultiActionPanelAdapter.this.panelView;
                    yOffset = SquareOnlineStatusMultiActionPanelAdapter.this.getYOffset(resetSelectedItemToPicked);
                    recyclerView.scrollBy(0, yOffset);
                }
            }
        });
    }

    public SquareOnlineStatusMultiActionPanelAdapter(Context context, RecyclerView panelView, IReportDependency iReportDependency, IMMKV mmkv) {
        List<? extends BaseResourceInfo> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelView, "panelView");
        Intrinsics.checkNotNullParameter(mmkv, "mmkv");
        this.context = context;
        this.panelView = panelView;
        this.reportDependency = iReportDependency;
        this.mmkv = mmkv;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.dataList = emptyList;
    }

    public final void clearActionId() {
        this.defaultActionId = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SquareOnlineStatusMultiActionPanelHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindData(this.dataList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SquareOnlineStatusMultiActionPanelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareDetailMeMultiActionItemBinding inflate = VasSquareDetailMeMultiActionItemBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailMeMultiAc\u2026          )\n            )");
        FrameLayout mRv = inflate.getMRv();
        mRv.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(mRv, "VasSquareDetailMeMultiAc\u2026          )\n            }");
        return new SquareOnlineStatusMultiActionPanelHolder(mRv, this, this.reportDependency, this.mmkv);
    }
}
