package com.tencent.mobileqq.wink.editor.music.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001b\u0010\u000f\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/adapter/MusicMenuPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment;", "d", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment;", "musicSelectFragment", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "e", "()Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "musicVolumeControlFragment", "Landroidx/fragment/app/FragmentManager;", "fm", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "scene", "Landroidx/lifecycle/ViewModelStoreOwner;", "storeOwner", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;Landroidx/lifecycle/ViewModelStoreOwner;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicMenuPagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy musicSelectFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy musicVolumeControlFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicMenuPagerAdapter(@NotNull FragmentManager fm5, @NotNull final Scene scene, @Nullable final ViewModelStoreOwner viewModelStoreOwner) {
        super(fm5);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(scene, "scene");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicSelectFragment>() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter$musicSelectFragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSelectFragment invoke() {
                return MusicSelectFragment.INSTANCE.a(Scene.this, viewModelStoreOwner);
            }
        });
        this.musicSelectFragment = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlFragment>() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter$musicVolumeControlFragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlFragment invoke() {
                return MusicVolumeControlFragment.INSTANCE.a(Scene.this, viewModelStoreOwner);
            }
        });
        this.musicVolumeControlFragment = lazy2;
    }

    private final MusicSelectFragment d() {
        return (MusicSelectFragment) this.musicSelectFragment.getValue();
    }

    private final MusicVolumeControlFragment e() {
        return (MusicVolumeControlFragment) this.musicVolumeControlFragment.getValue();
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
            return e();
        }
        return d();
    }

    public /* synthetic */ MusicMenuPagerAdapter(FragmentManager fragmentManager, Scene scene, ViewModelStoreOwner viewModelStoreOwner, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager, scene, (i3 & 4) != 0 ? null : viewModelStoreOwner);
    }
}
