package com.tencent.biz.richframework.widget.listview.card.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.widget.listview.card.RFWCardExtension;
import com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardHolder;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import com.tencent.biz.richframework.widget.listview.card.framework.RFWCardListFullScreenBuilder;
import com.tencent.biz.richframework.widget.listview.card.framework.RFWCardLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final HashMap<Integer, IRFWCardHolder> businessHolders = new HashMap<>();
    private RFWCardExtension cardExtension;
    private RFWCardViewBuilder cardViewBuilder;
    private final Context context;
    private List<? extends RFWCardModel> dataList;
    private RFWCardListFullScreenBuilder fullScreenFactory;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public int position;

        public ViewHolder(View view) {
            super(view);
            this.itemView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.richframework.widget.listview.card.framework.adapter.RFWCardListAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    ViewHolder.this.onCardClicked();
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
            if (RFWCardListAdapter.this.cardViewBuilder != null && RFWCardListAdapter.this.cardViewBuilder.onNormalBindListener != null) {
                IRFWCardHolder onCreate = RFWCardListAdapter.this.cardViewBuilder.onNormalBindListener.onCreate(view);
                int hashCode = hashCode();
                if (onCreate != null && !RFWCardListAdapter.this.businessHolders.containsKey(Integer.valueOf(hashCode))) {
                    RFWCardListAdapter.this.businessHolders.put(Integer.valueOf(hashCode), onCreate);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onCardClicked() {
            RFWCardListAdapter rFWCardListAdapter = RFWCardListAdapter.this;
            rFWCardListAdapter.fullScreenFactory = new RFWCardListFullScreenBuilder(rFWCardListAdapter.context).setData(RFWCardListAdapter.this.dataList).setCardExtension(RFWCardListAdapter.this.cardExtension).onFullScreenViewCreate(this.position);
            if (RFWCardListAdapter.this.cardExtension != null && RFWCardListAdapter.this.cardExtension.report != null) {
                RFWCardListAdapter.this.cardExtension.report.onViewClick(this.itemView);
            }
            if (RFWCardLogger.isColorLevel()) {
                RFWCardLogger.debug("RFWCardListAdapter", "onCardClicked, position=" + this.position);
            }
        }

        public void bindData(RFWCardModel rFWCardModel, int i3) {
            if (rFWCardModel == null) {
                return;
            }
            this.position = i3;
            if (RFWCardListAdapter.this.cardViewBuilder != null && RFWCardListAdapter.this.cardViewBuilder.onNormalBindListener != null) {
                int hashCode = hashCode();
                if (RFWCardListAdapter.this.businessHolders.containsKey(Integer.valueOf(hashCode))) {
                    RFWCardListAdapter.this.cardViewBuilder.onNormalBindListener.onBind((IRFWCardHolder) RFWCardListAdapter.this.businessHolders.get(Integer.valueOf(hashCode)), rFWCardModel, i3);
                }
            }
            if (RFWCardListAdapter.this.cardExtension != null && RFWCardListAdapter.this.cardExtension.report != null) {
                RFWCardListAdapter.this.cardExtension.report.onNormalCardElementRegister(this.itemView, i3);
            }
        }
    }

    public RFWCardListAdapter(Context context) {
        this.context = context;
    }

    public RFWCardExtension getCardExtension() {
        return this.cardExtension;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends RFWCardModel> list = this.dataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public boolean onBackPressed() {
        RFWCardListFullScreenBuilder rFWCardListFullScreenBuilder = this.fullScreenFactory;
        if (rFWCardListFullScreenBuilder != null) {
            return rFWCardListFullScreenBuilder.onBackPressed();
        }
        return false;
    }

    public void setCardExtension(RFWCardExtension rFWCardExtension) {
        this.cardExtension = rFWCardExtension;
        this.cardViewBuilder = rFWCardExtension.cardViewBuilder;
    }

    public void setData(List<? extends RFWCardModel> list) {
        this.dataList = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i3) {
        RFWCardModel rFWCardModel = this.dataList.get(i3);
        View view = viewHolder.itemView;
        if (view != null) {
            view.setTag(viewHolder);
        }
        rFWCardModel.setView(view);
        viewHolder.bindData(rFWCardModel, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i3) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(this.cardViewBuilder.normalCardResId, viewGroup, false));
    }
}
