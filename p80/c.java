package p80;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.feed.QFSSearchFeedResultHotItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends BaseListViewAdapter<String> {
    private String C;

    /* renamed from: m, reason: collision with root package name */
    private String f425708m;

    public void i0(String str, String str2) {
        this.f425708m = str;
        this.C = str2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (ab0.a.a(i3, getDataList())) {
            return;
        }
        QFSSearchFeedResultHotItemView qFSSearchFeedResultHotItemView = (QFSSearchFeedResultHotItemView) viewHolder.itemView;
        qFSSearchFeedResultHotItemView.setData(getItem(i3), i3);
        qFSSearchFeedResultHotItemView.setReportParams(this.f425708m, this.C);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSSearchFeedResultHotItemView qFSSearchFeedResultHotItemView = new QFSSearchFeedResultHotItemView(viewGroup.getContext());
        qFSSearchFeedResultHotItemView.setParentView(viewGroup);
        return new BaseListViewAdapter.BaseVH(qFSSearchFeedResultHotItemView);
    }
}
