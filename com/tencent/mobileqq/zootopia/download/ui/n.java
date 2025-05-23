package com.tencent.mobileqq.zootopia.download.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016R$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/n;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "Landroidx/fragment/app/Fragment;", "fragment", "", "addFragment", "", "getCount", "position", "getItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "fragments", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n extends FragmentStatePagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Fragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FragmentManager fm5) {
        super(fm5);
        Intrinsics.checkNotNullParameter(fm5, "fm");
        this.fragments = new ArrayList<>();
    }

    public final void addFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragments.add(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.fragments.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        Fragment fragment = this.fragments.get(position);
        Intrinsics.checkNotNullExpressionValue(fragment, "fragments[position]");
        return fragment;
    }
}
