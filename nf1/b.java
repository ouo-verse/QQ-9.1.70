package nf1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends RecyclerView.Adapter<a> {
    private List<IGProAppInfo> C = new ArrayList();
    public qf1.a D;

    /* renamed from: m, reason: collision with root package name */
    private Context f420093m;

    public b(Context context) {
        this.f420093m = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @RequiresApi(api = 21)
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        IGProAppInfo iGProAppInfo = this.C.get(i3);
        aVar.l(iGProAppInfo);
        aVar.itemView.setTag(iGProAppInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(this.f420093m).inflate(R.layout.efn, (ViewGroup) null), this);
    }

    public void k0(qf1.a aVar) {
        this.D = aVar;
    }

    public void setData(List<IGProAppInfo> list) {
        if (list != null && list.size() > 0) {
            this.C.clear();
            this.C.addAll(list);
        }
        notifyDataSetChanged();
    }
}
