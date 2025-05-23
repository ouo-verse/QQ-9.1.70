package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSPersonalMenuInfo;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalMenuBaseItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class k extends BaseListViewAdapter<QFSPersonalMenuInfo> {

    /* renamed from: m, reason: collision with root package name */
    private b f88386m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f88387d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f88388e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f88389f;

        a(int i3, List list, RecyclerView.ViewHolder viewHolder) {
            this.f88387d = i3;
            this.f88388e = list;
            this.f88389f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (k.this.f88386m != null) {
                b bVar = k.this.f88386m;
                int i3 = this.f88387d;
                bVar.a(i3, (QFSPersonalMenuInfo) this.f88388e.get(i3), this.f88389f.itemView);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, QFSPersonalMenuInfo qFSPersonalMenuInfo, View view);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<QFSPersonalMenuInfo> dataList = getDataList();
        if (dataList != null) {
            return dataList.size();
        }
        return 0;
    }

    public void j0(b bVar) {
        this.f88386m = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        List<QFSPersonalMenuInfo> dataList = getDataList();
        if (!ab0.a.a(i3, dataList)) {
            ((QFSPersonalMenuBaseItemView) viewHolder.itemView).setData(dataList.get(i3), i3);
            viewHolder.itemView.setOnClickListener(new a(i3, dataList, viewHolder));
        }
    }
}
