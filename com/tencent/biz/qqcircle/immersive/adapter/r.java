package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleTabNameInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r extends FragmentPagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private List<? extends Fragment> f84732d;

    /* renamed from: e, reason: collision with root package name */
    private final List<QCircleTabNameInfo> f84733e;

    /* renamed from: f, reason: collision with root package name */
    private final FragmentManager f84734f;

    /* renamed from: h, reason: collision with root package name */
    private FragmentTransaction f84735h;

    public r(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        this.f84732d = new ArrayList();
        this.f84733e = new ArrayList();
        this.f84734f = fragmentManager;
    }

    public void d(List<? extends Fragment> list) {
        this.f84732d = list;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull @NotNull ViewGroup viewGroup, int i3, @NonNull @NotNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f84735h == null) {
            this.f84735h = this.f84734f.beginTransaction();
        }
        QLog.d("QFSMainTabFragmentAdapter", 1, "destroyItem fragment:" + fragment);
        this.f84735h.remove(fragment);
        try {
            Field declaredField = FragmentPagerAdapter.class.getDeclaredField("mCurrentPrimaryItem");
            declaredField.setAccessible(true);
            Fragment fragment2 = (Fragment) declaredField.get(this);
            if (fragment2 != null && fragment2.equals(fragment)) {
                declaredField.set(this, null);
                QLog.d("QFSMainTabFragmentAdapter", 1, "currentPrimaryFragment null");
            }
        } catch (Exception e16) {
            QLog.e("QFSMainTabFragmentAdapter", 1, "destroyItem error:", e16);
        }
    }

    public void e(List<QCircleTabNameInfo> list) {
        this.f84733e.clear();
        this.f84733e.addAll(list);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull @NotNull ViewGroup viewGroup) {
        try {
            super.finishUpdate(viewGroup);
            FragmentTransaction fragmentTransaction = this.f84735h;
            if (fragmentTransaction != null) {
                fragmentTransaction.commitAllowingStateLoss();
                this.f84735h = null;
            }
        } catch (Exception e16) {
            QLog.e("QFSMainTabFragmentAdapter", 1, "finishUpdate error:" + e16);
            if (!QCircleHostConstants._AppSetting.isDebugVersion()) {
            } else {
                throw e16;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f84732d.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i3) {
        if (ab0.a.a(i3, this.f84732d)) {
            return null;
        }
        return this.f84732d.get(i3);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i3) {
        return this.f84732d.get(i3).hashCode();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull @NotNull Object obj) {
        if (obj instanceof Fragment) {
            int indexOf = this.f84732d.indexOf(obj);
            if (indexOf != -1) {
                return indexOf;
            }
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i3) {
        if (ab0.a.a(i3, this.f84733e)) {
            return "";
        }
        return this.f84733e.get(i3).getShowTabName();
    }
}
