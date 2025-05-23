package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class v extends FragmentPagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private List<? extends Fragment> f84737d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f84738e;

    public v(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        this.f84737d = new ArrayList();
        this.f84738e = new ArrayList();
    }

    public void d(List<? extends Fragment> list) {
        this.f84737d = list;
    }

    public void e(List<String> list) {
        this.f84738e.clear();
        this.f84738e.addAll(list);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull @NotNull ViewGroup viewGroup) {
        try {
            super.finishUpdate(viewGroup);
        } catch (Exception e16) {
            QLog.e("QFSMultiTabFragmentAdapter", 1, "finishUpdate error:" + e16);
            QCircleFolderFunnelCollect.recordCrashInfo(QCircleFolderFunnelCollect.EXTRA_ADAPTER_CRASH, e16);
            if (!QCircleHostConstants._AppSetting.isDebugVersion()) {
            } else {
                throw e16;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f84737d.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i3) {
        if (ab0.a.a(i3, this.f84737d)) {
            return null;
        }
        return this.f84737d.get(i3);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i3) {
        return this.f84737d.get(i3).hashCode();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i3) {
        if (ab0.a.a(i3, this.f84738e)) {
            return "";
        }
        return this.f84738e.get(i3);
    }
}
