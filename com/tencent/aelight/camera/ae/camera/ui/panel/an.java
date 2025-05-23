package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/an;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "a", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "beautyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", "b", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", "bodyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;", "c", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;", "cosmeticsViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac;", "d", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac;", "filterViewModel", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class an implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AEBeautyProviderViewModel beautyViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AEBodyProviderViewModel bodyViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final aa cosmeticsViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ac filterViewModel;

    public an(AEBeautyProviderViewModel beautyViewModel, AEBodyProviderViewModel bodyViewModel, aa cosmeticsViewModel, ac filterViewModel) {
        Intrinsics.checkNotNullParameter(beautyViewModel, "beautyViewModel");
        Intrinsics.checkNotNullParameter(bodyViewModel, "bodyViewModel");
        Intrinsics.checkNotNullParameter(cosmeticsViewModel, "cosmeticsViewModel");
        Intrinsics.checkNotNullParameter(filterViewModel, "filterViewModel");
        this.beautyViewModel = beautyViewModel;
        this.bodyViewModel = bodyViewModel;
        this.cosmeticsViewModel = cosmeticsViewModel;
        this.filterViewModel = filterViewModel;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(AEProviderViewModel.class)) {
            return new AEProviderViewModel(this.beautyViewModel, this.bodyViewModel, this.cosmeticsViewModel, this.filterViewModel);
        }
        throw new IllegalArgumentException("ViewModel Not Found");
    }
}
