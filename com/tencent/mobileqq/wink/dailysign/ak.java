package com.tencent.mobileqq.wink.dailysign;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2;
import com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListPageAdapter;
import com.tencent.mobileqq.wink.editor.music.ax;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment;
import com.tencent.mobileqq.wink.editor.music.view.WinkMusicTab;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0014R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/ak;", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2;", "Lr53/a;", "", "Kb", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "", "Za", "Landroid/os/Bundle;", "args", "L9", "Landroidx/lifecycle/ViewModelStoreOwner;", "cb", "Landroidx/lifecycle/MutableLiveData;", "", "J3", "Lcom/tencent/mobileqq/wink/editor/dr;", "H9", "rb", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "", "ic", "P3", "", "Sa", "v0", "Landroidx/lifecycle/MutableLiveData;", "currentPlayerTimeLiveData", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ak extends WinkEditorMusicMenuPartV2 implements r53.a {

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> currentPlayerTimeLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/dailysign/ak$a", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Observer<List<? extends MetaCategory>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable List<MetaCategory> metaCategories) {
            if (!ak.this.ic(metaCategories).isEmpty()) {
                WinkEditorResourceManager.a1().K0().removeObserver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gc(ak this$0, int i3, boolean z16) {
        WinkMusicListFragment.MusicRequestType musicRequestType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.TAG, "[onTabChange] pos:" + i3 + " fromUserClick:" + z16);
        WinkMusicListPageAdapter musicListPageAdapter = this$0.getMusicListPageAdapter();
        if (musicListPageAdapter != null) {
            if (i3 == 0) {
                musicRequestType = WinkMusicListFragment.MusicRequestType.DAILY_SIGN;
            } else {
                musicRequestType = WinkMusicListFragment.MusicRequestType.COLLECTION;
            }
            musicListPageAdapter.j(musicRequestType);
        }
        if (i3 != 0) {
            if (i3 == 1) {
                MusicSourceViewModel Wa = this$0.Wa();
                ax COLLECTION_CATEGORY_INFO = ax.f320779f;
                Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
                Wa.G3(COLLECTION_CATEGORY_INFO);
                return;
            }
            return;
        }
        MusicSourceViewModel Wa2 = this$0.Wa();
        ax DAILY_SIGN_CATEGORY_INFO = ax.f320782i;
        Intrinsics.checkNotNullExpressionValue(DAILY_SIGN_CATEGORY_INFO, "DAILY_SIGN_CATEGORY_INFO");
        Wa2.G3(DAILY_SIGN_CATEGORY_INFO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hc(ak this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d
    @Nullable
    public dr H9() {
        DailySignFragment dailySignFragment;
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof DailySignFragment) {
            dailySignFragment = (DailySignFragment) hostFragment;
        } else {
            dailySignFragment = null;
        }
        if (dailySignFragment == null) {
            return null;
        }
        return dailySignFragment.zi();
    }

    @Override // r53.a
    @NotNull
    public MutableLiveData<Long> J3() {
        return this.currentPlayerTimeLiveData;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        fb().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2
    public void Kb() {
        if (H9() != null && Wa().getGetCategoryMusicListFail()) {
            ic(WinkEditorResourceManager.a1().K0().getValue());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.bringToFront();
        }
        View partRootView2 = getPartRootView();
        if (partRootView2 != null) {
            partRootView2.setClickable(true);
        }
        View partRootView3 = getPartRootView();
        if (partRootView3 != null) {
            partRootView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.ai
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ak.hc(ak.this, view);
                }
            });
        }
        Qb(false);
    }

    @Override // r53.a
    public void P3() {
        WinkEditorResourceManager.a1().K0().observe(getHostFragment(), new a());
        Wa().u4(true);
        Wa().p4(true);
        Xa().I2(false);
        Xa().H2(false);
        MusicVolumeControlViewModel.z2(Xa(), false, false, 2, null);
        Xa().n2(true, true);
        Xa().S1(Xa().Z1(), MusicVolumeControlViewModel.VolumeType.BGM);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2
    protected boolean Sa() {
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2
    public int Za() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2
    @NotNull
    public ViewModelStoreOwner cb() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        return hostFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<String> ic(@Nullable List<MetaCategory> metaCategories) {
        List emptyList;
        Object obj;
        ArrayList<MetaMaterial> arrayList;
        Object obj2;
        Map<String, String> map;
        String str = null;
        if (metaCategories != null) {
            Iterator<T> it = metaCategories.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "music")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MetaCategory metaCategory = (MetaCategory) obj;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        if (Intrinsics.areEqual(((MetaMaterial) obj2).f30533id, "daily_sign_in_recommend_music_list")) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                MetaMaterial metaMaterial = (MetaMaterial) obj2;
                if (metaMaterial != null && (map = metaMaterial.additionalFields) != null) {
                    str = map.get("musicList");
                }
            }
        }
        String str2 = str;
        if (str2 == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<String> arrayList2 = new ArrayList<>(emptyList);
        Wa().M4(arrayList2);
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        fb().setVisibility(8);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2
    protected void rb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.view_pager)");
        Sb((ViewPager) findViewById);
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        Ob(new WinkMusicListPageAdapter(childFragmentManager, cb(), !Sa(), WinkMusicListFragment.MusicRequestType.DAILY_SIGN, WinkDaTongReportConstant.PageId.PG_XSJ_DAILY_SIGNIN_PAGE));
        eb().setAdapter(getMusicListPageAdapter());
        View findViewById2 = rootView.findViewById(R.id.j_o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tab_layout)");
        Rb((WinkMusicTab) findViewById2);
        bb().setTabData(new String[]{"\u63a8\u8350", "\u6536\u85cf"});
        bb().setViewPager(eb());
        bb().setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.wink.dailysign.aj
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                ak.gc(ak.this, i3, z16);
            }
        });
    }
}
