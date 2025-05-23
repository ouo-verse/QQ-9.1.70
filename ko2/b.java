package ko2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.UfsLabel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name */
    private final List<UfsLabel> f412739m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a extends RecyclerView.ViewHolder {
        private TextView E;

        public a(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.f166942ja3);
        }

        public void l(UfsLabel ufsLabel) {
            b.k0(ufsLabel, this.E);
        }
    }

    public static void k0(UfsLabel ufsLabel, TextView textView) {
        int i3;
        int i16;
        if (textView != null) {
            Context context = textView.getContext();
            textView.setText(ufsLabel.name);
            if (ufsLabel.type == 1) {
                i3 = R.color.qui_common_brand_standard;
                i16 = R.color.qui_common_brand_light;
            } else {
                i3 = R.color.qui_common_text_secondary;
                i16 = R.color.qui_common_fill_standard_primary;
            }
            textView.setTextColor(ie0.a.f().g(context, i3, 1000));
            textView.setBackground(ad.f(ie0.a.f().g(context, i16, 1000), 4, 18, 18));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f412739m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        aVar.l(this.f412739m.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fun, viewGroup, false));
    }

    public void setData(List<UfsLabel> list) {
        this.f412739m.clear();
        this.f412739m.addAll(list);
        notifyDataSetChanged();
    }
}
