package com.tencent.qqmini.sdk.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.widget.Switch;
import com.tencent.qqmini.sdk.model.SubscribeItemModel;
import com.tencent.qqmini.sdk.server.R;
import java.util.List;

/* loaded from: classes23.dex */
public class SubscribePermissionAdapter extends RecyclerView.Adapter {
    private final InteractiveListener interactiveListener;
    private List<SubscribeItemModel> subscribeItemList;

    /* loaded from: classes23.dex */
    public interface InteractiveListener {
        void onCheckedChange(int i3, boolean z16);

        void onClickDetail(int i3);
    }

    /* loaded from: classes23.dex */
    public static class SubscribeViewHolder extends RecyclerView.ViewHolder {
        Switch authSwitch;
        TextView contentTextView;
        ImageView detailImageView;

        public SubscribeViewHolder(View view) {
            super(view);
            this.contentTextView = (TextView) view.findViewById(R.id.tv_auth_title);
            this.detailImageView = (ImageView) view.findViewById(R.id.iv_auth_detail);
            this.authSwitch = (Switch) view.findViewById(R.id.sw_auth);
        }
    }

    /* loaded from: classes23.dex */
    public static class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public TitleViewHolder(View view) {
            super(view);
            this.titleTextView = (TextView) view.findViewById(R.id.subscribe_title);
        }
    }

    public SubscribePermissionAdapter(List<SubscribeItemModel> list, InteractiveListener interactiveListener) {
        this.subscribeItemList = list;
        this.interactiveListener = interactiveListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SubscribeItemModel> list = this.subscribeItemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<SubscribeItemModel> list = this.subscribeItemList;
        if (list != null && list.size() > 0) {
            return this.subscribeItemList.get(i3).getViewType().ordinal();
        }
        return SubscribeItemModel.SubscribeViewType.TITLE.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        SubscribeItemModel subscribeItemModel;
        List<SubscribeItemModel> list = this.subscribeItemList;
        if (list != null && (subscribeItemModel = list.get(i3)) != null && viewHolder != null) {
            int ordinal = subscribeItemModel.getViewType().ordinal();
            if (ordinal == SubscribeItemModel.SubscribeViewType.TITLE.ordinal()) {
                ((TitleViewHolder) viewHolder).titleTextView.setText(subscribeItemModel.getContent());
            }
            if (ordinal == SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE.ordinal()) {
                SubscribeViewHolder subscribeViewHolder = (SubscribeViewHolder) viewHolder;
                subscribeViewHolder.contentTextView.setText(subscribeItemModel.getContent());
                subscribeViewHolder.detailImageView.setVisibility(8);
                subscribeViewHolder.authSwitch.setChecked(subscribeItemModel.isChecked());
                final int adapterPosition = viewHolder.getAdapterPosition();
                subscribeViewHolder.authSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter.1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                        if (SubscribePermissionAdapter.this.interactiveListener != null) {
                            SubscribePermissionAdapter.this.interactiveListener.onCheckedChange(adapterPosition, z16);
                        }
                        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
                    }
                });
            }
            if (ordinal == SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE.ordinal() || ordinal == SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE.ordinal()) {
                SubscribeViewHolder subscribeViewHolder2 = (SubscribeViewHolder) viewHolder;
                subscribeViewHolder2.contentTextView.setText(subscribeItemModel.getContent());
                final int adapterPosition2 = viewHolder.getAdapterPosition();
                subscribeViewHolder2.detailImageView.setVisibility(0);
                subscribeViewHolder2.detailImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        if (SubscribePermissionAdapter.this.interactiveListener != null) {
                            SubscribePermissionAdapter.this.interactiveListener.onClickDetail(adapterPosition2);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                subscribeViewHolder2.authSwitch.setChecked(subscribeItemModel.isChecked());
                subscribeViewHolder2.authSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter.3
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                        if (SubscribePermissionAdapter.this.interactiveListener != null) {
                            SubscribePermissionAdapter.this.interactiveListener.onCheckedChange(adapterPosition2, z16);
                        }
                        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i3 == SubscribeItemModel.SubscribeViewType.TITLE.ordinal()) {
            return new TitleViewHolder(from.inflate(R.layout.mini_sdk_once_sub_item_title, viewGroup, false));
        }
        if (i3 != SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE.ordinal() && i3 != SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE.ordinal() && i3 != SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE.ordinal()) {
            return null;
        }
        return new SubscribeViewHolder(from.inflate(R.layout.mini_sdk_once_sub_item_switcher, viewGroup, false));
    }

    public void setData(List<SubscribeItemModel> list) {
        this.subscribeItemList = list;
        notifyDataSetChanged();
    }
}
