package com.tencent.mobileqq.wink.editor.music.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListPageAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "", "i", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "type", "j", "f", "d", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "e", "()Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "setCurrentTabScene", "(Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;)V", "currentTabScene", "", "Ljava/lang/String;", "pgid", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment;", "Lkotlin/Lazy;", h.F, "()Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment;", "musicRecommendFragment", "g", "musicCollectionFragment", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/lifecycle/ViewModelStoreOwner;", "storeOwner", "", "isCanCancelMusic", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/ViewModelStoreOwner;ZLcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicListPageAdapter extends FragmentStatePagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WinkMusicListFragment.MusicRequestType currentTabScene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pgid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy musicRecommendFragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy musicCollectionFragment;

    public /* synthetic */ WinkMusicListPageAdapter(FragmentManager fragmentManager, ViewModelStoreOwner viewModelStoreOwner, boolean z16, WinkMusicListFragment.MusicRequestType musicRequestType, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager, (i3 & 2) != 0 ? null : viewModelStoreOwner, (i3 & 4) != 0 ? true : z16, (i3 & 8) != 0 ? WinkMusicListFragment.MusicRequestType.RECOMMEND : musicRequestType, (i3 & 16) != 0 ? WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE : str);
    }

    private final WinkMusicListFragment g() {
        return (WinkMusicListFragment) this.musicCollectionFragment.getValue();
    }

    private final WinkMusicListFragment h() {
        return (WinkMusicListFragment) this.musicRecommendFragment.getValue();
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final WinkMusicListFragment.MusicRequestType getCurrentTabScene() {
        return this.currentTabScene;
    }

    public final int f() {
        if (this.currentTabScene == WinkMusicListFragment.MusicRequestType.COLLECTION) {
            return g().Ah();
        }
        return h().Ah();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return 2;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        if (position == 1) {
            return g();
        }
        return h();
    }

    public final void i(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        h().Oh();
        g().Oh();
    }

    public final void j(@NotNull WinkMusicListFragment.MusicRequestType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.currentTabScene = type;
        h().Rh(type);
        g().Rh(type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMusicListPageAdapter(@NotNull FragmentManager fm5, @Nullable final ViewModelStoreOwner viewModelStoreOwner, final boolean z16, @NotNull WinkMusicListFragment.MusicRequestType currentTabScene, @NotNull String pgid) {
        super(fm5, 1);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(currentTabScene, "currentTabScene");
        Intrinsics.checkNotNullParameter(pgid, "pgid");
        this.currentTabScene = currentTabScene;
        this.pgid = pgid;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMusicListFragment>() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListPageAdapter$musicRecommendFragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMusicListFragment invoke() {
                String str;
                WinkMusicListFragment a16 = WinkMusicListFragment.INSTANCE.a(WinkMusicListPageAdapter.this.getCurrentTabScene(), viewModelStoreOwner);
                WinkMusicListPageAdapter winkMusicListPageAdapter = WinkMusicListPageAdapter.this;
                boolean z17 = z16;
                a16.Rh(winkMusicListPageAdapter.getCurrentTabScene());
                a16.Qh(z17);
                str = winkMusicListPageAdapter.pgid;
                a16.Sh(str);
                return a16;
            }
        });
        this.musicRecommendFragment = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMusicListFragment>() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListPageAdapter$musicCollectionFragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMusicListFragment invoke() {
                String str;
                WinkMusicListFragment a16 = WinkMusicListFragment.INSTANCE.a(WinkMusicListFragment.MusicRequestType.COLLECTION, ViewModelStoreOwner.this);
                WinkMusicListPageAdapter winkMusicListPageAdapter = this;
                boolean z17 = z16;
                a16.Rh(winkMusicListPageAdapter.getCurrentTabScene());
                a16.Qh(z17);
                str = winkMusicListPageAdapter.pgid;
                a16.Sh(str);
                return a16;
            }
        });
        this.musicCollectionFragment = lazy2;
    }
}
