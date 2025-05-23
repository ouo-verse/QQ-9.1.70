package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel$fetchThemeIcons$1$1", f = "GuildApplicationManageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildApplicationManageViewModel$fetchThemeIcons$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ IGProGetPreviewNavigationRsp $resp;
    final /* synthetic */ int $result;
    final /* synthetic */ Function3<Boolean, String, List<? extends IGProGuildNavIconTheme>, Unit> $successFun;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildApplicationManageViewModel$fetchThemeIcons$1$1(Function3<? super Boolean, ? super String, ? super List<? extends IGProGuildNavIconTheme>, Unit> function3, int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp, Continuation<? super GuildApplicationManageViewModel$fetchThemeIcons$1$1> continuation) {
        super(2, continuation);
        this.$successFun = function3;
        this.$result = i3;
        this.$errorMsg = str;
        this.$resp = iGProGetPreviewNavigationRsp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildApplicationManageViewModel$fetchThemeIcons$1$1(this.$successFun, this.$result, this.$errorMsg, this.$resp, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<Boolean, String, List<? extends IGProGuildNavIconTheme>, Unit> function3 = this.$successFun;
            if (this.$result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean boxBoolean = Boxing.boxBoolean(z16);
            String errorMsg = this.$errorMsg;
            Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
            function3.invoke(boxBoolean, errorMsg, this.$resp.getIconThemes());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildApplicationManageViewModel$fetchThemeIcons$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
