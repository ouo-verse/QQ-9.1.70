package com.tencent.biz.qqcircle.widgets.polymerization;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$MaterialInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f93809d;

    /* renamed from: e, reason: collision with root package name */
    private a f93810e;

    /* renamed from: f, reason: collision with root package name */
    private List<FeedCloudMeta$MaterialInfo> f93811f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleReportBean f93812h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return d.this.f93811f.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            if (d.this.f93811f.size() < i3) {
                return;
            }
            ((b) viewHolder).l((FeedCloudMeta$MaterialInfo) d.this.f93811f.get(i3), i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            QFSPolymerizationTemplateItemView qFSPolymerizationTemplateItemView = new QFSPolymerizationTemplateItemView(viewGroup.getContext());
            qFSPolymerizationTemplateItemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            qFSPolymerizationTemplateItemView.setParentView(viewGroup);
            qFSPolymerizationTemplateItemView.setReportBean(d.this.getReportBean());
            return new b(qFSPolymerizationTemplateItemView);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }

        public void l(FeedCloudMeta$MaterialInfo feedCloudMeta$MaterialInfo, int i3) {
            View view = this.itemView;
            if (view instanceof QCircleBaseWidgetView) {
                view.setTag(this);
                ((QCircleBaseWidgetView) this.itemView).setData(feedCloudMeta$MaterialInfo, i3);
            }
        }
    }

    public void b(List<FeedCloudMeta$MaterialInfo> list) {
        this.f93811f = list;
        this.f93809d.setVisibility(0);
        a aVar = this.f93810e;
        if (aVar == null) {
            a aVar2 = new a();
            this.f93810e = aVar2;
            this.f93809d.setAdapter(aVar2);
            return;
        }
        aVar.notifyDataSetChanged();
    }

    protected String c() {
        return "QFSPolymerizationHeadTemplateListView";
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QCircleReportBean getReportBean() {
        return QCircleReportBean.getReportBean(c(), this.f93812h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f55542i7);
        this.f93809d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
    }

    public void f(QCircleReportBean qCircleReportBean) {
        this.f93812h = QCircleReportBean.setReportBean(c(), qCircleReportBean);
    }
}
