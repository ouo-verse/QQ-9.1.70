package dx1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotFeatureInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends RecyclerView.Adapter<c> {
    private List<GProGuildRobotFeatureInfo> C;

    /* renamed from: m, reason: collision with root package name */
    private cx1.a f395149m;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i3) {
        cVar.m(this.C.get(i3), i3, this.f395149m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f56, viewGroup, false));
    }

    public void k0(List<GProGuildRobotFeatureInfo> list, cx1.a aVar, boolean z16) {
        this.f395149m = aVar;
        this.C = list;
        if (z16 && list.size() > 3) {
            this.C = list.subList(0, 4);
        }
        notifyDataSetChanged();
    }
}
