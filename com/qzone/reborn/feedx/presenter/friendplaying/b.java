package com.qzone.reborn.feedx.presenter.friendplaying;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.reborn.base.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends i<PicText> {

    /* renamed from: m, reason: collision with root package name */
    private BusinessFeedData f55639m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void l(PicText picText, int i3, BusinessFeedData businessFeedData) {
            View view = this.itemView;
            if (view instanceof QZoneFriendPlayingFeedContentItemView) {
                ((QZoneFriendPlayingFeedContentItemView) view).setFeedData(businessFeedData);
                ((QZoneFriendPlayingFeedContentItemView) this.itemView).setData(picText, i3);
            }
        }
    }

    public void i0(BusinessFeedData businessFeedData) {
        this.f55639m = businessFeedData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            ((a) viewHolder).l(getItem(i3), i3, this.f55639m);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        return new a(new QZoneFriendPlayingFeedContentItemView(viewGroup.getContext()));
    }
}
