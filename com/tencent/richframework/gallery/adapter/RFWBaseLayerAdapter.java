package com.tencent.richframework.gallery.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.ListDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u0000 #*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001#B\u001b\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u001e\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R$\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/richframework/gallery/adapter/RFWBaseLayerAdapter;", "T", "Lcom/tencent/biz/richframework/part/adapter/ListDelegationAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "", "position", "getRealPosition", "", "switchDurationTime", "J", "getSwitchDurationTime", "()J", "setSwitchDurationTime", "(J)V", "animationTime", "getAnimationTime", "setAnimationTime", "", "mIsEnableLoop", "Z", "mEnableDamp", "enableLoop", "isEnableLoop", "()Z", "setEnableLoop", "(Z)V", "isCanLoop", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "delegatesManager", "<init>", "(Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public abstract class RFWBaseLayerAdapter<T> extends ListDelegationAdapter<T> {
    private long animationTime;
    private boolean mEnableDamp;
    private boolean mIsEnableLoop;
    private long switchDurationTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWBaseLayerAdapter(@NotNull AdapterDelegatesManager<List<T>> delegatesManager) {
        super(delegatesManager);
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
        this.switchDurationTime = 2000L;
        this.animationTime = 1000L;
        this.mIsEnableLoop = true;
    }

    public final long getAnimationTime() {
        return this.animationTime;
    }

    public final int getRealPosition(int position) {
        if (isCanLoop()) {
            int itemCount = (position % getItemCount()) - 1;
            if (itemCount < 0) {
                return getItemCount() - 1;
            }
            return itemCount;
        }
        return position;
    }

    public final long getSwitchDurationTime() {
        return this.switchDurationTime;
    }

    public final boolean isCanLoop() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setOverScrollMode(2);
    }

    public final void setEnableLoop(boolean z16) {
        this.mIsEnableLoop = z16;
        if (z16) {
            this.mEnableDamp = false;
        }
    }
}
