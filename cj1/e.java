package cj1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class e extends b implements SimpleEventReceiver {
    protected final GuildFeedMainInitBean C;
    private boolean D;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }
    }

    public e(GuildFeedMainInitBean guildFeedMainInitBean) {
        super(new Bundle());
        this.D = true;
        this.C = guildFeedMainInitBean;
    }

    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.D ? 1 : 0;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 3;
    }

    protected abstract View k0(ViewGroup viewGroup, MultiViewBlock multiViewBlock);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a(k0(viewGroup, this));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List list) {
        this.mDataList.clear();
        notifyDataSetChanged();
        if (list == null) {
            return;
        }
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
