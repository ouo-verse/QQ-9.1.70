package mx2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import mx2.d;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends d {
    public e(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override // mx2.d
    protected String l0() {
        return "vertical";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new d.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ggz, viewGroup, false));
    }
}
