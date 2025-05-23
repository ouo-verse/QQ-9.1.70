package com.tencent.mobileqq.mini.out.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.proto.lbsshare.LBSShare$POI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes15.dex */
public class POIAdapter extends BaseAdapter {
    protected LayoutInflater mInflater;
    public int nextBegin;
    protected int textBlack;
    protected int textGray;
    protected List<LBSShare$POI> poiList = new ArrayList();
    public int selectPos = -1;
    public boolean hasMore = true;
    protected int blueColor = Color.rgb(0, 121, 255);

    /* loaded from: classes15.dex */
    public static class PoiItemViewHolder {
        public TextView addrTextView;
        public View chooseView;
        public View detailView;
        public TextView nameTextView;
        public LBSShare$POI poi;
    }

    public POIAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        ThemeUtil.getCurrentThemeInfo().getString("themeId");
        this.textGray = context.getResources().getColor(R.color.skin_gray2);
        this.textBlack = context.getResources().getColor(R.color.skin_black);
    }

    public void addPoiList(List<LBSShare$POI> list, boolean z16) {
        if (list != null && list.size() > 0) {
            this.hasMore = z16;
            this.nextBegin++;
            this.poiList.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<LBSShare$POI> list = this.poiList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        PoiItemViewHolder poiItemViewHolder;
        View view3 = null;
        if (view == null) {
            poiItemViewHolder = new PoiItemViewHolder();
            View inflate = this.mInflater.inflate(R.layout.bdc, (ViewGroup) null);
            poiItemViewHolder.nameTextView = (TextView) inflate.findViewById(R.id.f5p);
            poiItemViewHolder.addrTextView = (TextView) inflate.findViewById(R.id.f164040i7);
            View findViewById = inflate.findViewById(R.id.f166843im3);
            poiItemViewHolder.chooseView = findViewById;
            findViewById.setVisibility(4);
            poiItemViewHolder.detailView = inflate;
            inflate.setTag(poiItemViewHolder);
            view2 = inflate;
        } else {
            view2 = view;
            poiItemViewHolder = (PoiItemViewHolder) view.getTag();
        }
        LBSShare$POI item = getItem(i3);
        if (item != null) {
            poiItemViewHolder.poi = item;
            poiItemViewHolder.nameTextView.setText(item.name.get());
            poiItemViewHolder.addrTextView.setText(item.addr.get());
            if (i3 == this.selectPos) {
                poiItemViewHolder.nameTextView.setTextColor(this.blueColor);
                poiItemViewHolder.addrTextView.setTextColor(this.blueColor);
                poiItemViewHolder.chooseView.setVisibility(0);
            } else {
                poiItemViewHolder.nameTextView.setTextColor(this.textBlack);
                poiItemViewHolder.addrTextView.setTextColor(this.textGray);
                poiItemViewHolder.chooseView.setVisibility(4);
            }
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }

    public void reset() {
        this.nextBegin = 0;
        this.selectPos = -1;
        this.hasMore = true;
        this.poiList.clear();
        notifyDataSetChanged();
    }

    public void select(int i3) {
        if (i3 < this.poiList.size() && i3 != this.selectPos) {
            this.selectPos = i3;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public LBSShare$POI getItem(int i3) {
        int size;
        List<LBSShare$POI> list = this.poiList;
        if (list != null && (size = list.size()) > 0 && i3 > -1 && i3 < size) {
            return this.poiList.get(i3);
        }
        return null;
    }
}
