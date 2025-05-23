package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopDetectFacePart;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00042\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u00062\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000\u001a\u0012\u0010\t\u001a\u00020\b2\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000\u001a\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0001\u001a\u0004\u0018\u00010\f\u001a\u0012\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000\u001a\u0012\u0010\u0012\u001a\u00020\u00112\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000\u001a\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0013\u001a\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "fragment", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel;", "d", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "j", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "i", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", tl.h.F, "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "f", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkAlbumListViewModel;", "c", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaSelectionPanelStateViewModel;", "g", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/m;", "e", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "a", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/u;", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class q {
    @NotNull
    public static final p a(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = new ViewModelProvider(activity).get(p.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026ateViewModel::class.java)");
        return (p) viewModel;
    }

    @NotNull
    public static final u b(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = new ViewModelProvider(activity).get(u.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026nfoViewModel::class.java)");
        return (u) viewModel;
    }

    @NotNull
    public static final WinkAlbumListViewModel c(@NotNull WinkMediaPickerMainBaseFragment<?> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(WinkAlbumListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026istViewModel::class.java)");
        return (WinkAlbumListViewModel) viewModel;
    }

    @NotNull
    public static final WinkLocalMediaViewModel d(@NotNull WinkMediaPickerMainBaseFragment<?> fragment, @NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        if (fragment.ci() && QCircleMediaPickerTopDetectFacePart.INSTANCE.a()) {
            ViewModel viewModel = new ViewModelProvider(fragment).get(WinkLocalImageForFaceDetectViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "{\n        ViewModelProvi\u2026wModel::class.java)\n    }");
            return (WinkLocalMediaViewModel) viewModel;
        }
        ViewModel viewModel2 = new ViewModelProvider(fragment, new j(mediaType)).get(WinkLocalMediaViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "{\n        ViewModelProvi\u2026wModel::class.java)\n    }");
        return (WinkLocalMediaViewModel) viewModel2;
    }

    @NotNull
    public static final m e(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(m.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026ateViewModel::class.java)");
        return (m) viewModel;
    }

    @Nullable
    public static final WinkMediaPreviewViewModel f(@Nullable WinkMediaPickerChildFragment winkMediaPickerChildFragment) {
        if (winkMediaPickerChildFragment != null) {
            return (WinkMediaPreviewViewModel) new ViewModelProvider(winkMediaPickerChildFragment).get(WinkMediaPreviewViewModel.class);
        }
        return null;
    }

    @NotNull
    public static final WinkMediaSelectionPanelStateViewModel g(@NotNull WinkMediaPickerMainBaseFragment<?> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(WinkMediaSelectionPanelStateViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026ateViewModel::class.java)");
        WinkMediaSelectionPanelStateViewModel winkMediaSelectionPanelStateViewModel = (WinkMediaSelectionPanelStateViewModel) viewModel;
        winkMediaSelectionPanelStateViewModel.T1(j(fragment).Z1());
        return winkMediaSelectionPanelStateViewModel;
    }

    @Nullable
    public static final BaseWinkMediaViewModel h(@Nullable WinkMediaPickerMainBaseFragment<?> winkMediaPickerMainBaseFragment, @NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        if (winkMediaPickerMainBaseFragment != null) {
            if (mediaType.isQZoneMedia()) {
                return i(winkMediaPickerMainBaseFragment);
            }
            return d(winkMediaPickerMainBaseFragment, mediaType);
        }
        return null;
    }

    @NotNull
    public static final v i(@NotNull WinkMediaPickerMainBaseFragment<?> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(v.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026diaViewModel::class.java)");
        return (v) viewModel;
    }

    @NotNull
    public static final WinkSelectedMediaViewModel j(@NotNull WinkMediaPickerMainBaseFragment<?> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(WinkSelectedMediaViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026diaViewModel::class.java)");
        return (WinkSelectedMediaViewModel) viewModel;
    }
}
