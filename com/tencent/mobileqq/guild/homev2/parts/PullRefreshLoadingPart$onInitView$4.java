package com.tencent.mobileqq.guild.homev2.parts;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.views.GuildLoadingFrameLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$4", f = "PullRefreshLoadingPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class PullRefreshLoadingPart$onInitView$4 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends String>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PullRefreshLoadingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshLoadingPart$onInitView$4(PullRefreshLoadingPart pullRefreshLoadingPart, Continuation<? super PullRefreshLoadingPart$onInitView$4> continuation) {
        super(2, continuation);
        this.this$0 = pullRefreshLoadingPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PullRefreshLoadingPart$onInitView$4 pullRefreshLoadingPart$onInitView$4 = new PullRefreshLoadingPart$onInitView$4(this.this$0, continuation);
        pullRefreshLoadingPart$onInitView$4.L$0 = obj;
        return pullRefreshLoadingPart$onInitView$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Integer, ? extends String> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<Integer, String>) pair, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            int intValue = ((Number) pair.component1()).intValue();
            GuildLoadingFrameLayout guildLoadingFrameLayout = null;
            if (TextUtils.isEmpty((String) pair.component2()) && this.this$0.B9().a() != GuildFacadeType.GameCenter) {
                Logger.f235387a.d().i("PullRefreshLoadingPart", 1, "setPadding topInsets:" + intValue + " + 25dp  + 48dp");
                int b16 = intValue + ((int) cw.b(25)) + ((int) cw.b(48));
                GuildLoadingFrameLayout guildLoadingFrameLayout2 = this.this$0.loadingLayout;
                if (guildLoadingFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    guildLoadingFrameLayout2 = null;
                }
                guildLoadingFrameLayout2.b(b16);
                GuildLoadingFrameLayout guildLoadingFrameLayout3 = this.this$0.loadingLayout;
                if (guildLoadingFrameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                } else {
                    guildLoadingFrameLayout = guildLoadingFrameLayout3;
                }
                guildLoadingFrameLayout.setPadding(0, b16, 0, (int) cw.b(25));
            } else {
                if (this.this$0.B9().a() == GuildFacadeType.GameCenter) {
                    i3 = 0;
                } else {
                    i3 = intValue;
                }
                Logger.f235387a.d().i("PullRefreshLoadingPart", 1, "setPadding topInsets:" + intValue + " + 25dp");
                int b17 = i3 + ((int) cw.b(25));
                GuildLoadingFrameLayout guildLoadingFrameLayout4 = this.this$0.loadingLayout;
                if (guildLoadingFrameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    guildLoadingFrameLayout4 = null;
                }
                guildLoadingFrameLayout4.b(b17);
                GuildLoadingFrameLayout guildLoadingFrameLayout5 = this.this$0.loadingLayout;
                if (guildLoadingFrameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                } else {
                    guildLoadingFrameLayout = guildLoadingFrameLayout5;
                }
                guildLoadingFrameLayout.setPadding(0, b17, 0, (int) cw.b(25));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<Integer, String> pair, @Nullable Continuation<? super Unit> continuation) {
        return ((PullRefreshLoadingPart$onInitView$4) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
