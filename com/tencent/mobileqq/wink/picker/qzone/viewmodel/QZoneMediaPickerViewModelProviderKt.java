package com.tencent.mobileqq.wink.picker.qzone.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.qzone.viewmodel.QZoneSelectedMediaViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2 = {"getWinkQZoneSelectedViewModel", "Lcom/tencent/mobileqq/wink/picker/qzone/viewmodel/QZoneSelectedMediaViewModel;", "fragment", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "initBean", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "qq-wink-temp-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QZoneMediaPickerViewModelProviderKt {
    @NotNull
    public static final QZoneSelectedMediaViewModel getWinkQZoneSelectedViewModel(@NotNull WinkMediaPickerMainBaseFragment<?> fragment, @NotNull QZoneInitBean initBean) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        ViewModel viewModel = new ViewModelProvider(fragment, new QZoneSelectedMediaViewModel.QZoneSelectedViewModelFactory(initBean)).get(QZoneSelectedMediaViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026diaViewModel::class.java)");
        return (QZoneSelectedMediaViewModel) viewModel;
    }
}
