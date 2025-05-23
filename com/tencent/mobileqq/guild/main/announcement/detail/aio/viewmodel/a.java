package com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.guild.base.repository.h;
import com.tencent.mobileqq.guild.main.announcement.detail.Param;
import com.tencent.mobileqq.guild.main.announcement.detail.aio.InputState;
import com.tencent.mobileqq.guild.main.announcement.detail.aio.b;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.s;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/a;", "Lcom/tencent/aio/base/mvvm/b;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "intent", "handleIntent", "Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "d", "Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "param", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends com.tencent.aio.base.mvvm.b<at.a, InputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Param param;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/a$b", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lri1/a;", "error", "result", "", "b", "(Lri1/a;Ljava/lang/Boolean;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements h<Boolean> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable Boolean result) {
            Intrinsics.checkNotNullParameter(error, "error");
            Logger.f235387a.d().i("Guild.ann.AnnouncementAio-InputViewModel", 1, "onResult: " + error + ", " + result);
            if (error.d()) {
                a.this.updateUI(InputState.AnnouncementCanceled.f227086d);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            Param param = this.param;
            if (param == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                param = null;
            }
            xq1.c.h(param.getGuildId(), new b());
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Param b16;
        Intrinsics.checkNotNullParameter(context, "context");
        b16 = com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.b.b(context);
        this.param = b16;
        IRoleGroupListRepository a16 = s.a();
        Param param = this.param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        updateUI(new InputState.BottomUiState(a16.getGuildPermission(param.getGuildId()).a(40001)));
    }
}
