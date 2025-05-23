package com.qzone.reborn.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/base/o;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "", "e", "", "fragmentList", "titles", "", "f", "d", "Ljava/util/List;", "mTitles", "()Ljava/util/List;", "setMFragments", "(Ljava/util/List;)V", "mFragments", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "(Landroidx/fragment/app/FragmentManager;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends FragmentStatePagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<String> mTitles;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<Fragment> mFragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FragmentManager fm5) {
        super(fm5);
        Intrinsics.checkNotNullParameter(fm5, "fm");
        this.mTitles = new ArrayList();
        this.mFragments = new ArrayList();
    }

    public final List<Fragment> d() {
        return this.mFragments;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public String getPageTitle(int position) {
        return this.mTitles.get(position);
    }

    public final void f(List<Fragment> fragmentList, List<String> titles) {
        Intrinsics.checkNotNullParameter(fragmentList, "fragmentList");
        Intrinsics.checkNotNullParameter(titles, "titles");
        this.mFragments = fragmentList;
        this.mTitles = titles;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.mFragments.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        return this.mFragments.get(position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FragmentManager fm5, int i3) {
        super(fm5, i3);
        Intrinsics.checkNotNullParameter(fm5, "fm");
        this.mTitles = new ArrayList();
        this.mFragments = new ArrayList();
    }
}
