package com.tencent.luggage.wxa.qq;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends FragmentPagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.xweb.debug.c f138971a;

    public d(FragmentManager fragmentManager, com.tencent.xweb.debug.c cVar) {
        super(fragmentManager);
        this.f138971a = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return 4;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i3) {
        if (i3 == 0) {
            return new e(this.f138971a);
        }
        if (i3 == 1) {
            return new i(this.f138971a);
        }
        if (i3 == 2) {
            return new g(this.f138971a);
        }
        if (i3 == 3) {
            return new h(this.f138971a);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i3) {
        if (i3 == 0) {
            return "\u5185\u6838\u8c03\u8bd5";
        }
        if (i3 == 1) {
            return "\u63d2\u4ef6\u8c03\u8bd5";
        }
        if (i3 == 2) {
            return "\u8c03\u8bd5\u4fe1\u606f";
        }
        if (i3 == 3) {
            return "\u521d\u59cb\u65e5\u5fd7";
        }
        return null;
    }
}
