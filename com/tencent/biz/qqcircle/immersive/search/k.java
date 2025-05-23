package com.tencent.biz.qqcircle.immersive.search;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StSearchSubTag;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends BaseListViewAdapter<FeedCloudRead$StSearchSubTag> {
    private String C;
    private b D;
    private Fragment E;

    /* renamed from: m, reason: collision with root package name */
    private int f89898m = 0;
    private String F = "";
    private String G = "";

    private void j0(View view, int i3, FeedCloudRead$StSearchSubTag feedCloudRead$StSearchSubTag) {
        HashMap hashMap = new HashMap();
        String str = feedCloudRead$StSearchSubTag.text.get();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MAIN_QUERY_TEXT, this.C);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LEVEL2_TAG_INDEX, Integer.valueOf(i3 + 1));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LEVEL2_TAG_NAME, str);
        hashMap.put("xsj_query_text", p.c(this.C, str));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LEVEL2_TAG_INDEX, this.G);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LEVEL2_TAG_NAME, this.F);
        ua0.i.k(view, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_PAGE_LEVEL2_TAG, hashMap, feedCloudRead$StSearchSubTag.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(int i3, FeedCloudRead$StSearchSubTag feedCloudRead$StSearchSubTag, QFSSearchResultSubTagsItemView qFSSearchResultSubTagsItemView, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f89898m = i3;
        notifyDataSetChanged();
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        qFSSearchInfo.k(this.C);
        qFSSearchInfo.j(15);
        b bVar = this.D;
        if (i3 == 0) {
            str = "";
        } else {
            str = feedCloudRead$StSearchSubTag.text.get();
        }
        bVar.a(qFSSearchInfo, str);
        j0(qFSSearchResultSubTagsItemView, i3, feedCloudRead$StSearchSubTag);
        this.F = feedCloudRead$StSearchSubTag.text.get();
        this.G = String.valueOf(i3 + 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void l0(Fragment fragment) {
        this.E = fragment;
    }

    public void m0(String str) {
        this.C = str;
    }

    public void n0(b bVar) {
        this.D = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"NotifyDataSetChanged"})
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) final int i3) {
        boolean z16;
        if (ab0.a.a(i3, getDataList())) {
            return;
        }
        final QFSSearchResultSubTagsItemView qFSSearchResultSubTagsItemView = (QFSSearchResultSubTagsItemView) viewHolder.itemView;
        final FeedCloudRead$StSearchSubTag item = getItem(i3);
        if (this.f89898m == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        qFSSearchResultSubTagsItemView.setSelected(z16);
        qFSSearchResultSubTagsItemView.setData(item, i3);
        qFSSearchResultSubTagsItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.k0(i3, item, qFSSearchResultSubTagsItemView, view);
            }
        });
        j0(qFSSearchResultSubTagsItemView, i3, item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSSearchResultSubTagsItemView qFSSearchResultSubTagsItemView = new QFSSearchResultSubTagsItemView(viewGroup.getContext());
        qFSSearchResultSubTagsItemView.setParentView(viewGroup);
        qFSSearchResultSubTagsItemView.setFragment(this.E);
        return new BaseListViewAdapter.BaseVH(qFSSearchResultSubTagsItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<FeedCloudRead$StSearchSubTag> list) {
        this.f89898m = 0;
        super.setDatas(list);
    }
}
