package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/d;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lag2/b;", "a", "Lag2/b;", "settingsRepo", "<init>", "(Lag2/b;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ag2.b settingsRepo;

    public d(ag2.b settingsRepo) {
        Intrinsics.checkNotNullParameter(settingsRepo, "settingsRepo");
        this.settingsRepo = settingsRepo;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (Intrinsics.areEqual(modelClass, MessageTypeSettingsViewModel.class)) {
            Object newInstance = MessageTypeSettingsViewModel.class.getConstructor(ag2.b.class).newInstance(this.settingsRepo);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type T of com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsViewModelFactory.create");
            return (T) newInstance;
        }
        throw new IllegalArgumentException("factory could not create current modelClass: " + modelClass);
    }
}
