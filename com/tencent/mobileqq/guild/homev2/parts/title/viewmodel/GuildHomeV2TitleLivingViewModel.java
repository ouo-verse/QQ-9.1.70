package com.tencent.mobileqq.guild.homev2.parts.title.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0006H\u0014R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleLivingViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$a;", "P1", "", "guildId", "", "T1", "from", "U1", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGuildId", "Le12/e;", "", "D", "Le12/e;", "_isLivingStatus", "E", "Lkotlin/Lazy;", "R1", "()Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$a;", "livingStatusListener", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "isLivingStatus", "<init>", "(Ljava/lang/String;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2TitleLivingViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Boolean> _isLivingStatus;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy livingStatusListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleLivingViewModel$1", f = "GuildHomeV2TitleLivingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleLivingViewModel$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildHomeV2TitleLivingViewModel.this.U1("init");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public GuildHomeV2TitleLivingViewModel(@NotNull String mGuildId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        this.mGuildId = mGuildId;
        this._isLivingStatus = new e12.e<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<g.a>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleLivingViewModel$livingStatusListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g.a invoke() {
                g.a P1;
                P1 = GuildHomeV2TitleLivingViewModel.this.P1();
                return P1;
            }
        });
        this.livingStatusListener = lazy;
        g.f226031d.g(R1());
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildHomeV2TitleLivingViewModel init", null, null, Boolean.TRUE, new AnonymousClass1(null), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g.a P1() {
        return new g.a() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.b
            @Override // com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.g.a
            public final void a(String str, boolean z16) {
                GuildHomeV2TitleLivingViewModel.Q1(GuildHomeV2TitleLivingViewModel.this, str, z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(GuildHomeV2TitleLivingViewModel this$0, String guildId, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (Intrinsics.areEqual(guildId, this$0.mGuildId)) {
            this$0._isLivingStatus.setValue(Boolean.valueOf(z16));
        }
    }

    private final g.a R1() {
        return (g.a) this.livingStatusListener.getValue();
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        return this._isLivingStatus;
    }

    public final void T1(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.mGuildId = guildId;
        U1("updateGuildId");
    }

    public final void U1(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeV2TitleLivingViewModel", 1, "updateLivingStatus from:" + from);
        }
        this._isLivingStatus.setValue(Boolean.valueOf(g.f226031d.k(this.mGuildId)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        g.f226031d.q(R1());
    }
}
