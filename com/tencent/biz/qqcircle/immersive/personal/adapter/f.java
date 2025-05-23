package com.tencent.biz.qqcircle.immersive.personal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSCollectAlbumFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalCollectBoxFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalCollectedFeedFragment;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends FragmentStateAdapter {
    public f(@NonNull Fragment fragment) {
        super(fragment);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NonNull
    public Fragment createFragment(int i3) {
        if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.g()) {
            return new QFSPersonalCollectBoxFragment();
        }
        if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.i()) {
            return new QFSPersonalCollectedFeedFragment();
        }
        return new QFSCollectAlbumFragment();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3;
        if (com.tencent.biz.qqcircle.immersive.personal.utils.j.a()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            return i3 + 1;
        }
        return i3;
    }
}
