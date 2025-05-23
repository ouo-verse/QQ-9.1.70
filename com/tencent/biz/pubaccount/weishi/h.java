package com.tencent.biz.pubaccount.weishi;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends FragmentPagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private List<QBaseFragment> f80751d;

    public h(FragmentManager fragmentManager, List<QBaseFragment> list) {
        super(fragmentManager);
        this.f80751d = list;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QBaseFragment getItem(int i3) {
        return this.f80751d.get(i3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<QBaseFragment> list = this.f80751d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
