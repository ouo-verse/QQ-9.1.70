package p80;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.feed.QFSSearchFeedResultRelateItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import feedcloud.FeedCloudMeta$RecommendItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends BaseListViewAdapter<FeedCloudMeta$RecommendItem> {
    private String C;

    /* renamed from: m, reason: collision with root package name */
    private String f425709m;

    public void i0(String str, String str2) {
        this.f425709m = str;
        this.C = str2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (ab0.a.a(i3, getDataList())) {
            return;
        }
        QFSSearchFeedResultRelateItemView qFSSearchFeedResultRelateItemView = (QFSSearchFeedResultRelateItemView) viewHolder.itemView;
        qFSSearchFeedResultRelateItemView.setData(getItem(i3), i3);
        qFSSearchFeedResultRelateItemView.setReportParams(this.f425709m, this.C);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSSearchFeedResultRelateItemView qFSSearchFeedResultRelateItemView = new QFSSearchFeedResultRelateItemView(viewGroup.getContext());
        qFSSearchFeedResultRelateItemView.setParentView(viewGroup);
        return new BaseListViewAdapter.BaseVH(qFSSearchFeedResultRelateItemView);
    }
}
