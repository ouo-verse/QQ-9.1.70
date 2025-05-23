package com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.view.WSXRecyclerView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends lz.d<j, c> {
    private long C;
    private int D;

    /* renamed from: i, reason: collision with root package name */
    private long f81931i;

    /* renamed from: m, reason: collision with root package name */
    private int f81932m;

    public b(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
        this.f81932m = -1;
        this.D = -1;
    }

    private void C(int i3) {
        if (i3 >= this.f81932m) {
            this.f81932m = i3;
            this.f81931i = System.currentTimeMillis();
        }
        int i16 = this.D;
        if (i3 <= i16 || i16 == -1) {
            this.D = i3;
            this.C = System.currentTimeMillis();
        }
    }

    private String x(int i3) {
        if (i3 < getDataList().size()) {
            return ((j) getDataList().get(i3)).e().f25129id;
        }
        return "";
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(c cVar, int i3) {
        j jVar = (j) getDataList().get(i3);
        if (jVar.isChecked()) {
            this.f415798d = i3;
        }
        cVar.bindData(jVar);
        C(i3);
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public c onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return new c(viewGroup, this);
    }

    public void D(WSXRecyclerView wSXRecyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) wSXRecyclerView.getRecyclerView().getLayoutManager();
        this.C = System.currentTimeMillis();
        this.D = linearLayoutManager.findFirstVisibleItemPosition();
        this.f81931i = System.currentTimeMillis();
        this.f81932m = linearLayoutManager.findLastVisibleItemPosition();
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    public void w(List<j> list) {
        List<M> dataList = getDataList();
        if (dataList == 0 || !dataList.addAll(list)) {
            return;
        }
        notifyItemRangeChanged(dataList.size() - list.size(), list.size());
    }

    public Map<String, String> y() {
        HashMap hashMap = new HashMap();
        hashMap.put("max_feedid", x(this.f81932m));
        hashMap.put("max_times", String.valueOf(this.f81931i));
        hashMap.put("min_feedid", x(this.D));
        hashMap.put("min_times", String.valueOf(this.C));
        hashMap.put(WidgetCacheConstellationData.NUM, String.valueOf(this.f81932m - this.D));
        return hashMap;
    }

    public void z(List<j> list) {
        List<M> dataList = getDataList();
        if (dataList == 0) {
            return;
        }
        if (dataList.addAll(0, list)) {
            notifyItemRangeInserted(0, list.size());
        }
        int size = list.size();
        this.f415798d += size;
        this.f81932m += size;
        this.D += size;
    }
}
