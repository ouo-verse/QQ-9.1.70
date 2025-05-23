package cn;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends FragmentStateAdapter {

    /* renamed from: m, reason: collision with root package name */
    private List<QZMBaseFragment> f31125m;

    public b(Fragment fragment) {
        super(fragment);
        this.f31125m = new ArrayList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i3) {
        return this.f31125m.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f31125m.size();
    }

    public void i0(List<QZMBaseFragment> list) {
        this.f31125m = list;
        notifyDataSetChanged();
    }
}
