package i80;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a<T extends QFSSearchBaseWidgetView<FeedCloudMeta$StFeed>> extends BaseListViewAdapter<FeedCloudMeta$StFeed> {
    private QCircleExtraTypeInfo C;
    private Fragment D;

    /* renamed from: m, reason: collision with root package name */
    private int f407351m;

    /* compiled from: P */
    /* renamed from: i80.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C10512a extends RecyclerView.ViewHolder {
        private final T E;

        public C10512a(@NonNull View view) {
            super(view);
            this.E = (T) view;
        }

        public void l(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            this.E.setData(feedCloudMeta$StFeed, i3);
            T t16 = this.E;
            if (t16 instanceof QFSSearchBaseCardItemView) {
                ((QFSSearchBaseCardItemView) t16).setMaxItemCount(a.this.getItemCount());
            }
        }
    }

    protected abstract T i0(Context context, int i3);

    public void j0(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.C = qCircleExtraTypeInfo;
    }

    public void k0(Fragment fragment) {
        this.D = fragment;
    }

    public void l0(int i3) {
        this.f407351m = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        ((C10512a) viewHolder).l(getItem(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        T i06 = i0(viewGroup.getContext(), this.f407351m);
        i06.setParentView(viewGroup);
        i06.setExtraTypeInfo(this.C);
        i06.setFragment(this.D);
        return new C10512a(i06);
    }
}
