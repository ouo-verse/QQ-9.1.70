package com.tencent.biz.qqcircle.publicaccount;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/publicaccount/QCirclePublicAccountMenuCancelSetTopUseCase;", "Lcom/tencent/biz/qqcircle/publicaccount/g;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "a", "", "b", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QCirclePublicAccountMenuCancelSetTopUseCase extends g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRecentContactRepo repo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCirclePublicAccountMenuCancelSetTopUseCase(@NotNull IRecentContactRepo repo) {
        super(repo);
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.repo = repo;
    }

    @Override // com.tencent.biz.qqcircle.publicaccount.g
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a a() {
        return ((IChatsMenuDefaultUseCaseProvider) QRoute.api(IChatsMenuDefaultUseCaseProvider.class)).newCancelTopUseCase(this.repo);
    }

    @Override // com.tencent.biz.qqcircle.publicaccount.g
    public void b() {
        final BaseQQAppInterface b16;
        b16 = h.b();
        if (b16 == null) {
            return;
        }
        ((IQCirclePublicAccountMessageService) b16.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountMenuCancelSetTopUseCase$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportCancelSetTop(BaseQQAppInterface.this, qCirclePublicAccountMessageInfo);
            }
        });
    }
}
