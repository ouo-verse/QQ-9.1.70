package com.tencent.biz.richframework.widget.listview.card.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.widget.listview.card.RFWCardExtension;
import com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardHolder;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardListFullScreenAdapter extends RecyclerView.Adapter<ViewHolder> {
    private RFWCardExtension cardExtension;
    private RFWCardViewBuilder cardViewBuilder;
    private final Context context;
    private List<RFWCardModel> dataList;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final HashMap<Integer, IRFWCardHolder> businessHolders;
        private RFWCardExtension cardExtension;
        private final RFWCardViewBuilder cardViewBuilder;
        public View itemView;
        public int mode;

        public ViewHolder(View view, RFWCardViewBuilder rFWCardViewBuilder, int i3) {
            super(view);
            RFWCardViewBuilder.OnLargeBindListener onLargeBindListener;
            HashMap<Integer, IRFWCardHolder> hashMap = new HashMap<>();
            this.businessHolders = hashMap;
            this.mode = i3;
            this.itemView = view;
            this.cardViewBuilder = rFWCardViewBuilder;
            if (rFWCardViewBuilder != null && (onLargeBindListener = rFWCardViewBuilder.onLargeBindListener) != null) {
                IRFWCardHolder onCreate = onLargeBindListener.onCreate(view);
                int hashCode = hashCode();
                if (onCreate != null && !hashMap.containsKey(Integer.valueOf(hashCode))) {
                    hashMap.put(Integer.valueOf(hashCode), onCreate);
                }
            }
        }

        private void resizeCardView(float f16) {
            RFWCardViewBuilder rFWCardViewBuilder = this.cardViewBuilder;
            float f17 = ((int) rFWCardViewBuilder.normalCardWidth) + ((((int) rFWCardViewBuilder.largeCardWidth) - r1) * f16);
            float f18 = ((int) rFWCardViewBuilder.normalCardHeight) + ((((int) rFWCardViewBuilder.largeCardHeight) - r1) * f16);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            layoutParams.width = (int) f17;
            layoutParams.height = (int) f18;
            this.itemView.setLayoutParams(layoutParams);
        }

        public void bindData(RFWCardModel rFWCardModel, int i3, boolean z16) {
            IRFWCardReport iRFWCardReport;
            RFWCardViewBuilder.OnLargeBindListener onLargeBindListener;
            if (rFWCardModel == null) {
                return;
            }
            RFWCardViewBuilder rFWCardViewBuilder = this.cardViewBuilder;
            if (rFWCardViewBuilder != null && (onLargeBindListener = rFWCardViewBuilder.onLargeBindListener) != null) {
                int hashCode = hashCode();
                if (this.businessHolders.containsKey(Integer.valueOf(hashCode))) {
                    onLargeBindListener.onBind(this.businessHolders.get(Integer.valueOf(hashCode)), rFWCardModel, i3);
                }
            }
            RFWCardExtension rFWCardExtension = this.cardExtension;
            if (rFWCardExtension != null && (iRFWCardReport = rFWCardExtension.report) != null && z16) {
                iRFWCardReport.onFullScreenCardElementRegister(this.itemView, i3);
            }
        }

        public void onLayoutDuringAnimation(float f16) {
            RFWCardViewBuilder rFWCardViewBuilder = this.cardViewBuilder;
            if (rFWCardViewBuilder != null && rFWCardViewBuilder.onLargeBindListener != null) {
                resizeCardView(f16);
                RFWCardViewBuilder.OnLargeBindListener onLargeBindListener = this.cardViewBuilder.onLargeBindListener;
                int hashCode = hashCode();
                if (this.businessHolders.containsKey(Integer.valueOf(hashCode))) {
                    onLargeBindListener.onLayoutDuringAnimation(this.businessHolders.get(Integer.valueOf(hashCode)), this.itemView, f16);
                }
            }
        }

        public void setCardExtension(RFWCardExtension rFWCardExtension) {
            this.cardExtension = rFWCardExtension;
        }
    }

    public RFWCardListFullScreenAdapter(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RFWCardModel> list = this.dataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setCardExtension(RFWCardExtension rFWCardExtension) {
        this.cardExtension = rFWCardExtension;
        this.cardViewBuilder = rFWCardExtension.cardViewBuilder;
    }

    public void setData(List<RFWCardModel> list) {
        this.dataList = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i3) {
        RFWCardModel rFWCardModel = this.dataList.get(i3);
        viewHolder.setCardExtension(this.cardExtension);
        viewHolder.bindData(rFWCardModel, i3, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i3) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(this.cardViewBuilder.largeCardResId, viewGroup, false), this.cardViewBuilder, 0);
    }
}
