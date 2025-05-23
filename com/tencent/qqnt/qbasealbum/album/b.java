package com.tencent.qqnt.qbasealbum.album;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel;
import com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment;
import com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment;
import com.tencent.qqnt.qbasealbum.preview.viewmodel.PreviewMediaViewModel;
import com.tencent.qqnt.qbasealbum.query.QueryViewModel;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedPanelStateViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001a\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\f\u001a\u0012\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0000\u001a$\u0010\u0017\u001a\u00020\u00162\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u001a\u0012\u0010\u0019\u001a\u00020\u00182\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a8\u0006\u001a"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/share/a;", h.F, "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseMainFragment;", "fragment", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;", "b", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "g", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseFragment;", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "c", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "a", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "f", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "selectedMediaChangedActionLiveData", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedPanelStateViewModel;", "d", "Lcom/tencent/qqnt/qbasealbum/online/viewmodel/a;", "e", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    @NotNull
    public static final AlbumListViewModel a(@NotNull QAlbumBaseMainFragment<?> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(AlbumListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026istViewModel::class.java]");
        return (AlbumListViewModel) viewModel;
    }

    @NotNull
    public static final PickerLocalMediaViewModel b(@NotNull QAlbumBaseMainFragment<?> fragment, @NotNull PageType pageType) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        ViewModel viewModel = new ViewModelProvider(fragment, new a(pageType)).get(PickerLocalMediaViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026diaViewModel::class.java)");
        return (PickerLocalMediaViewModel) viewModel;
    }

    @NotNull
    public static final PreviewMediaViewModel c(@NotNull QAlbumBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!(fragment instanceof QAlbumPreviewMainFragment) && !(fragment instanceof QAlbumPreviewChildFragment)) {
            throw new RuntimeException("WTF");
        }
        ViewModel viewModel = new ViewModelProvider(fragment).get(PreviewMediaViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026diaViewModel::class.java)");
        return (PreviewMediaViewModel) viewModel;
    }

    @NotNull
    public static final SelectedPanelStateViewModel d(@NotNull QAlbumBaseMainFragment<?> fragment, @Nullable LiveData<com.tencent.qqnt.qbasealbum.select.model.a> liveData) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(SelectedPanelStateViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026ateViewModel::class.java)");
        SelectedPanelStateViewModel selectedPanelStateViewModel = (SelectedPanelStateViewModel) viewModel;
        if (liveData != null) {
            selectedPanelStateViewModel.S1(liveData);
        }
        return selectedPanelStateViewModel;
    }

    @NotNull
    public static final com.tencent.qqnt.qbasealbum.online.viewmodel.a e(@NotNull QAlbumBaseMainFragment<?> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return (com.tencent.qqnt.qbasealbum.online.viewmodel.a) new ViewModelProvider(fragment).get(QAlbumPickerContext.f361201a.e().n().c());
    }

    @NotNull
    public static final QueryViewModel f(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = new ViewModelProvider(activity).get(QueryViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026eryViewModel::class.java)");
        return (QueryViewModel) viewModel;
    }

    @NotNull
    public static final SelectedMediaViewModel g(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = new ViewModelProvider(activity).get(SelectedMediaViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026diaViewModel::class.java)");
        return (SelectedMediaViewModel) viewModel;
    }

    @NotNull
    public static final com.tencent.qqnt.qbasealbum.share.a h(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = new ViewModelProvider(activity).get(com.tencent.qqnt.qbasealbum.share.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026ataViewModel::class.java)");
        return (com.tencent.qqnt.qbasealbum.share.a) viewModel;
    }
}
