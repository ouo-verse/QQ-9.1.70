package fh0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends RecyclerView.ViewHolder {
    public b(LayoutInflater layoutInflater, ViewGroup viewGroup, int i3) {
        super(layoutInflater.inflate(R.layout.crq, viewGroup, false));
        ViewGroup viewGroup2 = (ViewGroup) this.itemView;
        View inflate = layoutInflater.inflate(i3, viewGroup2, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            viewGroup2.setLayoutParams(layoutParams);
        }
        viewGroup2.addView(inflate);
    }
}
