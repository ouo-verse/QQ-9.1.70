package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/p;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lag2/c;", "a", "Lag2/c;", "promotionRepo", "Lag2/b;", "b", "Lag2/b;", "messageSettingsRepo", "Lag2/a;", "c", "Lag2/a;", "messageRepo", "<init>", "(Lag2/c;Lag2/b;Lag2/a;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class p implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ag2.c promotionRepo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ag2.b messageSettingsRepo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ag2.a messageRepo;

    public p(ag2.c promotionRepo, ag2.b messageSettingsRepo, ag2.a messageRepo) {
        Intrinsics.checkNotNullParameter(promotionRepo, "promotionRepo");
        Intrinsics.checkNotNullParameter(messageSettingsRepo, "messageSettingsRepo");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        this.promotionRepo = promotionRepo;
        this.messageSettingsRepo = messageSettingsRepo;
        this.messageRepo = messageRepo;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (Intrinsics.areEqual(modelClass, MessageCenterViewModel.class)) {
            Object newInstance = MessageCenterViewModel.class.getConstructor(ag2.c.class, ag2.b.class, ag2.a.class).newInstance(this.promotionRepo, this.messageSettingsRepo, this.messageRepo);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type T of com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterViewModelFactory.create");
            return (T) newInstance;
        }
        throw new IllegalArgumentException("factory could not create current modelClass: " + modelClass);
    }
}
