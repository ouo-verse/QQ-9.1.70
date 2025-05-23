package dx1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPanelListItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends RecyclerView.Adapter<h> {
    private List<GProGuildRobotPanelListItem> C;

    /* renamed from: m, reason: collision with root package name */
    private cx1.a f395156m;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull h hVar, int i3) {
        hVar.m(this.C.get(i3), this.f395156m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new h(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f65, viewGroup, false));
    }

    public void k0(List<GProGuildRobotPanelListItem> list, cx1.a aVar, boolean z16) {
        this.f395156m = aVar;
        this.C = list;
        if (z16 && list.size() > 3) {
            this.C = list.subList(0, 3);
        }
        notifyDataSetChanged();
    }
}
