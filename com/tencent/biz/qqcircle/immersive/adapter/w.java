package com.tencent.biz.qqcircle.immersive.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class w extends FragmentStateAdapter {

    /* renamed from: m, reason: collision with root package name */
    private List<QFSBaseFragment> f84739m;

    public w(@NonNull Fragment fragment) {
        super(fragment);
        this.f84739m = new ArrayList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NonNull
    public Fragment createFragment(int i3) {
        return this.f84739m.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f84739m.size();
    }

    public void i0(List<QFSBaseFragment> list) {
        this.f84739m = list;
        notifyDataSetChanged();
    }
}
