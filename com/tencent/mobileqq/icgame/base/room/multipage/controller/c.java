package com.tencent.mobileqq.icgame.base.room.multipage.controller;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchPageInfo;
import com.tencent.mobileqq.icgame.base.room.multipage.api.d;
import com.tencent.mobileqq.icgame.base.room.multipage.api.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 72\u00020\u0001:\u00018B1\u0012\b\u00104\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020%\u0012\u0006\u0010*\u001a\u00020(\u00a2\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u000bR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010,R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/c;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "position", "Landroidx/fragment/app/Fragment;", "d", "Landroid/os/Parcelable;", "saveState", "", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "list", "", "j", "", "g", "getCount", "getItem", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "object", "setPrimaryItem", "instantiateItem", "destroyItem", "getItemPosition", "e", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "f", "pageInfo", "i", h.F, "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/b;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/b;", "pageCreator", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/d;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/d;", "viewPagerImpl", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/e;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/e;", "pageOperationListener", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "fragmentSparseArray", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "switchInfoList", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/fragment/app/Fragment;", "currentFragment", "initInfo", "<init>", "(Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;Landroidx/fragment/app/FragmentManager;Lcom/tencent/mobileqq/icgame/base/room/multipage/api/b;Lcom/tencent/mobileqq/icgame/base/room/multipage/api/d;Lcom/tencent/mobileqq/icgame/base/room/multipage/api/e;)V", "D", "a", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends FragmentStatePagerAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Fragment currentFragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FragmentManager fragmentManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.icgame.base.room.multipage.api.b pageCreator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d viewPagerImpl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e pageOperationListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<Fragment> fragmentSparseArray;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SwitchPageInfo> switchInfoList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@Nullable SwitchPageInfo switchPageInfo, @NotNull FragmentManager fragmentManager, @NotNull com.tencent.mobileqq.icgame.base.room.multipage.api.b pageCreator, @NotNull d viewPagerImpl, @NotNull e pageOperationListener) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(pageCreator, "pageCreator");
        Intrinsics.checkNotNullParameter(viewPagerImpl, "viewPagerImpl");
        Intrinsics.checkNotNullParameter(pageOperationListener, "pageOperationListener");
        this.fragmentManager = fragmentManager;
        this.pageCreator = pageCreator;
        this.viewPagerImpl = viewPagerImpl;
        this.pageOperationListener = pageOperationListener;
        SparseArray<Fragment> sparseArray = new SparseArray<>();
        this.fragmentSparseArray = sparseArray;
        ArrayList arrayList = new ArrayList();
        this.switchInfoList = arrayList;
        if (switchPageInfo != null) {
            arrayList.add(switchPageInfo);
            sparseArray.put(0, d(0));
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Fragment d(int position) {
        e22.b.f395373a.a().i("ICGameMultiPageController", "createFragment POSITION = " + position);
        SwitchPageInfo switchPageInfo = this.switchInfoList.get(position);
        switchPageInfo.f(position);
        com.tencent.mobileqq.icgame.base.room.multipage.api.a a16 = this.pageCreator.a(switchPageInfo);
        a16.v1(this.pageOperationListener);
        a16.da(this.switchInfoList.get(position));
        a16.Hd(this.viewPagerImpl);
        if (a16 instanceof Fragment) {
            return (Fragment) a16;
        }
        throw new IllegalArgumentException("page must be a fragment!");
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        super.destroyItem(container, position, object);
        this.fragmentSparseArray.remove(position);
    }

    @Nullable
    public final Fragment e() {
        Fragment fragment = this.currentFragment;
        if (fragment == null) {
            return this.fragmentSparseArray.get(0);
        }
        return fragment;
    }

    @Nullable
    public final SwitchPageInfo f(int item) {
        if (this.switchInfoList.size() > item) {
            return this.switchInfoList.get(item);
        }
        return null;
    }

    @NotNull
    public final List<SwitchPageInfo> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.switchInfoList);
        return arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.switchInfoList.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        if (this.fragmentSparseArray.get(position) == null) {
            return d(position);
        }
        Fragment fragment = this.fragmentSparseArray.get(position);
        Intrinsics.checkNotNullExpressionValue(fragment, "fragmentSparseArray[position]");
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object object) {
        boolean z16;
        Intrinsics.checkNotNullParameter(object, "object");
        com.tencent.mobileqq.icgame.base.room.multipage.api.a aVar = (com.tencent.mobileqq.icgame.base.room.multipage.api.a) object;
        if (aVar.getForceUpdate()) {
            return -2;
        }
        int pageIndex = aVar.getPageInfo().getPageIndex();
        if (pageIndex == this.viewPagerImpl.getCurrentItem() + 1) {
            ActivityResultCaller item = getItem(pageIndex);
            if (item instanceof com.tencent.mobileqq.icgame.base.room.multipage.api.a) {
                z16 = ((com.tencent.mobileqq.icgame.base.room.multipage.api.a) item).getForceUpdate();
            } else {
                z16 = false;
            }
            if (pageIndex < this.switchInfoList.size() && z16) {
                return -2;
            }
        }
        return -1;
    }

    public final void h() {
        int size = this.fragmentSparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            ActivityResultCaller valueAt = this.fragmentSparseArray.valueAt(i3);
            Intrinsics.checkNotNullExpressionValue(valueAt, "fragmentSparseArray.valueAt(i)");
            ActivityResultCaller activityResultCaller = (Fragment) valueAt;
            if (activityResultCaller instanceof com.tencent.mobileqq.icgame.base.room.multipage.api.a) {
                ((com.tencent.mobileqq.icgame.base.room.multipage.api.a) activityResultCaller).Ud(true);
            }
        }
        this.switchInfoList.clear();
        notifyDataSetChanged();
        this.fragmentSparseArray.clear();
        this.currentFragment = null;
    }

    @NotNull
    public final Fragment i(@NotNull SwitchPageInfo pageInfo) {
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        int size = this.fragmentSparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            ActivityResultCaller valueAt = this.fragmentSparseArray.valueAt(i3);
            Intrinsics.checkNotNullExpressionValue(valueAt, "fragmentSparseArray.valueAt(i)");
            ActivityResultCaller activityResultCaller = (Fragment) valueAt;
            if (activityResultCaller instanceof com.tencent.mobileqq.icgame.base.room.multipage.api.a) {
                com.tencent.mobileqq.icgame.base.room.multipage.api.a aVar = (com.tencent.mobileqq.icgame.base.room.multipage.api.a) activityResultCaller;
                aVar.Ud(true);
                aVar.eb();
            }
        }
        this.switchInfoList.clear();
        this.switchInfoList.add(pageInfo);
        this.currentFragment = null;
        this.fragmentSparseArray.clear();
        this.fragmentSparseArray.put(0, d(0));
        notifyDataSetChanged();
        Fragment fragment = this.fragmentSparseArray.get(0);
        Intrinsics.checkNotNullExpressionValue(fragment, "fragmentSparseArray[0]");
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        Object instantiateItem = super.instantiateItem(container, position);
        Intrinsics.checkNotNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment fragment = (Fragment) instantiateItem;
        this.fragmentSparseArray.put(position, fragment);
        return fragment;
    }

    public final void j(@NotNull List<SwitchPageInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.switchInfoList.clear();
        this.switchInfoList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        Bundle bundle = (Bundle) super.saveState();
        if (bundle != null) {
            bundle.remove("states");
        }
        return bundle;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        super.setPrimaryItem(container, position, object);
        this.currentFragment = (Fragment) object;
    }
}
